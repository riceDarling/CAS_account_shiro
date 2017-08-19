/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.dao.AccountInquiryDao;
import com.account.dao.AccountRequisitionActDao;
import com.account.dao.AccountRequisitionDao;
import com.account.dao.AccountRequisitionDetailDao;
import com.account.entity.AccountInquiry;
import com.account.entity.AccountRequisition;
import com.account.entity.AccountRequisitionAct;
import com.account.entity.AccountRequisitionDetail;
import com.account.entity.Admin;
import com.account.service.AccountRequisitionService;
import com.account.utils.FormatDateUtils;
import com.account.utils.RandomUtils;

/**
 * 申请单Service
 * 
 * @author admin
 * @version 2017-07-24
 */
@Service
@Transactional(readOnly = true)
public class AccountRequisitionServiceImpl implements AccountRequisitionService {

	@Autowired
	private AccountRequisitionDao accountRequisitionDao;

	@Autowired
	private AccountRequisitionDetailDao accountRequisitionDetailDao;

	@Autowired
	private AccountRequisitionActDao accountRequisitionActDao;

	@Autowired
	private AccountInquiryDao accountInquiryDao;

	public AccountRequisition get(String id) {
		AccountRequisition accountRequisition = accountRequisitionDao.get(id);
		// accountRequisition.setAccountRequisitionDetailList(accountRequisitionDetailDao.findList(new AccountRequisitionDetail(accountRequisition)));
		return accountRequisition;
	}

	@Transactional(readOnly = false)
	public void save(AccountRequisition accountRequisition) {
		Subject subject = SecurityUtils.getSubject();
		Admin loginAdmin = (Admin) subject.getSession().getAttribute("loginAdmin");
		if (accountRequisition.getId() == null) {
			accountRequisition.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			// 生成17位单据编号 04-20170203-00001
			String ordernum = "04-" + FormatDateUtils.dateToString(new Date()) + "-" + RandomUtils.random();
			accountRequisition.setOrdernum(ordernum);
			
			accountRequisition.setOffice("测试");
			accountRequisition.setCreateBy(loginAdmin.getId().toString());
			accountRequisition.setCreateDate(new Date());
			accountRequisition.setProcInsId("start");
			accountRequisitionDao.insert(accountRequisition);
		} else {
			AccountRequisitionAct now_act = new AccountRequisitionAct();
			now_act.setActindex(0);

			now_act.setCheckerName(loginAdmin.getId().toString());
			now_act.setRequisitionId(accountRequisition.getId());
			now_act = accountRequisitionActDao.getbyRequisitionIdAndChecknameAndState(now_act);
			now_act.setState(1);
			now_act.setConclusion(1);
			now_act.setRemarks("重申");
			now_act.setEndTime(new Date());
			accountRequisitionActDao.update(now_act);
			
			accountRequisition.setOffice("测试");
			accountRequisition.setCreateBy(loginAdmin.getId().toString());
			accountRequisition.setCreateDate(new Date());
			accountRequisition.setProcInsId("start");
			accountRequisitionDao.update(accountRequisition);
		}
		

		accountRequisitionDetailDao.deleteByparentId(accountRequisition.getId());
		for (AccountRequisitionDetail accountRequisitionDetail : accountRequisition.getAccountRequisitionDetailList()) {
			accountRequisitionDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountRequisitionDetail.setParent(accountRequisition);
			accountRequisitionDetailDao.insert(accountRequisitionDetail);
		}

		AccountRequisitionAct act = new AccountRequisitionAct();
		act.setActindex(0);
		act.setRequisitionId(accountRequisition.getId());

		act.setRequisitionName(loginAdmin.getId().toString());
		act.setStartTime(new Date());
		act.setStep(0);
		act.setState(1);
		act.setCheckerName(loginAdmin.getId().toString());
		accountRequisitionActDao.insert(act);

		act.setConclusion(1);
		act.setRemarks("提交申请");
		act.setEndTime(new Date());
		accountRequisitionActDao.update(act);

		AccountRequisitionAct next_act = new AccountRequisitionAct();
		next_act.setActindex(0);
		next_act.setRequisitionId(accountRequisition.getId());
		next_act.setRequisitionName(loginAdmin.getId().toString());
		next_act.setStartTime(new Date());
		next_act.setStep(1);
		next_act.setState(0);
		next_act.setCheckerName(accountRequisition.getChecker());
		accountRequisitionActDao.insert(next_act);
	}

	@Override
	public List<Map<String, Object>> getDetailMapByparentid(String parentid) {
		return accountRequisitionDetailDao.getDetailMapByparentid(parentid);
	}

	@Transactional(readOnly = false)
	public void saveAudit(AccountRequisition accountRequisition) {
		AccountRequisitionAct now_act = new AccountRequisitionAct();
		now_act.setActindex(0);
		Subject subject = SecurityUtils.getSubject();
		Admin loginAdmin = (Admin) subject.getSession().getAttribute("loginAdmin");
		now_act.setCheckerName(loginAdmin.getId().toString());
		now_act.setRequisitionId(accountRequisition.getId());
		now_act = accountRequisitionActDao.getbyRequisitionIdAndChecknameAndState(now_act);

		now_act.setState(1);
		now_act.setConclusion("yes".equals(accountRequisition.getConclusion()) || "end".equals(accountRequisition.getConclusion()) ? 1 : 0);
		now_act.setRemarks(accountRequisition.getComment());
		now_act.setEndTime(new Date());
		accountRequisition.setUpdate(new Date());
		accountRequisition.setUpdateBy(loginAdmin.getId().toString());
		accountRequisitionActDao.update(now_act);
		if ("yes".equals(accountRequisition.getConclusion())) {
			// 如果有人进行审核并且通过，修改主表状态为"examine"，表示当前这个任务无法撤回了
			accountRequisition.setProcInsId("examine");
			accountRequisitionDao.update(accountRequisition);
			// 如果同意则，进入下一个节点
			AccountRequisitionAct next_act = new AccountRequisitionAct();
			next_act.setActindex(0);
			next_act.setRequisitionId(accountRequisition.getId());
			next_act.setRequisitionName(loginAdmin.getId().toString());
			next_act.setStartTime(new Date());
			next_act.setStep(now_act.getStep() + 1);
			next_act.setState(0);
			next_act.setCheckerName(accountRequisition.getChecker());
			accountRequisitionActDao.insert(next_act);
		} else if ("end".equals(accountRequisition.getConclusion())) {
			// 结束标识
			accountRequisition.setProcInsId("end");
			accountRequisitionDao.update(accountRequisition);
			// 添加数据到询价单主表
			AccountInquiry entity = new AccountInquiry();

			// 生成17位单据编号 04-20170203-00001
			String ordernum = "13-" + FormatDateUtils.dateToString(new Date()) + "-" + RandomUtils.random();
			// 生成37位入库单号
			String inquirynum = "xj-" + FormatDateUtils.dateToString(new Date()) + "-" + RandomUtils.random();


			accountRequisition = accountRequisitionDao.get(accountRequisition.getId());
			entity.setOrdernum(ordernum);
			entity.setInquirynum(inquirynum);
			entity.setRequisition(accountRequisition.getId());
			entity.setStatus("0");
			entity.setTitle(accountRequisition.getTitle());

			// 询价人
			entity.setInquiry(accountRequisition.getChecker());
			entity.setCreateDate(new Date());
			
			entity.setValiddate(new Date());
			entity.setMaker(loginAdmin.getUsername());
			//创建人改为任务办理人（流程第一节点）
			entity.setCreateBy(accountRequisition.getChecker());
			entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountInquiryDao.insert(entity);
			
			//询价办理
			AccountRequisitionAct next_act = new AccountRequisitionAct();
			next_act.setActindex(1);
			next_act.setRequisitionId(entity.getId());
			next_act.setRequisitionName(loginAdmin.getId().toString());
			next_act.setStartTime(new Date());
			next_act.setStep(0);
			next_act.setState(0);
			next_act.setCheckerName(accountRequisition.getChecker());
			accountRequisitionActDao.insert(next_act);
		} else {
			// 返回上一个节点驳回目标人为上一节点（逐级驳回）
			AccountRequisitionAct next_act = new AccountRequisitionAct();
			next_act.setActindex(0);
			next_act.setRequisitionId(accountRequisition.getId());
			next_act.setRequisitionName(loginAdmin.getId().toString());
			next_act.setStartTime(new Date());
			next_act.setStep(now_act.getStep() - 1);
			next_act.setState(0);
			next_act.setCheckerName(now_act.getRequisitionName());
			accountRequisitionActDao.insert(next_act);
		}

	}

	@Transactional(readOnly = false)
	public void delete(String requisitionid) {
		accountRequisitionDao.delete(requisitionid);
		accountRequisitionActDao.deleteByRequisitionId(requisitionid);
	}

}
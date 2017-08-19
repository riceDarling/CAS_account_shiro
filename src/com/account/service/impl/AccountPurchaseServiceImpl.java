package com.account.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.dao.AccountInquiryDao;
import com.account.dao.AccountPurchaseDao;
import com.account.dao.AccountPurchaseDetailDao;
import com.account.dao.AccountPurchaseSupplierDao;
import com.account.dao.AccountRequisitionActDao;
import com.account.entity.AccountInquiry;
import com.account.entity.AccountPurchase;
import com.account.entity.AccountPurchaseDetail;
import com.account.entity.AccountPurchaseSupplier;
import com.account.entity.AccountRequisitionAct;
import com.account.entity.Admin;
import com.account.service.AccountPurchaseService;
import com.account.utils.FormatDateUtils;
import com.account.utils.RandomUtils;

/**
 * 订货单Service
 * 
 * @author admin
 * @version 2017-07-26
 */
@Service
@Transactional
public class AccountPurchaseServiceImpl implements AccountPurchaseService {

	@Autowired
	private AccountPurchaseDetailDao accountPurchaseDetailDao;

	@Autowired
	private AccountPurchaseSupplierDao accountPurchaseSupplierDao;

	@Autowired
	private AccountRequisitionActDao accountRequisitionActDao;

	@Autowired
	private AccountInquiryDao accountInquiryDao;
	
	@Autowired
	private AccountPurchaseDao accountPurchaseDao;

	public AccountPurchase get(String id) {
		AccountPurchase accountPurchase = accountPurchaseDao.get(id);
		// accountPurchase.setAccountPurchaseDetailList(accountPurchaseDetailDao.findList(new AccountPurchaseDetail(accountPurchase)));
		return accountPurchase;
	}

	@Transactional
	public void save(AccountPurchase accountPurchase) {
		Subject subject = SecurityUtils.getSubject();
		Admin loginAdmin = (Admin) subject.getSession().getAttribute("loginAdmin");
		
	
		if (accountPurchase.getId()==null) {
			// 生成17位单据编号 04-20170203-00001
			//String ordernum = "06-" + FormatDateUtils.dateToString(new Date()) + "-" + RandomUtils.random();
			//accountPurchase.setOrdernum(ordernum);
			
			//accountPurchase.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			//accountPurchase.setMaker(loginAdmin.getId().toString());
			//accountPurchase.setProcInsId("start");
			//accountPurchase.setCreateBy(loginAdmin.getId().toString());
			//accountPurchase.setCreateDate(new Date());
			//accountPurchaseDao.insert(accountPurchase);
		} else {
			AccountRequisitionAct now_act = new AccountRequisitionAct();		
			now_act.setCheckerName(loginAdmin.getId().toString());
			now_act.setRequisitionId(accountPurchase.getId());
			now_act = accountRequisitionActDao.getbyRequisitionIdAndChecknameAndState(now_act);
			now_act.setState(1);
			now_act.setConclusion(1);
			now_act.setRemarks("提交申请");
			now_act.setEndTime(new Date());
			now_act.setActindex(2);
			accountRequisitionActDao.update(now_act);
			
			accountPurchase.setProcInsId("start");
			accountPurchase.setUpdate(new Date());
			accountPurchase.setUpdateBy(loginAdmin.getId().toString());
			accountPurchaseDao.update(accountPurchase);
		}

		List<AccountPurchaseDetail> detailList=accountPurchaseDetailDao.findList(new AccountPurchaseDetail(accountPurchase));
		if(detailList.size()>0){
			accountPurchaseDetailDao.deleteByparentId(accountPurchase.getId());
		}
		
		for (AccountPurchaseDetail accountPurchaseDetail : accountPurchase.getAccountPurchaseDetailList()) {
			accountPurchaseDetail.setParent(accountPurchase);
			accountPurchaseDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountPurchaseDetail.setCreateBy(loginAdmin.getId().toString());
			accountPurchaseDetail.setCreateDate(new Date());
			accountPurchaseDetailDao.insert(accountPurchaseDetail);
		}
		List<AccountPurchaseSupplier> supplierList=accountPurchaseSupplierDao.getbyParentId(accountPurchase.getId());
		if(supplierList.size()>0){
			accountPurchaseSupplierDao.deleteByparentId(accountPurchase.getId());
		}
		
		for (AccountPurchaseSupplier accountPurchaseSupplier : accountPurchase.getSupplierList()) {
			accountPurchaseSupplier.setParent(accountPurchase);
			accountPurchaseSupplier.setCreateBy(loginAdmin.getId().toString());
			accountPurchaseSupplier.setCreateDate(new Date());
			accountPurchaseSupplierDao.insert(accountPurchaseSupplier);
		}

		AccountRequisitionAct act = new AccountRequisitionAct();
		act.setActindex(2);
		act.setRequisitionId(accountPurchase.getId());
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
		next_act.setActindex(2);
		next_act.setRequisitionId(accountPurchase.getId());
		next_act.setRequisitionName(loginAdmin.getId().toString());
		next_act.setStartTime(new Date());
		next_act.setStep(1);
		next_act.setState(0);
		next_act.setCheckerName(accountPurchase.getChecker());
		accountRequisitionActDao.insert(next_act);
	}

	@Override
	public List<AccountPurchaseSupplier> getbyParentId(String parentId) {
		return accountPurchaseSupplierDao.getbyParentId(parentId);
	}

	@Override
	public void setAccountPurchaseDetailListService(AccountPurchase accountPurchase) {
		accountPurchase.setAccountPurchaseDetailList(accountPurchaseDetailDao.findList(new AccountPurchaseDetail(accountPurchase)));	
	}

	@Transactional
	public void saveAudit(AccountPurchase accountPurchase) {
		Subject subject = SecurityUtils.getSubject();
		Admin loginAdmin = (Admin) subject.getSession().getAttribute("loginAdmin");
		AccountRequisitionAct now_act = new AccountRequisitionAct();
		now_act.setCheckerName(loginAdmin.getId().toString());
		now_act.setRequisitionId(accountPurchase.getId());
		now_act = accountRequisitionActDao.getbyRequisitionIdAndChecknameAndState(now_act);

		now_act.setState(1);
		now_act.setConclusion("yes".equals(accountPurchase.getConclusion()) || "end".equals(accountPurchase.getConclusion()) ? 1: 0);
		now_act.setRemarks(accountPurchase.getComment());
		now_act.setEndTime(new Date());
		now_act.setActindex(2);
		accountRequisitionActDao.update(now_act);
		if ("yes".equals(accountPurchase.getConclusion())) {
			//如果有人进行审核并且通过，修改主表状态为"examine"，表示当前这个任务无法撤回了
			accountPurchase.setProcInsId("examine");
			accountPurchaseDao.update(accountPurchase);
			// 如果同意则，进入下一个节点
			AccountRequisitionAct next_act = new AccountRequisitionAct();
			next_act.setActindex(2);
			next_act.setRequisitionId(accountPurchase.getId());
			next_act.setRequisitionName(loginAdmin.getId().toString());
			next_act.setStartTime(new Date());
			next_act.setStep(now_act.getStep() + 1);
			next_act.setState(0);
			next_act.setCheckerName(accountPurchase.getChecker());
			accountRequisitionActDao.insert(next_act);
		} else if ("end".equals(accountPurchase.getConclusion())) {
			// 结束标识
			accountPurchase.setProcInsId("end");
			accountPurchaseDao.update(accountPurchase);
			
		} else {
			// 返回上一个节点驳回目标人为上一节点人
			AccountRequisitionAct next_act = new AccountRequisitionAct();
			next_act.setActindex(2);
			next_act.setRequisitionId(accountPurchase.getId());
			next_act.setRequisitionName(loginAdmin.getId().toString());
			next_act.setStartTime(new Date());
			next_act.setStep(now_act.getStep() - 1);
			next_act.setState(0);
			next_act.setCheckerName(now_act.getRequisitionName());
			accountRequisitionActDao.insert(next_act);
			
			String inquirynum=accountPurchase.getInquirynum();
			AccountInquiry accountInquiry=new AccountInquiry();
			accountInquiry.setOrdernum(inquirynum);
			accountInquiry.setStatus("1");
			accountInquiryDao.setAccountInquiryStatus(accountInquiry);
		}
	}
	@Override
	public List<AccountPurchase> getAccountPurchaseTitle() {
		return accountPurchaseDao.getAccountPurchaseTitle();
	}
	public List<AccountPurchaseDetail> getAccountSupplierByPurchasenum(AccountPurchaseDetail accountPurchaseDetail){
		return accountPurchaseDetailDao.getAccountSupplierByPurchasenum(accountPurchaseDetail);
	}
	public Map<String,AccountPurchaseDetail> getAccountSupplierByPurchasenumtitle(String purchasenumtitle){
		List<AccountPurchaseDetail> li=accountPurchaseDetailDao.getAccountSupplierByPurchasenumtitle(purchasenumtitle);
		Map<String,AccountPurchaseDetail> map=new HashMap<String,AccountPurchaseDetail>();
		for (AccountPurchaseDetail accountPurchaseDetail : li) {
			accountPurchaseDetail.getSuppliercode();
			if(map.get(accountPurchaseDetail.getSuppliercode())==null){
				map.put(accountPurchaseDetail.getSuppliercode(), accountPurchaseDetail);
			}
			else{
		     Double  money=Double.parseDouble(map.get(accountPurchaseDetail.getSuppliercode()).getTotlemoney().trim()) ;
		     Double money2=Double.parseDouble(accountPurchaseDetail.getTotlemoney().trim()) ;
		     java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
		     map.get(accountPurchaseDetail.getSuppliercode()).setTotlemoney(String.valueOf(df.format(money+money2)));
			}
		}
		return map;
	}

}
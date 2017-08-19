package com.account.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountInquiry;
import com.account.entity.AccountInquiryDetail;
import com.account.entity.Admin;
import com.account.service.AccountInquiryDetailService;
import com.account.service.AccountInquiryService;
import com.account.service.AccountRequisitionActService;
import com.account.service.AccountRequisitionService;
import com.account.utils.PageUtil;
import com.account.utils.ResponseModel;


/**
 * 询价单Controller
 * 
 */
@Controller
@RequestMapping("/accountInquiry")
public class AccountInquiryController {

	@Autowired
	private AccountInquiryService accountInquiryService;
	
	@Autowired
	private AccountRequisitionService accountRequisitionService;
	
	@Autowired
	private AccountInquiryDetailService accountInquiryDetailService;
	
	@Autowired
	private AccountRequisitionActService accountRequisitionActService;
	
	
	/**
	 * 询价单列表
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="list")
	public ResponseModel<PageUtil<AccountInquiry>> form(AccountInquiry entity) {
		ResponseModel<PageUtil<AccountInquiry>> rm = new ResponseModel<PageUtil<AccountInquiry>>();
		try { 
			entity.setPage(new PageUtil<AccountInquiry>());
			accountInquiryService.findPage(entity);
			rm.isSuccessMsg(entity.getPage(),"获取询价信息成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取询价信息失败");
		}
		return rm;
	}
	
	/**
	 * 获取询价单
	 * @param accountInquiryid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="get")
	public ResponseModel<AccountInquiry> get(String accountInquiryid) {
		ResponseModel<AccountInquiry> rm = new ResponseModel<AccountInquiry>();
		try { 
			AccountInquiry entity=accountInquiryService.getById(accountInquiryid);
			rm.isSuccessMsg(entity,"获取询价单成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取询价单失败");
		}
		return rm;
	}
	/**
	 * 申请单列表
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="requisition")
	public ResponseModel<List<Map<String,Object>>> requisition(String accountInquiryid) {
		ResponseModel<List<Map<String,Object>>> rm = new ResponseModel<List<Map<String,Object>>>();
		try { 
			AccountInquiry entity=accountInquiryService.getById(accountInquiryid);
			List<Map<String,Object>> list=accountRequisitionService.getDetailMapByparentid(entity.getRequisition());
			rm.isSuccessMsg(list,"获取申请单列表成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取申请单列表失败");
		}
		return rm;
	}
	
	/**
	 * 询价记录
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="detail")
	public ResponseModel<List<AccountInquiryDetail>> detail(String accountInquiryid) {
		ResponseModel<List<AccountInquiryDetail>> rm = new ResponseModel<List<AccountInquiryDetail>>();
		try { 
			AccountInquiry entity=accountInquiryService.getById(accountInquiryid);
			List<AccountInquiryDetail> list = accountInquiryDetailService.selectInquiryDetailByOrdernum(entity.getOrdernum());
			rm.isSuccessMsg(list,"获取询价记录成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取询价记录失败");
		}
		return rm;
	}
	
	/**
	 * 保存询价记录
	 * @param accountInquiryid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="saveDetail")
	public ResponseModel<String> saveDetail(AccountInquiryDetail entity) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			Subject subject = SecurityUtils.getSubject();
			Admin loginAdmin = (Admin) subject.getSession().getAttribute("loginAdmin");
			AccountInquiry accountInquiry=accountInquiryService.getById(entity.getOrdernum());
			if(Integer.parseInt(accountInquiry.getStatus())!=0){
				rm.isSuccessMsg("","询价单已提交，无法继续添加询价记录");
			}else{
				entity.setOrdernum(accountInquiry.getOrdernum());
				entity.setMaker(loginAdmin.getUsername());
				entity.setCreateDate(new Date());
				entity.setCreateBy(loginAdmin.getId().toString());
				accountInquiryDetailService.save(entity);
				rm.isSuccessMsg("","保存询价记录成功");
			}
			
		} catch (Exception e) {
			rm.isErrorMsg("保存询价记录失败");
		}
		return rm;
	}

	/**
	 * 询价记录
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="commit1")
	public ResponseModel<String> commit1(String accountInquiryid) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			AccountInquiry entity=accountInquiryService.getById(accountInquiryid);
			List<AccountInquiryDetail> list = accountInquiryDetailService.selectInquiryDetailByOrdernum(entity.getOrdernum());
			if(list.size()>0) {
				accountInquiryService.commit1(entity.getOrdernum());
				rm.isSuccessMsg("","提交询价单成功");
			}else {
				rm.isSuccessMsg("","询价单没有询价记录，提交失败");
			}	
			
		} catch (Exception e) {
			rm.isErrorMsg("提交询价单失败");
		}
		return rm;
	}
	
	/**
	 * 提交询价记录进行审核
	 * @param inquirydetailId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="detailupdata")
	public ResponseModel<String> detailupdata(@RequestParam(required = false, value = "inquirydetailId[]") String[] inquirydetailId,String checker) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			if(inquirydetailId.length<0){
				rm.isErrorMsg("没有选择询价记录,提交失败");
			}else{
				accountInquiryService.detailupdata(inquirydetailId,checker);
				rm.isSuccessMsg(null,"提交询价单成功");
			}	
		} catch (Exception e) {
			rm.isErrorMsg("提交询价单失败");
		}
		return rm;
	}
	
	/**
	 * 已提交的询价记录
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="detailEnd")
	public ResponseModel<List<AccountInquiryDetail>> detailEnd(String accountInquiryid) {
		ResponseModel<List<AccountInquiryDetail>> rm = new ResponseModel<List<AccountInquiryDetail>>();
		try { 
			AccountInquiry entity=accountInquiryService.getById(accountInquiryid);
			List<AccountInquiryDetail> list = accountInquiryDetailService.selectInquiryDetailEndByOrdernum(entity.getOrdernum());
			rm.isSuccessMsg(list,"获取询价记录成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取询价记录失败");
		}
		return rm;
	}
	
	/**
	 * 审批提交
	 * @param inquirydetailId
	 * @param checker
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="saveAudit")
	public ResponseModel<String> saveAudit(AccountInquiry entity) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			AccountInquiry temp=accountInquiryService.getById(entity.getId());
			if("2".equals(temp.getStatus())){
				rm.isErrorMsg("当前任务已完成,不可重复提交");
			}else{
				accountInquiryService.saveAudit(entity);
				rm.isSuccessMsg(null,"提交询价单成功");
			}
			
		} catch (Exception e) {
			rm.isErrorMsg("提交询价单失败");
		}
		return rm;
	}
	/**
	 * 获取流程历史
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="getAct")
	public ResponseModel<List<Map<String, Object>>> getAct(String accountInquiryid) {
		ResponseModel<List<Map<String, Object>>> rm = new ResponseModel<List<Map<String, Object>>>();
		try { 
			rm.isSuccessMsg(accountRequisitionActService.getbyRequisitionId(accountInquiryid),"获取询价单流程历史成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取询价单流程历史失败");
		}
		return rm;
	}
}

package com.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountInquiry;
import com.account.entity.AccountInquiryDetail;
import com.account.entity.AccountPayment;
import com.account.entity.AccountPurchase;
import com.account.entity.AccountPurchaseDetail;
import com.account.entity.AccountPurchaseSupplier;
import com.account.service.AccountInquiryDetailService;
import com.account.service.AccountPurchaseService;
import com.account.service.AccountRequisitionActService;
import com.account.utils.ResponseModel;
import com.alibaba.fastjson.JSON;

/**
 * 订货单Controller
 * 
 * @author admin
 * @version 2017-07-26
 */
@Controller
@RequestMapping("/accountPurchase")
public class AccountPurchaseController {

	@Autowired
	private AccountPurchaseService accountPurchaseService;
	
	@Autowired
	private AccountInquiryDetailService accountInquiryDetailService;
	
	@Autowired
	private AccountRequisitionActService accountRequisitionActService;
	
	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(@RequestBody String data){
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			 AccountPurchase  accountPurchase= JSON.parseObject(data,  AccountPurchase.class);
			if("no".equals(accountPurchase.getConclusion())) {
				//删除申请单(修改页面单独处理，所有此处没有删除逻辑)
				rm.isSuccessMsg("","删除成功");
			}else {
				//保存申请单
				accountPurchaseService.save(accountPurchase);
				rm.isSuccessMsg("","提交成功");
			}
		} catch (Exception e) {
			rm.isErrorMsg("失败");
	
		}
		
		return rm;
	}
	
	/**
	 * (申请单主表,询价报表)
	 * @param requisitionid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="detailEnd")
	public ResponseModel<Map<String,Object>> detailEnd(String accountPurchaseid) {
		ResponseModel<Map<String,Object>> rm = new ResponseModel<Map<String,Object>>();
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			AccountPurchase entity=accountPurchaseService.get(accountPurchaseid);
			List<AccountInquiryDetail> list = accountInquiryDetailService.selectInquiryDetailEndByOrdernum(entity.getInquirynum());
			map.put("detail", list);
			map.put("purchase", entity);
			rm.isSuccessMsg(map,"获取申请单成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取申请单失败");
		}
		return rm;
	}
	@ResponseBody
	@RequestMapping(value = "formView")
	public ResponseModel<Map<String,Object>> formView(String accountPurchaseid) {
		ResponseModel<Map<String,Object>> rm = new ResponseModel<Map<String,Object>>();
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			AccountPurchase accountPurchase=accountPurchaseService.get(accountPurchaseid);
			//字表数据
			accountPurchaseService.setAccountPurchaseDetailListService(accountPurchase);
			//供应商数据
			List<AccountPurchaseSupplier> accountPurchaseSuppliers= accountPurchaseService.getbyParentId(accountPurchaseid);
			accountPurchase.setSupplierList(accountPurchaseSuppliers);
			List<Map<String,Object>> actlist=accountRequisitionActService.getbyRequisitionId(accountPurchaseid);
			map.put("purchase", accountPurchase);
			map.put("actlist", actlist);
			rm.isSuccessMsg(map,"获取申请单成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取申请单失败");
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
	public ResponseModel<String> saveAudit(AccountPurchase entity) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try { 
			accountPurchaseService.saveAudit(entity);
			rm.isSuccessMsg(null,"提交订货单成功");
		} catch (Exception e) {
			rm.isErrorMsg("提交订货单失败");
		}
		return rm;
	}

	/**
	 * 获取采购标题
	 */
	@ResponseBody
	@RequestMapping(value = "getAccountPurchaseTitle")
	public ResponseModel<List<AccountPurchase>> getAccountPurchaseTitle() {
		ResponseModel<List<AccountPurchase>> rm = new ResponseModel<List<AccountPurchase>>();
		try {
			List<AccountPurchase> accountPurchase = accountPurchaseService.getAccountPurchaseTitle();
			rm.isSuccessMsg(accountPurchase, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	/**
	 * 根据物资编码获取详细信息
	 */
	@ResponseBody
	@RequestMapping(value = "getAccountSupplierByPurchasenum")
	public ResponseModel<List<AccountPurchaseDetail>> getAccountSupplierByPurchasenum(AccountPurchaseDetail accountPurchaseDetail) {
		ResponseModel<List<AccountPurchaseDetail>> rm = new ResponseModel<List<AccountPurchaseDetail>>();
		try {
			List<AccountPurchaseDetail> adDetails = accountPurchaseService.getAccountSupplierByPurchasenum(accountPurchaseDetail);
			rm.isSuccessMsg(adDetails, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	/**
	 * 根据采购标题获取供应商列表信息
	 */
	@ResponseBody
	@RequestMapping(value = "getAccountSupplierByPurchasenumtitle")
	public ResponseModel<Map<String, AccountPurchaseDetail>> getAccountSupplierByPurchasenumtitle(HttpServletRequest req) {
		ResponseModel<Map<String, AccountPurchaseDetail>> rm = new ResponseModel<Map<String, AccountPurchaseDetail>>();
		try {
			String purchasenumtitle = req.getParameter("purchasenumtitle");
			Map<String, AccountPurchaseDetail> accountPurchaseDetail = accountPurchaseService.getAccountSupplierByPurchasenumtitle(purchasenumtitle);
			rm.isSuccessMsg(accountPurchaseDetail, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
}
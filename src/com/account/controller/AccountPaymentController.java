package com.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountPayment;
import com.account.service.AccountContractService;
import com.account.service.AccountPaymentService;
import com.account.utils.ResponseModel;

/**
 * 付款单Controller
 */
@Controller
@RequestMapping("/accountPaymentController")
public class AccountPaymentController {
	@Autowired
	private AccountPaymentService accountPaymentService;
	@Autowired
	private AccountContractService accountContractService;

	@ResponseBody
	@RequestMapping(value = "findList")
	public ResponseModel<List<AccountPayment>> findList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("supplier", req.getParameter("supplier"));
		map.put("beginDate", req.getParameter("beginDate"));
		map.put("endDate", req.getParameter("endDate"));
		ResponseModel<List<AccountPayment>> rm = new ResponseModel<List<AccountPayment>>();
		try {
			List<AccountPayment> li = accountPaymentService.findList(map);
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(AccountPayment accountPayment) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			accountPaymentService.save(accountPayment);
			accountContractService.updateContractStatus(accountPayment.getContractnum());
			rm.isSuccessMsg("", "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "getById")
	public ResponseModel<AccountPayment> getById(HttpServletRequest req) {
		ResponseModel<AccountPayment> rm = new ResponseModel<AccountPayment>();
		try {
			String id = req.getParameter("id");
			AccountPayment accountPayment = accountPaymentService.getById(id);
			rm.isSuccessMsg(accountPayment, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "delete")
	public ResponseModel<String> delete(HttpServletRequest req) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			String id = req.getParameter("id");
			String contractId = req.getParameter("contractId");
			accountPaymentService.delete(id);
			accountContractService.updateContractStatustwo(contractId);
			rm.isSuccessMsg("", "删除成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

}

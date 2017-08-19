package com.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountArrival;
import com.account.service.AccountArrivalService;
import com.account.service.AccountContractService;
import com.account.utils.ResponseModel;

/**
 * 到货单Controller
 */
@Controller
@RequestMapping("/accountArrivalController")
public class AccountArrivalController {
	@Autowired
	private AccountArrivalService accountArrivalService;

	@Autowired
	private AccountContractService accountContractService;

	@ResponseBody
	@RequestMapping(value = "findList")
	public ResponseModel<List<AccountArrival>> findList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contractTitle", req.getParameter("contracttitle"));
		map.put("supplier", req.getParameter("supplier"));
		map.put("status", req.getParameter("status"));
		ResponseModel<List<AccountArrival>> rm = new ResponseModel<List<AccountArrival>>();
		try {
			List<AccountArrival> li = accountArrivalService.findList(map);
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
	@ResponseBody
	@RequestMapping(value = "findAllList")
	public ResponseModel<List<AccountArrival>> findAllList(HttpServletRequest req) {
		ResponseModel<List<AccountArrival>> rm = new ResponseModel<List<AccountArrival>>();
		try {
			List<AccountArrival> li = accountArrivalService.findAllList();
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
	@ResponseBody
	@RequestMapping(value = "lastForm")
	public ResponseModel<List<AccountArrival>> lastForm(HttpServletRequest req) {

		ResponseModel<List<AccountArrival>> rm = new ResponseModel<List<AccountArrival>>();
		try {
			String id = req.getParameter("id");
			List<AccountArrival> list = accountArrivalService.getLastForm(id);
			rm.isSuccessMsg(list, "提交成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "editForm")
	public String editForm(AccountArrival accountArrival, Model model) {
		model.addAttribute("accountArrival", accountArrival);
		return "modules/erp/accountArrivalEdit";
	}

	@ResponseBody
	@RequestMapping(value = "addform")
	public ResponseModel<List<AccountArrival>> addform(HttpServletRequest req) {
		ResponseModel<List<AccountArrival>> rm = new ResponseModel<List<AccountArrival>>();
		try {
			String contractNum = req.getParameter("contractNum");
			List<AccountArrival> arrivalDetail = accountArrivalService.getArrivalDetail(contractNum);
			rm.isSuccessMsg(arrivalDetail, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(AccountArrival accountArrival) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			accountArrivalService.save(accountArrival);
			rm.isSuccessMsg("", "提交成功");
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
			accountArrivalService.delete(id);
			rm.isSuccessMsg("", "删除成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
}

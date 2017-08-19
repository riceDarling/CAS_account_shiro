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

import com.account.entity.AccountArrival;
import com.account.entity.AccountInspection;
import com.account.entity.AccountInspectionInfo;
import com.account.service.AccountInspectionService;
import com.account.utils.ResponseModel;

/**
 * 送检单Controller
 */
@Controller
@RequestMapping("/accountInspectionController")
public class AccountInspectionController {
	@Autowired
	private AccountInspectionService accountInspectionService;

	@ResponseBody
	@RequestMapping(value = "findList")
	public ResponseModel<List<AccountInspection>> findList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", req.getParameter("title"));
		map.put("contractTitle", req.getParameter("contractTitle"));
		map.put("beginInspectiondate", req.getParameter("beginInspectiondate"));
		map.put("endInspectiondate", req.getParameter("endInspectiondate"));
		ResponseModel<List<AccountInspection>> rm = new ResponseModel<List<AccountInspection>>();
		try {
			List<AccountInspection> li = accountInspectionService.findList(map);
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(@RequestBody AccountInspection accountInspection) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			accountInspectionService.save(accountInspection);
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
			accountInspectionService.delete(id);
			rm.isSuccessMsg("", "删除成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "nextForm")
	public ResponseModel<List<AccountInspection>> nextForm(HttpServletRequest req) {

		ResponseModel<List<AccountInspection>> rm = new ResponseModel<List<AccountInspection>>();
		try {
			String id = req.getParameter("id");
			List<AccountInspection> list = accountInspectionService.getNextInspection(id);
			rm.isSuccessMsg(list, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	/**
	 * 待送检列表
	 */
	@ResponseBody
	@RequestMapping(value = "formSec")
	public ResponseModel<List<AccountArrival>> formSec() {
		ResponseModel<List<AccountArrival>> rm = new ResponseModel<List<AccountArrival>>();
		try {
			List<AccountArrival> li = accountInspectionService.getArrivalList();
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;

	}

	@RequestMapping(value = "getAccountInspectionDetailByArrivalnum")
	public ResponseModel<List<AccountInspectionInfo>> getAccountInspectionDetailByArrivalnum(HttpServletRequest req) {
		ResponseModel<List<AccountInspectionInfo>> rm = new ResponseModel<List<AccountInspectionInfo>>();
		try {
			String arrivalnum = req.getParameter("arrivalnum");
			List<AccountInspectionInfo> list = accountInspectionService.getAccount_inspectionInfo(arrivalnum);
			rm.isSuccessMsg(list, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
}
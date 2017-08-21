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

import com.account.entity.AccountInspection;
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
		map.put("supplier", req.getParameter("supplier"));
		map.put("status", req.getParameter("status"));
		map.put("beginDate", req.getParameter("beginDate"));
		map.put("endDate", req.getParameter("endDate"));
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
}
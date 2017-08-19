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

import com.account.entity.AccountInput;
import com.account.entity.AccountInputInfo;
import com.account.service.AccountInputService;
import com.account.utils.ResponseModel;

/**
 * 入库单Controller
 */
@Controller
@RequestMapping("/accountInputController")
public class AccountInputController {
	@Autowired
	private AccountInputService accountInputService;

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(@RequestBody AccountInput accountInput) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			accountInputService.save(accountInput);
			rm.isSuccessMsg("", "提交成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "getAccountInputListInfoBy")
	public ResponseModel<List<AccountInputInfo>> getAccountInputListInfoBy(HttpServletRequest req) {
		ResponseModel<List<AccountInputInfo>> rm = new ResponseModel<List<AccountInputInfo>>();
		try {
			String id = req.getParameter("id");
			List<AccountInputInfo> li = accountInputService.getAccountInputListInfoBy(id);
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "findList")
	public ResponseModel<List<AccountInput>> findList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contracttitle", req.getParameter("contracttitle"));
		map.put("beginDate", req.getParameter("beginDate"));
		map.put("endDate", req.getParameter("endDate"));
		ResponseModel<List<AccountInput>> rm = new ResponseModel<List<AccountInput>>();
		try {
			List<AccountInput> li = accountInputService.findList(map);
			rm.isSuccessMsg(li, "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "form")
	public ResponseModel<List<AccountInputInfo>> form() {
		ResponseModel<List<AccountInputInfo>> rm = new ResponseModel<List<AccountInputInfo>>();
		try {
			List<AccountInputInfo> accountInputInfo = accountInputService.getAccountInputInfo();
			rm.isSuccessMsg(accountInputInfo, "成功");
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
			accountInputService.delete(id);
			rm.isSuccessMsg("", "删除成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
}

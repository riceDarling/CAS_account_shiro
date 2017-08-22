package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountReject;
import com.account.service.AccountRejectService;
import com.account.utils.ResponseModel;
import com.alibaba.fastjson.JSON;
/**
 * 退货单
 *
 */
@Controller
@RequestMapping("/accountReject")
public class AccountRejectController {

	@Autowired
	private AccountRejectService accountRejectService;

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> save(@RequestBody String data) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			AccountReject accountReject = JSON.parseObject(data, AccountReject.class);
			// 保存退货单
			accountRejectService.save(accountReject);
			rm.isSuccessMsg("", "提交成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");

		}

		return rm;
	}
	
	@ResponseBody
	@RequestMapping(value = "get")
	public ResponseModel<AccountReject> get(String accountRejectId) {
		ResponseModel<AccountReject> rm = new ResponseModel<AccountReject>();
		try {
			AccountReject entity=accountRejectService.get(accountRejectId);
			rm.isSuccessMsg(entity, "获取退货单成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取退货单失败");

		}

		return rm;
	}
	
	@ResponseBody
	@RequestMapping(value = "list")
	public ResponseModel<List<AccountReject>> list(AccountReject entity) {
		ResponseModel<List<AccountReject>> rm = new ResponseModel<List<AccountReject>>();
		try {
			List<AccountReject> li=accountRejectService.list(entity);
			rm.isSuccessMsg(li, "获取退货单列表成功");
		} catch (Exception e) {
			rm.isErrorMsg("获取退货单列表失败");

		}

		return rm;
	}
}

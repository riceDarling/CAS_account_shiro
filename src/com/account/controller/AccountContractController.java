package com.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountContract;
import com.account.service.AccountContractService;
import com.account.utils.ResponseModel;

/**
 * 合同Controller
 */
@Controller
@RequestMapping("/accountContractController")
public class AccountContractController {

	@Autowired
	private AccountContractService accountContractService;

	@ResponseBody
	@RequestMapping(value = "save")
	public ResponseModel<String> test(AccountContract accountContract) {
		ResponseModel<String> rm = new ResponseModel<String>();
		try {
			accountContractService.save(accountContract);
			rm.isSuccessMsg("", "成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "findList")
	public ResponseModel<List<AccountContract>> findList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchasenumtitle", req.getParameter("purchasenumtitle"));
		map.put("contracttitle", req.getParameter("contracttitle"));
		map.put("status", req.getParameter("status"));
		map.put("beginDate", req.getParameter("beginDate"));
		map.put("endDate", req.getParameter("endDate"));
		ResponseModel<List<AccountContract>> rm = new ResponseModel<List<AccountContract>>();
		try {
			List<AccountContract> li = accountContractService.findList(map);
			rm.isSuccessMsg(li, "成功");
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
			accountContractService.delete(id);
			rm.isSuccessMsg("", "删除成功");
		} catch (Exception e) {
			rm.isErrorMsg("失败");
		}
		return rm;
	}
	/*
	 * @RequestMapping(value = "form") public String form(AccountContract accountContract, Model model) { model.addAttribute("accountContract", accountContract); return "modules/erp/accountContractForm"; }
	 * 
	 * @RequestMapping(value = "form2") public String form2(AccountContract accountContract, Model model) { model.addAttribute("accountContract", accountContract); return "modules/erp/accountContractForm2"; }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequiresPermissions("erp:accountContract:view")
	 * 
	 * @RequestMapping(value = "getCompanyById/{id}") public String getCompanyById(@PathVariable("id") String id) { return accountContractService.get(id).getCompany(); }
	 * 
	 * @ResponseBody
	 * 
	 * @RequiresPermissions("erp:accountContract:view")
	 * 
	 * @RequestMapping(value = "getMoneyById/{id}") public Double getMoneyById(@PathVariable("id") String id) { return accountContractService.get(id).getMoney(); }
	 */

}
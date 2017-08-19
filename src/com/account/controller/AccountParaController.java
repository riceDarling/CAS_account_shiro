package com.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.AccountPara;
import com.account.service.AccountParaService;
import com.account.utils.ResponseModel;

/**
 * 单位类型Controller
 */
@Controller
@RequestMapping("/accountPara")
public class AccountParaController  {
	
	@Autowired
	private AccountParaService apService;
	
	/**
	 * 查询单位类型信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="findList")
	public ResponseModel<List<AccountPara>> findList(HttpServletRequest req) {
		ResponseModel<List<AccountPara>> rm = new ResponseModel<List<AccountPara>>();
		try {
			List<AccountPara> li=apService.findList();
			rm.setSuccessMessage("操作成功", li);
		} catch (Exception e) {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 新增单位类型信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="insert")
	public ResponseModel<String> insert(AccountPara AccountPara) {
		ResponseModel<String> rm = new ResponseModel<String>();
		
		if (apService.insertSelective(AccountPara) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 根据主键删除单位类型信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="delete")
	public ResponseModel<String> delete(String id) {
		ResponseModel<String> rm = new ResponseModel<String>();

		if (apService.deleteByPrimaryKey(Integer.parseInt(id)) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 根据主键查询单位类型信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="selectById")
	public ResponseModel<AccountPara> selectById(String id) {
		ResponseModel<AccountPara> rm = new ResponseModel<AccountPara>();

		AccountPara mt = apService.selectByPrimaryKey(Integer.parseInt(id));
		if (mt != null) {
			rm.setSuccessMessage("操作成功", mt);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
}
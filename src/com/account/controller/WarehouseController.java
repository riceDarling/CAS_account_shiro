package com.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.Warehouse;
import com.account.service.WarehouseService;
import com.account.utils.PageBean;
import com.account.utils.ResponseModel;
import com.account.utils.pagebean.WarehousePage;

/**
 * 仓库Controller
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController  {
	
	@Autowired
	private WarehouseService wService;
	
	/**
	 * 分页查询仓库信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="findList")
	public ResponseModel<WarehousePage> findList(WarehousePage wPage, HttpServletRequest req) {
		ResponseModel<WarehousePage> rm = new ResponseModel<WarehousePage>();
		try {
			List<Warehouse> list=wService.findList(wPage);
			wPage.setCurrentPage(PageBean.getCurrentPage(req));
			wPage.setUrl(PageBean.getUrl(req));
			wPage.setPageTotal(PageBean.getPageCount(req));
			wPage.setTotalCount(wService.findListCount(wPage));
			wPage.setList(list);
			rm.setSuccessMessage("操作成功", wPage);
		} catch (Exception e) {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 新增仓库信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="insert")
	public ResponseModel<String> insert(Warehouse Warehouse) {
		ResponseModel<String> rm = new ResponseModel<String>();
		
		if (wService.insertSelective(Warehouse) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 根据主键删除仓库信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="delete")
	public ResponseModel<String> delete(String id) {
		ResponseModel<String> rm = new ResponseModel<String>();

		if (wService.deleteByPrimaryKey(id) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 根据主键查询仓库信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="selectById")
	public ResponseModel<Warehouse> selectById(String id) {
		ResponseModel<Warehouse> rm = new ResponseModel<Warehouse>();

		Warehouse mt = wService.selectByPrimaryKey(id);
		if (mt != null) {
			rm.setSuccessMessage("操作成功", mt);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
}
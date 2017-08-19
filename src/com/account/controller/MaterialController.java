package com.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.entity.Material;
import com.account.service.MaterialService;
import com.account.utils.PageBean;
import com.account.utils.ResponseModel;
import com.account.utils.pagebean.MaterialPage;

/**
 * 物资Controller
 */
@Controller
@RequestMapping("/material")
public class MaterialController  {
	
	@Autowired
	private MaterialService mService;
	
	/**
	 * 分页查询物资信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="findList")
	public ResponseModel<MaterialPage> findList(MaterialPage mPage, HttpServletRequest req) {
		ResponseModel<MaterialPage> rm = new ResponseModel<MaterialPage>();
		try {
			List<Material> list = mService.findList(mPage);
			mPage.setCurrentPage(PageBean.getCurrentPage(req));
			mPage.setUrl(PageBean.getUrl(req));
			mPage.setPageTotal(PageBean.getPageCount(req));
			mPage.setTotalCount(mService.findListCount(mPage));
			mPage.setList(list);
			rm.setSuccessMessage("操作成功", mPage);
		} catch (Exception e) {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 新增物资信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="insert")
	public ResponseModel<String> insert(Material material) {
		ResponseModel<String> rm = new ResponseModel<String>();
		
		if (mService.insertSelective(material) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 修改物资信息
	 * @param req
	 * @return
	 */
/*	@ResponseBody
	@RequestMapping(value ="updateById")
	public ResponseModel<String> updateById(Material material) {
		ResponseModel<String> rm = new ResponseModel<String>();
		
		if (mService.updateByPrimaryKeySelective(material) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}*/
	
	/**
	 * 根据主键删除物资信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="delete")
	public ResponseModel<String> delete(String id) {
		ResponseModel<String> rm = new ResponseModel<String>();

		if (mService.deleteByPrimaryKey(id) > 0) {
			rm.setSuccessMessage("操作成功", null);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 根据主键查询物资信息
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="selectById")
	public ResponseModel<Material> selectById(String id) {
		ResponseModel<Material> rm = new ResponseModel<Material>();

		Material mt = mService.selectByPrimaryKey(id);
		if (mt != null) {
			rm.setSuccessMessage("操作成功", mt);
		} else {
			rm.setErrorMessage("操作失败", null);
		}
		return rm;
	}
	
	/**
	 * 获取全部物资
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="findAllList")
	public ResponseModel<List<Material>> findAllList(HttpServletRequest req) {
		ResponseModel<List<Material>> rm = new ResponseModel<List<Material>>();
		try {
			List<Material> li=mService.findAllList();
			rm.setSuccessMessage("获取全部物资", li);
		} catch (Exception e) {
			rm.setErrorMessage("获取全部物资失败", null);
		}
		return rm;
	}
	
}
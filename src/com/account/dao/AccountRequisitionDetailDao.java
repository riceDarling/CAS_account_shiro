/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountRequisition;
import com.account.entity.AccountRequisitionDetail;

/**
 * 申请单DAO接口
 * @author admin
 * @version 2017-07-24
 */
public interface AccountRequisitionDetailDao  {
	List<AccountRequisitionDetail> getAccountRequisitionDetailsByid(String parentid);
	
	AccountRequisition get(String id);
	
	List<AccountRequisitionDetail> findList(AccountRequisitionDetail entity);
	List<AccountRequisitionDetail> findAllList(AccountRequisitionDetail entity);
	/**
	 * 获取字表详细数据（关联物资，计量单位）
	 * @param parentid
	 * @return
	 */
	List<Map<String,Object>> getDetailMapByparentid(String parentid);
	
	void insert(AccountRequisitionDetail entity);
	void update(AccountRequisitionDetail entity);
	
	void delete(String id);
	
	void deleteByparentId(String parentId);
	
}
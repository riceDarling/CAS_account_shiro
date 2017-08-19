/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.dao;

import java.util.List;

import com.account.entity.AccountRequisition;

/**
 * 申请单DAO接口
 * @author admin
 * @version 2017-07-24
 */
public interface AccountRequisitionDao  {
	AccountRequisition getDataByProcId(String procInsId);
	AccountRequisition selectRequisitionByOrdernum(String orderNumber);
	
	AccountRequisition get(String id);
	
	List<AccountRequisition> findList(AccountRequisition entity);
	List<AccountRequisition> findAllList(AccountRequisition entity);
	
	void insert(AccountRequisition entity);
	void update(AccountRequisition entity);
	
	void delete(String id);
	
	
}
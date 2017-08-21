/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInquiry;


/**
 * 询价单DAO接口
 * @author 宿通
 * @version 2017-06-25
 */
public interface AccountInquiryDao {
	public void commit1(String ordernum);

	public List<AccountInquiry> selectInquiryByDateAndStatus(AccountInquiry accountInquiry);
	
	public void setAccountInquiryStatus(AccountInquiry entity);
	
	public String getRequisitionId(String ordernum);
	
	AccountInquiry get(String id);
	
	List<AccountInquiry> findList(AccountInquiry entity);
	List<AccountInquiry> findAllList(AccountInquiry entity);
	
	void insert(AccountInquiry entity);
	void update(AccountInquiry entity);
	
	void delete(String id);
	
	void setInquiryStatusById(String id,String status);
	
	
	List<Map<String,Object>> selectAllTitle();
}
package com.account.dao;

import java.util.List;

import com.account.entity.AccountInquiryDetail;

/**
 * 询价单子表DAO接口
 * @author yang
 * @version 2017-07-13
 */
public interface AccountInquiryDetailDao {
	
	AccountInquiryDetail get(String inquirydetailId);
	
	List<AccountInquiryDetail> selectInquiryDetailByOrdernum(String ordernum);
	
	void insert(AccountInquiryDetail entity);
	
	void setInquiryDetailStateById(String id,String state);
	
	public List<AccountInquiryDetail> selectInquiryDetailEndByOrdernum(String accountInquiryid);
	
	void updateByOrdernum(String ordernum);
}
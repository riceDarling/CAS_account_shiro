package com.account.service;

import java.util.List;

import com.account.entity.AccountInquiryDetail;

public interface AccountInquiryDetailService {
	List<AccountInquiryDetail> selectInquiryDetailByOrdernum(String accountInquiryid);
	
	void save(AccountInquiryDetail entity);
	
	List<AccountInquiryDetail> selectInquiryDetailEndByOrdernum(String accountInquiryid);
}

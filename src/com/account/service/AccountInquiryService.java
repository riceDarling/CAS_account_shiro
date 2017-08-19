package com.account.service;

import com.account.entity.AccountInquiry;

public interface AccountInquiryService {

	AccountInquiry getById(String id);

	void findPage(AccountInquiry accountInquiry);
	
	public void commit1(String ordernum);
	
	void detailupdata(String [] inquirydetailId,String checker);
	
	void saveAudit(AccountInquiry entity);
}

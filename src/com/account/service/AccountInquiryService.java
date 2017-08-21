package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInquiry;

public interface AccountInquiryService {

	AccountInquiry getById(String id);

	void findPage(AccountInquiry accountInquiry);
	
	public void commit1(String ordernum);
	
	void detailupdata(String [] inquirydetailId,String checker);
	
	void saveAudit(AccountInquiry entity);

	List<Map<String, Object>> selectAllTitle();

}

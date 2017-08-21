package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInquiry;
import com.account.entity.AccountInquiryDetail;

public interface AccountInquiryDetailService {
	List<AccountInquiryDetail> selectInquiryDetailByOrdernum(String accountInquiryOrdernum);
	
	void save(AccountInquiryDetail entity);
	
	List<AccountInquiryDetail> selectInquiryDetailEndByOrdernum(String accountInquiryid);

	List<Map<String, Object>> selectAllmaterial(String accountInquiryOrdernum);

	List<AccountInquiryDetail> selectDetail(AccountInquiryDetail entity);

	void saveDetail(AccountInquiry accountInquiry);
	
	public List<AccountInquiryDetail> getAccountSupplierByPurchasenum(AccountInquiryDetail accountInquiryDetail);

	public List<AccountInquiryDetail> getAccountSupplierByPurchasenumtitle(String purchasenumtitle);

}

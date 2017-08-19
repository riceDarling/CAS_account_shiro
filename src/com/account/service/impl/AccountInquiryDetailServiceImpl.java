package com.account.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.dao.AccountInquiryDetailDao;
import com.account.entity.AccountInquiryDetail;
import com.account.service.AccountInquiryDetailService;

@Service
public class AccountInquiryDetailServiceImpl implements AccountInquiryDetailService {

	@Autowired
	private AccountInquiryDetailDao accountInquiryDetailDao;
	
	@Override
	public List<AccountInquiryDetail> selectInquiryDetailByOrdernum(String accountInquiryid) {
		
		return accountInquiryDetailDao.selectInquiryDetailByOrdernum(accountInquiryid);
	}

	@Transactional(readOnly = false)
	public void save(AccountInquiryDetail entity) {
		entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		accountInquiryDetailDao.insert(entity);
	}

	@Override
	public List<AccountInquiryDetail> selectInquiryDetailEndByOrdernum(String accountInquiryid) {
		return accountInquiryDetailDao.selectInquiryDetailEndByOrdernum(accountInquiryid);
	}

}

package com.account.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.AccountReceiptDao;
import com.account.entity.AccountReceipt;
import com.account.service.AccountReceiptService;

@Service
public class AccountReceiptServiceImpl implements AccountReceiptService {
	@Autowired
	private AccountReceiptDao accountReceiptDao;

	@Override
	public void save(AccountReceipt accountReceipt) {
		if (accountReceipt.getId() != null&&accountReceipt.getId().trim().length()>0) {
			accountReceiptDao.update(accountReceipt);
		} else {
			accountReceipt.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountReceiptDao.save(accountReceipt);
		}
	}

	@Override
	public void delete(String id) {
		accountReceiptDao.delete(id);
	}

	@Override
	public void update(AccountReceipt accountReceipt) {
		accountReceiptDao.update(accountReceipt);
	}

	@Override
	public List<AccountReceipt> findList(Map<String, Object> map) {
		return accountReceiptDao.findList(map);
	}

	@Override
	public AccountReceipt getById(String id) {
		return accountReceiptDao.getById(id);
	}

}

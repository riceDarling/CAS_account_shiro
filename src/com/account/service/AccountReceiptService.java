package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountReceipt;

public interface AccountReceiptService {
	void save(AccountReceipt accountReceipt);

	void delete(String id);

	void update(AccountReceipt accountReceipt);

	List<AccountReceipt> findList(Map<String, Object> map);

	AccountReceipt getById(String id);

}

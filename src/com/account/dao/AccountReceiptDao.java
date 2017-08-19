package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountReceipt;

/**
 * 发票DAO接口
 */
public interface AccountReceiptDao {
	void save(AccountReceipt accountReceipt);

	void delete(String id);

	void update(AccountReceipt accountReceipt);

	List<AccountReceipt> findList(Map<String, Object> map);

	AccountReceipt getById(String id);

}
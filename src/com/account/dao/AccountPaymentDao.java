package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountPayment;

/**
 * 付款单DAO接口
 */
public interface AccountPaymentDao {
	void save(AccountPayment accountPayment);

	void delete(String id);

	void update(AccountPayment accountPayment);

	List<AccountPayment> findList(Map<String, Object> map);

	AccountPayment getById(String id);
}
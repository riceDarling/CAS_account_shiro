package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountPayment;

public interface AccountPaymentService {
	void save(AccountPayment accountPayment);

	void delete(String id);

	void update(AccountPayment accountPayment);

	List<AccountPayment> findList(Map<String, Object> map);

	AccountPayment getById(String id);
}

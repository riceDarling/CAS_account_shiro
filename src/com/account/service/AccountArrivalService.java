package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountArrival;

public interface AccountArrivalService {
	void save(AccountArrival accountArrival);

	void delete(String id);

	void update(AccountArrival accountArrival);

	List<AccountArrival> findList(Map<String, Object> map);

	AccountArrival getById(String id);
	// List<AccountArrival> getLastForm(String id);

}

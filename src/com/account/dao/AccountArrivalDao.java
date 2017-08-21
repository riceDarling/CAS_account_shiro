package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountArrival;

/**
 * 到货单DAO接口
 */
public interface AccountArrivalDao {
	void save(AccountArrival accountArrival);

	void delete(String id);

	void update(AccountArrival accountArrival);
    void updateStatus(String id);
	List<AccountArrival> findList(Map<String, Object> map);

	AccountArrival getById(String id);
	// List<AccountArrival> getLastForm(String id);
}
package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountArrival;

public interface AccountArrivalService {
	void save(AccountArrival accountArrival);

	void delete(String id);

	void update(Map<String,Object> map) ;
	List<AccountArrival> findAllList();
	List<AccountArrival> findList(Map<String,Object> map);

	AccountArrival getById(String id);

	List<AccountArrival> getNextForm(String contractId);

	List<AccountArrival> getLastForm(String id);
	/**
	 * 根据合同获取到货信息
	 * @param contractNum
	 * @return
	 */
	public List<AccountArrival> getArrivalDetail(String contractNum);

}

package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInspection;

/**
 * 送检单主表DAO接口
 */
public interface AccountInspectionDao {
	AccountInspection getById(String id);

	void save(AccountInspection accountInspection);

	void delete(String id);

	void update(AccountInspection accountInspection);
	void upSatus(String id);

	List<AccountInspection> findList(Map<String, Object> map);
	
	List<Map<String,Object>> getArrivalNum();

}
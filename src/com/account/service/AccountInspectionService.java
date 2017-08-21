package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInspection;

public interface AccountInspectionService {

	void save(AccountInspection accountInspection);

	void delete(String id);

	void update(Map<String, Object> map);

	AccountInspection getById(String id);

	List<AccountInspection> findList(Map<String, Object> map);


}

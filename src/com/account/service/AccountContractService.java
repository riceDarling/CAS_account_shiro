package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountContract;

public interface AccountContractService {
	void save(AccountContract accountContract);

	void delete(String id);

	void update(AccountContract accountContract);

	void updateContractStatus(String id);

	void updateContractStatustwo(String id);

	List<AccountContract> findList(Map<String, Object> map);

	AccountContract getById(String id);

	List<AccountContract> getAllAccountContractInfo();
}

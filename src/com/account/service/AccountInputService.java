package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInput;
import com.account.entity.AccountInputInfo;

public interface AccountInputService {
	List<AccountInputInfo> getAccountInputInfo();

	List<AccountInputInfo> getAccountInputListInfoBy(String id);

	int getAccountInput(String Inspectionnum);

	void updateStatus(String ordernum);

	void updateInspectionStatus(String ordernum);

	void save(AccountInput accountInput);

	void delete(String id);

	void update(String id);

	List<AccountInput> findList(Map<String, Object> map);

	AccountInput getById(String id);
}

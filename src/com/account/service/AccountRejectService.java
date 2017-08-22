package com.account.service;

import java.util.List;

import com.account.entity.AccountReject;

public interface AccountRejectService {

	void save(AccountReject accountReject);

	 List<AccountReject> list(AccountReject entity);

	AccountReject get(String accountRejectId);

	void delete(String accountRejectId);

}

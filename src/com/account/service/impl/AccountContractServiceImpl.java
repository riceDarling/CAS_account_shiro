package com.account.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.AccountContractDao;
import com.account.entity.AccountContract;
import com.account.service.AccountContractService;

@Service
public class AccountContractServiceImpl implements AccountContractService {
	@Autowired
	private AccountContractDao accountContractDao;

	@Override
	public void save(AccountContract accountContract) {
		if (accountContract.getId() != null&&accountContract.getId().trim().length()>0) {
			accountContractDao.update(accountContract);
		} else {
			accountContract.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountContractDao.save(accountContract);
		}
		
		
	}

	@Override
	public void delete(String id) {
		accountContractDao.delete(id);
	}

	@Override
	public List<AccountContract> findList(Map<String, Object> map) {
		return accountContractDao.findList(map);
	}

	@Override
	public void updateContractStatus(String id) {
		accountContractDao.updateContractStatus(id);
	}

	@Override
	public void updateContractStatustwo(String id) {
		accountContractDao.updateContractStatustwo(id);
	}

	@Override
	public List<AccountContract> getAllAccountContractInfo() {
		return accountContractDao.getAllAccountContractInfo();
	}

	@Override
	public AccountContract getById(String id) {
		return accountContractDao.getById(id);
	}
	@Override
	public void update(AccountContract accountContract) {
		accountContractDao.update(accountContract);
	}

}

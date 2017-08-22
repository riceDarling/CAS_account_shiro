package com.account.dao;

import java.util.List;

import com.account.entity.AccountContractDetail;

/**
 * 合同子表DAO接口
 */
public interface AccountContractDetailDao {
	void save(AccountContractDetail accountContractDetail);

	void delete(String id);

	void update(AccountContractDetail accountContractDetail);

	List<AccountContractDetail> getByContractId(String id);
     
}
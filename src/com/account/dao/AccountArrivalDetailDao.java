package com.account.dao;

import java.util.List;

import com.account.entity.AccountArrivalDetail;

/**
 * 到货子表DAO接口
 */
public interface AccountArrivalDetailDao {
	void save(AccountArrivalDetail accountArrivalDetail);

	void delete(String id);

	void update(AccountArrivalDetail accountArrivalDetail);

	List<AccountArrivalDetail> getByArrivalId(String id);
     
}
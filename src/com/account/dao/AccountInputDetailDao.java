package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInputDetail;

/**
 * 入库单子表DAO接口
 * 
 * @author haitao
 * @version 2017-07-26
 */
public interface AccountInputDetailDao {
	void save(AccountInputDetail accountInputDetail);

	void delete(String id);

	void update(Map<String, Object> map);

	List<AccountInputDetail> findList();

	AccountInputDetail getById(String id);
}
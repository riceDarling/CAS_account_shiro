package com.account.dao;

import java.util.List;

import com.account.entity.AccountPurchase;

/**
 * 订货单DAO接口
 * 
 * @author admin
 * @version 2017-07-20
 */
public interface AccountPurchaseDao {

	public AccountPurchase get(String id);

	public List<AccountPurchase> findList(AccountPurchase accountPurchase);

	public List<AccountPurchase> findAllList(AccountPurchase accountPurchase);

	public void insert(AccountPurchase accountPurchase);

	public void update(AccountPurchase accountPurchase);

	public void delete(String id);

	public List<AccountPurchase> getAccountPurchaseTitle();
}
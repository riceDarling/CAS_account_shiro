package com.account.dao;

import java.util.List;
import com.account.entity.AccountPurchaseDetail;

/**
 * 订货单DAO接口
 * 
 * @author admin
 * @version 2017-07-26
 */
public interface AccountPurchaseDetailDao {
	
	public AccountPurchaseDetail get(String id);

	public List<AccountPurchaseDetail> findList(AccountPurchaseDetail entity);

	public List<AccountPurchaseDetail> findAllList(AccountPurchaseDetail entity);

	public void insert(AccountPurchaseDetail entity);

	public void update(AccountPurchaseDetail entity);

	public void delete(String id);
	
	void deleteByparentId(String parentId);
	
	public List<AccountPurchaseDetail> getAccountSupplierByPurchasenum(AccountPurchaseDetail accountPurchaseDetail);

	public List<AccountPurchaseDetail> getAccountSupplierByPurchasenumtitle(String purchasenumtitle);

	
}
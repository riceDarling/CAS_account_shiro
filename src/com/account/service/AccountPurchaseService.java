package com.account.service;

import java.util.List;

import com.account.entity.AccountPurchase;
import com.account.entity.AccountPurchaseSupplier;

public interface AccountPurchaseService {
	
	public AccountPurchase get(String id);
	public void save(AccountPurchase accountPurchase);
	
	public List<AccountPurchaseSupplier> getbyParentId(String parentId);
	
	public void setAccountPurchaseDetailListService(AccountPurchase accountPurchase);
	
	public void saveAudit(AccountPurchase entity);
	public AccountPurchase findPage(AccountPurchase entity);
	public void delete(String accountPurchaseid);
	public List<AccountPurchase> findAllorderNum();
}

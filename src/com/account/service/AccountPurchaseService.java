package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountPurchase;
import com.account.entity.AccountPurchaseDetail;
import com.account.entity.AccountPurchaseSupplier;

public interface AccountPurchaseService {
	
	public AccountPurchase get(String id);
	public void save(AccountPurchase accountPurchase);
	
	public List<AccountPurchaseSupplier> getbyParentId(String parentId);
	
	public void setAccountPurchaseDetailListService(AccountPurchase accountPurchase);
	
	public void saveAudit(AccountPurchase entity);
	public List<AccountPurchase> getAccountPurchaseTitle();
	public List<AccountPurchaseDetail> getAccountSupplierByPurchasenum(AccountPurchaseDetail accountPurchaseDetail);

	public Map<String,AccountPurchaseDetail> getAccountSupplierByPurchasenumtitle(String purchasenumtitle);

}

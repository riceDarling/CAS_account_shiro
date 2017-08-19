package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountRequisitionAct;

public interface AccountRequisitionActService {
	void insert(AccountRequisitionAct entity);
	
	void update(AccountRequisitionAct entity);
	
	public List<Map<String,Object>> getbyRequisitionId(String requisitionId);
	
	public AccountRequisitionAct findPage(AccountRequisitionAct entity);
	
	public String revoke(String requisitionId);
}

package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountRequisition;

public interface AccountRequisitionService {
	public AccountRequisition get(String id);
	public void save(AccountRequisition accountRequisition);
	/**
	 * 获取字表详细数据（关联物资，计量单位）
	 * @param parentid
	 * @return
	 */
	List<Map<String,Object>> getDetailMapByparentid(String parentid);
	
	public void saveAudit(AccountRequisition accountRequisition);
	
	void delete(String requisitionid);
}

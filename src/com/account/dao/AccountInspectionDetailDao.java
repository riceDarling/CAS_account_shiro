package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountInspectionDetail;
import com.account.entity.AccountInspectionInfo;

/**
 * 送检单子表DAO接口
 */
public interface AccountInspectionDetailDao {
	void add(AccountInspectionDetail accountInspectionDetail);

	void delete(String id);

	void update(String id);

	List<AccountInspectionDetail> findList(Map<String, Object> map);

	AccountInspectionDetail getById(String id);

	void updateDetail(AccountInspectionDetail accountInspectionDetail);

	List<AccountInspectionInfo> getAccount_inspectionInfo(String arrivalnum);
}
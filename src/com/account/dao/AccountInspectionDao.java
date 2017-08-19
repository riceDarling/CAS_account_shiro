package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountArrival;
import com.account.entity.AccountInspection;

/**
 * 送检单主表DAO接口
 */
public interface AccountInspectionDao {
	AccountInspection getById(String id);

	void save(AccountInspection accountInspection);

	void delete(String id);

	void update(Map<String, Object> map);

	void upArrivalSatus(String arrivalnum);

	List<AccountInspection> findList(Map<String, Object> map);

	// 根据送检ID获取送检单详情
	List<AccountInspection> getNextInspection(String id);

	// 到货未送检列表
	List<AccountArrival> getArrivalList();

	// 根据到货时间及合同ID获取到货未送检详情
	List<AccountArrival> getDetailByDateAndContractId(AccountArrival accountArrival);

	// 根据送检时间和送检子表ID及合同ID获取送检单详情
	AccountInspection getInspectionDetailToAdd(AccountInspection accountInspection);
}
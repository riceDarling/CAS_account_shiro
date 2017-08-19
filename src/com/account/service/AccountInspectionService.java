package com.account.service;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountArrival;
import com.account.entity.AccountInspection;
import com.account.entity.AccountInspectionDetail;
import com.account.entity.AccountInspectionInfo;

public interface AccountInspectionService {

	void save(AccountInspection accountInspection);

	void delete(String id);

	void update(Map<String, Object> map);
	AccountInspection getById(String id);

	List<AccountInspection> findList(Map<String, Object> map);
	
	
	 void updateDetail(AccountInspectionDetail accountInspectionDetail);
	 List<AccountInspectionInfo> getAccount_inspectionInfo(String arrivalnum);
	// 到货未送检列表
	List<AccountArrival> getArrivalList();

	// 根据送检时间及合同ID获取送检单详情
	List<AccountInspection> getNextInspection(String id);
	
	
	
	// 根据到货时间及合同ID获取到货未送检详情
	List<AccountArrival> getDetailByDateAndContractId(AccountArrival accountArrival);


	// 根据送检时间和送检子表ID及合同ID获取送检单详情
	AccountInspection getInspectionDetailToAdd(AccountInspection accountInspection);
}

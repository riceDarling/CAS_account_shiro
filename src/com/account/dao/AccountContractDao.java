package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountContract;

/**
 * 合同DAO接口
 */
public interface AccountContractDao {

	// public List<AccuuntMaterialPurchasingModifyQuery> findTotalModifyQuery(AccuuntMaterialPurchasingModifyQuery accuuntMaterialPurchasingModifyQuery);
	// public List<AccuuntMaterialPurchasingSubsidiaryLedger> findTotalSubsidiaryLedger(AccuuntMaterialPurchasingSubsidiaryLedger accuuntMaterialPurchasingSubsidiaryLedger);
	// public List<AccountMaterialPurchaseReturnReason> findTotalPurchaseReturnReason(AccountMaterialPurchaseReturnReason accuuntMaterialPurchaseReturnReason);
	// public List<AccountMaterialPurchasingLossAnalysis> findTotalPurchasingLossAnalysisOne(AccountMaterialPurchasingLossAnalysis accountMaterialPurchasingLossAnalysis);
	// public List<AccountMaterialPurchasingLossAnalysis> findTotalPurchasingLossAnalysisTwo(AccountMaterialPurchasingLossAnalysis accountMaterialPurchasingLossAnalysis);
	void save(AccountContract accountContract);

	void delete(String id);
    void update(AccountContract accountContract);
	void updateContractStatus(String id);

	void updateContractStatustwo(String id);

	List<AccountContract> findList(Map<String, Object> map);

	AccountContract getById(String id);

	List<AccountContract> getAllAccountContractInfo();

	List<Map<String, Object>> findAllTitle();
}
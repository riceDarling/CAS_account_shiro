package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.AccountRequisitionAct;

public interface AccountRequisitionActDao {

	void insert(AccountRequisitionAct entity);
	
	void update(AccountRequisitionAct entity);
	
	List<Map<String,Object>> getbyRequisitionId(String requisitionId);
	
	AccountRequisitionAct getbyRequisitionIdAndChecknameAndState(AccountRequisitionAct entity);
	
	/**
	 * 待办(完成)
	 * @param checkname
	 * @return
	 */
	List<Map<String,Object>> findList(AccountRequisitionAct entity);
	
	void deleteByRequisitionId(String requisitionId);
	
	/**
	 * 获取最新的节点
	 */
	AccountRequisitionAct getbyRequisitionIdAndState(String requisitionId);
	
	void revoke(AccountRequisitionAct entity);
	
	/**
	 * 根据requisitionId和步数查询一条记录
	 */
	AccountRequisitionAct getbyRequisitionIdAndStep(Map<String,Object> map);
}

package com.account.service;

import java.util.List;

import com.account.entity.AccountPara;

public interface AccountParaService {
	/**
	 * 根据主键删除单位类型
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
	
    /**
	 * 新增单位类型
	 * @param id
	 * @return
	 */
    int insertSelective(AccountPara record);

	/**
	 * 根据主键查询单位类型
	 * @param id
	 * @return
	 */
    AccountPara selectByPrimaryKey(Integer id);

	/**
	 * 根据主键修改单位类型
	 * @param id
	 * @return
	 */
    int updateByPrimaryKeySelective(AccountPara record);

    /**
     * 分页查询全部单位类型
     * @return
     */
    List<AccountPara> findList();
}

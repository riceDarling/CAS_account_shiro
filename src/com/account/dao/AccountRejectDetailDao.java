package com.account.dao;

import java.util.List;

import com.account.entity.AccountRejectDetail;

public interface AccountRejectDetailDao {
    int deleteByPrimaryKey(String id);

    int insert(AccountRejectDetail record);

    int insertSelective(AccountRejectDetail record);

    AccountRejectDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountRejectDetail record);

    int updateByPrimaryKey(AccountRejectDetail record);
    
    List<AccountRejectDetail> getByPid(String pid);
}
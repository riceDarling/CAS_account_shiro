package com.account.dao;

import java.util.List;

import com.account.entity.AccountReject;

public interface AccountRejectDao {
    int deleteByPrimaryKey(String id);

    int insert(AccountReject record);

    int insertSelective(AccountReject record);

    AccountReject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountReject record);

    int updateByPrimaryKey(AccountReject record);
    
    List<AccountReject> list(AccountReject entity);
    
   int delete(String id);
}
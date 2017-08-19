package com.account.dao;

import java.util.List;

import com.account.entity.Admin;

public interface AdminDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    public Admin getAdminByName(String name);
    
    List<Admin> findList();
}
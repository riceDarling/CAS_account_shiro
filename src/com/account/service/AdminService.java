package com.account.service;

import java.util.List;

import com.account.entity.Admin;

public interface AdminService {

	Admin getAdminByName(String name);

	/**
	 * 插入一个用户
	 * @param ia
	 * @return
	 */
	void insertSelective(Admin ia);

	/**
	 * 修改用户
	 * @param ia
	 * @return
	 */
	void update(Admin ia);
	
	List<Admin> findList();
}

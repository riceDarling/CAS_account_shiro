package com.account.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.MaterialMapper;
import com.account.entity.Material;
import com.account.service.MaterialService;
import com.account.utils.GetUUID;
import com.account.utils.pagebean.MaterialPage;

@Service
public class MaterialServiceImpl implements MaterialService{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private MaterialMapper mDao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return mDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Material record) {
		if (record.getId() != null && !record.getId().equals("")) {
			record.setDelFlag("0");
			return mDao.updateByPrimaryKeySelective(record);
		} else {
			record.setId(GetUUID.getOneUUID());
			record.setCreateDate(new Date());
			record.setDelFlag("0");
			return mDao.insertSelective(record);
		}
	}

	@Override
	public Material selectByPrimaryKey(String id) {
		return mDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Material record) {
		return mDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Material> findList(MaterialPage mPage) {
		List<Material> list = mDao.findList(mPage);
		for (Material ml : list) {
			ml.setCreateTime(sdf.format(ml.getCreateDate()));
		}
		return list;
	}
	
	@Override
	public int findListCount(MaterialPage mPage) {
		return mDao.findListCount(mPage);
	}
	
	@Override
	public List<Material> findAllList() {
		return mDao.findAllList();
	}
}

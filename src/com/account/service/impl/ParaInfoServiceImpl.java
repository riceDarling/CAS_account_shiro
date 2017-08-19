package com.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.ParaInfoMapper;
import com.account.entity.ParaInfo;
import com.account.service.ParaInfoService;
import com.account.utils.pagebean.ParaInfoPage;

@Service
public class ParaInfoServiceImpl implements ParaInfoService {

	@Autowired
	private ParaInfoMapper piDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return piDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(ParaInfo record) {
		if (record.getId() != null && !record.getId().equals("")) {
			record.setDelFlag("0");
			return piDao.updateByPrimaryKeySelective(record);
		} else {
			record.setDelFlag("0");
			return piDao.insertSelective(record);
		}
	}

	@Override
	public ParaInfo selectByPrimaryKey(Integer id) {
		return piDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ParaInfo record) {
		return piDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ParaInfo> findList(ParaInfoPage piPage) {
		return piDao.findList(piPage);
	}
	
	@Override
	public int findListCount(ParaInfoPage piPage) {
		return piDao.findListCount(piPage);
	}

	@Override
	public List<ParaInfo> getParaInfoList(int pId) {
		// TODO Auto-generated method stub
		return piDao.getParaInfoList(pId);
	}
	
}

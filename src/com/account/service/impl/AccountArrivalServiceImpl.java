package com.account.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.AccountArrivalDao;
import com.account.entity.AccountArrival;
import com.account.service.AccountArrivalService;
import com.account.utils.FormatDateUtils;
import com.account.utils.RandomUtils;

@Service
public class AccountArrivalServiceImpl implements AccountArrivalService {
	@Autowired
	private AccountArrivalDao accountArrivalDao;

	@Override
	public void save(AccountArrival accountArrival) {
		// 生成17位单据编号 04-20170203-00001
		String ordernum = "04-" + FormatDateUtils.dateToString(new Date()) + "-" + RandomUtils.random();
		accountArrival.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		accountArrival.setOrdernum(ordernum);
		accountArrivalDao.save(accountArrival);
	}

	@Override
	public void delete(String id) {
		accountArrivalDao.delete(id);

	}

	@Override
	public void update(Map<String, Object> map) {
		accountArrivalDao.update(map);
	}

	@Override
	public List<AccountArrival> findList(Map<String, Object> map) {
		return accountArrivalDao.findList(map);
	}

	@Override
	public AccountArrival getById(String id) {
		return accountArrivalDao.getById(id);
	}

	@Override
	public List<AccountArrival> getNextForm(String contractId) {
		return accountArrivalDao.getNextForm(contractId);
	}

	@Override
	public List<AccountArrival> getLastForm(String id) {
		return accountArrivalDao.getLastForm(id);
	}

	public List<AccountArrival> getArrivalDetail(String contractNum) {
		// 分组数据
		List<AccountArrival> arrivalDetail = accountArrivalDao.getArrivalDetail(contractNum);
		// 未分组数量
		List<AccountArrival> arrivalDetailNum = accountArrivalDao.getArrivalDetailNum(contractNum);

		for (AccountArrival ad : arrivalDetail) {
			String materialId = ad.getMaterialId();
			int arrNum = 0;
			for (AccountArrival adn : arrivalDetailNum) {
				if (materialId.equals(adn.getMaterialId())) {
					arrNum += Integer.parseInt(adn.getArrivalNum());
				}
			}
			ad.setArrivalNum("" + arrNum);
		}
		return arrivalDetail;
	}

	@Override
	public List<AccountArrival> findAllList() {
		return accountArrivalDao.findAllList();
	}

}

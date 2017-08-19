package com.account.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.dao.AccountInspectionDao;
import com.account.dao.AccountInspectionDetailDao;
import com.account.entity.AccountArrival;
import com.account.entity.AccountInspection;
import com.account.entity.AccountInspectionDetail;
import com.account.entity.AccountInspectionInfo;
import com.account.service.AccountInspectionService;

@Service
@Transactional
public class AccountInspectionServiceImpl implements AccountInspectionService {
	@Autowired
	private AccountInspectionDao accountInspectionDao;
	@Autowired
	private AccountInspectionDetailDao accountInspectionDetailDao;

	@Override
	public void save(AccountInspection accountInspection) {
		accountInspection.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		accountInspectionDao.save(accountInspection);
		int size = accountInspection.getAccountInspectionDetail().size();
		AccountInspectionDetail accountInspectionDetail = new AccountInspectionDetail();
		for (int i = 0; i < size; i++) {
			accountInspectionDetail = accountInspection.getAccountInspectionDetail().get(i);
			if (!accountInspectionDetail.getStatus().equals("1")) {
				accountInspectionDao.upArrivalSatus(accountInspection.getArrivalnum());
			}
			accountInspectionDetail.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			accountInspectionDetail.setParent_Id(accountInspection.getId());
			accountInspectionDetailDao.add(accountInspectionDetail);
		}

	}

	@Override
	public void delete(String id) {
		accountInspectionDao.delete(id);
	}

	@Override
	public void update(Map<String, Object> map) {
		accountInspectionDao.update(map);
	}

	@Override
	public void updateDetail(AccountInspectionDetail accountInspectionDetail) {
		accountInspectionDetailDao.updateDetail(accountInspectionDetail);

	}

	@Override
	public List<AccountInspectionInfo> getAccount_inspectionInfo(String arrivalnum) {
		return accountInspectionDetailDao.getAccount_inspectionInfo(arrivalnum);
	}

	@Override
	public List<AccountArrival> getArrivalList() {
		return accountInspectionDao.getArrivalList();
	}

	@Override
	public List<AccountArrival> getDetailByDateAndContractId(AccountArrival accountArrival) {
		return accountInspectionDao.getDetailByDateAndContractId(accountArrival);
	}

	@Override
	public List<AccountInspection> getNextInspection(String id) {
		return accountInspectionDao.getNextInspection(id);
	}

	@Override
	public AccountInspection getInspectionDetailToAdd(AccountInspection accountInspection) {
		return accountInspectionDao.getInspectionDetailToAdd(accountInspection);
	}

	@Override
	public AccountInspection getById(String id) {
		return accountInspectionDao.getById(id);
	}

	@Override
	public List<AccountInspection> findList(Map<String, Object> map) {
		return accountInspectionDao.findList(map);
	}

}

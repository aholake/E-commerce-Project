package com.ecommerce.TAL.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.AccountDetailDao;
import com.ecommerce.TAL.model.AccountDetail;
import com.ecommerce.TAL.service.AccountDetailService;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

	@Autowired
	private AccountDetailDao accountDetailDao;
	@Override
	@Transactional
	public void saveAccountDetail(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		this.accountDetailDao.saveAccountDetail(accountDetail);
	}
	@Override
	@Transactional
	public void deleteAccountDetail(int accountId) {
		// TODO Auto-generated method stub
		this.accountDetailDao.deleteAccountDetail(accountId);
	}
	@Override
	@Transactional
	public List<AccountDetail> getListAccountDetail() {
		// TODO Auto-generated method stub
		return this.accountDetailDao.getListAccountDetail();
	}
	@Override
	@Transactional
	public AccountDetail getAccountDetail(int accountId) {
		// TODO Auto-generated method stub
		return this.accountDetailDao.getAccountDetail(accountId);
	}

}

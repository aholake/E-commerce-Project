package com.ecommerce.TAL.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.AccountDao;
import com.ecommerce.TAL.model.Account;
import com.ecommerce.TAL.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	@Transactional
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		this.accountDao.saveAccount(account);
	}
	@Override
	@Transactional
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		this.accountDao.deleteAccount(accountId);
	}
	@Override
	@Transactional
	public List<Account> getListAccount() {
		// TODO Auto-generated method stub
		return this.accountDao.getListAccount();
	}
	@Override
	@Transactional
	public Account getAccount(int accountId) {
		// TODO Auto-generated method stub
		return this.accountDao.getAccount(accountId);
	}

}

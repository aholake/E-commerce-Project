package com.ecommerce.TAL.dao;

import java.util.List;

import com.ecommerce.TAL.model.Account;

public interface AccountDao {

	/*
	 * Create and Update Account
	 */
	public void saveAccount(Account account);

	/*
	 * Delete Account
	 */
	public void deleteAccount(int accountId);

	public List<Account> getListAccount();

	public Account getAccount(int accountId);
}

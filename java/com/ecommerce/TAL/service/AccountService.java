package com.ecommerce.TAL.service;

import java.util.List;

import com.ecommerce.TAL.model.Account;

public interface AccountService {

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

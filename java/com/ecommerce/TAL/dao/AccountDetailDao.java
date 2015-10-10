package com.ecommerce.TAL.dao;

import java.util.List;

import com.ecommerce.TAL.model.AccountDetail;

public interface AccountDetailDao {
	/*
	 * Create and Update Account Detail
	 */
	public void saveAccountDetail(AccountDetail accountDetail);

	/*
	 * Delete Account Detail
	 */
	public void deleteAccountDetail(int accountId);

	public List<AccountDetail> getListAccountDetail();

	public AccountDetail getAccountDetail(int accountId);
}

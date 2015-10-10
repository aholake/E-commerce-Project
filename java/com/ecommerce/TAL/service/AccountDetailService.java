package com.ecommerce.TAL.service;

import java.util.List;

import com.ecommerce.TAL.model.AccountDetail;

public interface AccountDetailService {
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

package com.ecommerce.TAL.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.AccountDetailDao;
import com.ecommerce.TAL.model.AccountDetail;

@Repository
public class AccountDetailDaoImpl implements AccountDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveAccountDetail(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		getSession().save(accountDetail);
	}

	@Override
	@Transactional
	public void deleteAccountDetail(int accountId) {
		// TODO Auto-generated method stub
		AccountDetail accountDetail = getAccountDetail(accountId);

		if (accountDetail != null) {
			getSession().delete(accountDetail);
		}
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<AccountDetail> getListAccountDetail() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(AccountDetail.class).list();
	}

	@Override
	@Transactional
	public AccountDetail getAccountDetail(int accountId) {
		// TODO Auto-generated method stub
		return (AccountDetail) getSession().get(AccountDetail.class, accountId);
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

}

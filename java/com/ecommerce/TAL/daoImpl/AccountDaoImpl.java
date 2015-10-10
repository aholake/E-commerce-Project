package com.ecommerce.TAL.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.AccountDao;
import com.ecommerce.TAL.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		getSession().save(account);
	}

	@Override
	@Transactional
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		Account account = getAccount(accountId);

		if (account != null) {
			getSession().delete(account);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Account> getListAccount() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Account.class).list();
	}

	@Override
	@Transactional
	public Account getAccount(int accountId) {
		// TODO Auto-generated method stub
		return (Account) getSession().get(Account.class, accountId);
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

package com.ecommerce.TAL.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ShoppingCartItemDao;
import com.ecommerce.TAL.model.ShoppingCartItem;

@Repository
public class ShoppingCartItemDaoImpl implements ShoppingCartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		// TODO Auto-generated method stub
		getSession().save(shoppingCartItem);
	}

	@Override
	@Transactional
	public void deleteShoppingCartItem(int shoppingCartItemId) {
		// TODO Auto-generated method stub
		ShoppingCartItem shoppingCartItem = getShoppingCartItem(shoppingCartItemId);
		if (shoppingCartItem != null) {
			getSession().delete(shoppingCartItem);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ShoppingCartItem> getListShoppingCartItem() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(ShoppingCartItem.class).list();
	}

	@Override
	@Transactional
	public ShoppingCartItem getShoppingCartItem(int shoppingCartItemId) {
		// TODO Auto-generated method stub
		return (ShoppingCartItem) getSession().get(ShoppingCartItem.class,
				shoppingCartItemId);
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

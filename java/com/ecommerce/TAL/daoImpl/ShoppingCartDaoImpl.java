package com.ecommerce.TAL.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ShoppingCartDao;
import com.ecommerce.TAL.model.ShoppingCart;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		getSession().save(shoppingCart);
	}

	@Override
	@Transactional
	public void deleteShoppingCart(int shoppingCartId) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = getShoppingCart(shoppingCartId);
		if (shoppingCart != null) {
			getSession().delete(shoppingCart);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ShoppingCart> getListShoppingCart() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(ShoppingCart.class).list();
	}

	@Override
	@Transactional
	public ShoppingCart getShoppingCart(int shoppingCartId) {
		// TODO Auto-generated method stub
		return (ShoppingCart) getSession().get(ShoppingCart.class,
				shoppingCartId);
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

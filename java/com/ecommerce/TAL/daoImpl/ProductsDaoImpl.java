package com.ecommerce.TAL.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ProductsDao;
import com.ecommerce.TAL.model.Products;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveProducts(Products products) {
		// TODO Auto-generated method stub
		getSession().save(products);
	}

	@Override
	@Transactional
	public void deleteProducts(int productsId) {
		// TODO Auto-generated method stub
		Products products = getProducts(productsId);
		if (products != null) {
			getSession().delete(products);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Products> getListProducts() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Products.class).list();
	}

	@Override
	@Transactional
	public Products getProducts(int productsId) {
		// TODO Auto-generated method stub
		return (Products) getSession().get(Products.class, productsId);
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

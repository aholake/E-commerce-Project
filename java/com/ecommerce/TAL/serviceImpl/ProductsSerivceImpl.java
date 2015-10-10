package com.ecommerce.TAL.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ProductsDao;
import com.ecommerce.TAL.model.Products;
import com.ecommerce.TAL.service.ProductsSerivce;

@Service
public class ProductsSerivceImpl implements ProductsSerivce {

	@Autowired
	private ProductsDao productsDao;

	@Override
	@Transactional
	public void saveProducts(Products products) {
		// TODO Auto-generated method stub
		productsDao.saveProducts(products);
	}

	@Override
	@Transactional
	public void deleteProducts(int productsId) {
		// TODO Auto-generated method stub
		productsDao.deleteProducts(productsId);
	}

	@Override
	@Transactional
	public List<Products> getListProducts() {
		// TODO Auto-generated method stub
		return productsDao.getListProducts();
	}

	@Override
	@Transactional
	public Products getProducts(int productsId) {
		// TODO Auto-generated method stub
		return productsDao.getProducts(productsId);
	}

}

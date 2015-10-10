package com.ecommerce.TAL.service;

import java.util.List;

import com.ecommerce.TAL.model.Products;

public interface ProductsSerivce {

	/*
	 * Create and Update Products
	 */
	public void saveProducts(Products products);

	/*
	 * Delete Products
	 */
	public void deleteProducts(int productsId);

	public List<Products> getListProducts();

	public Products getProducts(int productsId);
}

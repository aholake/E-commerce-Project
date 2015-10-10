package com.ecommerce.TAL.dao;

import java.util.List;

import com.ecommerce.TAL.model.ShoppingCart;

public interface ShoppingCartDao {
	/*
	 * Create and Update ShoppingCart
	 */
	public void saveShoppingCart(ShoppingCart shoppingCart);

	/*
	 * Delete ShoppingCart
	 */
	public void deleteShoppingCart(int shoppingCartId);

	public List<ShoppingCart> getListShoppingCart();

	public ShoppingCart getShoppingCart(int shoppingCartId);
}

package com.ecommerce.TAL.service;

import java.util.List;

import com.ecommerce.TAL.model.ShoppingCart;

public interface ShoppingCartService {
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

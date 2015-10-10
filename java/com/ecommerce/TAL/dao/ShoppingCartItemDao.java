package com.ecommerce.TAL.dao;

import java.util.List;

import com.ecommerce.TAL.model.ShoppingCartItem;

public interface ShoppingCartItemDao {
	/*
	 * Create and Update ShoppingCartItem
	 */
	public void saveShoppingCartItem(ShoppingCartItem shoppingCartItem);

	/*
	 * Delete ShoppingCartItem
	 */
	public void deleteShoppingCartItem(int shoppingCartItemId);

	public List<ShoppingCartItem> getListShoppingCartItem();

	public ShoppingCartItem getShoppingCartItem(int shoppingCartItemId);
}

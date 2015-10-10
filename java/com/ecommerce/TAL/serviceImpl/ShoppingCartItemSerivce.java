package com.ecommerce.TAL.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ShoppingCartItemDao;
import com.ecommerce.TAL.model.ShoppingCartItem;
import com.ecommerce.TAL.service.ShoppingCartItemService;

@Service
public class ShoppingCartItemSerivce implements ShoppingCartItemService {

	@Autowired
	private ShoppingCartItemDao shoppingCartItemDao;

	@Override
	@Transactional
	public void saveShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		// TODO Auto-generated method stub
		shoppingCartItemDao.saveShoppingCartItem(shoppingCartItem);
	}

	@Override
	@Transactional
	public void deleteShoppingCartItem(int shoppingCartItemId) {
		// TODO Auto-generated method stub
		shoppingCartItemDao.deleteShoppingCartItem(shoppingCartItemId);
	}

	@Override
	@Transactional
	public List<ShoppingCartItem> getListShoppingCartItem() {
		// TODO Auto-generated method stub
		return shoppingCartItemDao.getListShoppingCartItem();
	}

	@Override
	@Transactional
	public ShoppingCartItem getShoppingCartItem(int shoppingCartItemId) {
		// TODO Auto-generated method stub
		return shoppingCartItemDao.getShoppingCartItem(shoppingCartItemId);
	}

}

package com.ecommerce.TAL.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.TAL.dao.ShoppingCartDao;
import com.ecommerce.TAL.model.ShoppingCart;
import com.ecommerce.TAL.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	@Transactional
	public void saveShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		shoppingCartDao.saveShoppingCart(shoppingCart);
	}

	@Override
	@Transactional
	public void deleteShoppingCart(int shoppingCartId) {
		// TODO Auto-generated method stub
		shoppingCartDao.deleteShoppingCart(shoppingCartId);
	}

	@Override
	@Transactional
	public List<ShoppingCart> getListShoppingCart() {
		// TODO Auto-generated method stub
		return shoppingCartDao.getListShoppingCart();
	}

	@Override
	@Transactional
	public ShoppingCart getShoppingCart(int shoppingCartId) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getShoppingCart(shoppingCartId);
	}

}

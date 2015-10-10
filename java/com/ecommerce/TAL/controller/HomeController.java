package com.ecommerce.TAL.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.TAL.model.Account;
import com.ecommerce.TAL.model.AccountDetail;
import com.ecommerce.TAL.model.Products;
import com.ecommerce.TAL.model.ShoppingCart;
import com.ecommerce.TAL.model.ShoppingCartItem;
import com.ecommerce.TAL.service.AccountDetailService;
import com.ecommerce.TAL.service.AccountService;
import com.ecommerce.TAL.service.ShoppingCartItemService;
import com.ecommerce.TAL.service.ShoppingCartService;
import com.mysql.fabric.xmlrpc.base.Data;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ShoppingCartItemService shoppingCartItemService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String oneToOne(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 * one to one (account vs account detail)
		 */
		Account account = new Account();
		account.setUsername("a6terabytente");
		account.setPassword("tuanem");
		account.setActive(true);

		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setFullName("Nguyan Tuan Anh");
		accountDetail.setEmail("ntatvr@gmail.com");
		accountDetail.setSex(1);
		accountDetail.setPhoneNumber("01653164732");
		accountDetail.setBirthday(new Date());
		accountDetail.setAddress("BH, DN");

		account.setAccountDetail(accountDetail);

		accountDetail.setAccount(account);

		accountService.saveAccount(account);
		
		/*
		 * one to many (account vs shoppingcart, shoppingcart vs shoppingcartitem)
		 */
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setDate(new Date());
		shoppingCart.setSumMoney(50000);

		shoppingCart.setAccount(account);
		account.getShoppingCarts().add(shoppingCart);

		shoppingCartService.saveShoppingCart(shoppingCart);
		
		
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setQuantity(10);
		shoppingCartItem.setPrice(5000);
		shoppingCartItem.setCost(5000);
		
		shoppingCartItem.setScart(shoppingCart);
		shoppingCart.getShoppingCartItems().add(shoppingCartItem);
		
		
		/*
		 * many to many (shoppingcartitem vs product)
		 */
		Products p1 = new Products();
		p1.setName("Mat hang A");
		p1.setTitle("Dang Cap Nhat");
		p1.setDetail("Dang cap nhat");
		p1.setPrice(5000);
		p1.setSale(0);
		Products p2 = new Products();
		p2.setName("Mat hang B");
		p2.setTitle("Dang Cap Nhat");
		p2.setDetail("Dang cap nhat");
		p2.setPrice(5000);
		p2.setSale(0);
		Set<Products> products = new HashSet<Products>();
		products.add(p1);
		products.add(p2);
		
		shoppingCartItem.setProducts(products);
		
		shoppingCartItemService.saveShoppingCartItem(shoppingCartItem);
		
		
		
		
		
		return "Results: " + account;
	}

}

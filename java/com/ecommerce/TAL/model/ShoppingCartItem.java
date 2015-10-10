package com.ecommerce.TAL.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcartitem", catalog = "ecommerce")
public class ShoppingCartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cartItemID;
	private int quantity;
	private int price;
	private int cost;

	private ShoppingCart scart;

	private Set<Products> products = new HashSet<Products>(0);

	public ShoppingCartItem() {
		super();
	}

	public ShoppingCartItem(int quantity, int price, int cost) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}

	public ShoppingCartItem(int cartItemID, int quantity, int price, int cost) {
		super();
		this.cartItemID = cartItemID;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}

	public ShoppingCartItem(int cartItemID, int quantity, int price, int cost,
			ShoppingCart scart) {
		super();
		this.cartItemID = cartItemID;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
		this.scart = scart;
	}

	public ShoppingCartItem(int cartItemID, int quantity, int price, int cost,
			ShoppingCart scart, Set<Products> products) {
		super();
		this.cartItemID = cartItemID;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
		this.scart = scart;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ITEM_ID", unique = true, nullable = false)
	public int getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}

	@Column(name = "QUANTITY", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "PRICE", nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "COST", nullable = false)
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCART_ID", nullable = false)
	public ShoppingCart getScart() {
		return scart;
	}

	public void setScart(ShoppingCart scart) {
		this.scart = scart;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scart_item_products", catalog = "ecommerce", joinColumns = { @JoinColumn(name = "SCART_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "PRODUCTS_ID", nullable = false, updatable = false)})
	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [cartItemID=" + cartItemID + ", quantity="
				+ quantity + ", price=" + price + ", cost=" + cost + "]";
	}

}

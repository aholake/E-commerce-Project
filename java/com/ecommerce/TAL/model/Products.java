package com.ecommerce.TAL.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products", catalog = "ecommerce")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productID;
	private String name;
	private String title;
	private String detail;
	private int price;
	private int sale;

	private Set<ShoppingCartItem> scitem = new HashSet<ShoppingCartItem>(0);

	public Products() {
		super();
	}

	public Products(String name, String title, String detail, int price, int sale) {
		super();
		this.name = name;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.sale = sale;
	}

	public Products(int productID, String name, String title, String detail, int price,
			int sale) {
		super();
		this.productID = productID;
		this.name = name;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.sale = sale;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTS_ID", unique = true, nullable = false)
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	@Column(name= "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name= "TITLE", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name= "DETAIL", nullable = false)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Column(name= "PRICE", nullable = false)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Column(name= "SALE", nullable = false)
	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<ShoppingCartItem> getScitem() {
		return scitem;
	}

	public void setScitem(Set<ShoppingCartItem> scitem) {
		this.scitem = scitem;
	}

	@Override
	public String toString() {
		return "Products [productID=" + productID + ", name=" + name
				+ ", title=" + title + ", detail=" + detail + ", price="
				+ price + ", sale=" + sale + "]";
	}

}

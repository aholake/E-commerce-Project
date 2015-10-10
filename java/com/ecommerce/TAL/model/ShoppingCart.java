package com.ecommerce.TAL.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "shoppingcart", catalog = "ecommerce")
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	private int scartId;
	private Date date;
	private int sumMoney;

	private Account account;

	private Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>(0);

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(int scartId, Date date, int sumMoney) {
		super();
		this.scartId = scartId;
		this.date = date;
		this.sumMoney = sumMoney;
	}

	public ShoppingCart(int scartId, Date date, int sumMoney, Account account) {
		super();
		this.scartId = scartId;
		this.date = date;
		this.sumMoney = sumMoney;
		this.account = account;
	}

	public ShoppingCart(int scartId, Date date, int sumMoney, Account account,
			Set<ShoppingCartItem> shoppingCartItems) {
		super();
		this.scartId = scartId;
		this.date = date;
		this.sumMoney = sumMoney;
		this.account = account;
		this.shoppingCartItems = shoppingCartItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCART_ID", unique = true, nullable = false)
	public int getScartId() {
		return scartId;
	}

	public void setScartId(int scartId) {
		this.scartId = scartId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", nullable = false, length = 10)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "SUM_MONEY", nullable = false)
	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scart")
	public Set<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	@Override
	public String toString() {
		return "ShoppingCart [scartId=" + scartId + ", date=" + date
				+ ", sumMoney=" + sumMoney + ", account=" + account
				+ ", shoppingCartItems=" + shoppingCartItems + "]";
	}

}

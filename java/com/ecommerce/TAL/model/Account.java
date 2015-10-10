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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * Create by Nguyen Tuan Anh
 * Date 8/10/2015
 * Hibernate one to one relationship (account to account detail)
 */

@Entity
@Table(name = "account", catalog = "ecommerce", uniqueConstraints = { @UniqueConstraint(columnNames = "USERNAME") })
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountID;
	private String username;
	private String password;
	private boolean active;

	private AccountDetail accountDetail;

	private Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0);

	public Account() {
		super();
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Account(String username, String password, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Account(int accountID, String username, String password,
			AccountDetail accountDetail) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.accountDetail = accountDetail;
	}

	public Account(int accountID, String username, String password,
			boolean active, AccountDetail accountDetail,
			Set<ShoppingCart> shoppingCarts) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.active = active;
		this.accountDetail = accountDetail;
		this.shoppingCarts = shoppingCarts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ACTIVE", nullable = false)
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", username=" + username
				+ ", password=" + password + ", active=" + active
				+ ", accountDetail=" + accountDetail + "]";
	}

}

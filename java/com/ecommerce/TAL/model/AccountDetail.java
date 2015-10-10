package com.ecommerce.TAL.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*
 * Create by Nguyen Tuan Anh
 * Date 8/10/2015
 * Hibernate one to one relationship (account to account detail)
 */

@Entity
@Table(name = "accountdetail", catalog = "ecommerce")
public class AccountDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountId;
	private String fullName;
	private String email;
	private Date birthday;
	private int sex;
	private String phoneNumber;
	private String address;

	private Account account;

	public AccountDetail() {
		super();
	}

	public AccountDetail(String fullName, String email, Date birthday, int sex,
			String phoneNumber, String address) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public AccountDetail(int accountId, String fullName, String email,
			Date birthday, int sex, String phoneNumber, String address) {
		super();
		this.accountId = accountId;
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public AccountDetail(int accountId, String fullName, String email,
			Date birthday, int sex, String phoneNumber, String address,
			Account account) {
		super();
		this.accountId = accountId;
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.account = account;
	}

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "account"))
	@GeneratedValue(generator = "generator")
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name = "FULL_NAME", nullable = false, length = 100)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "EMAIL", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false, length = 10)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "SEX", nullable = false)
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "ADDRESS", nullable = false, length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountDetail [accountId=" + accountId + ", fullName="
				+ fullName + ", email=" + email + ", birthday=" + birthday
				+ ", sex=" + sex + ", phoneNumber=" + phoneNumber
				+ ", address=" + address+"]";
	}

}

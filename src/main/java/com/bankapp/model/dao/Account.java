package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account_table")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	private String name;
	
	private Double balance;
	private String address;
	private String phone;
	private String email;
	private String aadharCard;
	private String panNumber;
	
	
	@JoinColumn(name = "account_Id_fk")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TransactionEntry> transactionEntry = new ArrayList<TransactionEntry>();

	public Account() {
		
	}

	public Account(String name, Double balance, String address, String phone, String email, String aadharCard,
			String panNumber) {
		this.name = name;
		this.balance = balance;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.aadharCard = aadharCard;
		this.panNumber = panNumber;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public List<TransactionEntry> getTransactionEntry() {
		return transactionEntry;
	}

	public void setTransactionEntry(List<TransactionEntry> transactionEntry) {
		this.transactionEntry = transactionEntry;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", balance=" + balance + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", aadharCard=" + aadharCard + ", panNumber=" + panNumber
				+ ", transactionEntry=" + transactionEntry + "]";
	}

	
}

package com.bankapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "account_table")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	@NotEmpty(message = "Name can not be left blank")
	@Column(unique = true, nullable = false)
	private String name;
	
	@NotNull(message = "Balance can not be left blank")
	private Double balance;
	
	@NotEmpty(message = "Address can not be left blank")
	private String address;
	
	@NotEmpty(message = "Phone can not be left blank")
	private String phone;
	
	@NotEmpty(message = "Email can not be left blank")
	private String email;
	
	@Column(unique = true)
	@NotEmpty(message = "Aadhar can not be left blank")
	private String aadharCard;
	
	@NotEmpty(message = "Pan Number can not be left blank")
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
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", aadharCard=");
		builder.append(aadharCard);
		builder.append(", panNumber=");
		builder.append(panNumber);
		builder.append(", transactionEntry=");
		builder.append(transactionEntry);
		builder.append("]");
		return builder.toString();
	}
}
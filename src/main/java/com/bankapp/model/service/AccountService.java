package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts();
	
	public void deposit(int accountId, double amount);
	public void withdraw(int accountId, double amount);
	public void transfer(int fromAccountId, int toAccountId, double amount);
	
	public Account updateAccount(Account account);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	
}
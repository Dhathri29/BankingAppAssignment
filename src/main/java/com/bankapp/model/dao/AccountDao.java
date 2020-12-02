package com.bankapp.model.dao;

import java.util.List;

public interface AccountDao {
	
	public List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	
}

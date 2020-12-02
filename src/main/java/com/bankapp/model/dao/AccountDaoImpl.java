package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

	private SessionFactory factory;
	
	//constructor
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	//get session from Session Factory.
	private Session getSession() {
		return factory.getCurrentSession();
	}

	//List of all accounts 
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").getResultList();
	}

	
	//updating account 
	@Override
	public Account updateAccount(Account account) {
		Account accountToBeUpdated = getAccountById(account.getAccountId());
		getSession().update(accountToBeUpdated);
		return accountToBeUpdated;
	}

	//Deleting an account using Id which is a primary key
	@Override
	public Account deleteAccount(int accountId) {
		Account accountToBeDeleted = getAccountById(accountId);
		getSession().delete(accountToBeDeleted);
		return accountToBeDeleted;
	}

	
	//Getting account by id.
	@Override
	public Account getAccountById(int accountId) {
		Account account = getSession().get(Account.class, accountId);
		return account;
	}
	
	//Adding new account
	@Override
	public Account addAccount(Account account) {
		getSession().save(account);
		return account;
	}
	

}
package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

	private SessionFactory factory;
	
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").getResultList();
	}

	@Override
	public Account updateAccount(Account account) {

		Account accountToBeUpdated = getAccountById(account.getAccountId());
		
		accountToBeUpdated.setAddress(account.getAddress());
		accountToBeUpdated.setEmail(account.getEmail());
		accountToBeUpdated.setPhone(account.getPhone());
		getSession().update(accountToBeUpdated);
		
		getSession().update(account);
		
		
		return account;
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account accountToBeDeleted = getAccountById(accountId);
		getSession().update(accountToBeDeleted);
		return accountToBeDeleted;
	}

	@Override
	public Account getAccountById(int accountId) {
		Account account = getSession().get(Account.class, accountId);
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		getSession().save(account);
		return account;
	}
	

}
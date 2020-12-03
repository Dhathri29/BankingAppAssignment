package com.bankapp.model.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.TransactionEntry;
import com.bankapp.model.dao.TransactionEntryDao;
import com.bankapp.model.dao.TransactionType;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;
	public TransactionEntryDao transactionEntryDao;
	private TransactionEntryService transactionEntryService;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, TransactionEntryDao transactionEntryDao,
			TransactionEntryService transactionEntryService) {
		this.accountDao = accountDao;
		this.transactionEntryDao = transactionEntryDao;
		this.transactionEntryService = transactionEntryService;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account = accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
		account.setTransactionEntry(transactionEntryDao.getTransactionsById(accountId));
		
		TransactionEntry entry = new TransactionEntry("Deposited to " + accountId , amount, TransactionType.DEPOSIT);
		account.getTransactionEntry().add(entry);
		accountDao.updateAccount(account);
		
//		transactionEntryService.addTransaction("deposit to " + accountId , amount, TxType.DEPOSIT);
//		account.setTransactionEntry(Arrays.asList(transactionEntryDao.addTransaction("deposit to " + accountId , amount, TxType.WITHDRAW)));
		
	}


	@Override
	public void withdraw(int accountId, double amount) {
		Account account = accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
		
		TransactionEntry entry = new TransactionEntry("Withdraw from " + accountId , amount, TransactionType.WITHDRAW);
		account.getTransactionEntry().add(entry);
		accountDao.updateAccount(account);
	}
	
	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		Account fromAccount = accountDao.getAccountById(fromAccountId);
		Account toAccount = accountDao.getAccountById(toAccountId);
		
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
		
		TransactionEntry entryFrom = new TransactionEntry("Transferred from " + fromAccountId + " to " + toAccountId , amount, TransactionType.TRANSFER);
		TransactionEntry entryTo = new TransactionEntry("Credited to your account with account number " + toAccountId + " from account number " + fromAccountId , amount, TransactionType.TRANSFER);
		fromAccount.getTransactionEntry().add(entryFrom);
		toAccount.getTransactionEntry().add(entryTo);
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
		
		
	}

	@Override
	public Account updateAccount(Account account) {
		Account accountToBeUpdated = accountDao.getAccountById(account.getAccountId());
		accountToBeUpdated.setEmail(account.getEmail());
		accountToBeUpdated.setPhone(account.getPhone());
		accountToBeUpdated.setAddress(account.getAddress());
		accountDao.updateAccount(accountToBeUpdated);
		
		return accountToBeUpdated;
	}

	@Override
	public Account deleteAccount(int accountId) {
		return accountDao.deleteAccount(accountId);
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}
}
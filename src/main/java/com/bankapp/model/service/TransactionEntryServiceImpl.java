package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.TransactionEntry;
import com.bankapp.model.dao.TransactionEntryDao;
import com.bankapp.model.dao.TransactionType;

@Service("transactionEntryService")
@Transactional
public class TransactionEntryServiceImpl implements TransactionEntryService{

	private TransactionEntryDao transactionEntryDao;
	
	@Autowired
	public TransactionEntryServiceImpl(TransactionEntryDao transactionEntryDao) {
		super();
		this.transactionEntryDao = transactionEntryDao;
	}

	@Override
	public TransactionEntry addTransaction(String txInfo, Double amount, TransactionType txType) {
		return transactionEntryDao.addTransaction(txInfo, amount, txType);
	}



	@Override
	public List<TransactionEntry> getTransactionsById(int accountId) {
		return transactionEntryDao.getTransactionsById(accountId);
	}

}
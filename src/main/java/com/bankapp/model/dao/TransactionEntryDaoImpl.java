  
package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionEntryDaoImpl implements TransactionEntryDao{

	private SessionFactory factory;
	
	@Autowired
	public TransactionEntryDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public TransactionEntry addTransaction(String txInfo, Double amount, TransactionType txType) {
		TransactionEntry transactionEntry = new TransactionEntry(txInfo, amount, txType);
		getSession().save(transactionEntry);
		return transactionEntry;
	}

	@Override
	public List<TransactionEntry> getTransactionsById(int accountId) {
		List<TransactionEntry> transactionEntries = (List<TransactionEntry>) getSession().get(TransactionEntry.class, accountId);
		return transactionEntries;
	}
}
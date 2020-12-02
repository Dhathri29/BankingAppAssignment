  
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
	
	//Getting a session from session Factory.
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	//adding the transaction with info, amount and transactiontype.
	@Override
	public TransactionEntry addTransaction(String txInfo, Double amount, TransactionType txType) {
		TransactionEntry transactionEntry = new TransactionEntry(txInfo, amount, txType);
		getSession().save(transactionEntry);
		return transactionEntry;
	}

	//Getting transaction using id.
	@Override
	public List<TransactionEntry> getTransactionsById(int accountId) {
		List<TransactionEntry> transactionEntries = (List<TransactionEntry>) getSession().get(TransactionEntry.class, accountId);
		return transactionEntries;
	}
}
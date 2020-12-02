package com.bankapp.model.dao;

import java.util.List;

public interface TransactionEntryDao {

	public TransactionEntry addTransaction(String txInfo, Double amount, TransactionType txType);
	public List<TransactionEntry> getTransactionsById(int accountId);
	
}
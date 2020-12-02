package com.bankapp.model.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "transaction_table")
public class TransactionEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto generated
	private Integer txId;
	
    private String txInfo;
    
    @Temporal(TemporalType.TIME)
    private Date timestamp;
    
    private Double amount;
    
    //type of enum
    @Enumerated(EnumType.STRING)
    private TransactionType txType;
    
	public TransactionEntry() {
		
	}
	
	public TransactionEntry(Integer txId, String txInfo, Date timestamp, Double amount, TransactionType txType) {
		super();
		this.txId = txId;
		this.txInfo = txInfo;
		this.timestamp = timestamp;
		this.amount = amount;
		this.txType = txType;
	}

	public TransactionEntry(String txInfo,  Double amount, TransactionType txType) {
		super();
		this.txInfo = txInfo;
		this.amount = amount;
		this.txType = txType;
	}




	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	public String getTxInfo() {
		return txInfo;
	}

	public void setTxInfo(String txInfo) {
		this.txInfo = txInfo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	public TransactionType getTxType() {
		return txType;
	}

	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}

	@Override
	public String toString() {
		return "TransactionEntry [txId=" + txId + ", txInfo=" + txInfo + ", timestamp=" + timestamp + ", amount="
				+ amount + "]";
	}
	
	
}
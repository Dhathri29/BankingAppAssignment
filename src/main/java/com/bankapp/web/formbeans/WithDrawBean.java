package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

public class WithDrawBean {
	
	@NotNull(message = "Account id can not be left blank")
	private Integer accountId;
	
	@NotNull(message = "Amount can not be left blank")
	private Double amount;
	
	public WithDrawBean(Integer accountId, Double amount) {
		
		this.accountId = accountId;
		this.amount = amount;
	}
	
	public WithDrawBean() {
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "WithdrawBean [accountId=" + accountId + ", amount=" + amount + "]";
	}
	
}
package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

public class TransferBean {
	
	@NotNull(message = "From account id can not be left blank")
	private Integer fromAccountId;
	
	@NotNull(message = "To account id can not be left blank")
	private Integer toAccountId;
	
	@NotNull(message = "Amount can not be left blank")
	private Double amount;
	
	public TransferBean() {
	}

	public Integer getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransferBean(Integer fromAccountId, Integer toAccountId, Double amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
}
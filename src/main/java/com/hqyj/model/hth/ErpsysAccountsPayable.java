package com.hqyj.model.hth;

import java.util.Date;

public class ErpsysAccountsPayable {
	private Integer accountsPayableId;

	private String accountsPayableName;

	private Double accountsPayableMoney;

	private String accountsReceiver;

	private Date accountsRecordTime;

	private String accountsRecordTimeString;

	private Integer alreadyPaid;

	private Date payTime;

	private String payTimeString;

	public Integer getAccountsPayableId() {
		return accountsPayableId;
	}

	public void setAccountsPayableId(Integer accountsPayableId) {
		this.accountsPayableId = accountsPayableId;
	}

	public String getAccountsPayableName() {
		return accountsPayableName;
	}

	public void setAccountsPayableName(String accountsPayableName) {
		this.accountsPayableName = accountsPayableName;
	}

	public Double getAccountsPayableMoney() {
		return accountsPayableMoney;
	}

	public void setAccountsPayableMoney(Double accountsPayableMoney) {
		this.accountsPayableMoney = accountsPayableMoney;
	}

	public String getAccountsReceiver() {
		return accountsReceiver;
	}

	public void setAccountsReceiver(String accountsReceiver) {
		this.accountsReceiver = accountsReceiver;
	}

	public Date getAccountsRecordTime() {
		return accountsRecordTime;
	}

	public void setAccountsRecordTime(Date accountsRecordTime) {
		this.accountsRecordTime = accountsRecordTime;
	}

	public Integer getAlreadyPaid() {
		return alreadyPaid;
	}

	public void setAlreadyPaid(Integer alreadyPaid) {
		this.alreadyPaid = alreadyPaid;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getAccountsRecordTimeString() {
		return accountsRecordTimeString;
	}

	public void setAccountsRecordTimeString(String accountsRecordTimeString) {
		this.accountsRecordTimeString = accountsRecordTimeString;
	}

	public String getPayTimeString() {
		return payTimeString;
	}

	public void setPayTimeString(String payTimeString) {
		this.payTimeString = payTimeString;
	}

	
}
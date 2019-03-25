package com.hqyj.model.hth;

import java.util.Date;

public class ErpsysAccountsReceivable {
    private Integer accountsReceivableId;

    private String accountsReceivableName;

    private Double accountsReceivableMoney;

    private String accountsPayer;

    private Date accountsRecordTime;
    
    private String accountsRecordTimeString;

    private Integer alreadyReceived;

    private Date paymentTime;
    
    private String paymentTimeString;

    public Integer getAccountsReceivableId() {
        return accountsReceivableId;
    }

    public void setAccountsReceivableId(Integer accountsReceivableId) {
        this.accountsReceivableId = accountsReceivableId;
    }

    public String getAccountsReceivableName() {
        return accountsReceivableName;
    }

    public void setAccountsReceivableName(String accountsReceivableName) {
        this.accountsReceivableName = accountsReceivableName;
    }

    public Double getAccountsReceivableMoney() {
        return accountsReceivableMoney;
    }

    public void setAccountsReceivableMoney(Double accountsReceivableMoney) {
        this.accountsReceivableMoney = accountsReceivableMoney;
    }

    public String getAccountsPayer() {
        return accountsPayer;
    }

    public void setAccountsPayer(String accountsPayer) {
        this.accountsPayer = accountsPayer;
    }

    public Date getAccountsRecordTime() {
        return accountsRecordTime;
    }

    public void setAccountsRecordTime(Date accountsRecordTime) {
        this.accountsRecordTime = accountsRecordTime;
    }

    public Integer getAlreadyReceived() {
        return alreadyReceived;
    }

    public void setAlreadyReceived(Integer alreadyReceived) {
        this.alreadyReceived = alreadyReceived;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

	public String getAccountsRecordTimeString() {
		return accountsRecordTimeString;
	}

	public void setAccountsRecordTimeString(String accountsRecordTimeString) {
		this.accountsRecordTimeString = accountsRecordTimeString;
	}

	public String getPaymentTimeString() {
		return paymentTimeString;
	}

	public void setPaymentTimeString(String paymentTimeString) {
		this.paymentTimeString = paymentTimeString;
	}

	@Override
	public String toString() {
		return "ErpsysAccountsReceivable [accountsReceivableId=" + accountsReceivableId + ", accountsReceivableName="
				+ accountsReceivableName + ", accountsReceivableMoney=" + accountsReceivableMoney + ", accountsPayer="
				+ accountsPayer + ", accountsRecordTime=" + accountsRecordTime + ", accountsRecordTimeString="
				+ accountsRecordTimeString + ", alreadyReceived=" + alreadyReceived + ", paymentTime=" + paymentTime
				+ ", paymentTimeString=" + paymentTimeString + "]";
	}
    
	
    
}
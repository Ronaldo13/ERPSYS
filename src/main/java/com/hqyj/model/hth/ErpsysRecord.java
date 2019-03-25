package com.hqyj.model.hth;

import java.util.Date;

public class ErpsysRecord {
    private Integer recordId;

    private Double recordMoney;

    private String recordReason;

    private Date recordTime;
    
    private String recordTimeString;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Double getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(Double recordMoney) {
        this.recordMoney = recordMoney;
    }

    public String getRecordReason() {
        return recordReason;
    }

    public void setRecordReason(String recordReason) {
        this.recordReason = recordReason;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

	public String getRecordTimeString() {
		return recordTimeString;
	}

	public void setRecordTimeString(String recordTimeString) {
		this.recordTimeString = recordTimeString;
	}

	@Override
	public String toString() {
		return "ErpsysRecord [recordId=" + recordId + ", recordMoney=" + recordMoney + ", recordReason=" + recordReason
				+ ", recordTime=" + recordTime + ", recordTimeString=" + recordTimeString + "]";
	}

	
    
    
}
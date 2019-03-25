package com.hqyj.model.xsh;

import java.util.Date;

public class ErpsysSellLog {
    private Integer sellLogId;

	private String buyer;

	private Date sellTime;

	private Integer sellNumber;

	private Integer outWarehouseLogId;

	private Integer orderId;

	public Integer getSellLogId() {
		return sellLogId;
	}

	public void setSellLogId(Integer sellLogId) {
		this.sellLogId = sellLogId;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Date getSellTime() {
		return sellTime;
	}

	public void setSellTime(Date sellTime) {
		this.sellTime = sellTime;
	}

	public Integer getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(Integer sellNumber) {
		this.sellNumber = sellNumber;
	}

	public Integer getOutWarehouseLogId() {
		return outWarehouseLogId;
	}

	public void setOutWarehouseLogId(Integer outWarehouseLogId) {
		this.outWarehouseLogId = outWarehouseLogId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
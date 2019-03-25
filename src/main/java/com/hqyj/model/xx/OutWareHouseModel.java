package com.hqyj.model.xx;

import java.util.Date;

public class OutWareHouseModel {
    private Integer outWarehouseLogId;

    private Integer productionWarehouseId;

    private Date outWarehouseTime;

    private String outWarehouseReason;

    private Integer outWarehouseNumber;

    private Integer orderId;

    private String outWarehouseStatus;

    public Integer getOutWarehouseLogId() {
        return outWarehouseLogId;
    }

    public void setOutWarehouseLogId(Integer outWarehouseLogId) {
        this.outWarehouseLogId = outWarehouseLogId;
    }

    public Integer getProductionWarehouseId() {
        return productionWarehouseId;
    }

    public void setProductionWarehouseId(Integer productionWarehouseId) {
        this.productionWarehouseId = productionWarehouseId;
    }

    public Date getOutWarehouseTime() {
        return outWarehouseTime;
    }

    public void setOutWarehouseTime(Date outWarehouseTime) {
        this.outWarehouseTime = outWarehouseTime;
    }

    public String getOutWarehouseReason() {
        return outWarehouseReason;
    }

    public void setOutWarehouseReason(String outWarehouseReason) {
        this.outWarehouseReason = outWarehouseReason;
    }

    public Integer getOutWarehouseNumber() {
        return outWarehouseNumber;
    }

    public void setOutWarehouseNumber(Integer outWarehouseNumber) {
        this.outWarehouseNumber = outWarehouseNumber;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOutWarehouseStatus() {
        return outWarehouseStatus;
    }

    public void setOutWarehouseStatus(String outWarehouseStatus) {
        this.outWarehouseStatus = outWarehouseStatus;
    }
    
}
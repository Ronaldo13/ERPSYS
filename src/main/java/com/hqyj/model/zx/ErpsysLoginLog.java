package com.hqyj.model.zx;

import java.util.Date;

public class ErpsysLoginLog {
    private Integer erpsysLoginlogId;

    private String erpsysLoginAccountId;

    private Date erpsysLoginDate;

    private String erpsysLoginState;

    public Integer getErpsysLoginlogId() {
        return erpsysLoginlogId;
    }

    public void setErpsysLoginlogId(Integer erpsysLoginlogId) {
        this.erpsysLoginlogId = erpsysLoginlogId;
    }

    public String getErpsysLoginAccountId() {
        return erpsysLoginAccountId;
    }

    public void setErpsysLoginAccountId(String erpsysLoginAccountId) {
        this.erpsysLoginAccountId = erpsysLoginAccountId;
    }

    public Date getErpsysLoginDate() {
        return erpsysLoginDate;
    }

    public void setErpsysLoginDate(Date erpsysLoginDate) {
        this.erpsysLoginDate = erpsysLoginDate;
    }

    public String getErpsysLoginState() {
        return erpsysLoginState;
    }

    public void setErpsysLoginState(String erpsysLoginState) {
        this.erpsysLoginState = erpsysLoginState;
    }
}
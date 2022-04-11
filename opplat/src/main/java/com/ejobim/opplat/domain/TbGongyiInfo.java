package com.ejobim.opplat.domain;

import java.util.Date;

public class TbGongyiInfo {
    private String gongyiNo;

    private String gongyiName;

    private String gongyiCreateUser;

    private Date gongyiCreateTime;

    private String gongyiUpdateUser;

    private Date gongyiUpdtateTime;

    private String gongyiFactoryNo;

    private Integer gongyiIndex;

    public String getGongyiNo() {
        return gongyiNo;
    }

    public void setGongyiNo(String gongyiNo) {
        this.gongyiNo = gongyiNo == null ? null : gongyiNo.trim();
    }

    public String getGongyiName() {
        return gongyiName;
    }

    public void setGongyiName(String gongyiName) {
        this.gongyiName = gongyiName == null ? null : gongyiName.trim();
    }

    public String getGongyiCreateUser() {
        return gongyiCreateUser;
    }

    public void setGongyiCreateUser(String gongyiCreateUser) {
        this.gongyiCreateUser = gongyiCreateUser == null ? null : gongyiCreateUser.trim();
    }

    public Date getGongyiCreateTime() {
        return gongyiCreateTime;
    }

    public void setGongyiCreateTime(Date gongyiCreateTime) {
        this.gongyiCreateTime = gongyiCreateTime;
    }

    public String getGongyiUpdateUser() {
        return gongyiUpdateUser;
    }

    public void setGongyiUpdateUser(String gongyiUpdateUser) {
        this.gongyiUpdateUser = gongyiUpdateUser == null ? null : gongyiUpdateUser.trim();
    }

    public Date getGongyiUpdtateTime() {
        return gongyiUpdtateTime;
    }

    public void setGongyiUpdtateTime(Date gongyiUpdtateTime) {
        this.gongyiUpdtateTime = gongyiUpdtateTime;
    }

    public String getGongyiFactoryNo() {
        return gongyiFactoryNo;
    }

    public void setGongyiFactoryNo(String gongyiFactoryNo) {
        this.gongyiFactoryNo = gongyiFactoryNo == null ? null : gongyiFactoryNo.trim();
    }

    public Integer getGongyiIndex() {
        return gongyiIndex;
    }

    public void setGongyiIndex(Integer gongyiIndex) {
        this.gongyiIndex = gongyiIndex;
    }
}
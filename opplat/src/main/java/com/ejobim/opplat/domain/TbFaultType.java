package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFaultType {
    private String faultNo;

    private String faultName;

    private String factoryNo;

    private String equipTypeNo;

    private String equipTypeName;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    public String getFaultNo() {
        return faultNo;
    }

    public void setFaultNo(String faultNo) {
        this.faultNo = faultNo == null ? null : faultNo.trim();
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName == null ? null : faultName.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getEquipTypeNo() {
        return equipTypeNo;
    }

    public void setEquipTypeNo(String equipTypeNo) {
        this.equipTypeNo = equipTypeNo == null ? null : equipTypeNo.trim();
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName == null ? null : equipTypeName.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}
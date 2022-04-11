package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbEquipMaintainFactor {
    private String mfNo;

    private String equipNo;

    private String factoryNo;

    private String mfContent;

    private Integer mfType;

    private Integer cycle;

    private String mfAddon;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private Integer flag;

    private Date mfTime;

    private String equipName;

    private String mfTimeName;

    //0是 1:否
    private Integer  whether;

    public String getMfNo() {
        return mfNo;
    }

    public void setMfNo(String mfNo) {
        this.mfNo = mfNo == null ? null : mfNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getMfContent() {
        return mfContent;
    }

    public void setMfContent(String mfContent) {
        this.mfContent = mfContent == null ? null : mfContent.trim();
    }

    public Integer getMfType() {
        return mfType;
    }

    public void setMfType(Integer mfType) {
        this.mfType = mfType;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getMfAddon() {
        return mfAddon;
    }

    public void setMfAddon(String mfAddon) {
        this.mfAddon = mfAddon == null ? null : mfAddon.trim();
    }

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getMfTime() {
        return mfTime;
    }

    public void setMfTime(Date mfTime) {
        this.mfTime = mfTime;
    }
    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getMfTimeName() {
        return mfTimeName;
    }

    public void setMfTimeName(String mfTimeName) {
        this.mfTimeName = mfTimeName;
    }
}
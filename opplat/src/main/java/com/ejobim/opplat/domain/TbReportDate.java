package com.ejobim.opplat.domain;

import java.util.Date;

public class TbReportDate {
    private String drNo;

    private Date drDate;

    private Float drValue;

    private String drBrowseName;

    private String drDisplayName;

    private String drUnit;

    private Date drCreateTime;

    private String drFactoryNo;

    private String drEquipNo;

    private String drEquipName;

    private Integer drDataType;

    private String drFillNo;

    public String getDrNo() {
        return drNo;
    }

    public void setDrNo(String drNo) {
        this.drNo = drNo == null ? null : drNo.trim();
    }

    public Date getDrDate() {
        return drDate;
    }

    public void setDrDate(Date drDate) {
        this.drDate = drDate;
    }

    public Float getDrValue() {
        return drValue;
    }

    public void setDrValue(Float drValue) {
        this.drValue = drValue;
    }

    public String getDrBrowseName() {
        return drBrowseName;
    }

    public void setDrBrowseName(String drBrowseName) {
        this.drBrowseName = drBrowseName == null ? null : drBrowseName.trim();
    }

    public String getDrDisplayName() {
        return drDisplayName;
    }

    public void setDrDisplayName(String drDisplayName) {
        this.drDisplayName = drDisplayName == null ? null : drDisplayName.trim();
    }

    public String getDrUnit() {
        return drUnit;
    }

    public void setDrUnit(String drUnit) {
        this.drUnit = drUnit == null ? null : drUnit.trim();
    }

    public Date getDrCreateTime() {
        return drCreateTime;
    }

    public void setDrCreateTime(Date drCreateTime) {
        this.drCreateTime = drCreateTime;
    }

    public String getDrFactoryNo() {
        return drFactoryNo;
    }

    public void setDrFactoryNo(String drFactoryNo) {
        this.drFactoryNo = drFactoryNo == null ? null : drFactoryNo.trim();
    }

    public String getDrEquipNo() {
        return drEquipNo;
    }

    public void setDrEquipNo(String drEquipNo) {
        this.drEquipNo = drEquipNo == null ? null : drEquipNo.trim();
    }

    public String getDrEquipName() {
        return drEquipName;
    }

    public void setDrEquipName(String drEquipName) {
        this.drEquipName = drEquipName == null ? null : drEquipName.trim();
    }

    public Integer getDrDataType() {
        return drDataType;
    }

    public void setDrDataType(Integer drDataType) {
        this.drDataType = drDataType;
    }

    public String getDrFillNo() {
        return drFillNo;
    }

    public void setDrFillNo(String drFillNo) {
        this.drFillNo = drFillNo == null ? null : drFillNo.trim();
    }
}
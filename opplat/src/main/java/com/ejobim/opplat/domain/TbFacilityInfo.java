package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFacilityInfo {
    private String fatiNo;

    private String fatiUri;

    private String fatiFactoryNo;

    private String fatiName;

    private String fatiBrowseName;

    private String fatiCode;

    private String fatiGongyi;

    private Integer fatiNum;

    private String fatiUnit;

    private Integer fatiType;

    private Date fatiInitDate;

    private String fatiDesignOrg;

    private String fatiBuildOrg;

    private Integer fatiManagerStatus;

    private String fatiDescription;

    private Date fatiCreateTime;

    private String fatiCreateUserCode;

    private String fatiCreateUserName;

    private String fatiGongyiName;

    public String getFatiNo() {
        return fatiNo;
    }

    public void setFatiNo(String fatiNo) {
        this.fatiNo = fatiNo == null ? null : fatiNo.trim();
    }

    public String getFatiUri() {
        return fatiUri;
    }

    public void setFatiUri(String fatiUri) {
        this.fatiUri = fatiUri == null ? null : fatiUri.trim();
    }

    public String getFatiFactoryNo() {
        return fatiFactoryNo;
    }

    public void setFatiFactoryNo(String fatiFactoryNo) {
        this.fatiFactoryNo = fatiFactoryNo == null ? null : fatiFactoryNo.trim();
    }

    public String getFatiName() {
        return fatiName;
    }

    public void setFatiName(String fatiName) {
        this.fatiName = fatiName == null ? null : fatiName.trim();
    }

    public String getFatiBrowseName() {
        return fatiBrowseName;
    }

    public void setFatiBrowseName(String fatiBrowseName) {
        this.fatiBrowseName = fatiBrowseName == null ? null : fatiBrowseName.trim();
    }

    public String getFatiCode() {
        return fatiCode;
    }

    public void setFatiCode(String fatiCode) {
        this.fatiCode = fatiCode == null ? null : fatiCode.trim();
    }

    public String getFatiGongyi() {
        return fatiGongyi;
    }

    public void setFatiGongyi(String fatiGongyi) {
        this.fatiGongyi = fatiGongyi == null ? null : fatiGongyi.trim();
    }

    public Integer getFatiNum() {
        return fatiNum;
    }

    public void setFatiNum(Integer fatiNum) {
        this.fatiNum = fatiNum;
    }

    public String getFatiUnit() {
        return fatiUnit;
    }

    public void setFatiUnit(String fatiUnit) {
        this.fatiUnit = fatiUnit == null ? null : fatiUnit.trim();
    }

    public Integer getFatiType() {
        return fatiType;
    }

    public void setFatiType(Integer fatiType) {
        this.fatiType = fatiType;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getFatiInitDate() {
        return fatiInitDate;
    }

    public void setFatiInitDate(Date fatiInitDate) {
        this.fatiInitDate = fatiInitDate;
    }

    public String getFatiDesignOrg() {
        return fatiDesignOrg;
    }

    public void setFatiDesignOrg(String fatiDesignOrg) {
        this.fatiDesignOrg = fatiDesignOrg == null ? null : fatiDesignOrg.trim();
    }

    public String getFatiBuildOrg() {
        return fatiBuildOrg;
    }

    public void setFatiBuildOrg(String fatiBuildOrg) {
        this.fatiBuildOrg = fatiBuildOrg == null ? null : fatiBuildOrg.trim();
    }

    public Integer getFatiManagerStatus() {
        return fatiManagerStatus;
    }

    public void setFatiManagerStatus(Integer fatiManagerStatus) {
        this.fatiManagerStatus = fatiManagerStatus;
    }

    public String getFatiDescription() {
        return fatiDescription;
    }

    public void setFatiDescription(String fatiDescription) {
        this.fatiDescription = fatiDescription == null ? null : fatiDescription.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getFatiCreateTime() {
        return fatiCreateTime;
    }

    public void setFatiCreateTime(Date fatiCreateTime) {
        this.fatiCreateTime = fatiCreateTime;
    }

    public String getFatiCreateUserCode() {
        return fatiCreateUserCode;
    }

    public void setFatiCreateUserCode(String fatiCreateUserCode) {
        this.fatiCreateUserCode = fatiCreateUserCode == null ? null : fatiCreateUserCode.trim();
    }

    public String getFatiCreateUserName() {
        return fatiCreateUserName;
    }

    public void setFatiCreateUserName(String fatiCreateUserName) {
        this.fatiCreateUserName = fatiCreateUserName == null ? null : fatiCreateUserName.trim();
    }

    public String getFatiGongyiName() {
        return fatiGongyiName;
    }

    public void setFatiGongyiName(String fatiGongyiName) {
        this.fatiGongyiName = fatiGongyiName == null ? null : fatiGongyiName.trim();
    }
}
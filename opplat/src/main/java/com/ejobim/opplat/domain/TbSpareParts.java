package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbSpareParts {
    private String sparePartsNo;

    private String sparePartsName;

    private String sparePartsMode;

    private String sparePartsDescribe;

    private Integer sparePartsCount;

    private String storeRoomNo;

    private String sparePartsCode;

    private String sparePartsType;

    private String equipType;

    private Date createTime;

    private String producter;

    private String sparetPartsUnit;

    private String factoryNo;

    private Date startTime;

    private String creaetUser;

    private String equipTypeName;

    public String getSparePartsNo() {
        return sparePartsNo;
    }

    public void setSparePartsNo(String sparePartsNo) {
        this.sparePartsNo = sparePartsNo == null ? null : sparePartsNo.trim();
    }

    public String getSparePartsName() {
        return sparePartsName;
    }

    public void setSparePartsName(String sparePartsName) {
        this.sparePartsName = sparePartsName == null ? null : sparePartsName.trim();
    }

    public String getSparePartsMode() {
        return sparePartsMode;
    }

    public void setSparePartsMode(String sparePartsMode) {
        this.sparePartsMode = sparePartsMode == null ? null : sparePartsMode.trim();
    }

    public String getSparePartsDescribe() {
        return sparePartsDescribe;
    }

    public void setSparePartsDescribe(String sparePartsDescribe) {
        this.sparePartsDescribe = sparePartsDescribe == null ? null : sparePartsDescribe.trim();
    }

    public Integer getSparePartsCount() {
        return sparePartsCount;
    }

    public void setSparePartsCount(Integer sparePartsCount) {
        this.sparePartsCount = sparePartsCount;
    }

    public String getStoreRoomNo() {
        return storeRoomNo;
    }

    public void setStoreRoomNo(String storeRoomNo) {
        this.storeRoomNo = storeRoomNo == null ? null : storeRoomNo.trim();
    }

    public String getSparePartsCode() {
        return sparePartsCode;
    }

    public void setSparePartsCode(String sparePartsCode) {
        this.sparePartsCode = sparePartsCode == null ? null : sparePartsCode.trim();
    }

    public String getSparePartsType() {
        return sparePartsType;
    }

    public void setSparePartsType(String sparePartsType) {
        this.sparePartsType = sparePartsType == null ? null : sparePartsType.trim();
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter == null ? null : producter.trim();
    }

    public String getSparetPartsUnit() {
        return sparetPartsUnit;
    }

    public void setSparetPartsUnit(String sparetPartsUnit) {
        this.sparetPartsUnit = sparetPartsUnit == null ? null : sparetPartsUnit.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCreaetUser() {
        return creaetUser;
    }

    public void setCreaetUser(String creaetUser) {
        this.creaetUser = creaetUser == null ? null : creaetUser.trim();
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName == null ? null : equipTypeName.trim();
    }
}
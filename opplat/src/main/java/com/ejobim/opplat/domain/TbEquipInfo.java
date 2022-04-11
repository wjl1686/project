package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbEquipInfo {
    private String equipNo;

    private String equipUri;

    private String equipType;

    private String equipMode;

    private String equipDescribe;

    private Double equipPower;

    private String assetType;

    private Double assetValue;

    private Double assetNetValue;

    private String installationSite;

    private String installationSiteName;

    private String installationLocation;

    private String supplier;

    private String serviceTelephone;

    private String manufacturer;

    private String purchaseNo;

    private Date purchaseDate;

    private String purchaseDateName;

    private Date invocationDate;

    private String invocationDateName;

    private String maintenancePeriod;

    private Integer expirationYear;

    private Integer equipStatus;

    private String equipStatusName;

    private String equipPicture;

    private String factoryNo;

    private String equipName;

    private String equipCode;

    private String equipMainType;

    private Date startDate;

    private String startDateName;
    //设备类型名称
    private String equipTypeName;

    private Date updateTime;

    private String updateUser;

    private String equipTypeCode;

    private Integer equipSort;

    private Integer equipNewType;

    private String equipNewTypeName;

    private List<TbEquipHistroy> tbEquipHistroyList;

    private  List<TbDict> tbDicts;

    private List<TbEquipType> equipTypeList;
    
    private String factoryCode;

    private String issueNo;

    private String equipNameS;

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }

    public String getEquipMode() {
        return equipMode;
    }

    public void setEquipMode(String equipMode) {
        this.equipMode = equipMode == null ? null : equipMode.trim();
    }

    public String getEquipDescribe() {
        return equipDescribe;
    }

    public void setEquipDescribe(String equipDescribe) {
        this.equipDescribe = equipDescribe;
    }

    public Double getEquipPower() {
        return equipPower;
    }

    public void setEquipPower(Double equipPower) {
        this.equipPower = equipPower;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public Double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(Double assetValue) {
        this.assetValue = assetValue;
    }

    public Double getAssetNetValue() {
        return assetNetValue;
    }

    public void setAssetNetValue(Double assetNetValue) {
        this.assetNetValue = assetNetValue;
    }

    public String getInstallationSite() {
        return installationSite;
    }

    public void setInstallationSite(String installationSite) {
        this.installationSite = installationSite == null ? null : installationSite.trim();
    }

    public String getInstallationLocation() {
        return installationLocation;
    }

    public void setInstallationLocation(String installationLocation) {
        this.installationLocation = installationLocation == null ? null : installationLocation.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getServiceTelephone() {
        return serviceTelephone;
    }

    public void setServiceTelephone(String serviceTelephone) {
        this.serviceTelephone = serviceTelephone == null ? null : serviceTelephone.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getInvocationDate() {
        return invocationDate;
    }

    public void setInvocationDate(Date invocationDate) {
        this.invocationDate = invocationDate;
    }

    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    public String getEquipPicture() {
        return equipPicture;
    }

    public void setEquipPicture(String equipPicture) {
        this.equipPicture = equipPicture == null ? null : equipPicture.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode == null ? null : equipCode.trim();
    }

    public String getEquipMainType() {
        return equipMainType;
    }

    public void setEquipMainType(String equipMainType) {
        this.equipMainType = equipMainType == null ? null : equipMainType.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getInstallationSiteName() {
        return installationSiteName;
    }

    public void setInstallationSiteName(String installationSiteName) {
        this.installationSiteName = installationSiteName;
    }

    public List<TbEquipHistroy> getTbEquipHistroyList() {
        return tbEquipHistroyList;
    }

    public void setTbEquipHistroyList(List<TbEquipHistroy> tbEquipHistroyList) {
        this.tbEquipHistroyList = tbEquipHistroyList;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getEquipTypeCode() {
        return equipTypeCode;
    }

    public void setEquipTypeCode(String equipTypeCode) {
        this.equipTypeCode = equipTypeCode == null ? null : equipTypeCode.trim();
    }

    public Integer getEquipSort() {
        return equipSort;
    }

    public void setEquipSort(Integer equipSort) {
        this.equipSort = equipSort;
    }

    public Integer getEquipNewType() {
        return equipNewType;
    }

    public void setEquipNewType(Integer equipNewType) {
        this.equipNewType = equipNewType;
    }

    public String getPurchaseDateName() {
        return purchaseDateName;
    }

    public void setPurchaseDateName(String purchaseDateName) {
        this.purchaseDateName = purchaseDateName;
    }

    public String getInvocationDateName() {
        return invocationDateName;
    }

    public void setInvocationDateName(String invocationDateName) {
        this.invocationDateName = invocationDateName;
    }

    public String getEquipStatusName() {
        return equipStatusName;
    }

    public void setEquipStatusName(String equipStatusName) {
        this.equipStatusName = equipStatusName;
    }

    public String getStartDateName() {
        return startDateName;
    }

    public void setStartDateName(String startDateName) {
        this.startDateName = startDateName;
    }

    public String getEquipNewTypeName() {
        return equipNewTypeName;
    }

    public void setEquipNewTypeName(String equipNewTypeName) {
        this.equipNewTypeName = equipNewTypeName;
    }

    public List<TbDict> getTbDicts() {
        return tbDicts;
    }

    public void setTbDicts(List<TbDict> tbDicts) {
        this.tbDicts = tbDicts;
    }

    public List<TbEquipType> getEquipTypeList() {
        return equipTypeList;
    }

    public void setEquipTypeList(List<TbEquipType> equipTypeList) {
        this.equipTypeList = equipTypeList;
    }


    public String getEquipUri() {
        return equipUri;
    }

    public void setEquipUri(String equipUri) {
        this.equipUri = equipUri;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo == null ? null : issueNo.trim();
    }

    public String getEquipNameS() {
        return equipNameS;
    }

    public void setEquipNameS(String equipNameS) {
        this.equipNameS = equipNameS;
    }
}
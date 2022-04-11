package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFactoryInfoExtend {
    private String factoryNo;

    private Double planningScale;

    private Double contractScale;

    private Double powerRate;

    private Double powerScale;

    private Double buileScale;

    private Double holdScale;

    private Double holdMaintain;

    private Double servicePopulation;

    private Double serviceArea;

    private Double industrialWasteRate;

    private String coreProcess;

    private String waterQualityNormOut;

    private Double contractPeriod;

    private Double keepWaterVolume;

    private Double contractUnitPrice;

    private String filledAccount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Double getPlanningScale() {
        return planningScale;
    }

    public void setPlanningScale(Double planningScale) {
        this.planningScale = planningScale;
    }

    public Double getContractScale() {
        return contractScale;
    }

    public void setContractScale(Double contractScale) {
        this.contractScale = contractScale;
    }

    public Double getPowerRate() {
        return powerRate;
    }

    public void setPowerRate(Double powerRate) {
        this.powerRate = powerRate;
    }

    public Double getPowerScale() {
        return powerScale;
    }

    public void setPowerScale(Double powerScale) {
        this.powerScale = powerScale;
    }

    public Double getBuileScale() {
        return buileScale;
    }

    public void setBuileScale(Double buileScale) {
        this.buileScale = buileScale;
    }

    public Double getHoldScale() {
        return holdScale;
    }

    public void setHoldScale(Double holdScale) {
        this.holdScale = holdScale;
    }

    public Double getHoldMaintain() {
        return holdMaintain;
    }

    public void setHoldMaintain(Double holdMaintain) {
        this.holdMaintain = holdMaintain;
    }

    public Double getServicePopulation() {
        return servicePopulation;
    }

    public void setServicePopulation(Double servicePopulation) {
        this.servicePopulation = servicePopulation;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getIndustrialWasteRate() {
        return industrialWasteRate;
    }

    public void setIndustrialWasteRate(Double industrialWasteRate) {
        this.industrialWasteRate = industrialWasteRate;
    }

    public String getCoreProcess() {
        return coreProcess;
    }

    public void setCoreProcess(String coreProcess) {
        this.coreProcess = coreProcess == null ? null : coreProcess.trim();
    }

    public String getWaterQualityNormOut() {
        return waterQualityNormOut;
    }

    public void setWaterQualityNormOut(String waterQualityNormOut) {
        this.waterQualityNormOut = waterQualityNormOut == null ? null : waterQualityNormOut.trim();
    }

    public Double getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Double contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Double getKeepWaterVolume() {
        return keepWaterVolume;
    }

    public void setKeepWaterVolume(Double keepWaterVolume) {
        this.keepWaterVolume = keepWaterVolume;
    }

    public Double getContractUnitPrice() {
        return contractUnitPrice;
    }

    public void setContractUnitPrice(Double contractUnitPrice) {
        this.contractUnitPrice = contractUnitPrice;
    }

    public String getFilledAccount() {
        return filledAccount;
    }

    public void setFilledAccount(String filledAccount) {
        this.filledAccount = filledAccount == null ? null : filledAccount.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

public class TbEquipOverhaulInfo implements WorkFlowExtendI {
    private String overhaulDetailNo;

    private String extendNo;

    private String suggestSparepartLists;

    private String sparepartLists;

    private String suggestInfo;

    private String overhaulPictures;

    private String overhaulVideo;

    private Integer overhaulSanitationOk;

    private Integer overhaulAppearanceOk;

    private Integer overhaulConversionOk;

    private Integer overhaulSoundOk;

    private Integer overhaulTempOk;

    private Integer overhaulElectricCurrent;

    private String detailParty;

    private String contractNo;

    private String overhaulContent;

    private Integer equipStatus;

    private Double planCost;

    private Double realCost;

    private Double taxRate;

    public String getOverhaulDetailNo() {
        return overhaulDetailNo;
    }

    public void setOverhaulDetailNo(String overhaulDetailNo) {
        this.overhaulDetailNo = overhaulDetailNo == null ? null : overhaulDetailNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getSuggestSparepartLists() {
        return suggestSparepartLists;
    }

    public void setSuggestSparepartLists(String suggestSparepartLists) {
        this.suggestSparepartLists = suggestSparepartLists == null ? null : suggestSparepartLists.trim();
    }

    public String getSparepartLists() {
        return sparepartLists;
    }

    public void setSparepartLists(String sparepartLists) {
        this.sparepartLists = sparepartLists == null ? null : sparepartLists.trim();
    }

    public String getSuggestInfo() {
        return suggestInfo;
    }

    public void setSuggestInfo(String suggestInfo) {
        this.suggestInfo = suggestInfo == null ? null : suggestInfo.trim();
    }

    public String getOverhaulPictures() {
        return overhaulPictures;
    }

    public void setOverhaulPictures(String overhaulPictures) {
        this.overhaulPictures = overhaulPictures == null ? null : overhaulPictures.trim();
    }

    public String getOverhaulVideo() {
        return overhaulVideo;
    }

    public void setOverhaulVideo(String overhaulVideo) {
        this.overhaulVideo = overhaulVideo == null ? null : overhaulVideo.trim();
    }

    public Integer getOverhaulSanitationOk() {
        return overhaulSanitationOk;
    }

    public void setOverhaulSanitationOk(Integer overhaulSanitationOk) {
        this.overhaulSanitationOk = overhaulSanitationOk;
    }

    public Integer getOverhaulAppearanceOk() {
        return overhaulAppearanceOk;
    }

    public void setOverhaulAppearanceOk(Integer overhaulAppearanceOk) {
        this.overhaulAppearanceOk = overhaulAppearanceOk;
    }

    public Integer getOverhaulConversionOk() {
        return overhaulConversionOk;
    }

    public void setOverhaulConversionOk(Integer overhaulConversionOk) {
        this.overhaulConversionOk = overhaulConversionOk;
    }

    public Integer getOverhaulSoundOk() {
        return overhaulSoundOk;
    }

    public void setOverhaulSoundOk(Integer overhaulSoundOk) {
        this.overhaulSoundOk = overhaulSoundOk;
    }

    public Integer getOverhaulTempOk() {
        return overhaulTempOk;
    }

    public void setOverhaulTempOk(Integer overhaulTempOk) {
        this.overhaulTempOk = overhaulTempOk;
    }

    public Integer getOverhaulElectricCurrent() {
        return overhaulElectricCurrent;
    }

    public void setOverhaulElectricCurrent(Integer overhaulElectricCurrent) {
        this.overhaulElectricCurrent = overhaulElectricCurrent;
    }

    public String getDetailParty() {
        return detailParty;
    }

    public void setDetailParty(String detailParty) {
        this.detailParty = detailParty == null ? null : detailParty.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getOverhaulContent() {
        return overhaulContent;
    }

    public void setOverhaulContent(String overhaulContent) {
        this.overhaulContent = overhaulContent == null ? null : overhaulContent.trim();
    }

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    public Double getPlanCost() {
        return planCost;
    }

    public void setPlanCost(Double planCost) {
        this.planCost = planCost;
    }

    public Double getRealCost() {
        return realCost;
    }

    public void setRealCost(Double realCost) {
        this.realCost = realCost;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}
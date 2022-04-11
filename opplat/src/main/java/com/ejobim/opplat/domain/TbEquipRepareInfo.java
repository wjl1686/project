package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

public class TbEquipRepareInfo implements WorkFlowExtendI {
    private String repareDetailNo;

    private String extendNo;

    private String suggestSparepartLists;

    private String sparepartLists;

    private String suggestInfo;

    private String reparePictures;

    private String repareVideo;

    private Integer repareSanitationOk;

    private Integer repareAppearanceOk;

    private Integer repareConversionOk;

    private Integer repareSoundOk;

    private Integer repareTempOk;

    private Integer repareElectricCurrent;

    private String detailParty;

    private String contractNo;

    private String repareContent;

    private Integer equipStatus;

    private Integer repareType;

    private Integer planCost;

    private Integer realCost;

    public String getRepareDetailNo() {
        return repareDetailNo;
    }

    public void setRepareDetailNo(String repareDetailNo) {
        this.repareDetailNo = repareDetailNo == null ? null : repareDetailNo.trim();
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

    public String getReparePictures() {
        return reparePictures;
    }

    public void setReparePictures(String reparePictures) {
        this.reparePictures = reparePictures == null ? null : reparePictures.trim();
    }

    public String getRepareVideo() {
        return repareVideo;
    }

    public void setRepareVideo(String repareVideo) {
        this.repareVideo = repareVideo == null ? null : repareVideo.trim();
    }

    public Integer getRepareSanitationOk() {
        return repareSanitationOk;
    }

    public void setRepareSanitationOk(Integer repareSanitationOk) {
        this.repareSanitationOk = repareSanitationOk;
    }

    public Integer getRepareAppearanceOk() {
        return repareAppearanceOk;
    }

    public void setRepareAppearanceOk(Integer repareAppearanceOk) {
        this.repareAppearanceOk = repareAppearanceOk;
    }

    public Integer getRepareConversionOk() {
        return repareConversionOk;
    }

    public void setRepareConversionOk(Integer repareConversionOk) {
        this.repareConversionOk = repareConversionOk;
    }

    public Integer getRepareSoundOk() {
        return repareSoundOk;
    }

    public void setRepareSoundOk(Integer repareSoundOk) {
        this.repareSoundOk = repareSoundOk;
    }

    public Integer getRepareTempOk() {
        return repareTempOk;
    }

    public void setRepareTempOk(Integer repareTempOk) {
        this.repareTempOk = repareTempOk;
    }

    public Integer getRepareElectricCurrent() {
        return repareElectricCurrent;
    }

    public void setRepareElectricCurrent(Integer repareElectricCurrent) {
        this.repareElectricCurrent = repareElectricCurrent;
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

    public String getRepareContent() {
        return repareContent;
    }

    public void setRepareContent(String repareContent) {
        this.repareContent = repareContent == null ? null : repareContent.trim();
    }

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    public Integer getRepareType() {
        return repareType;
    }

    public void setRepareType(Integer repareType) {
        this.repareType = repareType;
    }

    public Integer getPlanCost() {
        return planCost;
    }

    public void setPlanCost(Integer planCost) {
        this.planCost = planCost;
    }

    public Integer getRealCost() {
        return realCost;
    }

    public void setRealCost(Integer realCost) {
        this.realCost = realCost;
    }
}
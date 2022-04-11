package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

import java.math.BigDecimal;

public class TbEquipRepareTaskExtend  implements WorkFlowExtendI {
    private String taskNo;

    private String extendNo;

    private String sparepartLists;

    private String repareContent;

    private String reparePictures;

    private String repareVideo;

    private Integer repareAppearanceOk;

    private Integer repareConversionOk;

    private Integer repareSoundOk;

    private Integer repareTempOk;

    private Integer repareElectricCurrent;

    private Integer repareSanitationOk;

    private String deailsConclusion;

    private String empiricalAnalysis;

    private String followDecision;

    private String detailFileNo;

    private BigDecimal detailAmount;

    private String detailParty;

    private String repareAddon;

    private String repareChartAttach;

    private String repareReportJun;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getSparepartLists() {
        return sparepartLists;
    }

    public void setSparepartLists(String sparepartLists) {
        this.sparepartLists = sparepartLists == null ? null : sparepartLists.trim();
    }

    public String getRepareContent() {
        return repareContent;
    }

    public void setRepareContent(String repareContent) {
        this.repareContent = repareContent == null ? null : repareContent.trim();
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

    public String getDeailsConclusion() {
        return deailsConclusion;
    }

    public void setDeailsConclusion(String deailsConclusion) {
        this.deailsConclusion = deailsConclusion == null ? null : deailsConclusion.trim();
    }

    public String getEmpiricalAnalysis() {
        return empiricalAnalysis;
    }

    public void setEmpiricalAnalysis(String empiricalAnalysis) {
        this.empiricalAnalysis = empiricalAnalysis == null ? null : empiricalAnalysis.trim();
    }

    public String getFollowDecision() {
        return followDecision;
    }

    public void setFollowDecision(String followDecision) {
        this.followDecision = followDecision == null ? null : followDecision.trim();
    }

    public String getDetailFileNo() {
        return detailFileNo;
    }

    public void setDetailFileNo(String detailFileNo) {
        this.detailFileNo = detailFileNo == null ? null : detailFileNo.trim();
    }

    public BigDecimal getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(BigDecimal detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getDetailParty() {
        return detailParty;
    }

    public void setDetailParty(String detailParty) {
        this.detailParty = detailParty == null ? null : detailParty.trim();
    }

    public String getRepareAddon() {
        return repareAddon;
    }

    public void setRepareAddon(String repareAddon) {
        this.repareAddon = repareAddon == null ? null : repareAddon.trim();
    }

    public String getRepareChartAttach() {
        return repareChartAttach;
    }

    public void setRepareChartAttach(String repareChartAttach) {
        this.repareChartAttach = repareChartAttach == null ? null : repareChartAttach.trim();
    }

    public String getRepareReportJun() {
        return repareReportJun;
    }

    public void setRepareReportJun(String repareReportJun) {
        this.repareReportJun = repareReportJun == null ? null : repareReportJun.trim();
    }

    public Integer getRepareSanitationOk() {
        return repareSanitationOk;
    }

    public void setRepareSanitationOk(Integer repareSanitationOk) {
        this.repareSanitationOk = repareSanitationOk;
    }
}
package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

/**
 * @author xof
 */
public class TbFlowMaintainTaskDetail  implements WorkFlowExtendI {
    private String detailNo;

    private String extendNo;

    private String addon;

    private String content;

    private String extendDetail;

    private Integer detailSanitationOk;

    private Float detailElectricCurrent;

    private Integer detailSoundOk;

    private Integer detailFrequencyConversionOk;

    private String detailPictures;

    private String detailVideo;

    private String detailChartAttach;

    private String detailReportJun;

    private Integer detailTempOk;

    private Double detailAmount;

    private String detailParty;

    private String detailFileNo;

    private String detailEvaluate;

    private String detailElementList;

    private Integer detailSpareParts;

    private Integer detailAppearanceOk ;

    private String detailAssistingUser;

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo == null ? null : detailNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon == null ? null : addon.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getExtendDetail() {
        return extendDetail;
    }

    public void setExtendDetail(String extendDetail) {
        this.extendDetail = extendDetail == null ? null : extendDetail.trim();
    }

    public Integer getDetailSanitationOk() {
        return detailSanitationOk;
    }

    public void setDetailSanitationOk(Integer detailSanitationOk) {
        this.detailSanitationOk = detailSanitationOk;
    }

    public Float getDetailElectricCurrent() {
        return detailElectricCurrent;
    }

    public void setDetailElectricCurrent(Float detailElectricCurrent) {
        this.detailElectricCurrent = detailElectricCurrent;
    }

    public Integer getDetailSoundOk() {
        return detailSoundOk;
    }

    public void setDetailSoundOk(Integer detailSoundOk) {
        this.detailSoundOk = detailSoundOk;
    }

    public Integer getDetailFrequencyConversionOk() {
        return detailFrequencyConversionOk;
    }

    public void setDetailFrequencyConversionOk(Integer detailFrequencyConversionOk) {
        this.detailFrequencyConversionOk = detailFrequencyConversionOk;
    }

    public String getDetailPictures() {
        return detailPictures;
    }

    public void setDetailPictures(String detailPictures) {
        this.detailPictures = detailPictures == null ? null : detailPictures.trim();
    }

    public String getDetailVideo() {
        return detailVideo;
    }

    public void setDetailVideo(String detailVideo) {
        this.detailVideo = detailVideo == null ? null : detailVideo.trim();
    }

    public String getDetailChartAttach() {
        return detailChartAttach;
    }

    public void setDetailChartAttach(String detailChartAttach) {
        this.detailChartAttach = detailChartAttach == null ? null : detailChartAttach.trim();
    }

    public String getDetailReportJun() {
        return detailReportJun;
    }

    public void setDetailReportJun(String detailReportJun) {
        this.detailReportJun = detailReportJun == null ? null : detailReportJun.trim();
    }

    public Integer getDetailTempOk() {
        return detailTempOk;
    }

    public void setDetailTempOk(Integer detailTempOk) {
        this.detailTempOk = detailTempOk;
    }

    public Double getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(Double detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getDetailParty() {
        return detailParty;
    }

    public void setDetailParty(String detailParty) {
        this.detailParty = detailParty == null ? null : detailParty.trim();
    }

    public String getDetailFileNo() {
        return detailFileNo;
    }

    public void setDetailFileNo(String detailFileNo) {
        this.detailFileNo = detailFileNo == null ? null : detailFileNo.trim();
    }

    public String getDetailEvaluate() {
        return detailEvaluate;
    }

    public void setDetailEvaluate(String detailEvaluate) {
        this.detailEvaluate = detailEvaluate == null ? null : detailEvaluate.trim();
    }

    public String getDetailElementList() {
        return detailElementList;
    }

    public void setDetailElementList(String detailElementList) {
        this.detailElementList = detailElementList == null ? null : detailElementList.trim();
    }

    public Integer getDetailSpareParts() {
        return detailSpareParts;
    }

    public void setDetailSpareParts(Integer detailSpareParts) {
        this.detailSpareParts = detailSpareParts;
    }

    public Integer getDetailAppearanceOk() {
        return detailAppearanceOk;
    }

    public void setDetailAppearanceOk(Integer detailAppearanceOk) {
        this.detailAppearanceOk = detailAppearanceOk;
    }

    public String getDetailAssistingUser() {
        return detailAssistingUser;
    }

    public void setDetailAssistingUser(String detailAssistingUser) {
        this.detailAssistingUser = detailAssistingUser;
    }
}
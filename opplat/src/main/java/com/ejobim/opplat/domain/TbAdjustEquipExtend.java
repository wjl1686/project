package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbAdjustEquipExtend {
    private String adDetailNo;

    private String adNo;

    private String stepUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date stepTime;

    private String stepIdea;

    private String stepRemark;

    private Integer vaildStatus;

    private Integer stepIndex;

    private Integer flowIndex;

    public String getAdDetailNo() {
        return adDetailNo;
    }

    public void setAdDetailNo(String adDetailNo) {
        this.adDetailNo = adDetailNo == null ? null : adDetailNo.trim();
    }

    public String getAdNo() {
        return adNo;
    }

    public void setAdNo(String adNo) {
        this.adNo = adNo == null ? null : adNo.trim();
    }

    public String getStepUser() {
        return stepUser;
    }

    public void setStepUser(String stepUser) {
        this.stepUser = stepUser == null ? null : stepUser.trim();
    }

    public Date getStepTime() {
        return stepTime;
    }

    public void setStepTime(Date stepTime) {
        this.stepTime = stepTime;
    }

    public String getStepIdea() {
        return stepIdea;
    }

    public void setStepIdea(String stepIdea) {
        this.stepIdea = stepIdea == null ? null : stepIdea.trim();
    }

    public String getStepRemark() {
        return stepRemark;
    }

    public void setStepRemark(String stepRemark) {
        this.stepRemark = stepRemark == null ? null : stepRemark.trim();
    }

    public Integer getVaildStatus() {
        return vaildStatus;
    }

    public void setVaildStatus(Integer vaildStatus) {
        this.vaildStatus = vaildStatus;
    }

    public Integer getStepIndex() {
        return stepIndex;
    }

    public void setStepIndex(Integer stepIndex) {
        this.stepIndex = stepIndex;
    }

    public Integer getFlowIndex() {
        return flowIndex;
    }

    public void setFlowIndex(Integer flowIndex) {
        this.flowIndex = flowIndex;
    }
}
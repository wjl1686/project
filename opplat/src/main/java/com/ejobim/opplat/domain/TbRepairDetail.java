package com.ejobim.opplat.domain;

import java.util.Date;

public class TbRepairDetail {
    private Integer id;

    private String repairNo;

    private String stepName;

    private String stepStatus;

    private String userNo;

    private Date stepTime;

    private String stepInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo == null ? null : repairNo.trim();
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus == null ? null : stepStatus.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Date getStepTime() {
        return stepTime;
    }

    public void setStepTime(Date stepTime) {
        this.stepTime = stepTime;
    }

    public String getStepInfo() {
        return stepInfo;
    }

    public void setStepInfo(String stepInfo) {
        this.stepInfo = stepInfo == null ? null : stepInfo.trim();
    }
}
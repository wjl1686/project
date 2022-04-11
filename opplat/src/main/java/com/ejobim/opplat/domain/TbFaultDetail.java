package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFaultDetail {
    private String faultDetailNo;

    private String taskNo;

    private String taskCode;

    private String faultNo;

    private String faultName;

    private String factoryNo;

    private String equipNo;

    private String equipCode;

    private String equipName;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private String faultDescription;

    private String faultAnalysis;

    private String dealPloy;

    private String faultPic;

    private Date faultTime;

    private Date repairTime;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private String beginTime;

    private String endTime;

    //上报人
    private String  reportUserName;

    public String getFaultDetailNo() {
        return faultDetailNo;
    }

    public void setFaultDetailNo(String faultDetailNo) {
        this.faultDetailNo = faultDetailNo == null ? null : faultDetailNo.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public String getFaultNo() {
        return faultNo;
    }

    public void setFaultNo(String faultNo) {
        this.faultNo = faultNo == null ? null : faultNo.trim();
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription == null ? null : faultDescription.trim();
    }

    public String getFaultAnalysis() {
        return faultAnalysis;
    }

    public void setFaultAnalysis(String faultAnalysis) {
        this.faultAnalysis = faultAnalysis == null ? null : faultAnalysis.trim();
    }

    public String getDealPloy() {
        return dealPloy;
    }

    public void setDealPloy(String dealPloy) {
        this.dealPloy = dealPloy == null ? null : dealPloy.trim();
    }

    public String getFaultPic() {
        return faultPic;
    }

    public void setFaultPic(String faultPic) {
        this.faultPic = faultPic == null ? null : faultPic.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getFaultTime() {
        return faultTime;
    }

    public void setFaultTime(Date faultTime) {
        this.faultTime = faultTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }
}
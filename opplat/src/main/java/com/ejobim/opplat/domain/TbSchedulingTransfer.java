package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbSchedulingTransfer {
    private String transferNo;

    private String transferCode;

    private String factoryNo;

    private Integer groupType;

    private String applyUserName;

    private String applyUserCode;

    private String applyGroupNo;

    private String applyGroupName;

    private String applyGroupTime;

    private Integer applyDayType;

    private String targetUserName;

    private String targetUserCode;

    private String targetGroupNo;

    private String targetGroupName;

    private String targetGroupTime;

    private Integer targetDayType;

    private Integer flag;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private String updateUserName;

    private String updateUserCode;

    private Date updateTime;
    
    private String startTime;
    
    private String endTime;

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode == null ? null : transferCode.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    public String getApplyUserCode() {
        return applyUserCode;
    }

    public void setApplyUserCode(String applyUserCode) {
        this.applyUserCode = applyUserCode == null ? null : applyUserCode.trim();
    }

    public String getApplyGroupNo() {
        return applyGroupNo;
    }

    public void setApplyGroupNo(String applyGroupNo) {
        this.applyGroupNo = applyGroupNo == null ? null : applyGroupNo.trim();
    }

    public String getApplyGroupName() {
        return applyGroupName;
    }

    public void setApplyGroupName(String applyGroupName) {
        this.applyGroupName = applyGroupName == null ? null : applyGroupName.trim();
    }

    public String getApplyGroupTime() {
        return applyGroupTime;
    }

    public void setApplyGroupTime(String applyGroupTime) {
        this.applyGroupTime = applyGroupTime == null ? null : applyGroupTime.trim();
    }

    public Integer getApplyDayType() {
        return applyDayType;
    }

    public void setApplyDayType(Integer applyDayType) {
        this.applyDayType = applyDayType;
    }

    public String getTargetUserName() {
        return targetUserName;
    }

    public void setTargetUserName(String targetUserName) {
        this.targetUserName = targetUserName == null ? null : targetUserName.trim();
    }

    public String getTargetUserCode() {
        return targetUserCode;
    }

    public void setTargetUserCode(String targetUserCode) {
        this.targetUserCode = targetUserCode == null ? null : targetUserCode.trim();
    }

    public String getTargetGroupNo() {
        return targetGroupNo;
    }

    public void setTargetGroupNo(String targetGroupNo) {
        this.targetGroupNo = targetGroupNo == null ? null : targetGroupNo.trim();
    }

    public String getTargetGroupName() {
        return targetGroupName;
    }

    public void setTargetGroupName(String targetGroupName) {
        this.targetGroupName = targetGroupName == null ? null : targetGroupName.trim();
    }

    public String getTargetGroupTime() {
        return targetGroupTime;
    }

    public void setTargetGroupTime(String targetGroupTime) {
        this.targetGroupTime = targetGroupTime == null ? null : targetGroupTime.trim();
    }

    public Integer getTargetDayType() {
        return targetDayType;
    }

    public void setTargetDayType(Integer targetDayType) {
        this.targetDayType = targetDayType;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
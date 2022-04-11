package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbSchedulingChange {
    private String changeNo;

    private String factoryNo;

    private Integer groupType;

    private String applySchedulingNoDetail;

    private String applyUserName;

    private String applyUserCode;

    private String applyGroupTimePoint;

    private Date applyGroupTime;

    private String applyGroupNo;

    private String applyGroupName;

    private Integer applyDayType;

    private String targetSchedulingNoDetail;

    private String targetUserName;

    private String targetUserCode;

    private String targetGroupTimePoint;

    private Date targetGroupTime;

    private String targetGroupNo;

    private String targetGroupName;

    private Integer targetDayType;

    private String reason;

    private Integer status;

    private Integer flag;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private String updateUserName;

    private String updateUserCode;

    private Date updateTime;

    private String applyGroupTimeName;
    
    private String targetGroupTimeName;

    private Integer type;//1:通过 2:驳回
    
    private Integer source;// 来源1 pc 2 app
    
    private String startTime;
    
    private String endTime;

    public String getChangeNo() {
        return changeNo;
    }

    public void setChangeNo(String changeNo) {
        this.changeNo = changeNo == null ? null : changeNo.trim();
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

    public String getApplySchedulingNoDetail() {
        return applySchedulingNoDetail;
    }

    public void setApplySchedulingNoDetail(String applySchedulingNoDetail) {
        this.applySchedulingNoDetail = applySchedulingNoDetail == null ? null : applySchedulingNoDetail.trim();
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

    public String getApplyGroupTimePoint() {
        return applyGroupTimePoint;
    }

    public void setApplyGroupTimePoint(String applyGroupTimePoint) {
        this.applyGroupTimePoint = applyGroupTimePoint == null ? null : applyGroupTimePoint.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getApplyGroupTime() {
        return applyGroupTime;
    }

    public void setApplyGroupTime(Date applyGroupTime) {
        this.applyGroupTime = applyGroupTime;
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

    public Integer getApplyDayType() {
        return applyDayType;
    }

    public void setApplyDayType(Integer applyDayType) {
        this.applyDayType = applyDayType;
    }

    public String getTargetSchedulingNoDetail() {
        return targetSchedulingNoDetail;
    }

    public void setTargetSchedulingNoDetail(String targetSchedulingNoDetail) {
        this.targetSchedulingNoDetail = targetSchedulingNoDetail == null ? null : targetSchedulingNoDetail.trim();
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

    public String getTargetGroupTimePoint() {
        return targetGroupTimePoint;
    }

    public void setTargetGroupTimePoint(String targetGroupTimePoint) {
        this.targetGroupTimePoint = targetGroupTimePoint == null ? null : targetGroupTimePoint.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getTargetGroupTime() {
        return targetGroupTime;
    }

    public void setTargetGroupTime(Date targetGroupTime) {
        this.targetGroupTime = targetGroupTime;
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

    public Integer getTargetDayType() {
        return targetDayType;
    }

    public void setTargetDayType(Integer targetDayType) {
        this.targetDayType = targetDayType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
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

    public String getApplyGroupTimeName() {
        return applyGroupTimeName;
    }

    public void setApplyGroupTimeName(String applyGroupTimeName) {
        this.applyGroupTimeName = applyGroupTimeName;
    }

    public String getTargetGroupTimeName() {
        return targetGroupTimeName;
    }

    public void setTargetGroupTimeName(String targetGroupTimeName) {
        this.targetGroupTimeName = targetGroupTimeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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
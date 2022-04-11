package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFactoryTime {
    
    private String timeNo;
    
    private String factoryNo;

    private String startTimePoint;

    private String endTimePoint;

    private Integer timeType;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private Integer flag;
    
    private String dayTimeType;

    private Integer timeSort;

    public String getTimeNo() {
        return timeNo;
    }

    public void setTimeNo(String timeNo) {
        this.timeNo = timeNo == null ? null : timeNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getStartTimePoint() {
        return startTimePoint;
    }

    public void setStartTimePoint(String startTimePoint) {
        this.startTimePoint = startTimePoint == null ? null : startTimePoint.trim();
    }

    public String getEndTimePoint() {
        return endTimePoint;
    }

    public void setEndTimePoint(String endTimePoint) {
        this.endTimePoint = endTimePoint == null ? null : endTimePoint.trim();
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDayTimeType() {
        return dayTimeType;
    }

    public void setDayTimeType(String dayTimeType) {
        this.dayTimeType = dayTimeType;
    }

    public Integer getTimeSort() {
        return timeSort;
    }

    public void setTimeSort(Integer timeSort) {
        this.timeSort = timeSort;
    }
}
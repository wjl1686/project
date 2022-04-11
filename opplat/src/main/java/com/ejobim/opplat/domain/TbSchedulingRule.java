package com.ejobim.opplat.domain;

import java.util.Date;

public class TbSchedulingRule {
    private String schedulingRuleNo;

    private Integer ruleType;

    private Integer groupType;

    private String factoryNo;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private String updateUserName;

    private String updateUserCode;

    private Date updateTime;

    private Object extendInfo;

    private Date enableTime;

    private Integer weekendWork;

    private Integer canEdit;

    public String getSchedulingRuleNo() {
        return schedulingRuleNo;
    }

    public void setSchedulingRuleNo(String schedulingRuleNo) {
        this.schedulingRuleNo = schedulingRuleNo == null ? null : schedulingRuleNo.trim();
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
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

    public Object getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Object extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public Integer getWeekendWork() {
        return weekendWork;
    }

    public void setWeekendWork(Integer weekendWork) {
        this.weekendWork = weekendWork;
    }

    public Integer getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Integer canEdit) {
        this.canEdit = canEdit;
    }
}
package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbProcessApplyExtend {
    private String processApplyNo;

    private String processNo;

    private String stepUserName;

    private String stepUser;

    private Date stepTime;

    private Integer step;

    private String remark;

    private String idea;

    private Integer vaildStatus;

    private String createUser;

    private String createUserName;

    private Date createTime;

    public String getProcessApplyNo() {
        return processApplyNo;
    }

    public void setProcessApplyNo(String processApplyNo) {
        this.processApplyNo = processApplyNo == null ? null : processApplyNo.trim();
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    public String getStepUserName() {
        return stepUserName;
    }

    public void setStepUserName(String stepUserName) {
        this.stepUserName = stepUserName == null ? null : stepUserName.trim();
    }

    public String getStepUser() {
        return stepUser;
    }

    public void setStepUser(String stepUser) {
        this.stepUser = stepUser == null ? null : stepUser.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getStepTime() {
        return stepTime;
    }

    public void setStepTime(Date stepTime) {
        this.stepTime = stepTime;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea == null ? null : idea.trim();
    }

    public Integer getVaildStatus() {
        return vaildStatus;
    }

    public void setVaildStatus(Integer vaildStatus) {
        this.vaildStatus = vaildStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
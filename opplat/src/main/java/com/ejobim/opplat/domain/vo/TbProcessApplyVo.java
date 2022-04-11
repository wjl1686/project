package com.ejobim.opplat.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbProcessApplyVo {
    private String processNo;

    private String factoryNo;

    private String processName;

    private Integer category;

    private String content;

    private Integer status;

    private String applyUser;

    private Date applyTime;

    private String remark;

    private String factoryName;

    private String stepUser;

    private Date stepTime;

    private String idea;

    private String createUserName;

    private Integer vaildStatus;

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo == null ? null : processNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getStepUser() {
        return stepUser;
    }

    public void setStepUser(String stepUser) {
        this.stepUser = stepUser;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getStepTime() {
        return stepTime;
    }

    public void setStepTime(Date stepTime) {
        this.stepTime = stepTime;
    }

    public String getIdea(){
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getVaildStatus() {
        return vaildStatus;
    }

    public void setVaildStatus(Integer vaildStatus) {
        this.vaildStatus = vaildStatus;
    }
}
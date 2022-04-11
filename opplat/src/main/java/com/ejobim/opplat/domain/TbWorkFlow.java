package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWorkFlow {
    private String flowNo;

    private String workFlowConfigNo;

    private Date createTime;

    private String createUser;

    private String createUserName;

    private String nextUser;

    private String nextUserName;

    private Integer statusIndex;

    private String statusCodeName;

    private Integer nextStatusIndex;

    private String nextStatusCodeName;

    private Integer nextPlat;

    private Date updateTime;

    private Integer deleteFlag;

    private Object detailInfo;

    private String orgNo;

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getWorkFlowConfigNo() {
        return workFlowConfigNo;
    }

    public void setWorkFlowConfigNo(String workFlowConfigNo) {
        this.workFlowConfigNo = workFlowConfigNo == null ? null : workFlowConfigNo.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser == null ? null : nextUser.trim();
    }

    public String getNextUserName() {
        return nextUserName;
    }

    public void setNextUserName(String nextUserName) {
        this.nextUserName = nextUserName == null ? null : nextUserName.trim();
    }

    public String getStatusCodeName() {
        return statusCodeName;
    }

    public void setStatusCodeName(String statusCodeName) {
        this.statusCodeName = statusCodeName == null ? null : statusCodeName.trim();
    }

    public String getNextStatusCodeName() {
        return nextStatusCodeName;
    }

    public void setNextStatusCodeName(String nextStatusCodeName) {
        this.nextStatusCodeName = nextStatusCodeName == null ? null : nextStatusCodeName.trim();
    }

    public Integer getNextPlat() {
        return nextPlat;
    }

    public void setNextPlat(Integer nextPlat) {
        this.nextPlat = nextPlat;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Object getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(Object detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }

    public Integer getNextStatusIndex() {
        return nextStatusIndex;
    }

    public void setNextStatusIndex(Integer nextStatusIndex) {
        this.nextStatusIndex = nextStatusIndex;
    }
}
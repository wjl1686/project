package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWorkTaskInfoExtend {
    private String extendNo;

    private String taskNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String statusCode;

    private String statusCodeName;

    private Integer validStatus;

    private String commitUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commitTime;

    private String commitUserCode;

    private Integer statusIndex;

    private Object detailInfo;

    private String nodeConfigDetail;

    private TbWorkFlowConfigDetail configDetail;

    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public String getStatusCodeName() {
        return statusCodeName;
    }

    public void setStatusCodeName(String statusCodeName) {
        this.statusCodeName = statusCodeName == null ? null : statusCodeName.trim();
    }

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getCommitUserCode() {
        return commitUserCode;
    }

    public void setCommitUserCode(String commitUserCode) {
        this.commitUserCode = commitUserCode == null ? null : commitUserCode.trim();
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }

    public Object getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(Object detailInfo) {
        this.detailInfo = detailInfo;
    }

    public TbWorkFlowConfigDetail getConfigDetail() {
        return configDetail;
    }

    public void setConfigDetail(TbWorkFlowConfigDetail configDetail) {
        this.configDetail = configDetail;
    }

    public String getNodeConfigDetail() {
        return nodeConfigDetail;
    }

    public void setNodeConfigDetail(String nodeConfigDetail) {
        this.nodeConfigDetail = nodeConfigDetail;
    }
}
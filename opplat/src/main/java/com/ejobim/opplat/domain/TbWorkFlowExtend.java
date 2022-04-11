package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWorkFlowExtend extends TbWorkFlowExtendKey {
    private Date createTime;

    private Date updateTime;



    private Integer statusIndex;

    private String statusCodeName;

    private Integer validStatus;

    private String commitUser;

    private String commitUserCode;

    private String nextUser;

    private Date commitTime;

    private Object detailInfo;

    private TbWorkFlowConfigDetail configDetail;

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

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser == null ? null : nextUser.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Object getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(Object detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getCommitUserCode() {
        return commitUserCode;
    }

    public void setCommitUserCode(String commitUserCode) {
        this.commitUserCode = commitUserCode;
    }

    public TbWorkFlowConfigDetail getConfigDetail() {
        return configDetail;
    }

    public void setConfigDetail(TbWorkFlowConfigDetail configDetail) {
        this.configDetail = configDetail;
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }
}
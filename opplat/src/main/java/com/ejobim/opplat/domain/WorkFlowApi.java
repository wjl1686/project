package com.ejobim.opplat.domain;

import java.util.Date;

public class WorkFlowApi {
    private String apiNo;

    private String apiName;

    private String apiUrl;

    private Object apiParams;

    private String apiInfo;

    private Integer deleteFlag;

    private Date updateTime;

    private Object commitParams;

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo == null ? null : apiNo.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public Object getApiParams() {
        return apiParams;
    }

    public void setApiParams(Object apiParams) {
        this.apiParams = apiParams;
    }

    public String getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(String apiInfo) {
        this.apiInfo = apiInfo == null ? null : apiInfo.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getCommitParams() {
        return commitParams;
    }

    public void setCommitParams(Object commitParams) {
        this.commitParams = commitParams;
    }
}
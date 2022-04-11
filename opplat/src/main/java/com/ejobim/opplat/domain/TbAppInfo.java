package com.ejobim.opplat.domain;

import java.util.Date;

public class TbAppInfo {
    private Integer id;

    private String appVersion;

    private Date appUpdateTime;

    private String appDownloadUrl;

    private String appUpdateDetail;

    private String appUpdateUser;

    private Integer appStatus;

    private Integer appChannel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public Date getAppUpdateTime() {
        return appUpdateTime;
    }

    public void setAppUpdateTime(Date appUpdateTime) {
        this.appUpdateTime = appUpdateTime;
    }

    public String getAppDownloadUrl() {
        return appDownloadUrl;
    }

    public void setAppDownloadUrl(String appDownloadUrl) {
        this.appDownloadUrl = appDownloadUrl == null ? null : appDownloadUrl.trim();
    }

    public String getAppUpdateDetail() {
        return appUpdateDetail;
    }

    public void setAppUpdateDetail(String appUpdateDetail) {
        this.appUpdateDetail = appUpdateDetail == null ? null : appUpdateDetail.trim();
    }

    public String getAppUpdateUser() {
        return appUpdateUser;
    }

    public void setAppUpdateUser(String appUpdateUser) {
        this.appUpdateUser = appUpdateUser == null ? null : appUpdateUser.trim();
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(Integer appChannel) {
        this.appChannel = appChannel;
    }
}
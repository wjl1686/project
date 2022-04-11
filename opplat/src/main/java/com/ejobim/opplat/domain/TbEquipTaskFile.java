package com.ejobim.opplat.domain;

import java.util.Date;

public class TbEquipTaskFile {
    private String ofNo;

    private String ofTaskNo;

    private String ofTaskExtendNo;

    private Integer ofTaskStatus;

    private String ofTaskStatusCode;

    private String ofFileName;

    private String ofFileUrl;

    private Date ofUploadTime;

    private Integer ofFileStatus;

    private String ofFactoryNo;

    private Integer ofType;

    public String getOfNo() {
        return ofNo;
    }

    public void setOfNo(String ofNo) {
        this.ofNo = ofNo == null ? null : ofNo.trim();
    }

    public String getOfTaskNo() {
        return ofTaskNo;
    }

    public void setOfTaskNo(String ofTaskNo) {
        this.ofTaskNo = ofTaskNo == null ? null : ofTaskNo.trim();
    }

    public String getOfTaskExtendNo() {
        return ofTaskExtendNo;
    }

    public void setOfTaskExtendNo(String ofTaskExtendNo) {
        this.ofTaskExtendNo = ofTaskExtendNo == null ? null : ofTaskExtendNo.trim();
    }

    public Integer getOfTaskStatus() {
        return ofTaskStatus;
    }

    public void setOfTaskStatus(Integer ofTaskStatus) {
        this.ofTaskStatus = ofTaskStatus;
    }

    public String getOfTaskStatusCode() {
        return ofTaskStatusCode;
    }

    public void setOfTaskStatusCode(String ofTaskStatusCode) {
        this.ofTaskStatusCode = ofTaskStatusCode == null ? null : ofTaskStatusCode.trim();
    }

    public String getOfFileName() {
        return ofFileName;
    }

    public void setOfFileName(String ofFileName) {
        this.ofFileName = ofFileName == null ? null : ofFileName.trim();
    }

    public String getOfFileUrl() {
        return ofFileUrl;
    }

    public void setOfFileUrl(String ofFileUrl) {
        this.ofFileUrl = ofFileUrl == null ? null : ofFileUrl.trim();
    }

    public Date getOfUploadTime() {
        return ofUploadTime;
    }

    public void setOfUploadTime(Date ofUploadTime) {
        this.ofUploadTime = ofUploadTime;
    }

    public Integer getOfFileStatus() {
        return ofFileStatus;
    }

    public void setOfFileStatus(Integer ofFileStatus) {
        this.ofFileStatus = ofFileStatus;
    }

    public String getOfFactoryNo() {
        return ofFactoryNo;
    }

    public void setOfFactoryNo(String ofFactoryNo) {
        this.ofFactoryNo = ofFactoryNo == null ? null : ofFactoryNo.trim();
    }

    public Integer getOfType() {
        return ofType;
    }

    public void setOfType(Integer ofType) {
        this.ofType = ofType;
    }
}
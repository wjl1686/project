package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbEquipFaultInfo {
    private String errorNo;

    private String factoryNo;

    private String equipNo;

    private String equipName;

    private String equipTypeName;

    private String equipLocation;

    private Integer errorFrom;

    private String errorType;

    private String errorLocation;

    private String errorContent;

    private String errorPictures;

    private String errorVideo;

    private String errorAudio;

    private String flowNo;

    private String detailTaskNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String reportUserCode;

    private String reportUserName;

    private String routingInfo;

    private Integer errorStatus;

    private String locationName;

    
    public String getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo == null ? null : errorNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName == null ? null : equipTypeName.trim();
    }

    public String getEquipLocation() {
        return equipLocation;
    }

    public void setEquipLocation(String equipLocation) {
        this.equipLocation = equipLocation == null ? null : equipLocation.trim();
    }

    public Integer getErrorFrom() {
        return errorFrom;
    }

    public void setErrorFrom(Integer errorFrom) {
        this.errorFrom = errorFrom;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType == null ? null : errorType.trim();
    }

    public String getErrorLocation() {
        return errorLocation;
    }

    public void setErrorLocation(String errorLocation) {
        this.errorLocation = errorLocation == null ? null : errorLocation.trim();
    }

    public String getErrorContent() {
        return errorContent;
    }

    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent == null ? null : errorContent.trim();
    }

    public String getErrorPictures() {
        return errorPictures;
    }

    public void setErrorPictures(String errorPictures) {
        this.errorPictures = errorPictures == null ? null : errorPictures.trim();
    }

    public String getErrorVideo() {
        return errorVideo;
    }

    public void setErrorVideo(String errorVideo) {
        this.errorVideo = errorVideo == null ? null : errorVideo.trim();
    }

    public String getErrorAudio() {
        return errorAudio;
    }

    public void setErrorAudio(String errorAudio) {
        this.errorAudio = errorAudio == null ? null : errorAudio.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getDetailTaskNo() {
        return detailTaskNo;
    }

    public void setDetailTaskNo(String detailTaskNo) {
        this.detailTaskNo = detailTaskNo == null ? null : detailTaskNo.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReportUserCode() {
        return reportUserCode;
    }

    public void setReportUserCode(String reportUserCode) {
        this.reportUserCode = reportUserCode == null ? null : reportUserCode.trim();
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName == null ? null : reportUserName.trim();
    }

    public String getRoutingInfo() {
        return routingInfo;
    }

    public void setRoutingInfo(String routingInfo) {
        this.routingInfo = routingInfo;
    }

    public Integer getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }


}
package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbDraftData {
    private String draftNo;

    private Date draftTime;

    private String draftDate;

    private Double draftValue;

    private String draftUnit;

    private Integer staticType;

    private Integer draftType;

    private String dataFrom;

    private String fieldNo;

    private String draftName;

    private String factoryNo;

    private String fillNo;

    private String fillTaskNo;

    private String draftTimeByString;

    private String draftTypeName;

    private String draftUnitValue;

    private String startTime;

    private String endTime;

    public String getDraftNo() {
        return draftNo;
    }

    public void setDraftNo(String draftNo) {
        this.draftNo = draftNo == null ? null : draftNo.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getDraftTime() {
        return draftTime;
    }

    public void setDraftTime(Date draftTime) {
        this.draftTime = draftTime;
    }

    public String getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(String draftDate) {
        this.draftDate = draftDate == null ? null : draftDate.trim();
    }

    public Double getDraftValue() {
        return draftValue;
    }

    public void setDraftValue(Double draftValue) {
        this.draftValue = draftValue;
    }

    public String getDraftUnit() {
        return draftUnit;
    }

    public void setDraftUnit(String draftUnit) {
        this.draftUnit = draftUnit == null ? null : draftUnit.trim();
    }

    public Integer getStaticType() {
        return staticType;
    }

    public void setStaticType(Integer staticType) {
        this.staticType = staticType;
    }

    public Integer getDraftType() {
        return draftType;
    }

    public void setDraftType(Integer draftType) {
        this.draftType = draftType;
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom == null ? null : dataFrom.trim();
    }

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getDraftName() {
        return draftName;
    }

    public void setDraftName(String draftName) {
        this.draftName = draftName == null ? null : draftName.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getFillNo() {
        return fillNo;
    }

    public void setFillNo(String fillNo) {
        this.fillNo = fillNo == null ? null : fillNo.trim();
    }

    public String getFillTaskNo() {
        return fillTaskNo;
    }

    public void setFillTaskNo(String fillTaskNo) {
        this.fillTaskNo = fillTaskNo;
    }

    public String getDraftTimeByString() {
        return draftTimeByString;
    }

    public void setDraftTimeByString(String draftTimeByString) {
        this.draftTimeByString = draftTimeByString;
    }

    public String getDraftTypeName() {
        return draftTypeName;
    }

    public void setDraftTypeName(String draftTypeName) {
        this.draftTypeName = draftTypeName;
    }

    public String getDraftUnitValue() {
        return draftUnitValue;
    }

    public void setDraftUnitValue(String draftUnitValue) {
        this.draftUnitValue = draftUnitValue;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
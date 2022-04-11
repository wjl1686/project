package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFacilityParam {
    private String fatiParamNo;

    private String fatiParamUri;

    private String fatiModelName;

    private String fatiParamName;

    private Float fatiParamValue;

    private String fatiParamUnit;

    private Date fatiUpdateTime;

    private String paramFactoryNo;

    public String getFatiParamNo() {
        return fatiParamNo;
    }

    public void setFatiParamNo(String fatiParamNo) {
        this.fatiParamNo = fatiParamNo == null ? null : fatiParamNo.trim();
    }

    public String getFatiParamUri() {
        return fatiParamUri;
    }

    public void setFatiParamUri(String fatiParamUri) {
        this.fatiParamUri = fatiParamUri == null ? null : fatiParamUri.trim();
    }

    public String getFatiModelName() {
        return fatiModelName;
    }

    public void setFatiModelName(String fatiModelName) {
        this.fatiModelName = fatiModelName == null ? null : fatiModelName.trim();
    }

    public String getFatiParamName() {
        return fatiParamName;
    }

    public void setFatiParamName(String fatiParamName) {
        this.fatiParamName = fatiParamName == null ? null : fatiParamName.trim();
    }

    public Float getFatiParamValue() {
        return fatiParamValue;
    }

    public void setFatiParamValue(Float fatiParamValue) {
        this.fatiParamValue = fatiParamValue;
    }

    public String getFatiParamUnit() {
        return fatiParamUnit;
    }

    public void setFatiParamUnit(String fatiParamUnit) {
        this.fatiParamUnit = fatiParamUnit == null ? null : fatiParamUnit.trim();
    }

    public Date getFatiUpdateTime() {
        return fatiUpdateTime;
    }

    public void setFatiUpdateTime(Date fatiUpdateTime) {
        this.fatiUpdateTime = fatiUpdateTime;
    }

    public String getParamFactoryNo() {
        return paramFactoryNo;
    }

    public void setParamFactoryNo(String paramFactoryNo) {
        this.paramFactoryNo = paramFactoryNo == null ? null : paramFactoryNo.trim();
    }
}
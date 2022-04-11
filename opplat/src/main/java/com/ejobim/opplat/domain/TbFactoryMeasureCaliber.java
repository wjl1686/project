package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFactoryMeasureCaliber {
    private String factoryNo;

    private String measureCaliberType;

    private String description;

    private Date lastUpdateTime;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getMeasureCaliberType() {
        return measureCaliberType;
    }

    public void setMeasureCaliberType(String measureCaliberType) {
        this.measureCaliberType = measureCaliberType == null ? null : measureCaliberType.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
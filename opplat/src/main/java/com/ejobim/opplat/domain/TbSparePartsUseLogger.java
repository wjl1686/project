package com.ejobim.opplat.domain;

import java.util.Date;

public class TbSparePartsUseLogger {
    private Integer id;

    private String workOrderNo;

    private Integer workOrderType;

    private Integer useCount;

    private String sparePartsNo;

    private Date useTime;

    private String sparePartsName;

    private String sparetPartsUnit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo == null ? null : workOrderNo.trim();
    }

    public Integer getWorkOrderType() {
        return workOrderType;
    }

    public void setWorkOrderType(Integer workOrderType) {
        this.workOrderType = workOrderType;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public String getSparePartsNo() {
        return sparePartsNo;
    }

    public void setSparePartsNo(String sparePartsNo) {
        this.sparePartsNo = sparePartsNo == null ? null : sparePartsNo.trim();
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public String getSparePartsName() {
        return sparePartsName;
    }

    public void setSparePartsName(String sparePartsName) {
        this.sparePartsName = sparePartsName;
    }

    public String getSparetPartsUnit() {
        return sparetPartsUnit;
    }

    public void setSparetPartsUnit(String sparetPartsUnit) {
        this.sparetPartsUnit = sparetPartsUnit;
    }
}
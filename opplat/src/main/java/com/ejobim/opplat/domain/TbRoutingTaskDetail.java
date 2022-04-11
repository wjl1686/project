package com.ejobim.opplat.domain;

import java.util.Date;

public class TbRoutingTaskDetail {
    private String taskDetailNo;

    private String taskNo;

    private Integer elementType;

    private String elementNo;

    private String elementName;

    private Integer routingStatus;

    private Date commitTime;

    private Double fillValue;

    private Double autoValue;

    private String autoBrowsePath;

    private String fieldNo;

    private String fieldUnit;

    private String locationNo;

    private String equipNo;

    private TbEquipFaultInfo equipFaultInfo;

    public String getTaskDetailNo() {
        return taskDetailNo;
    }

    public void setTaskDetailNo(String taskDetailNo) {
        this.taskDetailNo = taskDetailNo == null ? null : taskDetailNo.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public String getElementNo() {
        return elementNo;
    }

    public void setElementNo(String elementNo) {
        this.elementNo = elementNo == null ? null : elementNo.trim();
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    public Integer getRoutingStatus() {
        return routingStatus;
    }

    public void setRoutingStatus(Integer routingStatus) {
        this.routingStatus = routingStatus;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Double getFillValue() {
        return fillValue;
    }

    public void setFillValue(Double fillValue) {
        this.fillValue = fillValue;
    }

    public Double getAutoValue() {
        return autoValue;
    }

    public void setAutoValue(Double autoValue) {
        this.autoValue = autoValue;
    }

    public String getAutoBrowsePath() {
        return autoBrowsePath;
    }

    public void setAutoBrowsePath(String autoBrowsePath) {
        this.autoBrowsePath = autoBrowsePath == null ? null : autoBrowsePath.trim();
    }

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getFieldUnit() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit = fieldUnit == null ? null : fieldUnit.trim();
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo == null ? null : locationNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public TbEquipFaultInfo getEquipFaultInfo() {
        return equipFaultInfo;
    }

    public void setEquipFaultInfo(TbEquipFaultInfo equipFaultInfo) {
        this.equipFaultInfo = equipFaultInfo;
    }
}
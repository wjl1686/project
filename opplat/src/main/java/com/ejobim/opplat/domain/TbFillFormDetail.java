package com.ejobim.opplat.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TbFillFormDetail {
    private String fillFormDetailNo;

    private String configNo;

    private String taskNo;

    private String fieldCode;

    private String fieldName;

    private Double fieldValue;

    private String fieldUnit;

    private String factoryNo;

    private String equipNo;

    private String timePoint;

    private Date createTime;

    private Date fillTime;//填报时间

    private String createPerson;

    private Date formDate;

    private Integer type;

    private Double autoValue;

    private String browsePath;

    private String fillTakeTime;

    public String getFillFormDetailNo() {
        return fillFormDetailNo;
    }

    public void setFillFormDetailNo(String fillFormDetailNo) {
        this.fillFormDetailNo = fillFormDetailNo == null ? null : fillFormDetailNo.trim();
    }

    public String getConfigNo() {
        return configNo;
    }

    public void setConfigNo(String configNo) {
        this.configNo = configNo == null ? null : configNo.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public Double getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Double fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldUnit() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit = fieldUnit == null ? null : fieldUnit.trim();
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

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint == null ? null : timePoint.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAutoValue() {
        return autoValue;
    }

    public void setAutoValue(Double autoValue) {
        this.autoValue = autoValue;
    }

    public String getBrowsePath() {
        return browsePath;
    }

    public void setBrowsePath(String browsePath) {
        this.browsePath = browsePath;
    }

    public String getFillTakeTime() {
        return fillTakeTime;
    }

    public void setFillTakeTime(String fillTakeTime) {
        this.fillTakeTime = fillTakeTime;
    }

    public Date getFillTime() {
        return fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }
}
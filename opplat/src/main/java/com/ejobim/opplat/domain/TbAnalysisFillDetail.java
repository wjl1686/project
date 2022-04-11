package com.ejobim.opplat.domain;

import java.util.Date;

public class TbAnalysisFillDetail {
    private String fillDetailNo;

    private String fieldNo;

    private String baseFieldNo;

    private String taskNo;

    private String fieldName;

    private Double fieldValue;

    private String fieldUnit;

    private String factoryNo;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date fillTime;

    public String getFillDetailNo() {
        return fillDetailNo;
    }

    public void setFillDetailNo(String fillDetailNo) {
        this.fillDetailNo = fillDetailNo == null ? null : fillDetailNo.trim();
    }

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getBaseFieldNo() {
        return baseFieldNo;
    }

    public void setBaseFieldNo(String baseFieldNo) {
        this.baseFieldNo = baseFieldNo == null ? null : baseFieldNo.trim();
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getFillTime() {
        return fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }
}
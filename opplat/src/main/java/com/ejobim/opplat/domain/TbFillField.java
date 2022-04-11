package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFillField {
    private String fieldNo;

    private String factoryNo;

    private String createUserCode;

    private String createUserName;

    private Date createTime;

    private Integer fieldStatus;

    private String fieldName;

    private String baseFieldNo;

    private Integer fieldType;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private TbParameterConfig parameterConfig;

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(Integer fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getBaseFieldNo() {
        return baseFieldNo;
    }

    public void setBaseFieldNo(String baseFieldNo) {
        this.baseFieldNo = baseFieldNo == null ? null : baseFieldNo.trim();
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public TbParameterConfig getParameterConfig() {
        return parameterConfig;
    }

    public void setParameterConfig(TbParameterConfig parameterConfig) {
        this.parameterConfig = parameterConfig;
    }
}
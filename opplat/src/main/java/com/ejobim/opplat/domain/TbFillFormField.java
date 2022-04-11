package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFillFormField {
    private String configNo;

    private String configInfo;

    private Date createTime;

    private String createPerson;

    private Integer configStatus;

    private String factoryNo;

    private String fieldName;

    private String fieldCode;

    private Float fieldMaxValue;

    private Float fieldMinValue;

    private String fieldUnit;

    private String browsePath;

    private Integer fieldType;

    private String gydNo;

    private String equipNo;

    private Integer fillType;

    private String sedName;

    private TbFillFormFieldExtend fieldExtend;

    private TbSynObject parentObj;

    public String getConfigNo() {
        return configNo;
    }

    public void setConfigNo(String configNo) {
        this.configNo = configNo == null ? null : configNo.trim();
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo == null ? null : configInfo.trim();
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

    public Integer getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(Integer configStatus) {
        this.configStatus = configStatus;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    public Float getFieldMaxValue() {
        return fieldMaxValue;
    }

    public void setFieldMaxValue(Float fieldMaxValue) {
        this.fieldMaxValue = fieldMaxValue;
    }

    public Float getFieldMinValue() {
        return fieldMinValue;
    }

    public void setFieldMinValue(Float fieldMinValue) {
        this.fieldMinValue = fieldMinValue;
    }

    public String getFieldUnit() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit = fieldUnit == null ? null : fieldUnit.trim();
    }

    public String getBrowsePath() {
        return browsePath;
    }

    public void setBrowsePath(String browsePath) {
        this.browsePath = browsePath == null ? null : browsePath.trim();
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getGydNo() {
        return gydNo;
    }

    public void setGydNo(String gydNo) {
        this.gydNo = gydNo == null ? null : gydNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public Integer getFillType() {
        return fillType;
    }

    public void setFillType(Integer fillType) {
        this.fillType = fillType;
    }

    public String getSedName() {
        return sedName;
    }

    public void setSedName(String sedName) {
        this.sedName = sedName == null ? null : sedName.trim();
    }

    public TbFillFormFieldExtend getFieldExtend() {
        return fieldExtend;
    }

    public void setFieldExtend(TbFillFormFieldExtend fieldExtend) {
        this.fieldExtend = fieldExtend;
    }

    public TbSynObject getParentObj() {
        return parentObj;
    }

    public void setParentObj(TbSynObject parentObj) {
        this.parentObj = parentObj;
    }

    @Override
    public String toString() {
        return "TbFillFormField{" +
                "configNo='" + configNo + '\'' +
                ", configInfo='" + configInfo + '\'' +
                ", createTime=" + createTime +
                ", createPerson='" + createPerson + '\'' +
                ", configStatus=" + configStatus +
                ", factoryNo='" + factoryNo + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldCode='" + fieldCode + '\'' +
                ", fieldMaxValue=" + fieldMaxValue +
                ", fieldMinValue=" + fieldMinValue +
                ", fieldUnit='" + fieldUnit + '\'' +
                ", browsePath='" + browsePath + '\'' +
                ", fieldType=" + fieldType +
                ", gydNo='" + gydNo + '\'' +
                ", equipNo='" + equipNo + '\'' +
                ", fillType=" + fillType +
                ", sedName='" + sedName + '\'' +
                ", fieldExtend=" + fieldExtend +
                ", parentObj=" + parentObj +
                '}';
    }
}
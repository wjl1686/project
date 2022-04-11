package com.ejobim.opplat.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TbFormData {
    private Integer id;

    private String fieldCode;

    private String fieldName;

    private Double fieldValue;

    private String fieldUnit;

    private String factoryNo;

    private String equipNo;

    private String timePoint;

    private Date creatTime;

    private String creatPerson;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date formDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getCreatPerson() {
        return creatPerson;
    }

    public void setCreatPerson(String creatPerson) {
        this.creatPerson = creatPerson == null ? null : creatPerson.trim();
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }
}
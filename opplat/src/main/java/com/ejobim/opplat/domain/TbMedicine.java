package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbMedicine {
    private String medicineNo;

    private String factoryNo;

    private String targetNo;

    private String chemicalName;

    private String chemical;

    private String medicineCategory;

    private String categoryType;

    private String medicineVaid;

    private String medicineContent;

    private Integer reportType;

    private Integer type;

    private String uri;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createUser;

    public String getMedicineNo() {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo) {
        this.medicineNo = medicineNo == null ? null : medicineNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String targetNo) {
        this.targetNo = targetNo == null ? null : targetNo.trim();
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName == null ? null : chemicalName.trim();
    }

    public String getChemical() {
        return chemical;
    }

    public void setChemical(String chemical) {
        this.chemical = chemical == null ? null : chemical.trim();
    }

    public String getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory == null ? null : medicineCategory.trim();
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType == null ? null : categoryType.trim();
    }

    public String getMedicineVaid() {
        return medicineVaid;
    }

    public void setMedicineVaid(String medicineVaid) {
        this.medicineVaid = medicineVaid == null ? null : medicineVaid.trim();
    }

    public String getMedicineContent() {
        return medicineContent;
    }

    public void setMedicineContent(String medicineContent) {
        this.medicineContent = medicineContent == null ? null : medicineContent.trim();
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }
}
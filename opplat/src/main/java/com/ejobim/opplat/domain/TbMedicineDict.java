package com.ejobim.opplat.domain;

public class TbMedicineDict {
    private Integer id;

    private String tragetNo;

    private String medicineCategory;

    private String categoryType;

    private String medicineName;

    private String chemical;

    private String medicineType;

    private String medicineVaid;

    private String medicineContent;

    private String choose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTragetNo() {
        return tragetNo;
    }

    public void setTragetNo(String tragetNo) {
        this.tragetNo = tragetNo == null ? null : tragetNo.trim();
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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public String getChemical() {
        return chemical;
    }

    public void setChemical(String chemical) {
        this.chemical = chemical == null ? null : chemical.trim();
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType == null ? null : medicineType.trim();
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

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }
}
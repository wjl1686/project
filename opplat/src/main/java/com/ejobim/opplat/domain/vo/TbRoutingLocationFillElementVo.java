package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.ExcelColumn;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbRoutingLocationFillElementVo {

    @ExcelColumn(value = "巡检点",col = 1)
    private String locationName;
    @ExcelColumn(value = "设备名称",col = 2)
    private String equipName;
    @ExcelColumn(value = "填报指标",col = 3)
    private String fieldNoName;
    
    private String locationFieldNo;

    private String parentNo;

    private String fieldNo;
    @ExcelColumn(value = "填报名称",col = 4)
    private String elementName;

    private Integer parentType;

    //@ExcelColumn(value = "要素方法",col = 3)
    private String elementMethod;
    private String equipNo;
    
    private Integer elementLevel;

    private String fillTimes;

    private Integer elementType;

    private String factoryNo;

    private String locationNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer deleteFlag;

    private String fieldUnit;

    private String autoFieldUri;

    private String autoFieldBrowsePath;

    public String getLocationFieldNo() {
        return locationFieldNo;
    }

    public void setLocationFieldNo(String locationFieldNo) {
        this.locationFieldNo = locationFieldNo == null ? null : locationFieldNo.trim();
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo == null ? null : parentNo.trim();
    }

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    public Integer getParentType() {
        return parentType;
    }

    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    public String getElementMethod() {
        return elementMethod;
    }

    public void setElementMethod(String elementMethod) {
        this.elementMethod = elementMethod == null ? null : elementMethod.trim();
    }

    public Integer getElementLevel() {
        return elementLevel;
    }

    public void setElementLevel(Integer elementLevel) {
        this.elementLevel = elementLevel;
    }

    public String getFillTimes() {
        return fillTimes;
    }

    public void setFillTimes(String fillTimes) {
        this.fillTimes = fillTimes == null ? null : fillTimes.trim();
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getFieldUnit() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit = fieldUnit == null ? null : fieldUnit.trim();
    }

    public String getAutoFieldUri() {
        return autoFieldUri;
    }

    public void setAutoFieldUri(String autoFieldUri) {
        this.autoFieldUri = autoFieldUri == null ? null : autoFieldUri.trim();
    }

    public String getAutoFieldBrowsePath() {
        return autoFieldBrowsePath;
    }

    public void setAutoFieldBrowsePath(String autoFieldBrowsePath) {
        this.autoFieldBrowsePath = autoFieldBrowsePath == null ? null : autoFieldBrowsePath.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getFieldNoName() {
        return fieldNoName;
    }

    public void setFieldNoName(String fieldNoName) {
        this.fieldNoName = fieldNoName;
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
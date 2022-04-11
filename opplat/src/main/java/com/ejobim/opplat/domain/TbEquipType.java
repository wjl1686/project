package com.ejobim.opplat.domain;

import java.util.Date;
import java.util.List;

public class TbEquipType {
    private Integer id;

    private Integer parentId;

    private String equipTypeCode;

    private String equipLevelType;

    private String typeName;

    private String factoryNo;

    private String typeNo;

    private String unit;

    private Integer level;

    private Integer status;

    private Date createTime;

    private String createUser;

    private String createUserName;

    private String description;

    private String typeUri;

    private String parentName;

    private List<TbEquipType> children;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getEquipTypeCode() {
        return equipTypeCode;
    }

    public void setEquipTypeCode(String equipTypeCode) {
        this.equipTypeCode = equipTypeCode == null ? null : equipTypeCode.trim();
    }

    public String getEquipLevelType() {
        return equipLevelType;
    }

    public void setEquipLevelType(String equipLevelType) {
        this.equipLevelType = equipLevelType == null ? null : equipLevelType.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo == null ? null : typeNo.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTypeUri() {
        return typeUri;
    }

    public void setTypeUri(String typeUri) {
        this.typeUri = typeUri == null ? null : typeUri.trim();
    }
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<TbEquipType> getChildren() {
        return children;
    }

    public void setChildren(List<TbEquipType> children) {
        this.children = children;
    }
}
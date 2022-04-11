package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSynObject {
    private String uri;

    private String factoryUri;

    private String name;

    private String browsepath;

    private String browsename;

    private String displayname;

    private String parentUri;

    private String parentName;

    private String description;

    private String fieldUri;

    private String factoryNo;

    private Integer level;

    private String accesslevel;

    private Integer hasvalue;

    private Integer type;

    private Integer fieldType;

    private Date createTime;

    private Long sortOrder;

    private List<TbSynObject> tbSynObjectList;

    private List<TbSynObject> tbChildSynObjectList = new ArrayList<>();

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getFactoryUri() {
        return factoryUri;
    }

    public void setFactoryUri(String factoryUri) {
        this.factoryUri = factoryUri == null ? null : factoryUri.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrowsepath() {
        return browsepath;
    }

    public void setBrowsepath(String browsepath) {
        this.browsepath = browsepath == null ? null : browsepath.trim();
    }

    public String getBrowsename() {
        return browsename;
    }

    public void setBrowsename(String browsename) {
        this.browsename = browsename == null ? null : browsename.trim();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public String getParentUri() {
        return parentUri;
    }

    public void setParentUri(String parentUri) {
        this.parentUri = parentUri == null ? null : parentUri.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFieldUri() {
        return fieldUri;
    }

    public void setFieldUri(String fieldUri) {
        this.fieldUri = fieldUri == null ? null : fieldUri.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel == null ? null : accesslevel.trim();
    }

    public Integer getHasvalue() {
        return hasvalue;
    }

    public void setHasvalue(Integer hasvalue) {
        this.hasvalue = hasvalue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<TbSynObject> getTbSynObjectList() {
        return tbSynObjectList;
    }

    public void setTbSynObjectList(List<TbSynObject> tbSynObjectList) {
        this.tbSynObjectList = tbSynObjectList;
    }

    public List<TbSynObject> getTbChildSynObjectList() {
        return tbChildSynObjectList;
    }

    public void setTbChildSynObjectList(List<TbSynObject> tbChildSynObjectList) {
        this.tbChildSynObjectList = tbChildSynObjectList;
    }
}
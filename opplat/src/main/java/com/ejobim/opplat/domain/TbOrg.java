package com.ejobim.opplat.domain;

import java.util.Date;

public class TbOrg {
    private String code;

    private String name;

    private String parentCode;

    private Integer type;

    private Integer state;

    private Integer sort;

    private String creator;

    private Date createTime;

    private String description;

    private Integer isleaf;

    private Integer level;

    private Integer projectid;

    private String projectnamespace;

    private String tenantid;

    private String orgencode;

    private String uri;

    private Date updateTime;

    private String creatorcode;

    private String enable;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectnamespace() {
        return projectnamespace;
    }

    public void setProjectnamespace(String projectnamespace) {
        this.projectnamespace = projectnamespace == null ? null : projectnamespace.trim();
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getOrgencode() {
        return orgencode;
    }

    public void setOrgencode(String orgencode) {
        this.orgencode = orgencode == null ? null : orgencode.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatorcode() {
        return creatorcode;
    }

    public void setCreatorcode(String creatorcode) {
        this.creatorcode = creatorcode == null ? null : creatorcode.trim();
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }
}
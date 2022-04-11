package com.ejobim.opplat.domain;

import java.util.Date;

public class TbSynBaseDetail {
    private Integer id;

    private String uri;

    private String typedefinitionuri;

    private String browsepath;

    private String description;

    private String browsename;

    private String displayname;

    private String name;

    private String value;

    private Date createTime;

    private String factoryNo;

    private String parentUri;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getTypedefinitionuri() {
        return typedefinitionuri;
    }

    public void setTypedefinitionuri(String typedefinitionuri) {
        this.typedefinitionuri = typedefinitionuri == null ? null : typedefinitionuri.trim();
    }

    public String getBrowsepath() {
        return browsepath;
    }

    public void setBrowsepath(String browsepath) {
        this.browsepath = browsepath == null ? null : browsepath.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getParentUri() {
        return parentUri;
    }

    public void setParentUri(String parentUri) {
        this.parentUri = parentUri == null ? null : parentUri.trim();
    }

    @Override
    public String toString() {
        return "TbSynBaseDetail{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", typedefinitionuri='" + typedefinitionuri + '\'' +
                ", browsepath='" + browsepath + '\'' +
                ", description='" + description + '\'' +
                ", browsename='" + browsename + '\'' +
                ", displayname='" + displayname + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", createTime=" + createTime +
                ", factoryNo='" + factoryNo + '\'' +
                ", parentUri='" + parentUri + '\'' +
                '}';
    }
}
package com.ejobim.opplat.domain;

public class TbSynField {
    private String uri;

    private String name;

    private String description;

    private String browsepath;

    private String browsename;

    private String displayname;

    private String accesslevel;

    private Integer hasvalue;

    private String parentUri;

    private String factoryUri;

    private String factoryNo;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public String getParentUri() {
        return parentUri;
    }

    public void setParentUri(String parentUri) {
        this.parentUri = parentUri == null ? null : parentUri.trim();
    }

    public String getFactoryUri() {
        return factoryUri;
    }

    public void setFactoryUri(String factoryUri) {
        this.factoryUri = factoryUri == null ? null : factoryUri.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }
}
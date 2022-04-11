package com.ejobim.opplat.domain;

public class TbRealTimeConfig {
    private String uri;

    private String factoryNo;

    private String parenturi;

    private String displayname;

    private String browsepath;

    private String accesslevel;

    private double realTimeValue; //实时数据

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getParenturi() {
        return parenturi;
    }

    public void setParenturi(String parenturi) {
        this.parenturi = parenturi == null ? null : parenturi.trim();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public String getBrowsepath() {
        return browsepath;
    }

    public void setBrowsepath(String browsepath) {
        this.browsepath = browsepath == null ? null : browsepath.trim();
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel == null ? null : accesslevel.trim();
    }

    public double getRealTimeValue() {
        return realTimeValue;
    }

    public void setRealTimeValue(double realTimeValue) {
        this.realTimeValue = realTimeValue;
    }
}
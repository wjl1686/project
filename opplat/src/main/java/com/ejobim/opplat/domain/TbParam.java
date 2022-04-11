package com.ejobim.opplat.domain;

import java.util.Date;

public class TbParam {
    private String name;

    private String uri;

    private Integer type;

    private String parentUri;

    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentUri() {
        return parentUri;
    }

    public void setParentUri(String parentUri) {
        this.parentUri = parentUri == null ? null : parentUri.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TbParam{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", type=" + type +
                ", parentUri='" + parentUri + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
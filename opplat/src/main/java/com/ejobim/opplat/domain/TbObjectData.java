package com.ejobim.opplat.domain;

import java.util.Date;

public class TbObjectData {
    private String objectUri;

    private Integer objectType;

    private String dataUri;

    private Date createTime;

    private String factoryNo;

    private Integer dataFrom;

    public String getObjectUri() {
        return objectUri;
    }

    public void setObjectUri(String objectUri) {
        this.objectUri = objectUri == null ? null : objectUri.trim();
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    public String getDataUri() {
        return dataUri;
    }

    public void setDataUri(String dataUri) {
        this.dataUri = dataUri == null ? null : dataUri.trim();
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

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    @Override
    public String toString() {
        return "TbObjectData{" +
                "objectUri='" + objectUri + '\'' +
                ", objectType=" + objectType +
                ", dataUri=" + dataUri +
                ", createTime='" + createTime + '\'' +
                ", factoryNo='" + factoryNo + '\'' +
                ", dataFrom='" + dataFrom + '\'' +
                '}';
    }

}
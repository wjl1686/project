package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFactoryDehydrationSystem {
    private Integer id;

    private String factoryNo;

    private Integer sludgeType;

    private Integer dehydrationType;

    private Double dehydrationMud;

    private Integer dehydrationPreType;

    private Double preDehydrationMudWaterRate;

    private Integer mudDepthDehydrationType;

    private Double depthDehydrationMudWaterRate;

    private Integer mudTransportType;

    private Integer mudHandleType;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getSludgeType() {
        return sludgeType;
    }

    public void setSludgeType(Integer sludgeType) {
        this.sludgeType = sludgeType;
    }

    public Integer getDehydrationType() {
        return dehydrationType;
    }

    public void setDehydrationType(Integer dehydrationType) {
        this.dehydrationType = dehydrationType;
    }

    public Double getDehydrationMud() {
        return dehydrationMud;
    }

    public void setDehydrationMud(Double dehydrationMud) {
        this.dehydrationMud = dehydrationMud;
    }

    public Integer getDehydrationPreType() {
        return dehydrationPreType;
    }

    public void setDehydrationPreType(Integer dehydrationPreType) {
        this.dehydrationPreType = dehydrationPreType;
    }

    public Double getPreDehydrationMudWaterRate() {
        return preDehydrationMudWaterRate;
    }

    public void setPreDehydrationMudWaterRate(Double preDehydrationMudWaterRate) {
        this.preDehydrationMudWaterRate = preDehydrationMudWaterRate;
    }

    public Integer getMudDepthDehydrationType() {
        return mudDepthDehydrationType;
    }

    public void setMudDepthDehydrationType(Integer mudDepthDehydrationType) {
        this.mudDepthDehydrationType = mudDepthDehydrationType;
    }

    public Double getDepthDehydrationMudWaterRate() {
        return depthDehydrationMudWaterRate;
    }

    public void setDepthDehydrationMudWaterRate(Double depthDehydrationMudWaterRate) {
        this.depthDehydrationMudWaterRate = depthDehydrationMudWaterRate;
    }

    public Integer getMudTransportType() {
        return mudTransportType;
    }

    public void setMudTransportType(Integer mudTransportType) {
        this.mudTransportType = mudTransportType;
    }

    public Integer getMudHandleType() {
        return mudHandleType;
    }

    public void setMudHandleType(Integer mudHandleType) {
        this.mudHandleType = mudHandleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
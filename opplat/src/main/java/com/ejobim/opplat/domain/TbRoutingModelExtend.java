package com.ejobim.opplat.domain;

import java.util.Date;

public class TbRoutingModelExtend {
    private String routingModelExtendNo;

    private String routingModelNo;

    private String routingElementNo;

    private Integer routingElementType;

    private Date createTime;

    private String routingLocationNo;

    private String routingEquipNo;

    public String getRoutingModelExtendNo() {
        return routingModelExtendNo;
    }

    public void setRoutingModelExtendNo(String routingModelExtendNo) {
        this.routingModelExtendNo = routingModelExtendNo == null ? null : routingModelExtendNo.trim();
    }

    public String getRoutingModelNo() {
        return routingModelNo;
    }

    public void setRoutingModelNo(String routingModelNo) {
        this.routingModelNo = routingModelNo == null ? null : routingModelNo.trim();
    }

    public String getRoutingElementNo() {
        return routingElementNo;
    }

    public void setRoutingElementNo(String routingElementNo) {
        this.routingElementNo = routingElementNo == null ? null : routingElementNo.trim();
    }

    public Integer getRoutingElementType() {
        return routingElementType;
    }

    public void setRoutingElementType(Integer routingElementType) {
        this.routingElementType = routingElementType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoutingLocationNo() {
        return routingLocationNo;
    }

    public void setRoutingLocationNo(String routingLocationNo) {
        this.routingLocationNo = routingLocationNo == null ? null : routingLocationNo.trim();
    }

    public String getRoutingEquipNo() {
        return routingEquipNo;
    }

    public void setRoutingEquipNo(String routingEquipNo) {
        this.routingEquipNo = routingEquipNo == null ? null : routingEquipNo.trim();
    }
}
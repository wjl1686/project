package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbRoutingModel {
    private String routingModelNo;

    private String routingModelName;

    private Integer routingModelLevel;

    private Integer routingModelStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateUser;

    private String factoryNo;

    private Integer deleteFlag;

    private String timeZones;

    private Integer allCount;

    private Integer routeType;
    
    //0 来源pc 添加 
    private Integer source;

    public String getRoutingModelNo() {
        return routingModelNo;
    }

    public void setRoutingModelNo(String routingModelNo) {
        this.routingModelNo = routingModelNo == null ? null : routingModelNo.trim();
    }

    public String getRoutingModelName() {
        return routingModelName;
    }

    public void setRoutingModelName(String routingModelName) {
        this.routingModelName = routingModelName == null ? null : routingModelName.trim();
    }

    public Integer getRoutingModelLevel() {
        return routingModelLevel;
    }

    public void setRoutingModelLevel(Integer routingModelLevel) {
        this.routingModelLevel = routingModelLevel;
    }

    public Integer getRoutingModelStatus() {
        return routingModelStatus;
    }

    public void setRoutingModelStatus(Integer routingModelStatus) {
        this.routingModelStatus = routingModelStatus;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getTimeZones() {
        return timeZones;
    }

    public void setTimeZones(String timeZones) {
        this.timeZones = timeZones == null ? null : timeZones.trim();
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
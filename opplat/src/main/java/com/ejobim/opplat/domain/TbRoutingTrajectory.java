package com.ejobim.opplat.domain;

import java.util.Date;

public class TbRoutingTrajectory {
    private String trajeNo;

    private String locationNo;

    private Date trajeTime;

    private String routingTaskNo;

    private Double trajeX;

    private Double trajeY;

    public String getTrajeNo() {
        return trajeNo;
    }

    public void setTrajeNo(String trajeNo) {
        this.trajeNo = trajeNo == null ? null : trajeNo.trim();
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo == null ? null : locationNo.trim();
    }

    public Date getTrajeTime() {
        return trajeTime;
    }

    public void setTrajeTime(Date trajeTime) {
        this.trajeTime = trajeTime;
    }

    public String getRoutingTaskNo() {
        return routingTaskNo;
    }

    public void setRoutingTaskNo(String routingTaskNo) {
        this.routingTaskNo = routingTaskNo == null ? null : routingTaskNo.trim();
    }

    public Double getTrajeX() {
        return trajeX;
    }

    public void setTrajeX(Double trajeX) {
        this.trajeX = trajeX;
    }

    public Double getTrajeY() {
        return trajeY;
    }

    public void setTrajeY(Double trajeY) {
        this.trajeY = trajeY;
    }
}
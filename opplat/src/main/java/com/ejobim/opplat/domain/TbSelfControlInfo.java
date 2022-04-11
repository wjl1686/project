package com.ejobim.opplat.domain;

public class TbSelfControlInfo {
    private String selControlNo;

    private String factoryNo;

    private Integer selfControlStatus;

    public String getSelControlNo() {
        return selControlNo;
    }

    public void setSelControlNo(String selControlNo) {
        this.selControlNo = selControlNo == null ? null : selControlNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getSelfControlStatus() {
        return selfControlStatus;
    }

    public void setSelfControlStatus(Integer selfControlStatus) {
        this.selfControlStatus = selfControlStatus;
    }
}
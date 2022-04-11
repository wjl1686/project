package com.ejobim.opplat.domain;

import java.util.Date;

public class TbReportModel {
    private String rmNo;

    private String rmName;

    private Integer rmCycle;

    private String rmCreateUser;

    private String rmCreateUseName;

    private Date rmCreateTime;

    private String rmCheckUser;

    private String rmCheckUserName;

    private Date rmCheckTime;

    private String rmFactoryNo;

    public String getRmNo() {
        return rmNo;
    }

    public void setRmNo(String rmNo) {
        this.rmNo = rmNo == null ? null : rmNo.trim();
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName == null ? null : rmName.trim();
    }

    public Integer getRmCycle() {
        return rmCycle;
    }

    public void setRmCycle(Integer rmCycle) {
        this.rmCycle = rmCycle;
    }

    public String getRmCreateUser() {
        return rmCreateUser;
    }

    public void setRmCreateUser(String rmCreateUser) {
        this.rmCreateUser = rmCreateUser == null ? null : rmCreateUser.trim();
    }

    public String getRmCreateUseName() {
        return rmCreateUseName;
    }

    public void setRmCreateUseName(String rmCreateUseName) {
        this.rmCreateUseName = rmCreateUseName == null ? null : rmCreateUseName.trim();
    }

    public Date getRmCreateTime() {
        return rmCreateTime;
    }

    public void setRmCreateTime(Date rmCreateTime) {
        this.rmCreateTime = rmCreateTime;
    }

    public String getRmCheckUser() {
        return rmCheckUser;
    }

    public void setRmCheckUser(String rmCheckUser) {
        this.rmCheckUser = rmCheckUser == null ? null : rmCheckUser.trim();
    }

    public String getRmCheckUserName() {
        return rmCheckUserName;
    }

    public void setRmCheckUserName(String rmCheckUserName) {
        this.rmCheckUserName = rmCheckUserName == null ? null : rmCheckUserName.trim();
    }

    public Date getRmCheckTime() {
        return rmCheckTime;
    }

    public void setRmCheckTime(Date rmCheckTime) {
        this.rmCheckTime = rmCheckTime;
    }

    public String getRmFactoryNo() {
        return rmFactoryNo;
    }

    public void setRmFactoryNo(String rmFactoryNo) {
        this.rmFactoryNo = rmFactoryNo == null ? null : rmFactoryNo.trim();
    }

    @Override
    public TbReportModel clone() {
        TbReportModel reportModel = new TbReportModel();
        reportModel.setRmNo(this.getRmNo());
        reportModel.setRmFactoryNo(this.getRmFactoryNo());
        reportModel.setRmCreateTime(this.getRmCreateTime());
        reportModel.setRmCycle(this.getRmCycle());
        reportModel.setRmName(this.getRmName());
        reportModel.setRmCreateUseName(this.getRmCreateUseName());
        return reportModel;
    }
}
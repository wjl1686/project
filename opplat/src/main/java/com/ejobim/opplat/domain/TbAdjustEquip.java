package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbAdjustEquip {
    private String adNo;

    private String factoryNo;

    private String adName;

    private String adContent;

    private Integer status;

    private String applyUser;

    private String applyUserName;

    private String adEquipList;

    private Date applyTime;

    private String adEquipNameList;

    private List<TbAdjustEquipExtend> extendList;

    public String getAdNo() {
        return adNo;
    }

    public void setAdNo(String adNo) {
        this.adNo = adNo == null ? null : adNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent == null ? null : adContent.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public List<TbAdjustEquipExtend> getExtendList() {
        return extendList;
    }

    public void setExtendList(List<TbAdjustEquipExtend> extendList) {
        this.extendList = extendList;
    }

    public String getAdEquipList() {
        return adEquipList;
    }

    public void setAdEquipList(String adEquipList) {
        this.adEquipList = adEquipList;
    }

    public String getAdEquipNameList() {
        return adEquipNameList;
    }

    public void setAdEquipNameList(String adEquipNameList) {
        this.adEquipNameList = adEquipNameList;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }
}
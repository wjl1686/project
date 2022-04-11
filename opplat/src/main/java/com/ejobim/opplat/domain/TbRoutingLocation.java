package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingLocation {
    private String locationNo;

    private String factoryNo;

    private String locationName;

    private String locationDescribe;

    private Integer locationType;

    private Integer locationLevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer deleteFlag;

    private Integer locationSort;

    private Integer equipCount;

    private Integer fillCount;
    
    //0 pc支持巡检点模糊查询
    private Integer source;

    private  Double locationX;

    private  Double locationY;

    private List<TbRoutingLocatioinEquip> equipList;

    private List<TbRoutingLocationElement> elementList;

    private List<TbRoutingTaskDetail> taskDetailList;

    private String nfcNo;

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo == null ? null : locationNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    public String getLocationDescribe() {
        return locationDescribe;
    }

    public void setLocationDescribe(String locationDescribe) {
        this.locationDescribe = locationDescribe == null ? null : locationDescribe.trim();
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public Integer getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(Integer locationLevel) {
        this.locationLevel = locationLevel;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getLocationSort() {
        return locationSort;
    }

    public void setLocationSort(Integer locationSort) {
        this.locationSort = locationSort;
    }

    public Integer getEquipCount() {
        return equipCount;
    }

    public void setEquipCount(Integer equipCount) {
        this.equipCount = equipCount;
    }

    public Integer getFillCount() {
        return fillCount;
    }

    public void setFillCount(Integer fillCount) {
        this.fillCount = fillCount;
    }

    public List<TbRoutingLocatioinEquip> getEquipList() {
        if(equipList==null){
            equipList = new ArrayList<>();
        }
        return equipList;
    }

    public void setEquipList(List<TbRoutingLocatioinEquip> equipList) {
        this.equipList = equipList;
    }

    public List<TbRoutingLocationElement> getElementList() {
        if(elementList==null){
            elementList = new ArrayList<>();
        }
        return elementList;
    }

    public void setElementList(List<TbRoutingLocationElement> elementList) {
        this.elementList = elementList;
    }

    public List<TbRoutingTaskDetail> getTaskDetailList() {
        if(taskDetailList==null){
            taskDetailList = new ArrayList<>();
        }
        return taskDetailList;
    }

    public void setTaskDetailList(List<TbRoutingTaskDetail> taskDetailList) {
        this.taskDetailList = taskDetailList;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }
    public String getNfcNo() {
        return nfcNo;
    }

    public void setNfcNo(String nfcNo) {
        this.nfcNo = nfcNo == null ? null : nfcNo.trim();
    }
}
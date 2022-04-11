package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingLocatioinEquip {
    private String locationEquipNo;

    private String routingNo;

    private String equipNo;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer equipSort;

    private String equipName;

    private String equipPicture;

    //类型(0:上移 1:下移)
    private Integer type;
    //上面/或者下设备no
    private String locationEquipNoUpOrDown;

    private List<TbRoutingLocationElement> elementList;
    private List<TbRoutingTaskDetail> taskDetailList;

    public String getLocationEquipNo() {
        return locationEquipNo;
    }

    public void setLocationEquipNo(String locationEquipNo) {
        this.locationEquipNo = locationEquipNo == null ? null : locationEquipNo.trim();
    }

    public String getRoutingNo() {
        return routingNo;
    }

    public void setRoutingNo(String routingNo) {
        this.routingNo = routingNo == null ? null : routingNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getEquipSort() {
        return equipSort;
    }

    public void setEquipSort(Integer equipSort) {
        this.equipSort = equipSort;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public List<TbRoutingLocationElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<TbRoutingLocationElement> elementList) {
        this.elementList = elementList;
    }


    public String getEquipPicture() {
        return equipPicture;
    }

    public void setEquipPicture(String equipPicture) {
        this.equipPicture = equipPicture;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLocationEquipNoUpOrDown() {
        return locationEquipNoUpOrDown;
    }

    public void setLocationEquipNoUpOrDown(String locationEquipNoUpOrDown) {
        this.locationEquipNoUpOrDown = locationEquipNoUpOrDown;
    }
}
package com.ejobim.opplat.domain.condition;

import java.util.Date;
import java.util.List;

public class TbRoutingTaskConditon {
    
    private String taskNo;

    private String factoryNo;

    private String taskCode;

    private String modelNo;

    private Integer needCount;

    private Integer finishCount;

    private Integer errorCount;

    private Integer taskStatus;

    private String createUserCode;

    private String createUserName;
    
    private Date updateTime;
    
    private Date beginTime;

    private Date endTime;

    private Date startTime;

    private Date finishTime;

    private String commitUser;

    private Integer taskType;

    private boolean isCurrentTask;

    private String modelName;

    private Integer elementType;
    
    private String  locationFieldNo;
    
    private String locationNo;
    
    private String equipNo;
    
    private String beginTimeName;
    
    private List<TbRoutingTaskConditon> tbRoutingTaskConditonList;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Integer getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Integer needCount) {
        this.needCount = needCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public boolean isCurrentTask() {
        return isCurrentTask;
    }

    public void setCurrentTask(boolean currentTask) {
        isCurrentTask = currentTask;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public String getLocationFieldNo() {
        return locationFieldNo;
    }

    public void setLocationFieldNo(String locationFieldNo) {
        this.locationFieldNo = locationFieldNo;
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public List<TbRoutingTaskConditon> getTbRoutingTaskConditonList() {
        return tbRoutingTaskConditonList;
    }

    public void setTbRoutingTaskConditonList(List<TbRoutingTaskConditon> tbRoutingTaskConditonList) {
        this.tbRoutingTaskConditonList = tbRoutingTaskConditonList;
    }

    public String getBeginTimeName() {
        return beginTimeName;
    }

    public void setBeginTimeName(String beginTimeName) {
        this.beginTimeName = beginTimeName;
    }
}
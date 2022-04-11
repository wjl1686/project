package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbRoutingTask {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date craeteTime;

    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;

    private Date endTime;

    private Date startTime;

    private Date finishTime;

    private String commitUserCode;

    private String commitUser;

    private Integer taskType;

    private boolean isCurrentTask;

    private String modelName;
    /**
     * 巡检点列表
     */
    private String routingLocationList;

    private Integer tempStatus;
    
    private String beginTimeS;

    private Integer draftStatus;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo == null ? null : modelNo.trim();
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
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
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

    public String getCommitUserCode() {
        return commitUserCode;
    }

    public void setCommitUserCode(String commitUserCode) {
        this.commitUserCode = commitUserCode == null ? null : commitUserCode.trim();
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
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

    public String getRoutingLocationList() {
        return routingLocationList;
    }

    public void setRoutingLocationList(String routingLocationList) {
        this.routingLocationList = routingLocationList;
    }

    public Integer getTempStatus() {
        return tempStatus;
    }

    public void setTempStatus(Integer tempStatus) {
        this.tempStatus = tempStatus;
    }

    public String getBeginTimeS() {
        return beginTimeS;
    }

    public void setBeginTimeS(String beginTimeS) {
        this.beginTimeS = beginTimeS;
    }

    public Integer getDraftStatus() {
        return draftStatus;
    }

    public void setDraftStatus(Integer draftStatus) {
        this.draftStatus = draftStatus;
    }
}
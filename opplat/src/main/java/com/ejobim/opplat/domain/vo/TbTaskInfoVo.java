package com.ejobim.opplat.domain.vo;

import java.util.Date;

public class TbTaskInfoVo {
    private String taskNo;

    private Integer taskId;

    private String taskName;

    private String taskGroup;

    private String taskUserNo;

    private String taskUserName;

    private Integer taskType;

    private Date endTime;

    private Date finishTime;

    private Integer taskStatus;

    private Date createTime;

    private String createUserNo;

    private String createUserName;

    private String endTimes;

    private String finishTimes;

    public String getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(String endTimes) {
        this.endTimes = endTimes;
    }

    public String getFinishTimes() {
        return finishTimes;
    }

    public void setFinishTimes(String finishTimes) {
        this.finishTimes = finishTimes;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup == null ? null : taskGroup.trim();
    }

    public String getTaskUserNo() {
        return taskUserNo;
    }

    public void setTaskUserNo(String taskUserNo) {
        this.taskUserNo = taskUserNo == null ? null : taskUserNo.trim();
    }

    public String getTaskUserName() {
        return taskUserName;
    }

    public void setTaskUserName(String taskUserName) {
        this.taskUserName = taskUserName == null ? null : taskUserName.trim();
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserNo() {
        return createUserNo;
    }

    public void setCreateUserNo(String createUserNo) {
        this.createUserNo = createUserNo == null ? null : createUserNo.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }
}
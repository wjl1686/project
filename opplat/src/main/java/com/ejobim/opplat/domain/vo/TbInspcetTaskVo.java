package com.ejobim.opplat.domain.vo;

import java.util.Date;

public class TbInspcetTaskVo {
    private String inspTaskNo;

    private String inspTaskCode;

    private String inspModelNo;

    private String inspModelName;

    private Date inspTaskTime;

    private Date inspEndTime;

    private Integer inspTaskStatus;

    private String createUser;

    private Date createTime;

    private Date commitTime;

    private Date startTime;

    private Integer inspTaskIndex;

    private String factroyNo;

    private String inspTaskUser;

    private Integer errorCount;

    private Integer allCount;

    private Integer finishCount;

    private String taskRangeInfo;

    private Boolean isCurrentTask;

    private String inspEndTimeName;

    public String getInspTaskNo() {
        return inspTaskNo;
    }

    public void setInspTaskNo(String inspTaskNo) {
        this.inspTaskNo = inspTaskNo == null ? null : inspTaskNo.trim();
    }

    public String getInspTaskCode() {
        return inspTaskCode;
    }

    public void setInspTaskCode(String inspTaskCode) {
        this.inspTaskCode = inspTaskCode == null ? null : inspTaskCode.trim();
    }

    public String getInspModelNo() {
        return inspModelNo;
    }

    public void setInspModelNo(String inspModelNo) {
        this.inspModelNo = inspModelNo == null ? null : inspModelNo.trim();
    }

    public Date getInspTaskTime() {
        return inspTaskTime;
    }

    public void setInspTaskTime(Date inspTaskTime) {
        this.inspTaskTime = inspTaskTime;
    }

    public Date getInspEndTime() {
        return inspEndTime;
    }

    public void setInspEndTime(Date inspEndTime) {
        this.inspEndTime = inspEndTime;
    }

    public Integer getInspTaskStatus() {
        return inspTaskStatus;
    }

    public void setInspTaskStatus(Integer inspTaskStatus) {
        this.inspTaskStatus = inspTaskStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getInspTaskIndex() {
        return inspTaskIndex;
    }

    public void setInspTaskIndex(Integer inspTaskIndex) {
        this.inspTaskIndex = inspTaskIndex;
    }

    public String getFactroyNo() {
        return factroyNo;
    }

    public void setFactroyNo(String factroyNo) {
        this.factroyNo = factroyNo == null ? null : factroyNo.trim();
    }

    public String getInspTaskUser() {
        return inspTaskUser;
    }

    public void setInspTaskUser(String inspTaskUser) {
        this.inspTaskUser = inspTaskUser == null ? null : inspTaskUser.trim();
    }

    public String getInspModelName() {
        return inspModelName;
    }

    public void setInspModelName(String inspModelName) {
        this.inspModelName = inspModelName;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }


    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    public Boolean getCurrentTask() {
        return isCurrentTask;
    }

    public void setCurrentTask(Boolean currentTask) {
        isCurrentTask = currentTask;
    }

    public String getTaskRangeInfo() {
        return taskRangeInfo;
    }

    public void setTaskRangeInfo(String taskRangeInfo) {
        this.taskRangeInfo = taskRangeInfo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getInspEndTimeName() {
        return inspEndTimeName;
    }

    public void setInspEndTimeName(String inspEndTimeName) {
        this.inspEndTimeName = inspEndTimeName;
    }
}
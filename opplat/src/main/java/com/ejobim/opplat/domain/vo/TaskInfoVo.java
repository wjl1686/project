package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.TbRoutingTask;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author  xibian
 */
public class TaskInfoVo {
    /**
     * 任务类别：1：巡检；2：填报；4：维修；5：维保；6：防腐；7：大修
     */
    private  int taskType;
    /**
     * 任务级别：1：日常任务；2:临时任务；3:紧急任务
     */
    private int taskLevel;
    /**
     * 任务编号
     */
    private String taskCode;
    private String equipNo;
    /**
     * 任务详情
     */
    private String taskInfo;
    private String taskNo;
    private Integer taskStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskTime;
    private Integer neeeCount;
    private Integer finishCount;
    private boolean isCurrent;


    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public int getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(int taskLevel) {
        this.taskLevel = taskLevel;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public TaskInfoVo(TbRoutingTask routingTask){
        this.taskCode = routingTask.getTaskCode();
        if(routingTask.getTaskType().intValue()==1){
            this.taskInfo = "日常巡检";
        }else{
            this.taskInfo = "日常填报";
        }
        this.taskType = routingTask.getTaskType();
        this.taskLevel = 1;
        this.isCurrent = routingTask.isCurrentTask();
        this.taskNo = routingTask.getTaskNo();
        this.taskTime = routingTask.getBeginTime();
        this.taskStatus = routingTask.getTaskStatus();
        this.neeeCount = routingTask.getNeedCount();
        this.finishCount = routingTask.getFinishCount();
    }


    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public Integer getNeeeCount() {
        return neeeCount;
    }

    public void setNeeeCount(Integer neeeCount) {
        this.neeeCount = neeeCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }
}

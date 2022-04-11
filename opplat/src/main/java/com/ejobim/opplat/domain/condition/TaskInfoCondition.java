package com.ejobim.opplat.domain.condition;

/**
 * @author wujianlong
 * @Description: 任务查询条件
 * @date 2019/1/18 10:40
 */
public class TaskInfoCondition {
    private String startTime;

    private String endTime;

    private String currentTime;

    // 类型区分 1:未完成 2:待完成
    private Integer type;

    private String time;

    private String dutyUser;

    private String factoryNo;

    private String factoryUri;
    //'1:维保；2：防腐',
    private Integer taskType;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public String getFactoryUri() {
        return factoryUri;
    }

    public void setFactoryUri(String factoryUri) {
        this.factoryUri = factoryUri;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }
}

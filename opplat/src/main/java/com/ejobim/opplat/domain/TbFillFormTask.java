package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFillFormTask {
    private String fillTaskNo;

    private Date fillTaskTime;

    private String fillTaskUserNo;

    private Integer fillCountAll;

    private Integer fillCount;

    private String factoryNo;

    private Integer equipStatus;

    private Date createTime;

    private Date endTime;

    private Date commitTime; //确认提交时间

    private String createUser;

    private Integer status;

    private String checkUser;

    private String checkUserName;

    private String fillUser;

    private String fillUserName;

    private String fillTaskCode;

    private Integer taskType;

    private String flag;

    private Integer isOutTime;

    public String getFillTaskNo() {
        return fillTaskNo;
    }

    public void setFillTaskNo(String fillTaskNo) {
        this.fillTaskNo = fillTaskNo == null ? null : fillTaskNo.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getFillTaskTime() {
        return fillTaskTime;
    }

    public void setFillTaskTime(Date fillTaskTime) {
        this.fillTaskTime = fillTaskTime;
    }

    public String getFillTaskUserNo() {
        return fillTaskUserNo;
    }

    public void setFillTaskUserNo(String fillTaskUserNo) {
        this.fillTaskUserNo = fillTaskUserNo == null ? null : fillTaskUserNo.trim();
    }

    public Integer getFillCountAll() {
        return fillCountAll;
    }

    public void setFillCountAll(Integer fillCountAll) {
        this.fillCountAll = fillCountAll;
    }

    public Integer getFillCount() {
        return fillCount;
    }

    public void setFillCount(Integer fillCount) {
        this.fillCount = fillCount;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status 0待下发 1:未执行；2:未提交;4:已提交:5:已完成;6:超时提交:7:超时完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser == null ? null : checkUser.trim();
    }

    public String getFillUser() {
        return fillUser;
    }

    public void setFillUser(String fillUser) {
        this.fillUser = fillUser == null ? null : fillUser.trim();
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getFillTaskCode() {
        return fillTaskCode;
    }

    public void setFillTaskCode(String fillTaskCode) {
        this.fillTaskCode = fillTaskCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getIsOutTime() {
        isOutTime = 0;
        if(this.getStatus()!=null){
            if(this.getStatus()==1||this.getStatus()==2||this.getStatus()==0){
                if(this.getEndTime()!=null){
                    if(this.getEndTime().getTime()<System.currentTimeMillis()){
                        isOutTime = 1;
                    }
                }
            }
        }

        return isOutTime;
    }

    public void setIsOutTime(Integer isOutTime) {
        this.isOutTime = isOutTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getFillUserName() {
        return fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName;
    }

    @Override
    public String toString() {
        return "TbFillFormTask{" +
                "fillTaskNo='" + fillTaskNo + '\'' +
                ", fillTaskTime=" + fillTaskTime +
                ", fillTaskUserNo='" + fillTaskUserNo + '\'' +
                ", fillCountAll=" + fillCountAll +
                ", fillCount=" + fillCount +
                ", factoryNo='" + factoryNo + '\'' +
                ", equipStatus=" + equipStatus +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", commitTime=" + commitTime +
                ", createUser='" + createUser + '\'' +
                ", status=" + status +
                ", checkUser='" + checkUser + '\'' +
                ", checkUserName='" + checkUserName + '\'' +
                ", fillUser='" + fillUser + '\'' +
                ", fillUserName='" + fillUserName + '\'' +
                ", fillTaskCode='" + fillTaskCode + '\'' +
                ", taskType=" + taskType +
                ", flag='" + flag + '\'' +
                ", isOutTime=" + isOutTime +
                '}';
    }
}
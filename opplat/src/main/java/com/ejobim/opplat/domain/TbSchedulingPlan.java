package com.ejobim.opplat.domain;

import java.util.Date;
import java.util.List;

public class TbSchedulingPlan {
    private String schedulingNo;

    private String factoryNo;

    private Integer groupType;

    private String groupNo;

    private String groupName;

    private Date startTimePoint;

    private Date endTimePoint;

    private String timeNo;

    private Integer dayType;

    private String schedulingTime;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private String updateUserName;

    private String updateUserCode;

    private Date updateTime;

    private Integer flag;

    private List<String> userNameList;

    private List<TbSchedulingPlan> schedulingPlanList;

    private String startTimePointName;

    private String endTimePointName;
    
    private  List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList;

    private String startTime;

    private String endTime;
    
    private String userCode;
    
    private String userName;
    
    private Integer dictId;
    
    private String transferCode;

    private String scheduleRule;
    
    public String getSchedulingNo() {
        return schedulingNo;
    }

    public void setSchedulingNo(String schedulingNo) {
        this.schedulingNo = schedulingNo == null ? null : schedulingNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getStartTimePoint() {
        return startTimePoint;
    }

    public void setStartTimePoint(Date startTimePoint) {
        this.startTimePoint = startTimePoint;
    }

    public Date getEndTimePoint() {
        return endTimePoint;
    }

    public void setEndTimePoint(Date endTimePoint) {
        this.endTimePoint = endTimePoint;
    }

    public String getTimeNo() {
        return timeNo;
    }

    public void setTimeNo(String timeNo) {
        this.timeNo = timeNo == null ? null : timeNo.trim();
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public String getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(String schedulingTime) {
        this.schedulingTime = schedulingTime == null ? null : schedulingTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    public List<TbSchedulingPlan> getSchedulingPlanList() {
        return schedulingPlanList;
    }

    public void setSchedulingPlanList(List<TbSchedulingPlan> schedulingPlanList) {
        this.schedulingPlanList = schedulingPlanList;
    }

    public String getStartTimePointName() {
        return startTimePointName;
    }

    public void setStartTimePointName(String startTimePointName) {
        this.startTimePointName = startTimePointName;
    }

    public String getEndTimePointName() {
        return endTimePointName;
    }

    public void setEndTimePointName(String endTimePointName) {
        this.endTimePointName = endTimePointName;
    }

    public List<TbSchedulingPlanDeatail> getTbSchedulingPlanDeatailList() {
        return tbSchedulingPlanDeatailList;
    }

    public void setTbSchedulingPlanDeatailList(List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList) {
        this.tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailList;
    }

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getScheduleRule() {
        return scheduleRule;
    }

    public void setScheduleRule(String scheduleRule) {
        this.scheduleRule = scheduleRule;
    }
}
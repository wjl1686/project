package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWorkTaskInfo {
    private String taskNo;

    private String workFlowConfigNo;

    private String taskName;

    private Date createTime;

    private String createUser;

    private String createUserName;

    private String nextRole;

    private String nextRoleName;

    private String statusCode;

    private String statusCodeName;

    private String nextStatusCode;

    private String nextStatusCodeName;

    private Integer nextPlat;

    private Date updateTime;

    private Integer deleteFlag;

    private String orgNo;

    private Integer statusIndex;

    private Integer nextStatusIndex;

    private Integer taskType;

    private Integer isEntrust;

    private Integer urgencyDegree;

    private Integer isTemp;

    private Date planStartTime;

    private Date realStartTime;

    private Date realFinishTime;

    private String planCode;

    private String taskCode;

    private String taskFrom;

    private Date planFinishTime;

    private Double planUseTime;

    private String equipNo;

    private String taskContent;

    private String equipLocation;

    private String equipName;

    private String fatiName;

    private String dutyUser;

    private Integer taskStatus;

    private String relatedUser;

    private String nextUser;

    private String assistUser;

    private String checkUser;

    private Integer isRepeat;

    private Boolean enableCommit;

    private String equipList;

    private Double workingHours;

    private String extendInfo;

    // 0 查询大于planstaime 1 等于
    private Integer source;

    //是否影响后续计划 0是 1否
    private Integer whether;

    private String groupName;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    public String getWorkFlowConfigNo() {
        return workFlowConfigNo;
    }

    public void setWorkFlowConfigNo(String workFlowConfigNo) {
        this.workFlowConfigNo = workFlowConfigNo == null ? null : workFlowConfigNo.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getNextRole() {
        return nextRole;
    }

    public void setNextRole(String nextRole) {
        this.nextRole = nextRole == null ? null : nextRole.trim();
    }

    public String getNextRoleName() {
        return nextRoleName;
    }

    public void setNextRoleName(String nextRoleName) {
        this.nextRoleName = nextRoleName == null ? null : nextRoleName.trim();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public String getStatusCodeName() {
        return statusCodeName;
    }

    public void setStatusCodeName(String statusCodeName) {
        this.statusCodeName = statusCodeName == null ? null : statusCodeName.trim();
    }

    public String getNextStatusCode() {
        return nextStatusCode;
    }

    public void setNextStatusCode(String nextStatusCode) {
        this.nextStatusCode = nextStatusCode == null ? null : nextStatusCode.trim();
    }

    public String getNextStatusCodeName() {
        return nextStatusCodeName;
    }

    public void setNextStatusCodeName(String nextStatusCodeName) {
        this.nextStatusCodeName = nextStatusCodeName == null ? null : nextStatusCodeName.trim();
    }

    public Integer getNextPlat() {
        return nextPlat;
    }

    public void setNextPlat(Integer nextPlat) {
        this.nextPlat = nextPlat;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }

    public Integer getNextStatusIndex() {
        return nextStatusIndex;
    }

    public void setNextStatusIndex(Integer nextStatusIndex) {
        this.nextStatusIndex = nextStatusIndex;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getIsEntrust() {
        return isEntrust;
    }

    public void setIsEntrust(Integer isEntrust) {
        this.isEntrust = isEntrust;
    }

    public Integer getUrgencyDegree() {
        return urgencyDegree;
    }

    public void setUrgencyDegree(Integer urgencyDegree) {
        this.urgencyDegree = urgencyDegree;
    }

    public Integer getIsTemp() {
        return isTemp;
    }

    public void setIsTemp(Integer isTemp) {
        this.isTemp = isTemp;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public String getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(String taskFrom) {
        this.taskFrom = taskFrom == null ? null : taskFrom.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Date planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    public Double getPlanUseTime() {
        return planUseTime;
    }

    public void setPlanUseTime(Double planUseTime) {
        this.planUseTime = planUseTime;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public String getEquipLocation() {
        if("01".equals(equipLocation)) {
            return "进水段";
        }
        if("02".equals(equipLocation)){
            return "提升段";
        }
        if("03".equals(equipLocation)){
            return "初沉段";
        }
        if("04".equals(equipLocation)){
            return "生化处理段";
        }
        if("05".equals(equipLocation)){
            return "二沉段";
        }
        if("06".equals(equipLocation)){
            return "脱水段";
        }
        if("07".equals(equipLocation)){
            return "深水处理段";
        }
        if("08".equals(equipLocation)){
            return "电力高压段";
        }
        if("09".equals(equipLocation)){
            return "电力低压段";
        }
        if("99".equals(equipLocation)) {
            return "其他段";
        }
        return equipLocation;
    }

    public void setEquipLocation(String equipLocation) {
        this.equipLocation = equipLocation;
    }


    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser == null ? null : dutyUser.trim();
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRelatedUser() {
        return relatedUser;
    }

    public void setRelatedUser(String relatedUser) {
        this.relatedUser = relatedUser == null ? null : relatedUser.trim();
    }

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser == null ? null : nextUser.trim();
    }

    public String getAssistUser() {
        return assistUser;
    }

    public void setAssistUser(String assistUser) {
        this.assistUser = assistUser == null ? null : assistUser.trim();
    }

    public Integer getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Integer isRepeat) {
        this.isRepeat = isRepeat;
    }

    /**
     * 是否可提交
     * @return
     */
    public Boolean getEnableCommit() {
        return enableCommit;
    }

    /**
     * 设置是否可以进行提交操作
     * @param enableCommit
     */
    public void setEnableCommit(Boolean enableCommit) {
        this.enableCommit = enableCommit;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getFatiName() {
        return fatiName;
    }

    public void setFatiName(String fatiName) {
        this.fatiName = fatiName;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser == null ? null : checkUser.trim();
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList == null ? null : equipList.trim();
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    public Integer getWhether() {
        return whether;
    }

    public void setWhether(Integer whether) {
        this.whether = whether;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRealFinishTime() {
        return realFinishTime;
    }

    public void setRealFinishTime(Date realFinishTime) {
        this.realFinishTime = realFinishTime;
    }
}
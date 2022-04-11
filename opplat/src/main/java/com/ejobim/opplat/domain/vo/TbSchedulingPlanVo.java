package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.ExcelColumn;
import com.ejobim.opplat.domain.TbSchedulingPlanDeatail;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbSchedulingPlanVo {
    
    private String schedulingNo;
    
    private String factoryNo;
    @ExcelColumn(value = "水厂名称",col = 1)
    private String factoryName;

   
    private Integer groupType;
    
    @ExcelColumn(value = "班组类型",col = 2)
    private String groupTypeName;

    private String groupNo;
    @ExcelColumn(value = "班组名称",col = 3)
    private String groupName;

    @ExcelColumn(value = "成员",col = 4)
    private String chengUser;
    
    @ExcelColumn(value = "班长",col = 5)
    private String banUser;
   
    private Date startTimePoint;
    @ExcelColumn(value = "排班开始时间点",col = 6)
    private String startTimePointName;
    
    private Date endTimePoint;
    
    @ExcelColumn(value = "排班截止时间点",col = 7)
    private String endTimePointName;

    @ExcelColumn(value = "排班日期",col = 8)
    private String schedulingTime;
   
    private Integer dayType;
    
    @ExcelColumn(value = "日期类型",col = 9)
    private String dayTypeName;

   
    private Date createTime;
    
    @ExcelColumn(value = "创建时间",col = 10)
    private String createTimeName;
    
    private String createUserCode;
    
    @ExcelColumn(value = "创建人",col = 11)
    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;
    
    private String  schedulingNoDetail;

    private Integer flag;

    private List<String> userNameList;
    
    private  List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList;
    
    
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    public Date getStartTimePoint() {
        return startTimePoint;
    }

    public void setStartTimePoint(Date startTimePoint) {
        this.startTimePoint = startTimePoint;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    public Date getEndTimePoint() {
        return endTimePoint;
    }

    public void setEndTimePoint(Date endTimePoint) {
        this.endTimePoint = endTimePoint;
    }

    public String getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(String schedulingTime) {
        this.schedulingTime = schedulingTime == null ? null : schedulingTime.trim();
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
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
    
    public List<TbSchedulingPlanDeatail> getTbSchedulingPlanDeatailList() {
        return tbSchedulingPlanDeatailList;
    }

    public void setTbSchedulingPlanDeatailList(List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList) {
        this.tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailList;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getGroupTypeName() {
        return groupTypeName;
    }

    public void setGroupTypeName(String groupTypeName) {
        this.groupTypeName = groupTypeName;
    }

    public String getDayTypeName() {
        return dayTypeName;
    }

    public void setDayTypeName(String dayTypeName) {
        this.dayTypeName = dayTypeName;
    }

    public String getSchedulingNoDetail() {
        return schedulingNoDetail;
    }

    public void setSchedulingNoDetail(String schedulingNoDetail) {
        this.schedulingNoDetail = schedulingNoDetail;
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

    public String getCreateTimeName() {
        return createTimeName;
    }

    public void setCreateTimeName(String createTimeName) {
        this.createTimeName = createTimeName;
    }

    public String getChengUser() {
        return chengUser;
    }

    public void setChengUser(String chengUser) {
        this.chengUser = chengUser;
    }

    public String getBanUser() {
        return banUser;
    }

    public void setBanUser(String banUser) {
        this.banUser = banUser;
    }
}
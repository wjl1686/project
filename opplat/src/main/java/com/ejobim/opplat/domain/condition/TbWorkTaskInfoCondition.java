package com.ejobim.opplat.domain.condition;

import com.ejobim.opplat.domain.TbWorkTaskInfo;

import java.util.List;

/**
 * @author wujianlong
 * @Description: 计划查询条件实体
 * @date 2019/1/18 10:40
 */
public class TbWorkTaskInfoCondition {

    private String factoryUri;
    
    private String factoryNo;

    private Integer year;
    
    private Integer mouth;
    // 0:全部 1:运行班组 2,设备班组
    private Integer type;

    private String startTime;

    private String endTime;

    private String groupNo;
    
    private String userCode;
    
    private String currentTime;
    
    //来源1 pc 2 app
    private Integer source;
    
    private String roleNo;

    private String roleCode;
    
    private String orgCode;
    
    private List<TbWorkTaskInfo> tbWorkTaskInfoList;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMouth() {
        return mouth;
    }

    public void setMouth(Integer mouth) {
        this.mouth = mouth;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public List<TbWorkTaskInfo> getTbWorkTaskInfoList() {
        return tbWorkTaskInfoList;
    }

    public void setTbWorkTaskInfoList(List<TbWorkTaskInfo> tbWorkTaskInfoList) {
        this.tbWorkTaskInfoList = tbWorkTaskInfoList;
    }

    public String getFactoryUri() {
        return factoryUri;
    }

    public void setFactoryUri(String factoryUri) {
        this.factoryUri = factoryUri;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
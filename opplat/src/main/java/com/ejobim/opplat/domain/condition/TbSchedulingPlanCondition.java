package com.ejobim.opplat.domain.condition;

public class TbSchedulingPlanCondition {

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

    private String schedulingTime;
    //来源1 pc 2 app
    private Integer source;
    
    private Integer dictId;
    
    private String transferCode;

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

    public String getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(String schedulingTime) {
        this.schedulingTime = schedulingTime;
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
}
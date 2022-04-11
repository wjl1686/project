package com.ejobim.opplat.domain;

import java.util.Date;

public class TbFillFormFieldExtend {
    private Integer id;

    private String startTime;

    private String stTime;

    private Integer type;

    private Integer cycle;

    private String week;

    private String mouth;

    private String configNo;

    private Date createTime;

    private String vaildTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStTime() {
        return stTime;
    }

    public void setStTime(String stTime) {
        this.stTime = stTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth == null ? null : mouth.trim();
    }

    public String getConfigNo() {
        return configNo;
    }

    public void setConfigNo(String configNo) {
        this.configNo = configNo == null ? null : configNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVaildTime() {
        return vaildTime;
    }

    public void setVaildTime(String vaildTime) {
        this.vaildTime = vaildTime == null ? null : vaildTime.trim();
    }
}
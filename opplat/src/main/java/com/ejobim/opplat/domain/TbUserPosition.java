package com.ejobim.opplat.domain;

import java.util.Date;

public class TbUserPosition {
    private Integer id;

    private String userCode;

    private String lng;

    private String lat;

    private Date createTime;

    private String inspTaskCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInspTaskCode() {
        return inspTaskCode;
    }

    public void setInspTaskCode(String inspTaskCode) {
        this.inspTaskCode = inspTaskCode == null ? null : inspTaskCode.trim();
    }
}
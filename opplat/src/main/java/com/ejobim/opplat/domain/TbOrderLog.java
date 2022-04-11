package com.ejobim.opplat.domain;

public class TbOrderLog {
    private Integer id;

    private String orderNo;

    private Integer orderType;

    private String beforeUser;

    private String beforeUserNo;

    private String afterUser;

    private String afterUserNo;

    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getBeforeUser() {
        return beforeUser;
    }

    public void setBeforeUser(String beforeUser) {
        this.beforeUser = beforeUser == null ? null : beforeUser.trim();
    }

    public String getBeforeUserNo() {
        return beforeUserNo;
    }

    public void setBeforeUserNo(String beforeUserNo) {
        this.beforeUserNo = beforeUserNo == null ? null : beforeUserNo.trim();
    }

    public String getAfterUser() {
        return afterUser;
    }

    public void setAfterUser(String afterUser) {
        this.afterUser = afterUser == null ? null : afterUser.trim();
    }

    public String getAfterUserNo() {
        return afterUserNo;
    }

    public void setAfterUserNo(String afterUserNo) {
        this.afterUserNo = afterUserNo == null ? null : afterUserNo.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}
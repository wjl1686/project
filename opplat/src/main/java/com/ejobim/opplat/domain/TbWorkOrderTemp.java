package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWorkOrderTemp {
    private String orderId;

    private String orderName;

    private String orderDetail;

    private String orderDuty;

    private String orderDutyName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderEndTime;

    private String createUser;

    private String createUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderFinishTime;

    private String orderFinishPictures;

    private String orderFinishVideo;

    private String tbWorkOrderContent;

    private String orderFactoryNo;

    private String orderCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail == null ? null : orderDetail.trim();
    }

    public String getOrderDuty() {
        return orderDuty;
    }

    public void setOrderDuty(String orderDuty) {
        this.orderDuty = orderDuty == null ? null : orderDuty.trim();
    }

    public String getOrderDutyName() {
        return orderDutyName;
    }

    public void setOrderDutyName(String orderDutyName) {
        this.orderDutyName = orderDutyName == null ? null : orderDutyName.trim();
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
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


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    public String getOrderFinishPictures() {
        return orderFinishPictures;
    }

    public void setOrderFinishPictures(String orderFinishPictures) {
        this.orderFinishPictures = orderFinishPictures == null ? null : orderFinishPictures.trim();
    }

    public String getOrderFinishVideo() {
        return orderFinishVideo;
    }

    public void setOrderFinishVideo(String orderFinishVideo) {
        this.orderFinishVideo = orderFinishVideo == null ? null : orderFinishVideo.trim();
    }

    public String getTbWorkOrderContent() {
        return tbWorkOrderContent;
    }

    public void setTbWorkOrderContent(String tbWorkOrderContent) {
        this.tbWorkOrderContent = tbWorkOrderContent == null ? null : tbWorkOrderContent.trim();
    }

    public String getOrderFactoryNo() {
        return orderFactoryNo;
    }

    public void setOrderFactoryNo(String orderFactoryNo) {
        this.orderFactoryNo = orderFactoryNo == null ? null : orderFactoryNo.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }
}
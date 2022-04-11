package com.ejobim.opplat.domain;

import java.util.Date;

public class TbAnnouncement {
    private String annoucementNo;

    private String title;

    private Date publishTime;

    private Integer ifCancel;

    private Date cancelTime;

    private Integer delFlag;

    private Date deleteTime;

    private Date createTime;

    private String createUser;

    private String content;

    public String getAnnoucementNo() {
        return annoucementNo;
    }

    public void setAnnoucementNo(String annoucementNo) {
        this.annoucementNo = annoucementNo == null ? null : annoucementNo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getIfCancel() {
        return ifCancel;
    }

    public void setIfCancel(Integer ifCancel) {
        this.ifCancel = ifCancel;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbAnalysisFillTask {
    private String fillTaskNo;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fillTaskTime;

    private Integer fillCountAll;

    private Integer fillCount;

    private String factoryNo;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Integer status;

    private String fillUserCode;

    private String fillUserName;

    private String checkUserCode;

    private String checkUserName;

    private String fillTaskCode;

    private Integer draftStatus;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date commitTime;

    public String getFillTaskNo() {
        return fillTaskNo;
    }

    public void setFillTaskNo(String fillTaskNo) {
        this.fillTaskNo = fillTaskNo == null ? null : fillTaskNo.trim();
    }

    public Date getFillTaskTime() {
        return fillTaskTime;
    }

    public void setFillTaskTime(Date fillTaskTime) {
        this.fillTaskTime = fillTaskTime;
    }

    public Integer getFillCountAll() {
        return fillCountAll;
    }

    public void setFillCountAll(Integer fillCountAll) {
        this.fillCountAll = fillCountAll;
    }

    public Integer getFillCount() {
        return fillCount;
    }

    public void setFillCount(Integer fillCount) {
        this.fillCount = fillCount;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFillUserCode() {
        return fillUserCode;
    }

    public void setFillUserCode(String fillUserCode) {
        this.fillUserCode = fillUserCode == null ? null : fillUserCode.trim();
    }

    public String getFillUserName() {
        return fillUserName;
    }

    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName == null ? null : fillUserName.trim();
    }

    public String getCheckUserCode() {
        return checkUserCode;
    }

    public void setCheckUserCode(String checkUserCode) {
        this.checkUserCode = checkUserCode == null ? null : checkUserCode.trim();
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName == null ? null : checkUserName.trim();
    }

    public String getFillTaskCode() {
        return fillTaskCode;
    }

    public void setFillTaskCode(String fillTaskCode) {
        this.fillTaskCode = fillTaskCode == null ? null : fillTaskCode.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    /**
     * 是否加入底稿
     * @return
     */
    public Integer getDraftStatus() {
        return draftStatus;
    }

    public void setDraftStatus(Integer draftStatus) {
        this.draftStatus = draftStatus;
    }
}
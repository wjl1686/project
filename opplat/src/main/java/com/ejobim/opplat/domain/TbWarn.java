package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbWarn {
    private String warnNo;

    private Integer status;

    private Date createTime;

    private String createUse;

    private String content;

    public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo == null ? null : warnNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUse() {
        return createUse;
    }

    public void setCreateUse(String createUse) {
        this.createUse = createUse == null ? null : createUse.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
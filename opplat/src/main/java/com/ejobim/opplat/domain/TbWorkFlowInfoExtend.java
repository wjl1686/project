package com.ejobim.opplat.domain;

public class TbWorkFlowInfoExtend {
    private String extendNo;

    private String flowNo;

    private String orgNo;

    private String statusCode;

    private Integer extendType;

    private String roleList;

    private String extendOrgNo;

    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public Integer getExtendType() {
        return extendType;
    }

    public void setExtendType(Integer extendType) {
        this.extendType = extendType;
    }

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList == null ? null : roleList.trim();
    }

    public String getExtendOrgNo() {
        return extendOrgNo;
    }

    public void setExtendOrgNo(String extendOrgNo) {
        this.extendOrgNo = extendOrgNo == null ? null : extendOrgNo.trim();
    }
}
package com.ejobim.opplat.domain;

public class OrgGroupInfo {
    private Integer id;

    private String groupName;

    private String parentOrg;

    private Object groupDetailInfo;

    private String groupNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(String parentOrg) {
        this.parentOrg = parentOrg == null ? null : parentOrg.trim();
    }

    public Object getGroupDetailInfo() {
        return groupDetailInfo;
    }

    public void setGroupDetailInfo(Object groupDetailInfo) {
        this.groupDetailInfo = groupDetailInfo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }
}
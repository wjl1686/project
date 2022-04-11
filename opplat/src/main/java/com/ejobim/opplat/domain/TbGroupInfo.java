package com.ejobim.opplat.domain;

import java.util.Date;
import java.util.List;

public class TbGroupInfo {
    private String groupNo;

    private String groupName;

    private Integer groupType;

    private String factoryNo;

    private Integer memberCount;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private Integer flag;

    private String uri;

    private String code;

    private Integer leader;

    private String userCode;

    private String name;

    private List<TbGroupInfo> memberList;

    private List<TbGroupDetail> tbGroupDetailList;
    
    private List<TbUser> userList;

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TbGroupInfo> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<TbGroupInfo> memberList) {
        this.memberList = memberList;
    }

    public List<TbGroupDetail> getTbGroupDetailList() {
        return tbGroupDetailList;
    }

    public void setTbGroupDetailList(List<TbGroupDetail> tbGroupDetailList) {
        this.tbGroupDetailList = tbGroupDetailList;
    }

    public List<TbUser> getUserList() {
        return userList;
    }

    public void setUserList(List<TbUser> userList) {
        this.userList = userList;
    }
}
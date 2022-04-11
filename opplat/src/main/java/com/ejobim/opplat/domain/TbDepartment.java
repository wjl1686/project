package com.ejobim.opplat.domain;

import java.util.Date;

public class TbDepartment {
    private String departmentNo;

    private Integer id;

    private String departmentName;

    private String parentDepartmentNo;

    private String departmentManager;

    private Integer departmentType;

    private String typeName;

    private Date createTime;

    public String getDepartmentNo() {
        return departmentNo;
    }


    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo == null ? null : departmentNo.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getParentDepartmentNo() {
        return parentDepartmentNo;
    }

    public void setParentDepartmentNo(String parentDepartmentNo) {
        this.parentDepartmentNo = parentDepartmentNo == null ? null : parentDepartmentNo.trim();
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager == null ? null : departmentManager.trim();
    }

    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
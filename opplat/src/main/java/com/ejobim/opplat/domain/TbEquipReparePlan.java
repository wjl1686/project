package com.ejobim.opplat.domain;

import java.util.Date;

public class TbEquipReparePlan {
    private String rpNo;

    private Date planFinishTime;

    private Integer maintainType;

    private String flowNo;

    public String getRpNo() {
        return rpNo;
    }

    public void setRpNo(String rpNo) {
        this.rpNo = rpNo == null ? null : rpNo.trim();
    }

    public Date getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Date planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    public Integer getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(Integer maintainType) {
        this.maintainType = maintainType;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }
}
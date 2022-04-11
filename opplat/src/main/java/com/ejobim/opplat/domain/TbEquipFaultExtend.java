package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbEquipFaultExtend implements WorkFlowExtendI {
    private String id;

    private String extendNo;

    private Date planFinishTime;

    private Integer maintainType;

    private Integer nextType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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

    public Integer getNextType() {
        return nextType;
    }

    public void setNextType(Integer nextType) {
        this.nextType = nextType;
    }
}
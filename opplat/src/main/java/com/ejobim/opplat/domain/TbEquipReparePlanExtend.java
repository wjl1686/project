package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class TbEquipReparePlanExtend implements WorkFlowExtendI {
    private String planExtendNo;

    private String extendNo;

    private Integer planUrgency;

    private Integer isEntrust;

    private Double planCost;

    private String planContent;

    private String tbEquipReparePlanExtendcol;

    public String getPlanExtendNo() {
        return planExtendNo;
    }

    public void setPlanExtendNo(String planExtendNo) {
        this.planExtendNo = planExtendNo == null ? null : planExtendNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public Integer getPlanUrgency() {
        return planUrgency;
    }

    public void setPlanUrgency(Integer planUrgency) {
        this.planUrgency = planUrgency;
    }

    public Integer getIsEntrust() {
        return isEntrust;
    }

    public void setIsEntrust(Integer isEntrust) {
        this.isEntrust = isEntrust;
    }

    public Double getPlanCost() {
        return planCost;
    }

    public void setPlanCost(Double planCost) {
        this.planCost = planCost;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getTbEquipReparePlanExtendcol() {
        return tbEquipReparePlanExtendcol;
    }

    public void setTbEquipReparePlanExtendcol(String tbEquipReparePlanExtendcol) {
        this.tbEquipReparePlanExtendcol = tbEquipReparePlanExtendcol == null ? null : tbEquipReparePlanExtendcol.trim();
    }
}
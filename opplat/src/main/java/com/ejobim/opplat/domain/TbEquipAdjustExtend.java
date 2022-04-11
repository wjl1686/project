package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

public class TbEquipAdjustExtend implements WorkFlowExtendI {
    private String adDetailNo;

    private String extendNo;

    private String stepIdea;

    private String stepRemark;

    public String getAdDetailNo() {
        return adDetailNo;
    }

    public void setAdDetailNo(String adDetailNo) {
        this.adDetailNo = adDetailNo == null ? null : adDetailNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getStepIdea() {
        return stepIdea;
    }

    public void setStepIdea(String stepIdea) {
        this.stepIdea = stepIdea == null ? null : stepIdea.trim();
    }

    public String getStepRemark() {
        return stepRemark;
    }

    public void setStepRemark(String stepRemark) {
        this.stepRemark = stepRemark == null ? null : stepRemark.trim();
    }
}
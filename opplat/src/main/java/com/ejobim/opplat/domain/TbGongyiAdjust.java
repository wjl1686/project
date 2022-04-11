package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

/**
 * @author xibian
 */
public class TbGongyiAdjust implements WorkFlowExtendI {
    private String adjustNo;

    private String flowNo;

    private String adjustName;

    private Integer adjustType;

    private String adjustContent;

    private String adjustAddon;

    private TbWorkFlow workFlow;

    public String getAdjustNo() {
        return adjustNo;
    }

    public void setAdjustNo(String adjustNo) {
        this.adjustNo = adjustNo == null ? null : adjustNo.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getAdjustName() {
        return adjustName;
    }

    public void setAdjustName(String adjustName) {
        this.adjustName = adjustName == null ? null : adjustName.trim();
    }

    public Integer getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Integer adjustType) {
        this.adjustType = adjustType;
    }

    public String getAdjustContent() {
        return adjustContent;
    }

    public void setAdjustContent(String adjustContent) {
        this.adjustContent = adjustContent == null ? null : adjustContent.trim();
    }

    public String getAdjustAddon() {
        return adjustAddon;
    }

    public void setAdjustAddon(String adjustAddon) {
        this.adjustAddon = adjustAddon == null ? null : adjustAddon.trim();
    }

    public TbWorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(TbWorkFlow workFlow) {
        this.workFlow = workFlow;
    }

    @Override
    public String getExtendNo() {
        return flowNo;
    }
}
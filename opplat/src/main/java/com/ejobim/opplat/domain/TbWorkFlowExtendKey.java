package com.ejobim.opplat.domain;

public class TbWorkFlowExtendKey {
    private String extendNo;

    private String flowNo;

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
}
package com.ejobim.opplat.domain;

public class TbEquipAdjust {
    private String adNo;

    private String adName;

    private String adContent;

    private String adEquipList;

    private String adEquipnameList;

    private String flowNo;

    private TbWorkFlow workFlow;

    public String getAdNo() {
        return adNo;
    }

    public void setAdNo(String adNo) {
        this.adNo = adNo == null ? null : adNo.trim();
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent == null ? null : adContent.trim();
    }

    public String getAdEquipList() {
        return adEquipList;
    }

    public void setAdEquipList(String adEquipList) {
        this.adEquipList = adEquipList == null ? null : adEquipList.trim();
    }

    public String getAdEquipnameList() {
        return adEquipnameList;
    }

    public void setAdEquipnameList(String adEquipnameList) {
        this.adEquipnameList = adEquipnameList == null ? null : adEquipnameList.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public TbWorkFlow getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(TbWorkFlow workFlow) {
        this.workFlow = workFlow;
    }
}
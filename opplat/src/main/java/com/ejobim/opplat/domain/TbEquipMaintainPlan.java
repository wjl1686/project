package com.ejobim.opplat.domain;

import java.util.Date;

public class TbEquipMaintainPlan {
    private String planNo;

    private String equipNo;

    private String equipName;

    private String equipTypeName;

    private String equipLocationName;

    private Integer isEntrust;

    private Integer planYear;

    private Integer planCircle;

    private Double planCost;

    private Double realCost;

    private Integer planType;

    private String planContent;

    private String planAddon;

    private Integer taskType;

    private Date planUpdateTime;

    private String flowNo;

    private TbWorkFlow workFlow;

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName == null ? null : equipTypeName.trim();
    }

    public String getEquipLocationName() {
        return equipLocationName;
    }

    public void setEquipLocationName(String equipLocationName) {
        this.equipLocationName = equipLocationName == null ? null : equipLocationName.trim();
    }

    public Integer getIsEntrust() {
        return isEntrust;
    }

    public void setIsEntrust(Integer isEntrust) {
        this.isEntrust = isEntrust;
    }

    public Integer getPlanYear() {
        return planYear;
    }

    public void setPlanYear(Integer planYear) {
        this.planYear = planYear;
    }

    public Integer getPlanCircle() {
        return planCircle;
    }

    public void setPlanCircle(Integer planCircle) {
        this.planCircle = planCircle;
    }

    public Double getPlanCost() {
        return planCost;
    }

    public void setPlanCost(Double planCost) {
        this.planCost = planCost;
    }

    public Double getRealCost() {
        return realCost;
    }

    public void setRealCost(Double realCost) {
        this.realCost = realCost;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPlanAddon() {
        return planAddon;
    }

    public void setPlanAddon(String planAddon) {
        this.planAddon = planAddon == null ? null : planAddon.trim();
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getPlanUpdateTime() {
        return planUpdateTime;
    }

    public void setPlanUpdateTime(Date planUpdateTime) {
        this.planUpdateTime = planUpdateTime;
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
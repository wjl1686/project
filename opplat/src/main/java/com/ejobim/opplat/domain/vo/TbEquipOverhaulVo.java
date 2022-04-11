package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.ExcelColumn;
import com.ejobim.opplat.domain.TbWorkTaskInfo;

/**
 * @author wjl
 *  大修导出模板类
 */
public class TbEquipOverhaulVo extends TbWorkTaskInfo {
    
    @ExcelColumn(value = "设备名称",col = 1)
    private String equipName;
    
    private String equipNo;
    
    private String orgNo;
    
    @ExcelColumn(value = "预算（含税金额）万元",col = 2)
    private Double planCost;
    
    @ExcelColumn(value = "预算（不含税）万元",col = 3)
    private Double realCost;
    
    @ExcelColumn(value = "参照税率(X.00%)",col = 4)
    private String taxRate;

    @ExcelColumn(value = "预算计算明细",col = 5)
    private String overhaulContent;

    @ExcelColumn(value = "项目类型",col = 6)
    private String  overhaulSanitationOkType; // 1,大修 2,重置  3 改造 4,新增  [{"key":1,"value":"大修"},{"key":2,"value":"重置"},{"key":3,"value":"改造"},{"key":4,"value":"新增"}]

    private Integer  overhaulSanitationOk;

    @ExcelColumn(value = "是否委外",col = 7)
    private String isEntrustType; // 0不委外 1委外

    private Integer isEntrust;

    @ExcelColumn(value = "计划实施时间(yyyy-MM)",col = 8)
    private String planTime;

    @ExcelColumn(value = "实施原因",col = 9)
    private String overhaulVideo;

    @ExcelColumn(value = "大修目标",col = 10)
    private String taskContent;

    @Override
    public String getEquipName() {
        return equipName;
    }
    @Override
    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }
    @Override
    public String getEquipNo() {
        return equipNo;
    }
    @Override
    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }
    @Override
    public String getOrgNo() {
        return orgNo;
    }
    @Override
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
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

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getOverhaulContent() {
        return overhaulContent;
    }

    public void setOverhaulContent(String overhaulContent) {
        this.overhaulContent = overhaulContent;
    }

    public String getOverhaulSanitationOkType() {
        return overhaulSanitationOkType;
    }

    public void setOverhaulSanitationOkType(String overhaulSanitationOkType) {
        this.overhaulSanitationOkType = overhaulSanitationOkType;
    }

    public Integer getOverhaulSanitationOk() {
        return overhaulSanitationOk;
    }

    public void setOverhaulSanitationOk(Integer overhaulSanitationOk) {
        this.overhaulSanitationOk = overhaulSanitationOk;
    }

    public String getIsEntrustType() {
        return isEntrustType;
    }

    public void setIsEntrustType(String isEntrustType) {
        this.isEntrustType = isEntrustType;
    }

    @Override
    public Integer getIsEntrust() {
        return isEntrust;
    }
    @Override
    public void setIsEntrust(Integer isEntrust) {
        this.isEntrust = isEntrust;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getOverhaulVideo() {
        return overhaulVideo;
    }

    public void setOverhaulVideo(String overhaulVideo) {
        this.overhaulVideo = overhaulVideo;
    }

    @Override
    public String getTaskContent() {
        return taskContent;
    }

    @Override
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}

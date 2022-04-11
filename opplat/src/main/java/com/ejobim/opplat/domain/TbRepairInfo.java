package com.ejobim.opplat.domain;

import java.util.Date;

public class TbRepairInfo {
    private Integer id;

    private String repairNo;

    private String repairPersonLiable;

    private String repairPersonExecutive;

    private Date repairTime;

    private String repairFault;

    private Integer repairLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo == null ? null : repairNo.trim();
    }

    public String getRepairPersonLiable() {
        return repairPersonLiable;
    }

    public void setRepairPersonLiable(String repairPersonLiable) {
        this.repairPersonLiable = repairPersonLiable == null ? null : repairPersonLiable.trim();
    }

    public String getRepairPersonExecutive() {
        return repairPersonExecutive;
    }

    public void setRepairPersonExecutive(String repairPersonExecutive) {
        this.repairPersonExecutive = repairPersonExecutive == null ? null : repairPersonExecutive.trim();
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairFault() {
        return repairFault;
    }

    public void setRepairFault(String repairFault) {
        this.repairFault = repairFault == null ? null : repairFault.trim();
    }

    public Integer getRepairLevel() {
        return repairLevel;
    }

    public void setRepairLevel(Integer repairLevel) {
        this.repairLevel = repairLevel;
    }
}
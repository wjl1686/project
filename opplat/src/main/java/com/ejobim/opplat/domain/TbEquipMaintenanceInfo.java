package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

import java.util.Date;

public class TbEquipMaintenanceInfo implements WorkFlowExtendI {
    private String maintenanceDetailNo;

    private String extendNo;

    private String maintenancePictures;

    private Date updateTime;

    private String maintenanceElementNo;

    private String mentenanceMethod;

    private String mentenanceDescription;

    public String getMaintenanceDetailNo() {
        return maintenanceDetailNo;
    }

    public void setMaintenanceDetailNo(String maintenanceDetailNo) {
        this.maintenanceDetailNo = maintenanceDetailNo == null ? null : maintenanceDetailNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getMaintenancePictures() {
        return maintenancePictures;
    }

    public void setMaintenancePictures(String maintenancePictures) {
        this.maintenancePictures = maintenancePictures == null ? null : maintenancePictures.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMaintenanceElementNo() {
        return maintenanceElementNo;
    }

    public void setMaintenanceElementNo(String maintenanceElementNo) {
        this.maintenanceElementNo = maintenanceElementNo == null ? null : maintenanceElementNo.trim();
    }

    public String getMentenanceMethod() {
        return mentenanceMethod;
    }

    public void setMentenanceMethod(String mentenanceMethod) {
        this.mentenanceMethod = mentenanceMethod == null ? null : mentenanceMethod.trim();
    }

    public String getMentenanceDescription() {
        return mentenanceDescription;
    }

    public void setMentenanceDescription(String mentenanceDescription) {
        this.mentenanceDescription = mentenanceDescription == null ? null : mentenanceDescription.trim();
    }
}
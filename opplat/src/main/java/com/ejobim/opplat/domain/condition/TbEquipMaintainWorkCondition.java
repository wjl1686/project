package com.ejobim.opplat.domain.condition;

import java.util.Date;
import java.util.List;

public class TbEquipMaintainWorkCondition {
    
    private String equipNo;

    private String factoryNo;
    
    private List<String> mfNoLkist;
   /* //0是 1:否
    private Integer  whetherBatch;*/
    
    private Date beginTime;
    
    private Date endTime;

    private String checkUser;

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public List<String> getMfNoLkist() {
        return mfNoLkist;
    }

    public void setMfNoLkist(List<String> mfNoLkist) {
        this.mfNoLkist = mfNoLkist;
    }

 /*   public Integer getWhetherBatch() {
        return whetherBatch;
    }

    public void setWhetherBatch(Integer whetherBatch) {
        this.whetherBatch = whetherBatch;
    }*/

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }
}
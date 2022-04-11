package com.ejobim.opplat.domain.vo;

/**
 * 巡检点
 * @author xibian
 */
public class RoutingLocationVo {
    
    private String locationNo;
    
    private String locationName;
    
    private String ModelName;
    
    private String equipNameList;
    
    private StringBuffer equipBuffer;
    
    private Integer errorCount;

    private Integer needCount;

    private Integer finishCount;

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getEquipNameList() {
        if(equipBuffer!=null){
            return equipBuffer.toString();
        }
        return null;
    }
    public Integer getErrorCount() {
        if(errorCount==null){
            errorCount = 0;
        }
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        if(errorCount==null){
            errorCount = 0;
        }
        this.errorCount = errorCount;
    }

    public void setEquipBuffer(StringBuffer equipBuffer) {
        this.equipBuffer = equipBuffer;
    }

    public StringBuffer getEquipBuffer(){
        if(equipBuffer==null){
            equipBuffer = new StringBuffer();
        }
        return equipBuffer;
    }
    public void setEquipNameList(String equipNameList) {
        this.equipNameList = equipNameList;
    }

    public Integer getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Integer needCount) {
        this.needCount = needCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }
}

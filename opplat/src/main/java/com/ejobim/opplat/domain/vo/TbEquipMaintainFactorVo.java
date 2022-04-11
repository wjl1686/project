package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.ExcelColumn;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbEquipMaintainFactorVo {
    
    private String mfNo;

    private String equipNo;
    @ExcelColumn(value = "设备名称",col = 1)
    private String equipName;

    private String factoryNo;

    @ExcelColumn(value = "维保内容",col = 2)
    private String mfContent;

    private Integer mfType;

    @ExcelColumn(value = "维保周期",col = 3)
    private Integer cycle;

    @ExcelColumn(value = "维保方法",col = 4)
    private String mfAddon;

    private Date createTime;

    private String createUserCode;

    private String createUserName;

    private Date updateTime;

    private String updateUserCode;

    private String updateUserName;

    private Integer flag;
    @ExcelColumn(value = "下次维保时间(格式yyyy-MM-dd)",col = 5)
    private String mfTimeName;
    
    private Date mfTime;
    public String getMfNo() {
        return mfNo;
    }

    public void setMfNo(String mfNo) {
        this.mfNo = mfNo == null ? null : mfNo.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getMfContent() {
        return mfContent;
    }

    public void setMfContent(String mfContent) {
        this.mfContent = mfContent == null ? null : mfContent.trim();
    }

    public Integer getMfType() {
        return mfType;
    }

    public void setMfType(Integer mfType) {
        this.mfType = mfType;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getMfAddon() {
        return mfAddon;
    }

    public void setMfAddon(String mfAddon) {
        this.mfAddon = mfAddon == null ? null : mfAddon.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode == null ? null : createUserCode.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode == null ? null : updateUserCode.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+8")
    public Date getMfTime() {
        return mfTime;
    }

    public void setMfTime(Date mfTime) {
        this.mfTime = mfTime;
    }
    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getMfTimeName() {
        return mfTimeName;
    }

    public void setMfTimeName(String mfTimeName) {
        this.mfTimeName = mfTimeName;
    }
}
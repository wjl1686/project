package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbParameterConfig {
    private String paramNo;

    private Integer fillRate;

    private Integer paramType;

    private String paramName;

    private String paramCode;

    private String paramUnit;

    private Integer paramFillType;

    private Integer paremMathType;

    private Integer paramFrom;

    private String browseName;

    private Integer paramModel;

    private String paramMathCmd;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;
    //添加多个查询条件
    private List<Integer> paramFromList;

    public String getParamNo() {
        return paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo == null ? null : paramNo.trim();
    }

    public Integer getFillRate() {
        return fillRate;
    }

    public void setFillRate(Integer fillRate) {
        this.fillRate = fillRate;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    public String getParamUnit() {
        return paramUnit;
    }

    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit == null ? null : paramUnit.trim();
    }

    public Integer getParamFillType() {
        return paramFillType;
    }

    public void setParamFillType(Integer paramFillType) {
        this.paramFillType = paramFillType;
    }

    public Integer getParemMathType() {
        return paremMathType;
    }

    public void setParemMathType(Integer paremMathType) {
        this.paremMathType = paremMathType;
    }

    public Integer getParamFrom() {
        return paramFrom;
    }

    public void setParamFrom(Integer paramFrom) {
        this.paramFrom = paramFrom;
    }

    public String getBrowseName() {
        return browseName;
    }

    public void setBrowseName(String browseName) {
        this.browseName = browseName == null ? null : browseName.trim();
    }

    public Integer getParamModel() {
        return paramModel;
    }

    public void setParamModel(Integer paramModel) {
        this.paramModel = paramModel;
    }

    public String getParamMathCmd() {
        return paramMathCmd;
    }

    public void setParamMathCmd(String paramMathCmd) {
        this.paramMathCmd = paramMathCmd == null ? null : paramMathCmd.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<Integer> getParamFromList() {
        return paramFromList;
    }

    public void setParamFromList(List<Integer> paramFromList) {
        this.paramFromList = paramFromList;
    }
}
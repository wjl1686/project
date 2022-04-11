package com.ejobim.opplat.domain;

public class TbParameterConfigExtend {
    private String extendNo;

    private String extendParamNo;

    private String factoryNo;

    private Integer subIndex;

    private Integer extendMathType;

    private String extendName;

    private TbParameterConfig parameterConfig;

    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getExtendParamNo() {
        return extendParamNo;
    }

    public void setExtendParamNo(String extendParamNo) {
        this.extendParamNo = extendParamNo == null ? null : extendParamNo.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getSubIndex() {
        return subIndex;
    }

    public void setSubIndex(Integer subIndex) {
        this.subIndex = subIndex;
    }

    public Integer getExtendMathType() {
        return extendMathType;
    }

    public void setExtendMathType(Integer extendMathType) {
        this.extendMathType = extendMathType;
    }

    public String getExtendName() {
        return extendName;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName == null ? null : extendName.trim();
    }

    public TbParameterConfig getParameterConfig() {
        return parameterConfig;
    }

    public void setParameterConfig(TbParameterConfig parameterConfig) {
        this.parameterConfig = parameterConfig;
    }
}
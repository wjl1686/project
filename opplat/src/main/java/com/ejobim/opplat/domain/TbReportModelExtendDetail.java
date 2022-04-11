package com.ejobim.opplat.domain;

public class TbReportModelExtendDetail {
    private Integer id;

    private String linkExtendNo;

    private String dtUri;

    private String fieldNo;

    private String mathCmd;

    private String factoryNo;

    private Integer mathType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkExtendNo() {
        return linkExtendNo;
    }

    public void setLinkExtendNo(String linkExtendNo) {
        this.linkExtendNo = linkExtendNo == null ? null : linkExtendNo.trim();
    }

    public String getDtUri() {
        return dtUri;
    }

    public void setDtUri(String dtUri) {
        this.dtUri = dtUri == null ? null : dtUri.trim();
    }

    public String getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo == null ? null : fieldNo.trim();
    }

    public String getMathCmd() {
        return mathCmd;
    }

    public void setMathCmd(String mathCmd) {
        this.mathCmd = mathCmd == null ? null : mathCmd.trim();
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getMathType() {
        return mathType;
    }

    public void setMathType(Integer mathType) {
        this.mathType = mathType;
    }
}
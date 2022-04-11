package com.ejobim.opplat.domain;

public class TbReportModelExtend {
    private String extendNo;

    private String extendRmNo;

    private String extendFactoryNo;

    private Integer subIndex;

    private Integer extendMathType;

    private String extendBrowseName;

    private String extendFieldName;

    private String extendColumnName;

    private String uri;

    private Integer extendColumnIndex;

    private Integer extendRowIndex;

    private Integer extendCellWidth;

    private Integer extendCellHeight;

    private String extendMathCmd;

    private String extendMathOt;

    private String extendCode;

    private String value;


    private String  extendStaticInfo;

    private TbReportModelExtendDetail reportModelExtendDetail;

    public TbReportModelExtend() {
    }

    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getExtendRmNo() {
        return extendRmNo;
    }

    public void setExtendRmNo(String extendRmNo) {
        this.extendRmNo = extendRmNo == null ? null : extendRmNo.trim();
    }

    public String getExtendFactoryNo() {
        return extendFactoryNo;
    }

    public void setExtendFactoryNo(String extendFactoryNo) {
        this.extendFactoryNo = extendFactoryNo == null ? null : extendFactoryNo.trim();
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

    public String getExtendBrowseName() {
        return extendBrowseName;
    }

    public void setExtendBrowseName(String extendBrowseName) {
        this.extendBrowseName = extendBrowseName == null ? null : extendBrowseName.trim();
    }

    public String getExtendFieldName() {
        return extendFieldName;
    }

    public void setExtendFieldName(String extendFieldName) {
        this.extendFieldName = extendFieldName == null ? null : extendFieldName.trim();
    }

    public String getExtendColumnName() {
        return extendColumnName;
    }

    public void setExtendColumnName(String extendColumnName) {
        this.extendColumnName = extendColumnName == null ? null : extendColumnName.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Integer getExtendColumnIndex() {
        return extendColumnIndex;
    }

    public void setExtendColumnIndex(Integer extendColumnIndex) {
        this.extendColumnIndex = extendColumnIndex;
    }

    public Integer getExtendRowIndex() {
        return extendRowIndex;
    }

    public void setExtendRowIndex(Integer extendRowIndex) {
        this.extendRowIndex = extendRowIndex;
    }

    public Integer getExtendCellWidth() {
        return extendCellWidth;
    }

    public void setExtendCellWidth(Integer extendCellWidth) {
        this.extendCellWidth = extendCellWidth;
    }

    public Integer getExtendCellHeight() {
        return extendCellHeight;
    }

    public void setExtendCellHeight(Integer extendCellHeight) {
        this.extendCellHeight = extendCellHeight;
    }

    public String getExtendMathCmd() {
        return extendMathCmd;
    }

    public void setExtendMathCmd(String extendMathCmd) {
        this.extendMathCmd = extendMathCmd;
    }

    public String getExtendMathOt() {
        return extendMathOt;
    }

    public void setExtendMathOt(String extendMathOt) {
        this.extendMathOt = extendMathOt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    public TbReportModelExtendDetail getReportModelExtendDetail() {
        return reportModelExtendDetail;
    }

    public void setReportModelExtendDetail(TbReportModelExtendDetail reportModelExtendDetail) {
        this.reportModelExtendDetail = reportModelExtendDetail;
    }

    public String getExtendStaticInfo() {
        return extendStaticInfo;
    }


    public void setExtendStaticInfo(String extendStaticInfo) {
        this.extendStaticInfo = extendStaticInfo;
    }
}
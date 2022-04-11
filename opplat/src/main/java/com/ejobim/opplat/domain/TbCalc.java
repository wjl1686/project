package com.ejobim.opplat.domain;

public class TbCalc {
    private Integer id;

    private String calcName;

    private String calcContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalcName() {
        return calcName;
    }

    public void setCalcName(String calcName) {
        this.calcName = calcName == null ? null : calcName.trim();
    }

    public String getCalcContent() {
        return calcContent;
    }

    public void setCalcContent(String calcContent) {
        this.calcContent = calcContent == null ? null : calcContent.trim();
    }
}
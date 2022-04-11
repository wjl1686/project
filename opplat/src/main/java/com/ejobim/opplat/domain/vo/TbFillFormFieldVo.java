package com.ejobim.opplat.domain.vo;


import com.ejobim.opplat.domain.TbFillFormField;

public class TbFillFormFieldVo extends TbFillFormField {
    private String time;
    private String filedValue;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFiledValue() {
        return filedValue;
    }

    public void setFiledValue(String filedValue) {
        this.filedValue = filedValue;
    }
}
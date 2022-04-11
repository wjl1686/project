package com.ejobim.opplat.domain.enums;

import org.apache.commons.lang3.StringUtils;

public enum StatusEnum {

	NORMAL(0, "正常"),
	NOTNORMAL(1, "不正常");

	private Integer code;
	private String text;

	private StatusEnum(Integer code, String text) {
		this.code = code;
		this.text = text;
	}

	public Integer getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

	public static StatusEnum forValue(String value){
		if(StringUtils.isBlank(value)){
			return null;
		}
		return valueOf(value);
	}
}
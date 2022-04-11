package com.ejobim.opplat.domain.enums;

public enum ProjectTypeEnum {

	EQUIP_DX(1, "大修"),
    EQUIP_CZ(2, "重置"),
    EQUIP_GZ(3, "改造"),
    EQUIP_XZ(4, "新增");

	private Integer code;
	private String text;

    private ProjectTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public static Integer getCode(String name) {
        for (ProjectTypeEnum c : ProjectTypeEnum.values()) {
            if (c.getText().equals(name)) {
                return c.code;
            }
        }
        return null;
    }
    public static String getName(int index) {
        for (ProjectTypeEnum c : ProjectTypeEnum.values()) {
            if (c.getCode() == index) {
                return c.text;
            }
        }
        return null;
    }
}
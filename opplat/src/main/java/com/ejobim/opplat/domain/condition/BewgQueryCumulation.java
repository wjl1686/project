package com.ejobim.opplat.domain.condition;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/19 16:43
 */
public class BewgQueryCumulation {
    private String startTime;
    private String endTime;
    private String uri;
    private String value;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

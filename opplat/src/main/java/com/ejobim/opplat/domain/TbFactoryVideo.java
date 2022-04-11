package com.ejobim.opplat.domain;

public class TbFactoryVideo {
    private String factoryNo;

    private Integer hasvideo;

    private String videoId;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public Integer getHasvideo() {
        return hasvideo;
    }

    public void setHasvideo(Integer hasvideo) {
        this.hasvideo = hasvideo;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }
}
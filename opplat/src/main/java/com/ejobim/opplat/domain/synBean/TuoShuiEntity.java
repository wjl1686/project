package com.ejobim.opplat.domain.synBean;

/**
 * 脱水系统设计参数实体
 */
public class TuoShuiEntity {
    // 水厂编号(例如：ps1091)
    private String USERID;
    //污泥浓缩方式
    private String MudConcentrateType;
    //污泥脱水方式
    private String MudDehydrationType;
    //脱水设计出泥含水率
    private Double MudDesignDehydrationRate;
    //污泥预脱水方式
    private String MudPreDehydrationType;
    // 预脱水设计出泥含水率
    private Double MudPreDesignDehydrationRate;
    //污泥深度脱水方式
    private String MudDeepDehydrationType;
    //深度脱水设计出泥含水率
    private Double MudDeepDesignDehydrationRate;
    //污泥运输
    private String MudTransport;
    //污泥处理
    private String MudHandle;

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getMudConcentrateType() {
        return MudConcentrateType;
    }

    public void setMudConcentrateType(String mudConcentrateType) {
        MudConcentrateType = mudConcentrateType;
    }

    public String getMudDehydrationType() {
        return MudDehydrationType;
    }

    public void setMudDehydrationType(String mudDehydrationType) {
        MudDehydrationType = mudDehydrationType;
    }

    public Double getMudDesignDehydrationRate() {
        return MudDesignDehydrationRate;
    }

    public void setMudDesignDehydrationRate(Double mudDesignDehydrationRate) {
        MudDesignDehydrationRate = mudDesignDehydrationRate;
    }

    public String getMudPreDehydrationType() {
        return MudPreDehydrationType;
    }

    public void setMudPreDehydrationType(String mudPreDehydrationType) {
        MudPreDehydrationType = mudPreDehydrationType;
    }

    public Double getMudPreDesignDehydrationRate() {
        return MudPreDesignDehydrationRate;
    }

    public void setMudPreDesignDehydrationRate(Double mudPreDesignDehydrationRate) {
        MudPreDesignDehydrationRate = mudPreDesignDehydrationRate;
    }

    public String getMudDeepDehydrationType() {
        return MudDeepDehydrationType;
    }

    public void setMudDeepDehydrationType(String mudDeepDehydrationType) {
        MudDeepDehydrationType = mudDeepDehydrationType;
    }

    public Double getMudDeepDesignDehydrationRate() {
        return MudDeepDesignDehydrationRate;
    }

    public void setMudDeepDesignDehydrationRate(Double mudDeepDesignDehydrationRate) {
        MudDeepDesignDehydrationRate = mudDeepDesignDehydrationRate;
    }

    public String getMudTransport() {
        return MudTransport;
    }

    public void setMudTransport(String mudTransport) {
        MudTransport = mudTransport;
    }

    public String getMudHandle() {
        return MudHandle;
    }

    public void setMudHandle(String mudHandle) {
        MudHandle = mudHandle;
    }
}

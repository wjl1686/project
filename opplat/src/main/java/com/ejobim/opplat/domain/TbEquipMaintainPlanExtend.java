package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

import java.util.Date;

public class TbEquipMaintainPlanExtend implements WorkFlowExtendI {
    private String detailNo;

    private String extendContent;

    private String extendAddon;

    private String extendDetail;

    private Date extendUpdateTime;

    private String extendNo;

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo == null ? null : detailNo.trim();
    }

    public String getExtendContent() {
        return extendContent;
    }

    public void setExtendContent(String extendContent) {
        this.extendContent = extendContent == null ? null : extendContent.trim();
    }

    public String getExtendAddon() {
        return extendAddon;
    }

    public void setExtendAddon(String extendAddon) {
        this.extendAddon = extendAddon == null ? null : extendAddon.trim();
    }

    public String getExtendDetail() {
        return extendDetail;
    }

    public void setExtendDetail(String extendDetail) {
        this.extendDetail = extendDetail == null ? null : extendDetail.trim();
    }

    public Date getExtendUpdateTime() {
        return extendUpdateTime;
    }

    public void setExtendUpdateTime(Date extendUpdateTime) {
        this.extendUpdateTime = extendUpdateTime;
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }
}
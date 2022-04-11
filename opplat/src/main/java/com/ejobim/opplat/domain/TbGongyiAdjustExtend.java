package com.ejobim.opplat.domain;

import com.ejobim.opplat.domain.interf.WorkFlowExtendI;

/**
 * @author  xibian
 */
public class TbGongyiAdjustExtend implements WorkFlowExtendI {
    private String adExtendNo;

    private String extendNo;

    private String adjustContent;

    private String adjustAddon;

    public String getAdExtendNo() {
        return adExtendNo;
    }

    public void setAdExtendNo(String adExtendNo) {
        this.adExtendNo = adExtendNo == null ? null : adExtendNo.trim();
    }

    @Override
    public String getExtendNo() {
        return extendNo;
    }

    public void setExtendNo(String extendNo) {
        this.extendNo = extendNo == null ? null : extendNo.trim();
    }

    public String getAdjustContent() {
        return adjustContent;
    }

    public void setAdjustContent(String adjustContent) {
        this.adjustContent = adjustContent == null ? null : adjustContent.trim();
    }

    public String getAdjustAddon() {
        return adjustAddon;
    }

    public void setAdjustAddon(String adjustAddon) {
        this.adjustAddon = adjustAddon == null ? null : adjustAddon.trim();
    }
}
package com.ejobim.opplat.domain;

public class TbWorkFlowConfigDetailKey {
    private String nodeCode;

    private String nodeNo;

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo == null ? null : nodeNo.trim();
    }
}
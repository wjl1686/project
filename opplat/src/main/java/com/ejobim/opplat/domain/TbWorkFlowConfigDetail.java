package com.ejobim.opplat.domain;

import java.util.List;

public class TbWorkFlowConfigDetail {
    private String nodeNo;

    private String configNo;

    private Integer nodeSort;

    private String nodeName;

    private String nodeOptName;

    private String nodeRole;

    private String nodeRoleOrg;

    private Integer nodeNeedCheck;

    private String nodeReturn;

    private String nodeReturnName;

    private String nodeCode;

    private Float positionX;

    private Float positionY;

    private String linkedNodes;

    private String orgNo;

    private Integer nodeIndex;

    private Integer nodePlat;

    private String stepCode;

    private Integer nodeUserIndex;

    private String nodeUserCode;

    private  TbWorkFlowExtend detailInfo;

    private TbWorkTaskInfoExtend workTaskInfoExtend;

    private List<TbWorkFlowConfigDetailExtend> fieldList;

    private List<TbWorkFlowConfigDetailExtend> buttonList;

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo == null ? null : nodeNo.trim();
    }

    public String getConfigNo() {
        return configNo;
    }

    public void setConfigNo(String configNo) {
        this.configNo = configNo == null ? null : configNo.trim();
    }

    public Integer getNodeSort() {
        return nodeSort;
    }

    public void setNodeSort(Integer nodeSort) {
        this.nodeSort = nodeSort;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getNodeOptName() {
        return nodeOptName;
    }

    public void setNodeOptName(String nodeOptName) {
        this.nodeOptName = nodeOptName == null ? null : nodeOptName.trim();
    }

    public String getNodeRole() {
        return nodeRole;
    }

    public void setNodeRole(String nodeRole) {
        this.nodeRole = nodeRole == null ? null : nodeRole.trim();
    }

    public String getNodeRoleOrg() {
        return nodeRoleOrg;
    }

    public void setNodeRoleOrg(String nodeRoleOrg) {
        this.nodeRoleOrg = nodeRoleOrg == null ? null : nodeRoleOrg.trim();
    }

    public Integer getNodeNeedCheck() {
        return nodeNeedCheck;
    }

    public void setNodeNeedCheck(Integer nodeNeedCheck) {
        this.nodeNeedCheck = nodeNeedCheck;
    }

    public String getNodeReturn() {
        return nodeReturn;
    }

    public void setNodeReturn(String nodeReturn) {
        this.nodeReturn = nodeReturn == null ? null : nodeReturn.trim();
    }

    public String getNodeReturnName() {
        return nodeReturnName;
    }

    public void setNodeReturnName(String nodeReturnName) {
        this.nodeReturnName = nodeReturnName == null ? null : nodeReturnName.trim();
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode == null ? null : nodeCode.trim();
    }

    public Float getPositionX() {
        return positionX;
    }

    public void setPositionX(Float positionX) {
        this.positionX = positionX;
    }

    public Float getPositionY() {
        return positionY;
    }

    public void setPositionY(Float positionY) {
        this.positionY = positionY;
    }

    public String getLinkedNodes() {
        return linkedNodes;
    }

    public void setLinkedNodes(String linkedNodes) {
        this.linkedNodes = linkedNodes == null ? null : linkedNodes.trim();
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public Integer getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(Integer nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public Integer getNodePlat() {
        return nodePlat;
    }

    public void setNodePlat(Integer nodePlat) {
        this.nodePlat = nodePlat;
    }

    public List<TbWorkFlowConfigDetailExtend> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<TbWorkFlowConfigDetailExtend> fieldList) {
        this.fieldList = fieldList;
    }

    public TbWorkFlowExtend getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(TbWorkFlowExtend detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public TbWorkTaskInfoExtend getWorkTaskInfoExtend() {
        return workTaskInfoExtend;
    }

    public void setWorkTaskInfoExtend(TbWorkTaskInfoExtend workTaskInfoExtend) {
        this.workTaskInfoExtend = workTaskInfoExtend;
    }

    public Integer getNodeUserIndex() {
        return nodeUserIndex;
    }

    public void setNodeUserIndex(Integer nodeUserIndex) {
        this.nodeUserIndex = nodeUserIndex;
    }

    public String getNodeUserCode() {
        return nodeUserCode;
    }

    public void setNodeUserCode(String nodeUserCode) {
        this.nodeUserCode = nodeUserCode;
    }

    public List<TbWorkFlowConfigDetailExtend> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<TbWorkFlowConfigDetailExtend> buttonList) {
        this.buttonList = buttonList;
    }
}
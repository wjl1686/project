package com.ejobim.opplat.domain.vo;

public class CheckVo {

    private String processNo;

    private  String idea;

    private  String remark;

    private String operator;

    private String applyUser;

    private String getApplyUserName;

    private Integer type;//1通过标志 2:驳回标志

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getGetApplyUserName() {
        return getApplyUserName;
    }

    public void setGetApplyUserName(String getApplyUserName) {
        this.getApplyUserName = getApplyUserName;
    }
}

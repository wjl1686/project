package com.ejobim.opplat.domain.interf;

public interface WorkFlowNode {

    public String getStatusCode();
    public void setStatusCodeName(String statusCodeName);
    public String getNextStatusCode();
    public void setNextStatusCodeName(String nextStatusCodeName);
}

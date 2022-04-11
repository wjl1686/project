package com.ejobim.opplat.domain.condition;

import java.util.List;

public class MonitorCondition {
    //订阅id
    private String subscriptionId;

    private String nodeUri;

    private  String monitoredItemType ="EVENT_BY_URI";

    private List<MonitorCondition> monitoredItems;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getNodeUri() {
        return nodeUri;
    }

    public void setNodeUri(String nodeUri) {
        this.nodeUri = nodeUri;
    }

    public String getMonitoredItemType() {
        return monitoredItemType;
    }

    public void setMonitoredItemType(String monitoredItemType) {
        this.monitoredItemType = monitoredItemType;
    }

    public List<MonitorCondition> getMonitoredItems() {
        return monitoredItems;
    }

    public void setMonitoredItems(List<MonitorCondition> monitoredItems) {
        this.monitoredItems = monitoredItems;
    }
}

package com.ejobim.opplat.domain.condition;

import java.util.List;
import java.util.Map;

public class QueryHistoryAlarmConditon {
/*
    {
        "continuationPoint": "string",
            "deepQuery": true,
            "endTime": "string",
            "fields": [
        "string"
  ],
        "filter": [
        {
            "field": "string",
                "operator": "Equal",
                "value": [
            {}
      ]
        }
  ],
        "maxSize": 0,
            "nodes": [
        "string"
  ],
        "prevQuery": true,
            "startTime": "string"
    }*/
    //查询分页续传点
    private String continuationPoint;
    //需要返回的事件field集合，不传则返回事件中所有的field
    private List<String> fields;
    
    //field值过滤条件集合，三元组
    private List filter;
    
    //单次请求中返回事件数量，不传则默认值10
    private Integer maxSize =100;
    //事件所属node集合，不传则默认查询所有node
    private List<String> nodes;
    
    //是否深度查询（深度查询只查询只支持上一页下一页查询）
    private Boolean prevQuery;
    
    //反向查询时为true
    private Boolean deepQuery =true;
    

    //查询开始时间，毫秒时间戳或时间字符串
    private String startTime;

    //查询结束时间，毫秒时间戳或时间字符串
    private String endTime;

    private Map subscrption;

    public String getContinuationPoint() {
        return continuationPoint;
    }

    public void setContinuationPoint(String continuationPoint) {
        this.continuationPoint = continuationPoint;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List getFilter() {
        return filter;
    }

    public void setFilter(List filter) {
        this.filter = filter;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Boolean getPrevQuery() {
        return prevQuery;
    }

    public void setPrevQuery(Boolean prevQuery) {
        this.prevQuery = prevQuery;
    }

    public Boolean getDeepQuery() {
        return deepQuery;
    }

    public void setDeepQuery(Boolean deepQuery) {
        this.deepQuery = deepQuery;
    }

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

    public Map getSubscrption() {
        return subscrption;
    }

    public void setSubscrption(Map subscrption) {
        this.subscrption = subscrption;
    }
}

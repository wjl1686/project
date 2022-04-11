package com.ejobim.opplat.domain.condition;

import java.util.List;

/**
 * @author wujianlong
 * @Description: 测点时序数据condition
 * @date 2019/2/19 17:28
 */
public class BewgPointCondition {
    
    // 对象uri 和测点BrowseName拼接字符串
    private String uri;
    //续传点，分页使用 "2019/02/01 00:00:00"
    private String continuationPoint;
    //查询开始时间 "2019/02/01 00:00:00"
    private String startTime;
    private String endTime;
    //聚合类型 "interpolation"
    private String aggregateType;
    //处理间隔(周期)大小(秒) 10000
    private Long interval;
    //每个测点返回结果数量
    private Integer maxSizePerNode;
    
    private List<String> pathList;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getContinuationPoint() {
        return continuationPoint;
    }

    public void setContinuationPoint(String continuationPoint) {
        this.continuationPoint = continuationPoint;
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

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Integer getMaxSizePerNode() {
        return maxSizePerNode;
    }

    public void setMaxSizePerNode(Integer maxSizePerNode) {
        this.maxSizePerNode = maxSizePerNode;
    }

    public List<String> getPathList() {
        return pathList;
    }

    public void setPathList(List<String> pathList) {
        this.pathList = pathList;
    }
}


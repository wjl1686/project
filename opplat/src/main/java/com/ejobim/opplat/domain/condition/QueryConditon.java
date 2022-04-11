package com.ejobim.opplat.domain.condition;

import java.util.List;

public class QueryConditon {
    //租户Id
    private String tenantId;
    //更新时间。如果不填则查询全部
    private Long updateTime;

    //页码。默认值为1
    private Integer pageNum;
    //页面大小。默认值为10
    private Integer pageSize;
    //测点uri
    private List<String> uriList;

    private String factoryUri;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<String> getUriList() {
        return uriList;
    }

    public void setUriList(List<String> uriList) {
        this.uriList = uriList;
    }

    public String getFactoryUri() {
        return factoryUri;
    }

    public void setFactoryUri(String factoryUri) {
        this.factoryUri = factoryUri;
    }
}

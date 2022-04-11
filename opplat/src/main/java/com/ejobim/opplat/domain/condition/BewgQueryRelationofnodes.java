package com.ejobim.opplat.domain.condition;

import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/19 17:28
 */
public class BewgQueryRelationofnodes {
    private String forward;
    private Integer maxSize;
    private List<String> relations;
    private List<String> uris;

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public List<String> getRelations() {
        return relations;
    }

    public void setRelations(List<String> relations) {
        this.relations = relations;
    }

    public List<String> getUris() {
        return uris;
    }

    public void setUris(List<String> uris) {
        this.uris = uris;
    }
}

package com.ejobim.opplat.domain.condition;

import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/19 17:28
 */
;

public class BewgQueryTreeCondition {
    private String depth;
    private String forward;
    private List<String> relations;
    private String id;
    private String namespace;
    private String queryTypeDefinition;
    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public List<String> getRelations() {
        return relations;
    }

    public void setRelations(List<String> relations) {
        this.relations = relations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getQueryTypeDefinition() {
        return queryTypeDefinition;
    }

    public void setQueryTypeDefinition(String queryTypeDefinition) {
        this.queryTypeDefinition = queryTypeDefinition;
    }
}

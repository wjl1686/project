package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbWorkFlowConfigDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkFlowConfigDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNodeNoIsNull() {
            addCriterion("node_no is null");
            return (Criteria) this;
        }

        public Criteria andNodeNoIsNotNull() {
            addCriterion("node_no is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNoEqualTo(String value) {
            addCriterion("node_no =", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotEqualTo(String value) {
            addCriterion("node_no <>", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoGreaterThan(String value) {
            addCriterion("node_no >", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoGreaterThanOrEqualTo(String value) {
            addCriterion("node_no >=", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLessThan(String value) {
            addCriterion("node_no <", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLessThanOrEqualTo(String value) {
            addCriterion("node_no <=", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLike(String value) {
            addCriterion("node_no like", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotLike(String value) {
            addCriterion("node_no not like", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoIn(List<String> values) {
            addCriterion("node_no in", values, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotIn(List<String> values) {
            addCriterion("node_no not in", values, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoBetween(String value1, String value2) {
            addCriterion("node_no between", value1, value2, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotBetween(String value1, String value2) {
            addCriterion("node_no not between", value1, value2, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNull() {
            addCriterion("config_no is null");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNotNull() {
            addCriterion("config_no is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNoEqualTo(String value) {
            addCriterion("config_no =", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotEqualTo(String value) {
            addCriterion("config_no <>", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThan(String value) {
            addCriterion("config_no >", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThanOrEqualTo(String value) {
            addCriterion("config_no >=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThan(String value) {
            addCriterion("config_no <", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThanOrEqualTo(String value) {
            addCriterion("config_no <=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLike(String value) {
            addCriterion("config_no like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotLike(String value) {
            addCriterion("config_no not like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoIn(List<String> values) {
            addCriterion("config_no in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotIn(List<String> values) {
            addCriterion("config_no not in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoBetween(String value1, String value2) {
            addCriterion("config_no between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotBetween(String value1, String value2) {
            addCriterion("config_no not between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andNodeSortIsNull() {
            addCriterion("node_sort is null");
            return (Criteria) this;
        }

        public Criteria andNodeSortIsNotNull() {
            addCriterion("node_sort is not null");
            return (Criteria) this;
        }

        public Criteria andNodeSortEqualTo(Integer value) {
            addCriterion("node_sort =", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortNotEqualTo(Integer value) {
            addCriterion("node_sort <>", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortGreaterThan(Integer value) {
            addCriterion("node_sort >", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_sort >=", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortLessThan(Integer value) {
            addCriterion("node_sort <", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortLessThanOrEqualTo(Integer value) {
            addCriterion("node_sort <=", value, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortIn(List<Integer> values) {
            addCriterion("node_sort in", values, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortNotIn(List<Integer> values) {
            addCriterion("node_sort not in", values, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortBetween(Integer value1, Integer value2) {
            addCriterion("node_sort between", value1, value2, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeSortNotBetween(Integer value1, Integer value2) {
            addCriterion("node_sort not between", value1, value2, "nodeSort");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameIsNull() {
            addCriterion("node_opt_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameIsNotNull() {
            addCriterion("node_opt_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameEqualTo(String value) {
            addCriterion("node_opt_name =", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameNotEqualTo(String value) {
            addCriterion("node_opt_name <>", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameGreaterThan(String value) {
            addCriterion("node_opt_name >", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_opt_name >=", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameLessThan(String value) {
            addCriterion("node_opt_name <", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameLessThanOrEqualTo(String value) {
            addCriterion("node_opt_name <=", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameLike(String value) {
            addCriterion("node_opt_name like", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameNotLike(String value) {
            addCriterion("node_opt_name not like", value, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameIn(List<String> values) {
            addCriterion("node_opt_name in", values, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameNotIn(List<String> values) {
            addCriterion("node_opt_name not in", values, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameBetween(String value1, String value2) {
            addCriterion("node_opt_name between", value1, value2, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeOptNameNotBetween(String value1, String value2) {
            addCriterion("node_opt_name not between", value1, value2, "nodeOptName");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIsNull() {
            addCriterion("node_role is null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIsNotNull() {
            addCriterion("node_role is not null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleEqualTo(String value) {
            addCriterion("node_role =", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotEqualTo(String value) {
            addCriterion("node_role <>", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleGreaterThan(String value) {
            addCriterion("node_role >", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleGreaterThanOrEqualTo(String value) {
            addCriterion("node_role >=", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLessThan(String value) {
            addCriterion("node_role <", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLessThanOrEqualTo(String value) {
            addCriterion("node_role <=", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLike(String value) {
            addCriterion("node_role like", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotLike(String value) {
            addCriterion("node_role not like", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIn(List<String> values) {
            addCriterion("node_role in", values, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotIn(List<String> values) {
            addCriterion("node_role not in", values, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleBetween(String value1, String value2) {
            addCriterion("node_role between", value1, value2, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotBetween(String value1, String value2) {
            addCriterion("node_role not between", value1, value2, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgIsNull() {
            addCriterion("node_role_org is null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgIsNotNull() {
            addCriterion("node_role_org is not null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgEqualTo(String value) {
            addCriterion("node_role_org =", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgNotEqualTo(String value) {
            addCriterion("node_role_org <>", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgGreaterThan(String value) {
            addCriterion("node_role_org >", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgGreaterThanOrEqualTo(String value) {
            addCriterion("node_role_org >=", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgLessThan(String value) {
            addCriterion("node_role_org <", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgLessThanOrEqualTo(String value) {
            addCriterion("node_role_org <=", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgLike(String value) {
            addCriterion("node_role_org like", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgNotLike(String value) {
            addCriterion("node_role_org not like", value, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgIn(List<String> values) {
            addCriterion("node_role_org in", values, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgNotIn(List<String> values) {
            addCriterion("node_role_org not in", values, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgBetween(String value1, String value2) {
            addCriterion("node_role_org between", value1, value2, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeRoleOrgNotBetween(String value1, String value2) {
            addCriterion("node_role_org not between", value1, value2, "nodeRoleOrg");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckIsNull() {
            addCriterion("node_need_check is null");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckIsNotNull() {
            addCriterion("node_need_check is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckEqualTo(Integer value) {
            addCriterion("node_need_check =", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckNotEqualTo(Integer value) {
            addCriterion("node_need_check <>", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckGreaterThan(Integer value) {
            addCriterion("node_need_check >", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_need_check >=", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckLessThan(Integer value) {
            addCriterion("node_need_check <", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckLessThanOrEqualTo(Integer value) {
            addCriterion("node_need_check <=", value, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckIn(List<Integer> values) {
            addCriterion("node_need_check in", values, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckNotIn(List<Integer> values) {
            addCriterion("node_need_check not in", values, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckBetween(Integer value1, Integer value2) {
            addCriterion("node_need_check between", value1, value2, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeNeedCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("node_need_check not between", value1, value2, "nodeNeedCheck");
            return (Criteria) this;
        }

        public Criteria andNodeReturnIsNull() {
            addCriterion("node_return is null");
            return (Criteria) this;
        }

        public Criteria andNodeReturnIsNotNull() {
            addCriterion("node_return is not null");
            return (Criteria) this;
        }

        public Criteria andNodeReturnEqualTo(String value) {
            addCriterion("node_return =", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNotEqualTo(String value) {
            addCriterion("node_return <>", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnGreaterThan(String value) {
            addCriterion("node_return >", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnGreaterThanOrEqualTo(String value) {
            addCriterion("node_return >=", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnLessThan(String value) {
            addCriterion("node_return <", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnLessThanOrEqualTo(String value) {
            addCriterion("node_return <=", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnLike(String value) {
            addCriterion("node_return like", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNotLike(String value) {
            addCriterion("node_return not like", value, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnIn(List<String> values) {
            addCriterion("node_return in", values, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNotIn(List<String> values) {
            addCriterion("node_return not in", values, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnBetween(String value1, String value2) {
            addCriterion("node_return between", value1, value2, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNotBetween(String value1, String value2) {
            addCriterion("node_return not between", value1, value2, "nodeReturn");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameIsNull() {
            addCriterion("node_return_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameIsNotNull() {
            addCriterion("node_return_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameEqualTo(String value) {
            addCriterion("node_return_name =", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameNotEqualTo(String value) {
            addCriterion("node_return_name <>", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameGreaterThan(String value) {
            addCriterion("node_return_name >", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_return_name >=", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameLessThan(String value) {
            addCriterion("node_return_name <", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameLessThanOrEqualTo(String value) {
            addCriterion("node_return_name <=", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameLike(String value) {
            addCriterion("node_return_name like", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameNotLike(String value) {
            addCriterion("node_return_name not like", value, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameIn(List<String> values) {
            addCriterion("node_return_name in", values, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameNotIn(List<String> values) {
            addCriterion("node_return_name not in", values, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameBetween(String value1, String value2) {
            addCriterion("node_return_name between", value1, value2, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeReturnNameNotBetween(String value1, String value2) {
            addCriterion("node_return_name not between", value1, value2, "nodeReturnName");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNull() {
            addCriterion("node_code is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("node_code is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("node_code =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("node_code <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("node_code >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("node_code >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("node_code <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("node_code <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("node_code like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("node_code not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("node_code in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("node_code not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("node_code between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("node_code not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNull() {
            addCriterion("position_x is null");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNotNull() {
            addCriterion("position_x is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXEqualTo(Float value) {
            addCriterion("position_x =", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotEqualTo(Float value) {
            addCriterion("position_x <>", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThan(Float value) {
            addCriterion("position_x >", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThanOrEqualTo(Float value) {
            addCriterion("position_x >=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThan(Float value) {
            addCriterion("position_x <", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThanOrEqualTo(Float value) {
            addCriterion("position_x <=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXIn(List<Float> values) {
            addCriterion("position_x in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotIn(List<Float> values) {
            addCriterion("position_x not in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXBetween(Float value1, Float value2) {
            addCriterion("position_x between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotBetween(Float value1, Float value2) {
            addCriterion("position_x not between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNull() {
            addCriterion("position_y is null");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNotNull() {
            addCriterion("position_y is not null");
            return (Criteria) this;
        }

        public Criteria andPositionYEqualTo(Float value) {
            addCriterion("position_y =", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotEqualTo(Float value) {
            addCriterion("position_y <>", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThan(Float value) {
            addCriterion("position_y >", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThanOrEqualTo(Float value) {
            addCriterion("position_y >=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThan(Float value) {
            addCriterion("position_y <", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThanOrEqualTo(Float value) {
            addCriterion("position_y <=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYIn(List<Float> values) {
            addCriterion("position_y in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotIn(List<Float> values) {
            addCriterion("position_y not in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYBetween(Float value1, Float value2) {
            addCriterion("position_y between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotBetween(Float value1, Float value2) {
            addCriterion("position_y not between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesIsNull() {
            addCriterion("linked_nodes is null");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesIsNotNull() {
            addCriterion("linked_nodes is not null");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesEqualTo(String value) {
            addCriterion("linked_nodes =", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesNotEqualTo(String value) {
            addCriterion("linked_nodes <>", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesGreaterThan(String value) {
            addCriterion("linked_nodes >", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesGreaterThanOrEqualTo(String value) {
            addCriterion("linked_nodes >=", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesLessThan(String value) {
            addCriterion("linked_nodes <", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesLessThanOrEqualTo(String value) {
            addCriterion("linked_nodes <=", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesLike(String value) {
            addCriterion("linked_nodes like", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesNotLike(String value) {
            addCriterion("linked_nodes not like", value, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesIn(List<String> values) {
            addCriterion("linked_nodes in", values, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesNotIn(List<String> values) {
            addCriterion("linked_nodes not in", values, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesBetween(String value1, String value2) {
            addCriterion("linked_nodes between", value1, value2, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andLinkedNodesNotBetween(String value1, String value2) {
            addCriterion("linked_nodes not between", value1, value2, "linkedNodes");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNull() {
            addCriterion("org_no is null");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNotNull() {
            addCriterion("org_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNoEqualTo(String value) {
            addCriterion("org_no =", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotEqualTo(String value) {
            addCriterion("org_no <>", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThan(String value) {
            addCriterion("org_no >", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("org_no >=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThan(String value) {
            addCriterion("org_no <", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThanOrEqualTo(String value) {
            addCriterion("org_no <=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLike(String value) {
            addCriterion("org_no like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotLike(String value) {
            addCriterion("org_no not like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoIn(List<String> values) {
            addCriterion("org_no in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotIn(List<String> values) {
            addCriterion("org_no not in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoBetween(String value1, String value2) {
            addCriterion("org_no between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotBetween(String value1, String value2) {
            addCriterion("org_no not between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIsNull() {
            addCriterion("node_index is null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIsNotNull() {
            addCriterion("node_index is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIndexEqualTo(Integer value) {
            addCriterion("node_index =", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotEqualTo(Integer value) {
            addCriterion("node_index <>", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThan(Integer value) {
            addCriterion("node_index >", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_index >=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThan(Integer value) {
            addCriterion("node_index <", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("node_index <=", value, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexIn(List<Integer> values) {
            addCriterion("node_index in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotIn(List<Integer> values) {
            addCriterion("node_index not in", values, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexBetween(Integer value1, Integer value2) {
            addCriterion("node_index between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }

        public Criteria andNodeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("node_index not between", value1, value2, "nodeIndex");
            return (Criteria) this;
        }


        public Criteria andNodePlatIsNull() {
            addCriterion("node_plat is null");
            return (Criteria) this;
        }

        public Criteria andNodePlatIsNotNull() {
            addCriterion("node_plat is not null");
            return (Criteria) this;
        }

        public Criteria andNodePlatEqualTo(Integer value) {
            addCriterion("node_plat =", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatNotEqualTo(Integer value) {
            addCriterion("node_plat <>", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatGreaterThan(Integer value) {
            addCriterion("node_plat >", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_plat >=", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatLessThan(Integer value) {
            addCriterion("node_plat <", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatLessThanOrEqualTo(Integer value) {
            addCriterion("node_plat <=", value, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatIn(List<Integer> values) {
            addCriterion("node_plat in", values, "NodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatNotIn(List<Integer> values) {
            addCriterion("node_plat not in", values, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatBetween(Integer value1, Integer value2) {
            addCriterion("node_plat between", value1, value2, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andNodePlatNotBetween(Integer value1, Integer value2) {
            addCriterion("node_plat not between", value1, value2, "nodePlat");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNull() {
            addCriterion("step_code is null");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNotNull() {
            addCriterion("step_code is not null");
            return (Criteria) this;
        }

        public Criteria andStepCodeEqualTo(String value) {
            addCriterion("step_code =", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotEqualTo(String value) {
            addCriterion("step_code <>", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThan(String value) {
            addCriterion("step_code >", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("step_code >=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThan(String value) {
            addCriterion("step_code <", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThanOrEqualTo(String value) {
            addCriterion("step_code <=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLike(String value) {
            addCriterion("step_code like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotLike(String value) {
            addCriterion("step_code not like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeIn(List<String> values) {
            addCriterion("step_code in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotIn(List<String> values) {
            addCriterion("step_code not in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeBetween(String value1, String value2) {
            addCriterion("step_code between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotBetween(String value1, String value2) {
            addCriterion("step_code not between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexIsNull() {
            addCriterion("node_user_index is null");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexIsNotNull() {
            addCriterion("node_user_index is not null");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexEqualTo(Integer value) {
            addCriterion("node_user_index =", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexNotEqualTo(Integer value) {
            addCriterion("node_user_index <>", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexGreaterThan(Integer value) {
            addCriterion("node_user_index >", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_user_index >=", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexLessThan(Integer value) {
            addCriterion("node_user_index <", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexLessThanOrEqualTo(Integer value) {
            addCriterion("node_user_index <=", value, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexIn(List<Integer> values) {
            addCriterion("node_user_index in", values, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexNotIn(List<Integer> values) {
            addCriterion("node_user_index not in", values, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexBetween(Integer value1, Integer value2) {
            addCriterion("node_user_index between", value1, value2, "nodeUserIndex");
            return (Criteria) this;
        }

        public Criteria andNodeUserIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("node_user_index not between", value1, value2, "nodeUserIndex");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
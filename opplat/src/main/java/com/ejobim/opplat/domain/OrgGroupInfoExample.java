package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class OrgGroupInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgGroupInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andParentOrgIsNull() {
            addCriterion("parent_org is null");
            return (Criteria) this;
        }

        public Criteria andParentOrgIsNotNull() {
            addCriterion("parent_org is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrgEqualTo(String value) {
            addCriterion("parent_org =", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgNotEqualTo(String value) {
            addCriterion("parent_org <>", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgGreaterThan(String value) {
            addCriterion("parent_org >", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgGreaterThanOrEqualTo(String value) {
            addCriterion("parent_org >=", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgLessThan(String value) {
            addCriterion("parent_org <", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgLessThanOrEqualTo(String value) {
            addCriterion("parent_org <=", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgLike(String value) {
            addCriterion("parent_org like", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgNotLike(String value) {
            addCriterion("parent_org not like", value, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgIn(List<String> values) {
            addCriterion("parent_org in", values, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgNotIn(List<String> values) {
            addCriterion("parent_org not in", values, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgBetween(String value1, String value2) {
            addCriterion("parent_org between", value1, value2, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andParentOrgNotBetween(String value1, String value2) {
            addCriterion("parent_org not between", value1, value2, "parentOrg");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoIsNull() {
            addCriterion("group_detail_info is null");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoIsNotNull() {
            addCriterion("group_detail_info is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoEqualTo(Object value) {
            addCriterion("group_detail_info =", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoNotEqualTo(Object value) {
            addCriterion("group_detail_info <>", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoGreaterThan(Object value) {
            addCriterion("group_detail_info >", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoGreaterThanOrEqualTo(Object value) {
            addCriterion("group_detail_info >=", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoLessThan(Object value) {
            addCriterion("group_detail_info <", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoLessThanOrEqualTo(Object value) {
            addCriterion("group_detail_info <=", value, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoIn(List<Object> values) {
            addCriterion("group_detail_info in", values, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoNotIn(List<Object> values) {
            addCriterion("group_detail_info not in", values, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoBetween(Object value1, Object value2) {
            addCriterion("group_detail_info between", value1, value2, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupDetailInfoNotBetween(Object value1, Object value2) {
            addCriterion("group_detail_info not between", value1, value2, "groupDetailInfo");
            return (Criteria) this;
        }

        public Criteria andGroupNoIsNull() {
            addCriterion("group_no is null");
            return (Criteria) this;
        }

        public Criteria andGroupNoIsNotNull() {
            addCriterion("group_no is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNoEqualTo(String value) {
            addCriterion("group_no =", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotEqualTo(String value) {
            addCriterion("group_no <>", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThan(String value) {
            addCriterion("group_no >", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("group_no >=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThan(String value) {
            addCriterion("group_no <", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThanOrEqualTo(String value) {
            addCriterion("group_no <=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLike(String value) {
            addCriterion("group_no like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotLike(String value) {
            addCriterion("group_no not like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoIn(List<String> values) {
            addCriterion("group_no in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotIn(List<String> values) {
            addCriterion("group_no not in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoBetween(String value1, String value2) {
            addCriterion("group_no between", value1, value2, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotBetween(String value1, String value2) {
            addCriterion("group_no not between", value1, value2, "groupNo");
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
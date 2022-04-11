package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbRealTimeConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRealTimeConfigExample() {
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

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNull() {
            addCriterion("factory_no is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNotNull() {
            addCriterion("factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoEqualTo(String value) {
            addCriterion("factory_no =", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotEqualTo(String value) {
            addCriterion("factory_no <>", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThan(String value) {
            addCriterion("factory_no >", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("factory_no >=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThan(String value) {
            addCriterion("factory_no <", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("factory_no <=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLike(String value) {
            addCriterion("factory_no like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotLike(String value) {
            addCriterion("factory_no not like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIn(List<String> values) {
            addCriterion("factory_no in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotIn(List<String> values) {
            addCriterion("factory_no not in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoBetween(String value1, String value2) {
            addCriterion("factory_no between", value1, value2, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotBetween(String value1, String value2) {
            addCriterion("factory_no not between", value1, value2, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andParenturiIsNull() {
            addCriterion("parentUri is null");
            return (Criteria) this;
        }

        public Criteria andParenturiIsNotNull() {
            addCriterion("parentUri is not null");
            return (Criteria) this;
        }

        public Criteria andParenturiEqualTo(String value) {
            addCriterion("parentUri =", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiNotEqualTo(String value) {
            addCriterion("parentUri <>", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiGreaterThan(String value) {
            addCriterion("parentUri >", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiGreaterThanOrEqualTo(String value) {
            addCriterion("parentUri >=", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiLessThan(String value) {
            addCriterion("parentUri <", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiLessThanOrEqualTo(String value) {
            addCriterion("parentUri <=", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiLike(String value) {
            addCriterion("parentUri like", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiNotLike(String value) {
            addCriterion("parentUri not like", value, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiIn(List<String> values) {
            addCriterion("parentUri in", values, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiNotIn(List<String> values) {
            addCriterion("parentUri not in", values, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiBetween(String value1, String value2) {
            addCriterion("parentUri between", value1, value2, "parenturi");
            return (Criteria) this;
        }

        public Criteria andParenturiNotBetween(String value1, String value2) {
            addCriterion("parentUri not between", value1, value2, "parenturi");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNull() {
            addCriterion("displayName is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNotNull() {
            addCriterion("displayName is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameEqualTo(String value) {
            addCriterion("displayName =", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotEqualTo(String value) {
            addCriterion("displayName <>", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThan(String value) {
            addCriterion("displayName >", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThanOrEqualTo(String value) {
            addCriterion("displayName >=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThan(String value) {
            addCriterion("displayName <", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThanOrEqualTo(String value) {
            addCriterion("displayName <=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLike(String value) {
            addCriterion("displayName like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotLike(String value) {
            addCriterion("displayName not like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIn(List<String> values) {
            addCriterion("displayName in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotIn(List<String> values) {
            addCriterion("displayName not in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameBetween(String value1, String value2) {
            addCriterion("displayName between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotBetween(String value1, String value2) {
            addCriterion("displayName not between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIsNull() {
            addCriterion("browsePath is null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIsNotNull() {
            addCriterion("browsePath is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathEqualTo(String value) {
            addCriterion("browsePath =", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotEqualTo(String value) {
            addCriterion("browsePath <>", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThan(String value) {
            addCriterion("browsePath >", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThanOrEqualTo(String value) {
            addCriterion("browsePath >=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThan(String value) {
            addCriterion("browsePath <", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThanOrEqualTo(String value) {
            addCriterion("browsePath <=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLike(String value) {
            addCriterion("browsePath like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotLike(String value) {
            addCriterion("browsePath not like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIn(List<String> values) {
            addCriterion("browsePath in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotIn(List<String> values) {
            addCriterion("browsePath not in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathBetween(String value1, String value2) {
            addCriterion("browsePath between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotBetween(String value1, String value2) {
            addCriterion("browsePath not between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andAccesslevelIsNull() {
            addCriterion("accessLevel is null");
            return (Criteria) this;
        }

        public Criteria andAccesslevelIsNotNull() {
            addCriterion("accessLevel is not null");
            return (Criteria) this;
        }

        public Criteria andAccesslevelEqualTo(String value) {
            addCriterion("accessLevel =", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelNotEqualTo(String value) {
            addCriterion("accessLevel <>", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelGreaterThan(String value) {
            addCriterion("accessLevel >", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelGreaterThanOrEqualTo(String value) {
            addCriterion("accessLevel >=", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelLessThan(String value) {
            addCriterion("accessLevel <", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelLessThanOrEqualTo(String value) {
            addCriterion("accessLevel <=", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelLike(String value) {
            addCriterion("accessLevel like", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelNotLike(String value) {
            addCriterion("accessLevel not like", value, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelIn(List<String> values) {
            addCriterion("accessLevel in", values, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelNotIn(List<String> values) {
            addCriterion("accessLevel not in", values, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelBetween(String value1, String value2) {
            addCriterion("accessLevel between", value1, value2, "accesslevel");
            return (Criteria) this;
        }

        public Criteria andAccesslevelNotBetween(String value1, String value2) {
            addCriterion("accessLevel not between", value1, value2, "accesslevel");
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
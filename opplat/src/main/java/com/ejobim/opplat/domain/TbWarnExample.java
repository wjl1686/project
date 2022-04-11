package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWarnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWarnExample() {
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

        public Criteria andWarnNoIsNull() {
            addCriterion("warn_no is null");
            return (Criteria) this;
        }

        public Criteria andWarnNoIsNotNull() {
            addCriterion("warn_no is not null");
            return (Criteria) this;
        }

        public Criteria andWarnNoEqualTo(String value) {
            addCriterion("warn_no =", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotEqualTo(String value) {
            addCriterion("warn_no <>", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThan(String value) {
            addCriterion("warn_no >", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThanOrEqualTo(String value) {
            addCriterion("warn_no >=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThan(String value) {
            addCriterion("warn_no <", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThanOrEqualTo(String value) {
            addCriterion("warn_no <=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLike(String value) {
            addCriterion("warn_no like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotLike(String value) {
            addCriterion("warn_no not like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoIn(List<String> values) {
            addCriterion("warn_no in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotIn(List<String> values) {
            addCriterion("warn_no not in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoBetween(String value1, String value2) {
            addCriterion("warn_no between", value1, value2, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotBetween(String value1, String value2) {
            addCriterion("warn_no not between", value1, value2, "warnNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUseIsNull() {
            addCriterion("create_use is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseIsNotNull() {
            addCriterion("create_use is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseEqualTo(String value) {
            addCriterion("create_use =", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseNotEqualTo(String value) {
            addCriterion("create_use <>", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseGreaterThan(String value) {
            addCriterion("create_use >", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseGreaterThanOrEqualTo(String value) {
            addCriterion("create_use >=", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseLessThan(String value) {
            addCriterion("create_use <", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseLessThanOrEqualTo(String value) {
            addCriterion("create_use <=", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseLike(String value) {
            addCriterion("create_use like", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseNotLike(String value) {
            addCriterion("create_use not like", value, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseIn(List<String> values) {
            addCriterion("create_use in", values, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseNotIn(List<String> values) {
            addCriterion("create_use not in", values, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseBetween(String value1, String value2) {
            addCriterion("create_use between", value1, value2, "createUse");
            return (Criteria) this;
        }

        public Criteria andCreateUseNotBetween(String value1, String value2) {
            addCriterion("create_use not between", value1, value2, "createUse");
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
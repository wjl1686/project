package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbSelfControlInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSelfControlInfoExample() {
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

        public Criteria andSelControlNoIsNull() {
            addCriterion("sel_control_no is null");
            return (Criteria) this;
        }

        public Criteria andSelControlNoIsNotNull() {
            addCriterion("sel_control_no is not null");
            return (Criteria) this;
        }

        public Criteria andSelControlNoEqualTo(String value) {
            addCriterion("sel_control_no =", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoNotEqualTo(String value) {
            addCriterion("sel_control_no <>", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoGreaterThan(String value) {
            addCriterion("sel_control_no >", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoGreaterThanOrEqualTo(String value) {
            addCriterion("sel_control_no >=", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoLessThan(String value) {
            addCriterion("sel_control_no <", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoLessThanOrEqualTo(String value) {
            addCriterion("sel_control_no <=", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoLike(String value) {
            addCriterion("sel_control_no like", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoNotLike(String value) {
            addCriterion("sel_control_no not like", value, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoIn(List<String> values) {
            addCriterion("sel_control_no in", values, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoNotIn(List<String> values) {
            addCriterion("sel_control_no not in", values, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoBetween(String value1, String value2) {
            addCriterion("sel_control_no between", value1, value2, "selControlNo");
            return (Criteria) this;
        }

        public Criteria andSelControlNoNotBetween(String value1, String value2) {
            addCriterion("sel_control_no not between", value1, value2, "selControlNo");
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

        public Criteria andSelfControlStatusIsNull() {
            addCriterion("self_control_status is null");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusIsNotNull() {
            addCriterion("self_control_status is not null");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusEqualTo(Integer value) {
            addCriterion("self_control_status =", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusNotEqualTo(Integer value) {
            addCriterion("self_control_status <>", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusGreaterThan(Integer value) {
            addCriterion("self_control_status >", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("self_control_status >=", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusLessThan(Integer value) {
            addCriterion("self_control_status <", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusLessThanOrEqualTo(Integer value) {
            addCriterion("self_control_status <=", value, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusIn(List<Integer> values) {
            addCriterion("self_control_status in", values, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusNotIn(List<Integer> values) {
            addCriterion("self_control_status not in", values, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusBetween(Integer value1, Integer value2) {
            addCriterion("self_control_status between", value1, value2, "selfControlStatus");
            return (Criteria) this;
        }

        public Criteria andSelfControlStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("self_control_status not between", value1, value2, "selfControlStatus");
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
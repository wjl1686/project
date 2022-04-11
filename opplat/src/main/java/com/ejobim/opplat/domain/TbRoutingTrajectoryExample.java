package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingTrajectoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingTrajectoryExample() {
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

        public Criteria andTrajeNoIsNull() {
            addCriterion("traje_no is null");
            return (Criteria) this;
        }

        public Criteria andTrajeNoIsNotNull() {
            addCriterion("traje_no is not null");
            return (Criteria) this;
        }

        public Criteria andTrajeNoEqualTo(String value) {
            addCriterion("traje_no =", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoNotEqualTo(String value) {
            addCriterion("traje_no <>", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoGreaterThan(String value) {
            addCriterion("traje_no >", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoGreaterThanOrEqualTo(String value) {
            addCriterion("traje_no >=", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoLessThan(String value) {
            addCriterion("traje_no <", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoLessThanOrEqualTo(String value) {
            addCriterion("traje_no <=", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoLike(String value) {
            addCriterion("traje_no like", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoNotLike(String value) {
            addCriterion("traje_no not like", value, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoIn(List<String> values) {
            addCriterion("traje_no in", values, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoNotIn(List<String> values) {
            addCriterion("traje_no not in", values, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoBetween(String value1, String value2) {
            addCriterion("traje_no between", value1, value2, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andTrajeNoNotBetween(String value1, String value2) {
            addCriterion("traje_no not between", value1, value2, "trajeNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoIsNull() {
            addCriterion("location_no is null");
            return (Criteria) this;
        }

        public Criteria andLocationNoIsNotNull() {
            addCriterion("location_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNoEqualTo(String value) {
            addCriterion("location_no =", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotEqualTo(String value) {
            addCriterion("location_no <>", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThan(String value) {
            addCriterion("location_no >", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThanOrEqualTo(String value) {
            addCriterion("location_no >=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThan(String value) {
            addCriterion("location_no <", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThanOrEqualTo(String value) {
            addCriterion("location_no <=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLike(String value) {
            addCriterion("location_no like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotLike(String value) {
            addCriterion("location_no not like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoIn(List<String> values) {
            addCriterion("location_no in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotIn(List<String> values) {
            addCriterion("location_no not in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoBetween(String value1, String value2) {
            addCriterion("location_no between", value1, value2, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotBetween(String value1, String value2) {
            addCriterion("location_no not between", value1, value2, "locationNo");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeIsNull() {
            addCriterion("traje_time is null");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeIsNotNull() {
            addCriterion("traje_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeEqualTo(Date value) {
            addCriterion("traje_time =", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeNotEqualTo(Date value) {
            addCriterion("traje_time <>", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeGreaterThan(Date value) {
            addCriterion("traje_time >", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("traje_time >=", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeLessThan(Date value) {
            addCriterion("traje_time <", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeLessThanOrEqualTo(Date value) {
            addCriterion("traje_time <=", value, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeIn(List<Date> values) {
            addCriterion("traje_time in", values, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeNotIn(List<Date> values) {
            addCriterion("traje_time not in", values, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeBetween(Date value1, Date value2) {
            addCriterion("traje_time between", value1, value2, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andTrajeTimeNotBetween(Date value1, Date value2) {
            addCriterion("traje_time not between", value1, value2, "trajeTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoIsNull() {
            addCriterion("routing_task_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoIsNotNull() {
            addCriterion("routing_task_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoEqualTo(String value) {
            addCriterion("routing_task_no =", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoNotEqualTo(String value) {
            addCriterion("routing_task_no <>", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoGreaterThan(String value) {
            addCriterion("routing_task_no >", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_task_no >=", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoLessThan(String value) {
            addCriterion("routing_task_no <", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoLessThanOrEqualTo(String value) {
            addCriterion("routing_task_no <=", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoLike(String value) {
            addCriterion("routing_task_no like", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoNotLike(String value) {
            addCriterion("routing_task_no not like", value, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoIn(List<String> values) {
            addCriterion("routing_task_no in", values, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoNotIn(List<String> values) {
            addCriterion("routing_task_no not in", values, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoBetween(String value1, String value2) {
            addCriterion("routing_task_no between", value1, value2, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andRoutingTaskNoNotBetween(String value1, String value2) {
            addCriterion("routing_task_no not between", value1, value2, "routingTaskNo");
            return (Criteria) this;
        }

        public Criteria andTrajeXIsNull() {
            addCriterion("traje_x is null");
            return (Criteria) this;
        }

        public Criteria andTrajeXIsNotNull() {
            addCriterion("traje_x is not null");
            return (Criteria) this;
        }

        public Criteria andTrajeXEqualTo(Double value) {
            addCriterion("traje_x =", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXNotEqualTo(Double value) {
            addCriterion("traje_x <>", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXGreaterThan(Double value) {
            addCriterion("traje_x >", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXGreaterThanOrEqualTo(Double value) {
            addCriterion("traje_x >=", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXLessThan(Double value) {
            addCriterion("traje_x <", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXLessThanOrEqualTo(Double value) {
            addCriterion("traje_x <=", value, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXIn(List<Double> values) {
            addCriterion("traje_x in", values, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXNotIn(List<Double> values) {
            addCriterion("traje_x not in", values, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXBetween(Double value1, Double value2) {
            addCriterion("traje_x between", value1, value2, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeXNotBetween(Double value1, Double value2) {
            addCriterion("traje_x not between", value1, value2, "trajeX");
            return (Criteria) this;
        }

        public Criteria andTrajeYIsNull() {
            addCriterion("traje_y is null");
            return (Criteria) this;
        }

        public Criteria andTrajeYIsNotNull() {
            addCriterion("traje_y is not null");
            return (Criteria) this;
        }

        public Criteria andTrajeYEqualTo(Double value) {
            addCriterion("traje_y =", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYNotEqualTo(Double value) {
            addCriterion("traje_y <>", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYGreaterThan(Double value) {
            addCriterion("traje_y >", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYGreaterThanOrEqualTo(Double value) {
            addCriterion("traje_y >=", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYLessThan(Double value) {
            addCriterion("traje_y <", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYLessThanOrEqualTo(Double value) {
            addCriterion("traje_y <=", value, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYIn(List<Double> values) {
            addCriterion("traje_y in", values, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYNotIn(List<Double> values) {
            addCriterion("traje_y not in", values, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYBetween(Double value1, Double value2) {
            addCriterion("traje_y between", value1, value2, "trajeY");
            return (Criteria) this;
        }

        public Criteria andTrajeYNotBetween(Double value1, Double value2) {
            addCriterion("traje_y not between", value1, value2, "trajeY");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbEquipReparePlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipReparePlanExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRpNoIsNull() {
            addCriterion("rp_no is null");
            return (Criteria) this;
        }

        public Criteria andRpNoIsNotNull() {
            addCriterion("rp_no is not null");
            return (Criteria) this;
        }

        public Criteria andRpNoEqualTo(String value) {
            addCriterion("rp_no =", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoNotEqualTo(String value) {
            addCriterion("rp_no <>", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoGreaterThan(String value) {
            addCriterion("rp_no >", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoGreaterThanOrEqualTo(String value) {
            addCriterion("rp_no >=", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoLessThan(String value) {
            addCriterion("rp_no <", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoLessThanOrEqualTo(String value) {
            addCriterion("rp_no <=", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoLike(String value) {
            addCriterion("rp_no like", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoNotLike(String value) {
            addCriterion("rp_no not like", value, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoIn(List<String> values) {
            addCriterion("rp_no in", values, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoNotIn(List<String> values) {
            addCriterion("rp_no not in", values, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoBetween(String value1, String value2) {
            addCriterion("rp_no between", value1, value2, "rpNo");
            return (Criteria) this;
        }

        public Criteria andRpNoNotBetween(String value1, String value2) {
            addCriterion("rp_no not between", value1, value2, "rpNo");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNull() {
            addCriterion("plan_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNotNull() {
            addCriterion("plan_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("plan_finish_time =", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_finish_time <>", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_finish_time >", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_finish_time >=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("plan_finish_time <", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_finish_time <=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("plan_finish_time in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_finish_time not in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_finish_time between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_finish_time not between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeIsNull() {
            addCriterion("maintain_type is null");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeIsNotNull() {
            addCriterion("maintain_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeEqualTo(Integer value) {
            addCriterion("maintain_type =", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeNotEqualTo(Integer value) {
            addCriterion("maintain_type <>", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeGreaterThan(Integer value) {
            addCriterion("maintain_type >", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintain_type >=", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeLessThan(Integer value) {
            addCriterion("maintain_type <", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeLessThanOrEqualTo(Integer value) {
            addCriterion("maintain_type <=", value, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeIn(List<Integer> values) {
            addCriterion("maintain_type in", values, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeNotIn(List<Integer> values) {
            addCriterion("maintain_type not in", values, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeBetween(Integer value1, Integer value2) {
            addCriterion("maintain_type between", value1, value2, "maintainType");
            return (Criteria) this;
        }

        public Criteria andMaintainTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("maintain_type not between", value1, value2, "maintainType");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNull() {
            addCriterion("flow_no is null");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNotNull() {
            addCriterion("flow_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNoEqualTo(String value) {
            addCriterion("flow_no =", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotEqualTo(String value) {
            addCriterion("flow_no <>", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThan(String value) {
            addCriterion("flow_no >", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThanOrEqualTo(String value) {
            addCriterion("flow_no >=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThan(String value) {
            addCriterion("flow_no <", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThanOrEqualTo(String value) {
            addCriterion("flow_no <=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLike(String value) {
            addCriterion("flow_no like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotLike(String value) {
            addCriterion("flow_no not like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoIn(List<String> values) {
            addCriterion("flow_no in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotIn(List<String> values) {
            addCriterion("flow_no not in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoBetween(String value1, String value2) {
            addCriterion("flow_no between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotBetween(String value1, String value2) {
            addCriterion("flow_no not between", value1, value2, "flowNo");
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
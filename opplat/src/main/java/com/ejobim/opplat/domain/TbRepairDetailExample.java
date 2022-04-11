package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRepairDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRepairDetailExample() {
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

        public Criteria andRepairNoIsNull() {
            addCriterion("repair_no is null");
            return (Criteria) this;
        }

        public Criteria andRepairNoIsNotNull() {
            addCriterion("repair_no is not null");
            return (Criteria) this;
        }

        public Criteria andRepairNoEqualTo(String value) {
            addCriterion("repair_no =", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoNotEqualTo(String value) {
            addCriterion("repair_no <>", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoGreaterThan(String value) {
            addCriterion("repair_no >", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoGreaterThanOrEqualTo(String value) {
            addCriterion("repair_no >=", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoLessThan(String value) {
            addCriterion("repair_no <", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoLessThanOrEqualTo(String value) {
            addCriterion("repair_no <=", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoLike(String value) {
            addCriterion("repair_no like", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoNotLike(String value) {
            addCriterion("repair_no not like", value, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoIn(List<String> values) {
            addCriterion("repair_no in", values, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoNotIn(List<String> values) {
            addCriterion("repair_no not in", values, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoBetween(String value1, String value2) {
            addCriterion("repair_no between", value1, value2, "repairNo");
            return (Criteria) this;
        }

        public Criteria andRepairNoNotBetween(String value1, String value2) {
            addCriterion("repair_no not between", value1, value2, "repairNo");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepStatusIsNull() {
            addCriterion("step_status is null");
            return (Criteria) this;
        }

        public Criteria andStepStatusIsNotNull() {
            addCriterion("step_status is not null");
            return (Criteria) this;
        }

        public Criteria andStepStatusEqualTo(String value) {
            addCriterion("step_status =", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusNotEqualTo(String value) {
            addCriterion("step_status <>", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusGreaterThan(String value) {
            addCriterion("step_status >", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusGreaterThanOrEqualTo(String value) {
            addCriterion("step_status >=", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusLessThan(String value) {
            addCriterion("step_status <", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusLessThanOrEqualTo(String value) {
            addCriterion("step_status <=", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusLike(String value) {
            addCriterion("step_status like", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusNotLike(String value) {
            addCriterion("step_status not like", value, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusIn(List<String> values) {
            addCriterion("step_status in", values, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusNotIn(List<String> values) {
            addCriterion("step_status not in", values, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusBetween(String value1, String value2) {
            addCriterion("step_status between", value1, value2, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andStepStatusNotBetween(String value1, String value2) {
            addCriterion("step_status not between", value1, value2, "stepStatus");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andStepTimeIsNull() {
            addCriterion("step_time is null");
            return (Criteria) this;
        }

        public Criteria andStepTimeIsNotNull() {
            addCriterion("step_time is not null");
            return (Criteria) this;
        }

        public Criteria andStepTimeEqualTo(Date value) {
            addCriterion("step_time =", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotEqualTo(Date value) {
            addCriterion("step_time <>", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeGreaterThan(Date value) {
            addCriterion("step_time >", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("step_time >=", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeLessThan(Date value) {
            addCriterion("step_time <", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeLessThanOrEqualTo(Date value) {
            addCriterion("step_time <=", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeIn(List<Date> values) {
            addCriterion("step_time in", values, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotIn(List<Date> values) {
            addCriterion("step_time not in", values, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeBetween(Date value1, Date value2) {
            addCriterion("step_time between", value1, value2, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotBetween(Date value1, Date value2) {
            addCriterion("step_time not between", value1, value2, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepInfoIsNull() {
            addCriterion("step_info is null");
            return (Criteria) this;
        }

        public Criteria andStepInfoIsNotNull() {
            addCriterion("step_info is not null");
            return (Criteria) this;
        }

        public Criteria andStepInfoEqualTo(String value) {
            addCriterion("step_info =", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoNotEqualTo(String value) {
            addCriterion("step_info <>", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoGreaterThan(String value) {
            addCriterion("step_info >", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoGreaterThanOrEqualTo(String value) {
            addCriterion("step_info >=", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoLessThan(String value) {
            addCriterion("step_info <", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoLessThanOrEqualTo(String value) {
            addCriterion("step_info <=", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoLike(String value) {
            addCriterion("step_info like", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoNotLike(String value) {
            addCriterion("step_info not like", value, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoIn(List<String> values) {
            addCriterion("step_info in", values, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoNotIn(List<String> values) {
            addCriterion("step_info not in", values, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoBetween(String value1, String value2) {
            addCriterion("step_info between", value1, value2, "stepInfo");
            return (Criteria) this;
        }

        public Criteria andStepInfoNotBetween(String value1, String value2) {
            addCriterion("step_info not between", value1, value2, "stepInfo");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRepairInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRepairInfoExample() {
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

        public Criteria andRepairPersonLiableIsNull() {
            addCriterion("repair_person_liable is null");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableIsNotNull() {
            addCriterion("repair_person_liable is not null");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableEqualTo(String value) {
            addCriterion("repair_person_liable =", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableNotEqualTo(String value) {
            addCriterion("repair_person_liable <>", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableGreaterThan(String value) {
            addCriterion("repair_person_liable >", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableGreaterThanOrEqualTo(String value) {
            addCriterion("repair_person_liable >=", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableLessThan(String value) {
            addCriterion("repair_person_liable <", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableLessThanOrEqualTo(String value) {
            addCriterion("repair_person_liable <=", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableLike(String value) {
            addCriterion("repair_person_liable like", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableNotLike(String value) {
            addCriterion("repair_person_liable not like", value, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableIn(List<String> values) {
            addCriterion("repair_person_liable in", values, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableNotIn(List<String> values) {
            addCriterion("repair_person_liable not in", values, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableBetween(String value1, String value2) {
            addCriterion("repair_person_liable between", value1, value2, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonLiableNotBetween(String value1, String value2) {
            addCriterion("repair_person_liable not between", value1, value2, "repairPersonLiable");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveIsNull() {
            addCriterion("repair_person_executive is null");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveIsNotNull() {
            addCriterion("repair_person_executive is not null");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveEqualTo(String value) {
            addCriterion("repair_person_executive =", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveNotEqualTo(String value) {
            addCriterion("repair_person_executive <>", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveGreaterThan(String value) {
            addCriterion("repair_person_executive >", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveGreaterThanOrEqualTo(String value) {
            addCriterion("repair_person_executive >=", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveLessThan(String value) {
            addCriterion("repair_person_executive <", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveLessThanOrEqualTo(String value) {
            addCriterion("repair_person_executive <=", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveLike(String value) {
            addCriterion("repair_person_executive like", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveNotLike(String value) {
            addCriterion("repair_person_executive not like", value, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveIn(List<String> values) {
            addCriterion("repair_person_executive in", values, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveNotIn(List<String> values) {
            addCriterion("repair_person_executive not in", values, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveBetween(String value1, String value2) {
            addCriterion("repair_person_executive between", value1, value2, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairPersonExecutiveNotBetween(String value1, String value2) {
            addCriterion("repair_person_executive not between", value1, value2, "repairPersonExecutive");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairFaultIsNull() {
            addCriterion("repair_fault is null");
            return (Criteria) this;
        }

        public Criteria andRepairFaultIsNotNull() {
            addCriterion("repair_fault is not null");
            return (Criteria) this;
        }

        public Criteria andRepairFaultEqualTo(String value) {
            addCriterion("repair_fault =", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultNotEqualTo(String value) {
            addCriterion("repair_fault <>", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultGreaterThan(String value) {
            addCriterion("repair_fault >", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultGreaterThanOrEqualTo(String value) {
            addCriterion("repair_fault >=", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultLessThan(String value) {
            addCriterion("repair_fault <", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultLessThanOrEqualTo(String value) {
            addCriterion("repair_fault <=", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultLike(String value) {
            addCriterion("repair_fault like", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultNotLike(String value) {
            addCriterion("repair_fault not like", value, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultIn(List<String> values) {
            addCriterion("repair_fault in", values, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultNotIn(List<String> values) {
            addCriterion("repair_fault not in", values, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultBetween(String value1, String value2) {
            addCriterion("repair_fault between", value1, value2, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairFaultNotBetween(String value1, String value2) {
            addCriterion("repair_fault not between", value1, value2, "repairFault");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIsNull() {
            addCriterion("repair_level is null");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIsNotNull() {
            addCriterion("repair_level is not null");
            return (Criteria) this;
        }

        public Criteria andRepairLevelEqualTo(Integer value) {
            addCriterion("repair_level =", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotEqualTo(Integer value) {
            addCriterion("repair_level <>", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelGreaterThan(Integer value) {
            addCriterion("repair_level >", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_level >=", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelLessThan(Integer value) {
            addCriterion("repair_level <", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelLessThanOrEqualTo(Integer value) {
            addCriterion("repair_level <=", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIn(List<Integer> values) {
            addCriterion("repair_level in", values, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotIn(List<Integer> values) {
            addCriterion("repair_level not in", values, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelBetween(Integer value1, Integer value2) {
            addCriterion("repair_level between", value1, value2, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_level not between", value1, value2, "repairLevel");
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
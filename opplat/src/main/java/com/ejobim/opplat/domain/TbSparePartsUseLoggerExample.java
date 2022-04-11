package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSparePartsUseLoggerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSparePartsUseLoggerExample() {
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

        public Criteria andWorkOrderNoIsNull() {
            addCriterion("work_order_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoIsNotNull() {
            addCriterion("work_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoEqualTo(String value) {
            addCriterion("work_order_no =", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoNotEqualTo(String value) {
            addCriterion("work_order_no <>", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoGreaterThan(String value) {
            addCriterion("work_order_no >", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_no >=", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoLessThan(String value) {
            addCriterion("work_order_no <", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoLessThanOrEqualTo(String value) {
            addCriterion("work_order_no <=", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoLike(String value) {
            addCriterion("work_order_no like", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoNotLike(String value) {
            addCriterion("work_order_no not like", value, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoIn(List<String> values) {
            addCriterion("work_order_no in", values, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoNotIn(List<String> values) {
            addCriterion("work_order_no not in", values, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoBetween(String value1, String value2) {
            addCriterion("work_order_no between", value1, value2, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNoNotBetween(String value1, String value2) {
            addCriterion("work_order_no not between", value1, value2, "workOrderNo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeIsNull() {
            addCriterion("work_order_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeIsNotNull() {
            addCriterion("work_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeEqualTo(Integer value) {
            addCriterion("work_order_type =", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotEqualTo(Integer value) {
            addCriterion("work_order_type <>", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeGreaterThan(Integer value) {
            addCriterion("work_order_type >", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_order_type >=", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeLessThan(Integer value) {
            addCriterion("work_order_type <", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("work_order_type <=", value, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeIn(List<Integer> values) {
            addCriterion("work_order_type in", values, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotIn(List<Integer> values) {
            addCriterion("work_order_type not in", values, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("work_order_type between", value1, value2, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("work_order_type not between", value1, value2, "workOrderType");
            return (Criteria) this;
        }

        public Criteria andUseCountIsNull() {
            addCriterion("use_count is null");
            return (Criteria) this;
        }

        public Criteria andUseCountIsNotNull() {
            addCriterion("use_count is not null");
            return (Criteria) this;
        }

        public Criteria andUseCountEqualTo(Integer value) {
            addCriterion("use_count =", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotEqualTo(Integer value) {
            addCriterion("use_count <>", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountGreaterThan(Integer value) {
            addCriterion("use_count >", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_count >=", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountLessThan(Integer value) {
            addCriterion("use_count <", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountLessThanOrEqualTo(Integer value) {
            addCriterion("use_count <=", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountIn(List<Integer> values) {
            addCriterion("use_count in", values, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotIn(List<Integer> values) {
            addCriterion("use_count not in", values, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountBetween(Integer value1, Integer value2) {
            addCriterion("use_count between", value1, value2, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("use_count not between", value1, value2, "useCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoIsNull() {
            addCriterion("spare_parts_no is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoIsNotNull() {
            addCriterion("spare_parts_no is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoEqualTo(String value) {
            addCriterion("spare_parts_no =", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotEqualTo(String value) {
            addCriterion("spare_parts_no <>", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoGreaterThan(String value) {
            addCriterion("spare_parts_no >", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_no >=", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLessThan(String value) {
            addCriterion("spare_parts_no <", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_no <=", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLike(String value) {
            addCriterion("spare_parts_no like", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotLike(String value) {
            addCriterion("spare_parts_no not like", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoIn(List<String> values) {
            addCriterion("spare_parts_no in", values, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotIn(List<String> values) {
            addCriterion("spare_parts_no not in", values, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoBetween(String value1, String value2) {
            addCriterion("spare_parts_no between", value1, value2, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotBetween(String value1, String value2) {
            addCriterion("spare_parts_no not between", value1, value2, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Date value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Date value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Date value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Date value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Date> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Date> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Date value1, Date value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
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
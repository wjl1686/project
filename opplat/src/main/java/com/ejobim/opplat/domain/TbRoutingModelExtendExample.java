package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingModelExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingModelExtendExample() {
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

        public Criteria andRoutingModelExtendNoIsNull() {
            addCriterion("routing_model_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoIsNotNull() {
            addCriterion("routing_model_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoEqualTo(String value) {
            addCriterion("routing_model_extend_no =", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoNotEqualTo(String value) {
            addCriterion("routing_model_extend_no <>", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoGreaterThan(String value) {
            addCriterion("routing_model_extend_no >", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_model_extend_no >=", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoLessThan(String value) {
            addCriterion("routing_model_extend_no <", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoLessThanOrEqualTo(String value) {
            addCriterion("routing_model_extend_no <=", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoLike(String value) {
            addCriterion("routing_model_extend_no like", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoNotLike(String value) {
            addCriterion("routing_model_extend_no not like", value, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoIn(List<String> values) {
            addCriterion("routing_model_extend_no in", values, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoNotIn(List<String> values) {
            addCriterion("routing_model_extend_no not in", values, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoBetween(String value1, String value2) {
            addCriterion("routing_model_extend_no between", value1, value2, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelExtendNoNotBetween(String value1, String value2) {
            addCriterion("routing_model_extend_no not between", value1, value2, "routingModelExtendNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoIsNull() {
            addCriterion("routing_model_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoIsNotNull() {
            addCriterion("routing_model_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoEqualTo(String value) {
            addCriterion("routing_model_no =", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotEqualTo(String value) {
            addCriterion("routing_model_no <>", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoGreaterThan(String value) {
            addCriterion("routing_model_no >", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_model_no >=", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLessThan(String value) {
            addCriterion("routing_model_no <", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLessThanOrEqualTo(String value) {
            addCriterion("routing_model_no <=", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLike(String value) {
            addCriterion("routing_model_no like", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotLike(String value) {
            addCriterion("routing_model_no not like", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoIn(List<String> values) {
            addCriterion("routing_model_no in", values, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotIn(List<String> values) {
            addCriterion("routing_model_no not in", values, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoBetween(String value1, String value2) {
            addCriterion("routing_model_no between", value1, value2, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotBetween(String value1, String value2) {
            addCriterion("routing_model_no not between", value1, value2, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoIsNull() {
            addCriterion("routing_element_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoIsNotNull() {
            addCriterion("routing_element_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoEqualTo(String value) {
            addCriterion("routing_element_no =", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoNotEqualTo(String value) {
            addCriterion("routing_element_no <>", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoGreaterThan(String value) {
            addCriterion("routing_element_no >", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_element_no >=", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoLessThan(String value) {
            addCriterion("routing_element_no <", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoLessThanOrEqualTo(String value) {
            addCriterion("routing_element_no <=", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoLike(String value) {
            addCriterion("routing_element_no like", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoNotLike(String value) {
            addCriterion("routing_element_no not like", value, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoIn(List<String> values) {
            addCriterion("routing_element_no in", values, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoNotIn(List<String> values) {
            addCriterion("routing_element_no not in", values, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoBetween(String value1, String value2) {
            addCriterion("routing_element_no between", value1, value2, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementNoNotBetween(String value1, String value2) {
            addCriterion("routing_element_no not between", value1, value2, "routingElementNo");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeIsNull() {
            addCriterion("routing_element_type is null");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeIsNotNull() {
            addCriterion("routing_element_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeEqualTo(Integer value) {
            addCriterion("routing_element_type =", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeNotEqualTo(Integer value) {
            addCriterion("routing_element_type <>", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeGreaterThan(Integer value) {
            addCriterion("routing_element_type >", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("routing_element_type >=", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeLessThan(Integer value) {
            addCriterion("routing_element_type <", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("routing_element_type <=", value, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeIn(List<Integer> values) {
            addCriterion("routing_element_type in", values, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeNotIn(List<Integer> values) {
            addCriterion("routing_element_type not in", values, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeBetween(Integer value1, Integer value2) {
            addCriterion("routing_element_type between", value1, value2, "routingElementType");
            return (Criteria) this;
        }

        public Criteria andRoutingElementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("routing_element_type not between", value1, value2, "routingElementType");
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

        public Criteria andRoutingLocationNoIsNull() {
            addCriterion("routing_location_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoIsNotNull() {
            addCriterion("routing_location_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoEqualTo(String value) {
            addCriterion("routing_location_no =", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoNotEqualTo(String value) {
            addCriterion("routing_location_no <>", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoGreaterThan(String value) {
            addCriterion("routing_location_no >", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_location_no >=", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoLessThan(String value) {
            addCriterion("routing_location_no <", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoLessThanOrEqualTo(String value) {
            addCriterion("routing_location_no <=", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoLike(String value) {
            addCriterion("routing_location_no like", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoNotLike(String value) {
            addCriterion("routing_location_no not like", value, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoIn(List<String> values) {
            addCriterion("routing_location_no in", values, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoNotIn(List<String> values) {
            addCriterion("routing_location_no not in", values, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoBetween(String value1, String value2) {
            addCriterion("routing_location_no between", value1, value2, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingLocationNoNotBetween(String value1, String value2) {
            addCriterion("routing_location_no not between", value1, value2, "routingLocationNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoIsNull() {
            addCriterion("routing_equip_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoIsNotNull() {
            addCriterion("routing_equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoEqualTo(String value) {
            addCriterion("routing_equip_no =", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoNotEqualTo(String value) {
            addCriterion("routing_equip_no <>", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoGreaterThan(String value) {
            addCriterion("routing_equip_no >", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_equip_no >=", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoLessThan(String value) {
            addCriterion("routing_equip_no <", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoLessThanOrEqualTo(String value) {
            addCriterion("routing_equip_no <=", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoLike(String value) {
            addCriterion("routing_equip_no like", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoNotLike(String value) {
            addCriterion("routing_equip_no not like", value, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoIn(List<String> values) {
            addCriterion("routing_equip_no in", values, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoNotIn(List<String> values) {
            addCriterion("routing_equip_no not in", values, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoBetween(String value1, String value2) {
            addCriterion("routing_equip_no between", value1, value2, "routingEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingEquipNoNotBetween(String value1, String value2) {
            addCriterion("routing_equip_no not between", value1, value2, "routingEquipNo");
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
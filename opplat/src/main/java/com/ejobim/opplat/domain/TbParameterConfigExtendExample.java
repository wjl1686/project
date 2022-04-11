package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbParameterConfigExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParameterConfigExtendExample() {
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

        public Criteria andExtendNoIsNull() {
            addCriterion("extend_no is null");
            return (Criteria) this;
        }

        public Criteria andExtendNoIsNotNull() {
            addCriterion("extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtendNoEqualTo(String value) {
            addCriterion("extend_no =", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotEqualTo(String value) {
            addCriterion("extend_no <>", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoGreaterThan(String value) {
            addCriterion("extend_no >", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_no >=", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLessThan(String value) {
            addCriterion("extend_no <", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLessThanOrEqualTo(String value) {
            addCriterion("extend_no <=", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLike(String value) {
            addCriterion("extend_no like", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotLike(String value) {
            addCriterion("extend_no not like", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoIn(List<String> values) {
            addCriterion("extend_no in", values, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotIn(List<String> values) {
            addCriterion("extend_no not in", values, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoBetween(String value1, String value2) {
            addCriterion("extend_no between", value1, value2, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotBetween(String value1, String value2) {
            addCriterion("extend_no not between", value1, value2, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoIsNull() {
            addCriterion("extend_param_no is null");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoIsNotNull() {
            addCriterion("extend_param_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoEqualTo(String value) {
            addCriterion("extend_param_no =", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoNotEqualTo(String value) {
            addCriterion("extend_param_no <>", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoGreaterThan(String value) {
            addCriterion("extend_param_no >", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_param_no >=", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoLessThan(String value) {
            addCriterion("extend_param_no <", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoLessThanOrEqualTo(String value) {
            addCriterion("extend_param_no <=", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoLike(String value) {
            addCriterion("extend_param_no like", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoNotLike(String value) {
            addCriterion("extend_param_no not like", value, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoIn(List<String> values) {
            addCriterion("extend_param_no in", values, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoNotIn(List<String> values) {
            addCriterion("extend_param_no not in", values, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoBetween(String value1, String value2) {
            addCriterion("extend_param_no between", value1, value2, "extendParamNo");
            return (Criteria) this;
        }

        public Criteria andExtendParamNoNotBetween(String value1, String value2) {
            addCriterion("extend_param_no not between", value1, value2, "extendParamNo");
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

        public Criteria andSubIndexIsNull() {
            addCriterion("sub_index is null");
            return (Criteria) this;
        }

        public Criteria andSubIndexIsNotNull() {
            addCriterion("sub_index is not null");
            return (Criteria) this;
        }

        public Criteria andSubIndexEqualTo(Integer value) {
            addCriterion("sub_index =", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotEqualTo(Integer value) {
            addCriterion("sub_index <>", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexGreaterThan(Integer value) {
            addCriterion("sub_index >", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_index >=", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexLessThan(Integer value) {
            addCriterion("sub_index <", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexLessThanOrEqualTo(Integer value) {
            addCriterion("sub_index <=", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexIn(List<Integer> values) {
            addCriterion("sub_index in", values, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotIn(List<Integer> values) {
            addCriterion("sub_index not in", values, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexBetween(Integer value1, Integer value2) {
            addCriterion("sub_index between", value1, value2, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_index not between", value1, value2, "subIndex");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIsNull() {
            addCriterion("extend_math_type is null");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIsNotNull() {
            addCriterion("extend_math_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeEqualTo(Integer value) {
            addCriterion("extend_math_type =", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotEqualTo(Integer value) {
            addCriterion("extend_math_type <>", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeGreaterThan(Integer value) {
            addCriterion("extend_math_type >", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_math_type >=", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeLessThan(Integer value) {
            addCriterion("extend_math_type <", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeLessThanOrEqualTo(Integer value) {
            addCriterion("extend_math_type <=", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIn(List<Integer> values) {
            addCriterion("extend_math_type in", values, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotIn(List<Integer> values) {
            addCriterion("extend_math_type not in", values, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeBetween(Integer value1, Integer value2) {
            addCriterion("extend_math_type between", value1, value2, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_math_type not between", value1, value2, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendNameIsNull() {
            addCriterion("extend_name is null");
            return (Criteria) this;
        }

        public Criteria andExtendNameIsNotNull() {
            addCriterion("extend_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtendNameEqualTo(String value) {
            addCriterion("extend_name =", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameNotEqualTo(String value) {
            addCriterion("extend_name <>", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameGreaterThan(String value) {
            addCriterion("extend_name >", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameGreaterThanOrEqualTo(String value) {
            addCriterion("extend_name >=", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameLessThan(String value) {
            addCriterion("extend_name <", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameLessThanOrEqualTo(String value) {
            addCriterion("extend_name <=", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameLike(String value) {
            addCriterion("extend_name like", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameNotLike(String value) {
            addCriterion("extend_name not like", value, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameIn(List<String> values) {
            addCriterion("extend_name in", values, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameNotIn(List<String> values) {
            addCriterion("extend_name not in", values, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameBetween(String value1, String value2) {
            addCriterion("extend_name between", value1, value2, "extendName");
            return (Criteria) this;
        }

        public Criteria andExtendNameNotBetween(String value1, String value2) {
            addCriterion("extend_name not between", value1, value2, "extendName");
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
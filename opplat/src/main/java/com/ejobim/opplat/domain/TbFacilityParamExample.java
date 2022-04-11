package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFacilityParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFacilityParamExample() {
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

        public Criteria andFatiParamNoIsNull() {
            addCriterion("fati_param_no is null");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoIsNotNull() {
            addCriterion("fati_param_no is not null");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoEqualTo(String value) {
            addCriterion("fati_param_no =", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoNotEqualTo(String value) {
            addCriterion("fati_param_no <>", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoGreaterThan(String value) {
            addCriterion("fati_param_no >", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoGreaterThanOrEqualTo(String value) {
            addCriterion("fati_param_no >=", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoLessThan(String value) {
            addCriterion("fati_param_no <", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoLessThanOrEqualTo(String value) {
            addCriterion("fati_param_no <=", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoLike(String value) {
            addCriterion("fati_param_no like", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoNotLike(String value) {
            addCriterion("fati_param_no not like", value, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoIn(List<String> values) {
            addCriterion("fati_param_no in", values, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoNotIn(List<String> values) {
            addCriterion("fati_param_no not in", values, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoBetween(String value1, String value2) {
            addCriterion("fati_param_no between", value1, value2, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamNoNotBetween(String value1, String value2) {
            addCriterion("fati_param_no not between", value1, value2, "fatiParamNo");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriIsNull() {
            addCriterion("fati_param_uri is null");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriIsNotNull() {
            addCriterion("fati_param_uri is not null");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriEqualTo(String value) {
            addCriterion("fati_param_uri =", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriNotEqualTo(String value) {
            addCriterion("fati_param_uri <>", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriGreaterThan(String value) {
            addCriterion("fati_param_uri >", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriGreaterThanOrEqualTo(String value) {
            addCriterion("fati_param_uri >=", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriLessThan(String value) {
            addCriterion("fati_param_uri <", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriLessThanOrEqualTo(String value) {
            addCriterion("fati_param_uri <=", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriLike(String value) {
            addCriterion("fati_param_uri like", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriNotLike(String value) {
            addCriterion("fati_param_uri not like", value, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriIn(List<String> values) {
            addCriterion("fati_param_uri in", values, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriNotIn(List<String> values) {
            addCriterion("fati_param_uri not in", values, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriBetween(String value1, String value2) {
            addCriterion("fati_param_uri between", value1, value2, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiParamUriNotBetween(String value1, String value2) {
            addCriterion("fati_param_uri not between", value1, value2, "fatiParamUri");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameIsNull() {
            addCriterion("fati_model_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameIsNotNull() {
            addCriterion("fati_model_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameEqualTo(String value) {
            addCriterion("fati_model_name =", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameNotEqualTo(String value) {
            addCriterion("fati_model_name <>", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameGreaterThan(String value) {
            addCriterion("fati_model_name >", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_model_name >=", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameLessThan(String value) {
            addCriterion("fati_model_name <", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameLessThanOrEqualTo(String value) {
            addCriterion("fati_model_name <=", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameLike(String value) {
            addCriterion("fati_model_name like", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameNotLike(String value) {
            addCriterion("fati_model_name not like", value, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameIn(List<String> values) {
            addCriterion("fati_model_name in", values, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameNotIn(List<String> values) {
            addCriterion("fati_model_name not in", values, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameBetween(String value1, String value2) {
            addCriterion("fati_model_name between", value1, value2, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiModelNameNotBetween(String value1, String value2) {
            addCriterion("fati_model_name not between", value1, value2, "fatiModelName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameIsNull() {
            addCriterion("fati_param_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameIsNotNull() {
            addCriterion("fati_param_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameEqualTo(String value) {
            addCriterion("fati_param_name =", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameNotEqualTo(String value) {
            addCriterion("fati_param_name <>", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameGreaterThan(String value) {
            addCriterion("fati_param_name >", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_param_name >=", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameLessThan(String value) {
            addCriterion("fati_param_name <", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameLessThanOrEqualTo(String value) {
            addCriterion("fati_param_name <=", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameLike(String value) {
            addCriterion("fati_param_name like", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameNotLike(String value) {
            addCriterion("fati_param_name not like", value, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameIn(List<String> values) {
            addCriterion("fati_param_name in", values, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameNotIn(List<String> values) {
            addCriterion("fati_param_name not in", values, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameBetween(String value1, String value2) {
            addCriterion("fati_param_name between", value1, value2, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamNameNotBetween(String value1, String value2) {
            addCriterion("fati_param_name not between", value1, value2, "fatiParamName");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueIsNull() {
            addCriterion("fati_param_value is null");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueIsNotNull() {
            addCriterion("fati_param_value is not null");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueEqualTo(Float value) {
            addCriterion("fati_param_value =", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueNotEqualTo(Float value) {
            addCriterion("fati_param_value <>", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueGreaterThan(Float value) {
            addCriterion("fati_param_value >", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueGreaterThanOrEqualTo(Float value) {
            addCriterion("fati_param_value >=", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueLessThan(Float value) {
            addCriterion("fati_param_value <", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueLessThanOrEqualTo(Float value) {
            addCriterion("fati_param_value <=", value, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueIn(List<Float> values) {
            addCriterion("fati_param_value in", values, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueNotIn(List<Float> values) {
            addCriterion("fati_param_value not in", values, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueBetween(Float value1, Float value2) {
            addCriterion("fati_param_value between", value1, value2, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamValueNotBetween(Float value1, Float value2) {
            addCriterion("fati_param_value not between", value1, value2, "fatiParamValue");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitIsNull() {
            addCriterion("fati_param_unit is null");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitIsNotNull() {
            addCriterion("fati_param_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitEqualTo(String value) {
            addCriterion("fati_param_unit =", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitNotEqualTo(String value) {
            addCriterion("fati_param_unit <>", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitGreaterThan(String value) {
            addCriterion("fati_param_unit >", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitGreaterThanOrEqualTo(String value) {
            addCriterion("fati_param_unit >=", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitLessThan(String value) {
            addCriterion("fati_param_unit <", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitLessThanOrEqualTo(String value) {
            addCriterion("fati_param_unit <=", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitLike(String value) {
            addCriterion("fati_param_unit like", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitNotLike(String value) {
            addCriterion("fati_param_unit not like", value, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitIn(List<String> values) {
            addCriterion("fati_param_unit in", values, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitNotIn(List<String> values) {
            addCriterion("fati_param_unit not in", values, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitBetween(String value1, String value2) {
            addCriterion("fati_param_unit between", value1, value2, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiParamUnitNotBetween(String value1, String value2) {
            addCriterion("fati_param_unit not between", value1, value2, "fatiParamUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeIsNull() {
            addCriterion("fati_update_time is null");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeIsNotNull() {
            addCriterion("fati_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeEqualTo(Date value) {
            addCriterion("fati_update_time =", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeNotEqualTo(Date value) {
            addCriterion("fati_update_time <>", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeGreaterThan(Date value) {
            addCriterion("fati_update_time >", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fati_update_time >=", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeLessThan(Date value) {
            addCriterion("fati_update_time <", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("fati_update_time <=", value, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeIn(List<Date> values) {
            addCriterion("fati_update_time in", values, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeNotIn(List<Date> values) {
            addCriterion("fati_update_time not in", values, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("fati_update_time between", value1, value2, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFatiUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("fati_update_time not between", value1, value2, "fatiUpdateTime");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoIsNull() {
            addCriterion("param_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoIsNotNull() {
            addCriterion("param_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoEqualTo(String value) {
            addCriterion("param_factory_no =", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoNotEqualTo(String value) {
            addCriterion("param_factory_no <>", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoGreaterThan(String value) {
            addCriterion("param_factory_no >", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("param_factory_no >=", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoLessThan(String value) {
            addCriterion("param_factory_no <", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("param_factory_no <=", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoLike(String value) {
            addCriterion("param_factory_no like", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoNotLike(String value) {
            addCriterion("param_factory_no not like", value, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoIn(List<String> values) {
            addCriterion("param_factory_no in", values, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoNotIn(List<String> values) {
            addCriterion("param_factory_no not in", values, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoBetween(String value1, String value2) {
            addCriterion("param_factory_no between", value1, value2, "paramFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParamFactoryNoNotBetween(String value1, String value2) {
            addCriterion("param_factory_no not between", value1, value2, "paramFactoryNo");
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
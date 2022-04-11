package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFillFormFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFillFormFieldExample() {
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

        public Criteria andConfigNoIsNull() {
            addCriterion("config_no is null");
            return (Criteria) this;
        }

        public Criteria andConfigNoIsNotNull() {
            addCriterion("config_no is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNoEqualTo(String value) {
            addCriterion("config_no =", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotEqualTo(String value) {
            addCriterion("config_no <>", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThan(String value) {
            addCriterion("config_no >", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoGreaterThanOrEqualTo(String value) {
            addCriterion("config_no >=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThan(String value) {
            addCriterion("config_no <", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLessThanOrEqualTo(String value) {
            addCriterion("config_no <=", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoLike(String value) {
            addCriterion("config_no like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotLike(String value) {
            addCriterion("config_no not like", value, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoIn(List<String> values) {
            addCriterion("config_no in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotIn(List<String> values) {
            addCriterion("config_no not in", values, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoBetween(String value1, String value2) {
            addCriterion("config_no between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigNoNotBetween(String value1, String value2) {
            addCriterion("config_no not between", value1, value2, "configNo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIsNull() {
            addCriterion("config_info is null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIsNotNull() {
            addCriterion("config_info is not null");
            return (Criteria) this;
        }

        public Criteria andConfigInfoEqualTo(String value) {
            addCriterion("config_info =", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotEqualTo(String value) {
            addCriterion("config_info <>", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThan(String value) {
            addCriterion("config_info >", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoGreaterThanOrEqualTo(String value) {
            addCriterion("config_info >=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThan(String value) {
            addCriterion("config_info <", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLessThanOrEqualTo(String value) {
            addCriterion("config_info <=", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoLike(String value) {
            addCriterion("config_info like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotLike(String value) {
            addCriterion("config_info not like", value, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoIn(List<String> values) {
            addCriterion("config_info in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotIn(List<String> values) {
            addCriterion("config_info not in", values, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoBetween(String value1, String value2) {
            addCriterion("config_info between", value1, value2, "configInfo");
            return (Criteria) this;
        }

        public Criteria andConfigInfoNotBetween(String value1, String value2) {
            addCriterion("config_info not between", value1, value2, "configInfo");
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

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andConfigStatusIsNull() {
            addCriterion("config_status is null");
            return (Criteria) this;
        }

        public Criteria andConfigStatusIsNotNull() {
            addCriterion("config_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfigStatusEqualTo(Integer value) {
            addCriterion("config_status =", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusNotEqualTo(Integer value) {
            addCriterion("config_status <>", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusGreaterThan(Integer value) {
            addCriterion("config_status >", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("config_status >=", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusLessThan(Integer value) {
            addCriterion("config_status <", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusLessThanOrEqualTo(Integer value) {
            addCriterion("config_status <=", value, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusIn(List<Integer> values) {
            addCriterion("config_status in", values, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusNotIn(List<Integer> values) {
            addCriterion("config_status not in", values, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusBetween(Integer value1, Integer value2) {
            addCriterion("config_status between", value1, value2, "configStatus");
            return (Criteria) this;
        }

        public Criteria andConfigStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("config_status not between", value1, value2, "configStatus");
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNull() {
            addCriterion("field_code is null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNotNull() {
            addCriterion("field_code is not null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeEqualTo(String value) {
            addCriterion("field_code =", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotEqualTo(String value) {
            addCriterion("field_code <>", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThan(String value) {
            addCriterion("field_code >", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("field_code >=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThan(String value) {
            addCriterion("field_code <", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThanOrEqualTo(String value) {
            addCriterion("field_code <=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLike(String value) {
            addCriterion("field_code like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotLike(String value) {
            addCriterion("field_code not like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIn(List<String> values) {
            addCriterion("field_code in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotIn(List<String> values) {
            addCriterion("field_code not in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeBetween(String value1, String value2) {
            addCriterion("field_code between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotBetween(String value1, String value2) {
            addCriterion("field_code not between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueIsNull() {
            addCriterion("field_max_value is null");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueIsNotNull() {
            addCriterion("field_max_value is not null");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueEqualTo(Float value) {
            addCriterion("field_max_value =", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueNotEqualTo(Float value) {
            addCriterion("field_max_value <>", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueGreaterThan(Float value) {
            addCriterion("field_max_value >", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueGreaterThanOrEqualTo(Float value) {
            addCriterion("field_max_value >=", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueLessThan(Float value) {
            addCriterion("field_max_value <", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueLessThanOrEqualTo(Float value) {
            addCriterion("field_max_value <=", value, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueIn(List<Float> values) {
            addCriterion("field_max_value in", values, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueNotIn(List<Float> values) {
            addCriterion("field_max_value not in", values, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueBetween(Float value1, Float value2) {
            addCriterion("field_max_value between", value1, value2, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMaxValueNotBetween(Float value1, Float value2) {
            addCriterion("field_max_value not between", value1, value2, "fieldMaxValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueIsNull() {
            addCriterion("field_min_value is null");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueIsNotNull() {
            addCriterion("field_min_value is not null");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueEqualTo(Float value) {
            addCriterion("field_min_value =", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueNotEqualTo(Float value) {
            addCriterion("field_min_value <>", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueGreaterThan(Float value) {
            addCriterion("field_min_value >", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueGreaterThanOrEqualTo(Float value) {
            addCriterion("field_min_value >=", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueLessThan(Float value) {
            addCriterion("field_min_value <", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueLessThanOrEqualTo(Float value) {
            addCriterion("field_min_value <=", value, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueIn(List<Float> values) {
            addCriterion("field_min_value in", values, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueNotIn(List<Float> values) {
            addCriterion("field_min_value not in", values, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueBetween(Float value1, Float value2) {
            addCriterion("field_min_value between", value1, value2, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldMinValueNotBetween(Float value1, Float value2) {
            addCriterion("field_min_value not between", value1, value2, "fieldMinValue");
            return (Criteria) this;
        }

        public Criteria andFieldUnitIsNull() {
            addCriterion("field_unit is null");
            return (Criteria) this;
        }

        public Criteria andFieldUnitIsNotNull() {
            addCriterion("field_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFieldUnitEqualTo(String value) {
            addCriterion("field_unit =", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitNotEqualTo(String value) {
            addCriterion("field_unit <>", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitGreaterThan(String value) {
            addCriterion("field_unit >", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitGreaterThanOrEqualTo(String value) {
            addCriterion("field_unit >=", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitLessThan(String value) {
            addCriterion("field_unit <", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitLessThanOrEqualTo(String value) {
            addCriterion("field_unit <=", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitLike(String value) {
            addCriterion("field_unit like", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitNotLike(String value) {
            addCriterion("field_unit not like", value, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitIn(List<String> values) {
            addCriterion("field_unit in", values, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitNotIn(List<String> values) {
            addCriterion("field_unit not in", values, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitBetween(String value1, String value2) {
            addCriterion("field_unit between", value1, value2, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andFieldUnitNotBetween(String value1, String value2) {
            addCriterion("field_unit not between", value1, value2, "fieldUnit");
            return (Criteria) this;
        }

        public Criteria andBrowsePathIsNull() {
            addCriterion("browse_path is null");
            return (Criteria) this;
        }

        public Criteria andBrowsePathIsNotNull() {
            addCriterion("browse_path is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsePathEqualTo(String value) {
            addCriterion("browse_path =", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathNotEqualTo(String value) {
            addCriterion("browse_path <>", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathGreaterThan(String value) {
            addCriterion("browse_path >", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathGreaterThanOrEqualTo(String value) {
            addCriterion("browse_path >=", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathLessThan(String value) {
            addCriterion("browse_path <", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathLessThanOrEqualTo(String value) {
            addCriterion("browse_path <=", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathLike(String value) {
            addCriterion("browse_path like", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathNotLike(String value) {
            addCriterion("browse_path not like", value, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathIn(List<String> values) {
            addCriterion("browse_path in", values, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathNotIn(List<String> values) {
            addCriterion("browse_path not in", values, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathBetween(String value1, String value2) {
            addCriterion("browse_path between", value1, value2, "browsePath");
            return (Criteria) this;
        }

        public Criteria andBrowsePathNotBetween(String value1, String value2) {
            addCriterion("browse_path not between", value1, value2, "browsePath");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("field_type is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("field_type is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(Integer value) {
            addCriterion("field_type =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(Integer value) {
            addCriterion("field_type <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(Integer value) {
            addCriterion("field_type >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_type >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(Integer value) {
            addCriterion("field_type <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(Integer value) {
            addCriterion("field_type <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<Integer> values) {
            addCriterion("field_type in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<Integer> values) {
            addCriterion("field_type not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(Integer value1, Integer value2) {
            addCriterion("field_type between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("field_type not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andGydNoIsNull() {
            addCriterion("gyd_no is null");
            return (Criteria) this;
        }

        public Criteria andGydNoIsNotNull() {
            addCriterion("gyd_no is not null");
            return (Criteria) this;
        }

        public Criteria andGydNoEqualTo(String value) {
            addCriterion("gyd_no =", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoNotEqualTo(String value) {
            addCriterion("gyd_no <>", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoGreaterThan(String value) {
            addCriterion("gyd_no >", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoGreaterThanOrEqualTo(String value) {
            addCriterion("gyd_no >=", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoLessThan(String value) {
            addCriterion("gyd_no <", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoLessThanOrEqualTo(String value) {
            addCriterion("gyd_no <=", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoLike(String value) {
            addCriterion("gyd_no like", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoNotLike(String value) {
            addCriterion("gyd_no not like", value, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoIn(List<String> values) {
            addCriterion("gyd_no in", values, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoNotIn(List<String> values) {
            addCriterion("gyd_no not in", values, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoBetween(String value1, String value2) {
            addCriterion("gyd_no between", value1, value2, "gydNo");
            return (Criteria) this;
        }

        public Criteria andGydNoNotBetween(String value1, String value2) {
            addCriterion("gyd_no not between", value1, value2, "gydNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNull() {
            addCriterion("equip_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNotNull() {
            addCriterion("equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNoEqualTo(String value) {
            addCriterion("equip_no =", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotEqualTo(String value) {
            addCriterion("equip_no <>", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThan(String value) {
            addCriterion("equip_no >", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("equip_no >=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThan(String value) {
            addCriterion("equip_no <", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThanOrEqualTo(String value) {
            addCriterion("equip_no <=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLike(String value) {
            addCriterion("equip_no like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotLike(String value) {
            addCriterion("equip_no not like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIn(List<String> values) {
            addCriterion("equip_no in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotIn(List<String> values) {
            addCriterion("equip_no not in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoBetween(String value1, String value2) {
            addCriterion("equip_no between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotBetween(String value1, String value2) {
            addCriterion("equip_no not between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andFillTypeIsNull() {
            addCriterion("fill_type is null");
            return (Criteria) this;
        }

        public Criteria andFillTypeIsNotNull() {
            addCriterion("fill_type is not null");
            return (Criteria) this;
        }

        public Criteria andFillTypeEqualTo(Integer value) {
            addCriterion("fill_type =", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeNotEqualTo(Integer value) {
            addCriterion("fill_type <>", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeGreaterThan(Integer value) {
            addCriterion("fill_type >", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_type >=", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeLessThan(Integer value) {
            addCriterion("fill_type <", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fill_type <=", value, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeIn(List<Integer> values) {
            addCriterion("fill_type in", values, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeNotIn(List<Integer> values) {
            addCriterion("fill_type not in", values, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeBetween(Integer value1, Integer value2) {
            addCriterion("fill_type between", value1, value2, "fillType");
            return (Criteria) this;
        }

        public Criteria andFillTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_type not between", value1, value2, "fillType");
            return (Criteria) this;
        }

        public Criteria andSedNameIsNull() {
            addCriterion("sed_name is null");
            return (Criteria) this;
        }

        public Criteria andSedNameIsNotNull() {
            addCriterion("sed_name is not null");
            return (Criteria) this;
        }

        public Criteria andSedNameEqualTo(String value) {
            addCriterion("sed_name =", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameNotEqualTo(String value) {
            addCriterion("sed_name <>", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameGreaterThan(String value) {
            addCriterion("sed_name >", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameGreaterThanOrEqualTo(String value) {
            addCriterion("sed_name >=", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameLessThan(String value) {
            addCriterion("sed_name <", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameLessThanOrEqualTo(String value) {
            addCriterion("sed_name <=", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameLike(String value) {
            addCriterion("sed_name like", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameNotLike(String value) {
            addCriterion("sed_name not like", value, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameIn(List<String> values) {
            addCriterion("sed_name in", values, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameNotIn(List<String> values) {
            addCriterion("sed_name not in", values, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameBetween(String value1, String value2) {
            addCriterion("sed_name between", value1, value2, "sedName");
            return (Criteria) this;
        }

        public Criteria andSedNameNotBetween(String value1, String value2) {
            addCriterion("sed_name not between", value1, value2, "sedName");
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
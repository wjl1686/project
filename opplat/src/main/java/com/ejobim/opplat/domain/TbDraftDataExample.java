package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDraftDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDraftDataExample() {
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

        public Criteria andDraftNoIsNull() {
            addCriterion("draft_no is null");
            return (Criteria) this;
        }

        public Criteria andDraftNoIsNotNull() {
            addCriterion("draft_no is not null");
            return (Criteria) this;
        }

        public Criteria andDraftNoEqualTo(String value) {
            addCriterion("draft_no =", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoNotEqualTo(String value) {
            addCriterion("draft_no <>", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoGreaterThan(String value) {
            addCriterion("draft_no >", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoGreaterThanOrEqualTo(String value) {
            addCriterion("draft_no >=", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoLessThan(String value) {
            addCriterion("draft_no <", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoLessThanOrEqualTo(String value) {
            addCriterion("draft_no <=", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoLike(String value) {
            addCriterion("draft_no like", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoNotLike(String value) {
            addCriterion("draft_no not like", value, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoIn(List<String> values) {
            addCriterion("draft_no in", values, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoNotIn(List<String> values) {
            addCriterion("draft_no not in", values, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoBetween(String value1, String value2) {
            addCriterion("draft_no between", value1, value2, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftNoNotBetween(String value1, String value2) {
            addCriterion("draft_no not between", value1, value2, "draftNo");
            return (Criteria) this;
        }

        public Criteria andDraftTimeIsNull() {
            addCriterion("draft_time is null");
            return (Criteria) this;
        }

        public Criteria andDraftTimeIsNotNull() {
            addCriterion("draft_time is not null");
            return (Criteria) this;
        }

        public Criteria andDraftTimeEqualTo(Date value) {
            addCriterion("draft_time =", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotEqualTo(Date value) {
            addCriterion("draft_time <>", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeGreaterThan(Date value) {
            addCriterion("draft_time >", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("draft_time >=", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeLessThan(Date value) {
            addCriterion("draft_time <", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeLessThanOrEqualTo(Date value) {
            addCriterion("draft_time <=", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeIn(List<Date> values) {
            addCriterion("draft_time in", values, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotIn(List<Date> values) {
            addCriterion("draft_time not in", values, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeBetween(Date value1, Date value2) {
            addCriterion("draft_time between", value1, value2, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotBetween(Date value1, Date value2) {
            addCriterion("draft_time not between", value1, value2, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftDateIsNull() {
            addCriterion("draft_date is null");
            return (Criteria) this;
        }

        public Criteria andDraftDateIsNotNull() {
            addCriterion("draft_date is not null");
            return (Criteria) this;
        }

        public Criteria andDraftDateEqualTo(String value) {
            addCriterion("draft_date =", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateNotEqualTo(String value) {
            addCriterion("draft_date <>", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateGreaterThan(String value) {
            addCriterion("draft_date >", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateGreaterThanOrEqualTo(String value) {
            addCriterion("draft_date >=", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateLessThan(String value) {
            addCriterion("draft_date <", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateLessThanOrEqualTo(String value) {
            addCriterion("draft_date <=", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateLike(String value) {
            addCriterion("draft_date like", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateNotLike(String value) {
            addCriterion("draft_date not like", value, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateIn(List<String> values) {
            addCriterion("draft_date in", values, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateNotIn(List<String> values) {
            addCriterion("draft_date not in", values, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateBetween(String value1, String value2) {
            addCriterion("draft_date between", value1, value2, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftDateNotBetween(String value1, String value2) {
            addCriterion("draft_date not between", value1, value2, "draftDate");
            return (Criteria) this;
        }

        public Criteria andDraftValueIsNull() {
            addCriterion("draft_value is null");
            return (Criteria) this;
        }

        public Criteria andDraftValueIsNotNull() {
            addCriterion("draft_value is not null");
            return (Criteria) this;
        }

        public Criteria andDraftValueEqualTo(Double value) {
            addCriterion("draft_value =", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueNotEqualTo(Double value) {
            addCriterion("draft_value <>", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueGreaterThan(Double value) {
            addCriterion("draft_value >", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueGreaterThanOrEqualTo(Double value) {
            addCriterion("draft_value >=", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueLessThan(Double value) {
            addCriterion("draft_value <", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueLessThanOrEqualTo(Double value) {
            addCriterion("draft_value <=", value, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueIn(List<Double> values) {
            addCriterion("draft_value in", values, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueNotIn(List<Double> values) {
            addCriterion("draft_value not in", values, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueBetween(Double value1, Double value2) {
            addCriterion("draft_value between", value1, value2, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftValueNotBetween(Double value1, Double value2) {
            addCriterion("draft_value not between", value1, value2, "draftValue");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIsNull() {
            addCriterion("draft_unit is null");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIsNotNull() {
            addCriterion("draft_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDraftUnitEqualTo(String value) {
            addCriterion("draft_unit =", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotEqualTo(String value) {
            addCriterion("draft_unit <>", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitGreaterThan(String value) {
            addCriterion("draft_unit >", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitGreaterThanOrEqualTo(String value) {
            addCriterion("draft_unit >=", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLessThan(String value) {
            addCriterion("draft_unit <", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLessThanOrEqualTo(String value) {
            addCriterion("draft_unit <=", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLike(String value) {
            addCriterion("draft_unit like", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotLike(String value) {
            addCriterion("draft_unit not like", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIn(List<String> values) {
            addCriterion("draft_unit in", values, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotIn(List<String> values) {
            addCriterion("draft_unit not in", values, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitBetween(String value1, String value2) {
            addCriterion("draft_unit between", value1, value2, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotBetween(String value1, String value2) {
            addCriterion("draft_unit not between", value1, value2, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIsNull() {
            addCriterion("static_type is null");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIsNotNull() {
            addCriterion("static_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaticTypeEqualTo(Integer value) {
            addCriterion("static_type =", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotEqualTo(Integer value) {
            addCriterion("static_type <>", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeGreaterThan(Integer value) {
            addCriterion("static_type >", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("static_type >=", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeLessThan(Integer value) {
            addCriterion("static_type <", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeLessThanOrEqualTo(Integer value) {
            addCriterion("static_type <=", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIn(List<Integer> values) {
            addCriterion("static_type in", values, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotIn(List<Integer> values) {
            addCriterion("static_type not in", values, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeBetween(Integer value1, Integer value2) {
            addCriterion("static_type between", value1, value2, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("static_type not between", value1, value2, "staticType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIsNull() {
            addCriterion("draft_type is null");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIsNotNull() {
            addCriterion("draft_type is not null");
            return (Criteria) this;
        }

        public Criteria andDraftTypeEqualTo(Integer value) {
            addCriterion("draft_type =", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotEqualTo(Integer value) {
            addCriterion("draft_type <>", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeGreaterThan(Integer value) {
            addCriterion("draft_type >", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("draft_type >=", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeLessThan(Integer value) {
            addCriterion("draft_type <", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeLessThanOrEqualTo(Integer value) {
            addCriterion("draft_type <=", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIn(List<Integer> values) {
            addCriterion("draft_type in", values, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotIn(List<Integer> values) {
            addCriterion("draft_type not in", values, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeBetween(Integer value1, Integer value2) {
            addCriterion("draft_type between", value1, value2, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("draft_type not between", value1, value2, "draftType");
            return (Criteria) this;
        }

        public Criteria andDataFromIsNull() {
            addCriterion("data_from is null");
            return (Criteria) this;
        }

        public Criteria andDataFromIsNotNull() {
            addCriterion("data_from is not null");
            return (Criteria) this;
        }

        public Criteria andDataFromEqualTo(String value) {
            addCriterion("data_from =", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotEqualTo(String value) {
            addCriterion("data_from <>", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThan(String value) {
            addCriterion("data_from >", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThanOrEqualTo(String value) {
            addCriterion("data_from >=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThan(String value) {
            addCriterion("data_from <", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThanOrEqualTo(String value) {
            addCriterion("data_from <=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLike(String value) {
            addCriterion("data_from like", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotLike(String value) {
            addCriterion("data_from not like", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromIn(List<String> values) {
            addCriterion("data_from in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotIn(List<String> values) {
            addCriterion("data_from not in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromBetween(String value1, String value2) {
            addCriterion("data_from between", value1, value2, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotBetween(String value1, String value2) {
            addCriterion("data_from not between", value1, value2, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andFieldNoIsNull() {
            addCriterion("field_no is null");
            return (Criteria) this;
        }

        public Criteria andFieldNoIsNotNull() {
            addCriterion("field_no is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNoEqualTo(String value) {
            addCriterion("field_no =", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotEqualTo(String value) {
            addCriterion("field_no <>", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoGreaterThan(String value) {
            addCriterion("field_no >", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoGreaterThanOrEqualTo(String value) {
            addCriterion("field_no >=", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLessThan(String value) {
            addCriterion("field_no <", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLessThanOrEqualTo(String value) {
            addCriterion("field_no <=", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLike(String value) {
            addCriterion("field_no like", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotLike(String value) {
            addCriterion("field_no not like", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoIn(List<String> values) {
            addCriterion("field_no in", values, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotIn(List<String> values) {
            addCriterion("field_no not in", values, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoBetween(String value1, String value2) {
            addCriterion("field_no between", value1, value2, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotBetween(String value1, String value2) {
            addCriterion("field_no not between", value1, value2, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andDraftNameIsNull() {
            addCriterion("draft_name is null");
            return (Criteria) this;
        }

        public Criteria andDraftNameIsNotNull() {
            addCriterion("draft_name is not null");
            return (Criteria) this;
        }

        public Criteria andDraftNameEqualTo(String value) {
            addCriterion("draft_name =", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameNotEqualTo(String value) {
            addCriterion("draft_name <>", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameGreaterThan(String value) {
            addCriterion("draft_name >", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameGreaterThanOrEqualTo(String value) {
            addCriterion("draft_name >=", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameLessThan(String value) {
            addCriterion("draft_name <", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameLessThanOrEqualTo(String value) {
            addCriterion("draft_name <=", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameLike(String value) {
            addCriterion("draft_name like", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameNotLike(String value) {
            addCriterion("draft_name not like", value, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameIn(List<String> values) {
            addCriterion("draft_name in", values, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameNotIn(List<String> values) {
            addCriterion("draft_name not in", values, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameBetween(String value1, String value2) {
            addCriterion("draft_name between", value1, value2, "draftName");
            return (Criteria) this;
        }

        public Criteria andDraftNameNotBetween(String value1, String value2) {
            addCriterion("draft_name not between", value1, value2, "draftName");
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

        public Criteria andFillNoIsNull() {
            addCriterion("fill_no is null");
            return (Criteria) this;
        }

        public Criteria andFillNoIsNotNull() {
            addCriterion("fill_no is not null");
            return (Criteria) this;
        }

        public Criteria andFillNoEqualTo(String value) {
            addCriterion("fill_no =", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoNotEqualTo(String value) {
            addCriterion("fill_no <>", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoGreaterThan(String value) {
            addCriterion("fill_no >", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoGreaterThanOrEqualTo(String value) {
            addCriterion("fill_no >=", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoLessThan(String value) {
            addCriterion("fill_no <", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoLessThanOrEqualTo(String value) {
            addCriterion("fill_no <=", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoLike(String value) {
            addCriterion("fill_no like", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoNotLike(String value) {
            addCriterion("fill_no not like", value, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoIn(List<String> values) {
            addCriterion("fill_no in", values, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoNotIn(List<String> values) {
            addCriterion("fill_no not in", values, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoBetween(String value1, String value2) {
            addCriterion("fill_no between", value1, value2, "fillNo");
            return (Criteria) this;
        }

        public Criteria andFillNoNotBetween(String value1, String value2) {
            addCriterion("fill_no not between", value1, value2, "fillNo");
            return (Criteria) this;
        }


        public Criteria andFillTaskNoIsNull() {
            addCriterion("fill_task_no is null");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoIsNotNull() {
            addCriterion("fill_task_no is not null");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoEqualTo(String value) {
            addCriterion("fill_task_no =", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotEqualTo(String value) {
            addCriterion("fill_task_no <>", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoGreaterThan(String value) {
            addCriterion("fill_task_no >", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("fill_task_no >=", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLessThan(String value) {
            addCriterion("fill_task_no <", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLessThanOrEqualTo(String value) {
            addCriterion("fill_task_no <=", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLike(String value) {
            addCriterion("fill_task_no like", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotLike(String value) {
            addCriterion("fill_task_no not like", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoIn(List<String> values) {
            addCriterion("fill_task_no in", values, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotIn(List<String> values) {
            addCriterion("fill_task_no not in", values, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoBetween(String value1, String value2) {
            addCriterion("fill_task_no between", value1, value2, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotBetween(String value1, String value2) {
            addCriterion("fill_task_no not between", value1, value2, "fillTaskNo");
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
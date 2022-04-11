package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFormDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFormDataExample() {
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

        public Criteria andFieldValueIsNull() {
            addCriterion("field_value is null");
            return (Criteria) this;
        }

        public Criteria andFieldValueIsNotNull() {
            addCriterion("field_value is not null");
            return (Criteria) this;
        }

        public Criteria andFieldValueEqualTo(Double value) {
            addCriterion("field_value =", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueNotEqualTo(Double value) {
            addCriterion("field_value <>", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueGreaterThan(Double value) {
            addCriterion("field_value >", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueGreaterThanOrEqualTo(Double value) {
            addCriterion("field_value >=", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueLessThan(Double value) {
            addCriterion("field_value <", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueLessThanOrEqualTo(Double value) {
            addCriterion("field_value <=", value, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueIn(List<Double> values) {
            addCriterion("field_value in", values, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueNotIn(List<Double> values) {
            addCriterion("field_value not in", values, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueBetween(Double value1, Double value2) {
            addCriterion("field_value between", value1, value2, "fieldValue");
            return (Criteria) this;
        }

        public Criteria andFieldValueNotBetween(Double value1, Double value2) {
            addCriterion("field_value not between", value1, value2, "fieldValue");
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

        public Criteria andTimePointIsNull() {
            addCriterion("time_point is null");
            return (Criteria) this;
        }

        public Criteria andTimePointIsNotNull() {
            addCriterion("time_point is not null");
            return (Criteria) this;
        }

        public Criteria andTimePointEqualTo(String value) {
            addCriterion("time_point =", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotEqualTo(String value) {
            addCriterion("time_point <>", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointGreaterThan(String value) {
            addCriterion("time_point >", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointGreaterThanOrEqualTo(String value) {
            addCriterion("time_point >=", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointLessThan(String value) {
            addCriterion("time_point <", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointLessThanOrEqualTo(String value) {
            addCriterion("time_point <=", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointLike(String value) {
            addCriterion("time_point like", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotLike(String value) {
            addCriterion("time_point not like", value, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointIn(List<String> values) {
            addCriterion("time_point in", values, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotIn(List<String> values) {
            addCriterion("time_point not in", values, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointBetween(String value1, String value2) {
            addCriterion("time_point between", value1, value2, "timePoint");
            return (Criteria) this;
        }

        public Criteria andTimePointNotBetween(String value1, String value2) {
            addCriterion("time_point not between", value1, value2, "timePoint");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatPersonIsNull() {
            addCriterion("creat_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatPersonIsNotNull() {
            addCriterion("creat_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatPersonEqualTo(String value) {
            addCriterion("creat_person =", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonNotEqualTo(String value) {
            addCriterion("creat_person <>", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonGreaterThan(String value) {
            addCriterion("creat_person >", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonGreaterThanOrEqualTo(String value) {
            addCriterion("creat_person >=", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonLessThan(String value) {
            addCriterion("creat_person <", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonLessThanOrEqualTo(String value) {
            addCriterion("creat_person <=", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonLike(String value) {
            addCriterion("creat_person like", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonNotLike(String value) {
            addCriterion("creat_person not like", value, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonIn(List<String> values) {
            addCriterion("creat_person in", values, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonNotIn(List<String> values) {
            addCriterion("creat_person not in", values, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonBetween(String value1, String value2) {
            addCriterion("creat_person between", value1, value2, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andCreatPersonNotBetween(String value1, String value2) {
            addCriterion("creat_person not between", value1, value2, "creatPerson");
            return (Criteria) this;
        }

        public Criteria andFormDateIsNull() {
            addCriterion("form_date is null");
            return (Criteria) this;
        }

        public Criteria andFormDateIsNotNull() {
            addCriterion("form_date is not null");
            return (Criteria) this;
        }

        public Criteria andFormDateEqualTo(Date value) {
            addCriterion("form_date =", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateNotEqualTo(Date value) {
            addCriterion("form_date <>", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateGreaterThan(Date value) {
            addCriterion("form_date >", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateGreaterThanOrEqualTo(Date value) {
            addCriterion("form_date >=", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateLessThan(Date value) {
            addCriterion("form_date <", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateLessThanOrEqualTo(Date value) {
            addCriterion("form_date <=", value, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateIn(List<Date> values) {
            addCriterion("form_date in", values, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateNotIn(List<Date> values) {
            addCriterion("form_date not in", values, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateBetween(Date value1, Date value2) {
            addCriterion("form_date between", value1, value2, "formDate");
            return (Criteria) this;
        }

        public Criteria andFormDateNotBetween(Date value1, Date value2) {
            addCriterion("form_date not between", value1, value2, "formDate");
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
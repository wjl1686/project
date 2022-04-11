package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAnalysisFillDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAnalysisFillDetailExample() {
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

        public Criteria andFillDetailNoIsNull() {
            addCriterion("fill_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoIsNotNull() {
            addCriterion("fill_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoEqualTo(String value) {
            addCriterion("fill_detail_no =", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoNotEqualTo(String value) {
            addCriterion("fill_detail_no <>", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoGreaterThan(String value) {
            addCriterion("fill_detail_no >", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("fill_detail_no >=", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoLessThan(String value) {
            addCriterion("fill_detail_no <", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoLessThanOrEqualTo(String value) {
            addCriterion("fill_detail_no <=", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoLike(String value) {
            addCriterion("fill_detail_no like", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoNotLike(String value) {
            addCriterion("fill_detail_no not like", value, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoIn(List<String> values) {
            addCriterion("fill_detail_no in", values, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoNotIn(List<String> values) {
            addCriterion("fill_detail_no not in", values, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoBetween(String value1, String value2) {
            addCriterion("fill_detail_no between", value1, value2, "fillDetailNo");
            return (Criteria) this;
        }

        public Criteria andFillDetailNoNotBetween(String value1, String value2) {
            addCriterion("fill_detail_no not between", value1, value2, "fillDetailNo");
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

        public Criteria andBaseFieldNoIsNull() {
            addCriterion("base_field_no is null");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoIsNotNull() {
            addCriterion("base_field_no is not null");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoEqualTo(String value) {
            addCriterion("base_field_no =", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoNotEqualTo(String value) {
            addCriterion("base_field_no <>", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoGreaterThan(String value) {
            addCriterion("base_field_no >", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoGreaterThanOrEqualTo(String value) {
            addCriterion("base_field_no >=", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoLessThan(String value) {
            addCriterion("base_field_no <", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoLessThanOrEqualTo(String value) {
            addCriterion("base_field_no <=", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoLike(String value) {
            addCriterion("base_field_no like", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoNotLike(String value) {
            addCriterion("base_field_no not like", value, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoIn(List<String> values) {
            addCriterion("base_field_no in", values, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoNotIn(List<String> values) {
            addCriterion("base_field_no not in", values, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoBetween(String value1, String value2) {
            addCriterion("base_field_no between", value1, value2, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andBaseFieldNoNotBetween(String value1, String value2) {
            addCriterion("base_field_no not between", value1, value2, "baseFieldNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNull() {
            addCriterion("task_no is null");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNotNull() {
            addCriterion("task_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNoEqualTo(String value) {
            addCriterion("task_no =", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotEqualTo(String value) {
            addCriterion("task_no <>", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThan(String value) {
            addCriterion("task_no >", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("task_no >=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThan(String value) {
            addCriterion("task_no <", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThanOrEqualTo(String value) {
            addCriterion("task_no <=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLike(String value) {
            addCriterion("task_no like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotLike(String value) {
            addCriterion("task_no not like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIn(List<String> values) {
            addCriterion("task_no in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotIn(List<String> values) {
            addCriterion("task_no not in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoBetween(String value1, String value2) {
            addCriterion("task_no between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotBetween(String value1, String value2) {
            addCriterion("task_no not between", value1, value2, "taskNo");
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

        public Criteria andCreateUserCodeIsNull() {
            addCriterion("create_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNotNull() {
            addCriterion("create_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeEqualTo(String value) {
            addCriterion("create_user_code =", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotEqualTo(String value) {
            addCriterion("create_user_code <>", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThan(String value) {
            addCriterion("create_user_code >", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_code >=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThan(String value) {
            addCriterion("create_user_code <", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("create_user_code <=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLike(String value) {
            addCriterion("create_user_code like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotLike(String value) {
            addCriterion("create_user_code not like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIn(List<String> values) {
            addCriterion("create_user_code in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotIn(List<String> values) {
            addCriterion("create_user_code not in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeBetween(String value1, String value2) {
            addCriterion("create_user_code between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotBetween(String value1, String value2) {
            addCriterion("create_user_code not between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andFillTimeIsNull() {
            addCriterion("fill_time is null");
            return (Criteria) this;
        }

        public Criteria andFillTimeIsNotNull() {
            addCriterion("fill_time is not null");
            return (Criteria) this;
        }

        public Criteria andFillTimeEqualTo(Date value) {
            addCriterion("fill_time =", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotEqualTo(Date value) {
            addCriterion("fill_time <>", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThan(Date value) {
            addCriterion("fill_time >", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fill_time >=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThan(Date value) {
            addCriterion("fill_time <", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThanOrEqualTo(Date value) {
            addCriterion("fill_time <=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeIn(List<Date> values) {
            addCriterion("fill_time in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotIn(List<Date> values) {
            addCriterion("fill_time not in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeBetween(Date value1, Date value2) {
            addCriterion("fill_time between", value1, value2, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotBetween(Date value1, Date value2) {
            addCriterion("fill_time not between", value1, value2, "fillTime");
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
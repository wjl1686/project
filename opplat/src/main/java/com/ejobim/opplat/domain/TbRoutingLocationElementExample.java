package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingLocationElementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingLocationElementExample() {
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

        public Criteria andLocationFieldNoIsNull() {
            addCriterion("location_field_no is null");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoIsNotNull() {
            addCriterion("location_field_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoEqualTo(String value) {
            addCriterion("location_field_no =", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoNotEqualTo(String value) {
            addCriterion("location_field_no <>", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoGreaterThan(String value) {
            addCriterion("location_field_no >", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoGreaterThanOrEqualTo(String value) {
            addCriterion("location_field_no >=", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoLessThan(String value) {
            addCriterion("location_field_no <", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoLessThanOrEqualTo(String value) {
            addCriterion("location_field_no <=", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoLike(String value) {
            addCriterion("location_field_no like", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoNotLike(String value) {
            addCriterion("location_field_no not like", value, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoIn(List<String> values) {
            addCriterion("location_field_no in", values, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoNotIn(List<String> values) {
            addCriterion("location_field_no not in", values, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoBetween(String value1, String value2) {
            addCriterion("location_field_no between", value1, value2, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andLocationFieldNoNotBetween(String value1, String value2) {
            addCriterion("location_field_no not between", value1, value2, "locationFieldNo");
            return (Criteria) this;
        }

        public Criteria andParentNoIsNull() {
            addCriterion("parent_no is null");
            return (Criteria) this;
        }

        public Criteria andParentNoIsNotNull() {
            addCriterion("parent_no is not null");
            return (Criteria) this;
        }

        public Criteria andParentNoEqualTo(String value) {
            addCriterion("parent_no =", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotEqualTo(String value) {
            addCriterion("parent_no <>", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThan(String value) {
            addCriterion("parent_no >", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_no >=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThan(String value) {
            addCriterion("parent_no <", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThanOrEqualTo(String value) {
            addCriterion("parent_no <=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLike(String value) {
            addCriterion("parent_no like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotLike(String value) {
            addCriterion("parent_no not like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoIn(List<String> values) {
            addCriterion("parent_no in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotIn(List<String> values) {
            addCriterion("parent_no not in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoBetween(String value1, String value2) {
            addCriterion("parent_no between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotBetween(String value1, String value2) {
            addCriterion("parent_no not between", value1, value2, "parentNo");
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

        public Criteria andElementNameIsNull() {
            addCriterion("element_name is null");
            return (Criteria) this;
        }

        public Criteria andElementNameIsNotNull() {
            addCriterion("element_name is not null");
            return (Criteria) this;
        }

        public Criteria andElementNameEqualTo(String value) {
            addCriterion("element_name =", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotEqualTo(String value) {
            addCriterion("element_name <>", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameGreaterThan(String value) {
            addCriterion("element_name >", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameGreaterThanOrEqualTo(String value) {
            addCriterion("element_name >=", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLessThan(String value) {
            addCriterion("element_name <", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLessThanOrEqualTo(String value) {
            addCriterion("element_name <=", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLike(String value) {
            addCriterion("element_name like", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotLike(String value) {
            addCriterion("element_name not like", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameIn(List<String> values) {
            addCriterion("element_name in", values, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotIn(List<String> values) {
            addCriterion("element_name not in", values, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameBetween(String value1, String value2) {
            addCriterion("element_name between", value1, value2, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotBetween(String value1, String value2) {
            addCriterion("element_name not between", value1, value2, "elementName");
            return (Criteria) this;
        }

        public Criteria andParentTypeIsNull() {
            addCriterion("parent_type is null");
            return (Criteria) this;
        }

        public Criteria andParentTypeIsNotNull() {
            addCriterion("parent_type is not null");
            return (Criteria) this;
        }

        public Criteria andParentTypeEqualTo(Integer value) {
            addCriterion("parent_type =", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotEqualTo(Integer value) {
            addCriterion("parent_type <>", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeGreaterThan(Integer value) {
            addCriterion("parent_type >", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_type >=", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeLessThan(Integer value) {
            addCriterion("parent_type <", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("parent_type <=", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeIn(List<Integer> values) {
            addCriterion("parent_type in", values, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotIn(List<Integer> values) {
            addCriterion("parent_type not in", values, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeBetween(Integer value1, Integer value2) {
            addCriterion("parent_type between", value1, value2, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_type not between", value1, value2, "parentType");
            return (Criteria) this;
        }

        public Criteria andElementMethodIsNull() {
            addCriterion("element_method is null");
            return (Criteria) this;
        }

        public Criteria andElementMethodIsNotNull() {
            addCriterion("element_method is not null");
            return (Criteria) this;
        }

        public Criteria andElementMethodEqualTo(String value) {
            addCriterion("element_method =", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodNotEqualTo(String value) {
            addCriterion("element_method <>", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodGreaterThan(String value) {
            addCriterion("element_method >", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodGreaterThanOrEqualTo(String value) {
            addCriterion("element_method >=", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodLessThan(String value) {
            addCriterion("element_method <", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodLessThanOrEqualTo(String value) {
            addCriterion("element_method <=", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodLike(String value) {
            addCriterion("element_method like", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodNotLike(String value) {
            addCriterion("element_method not like", value, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodIn(List<String> values) {
            addCriterion("element_method in", values, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodNotIn(List<String> values) {
            addCriterion("element_method not in", values, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodBetween(String value1, String value2) {
            addCriterion("element_method between", value1, value2, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementMethodNotBetween(String value1, String value2) {
            addCriterion("element_method not between", value1, value2, "elementMethod");
            return (Criteria) this;
        }

        public Criteria andElementLevelIsNull() {
            addCriterion("element_level is null");
            return (Criteria) this;
        }

        public Criteria andElementLevelIsNotNull() {
            addCriterion("element_level is not null");
            return (Criteria) this;
        }

        public Criteria andElementLevelEqualTo(Integer value) {
            addCriterion("element_level =", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelNotEqualTo(Integer value) {
            addCriterion("element_level <>", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelGreaterThan(Integer value) {
            addCriterion("element_level >", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("element_level >=", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelLessThan(Integer value) {
            addCriterion("element_level <", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelLessThanOrEqualTo(Integer value) {
            addCriterion("element_level <=", value, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelIn(List<Integer> values) {
            addCriterion("element_level in", values, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelNotIn(List<Integer> values) {
            addCriterion("element_level not in", values, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelBetween(Integer value1, Integer value2) {
            addCriterion("element_level between", value1, value2, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andElementLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("element_level not between", value1, value2, "elementLevel");
            return (Criteria) this;
        }

        public Criteria andFillTimesIsNull() {
            addCriterion("fill_times is null");
            return (Criteria) this;
        }

        public Criteria andFillTimesIsNotNull() {
            addCriterion("fill_times is not null");
            return (Criteria) this;
        }

        public Criteria andFillTimesEqualTo(String value) {
            addCriterion("fill_times =", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesNotEqualTo(String value) {
            addCriterion("fill_times <>", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesGreaterThan(String value) {
            addCriterion("fill_times >", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesGreaterThanOrEqualTo(String value) {
            addCriterion("fill_times >=", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesLessThan(String value) {
            addCriterion("fill_times <", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesLessThanOrEqualTo(String value) {
            addCriterion("fill_times <=", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesLike(String value) {
            addCriterion("fill_times like", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesNotLike(String value) {
            addCriterion("fill_times not like", value, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesIn(List<String> values) {
            addCriterion("fill_times in", values, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesNotIn(List<String> values) {
            addCriterion("fill_times not in", values, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesBetween(String value1, String value2) {
            addCriterion("fill_times between", value1, value2, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andFillTimesNotBetween(String value1, String value2) {
            addCriterion("fill_times not between", value1, value2, "fillTimes");
            return (Criteria) this;
        }

        public Criteria andElementTypeIsNull() {
            addCriterion("element_type is null");
            return (Criteria) this;
        }

        public Criteria andElementTypeIsNotNull() {
            addCriterion("element_type is not null");
            return (Criteria) this;
        }

        public Criteria andElementTypeEqualTo(Integer value) {
            addCriterion("element_type =", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotEqualTo(Integer value) {
            addCriterion("element_type <>", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeGreaterThan(Integer value) {
            addCriterion("element_type >", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("element_type >=", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeLessThan(Integer value) {
            addCriterion("element_type <", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeLessThanOrEqualTo(Integer value) {
            addCriterion("element_type <=", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeIn(List<Integer> values) {
            addCriterion("element_type in", values, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotIn(List<Integer> values) {
            addCriterion("element_type not in", values, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeBetween(Integer value1, Integer value2) {
            addCriterion("element_type between", value1, value2, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("element_type not between", value1, value2, "elementType");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
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

        public Criteria andAutoFieldUriIsNull() {
            addCriterion("auto_field_uri is null");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriIsNotNull() {
            addCriterion("auto_field_uri is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriEqualTo(String value) {
            addCriterion("auto_field_uri =", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriNotEqualTo(String value) {
            addCriterion("auto_field_uri <>", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriGreaterThan(String value) {
            addCriterion("auto_field_uri >", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriGreaterThanOrEqualTo(String value) {
            addCriterion("auto_field_uri >=", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriLessThan(String value) {
            addCriterion("auto_field_uri <", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriLessThanOrEqualTo(String value) {
            addCriterion("auto_field_uri <=", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriLike(String value) {
            addCriterion("auto_field_uri like", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriNotLike(String value) {
            addCriterion("auto_field_uri not like", value, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriIn(List<String> values) {
            addCriterion("auto_field_uri in", values, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriNotIn(List<String> values) {
            addCriterion("auto_field_uri not in", values, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriBetween(String value1, String value2) {
            addCriterion("auto_field_uri between", value1, value2, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldUriNotBetween(String value1, String value2) {
            addCriterion("auto_field_uri not between", value1, value2, "autoFieldUri");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathIsNull() {
            addCriterion("auto_field_browse_path is null");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathIsNotNull() {
            addCriterion("auto_field_browse_path is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathEqualTo(String value) {
            addCriterion("auto_field_browse_path =", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathNotEqualTo(String value) {
            addCriterion("auto_field_browse_path <>", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathGreaterThan(String value) {
            addCriterion("auto_field_browse_path >", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathGreaterThanOrEqualTo(String value) {
            addCriterion("auto_field_browse_path >=", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathLessThan(String value) {
            addCriterion("auto_field_browse_path <", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathLessThanOrEqualTo(String value) {
            addCriterion("auto_field_browse_path <=", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathLike(String value) {
            addCriterion("auto_field_browse_path like", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathNotLike(String value) {
            addCriterion("auto_field_browse_path not like", value, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathIn(List<String> values) {
            addCriterion("auto_field_browse_path in", values, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathNotIn(List<String> values) {
            addCriterion("auto_field_browse_path not in", values, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathBetween(String value1, String value2) {
            addCriterion("auto_field_browse_path between", value1, value2, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoFieldBrowsePathNotBetween(String value1, String value2) {
            addCriterion("auto_field_browse_path not between", value1, value2, "autoFieldBrowsePath");
            return (Criteria) this;
        }

        public Criteria andElementSortIsNull() {
            addCriterion("element_sort is null");
            return (Criteria) this;
        }

        public Criteria andElementSortIsNotNull() {
            addCriterion("element_sort is not null");
            return (Criteria) this;
        }

        public Criteria andElementSortEqualTo(Integer value) {
            addCriterion("element_sort =", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortNotEqualTo(Integer value) {
            addCriterion("element_sort <>", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortGreaterThan(Integer value) {
            addCriterion("element_sort >", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("element_sort >=", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortLessThan(Integer value) {
            addCriterion("element_sort <", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortLessThanOrEqualTo(Integer value) {
            addCriterion("element_sort <=", value, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortIn(List<Integer> values) {
            addCriterion("element_sort in", values, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortNotIn(List<Integer> values) {
            addCriterion("element_sort not in", values, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortBetween(Integer value1, Integer value2) {
            addCriterion("element_sort between", value1, value2, "elementSort");
            return (Criteria) this;
        }

        public Criteria andElementSortNotBetween(Integer value1, Integer value2) {
            addCriterion("element_sort not between", value1, value2, "elementSort");
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
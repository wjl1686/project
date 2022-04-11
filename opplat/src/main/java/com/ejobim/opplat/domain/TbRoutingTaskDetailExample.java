package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingTaskDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingTaskDetailExample() {
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

        public Criteria andTaskDetailNoIsNull() {
            addCriterion("task_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoIsNotNull() {
            addCriterion("task_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoEqualTo(String value) {
            addCriterion("task_detail_no =", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoNotEqualTo(String value) {
            addCriterion("task_detail_no <>", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoGreaterThan(String value) {
            addCriterion("task_detail_no >", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("task_detail_no >=", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoLessThan(String value) {
            addCriterion("task_detail_no <", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoLessThanOrEqualTo(String value) {
            addCriterion("task_detail_no <=", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoLike(String value) {
            addCriterion("task_detail_no like", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoNotLike(String value) {
            addCriterion("task_detail_no not like", value, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoIn(List<String> values) {
            addCriterion("task_detail_no in", values, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoNotIn(List<String> values) {
            addCriterion("task_detail_no not in", values, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoBetween(String value1, String value2) {
            addCriterion("task_detail_no between", value1, value2, "taskDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskDetailNoNotBetween(String value1, String value2) {
            addCriterion("task_detail_no not between", value1, value2, "taskDetailNo");
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

        public Criteria andElementNoIsNull() {
            addCriterion("element_no is null");
            return (Criteria) this;
        }

        public Criteria andElementNoIsNotNull() {
            addCriterion("element_no is not null");
            return (Criteria) this;
        }

        public Criteria andElementNoEqualTo(String value) {
            addCriterion("element_no =", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoNotEqualTo(String value) {
            addCriterion("element_no <>", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoGreaterThan(String value) {
            addCriterion("element_no >", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoGreaterThanOrEqualTo(String value) {
            addCriterion("element_no >=", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoLessThan(String value) {
            addCriterion("element_no <", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoLessThanOrEqualTo(String value) {
            addCriterion("element_no <=", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoLike(String value) {
            addCriterion("element_no like", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoNotLike(String value) {
            addCriterion("element_no not like", value, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoIn(List<String> values) {
            addCriterion("element_no in", values, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoNotIn(List<String> values) {
            addCriterion("element_no not in", values, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoBetween(String value1, String value2) {
            addCriterion("element_no between", value1, value2, "elementNo");
            return (Criteria) this;
        }

        public Criteria andElementNoNotBetween(String value1, String value2) {
            addCriterion("element_no not between", value1, value2, "elementNo");
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

        public Criteria andRoutingStatusIsNull() {
            addCriterion("routing_status is null");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusIsNotNull() {
            addCriterion("routing_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusEqualTo(Integer value) {
            addCriterion("routing_status =", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusNotEqualTo(Integer value) {
            addCriterion("routing_status <>", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusGreaterThan(Integer value) {
            addCriterion("routing_status >", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("routing_status >=", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusLessThan(Integer value) {
            addCriterion("routing_status <", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("routing_status <=", value, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusIn(List<Integer> values) {
            addCriterion("routing_status in", values, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusNotIn(List<Integer> values) {
            addCriterion("routing_status not in", values, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusBetween(Integer value1, Integer value2) {
            addCriterion("routing_status between", value1, value2, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("routing_status not between", value1, value2, "routingStatus");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("commit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commit_time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commit_time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commit_time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commit_time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commit_time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commit_time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commit_time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commit_time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commit_time not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andFillValueIsNull() {
            addCriterion("fill_value is null");
            return (Criteria) this;
        }

        public Criteria andFillValueIsNotNull() {
            addCriterion("fill_value is not null");
            return (Criteria) this;
        }

        public Criteria andFillValueEqualTo(Double value) {
            addCriterion("fill_value =", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueNotEqualTo(Double value) {
            addCriterion("fill_value <>", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueGreaterThan(Double value) {
            addCriterion("fill_value >", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueGreaterThanOrEqualTo(Double value) {
            addCriterion("fill_value >=", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueLessThan(Double value) {
            addCriterion("fill_value <", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueLessThanOrEqualTo(Double value) {
            addCriterion("fill_value <=", value, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueIn(List<Double> values) {
            addCriterion("fill_value in", values, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueNotIn(List<Double> values) {
            addCriterion("fill_value not in", values, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueBetween(Double value1, Double value2) {
            addCriterion("fill_value between", value1, value2, "fillValue");
            return (Criteria) this;
        }

        public Criteria andFillValueNotBetween(Double value1, Double value2) {
            addCriterion("fill_value not between", value1, value2, "fillValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueIsNull() {
            addCriterion("auto_value is null");
            return (Criteria) this;
        }

        public Criteria andAutoValueIsNotNull() {
            addCriterion("auto_value is not null");
            return (Criteria) this;
        }

        public Criteria andAutoValueEqualTo(Double value) {
            addCriterion("auto_value =", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueNotEqualTo(Double value) {
            addCriterion("auto_value <>", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueGreaterThan(Double value) {
            addCriterion("auto_value >", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueGreaterThanOrEqualTo(Double value) {
            addCriterion("auto_value >=", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueLessThan(Double value) {
            addCriterion("auto_value <", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueLessThanOrEqualTo(Double value) {
            addCriterion("auto_value <=", value, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueIn(List<Double> values) {
            addCriterion("auto_value in", values, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueNotIn(List<Double> values) {
            addCriterion("auto_value not in", values, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueBetween(Double value1, Double value2) {
            addCriterion("auto_value between", value1, value2, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoValueNotBetween(Double value1, Double value2) {
            addCriterion("auto_value not between", value1, value2, "autoValue");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathIsNull() {
            addCriterion("auto_browse_path is null");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathIsNotNull() {
            addCriterion("auto_browse_path is not null");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathEqualTo(String value) {
            addCriterion("auto_browse_path =", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathNotEqualTo(String value) {
            addCriterion("auto_browse_path <>", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathGreaterThan(String value) {
            addCriterion("auto_browse_path >", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathGreaterThanOrEqualTo(String value) {
            addCriterion("auto_browse_path >=", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathLessThan(String value) {
            addCriterion("auto_browse_path <", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathLessThanOrEqualTo(String value) {
            addCriterion("auto_browse_path <=", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathLike(String value) {
            addCriterion("auto_browse_path like", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathNotLike(String value) {
            addCriterion("auto_browse_path not like", value, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathIn(List<String> values) {
            addCriterion("auto_browse_path in", values, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathNotIn(List<String> values) {
            addCriterion("auto_browse_path not in", values, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathBetween(String value1, String value2) {
            addCriterion("auto_browse_path between", value1, value2, "autoBrowsePath");
            return (Criteria) this;
        }

        public Criteria andAutoBrowsePathNotBetween(String value1, String value2) {
            addCriterion("auto_browse_path not between", value1, value2, "autoBrowsePath");
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

        public Criteria andLocationNoIsNull() {
            addCriterion("location_no is null");
            return (Criteria) this;
        }

        public Criteria andLocationNoIsNotNull() {
            addCriterion("location_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNoEqualTo(String value) {
            addCriterion("location_no =", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotEqualTo(String value) {
            addCriterion("location_no <>", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThan(String value) {
            addCriterion("location_no >", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThanOrEqualTo(String value) {
            addCriterion("location_no >=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThan(String value) {
            addCriterion("location_no <", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThanOrEqualTo(String value) {
            addCriterion("location_no <=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLike(String value) {
            addCriterion("location_no like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotLike(String value) {
            addCriterion("location_no not like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoIn(List<String> values) {
            addCriterion("location_no in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotIn(List<String> values) {
            addCriterion("location_no not in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoBetween(String value1, String value2) {
            addCriterion("location_no between", value1, value2, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotBetween(String value1, String value2) {
            addCriterion("location_no not between", value1, value2, "locationNo");
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
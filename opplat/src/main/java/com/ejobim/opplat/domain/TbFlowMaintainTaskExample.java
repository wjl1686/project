package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFlowMaintainTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFlowMaintainTaskExample() {
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

        public Criteria andPlanNoIsNull() {
            addCriterion("plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(String value) {
            addCriterion("plan_no =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(String value) {
            addCriterion("plan_no <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(String value) {
            addCriterion("plan_no >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(String value) {
            addCriterion("plan_no >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(String value) {
            addCriterion("plan_no <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(String value) {
            addCriterion("plan_no <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLike(String value) {
            addCriterion("plan_no like", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotLike(String value) {
            addCriterion("plan_no not like", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<String> values) {
            addCriterion("plan_no in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<String> values) {
            addCriterion("plan_no not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(String value1, String value2) {
            addCriterion("plan_no between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(String value1, String value2) {
            addCriterion("plan_no not between", value1, value2, "planNo");
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

        public Criteria andEquipNameIsNull() {
            addCriterion("equip_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNotNull() {
            addCriterion("equip_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNameEqualTo(String value) {
            addCriterion("equip_name =", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotEqualTo(String value) {
            addCriterion("equip_name <>", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThan(String value) {
            addCriterion("equip_name >", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_name >=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThan(String value) {
            addCriterion("equip_name <", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThanOrEqualTo(String value) {
            addCriterion("equip_name <=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLike(String value) {
            addCriterion("equip_name like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotLike(String value) {
            addCriterion("equip_name not like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameIn(List<String> values) {
            addCriterion("equip_name in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotIn(List<String> values) {
            addCriterion("equip_name not in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameBetween(String value1, String value2) {
            addCriterion("equip_name between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotBetween(String value1, String value2) {
            addCriterion("equip_name not between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNull() {
            addCriterion("equip_type_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNotNull() {
            addCriterion("equip_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameEqualTo(String value) {
            addCriterion("equip_type_name =", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotEqualTo(String value) {
            addCriterion("equip_type_name <>", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThan(String value) {
            addCriterion("equip_type_name >", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type_name >=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThan(String value) {
            addCriterion("equip_type_name <", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThanOrEqualTo(String value) {
            addCriterion("equip_type_name <=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLike(String value) {
            addCriterion("equip_type_name like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotLike(String value) {
            addCriterion("equip_type_name not like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIn(List<String> values) {
            addCriterion("equip_type_name in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotIn(List<String> values) {
            addCriterion("equip_type_name not in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameBetween(String value1, String value2) {
            addCriterion("equip_type_name between", value1, value2, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotBetween(String value1, String value2) {
            addCriterion("equip_type_name not between", value1, value2, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameIsNull() {
            addCriterion("equip_location_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameIsNotNull() {
            addCriterion("equip_location_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameEqualTo(String value) {
            addCriterion("equip_location_name =", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotEqualTo(String value) {
            addCriterion("equip_location_name <>", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameGreaterThan(String value) {
            addCriterion("equip_location_name >", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_location_name >=", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLessThan(String value) {
            addCriterion("equip_location_name <", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLessThanOrEqualTo(String value) {
            addCriterion("equip_location_name <=", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLike(String value) {
            addCriterion("equip_location_name like", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotLike(String value) {
            addCriterion("equip_location_name not like", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameIn(List<String> values) {
            addCriterion("equip_location_name in", values, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotIn(List<String> values) {
            addCriterion("equip_location_name not in", values, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameBetween(String value1, String value2) {
            addCriterion("equip_location_name between", value1, value2, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotBetween(String value1, String value2) {
            addCriterion("equip_location_name not between", value1, value2, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNull() {
            addCriterion("task_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNotNull() {
            addCriterion("task_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeEqualTo(String value) {
            addCriterion("task_code =", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotEqualTo(String value) {
            addCriterion("task_code <>", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThan(String value) {
            addCriterion("task_code >", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_code >=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThan(String value) {
            addCriterion("task_code <", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThanOrEqualTo(String value) {
            addCriterion("task_code <=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLike(String value) {
            addCriterion("task_code like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotLike(String value) {
            addCriterion("task_code not like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIn(List<String> values) {
            addCriterion("task_code in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotIn(List<String> values) {
            addCriterion("task_code not in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeBetween(String value1, String value2) {
            addCriterion("task_code between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotBetween(String value1, String value2) {
            addCriterion("task_code not between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNull() {
            addCriterion("duty_user is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNotNull() {
            addCriterion("duty_user is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserEqualTo(String value) {
            addCriterion("duty_user =", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotEqualTo(String value) {
            addCriterion("duty_user <>", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThan(String value) {
            addCriterion("duty_user >", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user >=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThan(String value) {
            addCriterion("duty_user <", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThanOrEqualTo(String value) {
            addCriterion("duty_user <=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLike(String value) {
            addCriterion("duty_user like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotLike(String value) {
            addCriterion("duty_user not like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserIn(List<String> values) {
            addCriterion("duty_user in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotIn(List<String> values) {
            addCriterion("duty_user not in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserBetween(String value1, String value2) {
            addCriterion("duty_user between", value1, value2, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotBetween(String value1, String value2) {
            addCriterion("duty_user not between", value1, value2, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameIsNull() {
            addCriterion("duty_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameIsNotNull() {
            addCriterion("duty_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameEqualTo(String value) {
            addCriterion("duty_user_name =", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameNotEqualTo(String value) {
            addCriterion("duty_user_name <>", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameGreaterThan(String value) {
            addCriterion("duty_user_name >", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user_name >=", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameLessThan(String value) {
            addCriterion("duty_user_name <", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameLessThanOrEqualTo(String value) {
            addCriterion("duty_user_name <=", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameLike(String value) {
            addCriterion("duty_user_name like", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameNotLike(String value) {
            addCriterion("duty_user_name not like", value, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameIn(List<String> values) {
            addCriterion("duty_user_name in", values, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameNotIn(List<String> values) {
            addCriterion("duty_user_name not in", values, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameBetween(String value1, String value2) {
            addCriterion("duty_user_name between", value1, value2, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andDutyUserNameNotBetween(String value1, String value2) {
            addCriterion("duty_user_name not between", value1, value2, "dutyUserName");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIsNull() {
            addCriterion("is_entrust is null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIsNotNull() {
            addCriterion("is_entrust is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustEqualTo(Integer value) {
            addCriterion("is_entrust =", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotEqualTo(Integer value) {
            addCriterion("is_entrust <>", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThan(Integer value) {
            addCriterion("is_entrust >", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_entrust >=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThan(Integer value) {
            addCriterion("is_entrust <", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThanOrEqualTo(Integer value) {
            addCriterion("is_entrust <=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIn(List<Integer> values) {
            addCriterion("is_entrust in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotIn(List<Integer> values) {
            addCriterion("is_entrust not in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust between", value1, value2, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust not between", value1, value2, "isEntrust");
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

        public Criteria andFlowNoIsNull() {
            addCriterion("flow_no is null");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNotNull() {
            addCriterion("flow_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNoEqualTo(String value) {
            addCriterion("flow_no =", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotEqualTo(String value) {
            addCriterion("flow_no <>", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThan(String value) {
            addCriterion("flow_no >", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThanOrEqualTo(String value) {
            addCriterion("flow_no >=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThan(String value) {
            addCriterion("flow_no <", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThanOrEqualTo(String value) {
            addCriterion("flow_no <=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLike(String value) {
            addCriterion("flow_no like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotLike(String value) {
            addCriterion("flow_no not like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoIn(List<String> values) {
            addCriterion("flow_no in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotIn(List<String> values) {
            addCriterion("flow_no not in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoBetween(String value1, String value2) {
            addCriterion("flow_no between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotBetween(String value1, String value2) {
            addCriterion("flow_no not between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andPlanCostIsNull() {
            addCriterion("plan_cost is null");
            return (Criteria) this;
        }

        public Criteria andPlanCostIsNotNull() {
            addCriterion("plan_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCostEqualTo(Double value) {
            addCriterion("plan_cost =", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotEqualTo(Double value) {
            addCriterion("plan_cost <>", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThan(Double value) {
            addCriterion("plan_cost >", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_cost >=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThan(Double value) {
            addCriterion("plan_cost <", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThanOrEqualTo(Double value) {
            addCriterion("plan_cost <=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostIn(List<Double> values) {
            addCriterion("plan_cost in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotIn(List<Double> values) {
            addCriterion("plan_cost not in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostBetween(Double value1, Double value2) {
            addCriterion("plan_cost between", value1, value2, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotBetween(Double value1, Double value2) {
            addCriterion("plan_cost not between", value1, value2, "planCost");
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
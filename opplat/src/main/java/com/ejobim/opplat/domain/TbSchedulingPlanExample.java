package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSchedulingPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSchedulingPlanExample() {
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

        public Criteria andSchedulingNoIsNull() {
            addCriterion("scheduling_no is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoIsNotNull() {
            addCriterion("scheduling_no is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoEqualTo(String value) {
            addCriterion("scheduling_no =", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoNotEqualTo(String value) {
            addCriterion("scheduling_no <>", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoGreaterThan(String value) {
            addCriterion("scheduling_no >", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_no >=", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoLessThan(String value) {
            addCriterion("scheduling_no <", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoLessThanOrEqualTo(String value) {
            addCriterion("scheduling_no <=", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoLike(String value) {
            addCriterion("scheduling_no like", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoNotLike(String value) {
            addCriterion("scheduling_no not like", value, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoIn(List<String> values) {
            addCriterion("scheduling_no in", values, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoNotIn(List<String> values) {
            addCriterion("scheduling_no not in", values, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoBetween(String value1, String value2) {
            addCriterion("scheduling_no between", value1, value2, "schedulingNo");
            return (Criteria) this;
        }

        public Criteria andSchedulingNoNotBetween(String value1, String value2) {
            addCriterion("scheduling_no not between", value1, value2, "schedulingNo");
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

        public Criteria andGroupTypeIsNull() {
            addCriterion("group_type is null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNotNull() {
            addCriterion("group_type is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeEqualTo(Integer value) {
            addCriterion("group_type =", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotEqualTo(Integer value) {
            addCriterion("group_type <>", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThan(Integer value) {
            addCriterion("group_type >", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_type >=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThan(Integer value) {
            addCriterion("group_type <", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("group_type <=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIn(List<Integer> values) {
            addCriterion("group_type in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotIn(List<Integer> values) {
            addCriterion("group_type not in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("group_type between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("group_type not between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupNoIsNull() {
            addCriterion("group_no is null");
            return (Criteria) this;
        }

        public Criteria andGroupNoIsNotNull() {
            addCriterion("group_no is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNoEqualTo(String value) {
            addCriterion("group_no =", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotEqualTo(String value) {
            addCriterion("group_no <>", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThan(String value) {
            addCriterion("group_no >", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("group_no >=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThan(String value) {
            addCriterion("group_no <", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLessThanOrEqualTo(String value) {
            addCriterion("group_no <=", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoLike(String value) {
            addCriterion("group_no like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotLike(String value) {
            addCriterion("group_no not like", value, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoIn(List<String> values) {
            addCriterion("group_no in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotIn(List<String> values) {
            addCriterion("group_no not in", values, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoBetween(String value1, String value2) {
            addCriterion("group_no between", value1, value2, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNoNotBetween(String value1, String value2) {
            addCriterion("group_no not between", value1, value2, "groupNo");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andStartTimePointIsNull() {
            addCriterion("start_time_point is null");
            return (Criteria) this;
        }

        public Criteria andStartTimePointIsNotNull() {
            addCriterion("start_time_point is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimePointEqualTo(Date value) {
            addCriterion("start_time_point =", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointNotEqualTo(Date value) {
            addCriterion("start_time_point <>", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointGreaterThan(Date value) {
            addCriterion("start_time_point >", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time_point >=", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointLessThan(Date value) {
            addCriterion("start_time_point <", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointLessThanOrEqualTo(Date value) {
            addCriterion("start_time_point <=", value, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointIn(List<Date> values) {
            addCriterion("start_time_point in", values, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointNotIn(List<Date> values) {
            addCriterion("start_time_point not in", values, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointBetween(Date value1, Date value2) {
            addCriterion("start_time_point between", value1, value2, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andStartTimePointNotBetween(Date value1, Date value2) {
            addCriterion("start_time_point not between", value1, value2, "startTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointIsNull() {
            addCriterion("end_time_point is null");
            return (Criteria) this;
        }

        public Criteria andEndTimePointIsNotNull() {
            addCriterion("end_time_point is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimePointEqualTo(Date value) {
            addCriterion("end_time_point =", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointNotEqualTo(Date value) {
            addCriterion("end_time_point <>", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointGreaterThan(Date value) {
            addCriterion("end_time_point >", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time_point >=", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointLessThan(Date value) {
            addCriterion("end_time_point <", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointLessThanOrEqualTo(Date value) {
            addCriterion("end_time_point <=", value, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointIn(List<Date> values) {
            addCriterion("end_time_point in", values, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointNotIn(List<Date> values) {
            addCriterion("end_time_point not in", values, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointBetween(Date value1, Date value2) {
            addCriterion("end_time_point between", value1, value2, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andEndTimePointNotBetween(Date value1, Date value2) {
            addCriterion("end_time_point not between", value1, value2, "endTimePoint");
            return (Criteria) this;
        }

        public Criteria andTimeNoIsNull() {
            addCriterion("time_no is null");
            return (Criteria) this;
        }

        public Criteria andTimeNoIsNotNull() {
            addCriterion("time_no is not null");
            return (Criteria) this;
        }

        public Criteria andTimeNoEqualTo(String value) {
            addCriterion("time_no =", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoNotEqualTo(String value) {
            addCriterion("time_no <>", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoGreaterThan(String value) {
            addCriterion("time_no >", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoGreaterThanOrEqualTo(String value) {
            addCriterion("time_no >=", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoLessThan(String value) {
            addCriterion("time_no <", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoLessThanOrEqualTo(String value) {
            addCriterion("time_no <=", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoLike(String value) {
            addCriterion("time_no like", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoNotLike(String value) {
            addCriterion("time_no not like", value, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoIn(List<String> values) {
            addCriterion("time_no in", values, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoNotIn(List<String> values) {
            addCriterion("time_no not in", values, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoBetween(String value1, String value2) {
            addCriterion("time_no between", value1, value2, "timeNo");
            return (Criteria) this;
        }

        public Criteria andTimeNoNotBetween(String value1, String value2) {
            addCriterion("time_no not between", value1, value2, "timeNo");
            return (Criteria) this;
        }

        public Criteria andDayTypeIsNull() {
            addCriterion("day_type is null");
            return (Criteria) this;
        }

        public Criteria andDayTypeIsNotNull() {
            addCriterion("day_type is not null");
            return (Criteria) this;
        }

        public Criteria andDayTypeEqualTo(Integer value) {
            addCriterion("day_type =", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeNotEqualTo(Integer value) {
            addCriterion("day_type <>", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeGreaterThan(Integer value) {
            addCriterion("day_type >", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_type >=", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeLessThan(Integer value) {
            addCriterion("day_type <", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("day_type <=", value, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeIn(List<Integer> values) {
            addCriterion("day_type in", values, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeNotIn(List<Integer> values) {
            addCriterion("day_type not in", values, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeBetween(Integer value1, Integer value2) {
            addCriterion("day_type between", value1, value2, "dayType");
            return (Criteria) this;
        }

        public Criteria andDayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("day_type not between", value1, value2, "dayType");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeIsNull() {
            addCriterion("scheduling_time is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeIsNotNull() {
            addCriterion("scheduling_time is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeEqualTo(String value) {
            addCriterion("scheduling_time =", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeNotEqualTo(String value) {
            addCriterion("scheduling_time <>", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeGreaterThan(String value) {
            addCriterion("scheduling_time >", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_time >=", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeLessThan(String value) {
            addCriterion("scheduling_time <", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeLessThanOrEqualTo(String value) {
            addCriterion("scheduling_time <=", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeLike(String value) {
            addCriterion("scheduling_time like", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeNotLike(String value) {
            addCriterion("scheduling_time not like", value, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeIn(List<String> values) {
            addCriterion("scheduling_time in", values, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeNotIn(List<String> values) {
            addCriterion("scheduling_time not in", values, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeBetween(String value1, String value2) {
            addCriterion("scheduling_time between", value1, value2, "schedulingTime");
            return (Criteria) this;
        }

        public Criteria andSchedulingTimeNotBetween(String value1, String value2) {
            addCriterion("scheduling_time not between", value1, value2, "schedulingTime");
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

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNull() {
            addCriterion("update_user_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNotNull() {
            addCriterion("update_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeEqualTo(String value) {
            addCriterion("update_user_code =", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotEqualTo(String value) {
            addCriterion("update_user_code <>", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThan(String value) {
            addCriterion("update_user_code >", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_code >=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThan(String value) {
            addCriterion("update_user_code <", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("update_user_code <=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLike(String value) {
            addCriterion("update_user_code like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotLike(String value) {
            addCriterion("update_user_code not like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIn(List<String> values) {
            addCriterion("update_user_code in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotIn(List<String> values) {
            addCriterion("update_user_code not in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeBetween(String value1, String value2) {
            addCriterion("update_user_code between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotBetween(String value1, String value2) {
            addCriterion("update_user_code not between", value1, value2, "updateUserCode");
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

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }


        public Criteria andScheduleRuleIsNull() {
            addCriterion("schedule_rule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleIsNotNull() {
            addCriterion("schedule_rule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleEqualTo(String value) {
            addCriterion("schedule_rule =", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleNotEqualTo(String value) {
            addCriterion("schedule_rule <>", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleGreaterThan(String value) {
            addCriterion("schedule_rule >", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_rule >=", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleLessThan(String value) {
            addCriterion("schedule_rule <", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleLessThanOrEqualTo(String value) {
            addCriterion("schedule_rule <=", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleLike(String value) {
            addCriterion("schedule_rule like", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleNotLike(String value) {
            addCriterion("schedule_rule not like", value, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleIn(List<String> values) {
            addCriterion("schedule_rule in", values, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleNotIn(List<String> values) {
            addCriterion("schedule_rule not in", values, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleBetween(String value1, String value2) {
            addCriterion("schedule_rule between", value1, value2, "scheduleRule");
            return (Criteria) this;
        }

        public Criteria andScheduleRuleNotBetween(String value1, String value2) {
            addCriterion("schedule_rule not between", value1, value2, "scheduleRule");
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
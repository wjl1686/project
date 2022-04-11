package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSchedulingChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSchedulingChangeExample() {
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

        public Criteria andChangeNoIsNull() {
            addCriterion("change_no is null");
            return (Criteria) this;
        }

        public Criteria andChangeNoIsNotNull() {
            addCriterion("change_no is not null");
            return (Criteria) this;
        }

        public Criteria andChangeNoEqualTo(String value) {
            addCriterion("change_no =", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoNotEqualTo(String value) {
            addCriterion("change_no <>", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoGreaterThan(String value) {
            addCriterion("change_no >", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoGreaterThanOrEqualTo(String value) {
            addCriterion("change_no >=", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoLessThan(String value) {
            addCriterion("change_no <", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoLessThanOrEqualTo(String value) {
            addCriterion("change_no <=", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoLike(String value) {
            addCriterion("change_no like", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoNotLike(String value) {
            addCriterion("change_no not like", value, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoIn(List<String> values) {
            addCriterion("change_no in", values, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoNotIn(List<String> values) {
            addCriterion("change_no not in", values, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoBetween(String value1, String value2) {
            addCriterion("change_no between", value1, value2, "changeNo");
            return (Criteria) this;
        }

        public Criteria andChangeNoNotBetween(String value1, String value2) {
            addCriterion("change_no not between", value1, value2, "changeNo");
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

        public Criteria andApplySchedulingNoDetailIsNull() {
            addCriterion("apply_scheduling_no_detail is null");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailIsNotNull() {
            addCriterion("apply_scheduling_no_detail is not null");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailEqualTo(String value) {
            addCriterion("apply_scheduling_no_detail =", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailNotEqualTo(String value) {
            addCriterion("apply_scheduling_no_detail <>", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailGreaterThan(String value) {
            addCriterion("apply_scheduling_no_detail >", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailGreaterThanOrEqualTo(String value) {
            addCriterion("apply_scheduling_no_detail >=", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailLessThan(String value) {
            addCriterion("apply_scheduling_no_detail <", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailLessThanOrEqualTo(String value) {
            addCriterion("apply_scheduling_no_detail <=", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailLike(String value) {
            addCriterion("apply_scheduling_no_detail like", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailNotLike(String value) {
            addCriterion("apply_scheduling_no_detail not like", value, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailIn(List<String> values) {
            addCriterion("apply_scheduling_no_detail in", values, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailNotIn(List<String> values) {
            addCriterion("apply_scheduling_no_detail not in", values, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailBetween(String value1, String value2) {
            addCriterion("apply_scheduling_no_detail between", value1, value2, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplySchedulingNoDetailNotBetween(String value1, String value2) {
            addCriterion("apply_scheduling_no_detail not between", value1, value2, "applySchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNull() {
            addCriterion("apply_user_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNotNull() {
            addCriterion("apply_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameEqualTo(String value) {
            addCriterion("apply_user_name =", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotEqualTo(String value) {
            addCriterion("apply_user_name <>", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThan(String value) {
            addCriterion("apply_user_name >", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_name >=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThan(String value) {
            addCriterion("apply_user_name <", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThanOrEqualTo(String value) {
            addCriterion("apply_user_name <=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLike(String value) {
            addCriterion("apply_user_name like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotLike(String value) {
            addCriterion("apply_user_name not like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIn(List<String> values) {
            addCriterion("apply_user_name in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotIn(List<String> values) {
            addCriterion("apply_user_name not in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameBetween(String value1, String value2) {
            addCriterion("apply_user_name between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotBetween(String value1, String value2) {
            addCriterion("apply_user_name not between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeIsNull() {
            addCriterion("apply_user_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeIsNotNull() {
            addCriterion("apply_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeEqualTo(String value) {
            addCriterion("apply_user_code =", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeNotEqualTo(String value) {
            addCriterion("apply_user_code <>", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeGreaterThan(String value) {
            addCriterion("apply_user_code >", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_code >=", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeLessThan(String value) {
            addCriterion("apply_user_code <", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_user_code <=", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeLike(String value) {
            addCriterion("apply_user_code like", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeNotLike(String value) {
            addCriterion("apply_user_code not like", value, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeIn(List<String> values) {
            addCriterion("apply_user_code in", values, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeNotIn(List<String> values) {
            addCriterion("apply_user_code not in", values, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeBetween(String value1, String value2) {
            addCriterion("apply_user_code between", value1, value2, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyUserCodeNotBetween(String value1, String value2) {
            addCriterion("apply_user_code not between", value1, value2, "applyUserCode");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointIsNull() {
            addCriterion("apply_group_time_point is null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointIsNotNull() {
            addCriterion("apply_group_time_point is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointEqualTo(String value) {
            addCriterion("apply_group_time_point =", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointNotEqualTo(String value) {
            addCriterion("apply_group_time_point <>", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointGreaterThan(String value) {
            addCriterion("apply_group_time_point >", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointGreaterThanOrEqualTo(String value) {
            addCriterion("apply_group_time_point >=", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointLessThan(String value) {
            addCriterion("apply_group_time_point <", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointLessThanOrEqualTo(String value) {
            addCriterion("apply_group_time_point <=", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointLike(String value) {
            addCriterion("apply_group_time_point like", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointNotLike(String value) {
            addCriterion("apply_group_time_point not like", value, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointIn(List<String> values) {
            addCriterion("apply_group_time_point in", values, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointNotIn(List<String> values) {
            addCriterion("apply_group_time_point not in", values, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointBetween(String value1, String value2) {
            addCriterion("apply_group_time_point between", value1, value2, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimePointNotBetween(String value1, String value2) {
            addCriterion("apply_group_time_point not between", value1, value2, "applyGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeIsNull() {
            addCriterion("apply_group_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeIsNotNull() {
            addCriterion("apply_group_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeEqualTo(Date value) {
            addCriterion("apply_group_time =", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeNotEqualTo(Date value) {
            addCriterion("apply_group_time <>", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeGreaterThan(Date value) {
            addCriterion("apply_group_time >", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_group_time >=", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeLessThan(Date value) {
            addCriterion("apply_group_time <", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_group_time <=", value, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeIn(List<Date> values) {
            addCriterion("apply_group_time in", values, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeNotIn(List<Date> values) {
            addCriterion("apply_group_time not in", values, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeBetween(Date value1, Date value2) {
            addCriterion("apply_group_time between", value1, value2, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_group_time not between", value1, value2, "applyGroupTime");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoIsNull() {
            addCriterion("apply_group_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoIsNotNull() {
            addCriterion("apply_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoEqualTo(String value) {
            addCriterion("apply_group_no =", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoNotEqualTo(String value) {
            addCriterion("apply_group_no <>", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoGreaterThan(String value) {
            addCriterion("apply_group_no >", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("apply_group_no >=", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoLessThan(String value) {
            addCriterion("apply_group_no <", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoLessThanOrEqualTo(String value) {
            addCriterion("apply_group_no <=", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoLike(String value) {
            addCriterion("apply_group_no like", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoNotLike(String value) {
            addCriterion("apply_group_no not like", value, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoIn(List<String> values) {
            addCriterion("apply_group_no in", values, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoNotIn(List<String> values) {
            addCriterion("apply_group_no not in", values, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoBetween(String value1, String value2) {
            addCriterion("apply_group_no between", value1, value2, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNoNotBetween(String value1, String value2) {
            addCriterion("apply_group_no not between", value1, value2, "applyGroupNo");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameIsNull() {
            addCriterion("apply_group_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameIsNotNull() {
            addCriterion("apply_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameEqualTo(String value) {
            addCriterion("apply_group_name =", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameNotEqualTo(String value) {
            addCriterion("apply_group_name <>", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameGreaterThan(String value) {
            addCriterion("apply_group_name >", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_group_name >=", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameLessThan(String value) {
            addCriterion("apply_group_name <", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameLessThanOrEqualTo(String value) {
            addCriterion("apply_group_name <=", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameLike(String value) {
            addCriterion("apply_group_name like", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameNotLike(String value) {
            addCriterion("apply_group_name not like", value, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameIn(List<String> values) {
            addCriterion("apply_group_name in", values, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameNotIn(List<String> values) {
            addCriterion("apply_group_name not in", values, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameBetween(String value1, String value2) {
            addCriterion("apply_group_name between", value1, value2, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyGroupNameNotBetween(String value1, String value2) {
            addCriterion("apply_group_name not between", value1, value2, "applyGroupName");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeIsNull() {
            addCriterion("apply_day_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeIsNotNull() {
            addCriterion("apply_day_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeEqualTo(Integer value) {
            addCriterion("apply_day_type =", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeNotEqualTo(Integer value) {
            addCriterion("apply_day_type <>", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeGreaterThan(Integer value) {
            addCriterion("apply_day_type >", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_day_type >=", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeLessThan(Integer value) {
            addCriterion("apply_day_type <", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("apply_day_type <=", value, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeIn(List<Integer> values) {
            addCriterion("apply_day_type in", values, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeNotIn(List<Integer> values) {
            addCriterion("apply_day_type not in", values, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeBetween(Integer value1, Integer value2) {
            addCriterion("apply_day_type between", value1, value2, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andApplyDayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_day_type not between", value1, value2, "applyDayType");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailIsNull() {
            addCriterion("target_scheduling_no_detail is null");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailIsNotNull() {
            addCriterion("target_scheduling_no_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailEqualTo(String value) {
            addCriterion("target_scheduling_no_detail =", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailNotEqualTo(String value) {
            addCriterion("target_scheduling_no_detail <>", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailGreaterThan(String value) {
            addCriterion("target_scheduling_no_detail >", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailGreaterThanOrEqualTo(String value) {
            addCriterion("target_scheduling_no_detail >=", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailLessThan(String value) {
            addCriterion("target_scheduling_no_detail <", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailLessThanOrEqualTo(String value) {
            addCriterion("target_scheduling_no_detail <=", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailLike(String value) {
            addCriterion("target_scheduling_no_detail like", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailNotLike(String value) {
            addCriterion("target_scheduling_no_detail not like", value, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailIn(List<String> values) {
            addCriterion("target_scheduling_no_detail in", values, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailNotIn(List<String> values) {
            addCriterion("target_scheduling_no_detail not in", values, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailBetween(String value1, String value2) {
            addCriterion("target_scheduling_no_detail between", value1, value2, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetSchedulingNoDetailNotBetween(String value1, String value2) {
            addCriterion("target_scheduling_no_detail not between", value1, value2, "targetSchedulingNoDetail");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameIsNull() {
            addCriterion("target_user_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameIsNotNull() {
            addCriterion("target_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameEqualTo(String value) {
            addCriterion("target_user_name =", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameNotEqualTo(String value) {
            addCriterion("target_user_name <>", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameGreaterThan(String value) {
            addCriterion("target_user_name >", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_user_name >=", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameLessThan(String value) {
            addCriterion("target_user_name <", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameLessThanOrEqualTo(String value) {
            addCriterion("target_user_name <=", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameLike(String value) {
            addCriterion("target_user_name like", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameNotLike(String value) {
            addCriterion("target_user_name not like", value, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameIn(List<String> values) {
            addCriterion("target_user_name in", values, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameNotIn(List<String> values) {
            addCriterion("target_user_name not in", values, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameBetween(String value1, String value2) {
            addCriterion("target_user_name between", value1, value2, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserNameNotBetween(String value1, String value2) {
            addCriterion("target_user_name not between", value1, value2, "targetUserName");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeIsNull() {
            addCriterion("target_user_code is null");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeIsNotNull() {
            addCriterion("target_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeEqualTo(String value) {
            addCriterion("target_user_code =", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeNotEqualTo(String value) {
            addCriterion("target_user_code <>", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeGreaterThan(String value) {
            addCriterion("target_user_code >", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("target_user_code >=", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeLessThan(String value) {
            addCriterion("target_user_code <", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeLessThanOrEqualTo(String value) {
            addCriterion("target_user_code <=", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeLike(String value) {
            addCriterion("target_user_code like", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeNotLike(String value) {
            addCriterion("target_user_code not like", value, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeIn(List<String> values) {
            addCriterion("target_user_code in", values, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeNotIn(List<String> values) {
            addCriterion("target_user_code not in", values, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeBetween(String value1, String value2) {
            addCriterion("target_user_code between", value1, value2, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetUserCodeNotBetween(String value1, String value2) {
            addCriterion("target_user_code not between", value1, value2, "targetUserCode");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointIsNull() {
            addCriterion("target_group_time_point is null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointIsNotNull() {
            addCriterion("target_group_time_point is not null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointEqualTo(String value) {
            addCriterion("target_group_time_point =", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointNotEqualTo(String value) {
            addCriterion("target_group_time_point <>", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointGreaterThan(String value) {
            addCriterion("target_group_time_point >", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointGreaterThanOrEqualTo(String value) {
            addCriterion("target_group_time_point >=", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointLessThan(String value) {
            addCriterion("target_group_time_point <", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointLessThanOrEqualTo(String value) {
            addCriterion("target_group_time_point <=", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointLike(String value) {
            addCriterion("target_group_time_point like", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointNotLike(String value) {
            addCriterion("target_group_time_point not like", value, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointIn(List<String> values) {
            addCriterion("target_group_time_point in", values, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointNotIn(List<String> values) {
            addCriterion("target_group_time_point not in", values, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointBetween(String value1, String value2) {
            addCriterion("target_group_time_point between", value1, value2, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimePointNotBetween(String value1, String value2) {
            addCriterion("target_group_time_point not between", value1, value2, "targetGroupTimePoint");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeIsNull() {
            addCriterion("target_group_time is null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeIsNotNull() {
            addCriterion("target_group_time is not null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeEqualTo(Date value) {
            addCriterion("target_group_time =", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeNotEqualTo(Date value) {
            addCriterion("target_group_time <>", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeGreaterThan(Date value) {
            addCriterion("target_group_time >", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("target_group_time >=", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeLessThan(Date value) {
            addCriterion("target_group_time <", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeLessThanOrEqualTo(Date value) {
            addCriterion("target_group_time <=", value, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeIn(List<Date> values) {
            addCriterion("target_group_time in", values, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeNotIn(List<Date> values) {
            addCriterion("target_group_time not in", values, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeBetween(Date value1, Date value2) {
            addCriterion("target_group_time between", value1, value2, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupTimeNotBetween(Date value1, Date value2) {
            addCriterion("target_group_time not between", value1, value2, "targetGroupTime");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoIsNull() {
            addCriterion("target_group_no is null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoIsNotNull() {
            addCriterion("target_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoEqualTo(String value) {
            addCriterion("target_group_no =", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoNotEqualTo(String value) {
            addCriterion("target_group_no <>", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoGreaterThan(String value) {
            addCriterion("target_group_no >", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("target_group_no >=", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoLessThan(String value) {
            addCriterion("target_group_no <", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoLessThanOrEqualTo(String value) {
            addCriterion("target_group_no <=", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoLike(String value) {
            addCriterion("target_group_no like", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoNotLike(String value) {
            addCriterion("target_group_no not like", value, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoIn(List<String> values) {
            addCriterion("target_group_no in", values, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoNotIn(List<String> values) {
            addCriterion("target_group_no not in", values, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoBetween(String value1, String value2) {
            addCriterion("target_group_no between", value1, value2, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNoNotBetween(String value1, String value2) {
            addCriterion("target_group_no not between", value1, value2, "targetGroupNo");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameIsNull() {
            addCriterion("target_group_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameIsNotNull() {
            addCriterion("target_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameEqualTo(String value) {
            addCriterion("target_group_name =", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameNotEqualTo(String value) {
            addCriterion("target_group_name <>", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameGreaterThan(String value) {
            addCriterion("target_group_name >", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_group_name >=", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameLessThan(String value) {
            addCriterion("target_group_name <", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameLessThanOrEqualTo(String value) {
            addCriterion("target_group_name <=", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameLike(String value) {
            addCriterion("target_group_name like", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameNotLike(String value) {
            addCriterion("target_group_name not like", value, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameIn(List<String> values) {
            addCriterion("target_group_name in", values, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameNotIn(List<String> values) {
            addCriterion("target_group_name not in", values, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameBetween(String value1, String value2) {
            addCriterion("target_group_name between", value1, value2, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetGroupNameNotBetween(String value1, String value2) {
            addCriterion("target_group_name not between", value1, value2, "targetGroupName");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeIsNull() {
            addCriterion("target_day_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeIsNotNull() {
            addCriterion("target_day_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeEqualTo(Integer value) {
            addCriterion("target_day_type =", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeNotEqualTo(Integer value) {
            addCriterion("target_day_type <>", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeGreaterThan(Integer value) {
            addCriterion("target_day_type >", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_day_type >=", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeLessThan(Integer value) {
            addCriterion("target_day_type <", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("target_day_type <=", value, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeIn(List<Integer> values) {
            addCriterion("target_day_type in", values, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeNotIn(List<Integer> values) {
            addCriterion("target_day_type not in", values, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeBetween(Integer value1, Integer value2) {
            addCriterion("target_day_type between", value1, value2, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andTargetDayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("target_day_type not between", value1, value2, "targetDayType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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
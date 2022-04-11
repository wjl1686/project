package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbReportModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReportModelExample() {
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

        public Criteria andRmNoIsNull() {
            addCriterion("rm_no is null");
            return (Criteria) this;
        }

        public Criteria andRmNoIsNotNull() {
            addCriterion("rm_no is not null");
            return (Criteria) this;
        }

        public Criteria andRmNoEqualTo(String value) {
            addCriterion("rm_no =", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoNotEqualTo(String value) {
            addCriterion("rm_no <>", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoGreaterThan(String value) {
            addCriterion("rm_no >", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoGreaterThanOrEqualTo(String value) {
            addCriterion("rm_no >=", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoLessThan(String value) {
            addCriterion("rm_no <", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoLessThanOrEqualTo(String value) {
            addCriterion("rm_no <=", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoLike(String value) {
            addCriterion("rm_no like", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoNotLike(String value) {
            addCriterion("rm_no not like", value, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoIn(List<String> values) {
            addCriterion("rm_no in", values, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoNotIn(List<String> values) {
            addCriterion("rm_no not in", values, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoBetween(String value1, String value2) {
            addCriterion("rm_no between", value1, value2, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNoNotBetween(String value1, String value2) {
            addCriterion("rm_no not between", value1, value2, "rmNo");
            return (Criteria) this;
        }

        public Criteria andRmNameIsNull() {
            addCriterion("rm_name is null");
            return (Criteria) this;
        }

        public Criteria andRmNameIsNotNull() {
            addCriterion("rm_name is not null");
            return (Criteria) this;
        }

        public Criteria andRmNameEqualTo(String value) {
            addCriterion("rm_name =", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameNotEqualTo(String value) {
            addCriterion("rm_name <>", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameGreaterThan(String value) {
            addCriterion("rm_name >", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameGreaterThanOrEqualTo(String value) {
            addCriterion("rm_name >=", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameLessThan(String value) {
            addCriterion("rm_name <", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameLessThanOrEqualTo(String value) {
            addCriterion("rm_name <=", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameLike(String value) {
            addCriterion("rm_name like", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameNotLike(String value) {
            addCriterion("rm_name not like", value, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameIn(List<String> values) {
            addCriterion("rm_name in", values, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameNotIn(List<String> values) {
            addCriterion("rm_name not in", values, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameBetween(String value1, String value2) {
            addCriterion("rm_name between", value1, value2, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmNameNotBetween(String value1, String value2) {
            addCriterion("rm_name not between", value1, value2, "rmName");
            return (Criteria) this;
        }

        public Criteria andRmCycleIsNull() {
            addCriterion("rm_cycle is null");
            return (Criteria) this;
        }

        public Criteria andRmCycleIsNotNull() {
            addCriterion("rm_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andRmCycleEqualTo(Integer value) {
            addCriterion("rm_cycle =", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleNotEqualTo(Integer value) {
            addCriterion("rm_cycle <>", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleGreaterThan(Integer value) {
            addCriterion("rm_cycle >", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("rm_cycle >=", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleLessThan(Integer value) {
            addCriterion("rm_cycle <", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleLessThanOrEqualTo(Integer value) {
            addCriterion("rm_cycle <=", value, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleIn(List<Integer> values) {
            addCriterion("rm_cycle in", values, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleNotIn(List<Integer> values) {
            addCriterion("rm_cycle not in", values, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleBetween(Integer value1, Integer value2) {
            addCriterion("rm_cycle between", value1, value2, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("rm_cycle not between", value1, value2, "rmCycle");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserIsNull() {
            addCriterion("rm_create_user is null");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserIsNotNull() {
            addCriterion("rm_create_user is not null");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserEqualTo(String value) {
            addCriterion("rm_create_user =", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserNotEqualTo(String value) {
            addCriterion("rm_create_user <>", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserGreaterThan(String value) {
            addCriterion("rm_create_user >", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("rm_create_user >=", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserLessThan(String value) {
            addCriterion("rm_create_user <", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserLessThanOrEqualTo(String value) {
            addCriterion("rm_create_user <=", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserLike(String value) {
            addCriterion("rm_create_user like", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserNotLike(String value) {
            addCriterion("rm_create_user not like", value, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserIn(List<String> values) {
            addCriterion("rm_create_user in", values, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserNotIn(List<String> values) {
            addCriterion("rm_create_user not in", values, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserBetween(String value1, String value2) {
            addCriterion("rm_create_user between", value1, value2, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUserNotBetween(String value1, String value2) {
            addCriterion("rm_create_user not between", value1, value2, "rmCreateUser");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameIsNull() {
            addCriterion("rm_create_use_name is null");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameIsNotNull() {
            addCriterion("rm_create_use_name is not null");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameEqualTo(String value) {
            addCriterion("rm_create_use_name =", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameNotEqualTo(String value) {
            addCriterion("rm_create_use_name <>", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameGreaterThan(String value) {
            addCriterion("rm_create_use_name >", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameGreaterThanOrEqualTo(String value) {
            addCriterion("rm_create_use_name >=", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameLessThan(String value) {
            addCriterion("rm_create_use_name <", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameLessThanOrEqualTo(String value) {
            addCriterion("rm_create_use_name <=", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameLike(String value) {
            addCriterion("rm_create_use_name like", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameNotLike(String value) {
            addCriterion("rm_create_use_name not like", value, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameIn(List<String> values) {
            addCriterion("rm_create_use_name in", values, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameNotIn(List<String> values) {
            addCriterion("rm_create_use_name not in", values, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameBetween(String value1, String value2) {
            addCriterion("rm_create_use_name between", value1, value2, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateUseNameNotBetween(String value1, String value2) {
            addCriterion("rm_create_use_name not between", value1, value2, "rmCreateUseName");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeIsNull() {
            addCriterion("rm_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeIsNotNull() {
            addCriterion("rm_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeEqualTo(Date value) {
            addCriterion("rm_create_time =", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeNotEqualTo(Date value) {
            addCriterion("rm_create_time <>", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeGreaterThan(Date value) {
            addCriterion("rm_create_time >", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rm_create_time >=", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeLessThan(Date value) {
            addCriterion("rm_create_time <", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("rm_create_time <=", value, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeIn(List<Date> values) {
            addCriterion("rm_create_time in", values, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeNotIn(List<Date> values) {
            addCriterion("rm_create_time not in", values, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeBetween(Date value1, Date value2) {
            addCriterion("rm_create_time between", value1, value2, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("rm_create_time not between", value1, value2, "rmCreateTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserIsNull() {
            addCriterion("rm_check_user is null");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserIsNotNull() {
            addCriterion("rm_check_user is not null");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserEqualTo(String value) {
            addCriterion("rm_check_user =", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNotEqualTo(String value) {
            addCriterion("rm_check_user <>", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserGreaterThan(String value) {
            addCriterion("rm_check_user >", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("rm_check_user >=", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserLessThan(String value) {
            addCriterion("rm_check_user <", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserLessThanOrEqualTo(String value) {
            addCriterion("rm_check_user <=", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserLike(String value) {
            addCriterion("rm_check_user like", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNotLike(String value) {
            addCriterion("rm_check_user not like", value, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserIn(List<String> values) {
            addCriterion("rm_check_user in", values, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNotIn(List<String> values) {
            addCriterion("rm_check_user not in", values, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserBetween(String value1, String value2) {
            addCriterion("rm_check_user between", value1, value2, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNotBetween(String value1, String value2) {
            addCriterion("rm_check_user not between", value1, value2, "rmCheckUser");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameIsNull() {
            addCriterion("rm_check_user_name is null");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameIsNotNull() {
            addCriterion("rm_check_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameEqualTo(String value) {
            addCriterion("rm_check_user_name =", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameNotEqualTo(String value) {
            addCriterion("rm_check_user_name <>", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameGreaterThan(String value) {
            addCriterion("rm_check_user_name >", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("rm_check_user_name >=", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameLessThan(String value) {
            addCriterion("rm_check_user_name <", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameLessThanOrEqualTo(String value) {
            addCriterion("rm_check_user_name <=", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameLike(String value) {
            addCriterion("rm_check_user_name like", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameNotLike(String value) {
            addCriterion("rm_check_user_name not like", value, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameIn(List<String> values) {
            addCriterion("rm_check_user_name in", values, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameNotIn(List<String> values) {
            addCriterion("rm_check_user_name not in", values, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameBetween(String value1, String value2) {
            addCriterion("rm_check_user_name between", value1, value2, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckUserNameNotBetween(String value1, String value2) {
            addCriterion("rm_check_user_name not between", value1, value2, "rmCheckUserName");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeIsNull() {
            addCriterion("rm_check_time is null");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeIsNotNull() {
            addCriterion("rm_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeEqualTo(Date value) {
            addCriterion("rm_check_time =", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeNotEqualTo(Date value) {
            addCriterion("rm_check_time <>", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeGreaterThan(Date value) {
            addCriterion("rm_check_time >", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rm_check_time >=", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeLessThan(Date value) {
            addCriterion("rm_check_time <", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("rm_check_time <=", value, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeIn(List<Date> values) {
            addCriterion("rm_check_time in", values, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeNotIn(List<Date> values) {
            addCriterion("rm_check_time not in", values, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeBetween(Date value1, Date value2) {
            addCriterion("rm_check_time between", value1, value2, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("rm_check_time not between", value1, value2, "rmCheckTime");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoIsNull() {
            addCriterion("rm_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoIsNotNull() {
            addCriterion("rm_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoEqualTo(String value) {
            addCriterion("rm_factory_no =", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoNotEqualTo(String value) {
            addCriterion("rm_factory_no <>", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoGreaterThan(String value) {
            addCriterion("rm_factory_no >", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("rm_factory_no >=", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoLessThan(String value) {
            addCriterion("rm_factory_no <", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("rm_factory_no <=", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoLike(String value) {
            addCriterion("rm_factory_no like", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoNotLike(String value) {
            addCriterion("rm_factory_no not like", value, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoIn(List<String> values) {
            addCriterion("rm_factory_no in", values, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoNotIn(List<String> values) {
            addCriterion("rm_factory_no not in", values, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoBetween(String value1, String value2) {
            addCriterion("rm_factory_no between", value1, value2, "rmFactoryNo");
            return (Criteria) this;
        }

        public Criteria andRmFactoryNoNotBetween(String value1, String value2) {
            addCriterion("rm_factory_no not between", value1, value2, "rmFactoryNo");
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
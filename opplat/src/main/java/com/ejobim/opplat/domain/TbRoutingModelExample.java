package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingModelExample() {
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

        public Criteria andRoutingModelNoIsNull() {
            addCriterion("routing_model_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoIsNotNull() {
            addCriterion("routing_model_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoEqualTo(String value) {
            addCriterion("routing_model_no =", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotEqualTo(String value) {
            addCriterion("routing_model_no <>", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoGreaterThan(String value) {
            addCriterion("routing_model_no >", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_model_no >=", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLessThan(String value) {
            addCriterion("routing_model_no <", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLessThanOrEqualTo(String value) {
            addCriterion("routing_model_no <=", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoLike(String value) {
            addCriterion("routing_model_no like", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotLike(String value) {
            addCriterion("routing_model_no not like", value, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoIn(List<String> values) {
            addCriterion("routing_model_no in", values, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotIn(List<String> values) {
            addCriterion("routing_model_no not in", values, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoBetween(String value1, String value2) {
            addCriterion("routing_model_no between", value1, value2, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNoNotBetween(String value1, String value2) {
            addCriterion("routing_model_no not between", value1, value2, "routingModelNo");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameIsNull() {
            addCriterion("routing_model_name is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameIsNotNull() {
            addCriterion("routing_model_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameEqualTo(String value) {
            addCriterion("routing_model_name =", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameNotEqualTo(String value) {
            addCriterion("routing_model_name <>", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameGreaterThan(String value) {
            addCriterion("routing_model_name >", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("routing_model_name >=", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameLessThan(String value) {
            addCriterion("routing_model_name <", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameLessThanOrEqualTo(String value) {
            addCriterion("routing_model_name <=", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameLike(String value) {
            addCriterion("routing_model_name like", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameNotLike(String value) {
            addCriterion("routing_model_name not like", value, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameIn(List<String> values) {
            addCriterion("routing_model_name in", values, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameNotIn(List<String> values) {
            addCriterion("routing_model_name not in", values, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameBetween(String value1, String value2) {
            addCriterion("routing_model_name between", value1, value2, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelNameNotBetween(String value1, String value2) {
            addCriterion("routing_model_name not between", value1, value2, "routingModelName");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelIsNull() {
            addCriterion("routing_model_level is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelIsNotNull() {
            addCriterion("routing_model_level is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelEqualTo(Integer value) {
            addCriterion("routing_model_level =", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelNotEqualTo(Integer value) {
            addCriterion("routing_model_level <>", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelGreaterThan(Integer value) {
            addCriterion("routing_model_level >", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("routing_model_level >=", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelLessThan(Integer value) {
            addCriterion("routing_model_level <", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelLessThanOrEqualTo(Integer value) {
            addCriterion("routing_model_level <=", value, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelIn(List<Integer> values) {
            addCriterion("routing_model_level in", values, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelNotIn(List<Integer> values) {
            addCriterion("routing_model_level not in", values, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelBetween(Integer value1, Integer value2) {
            addCriterion("routing_model_level between", value1, value2, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("routing_model_level not between", value1, value2, "routingModelLevel");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusIsNull() {
            addCriterion("routing_model_status is null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusIsNotNull() {
            addCriterion("routing_model_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusEqualTo(Integer value) {
            addCriterion("routing_model_status =", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusNotEqualTo(Integer value) {
            addCriterion("routing_model_status <>", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusGreaterThan(Integer value) {
            addCriterion("routing_model_status >", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("routing_model_status >=", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusLessThan(Integer value) {
            addCriterion("routing_model_status <", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusLessThanOrEqualTo(Integer value) {
            addCriterion("routing_model_status <=", value, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusIn(List<Integer> values) {
            addCriterion("routing_model_status in", values, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusNotIn(List<Integer> values) {
            addCriterion("routing_model_status not in", values, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusBetween(Integer value1, Integer value2) {
            addCriterion("routing_model_status between", value1, value2, "routingModelStatus");
            return (Criteria) this;
        }

        public Criteria andRoutingModelStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("routing_model_status not between", value1, value2, "routingModelStatus");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andTimeZonesIsNull() {
            addCriterion("time_zones is null");
            return (Criteria) this;
        }

        public Criteria andTimeZonesIsNotNull() {
            addCriterion("time_zones is not null");
            return (Criteria) this;
        }

        public Criteria andTimeZonesEqualTo(String value) {
            addCriterion("time_zones =", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesNotEqualTo(String value) {
            addCriterion("time_zones <>", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesGreaterThan(String value) {
            addCriterion("time_zones >", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesGreaterThanOrEqualTo(String value) {
            addCriterion("time_zones >=", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesLessThan(String value) {
            addCriterion("time_zones <", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesLessThanOrEqualTo(String value) {
            addCriterion("time_zones <=", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesLike(String value) {
            addCriterion("time_zones like", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesNotLike(String value) {
            addCriterion("time_zones not like", value, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesIn(List<String> values) {
            addCriterion("time_zones in", values, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesNotIn(List<String> values) {
            addCriterion("time_zones not in", values, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesBetween(String value1, String value2) {
            addCriterion("time_zones between", value1, value2, "timeZones");
            return (Criteria) this;
        }

        public Criteria andTimeZonesNotBetween(String value1, String value2) {
            addCriterion("time_zones not between", value1, value2, "timeZones");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNull() {
            addCriterion("all_count is null");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNotNull() {
            addCriterion("all_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllCountEqualTo(Integer value) {
            addCriterion("all_count =", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotEqualTo(Integer value) {
            addCriterion("all_count <>", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThan(Integer value) {
            addCriterion("all_count >", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_count >=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThan(Integer value) {
            addCriterion("all_count <", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThanOrEqualTo(Integer value) {
            addCriterion("all_count <=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIn(List<Integer> values) {
            addCriterion("all_count in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotIn(List<Integer> values) {
            addCriterion("all_count not in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountBetween(Integer value1, Integer value2) {
            addCriterion("all_count between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotBetween(Integer value1, Integer value2) {
            addCriterion("all_count not between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIsNull() {
            addCriterion("route_type is null");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIsNotNull() {
            addCriterion("route_type is not null");
            return (Criteria) this;
        }

        public Criteria andRouteTypeEqualTo(Integer value) {
            addCriterion("route_type =", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotEqualTo(Integer value) {
            addCriterion("route_type <>", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeGreaterThan(Integer value) {
            addCriterion("route_type >", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("route_type >=", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeLessThan(Integer value) {
            addCriterion("route_type <", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeLessThanOrEqualTo(Integer value) {
            addCriterion("route_type <=", value, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeIn(List<Integer> values) {
            addCriterion("route_type in", values, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotIn(List<Integer> values) {
            addCriterion("route_type not in", values, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeBetween(Integer value1, Integer value2) {
            addCriterion("route_type between", value1, value2, "routeType");
            return (Criteria) this;
        }

        public Criteria andRouteTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("route_type not between", value1, value2, "routeType");
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
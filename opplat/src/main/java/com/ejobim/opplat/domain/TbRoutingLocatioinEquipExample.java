package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingLocatioinEquipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingLocatioinEquipExample() {
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

        public Criteria andLocationEquipNoIsNull() {
            addCriterion("location_equip_no is null");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoIsNotNull() {
            addCriterion("location_equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoEqualTo(String value) {
            addCriterion("location_equip_no =", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoNotEqualTo(String value) {
            addCriterion("location_equip_no <>", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoGreaterThan(String value) {
            addCriterion("location_equip_no >", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("location_equip_no >=", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoLessThan(String value) {
            addCriterion("location_equip_no <", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoLessThanOrEqualTo(String value) {
            addCriterion("location_equip_no <=", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoLike(String value) {
            addCriterion("location_equip_no like", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoNotLike(String value) {
            addCriterion("location_equip_no not like", value, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoIn(List<String> values) {
            addCriterion("location_equip_no in", values, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoNotIn(List<String> values) {
            addCriterion("location_equip_no not in", values, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoBetween(String value1, String value2) {
            addCriterion("location_equip_no between", value1, value2, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andLocationEquipNoNotBetween(String value1, String value2) {
            addCriterion("location_equip_no not between", value1, value2, "locationEquipNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoIsNull() {
            addCriterion("routing_no is null");
            return (Criteria) this;
        }

        public Criteria andRoutingNoIsNotNull() {
            addCriterion("routing_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingNoEqualTo(String value) {
            addCriterion("routing_no =", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoNotEqualTo(String value) {
            addCriterion("routing_no <>", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoGreaterThan(String value) {
            addCriterion("routing_no >", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoGreaterThanOrEqualTo(String value) {
            addCriterion("routing_no >=", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoLessThan(String value) {
            addCriterion("routing_no <", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoLessThanOrEqualTo(String value) {
            addCriterion("routing_no <=", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoLike(String value) {
            addCriterion("routing_no like", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoNotLike(String value) {
            addCriterion("routing_no not like", value, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoIn(List<String> values) {
            addCriterion("routing_no in", values, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoNotIn(List<String> values) {
            addCriterion("routing_no not in", values, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoBetween(String value1, String value2) {
            addCriterion("routing_no between", value1, value2, "routingNo");
            return (Criteria) this;
        }

        public Criteria andRoutingNoNotBetween(String value1, String value2) {
            addCriterion("routing_no not between", value1, value2, "routingNo");
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

        public Criteria andEquipSortIsNull() {
            addCriterion("equip_sort is null");
            return (Criteria) this;
        }

        public Criteria andEquipSortIsNotNull() {
            addCriterion("equip_sort is not null");
            return (Criteria) this;
        }

        public Criteria andEquipSortEqualTo(Integer value) {
            addCriterion("equip_sort =", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotEqualTo(Integer value) {
            addCriterion("equip_sort <>", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortGreaterThan(Integer value) {
            addCriterion("equip_sort >", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_sort >=", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortLessThan(Integer value) {
            addCriterion("equip_sort <", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortLessThanOrEqualTo(Integer value) {
            addCriterion("equip_sort <=", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortIn(List<Integer> values) {
            addCriterion("equip_sort in", values, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotIn(List<Integer> values) {
            addCriterion("equip_sort not in", values, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortBetween(Integer value1, Integer value2) {
            addCriterion("equip_sort between", value1, value2, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_sort not between", value1, value2, "equipSort");
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
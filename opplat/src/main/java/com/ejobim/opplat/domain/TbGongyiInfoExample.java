package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGongyiInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGongyiInfoExample() {
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

        public Criteria andGongyiNoIsNull() {
            addCriterion("gongyi_no is null");
            return (Criteria) this;
        }

        public Criteria andGongyiNoIsNotNull() {
            addCriterion("gongyi_no is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiNoEqualTo(String value) {
            addCriterion("gongyi_no =", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoNotEqualTo(String value) {
            addCriterion("gongyi_no <>", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoGreaterThan(String value) {
            addCriterion("gongyi_no >", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoGreaterThanOrEqualTo(String value) {
            addCriterion("gongyi_no >=", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoLessThan(String value) {
            addCriterion("gongyi_no <", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoLessThanOrEqualTo(String value) {
            addCriterion("gongyi_no <=", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoLike(String value) {
            addCriterion("gongyi_no like", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoNotLike(String value) {
            addCriterion("gongyi_no not like", value, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoIn(List<String> values) {
            addCriterion("gongyi_no in", values, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoNotIn(List<String> values) {
            addCriterion("gongyi_no not in", values, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoBetween(String value1, String value2) {
            addCriterion("gongyi_no between", value1, value2, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNoNotBetween(String value1, String value2) {
            addCriterion("gongyi_no not between", value1, value2, "gongyiNo");
            return (Criteria) this;
        }

        public Criteria andGongyiNameIsNull() {
            addCriterion("gongyi_name is null");
            return (Criteria) this;
        }

        public Criteria andGongyiNameIsNotNull() {
            addCriterion("gongyi_name is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiNameEqualTo(String value) {
            addCriterion("gongyi_name =", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameNotEqualTo(String value) {
            addCriterion("gongyi_name <>", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameGreaterThan(String value) {
            addCriterion("gongyi_name >", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameGreaterThanOrEqualTo(String value) {
            addCriterion("gongyi_name >=", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameLessThan(String value) {
            addCriterion("gongyi_name <", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameLessThanOrEqualTo(String value) {
            addCriterion("gongyi_name <=", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameLike(String value) {
            addCriterion("gongyi_name like", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameNotLike(String value) {
            addCriterion("gongyi_name not like", value, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameIn(List<String> values) {
            addCriterion("gongyi_name in", values, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameNotIn(List<String> values) {
            addCriterion("gongyi_name not in", values, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameBetween(String value1, String value2) {
            addCriterion("gongyi_name between", value1, value2, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiNameNotBetween(String value1, String value2) {
            addCriterion("gongyi_name not between", value1, value2, "gongyiName");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserIsNull() {
            addCriterion("gongyi_create_user is null");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserIsNotNull() {
            addCriterion("gongyi_create_user is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserEqualTo(String value) {
            addCriterion("gongyi_create_user =", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserNotEqualTo(String value) {
            addCriterion("gongyi_create_user <>", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserGreaterThan(String value) {
            addCriterion("gongyi_create_user >", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("gongyi_create_user >=", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserLessThan(String value) {
            addCriterion("gongyi_create_user <", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserLessThanOrEqualTo(String value) {
            addCriterion("gongyi_create_user <=", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserLike(String value) {
            addCriterion("gongyi_create_user like", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserNotLike(String value) {
            addCriterion("gongyi_create_user not like", value, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserIn(List<String> values) {
            addCriterion("gongyi_create_user in", values, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserNotIn(List<String> values) {
            addCriterion("gongyi_create_user not in", values, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserBetween(String value1, String value2) {
            addCriterion("gongyi_create_user between", value1, value2, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateUserNotBetween(String value1, String value2) {
            addCriterion("gongyi_create_user not between", value1, value2, "gongyiCreateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeIsNull() {
            addCriterion("gongyi_create_time is null");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeIsNotNull() {
            addCriterion("gongyi_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeEqualTo(Date value) {
            addCriterion("gongyi_create_time =", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeNotEqualTo(Date value) {
            addCriterion("gongyi_create_time <>", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeGreaterThan(Date value) {
            addCriterion("gongyi_create_time >", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gongyi_create_time >=", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeLessThan(Date value) {
            addCriterion("gongyi_create_time <", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("gongyi_create_time <=", value, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeIn(List<Date> values) {
            addCriterion("gongyi_create_time in", values, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeNotIn(List<Date> values) {
            addCriterion("gongyi_create_time not in", values, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeBetween(Date value1, Date value2) {
            addCriterion("gongyi_create_time between", value1, value2, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("gongyi_create_time not between", value1, value2, "gongyiCreateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserIsNull() {
            addCriterion("gongyi_update_user is null");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserIsNotNull() {
            addCriterion("gongyi_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserEqualTo(String value) {
            addCriterion("gongyi_update_user =", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserNotEqualTo(String value) {
            addCriterion("gongyi_update_user <>", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserGreaterThan(String value) {
            addCriterion("gongyi_update_user >", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("gongyi_update_user >=", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserLessThan(String value) {
            addCriterion("gongyi_update_user <", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("gongyi_update_user <=", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserLike(String value) {
            addCriterion("gongyi_update_user like", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserNotLike(String value) {
            addCriterion("gongyi_update_user not like", value, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserIn(List<String> values) {
            addCriterion("gongyi_update_user in", values, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserNotIn(List<String> values) {
            addCriterion("gongyi_update_user not in", values, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserBetween(String value1, String value2) {
            addCriterion("gongyi_update_user between", value1, value2, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdateUserNotBetween(String value1, String value2) {
            addCriterion("gongyi_update_user not between", value1, value2, "gongyiUpdateUser");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeIsNull() {
            addCriterion("gongyi_updtate_time is null");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeIsNotNull() {
            addCriterion("gongyi_updtate_time is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeEqualTo(Date value) {
            addCriterion("gongyi_updtate_time =", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeNotEqualTo(Date value) {
            addCriterion("gongyi_updtate_time <>", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeGreaterThan(Date value) {
            addCriterion("gongyi_updtate_time >", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gongyi_updtate_time >=", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeLessThan(Date value) {
            addCriterion("gongyi_updtate_time <", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeLessThanOrEqualTo(Date value) {
            addCriterion("gongyi_updtate_time <=", value, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeIn(List<Date> values) {
            addCriterion("gongyi_updtate_time in", values, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeNotIn(List<Date> values) {
            addCriterion("gongyi_updtate_time not in", values, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeBetween(Date value1, Date value2) {
            addCriterion("gongyi_updtate_time between", value1, value2, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiUpdtateTimeNotBetween(Date value1, Date value2) {
            addCriterion("gongyi_updtate_time not between", value1, value2, "gongyiUpdtateTime");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoIsNull() {
            addCriterion("gongyi_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoIsNotNull() {
            addCriterion("gongyi_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoEqualTo(String value) {
            addCriterion("gongyi_factory_no =", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoNotEqualTo(String value) {
            addCriterion("gongyi_factory_no <>", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoGreaterThan(String value) {
            addCriterion("gongyi_factory_no >", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("gongyi_factory_no >=", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoLessThan(String value) {
            addCriterion("gongyi_factory_no <", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("gongyi_factory_no <=", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoLike(String value) {
            addCriterion("gongyi_factory_no like", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoNotLike(String value) {
            addCriterion("gongyi_factory_no not like", value, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoIn(List<String> values) {
            addCriterion("gongyi_factory_no in", values, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoNotIn(List<String> values) {
            addCriterion("gongyi_factory_no not in", values, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoBetween(String value1, String value2) {
            addCriterion("gongyi_factory_no between", value1, value2, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiFactoryNoNotBetween(String value1, String value2) {
            addCriterion("gongyi_factory_no not between", value1, value2, "gongyiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexIsNull() {
            addCriterion("gongyi_index is null");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexIsNotNull() {
            addCriterion("gongyi_index is not null");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexEqualTo(Integer value) {
            addCriterion("gongyi_index =", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexNotEqualTo(Integer value) {
            addCriterion("gongyi_index <>", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexGreaterThan(Integer value) {
            addCriterion("gongyi_index >", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("gongyi_index >=", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexLessThan(Integer value) {
            addCriterion("gongyi_index <", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexLessThanOrEqualTo(Integer value) {
            addCriterion("gongyi_index <=", value, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexIn(List<Integer> values) {
            addCriterion("gongyi_index in", values, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexNotIn(List<Integer> values) {
            addCriterion("gongyi_index not in", values, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexBetween(Integer value1, Integer value2) {
            addCriterion("gongyi_index between", value1, value2, "gongyiIndex");
            return (Criteria) this;
        }

        public Criteria andGongyiIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("gongyi_index not between", value1, value2, "gongyiIndex");
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
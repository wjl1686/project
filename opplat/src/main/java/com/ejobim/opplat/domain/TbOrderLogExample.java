package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbOrderLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrderLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIsNull() {
            addCriterion("before_user is null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIsNotNull() {
            addCriterion("before_user is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserEqualTo(String value) {
            addCriterion("before_user =", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotEqualTo(String value) {
            addCriterion("before_user <>", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserGreaterThan(String value) {
            addCriterion("before_user >", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserGreaterThanOrEqualTo(String value) {
            addCriterion("before_user >=", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLessThan(String value) {
            addCriterion("before_user <", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLessThanOrEqualTo(String value) {
            addCriterion("before_user <=", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLike(String value) {
            addCriterion("before_user like", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotLike(String value) {
            addCriterion("before_user not like", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIn(List<String> values) {
            addCriterion("before_user in", values, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotIn(List<String> values) {
            addCriterion("before_user not in", values, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserBetween(String value1, String value2) {
            addCriterion("before_user between", value1, value2, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotBetween(String value1, String value2) {
            addCriterion("before_user not between", value1, value2, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoIsNull() {
            addCriterion("before_user_no is null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoIsNotNull() {
            addCriterion("before_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoEqualTo(String value) {
            addCriterion("before_user_no =", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoNotEqualTo(String value) {
            addCriterion("before_user_no <>", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoGreaterThan(String value) {
            addCriterion("before_user_no >", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("before_user_no >=", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoLessThan(String value) {
            addCriterion("before_user_no <", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoLessThanOrEqualTo(String value) {
            addCriterion("before_user_no <=", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoLike(String value) {
            addCriterion("before_user_no like", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoNotLike(String value) {
            addCriterion("before_user_no not like", value, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoIn(List<String> values) {
            addCriterion("before_user_no in", values, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoNotIn(List<String> values) {
            addCriterion("before_user_no not in", values, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoBetween(String value1, String value2) {
            addCriterion("before_user_no between", value1, value2, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNoNotBetween(String value1, String value2) {
            addCriterion("before_user_no not between", value1, value2, "beforeUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserIsNull() {
            addCriterion("after_user is null");
            return (Criteria) this;
        }

        public Criteria andAfterUserIsNotNull() {
            addCriterion("after_user is not null");
            return (Criteria) this;
        }

        public Criteria andAfterUserEqualTo(String value) {
            addCriterion("after_user =", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotEqualTo(String value) {
            addCriterion("after_user <>", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserGreaterThan(String value) {
            addCriterion("after_user >", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserGreaterThanOrEqualTo(String value) {
            addCriterion("after_user >=", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLessThan(String value) {
            addCriterion("after_user <", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLessThanOrEqualTo(String value) {
            addCriterion("after_user <=", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLike(String value) {
            addCriterion("after_user like", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotLike(String value) {
            addCriterion("after_user not like", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserIn(List<String> values) {
            addCriterion("after_user in", values, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotIn(List<String> values) {
            addCriterion("after_user not in", values, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserBetween(String value1, String value2) {
            addCriterion("after_user between", value1, value2, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotBetween(String value1, String value2) {
            addCriterion("after_user not between", value1, value2, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoIsNull() {
            addCriterion("after_user_no is null");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoIsNotNull() {
            addCriterion("after_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoEqualTo(String value) {
            addCriterion("after_user_no =", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoNotEqualTo(String value) {
            addCriterion("after_user_no <>", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoGreaterThan(String value) {
            addCriterion("after_user_no >", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("after_user_no >=", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoLessThan(String value) {
            addCriterion("after_user_no <", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoLessThanOrEqualTo(String value) {
            addCriterion("after_user_no <=", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoLike(String value) {
            addCriterion("after_user_no like", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoNotLike(String value) {
            addCriterion("after_user_no not like", value, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoIn(List<String> values) {
            addCriterion("after_user_no in", values, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoNotIn(List<String> values) {
            addCriterion("after_user_no not in", values, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoBetween(String value1, String value2) {
            addCriterion("after_user_no between", value1, value2, "afterUserNo");
            return (Criteria) this;
        }

        public Criteria andAfterUserNoNotBetween(String value1, String value2) {
            addCriterion("after_user_no not between", value1, value2, "afterUserNo");
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
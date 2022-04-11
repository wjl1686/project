package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkOrderTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkOrderTempExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIsNull() {
            addCriterion("order_detail is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIsNotNull() {
            addCriterion("order_detail is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailEqualTo(String value) {
            addCriterion("order_detail =", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailNotEqualTo(String value) {
            addCriterion("order_detail <>", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGreaterThan(String value) {
            addCriterion("order_detail >", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailGreaterThanOrEqualTo(String value) {
            addCriterion("order_detail >=", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailLessThan(String value) {
            addCriterion("order_detail <", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailLessThanOrEqualTo(String value) {
            addCriterion("order_detail <=", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailLike(String value) {
            addCriterion("order_detail like", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailNotLike(String value) {
            addCriterion("order_detail not like", value, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIn(List<String> values) {
            addCriterion("order_detail in", values, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailNotIn(List<String> values) {
            addCriterion("order_detail not in", values, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailBetween(String value1, String value2) {
            addCriterion("order_detail between", value1, value2, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDetailNotBetween(String value1, String value2) {
            addCriterion("order_detail not between", value1, value2, "orderDetail");
            return (Criteria) this;
        }

        public Criteria andOrderDutyIsNull() {
            addCriterion("order_duty is null");
            return (Criteria) this;
        }

        public Criteria andOrderDutyIsNotNull() {
            addCriterion("order_duty is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDutyEqualTo(String value) {
            addCriterion("order_duty =", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNotEqualTo(String value) {
            addCriterion("order_duty <>", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyGreaterThan(String value) {
            addCriterion("order_duty >", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyGreaterThanOrEqualTo(String value) {
            addCriterion("order_duty >=", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyLessThan(String value) {
            addCriterion("order_duty <", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyLessThanOrEqualTo(String value) {
            addCriterion("order_duty <=", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyLike(String value) {
            addCriterion("order_duty like", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNotLike(String value) {
            addCriterion("order_duty not like", value, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyIn(List<String> values) {
            addCriterion("order_duty in", values, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNotIn(List<String> values) {
            addCriterion("order_duty not in", values, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyBetween(String value1, String value2) {
            addCriterion("order_duty between", value1, value2, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNotBetween(String value1, String value2) {
            addCriterion("order_duty not between", value1, value2, "orderDuty");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameIsNull() {
            addCriterion("order_duty_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameIsNotNull() {
            addCriterion("order_duty_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameEqualTo(String value) {
            addCriterion("order_duty_name =", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameNotEqualTo(String value) {
            addCriterion("order_duty_name <>", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameGreaterThan(String value) {
            addCriterion("order_duty_name >", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_duty_name >=", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameLessThan(String value) {
            addCriterion("order_duty_name <", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameLessThanOrEqualTo(String value) {
            addCriterion("order_duty_name <=", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameLike(String value) {
            addCriterion("order_duty_name like", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameNotLike(String value) {
            addCriterion("order_duty_name not like", value, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameIn(List<String> values) {
            addCriterion("order_duty_name in", values, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameNotIn(List<String> values) {
            addCriterion("order_duty_name not in", values, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameBetween(String value1, String value2) {
            addCriterion("order_duty_name between", value1, value2, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderDutyNameNotBetween(String value1, String value2) {
            addCriterion("order_duty_name not between", value1, value2, "orderDutyName");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIsNull() {
            addCriterion("order_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIsNotNull() {
            addCriterion("order_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeEqualTo(Date value) {
            addCriterion("order_end_time =", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotEqualTo(Date value) {
            addCriterion("order_end_time <>", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeGreaterThan(Date value) {
            addCriterion("order_end_time >", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_end_time >=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeLessThan(Date value) {
            addCriterion("order_end_time <", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_end_time <=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIn(List<Date> values) {
            addCriterion("order_end_time in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotIn(List<Date> values) {
            addCriterion("order_end_time not in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeBetween(Date value1, Date value2) {
            addCriterion("order_end_time between", value1, value2, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_end_time not between", value1, value2, "orderEndTime");
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

        public Criteria andOrderFinishTimeIsNull() {
            addCriterion("order_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeIsNotNull() {
            addCriterion("order_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeEqualTo(Date value) {
            addCriterion("order_finish_time =", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotEqualTo(Date value) {
            addCriterion("order_finish_time <>", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeGreaterThan(Date value) {
            addCriterion("order_finish_time >", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_finish_time >=", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeLessThan(Date value) {
            addCriterion("order_finish_time <", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_finish_time <=", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeIn(List<Date> values) {
            addCriterion("order_finish_time in", values, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotIn(List<Date> values) {
            addCriterion("order_finish_time not in", values, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeBetween(Date value1, Date value2) {
            addCriterion("order_finish_time between", value1, value2, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_finish_time not between", value1, value2, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesIsNull() {
            addCriterion("order_finish_pictures is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesIsNotNull() {
            addCriterion("order_finish_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesEqualTo(String value) {
            addCriterion("order_finish_pictures =", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesNotEqualTo(String value) {
            addCriterion("order_finish_pictures <>", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesGreaterThan(String value) {
            addCriterion("order_finish_pictures >", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("order_finish_pictures >=", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesLessThan(String value) {
            addCriterion("order_finish_pictures <", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesLessThanOrEqualTo(String value) {
            addCriterion("order_finish_pictures <=", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesLike(String value) {
            addCriterion("order_finish_pictures like", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesNotLike(String value) {
            addCriterion("order_finish_pictures not like", value, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesIn(List<String> values) {
            addCriterion("order_finish_pictures in", values, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesNotIn(List<String> values) {
            addCriterion("order_finish_pictures not in", values, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesBetween(String value1, String value2) {
            addCriterion("order_finish_pictures between", value1, value2, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishPicturesNotBetween(String value1, String value2) {
            addCriterion("order_finish_pictures not between", value1, value2, "orderFinishPictures");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoIsNull() {
            addCriterion("order_finish_video is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoIsNotNull() {
            addCriterion("order_finish_video is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoEqualTo(String value) {
            addCriterion("order_finish_video =", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoNotEqualTo(String value) {
            addCriterion("order_finish_video <>", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoGreaterThan(String value) {
            addCriterion("order_finish_video >", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoGreaterThanOrEqualTo(String value) {
            addCriterion("order_finish_video >=", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoLessThan(String value) {
            addCriterion("order_finish_video <", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoLessThanOrEqualTo(String value) {
            addCriterion("order_finish_video <=", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoLike(String value) {
            addCriterion("order_finish_video like", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoNotLike(String value) {
            addCriterion("order_finish_video not like", value, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoIn(List<String> values) {
            addCriterion("order_finish_video in", values, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoNotIn(List<String> values) {
            addCriterion("order_finish_video not in", values, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoBetween(String value1, String value2) {
            addCriterion("order_finish_video between", value1, value2, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andOrderFinishVideoNotBetween(String value1, String value2) {
            addCriterion("order_finish_video not between", value1, value2, "orderFinishVideo");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentIsNull() {
            addCriterion("tb_work_order_content is null");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentIsNotNull() {
            addCriterion("tb_work_order_content is not null");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentEqualTo(String value) {
            addCriterion("tb_work_order_content =", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentNotEqualTo(String value) {
            addCriterion("tb_work_order_content <>", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentGreaterThan(String value) {
            addCriterion("tb_work_order_content >", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentGreaterThanOrEqualTo(String value) {
            addCriterion("tb_work_order_content >=", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentLessThan(String value) {
            addCriterion("tb_work_order_content <", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentLessThanOrEqualTo(String value) {
            addCriterion("tb_work_order_content <=", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentLike(String value) {
            addCriterion("tb_work_order_content like", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentNotLike(String value) {
            addCriterion("tb_work_order_content not like", value, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentIn(List<String> values) {
            addCriterion("tb_work_order_content in", values, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentNotIn(List<String> values) {
            addCriterion("tb_work_order_content not in", values, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentBetween(String value1, String value2) {
            addCriterion("tb_work_order_content between", value1, value2, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andTbWorkOrderContentNotBetween(String value1, String value2) {
            addCriterion("tb_work_order_content not between", value1, value2, "tbWorkOrderContent");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoIsNull() {
            addCriterion("order_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoIsNotNull() {
            addCriterion("order_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoEqualTo(String value) {
            addCriterion("order_factory_no =", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoNotEqualTo(String value) {
            addCriterion("order_factory_no <>", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoGreaterThan(String value) {
            addCriterion("order_factory_no >", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_factory_no >=", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoLessThan(String value) {
            addCriterion("order_factory_no <", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("order_factory_no <=", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoLike(String value) {
            addCriterion("order_factory_no like", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoNotLike(String value) {
            addCriterion("order_factory_no not like", value, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoIn(List<String> values) {
            addCriterion("order_factory_no in", values, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoNotIn(List<String> values) {
            addCriterion("order_factory_no not in", values, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoBetween(String value1, String value2) {
            addCriterion("order_factory_no between", value1, value2, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderFactoryNoNotBetween(String value1, String value2) {
            addCriterion("order_factory_no not between", value1, value2, "orderFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
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
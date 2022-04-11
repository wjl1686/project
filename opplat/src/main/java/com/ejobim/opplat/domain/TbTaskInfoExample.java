package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbTaskInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbTaskInfoExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNull() {
            addCriterion("task_group is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNotNull() {
            addCriterion("task_group is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupEqualTo(String value) {
            addCriterion("task_group =", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotEqualTo(String value) {
            addCriterion("task_group <>", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThan(String value) {
            addCriterion("task_group >", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThanOrEqualTo(String value) {
            addCriterion("task_group >=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThan(String value) {
            addCriterion("task_group <", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThanOrEqualTo(String value) {
            addCriterion("task_group <=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLike(String value) {
            addCriterion("task_group like", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotLike(String value) {
            addCriterion("task_group not like", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIn(List<String> values) {
            addCriterion("task_group in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotIn(List<String> values) {
            addCriterion("task_group not in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupBetween(String value1, String value2) {
            addCriterion("task_group between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotBetween(String value1, String value2) {
            addCriterion("task_group not between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoIsNull() {
            addCriterion("task_user_no is null");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoIsNotNull() {
            addCriterion("task_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoEqualTo(String value) {
            addCriterion("task_user_no =", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoNotEqualTo(String value) {
            addCriterion("task_user_no <>", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoGreaterThan(String value) {
            addCriterion("task_user_no >", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("task_user_no >=", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoLessThan(String value) {
            addCriterion("task_user_no <", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoLessThanOrEqualTo(String value) {
            addCriterion("task_user_no <=", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoLike(String value) {
            addCriterion("task_user_no like", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoNotLike(String value) {
            addCriterion("task_user_no not like", value, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoIn(List<String> values) {
            addCriterion("task_user_no in", values, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoNotIn(List<String> values) {
            addCriterion("task_user_no not in", values, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoBetween(String value1, String value2) {
            addCriterion("task_user_no between", value1, value2, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNoNotBetween(String value1, String value2) {
            addCriterion("task_user_no not between", value1, value2, "taskUserNo");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameIsNull() {
            addCriterion("task_user_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameIsNotNull() {
            addCriterion("task_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameEqualTo(String value) {
            addCriterion("task_user_name =", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameNotEqualTo(String value) {
            addCriterion("task_user_name <>", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameGreaterThan(String value) {
            addCriterion("task_user_name >", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_user_name >=", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameLessThan(String value) {
            addCriterion("task_user_name <", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameLessThanOrEqualTo(String value) {
            addCriterion("task_user_name <=", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameLike(String value) {
            addCriterion("task_user_name like", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameNotLike(String value) {
            addCriterion("task_user_name not like", value, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameIn(List<String> values) {
            addCriterion("task_user_name in", values, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameNotIn(List<String> values) {
            addCriterion("task_user_name not in", values, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameBetween(String value1, String value2) {
            addCriterion("task_user_name between", value1, value2, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskUserNameNotBetween(String value1, String value2) {
            addCriterion("task_user_name not between", value1, value2, "taskUserName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
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

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
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

        public Criteria andCreateUserNoIsNull() {
            addCriterion("create_user_no is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoIsNotNull() {
            addCriterion("create_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoEqualTo(String value) {
            addCriterion("create_user_no =", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoNotEqualTo(String value) {
            addCriterion("create_user_no <>", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoGreaterThan(String value) {
            addCriterion("create_user_no >", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_no >=", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoLessThan(String value) {
            addCriterion("create_user_no <", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoLessThanOrEqualTo(String value) {
            addCriterion("create_user_no <=", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoLike(String value) {
            addCriterion("create_user_no like", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoNotLike(String value) {
            addCriterion("create_user_no not like", value, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoIn(List<String> values) {
            addCriterion("create_user_no in", values, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoNotIn(List<String> values) {
            addCriterion("create_user_no not in", values, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoBetween(String value1, String value2) {
            addCriterion("create_user_no between", value1, value2, "createUserNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserNoNotBetween(String value1, String value2) {
            addCriterion("create_user_no not between", value1, value2, "createUserNo");
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

        public Criteria andExpectStartTimeIsNull() {
            addCriterion("expect_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeIsNotNull() {
            addCriterion("expect_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeEqualTo(Date value) {
            addCriterion("expect_start_time =", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeNotEqualTo(Date value) {
            addCriterion("expect_start_time <>", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeGreaterThan(Date value) {
            addCriterion("expect_start_time >", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_start_time >=", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeLessThan(Date value) {
            addCriterion("expect_start_time <", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_start_time <=", value, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeIn(List<Date> values) {
            addCriterion("expect_start_time in", values, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeNotIn(List<Date> values) {
            addCriterion("expect_start_time not in", values, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeBetween(Date value1, Date value2) {
            addCriterion("expect_start_time between", value1, value2, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_start_time not between", value1, value2, "expectStartTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeIsNull() {
            addCriterion("expect_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeIsNotNull() {
            addCriterion("expect_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeEqualTo(Date value) {
            addCriterion("expect_end_time =", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeNotEqualTo(Date value) {
            addCriterion("expect_end_time <>", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeGreaterThan(Date value) {
            addCriterion("expect_end_time >", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_end_time >=", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeLessThan(Date value) {
            addCriterion("expect_end_time <", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_end_time <=", value, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeIn(List<Date> values) {
            addCriterion("expect_end_time in", values, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeNotIn(List<Date> values) {
            addCriterion("expect_end_time not in", values, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeBetween(Date value1, Date value2) {
            addCriterion("expect_end_time between", value1, value2, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andExpectEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_end_time not between", value1, value2, "expectEndTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNull() {
            addCriterion("actual_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNotNull() {
            addCriterion("actual_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeEqualTo(Date value) {
            addCriterion("actual_start_time =", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotEqualTo(Date value) {
            addCriterion("actual_start_time <>", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThan(Date value) {
            addCriterion("actual_start_time >", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_start_time >=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThan(Date value) {
            addCriterion("actual_start_time <", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_start_time <=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIn(List<Date> values) {
            addCriterion("actual_start_time in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotIn(List<Date> values) {
            addCriterion("actual_start_time not in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeBetween(Date value1, Date value2) {
            addCriterion("actual_start_time between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_start_time not between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_end_time not between", value1, value2, "actualEndTime");
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
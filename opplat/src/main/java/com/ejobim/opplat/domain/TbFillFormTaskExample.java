package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFillFormTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFillFormTaskExample() {
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

        public Criteria andFillTaskNoIsNull() {
            addCriterion("fill_task_no is null");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoIsNotNull() {
            addCriterion("fill_task_no is not null");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoEqualTo(String value) {
            addCriterion("fill_task_no =", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotEqualTo(String value) {
            addCriterion("fill_task_no <>", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoGreaterThan(String value) {
            addCriterion("fill_task_no >", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("fill_task_no >=", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLessThan(String value) {
            addCriterion("fill_task_no <", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLessThanOrEqualTo(String value) {
            addCriterion("fill_task_no <=", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoLike(String value) {
            addCriterion("fill_task_no like", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotLike(String value) {
            addCriterion("fill_task_no not like", value, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoIn(List<String> values) {
            addCriterion("fill_task_no in", values, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotIn(List<String> values) {
            addCriterion("fill_task_no not in", values, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoBetween(String value1, String value2) {
            addCriterion("fill_task_no between", value1, value2, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskNoNotBetween(String value1, String value2) {
            addCriterion("fill_task_no not between", value1, value2, "fillTaskNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeIsNull() {
            addCriterion("fill_task_time is null");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeIsNotNull() {
            addCriterion("fill_task_time is not null");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeEqualTo(Date value) {
            addCriterion("fill_task_time =", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeNotEqualTo(Date value) {
            addCriterion("fill_task_time <>", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeGreaterThan(Date value) {
            addCriterion("fill_task_time >", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fill_task_time >=", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeLessThan(Date value) {
            addCriterion("fill_task_time <", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeLessThanOrEqualTo(Date value) {
            addCriterion("fill_task_time <=", value, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeIn(List<Date> values) {
            addCriterion("fill_task_time in", values, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeNotIn(List<Date> values) {
            addCriterion("fill_task_time not in", values, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeBetween(Date value1, Date value2) {
            addCriterion("fill_task_time between", value1, value2, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskTimeNotBetween(Date value1, Date value2) {
            addCriterion("fill_task_time not between", value1, value2, "fillTaskTime");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoIsNull() {
            addCriterion("fill_task_user_no is null");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoIsNotNull() {
            addCriterion("fill_task_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoEqualTo(String value) {
            addCriterion("fill_task_user_no =", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoNotEqualTo(String value) {
            addCriterion("fill_task_user_no <>", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoGreaterThan(String value) {
            addCriterion("fill_task_user_no >", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("fill_task_user_no >=", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoLessThan(String value) {
            addCriterion("fill_task_user_no <", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoLessThanOrEqualTo(String value) {
            addCriterion("fill_task_user_no <=", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoLike(String value) {
            addCriterion("fill_task_user_no like", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoNotLike(String value) {
            addCriterion("fill_task_user_no not like", value, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoIn(List<String> values) {
            addCriterion("fill_task_user_no in", values, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoNotIn(List<String> values) {
            addCriterion("fill_task_user_no not in", values, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoBetween(String value1, String value2) {
            addCriterion("fill_task_user_no between", value1, value2, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillTaskUserNoNotBetween(String value1, String value2) {
            addCriterion("fill_task_user_no not between", value1, value2, "fillTaskUserNo");
            return (Criteria) this;
        }

        public Criteria andFillCountAllIsNull() {
            addCriterion("fill_count_all is null");
            return (Criteria) this;
        }

        public Criteria andFillCountAllIsNotNull() {
            addCriterion("fill_count_all is not null");
            return (Criteria) this;
        }

        public Criteria andFillCountAllEqualTo(Integer value) {
            addCriterion("fill_count_all =", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllNotEqualTo(Integer value) {
            addCriterion("fill_count_all <>", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllGreaterThan(Integer value) {
            addCriterion("fill_count_all >", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_count_all >=", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllLessThan(Integer value) {
            addCriterion("fill_count_all <", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllLessThanOrEqualTo(Integer value) {
            addCriterion("fill_count_all <=", value, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllIn(List<Integer> values) {
            addCriterion("fill_count_all in", values, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllNotIn(List<Integer> values) {
            addCriterion("fill_count_all not in", values, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllBetween(Integer value1, Integer value2) {
            addCriterion("fill_count_all between", value1, value2, "fillCountAll");
            return (Criteria) this;
        }

        public Criteria andFillCountAllNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_count_all not between", value1, value2, "fillCountAll");
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


        public Criteria andFillCountIsNull() {
            addCriterion("fill_count is null");
            return (Criteria) this;
        }

        public Criteria andFillCountIsNotNull() {
            addCriterion("fill_count is not null");
            return (Criteria) this;
        }

        public Criteria andFillCountEqualTo(Integer value) {
            addCriterion("fill_count =", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotEqualTo(Integer value) {
            addCriterion("fill_count <>", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountGreaterThan(Integer value) {
            addCriterion("fill_count >", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_count >=", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountLessThan(Integer value) {
            addCriterion("fill_count <", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountLessThanOrEqualTo(Integer value) {
            addCriterion("fill_count <=", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountIn(List<Integer> values) {
            addCriterion("fill_count in", values, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotIn(List<Integer> values) {
            addCriterion("fill_count not in", values, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountBetween(Integer value1, Integer value2) {
            addCriterion("fill_count between", value1, value2, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_count not between", value1, value2, "fillCount");
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

        public Criteria andEquipStatusIsNull() {
            addCriterion("equip_status is null");
            return (Criteria) this;
        }

        public Criteria andEquipStatusIsNotNull() {
            addCriterion("equip_status is not null");
            return (Criteria) this;
        }

        public Criteria andEquipStatusEqualTo(Integer value) {
            addCriterion("equip_status =", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotEqualTo(Integer value) {
            addCriterion("equip_status <>", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusGreaterThan(Integer value) {
            addCriterion("equip_status >", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_status >=", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusLessThan(Integer value) {
            addCriterion("equip_status <", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusLessThanOrEqualTo(Integer value) {
            addCriterion("equip_status <=", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusIn(List<Integer> values) {
            addCriterion("equip_status in", values, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotIn(List<Integer> values) {
            addCriterion("equip_status not in", values, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusBetween(Integer value1, Integer value2) {
            addCriterion("equip_status between", value1, value2, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_status not between", value1, value2, "equipStatus");
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
            addCriterion("end_time <>", value, "EndTime");
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

        public Criteria andCommitTimeIsNull() {
            addCriterion("commit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commit_time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commit_time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commit_time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commit_time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commit_time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commit_time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commit_time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commit_time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commit_time not between", value1, value2, "commitTime");
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

        public Criteria andCheckUserIsNull() {
            addCriterion("check_user is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNotNull() {
            addCriterion("check_user is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserEqualTo(String value) {
            addCriterion("check_user =", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotEqualTo(String value) {
            addCriterion("check_user <>", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThan(String value) {
            addCriterion("check_user >", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("check_user >=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThan(String value) {
            addCriterion("check_user <", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThanOrEqualTo(String value) {
            addCriterion("check_user <=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLike(String value) {
            addCriterion("check_user like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotLike(String value) {
            addCriterion("check_user not like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserIn(List<String> values) {
            addCriterion("check_user in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotIn(List<String> values) {
            addCriterion("check_user not in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserBetween(String value1, String value2) {
            addCriterion("check_user between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotBetween(String value1, String value2) {
            addCriterion("check_user not between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andFillUserIsNull() {
            addCriterion("fill_user is null");
            return (Criteria) this;
        }

        public Criteria andFillUserIsNotNull() {
            addCriterion("fill_user is not null");
            return (Criteria) this;
        }

        public Criteria andFillUserEqualTo(String value) {
            addCriterion("fill_user =", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserNotEqualTo(String value) {
            addCriterion("fill_user <>", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserGreaterThan(String value) {
            addCriterion("fill_user >", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserGreaterThanOrEqualTo(String value) {
            addCriterion("fill_user >=", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserLessThan(String value) {
            addCriterion("fill_user <", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserLessThanOrEqualTo(String value) {
            addCriterion("fill_user <=", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserLike(String value) {
            addCriterion("fill_user like", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserNotLike(String value) {
            addCriterion("fill_user not like", value, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserIn(List<String> values) {
            addCriterion("fill_user in", values, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserNotIn(List<String> values) {
            addCriterion("fill_user not in", values, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserBetween(String value1, String value2) {
            addCriterion("fill_user between", value1, value2, "fillUser");
            return (Criteria) this;
        }

        public Criteria andFillUserNotBetween(String value1, String value2) {
            addCriterion("fill_user not between", value1, value2, "fillUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameEqualTo(String value) {
            addCriterion("check_user_name =", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotEqualTo(String value) {
            addCriterion("check_user_name <>", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameGreaterThan(String value) {
            addCriterion("check_user_name >", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_user_name >=", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLessThan(String value) {
            addCriterion("check_user_name <", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLessThanOrEqualTo(String value) {
            addCriterion("check_user_name <=", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLike(String value) {
            addCriterion("check_user_name like", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotLike(String value) {
            addCriterion("check_user_name not like", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIn(List<String> values) {
            addCriterion("check_user_name in", values, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotIn(List<String> values) {
            addCriterion("check_user_name not in", values, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameBetween(String value1, String value2) {
            addCriterion("check_user_name between", value1, value2, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotBetween(String value1, String value2) {
            addCriterion("check_user_name not between", value1, value2, "checkUserName");
            return (Criteria) this;
        }

        //

        public Criteria andFillUserNameEqualTo(String value) {
            addCriterion("fill_user_name =", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameNotEqualTo(String value) {
            addCriterion("fill_user_name <>", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameGreaterThan(String value) {
            addCriterion("fill_user_name >", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("fill_user_name >=", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameLessThan(String value) {
            addCriterion("fill_user_name <", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameLessThanOrEqualTo(String value) {
            addCriterion("fill_user_name <=", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameLike(String value) {
            addCriterion("fill_user_name like", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameNotLike(String value) {
            addCriterion("fill_user_name not like", value, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameIn(List<String> values) {
            addCriterion("fill_user_name in", values, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameNotIn(List<String> values) {
            addCriterion("fill_user_name not in", values, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameBetween(String value1, String value2) {
            addCriterion("fill_user_name between", value1, value2, "fillUserName");
            return (Criteria) this;
        }

        public Criteria andFillUserNameNotBetween(String value1, String value2) {
            addCriterion("fill_user_name not between", value1, value2, "fillUserName");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAnalysisFillTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAnalysisFillTaskExample() {
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

        public Criteria andFillUserCodeIsNull() {
            addCriterion("fill_user_code is null");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeIsNotNull() {
            addCriterion("fill_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeEqualTo(String value) {
            addCriterion("fill_user_code =", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeNotEqualTo(String value) {
            addCriterion("fill_user_code <>", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeGreaterThan(String value) {
            addCriterion("fill_user_code >", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fill_user_code >=", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeLessThan(String value) {
            addCriterion("fill_user_code <", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeLessThanOrEqualTo(String value) {
            addCriterion("fill_user_code <=", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeLike(String value) {
            addCriterion("fill_user_code like", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeNotLike(String value) {
            addCriterion("fill_user_code not like", value, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeIn(List<String> values) {
            addCriterion("fill_user_code in", values, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeNotIn(List<String> values) {
            addCriterion("fill_user_code not in", values, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeBetween(String value1, String value2) {
            addCriterion("fill_user_code between", value1, value2, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserCodeNotBetween(String value1, String value2) {
            addCriterion("fill_user_code not between", value1, value2, "fillUserCode");
            return (Criteria) this;
        }

        public Criteria andFillUserNameIsNull() {
            addCriterion("fill_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFillUserNameIsNotNull() {
            addCriterion("fill_user_name is not null");
            return (Criteria) this;
        }

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

        public Criteria andCheckUserCodeIsNull() {
            addCriterion("check_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeIsNotNull() {
            addCriterion("check_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeEqualTo(String value) {
            addCriterion("check_user_code =", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeNotEqualTo(String value) {
            addCriterion("check_user_code <>", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeGreaterThan(String value) {
            addCriterion("check_user_code >", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("check_user_code >=", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeLessThan(String value) {
            addCriterion("check_user_code <", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeLessThanOrEqualTo(String value) {
            addCriterion("check_user_code <=", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeLike(String value) {
            addCriterion("check_user_code like", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeNotLike(String value) {
            addCriterion("check_user_code not like", value, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeIn(List<String> values) {
            addCriterion("check_user_code in", values, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeNotIn(List<String> values) {
            addCriterion("check_user_code not in", values, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeBetween(String value1, String value2) {
            addCriterion("check_user_code between", value1, value2, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserCodeNotBetween(String value1, String value2) {
            addCriterion("check_user_code not between", value1, value2, "checkUserCode");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIsNull() {
            addCriterion("check_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIsNotNull() {
            addCriterion("check_user_name is not null");
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

        public Criteria andFillTaskCodeIsNull() {
            addCriterion("fill_task_code is null");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeIsNotNull() {
            addCriterion("fill_task_code is not null");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeEqualTo(String value) {
            addCriterion("fill_task_code =", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeNotEqualTo(String value) {
            addCriterion("fill_task_code <>", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeGreaterThan(String value) {
            addCriterion("fill_task_code >", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fill_task_code >=", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeLessThan(String value) {
            addCriterion("fill_task_code <", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeLessThanOrEqualTo(String value) {
            addCriterion("fill_task_code <=", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeLike(String value) {
            addCriterion("fill_task_code like", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeNotLike(String value) {
            addCriterion("fill_task_code not like", value, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeIn(List<String> values) {
            addCriterion("fill_task_code in", values, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeNotIn(List<String> values) {
            addCriterion("fill_task_code not in", values, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeBetween(String value1, String value2) {
            addCriterion("fill_task_code between", value1, value2, "fillTaskCode");
            return (Criteria) this;
        }

        public Criteria andFillTaskCodeNotBetween(String value1, String value2) {
            addCriterion("fill_task_code not between", value1, value2, "fillTaskCode");
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

        public Criteria andDraftStatusIsNull() {
            addCriterion("draft_status is null");
            return (Criteria) this;
        }

        public Criteria andDraftStatusIsNotNull() {
            addCriterion("draft_status is not null");
            return (Criteria) this;
        }

        public Criteria andDraftStatusEqualTo(Integer value) {
            addCriterion("draft_status =", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusNotEqualTo(Integer value) {
            addCriterion("draft_status <>", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusGreaterThan(Integer value) {
            addCriterion("draft_status >", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("draft_status >=", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusLessThan(Integer value) {
            addCriterion("draft_status <", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusLessThanOrEqualTo(Integer value) {
            addCriterion("draft_status <=", value, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusIn(List<Integer> values) {
            addCriterion("draft_status in", values, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusNotIn(List<Integer> values) {
            addCriterion("draft_status not in", values, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusBetween(Integer value1, Integer value2) {
            addCriterion("draft_status between", value1, value2, "draftStatus");
            return (Criteria) this;
        }

        public Criteria andDraftStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("draft_status not between", value1, value2, "draftStatus");
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
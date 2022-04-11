package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkTaskInfoExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkTaskInfoExtendExample() {
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

        public Criteria andExtendNoIsNull() {
            addCriterion("extend_no is null");
            return (Criteria) this;
        }

        public Criteria andExtendNoIsNotNull() {
            addCriterion("extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtendNoEqualTo(String value) {
            addCriterion("extend_no =", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotEqualTo(String value) {
            addCriterion("extend_no <>", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoGreaterThan(String value) {
            addCriterion("extend_no >", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_no >=", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLessThan(String value) {
            addCriterion("extend_no <", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLessThanOrEqualTo(String value) {
            addCriterion("extend_no <=", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoLike(String value) {
            addCriterion("extend_no like", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotLike(String value) {
            addCriterion("extend_no not like", value, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoIn(List<String> values) {
            addCriterion("extend_no in", values, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotIn(List<String> values) {
            addCriterion("extend_no not in", values, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoBetween(String value1, String value2) {
            addCriterion("extend_no between", value1, value2, "extendNo");
            return (Criteria) this;
        }

        public Criteria andExtendNoNotBetween(String value1, String value2) {
            addCriterion("extend_no not between", value1, value2, "extendNo");
            return (Criteria) this;
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

        public Criteria andStatusCodeIsNull() {
            addCriterion("status_code is null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIsNotNull() {
            addCriterion("status_code is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeEqualTo(String value) {
            addCriterion("status_code =", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotEqualTo(String value) {
            addCriterion("status_code <>", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThan(String value) {
            addCriterion("status_code >", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("status_code >=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThan(String value) {
            addCriterion("status_code <", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLessThanOrEqualTo(String value) {
            addCriterion("status_code <=", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeLike(String value) {
            addCriterion("status_code like", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotLike(String value) {
            addCriterion("status_code not like", value, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeIn(List<String> values) {
            addCriterion("status_code in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotIn(List<String> values) {
            addCriterion("status_code not in", values, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeBetween(String value1, String value2) {
            addCriterion("status_code between", value1, value2, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNotBetween(String value1, String value2) {
            addCriterion("status_code not between", value1, value2, "statusCode");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameIsNull() {
            addCriterion("status_code_name is null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameIsNotNull() {
            addCriterion("status_code_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameEqualTo(String value) {
            addCriterion("status_code_name =", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameNotEqualTo(String value) {
            addCriterion("status_code_name <>", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameGreaterThan(String value) {
            addCriterion("status_code_name >", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("status_code_name >=", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameLessThan(String value) {
            addCriterion("status_code_name <", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameLessThanOrEqualTo(String value) {
            addCriterion("status_code_name <=", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameLike(String value) {
            addCriterion("status_code_name like", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameNotLike(String value) {
            addCriterion("status_code_name not like", value, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameIn(List<String> values) {
            addCriterion("status_code_name in", values, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameNotIn(List<String> values) {
            addCriterion("status_code_name not in", values, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameBetween(String value1, String value2) {
            addCriterion("status_code_name between", value1, value2, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andStatusCodeNameNotBetween(String value1, String value2) {
            addCriterion("status_code_name not between", value1, value2, "statusCodeName");
            return (Criteria) this;
        }

        public Criteria andValidStatusIsNull() {
            addCriterion("valid_status is null");
            return (Criteria) this;
        }

        public Criteria andValidStatusIsNotNull() {
            addCriterion("valid_status is not null");
            return (Criteria) this;
        }

        public Criteria andValidStatusEqualTo(Integer value) {
            addCriterion("valid_status =", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotEqualTo(Integer value) {
            addCriterion("valid_status <>", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThan(Integer value) {
            addCriterion("valid_status >", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid_status >=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThan(Integer value) {
            addCriterion("valid_status <", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThanOrEqualTo(Integer value) {
            addCriterion("valid_status <=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusIn(List<Integer> values) {
            addCriterion("valid_status in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotIn(List<Integer> values) {
            addCriterion("valid_status not in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusBetween(Integer value1, Integer value2) {
            addCriterion("valid_status between", value1, value2, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("valid_status not between", value1, value2, "validStatus");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNull() {
            addCriterion("commit_user is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNotNull() {
            addCriterion("commit_user is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserEqualTo(String value) {
            addCriterion("commit_user =", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotEqualTo(String value) {
            addCriterion("commit_user <>", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThan(String value) {
            addCriterion("commit_user >", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThanOrEqualTo(String value) {
            addCriterion("commit_user >=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThan(String value) {
            addCriterion("commit_user <", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThanOrEqualTo(String value) {
            addCriterion("commit_user <=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLike(String value) {
            addCriterion("commit_user like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotLike(String value) {
            addCriterion("commit_user not like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserIn(List<String> values) {
            addCriterion("commit_user in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotIn(List<String> values) {
            addCriterion("commit_user not in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserBetween(String value1, String value2) {
            addCriterion("commit_user between", value1, value2, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotBetween(String value1, String value2) {
            addCriterion("commit_user not between", value1, value2, "commitUser");
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

        public Criteria andCommitUserCodeIsNull() {
            addCriterion("commit_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeIsNotNull() {
            addCriterion("commit_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeEqualTo(String value) {
            addCriterion("commit_user_code =", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeNotEqualTo(String value) {
            addCriterion("commit_user_code <>", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeGreaterThan(String value) {
            addCriterion("commit_user_code >", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("commit_user_code >=", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeLessThan(String value) {
            addCriterion("commit_user_code <", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeLessThanOrEqualTo(String value) {
            addCriterion("commit_user_code <=", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeLike(String value) {
            addCriterion("commit_user_code like", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeNotLike(String value) {
            addCriterion("commit_user_code not like", value, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeIn(List<String> values) {
            addCriterion("commit_user_code in", values, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeNotIn(List<String> values) {
            addCriterion("commit_user_code not in", values, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeBetween(String value1, String value2) {
            addCriterion("commit_user_code between", value1, value2, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andCommitUserCodeNotBetween(String value1, String value2) {
            addCriterion("commit_user_code not between", value1, value2, "commitUserCode");
            return (Criteria) this;
        }

        public Criteria andStatusIndexIsNull() {
            addCriterion("status_index is null");
            return (Criteria) this;
        }

        public Criteria andStatusIndexIsNotNull() {
            addCriterion("status_index is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIndexEqualTo(Integer value) {
            addCriterion("status_index =", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexNotEqualTo(Integer value) {
            addCriterion("status_index <>", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexGreaterThan(Integer value) {
            addCriterion("status_index >", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_index >=", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexLessThan(Integer value) {
            addCriterion("status_index <", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexLessThanOrEqualTo(Integer value) {
            addCriterion("status_index <=", value, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexIn(List<Integer> values) {
            addCriterion("status_index in", values, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexNotIn(List<Integer> values) {
            addCriterion("status_index not in", values, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexBetween(Integer value1, Integer value2) {
            addCriterion("status_index between", value1, value2, "statusIndex");
            return (Criteria) this;
        }

        public Criteria andStatusIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("status_index not between", value1, value2, "statusIndex");
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
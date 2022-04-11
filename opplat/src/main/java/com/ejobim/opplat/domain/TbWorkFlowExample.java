package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkFlowExample() {
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

        public Criteria andFlowNoIsNull() {
            addCriterion("flow_no is null");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNotNull() {
            addCriterion("flow_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNoEqualTo(String value) {
            addCriterion("flow_no =", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotEqualTo(String value) {
            addCriterion("flow_no <>", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThan(String value) {
            addCriterion("flow_no >", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThanOrEqualTo(String value) {
            addCriterion("flow_no >=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThan(String value) {
            addCriterion("flow_no <", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThanOrEqualTo(String value) {
            addCriterion("flow_no <=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLike(String value) {
            addCriterion("flow_no like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotLike(String value) {
            addCriterion("flow_no not like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoIn(List<String> values) {
            addCriterion("flow_no in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotIn(List<String> values) {
            addCriterion("flow_no not in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoBetween(String value1, String value2) {
            addCriterion("flow_no between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotBetween(String value1, String value2) {
            addCriterion("flow_no not between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoIsNull() {
            addCriterion("work_flow_config_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoIsNotNull() {
            addCriterion("work_flow_config_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoEqualTo(String value) {
            addCriterion("work_flow_config_no =", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoNotEqualTo(String value) {
            addCriterion("work_flow_config_no <>", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoGreaterThan(String value) {
            addCriterion("work_flow_config_no >", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_flow_config_no >=", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoLessThan(String value) {
            addCriterion("work_flow_config_no <", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoLessThanOrEqualTo(String value) {
            addCriterion("work_flow_config_no <=", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoLike(String value) {
            addCriterion("work_flow_config_no like", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoNotLike(String value) {
            addCriterion("work_flow_config_no not like", value, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoIn(List<String> values) {
            addCriterion("work_flow_config_no in", values, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoNotIn(List<String> values) {
            addCriterion("work_flow_config_no not in", values, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoBetween(String value1, String value2) {
            addCriterion("work_flow_config_no between", value1, value2, "workFlowConfigNo");
            return (Criteria) this;
        }

        public Criteria andWorkFlowConfigNoNotBetween(String value1, String value2) {
            addCriterion("work_flow_config_no not between", value1, value2, "workFlowConfigNo");
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

        public Criteria andNextUserIsNull() {
            addCriterion("next_user is null");
            return (Criteria) this;
        }

        public Criteria andNextUserIsNotNull() {
            addCriterion("next_user is not null");
            return (Criteria) this;
        }

        public Criteria andNextUserEqualTo(String value) {
            addCriterion("next_user =", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotEqualTo(String value) {
            addCriterion("next_user <>", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserGreaterThan(String value) {
            addCriterion("next_user >", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserGreaterThanOrEqualTo(String value) {
            addCriterion("next_user >=", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLessThan(String value) {
            addCriterion("next_user <", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLessThanOrEqualTo(String value) {
            addCriterion("next_user <=", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLike(String value) {
            addCriterion("next_user like", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotLike(String value) {
            addCriterion("next_user not like", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserIn(List<String> values) {
            addCriterion("next_user in", values, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotIn(List<String> values) {
            addCriterion("next_user not in", values, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserBetween(String value1, String value2) {
            addCriterion("next_user between", value1, value2, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotBetween(String value1, String value2) {
            addCriterion("next_user not between", value1, value2, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNameIsNull() {
            addCriterion("next_user_name is null");
            return (Criteria) this;
        }

        public Criteria andNextUserNameIsNotNull() {
            addCriterion("next_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andNextUserNameEqualTo(String value) {
            addCriterion("next_user_name =", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameNotEqualTo(String value) {
            addCriterion("next_user_name <>", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameGreaterThan(String value) {
            addCriterion("next_user_name >", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("next_user_name >=", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameLessThan(String value) {
            addCriterion("next_user_name <", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameLessThanOrEqualTo(String value) {
            addCriterion("next_user_name <=", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameLike(String value) {
            addCriterion("next_user_name like", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameNotLike(String value) {
            addCriterion("next_user_name not like", value, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameIn(List<String> values) {
            addCriterion("next_user_name in", values, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameNotIn(List<String> values) {
            addCriterion("next_user_name not in", values, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameBetween(String value1, String value2) {
            addCriterion("next_user_name between", value1, value2, "nextUserName");
            return (Criteria) this;
        }

        public Criteria andNextUserNameNotBetween(String value1, String value2) {
            addCriterion("next_user_name not between", value1, value2, "nextUserName");
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

        public Criteria andNextStatusCodeIsNull() {
            addCriterion("next_status_code is null");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeIsNotNull() {
            addCriterion("next_status_code is not null");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeEqualTo(String value) {
            addCriterion("next_status_code =", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNotEqualTo(String value) {
            addCriterion("next_status_code <>", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeGreaterThan(String value) {
            addCriterion("next_status_code >", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("next_status_code >=", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeLessThan(String value) {
            addCriterion("next_status_code <", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeLessThanOrEqualTo(String value) {
            addCriterion("next_status_code <=", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeLike(String value) {
            addCriterion("next_status_code like", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNotLike(String value) {
            addCriterion("next_status_code not like", value, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeIn(List<String> values) {
            addCriterion("next_status_code in", values, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNotIn(List<String> values) {
            addCriterion("next_status_code not in", values, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeBetween(String value1, String value2) {
            addCriterion("next_status_code between", value1, value2, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNotBetween(String value1, String value2) {
            addCriterion("next_status_code not between", value1, value2, "nextStatusCode");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameIsNull() {
            addCriterion("next_status_code_name is null");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameIsNotNull() {
            addCriterion("next_status_code_name is not null");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameEqualTo(String value) {
            addCriterion("next_status_code_name =", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameNotEqualTo(String value) {
            addCriterion("next_status_code_name <>", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameGreaterThan(String value) {
            addCriterion("next_status_code_name >", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("next_status_code_name >=", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameLessThan(String value) {
            addCriterion("next_status_code_name <", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameLessThanOrEqualTo(String value) {
            addCriterion("next_status_code_name <=", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameLike(String value) {
            addCriterion("next_status_code_name like", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameNotLike(String value) {
            addCriterion("next_status_code_name not like", value, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameIn(List<String> values) {
            addCriterion("next_status_code_name in", values, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameNotIn(List<String> values) {
            addCriterion("next_status_code_name not in", values, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameBetween(String value1, String value2) {
            addCriterion("next_status_code_name between", value1, value2, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextStatusCodeNameNotBetween(String value1, String value2) {
            addCriterion("next_status_code_name not between", value1, value2, "nextStatusCodeName");
            return (Criteria) this;
        }

        public Criteria andNextPlatIsNull() {
            addCriterion("next_plat is null");
            return (Criteria) this;
        }

        public Criteria andNextPlatIsNotNull() {
            addCriterion("next_plat is not null");
            return (Criteria) this;
        }

        public Criteria andNextPlatEqualTo(Integer value) {
            addCriterion("next_plat =", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatNotEqualTo(Integer value) {
            addCriterion("next_plat <>", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatGreaterThan(Integer value) {
            addCriterion("next_plat >", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_plat >=", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatLessThan(Integer value) {
            addCriterion("next_plat <", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatLessThanOrEqualTo(Integer value) {
            addCriterion("next_plat <=", value, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatIn(List<Integer> values) {
            addCriterion("next_plat in", values, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatNotIn(List<Integer> values) {
            addCriterion("next_plat not in", values, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatBetween(Integer value1, Integer value2) {
            addCriterion("next_plat between", value1, value2, "nextPlat");
            return (Criteria) this;
        }

        public Criteria andNextPlatNotBetween(Integer value1, Integer value2) {
            addCriterion("next_plat not between", value1, value2, "nextPlat");
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

        public Criteria andOrgNoIsNull() {
            addCriterion("org_no is null");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNotNull() {
            addCriterion("org_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNoEqualTo(String value) {
            addCriterion("org_no =", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotEqualTo(String value) {
            addCriterion("org_no <>", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThan(String value) {
            addCriterion("org_no >", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("org_no >=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThan(String value) {
            addCriterion("org_no <", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThanOrEqualTo(String value) {
            addCriterion("org_no <=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLike(String value) {
            addCriterion("org_no like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotLike(String value) {
            addCriterion("org_no not like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoIn(List<String> values) {
            addCriterion("org_no in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotIn(List<String> values) {
            addCriterion("org_no not in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoBetween(String value1, String value2) {
            addCriterion("org_no between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotBetween(String value1, String value2) {
            addCriterion("org_no not between", value1, value2, "orgNo");
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

        //
        public Criteria andNextStatusIndexIsNull() {
            addCriterion("next_status_index is null");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexIsNotNull() {
            addCriterion("next_status_index is not null");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexEqualTo(Integer value) {
            addCriterion("next_status_index =", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexNotEqualTo(Integer value) {
            addCriterion("next_status_index <>", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexGreaterThan(Integer value) {
            addCriterion("next_status_index >", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_status_index >=", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexLessThan(Integer value) {
            addCriterion("next_status_index <", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexLessThanOrEqualTo(Integer value) {
            addCriterion("next_status_index <=", value, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexIn(List<Integer> values) {
            addCriterion("next_status_index in", values, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexNotIn(List<Integer> values) {
            addCriterion("next_status_index not in", values, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexBetween(Integer value1, Integer value2) {
            addCriterion("next_status_index between", value1, value2, "nextStatusIndex");
            return (Criteria) this;
        }

        public Criteria andNextStatusIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("next_status_index not between", value1, value2, "nextStatusIndex");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkTaskInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkTaskInfoExample() {
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

        public Criteria andNextRoleIsNull() {
            addCriterion("next_role is null");
            return (Criteria) this;
        }

        public Criteria andNextRoleIsNotNull() {
            addCriterion("next_role is not null");
            return (Criteria) this;
        }

        public Criteria andNextRoleEqualTo(String value) {
            addCriterion("next_role =", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleNotEqualTo(String value) {
            addCriterion("next_role <>", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleGreaterThan(String value) {
            addCriterion("next_role >", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleGreaterThanOrEqualTo(String value) {
            addCriterion("next_role >=", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleLessThan(String value) {
            addCriterion("next_role <", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleLessThanOrEqualTo(String value) {
            addCriterion("next_role <=", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleLike(String value) {
            addCriterion("next_role like", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleNotLike(String value) {
            addCriterion("next_role not like", value, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleIn(List<String> values) {
            addCriterion("next_role in", values, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleNotIn(List<String> values) {
            addCriterion("next_role not in", values, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleBetween(String value1, String value2) {
            addCriterion("next_role between", value1, value2, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleNotBetween(String value1, String value2) {
            addCriterion("next_role not between", value1, value2, "nextRole");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameIsNull() {
            addCriterion("next_role_name is null");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameIsNotNull() {
            addCriterion("next_role_name is not null");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameEqualTo(String value) {
            addCriterion("next_role_name =", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameNotEqualTo(String value) {
            addCriterion("next_role_name <>", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameGreaterThan(String value) {
            addCriterion("next_role_name >", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("next_role_name >=", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameLessThan(String value) {
            addCriterion("next_role_name <", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameLessThanOrEqualTo(String value) {
            addCriterion("next_role_name <=", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameLike(String value) {
            addCriterion("next_role_name like", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameNotLike(String value) {
            addCriterion("next_role_name not like", value, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameIn(List<String> values) {
            addCriterion("next_role_name in", values, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameNotIn(List<String> values) {
            addCriterion("next_role_name not in", values, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameBetween(String value1, String value2) {
            addCriterion("next_role_name between", value1, value2, "nextRoleName");
            return (Criteria) this;
        }

        public Criteria andNextRoleNameNotBetween(String value1, String value2) {
            addCriterion("next_role_name not between", value1, value2, "nextRoleName");
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

        public Criteria andIsEntrustIsNull() {
            addCriterion("is_entrust is null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIsNotNull() {
            addCriterion("is_entrust is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustEqualTo(Integer value) {
            addCriterion("is_entrust =", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotEqualTo(Integer value) {
            addCriterion("is_entrust <>", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThan(Integer value) {
            addCriterion("is_entrust >", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_entrust >=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThan(Integer value) {
            addCriterion("is_entrust <", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThanOrEqualTo(Integer value) {
            addCriterion("is_entrust <=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIn(List<Integer> values) {
            addCriterion("is_entrust in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotIn(List<Integer> values) {
            addCriterion("is_entrust not in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust between", value1, value2, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust not between", value1, value2, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNull() {
            addCriterion("urgency_degree is null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNotNull() {
            addCriterion("urgency_degree is not null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeEqualTo(Integer value) {
            addCriterion("urgency_degree =", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotEqualTo(Integer value) {
            addCriterion("urgency_degree <>", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThan(Integer value) {
            addCriterion("urgency_degree >", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("urgency_degree >=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThan(Integer value) {
            addCriterion("urgency_degree <", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("urgency_degree <=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIn(List<Integer> values) {
            addCriterion("urgency_degree in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotIn(List<Integer> values) {
            addCriterion("urgency_degree not in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeBetween(Integer value1, Integer value2) {
            addCriterion("urgency_degree between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("urgency_degree not between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andIsTempIsNull() {
            addCriterion("is_temp is null");
            return (Criteria) this;
        }

        public Criteria andIsTempIsNotNull() {
            addCriterion("is_temp is not null");
            return (Criteria) this;
        }

        public Criteria andIsTempEqualTo(Integer value) {
            addCriterion("is_temp =", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempNotEqualTo(Integer value) {
            addCriterion("is_temp <>", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempGreaterThan(Integer value) {
            addCriterion("is_temp >", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_temp >=", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempLessThan(Integer value) {
            addCriterion("is_temp <", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempLessThanOrEqualTo(Integer value) {
            addCriterion("is_temp <=", value, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempIn(List<Integer> values) {
            addCriterion("is_temp in", values, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempNotIn(List<Integer> values) {
            addCriterion("is_temp not in", values, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempBetween(Integer value1, Integer value2) {
            addCriterion("is_temp between", value1, value2, "isTemp");
            return (Criteria) this;
        }

        public Criteria andIsTempNotBetween(Integer value1, Integer value2) {
            addCriterion("is_temp not between", value1, value2, "isTemp");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeIsNull() {
            addCriterion("real_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeIsNotNull() {
            addCriterion("real_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeEqualTo(Date value) {
            addCriterion("real_start_time =", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeNotEqualTo(Date value) {
            addCriterion("real_start_time <>", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeGreaterThan(Date value) {
            addCriterion("real_start_time >", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_start_time >=", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeLessThan(Date value) {
            addCriterion("real_start_time <", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_start_time <=", value, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeIn(List<Date> values) {
            addCriterion("real_start_time in", values, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeNotIn(List<Date> values) {
            addCriterion("real_start_time not in", values, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeBetween(Date value1, Date value2) {
            addCriterion("real_start_time between", value1, value2, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andRealStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_start_time not between", value1, value2, "realStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanCodeIsNull() {
            addCriterion("plan_code is null");
            return (Criteria) this;
        }

        public Criteria andPlanCodeIsNotNull() {
            addCriterion("plan_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCodeEqualTo(String value) {
            addCriterion("plan_code =", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeNotEqualTo(String value) {
            addCriterion("plan_code <>", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeGreaterThan(String value) {
            addCriterion("plan_code >", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_code >=", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeLessThan(String value) {
            addCriterion("plan_code <", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeLessThanOrEqualTo(String value) {
            addCriterion("plan_code <=", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeLike(String value) {
            addCriterion("plan_code like", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeNotLike(String value) {
            addCriterion("plan_code not like", value, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeIn(List<String> values) {
            addCriterion("plan_code in", values, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeNotIn(List<String> values) {
            addCriterion("plan_code not in", values, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeBetween(String value1, String value2) {
            addCriterion("plan_code between", value1, value2, "planCode");
            return (Criteria) this;
        }

        public Criteria andPlanCodeNotBetween(String value1, String value2) {
            addCriterion("plan_code not between", value1, value2, "planCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNull() {
            addCriterion("task_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNotNull() {
            addCriterion("task_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeEqualTo(String value) {
            addCriterion("task_code =", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotEqualTo(String value) {
            addCriterion("task_code <>", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThan(String value) {
            addCriterion("task_code >", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_code >=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThan(String value) {
            addCriterion("task_code <", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThanOrEqualTo(String value) {
            addCriterion("task_code <=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLike(String value) {
            addCriterion("task_code like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotLike(String value) {
            addCriterion("task_code not like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIn(List<String> values) {
            addCriterion("task_code in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotIn(List<String> values) {
            addCriterion("task_code not in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeBetween(String value1, String value2) {
            addCriterion("task_code between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotBetween(String value1, String value2) {
            addCriterion("task_code not between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskFromIsNull() {
            addCriterion("task_from is null");
            return (Criteria) this;
        }

        public Criteria andTaskFromIsNotNull() {
            addCriterion("task_from is not null");
            return (Criteria) this;
        }

        public Criteria andTaskFromEqualTo(String value) {
            addCriterion("task_from =", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromNotEqualTo(String value) {
            addCriterion("task_from <>", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromGreaterThan(String value) {
            addCriterion("task_from >", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromGreaterThanOrEqualTo(String value) {
            addCriterion("task_from >=", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromLessThan(String value) {
            addCriterion("task_from <", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromLessThanOrEqualTo(String value) {
            addCriterion("task_from <=", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromLike(String value) {
            addCriterion("task_from like", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromNotLike(String value) {
            addCriterion("task_from not like", value, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromIn(List<String> values) {
            addCriterion("task_from in", values, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromNotIn(List<String> values) {
            addCriterion("task_from not in", values, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromBetween(String value1, String value2) {
            addCriterion("task_from between", value1, value2, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andTaskFromNotBetween(String value1, String value2) {
            addCriterion("task_from not between", value1, value2, "taskFrom");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNull() {
            addCriterion("plan_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNotNull() {
            addCriterion("plan_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeEqualTo(Date value) {
            addCriterion("plan_finish_time =", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotEqualTo(Date value) {
            addCriterion("plan_finish_time <>", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThan(Date value) {
            addCriterion("plan_finish_time >", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_finish_time >=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThan(Date value) {
            addCriterion("plan_finish_time <", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_finish_time <=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIn(List<Date> values) {
            addCriterion("plan_finish_time in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotIn(List<Date> values) {
            addCriterion("plan_finish_time not in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeBetween(Date value1, Date value2) {
            addCriterion("plan_finish_time between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_finish_time not between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeIsNull() {
            addCriterion("plan_use_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeIsNotNull() {
            addCriterion("plan_use_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeEqualTo(Double value) {
            addCriterion("plan_use_time =", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeNotEqualTo(Double value) {
            addCriterion("plan_use_time <>", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeGreaterThan(Double value) {
            addCriterion("plan_use_time >", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_use_time >=", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeLessThan(Double value) {
            addCriterion("plan_use_time <", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeLessThanOrEqualTo(Double value) {
            addCriterion("plan_use_time <=", value, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeIn(List<Double> values) {
            addCriterion("plan_use_time in", values, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeNotIn(List<Double> values) {
            addCriterion("plan_use_time not in", values, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeBetween(Double value1, Double value2) {
            addCriterion("plan_use_time between", value1, value2, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andPlanUseTimeNotBetween(Double value1, Double value2) {
            addCriterion("plan_use_time not between", value1, value2, "planUseTime");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNull() {
            addCriterion("a.equip_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNotNull() {
            addCriterion("a.equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNoEqualTo(String value) {
            addCriterion("a.equip_no =", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotEqualTo(String value) {
            addCriterion("a.equip_no <>", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThan(String value) {
            addCriterion("a.equip_no >", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("a.equip_no >=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThan(String value) {
            addCriterion("a.equip_no <", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThanOrEqualTo(String value) {
            addCriterion("a.equip_no <=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLike(String value) {
            addCriterion("a.equip_no like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotLike(String value) {
            addCriterion("a.equip_no not like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIn(List<String> values) {
            addCriterion("a.equip_no in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotIn(List<String> values) {
            addCriterion("a.equip_no not in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoBetween(String value1, String value2) {
            addCriterion("a.equip_no between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotBetween(String value1, String value2) {
            addCriterion("a.equip_no not between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNull() {
            addCriterion("duty_user is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNotNull() {
            addCriterion("duty_user is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserEqualTo(String value) {
            addCriterion("duty_user =", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotEqualTo(String value) {
            addCriterion("duty_user <>", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThan(String value) {
            addCriterion("duty_user >", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user >=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThan(String value) {
            addCriterion("duty_user <", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThanOrEqualTo(String value) {
            addCriterion("duty_user <=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLike(String value) {
            addCriterion("duty_user like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotLike(String value) {
            addCriterion("duty_user not like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserIn(List<String> values) {
            addCriterion("duty_user in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotIn(List<String> values) {
            addCriterion("duty_user not in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserBetween(String value1, String value2) {
            addCriterion("duty_user between", value1, value2, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotBetween(String value1, String value2) {
            addCriterion("duty_user not between", value1, value2, "dutyUser");
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

        public Criteria andSendUserIsNull() {
            addCriterion("send_user is null");
            return (Criteria) this;
        }

        public Criteria andSendUserIsNotNull() {
            addCriterion("send_user is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserEqualTo(String value) {
            addCriterion("send_user =", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotEqualTo(String value) {
            addCriterion("send_user <>", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThan(String value) {
            addCriterion("send_user >", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThanOrEqualTo(String value) {
            addCriterion("send_user >=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThan(String value) {
            addCriterion("send_user <", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThanOrEqualTo(String value) {
            addCriterion("send_user <=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLike(String value) {
            addCriterion("send_user like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotLike(String value) {
            addCriterion("send_user not like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserIn(List<String> values) {
            addCriterion("send_user in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotIn(List<String> values) {
            addCriterion("send_user not in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserBetween(String value1, String value2) {
            addCriterion("send_user between", value1, value2, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotBetween(String value1, String value2) {
            addCriterion("send_user not between", value1, value2, "sendUser");
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

        public Criteria andIsRepeatIsNull() {
            addCriterion("is_repeat is null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIsNotNull() {
            addCriterion("is_repeat is not null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatEqualTo(Integer value) {
            addCriterion("is_repeat =", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotEqualTo(Integer value) {
            addCriterion("is_repeat <>", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThan(Integer value) {
            addCriterion("is_repeat >", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_repeat >=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThan(Integer value) {
            addCriterion("is_repeat <", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThanOrEqualTo(Integer value) {
            addCriterion("is_repeat <=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIn(List<Integer> values) {
            addCriterion("is_repeat in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotIn(List<Integer> values) {
            addCriterion("is_repeat not in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat between", value1, value2, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat not between", value1, value2, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeIsNull() {
            addCriterion("real_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeIsNotNull() {
            addCriterion("real_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeEqualTo(Date value) {
            addCriterion("real_finish_time =", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeNotEqualTo(Date value) {
            addCriterion("real_finish_time <>", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeGreaterThan(Date value) {
            addCriterion("real_finish_time >", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_finish_time >=", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeLessThan(Date value) {
            addCriterion("real_finish_time <", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_finish_time <=", value, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeIn(List<Date> values) {
            addCriterion("real_finish_time in", values, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeNotIn(List<Date> values) {
            addCriterion("real_finish_time not in", values, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeBetween(Date value1, Date value2) {
            addCriterion("real_finish_time between", value1, value2, "realFinishTime");
            return (Criteria) this;
        }

        public Criteria andRealFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_finish_time not between", value1, value2, "realFinishTime");
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
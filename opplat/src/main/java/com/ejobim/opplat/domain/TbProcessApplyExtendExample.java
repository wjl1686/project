package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProcessApplyExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProcessApplyExtendExample() {
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

        public Criteria andProcessApplyNoIsNull() {
            addCriterion("process_apply_no is null");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoIsNotNull() {
            addCriterion("process_apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoEqualTo(String value) {
            addCriterion("process_apply_no =", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoNotEqualTo(String value) {
            addCriterion("process_apply_no <>", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoGreaterThan(String value) {
            addCriterion("process_apply_no >", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("process_apply_no >=", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoLessThan(String value) {
            addCriterion("process_apply_no <", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoLessThanOrEqualTo(String value) {
            addCriterion("process_apply_no <=", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoLike(String value) {
            addCriterion("process_apply_no like", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoNotLike(String value) {
            addCriterion("process_apply_no not like", value, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoIn(List<String> values) {
            addCriterion("process_apply_no in", values, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoNotIn(List<String> values) {
            addCriterion("process_apply_no not in", values, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoBetween(String value1, String value2) {
            addCriterion("process_apply_no between", value1, value2, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessApplyNoNotBetween(String value1, String value2) {
            addCriterion("process_apply_no not between", value1, value2, "processApplyNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoIsNull() {
            addCriterion("process_no is null");
            return (Criteria) this;
        }

        public Criteria andProcessNoIsNotNull() {
            addCriterion("process_no is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNoEqualTo(String value) {
            addCriterion("process_no =", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotEqualTo(String value) {
            addCriterion("process_no <>", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThan(String value) {
            addCriterion("process_no >", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThanOrEqualTo(String value) {
            addCriterion("process_no >=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThan(String value) {
            addCriterion("process_no <", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThanOrEqualTo(String value) {
            addCriterion("process_no <=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLike(String value) {
            addCriterion("process_no like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotLike(String value) {
            addCriterion("process_no not like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoIn(List<String> values) {
            addCriterion("process_no in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotIn(List<String> values) {
            addCriterion("process_no not in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoBetween(String value1, String value2) {
            addCriterion("process_no between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotBetween(String value1, String value2) {
            addCriterion("process_no not between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andStepUserNameIsNull() {
            addCriterion("step_user_name is null");
            return (Criteria) this;
        }

        public Criteria andStepUserNameIsNotNull() {
            addCriterion("step_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepUserNameEqualTo(String value) {
            addCriterion("step_user_name =", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameNotEqualTo(String value) {
            addCriterion("step_user_name <>", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameGreaterThan(String value) {
            addCriterion("step_user_name >", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_user_name >=", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameLessThan(String value) {
            addCriterion("step_user_name <", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameLessThanOrEqualTo(String value) {
            addCriterion("step_user_name <=", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameLike(String value) {
            addCriterion("step_user_name like", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameNotLike(String value) {
            addCriterion("step_user_name not like", value, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameIn(List<String> values) {
            addCriterion("step_user_name in", values, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameNotIn(List<String> values) {
            addCriterion("step_user_name not in", values, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameBetween(String value1, String value2) {
            addCriterion("step_user_name between", value1, value2, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserNameNotBetween(String value1, String value2) {
            addCriterion("step_user_name not between", value1, value2, "stepUserName");
            return (Criteria) this;
        }

        public Criteria andStepUserIsNull() {
            addCriterion("step_user is null");
            return (Criteria) this;
        }

        public Criteria andStepUserIsNotNull() {
            addCriterion("step_user is not null");
            return (Criteria) this;
        }

        public Criteria andStepUserEqualTo(String value) {
            addCriterion("step_user =", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserNotEqualTo(String value) {
            addCriterion("step_user <>", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserGreaterThan(String value) {
            addCriterion("step_user >", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserGreaterThanOrEqualTo(String value) {
            addCriterion("step_user >=", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserLessThan(String value) {
            addCriterion("step_user <", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserLessThanOrEqualTo(String value) {
            addCriterion("step_user <=", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserLike(String value) {
            addCriterion("step_user like", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserNotLike(String value) {
            addCriterion("step_user not like", value, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserIn(List<String> values) {
            addCriterion("step_user in", values, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserNotIn(List<String> values) {
            addCriterion("step_user not in", values, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserBetween(String value1, String value2) {
            addCriterion("step_user between", value1, value2, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepUserNotBetween(String value1, String value2) {
            addCriterion("step_user not between", value1, value2, "stepUser");
            return (Criteria) this;
        }

        public Criteria andStepTimeIsNull() {
            addCriterion("step_time is null");
            return (Criteria) this;
        }

        public Criteria andStepTimeIsNotNull() {
            addCriterion("step_time is not null");
            return (Criteria) this;
        }

        public Criteria andStepTimeEqualTo(Date value) {
            addCriterion("step_time =", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotEqualTo(Date value) {
            addCriterion("step_time <>", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeGreaterThan(Date value) {
            addCriterion("step_time >", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("step_time >=", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeLessThan(Date value) {
            addCriterion("step_time <", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeLessThanOrEqualTo(Date value) {
            addCriterion("step_time <=", value, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeIn(List<Date> values) {
            addCriterion("step_time in", values, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotIn(List<Date> values) {
            addCriterion("step_time not in", values, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeBetween(Date value1, Date value2) {
            addCriterion("step_time between", value1, value2, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepTimeNotBetween(Date value1, Date value2) {
            addCriterion("step_time not between", value1, value2, "stepTime");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIdeaIsNull() {
            addCriterion("idea is null");
            return (Criteria) this;
        }

        public Criteria andIdeaIsNotNull() {
            addCriterion("idea is not null");
            return (Criteria) this;
        }

        public Criteria andIdeaEqualTo(String value) {
            addCriterion("idea =", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotEqualTo(String value) {
            addCriterion("idea <>", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaGreaterThan(String value) {
            addCriterion("idea >", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaGreaterThanOrEqualTo(String value) {
            addCriterion("idea >=", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLessThan(String value) {
            addCriterion("idea <", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLessThanOrEqualTo(String value) {
            addCriterion("idea <=", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaLike(String value) {
            addCriterion("idea like", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotLike(String value) {
            addCriterion("idea not like", value, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaIn(List<String> values) {
            addCriterion("idea in", values, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotIn(List<String> values) {
            addCriterion("idea not in", values, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaBetween(String value1, String value2) {
            addCriterion("idea between", value1, value2, "idea");
            return (Criteria) this;
        }

        public Criteria andIdeaNotBetween(String value1, String value2) {
            addCriterion("idea not between", value1, value2, "idea");
            return (Criteria) this;
        }

        public Criteria andVaildStatusIsNull() {
            addCriterion("vaild_status is null");
            return (Criteria) this;
        }

        public Criteria andVaildStatusIsNotNull() {
            addCriterion("vaild_status is not null");
            return (Criteria) this;
        }

        public Criteria andVaildStatusEqualTo(Integer value) {
            addCriterion("vaild_status =", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusNotEqualTo(Integer value) {
            addCriterion("vaild_status <>", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusGreaterThan(Integer value) {
            addCriterion("vaild_status >", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("vaild_status >=", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusLessThan(Integer value) {
            addCriterion("vaild_status <", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusLessThanOrEqualTo(Integer value) {
            addCriterion("vaild_status <=", value, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusIn(List<Integer> values) {
            addCriterion("vaild_status in", values, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusNotIn(List<Integer> values) {
            addCriterion("vaild_status not in", values, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusBetween(Integer value1, Integer value2) {
            addCriterion("vaild_status between", value1, value2, "vaildStatus");
            return (Criteria) this;
        }

        public Criteria andVaildStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("vaild_status not between", value1, value2, "vaildStatus");
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
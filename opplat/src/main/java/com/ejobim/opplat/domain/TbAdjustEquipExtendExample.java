package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAdjustEquipExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAdjustEquipExtendExample() {
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

        public Criteria andAdDetailNoIsNull() {
            addCriterion("ad_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoIsNotNull() {
            addCriterion("ad_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoEqualTo(String value) {
            addCriterion("ad_detail_no =", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoNotEqualTo(String value) {
            addCriterion("ad_detail_no <>", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoGreaterThan(String value) {
            addCriterion("ad_detail_no >", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("ad_detail_no >=", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoLessThan(String value) {
            addCriterion("ad_detail_no <", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoLessThanOrEqualTo(String value) {
            addCriterion("ad_detail_no <=", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoLike(String value) {
            addCriterion("ad_detail_no like", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoNotLike(String value) {
            addCriterion("ad_detail_no not like", value, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoIn(List<String> values) {
            addCriterion("ad_detail_no in", values, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoNotIn(List<String> values) {
            addCriterion("ad_detail_no not in", values, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoBetween(String value1, String value2) {
            addCriterion("ad_detail_no between", value1, value2, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdDetailNoNotBetween(String value1, String value2) {
            addCriterion("ad_detail_no not between", value1, value2, "adDetailNo");
            return (Criteria) this;
        }

        public Criteria andAdNoIsNull() {
            addCriterion("ad_no is null");
            return (Criteria) this;
        }

        public Criteria andAdNoIsNotNull() {
            addCriterion("ad_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdNoEqualTo(String value) {
            addCriterion("ad_no =", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotEqualTo(String value) {
            addCriterion("ad_no <>", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoGreaterThan(String value) {
            addCriterion("ad_no >", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoGreaterThanOrEqualTo(String value) {
            addCriterion("ad_no >=", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLessThan(String value) {
            addCriterion("ad_no <", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLessThanOrEqualTo(String value) {
            addCriterion("ad_no <=", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLike(String value) {
            addCriterion("ad_no like", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotLike(String value) {
            addCriterion("ad_no not like", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoIn(List<String> values) {
            addCriterion("ad_no in", values, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotIn(List<String> values) {
            addCriterion("ad_no not in", values, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoBetween(String value1, String value2) {
            addCriterion("ad_no between", value1, value2, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotBetween(String value1, String value2) {
            addCriterion("ad_no not between", value1, value2, "adNo");
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

        public Criteria andStepIdeaIsNull() {
            addCriterion("step_idea is null");
            return (Criteria) this;
        }

        public Criteria andStepIdeaIsNotNull() {
            addCriterion("step_idea is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdeaEqualTo(String value) {
            addCriterion("step_idea =", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaNotEqualTo(String value) {
            addCriterion("step_idea <>", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaGreaterThan(String value) {
            addCriterion("step_idea >", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaGreaterThanOrEqualTo(String value) {
            addCriterion("step_idea >=", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaLessThan(String value) {
            addCriterion("step_idea <", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaLessThanOrEqualTo(String value) {
            addCriterion("step_idea <=", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaLike(String value) {
            addCriterion("step_idea like", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaNotLike(String value) {
            addCriterion("step_idea not like", value, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaIn(List<String> values) {
            addCriterion("step_idea in", values, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaNotIn(List<String> values) {
            addCriterion("step_idea not in", values, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaBetween(String value1, String value2) {
            addCriterion("step_idea between", value1, value2, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepIdeaNotBetween(String value1, String value2) {
            addCriterion("step_idea not between", value1, value2, "stepIdea");
            return (Criteria) this;
        }

        public Criteria andStepRemarkIsNull() {
            addCriterion("step_remark is null");
            return (Criteria) this;
        }

        public Criteria andStepRemarkIsNotNull() {
            addCriterion("step_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStepRemarkEqualTo(String value) {
            addCriterion("step_remark =", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkNotEqualTo(String value) {
            addCriterion("step_remark <>", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkGreaterThan(String value) {
            addCriterion("step_remark >", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("step_remark >=", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkLessThan(String value) {
            addCriterion("step_remark <", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkLessThanOrEqualTo(String value) {
            addCriterion("step_remark <=", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkLike(String value) {
            addCriterion("step_remark like", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkNotLike(String value) {
            addCriterion("step_remark not like", value, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkIn(List<String> values) {
            addCriterion("step_remark in", values, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkNotIn(List<String> values) {
            addCriterion("step_remark not in", values, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkBetween(String value1, String value2) {
            addCriterion("step_remark between", value1, value2, "stepRemark");
            return (Criteria) this;
        }

        public Criteria andStepRemarkNotBetween(String value1, String value2) {
            addCriterion("step_remark not between", value1, value2, "stepRemark");
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

        public Criteria andStepIndexIsNull() {
            addCriterion("step_index is null");
            return (Criteria) this;
        }

        public Criteria andStepIndexIsNotNull() {
            addCriterion("step_index is not null");
            return (Criteria) this;
        }

        public Criteria andStepIndexEqualTo(Integer value) {
            addCriterion("step_index =", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotEqualTo(Integer value) {
            addCriterion("step_index <>", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexGreaterThan(Integer value) {
            addCriterion("step_index >", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_index >=", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexLessThan(Integer value) {
            addCriterion("step_index <", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexLessThanOrEqualTo(Integer value) {
            addCriterion("step_index <=", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexIn(List<Integer> values) {
            addCriterion("step_index in", values, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotIn(List<Integer> values) {
            addCriterion("step_index not in", values, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexBetween(Integer value1, Integer value2) {
            addCriterion("step_index between", value1, value2, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("step_index not between", value1, value2, "stepIndex");
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
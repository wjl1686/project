package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbEquipAdjustExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipAdjustExtendExample() {
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
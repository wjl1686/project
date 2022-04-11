package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xibian
 */
public class TbGongyiAdjustExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGongyiAdjustExtendExample() {
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

        public Criteria andAdExtendNoIsNull() {
            addCriterion("ad_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoIsNotNull() {
            addCriterion("ad_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoEqualTo(String value) {
            addCriterion("ad_extend_no =", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoNotEqualTo(String value) {
            addCriterion("ad_extend_no <>", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoGreaterThan(String value) {
            addCriterion("ad_extend_no >", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("ad_extend_no >=", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoLessThan(String value) {
            addCriterion("ad_extend_no <", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoLessThanOrEqualTo(String value) {
            addCriterion("ad_extend_no <=", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoLike(String value) {
            addCriterion("ad_extend_no like", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoNotLike(String value) {
            addCriterion("ad_extend_no not like", value, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoIn(List<String> values) {
            addCriterion("ad_extend_no in", values, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoNotIn(List<String> values) {
            addCriterion("ad_extend_no not in", values, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoBetween(String value1, String value2) {
            addCriterion("ad_extend_no between", value1, value2, "adExtendNo");
            return (Criteria) this;
        }

        public Criteria andAdExtendNoNotBetween(String value1, String value2) {
            addCriterion("ad_extend_no not between", value1, value2, "adExtendNo");
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

        public Criteria andAdjustContentIsNull() {
            addCriterion("adjust_content is null");
            return (Criteria) this;
        }

        public Criteria andAdjustContentIsNotNull() {
            addCriterion("adjust_content is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustContentEqualTo(String value) {
            addCriterion("adjust_content =", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentNotEqualTo(String value) {
            addCriterion("adjust_content <>", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentGreaterThan(String value) {
            addCriterion("adjust_content >", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentGreaterThanOrEqualTo(String value) {
            addCriterion("adjust_content >=", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentLessThan(String value) {
            addCriterion("adjust_content <", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentLessThanOrEqualTo(String value) {
            addCriterion("adjust_content <=", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentLike(String value) {
            addCriterion("adjust_content like", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentNotLike(String value) {
            addCriterion("adjust_content not like", value, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentIn(List<String> values) {
            addCriterion("adjust_content in", values, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentNotIn(List<String> values) {
            addCriterion("adjust_content not in", values, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentBetween(String value1, String value2) {
            addCriterion("adjust_content between", value1, value2, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustContentNotBetween(String value1, String value2) {
            addCriterion("adjust_content not between", value1, value2, "adjustContent");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonIsNull() {
            addCriterion("adjust_addon is null");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonIsNotNull() {
            addCriterion("adjust_addon is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonEqualTo(String value) {
            addCriterion("adjust_addon =", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonNotEqualTo(String value) {
            addCriterion("adjust_addon <>", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonGreaterThan(String value) {
            addCriterion("adjust_addon >", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonGreaterThanOrEqualTo(String value) {
            addCriterion("adjust_addon >=", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonLessThan(String value) {
            addCriterion("adjust_addon <", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonLessThanOrEqualTo(String value) {
            addCriterion("adjust_addon <=", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonLike(String value) {
            addCriterion("adjust_addon like", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonNotLike(String value) {
            addCriterion("adjust_addon not like", value, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonIn(List<String> values) {
            addCriterion("adjust_addon in", values, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonNotIn(List<String> values) {
            addCriterion("adjust_addon not in", values, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonBetween(String value1, String value2) {
            addCriterion("adjust_addon between", value1, value2, "adjustAddon");
            return (Criteria) this;
        }

        public Criteria andAdjustAddonNotBetween(String value1, String value2) {
            addCriterion("adjust_addon not between", value1, value2, "adjustAddon");
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
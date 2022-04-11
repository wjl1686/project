package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xibian
 */
public class TbGongyiAdjustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGongyiAdjustExample() {
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

        public Criteria andAdjustNoIsNull() {
            addCriterion("adjust_no is null");
            return (Criteria) this;
        }

        public Criteria andAdjustNoIsNotNull() {
            addCriterion("adjust_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustNoEqualTo(String value) {
            addCriterion("adjust_no =", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoNotEqualTo(String value) {
            addCriterion("adjust_no <>", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoGreaterThan(String value) {
            addCriterion("adjust_no >", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoGreaterThanOrEqualTo(String value) {
            addCriterion("adjust_no >=", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoLessThan(String value) {
            addCriterion("adjust_no <", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoLessThanOrEqualTo(String value) {
            addCriterion("adjust_no <=", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoLike(String value) {
            addCriterion("adjust_no like", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoNotLike(String value) {
            addCriterion("adjust_no not like", value, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoIn(List<String> values) {
            addCriterion("adjust_no in", values, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoNotIn(List<String> values) {
            addCriterion("adjust_no not in", values, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoBetween(String value1, String value2) {
            addCriterion("adjust_no between", value1, value2, "adjustNo");
            return (Criteria) this;
        }

        public Criteria andAdjustNoNotBetween(String value1, String value2) {
            addCriterion("adjust_no not between", value1, value2, "adjustNo");
            return (Criteria) this;
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

        public Criteria andAdjustNameIsNull() {
            addCriterion("adjust_name is null");
            return (Criteria) this;
        }

        public Criteria andAdjustNameIsNotNull() {
            addCriterion("adjust_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustNameEqualTo(String value) {
            addCriterion("adjust_name =", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameNotEqualTo(String value) {
            addCriterion("adjust_name <>", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameGreaterThan(String value) {
            addCriterion("adjust_name >", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameGreaterThanOrEqualTo(String value) {
            addCriterion("adjust_name >=", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameLessThan(String value) {
            addCriterion("adjust_name <", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameLessThanOrEqualTo(String value) {
            addCriterion("adjust_name <=", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameLike(String value) {
            addCriterion("adjust_name like", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameNotLike(String value) {
            addCriterion("adjust_name not like", value, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameIn(List<String> values) {
            addCriterion("adjust_name in", values, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameNotIn(List<String> values) {
            addCriterion("adjust_name not in", values, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameBetween(String value1, String value2) {
            addCriterion("adjust_name between", value1, value2, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustNameNotBetween(String value1, String value2) {
            addCriterion("adjust_name not between", value1, value2, "adjustName");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeIsNull() {
            addCriterion("adjust_type is null");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeIsNotNull() {
            addCriterion("adjust_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeEqualTo(Integer value) {
            addCriterion("adjust_type =", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeNotEqualTo(Integer value) {
            addCriterion("adjust_type <>", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeGreaterThan(Integer value) {
            addCriterion("adjust_type >", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adjust_type >=", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeLessThan(Integer value) {
            addCriterion("adjust_type <", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeLessThanOrEqualTo(Integer value) {
            addCriterion("adjust_type <=", value, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeIn(List<Integer> values) {
            addCriterion("adjust_type in", values, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeNotIn(List<Integer> values) {
            addCriterion("adjust_type not in", values, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeBetween(Integer value1, Integer value2) {
            addCriterion("adjust_type between", value1, value2, "adjustType");
            return (Criteria) this;
        }

        public Criteria andAdjustTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("adjust_type not between", value1, value2, "adjustType");
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
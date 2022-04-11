package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipMaintainPlanExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipMaintainPlanExtendExample() {
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

        public Criteria andDetailNoIsNull() {
            addCriterion("detail_no is null");
            return (Criteria) this;
        }

        public Criteria andDetailNoIsNotNull() {
            addCriterion("detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNoEqualTo(String value) {
            addCriterion("detail_no =", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotEqualTo(String value) {
            addCriterion("detail_no <>", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThan(String value) {
            addCriterion("detail_no >", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_no >=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThan(String value) {
            addCriterion("detail_no <", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThanOrEqualTo(String value) {
            addCriterion("detail_no <=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLike(String value) {
            addCriterion("detail_no like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotLike(String value) {
            addCriterion("detail_no not like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoIn(List<String> values) {
            addCriterion("detail_no in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotIn(List<String> values) {
            addCriterion("detail_no not in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoBetween(String value1, String value2) {
            addCriterion("detail_no between", value1, value2, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotBetween(String value1, String value2) {
            addCriterion("detail_no not between", value1, value2, "detailNo");
            return (Criteria) this;
        }

        public Criteria andExtendContentIsNull() {
            addCriterion("extend_content is null");
            return (Criteria) this;
        }

        public Criteria andExtendContentIsNotNull() {
            addCriterion("extend_content is not null");
            return (Criteria) this;
        }

        public Criteria andExtendContentEqualTo(String value) {
            addCriterion("extend_content =", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentNotEqualTo(String value) {
            addCriterion("extend_content <>", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentGreaterThan(String value) {
            addCriterion("extend_content >", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentGreaterThanOrEqualTo(String value) {
            addCriterion("extend_content >=", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentLessThan(String value) {
            addCriterion("extend_content <", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentLessThanOrEqualTo(String value) {
            addCriterion("extend_content <=", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentLike(String value) {
            addCriterion("extend_content like", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentNotLike(String value) {
            addCriterion("extend_content not like", value, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentIn(List<String> values) {
            addCriterion("extend_content in", values, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentNotIn(List<String> values) {
            addCriterion("extend_content not in", values, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentBetween(String value1, String value2) {
            addCriterion("extend_content between", value1, value2, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendContentNotBetween(String value1, String value2) {
            addCriterion("extend_content not between", value1, value2, "extendContent");
            return (Criteria) this;
        }

        public Criteria andExtendAddonIsNull() {
            addCriterion("extend_addon is null");
            return (Criteria) this;
        }

        public Criteria andExtendAddonIsNotNull() {
            addCriterion("extend_addon is not null");
            return (Criteria) this;
        }

        public Criteria andExtendAddonEqualTo(String value) {
            addCriterion("extend_addon =", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonNotEqualTo(String value) {
            addCriterion("extend_addon <>", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonGreaterThan(String value) {
            addCriterion("extend_addon >", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonGreaterThanOrEqualTo(String value) {
            addCriterion("extend_addon >=", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonLessThan(String value) {
            addCriterion("extend_addon <", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonLessThanOrEqualTo(String value) {
            addCriterion("extend_addon <=", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonLike(String value) {
            addCriterion("extend_addon like", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonNotLike(String value) {
            addCriterion("extend_addon not like", value, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonIn(List<String> values) {
            addCriterion("extend_addon in", values, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonNotIn(List<String> values) {
            addCriterion("extend_addon not in", values, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonBetween(String value1, String value2) {
            addCriterion("extend_addon between", value1, value2, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendAddonNotBetween(String value1, String value2) {
            addCriterion("extend_addon not between", value1, value2, "extendAddon");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIsNull() {
            addCriterion("extend_detail is null");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIsNotNull() {
            addCriterion("extend_detail is not null");
            return (Criteria) this;
        }

        public Criteria andExtendDetailEqualTo(String value) {
            addCriterion("extend_detail =", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotEqualTo(String value) {
            addCriterion("extend_detail <>", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailGreaterThan(String value) {
            addCriterion("extend_detail >", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailGreaterThanOrEqualTo(String value) {
            addCriterion("extend_detail >=", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLessThan(String value) {
            addCriterion("extend_detail <", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLessThanOrEqualTo(String value) {
            addCriterion("extend_detail <=", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLike(String value) {
            addCriterion("extend_detail like", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotLike(String value) {
            addCriterion("extend_detail not like", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIn(List<String> values) {
            addCriterion("extend_detail in", values, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotIn(List<String> values) {
            addCriterion("extend_detail not in", values, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailBetween(String value1, String value2) {
            addCriterion("extend_detail between", value1, value2, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotBetween(String value1, String value2) {
            addCriterion("extend_detail not between", value1, value2, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeIsNull() {
            addCriterion("extend_update_time is null");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeIsNotNull() {
            addCriterion("extend_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeEqualTo(Date value) {
            addCriterion("extend_update_time =", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeNotEqualTo(Date value) {
            addCriterion("extend_update_time <>", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeGreaterThan(Date value) {
            addCriterion("extend_update_time >", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("extend_update_time >=", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeLessThan(Date value) {
            addCriterion("extend_update_time <", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("extend_update_time <=", value, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeIn(List<Date> values) {
            addCriterion("extend_update_time in", values, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeNotIn(List<Date> values) {
            addCriterion("extend_update_time not in", values, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("extend_update_time between", value1, value2, "extendUpdateTime");
            return (Criteria) this;
        }

        public Criteria andExtendUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("extend_update_time not between", value1, value2, "extendUpdateTime");
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
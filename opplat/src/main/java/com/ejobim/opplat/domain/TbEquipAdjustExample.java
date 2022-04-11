package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbEquipAdjustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipAdjustExample() {
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

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdContentIsNull() {
            addCriterion("ad_content is null");
            return (Criteria) this;
        }

        public Criteria andAdContentIsNotNull() {
            addCriterion("ad_content is not null");
            return (Criteria) this;
        }

        public Criteria andAdContentEqualTo(String value) {
            addCriterion("ad_content =", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentNotEqualTo(String value) {
            addCriterion("ad_content <>", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentGreaterThan(String value) {
            addCriterion("ad_content >", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentGreaterThanOrEqualTo(String value) {
            addCriterion("ad_content >=", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentLessThan(String value) {
            addCriterion("ad_content <", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentLessThanOrEqualTo(String value) {
            addCriterion("ad_content <=", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentLike(String value) {
            addCriterion("ad_content like", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentNotLike(String value) {
            addCriterion("ad_content not like", value, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentIn(List<String> values) {
            addCriterion("ad_content in", values, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentNotIn(List<String> values) {
            addCriterion("ad_content not in", values, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentBetween(String value1, String value2) {
            addCriterion("ad_content between", value1, value2, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdContentNotBetween(String value1, String value2) {
            addCriterion("ad_content not between", value1, value2, "adContent");
            return (Criteria) this;
        }

        public Criteria andAdEquipListIsNull() {
            addCriterion("ad_equip_list is null");
            return (Criteria) this;
        }

        public Criteria andAdEquipListIsNotNull() {
            addCriterion("ad_equip_list is not null");
            return (Criteria) this;
        }

        public Criteria andAdEquipListEqualTo(String value) {
            addCriterion("ad_equip_list =", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListNotEqualTo(String value) {
            addCriterion("ad_equip_list <>", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListGreaterThan(String value) {
            addCriterion("ad_equip_list >", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListGreaterThanOrEqualTo(String value) {
            addCriterion("ad_equip_list >=", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListLessThan(String value) {
            addCriterion("ad_equip_list <", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListLessThanOrEqualTo(String value) {
            addCriterion("ad_equip_list <=", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListLike(String value) {
            addCriterion("ad_equip_list like", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListNotLike(String value) {
            addCriterion("ad_equip_list not like", value, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListIn(List<String> values) {
            addCriterion("ad_equip_list in", values, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListNotIn(List<String> values) {
            addCriterion("ad_equip_list not in", values, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListBetween(String value1, String value2) {
            addCriterion("ad_equip_list between", value1, value2, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipListNotBetween(String value1, String value2) {
            addCriterion("ad_equip_list not between", value1, value2, "adEquipList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListIsNull() {
            addCriterion("ad_equipName_list is null");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListIsNotNull() {
            addCriterion("ad_equipName_list is not null");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListEqualTo(String value) {
            addCriterion("ad_equipName_list =", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListNotEqualTo(String value) {
            addCriterion("ad_equipName_list <>", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListGreaterThan(String value) {
            addCriterion("ad_equipName_list >", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListGreaterThanOrEqualTo(String value) {
            addCriterion("ad_equipName_list >=", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListLessThan(String value) {
            addCriterion("ad_equipName_list <", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListLessThanOrEqualTo(String value) {
            addCriterion("ad_equipName_list <=", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListLike(String value) {
            addCriterion("ad_equipName_list like", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListNotLike(String value) {
            addCriterion("ad_equipName_list not like", value, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListIn(List<String> values) {
            addCriterion("ad_equipName_list in", values, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListNotIn(List<String> values) {
            addCriterion("ad_equipName_list not in", values, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListBetween(String value1, String value2) {
            addCriterion("ad_equipName_list between", value1, value2, "adEquipnameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipnameListNotBetween(String value1, String value2) {
            addCriterion("ad_equipName_list not between", value1, value2, "adEquipnameList");
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
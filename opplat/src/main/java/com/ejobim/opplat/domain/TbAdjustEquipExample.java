package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAdjustEquipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAdjustEquipExample() {
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
            addCriterion("ad_equipName_list is null");
            return (Criteria) this;
        }

        public Criteria andAdNoIsNotNull() {
            addCriterion("ad_equipName_list is not null");
            return (Criteria) this;
        }

        public Criteria andAdNoEqualTo(String value) {
            addCriterion("ad_equipName_list =", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotEqualTo(String value) {
            addCriterion("ad_equipName_list <>", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoGreaterThan(String value) {
            addCriterion("ad_equipName_list >", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoGreaterThanOrEqualTo(String value) {
            addCriterion("ad_equipName_list >=", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLessThan(String value) {
            addCriterion("ad_equipName_list <", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLessThanOrEqualTo(String value) {
            addCriterion("ad_equipName_list <=", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoLike(String value) {
            addCriterion("ad_equipName_list like", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotLike(String value) {
            addCriterion("ad_equipName_list not like", value, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoIn(List<String> values) {
            addCriterion("ad_equipName_list in", values, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotIn(List<String> values) {
            addCriterion("ad_equipName_list not in", values, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoBetween(String value1, String value2) {
            addCriterion("ad_equipName_list between", value1, value2, "adNo");
            return (Criteria) this;
        }

        public Criteria andAdNoNotBetween(String value1, String value2) {
            addCriterion("ad_equipName_list not between", value1, value2, "adNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNull() {
            addCriterion("factory_no is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIsNotNull() {
            addCriterion("factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNoEqualTo(String value) {
            addCriterion("factory_no =", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotEqualTo(String value) {
            addCriterion("factory_no <>", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThan(String value) {
            addCriterion("factory_no >", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("factory_no >=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThan(String value) {
            addCriterion("factory_no <", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("factory_no <=", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoLike(String value) {
            addCriterion("factory_no like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotLike(String value) {
            addCriterion("factory_no not like", value, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoIn(List<String> values) {
            addCriterion("factory_no in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotIn(List<String> values) {
            addCriterion("factory_no not in", values, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoBetween(String value1, String value2) {
            addCriterion("factory_no between", value1, value2, "factoryNo");
            return (Criteria) this;
        }

        public Criteria andFactoryNoNotBetween(String value1, String value2) {
            addCriterion("factory_no not between", value1, value2, "factoryNo");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("apply_user is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(String value) {
            addCriterion("apply_user =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(String value) {
            addCriterion("apply_user <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(String value) {
            addCriterion("apply_user >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(String value) {
            addCriterion("apply_user <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(String value) {
            addCriterion("apply_user <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLike(String value) {
            addCriterion("apply_user like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotLike(String value) {
            addCriterion("apply_user not like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(List<String> values) {
            addCriterion("apply_user in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(List<String> values) {
            addCriterion("apply_user not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(String value1, String value2) {
            addCriterion("apply_user between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(String value1, String value2) {
            addCriterion("apply_user not between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListIsNull() {
            addCriterion("ad_no is null");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListIsNotNull() {
            addCriterion("ad_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListEqualTo(String value) {
            addCriterion("ad_no =", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListNotEqualTo(String value) {
            addCriterion("ad_no <>", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListGreaterThan(String value) {
            addCriterion("ad_no >", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListGreaterThanOrEqualTo(String value) {
            addCriterion("ad_no >=", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListLessThan(String value) {
            addCriterion("ad_no <", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListLessThanOrEqualTo(String value) {
            addCriterion("ad_no <=", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListLike(String value) {
            addCriterion("ad_no like", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListNotLike(String value) {
            addCriterion("ad_no not like", value, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListIn(List<String> values) {
            addCriterion("ad_no in", values, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListNotIn(List<String> values) {
            addCriterion("ad_no not in", values, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListBetween(String value1, String value2) {
            addCriterion("ad_no between", value1, value2, "adEquipNameList");
            return (Criteria) this;
        }

        public Criteria andAdEquipNameListNotBetween(String value1, String value2) {
            addCriterion("ad_no not between", value1, value2, "adEquipNameList");
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
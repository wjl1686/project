package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkFlowApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkFlowApiExample() {
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

        public Criteria andApiNoIsNull() {
            addCriterion("api_no is null");
            return (Criteria) this;
        }

        public Criteria andApiNoIsNotNull() {
            addCriterion("api_no is not null");
            return (Criteria) this;
        }

        public Criteria andApiNoEqualTo(String value) {
            addCriterion("api_no =", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoNotEqualTo(String value) {
            addCriterion("api_no <>", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoGreaterThan(String value) {
            addCriterion("api_no >", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoGreaterThanOrEqualTo(String value) {
            addCriterion("api_no >=", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoLessThan(String value) {
            addCriterion("api_no <", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoLessThanOrEqualTo(String value) {
            addCriterion("api_no <=", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoLike(String value) {
            addCriterion("api_no like", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoNotLike(String value) {
            addCriterion("api_no not like", value, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoIn(List<String> values) {
            addCriterion("api_no in", values, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoNotIn(List<String> values) {
            addCriterion("api_no not in", values, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoBetween(String value1, String value2) {
            addCriterion("api_no between", value1, value2, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNoNotBetween(String value1, String value2) {
            addCriterion("api_no not between", value1, value2, "apiNo");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNull() {
            addCriterion("api_url is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNotNull() {
            addCriterion("api_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlEqualTo(String value) {
            addCriterion("api_url =", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotEqualTo(String value) {
            addCriterion("api_url <>", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThan(String value) {
            addCriterion("api_url >", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_url >=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThan(String value) {
            addCriterion("api_url <", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThanOrEqualTo(String value) {
            addCriterion("api_url <=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLike(String value) {
            addCriterion("api_url like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotLike(String value) {
            addCriterion("api_url not like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIn(List<String> values) {
            addCriterion("api_url in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotIn(List<String> values) {
            addCriterion("api_url not in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlBetween(String value1, String value2) {
            addCriterion("api_url between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotBetween(String value1, String value2) {
            addCriterion("api_url not between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiParamsIsNull() {
            addCriterion("api_params is null");
            return (Criteria) this;
        }

        public Criteria andApiParamsIsNotNull() {
            addCriterion("api_params is not null");
            return (Criteria) this;
        }

        public Criteria andApiParamsEqualTo(Object value) {
            addCriterion("api_params =", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsNotEqualTo(Object value) {
            addCriterion("api_params <>", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsGreaterThan(Object value) {
            addCriterion("api_params >", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsGreaterThanOrEqualTo(Object value) {
            addCriterion("api_params >=", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsLessThan(Object value) {
            addCriterion("api_params <", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsLessThanOrEqualTo(Object value) {
            addCriterion("api_params <=", value, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsIn(List<Object> values) {
            addCriterion("api_params in", values, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsNotIn(List<Object> values) {
            addCriterion("api_params not in", values, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsBetween(Object value1, Object value2) {
            addCriterion("api_params between", value1, value2, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiParamsNotBetween(Object value1, Object value2) {
            addCriterion("api_params not between", value1, value2, "apiParams");
            return (Criteria) this;
        }

        public Criteria andApiInfoIsNull() {
            addCriterion("api_info is null");
            return (Criteria) this;
        }

        public Criteria andApiInfoIsNotNull() {
            addCriterion("api_info is not null");
            return (Criteria) this;
        }

        public Criteria andApiInfoEqualTo(String value) {
            addCriterion("api_info =", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotEqualTo(String value) {
            addCriterion("api_info <>", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoGreaterThan(String value) {
            addCriterion("api_info >", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoGreaterThanOrEqualTo(String value) {
            addCriterion("api_info >=", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLessThan(String value) {
            addCriterion("api_info <", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLessThanOrEqualTo(String value) {
            addCriterion("api_info <=", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLike(String value) {
            addCriterion("api_info like", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotLike(String value) {
            addCriterion("api_info not like", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoIn(List<String> values) {
            addCriterion("api_info in", values, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotIn(List<String> values) {
            addCriterion("api_info not in", values, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoBetween(String value1, String value2) {
            addCriterion("api_info between", value1, value2, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotBetween(String value1, String value2) {
            addCriterion("api_info not between", value1, value2, "apiInfo");
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

        public Criteria andCommitParamsIsNull() {
            addCriterion("commit_params is null");
            return (Criteria) this;
        }

        public Criteria andCommitParamsIsNotNull() {
            addCriterion("commit_params is not null");
            return (Criteria) this;
        }

        public Criteria andCommitParamsEqualTo(Object value) {
            addCriterion("commit_params =", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsNotEqualTo(Object value) {
            addCriterion("commit_params <>", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsGreaterThan(Object value) {
            addCriterion("commit_params >", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsGreaterThanOrEqualTo(Object value) {
            addCriterion("commit_params >=", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsLessThan(Object value) {
            addCriterion("commit_params <", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsLessThanOrEqualTo(Object value) {
            addCriterion("commit_params <=", value, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsIn(List<Object> values) {
            addCriterion("commit_params in", values, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsNotIn(List<Object> values) {
            addCriterion("commit_params not in", values, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsBetween(Object value1, Object value2) {
            addCriterion("commit_params between", value1, value2, "commitParams");
            return (Criteria) this;
        }

        public Criteria andCommitParamsNotBetween(Object value1, Object value2) {
            addCriterion("commit_params not between", value1, value2, "commitParams");
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
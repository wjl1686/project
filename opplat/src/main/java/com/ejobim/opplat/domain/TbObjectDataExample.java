package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbObjectDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbObjectDataExample() {
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

        public Criteria andObjectUriIsNull() {
            addCriterion("object_uri is null");
            return (Criteria) this;
        }

        public Criteria andObjectUriIsNotNull() {
            addCriterion("object_uri is not null");
            return (Criteria) this;
        }

        public Criteria andObjectUriEqualTo(String value) {
            addCriterion("object_uri =", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriNotEqualTo(String value) {
            addCriterion("object_uri <>", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriGreaterThan(String value) {
            addCriterion("object_uri >", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriGreaterThanOrEqualTo(String value) {
            addCriterion("object_uri >=", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriLessThan(String value) {
            addCriterion("object_uri <", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriLessThanOrEqualTo(String value) {
            addCriterion("object_uri <=", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriLike(String value) {
            addCriterion("object_uri like", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriNotLike(String value) {
            addCriterion("object_uri not like", value, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriIn(List<String> values) {
            addCriterion("object_uri in", values, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriNotIn(List<String> values) {
            addCriterion("object_uri not in", values, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriBetween(String value1, String value2) {
            addCriterion("object_uri between", value1, value2, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectUriNotBetween(String value1, String value2) {
            addCriterion("object_uri not between", value1, value2, "objectUri");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(Integer value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(Integer value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(Integer value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(Integer value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<Integer> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<Integer> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andDataUriIsNull() {
            addCriterion("data_uri is null");
            return (Criteria) this;
        }

        public Criteria andDataUriIsNotNull() {
            addCriterion("data_uri is not null");
            return (Criteria) this;
        }

        public Criteria andDataUriEqualTo(String value) {
            addCriterion("data_uri =", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriNotEqualTo(String value) {
            addCriterion("data_uri <>", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriGreaterThan(String value) {
            addCriterion("data_uri >", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriGreaterThanOrEqualTo(String value) {
            addCriterion("data_uri >=", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriLessThan(String value) {
            addCriterion("data_uri <", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriLessThanOrEqualTo(String value) {
            addCriterion("data_uri <=", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriLike(String value) {
            addCriterion("data_uri like", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriNotLike(String value) {
            addCriterion("data_uri not like", value, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriIn(List<String> values) {
            addCriterion("data_uri in", values, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriNotIn(List<String> values) {
            addCriterion("data_uri not in", values, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriBetween(String value1, String value2) {
            addCriterion("data_uri between", value1, value2, "dataUri");
            return (Criteria) this;
        }

        public Criteria andDataUriNotBetween(String value1, String value2) {
            addCriterion("data_uri not between", value1, value2, "dataUri");
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


        public Criteria andDataFromIsNull() {
            addCriterion("data_from is null");
            return (Criteria) this;
        }

        public Criteria andDataFromIsNotNull() {
            addCriterion("data_from is not null");
            return (Criteria) this;
        }

        public Criteria andDataFromEqualTo(Integer value) {
            addCriterion("data_from =", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotEqualTo(Integer value) {
            addCriterion("data_from <>", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThan(Integer value) {
            addCriterion("data_from >", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_from >=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThan(Integer value) {
            addCriterion("data_from <", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThanOrEqualTo(Integer value) {
            addCriterion("data_from <=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromIn(List<Integer> values) {
            addCriterion("data_from in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotIn(List<Integer> values) {
            addCriterion("data_from not in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromBetween(Integer value1, Integer value2) {
            addCriterion("data_from between", value1, value2, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotBetween(Integer value1, Integer value2) {
            addCriterion("data_from not between", value1, value2, "dataFrom");
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
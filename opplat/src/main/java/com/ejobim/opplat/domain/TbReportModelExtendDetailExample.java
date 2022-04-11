package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbReportModelExtendDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReportModelExtendDetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoIsNull() {
            addCriterion("link_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoIsNotNull() {
            addCriterion("link_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoEqualTo(String value) {
            addCriterion("link_extend_no =", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoNotEqualTo(String value) {
            addCriterion("link_extend_no <>", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoGreaterThan(String value) {
            addCriterion("link_extend_no >", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("link_extend_no >=", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoLessThan(String value) {
            addCriterion("link_extend_no <", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoLessThanOrEqualTo(String value) {
            addCriterion("link_extend_no <=", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoLike(String value) {
            addCriterion("link_extend_no like", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoNotLike(String value) {
            addCriterion("link_extend_no not like", value, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoIn(List<String> values) {
            addCriterion("link_extend_no in", values, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoNotIn(List<String> values) {
            addCriterion("link_extend_no not in", values, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoBetween(String value1, String value2) {
            addCriterion("link_extend_no between", value1, value2, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andLinkExtendNoNotBetween(String value1, String value2) {
            addCriterion("link_extend_no not between", value1, value2, "linkExtendNo");
            return (Criteria) this;
        }

        public Criteria andDtUriIsNull() {
            addCriterion("dt_uri is null");
            return (Criteria) this;
        }

        public Criteria andDtUriIsNotNull() {
            addCriterion("dt_uri is not null");
            return (Criteria) this;
        }

        public Criteria andDtUriEqualTo(String value) {
            addCriterion("dt_uri =", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriNotEqualTo(String value) {
            addCriterion("dt_uri <>", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriGreaterThan(String value) {
            addCriterion("dt_uri >", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriGreaterThanOrEqualTo(String value) {
            addCriterion("dt_uri >=", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriLessThan(String value) {
            addCriterion("dt_uri <", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriLessThanOrEqualTo(String value) {
            addCriterion("dt_uri <=", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriLike(String value) {
            addCriterion("dt_uri like", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriNotLike(String value) {
            addCriterion("dt_uri not like", value, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriIn(List<String> values) {
            addCriterion("dt_uri in", values, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriNotIn(List<String> values) {
            addCriterion("dt_uri not in", values, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriBetween(String value1, String value2) {
            addCriterion("dt_uri between", value1, value2, "dtUri");
            return (Criteria) this;
        }

        public Criteria andDtUriNotBetween(String value1, String value2) {
            addCriterion("dt_uri not between", value1, value2, "dtUri");
            return (Criteria) this;
        }

        public Criteria andFieldNoIsNull() {
            addCriterion("field_no is null");
            return (Criteria) this;
        }

        public Criteria andFieldNoIsNotNull() {
            addCriterion("field_no is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNoEqualTo(String value) {
            addCriterion("field_no =", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotEqualTo(String value) {
            addCriterion("field_no <>", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoGreaterThan(String value) {
            addCriterion("field_no >", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoGreaterThanOrEqualTo(String value) {
            addCriterion("field_no >=", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLessThan(String value) {
            addCriterion("field_no <", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLessThanOrEqualTo(String value) {
            addCriterion("field_no <=", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoLike(String value) {
            addCriterion("field_no like", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotLike(String value) {
            addCriterion("field_no not like", value, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoIn(List<String> values) {
            addCriterion("field_no in", values, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotIn(List<String> values) {
            addCriterion("field_no not in", values, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoBetween(String value1, String value2) {
            addCriterion("field_no between", value1, value2, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andFieldNoNotBetween(String value1, String value2) {
            addCriterion("field_no not between", value1, value2, "fieldNo");
            return (Criteria) this;
        }

        public Criteria andMathCmdIsNull() {
            addCriterion("math_cmd is null");
            return (Criteria) this;
        }

        public Criteria andMathCmdIsNotNull() {
            addCriterion("math_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andMathCmdEqualTo(String value) {
            addCriterion("math_cmd =", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdNotEqualTo(String value) {
            addCriterion("math_cmd <>", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdGreaterThan(String value) {
            addCriterion("math_cmd >", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdGreaterThanOrEqualTo(String value) {
            addCriterion("math_cmd >=", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdLessThan(String value) {
            addCriterion("math_cmd <", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdLessThanOrEqualTo(String value) {
            addCriterion("math_cmd <=", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdLike(String value) {
            addCriterion("math_cmd like", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdNotLike(String value) {
            addCriterion("math_cmd not like", value, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdIn(List<String> values) {
            addCriterion("math_cmd in", values, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdNotIn(List<String> values) {
            addCriterion("math_cmd not in", values, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdBetween(String value1, String value2) {
            addCriterion("math_cmd between", value1, value2, "mathCmd");
            return (Criteria) this;
        }

        public Criteria andMathCmdNotBetween(String value1, String value2) {
            addCriterion("math_cmd not between", value1, value2, "mathCmd");
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

        public Criteria andMathTypeIsNull() {
            addCriterion("math_type is null");
            return (Criteria) this;
        }

        public Criteria andMathTypeIsNotNull() {
            addCriterion("math_type is not null");
            return (Criteria) this;
        }

        public Criteria andMathTypeEqualTo(Integer value) {
            addCriterion("math_type =", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeNotEqualTo(Integer value) {
            addCriterion("math_type <>", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeGreaterThan(Integer value) {
            addCriterion("math_type >", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("math_type >=", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeLessThan(Integer value) {
            addCriterion("math_type <", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeLessThanOrEqualTo(Integer value) {
            addCriterion("math_type <=", value, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeIn(List<Integer> values) {
            addCriterion("math_type in", values, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeNotIn(List<Integer> values) {
            addCriterion("math_type not in", values, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeBetween(Integer value1, Integer value2) {
            addCriterion("math_type between", value1, value2, "mathType");
            return (Criteria) this;
        }

        public Criteria andMathTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("math_type not between", value1, value2, "mathType");
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
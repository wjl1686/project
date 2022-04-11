package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDepartmentExample() {
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

        public Criteria andDepartmentNoIsNull() {
            addCriterion("department_no is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoIsNotNull() {
            addCriterion("department_no is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoEqualTo(String value) {
            addCriterion("department_no =", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoNotEqualTo(String value) {
            addCriterion("department_no <>", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoGreaterThan(String value) {
            addCriterion("department_no >", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("department_no >=", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoLessThan(String value) {
            addCriterion("department_no <", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoLessThanOrEqualTo(String value) {
            addCriterion("department_no <=", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoLike(String value) {
            addCriterion("department_no like", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoNotLike(String value) {
            addCriterion("department_no not like", value, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoIn(List<String> values) {
            addCriterion("department_no in", values, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoNotIn(List<String> values) {
            addCriterion("department_no not in", values, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoBetween(String value1, String value2) {
            addCriterion("department_no between", value1, value2, "departmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentNoNotBetween(String value1, String value2) {
            addCriterion("department_no not between", value1, value2, "departmentNo");
            return (Criteria) this;
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

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoIsNull() {
            addCriterion("parent_department_no is null");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoIsNotNull() {
            addCriterion("parent_department_no is not null");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoEqualTo(String value) {
            addCriterion("parent_department_no =", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoNotEqualTo(String value) {
            addCriterion("parent_department_no <>", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoGreaterThan(String value) {
            addCriterion("parent_department_no >", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_department_no >=", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoLessThan(String value) {
            addCriterion("parent_department_no <", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoLessThanOrEqualTo(String value) {
            addCriterion("parent_department_no <=", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoLike(String value) {
            addCriterion("parent_department_no like", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoNotLike(String value) {
            addCriterion("parent_department_no not like", value, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoIn(List<String> values) {
            addCriterion("parent_department_no in", values, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoNotIn(List<String> values) {
            addCriterion("parent_department_no not in", values, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoBetween(String value1, String value2) {
            addCriterion("parent_department_no between", value1, value2, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andParentDepartmentNoNotBetween(String value1, String value2) {
            addCriterion("parent_department_no not between", value1, value2, "parentDepartmentNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIsNull() {
            addCriterion("department_manager is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIsNotNull() {
            addCriterion("department_manager is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerEqualTo(String value) {
            addCriterion("department_manager =", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotEqualTo(String value) {
            addCriterion("department_manager <>", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerGreaterThan(String value) {
            addCriterion("department_manager >", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerGreaterThanOrEqualTo(String value) {
            addCriterion("department_manager >=", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLessThan(String value) {
            addCriterion("department_manager <", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLessThanOrEqualTo(String value) {
            addCriterion("department_manager <=", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLike(String value) {
            addCriterion("department_manager like", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotLike(String value) {
            addCriterion("department_manager not like", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIn(List<String> values) {
            addCriterion("department_manager in", values, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotIn(List<String> values) {
            addCriterion("department_manager not in", values, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerBetween(String value1, String value2) {
            addCriterion("department_manager between", value1, value2, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotBetween(String value1, String value2) {
            addCriterion("department_manager not between", value1, value2, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIsNull() {
            addCriterion("department_type is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIsNotNull() {
            addCriterion("department_type is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeEqualTo(Integer value) {
            addCriterion("department_type =", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotEqualTo(Integer value) {
            addCriterion("department_type <>", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThan(Integer value) {
            addCriterion("department_type >", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_type >=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThan(Integer value) {
            addCriterion("department_type <", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("department_type <=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIn(List<Integer> values) {
            addCriterion("department_type in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotIn(List<Integer> values) {
            addCriterion("department_type not in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeBetween(Integer value1, Integer value2) {
            addCriterion("department_type between", value1, value2, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("department_type not between", value1, value2, "departmentType");
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
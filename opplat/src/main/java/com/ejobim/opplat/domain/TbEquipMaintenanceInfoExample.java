package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipMaintenanceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipMaintenanceInfoExample() {
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

        public Criteria andMaintenanceDetailNoIsNull() {
            addCriterion("maintenance_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoIsNotNull() {
            addCriterion("maintenance_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoEqualTo(String value) {
            addCriterion("maintenance_detail_no =", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoNotEqualTo(String value) {
            addCriterion("maintenance_detail_no <>", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoGreaterThan(String value) {
            addCriterion("maintenance_detail_no >", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_detail_no >=", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoLessThan(String value) {
            addCriterion("maintenance_detail_no <", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoLessThanOrEqualTo(String value) {
            addCriterion("maintenance_detail_no <=", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoLike(String value) {
            addCriterion("maintenance_detail_no like", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoNotLike(String value) {
            addCriterion("maintenance_detail_no not like", value, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoIn(List<String> values) {
            addCriterion("maintenance_detail_no in", values, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoNotIn(List<String> values) {
            addCriterion("maintenance_detail_no not in", values, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoBetween(String value1, String value2) {
            addCriterion("maintenance_detail_no between", value1, value2, "maintenanceDetailNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceDetailNoNotBetween(String value1, String value2) {
            addCriterion("maintenance_detail_no not between", value1, value2, "maintenanceDetailNo");
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

        public Criteria andMaintenancePicturesIsNull() {
            addCriterion("maintenance_pictures is null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesIsNotNull() {
            addCriterion("maintenance_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesEqualTo(String value) {
            addCriterion("maintenance_pictures =", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesNotEqualTo(String value) {
            addCriterion("maintenance_pictures <>", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesGreaterThan(String value) {
            addCriterion("maintenance_pictures >", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_pictures >=", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesLessThan(String value) {
            addCriterion("maintenance_pictures <", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesLessThanOrEqualTo(String value) {
            addCriterion("maintenance_pictures <=", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesLike(String value) {
            addCriterion("maintenance_pictures like", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesNotLike(String value) {
            addCriterion("maintenance_pictures not like", value, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesIn(List<String> values) {
            addCriterion("maintenance_pictures in", values, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesNotIn(List<String> values) {
            addCriterion("maintenance_pictures not in", values, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesBetween(String value1, String value2) {
            addCriterion("maintenance_pictures between", value1, value2, "maintenancePictures");
            return (Criteria) this;
        }

        public Criteria andMaintenancePicturesNotBetween(String value1, String value2) {
            addCriterion("maintenance_pictures not between", value1, value2, "maintenancePictures");
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

        public Criteria andMaintenanceElementNoIsNull() {
            addCriterion("maintenance_element_no is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoIsNotNull() {
            addCriterion("maintenance_element_no is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoEqualTo(String value) {
            addCriterion("maintenance_element_no =", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoNotEqualTo(String value) {
            addCriterion("maintenance_element_no <>", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoGreaterThan(String value) {
            addCriterion("maintenance_element_no >", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_element_no >=", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoLessThan(String value) {
            addCriterion("maintenance_element_no <", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoLessThanOrEqualTo(String value) {
            addCriterion("maintenance_element_no <=", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoLike(String value) {
            addCriterion("maintenance_element_no like", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoNotLike(String value) {
            addCriterion("maintenance_element_no not like", value, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoIn(List<String> values) {
            addCriterion("maintenance_element_no in", values, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoNotIn(List<String> values) {
            addCriterion("maintenance_element_no not in", values, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoBetween(String value1, String value2) {
            addCriterion("maintenance_element_no between", value1, value2, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceElementNoNotBetween(String value1, String value2) {
            addCriterion("maintenance_element_no not between", value1, value2, "maintenanceElementNo");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodIsNull() {
            addCriterion("mentenance_method is null");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodIsNotNull() {
            addCriterion("mentenance_method is not null");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodEqualTo(String value) {
            addCriterion("mentenance_method =", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodNotEqualTo(String value) {
            addCriterion("mentenance_method <>", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodGreaterThan(String value) {
            addCriterion("mentenance_method >", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodGreaterThanOrEqualTo(String value) {
            addCriterion("mentenance_method >=", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodLessThan(String value) {
            addCriterion("mentenance_method <", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodLessThanOrEqualTo(String value) {
            addCriterion("mentenance_method <=", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodLike(String value) {
            addCriterion("mentenance_method like", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodNotLike(String value) {
            addCriterion("mentenance_method not like", value, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodIn(List<String> values) {
            addCriterion("mentenance_method in", values, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodNotIn(List<String> values) {
            addCriterion("mentenance_method not in", values, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodBetween(String value1, String value2) {
            addCriterion("mentenance_method between", value1, value2, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceMethodNotBetween(String value1, String value2) {
            addCriterion("mentenance_method not between", value1, value2, "mentenanceMethod");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionIsNull() {
            addCriterion("mentenance_description is null");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionIsNotNull() {
            addCriterion("mentenance_description is not null");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionEqualTo(String value) {
            addCriterion("mentenance_description =", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionNotEqualTo(String value) {
            addCriterion("mentenance_description <>", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionGreaterThan(String value) {
            addCriterion("mentenance_description >", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("mentenance_description >=", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionLessThan(String value) {
            addCriterion("mentenance_description <", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionLessThanOrEqualTo(String value) {
            addCriterion("mentenance_description <=", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionLike(String value) {
            addCriterion("mentenance_description like", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionNotLike(String value) {
            addCriterion("mentenance_description not like", value, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionIn(List<String> values) {
            addCriterion("mentenance_description in", values, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionNotIn(List<String> values) {
            addCriterion("mentenance_description not in", values, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionBetween(String value1, String value2) {
            addCriterion("mentenance_description between", value1, value2, "mentenanceDescription");
            return (Criteria) this;
        }

        public Criteria andMentenanceDescriptionNotBetween(String value1, String value2) {
            addCriterion("mentenance_description not between", value1, value2, "mentenanceDescription");
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
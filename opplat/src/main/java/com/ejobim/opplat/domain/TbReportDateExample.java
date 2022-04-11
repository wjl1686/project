package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbReportDateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReportDateExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDrNoIsNull() {
            addCriterion("dr_no is null");
            return (Criteria) this;
        }

        public Criteria andDrNoIsNotNull() {
            addCriterion("dr_no is not null");
            return (Criteria) this;
        }

        public Criteria andDrNoEqualTo(String value) {
            addCriterion("dr_no =", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoNotEqualTo(String value) {
            addCriterion("dr_no <>", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoGreaterThan(String value) {
            addCriterion("dr_no >", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoGreaterThanOrEqualTo(String value) {
            addCriterion("dr_no >=", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoLessThan(String value) {
            addCriterion("dr_no <", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoLessThanOrEqualTo(String value) {
            addCriterion("dr_no <=", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoLike(String value) {
            addCriterion("dr_no like", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoNotLike(String value) {
            addCriterion("dr_no not like", value, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoIn(List<String> values) {
            addCriterion("dr_no in", values, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoNotIn(List<String> values) {
            addCriterion("dr_no not in", values, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoBetween(String value1, String value2) {
            addCriterion("dr_no between", value1, value2, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrNoNotBetween(String value1, String value2) {
            addCriterion("dr_no not between", value1, value2, "drNo");
            return (Criteria) this;
        }

        public Criteria andDrDateIsNull() {
            addCriterion("dr_date is null");
            return (Criteria) this;
        }

        public Criteria andDrDateIsNotNull() {
            addCriterion("dr_date is not null");
            return (Criteria) this;
        }

        public Criteria andDrDateEqualTo(Date value) {
            addCriterionForJDBCDate("dr_date =", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dr_date <>", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateGreaterThan(Date value) {
            addCriterionForJDBCDate("dr_date >", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dr_date >=", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateLessThan(Date value) {
            addCriterionForJDBCDate("dr_date <", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dr_date <=", value, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateIn(List<Date> values) {
            addCriterionForJDBCDate("dr_date in", values, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dr_date not in", values, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dr_date between", value1, value2, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dr_date not between", value1, value2, "drDate");
            return (Criteria) this;
        }

        public Criteria andDrValueIsNull() {
            addCriterion("dr_value is null");
            return (Criteria) this;
        }

        public Criteria andDrValueIsNotNull() {
            addCriterion("dr_value is not null");
            return (Criteria) this;
        }

        public Criteria andDrValueEqualTo(Float value) {
            addCriterion("dr_value =", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueNotEqualTo(Float value) {
            addCriterion("dr_value <>", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueGreaterThan(Float value) {
            addCriterion("dr_value >", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueGreaterThanOrEqualTo(Float value) {
            addCriterion("dr_value >=", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueLessThan(Float value) {
            addCriterion("dr_value <", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueLessThanOrEqualTo(Float value) {
            addCriterion("dr_value <=", value, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueIn(List<Float> values) {
            addCriterion("dr_value in", values, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueNotIn(List<Float> values) {
            addCriterion("dr_value not in", values, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueBetween(Float value1, Float value2) {
            addCriterion("dr_value between", value1, value2, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrValueNotBetween(Float value1, Float value2) {
            addCriterion("dr_value not between", value1, value2, "drValue");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameIsNull() {
            addCriterion("dr_browse_name is null");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameIsNotNull() {
            addCriterion("dr_browse_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameEqualTo(String value) {
            addCriterion("dr_browse_name =", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameNotEqualTo(String value) {
            addCriterion("dr_browse_name <>", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameGreaterThan(String value) {
            addCriterion("dr_browse_name >", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameGreaterThanOrEqualTo(String value) {
            addCriterion("dr_browse_name >=", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameLessThan(String value) {
            addCriterion("dr_browse_name <", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameLessThanOrEqualTo(String value) {
            addCriterion("dr_browse_name <=", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameLike(String value) {
            addCriterion("dr_browse_name like", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameNotLike(String value) {
            addCriterion("dr_browse_name not like", value, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameIn(List<String> values) {
            addCriterion("dr_browse_name in", values, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameNotIn(List<String> values) {
            addCriterion("dr_browse_name not in", values, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameBetween(String value1, String value2) {
            addCriterion("dr_browse_name between", value1, value2, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrBrowseNameNotBetween(String value1, String value2) {
            addCriterion("dr_browse_name not between", value1, value2, "drBrowseName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameIsNull() {
            addCriterion("dr_display_name is null");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameIsNotNull() {
            addCriterion("dr_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameEqualTo(String value) {
            addCriterion("dr_display_name =", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameNotEqualTo(String value) {
            addCriterion("dr_display_name <>", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameGreaterThan(String value) {
            addCriterion("dr_display_name >", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("dr_display_name >=", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameLessThan(String value) {
            addCriterion("dr_display_name <", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("dr_display_name <=", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameLike(String value) {
            addCriterion("dr_display_name like", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameNotLike(String value) {
            addCriterion("dr_display_name not like", value, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameIn(List<String> values) {
            addCriterion("dr_display_name in", values, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameNotIn(List<String> values) {
            addCriterion("dr_display_name not in", values, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameBetween(String value1, String value2) {
            addCriterion("dr_display_name between", value1, value2, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrDisplayNameNotBetween(String value1, String value2) {
            addCriterion("dr_display_name not between", value1, value2, "drDisplayName");
            return (Criteria) this;
        }

        public Criteria andDrUnitIsNull() {
            addCriterion("dr_unit is null");
            return (Criteria) this;
        }

        public Criteria andDrUnitIsNotNull() {
            addCriterion("dr_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDrUnitEqualTo(String value) {
            addCriterion("dr_unit =", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitNotEqualTo(String value) {
            addCriterion("dr_unit <>", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitGreaterThan(String value) {
            addCriterion("dr_unit >", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitGreaterThanOrEqualTo(String value) {
            addCriterion("dr_unit >=", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitLessThan(String value) {
            addCriterion("dr_unit <", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitLessThanOrEqualTo(String value) {
            addCriterion("dr_unit <=", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitLike(String value) {
            addCriterion("dr_unit like", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitNotLike(String value) {
            addCriterion("dr_unit not like", value, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitIn(List<String> values) {
            addCriterion("dr_unit in", values, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitNotIn(List<String> values) {
            addCriterion("dr_unit not in", values, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitBetween(String value1, String value2) {
            addCriterion("dr_unit between", value1, value2, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrUnitNotBetween(String value1, String value2) {
            addCriterion("dr_unit not between", value1, value2, "drUnit");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeIsNull() {
            addCriterion("dr_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeIsNotNull() {
            addCriterion("dr_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeEqualTo(Date value) {
            addCriterion("dr_create_time =", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeNotEqualTo(Date value) {
            addCriterion("dr_create_time <>", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeGreaterThan(Date value) {
            addCriterion("dr_create_time >", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dr_create_time >=", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeLessThan(Date value) {
            addCriterion("dr_create_time <", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("dr_create_time <=", value, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeIn(List<Date> values) {
            addCriterion("dr_create_time in", values, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeNotIn(List<Date> values) {
            addCriterion("dr_create_time not in", values, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeBetween(Date value1, Date value2) {
            addCriterion("dr_create_time between", value1, value2, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("dr_create_time not between", value1, value2, "drCreateTime");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoIsNull() {
            addCriterion("dr_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoIsNotNull() {
            addCriterion("dr_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoEqualTo(String value) {
            addCriterion("dr_factory_no =", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoNotEqualTo(String value) {
            addCriterion("dr_factory_no <>", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoGreaterThan(String value) {
            addCriterion("dr_factory_no >", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("dr_factory_no >=", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoLessThan(String value) {
            addCriterion("dr_factory_no <", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("dr_factory_no <=", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoLike(String value) {
            addCriterion("dr_factory_no like", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoNotLike(String value) {
            addCriterion("dr_factory_no not like", value, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoIn(List<String> values) {
            addCriterion("dr_factory_no in", values, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoNotIn(List<String> values) {
            addCriterion("dr_factory_no not in", values, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoBetween(String value1, String value2) {
            addCriterion("dr_factory_no between", value1, value2, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrFactoryNoNotBetween(String value1, String value2) {
            addCriterion("dr_factory_no not between", value1, value2, "drFactoryNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoIsNull() {
            addCriterion("dr_equip_no is null");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoIsNotNull() {
            addCriterion("dr_equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoEqualTo(String value) {
            addCriterion("dr_equip_no =", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoNotEqualTo(String value) {
            addCriterion("dr_equip_no <>", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoGreaterThan(String value) {
            addCriterion("dr_equip_no >", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("dr_equip_no >=", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoLessThan(String value) {
            addCriterion("dr_equip_no <", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoLessThanOrEqualTo(String value) {
            addCriterion("dr_equip_no <=", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoLike(String value) {
            addCriterion("dr_equip_no like", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoNotLike(String value) {
            addCriterion("dr_equip_no not like", value, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoIn(List<String> values) {
            addCriterion("dr_equip_no in", values, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoNotIn(List<String> values) {
            addCriterion("dr_equip_no not in", values, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoBetween(String value1, String value2) {
            addCriterion("dr_equip_no between", value1, value2, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNoNotBetween(String value1, String value2) {
            addCriterion("dr_equip_no not between", value1, value2, "drEquipNo");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameIsNull() {
            addCriterion("dr_equip_name is null");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameIsNotNull() {
            addCriterion("dr_equip_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameEqualTo(String value) {
            addCriterion("dr_equip_name =", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameNotEqualTo(String value) {
            addCriterion("dr_equip_name <>", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameGreaterThan(String value) {
            addCriterion("dr_equip_name >", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameGreaterThanOrEqualTo(String value) {
            addCriterion("dr_equip_name >=", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameLessThan(String value) {
            addCriterion("dr_equip_name <", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameLessThanOrEqualTo(String value) {
            addCriterion("dr_equip_name <=", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameLike(String value) {
            addCriterion("dr_equip_name like", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameNotLike(String value) {
            addCriterion("dr_equip_name not like", value, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameIn(List<String> values) {
            addCriterion("dr_equip_name in", values, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameNotIn(List<String> values) {
            addCriterion("dr_equip_name not in", values, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameBetween(String value1, String value2) {
            addCriterion("dr_equip_name between", value1, value2, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrEquipNameNotBetween(String value1, String value2) {
            addCriterion("dr_equip_name not between", value1, value2, "drEquipName");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeIsNull() {
            addCriterion("dr_data_type is null");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeIsNotNull() {
            addCriterion("dr_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeEqualTo(Integer value) {
            addCriterion("dr_data_type =", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeNotEqualTo(Integer value) {
            addCriterion("dr_data_type <>", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeGreaterThan(Integer value) {
            addCriterion("dr_data_type >", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dr_data_type >=", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeLessThan(Integer value) {
            addCriterion("dr_data_type <", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dr_data_type <=", value, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeIn(List<Integer> values) {
            addCriterion("dr_data_type in", values, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeNotIn(List<Integer> values) {
            addCriterion("dr_data_type not in", values, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("dr_data_type between", value1, value2, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dr_data_type not between", value1, value2, "drDataType");
            return (Criteria) this;
        }

        public Criteria andDrFillNoIsNull() {
            addCriterion("dr_fill_no is null");
            return (Criteria) this;
        }

        public Criteria andDrFillNoIsNotNull() {
            addCriterion("dr_fill_no is not null");
            return (Criteria) this;
        }

        public Criteria andDrFillNoEqualTo(String value) {
            addCriterion("dr_fill_no =", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoNotEqualTo(String value) {
            addCriterion("dr_fill_no <>", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoGreaterThan(String value) {
            addCriterion("dr_fill_no >", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoGreaterThanOrEqualTo(String value) {
            addCriterion("dr_fill_no >=", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoLessThan(String value) {
            addCriterion("dr_fill_no <", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoLessThanOrEqualTo(String value) {
            addCriterion("dr_fill_no <=", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoLike(String value) {
            addCriterion("dr_fill_no like", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoNotLike(String value) {
            addCriterion("dr_fill_no not like", value, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoIn(List<String> values) {
            addCriterion("dr_fill_no in", values, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoNotIn(List<String> values) {
            addCriterion("dr_fill_no not in", values, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoBetween(String value1, String value2) {
            addCriterion("dr_fill_no between", value1, value2, "drFillNo");
            return (Criteria) this;
        }

        public Criteria andDrFillNoNotBetween(String value1, String value2) {
            addCriterion("dr_fill_no not between", value1, value2, "drFillNo");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbFacilityInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFacilityInfoExample() {
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

        public Criteria andFatiNoIsNull() {
            addCriterion("fati_no is null");
            return (Criteria) this;
        }

        public Criteria andFatiNoIsNotNull() {
            addCriterion("fati_no is not null");
            return (Criteria) this;
        }

        public Criteria andFatiNoEqualTo(String value) {
            addCriterion("fati_no =", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoNotEqualTo(String value) {
            addCriterion("fati_no <>", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoGreaterThan(String value) {
            addCriterion("fati_no >", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoGreaterThanOrEqualTo(String value) {
            addCriterion("fati_no >=", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoLessThan(String value) {
            addCriterion("fati_no <", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoLessThanOrEqualTo(String value) {
            addCriterion("fati_no <=", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoLike(String value) {
            addCriterion("fati_no like", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoNotLike(String value) {
            addCriterion("fati_no not like", value, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoIn(List<String> values) {
            addCriterion("fati_no in", values, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoNotIn(List<String> values) {
            addCriterion("fati_no not in", values, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoBetween(String value1, String value2) {
            addCriterion("fati_no between", value1, value2, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiNoNotBetween(String value1, String value2) {
            addCriterion("fati_no not between", value1, value2, "fatiNo");
            return (Criteria) this;
        }

        public Criteria andFatiUriIsNull() {
            addCriterion("fati_uri is null");
            return (Criteria) this;
        }

        public Criteria andFatiUriIsNotNull() {
            addCriterion("fati_uri is not null");
            return (Criteria) this;
        }

        public Criteria andFatiUriEqualTo(String value) {
            addCriterion("fati_uri =", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriNotEqualTo(String value) {
            addCriterion("fati_uri <>", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriGreaterThan(String value) {
            addCriterion("fati_uri >", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriGreaterThanOrEqualTo(String value) {
            addCriterion("fati_uri >=", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriLessThan(String value) {
            addCriterion("fati_uri <", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriLessThanOrEqualTo(String value) {
            addCriterion("fati_uri <=", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriLike(String value) {
            addCriterion("fati_uri like", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriNotLike(String value) {
            addCriterion("fati_uri not like", value, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriIn(List<String> values) {
            addCriterion("fati_uri in", values, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriNotIn(List<String> values) {
            addCriterion("fati_uri not in", values, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriBetween(String value1, String value2) {
            addCriterion("fati_uri between", value1, value2, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiUriNotBetween(String value1, String value2) {
            addCriterion("fati_uri not between", value1, value2, "fatiUri");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoIsNull() {
            addCriterion("fati_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoIsNotNull() {
            addCriterion("fati_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoEqualTo(String value) {
            addCriterion("fati_factory_no =", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoNotEqualTo(String value) {
            addCriterion("fati_factory_no <>", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoGreaterThan(String value) {
            addCriterion("fati_factory_no >", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("fati_factory_no >=", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoLessThan(String value) {
            addCriterion("fati_factory_no <", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("fati_factory_no <=", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoLike(String value) {
            addCriterion("fati_factory_no like", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoNotLike(String value) {
            addCriterion("fati_factory_no not like", value, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoIn(List<String> values) {
            addCriterion("fati_factory_no in", values, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoNotIn(List<String> values) {
            addCriterion("fati_factory_no not in", values, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoBetween(String value1, String value2) {
            addCriterion("fati_factory_no between", value1, value2, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiFactoryNoNotBetween(String value1, String value2) {
            addCriterion("fati_factory_no not between", value1, value2, "fatiFactoryNo");
            return (Criteria) this;
        }

        public Criteria andFatiNameIsNull() {
            addCriterion("fati_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiNameIsNotNull() {
            addCriterion("fati_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiNameEqualTo(String value) {
            addCriterion("fati_name =", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameNotEqualTo(String value) {
            addCriterion("fati_name <>", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameGreaterThan(String value) {
            addCriterion("fati_name >", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_name >=", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameLessThan(String value) {
            addCriterion("fati_name <", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameLessThanOrEqualTo(String value) {
            addCriterion("fati_name <=", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameLike(String value) {
            addCriterion("fati_name like", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameNotLike(String value) {
            addCriterion("fati_name not like", value, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameIn(List<String> values) {
            addCriterion("fati_name in", values, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameNotIn(List<String> values) {
            addCriterion("fati_name not in", values, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameBetween(String value1, String value2) {
            addCriterion("fati_name between", value1, value2, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiNameNotBetween(String value1, String value2) {
            addCriterion("fati_name not between", value1, value2, "fatiName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameIsNull() {
            addCriterion("fati_browse_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameIsNotNull() {
            addCriterion("fati_browse_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameEqualTo(String value) {
            addCriterion("fati_browse_name =", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameNotEqualTo(String value) {
            addCriterion("fati_browse_name <>", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameGreaterThan(String value) {
            addCriterion("fati_browse_name >", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_browse_name >=", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameLessThan(String value) {
            addCriterion("fati_browse_name <", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameLessThanOrEqualTo(String value) {
            addCriterion("fati_browse_name <=", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameLike(String value) {
            addCriterion("fati_browse_name like", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameNotLike(String value) {
            addCriterion("fati_browse_name not like", value, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameIn(List<String> values) {
            addCriterion("fati_browse_name in", values, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameNotIn(List<String> values) {
            addCriterion("fati_browse_name not in", values, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameBetween(String value1, String value2) {
            addCriterion("fati_browse_name between", value1, value2, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiBrowseNameNotBetween(String value1, String value2) {
            addCriterion("fati_browse_name not between", value1, value2, "fatiBrowseName");
            return (Criteria) this;
        }

        public Criteria andFatiCodeIsNull() {
            addCriterion("fati_code is null");
            return (Criteria) this;
        }

        public Criteria andFatiCodeIsNotNull() {
            addCriterion("fati_code is not null");
            return (Criteria) this;
        }

        public Criteria andFatiCodeEqualTo(String value) {
            addCriterion("fati_code =", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeNotEqualTo(String value) {
            addCriterion("fati_code <>", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeGreaterThan(String value) {
            addCriterion("fati_code >", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fati_code >=", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeLessThan(String value) {
            addCriterion("fati_code <", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeLessThanOrEqualTo(String value) {
            addCriterion("fati_code <=", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeLike(String value) {
            addCriterion("fati_code like", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeNotLike(String value) {
            addCriterion("fati_code not like", value, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeIn(List<String> values) {
            addCriterion("fati_code in", values, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeNotIn(List<String> values) {
            addCriterion("fati_code not in", values, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeBetween(String value1, String value2) {
            addCriterion("fati_code between", value1, value2, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiCodeNotBetween(String value1, String value2) {
            addCriterion("fati_code not between", value1, value2, "fatiCode");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiIsNull() {
            addCriterion("fati_gongyi is null");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiIsNotNull() {
            addCriterion("fati_gongyi is not null");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiEqualTo(String value) {
            addCriterion("fati_gongyi =", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNotEqualTo(String value) {
            addCriterion("fati_gongyi <>", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiGreaterThan(String value) {
            addCriterion("fati_gongyi >", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiGreaterThanOrEqualTo(String value) {
            addCriterion("fati_gongyi >=", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiLessThan(String value) {
            addCriterion("fati_gongyi <", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiLessThanOrEqualTo(String value) {
            addCriterion("fati_gongyi <=", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiLike(String value) {
            addCriterion("fati_gongyi like", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNotLike(String value) {
            addCriterion("fati_gongyi not like", value, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiIn(List<String> values) {
            addCriterion("fati_gongyi in", values, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNotIn(List<String> values) {
            addCriterion("fati_gongyi not in", values, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiBetween(String value1, String value2) {
            addCriterion("fati_gongyi between", value1, value2, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNotBetween(String value1, String value2) {
            addCriterion("fati_gongyi not between", value1, value2, "fatiGongyi");
            return (Criteria) this;
        }

        public Criteria andFatiNumIsNull() {
            addCriterion("fati_num is null");
            return (Criteria) this;
        }

        public Criteria andFatiNumIsNotNull() {
            addCriterion("fati_num is not null");
            return (Criteria) this;
        }

        public Criteria andFatiNumEqualTo(Integer value) {
            addCriterion("fati_num =", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumNotEqualTo(Integer value) {
            addCriterion("fati_num <>", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumGreaterThan(Integer value) {
            addCriterion("fati_num >", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fati_num >=", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumLessThan(Integer value) {
            addCriterion("fati_num <", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumLessThanOrEqualTo(Integer value) {
            addCriterion("fati_num <=", value, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumIn(List<Integer> values) {
            addCriterion("fati_num in", values, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumNotIn(List<Integer> values) {
            addCriterion("fati_num not in", values, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumBetween(Integer value1, Integer value2) {
            addCriterion("fati_num between", value1, value2, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiNumNotBetween(Integer value1, Integer value2) {
            addCriterion("fati_num not between", value1, value2, "fatiNum");
            return (Criteria) this;
        }

        public Criteria andFatiUnitIsNull() {
            addCriterion("fati_unit is null");
            return (Criteria) this;
        }

        public Criteria andFatiUnitIsNotNull() {
            addCriterion("fati_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFatiUnitEqualTo(String value) {
            addCriterion("fati_unit =", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitNotEqualTo(String value) {
            addCriterion("fati_unit <>", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitGreaterThan(String value) {
            addCriterion("fati_unit >", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitGreaterThanOrEqualTo(String value) {
            addCriterion("fati_unit >=", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitLessThan(String value) {
            addCriterion("fati_unit <", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitLessThanOrEqualTo(String value) {
            addCriterion("fati_unit <=", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitLike(String value) {
            addCriterion("fati_unit like", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitNotLike(String value) {
            addCriterion("fati_unit not like", value, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitIn(List<String> values) {
            addCriterion("fati_unit in", values, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitNotIn(List<String> values) {
            addCriterion("fati_unit not in", values, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitBetween(String value1, String value2) {
            addCriterion("fati_unit between", value1, value2, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiUnitNotBetween(String value1, String value2) {
            addCriterion("fati_unit not between", value1, value2, "fatiUnit");
            return (Criteria) this;
        }

        public Criteria andFatiTypeIsNull() {
            addCriterion("fati_type is null");
            return (Criteria) this;
        }

        public Criteria andFatiTypeIsNotNull() {
            addCriterion("fati_type is not null");
            return (Criteria) this;
        }

        public Criteria andFatiTypeEqualTo(Integer value) {
            addCriterion("fati_type =", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeNotEqualTo(Integer value) {
            addCriterion("fati_type <>", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeGreaterThan(Integer value) {
            addCriterion("fati_type >", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fati_type >=", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeLessThan(Integer value) {
            addCriterion("fati_type <", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fati_type <=", value, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeIn(List<Integer> values) {
            addCriterion("fati_type in", values, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeNotIn(List<Integer> values) {
            addCriterion("fati_type not in", values, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeBetween(Integer value1, Integer value2) {
            addCriterion("fati_type between", value1, value2, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fati_type not between", value1, value2, "fatiType");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateIsNull() {
            addCriterion("fati_init_date is null");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateIsNotNull() {
            addCriterion("fati_init_date is not null");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateEqualTo(Date value) {
            addCriterionForJDBCDate("fati_init_date =", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("fati_init_date <>", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("fati_init_date >", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fati_init_date >=", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateLessThan(Date value) {
            addCriterionForJDBCDate("fati_init_date <", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fati_init_date <=", value, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateIn(List<Date> values) {
            addCriterionForJDBCDate("fati_init_date in", values, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("fati_init_date not in", values, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fati_init_date between", value1, value2, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiInitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fati_init_date not between", value1, value2, "fatiInitDate");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgIsNull() {
            addCriterion("fati_design_org is null");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgIsNotNull() {
            addCriterion("fati_design_org is not null");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgEqualTo(String value) {
            addCriterion("fati_design_org =", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgNotEqualTo(String value) {
            addCriterion("fati_design_org <>", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgGreaterThan(String value) {
            addCriterion("fati_design_org >", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgGreaterThanOrEqualTo(String value) {
            addCriterion("fati_design_org >=", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgLessThan(String value) {
            addCriterion("fati_design_org <", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgLessThanOrEqualTo(String value) {
            addCriterion("fati_design_org <=", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgLike(String value) {
            addCriterion("fati_design_org like", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgNotLike(String value) {
            addCriterion("fati_design_org not like", value, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgIn(List<String> values) {
            addCriterion("fati_design_org in", values, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgNotIn(List<String> values) {
            addCriterion("fati_design_org not in", values, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgBetween(String value1, String value2) {
            addCriterion("fati_design_org between", value1, value2, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiDesignOrgNotBetween(String value1, String value2) {
            addCriterion("fati_design_org not between", value1, value2, "fatiDesignOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgIsNull() {
            addCriterion("fati_build_org is null");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgIsNotNull() {
            addCriterion("fati_build_org is not null");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgEqualTo(String value) {
            addCriterion("fati_build_org =", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgNotEqualTo(String value) {
            addCriterion("fati_build_org <>", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgGreaterThan(String value) {
            addCriterion("fati_build_org >", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgGreaterThanOrEqualTo(String value) {
            addCriterion("fati_build_org >=", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgLessThan(String value) {
            addCriterion("fati_build_org <", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgLessThanOrEqualTo(String value) {
            addCriterion("fati_build_org <=", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgLike(String value) {
            addCriterion("fati_build_org like", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgNotLike(String value) {
            addCriterion("fati_build_org not like", value, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgIn(List<String> values) {
            addCriterion("fati_build_org in", values, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgNotIn(List<String> values) {
            addCriterion("fati_build_org not in", values, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgBetween(String value1, String value2) {
            addCriterion("fati_build_org between", value1, value2, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiBuildOrgNotBetween(String value1, String value2) {
            addCriterion("fati_build_org not between", value1, value2, "fatiBuildOrg");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusIsNull() {
            addCriterion("fati_manager_status is null");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusIsNotNull() {
            addCriterion("fati_manager_status is not null");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusEqualTo(Integer value) {
            addCriterion("fati_manager_status =", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusNotEqualTo(Integer value) {
            addCriterion("fati_manager_status <>", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusGreaterThan(Integer value) {
            addCriterion("fati_manager_status >", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fati_manager_status >=", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusLessThan(Integer value) {
            addCriterion("fati_manager_status <", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fati_manager_status <=", value, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusIn(List<Integer> values) {
            addCriterion("fati_manager_status in", values, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusNotIn(List<Integer> values) {
            addCriterion("fati_manager_status not in", values, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusBetween(Integer value1, Integer value2) {
            addCriterion("fati_manager_status between", value1, value2, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiManagerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fati_manager_status not between", value1, value2, "fatiManagerStatus");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionIsNull() {
            addCriterion("fati_description is null");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionIsNotNull() {
            addCriterion("fati_description is not null");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionEqualTo(String value) {
            addCriterion("fati_description =", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionNotEqualTo(String value) {
            addCriterion("fati_description <>", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionGreaterThan(String value) {
            addCriterion("fati_description >", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("fati_description >=", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionLessThan(String value) {
            addCriterion("fati_description <", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionLessThanOrEqualTo(String value) {
            addCriterion("fati_description <=", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionLike(String value) {
            addCriterion("fati_description like", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionNotLike(String value) {
            addCriterion("fati_description not like", value, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionIn(List<String> values) {
            addCriterion("fati_description in", values, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionNotIn(List<String> values) {
            addCriterion("fati_description not in", values, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionBetween(String value1, String value2) {
            addCriterion("fati_description between", value1, value2, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiDescriptionNotBetween(String value1, String value2) {
            addCriterion("fati_description not between", value1, value2, "fatiDescription");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeIsNull() {
            addCriterion("fati_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeIsNotNull() {
            addCriterion("fati_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeEqualTo(Date value) {
            addCriterion("fati_create_time =", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeNotEqualTo(Date value) {
            addCriterion("fati_create_time <>", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeGreaterThan(Date value) {
            addCriterion("fati_create_time >", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fati_create_time >=", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeLessThan(Date value) {
            addCriterion("fati_create_time <", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("fati_create_time <=", value, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeIn(List<Date> values) {
            addCriterion("fati_create_time in", values, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeNotIn(List<Date> values) {
            addCriterion("fati_create_time not in", values, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeBetween(Date value1, Date value2) {
            addCriterion("fati_create_time between", value1, value2, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("fati_create_time not between", value1, value2, "fatiCreateTime");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeIsNull() {
            addCriterion("fati_create_user_code is null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeIsNotNull() {
            addCriterion("fati_create_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeEqualTo(String value) {
            addCriterion("fati_create_user_code =", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeNotEqualTo(String value) {
            addCriterion("fati_create_user_code <>", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeGreaterThan(String value) {
            addCriterion("fati_create_user_code >", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fati_create_user_code >=", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeLessThan(String value) {
            addCriterion("fati_create_user_code <", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("fati_create_user_code <=", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeLike(String value) {
            addCriterion("fati_create_user_code like", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeNotLike(String value) {
            addCriterion("fati_create_user_code not like", value, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeIn(List<String> values) {
            addCriterion("fati_create_user_code in", values, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeNotIn(List<String> values) {
            addCriterion("fati_create_user_code not in", values, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeBetween(String value1, String value2) {
            addCriterion("fati_create_user_code between", value1, value2, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserCodeNotBetween(String value1, String value2) {
            addCriterion("fati_create_user_code not between", value1, value2, "fatiCreateUserCode");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameIsNull() {
            addCriterion("fati_create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameIsNotNull() {
            addCriterion("fati_create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameEqualTo(String value) {
            addCriterion("fati_create_user_name =", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameNotEqualTo(String value) {
            addCriterion("fati_create_user_name <>", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameGreaterThan(String value) {
            addCriterion("fati_create_user_name >", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_create_user_name >=", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameLessThan(String value) {
            addCriterion("fati_create_user_name <", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("fati_create_user_name <=", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameLike(String value) {
            addCriterion("fati_create_user_name like", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameNotLike(String value) {
            addCriterion("fati_create_user_name not like", value, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameIn(List<String> values) {
            addCriterion("fati_create_user_name in", values, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameNotIn(List<String> values) {
            addCriterion("fati_create_user_name not in", values, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameBetween(String value1, String value2) {
            addCriterion("fati_create_user_name between", value1, value2, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("fati_create_user_name not between", value1, value2, "fatiCreateUserName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameIsNull() {
            addCriterion("fati_gongyi_name is null");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameIsNotNull() {
            addCriterion("fati_gongyi_name is not null");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameEqualTo(String value) {
            addCriterion("fati_gongyi_name =", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameNotEqualTo(String value) {
            addCriterion("fati_gongyi_name <>", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameGreaterThan(String value) {
            addCriterion("fati_gongyi_name >", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameGreaterThanOrEqualTo(String value) {
            addCriterion("fati_gongyi_name >=", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameLessThan(String value) {
            addCriterion("fati_gongyi_name <", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameLessThanOrEqualTo(String value) {
            addCriterion("fati_gongyi_name <=", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameLike(String value) {
            addCriterion("fati_gongyi_name like", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameNotLike(String value) {
            addCriterion("fati_gongyi_name not like", value, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameIn(List<String> values) {
            addCriterion("fati_gongyi_name in", values, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameNotIn(List<String> values) {
            addCriterion("fati_gongyi_name not in", values, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameBetween(String value1, String value2) {
            addCriterion("fati_gongyi_name between", value1, value2, "fatiGongyiName");
            return (Criteria) this;
        }

        public Criteria andFatiGongyiNameNotBetween(String value1, String value2) {
            addCriterion("fati_gongyi_name not between", value1, value2, "fatiGongyiName");
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
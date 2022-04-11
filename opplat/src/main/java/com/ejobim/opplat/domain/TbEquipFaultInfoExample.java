package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipFaultInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipFaultInfoExample() {
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

        public Criteria andErrorNoIsNull() {
            addCriterion("error_no is null");
            return (Criteria) this;
        }

        public Criteria andErrorNoIsNotNull() {
            addCriterion("error_no is not null");
            return (Criteria) this;
        }

        public Criteria andErrorNoEqualTo(String value) {
            addCriterion("error_no =", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoNotEqualTo(String value) {
            addCriterion("error_no <>", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoGreaterThan(String value) {
            addCriterion("error_no >", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoGreaterThanOrEqualTo(String value) {
            addCriterion("error_no >=", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoLessThan(String value) {
            addCriterion("error_no <", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoLessThanOrEqualTo(String value) {
            addCriterion("error_no <=", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoLike(String value) {
            addCriterion("error_no like", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoNotLike(String value) {
            addCriterion("error_no not like", value, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoIn(List<String> values) {
            addCriterion("error_no in", values, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoNotIn(List<String> values) {
            addCriterion("error_no not in", values, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoBetween(String value1, String value2) {
            addCriterion("error_no between", value1, value2, "errorNo");
            return (Criteria) this;
        }

        public Criteria andErrorNoNotBetween(String value1, String value2) {
            addCriterion("error_no not between", value1, value2, "errorNo");
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

        public Criteria andEquipNoIsNull() {
            addCriterion("equip_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNotNull() {
            addCriterion("equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNoEqualTo(String value) {
            addCriterion("equip_no =", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotEqualTo(String value) {
            addCriterion("equip_no <>", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThan(String value) {
            addCriterion("equip_no >", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("equip_no >=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThan(String value) {
            addCriterion("equip_no <", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThanOrEqualTo(String value) {
            addCriterion("equip_no <=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLike(String value) {
            addCriterion("equip_no like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotLike(String value) {
            addCriterion("equip_no not like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIn(List<String> values) {
            addCriterion("equip_no in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotIn(List<String> values) {
            addCriterion("equip_no not in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoBetween(String value1, String value2) {
            addCriterion("equip_no between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotBetween(String value1, String value2) {
            addCriterion("equip_no not between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNull() {
            addCriterion("equip_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNotNull() {
            addCriterion("equip_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNameEqualTo(String value) {
            addCriterion("equip_name =", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotEqualTo(String value) {
            addCriterion("equip_name <>", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThan(String value) {
            addCriterion("equip_name >", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_name >=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThan(String value) {
            addCriterion("equip_name <", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThanOrEqualTo(String value) {
            addCriterion("equip_name <=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLike(String value) {
            addCriterion("equip_name like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotLike(String value) {
            addCriterion("equip_name not like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameIn(List<String> values) {
            addCriterion("equip_name in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotIn(List<String> values) {
            addCriterion("equip_name not in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameBetween(String value1, String value2) {
            addCriterion("equip_name between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotBetween(String value1, String value2) {
            addCriterion("equip_name not between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNull() {
            addCriterion("equip_type_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNotNull() {
            addCriterion("equip_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameEqualTo(String value) {
            addCriterion("equip_type_name =", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotEqualTo(String value) {
            addCriterion("equip_type_name <>", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThan(String value) {
            addCriterion("equip_type_name >", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type_name >=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThan(String value) {
            addCriterion("equip_type_name <", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThanOrEqualTo(String value) {
            addCriterion("equip_type_name <=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLike(String value) {
            addCriterion("equip_type_name like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotLike(String value) {
            addCriterion("equip_type_name not like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIn(List<String> values) {
            addCriterion("equip_type_name in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotIn(List<String> values) {
            addCriterion("equip_type_name not in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameBetween(String value1, String value2) {
            addCriterion("equip_type_name between", value1, value2, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotBetween(String value1, String value2) {
            addCriterion("equip_type_name not between", value1, value2, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationIsNull() {
            addCriterion("equip_location is null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationIsNotNull() {
            addCriterion("equip_location is not null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationEqualTo(String value) {
            addCriterion("equip_location =", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNotEqualTo(String value) {
            addCriterion("equip_location <>", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationGreaterThan(String value) {
            addCriterion("equip_location >", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationGreaterThanOrEqualTo(String value) {
            addCriterion("equip_location >=", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationLessThan(String value) {
            addCriterion("equip_location <", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationLessThanOrEqualTo(String value) {
            addCriterion("equip_location <=", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationLike(String value) {
            addCriterion("equip_location like", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNotLike(String value) {
            addCriterion("equip_location not like", value, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationIn(List<String> values) {
            addCriterion("equip_location in", values, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNotIn(List<String> values) {
            addCriterion("equip_location not in", values, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationBetween(String value1, String value2) {
            addCriterion("equip_location between", value1, value2, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNotBetween(String value1, String value2) {
            addCriterion("equip_location not between", value1, value2, "equipLocation");
            return (Criteria) this;
        }

        public Criteria andErrorFromIsNull() {
            addCriterion("error_from is null");
            return (Criteria) this;
        }

        public Criteria andErrorFromIsNotNull() {
            addCriterion("error_from is not null");
            return (Criteria) this;
        }

        public Criteria andErrorFromEqualTo(Integer value) {
            addCriterion("error_from =", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromNotEqualTo(Integer value) {
            addCriterion("error_from <>", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromGreaterThan(Integer value) {
            addCriterion("error_from >", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_from >=", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromLessThan(Integer value) {
            addCriterion("error_from <", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromLessThanOrEqualTo(Integer value) {
            addCriterion("error_from <=", value, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromIn(List<Integer> values) {
            addCriterion("error_from in", values, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromNotIn(List<Integer> values) {
            addCriterion("error_from not in", values, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromBetween(Integer value1, Integer value2) {
            addCriterion("error_from between", value1, value2, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorFromNotBetween(Integer value1, Integer value2) {
            addCriterion("error_from not between", value1, value2, "errorFrom");
            return (Criteria) this;
        }

        public Criteria andErrorTypeIsNull() {
            addCriterion("error_type is null");
            return (Criteria) this;
        }

        public Criteria andErrorTypeIsNotNull() {
            addCriterion("error_type is not null");
            return (Criteria) this;
        }

        public Criteria andErrorTypeEqualTo(String value) {
            addCriterion("error_type =", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotEqualTo(String value) {
            addCriterion("error_type <>", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeGreaterThan(String value) {
            addCriterion("error_type >", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("error_type >=", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLessThan(String value) {
            addCriterion("error_type <", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLessThanOrEqualTo(String value) {
            addCriterion("error_type <=", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeLike(String value) {
            addCriterion("error_type like", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotLike(String value) {
            addCriterion("error_type not like", value, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeIn(List<String> values) {
            addCriterion("error_type in", values, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotIn(List<String> values) {
            addCriterion("error_type not in", values, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeBetween(String value1, String value2) {
            addCriterion("error_type between", value1, value2, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorTypeNotBetween(String value1, String value2) {
            addCriterion("error_type not between", value1, value2, "errorType");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIsNull() {
            addCriterion("error_location is null");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIsNotNull() {
            addCriterion("error_location is not null");
            return (Criteria) this;
        }

        public Criteria andErrorLocationEqualTo(String value) {
            addCriterion("error_location =", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotEqualTo(String value) {
            addCriterion("error_location <>", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationGreaterThan(String value) {
            addCriterion("error_location >", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationGreaterThanOrEqualTo(String value) {
            addCriterion("error_location >=", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLessThan(String value) {
            addCriterion("error_location <", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLessThanOrEqualTo(String value) {
            addCriterion("error_location <=", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationLike(String value) {
            addCriterion("error_location like", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotLike(String value) {
            addCriterion("error_location not like", value, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationIn(List<String> values) {
            addCriterion("error_location in", values, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotIn(List<String> values) {
            addCriterion("error_location not in", values, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationBetween(String value1, String value2) {
            addCriterion("error_location between", value1, value2, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorLocationNotBetween(String value1, String value2) {
            addCriterion("error_location not between", value1, value2, "errorLocation");
            return (Criteria) this;
        }

        public Criteria andErrorContentIsNull() {
            addCriterion("error_content is null");
            return (Criteria) this;
        }

        public Criteria andErrorContentIsNotNull() {
            addCriterion("error_content is not null");
            return (Criteria) this;
        }

        public Criteria andErrorContentEqualTo(String value) {
            addCriterion("error_content =", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentNotEqualTo(String value) {
            addCriterion("error_content <>", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentGreaterThan(String value) {
            addCriterion("error_content >", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentGreaterThanOrEqualTo(String value) {
            addCriterion("error_content >=", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentLessThan(String value) {
            addCriterion("error_content <", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentLessThanOrEqualTo(String value) {
            addCriterion("error_content <=", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentLike(String value) {
            addCriterion("error_content like", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentNotLike(String value) {
            addCriterion("error_content not like", value, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentIn(List<String> values) {
            addCriterion("error_content in", values, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentNotIn(List<String> values) {
            addCriterion("error_content not in", values, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentBetween(String value1, String value2) {
            addCriterion("error_content between", value1, value2, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorContentNotBetween(String value1, String value2) {
            addCriterion("error_content not between", value1, value2, "errorContent");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesIsNull() {
            addCriterion("error_pictures is null");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesIsNotNull() {
            addCriterion("error_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesEqualTo(String value) {
            addCriterion("error_pictures =", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesNotEqualTo(String value) {
            addCriterion("error_pictures <>", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesGreaterThan(String value) {
            addCriterion("error_pictures >", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("error_pictures >=", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesLessThan(String value) {
            addCriterion("error_pictures <", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesLessThanOrEqualTo(String value) {
            addCriterion("error_pictures <=", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesLike(String value) {
            addCriterion("error_pictures like", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesNotLike(String value) {
            addCriterion("error_pictures not like", value, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesIn(List<String> values) {
            addCriterion("error_pictures in", values, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesNotIn(List<String> values) {
            addCriterion("error_pictures not in", values, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesBetween(String value1, String value2) {
            addCriterion("error_pictures between", value1, value2, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorPicturesNotBetween(String value1, String value2) {
            addCriterion("error_pictures not between", value1, value2, "errorPictures");
            return (Criteria) this;
        }

        public Criteria andErrorVideoIsNull() {
            addCriterion("error_video is null");
            return (Criteria) this;
        }

        public Criteria andErrorVideoIsNotNull() {
            addCriterion("error_video is not null");
            return (Criteria) this;
        }

        public Criteria andErrorVideoEqualTo(String value) {
            addCriterion("error_video =", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoNotEqualTo(String value) {
            addCriterion("error_video <>", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoGreaterThan(String value) {
            addCriterion("error_video >", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoGreaterThanOrEqualTo(String value) {
            addCriterion("error_video >=", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoLessThan(String value) {
            addCriterion("error_video <", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoLessThanOrEqualTo(String value) {
            addCriterion("error_video <=", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoLike(String value) {
            addCriterion("error_video like", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoNotLike(String value) {
            addCriterion("error_video not like", value, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoIn(List<String> values) {
            addCriterion("error_video in", values, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoNotIn(List<String> values) {
            addCriterion("error_video not in", values, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoBetween(String value1, String value2) {
            addCriterion("error_video between", value1, value2, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorVideoNotBetween(String value1, String value2) {
            addCriterion("error_video not between", value1, value2, "errorVideo");
            return (Criteria) this;
        }

        public Criteria andErrorAudioIsNull() {
            addCriterion("error_audio is null");
            return (Criteria) this;
        }

        public Criteria andErrorAudioIsNotNull() {
            addCriterion("error_audio is not null");
            return (Criteria) this;
        }

        public Criteria andErrorAudioEqualTo(String value) {
            addCriterion("error_audio =", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioNotEqualTo(String value) {
            addCriterion("error_audio <>", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioGreaterThan(String value) {
            addCriterion("error_audio >", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioGreaterThanOrEqualTo(String value) {
            addCriterion("error_audio >=", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioLessThan(String value) {
            addCriterion("error_audio <", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioLessThanOrEqualTo(String value) {
            addCriterion("error_audio <=", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioLike(String value) {
            addCriterion("error_audio like", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioNotLike(String value) {
            addCriterion("error_audio not like", value, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioIn(List<String> values) {
            addCriterion("error_audio in", values, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioNotIn(List<String> values) {
            addCriterion("error_audio not in", values, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioBetween(String value1, String value2) {
            addCriterion("error_audio between", value1, value2, "errorAudio");
            return (Criteria) this;
        }

        public Criteria andErrorAudioNotBetween(String value1, String value2) {
            addCriterion("error_audio not between", value1, value2, "errorAudio");
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

        public Criteria andDetailTaskNoIsNull() {
            addCriterion("detail_task_no is null");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoIsNotNull() {
            addCriterion("detail_task_no is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoEqualTo(String value) {
            addCriterion("detail_task_no =", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoNotEqualTo(String value) {
            addCriterion("detail_task_no <>", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoGreaterThan(String value) {
            addCriterion("detail_task_no >", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_task_no >=", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoLessThan(String value) {
            addCriterion("detail_task_no <", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoLessThanOrEqualTo(String value) {
            addCriterion("detail_task_no <=", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoLike(String value) {
            addCriterion("detail_task_no like", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoNotLike(String value) {
            addCriterion("detail_task_no not like", value, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoIn(List<String> values) {
            addCriterion("detail_task_no in", values, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoNotIn(List<String> values) {
            addCriterion("detail_task_no not in", values, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoBetween(String value1, String value2) {
            addCriterion("detail_task_no between", value1, value2, "detailTaskNo");
            return (Criteria) this;
        }

        public Criteria andDetailTaskNoNotBetween(String value1, String value2) {
            addCriterion("detail_task_no not between", value1, value2, "detailTaskNo");
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

        public Criteria andReportUserCodeIsNull() {
            addCriterion("report_user_code is null");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeIsNotNull() {
            addCriterion("report_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeEqualTo(String value) {
            addCriterion("report_user_code =", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeNotEqualTo(String value) {
            addCriterion("report_user_code <>", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeGreaterThan(String value) {
            addCriterion("report_user_code >", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("report_user_code >=", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeLessThan(String value) {
            addCriterion("report_user_code <", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeLessThanOrEqualTo(String value) {
            addCriterion("report_user_code <=", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeLike(String value) {
            addCriterion("report_user_code like", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeNotLike(String value) {
            addCriterion("report_user_code not like", value, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeIn(List<String> values) {
            addCriterion("report_user_code in", values, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeNotIn(List<String> values) {
            addCriterion("report_user_code not in", values, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeBetween(String value1, String value2) {
            addCriterion("report_user_code between", value1, value2, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserCodeNotBetween(String value1, String value2) {
            addCriterion("report_user_code not between", value1, value2, "reportUserCode");
            return (Criteria) this;
        }

        public Criteria andReportUserNameIsNull() {
            addCriterion("report_user_name is null");
            return (Criteria) this;
        }

        public Criteria andReportUserNameIsNotNull() {
            addCriterion("report_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportUserNameEqualTo(String value) {
            addCriterion("report_user_name =", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameNotEqualTo(String value) {
            addCriterion("report_user_name <>", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameGreaterThan(String value) {
            addCriterion("report_user_name >", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_user_name >=", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameLessThan(String value) {
            addCriterion("report_user_name <", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameLessThanOrEqualTo(String value) {
            addCriterion("report_user_name <=", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameLike(String value) {
            addCriterion("report_user_name like", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameNotLike(String value) {
            addCriterion("report_user_name not like", value, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameIn(List<String> values) {
            addCriterion("report_user_name in", values, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameNotIn(List<String> values) {
            addCriterion("report_user_name not in", values, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameBetween(String value1, String value2) {
            addCriterion("report_user_name between", value1, value2, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andReportUserNameNotBetween(String value1, String value2) {
            addCriterion("report_user_name not between", value1, value2, "reportUserName");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIsNull() {
            addCriterion("error_status is null");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIsNotNull() {
            addCriterion("error_status is not null");
            return (Criteria) this;
        }

        public Criteria andErrorStatusEqualTo(Integer value) {
            addCriterion("error_status =", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotEqualTo(Integer value) {
            addCriterion("error_status <>", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusGreaterThan(Integer value) {
            addCriterion("error_status >", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_status >=", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusLessThan(Integer value) {
            addCriterion("error_status <", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusLessThanOrEqualTo(Integer value) {
            addCriterion("error_status <=", value, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusIn(List<Integer> values) {
            addCriterion("error_status in", values, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotIn(List<Integer> values) {
            addCriterion("error_status not in", values, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusBetween(Integer value1, Integer value2) {
            addCriterion("error_status between", value1, value2, "errorStatus");
            return (Criteria) this;
        }

        public Criteria andErrorStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("error_status not between", value1, value2, "errorStatus");
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
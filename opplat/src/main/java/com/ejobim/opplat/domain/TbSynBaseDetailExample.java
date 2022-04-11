package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSynBaseDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSynBaseDetailExample() {
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

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriIsNull() {
            addCriterion("typeDefinitionUri is null");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriIsNotNull() {
            addCriterion("typeDefinitionUri is not null");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriEqualTo(String value) {
            addCriterion("typeDefinitionUri =", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriNotEqualTo(String value) {
            addCriterion("typeDefinitionUri <>", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriGreaterThan(String value) {
            addCriterion("typeDefinitionUri >", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriGreaterThanOrEqualTo(String value) {
            addCriterion("typeDefinitionUri >=", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriLessThan(String value) {
            addCriterion("typeDefinitionUri <", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriLessThanOrEqualTo(String value) {
            addCriterion("typeDefinitionUri <=", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriLike(String value) {
            addCriterion("typeDefinitionUri like", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriNotLike(String value) {
            addCriterion("typeDefinitionUri not like", value, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriIn(List<String> values) {
            addCriterion("typeDefinitionUri in", values, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriNotIn(List<String> values) {
            addCriterion("typeDefinitionUri not in", values, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriBetween(String value1, String value2) {
            addCriterion("typeDefinitionUri between", value1, value2, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andTypedefinitionuriNotBetween(String value1, String value2) {
            addCriterion("typeDefinitionUri not between", value1, value2, "typedefinitionuri");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIsNull() {
            addCriterion("BrowsePath is null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIsNotNull() {
            addCriterion("BrowsePath is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathEqualTo(String value) {
            addCriterion("BrowsePath =", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotEqualTo(String value) {
            addCriterion("BrowsePath <>", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThan(String value) {
            addCriterion("BrowsePath >", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThanOrEqualTo(String value) {
            addCriterion("BrowsePath >=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThan(String value) {
            addCriterion("BrowsePath <", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThanOrEqualTo(String value) {
            addCriterion("BrowsePath <=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLike(String value) {
            addCriterion("BrowsePath like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotLike(String value) {
            addCriterion("BrowsePath not like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIn(List<String> values) {
            addCriterion("BrowsePath in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotIn(List<String> values) {
            addCriterion("BrowsePath not in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathBetween(String value1, String value2) {
            addCriterion("BrowsePath between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotBetween(String value1, String value2) {
            addCriterion("BrowsePath not between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIsNull() {
            addCriterion("BrowseName is null");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIsNotNull() {
            addCriterion("BrowseName is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsenameEqualTo(String value) {
            addCriterion("BrowseName =", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotEqualTo(String value) {
            addCriterion("BrowseName <>", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameGreaterThan(String value) {
            addCriterion("BrowseName >", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameGreaterThanOrEqualTo(String value) {
            addCriterion("BrowseName >=", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLessThan(String value) {
            addCriterion("BrowseName <", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLessThanOrEqualTo(String value) {
            addCriterion("BrowseName <=", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLike(String value) {
            addCriterion("BrowseName like", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotLike(String value) {
            addCriterion("BrowseName not like", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIn(List<String> values) {
            addCriterion("BrowseName in", values, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotIn(List<String> values) {
            addCriterion("BrowseName not in", values, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameBetween(String value1, String value2) {
            addCriterion("BrowseName between", value1, value2, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotBetween(String value1, String value2) {
            addCriterion("BrowseName not between", value1, value2, "browsename");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNull() {
            addCriterion("DisplayName is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNotNull() {
            addCriterion("DisplayName is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameEqualTo(String value) {
            addCriterion("DisplayName =", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotEqualTo(String value) {
            addCriterion("DisplayName <>", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThan(String value) {
            addCriterion("DisplayName >", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThanOrEqualTo(String value) {
            addCriterion("DisplayName >=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThan(String value) {
            addCriterion("DisplayName <", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThanOrEqualTo(String value) {
            addCriterion("DisplayName <=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLike(String value) {
            addCriterion("DisplayName like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotLike(String value) {
            addCriterion("DisplayName not like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIn(List<String> values) {
            addCriterion("DisplayName in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotIn(List<String> values) {
            addCriterion("DisplayName not in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameBetween(String value1, String value2) {
            addCriterion("DisplayName between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotBetween(String value1, String value2) {
            addCriterion("DisplayName not between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("Value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("Value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("Value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("Value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("Value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("Value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("Value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("Value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("Value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("Value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("Value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("Value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("Value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("Value not between", value1, value2, "value");
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

        public Criteria andParentUriIsNull() {
            addCriterion("parent_uri is null");
            return (Criteria) this;
        }

        public Criteria andParentUriIsNotNull() {
            addCriterion("parent_uri is not null");
            return (Criteria) this;
        }

        public Criteria andParentUriEqualTo(String value) {
            addCriterion("parent_uri =", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriNotEqualTo(String value) {
            addCriterion("parent_uri <>", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriGreaterThan(String value) {
            addCriterion("parent_uri >", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriGreaterThanOrEqualTo(String value) {
            addCriterion("parent_uri >=", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriLessThan(String value) {
            addCriterion("parent_uri <", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriLessThanOrEqualTo(String value) {
            addCriterion("parent_uri <=", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriLike(String value) {
            addCriterion("parent_uri like", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriNotLike(String value) {
            addCriterion("parent_uri not like", value, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriIn(List<String> values) {
            addCriterion("parent_uri in", values, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriNotIn(List<String> values) {
            addCriterion("parent_uri not in", values, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriBetween(String value1, String value2) {
            addCriterion("parent_uri between", value1, value2, "parentUri");
            return (Criteria) this;
        }

        public Criteria andParentUriNotBetween(String value1, String value2) {
            addCriterion("parent_uri not between", value1, value2, "parentUri");
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
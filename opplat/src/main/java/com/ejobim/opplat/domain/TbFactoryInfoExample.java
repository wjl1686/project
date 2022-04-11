package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbFactoryInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFactoryInfoExample() {
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

        public Criteria andFactoryNameIsNull() {
            addCriterion("factory_name is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNotNull() {
            addCriterion("factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameEqualTo(String value) {
            addCriterion("factory_name =", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotEqualTo(String value) {
            addCriterion("factory_name <>", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThan(String value) {
            addCriterion("factory_name >", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("factory_name >=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThan(String value) {
            addCriterion("factory_name <", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("factory_name <=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLike(String value) {
            addCriterion("factory_name like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotLike(String value) {
            addCriterion("factory_name not like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIn(List<String> values) {
            addCriterion("factory_name in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotIn(List<String> values) {
            addCriterion("factory_name not in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameBetween(String value1, String value2) {
            addCriterion("factory_name between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotBetween(String value1, String value2) {
            addCriterion("factory_name not between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressIsNull() {
            addCriterion("factory_address is null");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressIsNotNull() {
            addCriterion("factory_address is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressEqualTo(String value) {
            addCriterion("factory_address =", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressNotEqualTo(String value) {
            addCriterion("factory_address <>", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressGreaterThan(String value) {
            addCriterion("factory_address >", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("factory_address >=", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressLessThan(String value) {
            addCriterion("factory_address <", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressLessThanOrEqualTo(String value) {
            addCriterion("factory_address <=", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressLike(String value) {
            addCriterion("factory_address like", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressNotLike(String value) {
            addCriterion("factory_address not like", value, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressIn(List<String> values) {
            addCriterion("factory_address in", values, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressNotIn(List<String> values) {
            addCriterion("factory_address not in", values, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressBetween(String value1, String value2) {
            addCriterion("factory_address between", value1, value2, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryAddressNotBetween(String value1, String value2) {
            addCriterion("factory_address not between", value1, value2, "factoryAddress");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationIsNull() {
            addCriterion("factory_location is null");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationIsNotNull() {
            addCriterion("factory_location is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationEqualTo(String value) {
            addCriterion("factory_location =", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationNotEqualTo(String value) {
            addCriterion("factory_location <>", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationGreaterThan(String value) {
            addCriterion("factory_location >", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationGreaterThanOrEqualTo(String value) {
            addCriterion("factory_location >=", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationLessThan(String value) {
            addCriterion("factory_location <", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationLessThanOrEqualTo(String value) {
            addCriterion("factory_location <=", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationLike(String value) {
            addCriterion("factory_location like", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationNotLike(String value) {
            addCriterion("factory_location not like", value, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationIn(List<String> values) {
            addCriterion("factory_location in", values, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationNotIn(List<String> values) {
            addCriterion("factory_location not in", values, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationBetween(String value1, String value2) {
            addCriterion("factory_location between", value1, value2, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryLocationNotBetween(String value1, String value2) {
            addCriterion("factory_location not between", value1, value2, "factoryLocation");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerIsNull() {
            addCriterion("factory_manager is null");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerIsNotNull() {
            addCriterion("factory_manager is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerEqualTo(String value) {
            addCriterion("factory_manager =", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerNotEqualTo(String value) {
            addCriterion("factory_manager <>", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerGreaterThan(String value) {
            addCriterion("factory_manager >", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerGreaterThanOrEqualTo(String value) {
            addCriterion("factory_manager >=", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerLessThan(String value) {
            addCriterion("factory_manager <", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerLessThanOrEqualTo(String value) {
            addCriterion("factory_manager <=", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerLike(String value) {
            addCriterion("factory_manager like", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerNotLike(String value) {
            addCriterion("factory_manager not like", value, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerIn(List<String> values) {
            addCriterion("factory_manager in", values, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerNotIn(List<String> values) {
            addCriterion("factory_manager not in", values, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerBetween(String value1, String value2) {
            addCriterion("factory_manager between", value1, value2, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryManagerNotBetween(String value1, String value2) {
            addCriterion("factory_manager not between", value1, value2, "factoryManager");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneIsNull() {
            addCriterion("factory_telephone is null");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneIsNotNull() {
            addCriterion("factory_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneEqualTo(String value) {
            addCriterion("factory_telephone =", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneNotEqualTo(String value) {
            addCriterion("factory_telephone <>", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneGreaterThan(String value) {
            addCriterion("factory_telephone >", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("factory_telephone >=", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneLessThan(String value) {
            addCriterion("factory_telephone <", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneLessThanOrEqualTo(String value) {
            addCriterion("factory_telephone <=", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneLike(String value) {
            addCriterion("factory_telephone like", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneNotLike(String value) {
            addCriterion("factory_telephone not like", value, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneIn(List<String> values) {
            addCriterion("factory_telephone in", values, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneNotIn(List<String> values) {
            addCriterion("factory_telephone not in", values, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneBetween(String value1, String value2) {
            addCriterion("factory_telephone between", value1, value2, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryTelephoneNotBetween(String value1, String value2) {
            addCriterion("factory_telephone not between", value1, value2, "factoryTelephone");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeIsNull() {
            addCriterion("factory_describe is null");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeIsNotNull() {
            addCriterion("factory_describe is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeEqualTo(String value) {
            addCriterion("factory_describe =", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeNotEqualTo(String value) {
            addCriterion("factory_describe <>", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeGreaterThan(String value) {
            addCriterion("factory_describe >", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("factory_describe >=", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeLessThan(String value) {
            addCriterion("factory_describe <", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeLessThanOrEqualTo(String value) {
            addCriterion("factory_describe <=", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeLike(String value) {
            addCriterion("factory_describe like", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeNotLike(String value) {
            addCriterion("factory_describe not like", value, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeIn(List<String> values) {
            addCriterion("factory_describe in", values, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeNotIn(List<String> values) {
            addCriterion("factory_describe not in", values, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeBetween(String value1, String value2) {
            addCriterion("factory_describe between", value1, value2, "factoryDescribe");
            return (Criteria) this;
        }

        public Criteria andFactoryDescribeNotBetween(String value1, String value2) {
            addCriterion("factory_describe not between", value1, value2, "factoryDescribe");
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

        public Criteria andBrowsepathIsNull() {
            addCriterion("browsePath is null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIsNotNull() {
            addCriterion("browsePath is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsepathEqualTo(String value) {
            addCriterion("browsePath =", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotEqualTo(String value) {
            addCriterion("browsePath <>", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThan(String value) {
            addCriterion("browsePath >", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathGreaterThanOrEqualTo(String value) {
            addCriterion("browsePath >=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThan(String value) {
            addCriterion("browsePath <", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLessThanOrEqualTo(String value) {
            addCriterion("browsePath <=", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathLike(String value) {
            addCriterion("browsePath like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotLike(String value) {
            addCriterion("browsePath not like", value, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathIn(List<String> values) {
            addCriterion("browsePath in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotIn(List<String> values) {
            addCriterion("browsePath not in", values, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathBetween(String value1, String value2) {
            addCriterion("browsePath between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsepathNotBetween(String value1, String value2) {
            addCriterion("browsePath not between", value1, value2, "browsepath");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIsNull() {
            addCriterion("browseName is null");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIsNotNull() {
            addCriterion("browseName is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsenameEqualTo(String value) {
            addCriterion("browseName =", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotEqualTo(String value) {
            addCriterion("browseName <>", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameGreaterThan(String value) {
            addCriterion("browseName >", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameGreaterThanOrEqualTo(String value) {
            addCriterion("browseName >=", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLessThan(String value) {
            addCriterion("browseName <", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLessThanOrEqualTo(String value) {
            addCriterion("browseName <=", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameLike(String value) {
            addCriterion("browseName like", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotLike(String value) {
            addCriterion("browseName not like", value, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameIn(List<String> values) {
            addCriterion("browseName in", values, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotIn(List<String> values) {
            addCriterion("browseName not in", values, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameBetween(String value1, String value2) {
            addCriterion("browseName between", value1, value2, "browsename");
            return (Criteria) this;
        }

        public Criteria andBrowsenameNotBetween(String value1, String value2) {
            addCriterion("browseName not between", value1, value2, "browsename");
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

        public Criteria andFactorySerialNoIsNull() {
            addCriterion("factory_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoIsNotNull() {
            addCriterion("factory_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoEqualTo(String value) {
            addCriterion("factory_serial_no =", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoNotEqualTo(String value) {
            addCriterion("factory_serial_no <>", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoGreaterThan(String value) {
            addCriterion("factory_serial_no >", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("factory_serial_no >=", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoLessThan(String value) {
            addCriterion("factory_serial_no <", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoLessThanOrEqualTo(String value) {
            addCriterion("factory_serial_no <=", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoLike(String value) {
            addCriterion("factory_serial_no like", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoNotLike(String value) {
            addCriterion("factory_serial_no not like", value, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoIn(List<String> values) {
            addCriterion("factory_serial_no in", values, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoNotIn(List<String> values) {
            addCriterion("factory_serial_no not in", values, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoBetween(String value1, String value2) {
            addCriterion("factory_serial_no between", value1, value2, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andFactorySerialNoNotBetween(String value1, String value2) {
            addCriterion("factory_serial_no not between", value1, value2, "factorySerialNo");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationIsNull() {
            addCriterion("operate_abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationIsNotNull() {
            addCriterion("operate_abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationEqualTo(String value) {
            addCriterion("operate_abbreviation =", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationNotEqualTo(String value) {
            addCriterion("operate_abbreviation <>", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationGreaterThan(String value) {
            addCriterion("operate_abbreviation >", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("operate_abbreviation >=", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationLessThan(String value) {
            addCriterion("operate_abbreviation <", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("operate_abbreviation <=", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationLike(String value) {
            addCriterion("operate_abbreviation like", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationNotLike(String value) {
            addCriterion("operate_abbreviation not like", value, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationIn(List<String> values) {
            addCriterion("operate_abbreviation in", values, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationNotIn(List<String> values) {
            addCriterion("operate_abbreviation not in", values, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationBetween(String value1, String value2) {
            addCriterion("operate_abbreviation between", value1, value2, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateAbbreviationNotBetween(String value1, String value2) {
            addCriterion("operate_abbreviation not between", value1, value2, "operateAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameIsNull() {
            addCriterion("operate_company_name is null");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameIsNotNull() {
            addCriterion("operate_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameEqualTo(String value) {
            addCriterion("operate_company_name =", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameNotEqualTo(String value) {
            addCriterion("operate_company_name <>", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameGreaterThan(String value) {
            addCriterion("operate_company_name >", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("operate_company_name >=", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameLessThan(String value) {
            addCriterion("operate_company_name <", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("operate_company_name <=", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameLike(String value) {
            addCriterion("operate_company_name like", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameNotLike(String value) {
            addCriterion("operate_company_name not like", value, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameIn(List<String> values) {
            addCriterion("operate_company_name in", values, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameNotIn(List<String> values) {
            addCriterion("operate_company_name not in", values, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameBetween(String value1, String value2) {
            addCriterion("operate_company_name between", value1, value2, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andOperateCompanyNameNotBetween(String value1, String value2) {
            addCriterion("operate_company_name not between", value1, value2, "operateCompanyName");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Integer value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Integer value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Integer value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Integer value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Integer> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Integer> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNull() {
            addCriterion("project_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIsNotNull() {
            addCriterion("project_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAddressEqualTo(String value) {
            addCriterion("project_address =", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotEqualTo(String value) {
            addCriterion("project_address <>", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThan(String value) {
            addCriterion("project_address >", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_address >=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThan(String value) {
            addCriterion("project_address <", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLessThanOrEqualTo(String value) {
            addCriterion("project_address <=", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressLike(String value) {
            addCriterion("project_address like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotLike(String value) {
            addCriterion("project_address not like", value, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressIn(List<String> values) {
            addCriterion("project_address in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotIn(List<String> values) {
            addCriterion("project_address not in", values, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressBetween(String value1, String value2) {
            addCriterion("project_address between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andProjectAddressNotBetween(String value1, String value2) {
            addCriterion("project_address not between", value1, value2, "projectAddress");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(Integer value) {
            addCriterion("operate_type =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(Integer value) {
            addCriterion("operate_type <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(Integer value) {
            addCriterion("operate_type >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_type >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(Integer value) {
            addCriterion("operate_type <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operate_type <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<Integer> values) {
            addCriterion("operate_type in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<Integer> values) {
            addCriterion("operate_type not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(Integer value1, Integer value2) {
            addCriterion("operate_type between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_type not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIsNull() {
            addCriterion("business_start_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIsNotNull() {
            addCriterion("business_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_time =", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_time <>", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("business_start_time >", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_time >=", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("business_start_time <", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_start_time <=", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("business_start_time in", values, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("business_start_time not in", values, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_start_time between", value1, value2, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_start_time not between", value1, value2, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeIsNull() {
            addCriterion("project_exit_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeIsNotNull() {
            addCriterion("project_exit_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeEqualTo(Date value) {
            addCriterionForJDBCDate("project_exit_time =", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("project_exit_time <>", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("project_exit_time >", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_exit_time >=", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeLessThan(Date value) {
            addCriterionForJDBCDate("project_exit_time <", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_exit_time <=", value, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeIn(List<Date> values) {
            addCriterionForJDBCDate("project_exit_time in", values, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("project_exit_time not in", values, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_exit_time between", value1, value2, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andProjectExitTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_exit_time not between", value1, value2, "projectExitTime");
            return (Criteria) this;
        }

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("item like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("item not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("item not between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andDescripionIsNull() {
            addCriterion("descripion is null");
            return (Criteria) this;
        }

        public Criteria andDescripionIsNotNull() {
            addCriterion("descripion is not null");
            return (Criteria) this;
        }

        public Criteria andDescripionEqualTo(String value) {
            addCriterion("descripion =", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionNotEqualTo(String value) {
            addCriterion("descripion <>", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionGreaterThan(String value) {
            addCriterion("descripion >", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionGreaterThanOrEqualTo(String value) {
            addCriterion("descripion >=", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionLessThan(String value) {
            addCriterion("descripion <", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionLessThanOrEqualTo(String value) {
            addCriterion("descripion <=", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionLike(String value) {
            addCriterion("descripion like", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionNotLike(String value) {
            addCriterion("descripion not like", value, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionIn(List<String> values) {
            addCriterion("descripion in", values, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionNotIn(List<String> values) {
            addCriterion("descripion not in", values, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionBetween(String value1, String value2) {
            addCriterion("descripion between", value1, value2, "descripion");
            return (Criteria) this;
        }

        public Criteria andDescripionNotBetween(String value1, String value2) {
            addCriterion("descripion not between", value1, value2, "descripion");
            return (Criteria) this;
        }

        public Criteria andSortindexIsNull() {
            addCriterion("sortindex is null");
            return (Criteria) this;
        }

        public Criteria andSortindexIsNotNull() {
            addCriterion("sortindex is not null");
            return (Criteria) this;
        }

        public Criteria andSortindexEqualTo(Integer value) {
            addCriterion("sortindex =", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexNotEqualTo(Integer value) {
            addCriterion("sortindex <>", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexGreaterThan(Integer value) {
            addCriterion("sortindex >", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortindex >=", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexLessThan(Integer value) {
            addCriterion("sortindex <", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexLessThanOrEqualTo(Integer value) {
            addCriterion("sortindex <=", value, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexIn(List<Integer> values) {
            addCriterion("sortindex in", values, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexNotIn(List<Integer> values) {
            addCriterion("sortindex not in", values, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexBetween(Integer value1, Integer value2) {
            addCriterion("sortindex between", value1, value2, "sortindex");
            return (Criteria) this;
        }

        public Criteria andSortindexNotBetween(Integer value1, Integer value2) {
            addCriterion("sortindex not between", value1, value2, "sortindex");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeIsNull() {
            addCriterion("factory_code is null");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeIsNotNull() {
            addCriterion("factory_code is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeEqualTo(String value) {
            addCriterion("factory_code =", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeNotEqualTo(String value) {
            addCriterion("factory_code <>", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeGreaterThan(String value) {
            addCriterion("factory_code >", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("factory_code >=", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeLessThan(String value) {
            addCriterion("factory_code <", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeLessThanOrEqualTo(String value) {
            addCriterion("factory_code <=", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeLike(String value) {
            addCriterion("factory_code like", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeNotLike(String value) {
            addCriterion("factory_code not like", value, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeIn(List<String> values) {
            addCriterion("factory_code in", values, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeNotIn(List<String> values) {
            addCriterion("factory_code not in", values, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeBetween(String value1, String value2) {
            addCriterion("factory_code between", value1, value2, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andFactoryCodeNotBetween(String value1, String value2) {
            addCriterion("factory_code not between", value1, value2, "factoryCode");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andFactoryMapIsNull() {
            addCriterion("factory_map is null");
            return (Criteria) this;
        }

        public Criteria andFactoryMapIsNotNull() {
            addCriterion("factory_map is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryMapEqualTo(String value) {
            addCriterion("factory_map =", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapNotEqualTo(String value) {
            addCriterion("factory_map <>", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapGreaterThan(String value) {
            addCriterion("factory_map >", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapGreaterThanOrEqualTo(String value) {
            addCriterion("factory_map >=", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapLessThan(String value) {
            addCriterion("factory_map <", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapLessThanOrEqualTo(String value) {
            addCriterion("factory_map <=", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapLike(String value) {
            addCriterion("factory_map like", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapNotLike(String value) {
            addCriterion("factory_map not like", value, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapIn(List<String> values) {
            addCriterion("factory_map in", values, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapNotIn(List<String> values) {
            addCriterion("factory_map not in", values, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapBetween(String value1, String value2) {
            addCriterion("factory_map between", value1, value2, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andFactoryMapNotBetween(String value1, String value2) {
            addCriterion("factory_map not between", value1, value2, "factoryMap");
            return (Criteria) this;
        }

        public Criteria andCenterUrlIsNull() {
            addCriterion("center_url is null");
            return (Criteria) this;
        }

        public Criteria andCenterUrlIsNotNull() {
            addCriterion("center_url is not null");
            return (Criteria) this;
        }

        public Criteria andCenterUrlEqualTo(String value) {
            addCriterion("center_url =", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlNotEqualTo(String value) {
            addCriterion("center_url <>", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlGreaterThan(String value) {
            addCriterion("center_url >", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlGreaterThanOrEqualTo(String value) {
            addCriterion("center_url >=", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlLessThan(String value) {
            addCriterion("center_url <", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlLessThanOrEqualTo(String value) {
            addCriterion("center_url <=", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlLike(String value) {
            addCriterion("center_url like", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlNotLike(String value) {
            addCriterion("center_url not like", value, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlIn(List<String> values) {
            addCriterion("center_url in", values, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlNotIn(List<String> values) {
            addCriterion("center_url not in", values, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlBetween(String value1, String value2) {
            addCriterion("center_url between", value1, value2, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andCenterUrlNotBetween(String value1, String value2) {
            addCriterion("center_url not between", value1, value2, "centerUrl");
            return (Criteria) this;
        }

        public Criteria andIssueNoIsNull() {
            addCriterion("issue_no is null");
            return (Criteria) this;
        }

        public Criteria andIssueNoIsNotNull() {
            addCriterion("issue_no is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNoEqualTo(Integer value) {
            addCriterion("issue_no =", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotEqualTo(Integer value) {
            addCriterion("issue_no <>", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThan(Integer value) {
            addCriterion("issue_no >", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_no >=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThan(Integer value) {
            addCriterion("issue_no <", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThanOrEqualTo(Integer value) {
            addCriterion("issue_no <=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoIn(List<Integer> values) {
            addCriterion("issue_no in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotIn(List<Integer> values) {
            addCriterion("issue_no not in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoBetween(Integer value1, Integer value2) {
            addCriterion("issue_no between", value1, value2, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_no not between", value1, value2, "issueNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoIsNull() {
            addCriterion("parent_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoIsNotNull() {
            addCriterion("parent_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoEqualTo(String value) {
            addCriterion("parent_factory_no =", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoNotEqualTo(String value) {
            addCriterion("parent_factory_no <>", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoGreaterThan(String value) {
            addCriterion("parent_factory_no >", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_factory_no >=", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoLessThan(String value) {
            addCriterion("parent_factory_no <", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("parent_factory_no <=", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoLike(String value) {
            addCriterion("parent_factory_no like", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoNotLike(String value) {
            addCriterion("parent_factory_no not like", value, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoIn(List<String> values) {
            addCriterion("parent_factory_no in", values, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoNotIn(List<String> values) {
            addCriterion("parent_factory_no not in", values, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoBetween(String value1, String value2) {
            addCriterion("parent_factory_no between", value1, value2, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andParentFactoryNoNotBetween(String value1, String value2) {
            addCriterion("parent_factory_no not between", value1, value2, "parentFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoIsNull() {
            addCriterion("org_group_no is null");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoIsNotNull() {
            addCriterion("org_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoEqualTo(String value) {
            addCriterion("org_group_no =", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoNotEqualTo(String value) {
            addCriterion("org_group_no <>", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoGreaterThan(String value) {
            addCriterion("org_group_no >", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("org_group_no >=", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoLessThan(String value) {
            addCriterion("org_group_no <", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoLessThanOrEqualTo(String value) {
            addCriterion("org_group_no <=", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoLike(String value) {
            addCriterion("org_group_no like", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoNotLike(String value) {
            addCriterion("org_group_no not like", value, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoIn(List<String> values) {
            addCriterion("org_group_no in", values, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoNotIn(List<String> values) {
            addCriterion("org_group_no not in", values, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoBetween(String value1, String value2) {
            addCriterion("org_group_no between", value1, value2, "orgGroupNo");
            return (Criteria) this;
        }

        public Criteria andOrgGroupNoNotBetween(String value1, String value2) {
            addCriterion("org_group_no not between", value1, value2, "orgGroupNo");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbReportModelExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReportModelExtendExample() {
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

        public Criteria andExtendRmNoIsNull() {
            addCriterion("extend_rm_no is null");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoIsNotNull() {
            addCriterion("extend_rm_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoEqualTo(String value) {
            addCriterion("extend_rm_no =", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoNotEqualTo(String value) {
            addCriterion("extend_rm_no <>", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoGreaterThan(String value) {
            addCriterion("extend_rm_no >", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_rm_no >=", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoLessThan(String value) {
            addCriterion("extend_rm_no <", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoLessThanOrEqualTo(String value) {
            addCriterion("extend_rm_no <=", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoLike(String value) {
            addCriterion("extend_rm_no like", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoNotLike(String value) {
            addCriterion("extend_rm_no not like", value, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoIn(List<String> values) {
            addCriterion("extend_rm_no in", values, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoNotIn(List<String> values) {
            addCriterion("extend_rm_no not in", values, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoBetween(String value1, String value2) {
            addCriterion("extend_rm_no between", value1, value2, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendRmNoNotBetween(String value1, String value2) {
            addCriterion("extend_rm_no not between", value1, value2, "extendRmNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoIsNull() {
            addCriterion("extend_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoIsNotNull() {
            addCriterion("extend_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoEqualTo(String value) {
            addCriterion("extend_factory_no =", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoNotEqualTo(String value) {
            addCriterion("extend_factory_no <>", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoGreaterThan(String value) {
            addCriterion("extend_factory_no >", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_factory_no >=", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoLessThan(String value) {
            addCriterion("extend_factory_no <", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("extend_factory_no <=", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoLike(String value) {
            addCriterion("extend_factory_no like", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoNotLike(String value) {
            addCriterion("extend_factory_no not like", value, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoIn(List<String> values) {
            addCriterion("extend_factory_no in", values, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoNotIn(List<String> values) {
            addCriterion("extend_factory_no not in", values, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoBetween(String value1, String value2) {
            addCriterion("extend_factory_no between", value1, value2, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andExtendFactoryNoNotBetween(String value1, String value2) {
            addCriterion("extend_factory_no not between", value1, value2, "extendFactoryNo");
            return (Criteria) this;
        }

        public Criteria andSubIndexIsNull() {
            addCriterion("sub_index is null");
            return (Criteria) this;
        }

        public Criteria andSubIndexIsNotNull() {
            addCriterion("sub_index is not null");
            return (Criteria) this;
        }

        public Criteria andSubIndexEqualTo(Integer value) {
            addCriterion("sub_index =", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotEqualTo(Integer value) {
            addCriterion("sub_index <>", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexGreaterThan(Integer value) {
            addCriterion("sub_index >", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_index >=", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexLessThan(Integer value) {
            addCriterion("sub_index <", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexLessThanOrEqualTo(Integer value) {
            addCriterion("sub_index <=", value, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexIn(List<Integer> values) {
            addCriterion("sub_index in", values, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotIn(List<Integer> values) {
            addCriterion("sub_index not in", values, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexBetween(Integer value1, Integer value2) {
            addCriterion("sub_index between", value1, value2, "subIndex");
            return (Criteria) this;
        }

        public Criteria andSubIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_index not between", value1, value2, "subIndex");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIsNull() {
            addCriterion("extend_math_type is null");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIsNotNull() {
            addCriterion("extend_math_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeEqualTo(Integer value) {
            addCriterion("extend_math_type =", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotEqualTo(Integer value) {
            addCriterion("extend_math_type <>", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeGreaterThan(Integer value) {
            addCriterion("extend_math_type >", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_math_type >=", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeLessThan(Integer value) {
            addCriterion("extend_math_type <", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeLessThanOrEqualTo(Integer value) {
            addCriterion("extend_math_type <=", value, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeIn(List<Integer> values) {
            addCriterion("extend_math_type in", values, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotIn(List<Integer> values) {
            addCriterion("extend_math_type not in", values, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeBetween(Integer value1, Integer value2) {
            addCriterion("extend_math_type between", value1, value2, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendMathTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_math_type not between", value1, value2, "extendMathType");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameIsNull() {
            addCriterion("extend_browse_name is null");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameIsNotNull() {
            addCriterion("extend_browse_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameEqualTo(String value) {
            addCriterion("extend_browse_name =", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameNotEqualTo(String value) {
            addCriterion("extend_browse_name <>", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameGreaterThan(String value) {
            addCriterion("extend_browse_name >", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameGreaterThanOrEqualTo(String value) {
            addCriterion("extend_browse_name >=", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameLessThan(String value) {
            addCriterion("extend_browse_name <", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameLessThanOrEqualTo(String value) {
            addCriterion("extend_browse_name <=", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameLike(String value) {
            addCriterion("extend_browse_name like", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameNotLike(String value) {
            addCriterion("extend_browse_name not like", value, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameIn(List<String> values) {
            addCriterion("extend_browse_name in", values, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameNotIn(List<String> values) {
            addCriterion("extend_browse_name not in", values, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameBetween(String value1, String value2) {
            addCriterion("extend_browse_name between", value1, value2, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendBrowseNameNotBetween(String value1, String value2) {
            addCriterion("extend_browse_name not between", value1, value2, "extendBrowseName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameIsNull() {
            addCriterion("extend_field_name is null");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameIsNotNull() {
            addCriterion("extend_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameEqualTo(String value) {
            addCriterion("extend_field_name =", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameNotEqualTo(String value) {
            addCriterion("extend_field_name <>", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameGreaterThan(String value) {
            addCriterion("extend_field_name >", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_name >=", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameLessThan(String value) {
            addCriterion("extend_field_name <", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameLessThanOrEqualTo(String value) {
            addCriterion("extend_field_name <=", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameLike(String value) {
            addCriterion("extend_field_name like", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameNotLike(String value) {
            addCriterion("extend_field_name not like", value, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameIn(List<String> values) {
            addCriterion("extend_field_name in", values, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameNotIn(List<String> values) {
            addCriterion("extend_field_name not in", values, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameBetween(String value1, String value2) {
            addCriterion("extend_field_name between", value1, value2, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendFieldNameNotBetween(String value1, String value2) {
            addCriterion("extend_field_name not between", value1, value2, "extendFieldName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameIsNull() {
            addCriterion("extend_column_name is null");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameIsNotNull() {
            addCriterion("extend_column_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameEqualTo(String value) {
            addCriterion("extend_column_name =", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameNotEqualTo(String value) {
            addCriterion("extend_column_name <>", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameGreaterThan(String value) {
            addCriterion("extend_column_name >", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("extend_column_name >=", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameLessThan(String value) {
            addCriterion("extend_column_name <", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameLessThanOrEqualTo(String value) {
            addCriterion("extend_column_name <=", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameLike(String value) {
            addCriterion("extend_column_name like", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameNotLike(String value) {
            addCriterion("extend_column_name not like", value, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameIn(List<String> values) {
            addCriterion("extend_column_name in", values, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameNotIn(List<String> values) {
            addCriterion("extend_column_name not in", values, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameBetween(String value1, String value2) {
            addCriterion("extend_column_name between", value1, value2, "extendColumnName");
            return (Criteria) this;
        }

        public Criteria andExtendColumnNameNotBetween(String value1, String value2) {
            addCriterion("extend_column_name not between", value1, value2, "extendColumnName");
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

        public Criteria andExtendColumnIndexIsNull() {
            addCriterion("extend_column_index is null");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexIsNotNull() {
            addCriterion("extend_column_index is not null");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexEqualTo(Integer value) {
            addCriterion("extend_column_index =", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexNotEqualTo(Integer value) {
            addCriterion("extend_column_index <>", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexGreaterThan(Integer value) {
            addCriterion("extend_column_index >", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_column_index >=", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexLessThan(Integer value) {
            addCriterion("extend_column_index <", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexLessThanOrEqualTo(Integer value) {
            addCriterion("extend_column_index <=", value, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexIn(List<Integer> values) {
            addCriterion("extend_column_index in", values, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexNotIn(List<Integer> values) {
            addCriterion("extend_column_index not in", values, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexBetween(Integer value1, Integer value2) {
            addCriterion("extend_column_index between", value1, value2, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendColumnIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_column_index not between", value1, value2, "extendColumnIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexIsNull() {
            addCriterion("extend_row_index is null");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexIsNotNull() {
            addCriterion("extend_row_index is not null");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexEqualTo(Integer value) {
            addCriterion("extend_row_index =", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexNotEqualTo(Integer value) {
            addCriterion("extend_row_index <>", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexGreaterThan(Integer value) {
            addCriterion("extend_row_index >", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_row_index >=", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexLessThan(Integer value) {
            addCriterion("extend_row_index <", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("extend_row_index <=", value, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexIn(List<Integer> values) {
            addCriterion("extend_row_index in", values, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexNotIn(List<Integer> values) {
            addCriterion("extend_row_index not in", values, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexBetween(Integer value1, Integer value2) {
            addCriterion("extend_row_index between", value1, value2, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendRowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_row_index not between", value1, value2, "extendRowIndex");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthIsNull() {
            addCriterion("extend_cell_width is null");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthIsNotNull() {
            addCriterion("extend_cell_width is not null");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthEqualTo(Integer value) {
            addCriterion("extend_cell_width =", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthNotEqualTo(Integer value) {
            addCriterion("extend_cell_width <>", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthGreaterThan(Integer value) {
            addCriterion("extend_cell_width >", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_cell_width >=", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthLessThan(Integer value) {
            addCriterion("extend_cell_width <", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthLessThanOrEqualTo(Integer value) {
            addCriterion("extend_cell_width <=", value, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthIn(List<Integer> values) {
            addCriterion("extend_cell_width in", values, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthNotIn(List<Integer> values) {
            addCriterion("extend_cell_width not in", values, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthBetween(Integer value1, Integer value2) {
            addCriterion("extend_cell_width between", value1, value2, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_cell_width not between", value1, value2, "extendCellWidth");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightIsNull() {
            addCriterion("extend_cell_height is null");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightIsNotNull() {
            addCriterion("extend_cell_height is not null");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightEqualTo(Integer value) {
            addCriterion("extend_cell_height =", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightNotEqualTo(Integer value) {
            addCriterion("extend_cell_height <>", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightGreaterThan(Integer value) {
            addCriterion("extend_cell_height >", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("extend_cell_height >=", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightLessThan(Integer value) {
            addCriterion("extend_cell_height <", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightLessThanOrEqualTo(Integer value) {
            addCriterion("extend_cell_height <=", value, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightIn(List<Integer> values) {
            addCriterion("extend_cell_height in", values, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightNotIn(List<Integer> values) {
            addCriterion("extend_cell_height not in", values, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightBetween(Integer value1, Integer value2) {
            addCriterion("extend_cell_height between", value1, value2, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCellHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("extend_cell_height not between", value1, value2, "extendCellHeight");
            return (Criteria) this;
        }

        public Criteria andExtendCodeIsNull() {
            addCriterion("extend_code is null");
            return (Criteria) this;
        }

        public Criteria andExtendCodeIsNotNull() {
            addCriterion("extend_code is not null");
            return (Criteria) this;
        }

        public Criteria andExtendCodeEqualTo(String value) {
            addCriterion("extend_code =", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeNotEqualTo(String value) {
            addCriterion("extend_code <>", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeGreaterThan(String value) {
            addCriterion("extend_code >", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeGreaterThanOrEqualTo(String value) {
            addCriterion("extend_code >=", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeLessThan(String value) {
            addCriterion("extend_code <", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeLessThanOrEqualTo(String value) {
            addCriterion("extend_code <=", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeLike(String value) {
            addCriterion("extend_code like", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeNotLike(String value) {
            addCriterion("extend_code not like", value, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeIn(List<String> values) {
            addCriterion("extend_code in", values, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeNotIn(List<String> values) {
            addCriterion("extend_code not in", values, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeBetween(String value1, String value2) {
            addCriterion("extend_code between", value1, value2, "extendCode");
            return (Criteria) this;
        }

        public Criteria andExtendCodeNotBetween(String value1, String value2) {
            addCriterion("extend_code not between", value1, value2, "extendCode");
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
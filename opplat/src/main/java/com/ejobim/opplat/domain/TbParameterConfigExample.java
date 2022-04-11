package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParameterConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParameterConfigExample() {
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

        public Criteria andParamNoIsNull() {
            addCriterion("param_no is null");
            return (Criteria) this;
        }

        public Criteria andParamNoIsNotNull() {
            addCriterion("param_no is not null");
            return (Criteria) this;
        }

        public Criteria andParamNoEqualTo(String value) {
            addCriterion("param_no =", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotEqualTo(String value) {
            addCriterion("param_no <>", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoGreaterThan(String value) {
            addCriterion("param_no >", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoGreaterThanOrEqualTo(String value) {
            addCriterion("param_no >=", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLessThan(String value) {
            addCriterion("param_no <", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLessThanOrEqualTo(String value) {
            addCriterion("param_no <=", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoLike(String value) {
            addCriterion("param_no like", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotLike(String value) {
            addCriterion("param_no not like", value, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoIn(List<String> values) {
            addCriterion("param_no in", values, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotIn(List<String> values) {
            addCriterion("param_no not in", values, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoBetween(String value1, String value2) {
            addCriterion("param_no between", value1, value2, "paramNo");
            return (Criteria) this;
        }

        public Criteria andParamNoNotBetween(String value1, String value2) {
            addCriterion("param_no not between", value1, value2, "paramNo");
            return (Criteria) this;
        }

        public Criteria andFillRateIsNull() {
            addCriterion("fill_rate is null");
            return (Criteria) this;
        }

        public Criteria andFillRateIsNotNull() {
            addCriterion("fill_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFillRateEqualTo(Integer value) {
            addCriterion("fill_rate =", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateNotEqualTo(Integer value) {
            addCriterion("fill_rate <>", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateGreaterThan(Integer value) {
            addCriterion("fill_rate >", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_rate >=", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateLessThan(Integer value) {
            addCriterion("fill_rate <", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateLessThanOrEqualTo(Integer value) {
            addCriterion("fill_rate <=", value, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateIn(List<Integer> values) {
            addCriterion("fill_rate in", values, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateNotIn(List<Integer> values) {
            addCriterion("fill_rate not in", values, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateBetween(Integer value1, Integer value2) {
            addCriterion("fill_rate between", value1, value2, "fillRate");
            return (Criteria) this;
        }

        public Criteria andFillRateNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_rate not between", value1, value2, "fillRate");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNull() {
            addCriterion("param_type is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("param_type is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(Integer value) {
            addCriterion("param_type =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(Integer value) {
            addCriterion("param_type <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(Integer value) {
            addCriterion("param_type >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("param_type >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(Integer value) {
            addCriterion("param_type <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(Integer value) {
            addCriterion("param_type <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<Integer> values) {
            addCriterion("param_type in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<Integer> values) {
            addCriterion("param_type not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(Integer value1, Integer value2) {
            addCriterion("param_type between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("param_type not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("param_name is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("param_name is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("param_name =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("param_name <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("param_name >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("param_name >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("param_name <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("param_name <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("param_name like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("param_name not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("param_name in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("param_name not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("param_name between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("param_name not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNull() {
            addCriterion("param_code is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("param_code is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("param_code =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("param_code <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("param_code >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("param_code >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("param_code <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("param_code <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("param_code like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("param_code not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("param_code in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("param_code not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("param_code between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("param_code not between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamUnitIsNull() {
            addCriterion("param_unit is null");
            return (Criteria) this;
        }

        public Criteria andParamUnitIsNotNull() {
            addCriterion("param_unit is not null");
            return (Criteria) this;
        }

        public Criteria andParamUnitEqualTo(String value) {
            addCriterion("param_unit =", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitNotEqualTo(String value) {
            addCriterion("param_unit <>", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitGreaterThan(String value) {
            addCriterion("param_unit >", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitGreaterThanOrEqualTo(String value) {
            addCriterion("param_unit >=", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitLessThan(String value) {
            addCriterion("param_unit <", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitLessThanOrEqualTo(String value) {
            addCriterion("param_unit <=", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitLike(String value) {
            addCriterion("param_unit like", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitNotLike(String value) {
            addCriterion("param_unit not like", value, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitIn(List<String> values) {
            addCriterion("param_unit in", values, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitNotIn(List<String> values) {
            addCriterion("param_unit not in", values, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitBetween(String value1, String value2) {
            addCriterion("param_unit between", value1, value2, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamUnitNotBetween(String value1, String value2) {
            addCriterion("param_unit not between", value1, value2, "paramUnit");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeIsNull() {
            addCriterion("param_fill_type is null");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeIsNotNull() {
            addCriterion("param_fill_type is not null");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeEqualTo(Integer value) {
            addCriterion("param_fill_type =", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeNotEqualTo(Integer value) {
            addCriterion("param_fill_type <>", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeGreaterThan(Integer value) {
            addCriterion("param_fill_type >", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("param_fill_type >=", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeLessThan(Integer value) {
            addCriterion("param_fill_type <", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeLessThanOrEqualTo(Integer value) {
            addCriterion("param_fill_type <=", value, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeIn(List<Integer> values) {
            addCriterion("param_fill_type in", values, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeNotIn(List<Integer> values) {
            addCriterion("param_fill_type not in", values, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeBetween(Integer value1, Integer value2) {
            addCriterion("param_fill_type between", value1, value2, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParamFillTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("param_fill_type not between", value1, value2, "paramFillType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeIsNull() {
            addCriterion("parem_math_type is null");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeIsNotNull() {
            addCriterion("parem_math_type is not null");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeEqualTo(Integer value) {
            addCriterion("parem_math_type =", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeNotEqualTo(Integer value) {
            addCriterion("parem_math_type <>", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeGreaterThan(Integer value) {
            addCriterion("parem_math_type >", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("parem_math_type >=", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeLessThan(Integer value) {
            addCriterion("parem_math_type <", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeLessThanOrEqualTo(Integer value) {
            addCriterion("parem_math_type <=", value, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeIn(List<Integer> values) {
            addCriterion("parem_math_type in", values, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeNotIn(List<Integer> values) {
            addCriterion("parem_math_type not in", values, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeBetween(Integer value1, Integer value2) {
            addCriterion("parem_math_type between", value1, value2, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParemMathTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("parem_math_type not between", value1, value2, "paremMathType");
            return (Criteria) this;
        }

        public Criteria andParamFromIsNull() {
            addCriterion("param_from is null");
            return (Criteria) this;
        }

        public Criteria andParamFromIsNotNull() {
            addCriterion("param_from is not null");
            return (Criteria) this;
        }

        public Criteria andParamFromEqualTo(Integer value) {
            addCriterion("param_from =", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromNotEqualTo(Integer value) {
            addCriterion("param_from <>", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromGreaterThan(Integer value) {
            addCriterion("param_from >", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("param_from >=", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromLessThan(Integer value) {
            addCriterion("param_from <", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromLessThanOrEqualTo(Integer value) {
            addCriterion("param_from <=", value, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromIn(List<Integer> values) {
            addCriterion("param_from in", values, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromNotIn(List<Integer> values) {
            addCriterion("param_from not in", values, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromBetween(Integer value1, Integer value2) {
            addCriterion("param_from between", value1, value2, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andParamFromNotBetween(Integer value1, Integer value2) {
            addCriterion("param_from not between", value1, value2, "paramFrom");
            return (Criteria) this;
        }

        public Criteria andBrowseNameIsNull() {
            addCriterion("browse_name is null");
            return (Criteria) this;
        }

        public Criteria andBrowseNameIsNotNull() {
            addCriterion("browse_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseNameEqualTo(String value) {
            addCriterion("browse_name =", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameNotEqualTo(String value) {
            addCriterion("browse_name <>", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameGreaterThan(String value) {
            addCriterion("browse_name >", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameGreaterThanOrEqualTo(String value) {
            addCriterion("browse_name >=", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameLessThan(String value) {
            addCriterion("browse_name <", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameLessThanOrEqualTo(String value) {
            addCriterion("browse_name <=", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameLike(String value) {
            addCriterion("browse_name like", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameNotLike(String value) {
            addCriterion("browse_name not like", value, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameIn(List<String> values) {
            addCriterion("browse_name in", values, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameNotIn(List<String> values) {
            addCriterion("browse_name not in", values, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameBetween(String value1, String value2) {
            addCriterion("browse_name between", value1, value2, "browseName");
            return (Criteria) this;
        }

        public Criteria andBrowseNameNotBetween(String value1, String value2) {
            addCriterion("browse_name not between", value1, value2, "browseName");
            return (Criteria) this;
        }

        public Criteria andParamModelIsNull() {
            addCriterion("param_model is null");
            return (Criteria) this;
        }

        public Criteria andParamModelIsNotNull() {
            addCriterion("param_model is not null");
            return (Criteria) this;
        }

        public Criteria andParamModelEqualTo(Integer value) {
            addCriterion("param_model =", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelNotEqualTo(Integer value) {
            addCriterion("param_model <>", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelGreaterThan(Integer value) {
            addCriterion("param_model >", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("param_model >=", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelLessThan(Integer value) {
            addCriterion("param_model <", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelLessThanOrEqualTo(Integer value) {
            addCriterion("param_model <=", value, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelIn(List<Integer> values) {
            addCriterion("param_model in", values, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelNotIn(List<Integer> values) {
            addCriterion("param_model not in", values, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelBetween(Integer value1, Integer value2) {
            addCriterion("param_model between", value1, value2, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamModelNotBetween(Integer value1, Integer value2) {
            addCriterion("param_model not between", value1, value2, "paramModel");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdIsNull() {
            addCriterion("param_math_cmd is null");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdIsNotNull() {
            addCriterion("param_math_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdEqualTo(String value) {
            addCriterion("param_math_cmd =", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdNotEqualTo(String value) {
            addCriterion("param_math_cmd <>", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdGreaterThan(String value) {
            addCriterion("param_math_cmd >", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdGreaterThanOrEqualTo(String value) {
            addCriterion("param_math_cmd >=", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdLessThan(String value) {
            addCriterion("param_math_cmd <", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdLessThanOrEqualTo(String value) {
            addCriterion("param_math_cmd <=", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdLike(String value) {
            addCriterion("param_math_cmd like", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdNotLike(String value) {
            addCriterion("param_math_cmd not like", value, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdIn(List<String> values) {
            addCriterion("param_math_cmd in", values, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdNotIn(List<String> values) {
            addCriterion("param_math_cmd not in", values, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdBetween(String value1, String value2) {
            addCriterion("param_math_cmd between", value1, value2, "paramMathCmd");
            return (Criteria) this;
        }

        public Criteria andParamMathCmdNotBetween(String value1, String value2) {
            addCriterion("param_math_cmd not between", value1, value2, "paramMathCmd");
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

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
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
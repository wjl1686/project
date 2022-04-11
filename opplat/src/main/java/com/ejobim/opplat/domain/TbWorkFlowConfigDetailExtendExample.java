package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbWorkFlowConfigDetailExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkFlowConfigDetailExtendExample() {
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

        public Criteria andNodeExtendNoIsNull() {
            addCriterion("node_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoIsNotNull() {
            addCriterion("node_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoEqualTo(String value) {
            addCriterion("node_extend_no =", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoNotEqualTo(String value) {
            addCriterion("node_extend_no <>", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoGreaterThan(String value) {
            addCriterion("node_extend_no >", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("node_extend_no >=", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoLessThan(String value) {
            addCriterion("node_extend_no <", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoLessThanOrEqualTo(String value) {
            addCriterion("node_extend_no <=", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoLike(String value) {
            addCriterion("node_extend_no like", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoNotLike(String value) {
            addCriterion("node_extend_no not like", value, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoIn(List<String> values) {
            addCriterion("node_extend_no in", values, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoNotIn(List<String> values) {
            addCriterion("node_extend_no not in", values, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoBetween(String value1, String value2) {
            addCriterion("node_extend_no between", value1, value2, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeExtendNoNotBetween(String value1, String value2) {
            addCriterion("node_extend_no not between", value1, value2, "nodeExtendNo");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNull() {
            addCriterion("node_code is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("node_code is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("node_code =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("node_code <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("node_code >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("node_code >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("node_code <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("node_code <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("node_code like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("node_code not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("node_code in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("node_code not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("node_code between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("node_code not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNull() {
            addCriterion("field_type is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIsNotNull() {
            addCriterion("field_type is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeEqualTo(Integer value) {
            addCriterion("field_type =", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotEqualTo(Integer value) {
            addCriterion("field_type <>", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThan(Integer value) {
            addCriterion("field_type >", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_type >=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThan(Integer value) {
            addCriterion("field_type <", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeLessThanOrEqualTo(Integer value) {
            addCriterion("field_type <=", value, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIn(List<Integer> values) {
            addCriterion("field_type in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotIn(List<Integer> values) {
            addCriterion("field_type not in", values, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeBetween(Integer value1, Integer value2) {
            addCriterion("field_type between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("field_type not between", value1, value2, "fieldType");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlIsNull() {
            addCriterion("field_select_url is null");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlIsNotNull() {
            addCriterion("field_select_url is not null");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlEqualTo(String value) {
            addCriterion("field_select_url =", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlNotEqualTo(String value) {
            addCriterion("field_select_url <>", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlGreaterThan(String value) {
            addCriterion("field_select_url >", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("field_select_url >=", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlLessThan(String value) {
            addCriterion("field_select_url <", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlLessThanOrEqualTo(String value) {
            addCriterion("field_select_url <=", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlLike(String value) {
            addCriterion("field_select_url like", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlNotLike(String value) {
            addCriterion("field_select_url not like", value, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlIn(List<String> values) {
            addCriterion("field_select_url in", values, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlNotIn(List<String> values) {
            addCriterion("field_select_url not in", values, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlBetween(String value1, String value2) {
            addCriterion("field_select_url between", value1, value2, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldSelectUrlNotBetween(String value1, String value2) {
            addCriterion("field_select_url not between", value1, value2, "fieldSelectUrl");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthIsNull() {
            addCriterion("field_text_max_length is null");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthIsNotNull() {
            addCriterion("field_text_max_length is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthEqualTo(Integer value) {
            addCriterion("field_text_max_length =", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthNotEqualTo(Integer value) {
            addCriterion("field_text_max_length <>", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthGreaterThan(Integer value) {
            addCriterion("field_text_max_length >", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_text_max_length >=", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthLessThan(Integer value) {
            addCriterion("field_text_max_length <", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthLessThanOrEqualTo(Integer value) {
            addCriterion("field_text_max_length <=", value, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthIn(List<Integer> values) {
            addCriterion("field_text_max_length in", values, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthNotIn(List<Integer> values) {
            addCriterion("field_text_max_length not in", values, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthBetween(Integer value1, Integer value2) {
            addCriterion("field_text_max_length between", value1, value2, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMaxLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("field_text_max_length not between", value1, value2, "fieldTextMaxLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthIsNull() {
            addCriterion("field_text_min_length is null");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthIsNotNull() {
            addCriterion("field_text_min_length is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthEqualTo(Integer value) {
            addCriterion("field_text_min_length =", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthNotEqualTo(Integer value) {
            addCriterion("field_text_min_length <>", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthGreaterThan(Integer value) {
            addCriterion("field_text_min_length >", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_text_min_length >=", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthLessThan(Integer value) {
            addCriterion("field_text_min_length <", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthLessThanOrEqualTo(Integer value) {
            addCriterion("field_text_min_length <=", value, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthIn(List<Integer> values) {
            addCriterion("field_text_min_length in", values, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthNotIn(List<Integer> values) {
            addCriterion("field_text_min_length not in", values, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthBetween(Integer value1, Integer value2) {
            addCriterion("field_text_min_length between", value1, value2, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldTextMinLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("field_text_min_length not between", value1, value2, "fieldTextMinLength");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxIsNull() {
            addCriterion("field_number_max is null");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxIsNotNull() {
            addCriterion("field_number_max is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxEqualTo(Double value) {
            addCriterion("field_number_max =", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxNotEqualTo(Double value) {
            addCriterion("field_number_max <>", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxGreaterThan(Double value) {
            addCriterion("field_number_max >", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("field_number_max >=", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxLessThan(Double value) {
            addCriterion("field_number_max <", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxLessThanOrEqualTo(Double value) {
            addCriterion("field_number_max <=", value, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxIn(List<Double> values) {
            addCriterion("field_number_max in", values, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxNotIn(List<Double> values) {
            addCriterion("field_number_max not in", values, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxBetween(Double value1, Double value2) {
            addCriterion("field_number_max between", value1, value2, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andFieldNumberMaxNotBetween(Double value1, Double value2) {
            addCriterion("field_number_max not between", value1, value2, "fieldNumberMax");
            return (Criteria) this;
        }

        public Criteria andIsForceIsNull() {
            addCriterion("is_force is null");
            return (Criteria) this;
        }

        public Criteria andIsForceIsNotNull() {
            addCriterion("is_force is not null");
            return (Criteria) this;
        }

        public Criteria andIsForceEqualTo(Integer value) {
            addCriterion("is_force =", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotEqualTo(Integer value) {
            addCriterion("is_force <>", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceGreaterThan(Integer value) {
            addCriterion("is_force >", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_force >=", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceLessThan(Integer value) {
            addCriterion("is_force <", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceLessThanOrEqualTo(Integer value) {
            addCriterion("is_force <=", value, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceIn(List<Integer> values) {
            addCriterion("is_force in", values, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotIn(List<Integer> values) {
            addCriterion("is_force not in", values, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceBetween(Integer value1, Integer value2) {
            addCriterion("is_force between", value1, value2, "isForce");
            return (Criteria) this;
        }

        public Criteria andIsForceNotBetween(Integer value1, Integer value2) {
            addCriterion("is_force not between", value1, value2, "isForce");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoIsNull() {
            addCriterion("field_user_info is null");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoIsNotNull() {
            addCriterion("field_user_info is not null");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoEqualTo(String value) {
            addCriterion("field_user_info =", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoNotEqualTo(String value) {
            addCriterion("field_user_info <>", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoGreaterThan(String value) {
            addCriterion("field_user_info >", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoGreaterThanOrEqualTo(String value) {
            addCriterion("field_user_info >=", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoLessThan(String value) {
            addCriterion("field_user_info <", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoLessThanOrEqualTo(String value) {
            addCriterion("field_user_info <=", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoLike(String value) {
            addCriterion("field_user_info like", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoNotLike(String value) {
            addCriterion("field_user_info not like", value, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoIn(List<String> values) {
            addCriterion("field_user_info in", values, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoNotIn(List<String> values) {
            addCriterion("field_user_info not in", values, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoBetween(String value1, String value2) {
            addCriterion("field_user_info between", value1, value2, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andFieldUserInfoNotBetween(String value1, String value2) {
            addCriterion("field_user_info not between", value1, value2, "fieldUserInfo");
            return (Criteria) this;
        }

        public Criteria andNodeNoIsNull() {
            addCriterion("node_no is null");
            return (Criteria) this;
        }

        public Criteria andNodeNoIsNotNull() {
            addCriterion("node_no is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNoEqualTo(String value) {
            addCriterion("node_no =", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotEqualTo(String value) {
            addCriterion("node_no <>", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoGreaterThan(String value) {
            addCriterion("node_no >", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoGreaterThanOrEqualTo(String value) {
            addCriterion("node_no >=", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLessThan(String value) {
            addCriterion("node_no <", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLessThanOrEqualTo(String value) {
            addCriterion("node_no <=", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoLike(String value) {
            addCriterion("node_no like", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotLike(String value) {
            addCriterion("node_no not like", value, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoIn(List<String> values) {
            addCriterion("node_no in", values, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotIn(List<String> values) {
            addCriterion("node_no not in", values, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoBetween(String value1, String value2) {
            addCriterion("node_no between", value1, value2, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andNodeNoNotBetween(String value1, String value2) {
            addCriterion("node_no not between", value1, value2, "nodeNo");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNull() {
            addCriterion("field_code is null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNotNull() {
            addCriterion("field_code is not null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeEqualTo(String value) {
            addCriterion("field_code =", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotEqualTo(String value) {
            addCriterion("field_code <>", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThan(String value) {
            addCriterion("field_code >", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("field_code >=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThan(String value) {
            addCriterion("field_code <", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThanOrEqualTo(String value) {
            addCriterion("field_code <=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLike(String value) {
            addCriterion("field_code like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotLike(String value) {
            addCriterion("field_code not like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIn(List<String> values) {
            addCriterion("field_code in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotIn(List<String> values) {
            addCriterion("field_code not in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeBetween(String value1, String value2) {
            addCriterion("field_code between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotBetween(String value1, String value2) {
            addCriterion("field_code not between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldIndexIsNull() {
            addCriterion("field_index is null");
            return (Criteria) this;
        }

        public Criteria andFieldIndexIsNotNull() {
            addCriterion("field_index is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIndexEqualTo(Integer value) {
            addCriterion("field_index =", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexNotEqualTo(Integer value) {
            addCriterion("field_index <>", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexGreaterThan(Integer value) {
            addCriterion("field_index >", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("field_index >=", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexLessThan(Integer value) {
            addCriterion("field_index <", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexLessThanOrEqualTo(Integer value) {
            addCriterion("field_index <=", value, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexIn(List<Integer> values) {
            addCriterion("field_index in", values, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexNotIn(List<Integer> values) {
            addCriterion("field_index not in", values, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexBetween(Integer value1, Integer value2) {
            addCriterion("field_index between", value1, value2, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andFieldIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("field_index not between", value1, value2, "fieldIndex");
            return (Criteria) this;
        }

        public Criteria andIsRouteIsNull() {
            addCriterion("is_route is null");
            return (Criteria) this;
        }

        public Criteria andIsRouteIsNotNull() {
            addCriterion("is_route is not null");
            return (Criteria) this;
        }

        public Criteria andIsRouteEqualTo(Integer value) {
            addCriterion("is_route =", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteNotEqualTo(Integer value) {
            addCriterion("is_route <>", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteGreaterThan(Integer value) {
            addCriterion("is_route >", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_route >=", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteLessThan(Integer value) {
            addCriterion("is_route <", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteLessThanOrEqualTo(Integer value) {
            addCriterion("is_route <=", value, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteIn(List<Integer> values) {
            addCriterion("is_route in", values, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteNotIn(List<Integer> values) {
            addCriterion("is_route not in", values, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteBetween(Integer value1, Integer value2) {
            addCriterion("is_route between", value1, value2, "isRoute");
            return (Criteria) this;
        }

        public Criteria andIsRouteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_route not between", value1, value2, "isRoute");
            return (Criteria) this;
        }

        public Criteria andRouteCodeIsNull() {
            addCriterion("route_code is null");
            return (Criteria) this;
        }

        public Criteria andRouteCodeIsNotNull() {
            addCriterion("route_code is not null");
            return (Criteria) this;
        }

        public Criteria andRouteCodeEqualTo(String value) {
            addCriterion("route_code =", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeNotEqualTo(String value) {
            addCriterion("route_code <>", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeGreaterThan(String value) {
            addCriterion("route_code >", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("route_code >=", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeLessThan(String value) {
            addCriterion("route_code <", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeLessThanOrEqualTo(String value) {
            addCriterion("route_code <=", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeLike(String value) {
            addCriterion("route_code like", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeNotLike(String value) {
            addCriterion("route_code not like", value, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeIn(List<String> values) {
            addCriterion("route_code in", values, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeNotIn(List<String> values) {
            addCriterion("route_code not in", values, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeBetween(String value1, String value2) {
            addCriterion("route_code between", value1, value2, "routeCode");
            return (Criteria) this;
        }

        public Criteria andRouteCodeNotBetween(String value1, String value2) {
            addCriterion("route_code not between", value1, value2, "routeCode");
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

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andFiledSelectIsNull() {
            addCriterion("filed_select is null");
            return (Criteria) this;
        }

        public Criteria andFiledSelectIsNotNull() {
            addCriterion("filed_select is not null");
            return (Criteria) this;
        }

        public Criteria andFiledSelectEqualTo(String value) {
            addCriterion("filed_select =", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectNotEqualTo(String value) {
            addCriterion("filed_select <>", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectGreaterThan(String value) {
            addCriterion("filed_select >", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectGreaterThanOrEqualTo(String value) {
            addCriterion("filed_select >=", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectLessThan(String value) {
            addCriterion("filed_select <", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectLessThanOrEqualTo(String value) {
            addCriterion("filed_select <=", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectLike(String value) {
            addCriterion("filed_select like", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectNotLike(String value) {
            addCriterion("filed_select not like", value, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectIn(List<String> values) {
            addCriterion("filed_select in", values, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectNotIn(List<String> values) {
            addCriterion("filed_select not in", values, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectBetween(String value1, String value2) {
            addCriterion("filed_select between", value1, value2, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andFiledSelectNotBetween(String value1, String value2) {
            addCriterion("filed_select not between", value1, value2, "filedSelect");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsIsNull() {
            addCriterion("commit_fields is null");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsIsNotNull() {
            addCriterion("commit_fields is not null");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsEqualTo(String value) {
            addCriterion("commit_fields =", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsNotEqualTo(String value) {
            addCriterion("commit_fields <>", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsGreaterThan(String value) {
            addCriterion("commit_fields >", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsGreaterThanOrEqualTo(String value) {
            addCriterion("commit_fields >=", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsLessThan(String value) {
            addCriterion("commit_fields <", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsLessThanOrEqualTo(String value) {
            addCriterion("commit_fields <=", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsLike(String value) {
            addCriterion("commit_fields like", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsNotLike(String value) {
            addCriterion("commit_fields not like", value, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsIn(List<String> values) {
            addCriterion("commit_fields in", values, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsNotIn(List<String> values) {
            addCriterion("commit_fields not in", values, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsBetween(String value1, String value2) {
            addCriterion("commit_fields between", value1, value2, "commitFields");
            return (Criteria) this;
        }

        public Criteria andCommitFieldsNotBetween(String value1, String value2) {
            addCriterion("filed_select not between", value1, value2, "commitFields");
            return (Criteria) this;
        }


        public Criteria andShowConditionIsNull() {
            addCriterion("show_condition is null");
            return (Criteria) this;
        }

        public Criteria andShowConditionIsNotNull() {
            addCriterion("show_condition is not null");
            return (Criteria) this;
        }

        public Criteria andShowConditionEqualTo(String value) {
            addCriterion("show_condition =", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionNotEqualTo(String value) {
            addCriterion("show_condition <>", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionGreaterThan(String value) {
            addCriterion("show_condition >", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionGreaterThanOrEqualTo(String value) {
            addCriterion("show_condition >=", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionLessThan(String value) {
            addCriterion("show_condition <", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionLessThanOrEqualTo(String value) {
            addCriterion("show_condition <=", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionLike(String value) {
            addCriterion("show_condition like", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionNotLike(String value) {
            addCriterion("show_condition not like", value, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionIn(List<String> values) {
            addCriterion("show_condition in", values, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionNotIn(List<String> values) {
            addCriterion("show_condition not in", values, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionBetween(String value1, String value2) {
            addCriterion("show_condition between", value1, value2, "showCondition");
            return (Criteria) this;
        }

        public Criteria andShowConditionNotBetween(String value1, String value2) {
            addCriterion("show_condition not between", value1, value2, "showCondition");
            return (Criteria) this;
        }

        public Criteria andIsNextUserIsNull() {
            addCriterion("is_next_user is null");
            return (Criteria) this;
        }

        public Criteria andIsNextUserIsNotNull() {
            addCriterion("is_next_user is not null");
            return (Criteria) this;
        }

        public Criteria andIsNextUserEqualTo(Integer value) {
            addCriterion("is_next_user =", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserNotEqualTo(Integer value) {
            addCriterion("is_next_user <>", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserGreaterThan(Integer value) {
            addCriterion("is_next_user >", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_next_user >=", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserLessThan(Integer value) {
            addCriterion("is_next_user <", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserLessThanOrEqualTo(Integer value) {
            addCriterion("is_next_user <=", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserLike(Integer value) {
            addCriterion("is_next_user like", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserNotLike(Integer value) {
            addCriterion("is_next_user not like", value, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserIn(List<Integer> values) {
            addCriterion("is_next_user in", values, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserNotIn(List<Integer> values) {
            addCriterion("is_next_user not in", values, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserBetween(Integer value1, Integer value2) {
            addCriterion("is_next_user between", value1, value2, "isNextUser");
            return (Criteria) this;
        }

        public Criteria andIsNextUserNotBetween(Integer value1, Integer value2) {
            addCriterion("is_next_user not between", value1, value2, "isNextUser");
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
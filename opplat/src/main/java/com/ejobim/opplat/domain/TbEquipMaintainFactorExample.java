package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipMaintainFactorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipMaintainFactorExample() {
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

        public Criteria andMfNoIsNull() {
            addCriterion("mf_no is null");
            return (Criteria) this;
        }

        public Criteria andMfNoIsNotNull() {
            addCriterion("mf_no is not null");
            return (Criteria) this;
        }

        public Criteria andMfNoEqualTo(String value) {
            addCriterion("mf_no =", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoNotEqualTo(String value) {
            addCriterion("mf_no <>", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoGreaterThan(String value) {
            addCriterion("mf_no >", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoGreaterThanOrEqualTo(String value) {
            addCriterion("mf_no >=", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoLessThan(String value) {
            addCriterion("mf_no <", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoLessThanOrEqualTo(String value) {
            addCriterion("mf_no <=", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoLike(String value) {
            addCriterion("mf_no like", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoNotLike(String value) {
            addCriterion("mf_no not like", value, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoIn(List<String> values) {
            addCriterion("mf_no in", values, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoNotIn(List<String> values) {
            addCriterion("mf_no not in", values, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoBetween(String value1, String value2) {
            addCriterion("mf_no between", value1, value2, "mfNo");
            return (Criteria) this;
        }

        public Criteria andMfNoNotBetween(String value1, String value2) {
            addCriterion("mf_no not between", value1, value2, "mfNo");
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

        public Criteria andMfContentIsNull() {
            addCriterion("mf_content is null");
            return (Criteria) this;
        }

        public Criteria andMfContentIsNotNull() {
            addCriterion("mf_content is not null");
            return (Criteria) this;
        }

        public Criteria andMfContentEqualTo(String value) {
            addCriterion("mf_content =", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentNotEqualTo(String value) {
            addCriterion("mf_content <>", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentGreaterThan(String value) {
            addCriterion("mf_content >", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentGreaterThanOrEqualTo(String value) {
            addCriterion("mf_content >=", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentLessThan(String value) {
            addCriterion("mf_content <", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentLessThanOrEqualTo(String value) {
            addCriterion("mf_content <=", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentLike(String value) {
            addCriterion("mf_content like", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentNotLike(String value) {
            addCriterion("mf_content not like", value, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentIn(List<String> values) {
            addCriterion("mf_content in", values, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentNotIn(List<String> values) {
            addCriterion("mf_content not in", values, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentBetween(String value1, String value2) {
            addCriterion("mf_content between", value1, value2, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfContentNotBetween(String value1, String value2) {
            addCriterion("mf_content not between", value1, value2, "mfContent");
            return (Criteria) this;
        }

        public Criteria andMfTypeIsNull() {
            addCriterion("mf_type is null");
            return (Criteria) this;
        }

        public Criteria andMfTypeIsNotNull() {
            addCriterion("mf_type is not null");
            return (Criteria) this;
        }

        public Criteria andMfTypeEqualTo(Integer value) {
            addCriterion("mf_type =", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotEqualTo(Integer value) {
            addCriterion("mf_type <>", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeGreaterThan(Integer value) {
            addCriterion("mf_type >", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mf_type >=", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeLessThan(Integer value) {
            addCriterion("mf_type <", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mf_type <=", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeIn(List<Integer> values) {
            addCriterion("mf_type in", values, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotIn(List<Integer> values) {
            addCriterion("mf_type not in", values, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeBetween(Integer value1, Integer value2) {
            addCriterion("mf_type between", value1, value2, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mf_type not between", value1, value2, "mfType");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(Integer value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(Integer value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(Integer value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(Integer value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(Integer value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLike(Integer value) {
            addCriterion("cycle like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotLike(Integer value) {
            addCriterion("cycle not like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<Integer> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<Integer> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(Integer value1, Integer value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andMfAddonIsNull() {
            addCriterion("mf_addon is null");
            return (Criteria) this;
        }

        public Criteria andMfAddonIsNotNull() {
            addCriterion("mf_addon is not null");
            return (Criteria) this;
        }

        public Criteria andMfAddonEqualTo(String value) {
            addCriterion("mf_addon =", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonNotEqualTo(String value) {
            addCriterion("mf_addon <>", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonGreaterThan(String value) {
            addCriterion("mf_addon >", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonGreaterThanOrEqualTo(String value) {
            addCriterion("mf_addon >=", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonLessThan(String value) {
            addCriterion("mf_addon <", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonLessThanOrEqualTo(String value) {
            addCriterion("mf_addon <=", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonLike(String value) {
            addCriterion("mf_addon like", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonNotLike(String value) {
            addCriterion("mf_addon not like", value, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonIn(List<String> values) {
            addCriterion("mf_addon in", values, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonNotIn(List<String> values) {
            addCriterion("mf_addon not in", values, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonBetween(String value1, String value2) {
            addCriterion("mf_addon between", value1, value2, "mfAddon");
            return (Criteria) this;
        }

        public Criteria andMfAddonNotBetween(String value1, String value2) {
            addCriterion("mf_addon not between", value1, value2, "mfAddon");
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

        public Criteria andCreateUserCodeIsNull() {
            addCriterion("create_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNotNull() {
            addCriterion("create_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeEqualTo(String value) {
            addCriterion("create_user_code =", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotEqualTo(String value) {
            addCriterion("create_user_code <>", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThan(String value) {
            addCriterion("create_user_code >", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_code >=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThan(String value) {
            addCriterion("create_user_code <", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("create_user_code <=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLike(String value) {
            addCriterion("create_user_code like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotLike(String value) {
            addCriterion("create_user_code not like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIn(List<String> values) {
            addCriterion("create_user_code in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotIn(List<String> values) {
            addCriterion("create_user_code not in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeBetween(String value1, String value2) {
            addCriterion("create_user_code between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotBetween(String value1, String value2) {
            addCriterion("create_user_code not between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andUpdateUserCodeIsNull() {
            addCriterion("update_user_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNotNull() {
            addCriterion("update_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeEqualTo(String value) {
            addCriterion("update_user_code =", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotEqualTo(String value) {
            addCriterion("update_user_code <>", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThan(String value) {
            addCriterion("update_user_code >", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_code >=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThan(String value) {
            addCriterion("update_user_code <", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("update_user_code <=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLike(String value) {
            addCriterion("update_user_code like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotLike(String value) {
            addCriterion("update_user_code not like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIn(List<String> values) {
            addCriterion("update_user_code in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotIn(List<String> values) {
            addCriterion("update_user_code not in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeBetween(String value1, String value2) {
            addCriterion("update_user_code between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotBetween(String value1, String value2) {
            addCriterion("update_user_code not between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andMfTimeIsNull() {
            addCriterion("mf_time is null");
            return (Criteria) this;
        }

        public Criteria andMfTimeIsNotNull() {
            addCriterion("mf_time is not null");
            return (Criteria) this;
        }

        public Criteria andMfTimeEqualTo(Date value) {
            addCriterion("mf_time =", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeNotEqualTo(Date value) {
            addCriterion("mf_time <>", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeGreaterThan(Date value) {
            addCriterion("mf_time >", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mf_time >=", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeLessThan(Date value) {
            addCriterion("mf_time <", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeLessThanOrEqualTo(Date value) {
            addCriterion("mf_time <=", value, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeIn(List<Date> values) {
            addCriterion("mf_time in", values, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeNotIn(List<Date> values) {
            addCriterion("mf_time not in", values, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeBetween(Date value1, Date value2) {
            addCriterion("mf_time between", value1, value2, "mfTime");
            return (Criteria) this;
        }

        public Criteria andMfTimeNotBetween(Date value1, Date value2) {
            addCriterion("mf_time not between", value1, value2, "mfTime");
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
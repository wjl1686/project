package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipMaintainPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipMaintainPlanExample() {
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

        public Criteria andPlanNoIsNull() {
            addCriterion("plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(String value) {
            addCriterion("plan_no =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(String value) {
            addCriterion("plan_no <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(String value) {
            addCriterion("plan_no >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(String value) {
            addCriterion("plan_no >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(String value) {
            addCriterion("plan_no <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(String value) {
            addCriterion("plan_no <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLike(String value) {
            addCriterion("plan_no like", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotLike(String value) {
            addCriterion("plan_no not like", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<String> values) {
            addCriterion("plan_no in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<String> values) {
            addCriterion("plan_no not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(String value1, String value2) {
            addCriterion("plan_no between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(String value1, String value2) {
            addCriterion("plan_no not between", value1, value2, "planNo");
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

        public Criteria andEquipLocationNameIsNull() {
            addCriterion("equip_location_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameIsNotNull() {
            addCriterion("equip_location_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameEqualTo(String value) {
            addCriterion("equip_location_name =", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotEqualTo(String value) {
            addCriterion("equip_location_name <>", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameGreaterThan(String value) {
            addCriterion("equip_location_name >", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_location_name >=", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLessThan(String value) {
            addCriterion("equip_location_name <", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLessThanOrEqualTo(String value) {
            addCriterion("equip_location_name <=", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameLike(String value) {
            addCriterion("equip_location_name like", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotLike(String value) {
            addCriterion("equip_location_name not like", value, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameIn(List<String> values) {
            addCriterion("equip_location_name in", values, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotIn(List<String> values) {
            addCriterion("equip_location_name not in", values, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameBetween(String value1, String value2) {
            addCriterion("equip_location_name between", value1, value2, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andEquipLocationNameNotBetween(String value1, String value2) {
            addCriterion("equip_location_name not between", value1, value2, "equipLocationName");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIsNull() {
            addCriterion("is_entrust is null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIsNotNull() {
            addCriterion("is_entrust is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntrustEqualTo(Integer value) {
            addCriterion("is_entrust =", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotEqualTo(Integer value) {
            addCriterion("is_entrust <>", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThan(Integer value) {
            addCriterion("is_entrust >", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_entrust >=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThan(Integer value) {
            addCriterion("is_entrust <", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustLessThanOrEqualTo(Integer value) {
            addCriterion("is_entrust <=", value, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustIn(List<Integer> values) {
            addCriterion("is_entrust in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotIn(List<Integer> values) {
            addCriterion("is_entrust not in", values, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust between", value1, value2, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andIsEntrustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_entrust not between", value1, value2, "isEntrust");
            return (Criteria) this;
        }

        public Criteria andPlanYearIsNull() {
            addCriterion("plan_year is null");
            return (Criteria) this;
        }

        public Criteria andPlanYearIsNotNull() {
            addCriterion("plan_year is not null");
            return (Criteria) this;
        }

        public Criteria andPlanYearEqualTo(Integer value) {
            addCriterion("plan_year =", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotEqualTo(Integer value) {
            addCriterion("plan_year <>", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThan(Integer value) {
            addCriterion("plan_year >", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_year >=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThan(Integer value) {
            addCriterion("plan_year <", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThanOrEqualTo(Integer value) {
            addCriterion("plan_year <=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearIn(List<Integer> values) {
            addCriterion("plan_year in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotIn(List<Integer> values) {
            addCriterion("plan_year not in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearBetween(Integer value1, Integer value2) {
            addCriterion("plan_year between", value1, value2, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_year not between", value1, value2, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanCircleIsNull() {
            addCriterion("plan_circle is null");
            return (Criteria) this;
        }

        public Criteria andPlanCircleIsNotNull() {
            addCriterion("plan_circle is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCircleEqualTo(Integer value) {
            addCriterion("plan_circle =", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleNotEqualTo(Integer value) {
            addCriterion("plan_circle <>", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleGreaterThan(Integer value) {
            addCriterion("plan_circle >", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_circle >=", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleLessThan(Integer value) {
            addCriterion("plan_circle <", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleLessThanOrEqualTo(Integer value) {
            addCriterion("plan_circle <=", value, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleIn(List<Integer> values) {
            addCriterion("plan_circle in", values, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleNotIn(List<Integer> values) {
            addCriterion("plan_circle not in", values, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleBetween(Integer value1, Integer value2) {
            addCriterion("plan_circle between", value1, value2, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCircleNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_circle not between", value1, value2, "planCircle");
            return (Criteria) this;
        }

        public Criteria andPlanCostIsNull() {
            addCriterion("plan_cost is null");
            return (Criteria) this;
        }

        public Criteria andPlanCostIsNotNull() {
            addCriterion("plan_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCostEqualTo(Double value) {
            addCriterion("plan_cost =", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotEqualTo(Double value) {
            addCriterion("plan_cost <>", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThan(Double value) {
            addCriterion("plan_cost >", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_cost >=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThan(Double value) {
            addCriterion("plan_cost <", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThanOrEqualTo(Double value) {
            addCriterion("plan_cost <=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostIn(List<Double> values) {
            addCriterion("plan_cost in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotIn(List<Double> values) {
            addCriterion("plan_cost not in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostBetween(Double value1, Double value2) {
            addCriterion("plan_cost between", value1, value2, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotBetween(Double value1, Double value2) {
            addCriterion("plan_cost not between", value1, value2, "planCost");
            return (Criteria) this;
        }

        public Criteria andRealCostIsNull() {
            addCriterion("real_cost is null");
            return (Criteria) this;
        }

        public Criteria andRealCostIsNotNull() {
            addCriterion("real_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRealCostEqualTo(Double value) {
            addCriterion("real_cost =", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotEqualTo(Double value) {
            addCriterion("real_cost <>", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThan(Double value) {
            addCriterion("real_cost >", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThanOrEqualTo(Double value) {
            addCriterion("real_cost >=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThan(Double value) {
            addCriterion("real_cost <", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThanOrEqualTo(Double value) {
            addCriterion("real_cost <=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostIn(List<Double> values) {
            addCriterion("real_cost in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotIn(List<Double> values) {
            addCriterion("real_cost not in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostBetween(Double value1, Double value2) {
            addCriterion("real_cost between", value1, value2, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotBetween(Double value1, Double value2) {
            addCriterion("real_cost not between", value1, value2, "realCost");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(Integer value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(Integer value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(Integer value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(Integer value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<Integer> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<Integer> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(Integer value1, Integer value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNull() {
            addCriterion("plan_content is null");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNotNull() {
            addCriterion("plan_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlanContentEqualTo(String value) {
            addCriterion("plan_content =", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotEqualTo(String value) {
            addCriterion("plan_content <>", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThan(String value) {
            addCriterion("plan_content >", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThanOrEqualTo(String value) {
            addCriterion("plan_content >=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThan(String value) {
            addCriterion("plan_content <", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThanOrEqualTo(String value) {
            addCriterion("plan_content <=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLike(String value) {
            addCriterion("plan_content like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotLike(String value) {
            addCriterion("plan_content not like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentIn(List<String> values) {
            addCriterion("plan_content in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotIn(List<String> values) {
            addCriterion("plan_content not in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentBetween(String value1, String value2) {
            addCriterion("plan_content between", value1, value2, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotBetween(String value1, String value2) {
            addCriterion("plan_content not between", value1, value2, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanAddonIsNull() {
            addCriterion("plan_addon is null");
            return (Criteria) this;
        }

        public Criteria andPlanAddonIsNotNull() {
            addCriterion("plan_addon is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAddonEqualTo(String value) {
            addCriterion("plan_addon =", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonNotEqualTo(String value) {
            addCriterion("plan_addon <>", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonGreaterThan(String value) {
            addCriterion("plan_addon >", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonGreaterThanOrEqualTo(String value) {
            addCriterion("plan_addon >=", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonLessThan(String value) {
            addCriterion("plan_addon <", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonLessThanOrEqualTo(String value) {
            addCriterion("plan_addon <=", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonLike(String value) {
            addCriterion("plan_addon like", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonNotLike(String value) {
            addCriterion("plan_addon not like", value, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonIn(List<String> values) {
            addCriterion("plan_addon in", values, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonNotIn(List<String> values) {
            addCriterion("plan_addon not in", values, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonBetween(String value1, String value2) {
            addCriterion("plan_addon between", value1, value2, "planAddon");
            return (Criteria) this;
        }

        public Criteria andPlanAddonNotBetween(String value1, String value2) {
            addCriterion("plan_addon not between", value1, value2, "planAddon");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeIsNull() {
            addCriterion("plan_update_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeIsNotNull() {
            addCriterion("plan_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeEqualTo(Date value) {
            addCriterion("plan_update_time =", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeNotEqualTo(Date value) {
            addCriterion("plan_update_time <>", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeGreaterThan(Date value) {
            addCriterion("plan_update_time >", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_update_time >=", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeLessThan(Date value) {
            addCriterion("plan_update_time <", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_update_time <=", value, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeIn(List<Date> values) {
            addCriterion("plan_update_time in", values, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeNotIn(List<Date> values) {
            addCriterion("plan_update_time not in", values, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("plan_update_time between", value1, value2, "planUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPlanUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_update_time not between", value1, value2, "planUpdateTime");
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
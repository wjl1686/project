package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFactoryInfoExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFactoryInfoExtendExample() {
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

        public Criteria andPlanningScaleIsNull() {
            addCriterion("planning_scale is null");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleIsNotNull() {
            addCriterion("planning_scale is not null");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleEqualTo(Double value) {
            addCriterion("planning_scale =", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleNotEqualTo(Double value) {
            addCriterion("planning_scale <>", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleGreaterThan(Double value) {
            addCriterion("planning_scale >", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("planning_scale >=", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleLessThan(Double value) {
            addCriterion("planning_scale <", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleLessThanOrEqualTo(Double value) {
            addCriterion("planning_scale <=", value, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleIn(List<Double> values) {
            addCriterion("planning_scale in", values, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleNotIn(List<Double> values) {
            addCriterion("planning_scale not in", values, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleBetween(Double value1, Double value2) {
            addCriterion("planning_scale between", value1, value2, "planningScale");
            return (Criteria) this;
        }

        public Criteria andPlanningScaleNotBetween(Double value1, Double value2) {
            addCriterion("planning_scale not between", value1, value2, "planningScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleIsNull() {
            addCriterion("contract_scale is null");
            return (Criteria) this;
        }

        public Criteria andContractScaleIsNotNull() {
            addCriterion("contract_scale is not null");
            return (Criteria) this;
        }

        public Criteria andContractScaleEqualTo(Double value) {
            addCriterion("contract_scale =", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleNotEqualTo(Double value) {
            addCriterion("contract_scale <>", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleGreaterThan(Double value) {
            addCriterion("contract_scale >", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_scale >=", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleLessThan(Double value) {
            addCriterion("contract_scale <", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleLessThanOrEqualTo(Double value) {
            addCriterion("contract_scale <=", value, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleIn(List<Double> values) {
            addCriterion("contract_scale in", values, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleNotIn(List<Double> values) {
            addCriterion("contract_scale not in", values, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleBetween(Double value1, Double value2) {
            addCriterion("contract_scale between", value1, value2, "contractScale");
            return (Criteria) this;
        }

        public Criteria andContractScaleNotBetween(Double value1, Double value2) {
            addCriterion("contract_scale not between", value1, value2, "contractScale");
            return (Criteria) this;
        }

        public Criteria andPowerRateIsNull() {
            addCriterion("power_rate is null");
            return (Criteria) this;
        }

        public Criteria andPowerRateIsNotNull() {
            addCriterion("power_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPowerRateEqualTo(Double value) {
            addCriterion("power_rate =", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateNotEqualTo(Double value) {
            addCriterion("power_rate <>", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateGreaterThan(Double value) {
            addCriterion("power_rate >", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateGreaterThanOrEqualTo(Double value) {
            addCriterion("power_rate >=", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateLessThan(Double value) {
            addCriterion("power_rate <", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateLessThanOrEqualTo(Double value) {
            addCriterion("power_rate <=", value, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateIn(List<Double> values) {
            addCriterion("power_rate in", values, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateNotIn(List<Double> values) {
            addCriterion("power_rate not in", values, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateBetween(Double value1, Double value2) {
            addCriterion("power_rate between", value1, value2, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerRateNotBetween(Double value1, Double value2) {
            addCriterion("power_rate not between", value1, value2, "powerRate");
            return (Criteria) this;
        }

        public Criteria andPowerScaleIsNull() {
            addCriterion("power_scale is null");
            return (Criteria) this;
        }

        public Criteria andPowerScaleIsNotNull() {
            addCriterion("power_scale is not null");
            return (Criteria) this;
        }

        public Criteria andPowerScaleEqualTo(Double value) {
            addCriterion("power_scale =", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleNotEqualTo(Double value) {
            addCriterion("power_scale <>", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleGreaterThan(Double value) {
            addCriterion("power_scale >", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("power_scale >=", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleLessThan(Double value) {
            addCriterion("power_scale <", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleLessThanOrEqualTo(Double value) {
            addCriterion("power_scale <=", value, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleIn(List<Double> values) {
            addCriterion("power_scale in", values, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleNotIn(List<Double> values) {
            addCriterion("power_scale not in", values, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleBetween(Double value1, Double value2) {
            addCriterion("power_scale between", value1, value2, "powerScale");
            return (Criteria) this;
        }

        public Criteria andPowerScaleNotBetween(Double value1, Double value2) {
            addCriterion("power_scale not between", value1, value2, "powerScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleIsNull() {
            addCriterion("buile_scale is null");
            return (Criteria) this;
        }

        public Criteria andBuileScaleIsNotNull() {
            addCriterion("buile_scale is not null");
            return (Criteria) this;
        }

        public Criteria andBuileScaleEqualTo(Double value) {
            addCriterion("buile_scale =", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleNotEqualTo(Double value) {
            addCriterion("buile_scale <>", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleGreaterThan(Double value) {
            addCriterion("buile_scale >", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("buile_scale >=", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleLessThan(Double value) {
            addCriterion("buile_scale <", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleLessThanOrEqualTo(Double value) {
            addCriterion("buile_scale <=", value, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleIn(List<Double> values) {
            addCriterion("buile_scale in", values, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleNotIn(List<Double> values) {
            addCriterion("buile_scale not in", values, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleBetween(Double value1, Double value2) {
            addCriterion("buile_scale between", value1, value2, "buileScale");
            return (Criteria) this;
        }

        public Criteria andBuileScaleNotBetween(Double value1, Double value2) {
            addCriterion("buile_scale not between", value1, value2, "buileScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleIsNull() {
            addCriterion("hold_scale is null");
            return (Criteria) this;
        }

        public Criteria andHoldScaleIsNotNull() {
            addCriterion("hold_scale is not null");
            return (Criteria) this;
        }

        public Criteria andHoldScaleEqualTo(Double value) {
            addCriterion("hold_scale =", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleNotEqualTo(Double value) {
            addCriterion("hold_scale <>", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleGreaterThan(Double value) {
            addCriterion("hold_scale >", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("hold_scale >=", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleLessThan(Double value) {
            addCriterion("hold_scale <", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleLessThanOrEqualTo(Double value) {
            addCriterion("hold_scale <=", value, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleIn(List<Double> values) {
            addCriterion("hold_scale in", values, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleNotIn(List<Double> values) {
            addCriterion("hold_scale not in", values, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleBetween(Double value1, Double value2) {
            addCriterion("hold_scale between", value1, value2, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldScaleNotBetween(Double value1, Double value2) {
            addCriterion("hold_scale not between", value1, value2, "holdScale");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainIsNull() {
            addCriterion("hold_maintain is null");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainIsNotNull() {
            addCriterion("hold_maintain is not null");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainEqualTo(Double value) {
            addCriterion("hold_maintain =", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainNotEqualTo(Double value) {
            addCriterion("hold_maintain <>", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainGreaterThan(Double value) {
            addCriterion("hold_maintain >", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainGreaterThanOrEqualTo(Double value) {
            addCriterion("hold_maintain >=", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainLessThan(Double value) {
            addCriterion("hold_maintain <", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainLessThanOrEqualTo(Double value) {
            addCriterion("hold_maintain <=", value, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainIn(List<Double> values) {
            addCriterion("hold_maintain in", values, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainNotIn(List<Double> values) {
            addCriterion("hold_maintain not in", values, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainBetween(Double value1, Double value2) {
            addCriterion("hold_maintain between", value1, value2, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andHoldMaintainNotBetween(Double value1, Double value2) {
            addCriterion("hold_maintain not between", value1, value2, "holdMaintain");
            return (Criteria) this;
        }

        public Criteria andServicePopulationIsNull() {
            addCriterion("service_population is null");
            return (Criteria) this;
        }

        public Criteria andServicePopulationIsNotNull() {
            addCriterion("service_population is not null");
            return (Criteria) this;
        }

        public Criteria andServicePopulationEqualTo(Double value) {
            addCriterion("service_population =", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationNotEqualTo(Double value) {
            addCriterion("service_population <>", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationGreaterThan(Double value) {
            addCriterion("service_population >", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationGreaterThanOrEqualTo(Double value) {
            addCriterion("service_population >=", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationLessThan(Double value) {
            addCriterion("service_population <", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationLessThanOrEqualTo(Double value) {
            addCriterion("service_population <=", value, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationIn(List<Double> values) {
            addCriterion("service_population in", values, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationNotIn(List<Double> values) {
            addCriterion("service_population not in", values, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationBetween(Double value1, Double value2) {
            addCriterion("service_population between", value1, value2, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServicePopulationNotBetween(Double value1, Double value2) {
            addCriterion("service_population not between", value1, value2, "servicePopulation");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIsNull() {
            addCriterion("service_area is null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIsNotNull() {
            addCriterion("service_area is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaEqualTo(Double value) {
            addCriterion("service_area =", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotEqualTo(Double value) {
            addCriterion("service_area <>", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaGreaterThan(Double value) {
            addCriterion("service_area >", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("service_area >=", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaLessThan(Double value) {
            addCriterion("service_area <", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaLessThanOrEqualTo(Double value) {
            addCriterion("service_area <=", value, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaIn(List<Double> values) {
            addCriterion("service_area in", values, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotIn(List<Double> values) {
            addCriterion("service_area not in", values, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaBetween(Double value1, Double value2) {
            addCriterion("service_area between", value1, value2, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNotBetween(Double value1, Double value2) {
            addCriterion("service_area not between", value1, value2, "serviceArea");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateIsNull() {
            addCriterion("industrial_waste_rate is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateIsNotNull() {
            addCriterion("industrial_waste_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateEqualTo(Double value) {
            addCriterion("industrial_waste_rate =", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateNotEqualTo(Double value) {
            addCriterion("industrial_waste_rate <>", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateGreaterThan(Double value) {
            addCriterion("industrial_waste_rate >", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateGreaterThanOrEqualTo(Double value) {
            addCriterion("industrial_waste_rate >=", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateLessThan(Double value) {
            addCriterion("industrial_waste_rate <", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateLessThanOrEqualTo(Double value) {
            addCriterion("industrial_waste_rate <=", value, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateIn(List<Double> values) {
            addCriterion("industrial_waste_rate in", values, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateNotIn(List<Double> values) {
            addCriterion("industrial_waste_rate not in", values, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateBetween(Double value1, Double value2) {
            addCriterion("industrial_waste_rate between", value1, value2, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andIndustrialWasteRateNotBetween(Double value1, Double value2) {
            addCriterion("industrial_waste_rate not between", value1, value2, "industrialWasteRate");
            return (Criteria) this;
        }

        public Criteria andCoreProcessIsNull() {
            addCriterion("core_process is null");
            return (Criteria) this;
        }

        public Criteria andCoreProcessIsNotNull() {
            addCriterion("core_process is not null");
            return (Criteria) this;
        }

        public Criteria andCoreProcessEqualTo(String value) {
            addCriterion("core_process =", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessNotEqualTo(String value) {
            addCriterion("core_process <>", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessGreaterThan(String value) {
            addCriterion("core_process >", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessGreaterThanOrEqualTo(String value) {
            addCriterion("core_process >=", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessLessThan(String value) {
            addCriterion("core_process <", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessLessThanOrEqualTo(String value) {
            addCriterion("core_process <=", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessLike(String value) {
            addCriterion("core_process like", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessNotLike(String value) {
            addCriterion("core_process not like", value, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessIn(List<String> values) {
            addCriterion("core_process in", values, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessNotIn(List<String> values) {
            addCriterion("core_process not in", values, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessBetween(String value1, String value2) {
            addCriterion("core_process between", value1, value2, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andCoreProcessNotBetween(String value1, String value2) {
            addCriterion("core_process not between", value1, value2, "coreProcess");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutIsNull() {
            addCriterion("water_quality_norm_out is null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutIsNotNull() {
            addCriterion("water_quality_norm_out is not null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutEqualTo(String value) {
            addCriterion("water_quality_norm_out =", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutNotEqualTo(String value) {
            addCriterion("water_quality_norm_out <>", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutGreaterThan(String value) {
            addCriterion("water_quality_norm_out >", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutGreaterThanOrEqualTo(String value) {
            addCriterion("water_quality_norm_out >=", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutLessThan(String value) {
            addCriterion("water_quality_norm_out <", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutLessThanOrEqualTo(String value) {
            addCriterion("water_quality_norm_out <=", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutLike(String value) {
            addCriterion("water_quality_norm_out like", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutNotLike(String value) {
            addCriterion("water_quality_norm_out not like", value, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutIn(List<String> values) {
            addCriterion("water_quality_norm_out in", values, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutNotIn(List<String> values) {
            addCriterion("water_quality_norm_out not in", values, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutBetween(String value1, String value2) {
            addCriterion("water_quality_norm_out between", value1, value2, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andWaterQualityNormOutNotBetween(String value1, String value2) {
            addCriterion("water_quality_norm_out not between", value1, value2, "waterQualityNormOut");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNull() {
            addCriterion("contract_period is null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNotNull() {
            addCriterion("contract_period is not null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodEqualTo(Double value) {
            addCriterion("contract_period =", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotEqualTo(Double value) {
            addCriterion("contract_period <>", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThan(Double value) {
            addCriterion("contract_period >", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_period >=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThan(Double value) {
            addCriterion("contract_period <", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThanOrEqualTo(Double value) {
            addCriterion("contract_period <=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIn(List<Double> values) {
            addCriterion("contract_period in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotIn(List<Double> values) {
            addCriterion("contract_period not in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodBetween(Double value1, Double value2) {
            addCriterion("contract_period between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotBetween(Double value1, Double value2) {
            addCriterion("contract_period not between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeIsNull() {
            addCriterion("keep_water_volume is null");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeIsNotNull() {
            addCriterion("keep_water_volume is not null");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeEqualTo(Double value) {
            addCriterion("keep_water_volume =", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeNotEqualTo(Double value) {
            addCriterion("keep_water_volume <>", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeGreaterThan(Double value) {
            addCriterion("keep_water_volume >", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("keep_water_volume >=", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeLessThan(Double value) {
            addCriterion("keep_water_volume <", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeLessThanOrEqualTo(Double value) {
            addCriterion("keep_water_volume <=", value, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeIn(List<Double> values) {
            addCriterion("keep_water_volume in", values, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeNotIn(List<Double> values) {
            addCriterion("keep_water_volume not in", values, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeBetween(Double value1, Double value2) {
            addCriterion("keep_water_volume between", value1, value2, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andKeepWaterVolumeNotBetween(Double value1, Double value2) {
            addCriterion("keep_water_volume not between", value1, value2, "keepWaterVolume");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIsNull() {
            addCriterion("contract_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIsNotNull() {
            addCriterion("contract_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceEqualTo(Double value) {
            addCriterion("contract_unit_price =", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotEqualTo(Double value) {
            addCriterion("contract_unit_price <>", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceGreaterThan(Double value) {
            addCriterion("contract_unit_price >", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_unit_price >=", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceLessThan(Double value) {
            addCriterion("contract_unit_price <", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceLessThanOrEqualTo(Double value) {
            addCriterion("contract_unit_price <=", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIn(List<Double> values) {
            addCriterion("contract_unit_price in", values, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotIn(List<Double> values) {
            addCriterion("contract_unit_price not in", values, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceBetween(Double value1, Double value2) {
            addCriterion("contract_unit_price between", value1, value2, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotBetween(Double value1, Double value2) {
            addCriterion("contract_unit_price not between", value1, value2, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFilledAccountIsNull() {
            addCriterion("filled_account is null");
            return (Criteria) this;
        }

        public Criteria andFilledAccountIsNotNull() {
            addCriterion("filled_account is not null");
            return (Criteria) this;
        }

        public Criteria andFilledAccountEqualTo(String value) {
            addCriterion("filled_account =", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountNotEqualTo(String value) {
            addCriterion("filled_account <>", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountGreaterThan(String value) {
            addCriterion("filled_account >", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountGreaterThanOrEqualTo(String value) {
            addCriterion("filled_account >=", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountLessThan(String value) {
            addCriterion("filled_account <", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountLessThanOrEqualTo(String value) {
            addCriterion("filled_account <=", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountLike(String value) {
            addCriterion("filled_account like", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountNotLike(String value) {
            addCriterion("filled_account not like", value, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountIn(List<String> values) {
            addCriterion("filled_account in", values, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountNotIn(List<String> values) {
            addCriterion("filled_account not in", values, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountBetween(String value1, String value2) {
            addCriterion("filled_account between", value1, value2, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andFilledAccountNotBetween(String value1, String value2) {
            addCriterion("filled_account not between", value1, value2, "filledAccount");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
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
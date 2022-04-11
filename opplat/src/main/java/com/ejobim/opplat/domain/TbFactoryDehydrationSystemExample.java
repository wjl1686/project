package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFactoryDehydrationSystemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFactoryDehydrationSystemExample() {
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

        public Criteria andSludgeTypeIsNull() {
            addCriterion("sludge_type is null");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeIsNotNull() {
            addCriterion("sludge_type is not null");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeEqualTo(Integer value) {
            addCriterion("sludge_type =", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeNotEqualTo(Integer value) {
            addCriterion("sludge_type <>", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeGreaterThan(Integer value) {
            addCriterion("sludge_type >", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sludge_type >=", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeLessThan(Integer value) {
            addCriterion("sludge_type <", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sludge_type <=", value, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeIn(List<Integer> values) {
            addCriterion("sludge_type in", values, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeNotIn(List<Integer> values) {
            addCriterion("sludge_type not in", values, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeBetween(Integer value1, Integer value2) {
            addCriterion("sludge_type between", value1, value2, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andSludgeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sludge_type not between", value1, value2, "sludgeType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeIsNull() {
            addCriterion("dehydration_type is null");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeIsNotNull() {
            addCriterion("dehydration_type is not null");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeEqualTo(Integer value) {
            addCriterion("dehydration_type =", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeNotEqualTo(Integer value) {
            addCriterion("dehydration_type <>", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeGreaterThan(Integer value) {
            addCriterion("dehydration_type >", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dehydration_type >=", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeLessThan(Integer value) {
            addCriterion("dehydration_type <", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dehydration_type <=", value, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeIn(List<Integer> values) {
            addCriterion("dehydration_type in", values, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeNotIn(List<Integer> values) {
            addCriterion("dehydration_type not in", values, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeBetween(Integer value1, Integer value2) {
            addCriterion("dehydration_type between", value1, value2, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dehydration_type not between", value1, value2, "dehydrationType");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudIsNull() {
            addCriterion("dehydration_mud is null");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudIsNotNull() {
            addCriterion("dehydration_mud is not null");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudEqualTo(Double value) {
            addCriterion("dehydration_mud =", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudNotEqualTo(Double value) {
            addCriterion("dehydration_mud <>", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudGreaterThan(Double value) {
            addCriterion("dehydration_mud >", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudGreaterThanOrEqualTo(Double value) {
            addCriterion("dehydration_mud >=", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudLessThan(Double value) {
            addCriterion("dehydration_mud <", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudLessThanOrEqualTo(Double value) {
            addCriterion("dehydration_mud <=", value, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudIn(List<Double> values) {
            addCriterion("dehydration_mud in", values, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudNotIn(List<Double> values) {
            addCriterion("dehydration_mud not in", values, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudBetween(Double value1, Double value2) {
            addCriterion("dehydration_mud between", value1, value2, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationMudNotBetween(Double value1, Double value2) {
            addCriterion("dehydration_mud not between", value1, value2, "dehydrationMud");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeIsNull() {
            addCriterion("dehydration_pre_type is null");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeIsNotNull() {
            addCriterion("dehydration_pre_type is not null");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeEqualTo(Integer value) {
            addCriterion("dehydration_pre_type =", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeNotEqualTo(Integer value) {
            addCriterion("dehydration_pre_type <>", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeGreaterThan(Integer value) {
            addCriterion("dehydration_pre_type >", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dehydration_pre_type >=", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeLessThan(Integer value) {
            addCriterion("dehydration_pre_type <", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dehydration_pre_type <=", value, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeIn(List<Integer> values) {
            addCriterion("dehydration_pre_type in", values, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeNotIn(List<Integer> values) {
            addCriterion("dehydration_pre_type not in", values, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeBetween(Integer value1, Integer value2) {
            addCriterion("dehydration_pre_type between", value1, value2, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andDehydrationPreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dehydration_pre_type not between", value1, value2, "dehydrationPreType");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateIsNull() {
            addCriterion("pre_dehydration_mud_water_rate is null");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateIsNotNull() {
            addCriterion("pre_dehydration_mud_water_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateEqualTo(Double value) {
            addCriterion("pre_dehydration_mud_water_rate =", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateNotEqualTo(Double value) {
            addCriterion("pre_dehydration_mud_water_rate <>", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateGreaterThan(Double value) {
            addCriterion("pre_dehydration_mud_water_rate >", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateGreaterThanOrEqualTo(Double value) {
            addCriterion("pre_dehydration_mud_water_rate >=", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateLessThan(Double value) {
            addCriterion("pre_dehydration_mud_water_rate <", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateLessThanOrEqualTo(Double value) {
            addCriterion("pre_dehydration_mud_water_rate <=", value, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateIn(List<Double> values) {
            addCriterion("pre_dehydration_mud_water_rate in", values, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateNotIn(List<Double> values) {
            addCriterion("pre_dehydration_mud_water_rate not in", values, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateBetween(Double value1, Double value2) {
            addCriterion("pre_dehydration_mud_water_rate between", value1, value2, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andPreDehydrationMudWaterRateNotBetween(Double value1, Double value2) {
            addCriterion("pre_dehydration_mud_water_rate not between", value1, value2, "preDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeIsNull() {
            addCriterion("mud_depth_dehydration_type is null");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeIsNotNull() {
            addCriterion("mud_depth_dehydration_type is not null");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeEqualTo(Integer value) {
            addCriterion("mud_depth_dehydration_type =", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeNotEqualTo(Integer value) {
            addCriterion("mud_depth_dehydration_type <>", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeGreaterThan(Integer value) {
            addCriterion("mud_depth_dehydration_type >", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mud_depth_dehydration_type >=", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeLessThan(Integer value) {
            addCriterion("mud_depth_dehydration_type <", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mud_depth_dehydration_type <=", value, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeIn(List<Integer> values) {
            addCriterion("mud_depth_dehydration_type in", values, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeNotIn(List<Integer> values) {
            addCriterion("mud_depth_dehydration_type not in", values, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeBetween(Integer value1, Integer value2) {
            addCriterion("mud_depth_dehydration_type between", value1, value2, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andMudDepthDehydrationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mud_depth_dehydration_type not between", value1, value2, "mudDepthDehydrationType");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateIsNull() {
            addCriterion("depth_dehydration_mud_water_rate is null");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateIsNotNull() {
            addCriterion("depth_dehydration_mud_water_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateEqualTo(Double value) {
            addCriterion("depth_dehydration_mud_water_rate =", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateNotEqualTo(Double value) {
            addCriterion("depth_dehydration_mud_water_rate <>", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateGreaterThan(Double value) {
            addCriterion("depth_dehydration_mud_water_rate >", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateGreaterThanOrEqualTo(Double value) {
            addCriterion("depth_dehydration_mud_water_rate >=", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateLessThan(Double value) {
            addCriterion("depth_dehydration_mud_water_rate <", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateLessThanOrEqualTo(Double value) {
            addCriterion("depth_dehydration_mud_water_rate <=", value, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateIn(List<Double> values) {
            addCriterion("depth_dehydration_mud_water_rate in", values, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateNotIn(List<Double> values) {
            addCriterion("depth_dehydration_mud_water_rate not in", values, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateBetween(Double value1, Double value2) {
            addCriterion("depth_dehydration_mud_water_rate between", value1, value2, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andDepthDehydrationMudWaterRateNotBetween(Double value1, Double value2) {
            addCriterion("depth_dehydration_mud_water_rate not between", value1, value2, "depthDehydrationMudWaterRate");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeIsNull() {
            addCriterion("mud_transport_type is null");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeIsNotNull() {
            addCriterion("mud_transport_type is not null");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeEqualTo(Integer value) {
            addCriterion("mud_transport_type =", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeNotEqualTo(Integer value) {
            addCriterion("mud_transport_type <>", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeGreaterThan(Integer value) {
            addCriterion("mud_transport_type >", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mud_transport_type >=", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeLessThan(Integer value) {
            addCriterion("mud_transport_type <", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mud_transport_type <=", value, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeIn(List<Integer> values) {
            addCriterion("mud_transport_type in", values, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeNotIn(List<Integer> values) {
            addCriterion("mud_transport_type not in", values, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeBetween(Integer value1, Integer value2) {
            addCriterion("mud_transport_type between", value1, value2, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudTransportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mud_transport_type not between", value1, value2, "mudTransportType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeIsNull() {
            addCriterion("mud_handle_type is null");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeIsNotNull() {
            addCriterion("mud_handle_type is not null");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeEqualTo(Integer value) {
            addCriterion("mud_handle_type =", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeNotEqualTo(Integer value) {
            addCriterion("mud_handle_type <>", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeGreaterThan(Integer value) {
            addCriterion("mud_handle_type >", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mud_handle_type >=", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeLessThan(Integer value) {
            addCriterion("mud_handle_type <", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mud_handle_type <=", value, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeIn(List<Integer> values) {
            addCriterion("mud_handle_type in", values, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeNotIn(List<Integer> values) {
            addCriterion("mud_handle_type not in", values, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeBetween(Integer value1, Integer value2) {
            addCriterion("mud_handle_type between", value1, value2, "mudHandleType");
            return (Criteria) this;
        }

        public Criteria andMudHandleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mud_handle_type not between", value1, value2, "mudHandleType");
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
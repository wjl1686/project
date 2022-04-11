package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFactoryWaterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFactoryWaterExample() {
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

        public Criteria andTotalInwaterCodIsNull() {
            addCriterion("total_inwater_cod is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodIsNotNull() {
            addCriterion("total_inwater_cod is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodEqualTo(Double value) {
            addCriterion("total_inwater_cod =", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodNotEqualTo(Double value) {
            addCriterion("total_inwater_cod <>", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodGreaterThan(Double value) {
            addCriterion("total_inwater_cod >", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_cod >=", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodLessThan(Double value) {
            addCriterion("total_inwater_cod <", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_cod <=", value, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodIn(List<Double> values) {
            addCriterion("total_inwater_cod in", values, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodNotIn(List<Double> values) {
            addCriterion("total_inwater_cod not in", values, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodBetween(Double value1, Double value2) {
            addCriterion("total_inwater_cod between", value1, value2, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterCodNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_cod not between", value1, value2, "totalInwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodIsNull() {
            addCriterion("total_inwater_bod is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodIsNotNull() {
            addCriterion("total_inwater_bod is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodEqualTo(Double value) {
            addCriterion("total_inwater_bod =", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodNotEqualTo(Double value) {
            addCriterion("total_inwater_bod <>", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodGreaterThan(Double value) {
            addCriterion("total_inwater_bod >", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_bod >=", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodLessThan(Double value) {
            addCriterion("total_inwater_bod <", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_bod <=", value, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodIn(List<Double> values) {
            addCriterion("total_inwater_bod in", values, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodNotIn(List<Double> values) {
            addCriterion("total_inwater_bod not in", values, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodBetween(Double value1, Double value2) {
            addCriterion("total_inwater_bod between", value1, value2, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterBodNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_bod not between", value1, value2, "totalInwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsIsNull() {
            addCriterion("total_inwater_ss is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsIsNotNull() {
            addCriterion("total_inwater_ss is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsEqualTo(Double value) {
            addCriterion("total_inwater_ss =", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsNotEqualTo(Double value) {
            addCriterion("total_inwater_ss <>", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsGreaterThan(Double value) {
            addCriterion("total_inwater_ss >", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ss >=", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsLessThan(Double value) {
            addCriterion("total_inwater_ss <", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ss <=", value, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsIn(List<Double> values) {
            addCriterion("total_inwater_ss in", values, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsNotIn(List<Double> values) {
            addCriterion("total_inwater_ss not in", values, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ss between", value1, value2, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterSsNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ss not between", value1, value2, "totalInwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NIsNull() {
            addCriterion("total_inwater_nh3-n is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NIsNotNull() {
            addCriterion("total_inwater_nh3-n is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NEqualTo(Double value) {
            addCriterion("total_inwater_nh3-n =", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NNotEqualTo(Double value) {
            addCriterion("total_inwater_nh3-n <>", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NGreaterThan(Double value) {
            addCriterion("total_inwater_nh3-n >", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_nh3-n >=", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NLessThan(Double value) {
            addCriterion("total_inwater_nh3-n <", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_nh3-n <=", value, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NIn(List<Double> values) {
            addCriterion("total_inwater_nh3-n in", values, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NNotIn(List<Double> values) {
            addCriterion("total_inwater_nh3-n not in", values, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NBetween(Double value1, Double value2) {
            addCriterion("total_inwater_nh3-n between", value1, value2, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterNh3NNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_nh3-n not between", value1, value2, "totalInwaterNh3N");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnIsNull() {
            addCriterion("total_inwater_tn is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnIsNotNull() {
            addCriterion("total_inwater_tn is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnEqualTo(Double value) {
            addCriterion("total_inwater_tn =", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnNotEqualTo(Double value) {
            addCriterion("total_inwater_tn <>", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnGreaterThan(Double value) {
            addCriterion("total_inwater_tn >", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_tn >=", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnLessThan(Double value) {
            addCriterion("total_inwater_tn <", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_tn <=", value, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnIn(List<Double> values) {
            addCriterion("total_inwater_tn in", values, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnNotIn(List<Double> values) {
            addCriterion("total_inwater_tn not in", values, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnBetween(Double value1, Double value2) {
            addCriterion("total_inwater_tn between", value1, value2, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTnNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_tn not between", value1, value2, "totalInwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpIsNull() {
            addCriterion("total_inwater_tp is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpIsNotNull() {
            addCriterion("total_inwater_tp is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpEqualTo(Double value) {
            addCriterion("total_inwater_tp =", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpNotEqualTo(Double value) {
            addCriterion("total_inwater_tp <>", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpGreaterThan(Double value) {
            addCriterion("total_inwater_tp >", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_tp >=", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpLessThan(Double value) {
            addCriterion("total_inwater_tp <", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_tp <=", value, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpIn(List<Double> values) {
            addCriterion("total_inwater_tp in", values, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpNotIn(List<Double> values) {
            addCriterion("total_inwater_tp not in", values, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpBetween(Double value1, Double value2) {
            addCriterion("total_inwater_tp between", value1, value2, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterTpNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_tp not between", value1, value2, "totalInwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpIsNull() {
            addCriterion("total_inwater_ph_up is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpIsNotNull() {
            addCriterion("total_inwater_ph_up is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpEqualTo(Double value) {
            addCriterion("total_inwater_ph_up =", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpNotEqualTo(Double value) {
            addCriterion("total_inwater_ph_up <>", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpGreaterThan(Double value) {
            addCriterion("total_inwater_ph_up >", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ph_up >=", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpLessThan(Double value) {
            addCriterion("total_inwater_ph_up <", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ph_up <=", value, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpIn(List<Double> values) {
            addCriterion("total_inwater_ph_up in", values, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpNotIn(List<Double> values) {
            addCriterion("total_inwater_ph_up not in", values, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ph_up between", value1, value2, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhUpNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ph_up not between", value1, value2, "totalInwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownIsNull() {
            addCriterion("total_inwater_ph_down is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownIsNotNull() {
            addCriterion("total_inwater_ph_down is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownEqualTo(Double value) {
            addCriterion("total_inwater_ph_down =", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownNotEqualTo(Double value) {
            addCriterion("total_inwater_ph_down <>", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownGreaterThan(Double value) {
            addCriterion("total_inwater_ph_down >", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownGreaterThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ph_down >=", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownLessThan(Double value) {
            addCriterion("total_inwater_ph_down <", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownLessThanOrEqualTo(Double value) {
            addCriterion("total_inwater_ph_down <=", value, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownIn(List<Double> values) {
            addCriterion("total_inwater_ph_down in", values, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownNotIn(List<Double> values) {
            addCriterion("total_inwater_ph_down not in", values, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ph_down between", value1, value2, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterPhDownNotBetween(Double value1, Double value2) {
            addCriterion("total_inwater_ph_down not between", value1, value2, "totalInwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaIsNull() {
            addCriterion("total_inwater_chroma is null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaIsNotNull() {
            addCriterion("total_inwater_chroma is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaEqualTo(Integer value) {
            addCriterion("total_inwater_chroma =", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaNotEqualTo(Integer value) {
            addCriterion("total_inwater_chroma <>", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaGreaterThan(Integer value) {
            addCriterion("total_inwater_chroma >", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_inwater_chroma >=", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaLessThan(Integer value) {
            addCriterion("total_inwater_chroma <", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaLessThanOrEqualTo(Integer value) {
            addCriterion("total_inwater_chroma <=", value, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaIn(List<Integer> values) {
            addCriterion("total_inwater_chroma in", values, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaNotIn(List<Integer> values) {
            addCriterion("total_inwater_chroma not in", values, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaBetween(Integer value1, Integer value2) {
            addCriterion("total_inwater_chroma between", value1, value2, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalInwaterChromaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_inwater_chroma not between", value1, value2, "totalInwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodIsNull() {
            addCriterion("total_outwater_cod is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodIsNotNull() {
            addCriterion("total_outwater_cod is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodEqualTo(Double value) {
            addCriterion("total_outwater_cod =", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodNotEqualTo(Double value) {
            addCriterion("total_outwater_cod <>", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodGreaterThan(Double value) {
            addCriterion("total_outwater_cod >", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_cod >=", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodLessThan(Double value) {
            addCriterion("total_outwater_cod <", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_cod <=", value, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodIn(List<Double> values) {
            addCriterion("total_outwater_cod in", values, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodNotIn(List<Double> values) {
            addCriterion("total_outwater_cod not in", values, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodBetween(Double value1, Double value2) {
            addCriterion("total_outwater_cod between", value1, value2, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterCodNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_cod not between", value1, value2, "totalOutwaterCod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodIsNull() {
            addCriterion("total_outwater_bod is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodIsNotNull() {
            addCriterion("total_outwater_bod is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodEqualTo(Double value) {
            addCriterion("total_outwater_bod =", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodNotEqualTo(Double value) {
            addCriterion("total_outwater_bod <>", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodGreaterThan(Double value) {
            addCriterion("total_outwater_bod >", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_bod >=", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodLessThan(Double value) {
            addCriterion("total_outwater_bod <", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_bod <=", value, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodIn(List<Double> values) {
            addCriterion("total_outwater_bod in", values, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodNotIn(List<Double> values) {
            addCriterion("total_outwater_bod not in", values, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodBetween(Double value1, Double value2) {
            addCriterion("total_outwater_bod between", value1, value2, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterBodNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_bod not between", value1, value2, "totalOutwaterBod");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsIsNull() {
            addCriterion("total_outwater_ss is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsIsNotNull() {
            addCriterion("total_outwater_ss is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsEqualTo(Double value) {
            addCriterion("total_outwater_ss =", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsNotEqualTo(Double value) {
            addCriterion("total_outwater_ss <>", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsGreaterThan(Double value) {
            addCriterion("total_outwater_ss >", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ss >=", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsLessThan(Double value) {
            addCriterion("total_outwater_ss <", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ss <=", value, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsIn(List<Double> values) {
            addCriterion("total_outwater_ss in", values, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsNotIn(List<Double> values) {
            addCriterion("total_outwater_ss not in", values, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ss between", value1, value2, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterSsNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ss not between", value1, value2, "totalOutwaterSs");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1IsNull() {
            addCriterion("total_outwater_nh3-n_1 is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1IsNotNull() {
            addCriterion("total_outwater_nh3-n_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1EqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_1 =", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1NotEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_1 <>", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1GreaterThan(Double value) {
            addCriterion("total_outwater_nh3-n_1 >", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1GreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_1 >=", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1LessThan(Double value) {
            addCriterion("total_outwater_nh3-n_1 <", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1LessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_1 <=", value, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1In(List<Double> values) {
            addCriterion("total_outwater_nh3-n_1 in", values, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1NotIn(List<Double> values) {
            addCriterion("total_outwater_nh3-n_1 not in", values, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1Between(Double value1, Double value2) {
            addCriterion("total_outwater_nh3-n_1 between", value1, value2, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N1NotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_nh3-n_1 not between", value1, value2, "totalOutwaterNh3N1");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2IsNull() {
            addCriterion("total_outwater_nh3-n_2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2IsNotNull() {
            addCriterion("total_outwater_nh3-n_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2EqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_2 =", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2NotEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_2 <>", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2GreaterThan(Double value) {
            addCriterion("total_outwater_nh3-n_2 >", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2GreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_2 >=", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2LessThan(Double value) {
            addCriterion("total_outwater_nh3-n_2 <", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2LessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_nh3-n_2 <=", value, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2In(List<Double> values) {
            addCriterion("total_outwater_nh3-n_2 in", values, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2NotIn(List<Double> values) {
            addCriterion("total_outwater_nh3-n_2 not in", values, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2Between(Double value1, Double value2) {
            addCriterion("total_outwater_nh3-n_2 between", value1, value2, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterNh3N2NotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_nh3-n_2 not between", value1, value2, "totalOutwaterNh3N2");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnIsNull() {
            addCriterion("total_outwater_tn is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnIsNotNull() {
            addCriterion("total_outwater_tn is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnEqualTo(Double value) {
            addCriterion("total_outwater_tn =", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnNotEqualTo(Double value) {
            addCriterion("total_outwater_tn <>", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnGreaterThan(Double value) {
            addCriterion("total_outwater_tn >", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_tn >=", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnLessThan(Double value) {
            addCriterion("total_outwater_tn <", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_tn <=", value, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnIn(List<Double> values) {
            addCriterion("total_outwater_tn in", values, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnNotIn(List<Double> values) {
            addCriterion("total_outwater_tn not in", values, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnBetween(Double value1, Double value2) {
            addCriterion("total_outwater_tn between", value1, value2, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTnNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_tn not between", value1, value2, "totalOutwaterTn");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpIsNull() {
            addCriterion("total_outwater_tp is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpIsNotNull() {
            addCriterion("total_outwater_tp is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpEqualTo(Double value) {
            addCriterion("total_outwater_tp =", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpNotEqualTo(Double value) {
            addCriterion("total_outwater_tp <>", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpGreaterThan(Double value) {
            addCriterion("total_outwater_tp >", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_tp >=", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpLessThan(Double value) {
            addCriterion("total_outwater_tp <", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_tp <=", value, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpIn(List<Double> values) {
            addCriterion("total_outwater_tp in", values, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpNotIn(List<Double> values) {
            addCriterion("total_outwater_tp not in", values, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpBetween(Double value1, Double value2) {
            addCriterion("total_outwater_tp between", value1, value2, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTpNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_tp not between", value1, value2, "totalOutwaterTp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpIsNull() {
            addCriterion("total_outwater_ph_up is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpIsNotNull() {
            addCriterion("total_outwater_ph_up is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpEqualTo(Double value) {
            addCriterion("total_outwater_ph_up =", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpNotEqualTo(Double value) {
            addCriterion("total_outwater_ph_up <>", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpGreaterThan(Double value) {
            addCriterion("total_outwater_ph_up >", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ph_up >=", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpLessThan(Double value) {
            addCriterion("total_outwater_ph_up <", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ph_up <=", value, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpIn(List<Double> values) {
            addCriterion("total_outwater_ph_up in", values, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpNotIn(List<Double> values) {
            addCriterion("total_outwater_ph_up not in", values, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ph_up between", value1, value2, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhUpNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ph_up not between", value1, value2, "totalOutwaterPhUp");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownIsNull() {
            addCriterion("total_outwater_ph_down is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownIsNotNull() {
            addCriterion("total_outwater_ph_down is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownEqualTo(Double value) {
            addCriterion("total_outwater_ph_down =", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownNotEqualTo(Double value) {
            addCriterion("total_outwater_ph_down <>", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownGreaterThan(Double value) {
            addCriterion("total_outwater_ph_down >", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ph_down >=", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownLessThan(Double value) {
            addCriterion("total_outwater_ph_down <", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_ph_down <=", value, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownIn(List<Double> values) {
            addCriterion("total_outwater_ph_down in", values, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownNotIn(List<Double> values) {
            addCriterion("total_outwater_ph_down not in", values, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ph_down between", value1, value2, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterPhDownNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_ph_down not between", value1, value2, "totalOutwaterPhDown");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaIsNull() {
            addCriterion("total_outwater_chroma is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaIsNotNull() {
            addCriterion("total_outwater_chroma is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaEqualTo(Integer value) {
            addCriterion("total_outwater_chroma =", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaNotEqualTo(Integer value) {
            addCriterion("total_outwater_chroma <>", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaGreaterThan(Integer value) {
            addCriterion("total_outwater_chroma >", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_chroma >=", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaLessThan(Integer value) {
            addCriterion("total_outwater_chroma <", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaLessThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_chroma <=", value, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaIn(List<Integer> values) {
            addCriterion("total_outwater_chroma in", values, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaNotIn(List<Integer> values) {
            addCriterion("total_outwater_chroma not in", values, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_chroma between", value1, value2, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterChromaNotBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_chroma not between", value1, value2, "totalOutwaterChroma");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformIsNull() {
            addCriterion("total_outwater_coliform is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformIsNotNull() {
            addCriterion("total_outwater_coliform is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformEqualTo(Integer value) {
            addCriterion("total_outwater_coliform =", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformNotEqualTo(Integer value) {
            addCriterion("total_outwater_coliform <>", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformGreaterThan(Integer value) {
            addCriterion("total_outwater_coliform >", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_coliform >=", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformLessThan(Integer value) {
            addCriterion("total_outwater_coliform <", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformLessThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_coliform <=", value, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformIn(List<Integer> values) {
            addCriterion("total_outwater_coliform in", values, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformNotIn(List<Integer> values) {
            addCriterion("total_outwater_coliform not in", values, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_coliform between", value1, value2, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterColiformNotBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_coliform not between", value1, value2, "totalOutwaterColiform");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityIsNull() {
            addCriterion("total_outwater_turbidity is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityIsNotNull() {
            addCriterion("total_outwater_turbidity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityEqualTo(Integer value) {
            addCriterion("total_outwater_turbidity =", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityNotEqualTo(Integer value) {
            addCriterion("total_outwater_turbidity <>", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityGreaterThan(Integer value) {
            addCriterion("total_outwater_turbidity >", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_turbidity >=", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityLessThan(Integer value) {
            addCriterion("total_outwater_turbidity <", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityLessThanOrEqualTo(Integer value) {
            addCriterion("total_outwater_turbidity <=", value, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityIn(List<Integer> values) {
            addCriterion("total_outwater_turbidity in", values, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityNotIn(List<Integer> values) {
            addCriterion("total_outwater_turbidity not in", values, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_turbidity between", value1, value2, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterTurbidityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_outwater_turbidity not between", value1, value2, "totalOutwaterTurbidity");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionIsNull() {
            addCriterion("total_outwater_dissolution is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionIsNotNull() {
            addCriterion("total_outwater_dissolution is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionEqualTo(Double value) {
            addCriterion("total_outwater_dissolution =", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionNotEqualTo(Double value) {
            addCriterion("total_outwater_dissolution <>", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionGreaterThan(Double value) {
            addCriterion("total_outwater_dissolution >", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_dissolution >=", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionLessThan(Double value) {
            addCriterion("total_outwater_dissolution <", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_dissolution <=", value, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionIn(List<Double> values) {
            addCriterion("total_outwater_dissolution in", values, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionNotIn(List<Double> values) {
            addCriterion("total_outwater_dissolution not in", values, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionBetween(Double value1, Double value2) {
            addCriterion("total_outwater_dissolution between", value1, value2, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterDissolutionNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_dissolution not between", value1, value2, "totalOutwaterDissolution");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessIsNull() {
            addCriterion("total_outwater_hardness is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessIsNotNull() {
            addCriterion("total_outwater_hardness is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessEqualTo(Double value) {
            addCriterion("total_outwater_hardness =", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessNotEqualTo(Double value) {
            addCriterion("total_outwater_hardness <>", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessGreaterThan(Double value) {
            addCriterion("total_outwater_hardness >", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_hardness >=", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessLessThan(Double value) {
            addCriterion("total_outwater_hardness <", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_hardness <=", value, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessIn(List<Double> values) {
            addCriterion("total_outwater_hardness in", values, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessNotIn(List<Double> values) {
            addCriterion("total_outwater_hardness not in", values, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessBetween(Double value1, Double value2) {
            addCriterion("total_outwater_hardness between", value1, value2, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterHardnessNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_hardness not between", value1, value2, "totalOutwaterHardness");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionIsNull() {
            addCriterion("total_outwater_anion is null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionIsNotNull() {
            addCriterion("total_outwater_anion is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionEqualTo(Double value) {
            addCriterion("total_outwater_anion =", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionNotEqualTo(Double value) {
            addCriterion("total_outwater_anion <>", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionGreaterThan(Double value) {
            addCriterion("total_outwater_anion >", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionGreaterThanOrEqualTo(Double value) {
            addCriterion("total_outwater_anion >=", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionLessThan(Double value) {
            addCriterion("total_outwater_anion <", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionLessThanOrEqualTo(Double value) {
            addCriterion("total_outwater_anion <=", value, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionIn(List<Double> values) {
            addCriterion("total_outwater_anion in", values, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionNotIn(List<Double> values) {
            addCriterion("total_outwater_anion not in", values, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionBetween(Double value1, Double value2) {
            addCriterion("total_outwater_anion between", value1, value2, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andTotalOutwaterAnionNotBetween(Double value1, Double value2) {
            addCriterion("total_outwater_anion not between", value1, value2, "totalOutwaterAnion");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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
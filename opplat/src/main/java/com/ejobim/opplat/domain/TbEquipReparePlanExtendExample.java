package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbEquipReparePlanExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipReparePlanExtendExample() {
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

        public Criteria andPlanExtendNoIsNull() {
            addCriterion("plan_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoIsNotNull() {
            addCriterion("plan_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoEqualTo(String value) {
            addCriterion("plan_extend_no =", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoNotEqualTo(String value) {
            addCriterion("plan_extend_no <>", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoGreaterThan(String value) {
            addCriterion("plan_extend_no >", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("plan_extend_no >=", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoLessThan(String value) {
            addCriterion("plan_extend_no <", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoLessThanOrEqualTo(String value) {
            addCriterion("plan_extend_no <=", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoLike(String value) {
            addCriterion("plan_extend_no like", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoNotLike(String value) {
            addCriterion("plan_extend_no not like", value, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoIn(List<String> values) {
            addCriterion("plan_extend_no in", values, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoNotIn(List<String> values) {
            addCriterion("plan_extend_no not in", values, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoBetween(String value1, String value2) {
            addCriterion("plan_extend_no between", value1, value2, "planExtendNo");
            return (Criteria) this;
        }

        public Criteria andPlanExtendNoNotBetween(String value1, String value2) {
            addCriterion("plan_extend_no not between", value1, value2, "planExtendNo");
            return (Criteria) this;
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

        public Criteria andPlanUrgencyIsNull() {
            addCriterion("plan_urgency is null");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyIsNotNull() {
            addCriterion("plan_urgency is not null");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyEqualTo(Integer value) {
            addCriterion("plan_urgency =", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyNotEqualTo(Integer value) {
            addCriterion("plan_urgency <>", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyGreaterThan(Integer value) {
            addCriterion("plan_urgency >", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_urgency >=", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyLessThan(Integer value) {
            addCriterion("plan_urgency <", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyLessThanOrEqualTo(Integer value) {
            addCriterion("plan_urgency <=", value, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyIn(List<Integer> values) {
            addCriterion("plan_urgency in", values, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyNotIn(List<Integer> values) {
            addCriterion("plan_urgency not in", values, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyBetween(Integer value1, Integer value2) {
            addCriterion("plan_urgency between", value1, value2, "planUrgency");
            return (Criteria) this;
        }

        public Criteria andPlanUrgencyNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_urgency not between", value1, value2, "planUrgency");
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

        public Criteria andTbEquipReparePlanExtendcolIsNull() {
            addCriterion("tb_equip_repare_plan_extendcol is null");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolIsNotNull() {
            addCriterion("tb_equip_repare_plan_extendcol is not null");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolEqualTo(String value) {
            addCriterion("tb_equip_repare_plan_extendcol =", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolNotEqualTo(String value) {
            addCriterion("tb_equip_repare_plan_extendcol <>", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolGreaterThan(String value) {
            addCriterion("tb_equip_repare_plan_extendcol >", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolGreaterThanOrEqualTo(String value) {
            addCriterion("tb_equip_repare_plan_extendcol >=", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolLessThan(String value) {
            addCriterion("tb_equip_repare_plan_extendcol <", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolLessThanOrEqualTo(String value) {
            addCriterion("tb_equip_repare_plan_extendcol <=", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolLike(String value) {
            addCriterion("tb_equip_repare_plan_extendcol like", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolNotLike(String value) {
            addCriterion("tb_equip_repare_plan_extendcol not like", value, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolIn(List<String> values) {
            addCriterion("tb_equip_repare_plan_extendcol in", values, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolNotIn(List<String> values) {
            addCriterion("tb_equip_repare_plan_extendcol not in", values, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolBetween(String value1, String value2) {
            addCriterion("tb_equip_repare_plan_extendcol between", value1, value2, "tbEquipReparePlanExtendcol");
            return (Criteria) this;
        }

        public Criteria andTbEquipReparePlanExtendcolNotBetween(String value1, String value2) {
            addCriterion("tb_equip_repare_plan_extendcol not between", value1, value2, "tbEquipReparePlanExtendcol");
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
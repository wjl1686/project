package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFaultDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFaultDetailExample() {
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

        public Criteria andFaultDetailNoIsNull() {
            addCriterion("fault_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoIsNotNull() {
            addCriterion("fault_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoEqualTo(String value) {
            addCriterion("fault_detail_no =", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoNotEqualTo(String value) {
            addCriterion("fault_detail_no <>", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoGreaterThan(String value) {
            addCriterion("fault_detail_no >", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("fault_detail_no >=", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoLessThan(String value) {
            addCriterion("fault_detail_no <", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoLessThanOrEqualTo(String value) {
            addCriterion("fault_detail_no <=", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoLike(String value) {
            addCriterion("fault_detail_no like", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoNotLike(String value) {
            addCriterion("fault_detail_no not like", value, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoIn(List<String> values) {
            addCriterion("fault_detail_no in", values, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoNotIn(List<String> values) {
            addCriterion("fault_detail_no not in", values, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoBetween(String value1, String value2) {
            addCriterion("fault_detail_no between", value1, value2, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andFaultDetailNoNotBetween(String value1, String value2) {
            addCriterion("fault_detail_no not between", value1, value2, "faultDetailNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNull() {
            addCriterion("task_no is null");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNotNull() {
            addCriterion("task_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNoEqualTo(String value) {
            addCriterion("task_no =", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotEqualTo(String value) {
            addCriterion("task_no <>", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThan(String value) {
            addCriterion("task_no >", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("task_no >=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThan(String value) {
            addCriterion("task_no <", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThanOrEqualTo(String value) {
            addCriterion("task_no <=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLike(String value) {
            addCriterion("task_no like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotLike(String value) {
            addCriterion("task_no not like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIn(List<String> values) {
            addCriterion("task_no in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotIn(List<String> values) {
            addCriterion("task_no not in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoBetween(String value1, String value2) {
            addCriterion("task_no between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotBetween(String value1, String value2) {
            addCriterion("task_no not between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNull() {
            addCriterion("task_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNotNull() {
            addCriterion("task_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeEqualTo(String value) {
            addCriterion("task_code =", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotEqualTo(String value) {
            addCriterion("task_code <>", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThan(String value) {
            addCriterion("task_code >", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_code >=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThan(String value) {
            addCriterion("task_code <", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThanOrEqualTo(String value) {
            addCriterion("task_code <=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLike(String value) {
            addCriterion("task_code like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotLike(String value) {
            addCriterion("task_code not like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIn(List<String> values) {
            addCriterion("task_code in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotIn(List<String> values) {
            addCriterion("task_code not in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeBetween(String value1, String value2) {
            addCriterion("task_code between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotBetween(String value1, String value2) {
            addCriterion("task_code not between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andFaultNoIsNull() {
            addCriterion("fault_no is null");
            return (Criteria) this;
        }

        public Criteria andFaultNoIsNotNull() {
            addCriterion("fault_no is not null");
            return (Criteria) this;
        }

        public Criteria andFaultNoEqualTo(String value) {
            addCriterion("fault_no =", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoNotEqualTo(String value) {
            addCriterion("fault_no <>", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoGreaterThan(String value) {
            addCriterion("fault_no >", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoGreaterThanOrEqualTo(String value) {
            addCriterion("fault_no >=", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoLessThan(String value) {
            addCriterion("fault_no <", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoLessThanOrEqualTo(String value) {
            addCriterion("fault_no <=", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoLike(String value) {
            addCriterion("fault_no like", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoNotLike(String value) {
            addCriterion("fault_no not like", value, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoIn(List<String> values) {
            addCriterion("fault_no in", values, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoNotIn(List<String> values) {
            addCriterion("fault_no not in", values, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoBetween(String value1, String value2) {
            addCriterion("fault_no between", value1, value2, "faultNo");
            return (Criteria) this;
        }

        public Criteria andFaultNoNotBetween(String value1, String value2) {
            addCriterion("fault_no not between", value1, value2, "faultNo");
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

        public Criteria andFaultDescriptionIsNull() {
            addCriterion("fault_description is null");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionIsNotNull() {
            addCriterion("fault_description is not null");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionEqualTo(String value) {
            addCriterion("fault_description =", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionNotEqualTo(String value) {
            addCriterion("fault_description <>", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionGreaterThan(String value) {
            addCriterion("fault_description >", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("fault_description >=", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionLessThan(String value) {
            addCriterion("fault_description <", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionLessThanOrEqualTo(String value) {
            addCriterion("fault_description <=", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionLike(String value) {
            addCriterion("fault_description like", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionNotLike(String value) {
            addCriterion("fault_description not like", value, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionIn(List<String> values) {
            addCriterion("fault_description in", values, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionNotIn(List<String> values) {
            addCriterion("fault_description not in", values, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionBetween(String value1, String value2) {
            addCriterion("fault_description between", value1, value2, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultDescriptionNotBetween(String value1, String value2) {
            addCriterion("fault_description not between", value1, value2, "faultDescription");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisIsNull() {
            addCriterion("fault_analysis is null");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisIsNotNull() {
            addCriterion("fault_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisEqualTo(String value) {
            addCriterion("fault_analysis =", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisNotEqualTo(String value) {
            addCriterion("fault_analysis <>", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisGreaterThan(String value) {
            addCriterion("fault_analysis >", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("fault_analysis >=", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisLessThan(String value) {
            addCriterion("fault_analysis <", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisLessThanOrEqualTo(String value) {
            addCriterion("fault_analysis <=", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisLike(String value) {
            addCriterion("fault_analysis like", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisNotLike(String value) {
            addCriterion("fault_analysis not like", value, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisIn(List<String> values) {
            addCriterion("fault_analysis in", values, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisNotIn(List<String> values) {
            addCriterion("fault_analysis not in", values, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisBetween(String value1, String value2) {
            addCriterion("fault_analysis between", value1, value2, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andFaultAnalysisNotBetween(String value1, String value2) {
            addCriterion("fault_analysis not between", value1, value2, "faultAnalysis");
            return (Criteria) this;
        }

        public Criteria andDealPloyIsNull() {
            addCriterion("deal_ploy is null");
            return (Criteria) this;
        }

        public Criteria andDealPloyIsNotNull() {
            addCriterion("deal_ploy is not null");
            return (Criteria) this;
        }

        public Criteria andDealPloyEqualTo(String value) {
            addCriterion("deal_ploy =", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyNotEqualTo(String value) {
            addCriterion("deal_ploy <>", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyGreaterThan(String value) {
            addCriterion("deal_ploy >", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyGreaterThanOrEqualTo(String value) {
            addCriterion("deal_ploy >=", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyLessThan(String value) {
            addCriterion("deal_ploy <", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyLessThanOrEqualTo(String value) {
            addCriterion("deal_ploy <=", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyLike(String value) {
            addCriterion("deal_ploy like", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyNotLike(String value) {
            addCriterion("deal_ploy not like", value, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyIn(List<String> values) {
            addCriterion("deal_ploy in", values, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyNotIn(List<String> values) {
            addCriterion("deal_ploy not in", values, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyBetween(String value1, String value2) {
            addCriterion("deal_ploy between", value1, value2, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andDealPloyNotBetween(String value1, String value2) {
            addCriterion("deal_ploy not between", value1, value2, "dealPloy");
            return (Criteria) this;
        }

        public Criteria andFaultPicIsNull() {
            addCriterion("fault_pic is null");
            return (Criteria) this;
        }

        public Criteria andFaultPicIsNotNull() {
            addCriterion("fault_pic is not null");
            return (Criteria) this;
        }

        public Criteria andFaultPicEqualTo(String value) {
            addCriterion("fault_pic =", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicNotEqualTo(String value) {
            addCriterion("fault_pic <>", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicGreaterThan(String value) {
            addCriterion("fault_pic >", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicGreaterThanOrEqualTo(String value) {
            addCriterion("fault_pic >=", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicLessThan(String value) {
            addCriterion("fault_pic <", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicLessThanOrEqualTo(String value) {
            addCriterion("fault_pic <=", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicLike(String value) {
            addCriterion("fault_pic like", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicNotLike(String value) {
            addCriterion("fault_pic not like", value, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicIn(List<String> values) {
            addCriterion("fault_pic in", values, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicNotIn(List<String> values) {
            addCriterion("fault_pic not in", values, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicBetween(String value1, String value2) {
            addCriterion("fault_pic between", value1, value2, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultPicNotBetween(String value1, String value2) {
            addCriterion("fault_pic not between", value1, value2, "faultPic");
            return (Criteria) this;
        }

        public Criteria andFaultTimeIsNull() {
            addCriterion("fault_time is null");
            return (Criteria) this;
        }

        public Criteria andFaultTimeIsNotNull() {
            addCriterion("fault_time is not null");
            return (Criteria) this;
        }

        public Criteria andFaultTimeEqualTo(Date value) {
            addCriterion("fault_time =", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeNotEqualTo(Date value) {
            addCriterion("fault_time <>", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeGreaterThan(Date value) {
            addCriterion("fault_time >", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fault_time >=", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeLessThan(Date value) {
            addCriterion("fault_time <", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeLessThanOrEqualTo(Date value) {
            addCriterion("fault_time <=", value, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeIn(List<Date> values) {
            addCriterion("fault_time in", values, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeNotIn(List<Date> values) {
            addCriterion("fault_time not in", values, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeBetween(Date value1, Date value2) {
            addCriterion("fault_time between", value1, value2, "faultTime");
            return (Criteria) this;
        }

        public Criteria andFaultTimeNotBetween(Date value1, Date value2) {
            addCriterion("fault_time not between", value1, value2, "faultTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
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
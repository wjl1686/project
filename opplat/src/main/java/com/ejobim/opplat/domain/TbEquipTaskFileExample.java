package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipTaskFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipTaskFileExample() {
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

        public Criteria andOfNoIsNull() {
            addCriterion("of_no is null");
            return (Criteria) this;
        }

        public Criteria andOfNoIsNotNull() {
            addCriterion("of_no is not null");
            return (Criteria) this;
        }

        public Criteria andOfNoEqualTo(String value) {
            addCriterion("of_no =", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoNotEqualTo(String value) {
            addCriterion("of_no <>", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoGreaterThan(String value) {
            addCriterion("of_no >", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoGreaterThanOrEqualTo(String value) {
            addCriterion("of_no >=", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoLessThan(String value) {
            addCriterion("of_no <", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoLessThanOrEqualTo(String value) {
            addCriterion("of_no <=", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoLike(String value) {
            addCriterion("of_no like", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoNotLike(String value) {
            addCriterion("of_no not like", value, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoIn(List<String> values) {
            addCriterion("of_no in", values, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoNotIn(List<String> values) {
            addCriterion("of_no not in", values, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoBetween(String value1, String value2) {
            addCriterion("of_no between", value1, value2, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfNoNotBetween(String value1, String value2) {
            addCriterion("of_no not between", value1, value2, "ofNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoIsNull() {
            addCriterion("of_task_no is null");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoIsNotNull() {
            addCriterion("of_task_no is not null");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoEqualTo(String value) {
            addCriterion("of_task_no =", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoNotEqualTo(String value) {
            addCriterion("of_task_no <>", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoGreaterThan(String value) {
            addCriterion("of_task_no >", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("of_task_no >=", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoLessThan(String value) {
            addCriterion("of_task_no <", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoLessThanOrEqualTo(String value) {
            addCriterion("of_task_no <=", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoLike(String value) {
            addCriterion("of_task_no like", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoNotLike(String value) {
            addCriterion("of_task_no not like", value, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoIn(List<String> values) {
            addCriterion("of_task_no in", values, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoNotIn(List<String> values) {
            addCriterion("of_task_no not in", values, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoBetween(String value1, String value2) {
            addCriterion("of_task_no between", value1, value2, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskNoNotBetween(String value1, String value2) {
            addCriterion("of_task_no not between", value1, value2, "ofTaskNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoIsNull() {
            addCriterion("of_task_extend_no is null");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoIsNotNull() {
            addCriterion("of_task_extend_no is not null");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoEqualTo(String value) {
            addCriterion("of_task_extend_no =", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoNotEqualTo(String value) {
            addCriterion("of_task_extend_no <>", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoGreaterThan(String value) {
            addCriterion("of_task_extend_no >", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoGreaterThanOrEqualTo(String value) {
            addCriterion("of_task_extend_no >=", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoLessThan(String value) {
            addCriterion("of_task_extend_no <", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoLessThanOrEqualTo(String value) {
            addCriterion("of_task_extend_no <=", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoLike(String value) {
            addCriterion("of_task_extend_no like", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoNotLike(String value) {
            addCriterion("of_task_extend_no not like", value, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoIn(List<String> values) {
            addCriterion("of_task_extend_no in", values, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoNotIn(List<String> values) {
            addCriterion("of_task_extend_no not in", values, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoBetween(String value1, String value2) {
            addCriterion("of_task_extend_no between", value1, value2, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskExtendNoNotBetween(String value1, String value2) {
            addCriterion("of_task_extend_no not between", value1, value2, "ofTaskExtendNo");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusIsNull() {
            addCriterion("of_task_status is null");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusIsNotNull() {
            addCriterion("of_task_status is not null");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusEqualTo(Integer value) {
            addCriterion("of_task_status =", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusNotEqualTo(Integer value) {
            addCriterion("of_task_status <>", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusGreaterThan(Integer value) {
            addCriterion("of_task_status >", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("of_task_status >=", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusLessThan(Integer value) {
            addCriterion("of_task_status <", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("of_task_status <=", value, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusIn(List<Integer> values) {
            addCriterion("of_task_status in", values, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusNotIn(List<Integer> values) {
            addCriterion("of_task_status not in", values, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("of_task_status between", value1, value2, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("of_task_status not between", value1, value2, "ofTaskStatus");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeIsNull() {
            addCriterion("of_task_status_code is null");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeIsNotNull() {
            addCriterion("of_task_status_code is not null");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeEqualTo(String value) {
            addCriterion("of_task_status_code =", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeNotEqualTo(String value) {
            addCriterion("of_task_status_code <>", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeGreaterThan(String value) {
            addCriterion("of_task_status_code >", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("of_task_status_code >=", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeLessThan(String value) {
            addCriterion("of_task_status_code <", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeLessThanOrEqualTo(String value) {
            addCriterion("of_task_status_code <=", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeLike(String value) {
            addCriterion("of_task_status_code like", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeNotLike(String value) {
            addCriterion("of_task_status_code not like", value, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeIn(List<String> values) {
            addCriterion("of_task_status_code in", values, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeNotIn(List<String> values) {
            addCriterion("of_task_status_code not in", values, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeBetween(String value1, String value2) {
            addCriterion("of_task_status_code between", value1, value2, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfTaskStatusCodeNotBetween(String value1, String value2) {
            addCriterion("of_task_status_code not between", value1, value2, "ofTaskStatusCode");
            return (Criteria) this;
        }

        public Criteria andOfFileNameIsNull() {
            addCriterion("of_file_name is null");
            return (Criteria) this;
        }

        public Criteria andOfFileNameIsNotNull() {
            addCriterion("of_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andOfFileNameEqualTo(String value) {
            addCriterion("of_file_name =", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameNotEqualTo(String value) {
            addCriterion("of_file_name <>", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameGreaterThan(String value) {
            addCriterion("of_file_name >", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("of_file_name >=", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameLessThan(String value) {
            addCriterion("of_file_name <", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameLessThanOrEqualTo(String value) {
            addCriterion("of_file_name <=", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameLike(String value) {
            addCriterion("of_file_name like", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameNotLike(String value) {
            addCriterion("of_file_name not like", value, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameIn(List<String> values) {
            addCriterion("of_file_name in", values, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameNotIn(List<String> values) {
            addCriterion("of_file_name not in", values, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameBetween(String value1, String value2) {
            addCriterion("of_file_name between", value1, value2, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileNameNotBetween(String value1, String value2) {
            addCriterion("of_file_name not between", value1, value2, "ofFileName");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlIsNull() {
            addCriterion("of_file_url is null");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlIsNotNull() {
            addCriterion("of_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlEqualTo(String value) {
            addCriterion("of_file_url =", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlNotEqualTo(String value) {
            addCriterion("of_file_url <>", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlGreaterThan(String value) {
            addCriterion("of_file_url >", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("of_file_url >=", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlLessThan(String value) {
            addCriterion("of_file_url <", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlLessThanOrEqualTo(String value) {
            addCriterion("of_file_url <=", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlLike(String value) {
            addCriterion("of_file_url like", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlNotLike(String value) {
            addCriterion("of_file_url not like", value, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlIn(List<String> values) {
            addCriterion("of_file_url in", values, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlNotIn(List<String> values) {
            addCriterion("of_file_url not in", values, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlBetween(String value1, String value2) {
            addCriterion("of_file_url between", value1, value2, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfFileUrlNotBetween(String value1, String value2) {
            addCriterion("of_file_url not between", value1, value2, "ofFileUrl");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeIsNull() {
            addCriterion("of_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeIsNotNull() {
            addCriterion("of_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeEqualTo(Date value) {
            addCriterion("of_upload_time =", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeNotEqualTo(Date value) {
            addCriterion("of_upload_time <>", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeGreaterThan(Date value) {
            addCriterion("of_upload_time >", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("of_upload_time >=", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeLessThan(Date value) {
            addCriterion("of_upload_time <", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("of_upload_time <=", value, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeIn(List<Date> values) {
            addCriterion("of_upload_time in", values, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeNotIn(List<Date> values) {
            addCriterion("of_upload_time not in", values, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeBetween(Date value1, Date value2) {
            addCriterion("of_upload_time between", value1, value2, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("of_upload_time not between", value1, value2, "ofUploadTime");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusIsNull() {
            addCriterion("of_file_status is null");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusIsNotNull() {
            addCriterion("of_file_status is not null");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusEqualTo(Integer value) {
            addCriterion("of_file_status =", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusNotEqualTo(Integer value) {
            addCriterion("of_file_status <>", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusGreaterThan(Integer value) {
            addCriterion("of_file_status >", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("of_file_status >=", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusLessThan(Integer value) {
            addCriterion("of_file_status <", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusLessThanOrEqualTo(Integer value) {
            addCriterion("of_file_status <=", value, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusIn(List<Integer> values) {
            addCriterion("of_file_status in", values, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusNotIn(List<Integer> values) {
            addCriterion("of_file_status not in", values, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusBetween(Integer value1, Integer value2) {
            addCriterion("of_file_status between", value1, value2, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFileStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("of_file_status not between", value1, value2, "ofFileStatus");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoIsNull() {
            addCriterion("of_factory_no is null");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoIsNotNull() {
            addCriterion("of_factory_no is not null");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoEqualTo(String value) {
            addCriterion("of_factory_no =", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoNotEqualTo(String value) {
            addCriterion("of_factory_no <>", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoGreaterThan(String value) {
            addCriterion("of_factory_no >", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoGreaterThanOrEqualTo(String value) {
            addCriterion("of_factory_no >=", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoLessThan(String value) {
            addCriterion("of_factory_no <", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoLessThanOrEqualTo(String value) {
            addCriterion("of_factory_no <=", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoLike(String value) {
            addCriterion("of_factory_no like", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoNotLike(String value) {
            addCriterion("of_factory_no not like", value, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoIn(List<String> values) {
            addCriterion("of_factory_no in", values, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoNotIn(List<String> values) {
            addCriterion("of_factory_no not in", values, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoBetween(String value1, String value2) {
            addCriterion("of_factory_no between", value1, value2, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfFactoryNoNotBetween(String value1, String value2) {
            addCriterion("of_factory_no not between", value1, value2, "ofFactoryNo");
            return (Criteria) this;
        }

        public Criteria andOfTypeIsNull() {
            addCriterion("of_type is null");
            return (Criteria) this;
        }

        public Criteria andOfTypeIsNotNull() {
            addCriterion("of_type is not null");
            return (Criteria) this;
        }

        public Criteria andOfTypeEqualTo(Integer value) {
            addCriterion("of_type =", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeNotEqualTo(Integer value) {
            addCriterion("of_type <>", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeGreaterThan(Integer value) {
            addCriterion("of_type >", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("of_type >=", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeLessThan(Integer value) {
            addCriterion("of_type <", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeLessThanOrEqualTo(Integer value) {
            addCriterion("of_type <=", value, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeIn(List<Integer> values) {
            addCriterion("of_type in", values, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeNotIn(List<Integer> values) {
            addCriterion("of_type not in", values, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeBetween(Integer value1, Integer value2) {
            addCriterion("of_type between", value1, value2, "ofType");
            return (Criteria) this;
        }

        public Criteria andOfTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("of_type not between", value1, value2, "ofType");
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
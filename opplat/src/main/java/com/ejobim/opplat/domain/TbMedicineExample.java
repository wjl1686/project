package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMedicineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMedicineExample() {
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

        public Criteria andMedicineNoIsNull() {
            addCriterion("medicine_no is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNoIsNotNull() {
            addCriterion("medicine_no is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNoEqualTo(String value) {
            addCriterion("medicine_no =", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoNotEqualTo(String value) {
            addCriterion("medicine_no <>", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoGreaterThan(String value) {
            addCriterion("medicine_no >", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_no >=", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoLessThan(String value) {
            addCriterion("medicine_no <", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoLessThanOrEqualTo(String value) {
            addCriterion("medicine_no <=", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoLike(String value) {
            addCriterion("medicine_no like", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoNotLike(String value) {
            addCriterion("medicine_no not like", value, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoIn(List<String> values) {
            addCriterion("medicine_no in", values, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoNotIn(List<String> values) {
            addCriterion("medicine_no not in", values, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoBetween(String value1, String value2) {
            addCriterion("medicine_no between", value1, value2, "medicineNo");
            return (Criteria) this;
        }

        public Criteria andMedicineNoNotBetween(String value1, String value2) {
            addCriterion("medicine_no not between", value1, value2, "medicineNo");
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

        public Criteria andTargetNoIsNull() {
            addCriterion("target_no is null");
            return (Criteria) this;
        }

        public Criteria andTargetNoIsNotNull() {
            addCriterion("target_no is not null");
            return (Criteria) this;
        }

        public Criteria andTargetNoEqualTo(String value) {
            addCriterion("target_no =", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoNotEqualTo(String value) {
            addCriterion("target_no <>", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoGreaterThan(String value) {
            addCriterion("target_no >", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoGreaterThanOrEqualTo(String value) {
            addCriterion("target_no >=", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoLessThan(String value) {
            addCriterion("target_no <", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoLessThanOrEqualTo(String value) {
            addCriterion("target_no <=", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoLike(String value) {
            addCriterion("target_no like", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoNotLike(String value) {
            addCriterion("target_no not like", value, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoIn(List<String> values) {
            addCriterion("target_no in", values, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoNotIn(List<String> values) {
            addCriterion("target_no not in", values, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoBetween(String value1, String value2) {
            addCriterion("target_no between", value1, value2, "targetNo");
            return (Criteria) this;
        }

        public Criteria andTargetNoNotBetween(String value1, String value2) {
            addCriterion("target_no not between", value1, value2, "targetNo");
            return (Criteria) this;
        }

        public Criteria andChemicalNameIsNull() {
            addCriterion("chemical_name is null");
            return (Criteria) this;
        }

        public Criteria andChemicalNameIsNotNull() {
            addCriterion("chemical_name is not null");
            return (Criteria) this;
        }

        public Criteria andChemicalNameEqualTo(String value) {
            addCriterion("chemical_name =", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameNotEqualTo(String value) {
            addCriterion("chemical_name <>", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameGreaterThan(String value) {
            addCriterion("chemical_name >", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("chemical_name >=", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameLessThan(String value) {
            addCriterion("chemical_name <", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameLessThanOrEqualTo(String value) {
            addCriterion("chemical_name <=", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameLike(String value) {
            addCriterion("chemical_name like", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameNotLike(String value) {
            addCriterion("chemical_name not like", value, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameIn(List<String> values) {
            addCriterion("chemical_name in", values, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameNotIn(List<String> values) {
            addCriterion("chemical_name not in", values, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameBetween(String value1, String value2) {
            addCriterion("chemical_name between", value1, value2, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalNameNotBetween(String value1, String value2) {
            addCriterion("chemical_name not between", value1, value2, "chemicalName");
            return (Criteria) this;
        }

        public Criteria andChemicalIsNull() {
            addCriterion("chemical is null");
            return (Criteria) this;
        }

        public Criteria andChemicalIsNotNull() {
            addCriterion("chemical is not null");
            return (Criteria) this;
        }

        public Criteria andChemicalEqualTo(String value) {
            addCriterion("chemical =", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalNotEqualTo(String value) {
            addCriterion("chemical <>", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalGreaterThan(String value) {
            addCriterion("chemical >", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalGreaterThanOrEqualTo(String value) {
            addCriterion("chemical >=", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalLessThan(String value) {
            addCriterion("chemical <", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalLessThanOrEqualTo(String value) {
            addCriterion("chemical <=", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalLike(String value) {
            addCriterion("chemical like", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalNotLike(String value) {
            addCriterion("chemical not like", value, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalIn(List<String> values) {
            addCriterion("chemical in", values, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalNotIn(List<String> values) {
            addCriterion("chemical not in", values, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalBetween(String value1, String value2) {
            addCriterion("chemical between", value1, value2, "chemical");
            return (Criteria) this;
        }

        public Criteria andChemicalNotBetween(String value1, String value2) {
            addCriterion("chemical not between", value1, value2, "chemical");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryIsNull() {
            addCriterion("medicine_category is null");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryIsNotNull() {
            addCriterion("medicine_category is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryEqualTo(String value) {
            addCriterion("medicine_category =", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryNotEqualTo(String value) {
            addCriterion("medicine_category <>", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryGreaterThan(String value) {
            addCriterion("medicine_category >", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_category >=", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryLessThan(String value) {
            addCriterion("medicine_category <", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryLessThanOrEqualTo(String value) {
            addCriterion("medicine_category <=", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryLike(String value) {
            addCriterion("medicine_category like", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryNotLike(String value) {
            addCriterion("medicine_category not like", value, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryIn(List<String> values) {
            addCriterion("medicine_category in", values, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryNotIn(List<String> values) {
            addCriterion("medicine_category not in", values, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryBetween(String value1, String value2) {
            addCriterion("medicine_category between", value1, value2, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andMedicineCategoryNotBetween(String value1, String value2) {
            addCriterion("medicine_category not between", value1, value2, "medicineCategory");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNull() {
            addCriterion("category_type is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNotNull() {
            addCriterion("category_type is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeEqualTo(String value) {
            addCriterion("category_type =", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotEqualTo(String value) {
            addCriterion("category_type <>", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThan(String value) {
            addCriterion("category_type >", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("category_type >=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThan(String value) {
            addCriterion("category_type <", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThanOrEqualTo(String value) {
            addCriterion("category_type <=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLike(String value) {
            addCriterion("category_type like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotLike(String value) {
            addCriterion("category_type not like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIn(List<String> values) {
            addCriterion("category_type in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotIn(List<String> values) {
            addCriterion("category_type not in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeBetween(String value1, String value2) {
            addCriterion("category_type between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotBetween(String value1, String value2) {
            addCriterion("category_type not between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidIsNull() {
            addCriterion("medicine_vaid is null");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidIsNotNull() {
            addCriterion("medicine_vaid is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidEqualTo(String value) {
            addCriterion("medicine_vaid =", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidNotEqualTo(String value) {
            addCriterion("medicine_vaid <>", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidGreaterThan(String value) {
            addCriterion("medicine_vaid >", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_vaid >=", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidLessThan(String value) {
            addCriterion("medicine_vaid <", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidLessThanOrEqualTo(String value) {
            addCriterion("medicine_vaid <=", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidLike(String value) {
            addCriterion("medicine_vaid like", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidNotLike(String value) {
            addCriterion("medicine_vaid not like", value, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidIn(List<String> values) {
            addCriterion("medicine_vaid in", values, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidNotIn(List<String> values) {
            addCriterion("medicine_vaid not in", values, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidBetween(String value1, String value2) {
            addCriterion("medicine_vaid between", value1, value2, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineVaidNotBetween(String value1, String value2) {
            addCriterion("medicine_vaid not between", value1, value2, "medicineVaid");
            return (Criteria) this;
        }

        public Criteria andMedicineContentIsNull() {
            addCriterion("medicine_content is null");
            return (Criteria) this;
        }

        public Criteria andMedicineContentIsNotNull() {
            addCriterion("medicine_content is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineContentEqualTo(String value) {
            addCriterion("medicine_content =", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentNotEqualTo(String value) {
            addCriterion("medicine_content <>", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentGreaterThan(String value) {
            addCriterion("medicine_content >", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_content >=", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentLessThan(String value) {
            addCriterion("medicine_content <", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentLessThanOrEqualTo(String value) {
            addCriterion("medicine_content <=", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentLike(String value) {
            addCriterion("medicine_content like", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentNotLike(String value) {
            addCriterion("medicine_content not like", value, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentIn(List<String> values) {
            addCriterion("medicine_content in", values, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentNotIn(List<String> values) {
            addCriterion("medicine_content not in", values, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentBetween(String value1, String value2) {
            addCriterion("medicine_content between", value1, value2, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andMedicineContentNotBetween(String value1, String value2) {
            addCriterion("medicine_content not between", value1, value2, "medicineContent");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNull() {
            addCriterion("report_type is null");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNotNull() {
            addCriterion("report_type is not null");
            return (Criteria) this;
        }

        public Criteria andReportTypeEqualTo(Integer value) {
            addCriterion("report_type =", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotEqualTo(Integer value) {
            addCriterion("report_type <>", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThan(Integer value) {
            addCriterion("report_type >", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_type >=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThan(Integer value) {
            addCriterion("report_type <", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("report_type <=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeIn(List<Integer> values) {
            addCriterion("report_type in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotIn(List<Integer> values) {
            addCriterion("report_type not in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("report_type between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_type not between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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
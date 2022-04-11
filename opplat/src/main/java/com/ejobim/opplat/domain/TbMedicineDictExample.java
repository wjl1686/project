package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbMedicineDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMedicineDictExample() {
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

        public Criteria andTragetNoIsNull() {
            addCriterion("traget_no is null");
            return (Criteria) this;
        }

        public Criteria andTragetNoIsNotNull() {
            addCriterion("traget_no is not null");
            return (Criteria) this;
        }

        public Criteria andTragetNoEqualTo(String value) {
            addCriterion("traget_no =", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoNotEqualTo(String value) {
            addCriterion("traget_no <>", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoGreaterThan(String value) {
            addCriterion("traget_no >", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoGreaterThanOrEqualTo(String value) {
            addCriterion("traget_no >=", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoLessThan(String value) {
            addCriterion("traget_no <", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoLessThanOrEqualTo(String value) {
            addCriterion("traget_no <=", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoLike(String value) {
            addCriterion("traget_no like", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoNotLike(String value) {
            addCriterion("traget_no not like", value, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoIn(List<String> values) {
            addCriterion("traget_no in", values, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoNotIn(List<String> values) {
            addCriterion("traget_no not in", values, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoBetween(String value1, String value2) {
            addCriterion("traget_no between", value1, value2, "tragetNo");
            return (Criteria) this;
        }

        public Criteria andTragetNoNotBetween(String value1, String value2) {
            addCriterion("traget_no not between", value1, value2, "tragetNo");
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

        public Criteria andMedicineNameIsNull() {
            addCriterion("medicine_name is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNotNull() {
            addCriterion("medicine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameEqualTo(String value) {
            addCriterion("medicine_name =", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotEqualTo(String value) {
            addCriterion("medicine_name <>", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThan(String value) {
            addCriterion("medicine_name >", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_name >=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThan(String value) {
            addCriterion("medicine_name <", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThanOrEqualTo(String value) {
            addCriterion("medicine_name <=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLike(String value) {
            addCriterion("medicine_name like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotLike(String value) {
            addCriterion("medicine_name not like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIn(List<String> values) {
            addCriterion("medicine_name in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotIn(List<String> values) {
            addCriterion("medicine_name not in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameBetween(String value1, String value2) {
            addCriterion("medicine_name between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotBetween(String value1, String value2) {
            addCriterion("medicine_name not between", value1, value2, "medicineName");
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

        public Criteria andMedicineTypeIsNull() {
            addCriterion("medicine_type is null");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeIsNotNull() {
            addCriterion("medicine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeEqualTo(String value) {
            addCriterion("medicine_type =", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotEqualTo(String value) {
            addCriterion("medicine_type <>", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeGreaterThan(String value) {
            addCriterion("medicine_type >", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_type >=", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLessThan(String value) {
            addCriterion("medicine_type <", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLessThanOrEqualTo(String value) {
            addCriterion("medicine_type <=", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLike(String value) {
            addCriterion("medicine_type like", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotLike(String value) {
            addCriterion("medicine_type not like", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeIn(List<String> values) {
            addCriterion("medicine_type in", values, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotIn(List<String> values) {
            addCriterion("medicine_type not in", values, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeBetween(String value1, String value2) {
            addCriterion("medicine_type between", value1, value2, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotBetween(String value1, String value2) {
            addCriterion("medicine_type not between", value1, value2, "medicineType");
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

        public Criteria andChooseIsNull() {
            addCriterion("choose is null");
            return (Criteria) this;
        }

        public Criteria andChooseIsNotNull() {
            addCriterion("choose is not null");
            return (Criteria) this;
        }

        public Criteria andChooseEqualTo(String value) {
            addCriterion("choose =", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotEqualTo(String value) {
            addCriterion("choose <>", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThan(String value) {
            addCriterion("choose >", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseGreaterThanOrEqualTo(String value) {
            addCriterion("choose >=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThan(String value) {
            addCriterion("choose <", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLessThanOrEqualTo(String value) {
            addCriterion("choose <=", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseLike(String value) {
            addCriterion("choose like", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotLike(String value) {
            addCriterion("choose not like", value, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseIn(List<String> values) {
            addCriterion("choose in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotIn(List<String> values) {
            addCriterion("choose not in", values, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseBetween(String value1, String value2) {
            addCriterion("choose between", value1, value2, "choose");
            return (Criteria) this;
        }

        public Criteria andChooseNotBetween(String value1, String value2) {
            addCriterion("choose not between", value1, value2, "choose");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbEquipOverhaulInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipOverhaulInfoExample() {
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

        public Criteria andOverhaulDetailNoIsNull() {
            addCriterion("overhaul_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoIsNotNull() {
            addCriterion("overhaul_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoEqualTo(String value) {
            addCriterion("overhaul_detail_no =", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoNotEqualTo(String value) {
            addCriterion("overhaul_detail_no <>", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoGreaterThan(String value) {
            addCriterion("overhaul_detail_no >", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("overhaul_detail_no >=", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoLessThan(String value) {
            addCriterion("overhaul_detail_no <", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoLessThanOrEqualTo(String value) {
            addCriterion("overhaul_detail_no <=", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoLike(String value) {
            addCriterion("overhaul_detail_no like", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoNotLike(String value) {
            addCriterion("overhaul_detail_no not like", value, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoIn(List<String> values) {
            addCriterion("overhaul_detail_no in", values, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoNotIn(List<String> values) {
            addCriterion("overhaul_detail_no not in", values, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoBetween(String value1, String value2) {
            addCriterion("overhaul_detail_no between", value1, value2, "overhaulDetailNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulDetailNoNotBetween(String value1, String value2) {
            addCriterion("overhaul_detail_no not between", value1, value2, "overhaulDetailNo");
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

        public Criteria andSuggestSparepartListsIsNull() {
            addCriterion("suggest_sparepart_lists is null");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsIsNotNull() {
            addCriterion("suggest_sparepart_lists is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsEqualTo(String value) {
            addCriterion("suggest_sparepart_lists =", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsNotEqualTo(String value) {
            addCriterion("suggest_sparepart_lists <>", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsGreaterThan(String value) {
            addCriterion("suggest_sparepart_lists >", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsGreaterThanOrEqualTo(String value) {
            addCriterion("suggest_sparepart_lists >=", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsLessThan(String value) {
            addCriterion("suggest_sparepart_lists <", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsLessThanOrEqualTo(String value) {
            addCriterion("suggest_sparepart_lists <=", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsLike(String value) {
            addCriterion("suggest_sparepart_lists like", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsNotLike(String value) {
            addCriterion("suggest_sparepart_lists not like", value, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsIn(List<String> values) {
            addCriterion("suggest_sparepart_lists in", values, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsNotIn(List<String> values) {
            addCriterion("suggest_sparepart_lists not in", values, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsBetween(String value1, String value2) {
            addCriterion("suggest_sparepart_lists between", value1, value2, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestSparepartListsNotBetween(String value1, String value2) {
            addCriterion("suggest_sparepart_lists not between", value1, value2, "suggestSparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsIsNull() {
            addCriterion("sparepart_lists is null");
            return (Criteria) this;
        }

        public Criteria andSparepartListsIsNotNull() {
            addCriterion("sparepart_lists is not null");
            return (Criteria) this;
        }

        public Criteria andSparepartListsEqualTo(String value) {
            addCriterion("sparepart_lists =", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsNotEqualTo(String value) {
            addCriterion("sparepart_lists <>", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsGreaterThan(String value) {
            addCriterion("sparepart_lists >", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsGreaterThanOrEqualTo(String value) {
            addCriterion("sparepart_lists >=", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsLessThan(String value) {
            addCriterion("sparepart_lists <", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsLessThanOrEqualTo(String value) {
            addCriterion("sparepart_lists <=", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsLike(String value) {
            addCriterion("sparepart_lists like", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsNotLike(String value) {
            addCriterion("sparepart_lists not like", value, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsIn(List<String> values) {
            addCriterion("sparepart_lists in", values, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsNotIn(List<String> values) {
            addCriterion("sparepart_lists not in", values, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsBetween(String value1, String value2) {
            addCriterion("sparepart_lists between", value1, value2, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSparepartListsNotBetween(String value1, String value2) {
            addCriterion("sparepart_lists not between", value1, value2, "sparepartLists");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoIsNull() {
            addCriterion("suggest_info is null");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoIsNotNull() {
            addCriterion("suggest_info is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoEqualTo(String value) {
            addCriterion("suggest_info =", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoNotEqualTo(String value) {
            addCriterion("suggest_info <>", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoGreaterThan(String value) {
            addCriterion("suggest_info >", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoGreaterThanOrEqualTo(String value) {
            addCriterion("suggest_info >=", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoLessThan(String value) {
            addCriterion("suggest_info <", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoLessThanOrEqualTo(String value) {
            addCriterion("suggest_info <=", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoLike(String value) {
            addCriterion("suggest_info like", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoNotLike(String value) {
            addCriterion("suggest_info not like", value, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoIn(List<String> values) {
            addCriterion("suggest_info in", values, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoNotIn(List<String> values) {
            addCriterion("suggest_info not in", values, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoBetween(String value1, String value2) {
            addCriterion("suggest_info between", value1, value2, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andSuggestInfoNotBetween(String value1, String value2) {
            addCriterion("suggest_info not between", value1, value2, "suggestInfo");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesIsNull() {
            addCriterion("overhaul_pictures is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesIsNotNull() {
            addCriterion("overhaul_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesEqualTo(String value) {
            addCriterion("overhaul_pictures =", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesNotEqualTo(String value) {
            addCriterion("overhaul_pictures <>", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesGreaterThan(String value) {
            addCriterion("overhaul_pictures >", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("overhaul_pictures >=", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesLessThan(String value) {
            addCriterion("overhaul_pictures <", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesLessThanOrEqualTo(String value) {
            addCriterion("overhaul_pictures <=", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesLike(String value) {
            addCriterion("overhaul_pictures like", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesNotLike(String value) {
            addCriterion("overhaul_pictures not like", value, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesIn(List<String> values) {
            addCriterion("overhaul_pictures in", values, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesNotIn(List<String> values) {
            addCriterion("overhaul_pictures not in", values, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesBetween(String value1, String value2) {
            addCriterion("overhaul_pictures between", value1, value2, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulPicturesNotBetween(String value1, String value2) {
            addCriterion("overhaul_pictures not between", value1, value2, "overhaulPictures");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoIsNull() {
            addCriterion("overhaul_video is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoIsNotNull() {
            addCriterion("overhaul_video is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoEqualTo(String value) {
            addCriterion("overhaul_video =", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoNotEqualTo(String value) {
            addCriterion("overhaul_video <>", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoGreaterThan(String value) {
            addCriterion("overhaul_video >", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoGreaterThanOrEqualTo(String value) {
            addCriterion("overhaul_video >=", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoLessThan(String value) {
            addCriterion("overhaul_video <", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoLessThanOrEqualTo(String value) {
            addCriterion("overhaul_video <=", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoLike(String value) {
            addCriterion("overhaul_video like", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoNotLike(String value) {
            addCriterion("overhaul_video not like", value, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoIn(List<String> values) {
            addCriterion("overhaul_video in", values, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoNotIn(List<String> values) {
            addCriterion("overhaul_video not in", values, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoBetween(String value1, String value2) {
            addCriterion("overhaul_video between", value1, value2, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulVideoNotBetween(String value1, String value2) {
            addCriterion("overhaul_video not between", value1, value2, "overhaulVideo");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkIsNull() {
            addCriterion("overhaul_sanitation_ok is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkIsNotNull() {
            addCriterion("overhaul_sanitation_ok is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkEqualTo(Integer value) {
            addCriterion("overhaul_sanitation_ok =", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkNotEqualTo(Integer value) {
            addCriterion("overhaul_sanitation_ok <>", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkGreaterThan(Integer value) {
            addCriterion("overhaul_sanitation_ok >", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_sanitation_ok >=", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkLessThan(Integer value) {
            addCriterion("overhaul_sanitation_ok <", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_sanitation_ok <=", value, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkIn(List<Integer> values) {
            addCriterion("overhaul_sanitation_ok in", values, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkNotIn(List<Integer> values) {
            addCriterion("overhaul_sanitation_ok not in", values, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_sanitation_ok between", value1, value2, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSanitationOkNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_sanitation_ok not between", value1, value2, "overhaulSanitationOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkIsNull() {
            addCriterion("overhaul_appearance_ok is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkIsNotNull() {
            addCriterion("overhaul_appearance_ok is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkEqualTo(Integer value) {
            addCriterion("overhaul_appearance_ok =", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkNotEqualTo(Integer value) {
            addCriterion("overhaul_appearance_ok <>", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkGreaterThan(Integer value) {
            addCriterion("overhaul_appearance_ok >", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_appearance_ok >=", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkLessThan(Integer value) {
            addCriterion("overhaul_appearance_ok <", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_appearance_ok <=", value, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkIn(List<Integer> values) {
            addCriterion("overhaul_appearance_ok in", values, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkNotIn(List<Integer> values) {
            addCriterion("overhaul_appearance_ok not in", values, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_appearance_ok between", value1, value2, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulAppearanceOkNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_appearance_ok not between", value1, value2, "overhaulAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkIsNull() {
            addCriterion("overhaul_conversion_ok is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkIsNotNull() {
            addCriterion("overhaul_conversion_ok is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkEqualTo(Integer value) {
            addCriterion("overhaul_conversion_ok =", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkNotEqualTo(Integer value) {
            addCriterion("overhaul_conversion_ok <>", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkGreaterThan(Integer value) {
            addCriterion("overhaul_conversion_ok >", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_conversion_ok >=", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkLessThan(Integer value) {
            addCriterion("overhaul_conversion_ok <", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_conversion_ok <=", value, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkIn(List<Integer> values) {
            addCriterion("overhaul_conversion_ok in", values, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkNotIn(List<Integer> values) {
            addCriterion("overhaul_conversion_ok not in", values, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_conversion_ok between", value1, value2, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulConversionOkNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_conversion_ok not between", value1, value2, "overhaulConversionOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkIsNull() {
            addCriterion("overhaul_sound_ok is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkIsNotNull() {
            addCriterion("overhaul_sound_ok is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkEqualTo(Integer value) {
            addCriterion("overhaul_sound_ok =", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkNotEqualTo(Integer value) {
            addCriterion("overhaul_sound_ok <>", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkGreaterThan(Integer value) {
            addCriterion("overhaul_sound_ok >", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_sound_ok >=", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkLessThan(Integer value) {
            addCriterion("overhaul_sound_ok <", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_sound_ok <=", value, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkIn(List<Integer> values) {
            addCriterion("overhaul_sound_ok in", values, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkNotIn(List<Integer> values) {
            addCriterion("overhaul_sound_ok not in", values, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_sound_ok between", value1, value2, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulSoundOkNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_sound_ok not between", value1, value2, "overhaulSoundOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkIsNull() {
            addCriterion("overhaul_temp_ok is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkIsNotNull() {
            addCriterion("overhaul_temp_ok is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkEqualTo(Integer value) {
            addCriterion("overhaul_temp_ok =", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkNotEqualTo(Integer value) {
            addCriterion("overhaul_temp_ok <>", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkGreaterThan(Integer value) {
            addCriterion("overhaul_temp_ok >", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_temp_ok >=", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkLessThan(Integer value) {
            addCriterion("overhaul_temp_ok <", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_temp_ok <=", value, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkIn(List<Integer> values) {
            addCriterion("overhaul_temp_ok in", values, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkNotIn(List<Integer> values) {
            addCriterion("overhaul_temp_ok not in", values, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_temp_ok between", value1, value2, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulTempOkNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_temp_ok not between", value1, value2, "overhaulTempOk");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentIsNull() {
            addCriterion("overhaul_electric_current is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentIsNotNull() {
            addCriterion("overhaul_electric_current is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentEqualTo(Integer value) {
            addCriterion("overhaul_electric_current =", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentNotEqualTo(Integer value) {
            addCriterion("overhaul_electric_current <>", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentGreaterThan(Integer value) {
            addCriterion("overhaul_electric_current >", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("overhaul_electric_current >=", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentLessThan(Integer value) {
            addCriterion("overhaul_electric_current <", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentLessThanOrEqualTo(Integer value) {
            addCriterion("overhaul_electric_current <=", value, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentIn(List<Integer> values) {
            addCriterion("overhaul_electric_current in", values, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentNotIn(List<Integer> values) {
            addCriterion("overhaul_electric_current not in", values, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_electric_current between", value1, value2, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andOverhaulElectricCurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("overhaul_electric_current not between", value1, value2, "overhaulElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailPartyIsNull() {
            addCriterion("detail_party is null");
            return (Criteria) this;
        }

        public Criteria andDetailPartyIsNotNull() {
            addCriterion("detail_party is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPartyEqualTo(String value) {
            addCriterion("detail_party =", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyNotEqualTo(String value) {
            addCriterion("detail_party <>", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyGreaterThan(String value) {
            addCriterion("detail_party >", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyGreaterThanOrEqualTo(String value) {
            addCriterion("detail_party >=", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyLessThan(String value) {
            addCriterion("detail_party <", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyLessThanOrEqualTo(String value) {
            addCriterion("detail_party <=", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyLike(String value) {
            addCriterion("detail_party like", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyNotLike(String value) {
            addCriterion("detail_party not like", value, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyIn(List<String> values) {
            addCriterion("detail_party in", values, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyNotIn(List<String> values) {
            addCriterion("detail_party not in", values, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyBetween(String value1, String value2) {
            addCriterion("detail_party between", value1, value2, "detailParty");
            return (Criteria) this;
        }

        public Criteria andDetailPartyNotBetween(String value1, String value2) {
            addCriterion("detail_party not between", value1, value2, "detailParty");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentIsNull() {
            addCriterion("overhaul_content is null");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentIsNotNull() {
            addCriterion("overhaul_content is not null");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentEqualTo(String value) {
            addCriterion("overhaul_content =", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentNotEqualTo(String value) {
            addCriterion("overhaul_content <>", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentGreaterThan(String value) {
            addCriterion("overhaul_content >", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentGreaterThanOrEqualTo(String value) {
            addCriterion("overhaul_content >=", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentLessThan(String value) {
            addCriterion("overhaul_content <", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentLessThanOrEqualTo(String value) {
            addCriterion("overhaul_content <=", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentLike(String value) {
            addCriterion("overhaul_content like", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentNotLike(String value) {
            addCriterion("overhaul_content not like", value, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentIn(List<String> values) {
            addCriterion("overhaul_content in", values, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentNotIn(List<String> values) {
            addCriterion("overhaul_content not in", values, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentBetween(String value1, String value2) {
            addCriterion("overhaul_content between", value1, value2, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andOverhaulContentNotBetween(String value1, String value2) {
            addCriterion("overhaul_content not between", value1, value2, "overhaulContent");
            return (Criteria) this;
        }

        public Criteria andEquipStatusIsNull() {
            addCriterion("equip_status is null");
            return (Criteria) this;
        }

        public Criteria andEquipStatusIsNotNull() {
            addCriterion("equip_status is not null");
            return (Criteria) this;
        }

        public Criteria andEquipStatusEqualTo(Integer value) {
            addCriterion("equip_status =", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotEqualTo(Integer value) {
            addCriterion("equip_status <>", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusGreaterThan(Integer value) {
            addCriterion("equip_status >", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_status >=", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusLessThan(Integer value) {
            addCriterion("equip_status <", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusLessThanOrEqualTo(Integer value) {
            addCriterion("equip_status <=", value, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusIn(List<Integer> values) {
            addCriterion("equip_status in", values, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotIn(List<Integer> values) {
            addCriterion("equip_status not in", values, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusBetween(Integer value1, Integer value2) {
            addCriterion("equip_status between", value1, value2, "equipStatus");
            return (Criteria) this;
        }

        public Criteria andEquipStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_status not between", value1, value2, "equipStatus");
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

        public Criteria andPlanCostEqualTo(Integer value) {
            addCriterion("plan_cost =", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotEqualTo(Integer value) {
            addCriterion("plan_cost <>", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThan(Integer value) {
            addCriterion("plan_cost >", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_cost >=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThan(Integer value) {
            addCriterion("plan_cost <", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostLessThanOrEqualTo(Integer value) {
            addCriterion("plan_cost <=", value, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostIn(List<Integer> values) {
            addCriterion("plan_cost in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotIn(List<Integer> values) {
            addCriterion("plan_cost not in", values, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostBetween(Integer value1, Integer value2) {
            addCriterion("plan_cost between", value1, value2, "planCost");
            return (Criteria) this;
        }

        public Criteria andPlanCostNotBetween(Integer value1, Integer value2) {
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

        public Criteria andRealCostEqualTo(Integer value) {
            addCriterion("real_cost =", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotEqualTo(Integer value) {
            addCriterion("real_cost <>", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThan(Integer value) {
            addCriterion("real_cost >", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_cost >=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThan(Integer value) {
            addCriterion("real_cost <", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostLessThanOrEqualTo(Integer value) {
            addCriterion("real_cost <=", value, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostIn(List<Integer> values) {
            addCriterion("real_cost in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotIn(List<Integer> values) {
            addCriterion("real_cost not in", values, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostBetween(Integer value1, Integer value2) {
            addCriterion("real_cost between", value1, value2, "realCost");
            return (Criteria) this;
        }

        public Criteria andRealCostNotBetween(Integer value1, Integer value2) {
            addCriterion("real_cost not between", value1, value2, "realCost");
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
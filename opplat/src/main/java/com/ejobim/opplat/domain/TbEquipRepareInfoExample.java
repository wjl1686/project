package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbEquipRepareInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipRepareInfoExample() {
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

        public Criteria andRepareDetailNoIsNull() {
            addCriterion("repare_detail_no is null");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoIsNotNull() {
            addCriterion("repare_detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoEqualTo(String value) {
            addCriterion("repare_detail_no =", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoNotEqualTo(String value) {
            addCriterion("repare_detail_no <>", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoGreaterThan(String value) {
            addCriterion("repare_detail_no >", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("repare_detail_no >=", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoLessThan(String value) {
            addCriterion("repare_detail_no <", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoLessThanOrEqualTo(String value) {
            addCriterion("repare_detail_no <=", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoLike(String value) {
            addCriterion("repare_detail_no like", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoNotLike(String value) {
            addCriterion("repare_detail_no not like", value, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoIn(List<String> values) {
            addCriterion("repare_detail_no in", values, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoNotIn(List<String> values) {
            addCriterion("repare_detail_no not in", values, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoBetween(String value1, String value2) {
            addCriterion("repare_detail_no between", value1, value2, "repareDetailNo");
            return (Criteria) this;
        }

        public Criteria andRepareDetailNoNotBetween(String value1, String value2) {
            addCriterion("repare_detail_no not between", value1, value2, "repareDetailNo");
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

        public Criteria andReparePicturesIsNull() {
            addCriterion("repare_pictures is null");
            return (Criteria) this;
        }

        public Criteria andReparePicturesIsNotNull() {
            addCriterion("repare_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andReparePicturesEqualTo(String value) {
            addCriterion("repare_pictures =", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesNotEqualTo(String value) {
            addCriterion("repare_pictures <>", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesGreaterThan(String value) {
            addCriterion("repare_pictures >", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesGreaterThanOrEqualTo(String value) {
            addCriterion("repare_pictures >=", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesLessThan(String value) {
            addCriterion("repare_pictures <", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesLessThanOrEqualTo(String value) {
            addCriterion("repare_pictures <=", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesLike(String value) {
            addCriterion("repare_pictures like", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesNotLike(String value) {
            addCriterion("repare_pictures not like", value, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesIn(List<String> values) {
            addCriterion("repare_pictures in", values, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesNotIn(List<String> values) {
            addCriterion("repare_pictures not in", values, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesBetween(String value1, String value2) {
            addCriterion("repare_pictures between", value1, value2, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andReparePicturesNotBetween(String value1, String value2) {
            addCriterion("repare_pictures not between", value1, value2, "reparePictures");
            return (Criteria) this;
        }

        public Criteria andRepareVideoIsNull() {
            addCriterion("repare_video is null");
            return (Criteria) this;
        }

        public Criteria andRepareVideoIsNotNull() {
            addCriterion("repare_video is not null");
            return (Criteria) this;
        }

        public Criteria andRepareVideoEqualTo(String value) {
            addCriterion("repare_video =", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoNotEqualTo(String value) {
            addCriterion("repare_video <>", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoGreaterThan(String value) {
            addCriterion("repare_video >", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoGreaterThanOrEqualTo(String value) {
            addCriterion("repare_video >=", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoLessThan(String value) {
            addCriterion("repare_video <", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoLessThanOrEqualTo(String value) {
            addCriterion("repare_video <=", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoLike(String value) {
            addCriterion("repare_video like", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoNotLike(String value) {
            addCriterion("repare_video not like", value, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoIn(List<String> values) {
            addCriterion("repare_video in", values, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoNotIn(List<String> values) {
            addCriterion("repare_video not in", values, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoBetween(String value1, String value2) {
            addCriterion("repare_video between", value1, value2, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareVideoNotBetween(String value1, String value2) {
            addCriterion("repare_video not between", value1, value2, "repareVideo");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkIsNull() {
            addCriterion("repare_sanitation_ok is null");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkIsNotNull() {
            addCriterion("repare_sanitation_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkEqualTo(Integer value) {
            addCriterion("repare_sanitation_ok =", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkNotEqualTo(Integer value) {
            addCriterion("repare_sanitation_ok <>", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkGreaterThan(Integer value) {
            addCriterion("repare_sanitation_ok >", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_sanitation_ok >=", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkLessThan(Integer value) {
            addCriterion("repare_sanitation_ok <", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkLessThanOrEqualTo(Integer value) {
            addCriterion("repare_sanitation_ok <=", value, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkIn(List<Integer> values) {
            addCriterion("repare_sanitation_ok in", values, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkNotIn(List<Integer> values) {
            addCriterion("repare_sanitation_ok not in", values, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkBetween(Integer value1, Integer value2) {
            addCriterion("repare_sanitation_ok between", value1, value2, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareSanitationOkNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_sanitation_ok not between", value1, value2, "repareSanitationOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkIsNull() {
            addCriterion("repare_appearance_ok is null");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkIsNotNull() {
            addCriterion("repare_appearance_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkEqualTo(Integer value) {
            addCriterion("repare_appearance_ok =", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkNotEqualTo(Integer value) {
            addCriterion("repare_appearance_ok <>", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkGreaterThan(Integer value) {
            addCriterion("repare_appearance_ok >", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_appearance_ok >=", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkLessThan(Integer value) {
            addCriterion("repare_appearance_ok <", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkLessThanOrEqualTo(Integer value) {
            addCriterion("repare_appearance_ok <=", value, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkIn(List<Integer> values) {
            addCriterion("repare_appearance_ok in", values, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkNotIn(List<Integer> values) {
            addCriterion("repare_appearance_ok not in", values, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkBetween(Integer value1, Integer value2) {
            addCriterion("repare_appearance_ok between", value1, value2, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareAppearanceOkNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_appearance_ok not between", value1, value2, "repareAppearanceOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkIsNull() {
            addCriterion("repare_conversion_ok is null");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkIsNotNull() {
            addCriterion("repare_conversion_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkEqualTo(Integer value) {
            addCriterion("repare_conversion_ok =", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkNotEqualTo(Integer value) {
            addCriterion("repare_conversion_ok <>", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkGreaterThan(Integer value) {
            addCriterion("repare_conversion_ok >", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_conversion_ok >=", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkLessThan(Integer value) {
            addCriterion("repare_conversion_ok <", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkLessThanOrEqualTo(Integer value) {
            addCriterion("repare_conversion_ok <=", value, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkIn(List<Integer> values) {
            addCriterion("repare_conversion_ok in", values, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkNotIn(List<Integer> values) {
            addCriterion("repare_conversion_ok not in", values, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkBetween(Integer value1, Integer value2) {
            addCriterion("repare_conversion_ok between", value1, value2, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareConversionOkNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_conversion_ok not between", value1, value2, "repareConversionOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkIsNull() {
            addCriterion("repare_sound_ok is null");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkIsNotNull() {
            addCriterion("repare_sound_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkEqualTo(Integer value) {
            addCriterion("repare_sound_ok =", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkNotEqualTo(Integer value) {
            addCriterion("repare_sound_ok <>", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkGreaterThan(Integer value) {
            addCriterion("repare_sound_ok >", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_sound_ok >=", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkLessThan(Integer value) {
            addCriterion("repare_sound_ok <", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkLessThanOrEqualTo(Integer value) {
            addCriterion("repare_sound_ok <=", value, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkIn(List<Integer> values) {
            addCriterion("repare_sound_ok in", values, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkNotIn(List<Integer> values) {
            addCriterion("repare_sound_ok not in", values, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkBetween(Integer value1, Integer value2) {
            addCriterion("repare_sound_ok between", value1, value2, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareSoundOkNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_sound_ok not between", value1, value2, "repareSoundOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkIsNull() {
            addCriterion("repare_temp_ok is null");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkIsNotNull() {
            addCriterion("repare_temp_ok is not null");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkEqualTo(Integer value) {
            addCriterion("repare_temp_ok =", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkNotEqualTo(Integer value) {
            addCriterion("repare_temp_ok <>", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkGreaterThan(Integer value) {
            addCriterion("repare_temp_ok >", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_temp_ok >=", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkLessThan(Integer value) {
            addCriterion("repare_temp_ok <", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkLessThanOrEqualTo(Integer value) {
            addCriterion("repare_temp_ok <=", value, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkIn(List<Integer> values) {
            addCriterion("repare_temp_ok in", values, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkNotIn(List<Integer> values) {
            addCriterion("repare_temp_ok not in", values, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkBetween(Integer value1, Integer value2) {
            addCriterion("repare_temp_ok between", value1, value2, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareTempOkNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_temp_ok not between", value1, value2, "repareTempOk");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentIsNull() {
            addCriterion("repare_electric_current is null");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentIsNotNull() {
            addCriterion("repare_electric_current is not null");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentEqualTo(Integer value) {
            addCriterion("repare_electric_current =", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentNotEqualTo(Integer value) {
            addCriterion("repare_electric_current <>", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentGreaterThan(Integer value) {
            addCriterion("repare_electric_current >", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_electric_current >=", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentLessThan(Integer value) {
            addCriterion("repare_electric_current <", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentLessThanOrEqualTo(Integer value) {
            addCriterion("repare_electric_current <=", value, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentIn(List<Integer> values) {
            addCriterion("repare_electric_current in", values, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentNotIn(List<Integer> values) {
            addCriterion("repare_electric_current not in", values, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentBetween(Integer value1, Integer value2) {
            addCriterion("repare_electric_current between", value1, value2, "repareElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andRepareElectricCurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_electric_current not between", value1, value2, "repareElectricCurrent");
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

        public Criteria andRepareContentIsNull() {
            addCriterion("repare_content is null");
            return (Criteria) this;
        }

        public Criteria andRepareContentIsNotNull() {
            addCriterion("repare_content is not null");
            return (Criteria) this;
        }

        public Criteria andRepareContentEqualTo(String value) {
            addCriterion("repare_content =", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentNotEqualTo(String value) {
            addCriterion("repare_content <>", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentGreaterThan(String value) {
            addCriterion("repare_content >", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentGreaterThanOrEqualTo(String value) {
            addCriterion("repare_content >=", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentLessThan(String value) {
            addCriterion("repare_content <", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentLessThanOrEqualTo(String value) {
            addCriterion("repare_content <=", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentLike(String value) {
            addCriterion("repare_content like", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentNotLike(String value) {
            addCriterion("repare_content not like", value, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentIn(List<String> values) {
            addCriterion("repare_content in", values, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentNotIn(List<String> values) {
            addCriterion("repare_content not in", values, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentBetween(String value1, String value2) {
            addCriterion("repare_content between", value1, value2, "repareContent");
            return (Criteria) this;
        }

        public Criteria andRepareContentNotBetween(String value1, String value2) {
            addCriterion("repare_content not between", value1, value2, "repareContent");
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

        public Criteria andRepareTypeIsNull() {
            addCriterion("repare_type is null");
            return (Criteria) this;
        }

        public Criteria andRepareTypeIsNotNull() {
            addCriterion("repare_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepareTypeEqualTo(Integer value) {
            addCriterion("repare_type =", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeNotEqualTo(Integer value) {
            addCriterion("repare_type <>", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeGreaterThan(Integer value) {
            addCriterion("repare_type >", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("repare_type >=", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeLessThan(Integer value) {
            addCriterion("repare_type <", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("repare_type <=", value, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeIn(List<Integer> values) {
            addCriterion("repare_type in", values, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeNotIn(List<Integer> values) {
            addCriterion("repare_type not in", values, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeBetween(Integer value1, Integer value2) {
            addCriterion("repare_type between", value1, value2, "repareType");
            return (Criteria) this;
        }

        public Criteria andRepareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("repare_type not between", value1, value2, "repareType");
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
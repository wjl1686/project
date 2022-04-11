package com.ejobim.opplat.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbEquipRepareTaskExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipRepareTaskExtendExample() {
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

        public Criteria andDeailsConclusionIsNull() {
            addCriterion("deails_conclusion is null");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionIsNotNull() {
            addCriterion("deails_conclusion is not null");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionEqualTo(String value) {
            addCriterion("deails_conclusion =", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionNotEqualTo(String value) {
            addCriterion("deails_conclusion <>", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionGreaterThan(String value) {
            addCriterion("deails_conclusion >", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionGreaterThanOrEqualTo(String value) {
            addCriterion("deails_conclusion >=", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionLessThan(String value) {
            addCriterion("deails_conclusion <", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionLessThanOrEqualTo(String value) {
            addCriterion("deails_conclusion <=", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionLike(String value) {
            addCriterion("deails_conclusion like", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionNotLike(String value) {
            addCriterion("deails_conclusion not like", value, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionIn(List<String> values) {
            addCriterion("deails_conclusion in", values, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionNotIn(List<String> values) {
            addCriterion("deails_conclusion not in", values, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionBetween(String value1, String value2) {
            addCriterion("deails_conclusion between", value1, value2, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andDeailsConclusionNotBetween(String value1, String value2) {
            addCriterion("deails_conclusion not between", value1, value2, "deailsConclusion");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisIsNull() {
            addCriterion("empirical_analysis is null");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisIsNotNull() {
            addCriterion("empirical_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisEqualTo(String value) {
            addCriterion("empirical_analysis =", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisNotEqualTo(String value) {
            addCriterion("empirical_analysis <>", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisGreaterThan(String value) {
            addCriterion("empirical_analysis >", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("empirical_analysis >=", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisLessThan(String value) {
            addCriterion("empirical_analysis <", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisLessThanOrEqualTo(String value) {
            addCriterion("empirical_analysis <=", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisLike(String value) {
            addCriterion("empirical_analysis like", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisNotLike(String value) {
            addCriterion("empirical_analysis not like", value, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisIn(List<String> values) {
            addCriterion("empirical_analysis in", values, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisNotIn(List<String> values) {
            addCriterion("empirical_analysis not in", values, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisBetween(String value1, String value2) {
            addCriterion("empirical_analysis between", value1, value2, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andEmpiricalAnalysisNotBetween(String value1, String value2) {
            addCriterion("empirical_analysis not between", value1, value2, "empiricalAnalysis");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionIsNull() {
            addCriterion("follow_decision is null");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionIsNotNull() {
            addCriterion("follow_decision is not null");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionEqualTo(String value) {
            addCriterion("follow_decision =", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionNotEqualTo(String value) {
            addCriterion("follow_decision <>", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionGreaterThan(String value) {
            addCriterion("follow_decision >", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionGreaterThanOrEqualTo(String value) {
            addCriterion("follow_decision >=", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionLessThan(String value) {
            addCriterion("follow_decision <", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionLessThanOrEqualTo(String value) {
            addCriterion("follow_decision <=", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionLike(String value) {
            addCriterion("follow_decision like", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionNotLike(String value) {
            addCriterion("follow_decision not like", value, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionIn(List<String> values) {
            addCriterion("follow_decision in", values, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionNotIn(List<String> values) {
            addCriterion("follow_decision not in", values, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionBetween(String value1, String value2) {
            addCriterion("follow_decision between", value1, value2, "followDecision");
            return (Criteria) this;
        }

        public Criteria andFollowDecisionNotBetween(String value1, String value2) {
            addCriterion("follow_decision not between", value1, value2, "followDecision");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoIsNull() {
            addCriterion("detail_file_no is null");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoIsNotNull() {
            addCriterion("detail_file_no is not null");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoEqualTo(String value) {
            addCriterion("detail_file_no =", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoNotEqualTo(String value) {
            addCriterion("detail_file_no <>", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoGreaterThan(String value) {
            addCriterion("detail_file_no >", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_file_no >=", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoLessThan(String value) {
            addCriterion("detail_file_no <", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoLessThanOrEqualTo(String value) {
            addCriterion("detail_file_no <=", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoLike(String value) {
            addCriterion("detail_file_no like", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoNotLike(String value) {
            addCriterion("detail_file_no not like", value, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoIn(List<String> values) {
            addCriterion("detail_file_no in", values, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoNotIn(List<String> values) {
            addCriterion("detail_file_no not in", values, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoBetween(String value1, String value2) {
            addCriterion("detail_file_no between", value1, value2, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailFileNoNotBetween(String value1, String value2) {
            addCriterion("detail_file_no not between", value1, value2, "detailFileNo");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIsNull() {
            addCriterion("detail_amount is null");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIsNotNull() {
            addCriterion("detail_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAmountEqualTo(BigDecimal value) {
            addCriterion("detail_amount =", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotEqualTo(BigDecimal value) {
            addCriterion("detail_amount <>", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThan(BigDecimal value) {
            addCriterion("detail_amount >", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_amount >=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThan(BigDecimal value) {
            addCriterion("detail_amount <", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_amount <=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIn(List<BigDecimal> values) {
            addCriterion("detail_amount in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotIn(List<BigDecimal> values) {
            addCriterion("detail_amount not in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_amount between", value1, value2, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_amount not between", value1, value2, "detailAmount");
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

        public Criteria andRepareAddonIsNull() {
            addCriterion("repare_addon is null");
            return (Criteria) this;
        }

        public Criteria andRepareAddonIsNotNull() {
            addCriterion("repare_addon is not null");
            return (Criteria) this;
        }

        public Criteria andRepareAddonEqualTo(String value) {
            addCriterion("repare_addon =", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonNotEqualTo(String value) {
            addCriterion("repare_addon <>", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonGreaterThan(String value) {
            addCriterion("repare_addon >", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonGreaterThanOrEqualTo(String value) {
            addCriterion("repare_addon >=", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonLessThan(String value) {
            addCriterion("repare_addon <", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonLessThanOrEqualTo(String value) {
            addCriterion("repare_addon <=", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonLike(String value) {
            addCriterion("repare_addon like", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonNotLike(String value) {
            addCriterion("repare_addon not like", value, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonIn(List<String> values) {
            addCriterion("repare_addon in", values, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonNotIn(List<String> values) {
            addCriterion("repare_addon not in", values, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonBetween(String value1, String value2) {
            addCriterion("repare_addon between", value1, value2, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareAddonNotBetween(String value1, String value2) {
            addCriterion("repare_addon not between", value1, value2, "repareAddon");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachIsNull() {
            addCriterion("repare_chart_attach is null");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachIsNotNull() {
            addCriterion("repare_chart_attach is not null");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachEqualTo(String value) {
            addCriterion("repare_chart_attach =", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachNotEqualTo(String value) {
            addCriterion("repare_chart_attach <>", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachGreaterThan(String value) {
            addCriterion("repare_chart_attach >", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachGreaterThanOrEqualTo(String value) {
            addCriterion("repare_chart_attach >=", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachLessThan(String value) {
            addCriterion("repare_chart_attach <", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachLessThanOrEqualTo(String value) {
            addCriterion("repare_chart_attach <=", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachLike(String value) {
            addCriterion("repare_chart_attach like", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachNotLike(String value) {
            addCriterion("repare_chart_attach not like", value, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachIn(List<String> values) {
            addCriterion("repare_chart_attach in", values, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachNotIn(List<String> values) {
            addCriterion("repare_chart_attach not in", values, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachBetween(String value1, String value2) {
            addCriterion("repare_chart_attach between", value1, value2, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareChartAttachNotBetween(String value1, String value2) {
            addCriterion("repare_chart_attach not between", value1, value2, "repareChartAttach");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunIsNull() {
            addCriterion("repare_report_jun is null");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunIsNotNull() {
            addCriterion("repare_report_jun is not null");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunEqualTo(String value) {
            addCriterion("repare_report_jun =", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunNotEqualTo(String value) {
            addCriterion("repare_report_jun <>", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunGreaterThan(String value) {
            addCriterion("repare_report_jun >", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunGreaterThanOrEqualTo(String value) {
            addCriterion("repare_report_jun >=", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunLessThan(String value) {
            addCriterion("repare_report_jun <", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunLessThanOrEqualTo(String value) {
            addCriterion("repare_report_jun <=", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunLike(String value) {
            addCriterion("repare_report_jun like", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunNotLike(String value) {
            addCriterion("repare_report_jun not like", value, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunIn(List<String> values) {
            addCriterion("repare_report_jun in", values, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunNotIn(List<String> values) {
            addCriterion("repare_report_jun not in", values, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunBetween(String value1, String value2) {
            addCriterion("repare_report_jun between", value1, value2, "repareReportJun");
            return (Criteria) this;
        }

        public Criteria andRepareReportJunNotBetween(String value1, String value2) {
            addCriterion("repare_report_jun not between", value1, value2, "repareReportJun");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.List;

public class TbFlowMaintainTaskDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFlowMaintainTaskDetailExample() {
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

        public Criteria andDetailNoIsNull() {
            addCriterion("detail_no is null");
            return (Criteria) this;
        }

        public Criteria andDetailNoIsNotNull() {
            addCriterion("detail_no is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNoEqualTo(String value) {
            addCriterion("detail_no =", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotEqualTo(String value) {
            addCriterion("detail_no <>", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThan(String value) {
            addCriterion("detail_no >", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_no >=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThan(String value) {
            addCriterion("detail_no <", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLessThanOrEqualTo(String value) {
            addCriterion("detail_no <=", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoLike(String value) {
            addCriterion("detail_no like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotLike(String value) {
            addCriterion("detail_no not like", value, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoIn(List<String> values) {
            addCriterion("detail_no in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotIn(List<String> values) {
            addCriterion("detail_no not in", values, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoBetween(String value1, String value2) {
            addCriterion("detail_no between", value1, value2, "detailNo");
            return (Criteria) this;
        }

        public Criteria andDetailNoNotBetween(String value1, String value2) {
            addCriterion("detail_no not between", value1, value2, "detailNo");
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

        public Criteria andAddonIsNull() {
            addCriterion("addon is null");
            return (Criteria) this;
        }

        public Criteria andAddonIsNotNull() {
            addCriterion("addon is not null");
            return (Criteria) this;
        }

        public Criteria andAddonEqualTo(String value) {
            addCriterion("addon =", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonNotEqualTo(String value) {
            addCriterion("addon <>", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonGreaterThan(String value) {
            addCriterion("addon >", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonGreaterThanOrEqualTo(String value) {
            addCriterion("addon >=", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonLessThan(String value) {
            addCriterion("addon <", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonLessThanOrEqualTo(String value) {
            addCriterion("addon <=", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonLike(String value) {
            addCriterion("addon like", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonNotLike(String value) {
            addCriterion("addon not like", value, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonIn(List<String> values) {
            addCriterion("addon in", values, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonNotIn(List<String> values) {
            addCriterion("addon not in", values, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonBetween(String value1, String value2) {
            addCriterion("addon between", value1, value2, "addon");
            return (Criteria) this;
        }

        public Criteria andAddonNotBetween(String value1, String value2) {
            addCriterion("addon not between", value1, value2, "addon");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIsNull() {
            addCriterion("extend_detail is null");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIsNotNull() {
            addCriterion("extend_detail is not null");
            return (Criteria) this;
        }

        public Criteria andExtendDetailEqualTo(String value) {
            addCriterion("extend_detail =", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotEqualTo(String value) {
            addCriterion("extend_detail <>", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailGreaterThan(String value) {
            addCriterion("extend_detail >", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailGreaterThanOrEqualTo(String value) {
            addCriterion("extend_detail >=", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLessThan(String value) {
            addCriterion("extend_detail <", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLessThanOrEqualTo(String value) {
            addCriterion("extend_detail <=", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailLike(String value) {
            addCriterion("extend_detail like", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotLike(String value) {
            addCriterion("extend_detail not like", value, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailIn(List<String> values) {
            addCriterion("extend_detail in", values, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotIn(List<String> values) {
            addCriterion("extend_detail not in", values, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailBetween(String value1, String value2) {
            addCriterion("extend_detail between", value1, value2, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andExtendDetailNotBetween(String value1, String value2) {
            addCriterion("extend_detail not between", value1, value2, "extendDetail");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkIsNull() {
            addCriterion("detail_sanitation_ok is null");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkIsNotNull() {
            addCriterion("detail_sanitation_ok is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkEqualTo(Integer value) {
            addCriterion("detail_sanitation_ok =", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkNotEqualTo(Integer value) {
            addCriterion("detail_sanitation_ok <>", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkGreaterThan(Integer value) {
            addCriterion("detail_sanitation_ok >", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_sanitation_ok >=", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkLessThan(Integer value) {
            addCriterion("detail_sanitation_ok <", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkLessThanOrEqualTo(Integer value) {
            addCriterion("detail_sanitation_ok <=", value, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkIn(List<Integer> values) {
            addCriterion("detail_sanitation_ok in", values, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkNotIn(List<Integer> values) {
            addCriterion("detail_sanitation_ok not in", values, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkBetween(Integer value1, Integer value2) {
            addCriterion("detail_sanitation_ok between", value1, value2, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailSanitationOkNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_sanitation_ok not between", value1, value2, "detailSanitationOk");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentIsNull() {
            addCriterion("detail_electric_current is null");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentIsNotNull() {
            addCriterion("detail_electric_current is not null");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentEqualTo(Float value) {
            addCriterion("detail_electric_current =", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentNotEqualTo(Float value) {
            addCriterion("detail_electric_current <>", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentGreaterThan(Float value) {
            addCriterion("detail_electric_current >", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentGreaterThanOrEqualTo(Float value) {
            addCriterion("detail_electric_current >=", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentLessThan(Float value) {
            addCriterion("detail_electric_current <", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentLessThanOrEqualTo(Float value) {
            addCriterion("detail_electric_current <=", value, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentIn(List<Float> values) {
            addCriterion("detail_electric_current in", values, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentNotIn(List<Float> values) {
            addCriterion("detail_electric_current not in", values, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentBetween(Float value1, Float value2) {
            addCriterion("detail_electric_current between", value1, value2, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailElectricCurrentNotBetween(Float value1, Float value2) {
            addCriterion("detail_electric_current not between", value1, value2, "detailElectricCurrent");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkIsNull() {
            addCriterion("detail_sound_ok is null");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkIsNotNull() {
            addCriterion("detail_sound_ok is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkEqualTo(Integer value) {
            addCriterion("detail_sound_ok =", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkNotEqualTo(Integer value) {
            addCriterion("detail_sound_ok <>", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkGreaterThan(Integer value) {
            addCriterion("detail_sound_ok >", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_sound_ok >=", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkLessThan(Integer value) {
            addCriterion("detail_sound_ok <", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkLessThanOrEqualTo(Integer value) {
            addCriterion("detail_sound_ok <=", value, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkIn(List<Integer> values) {
            addCriterion("detail_sound_ok in", values, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkNotIn(List<Integer> values) {
            addCriterion("detail_sound_ok not in", values, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkBetween(Integer value1, Integer value2) {
            addCriterion("detail_sound_ok between", value1, value2, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailSoundOkNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_sound_ok not between", value1, value2, "detailSoundOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkIsNull() {
            addCriterion("detail_frequency_conversion_ok is null");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkIsNotNull() {
            addCriterion("detail_frequency_conversion_ok is not null");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkEqualTo(Integer value) {
            addCriterion("detail_frequency_conversion_ok =", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkNotEqualTo(Integer value) {
            addCriterion("detail_frequency_conversion_ok <>", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkGreaterThan(Integer value) {
            addCriterion("detail_frequency_conversion_ok >", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_frequency_conversion_ok >=", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkLessThan(Integer value) {
            addCriterion("detail_frequency_conversion_ok <", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkLessThanOrEqualTo(Integer value) {
            addCriterion("detail_frequency_conversion_ok <=", value, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkIn(List<Integer> values) {
            addCriterion("detail_frequency_conversion_ok in", values, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkNotIn(List<Integer> values) {
            addCriterion("detail_frequency_conversion_ok not in", values, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkBetween(Integer value1, Integer value2) {
            addCriterion("detail_frequency_conversion_ok between", value1, value2, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailFrequencyConversionOkNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_frequency_conversion_ok not between", value1, value2, "detailFrequencyConversionOk");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesIsNull() {
            addCriterion("detail_pictures is null");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesIsNotNull() {
            addCriterion("detail_pictures is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesEqualTo(String value) {
            addCriterion("detail_pictures =", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesNotEqualTo(String value) {
            addCriterion("detail_pictures <>", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesGreaterThan(String value) {
            addCriterion("detail_pictures >", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("detail_pictures >=", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesLessThan(String value) {
            addCriterion("detail_pictures <", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesLessThanOrEqualTo(String value) {
            addCriterion("detail_pictures <=", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesLike(String value) {
            addCriterion("detail_pictures like", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesNotLike(String value) {
            addCriterion("detail_pictures not like", value, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesIn(List<String> values) {
            addCriterion("detail_pictures in", values, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesNotIn(List<String> values) {
            addCriterion("detail_pictures not in", values, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesBetween(String value1, String value2) {
            addCriterion("detail_pictures between", value1, value2, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailPicturesNotBetween(String value1, String value2) {
            addCriterion("detail_pictures not between", value1, value2, "detailPictures");
            return (Criteria) this;
        }

        public Criteria andDetailVideoIsNull() {
            addCriterion("detail_video is null");
            return (Criteria) this;
        }

        public Criteria andDetailVideoIsNotNull() {
            addCriterion("detail_video is not null");
            return (Criteria) this;
        }

        public Criteria andDetailVideoEqualTo(String value) {
            addCriterion("detail_video =", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoNotEqualTo(String value) {
            addCriterion("detail_video <>", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoGreaterThan(String value) {
            addCriterion("detail_video >", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoGreaterThanOrEqualTo(String value) {
            addCriterion("detail_video >=", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoLessThan(String value) {
            addCriterion("detail_video <", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoLessThanOrEqualTo(String value) {
            addCriterion("detail_video <=", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoLike(String value) {
            addCriterion("detail_video like", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoNotLike(String value) {
            addCriterion("detail_video not like", value, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoIn(List<String> values) {
            addCriterion("detail_video in", values, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoNotIn(List<String> values) {
            addCriterion("detail_video not in", values, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoBetween(String value1, String value2) {
            addCriterion("detail_video between", value1, value2, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailVideoNotBetween(String value1, String value2) {
            addCriterion("detail_video not between", value1, value2, "detailVideo");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachIsNull() {
            addCriterion("detail_chart_attach is null");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachIsNotNull() {
            addCriterion("detail_chart_attach is not null");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachEqualTo(String value) {
            addCriterion("detail_chart_attach =", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachNotEqualTo(String value) {
            addCriterion("detail_chart_attach <>", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachGreaterThan(String value) {
            addCriterion("detail_chart_attach >", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachGreaterThanOrEqualTo(String value) {
            addCriterion("detail_chart_attach >=", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachLessThan(String value) {
            addCriterion("detail_chart_attach <", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachLessThanOrEqualTo(String value) {
            addCriterion("detail_chart_attach <=", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachLike(String value) {
            addCriterion("detail_chart_attach like", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachNotLike(String value) {
            addCriterion("detail_chart_attach not like", value, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachIn(List<String> values) {
            addCriterion("detail_chart_attach in", values, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachNotIn(List<String> values) {
            addCriterion("detail_chart_attach not in", values, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachBetween(String value1, String value2) {
            addCriterion("detail_chart_attach between", value1, value2, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailChartAttachNotBetween(String value1, String value2) {
            addCriterion("detail_chart_attach not between", value1, value2, "detailChartAttach");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunIsNull() {
            addCriterion("detail_report_jun is null");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunIsNotNull() {
            addCriterion("detail_report_jun is not null");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunEqualTo(String value) {
            addCriterion("detail_report_jun =", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunNotEqualTo(String value) {
            addCriterion("detail_report_jun <>", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunGreaterThan(String value) {
            addCriterion("detail_report_jun >", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunGreaterThanOrEqualTo(String value) {
            addCriterion("detail_report_jun >=", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunLessThan(String value) {
            addCriterion("detail_report_jun <", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunLessThanOrEqualTo(String value) {
            addCriterion("detail_report_jun <=", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunLike(String value) {
            addCriterion("detail_report_jun like", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunNotLike(String value) {
            addCriterion("detail_report_jun not like", value, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunIn(List<String> values) {
            addCriterion("detail_report_jun in", values, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunNotIn(List<String> values) {
            addCriterion("detail_report_jun not in", values, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunBetween(String value1, String value2) {
            addCriterion("detail_report_jun between", value1, value2, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailReportJunNotBetween(String value1, String value2) {
            addCriterion("detail_report_jun not between", value1, value2, "detailReportJun");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkIsNull() {
            addCriterion("detail_temp_ok is null");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkIsNotNull() {
            addCriterion("detail_temp_ok is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkEqualTo(Integer value) {
            addCriterion("detail_temp_ok =", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkNotEqualTo(Integer value) {
            addCriterion("detail_temp_ok <>", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkGreaterThan(Integer value) {
            addCriterion("detail_temp_ok >", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_temp_ok >=", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkLessThan(Integer value) {
            addCriterion("detail_temp_ok <", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkLessThanOrEqualTo(Integer value) {
            addCriterion("detail_temp_ok <=", value, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkIn(List<Integer> values) {
            addCriterion("detail_temp_ok in", values, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkNotIn(List<Integer> values) {
            addCriterion("detail_temp_ok not in", values, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkBetween(Integer value1, Integer value2) {
            addCriterion("detail_temp_ok between", value1, value2, "detailTempOk");
            return (Criteria) this;
        }

        public Criteria andDetailTempOkNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_temp_ok not between", value1, value2, "detailTempOk");
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

        public Criteria andDetailAmountEqualTo(Double value) {
            addCriterion("detail_amount =", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotEqualTo(Double value) {
            addCriterion("detail_amount <>", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThan(Double value) {
            addCriterion("detail_amount >", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("detail_amount >=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThan(Double value) {
            addCriterion("detail_amount <", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountLessThanOrEqualTo(Double value) {
            addCriterion("detail_amount <=", value, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountIn(List<Double> values) {
            addCriterion("detail_amount in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotIn(List<Double> values) {
            addCriterion("detail_amount not in", values, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountBetween(Double value1, Double value2) {
            addCriterion("detail_amount between", value1, value2, "detailAmount");
            return (Criteria) this;
        }

        public Criteria andDetailAmountNotBetween(Double value1, Double value2) {
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

        public Criteria andDetailEvaluateIsNull() {
            addCriterion("detail_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateIsNotNull() {
            addCriterion("detail_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateEqualTo(String value) {
            addCriterion("detail_evaluate =", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateNotEqualTo(String value) {
            addCriterion("detail_evaluate <>", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateGreaterThan(String value) {
            addCriterion("detail_evaluate >", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("detail_evaluate >=", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateLessThan(String value) {
            addCriterion("detail_evaluate <", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateLessThanOrEqualTo(String value) {
            addCriterion("detail_evaluate <=", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateLike(String value) {
            addCriterion("detail_evaluate like", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateNotLike(String value) {
            addCriterion("detail_evaluate not like", value, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateIn(List<String> values) {
            addCriterion("detail_evaluate in", values, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateNotIn(List<String> values) {
            addCriterion("detail_evaluate not in", values, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateBetween(String value1, String value2) {
            addCriterion("detail_evaluate between", value1, value2, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailEvaluateNotBetween(String value1, String value2) {
            addCriterion("detail_evaluate not between", value1, value2, "detailEvaluate");
            return (Criteria) this;
        }

        public Criteria andDetailElementListIsNull() {
            addCriterion("detail_element_list is null");
            return (Criteria) this;
        }

        public Criteria andDetailElementListIsNotNull() {
            addCriterion("detail_element_list is not null");
            return (Criteria) this;
        }

        public Criteria andDetailElementListEqualTo(String value) {
            addCriterion("detail_element_list =", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListNotEqualTo(String value) {
            addCriterion("detail_element_list <>", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListGreaterThan(String value) {
            addCriterion("detail_element_list >", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListGreaterThanOrEqualTo(String value) {
            addCriterion("detail_element_list >=", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListLessThan(String value) {
            addCriterion("detail_element_list <", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListLessThanOrEqualTo(String value) {
            addCriterion("detail_element_list <=", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListLike(String value) {
            addCriterion("detail_element_list like", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListNotLike(String value) {
            addCriterion("detail_element_list not like", value, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListIn(List<String> values) {
            addCriterion("detail_element_list in", values, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListNotIn(List<String> values) {
            addCriterion("detail_element_list not in", values, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListBetween(String value1, String value2) {
            addCriterion("detail_element_list between", value1, value2, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailElementListNotBetween(String value1, String value2) {
            addCriterion("detail_element_list not between", value1, value2, "detailElementList");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsIsNull() {
            addCriterion("detail_spare_parts is null");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsIsNotNull() {
            addCriterion("detail_spare_parts is not null");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsEqualTo(Integer value) {
            addCriterion("detail_spare_parts =", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsNotEqualTo(Integer value) {
            addCriterion("detail_spare_parts <>", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsGreaterThan(Integer value) {
            addCriterion("detail_spare_parts >", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_spare_parts >=", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsLessThan(Integer value) {
            addCriterion("detail_spare_parts <", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsLessThanOrEqualTo(Integer value) {
            addCriterion("detail_spare_parts <=", value, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsIn(List<Integer> values) {
            addCriterion("detail_spare_parts in", values, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsNotIn(List<Integer> values) {
            addCriterion("detail_spare_parts not in", values, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsBetween(Integer value1, Integer value2) {
            addCriterion("detail_spare_parts between", value1, value2, "detailSpareParts");
            return (Criteria) this;
        }

        public Criteria andDetailSparePartsNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_spare_parts not between", value1, value2, "detailSpareParts");
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
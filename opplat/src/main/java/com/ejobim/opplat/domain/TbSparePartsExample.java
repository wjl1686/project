package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSparePartsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSparePartsExample() {
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

        public Criteria andSparePartsNoIsNull() {
            addCriterion("spare_parts_no is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoIsNotNull() {
            addCriterion("spare_parts_no is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoEqualTo(String value) {
            addCriterion("spare_parts_no =", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotEqualTo(String value) {
            addCriterion("spare_parts_no <>", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoGreaterThan(String value) {
            addCriterion("spare_parts_no >", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_no >=", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLessThan(String value) {
            addCriterion("spare_parts_no <", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_no <=", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoLike(String value) {
            addCriterion("spare_parts_no like", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotLike(String value) {
            addCriterion("spare_parts_no not like", value, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoIn(List<String> values) {
            addCriterion("spare_parts_no in", values, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotIn(List<String> values) {
            addCriterion("spare_parts_no not in", values, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoBetween(String value1, String value2) {
            addCriterion("spare_parts_no between", value1, value2, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNoNotBetween(String value1, String value2) {
            addCriterion("spare_parts_no not between", value1, value2, "sparePartsNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameIsNull() {
            addCriterion("spare_parts_name is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameIsNotNull() {
            addCriterion("spare_parts_name is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameEqualTo(String value) {
            addCriterion("spare_parts_name =", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameNotEqualTo(String value) {
            addCriterion("spare_parts_name <>", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameGreaterThan(String value) {
            addCriterion("spare_parts_name >", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_name >=", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameLessThan(String value) {
            addCriterion("spare_parts_name <", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_name <=", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameLike(String value) {
            addCriterion("spare_parts_name like", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameNotLike(String value) {
            addCriterion("spare_parts_name not like", value, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameIn(List<String> values) {
            addCriterion("spare_parts_name in", values, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameNotIn(List<String> values) {
            addCriterion("spare_parts_name not in", values, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameBetween(String value1, String value2) {
            addCriterion("spare_parts_name between", value1, value2, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsNameNotBetween(String value1, String value2) {
            addCriterion("spare_parts_name not between", value1, value2, "sparePartsName");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeIsNull() {
            addCriterion("spare_parts_mode is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeIsNotNull() {
            addCriterion("spare_parts_mode is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeEqualTo(String value) {
            addCriterion("spare_parts_mode =", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeNotEqualTo(String value) {
            addCriterion("spare_parts_mode <>", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeGreaterThan(String value) {
            addCriterion("spare_parts_mode >", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_mode >=", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeLessThan(String value) {
            addCriterion("spare_parts_mode <", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_mode <=", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeLike(String value) {
            addCriterion("spare_parts_mode like", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeNotLike(String value) {
            addCriterion("spare_parts_mode not like", value, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeIn(List<String> values) {
            addCriterion("spare_parts_mode in", values, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeNotIn(List<String> values) {
            addCriterion("spare_parts_mode not in", values, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeBetween(String value1, String value2) {
            addCriterion("spare_parts_mode between", value1, value2, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsModeNotBetween(String value1, String value2) {
            addCriterion("spare_parts_mode not between", value1, value2, "sparePartsMode");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeIsNull() {
            addCriterion("spare_parts_describe is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeIsNotNull() {
            addCriterion("spare_parts_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeEqualTo(String value) {
            addCriterion("spare_parts_describe =", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeNotEqualTo(String value) {
            addCriterion("spare_parts_describe <>", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeGreaterThan(String value) {
            addCriterion("spare_parts_describe >", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_describe >=", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeLessThan(String value) {
            addCriterion("spare_parts_describe <", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_describe <=", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeLike(String value) {
            addCriterion("spare_parts_describe like", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeNotLike(String value) {
            addCriterion("spare_parts_describe not like", value, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeIn(List<String> values) {
            addCriterion("spare_parts_describe in", values, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeNotIn(List<String> values) {
            addCriterion("spare_parts_describe not in", values, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeBetween(String value1, String value2) {
            addCriterion("spare_parts_describe between", value1, value2, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsDescribeNotBetween(String value1, String value2) {
            addCriterion("spare_parts_describe not between", value1, value2, "sparePartsDescribe");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountIsNull() {
            addCriterion("spare_parts_count is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountIsNotNull() {
            addCriterion("spare_parts_count is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountEqualTo(Integer value) {
            addCriterion("spare_parts_count =", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountNotEqualTo(Integer value) {
            addCriterion("spare_parts_count <>", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountGreaterThan(Integer value) {
            addCriterion("spare_parts_count >", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("spare_parts_count >=", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountLessThan(Integer value) {
            addCriterion("spare_parts_count <", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountLessThanOrEqualTo(Integer value) {
            addCriterion("spare_parts_count <=", value, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountIn(List<Integer> values) {
            addCriterion("spare_parts_count in", values, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountNotIn(List<Integer> values) {
            addCriterion("spare_parts_count not in", values, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountBetween(Integer value1, Integer value2) {
            addCriterion("spare_parts_count between", value1, value2, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andSparePartsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("spare_parts_count not between", value1, value2, "sparePartsCount");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoIsNull() {
            addCriterion("store_room_no is null");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoIsNotNull() {
            addCriterion("store_room_no is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoEqualTo(String value) {
            addCriterion("store_room_no =", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoNotEqualTo(String value) {
            addCriterion("store_room_no <>", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoGreaterThan(String value) {
            addCriterion("store_room_no >", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoGreaterThanOrEqualTo(String value) {
            addCriterion("store_room_no >=", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoLessThan(String value) {
            addCriterion("store_room_no <", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoLessThanOrEqualTo(String value) {
            addCriterion("store_room_no <=", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoLike(String value) {
            addCriterion("store_room_no like", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoNotLike(String value) {
            addCriterion("store_room_no not like", value, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoIn(List<String> values) {
            addCriterion("store_room_no in", values, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoNotIn(List<String> values) {
            addCriterion("store_room_no not in", values, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoBetween(String value1, String value2) {
            addCriterion("store_room_no between", value1, value2, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andStoreRoomNoNotBetween(String value1, String value2) {
            addCriterion("store_room_no not between", value1, value2, "storeRoomNo");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeIsNull() {
            addCriterion("spare_parts_code is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeIsNotNull() {
            addCriterion("spare_parts_code is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeEqualTo(String value) {
            addCriterion("spare_parts_code =", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeNotEqualTo(String value) {
            addCriterion("spare_parts_code <>", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeGreaterThan(String value) {
            addCriterion("spare_parts_code >", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_code >=", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeLessThan(String value) {
            addCriterion("spare_parts_code <", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_code <=", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeLike(String value) {
            addCriterion("spare_parts_code like", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeNotLike(String value) {
            addCriterion("spare_parts_code not like", value, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeIn(List<String> values) {
            addCriterion("spare_parts_code in", values, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeNotIn(List<String> values) {
            addCriterion("spare_parts_code not in", values, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeBetween(String value1, String value2) {
            addCriterion("spare_parts_code between", value1, value2, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsCodeNotBetween(String value1, String value2) {
            addCriterion("spare_parts_code not between", value1, value2, "sparePartsCode");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeIsNull() {
            addCriterion("spare_parts_type is null");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeIsNotNull() {
            addCriterion("spare_parts_type is not null");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeEqualTo(String value) {
            addCriterion("spare_parts_type =", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeNotEqualTo(String value) {
            addCriterion("spare_parts_type <>", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeGreaterThan(String value) {
            addCriterion("spare_parts_type >", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("spare_parts_type >=", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeLessThan(String value) {
            addCriterion("spare_parts_type <", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeLessThanOrEqualTo(String value) {
            addCriterion("spare_parts_type <=", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeLike(String value) {
            addCriterion("spare_parts_type like", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeNotLike(String value) {
            addCriterion("spare_parts_type not like", value, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeIn(List<String> values) {
            addCriterion("spare_parts_type in", values, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeNotIn(List<String> values) {
            addCriterion("spare_parts_type not in", values, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeBetween(String value1, String value2) {
            addCriterion("spare_parts_type between", value1, value2, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andSparePartsTypeNotBetween(String value1, String value2) {
            addCriterion("spare_parts_type not between", value1, value2, "sparePartsType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIsNull() {
            addCriterion("equip_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIsNotNull() {
            addCriterion("equip_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeEqualTo(String value) {
            addCriterion("equip_type =", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotEqualTo(String value) {
            addCriterion("equip_type <>", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeGreaterThan(String value) {
            addCriterion("equip_type >", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type >=", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLessThan(String value) {
            addCriterion("equip_type <", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLessThanOrEqualTo(String value) {
            addCriterion("equip_type <=", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeLike(String value) {
            addCriterion("equip_type like", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotLike(String value) {
            addCriterion("equip_type not like", value, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeIn(List<String> values) {
            addCriterion("equip_type in", values, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotIn(List<String> values) {
            addCriterion("equip_type not in", values, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeBetween(String value1, String value2) {
            addCriterion("equip_type between", value1, value2, "equipType");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNotBetween(String value1, String value2) {
            addCriterion("equip_type not between", value1, value2, "equipType");
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

        public Criteria andProducterIsNull() {
            addCriterion("producter is null");
            return (Criteria) this;
        }

        public Criteria andProducterIsNotNull() {
            addCriterion("producter is not null");
            return (Criteria) this;
        }

        public Criteria andProducterEqualTo(String value) {
            addCriterion("producter =", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterNotEqualTo(String value) {
            addCriterion("producter <>", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterGreaterThan(String value) {
            addCriterion("producter >", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterGreaterThanOrEqualTo(String value) {
            addCriterion("producter >=", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterLessThan(String value) {
            addCriterion("producter <", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterLessThanOrEqualTo(String value) {
            addCriterion("producter <=", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterLike(String value) {
            addCriterion("producter like", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterNotLike(String value) {
            addCriterion("producter not like", value, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterIn(List<String> values) {
            addCriterion("producter in", values, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterNotIn(List<String> values) {
            addCriterion("producter not in", values, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterBetween(String value1, String value2) {
            addCriterion("producter between", value1, value2, "producter");
            return (Criteria) this;
        }

        public Criteria andProducterNotBetween(String value1, String value2) {
            addCriterion("producter not between", value1, value2, "producter");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitIsNull() {
            addCriterion("sparet_parts_unit is null");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitIsNotNull() {
            addCriterion("sparet_parts_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitEqualTo(String value) {
            addCriterion("sparet_parts_unit =", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitNotEqualTo(String value) {
            addCriterion("sparet_parts_unit <>", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitGreaterThan(String value) {
            addCriterion("sparet_parts_unit >", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("sparet_parts_unit >=", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitLessThan(String value) {
            addCriterion("sparet_parts_unit <", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitLessThanOrEqualTo(String value) {
            addCriterion("sparet_parts_unit <=", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitLike(String value) {
            addCriterion("sparet_parts_unit like", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitNotLike(String value) {
            addCriterion("sparet_parts_unit not like", value, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitIn(List<String> values) {
            addCriterion("sparet_parts_unit in", values, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitNotIn(List<String> values) {
            addCriterion("sparet_parts_unit not in", values, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitBetween(String value1, String value2) {
            addCriterion("sparet_parts_unit between", value1, value2, "sparetPartsUnit");
            return (Criteria) this;
        }

        public Criteria andSparetPartsUnitNotBetween(String value1, String value2) {
            addCriterion("sparet_parts_unit not between", value1, value2, "sparetPartsUnit");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCreaetUserIsNull() {
            addCriterion("creaet_user is null");
            return (Criteria) this;
        }

        public Criteria andCreaetUserIsNotNull() {
            addCriterion("creaet_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreaetUserEqualTo(String value) {
            addCriterion("creaet_user =", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserNotEqualTo(String value) {
            addCriterion("creaet_user <>", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserGreaterThan(String value) {
            addCriterion("creaet_user >", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserGreaterThanOrEqualTo(String value) {
            addCriterion("creaet_user >=", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserLessThan(String value) {
            addCriterion("creaet_user <", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserLessThanOrEqualTo(String value) {
            addCriterion("creaet_user <=", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserLike(String value) {
            addCriterion("creaet_user like", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserNotLike(String value) {
            addCriterion("creaet_user not like", value, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserIn(List<String> values) {
            addCriterion("creaet_user in", values, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserNotIn(List<String> values) {
            addCriterion("creaet_user not in", values, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserBetween(String value1, String value2) {
            addCriterion("creaet_user between", value1, value2, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andCreaetUserNotBetween(String value1, String value2) {
            addCriterion("creaet_user not between", value1, value2, "creaetUser");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNull() {
            addCriterion("equip_type_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIsNotNull() {
            addCriterion("equip_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameEqualTo(String value) {
            addCriterion("equip_type_name =", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotEqualTo(String value) {
            addCriterion("equip_type_name <>", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThan(String value) {
            addCriterion("equip_type_name >", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type_name >=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThan(String value) {
            addCriterion("equip_type_name <", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLessThanOrEqualTo(String value) {
            addCriterion("equip_type_name <=", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameLike(String value) {
            addCriterion("equip_type_name like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotLike(String value) {
            addCriterion("equip_type_name not like", value, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameIn(List<String> values) {
            addCriterion("equip_type_name in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotIn(List<String> values) {
            addCriterion("equip_type_name not in", values, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameBetween(String value1, String value2) {
            addCriterion("equip_type_name between", value1, value2, "equipTypeName");
            return (Criteria) this;
        }

        public Criteria andEquipTypeNameNotBetween(String value1, String value2) {
            addCriterion("equip_type_name not between", value1, value2, "equipTypeName");
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
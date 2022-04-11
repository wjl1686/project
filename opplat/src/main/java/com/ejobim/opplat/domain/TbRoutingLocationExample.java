package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoutingLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoutingLocationExample() {
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

        public Criteria andLocationNoIsNull() {
            addCriterion("location_no is null");
            return (Criteria) this;
        }

        public Criteria andLocationNoIsNotNull() {
            addCriterion("location_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNoEqualTo(String value) {
            addCriterion("location_no =", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotEqualTo(String value) {
            addCriterion("location_no <>", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThan(String value) {
            addCriterion("location_no >", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoGreaterThanOrEqualTo(String value) {
            addCriterion("location_no >=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThan(String value) {
            addCriterion("location_no <", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLessThanOrEqualTo(String value) {
            addCriterion("location_no <=", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoLike(String value) {
            addCriterion("location_no like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotLike(String value) {
            addCriterion("location_no not like", value, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoIn(List<String> values) {
            addCriterion("location_no in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotIn(List<String> values) {
            addCriterion("location_no not in", values, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoBetween(String value1, String value2) {
            addCriterion("location_no between", value1, value2, "locationNo");
            return (Criteria) this;
        }

        public Criteria andLocationNoNotBetween(String value1, String value2) {
            addCriterion("location_no not between", value1, value2, "locationNo");
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

        public Criteria andLocationNameIsNull() {
            addCriterion("location_name is null");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNotNull() {
            addCriterion("location_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNameEqualTo(String value) {
            addCriterion("location_name =", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotEqualTo(String value) {
            addCriterion("location_name <>", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThan(String value) {
            addCriterion("location_name >", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("location_name >=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThan(String value) {
            addCriterion("location_name <", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThanOrEqualTo(String value) {
            addCriterion("location_name <=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLike(String value) {
            addCriterion("location_name like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotLike(String value) {
            addCriterion("location_name not like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameIn(List<String> values) {
            addCriterion("location_name in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotIn(List<String> values) {
            addCriterion("location_name not in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameBetween(String value1, String value2) {
            addCriterion("location_name between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotBetween(String value1, String value2) {
            addCriterion("location_name not between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeIsNull() {
            addCriterion("location_describe is null");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeIsNotNull() {
            addCriterion("location_describe is not null");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeEqualTo(String value) {
            addCriterion("location_describe =", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeNotEqualTo(String value) {
            addCriterion("location_describe <>", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeGreaterThan(String value) {
            addCriterion("location_describe >", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("location_describe >=", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeLessThan(String value) {
            addCriterion("location_describe <", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeLessThanOrEqualTo(String value) {
            addCriterion("location_describe <=", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeLike(String value) {
            addCriterion("location_describe like", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeNotLike(String value) {
            addCriterion("location_describe not like", value, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeIn(List<String> values) {
            addCriterion("location_describe in", values, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeNotIn(List<String> values) {
            addCriterion("location_describe not in", values, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeBetween(String value1, String value2) {
            addCriterion("location_describe between", value1, value2, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationDescribeNotBetween(String value1, String value2) {
            addCriterion("location_describe not between", value1, value2, "locationDescribe");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNull() {
            addCriterion("location_type is null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNotNull() {
            addCriterion("location_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeEqualTo(Integer value) {
            addCriterion("location_type =", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotEqualTo(Integer value) {
            addCriterion("location_type <>", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThan(Integer value) {
            addCriterion("location_type >", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_type >=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThan(Integer value) {
            addCriterion("location_type <", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("location_type <=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIn(List<Integer> values) {
            addCriterion("location_type in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotIn(List<Integer> values) {
            addCriterion("location_type not in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeBetween(Integer value1, Integer value2) {
            addCriterion("location_type between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("location_type not between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIsNull() {
            addCriterion("location_level is null");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIsNotNull() {
            addCriterion("location_level is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLevelEqualTo(Integer value) {
            addCriterion("location_level =", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotEqualTo(Integer value) {
            addCriterion("location_level <>", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelGreaterThan(Integer value) {
            addCriterion("location_level >", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_level >=", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelLessThan(Integer value) {
            addCriterion("location_level <", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelLessThanOrEqualTo(Integer value) {
            addCriterion("location_level <=", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIn(List<Integer> values) {
            addCriterion("location_level in", values, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotIn(List<Integer> values) {
            addCriterion("location_level not in", values, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelBetween(Integer value1, Integer value2) {
            addCriterion("location_level between", value1, value2, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("location_level not between", value1, value2, "locationLevel");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andLocationSortIsNull() {
            addCriterion("location_sort is null");
            return (Criteria) this;
        }

        public Criteria andLocationSortIsNotNull() {
            addCriterion("location_sort is not null");
            return (Criteria) this;
        }

        public Criteria andLocationSortEqualTo(Integer value) {
            addCriterion("location_sort =", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotEqualTo(Integer value) {
            addCriterion("location_sort <>", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortGreaterThan(Integer value) {
            addCriterion("location_sort >", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_sort >=", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortLessThan(Integer value) {
            addCriterion("location_sort <", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortLessThanOrEqualTo(Integer value) {
            addCriterion("location_sort <=", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortIn(List<Integer> values) {
            addCriterion("location_sort in", values, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotIn(List<Integer> values) {
            addCriterion("location_sort not in", values, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortBetween(Integer value1, Integer value2) {
            addCriterion("location_sort between", value1, value2, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotBetween(Integer value1, Integer value2) {
            addCriterion("location_sort not between", value1, value2, "locationSort");
            return (Criteria) this;
        }

        public Criteria andEquipCountIsNull() {
            addCriterion("equip_count is null");
            return (Criteria) this;
        }

        public Criteria andEquipCountIsNotNull() {
            addCriterion("equip_count is not null");
            return (Criteria) this;
        }

        public Criteria andEquipCountEqualTo(Integer value) {
            addCriterion("equip_count =", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountNotEqualTo(Integer value) {
            addCriterion("equip_count <>", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountGreaterThan(Integer value) {
            addCriterion("equip_count >", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_count >=", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountLessThan(Integer value) {
            addCriterion("equip_count <", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountLessThanOrEqualTo(Integer value) {
            addCriterion("equip_count <=", value, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountIn(List<Integer> values) {
            addCriterion("equip_count in", values, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountNotIn(List<Integer> values) {
            addCriterion("equip_count not in", values, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountBetween(Integer value1, Integer value2) {
            addCriterion("equip_count between", value1, value2, "equipCount");
            return (Criteria) this;
        }

        public Criteria andEquipCountNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_count not between", value1, value2, "equipCount");
            return (Criteria) this;
        }

        public Criteria andFillCountIsNull() {
            addCriterion("fill_count is null");
            return (Criteria) this;
        }

        public Criteria andFillCountIsNotNull() {
            addCriterion("fill_count is not null");
            return (Criteria) this;
        }

        public Criteria andFillCountEqualTo(Integer value) {
            addCriterion("fill_count =", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotEqualTo(Integer value) {
            addCriterion("fill_count <>", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountGreaterThan(Integer value) {
            addCriterion("fill_count >", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fill_count >=", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountLessThan(Integer value) {
            addCriterion("fill_count <", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountLessThanOrEqualTo(Integer value) {
            addCriterion("fill_count <=", value, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountIn(List<Integer> values) {
            addCriterion("fill_count in", values, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotIn(List<Integer> values) {
            addCriterion("fill_count not in", values, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountBetween(Integer value1, Integer value2) {
            addCriterion("fill_count between", value1, value2, "fillCount");
            return (Criteria) this;
        }

        public Criteria andFillCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fill_count not between", value1, value2, "fillCount");
            return (Criteria) this;
        }

        public Criteria andNfcNoIsNull() {
            addCriterion("nfc_no is null");
            return (Criteria) this;
        }

        public Criteria andNfcNoIsNotNull() {
            addCriterion("nfc_no is not null");
            return (Criteria) this;
        }

        public Criteria andNfcNoEqualTo(String value) {
            addCriterion("nfc_no =", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoNotEqualTo(String value) {
            addCriterion("nfc_no <>", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoGreaterThan(String value) {
            addCriterion("nfc_no >", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoGreaterThanOrEqualTo(String value) {
            addCriterion("nfc_no >=", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoLessThan(String value) {
            addCriterion("nfc_no <", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoLessThanOrEqualTo(String value) {
            addCriterion("nfc_no <=", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoLike(String value) {
            addCriterion("nfc_no like", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoNotLike(String value) {
            addCriterion("nfc_no not like", value, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoIn(List<String> values) {
            addCriterion("nfc_no in", values, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoNotIn(List<String> values) {
            addCriterion("nfc_no not in", values, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoBetween(String value1, String value2) {
            addCriterion("nfc_no between", value1, value2, "nfcNo");
            return (Criteria) this;
        }

        public Criteria andNfcNoNotBetween(String value1, String value2) {
            addCriterion("nfc_no not between", value1, value2, "nfcNo");
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
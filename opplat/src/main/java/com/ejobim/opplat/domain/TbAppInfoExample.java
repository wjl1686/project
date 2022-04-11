package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAppInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAppInfoExample() {
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

        public Criteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLike(String value) {
            addCriterion("app_version like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("app_version not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("app_version in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeIsNull() {
            addCriterion("app_update_time is null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeIsNotNull() {
            addCriterion("app_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeEqualTo(Date value) {
            addCriterion("app_update_time =", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeNotEqualTo(Date value) {
            addCriterion("app_update_time <>", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeGreaterThan(Date value) {
            addCriterion("app_update_time >", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("app_update_time >=", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeLessThan(Date value) {
            addCriterion("app_update_time <", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("app_update_time <=", value, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeIn(List<Date> values) {
            addCriterion("app_update_time in", values, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeNotIn(List<Date> values) {
            addCriterion("app_update_time not in", values, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("app_update_time between", value1, value2, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("app_update_time not between", value1, value2, "appUpdateTime");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIsNull() {
            addCriterion("app_download_url is null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIsNotNull() {
            addCriterion("app_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlEqualTo(String value) {
            addCriterion("app_download_url =", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotEqualTo(String value) {
            addCriterion("app_download_url <>", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlGreaterThan(String value) {
            addCriterion("app_download_url >", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("app_download_url >=", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLessThan(String value) {
            addCriterion("app_download_url <", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("app_download_url <=", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlLike(String value) {
            addCriterion("app_download_url like", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotLike(String value) {
            addCriterion("app_download_url not like", value, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlIn(List<String> values) {
            addCriterion("app_download_url in", values, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotIn(List<String> values) {
            addCriterion("app_download_url not in", values, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlBetween(String value1, String value2) {
            addCriterion("app_download_url between", value1, value2, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("app_download_url not between", value1, value2, "appDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailIsNull() {
            addCriterion("app_update_detail is null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailIsNotNull() {
            addCriterion("app_update_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailEqualTo(String value) {
            addCriterion("app_update_detail =", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailNotEqualTo(String value) {
            addCriterion("app_update_detail <>", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailGreaterThan(String value) {
            addCriterion("app_update_detail >", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailGreaterThanOrEqualTo(String value) {
            addCriterion("app_update_detail >=", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailLessThan(String value) {
            addCriterion("app_update_detail <", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailLessThanOrEqualTo(String value) {
            addCriterion("app_update_detail <=", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailLike(String value) {
            addCriterion("app_update_detail like", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailNotLike(String value) {
            addCriterion("app_update_detail not like", value, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailIn(List<String> values) {
            addCriterion("app_update_detail in", values, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailNotIn(List<String> values) {
            addCriterion("app_update_detail not in", values, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailBetween(String value1, String value2) {
            addCriterion("app_update_detail between", value1, value2, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateDetailNotBetween(String value1, String value2) {
            addCriterion("app_update_detail not between", value1, value2, "appUpdateDetail");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserIsNull() {
            addCriterion("app_update_user is null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserIsNotNull() {
            addCriterion("app_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserEqualTo(String value) {
            addCriterion("app_update_user =", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserNotEqualTo(String value) {
            addCriterion("app_update_user <>", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserGreaterThan(String value) {
            addCriterion("app_update_user >", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("app_update_user >=", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserLessThan(String value) {
            addCriterion("app_update_user <", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("app_update_user <=", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserLike(String value) {
            addCriterion("app_update_user like", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserNotLike(String value) {
            addCriterion("app_update_user not like", value, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserIn(List<String> values) {
            addCriterion("app_update_user in", values, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserNotIn(List<String> values) {
            addCriterion("app_update_user not in", values, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserBetween(String value1, String value2) {
            addCriterion("app_update_user between", value1, value2, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppUpdateUserNotBetween(String value1, String value2) {
            addCriterion("app_update_user not between", value1, value2, "appUpdateUser");
            return (Criteria) this;
        }

        public Criteria andAppStatusIsNull() {
            addCriterion("app_status is null");
            return (Criteria) this;
        }

        public Criteria andAppStatusIsNotNull() {
            addCriterion("app_status is not null");
            return (Criteria) this;
        }

        public Criteria andAppStatusEqualTo(Integer value) {
            addCriterion("app_status =", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotEqualTo(Integer value) {
            addCriterion("app_status <>", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusGreaterThan(Integer value) {
            addCriterion("app_status >", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_status >=", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusLessThan(Integer value) {
            addCriterion("app_status <", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusLessThanOrEqualTo(Integer value) {
            addCriterion("app_status <=", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusIn(List<Integer> values) {
            addCriterion("app_status in", values, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotIn(List<Integer> values) {
            addCriterion("app_status not in", values, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusBetween(Integer value1, Integer value2) {
            addCriterion("app_status between", value1, value2, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("app_status not between", value1, value2, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppChannelIsNull() {
            addCriterion("app_channel is null");
            return (Criteria) this;
        }

        public Criteria andAppChannelIsNotNull() {
            addCriterion("app_channel is not null");
            return (Criteria) this;
        }

        public Criteria andAppChannelEqualTo(Integer value) {
            addCriterion("app_channel =", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotEqualTo(Integer value) {
            addCriterion("app_channel <>", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelGreaterThan(Integer value) {
            addCriterion("app_channel >", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_channel >=", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelLessThan(Integer value) {
            addCriterion("app_channel <", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelLessThanOrEqualTo(Integer value) {
            addCriterion("app_channel <=", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelIn(List<Integer> values) {
            addCriterion("app_channel in", values, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotIn(List<Integer> values) {
            addCriterion("app_channel not in", values, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelBetween(Integer value1, Integer value2) {
            addCriterion("app_channel between", value1, value2, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("app_channel not between", value1, value2, "appChannel");
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
package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipInfoExample() {
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

        public Criteria andEquipNoIsNull() {
            addCriterion("equip_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNotNull() {
            addCriterion("equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNoEqualTo(String value) {
            addCriterion("equip_no =", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotEqualTo(String value) {
            addCriterion("equip_no <>", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThan(String value) {
            addCriterion("equip_no >", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("equip_no >=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThan(String value) {
            addCriterion("equip_no <", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThanOrEqualTo(String value) {
            addCriterion("equip_no <=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLike(String value) {
            addCriterion("equip_no like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotLike(String value) {
            addCriterion("equip_no not like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIn(List<String> values) {
            addCriterion("equip_no in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotIn(List<String> values) {
            addCriterion("equip_no not in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoBetween(String value1, String value2) {
            addCriterion("equip_no between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotBetween(String value1, String value2) {
            addCriterion("equip_no not between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipUriIsNull() {
            addCriterion("equip_uri is null");
            return (Criteria) this;
        }

        public Criteria andEquipUriIsNotNull() {
            addCriterion("equip_uri is not null");
            return (Criteria) this;
        }

        public Criteria andEquipUriEqualTo(String value) {
            addCriterion("equip_uri =", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriNotEqualTo(String value) {
            addCriterion("equip_uri <>", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriGreaterThan(String value) {
            addCriterion("equip_uri >", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriGreaterThanOrEqualTo(String value) {
            addCriterion("equip_uri >=", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriLessThan(String value) {
            addCriterion("equip_uri <", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriLessThanOrEqualTo(String value) {
            addCriterion("equip_uri <=", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriLike(String value) {
            addCriterion("equip_uri like", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriNotLike(String value) {
            addCriterion("equip_uri not like", value, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriIn(List<String> values) {
            addCriterion("equip_uri in", values, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriNotIn(List<String> values) {
            addCriterion("equip_uri not in", values, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriBetween(String value1, String value2) {
            addCriterion("equip_uri between", value1, value2, "equipUri");
            return (Criteria) this;
        }

        public Criteria andEquipUriNotBetween(String value1, String value2) {
            addCriterion("equip_uri not between", value1, value2, "equipUri");
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

        public Criteria andEquipModeIsNull() {
            addCriterion("equip_mode is null");
            return (Criteria) this;
        }

        public Criteria andEquipModeIsNotNull() {
            addCriterion("equip_mode is not null");
            return (Criteria) this;
        }

        public Criteria andEquipModeEqualTo(String value) {
            addCriterion("equip_mode =", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeNotEqualTo(String value) {
            addCriterion("equip_mode <>", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeGreaterThan(String value) {
            addCriterion("equip_mode >", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_mode >=", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeLessThan(String value) {
            addCriterion("equip_mode <", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeLessThanOrEqualTo(String value) {
            addCriterion("equip_mode <=", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeLike(String value) {
            addCriterion("equip_mode like", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeNotLike(String value) {
            addCriterion("equip_mode not like", value, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeIn(List<String> values) {
            addCriterion("equip_mode in", values, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeNotIn(List<String> values) {
            addCriterion("equip_mode not in", values, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeBetween(String value1, String value2) {
            addCriterion("equip_mode between", value1, value2, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipModeNotBetween(String value1, String value2) {
            addCriterion("equip_mode not between", value1, value2, "equipMode");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeIsNull() {
            addCriterion("equip_describe is null");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeIsNotNull() {
            addCriterion("equip_describe is not null");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeEqualTo(String value) {
            addCriterion("equip_describe =", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeNotEqualTo(String value) {
            addCriterion("equip_describe <>", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeGreaterThan(String value) {
            addCriterion("equip_describe >", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_describe >=", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeLessThan(String value) {
            addCriterion("equip_describe <", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeLessThanOrEqualTo(String value) {
            addCriterion("equip_describe <=", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeLike(String value) {
            addCriterion("equip_describe like", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeNotLike(String value) {
            addCriterion("equip_describe not like", value, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeIn(List<String> values) {
            addCriterion("equip_describe in", values, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeNotIn(List<String> values) {
            addCriterion("equip_describe not in", values, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeBetween(String value1, String value2) {
            addCriterion("equip_describe between", value1, value2, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipDescribeNotBetween(String value1, String value2) {
            addCriterion("equip_describe not between", value1, value2, "equipDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipPowerIsNull() {
            addCriterion("equip_power is null");
            return (Criteria) this;
        }

        public Criteria andEquipPowerIsNotNull() {
            addCriterion("equip_power is not null");
            return (Criteria) this;
        }

        public Criteria andEquipPowerEqualTo(Double value) {
            addCriterion("equip_power =", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerNotEqualTo(Double value) {
            addCriterion("equip_power <>", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerGreaterThan(Double value) {
            addCriterion("equip_power >", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("equip_power >=", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerLessThan(Double value) {
            addCriterion("equip_power <", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerLessThanOrEqualTo(Double value) {
            addCriterion("equip_power <=", value, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerIn(List<Double> values) {
            addCriterion("equip_power in", values, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerNotIn(List<Double> values) {
            addCriterion("equip_power not in", values, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerBetween(Double value1, Double value2) {
            addCriterion("equip_power between", value1, value2, "equipPower");
            return (Criteria) this;
        }

        public Criteria andEquipPowerNotBetween(Double value1, Double value2) {
            addCriterion("equip_power not between", value1, value2, "equipPower");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(String value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(String value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(String value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(String value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(String value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLike(String value) {
            addCriterion("asset_type like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotLike(String value) {
            addCriterion("asset_type not like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<String> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<String> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(String value1, String value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(String value1, String value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNull() {
            addCriterion("asset_value is null");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNotNull() {
            addCriterion("asset_value is not null");
            return (Criteria) this;
        }

        public Criteria andAssetValueEqualTo(Double value) {
            addCriterion("asset_value =", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotEqualTo(Double value) {
            addCriterion("asset_value <>", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThan(Double value) {
            addCriterion("asset_value >", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThanOrEqualTo(Double value) {
            addCriterion("asset_value >=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThan(Double value) {
            addCriterion("asset_value <", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThanOrEqualTo(Double value) {
            addCriterion("asset_value <=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueIn(List<Double> values) {
            addCriterion("asset_value in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotIn(List<Double> values) {
            addCriterion("asset_value not in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueBetween(Double value1, Double value2) {
            addCriterion("asset_value between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotBetween(Double value1, Double value2) {
            addCriterion("asset_value not between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueIsNull() {
            addCriterion("asset_net_value is null");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueIsNotNull() {
            addCriterion("asset_net_value is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueEqualTo(Double value) {
            addCriterion("asset_net_value =", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueNotEqualTo(Double value) {
            addCriterion("asset_net_value <>", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueGreaterThan(Double value) {
            addCriterion("asset_net_value >", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueGreaterThanOrEqualTo(Double value) {
            addCriterion("asset_net_value >=", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueLessThan(Double value) {
            addCriterion("asset_net_value <", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueLessThanOrEqualTo(Double value) {
            addCriterion("asset_net_value <=", value, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueIn(List<Double> values) {
            addCriterion("asset_net_value in", values, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueNotIn(List<Double> values) {
            addCriterion("asset_net_value not in", values, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueBetween(Double value1, Double value2) {
            addCriterion("asset_net_value between", value1, value2, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andAssetNetValueNotBetween(Double value1, Double value2) {
            addCriterion("asset_net_value not between", value1, value2, "assetNetValue");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteIsNull() {
            addCriterion("installation_site is null");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteIsNotNull() {
            addCriterion("installation_site is not null");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteEqualTo(String value) {
            addCriterion("installation_site =", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteNotEqualTo(String value) {
            addCriterion("installation_site <>", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteGreaterThan(String value) {
            addCriterion("installation_site >", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteGreaterThanOrEqualTo(String value) {
            addCriterion("installation_site >=", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteLessThan(String value) {
            addCriterion("installation_site <", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteLessThanOrEqualTo(String value) {
            addCriterion("installation_site <=", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteLike(String value) {
            addCriterion("installation_site like", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteNotLike(String value) {
            addCriterion("installation_site not like", value, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteIn(List<String> values) {
            addCriterion("installation_site in", values, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteNotIn(List<String> values) {
            addCriterion("installation_site not in", values, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteBetween(String value1, String value2) {
            addCriterion("installation_site between", value1, value2, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationSiteNotBetween(String value1, String value2) {
            addCriterion("installation_site not between", value1, value2, "installationSite");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationIsNull() {
            addCriterion("installation_location is null");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationIsNotNull() {
            addCriterion("installation_location is not null");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationEqualTo(String value) {
            addCriterion("installation_location =", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationNotEqualTo(String value) {
            addCriterion("installation_location <>", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationGreaterThan(String value) {
            addCriterion("installation_location >", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationGreaterThanOrEqualTo(String value) {
            addCriterion("installation_location >=", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationLessThan(String value) {
            addCriterion("installation_location <", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationLessThanOrEqualTo(String value) {
            addCriterion("installation_location <=", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationLike(String value) {
            addCriterion("installation_location like", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationNotLike(String value) {
            addCriterion("installation_location not like", value, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationIn(List<String> values) {
            addCriterion("installation_location in", values, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationNotIn(List<String> values) {
            addCriterion("installation_location not in", values, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationBetween(String value1, String value2) {
            addCriterion("installation_location between", value1, value2, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andInstallationLocationNotBetween(String value1, String value2) {
            addCriterion("installation_location not between", value1, value2, "installationLocation");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneIsNull() {
            addCriterion("service_telephone is null");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneIsNotNull() {
            addCriterion("service_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneEqualTo(String value) {
            addCriterion("service_telephone =", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneNotEqualTo(String value) {
            addCriterion("service_telephone <>", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneGreaterThan(String value) {
            addCriterion("service_telephone >", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("service_telephone >=", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneLessThan(String value) {
            addCriterion("service_telephone <", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneLessThanOrEqualTo(String value) {
            addCriterion("service_telephone <=", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneLike(String value) {
            addCriterion("service_telephone like", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneNotLike(String value) {
            addCriterion("service_telephone not like", value, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneIn(List<String> values) {
            addCriterion("service_telephone in", values, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneNotIn(List<String> values) {
            addCriterion("service_telephone not in", values, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneBetween(String value1, String value2) {
            addCriterion("service_telephone between", value1, value2, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andServiceTelephoneNotBetween(String value1, String value2) {
            addCriterion("service_telephone not between", value1, value2, "serviceTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIsNull() {
            addCriterion("purchase_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIsNotNull() {
            addCriterion("purchase_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoEqualTo(String value) {
            addCriterion("purchase_no =", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotEqualTo(String value) {
            addCriterion("purchase_no <>", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThan(String value) {
            addCriterion("purchase_no >", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_no >=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThan(String value) {
            addCriterion("purchase_no <", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_no <=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLike(String value) {
            addCriterion("purchase_no like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotLike(String value) {
            addCriterion("purchase_no not like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIn(List<String> values) {
            addCriterion("purchase_no in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotIn(List<String> values) {
            addCriterion("purchase_no not in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoBetween(String value1, String value2) {
            addCriterion("purchase_no between", value1, value2, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotBetween(String value1, String value2) {
            addCriterion("purchase_no not between", value1, value2, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNull() {
            addCriterion("purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNotNull() {
            addCriterion("purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateEqualTo(Date value) {
            addCriterion("purchase_date =", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotEqualTo(Date value) {
            addCriterion("purchase_date <>", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThan(Date value) {
            addCriterion("purchase_date >", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_date >=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThan(Date value) {
            addCriterion("purchase_date <", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("purchase_date <=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIn(List<Date> values) {
            addCriterion("purchase_date in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotIn(List<Date> values) {
            addCriterion("purchase_date not in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateBetween(Date value1, Date value2) {
            addCriterion("purchase_date between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("purchase_date not between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateIsNull() {
            addCriterion("invocation_date is null");
            return (Criteria) this;
        }

        public Criteria andInvocationDateIsNotNull() {
            addCriterion("invocation_date is not null");
            return (Criteria) this;
        }

        public Criteria andInvocationDateEqualTo(Date value) {
            addCriterion("invocation_date =", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateNotEqualTo(Date value) {
            addCriterion("invocation_date <>", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateGreaterThan(Date value) {
            addCriterion("invocation_date >", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("invocation_date >=", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateLessThan(Date value) {
            addCriterion("invocation_date <", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateLessThanOrEqualTo(Date value) {
            addCriterion("invocation_date <=", value, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateIn(List<Date> values) {
            addCriterion("invocation_date in", values, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateNotIn(List<Date> values) {
            addCriterion("invocation_date not in", values, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateBetween(Date value1, Date value2) {
            addCriterion("invocation_date between", value1, value2, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andInvocationDateNotBetween(Date value1, Date value2) {
            addCriterion("invocation_date not between", value1, value2, "invocationDate");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIsNull() {
            addCriterion("maintenance_period is null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIsNotNull() {
            addCriterion("maintenance_period is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodEqualTo(String value) {
            addCriterion("maintenance_period =", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotEqualTo(String value) {
            addCriterion("maintenance_period <>", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodGreaterThan(String value) {
            addCriterion("maintenance_period >", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_period >=", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLessThan(String value) {
            addCriterion("maintenance_period <", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLessThanOrEqualTo(String value) {
            addCriterion("maintenance_period <=", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLike(String value) {
            addCriterion("maintenance_period like", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotLike(String value) {
            addCriterion("maintenance_period not like", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIn(List<String> values) {
            addCriterion("maintenance_period in", values, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotIn(List<String> values) {
            addCriterion("maintenance_period not in", values, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodBetween(String value1, String value2) {
            addCriterion("maintenance_period between", value1, value2, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotBetween(String value1, String value2) {
            addCriterion("maintenance_period not between", value1, value2, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andExpirationYearIsNull() {
            addCriterion("expiration_year is null");
            return (Criteria) this;
        }

        public Criteria andExpirationYearIsNotNull() {
            addCriterion("expiration_year is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationYearEqualTo(Integer value) {
            addCriterion("expiration_year =", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearNotEqualTo(Integer value) {
            addCriterion("expiration_year <>", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearGreaterThan(Integer value) {
            addCriterion("expiration_year >", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("expiration_year >=", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearLessThan(Integer value) {
            addCriterion("expiration_year <", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearLessThanOrEqualTo(Integer value) {
            addCriterion("expiration_year <=", value, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearIn(List<Integer> values) {
            addCriterion("expiration_year in", values, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearNotIn(List<Integer> values) {
            addCriterion("expiration_year not in", values, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearBetween(Integer value1, Integer value2) {
            addCriterion("expiration_year between", value1, value2, "expirationYear");
            return (Criteria) this;
        }

        public Criteria andExpirationYearNotBetween(Integer value1, Integer value2) {
            addCriterion("expiration_year not between", value1, value2, "expirationYear");
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

        public Criteria andEquipPictureIsNull() {
            addCriterion("equip_picture is null");
            return (Criteria) this;
        }

        public Criteria andEquipPictureIsNotNull() {
            addCriterion("equip_picture is not null");
            return (Criteria) this;
        }

        public Criteria andEquipPictureEqualTo(String value) {
            addCriterion("equip_picture =", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotEqualTo(String value) {
            addCriterion("equip_picture <>", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureGreaterThan(String value) {
            addCriterion("equip_picture >", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureGreaterThanOrEqualTo(String value) {
            addCriterion("equip_picture >=", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLessThan(String value) {
            addCriterion("equip_picture <", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLessThanOrEqualTo(String value) {
            addCriterion("equip_picture <=", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureLike(String value) {
            addCriterion("equip_picture like", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotLike(String value) {
            addCriterion("equip_picture not like", value, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureIn(List<String> values) {
            addCriterion("equip_picture in", values, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotIn(List<String> values) {
            addCriterion("equip_picture not in", values, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureBetween(String value1, String value2) {
            addCriterion("equip_picture between", value1, value2, "equipPicture");
            return (Criteria) this;
        }

        public Criteria andEquipPictureNotBetween(String value1, String value2) {
            addCriterion("equip_picture not between", value1, value2, "equipPicture");
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

        public Criteria andEquipNameIsNull() {
            addCriterion("equip_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipNameIsNotNull() {
            addCriterion("equip_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNameEqualTo(String value) {
            addCriterion("equip_name =", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotEqualTo(String value) {
            addCriterion("equip_name <>", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThan(String value) {
            addCriterion("equip_name >", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameGreaterThanOrEqualTo(String value) {
            addCriterion("equip_name >=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThan(String value) {
            addCriterion("equip_name <", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLessThanOrEqualTo(String value) {
            addCriterion("equip_name <=", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameLike(String value) {
            addCriterion("equip_name like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotLike(String value) {
            addCriterion("equip_name not like", value, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameIn(List<String> values) {
            addCriterion("equip_name in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotIn(List<String> values) {
            addCriterion("equip_name not in", values, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameBetween(String value1, String value2) {
            addCriterion("equip_name between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipNameNotBetween(String value1, String value2) {
            addCriterion("equip_name not between", value1, value2, "equipName");
            return (Criteria) this;
        }

        public Criteria andEquipCodeIsNull() {
            addCriterion("equip_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipCodeIsNotNull() {
            addCriterion("equip_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipCodeEqualTo(String value) {
            addCriterion("equip_code =", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeNotEqualTo(String value) {
            addCriterion("equip_code <>", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeGreaterThan(String value) {
            addCriterion("equip_code >", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_code >=", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeLessThan(String value) {
            addCriterion("equip_code <", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeLessThanOrEqualTo(String value) {
            addCriterion("equip_code <=", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeLike(String value) {
            addCriterion("equip_code like", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeNotLike(String value) {
            addCriterion("equip_code not like", value, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeIn(List<String> values) {
            addCriterion("equip_code in", values, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeNotIn(List<String> values) {
            addCriterion("equip_code not in", values, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeBetween(String value1, String value2) {
            addCriterion("equip_code between", value1, value2, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipCodeNotBetween(String value1, String value2) {
            addCriterion("equip_code not between", value1, value2, "equipCode");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeIsNull() {
            addCriterion("equip_main_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeIsNotNull() {
            addCriterion("equip_main_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeEqualTo(String value) {
            addCriterion("equip_main_type =", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeNotEqualTo(String value) {
            addCriterion("equip_main_type <>", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeGreaterThan(String value) {
            addCriterion("equip_main_type >", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_main_type >=", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeLessThan(String value) {
            addCriterion("equip_main_type <", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeLessThanOrEqualTo(String value) {
            addCriterion("equip_main_type <=", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeLike(String value) {
            addCriterion("equip_main_type like", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeNotLike(String value) {
            addCriterion("equip_main_type not like", value, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeIn(List<String> values) {
            addCriterion("equip_main_type in", values, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeNotIn(List<String> values) {
            addCriterion("equip_main_type not in", values, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeBetween(String value1, String value2) {
            addCriterion("equip_main_type between", value1, value2, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andEquipMainTypeNotBetween(String value1, String value2) {
            addCriterion("equip_main_type not between", value1, value2, "equipMainType");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
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

        public Criteria andEquipTypeCodeIsNull() {
            addCriterion("equip_type_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeIsNotNull() {
            addCriterion("equip_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeEqualTo(String value) {
            addCriterion("equip_type_code =", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeNotEqualTo(String value) {
            addCriterion("equip_type_code <>", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeGreaterThan(String value) {
            addCriterion("equip_type_code >", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equip_type_code >=", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeLessThan(String value) {
            addCriterion("equip_type_code <", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("equip_type_code <=", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeLike(String value) {
            addCriterion("equip_type_code like", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeNotLike(String value) {
            addCriterion("equip_type_code not like", value, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeIn(List<String> values) {
            addCriterion("equip_type_code in", values, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeNotIn(List<String> values) {
            addCriterion("equip_type_code not in", values, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeBetween(String value1, String value2) {
            addCriterion("equip_type_code between", value1, value2, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipTypeCodeNotBetween(String value1, String value2) {
            addCriterion("equip_type_code not between", value1, value2, "equipTypeCode");
            return (Criteria) this;
        }

        public Criteria andEquipSortIsNull() {
            addCriterion("equip_sort is null");
            return (Criteria) this;
        }

        public Criteria andEquipSortIsNotNull() {
            addCriterion("equip_sort is not null");
            return (Criteria) this;
        }

        public Criteria andEquipSortEqualTo(Integer value) {
            addCriterion("equip_sort =", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotEqualTo(Integer value) {
            addCriterion("equip_sort <>", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortGreaterThan(Integer value) {
            addCriterion("equip_sort >", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_sort >=", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortLessThan(Integer value) {
            addCriterion("equip_sort <", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortLessThanOrEqualTo(Integer value) {
            addCriterion("equip_sort <=", value, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortIn(List<Integer> values) {
            addCriterion("equip_sort in", values, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotIn(List<Integer> values) {
            addCriterion("equip_sort not in", values, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortBetween(Integer value1, Integer value2) {
            addCriterion("equip_sort between", value1, value2, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipSortNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_sort not between", value1, value2, "equipSort");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeIsNull() {
            addCriterion("equip_new_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeIsNotNull() {
            addCriterion("equip_new_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeEqualTo(Integer value) {
            addCriterion("equip_new_type =", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeNotEqualTo(Integer value) {
            addCriterion("equip_new_type <>", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeGreaterThan(Integer value) {
            addCriterion("equip_new_type >", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip_new_type >=", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeLessThan(Integer value) {
            addCriterion("equip_new_type <", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeLessThanOrEqualTo(Integer value) {
            addCriterion("equip_new_type <=", value, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeIn(List<Integer> values) {
            addCriterion("equip_new_type in", values, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeNotIn(List<Integer> values) {
            addCriterion("equip_new_type not in", values, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeBetween(Integer value1, Integer value2) {
            addCriterion("equip_new_type between", value1, value2, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andEquipNewTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("equip_new_type not between", value1, value2, "equipNewType");
            return (Criteria) this;
        }

        public Criteria andIssueNoIsNull() {
            addCriterion("issue_no is null");
            return (Criteria) this;
        }

        public Criteria andIssueNoIsNotNull() {
            addCriterion("issue_no is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNoEqualTo(String value) {
            addCriterion("issue_no =", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotEqualTo(String value) {
            addCriterion("issue_no <>", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThan(String value) {
            addCriterion("issue_no >", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoGreaterThanOrEqualTo(String value) {
            addCriterion("issue_no >=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThan(String value) {
            addCriterion("issue_no <", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLessThanOrEqualTo(String value) {
            addCriterion("issue_no <=", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoLike(String value) {
            addCriterion("issue_no like", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotLike(String value) {
            addCriterion("issue_no not like", value, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoIn(List<String> values) {
            addCriterion("issue_no in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotIn(List<String> values) {
            addCriterion("issue_no not in", values, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoBetween(String value1, String value2) {
            addCriterion("issue_no between", value1, value2, "issueNo");
            return (Criteria) this;
        }

        public Criteria andIssueNoNotBetween(String value1, String value2) {
            addCriterion("issue_no not between", value1, value2, "issueNo");
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
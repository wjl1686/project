package com.ejobim.opplat.domain.synBean;
/**
 * 水厂基本信息实体
 */
public class FactoryInfoEntity {

    private Integer Id;
    private String BatchId;
    private String BBQ_;
    private String USERID_;
    private String BTYPE_;
    private String SHTAG_;
    private String SHTAG2_;
    private String OPTION_;
    private String Code;
    //水厂序号
    private String NO;
    //父级编号
    private String ParentCode;
    // 业务大区编号
    private String AreaCode;
    //业务大区名称
    private String AreaName;
    //水厂名称
    private String FullName;
    //水厂简称
    private String ShortName;
    //水厂分级
    private String WaterworksLevel;
    //运营公司名称
    private String CompanyName;
    //项目类别
    private String ProjectType;
    //所在地区--省
    private String Province;
    //所在地区--市
    private String City;
    //项目地址
    private String Address;

    private String AccountNumber;

    private String IsWaterworks;
    // 经度
    private String Lng;
    // 维度
    private String Lat;
    //规划规模
    private Double FranchiseModel;
    //是否集团运营 是/否
    private String IsGroupOperation;
    //合同规模
    private Double ProPlanScale;
    //权益比例
    private Double ProBuildRate;
    //权益规模
    private Double ProBuildScale;
    //建设规模
    private Double ProConsStage;
    //运营规模
    private Double ProScaleOperation;
    //运营维护管网长度（km）
    private Double ProScaleMaintain;
    // 服务人口
    private Double PlanServicePopulation;
    //服务面积
    private Double PlanServiceArea;
    //工业废水比例（%）
    private Double PlanIndustrialWasteWater;
    //核心工艺
    private String PlanCoreTechnology;
    //出水水质标准
    private String PlanEffluentQualityStandard;
    //合同期限
    private String ContractPeriod;
    //保底水量
    private Double BaseWater;
    //合同单价
    private Double UnitContractPrice;
    //商运起始时间
    private String RunStartDate;
    //备注
    private String Remark;
    // 项目类别名称
    private String ProjectName;
    //退出时间
    private String ExitTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBatchId() {
        return BatchId;
    }

    public void setBatchId(String batchId) {
        BatchId = batchId;
    }

    public String getBBQ_() {
        return BBQ_;
    }

    public void setBBQ_(String BBQ_) {
        this.BBQ_ = BBQ_;
    }

    public String getUSERID_() {
        return USERID_;
    }

    public void setUSERID_(String USERID_) {
        this.USERID_ = USERID_;
    }

    public String getBTYPE_() {
        return BTYPE_;
    }

    public void setBTYPE_(String BTYPE_) {
        this.BTYPE_ = BTYPE_;
    }

    public String getSHTAG_() {
        return SHTAG_;
    }

    public void setSHTAG_(String SHTAG_) {
        this.SHTAG_ = SHTAG_;
    }

    public String getSHTAG2_() {
        return SHTAG2_;
    }

    public void setSHTAG2_(String SHTAG2_) {
        this.SHTAG2_ = SHTAG2_;
    }

    public String getOPTION_() {
        return OPTION_;
    }

    public void setOPTION_(String OPTION_) {
        this.OPTION_ = OPTION_;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getParentCode() {
        return ParentCode;
    }

    public void setParentCode(String parentCode) {
        ParentCode = parentCode;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getWaterworksLevel() {
        return WaterworksLevel;
    }

    public void setWaterworksLevel(String waterworksLevel) {
        WaterworksLevel = waterworksLevel;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getProjectType() {
        return ProjectType;
    }

    public void setProjectType(String projectType) {
        ProjectType = projectType;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getIsWaterworks() {
        return IsWaterworks;
    }

    public void setIsWaterworks(String isWaterworks) {
        IsWaterworks = isWaterworks;
    }

    public String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public Double getFranchiseModel() {
        return FranchiseModel;
    }

    public void setFranchiseModel(Double franchiseModel) {
        FranchiseModel = franchiseModel;
    }

    public String getIsGroupOperation() {
        return IsGroupOperation;
    }

    public void setIsGroupOperation(String isGroupOperation) {
        IsGroupOperation = isGroupOperation;
    }

    public Double getProPlanScale() {
        return ProPlanScale;
    }

    public void setProPlanScale(Double proPlanScale) {
        ProPlanScale = proPlanScale;
    }

    public Double getProBuildRate() {
        return ProBuildRate;
    }

    public void setProBuildRate(Double proBuildRate) {
        ProBuildRate = proBuildRate;
    }

    public Double getProBuildScale() {
        return ProBuildScale;
    }

    public void setProBuildScale(Double proBuildScale) {
        ProBuildScale = proBuildScale;
    }

    public Double getProConsStage() {
        return ProConsStage;
    }

    public void setProConsStage(Double proConsStage) {
        ProConsStage = proConsStage;
    }

    public Double getProScaleOperation() {
        return ProScaleOperation;
    }

    public void setProScaleOperation(Double proScaleOperation) {
        ProScaleOperation = proScaleOperation;
    }

    public Double getProScaleMaintain() {
        return ProScaleMaintain;
    }

    public void setProScaleMaintain(Double proScaleMaintain) {
        ProScaleMaintain = proScaleMaintain;
    }

    public Double getPlanServicePopulation() {
        return PlanServicePopulation;
    }

    public void setPlanServicePopulation(Double planServicePopulation) {
        PlanServicePopulation = planServicePopulation;
    }

    public Double getPlanServiceArea() {
        return PlanServiceArea;
    }

    public void setPlanServiceArea(Double planServiceArea) {
        PlanServiceArea = planServiceArea;
    }

    public Double getPlanIndustrialWasteWater() {
        return PlanIndustrialWasteWater;
    }

    public void setPlanIndustrialWasteWater(Double planIndustrialWasteWater) {
        PlanIndustrialWasteWater = planIndustrialWasteWater;
    }

    public String getPlanCoreTechnology() {
        return PlanCoreTechnology;
    }

    public void setPlanCoreTechnology(String planCoreTechnology) {
        PlanCoreTechnology = planCoreTechnology;
    }

    public String getPlanEffluentQualityStandard() {
        return PlanEffluentQualityStandard;
    }

    public void setPlanEffluentQualityStandard(String planEffluentQualityStandard) {
        PlanEffluentQualityStandard = planEffluentQualityStandard;
    }

    public String getContractPeriod() {
        return ContractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        ContractPeriod = contractPeriod;
    }

    public Double getBaseWater() {
        return BaseWater;
    }

    public void setBaseWater(Double baseWater) {
        BaseWater = baseWater;
    }

    public Double getUnitContractPrice() {
        return UnitContractPrice;
    }

    public void setUnitContractPrice(Double unitContractPrice) {
        UnitContractPrice = unitContractPrice;
    }

    public String getRunStartDate() {
        return RunStartDate;
    }

    public void setRunStartDate(String runStartDate) {
        RunStartDate = runStartDate;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getExitTime() {
        return ExitTime;
    }

    public void setExitTime(String exitTime) {
        ExitTime = exitTime;
    }

}

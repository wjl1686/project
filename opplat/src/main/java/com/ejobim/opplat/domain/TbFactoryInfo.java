package com.ejobim.opplat.domain;

import java.util.Date;
import java.util.List;

public class TbFactoryInfo {

    private String factoryNo;

    private String factoryName;

    private String factoryAddress;

    private String factoryLocation;

    private String factoryManager;

    private String factoryTelephone;

    private String factoryDescribe;

    private String uri;

    private String browsepath;

    private String browsename;

    private Date createTime;

    private String factorySerialNo;

    private String region;

    private String  regionName;

    private String operateAbbreviation;

    private String operateCompanyName;
    //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目
    private Integer projectType;

    private String projectTypeName;

    private String projectAddress;

    private Double latitude;

    private Double longitude;
    //是否集团运营 1运行  0：不运营
    private Integer operateType;

    private String operateTypeName;

    private Date businessStartTime;

    private String businessStartTimeName;

    private String remarks;

    private Date projectExitTime;

    private String projectExitTimeName;

    private String item;

    private String value;

    private String factoryMap;
    
    private String centerUrl;

    private Integer issueNo;

    private String parentFactoryNo;

    private String orgGroupNo;

    private Integer sortindex;

    private String descripion;

    private String factoryCode;
    //分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂
    private Integer level;

    private String levelName;

    private Double planningScale;

    private Double contractScale;

    private Double powerRate;

    private Double powerScale;

    private Double buileScale;

    private Double holdScale;

    private Double holdMaintain;

    private Double servicePopulation;

    private Double serviceArea;

    private Double industrialWasteRate;

    private String coreProcess;
    
    private String waterQualityNormOut;

    private String waterQualityNormOutName;

    private Double contractPeriod;

    private Double keepWaterVolume;

    private Double contractUnitPrice;

    private String filledAccount;

    private Date lastUpdateTime;

    //总进水COD设计值（mg/L）
    private Double totalInwaterCod;

    private Double totalInwaterBod;

    private Double totalInwaterSs;

    private Double totalInwaterNh3N;

    private Double totalInwaterTn;

    private Double totalInwaterTp;

    private Double totalInwaterPhUp;

    private Double totalInwaterPhDown;

    private Integer totalInwaterChroma;

    private Double totalOutwaterCod;

    private Double totalOutwaterBod;

    private Double totalOutwaterSs;

    private Double totalOutwaterNh3N1;

    private Double totalOutwaterNh3N2;

    private Double totalOutwaterTn;

    private Double totalOutwaterTp;

    private Double totalOutwaterPhUp;

    private Double totalOutwaterPhDown;

    private Integer totalOutwaterChroma;

    private Integer totalOutwaterColiform;

    private Integer totalOutwaterTurbidity;

    private Double totalOutwaterDissolution;

    private Double totalOutwaterHardness;

    private Double totalOutwaterAnion;
    //计量口径
    // 1:进水 2:出水 3:其他    -- (父id 65)
    private String measureCaliberTypeName;

    private String measureCaliberType;

    private String description;

    //脱水系统设计参数 //todo

    private String sludgeTypeName;
    // 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
    private Integer sludgeType;

    private String dehydrationTypeName;

    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
    private Integer dehydrationType;

    private Double dehydrationMud;

    private String dehydrationPreTypeName;
    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
    private Integer dehydrationPreType;

    private Double preDehydrationMudWaterRate;

    private String mudDepthDehydrationTypeName;
    //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
    private Integer mudDepthDehydrationType;

    private Double depthDehydrationMudWaterRate;

    private String mudTransportTypeName;
    // 1: 政府运输 2:自行运输       --父id  99
    private Integer mudTransportType;

    private String mudHandleTypeName;
    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
    private Integer mudHandleType;

    private TbFactoryWater inOutWater;

    private TbFactoryDehydrationSystem dehydrationSystem;

    private TbFactoryInfoExtend factoryInfoExtend;

    private TbFactoryMeasureCaliber factoryMeasureCaliber;

    private List<TbDict> tbDicts;

    private List<TbOrg> tbOrgList;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo == null ? null : factoryNo.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress == null ? null : factoryAddress.trim();
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation == null ? null : factoryLocation.trim();
    }

    public String getFactoryManager() {
        return factoryManager;
    }

    public void setFactoryManager(String factoryManager) {
        this.factoryManager = factoryManager == null ? null : factoryManager.trim();
    }

    public String getFactoryTelephone() {
        return factoryTelephone;
    }

    public void setFactoryTelephone(String factoryTelephone) {
        this.factoryTelephone = factoryTelephone == null ? null : factoryTelephone.trim();
    }

    public String getFactoryDescribe() {
        return factoryDescribe;
    }

    public void setFactoryDescribe(String factoryDescribe) {
        this.factoryDescribe = factoryDescribe == null ? null : factoryDescribe.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getBrowsepath() {
        return browsepath;
    }

    public void setBrowsepath(String browsepath) {
        this.browsepath = browsepath == null ? null : browsepath.trim();
    }

    public String getBrowsename() {
        return browsename;
    }

    public void setBrowsename(String browsename) {
        this.browsename = browsename == null ? null : browsename.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFactorySerialNo() {
        return factorySerialNo;
    }

    public void setFactorySerialNo(String factorySerialNo) {
        this.factorySerialNo = factorySerialNo == null ? null : factorySerialNo.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getOperateAbbreviation() {
        return operateAbbreviation;
    }

    public void setOperateAbbreviation(String operateAbbreviation) {
        this.operateAbbreviation = operateAbbreviation == null ? null : operateAbbreviation.trim();
    }

    public String getOperateCompanyName() {
        return operateCompanyName;
    }

    public void setOperateCompanyName(String operateCompanyName) {
        this.operateCompanyName = operateCompanyName == null ? null : operateCompanyName.trim();
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getProjectExitTime() {
        return projectExitTime;
    }

    public void setProjectExitTime(Date projectExitTime) {
        this.projectExitTime = projectExitTime;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion == null ? null : descripion.trim();
    }

    public Integer getSortindex() {
        return sortindex;
    }

    public void setSortindex(Integer sortindex) {
        this.sortindex = sortindex;
    }


    public TbFactoryWater getInOutWater() {
        return inOutWater;
    }

    public void setInOutWater(TbFactoryWater inOutWater) {
        this.inOutWater = inOutWater;
    }

    public TbFactoryDehydrationSystem getDehydrationSystem() {
        return dehydrationSystem;
    }

    public void setDehydrationSystem(TbFactoryDehydrationSystem dehydrationSystem) {
        this.dehydrationSystem = dehydrationSystem;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public TbFactoryInfoExtend getFactoryInfoExtend() {
        return factoryInfoExtend;
    }

    public void setFactoryInfoExtend(TbFactoryInfoExtend factoryInfoExtend) {
        this.factoryInfoExtend = factoryInfoExtend;
    }

    public TbFactoryMeasureCaliber getFactoryMeasureCaliber() {
        return factoryMeasureCaliber;
    }

    public void setFactoryMeasureCaliber(TbFactoryMeasureCaliber factoryMeasureCaliber) {
        this.factoryMeasureCaliber = factoryMeasureCaliber;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getOperateTypeName() {
        return operateTypeName;
    }

    public void setOperateTypeName(String operateTypeName) {
        this.operateTypeName = operateTypeName;
    }

    public String getBusinessStartTimeName() {
        return businessStartTimeName;
    }

    public void setBusinessStartTimeName(String businessStartTimeName) {
        this.businessStartTimeName = businessStartTimeName;
    }

    public String getProjectExitTimeName() {
        return projectExitTimeName;
    }

    public void setProjectExitTimeName(String projectExitTimeName) {
        this.projectExitTimeName = projectExitTimeName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<TbDict> getTbDicts() {
        return tbDicts;
    }

    public void setTbDicts(List<TbDict> tbDicts) {
        this.tbDicts = tbDicts;
    }

    public List<TbOrg> getTbOrgList() {
        return tbOrgList;
    }

    public void setTbOrgList(List<TbOrg> tbOrgList) {
        this.tbOrgList = tbOrgList;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getPlanningScale() {
        return planningScale;
    }

    public void setPlanningScale(Double planningScale) {
        this.planningScale = planningScale;
    }

    public Double getContractScale() {
        return contractScale;
    }

    public void setContractScale(Double contractScale) {
        this.contractScale = contractScale;
    }

    public Double getPowerRate() {
        return powerRate;
    }

    public void setPowerRate(Double powerRate) {
        this.powerRate = powerRate;
    }

    public Double getPowerScale() {
        return powerScale;
    }

    public void setPowerScale(Double powerScale) {
        this.powerScale = powerScale;
    }

    public Double getBuileScale() {
        return buileScale;
    }

    public void setBuileScale(Double buileScale) {
        this.buileScale = buileScale;
    }

    public Double getHoldScale() {
        return holdScale;
    }

    public void setHoldScale(Double holdScale) {
        this.holdScale = holdScale;
    }

    public Double getHoldMaintain() {
        return holdMaintain;
    }

    public void setHoldMaintain(Double holdMaintain) {
        this.holdMaintain = holdMaintain;
    }

    public Double getServicePopulation() {
        return servicePopulation;
    }

    public void setServicePopulation(Double servicePopulation) {
        this.servicePopulation = servicePopulation;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getIndustrialWasteRate() {
        return industrialWasteRate;
    }

    public void setIndustrialWasteRate(Double industrialWasteRate) {
        this.industrialWasteRate = industrialWasteRate;
    }

    public String getCoreProcess() {
        return coreProcess;
    }

    public void setCoreProcess(String coreProcess) {
        this.coreProcess = coreProcess;
    }

    public String getWaterQualityNormOut() {
        return waterQualityNormOut;
    }

    public void setWaterQualityNormOut(String waterQualityNormOut) {
        this.waterQualityNormOut = waterQualityNormOut;
    }

    public String getWaterQualityNormOutName() {
        return waterQualityNormOutName;
    }

    public void setWaterQualityNormOutName(String waterQualityNormOutName) {
        this.waterQualityNormOutName = waterQualityNormOutName;
    }

    public Double getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Double contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Double getKeepWaterVolume() {
        return keepWaterVolume;
    }

    public void setKeepWaterVolume(Double keepWaterVolume) {
        this.keepWaterVolume = keepWaterVolume;
    }

    public Double getContractUnitPrice() {
        return contractUnitPrice;
    }

    public void setContractUnitPrice(Double contractUnitPrice) {
        this.contractUnitPrice = contractUnitPrice;
    }

    public String getFilledAccount() {
        return filledAccount;
    }

    public void setFilledAccount(String filledAccount) {
        this.filledAccount = filledAccount;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Double getTotalInwaterCod() {
        return totalInwaterCod;
    }

    public void setTotalInwaterCod(Double totalInwaterCod) {
        this.totalInwaterCod = totalInwaterCod;
    }

    public Double getTotalInwaterBod() {
        return totalInwaterBod;
    }

    public void setTotalInwaterBod(Double totalInwaterBod) {
        this.totalInwaterBod = totalInwaterBod;
    }

    public Double getTotalInwaterSs() {
        return totalInwaterSs;
    }

    public void setTotalInwaterSs(Double totalInwaterSs) {
        this.totalInwaterSs = totalInwaterSs;
    }

    public Double getTotalInwaterNh3N() {
        return totalInwaterNh3N;
    }

    public void setTotalInwaterNh3N(Double totalInwaterNh3N) {
        this.totalInwaterNh3N = totalInwaterNh3N;
    }

    public Double getTotalInwaterTn() {
        return totalInwaterTn;
    }

    public void setTotalInwaterTn(Double totalInwaterTn) {
        this.totalInwaterTn = totalInwaterTn;
    }

    public Double getTotalInwaterTp() {
        return totalInwaterTp;
    }

    public void setTotalInwaterTp(Double totalInwaterTp) {
        this.totalInwaterTp = totalInwaterTp;
    }

    public Double getTotalInwaterPhUp() {
        return totalInwaterPhUp;
    }

    public void setTotalInwaterPhUp(Double totalInwaterPhUp) {
        this.totalInwaterPhUp = totalInwaterPhUp;
    }

    public Double getTotalInwaterPhDown() {
        return totalInwaterPhDown;
    }

    public void setTotalInwaterPhDown(Double totalInwaterPhDown) {
        this.totalInwaterPhDown = totalInwaterPhDown;
    }

    public Integer getTotalInwaterChroma() {
        return totalInwaterChroma;
    }

    public void setTotalInwaterChroma(Integer totalInwaterChroma) {
        this.totalInwaterChroma = totalInwaterChroma;
    }

    public Double getTotalOutwaterCod() {
        return totalOutwaterCod;
    }

    public void setTotalOutwaterCod(Double totalOutwaterCod) {
        this.totalOutwaterCod = totalOutwaterCod;
    }

    public Double getTotalOutwaterBod() {
        return totalOutwaterBod;
    }

    public void setTotalOutwaterBod(Double totalOutwaterBod) {
        this.totalOutwaterBod = totalOutwaterBod;
    }

    public Double getTotalOutwaterSs() {
        return totalOutwaterSs;
    }

    public void setTotalOutwaterSs(Double totalOutwaterSs) {
        this.totalOutwaterSs = totalOutwaterSs;
    }

    public Double getTotalOutwaterNh3N1() {
        return totalOutwaterNh3N1;
    }

    public void setTotalOutwaterNh3N1(Double totalOutwaterNh3N1) {
        this.totalOutwaterNh3N1 = totalOutwaterNh3N1;
    }

    public Double getTotalOutwaterNh3N2() {
        return totalOutwaterNh3N2;
    }

    public void setTotalOutwaterNh3N2(Double totalOutwaterNh3N2) {
        this.totalOutwaterNh3N2 = totalOutwaterNh3N2;
    }

    public Double getTotalOutwaterTn() {
        return totalOutwaterTn;
    }

    public void setTotalOutwaterTn(Double totalOutwaterTn) {
        this.totalOutwaterTn = totalOutwaterTn;
    }

    public Double getTotalOutwaterTp() {
        return totalOutwaterTp;
    }

    public void setTotalOutwaterTp(Double totalOutwaterTp) {
        this.totalOutwaterTp = totalOutwaterTp;
    }

    public Double getTotalOutwaterPhUp() {
        return totalOutwaterPhUp;
    }

    public void setTotalOutwaterPhUp(Double totalOutwaterPhUp) {
        this.totalOutwaterPhUp = totalOutwaterPhUp;
    }

    public Double getTotalOutwaterPhDown() {
        return totalOutwaterPhDown;
    }

    public void setTotalOutwaterPhDown(Double totalOutwaterPhDown) {
        this.totalOutwaterPhDown = totalOutwaterPhDown;
    }

    public Integer getTotalOutwaterChroma() {
        return totalOutwaterChroma;
    }

    public void setTotalOutwaterChroma(Integer totalOutwaterChroma) {
        this.totalOutwaterChroma = totalOutwaterChroma;
    }

    public Integer getTotalOutwaterColiform() {
        return totalOutwaterColiform;
    }

    public void setTotalOutwaterColiform(Integer totalOutwaterColiform) {
        this.totalOutwaterColiform = totalOutwaterColiform;
    }

    public Integer getTotalOutwaterTurbidity() {
        return totalOutwaterTurbidity;
    }

    public void setTotalOutwaterTurbidity(Integer totalOutwaterTurbidity) {
        this.totalOutwaterTurbidity = totalOutwaterTurbidity;
    }

    public Double getTotalOutwaterDissolution() {
        return totalOutwaterDissolution;
    }

    public void setTotalOutwaterDissolution(Double totalOutwaterDissolution) {
        this.totalOutwaterDissolution = totalOutwaterDissolution;
    }

    public Double getTotalOutwaterHardness() {
        return totalOutwaterHardness;
    }

    public void setTotalOutwaterHardness(Double totalOutwaterHardness) {
        this.totalOutwaterHardness = totalOutwaterHardness;
    }

    public Double getTotalOutwaterAnion() {
        return totalOutwaterAnion;
    }

    public void setTotalOutwaterAnion(Double totalOutwaterAnion) {
        this.totalOutwaterAnion = totalOutwaterAnion;
    }

    public String getMeasureCaliberTypeName() {
        return measureCaliberTypeName;
    }

    public void setMeasureCaliberTypeName(String measureCaliberTypeName) {
        this.measureCaliberTypeName = measureCaliberTypeName;
    }

    public String getMeasureCaliberType() {
        return measureCaliberType;
    }

    public void setMeasureCaliberType(String measureCaliberType) {
        this.measureCaliberType = measureCaliberType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSludgeTypeName() {
        return sludgeTypeName;
    }

    public void setSludgeTypeName(String sludgeTypeName) {
        this.sludgeTypeName = sludgeTypeName;
    }

    public Integer getSludgeType() {
        return sludgeType;
    }

    public void setSludgeType(Integer sludgeType) {
        this.sludgeType = sludgeType;
    }

    public String getDehydrationTypeName() {
        return dehydrationTypeName;
    }

    public void setDehydrationTypeName(String dehydrationTypeName) {
        this.dehydrationTypeName = dehydrationTypeName;
    }

    public Integer getDehydrationType() {
        return dehydrationType;
    }

    public void setDehydrationType(Integer dehydrationType) {
        this.dehydrationType = dehydrationType;
    }

    public Double getDehydrationMud() {
        return dehydrationMud;
    }

    public void setDehydrationMud(Double dehydrationMud) {
        this.dehydrationMud = dehydrationMud;
    }

    public String getDehydrationPreTypeName() {
        return dehydrationPreTypeName;
    }

    public void setDehydrationPreTypeName(String dehydrationPreTypeName) {
        this.dehydrationPreTypeName = dehydrationPreTypeName;
    }

    public Integer getDehydrationPreType() {
        return dehydrationPreType;
    }

    public void setDehydrationPreType(Integer dehydrationPreType) {
        this.dehydrationPreType = dehydrationPreType;
    }

    public Double getPreDehydrationMudWaterRate() {
        return preDehydrationMudWaterRate;
    }

    public void setPreDehydrationMudWaterRate(Double preDehydrationMudWaterRate) {
        this.preDehydrationMudWaterRate = preDehydrationMudWaterRate;
    }

    public String getMudDepthDehydrationTypeName() {
        return mudDepthDehydrationTypeName;
    }

    public void setMudDepthDehydrationTypeName(String mudDepthDehydrationTypeName) {
        this.mudDepthDehydrationTypeName = mudDepthDehydrationTypeName;
    }

    public Integer getMudDepthDehydrationType() {
        return mudDepthDehydrationType;
    }

    public void setMudDepthDehydrationType(Integer mudDepthDehydrationType) {
        this.mudDepthDehydrationType = mudDepthDehydrationType;
    }

    public Double getDepthDehydrationMudWaterRate() {
        return depthDehydrationMudWaterRate;
    }

    public void setDepthDehydrationMudWaterRate(Double depthDehydrationMudWaterRate) {
        this.depthDehydrationMudWaterRate = depthDehydrationMudWaterRate;
    }

    public String getMudTransportTypeName() {
        return mudTransportTypeName;
    }

    public void setMudTransportTypeName(String mudTransportTypeName) {
        this.mudTransportTypeName = mudTransportTypeName;
    }

    public Integer getMudTransportType() {
        return mudTransportType;
    }

    public void setMudTransportType(Integer mudTransportType) {
        this.mudTransportType = mudTransportType;
    }

    public String getMudHandleTypeName() {
        return mudHandleTypeName;
    }

    public void setMudHandleTypeName(String mudHandleTypeName) {
        this.mudHandleTypeName = mudHandleTypeName;
    }

    public Integer getMudHandleType() {
        return mudHandleType;
    }

    public void setMudHandleType(Integer mudHandleType) {
        this.mudHandleType = mudHandleType;
    }

    public String getFactoryMap() {
        return factoryMap;
    }

    public void setFactoryMap(String factoryMap) {
        this.factoryMap = factoryMap == null ? null : factoryMap.trim();
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl == null ? null : centerUrl.trim();
    }

    public Integer getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(Integer issueNo) {
        this.issueNo = issueNo;
    }

    public String getParentFactoryNo() {
        return parentFactoryNo;
    }

    public void setParentFactoryNo(String parentFactoryNo) {
        this.parentFactoryNo = parentFactoryNo;
    }

    public String getOrgGroupNo() {
        return orgGroupNo;
    }

    public void setOrgGroupNo(String orgGroupNo) {
        this.orgGroupNo = orgGroupNo;
    }
}
package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.ExcelColumn;

import java.util.Date;

public class TbFactoryInfoVo {

    private String factoryNo;

    @ExcelColumn(value = "水厂名称", col = 1)
    private String factoryName;

    @ExcelColumn(value = "水厂编号", col = 2)
    private String factoryCode;

    @ExcelColumn(value = "水厂序号",col=3)
    private Integer sortindex;

    //
    private String region;
    @ExcelColumn(value = "业务大区",col = 4)
    private String regionName;

    //分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂  --父id 55
    private Integer level;
    @ExcelColumn(value = "水厂分级",col = 5)
    private String levelName;

    @ExcelColumn(value = "运营厂简称",col = 6)
    private String operateAbbreviation;

    @ExcelColumn(value = "运营公司名称",col = 7)
    private String operateCompanyName;

    //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目  --父id 57
    private Integer projectType;
    @ExcelColumn(value = "项目类别",col = 8)
    private String projectTypeName;

    @ExcelColumn(value = "项目地址",col = 9)
    private String projectAddress;

    @ExcelColumn(value = "纬度",col = 10)
    private Double latitude;

    @ExcelColumn(value = "经度",col = 11)
    private Double longitude;

    //是否集团运营 1运营 是  0：不运营 否 父id 117
    private Integer operateType;
    @ExcelColumn(value = "是否集团运营",col = 12)
    private String operateTypeName;

    @ExcelColumn(value = "规划规模(万m3/d)",col = 13)
    private Double planningScale;

    @ExcelColumn(value = "合同规模(万m3/d)",col = 14)
    private Double contractScale;

    @ExcelColumn(value = "权益比例(%)",col = 15)
    private Double powerRate;

    @ExcelColumn(value = "权益规模(万m3/d)",col = 16)
    private Double powerScale;

    @ExcelColumn(value = "建设规模(万m3/d)",col = 17)
    private Double buileScale;

    @ExcelColumn(value = "运营规模(万m3/d)",col = 18)
    private Double holdScale;

    @ExcelColumn(value = "运营维护管网长度(km)",col = 19)
    private Double holdMaintain;

    @ExcelColumn(value = "服务人口(万)",col = 20)
    private Double servicePopulation;

    @ExcelColumn(value = "服务面积(hm2)",col = 21)
    private Double serviceArea;

    @ExcelColumn(value = "工业废水比例(按可研报告)(%)",col = 22)
    private Double industrialWasteRate;

    @ExcelColumn(value = "核心工艺",col = 23)
    private String coreProcess;


    // 1:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级A 2:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级B 3: 城镇污水处理厂污染物排放标准/GB18918-  2002/二级
    // 4: 污水综合排放标准/GB8978 - 1996/一级 5: 污水综合排放标准/GB8978 - 1996/二级 6: 污水综合排放标准/GB8978 - 1996/三级
    // 7;地表水环境质量标准/GB3838 - 2002/I类 8:地表水环境质量标准/GB3838 - 2002/II类 9: 地表水环境质量标准/GB3838 - 2002/III类 10:地表水环境质量标准/GB3838 - 2002/IV类 11;地表水环境质量标准/GB3838 - 2002/V类
    // 12:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/A标准 13:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/B标准
    // 14:广东省地方标准水污染物排放限值/DB4426 - 2001/一级 15:广东省地方标准水污染物排放限值/DB4426 - 2001/二级
    // 16:四川省岷江、沱江流域水污染物排放标准/DB51/2311-2016 17:化学工业主要水染污物排放标准/DB32/939 - 2006/一级 18:化学工业主要水污染物排放标准/DB32/939 - 2006/二级
    // 19: 河水净化厂水质标准：浊度≤2.0色度≤10 透明度≥15  父id 56
    private String waterQualityNormOut;

    @ExcelColumn(value = "出水水质标准",col = 24)
    private String waterQualityNormOutName;


    @ExcelColumn(value = "合同期限(年)",col = 25)
    private Double contractPeriod;

    @ExcelColumn(value = "保底水量(万m3/d)",col = 26)
    private Double keepWaterVolume;

    @ExcelColumn(value = "合同单价(元/m3)",col = 27)
    private Double contractUnitPrice;

    private Date businessStartTime;

    @ExcelColumn(value = "运营起始时间(yyyyMMdd)",col = 28)
    private String businessStartTimeName;

    private Date projectExitTime;

    @ExcelColumn(value = "项目退出时间(yyyyMMdd)",col = 29)
    private String projectExitTimeName;

    @ExcelColumn(value = "备注",col = 30)
    private String remarks;

    private String filledAccount;

    private Date lastUpdateTime;

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

    private String item;

    private String value;

    private String descripion;

    private Integer issueNo;

    private String parentFactoryNo;

    //总进水COD设计值（mg/L）
    @ExcelColumn(value = "总进水COD设计值（mg/L）",col = 31)
    private Double totalInwaterCod;

    @ExcelColumn(value = "总进水BOD设计器(mg/L)",col=32)
    private Double totalInwaterBod;

    @ExcelColumn(value = "总进水SS设计器(mg/L)",col = 33)
    private Double totalInwaterSs;

    @ExcelColumn(value = "总进水NH3-N设计器(mg/L)",col = 34)
    private Double totalInwaterNh3N;

    @ExcelColumn(value = "总进水TN标准值(mg/L)",col = 35)
    private Double totalInwaterTn;

    @ExcelColumn(value = "总进水TP标准值(mg/L)",col=36)
    private Double totalInwaterTp;

    @ExcelColumn(value = "总进水PH上限值(-)",col=37)
    private Double totalInwaterPhUp;

    @ExcelColumn(value = "总进水PH下限值(-)",col = 38)
    private Double totalInwaterPhDown;

    @ExcelColumn(value = "总进水色度标准值(稀释倍数)",col=39)
    private Integer totalInwaterChroma;

    @ExcelColumn(value = "总出水COD设计器(mg/L)",col = 40)
    private Double totalOutwaterCod;

    @ExcelColumn(value = "总出水BOD设计器(mg/L)",col = 41)
    private Double totalOutwaterBod;

    @ExcelColumn(value = "总出水SS设计器(mg/L)",col=42)
    private Double totalOutwaterSs;

    @ExcelColumn(value = "总出水NH3-N标准值(>=12℃)(mg/L)",col = 43)
    private Double totalOutwaterNh3N1;

    @ExcelColumn(value = "总出水NH3-N标准值(<12℃)(mg/L)",col = 44)
    private Double totalOutwaterNh3N2;

    @ExcelColumn(value = "总出水TN标准值(mg/L)",col = 45)
    private Double totalOutwaterTn;

    @ExcelColumn(value = "总进水TP标准值(mg/L)",col = 46)
    private Double totalOutwaterTp;

    @ExcelColumn(value = "总出水PH上限值(-)",col=47)
    private Double totalOutwaterPhUp;

    @ExcelColumn(value = "总出水PH下限值(-)",col=48)
    private Double totalOutwaterPhDown;

    @ExcelColumn(value = "总出水色度标准值(稀释倍数)",col=49)
    private Integer totalOutwaterChroma;

    @ExcelColumn(value = "总出水粪大肠菌群标准值(个/L)",col=50)
    private Integer totalOutwaterColiform;

    @ExcelColumn(value = "再生水出水浊度标准值(NTU)",col=51)
    private Integer totalOutwaterTurbidity;

    @ExcelColumn(value = "再生水出水溶解性总固体标准值(mg/L)",col = 52)
    private Double totalOutwaterDissolution;

    @ExcelColumn(value = "再生水出水总硬度标准值(mg/L)",col = 53)
    private Double totalOutwaterHardness;

    @ExcelColumn(value = "再生水出水阴离子表面活性剂标准值(mg/L)",col = 54)
    private Double totalOutwaterAnion;
    //计量口径
    @ExcelColumn(value = "类型",col = 55) //todo
    // 1:进水 2:出水 3:其他    -- (父id 65)
    private String measureCaliberTypeName;

    private String measureCaliberType;

    @ExcelColumn(value = "其他说明方式",col = 56)
    private String description;

    //脱水系统设计参数 //todo

    @ExcelColumn(value = "污泥浓缩方式",col = 57)
    private String sludgeTypeName;
    // 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
    private Integer sludgeType;

    @ExcelColumn(value = "污泥脱水方式(含水量约80%)",col=58)
    private String dehydrationTypeName;
    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
    private Integer dehydrationType;

    @ExcelColumn(value = "脱水设计出泥含水率",col = 59)
    private Double dehydrationMud;

    @ExcelColumn(value = "污泥预脱水方式",col = 60)
    private String dehydrationPreTypeName;
    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
    private Integer dehydrationPreType;

    @ExcelColumn(value = "预脱水设计出泥含水率",col = 61)
    private Double preDehydrationMudWaterRate;

    @ExcelColumn(value = "污泥深度脱水方式(含水率约60%)",col =62 )
    private String mudDepthDehydrationTypeName;
    //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
    private Integer mudDepthDehydrationType;

    @ExcelColumn(value = "深度脱水设计出泥含水率",col = 63)
    private Double depthDehydrationMudWaterRate;

    @ExcelColumn(value = "污泥运输方式",col = 64)
    private String mudTransportTypeName;
    // 1: 政府运输 2:自行运输       --父id  99
    private Integer mudTransportType;

    @ExcelColumn(value = "污泥处理方式",col = 65)
    private String mudHandleTypeName;
    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
    private Integer mudHandleType;

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public Integer getSortindex() {
        return sortindex;
    }

    public void setSortindex(Integer sortindex) {
        this.sortindex = sortindex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getOperateAbbreviation() {
        return operateAbbreviation;
    }

    public void setOperateAbbreviation(String operateAbbreviation) {
        this.operateAbbreviation = operateAbbreviation;
    }

    public String getOperateCompanyName() {
        return operateCompanyName;
    }

    public void setOperateCompanyName(String operateCompanyName) {
        this.operateCompanyName = operateCompanyName;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
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

    public String getOperateTypeName() {
        return operateTypeName;
    }

    public void setOperateTypeName(String operateTypeName) {
        this.operateTypeName = operateTypeName;
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

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public String getBusinessStartTimeName() {
        return businessStartTimeName;
    }

    public void setBusinessStartTimeName(String businessStartTimeName) {
        this.businessStartTimeName = businessStartTimeName;
    }

    public Date getProjectExitTime() {
        return projectExitTime;
    }

    public void setProjectExitTime(Date projectExitTime) {
        this.projectExitTime = projectExitTime;
    }

    public String getProjectExitTimeName() {
        return projectExitTimeName;
    }

    public void setProjectExitTimeName(String projectExitTimeName) {
        this.projectExitTimeName = projectExitTimeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    public String getFactoryManager() {
        return factoryManager;
    }

    public void setFactoryManager(String factoryManager) {
        this.factoryManager = factoryManager;
    }

    public String getFactoryTelephone() {
        return factoryTelephone;
    }

    public void setFactoryTelephone(String factoryTelephone) {
        this.factoryTelephone = factoryTelephone;
    }

    public String getFactoryDescribe() {
        return factoryDescribe;
    }

    public void setFactoryDescribe(String factoryDescribe) {
        this.factoryDescribe = factoryDescribe;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getBrowsepath() {
        return browsepath;
    }

    public void setBrowsepath(String browsepath) {
        this.browsepath = browsepath;
    }

    public String getBrowsename() {
        return browsename;
    }

    public void setBrowsename(String browsename) {
        this.browsename = browsename;
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
        this.factorySerialNo = factorySerialNo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
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

    public String getDehydrationTypeName() {
        return dehydrationTypeName;
    }

    public void setDehydrationTypeName(String dehydrationTypeName) {
        this.dehydrationTypeName = dehydrationTypeName;
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

    public String getMudHandleTypeName() {
        return mudHandleTypeName;
    }

    public void setMudHandleTypeName(String mudHandleTypeName) {
        this.mudHandleTypeName = mudHandleTypeName;
    }

    public String getMeasureCaliberType() {
        return measureCaliberType;
    }

    public void setMeasureCaliberType(String measureCaliberType) {
        this.measureCaliberType = measureCaliberType;
    }

    public Integer getSludgeType() {
        return sludgeType;
    }

    public void setSludgeType(Integer sludgeType) {
        this.sludgeType = sludgeType;
    }

    public Integer getDehydrationType() {
        return dehydrationType;
    }

    public void setDehydrationType(Integer dehydrationType) {
        this.dehydrationType = dehydrationType;
    }

    public Integer getDehydrationPreType() {
        return dehydrationPreType;
    }

    public void setDehydrationPreType(Integer dehydrationPreType) {
        this.dehydrationPreType = dehydrationPreType;
    }

    public Integer getMudDepthDehydrationType() {
        return mudDepthDehydrationType;
    }

    public void setMudDepthDehydrationType(Integer mudDepthDehydrationType) {
        this.mudDepthDehydrationType = mudDepthDehydrationType;
    }

    public Integer getMudTransportType() {
        return mudTransportType;
    }

    public void setMudTransportType(Integer mudTransportType) {
        this.mudTransportType = mudTransportType;
    }

    public Integer getMudHandleType() {
        return mudHandleType;
    }

    public void setMudHandleType(Integer mudHandleType) {
        this.mudHandleType = mudHandleType;
    }

    public String getWaterQualityNormOutName() {
        return waterQualityNormOutName;
    }

    public void setWaterQualityNormOutName(String waterQualityNormOutName) {
        this.waterQualityNormOutName = waterQualityNormOutName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
}
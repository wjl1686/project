package com.ejobim.opplat.wjl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.OpplatApplicationTests;
import com.ejobim.opplat.controller.BaseController;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.*;
import com.ejobim.opplat.domain.synBean.*;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.rest.HollySys;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.service.impl.*;
import com.ejobim.opplat.util.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class NewTest  extends OpplatApplicationTests {



    @Autowired
    private TbWorkFlowInfoMapper tbWorkFlowInfoMapper;

    @Autowired
    private TbWorkFlowInfoExtendMapper tbWorkFlowInfoExtendMapper;
    @Autowired
    private BewgServiceImpl bewgService;

    @Autowired
    private TbUserOrgRoleMapper tbUserOrgRoleMapper;

    @Autowired
    HollySys hollySys;
    @Value("${email.excel}")
    private String filePath;

    @Test
    public void testSaveTbWorkFlow(){

      //???????????? 1;?????? 2;?????? 3:??????  3:(??????)  5:????????????

        //?????? factoryNo ?????? 5c662ed96201b70001413521 ?????? 5c6f5f581c5fda0001211081   ?????? 5c7c8157f0313e00010d8727  ????????? 5c748f4f1c5fda00013b904d
        //????????? 5c7dbecb2d9c6b0001b8b949 ???????????? 5c807a2910d1df00013dbaa3 ???????????? 5c86f8a1e082bb000113d9d2 // ???????????????????????????5cb7d2087ec0fa0007383cdc
        //??????
        String orgN0="5d4d3330fc3b7f00062a2308";
         /* bewgService.testTZSQ(orgN0,"155410627896500010","WB_JH_ZD","??????",2,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","WB_JH_SP","??????",2,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","WB_JH_XF_NO_WEI","??????",2,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","WB_JH_XF_WEI","??????",2,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","WB_APP_ZX","??????",2,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410604662000002","COMMITPLAN","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","FACTORYCHECK","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","ZHIXING","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","DX_JH_XF_NO_WEI","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","DX_JH_XF_WEI","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","DX_APP_ZX","??????",3,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410604662000002","FF_JH_ZD","??????",4,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","FF_JH_SP","??????",4,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","FF_JH_XF_NO_WEI","??????",4,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","FF_JH_XF_WEI","??????",4,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","FF_APP_ZX","??????",4,"155641588445900005");
        //??????
       bewgService.testTZSQ(orgN0,"155410627896500010","WX_YC_SB","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","WX_YC_PD_GD","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","WX_YC_PD_JH","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410604662000002","WX_JH_ZD","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","WX_JH_SH","??????",1,"155641588445900005");

        bewgService.testTZSQ(orgN0,"155410627896500010","WX_JH_XF_WEI","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410630797900013","WX_JH_XF_NO_WEI","??????",1,"155641588445900005");
        bewgService.testTZSQ(orgN0,"155410627896500010","WX_APP_ZX","??????",1,"155641588445900005");*/

        //??????
       /* bewgService.testTZSQ(orgN0,"155410624743100007","TZ_SQ","????????????",5,"F1005001000300000000001");
        bewgService.testTZSQ(orgN0,"155410622795000005","TZ_FX","????????????",5,"F1005001000300000000001");
        bewgService.testTZSQ(orgN0,"155410624743100007","TZ_SP","????????????",5,"F1005001000300000000001");
        bewgService.testTZSQ(orgN0,"155410626944500009","TZ_XF","????????????",5,"F1005001000300000000001");
        bewgService.testTZSQ(orgN0,"155410626944500009","TZ_APP_ZX","????????????",5,"F1005001000300000000001");*/
    }

    @Test
    public  void  testOrgInfo() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        QueryConditon queryConditon = new QueryConditon();
        queryConditon.setPageNum(1);
        queryConditon.setPageSize(1000000);
//        bewgService.getOrgInfo(queryConditon);
//        bewgService.getRoleInfo(queryConditon);
        bewgService.getUserInfo(queryConditon);
        Class aa = Class.forName("aa");
        aa.newInstance();
    }
    @Autowired
    private TbSysUseService tbSysUseService;
    @Test
    public void getWxYcSb(){
        ChooseUserConditon conditon = new ChooseUserConditon();
        conditon.setFactoryNo("5c662ed96201b70001413521");
        conditon.setFlowType(1);
        conditon.setStatusCode("WX_YC_SB");
        tbSysUseService.getTbUserList(conditon);

    }
    @Autowired
    TbSysMenuMapper tbSysMenuMapper;
    @Test
    public void getROle(){
        TbUserOrgRoleExample tbUserOrgRoleExample = new TbUserOrgRoleExample();
        TbUserOrgRoleExample.Criteria criteria = tbUserOrgRoleExample.createCriteria();
        criteria.andUserCodeEqualTo("155684805667400020");
        List<TbUserOrgRole> tbUserOrgRoleList = tbUserOrgRoleMapper.selectByExample(tbUserOrgRoleExample);
        List<String> tableNames=tbUserOrgRoleList.stream().map(TbUserOrgRole::getRoleCode).collect(Collectors.toList());
        String role = tableNames.toString().replaceAll(", ", "','").replaceAll("\\[", "('").replaceAll("]", "')");
        System.out.println(tableNames.toString().replaceAll(", ", "','").replaceAll("\\[", "('").replaceAll("]", "')"));
        List<TbSysMenu> tbSysMenus = tbSysMenuMapper.selectMenuListByRoleNo(role);
        System.out.println(tbSysMenus.size());
    }

    @Test
    public void getROle111(){
        ChooseUserConditon conditon  = new ChooseUserConditon();
        conditon.setFactoryNo("5c662ed96201b70001413521");
       // conditon.setFlowType(4);
        conditon.setStatusCode("FF_APP_ZX");
        conditon.setExtendType(20);
        List<TbUser> tbUserList = tbSysUseService.getTbUserList(conditon);
        System.out.println(tbUserList.size());
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getROle1112(){
        BaseController baseController = new BaseController();
        TbUser user = baseController.getUser(null, stringRedisTemplate);
        System.out.println(user.getName() +"=========="+user.getCode());
    }
    @Autowired
    private TbEquipInfoMapper tbEquipInfoMapper;
    @Autowired
    TbSynObjectMapper tbSynObjectMapper;
    //??????????????????
    @Test
    public void testSaveEquipInfo(){
        List<TbSynObject> tbSynObjects = tbSynObjectMapper.getSynObjectInfo();
        System.out.println(tbSynObjects.size());
        List<TbEquipInfo> tbEquipInfos = new ArrayList<>();
        for (TbSynObject tbSynObject : tbSynObjects) {
            TbEquipInfo t = new TbEquipInfo();
            t.setEquipNo(tbSynObject.getUri());
            t.setFactoryNo(tbSynObject.getFactoryNo());
            t.setUpdateTime(new Date());
            t.setEquipType(tbSynObject.getFieldUri());
            t.setEquipName(tbSynObject.getName());
            tbEquipInfos.add(t);
        }
        String factory_no="";
       // tbEquipInfoMapper.delete(factory_no);
       for (TbEquipInfo tbEquipInfo : tbEquipInfos) {
            tbEquipInfoMapper.insertSelective(tbEquipInfo);
        }
    }
    @Test
    public void testRedis(){
        // stringRedisTemplate.opsForValue().set(access_token,json.getJSONObject("obj").toString(),2, TimeUnit.DAYS); //??????TOKEN????????????
        stringRedisTemplate.opsForValue().set("aa","11");

        String info = stringRedisTemplate.opsForValue().get("aa");
        System.out.println(info);

    }
@Autowired
private TbFactoryService tbFactoryService;

    //??????????????????
    @Test
    public   void tets111111(){
//      List<TbRealTimeConfig> tbRealTimeConfigList = tbFactoryService.fineTbRealTimeConfigList("5cef23a75a5d2200077c6bf8");
//        List<String> collect = tbRealTimeConfigList.stream().map(TbRealTimeConfig::getUri).collect(Collectors.toList());
//        String[] strings = new String[collect.size()];
        String[] str = new String[1];


        str[0]="/Hollysys_Bewg_modelNew4/5d81bd3194e57500078c2ac1/OPI/OPI1/IWQ_1/IW_FT";//jin

        bewgService.getDataInfoNew(str);

    }
    //??????????????????
    @Test
    public void getAllFactoryTest(){
        //List<TbFactoryInfo> factoryInfoList =  hollySys.getFactoryList();
        int index = 0;
        //System.out.println(factoryInfoList.size());

       hollySys.getFactoryTree("/Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308","5d4d3330fc3b7f00062a2308",1);
      /* for(TbFactoryInfo factoryInfo:factoryInfoList){
            hollySys.getFactoryTree(factoryInfo.getUri(),factoryInfo.getFactoryNo(),1);

            //?????????,???????????????
                System.out.println(factoryInfo.getUri());
                //hollySys.saveFactoryModelToFile("/Hollysys_Bewg_modelNew2/5cb7d2087ec0fa0007383cdc");
        }*/
    }
    @Autowired
    private FillFieldService fillFieldService;
    @Autowired
    private TbFactoryInfoMapper  tbFactoryInfoMapper;

    @Test
    //??????????????????
    public void addParameterConfig(){
        TbFactoryInfoExample example = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = example.createCriteria();
        List<TbFactoryInfo> tbFactoryInfoList = tbFactoryInfoMapper.selectByExample(example);
//        Map<String, Object> map = ReadExcelUtil.readExcel("D:\\??????\\param.xlsx", ",", -1);
//        List<Map<String,Object>> result = (List<Map<String,Object>> )map.get("result");
//        TbParameterConfig oldParameterConfig = null;
//        for(Map<String,Object> item:result){
//            int oldParameterType = oldParameterConfig==null?-1:oldParameterConfig.getParamType().intValue();
//            Map2ParameterConfig map2ParameterConfig = new Map2ParameterConfig(item,oldParameterType);
//            if(map2ParameterConfig.getParameterConfig().getParamFillType().intValue()==3){
//                TbParameterConfig parameterConfig = map2ParameterConfig.getParameterConfig();
//                parameterConfig.setParamNo(StringTools.getUUID());
//                parameterConfigMapper.insert(parameterConfig);
//            }
//            oldParameterConfig = map2ParameterConfig.getParameterConfig();
////            System.out.println(item);
//        }
        System.out.println(tbFactoryInfoList.size());
       /* for (TbFactoryInfo tbFactoryInfo : tbFactoryInfoList) {
            if(tbFactoryInfo.getFactoryNo().equals("5cb7d2087ec0fa0007383cdc")){
                break;
            }
            System.out.println(tbFactoryInfo.getFactoryName());
            fillFieldService.createFieldFromConfig(tbFactoryInfo.getFactoryNo());
        }*/
        //parameterConfigService.addParameterConfigExtendList("5cb7d2087ec0fa0007383cdc");
        //fillFieldService.createFieldFromConfig("5c748f4f1c5fda00013b904d");
        //parameterConfigService.addParameterConfigExtendList("5c748f4f1c5fda00013b904d");

        TbParameterConfigExtend configExtend = new TbParameterConfigExtend();
        //configExtend.setFactoryNo("5c748f4f1c5fda00013b904d");
        fillFieldService.createFieldFromConfig("5cb7d2087ec0fa0007383cdc");
//        TbParameterConfigExtend configExtend = new TbParameterConfigExtend();
//        configExtend.setFactoryNo("5c748f4f1c5fda00013b904d");
//        List<TbReportDate> list = fillFieldService.getReportDate("2019-04-14","5c748f4f1c5fda00013b904d");
//        fillFieldService.addReportDateList(list);
        //List<TbReportDate> list = fillFieldService.getReportDate("2019-04-14","5c748f4f1c5fda00013b904d");
        //fillFieldService.addReportDateList(list);

    }
    //?????????????????????
    @Autowired
    TbParamMapper tbParamMapper;
    @Test
    public void testSaveTbParam() {
        BewgQueryTreeCondition condition = new BewgQueryTreeCondition();
        //{"forward":"true","depth":10,"relations":["/0/45"],"id":"5c528443147b260001341a70","namespace":"Hollysys_Bewg_modelNew","queryTypeDefinition":"true"}
        condition.setForward("true");
        condition.setDepth("9");
        List<String> real = new ArrayList<>();
        real.add("/0/45");
        condition.setRelations(real);
        condition.setId("5c528443147b260001341a70");//5c51bb665c074c00011b47ee  2  5c528443147b260001341a70   1
        condition.setNamespace("Hollysys_Bewg_modelNew");
        condition.setQueryTypeDefinition("true");
        JSONObject jsonObject = bewgService.queryTreeNode(condition);


        List<TbParam> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("result").getJSONObject(0).getJSONArray("children");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            TbParam tbParam = JSON2Bean.getObjectfromJson(2,jsonObject1,null);
            if(jsonObject1.get("children")!=null){
                checkJSON(jsonObject1,"???",list,tbParam.getUri());
            }
            list.add(tbParam);
        }

        for(TbParam tbParam :list){
            System.out.println(tbParam.toString());
            tbParamMapper.insert(tbParam);
        }
    }

    private void checkJSON(JSONObject jsonObject,String level,List<TbParam> list,String parentUri){
        JSONArray jsonArray = jsonObject.getJSONArray("children");
        for (int j = 0; j < jsonArray.size(); j++) {
            JSONObject child = jsonArray.getJSONObject(j);
            TbParam tbParam = JSON2Bean.getObjectfromJson(2,child,parentUri);
            list.add(tbParam);
            if(child.containsKey("children")&&child.get("children")!=null){
                checkJSON(child,"???" + level,list,tbParam.getUri());
            }
        }
    }
    //??????????????????
    @Test
    public void testgetTbEquipMangerUserList() {
        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
        condition.setFactoryUri("/Hollysys_Bewg_modelNew/5c662ed96201b70001413521");
        tbSysUseService.getTbEquipMangerUserListByFactoryUri(condition);
    }
    //????????????
    @Test
    public void testgetTbBanUserList() {
        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
        condition.setType(0);
        //condition.setFactoryUri("/Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308");
        //???????????? /Hollysys_Bewg_modelNew/5c662ed96201b70001413521 //????????? /Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308
        condition.setFactoryUri("/Hollysys_Bewg_modelNew/5c662ed96201b70001413521");
    }
    //????????????
  
    @Test
    public void testBatchEquipList() {
        List<TbEquipInfo> list = new ArrayList<>();
        TbEquipInfo tbEquipInfo1 =new TbEquipInfo();
        tbEquipInfo1.setEquipNo(StringTools.getUUID());
        tbEquipInfo1.setFactoryNo("2222");
        tbEquipInfo1.setEquipName("2222");
        TbEquipInfo tbEquipInfo2 =new TbEquipInfo();
        tbEquipInfo2.setEquipNo(StringTools.getUUID());
        tbEquipInfo2.setFactoryNo("2222");
        tbEquipInfo2.setEquipName("2222");
        list.add(tbEquipInfo1);
        list.add(tbEquipInfo2);
        tbEquipInfoMapper.insertEquipBatchlist(list);
    }

    //??????????????????
    @Autowired
    WorkFlowServiceImpl workFlowServiceImpl;

    @Test
    public void testWorkFlowCopy() {
       /* TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
        condition.setType(0);
        //condition.setFactoryUri("/Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308");
        //???????????? /Hollysys_Bewg_modelNew/5c662ed96201b70001413521 //????????? /Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308
        condition.setFactoryUri("/Hollysys_Bewg_modelNew/5c662ed96201b70001413521");

        tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);*/

    }
    @Autowired
    private TbUserMapper tbUserMapper;
    
    @Autowired
    private TbWorkTaskInfoMapper tbTaskInfoMapper;
    @Test
    public void testGetToken() {
       // bewgService.getToken();

     /*   TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
       // [{"role":"155410627896500010","org":"156877508045800026"}]
        condition.setOrgCode("156877508045800026");
        condition.setRoleCode("155410627896500010");
        List<TbUser> tbEquipMangerUserListByFactoryUri = tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);
        System.out.println(tbEquipMangerUserListByFactoryUri.size());*/

       /* TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
        condition.setFactoryUri("/Hollysys_Bewg_modelNew4/5d81bd3194e57500078c2ac1");
        condition.setType(0);
        List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
        System.out.println(JSON.toJSONString(tbUserList));*/
        TaskInfoCondition condition = new TaskInfoCondition();
        condition.setDutyUser("P000770");
        condition.setFactoryNo("5d81bd3194e57500078c2ac1");
        List<TaskVo> taskVoList = tbTaskInfoMapper.selectTbWorkTaskInfoByJsonNew(condition);
        System.out.println(taskVoList.size());

        TbWorkTaskInfoCondition conditionQ = new TbWorkTaskInfoCondition();
        conditionQ.setFactoryUri("/Hollysys_Bewg_modelNew4/5d81bd3194e57500078c2ac1");
        //    private Integer type; 0:?????? 1:???????????? 2,???????????? 3 ???????????? SCYXJL ???????????? SCSBJL
        conditionQ.setType(3);
        List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(conditionQ);
        System.out.println(tbUserList.size());
    }
    @Autowired
    private TbDraftDataMapper draftDataMapper;

    @Autowired
    private ReportService reportService;
        @Test
        public void getReprtDare(){
        //?????????
        String sunDay = DateUtils.formateDate(DateUtils.getNextDate(new Date(), -1));
        //?????????
        String monDay = DateUtils.formateDate(DateUtils.getNextDate(new Date(),-7));
         /*   List<TbFactoryInfo> factories = this.factoryService.getTbFactoryInfoList(new TbFactoryInfo());
            for(TbFactoryInfo factory : factories) {
                this.reportService.selectReportDayWeekDate(factory.getFactoryNo());
            }*/
        List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
        if(tbDraftData!=null&& tbDraftData.size()>0){
            System.out.println(JSON.toJSON(tbDraftData));
            try {
                OutputStream out = new FileOutputStream("D:\\????????????201911.xlsx");
                List<List<String>> yunxingData = new ArrayList<List<String>>();
                List<List<String>> shebeiData = new ArrayList<List<String>>();
                List<List<String>> huayanData = new ArrayList<List<String>>();
                for (TbDraftData tbDraftDatum : tbDraftData) {
                    //???????????? 1:????????????2:????????????:3:????????????;4:????????????',
                    if(tbDraftDatum.getDraftType()==1){
                        List rowData = new ArrayList();
                        rowData.add(DateUtils.formateDateFull(tbDraftDatum.getDraftTime()));
                        rowData.add(tbDraftDatum.getDraftName());
                        rowData.add(tbDraftDatum.getDraftValue()+"");
                        rowData.add(tbDraftDatum.getDraftUnit());
                        yunxingData.add(rowData);
                    }else if(tbDraftDatum.getDraftType()==2) {
                        List rowData = new ArrayList();
                        rowData.add(DateUtils.formateDateFull(tbDraftDatum.getDraftTime()));
                        rowData.add(tbDraftDatum.getDraftName());
                        rowData.add(tbDraftDatum.getDraftValue()+"");
                        rowData.add(tbDraftDatum.getDraftUnit());
                        shebeiData.add(rowData);
                    }else if(tbDraftDatum.getDraftType()==3) {
                        List rowData = new ArrayList();
                        rowData.add(DateUtils.formateDateFull(tbDraftDatum.getDraftTime()));
                        rowData.add(tbDraftDatum.getDraftName());
                        rowData.add(tbDraftDatum.getDraftValue()+"");
                        rowData.add(tbDraftDatum.getDraftUnit());
                        huayanData.add(rowData);
                    }
                }
                String[] headers = { "??????", "?????????","????????????","????????????" };
                ExcelHighUtils eeu = new ExcelHighUtils();
                XSSFWorkbook workbook = new XSSFWorkbook();
                System.out.println("yunxingData="+JSON.toJSON(yunxingData)+","+"shebeiData="+JSON.toJSONString(shebeiData)+","+"huayanData="+JSON.toJSONString(huayanData));
                eeu.exportXSSFExcel(workbook, 0, "????????????????????????", headers, yunxingData, out);
                eeu.exportXSSFExcel(workbook, 1, "????????????????????????", headers, shebeiData, out);
                eeu.exportXSSFExcel(workbook, 2, "????????????????????????", headers, huayanData, out);
                //????????????????????????????????????????????????????????????????????????
                workbook.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
           // Map<String, Object> draftDataList = reportService.getDraftDataList("5d81bd3194e57500078c2ac1", DateUtils.parseDate("2019-11-15"), DateUtils.parseDate("2019-11-19"));
            //System.out.println(JSON.toJSON(draftDataList));
        }


    @Test
    public void dynaCol() {
        try {
            List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();

            ExcelExportEntity deliColGroup = new ExcelExportEntity("??????????????????", "order");
            List<ExcelExportEntity> deliColList = new ArrayList<ExcelExportEntity>();
            deliColList.add(new ExcelExportEntity("????????????", "taskName"));
            deliColList.add(new ExcelExportEntity("????????????", "adjustType"));
            deliColList.add(new ExcelExportEntity("????????????", "adjustTime"));
            deliColList.add(new ExcelExportEntity("??????????????????", "startTime"));
            deliColGroup.setList(deliColList);
            colList.add(deliColGroup);
            ExcelExportEntity jdColGroup = new ExcelExportEntity("??????", "check");
            List<ExcelExportEntity> jdColList = new ArrayList<ExcelExportEntity>();
            jdColList.add(new ExcelExportEntity("????????????", "zhixing"));
            jdColList.add(new ExcelExportEntity("????????????", "shenpi"));
            jdColList.add(new ExcelExportEntity("??????", "note"));
            jdColGroup.setList(jdColList);
            colList.add(jdColGroup);
            ExcelExportEntity jdColGroupXf = new ExcelExportEntity("??????", "xiafa");
            List<ExcelExportEntity> jdColListXf = new ArrayList<ExcelExportEntity>();
            jdColListXf.add(new ExcelExportEntity("????????????", "zhixing"));
            jdColListXf.add(new ExcelExportEntity("?????????", "zhixingUser"));
            jdColListXf.add(new ExcelExportEntity("?????????", "xiezhuUser"));
            jdColGroupXf.setList(jdColListXf);
            colList.add(jdColGroupXf);
            ExcelExportEntity jdColGroupFk = new ExcelExportEntity("??????", "fankui");
            List<ExcelExportEntity> jdColListFk = new ArrayList<ExcelExportEntity>();
            jdColListFk.add(new ExcelExportEntity("????????????", "zhixing"));
            jdColListFk.add(new ExcelExportEntity("????????????", "zhixingContent"));
            jdColListFk.add(new ExcelExportEntity("??????", "note"));
            jdColGroupFk.setList(jdColListFk);
            colList.add(jdColGroupFk);
            //ExcelExportEntity deliColGroup = new ExcelExportEntity("??????", "deli");
         /*   List<ExcelExportEntity> deliColList = new ArrayList<ExcelExportEntity>();
            deliColList.add(new ExcelExportEntity("?????????", "orgPrice"));
            deliColList.add(new ExcelExportEntity("?????????", "salePrice"));*/
           // deliColGroup.setList(deliColList);


          /*  ExcelExportEntity jdColGroup = new ExcelExportEntity("??????", "jd");
            List<ExcelExportEntity> jdColList = new ArrayList<ExcelExportEntity>();
            jdColList.add(new ExcelExportEntity("?????????", "orgPrice"));
            jdColList.add(new ExcelExportEntity("?????????", "salePrice"));
            jdColGroup.setList(jdColList);
            colList.add(jdColGroup);*/
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < 10; i++) {
                Map<String, Object> valMap = new HashMap<String, Object>();
           /*     valMap.put("title", "??????." + i);
                valMap.put("supplier", "?????????." + i);*/

                List<Map<String, Object>> deliDetailList = new ArrayList<Map<String, Object>>();
                for (int j = 0; j < 3; j++) {
                    Map<String, Object> deliValMap = new HashMap<String, Object>();
                    deliValMap.put("taskName", "??????.?????????." + j);
                    deliValMap.put("adjustType", "??????.?????????." + j);
                    deliValMap.put("adjustTime", "??????.?????????." + j);
                    deliValMap.put("startTime", "??????.?????????." + j);
                    deliDetailList.add(deliValMap);
                }
                valMap.put("order", deliDetailList);

                List<Map<String, Object>> jdDetailList = new ArrayList<Map<String, Object>>();
                for (int j = 0; j < 2; j++) {
                    Map<String, Object> jdValMap = new HashMap<String, Object>();
                    jdValMap.put("zhixing", "??????.?????????." + j);
                    jdValMap.put("shenpi", "??????.?????????." + j);
                    jdValMap.put("note", "??????.?????????." + j);
                    jdDetailList.add(jdValMap);
                }
                valMap.put("check", jdDetailList);

                list.add(valMap);
            }


            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("????????????", "??????????????????"), colList,
                    list);
            FileOutputStream fos = new FileOutputStream("D:/??????????????????.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //?????????
    public void testBaseWrite() throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("sheet");
        HSSFSheet sheet2 = hssfWorkbook.createSheet("sheet2");
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //??????????????????????????????????????????;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //??????????????????????????????????????????;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //???????????????
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //????????????
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //?????????
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//?????????

        Row titleRow = sheet.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);
        Row titleRow2 = sheet.createRow(1);
         Map<String, Object> draftDataList = reportService.getDraftDataList("5d81bd3194e57500078c2ac1", DateUtils.parseDate("2019-11-15"), DateUtils.parseDate("2019-11-19"));
        System.out.println(JSON.toJSON(draftDataList));
        System.out.println(JSON.toJSONString(draftDataList.get("hyMap")));

        Map hyMap = (Map) draftDataList.get("hyMap");
        List<Map<String, Object>> data = (List<Map<String, Object>>) hyMap.get("data");
        List<Map<String, Object>> title = (List<Map<String, Object>>)hyMap.get("title");
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
//        titleRow.createCell(0).setCellValue("??????");
        Cell cell = titleRow.createCell(0);

        cell.setCellValue("??????");
        cell.setCellStyle(style);
        Map map =new HashMap(16);
        sheet.setColumnWidth(0, 100 * 60);

       for (int j = 0; j < title.size(); j++) {
            map.put(j + 1,title.get(j).get("dataField").toString());
           Cell cellName = titleRow.createCell(j + 1);
           cellName.setCellStyle(style);
           cellName.setCellValue(title.get(j).get("draftName").toString());
           Cell cellUnit = titleRow2.createCell(j + 1);
           cellUnit.setCellStyle(style);
           cellUnit.setCellValue(title.get(j).get("dataUnit").toString());
            //titleRow2.createCell(j ).setCellValue(title.get(j).get("dataUnit").toString());
           sheet.setColumnWidth(j + 1,  100 * 60);
        }

        for (int j = 0; j < data.size(); j++) {
            Row tempRow = sheet.createRow(j + 2);
            Cell cellDate = tempRow.createCell(0);
            cellDate.setCellStyle(style);
            cellDate.setCellValue(data.get(j).get("date").toString());
            List<Map<String, Object>> tempArray = (List<Map<String, Object>>)data.get(j).get("data");
            for (int k = 0; k < map.keySet().size(); k++) {
                String tempKey = map.get(k + 1).toString();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).get("dataField").toString().equals(tempKey)) {
                        if (tempArray.get(i).get("value") != null) {
                            tempRow.createCell(k + 1).setCellValue(tempArray.get(i).get("value").toString());
                        } else {
                            tempRow.createCell(k + 1).setCellValue("");
                        }
                        continue;
                    }
                }
            }
            //titleRow2.createCell(j ).setCellValue(tbDraftData.get(j ).getDraftUnit());
        }
        File file = new File("D:\\test11111.xls");
        hssfWorkbook.write(new FileOutputStream(file));
    }

    @Test
    //?????????
    public void testXFSSBaseWrite() throws IOException {
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = hssfWorkbook.createSheet("sheet");
        XSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //??????????????????????????????????????????;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //??????????????????????????????????????????;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //???????????????
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //????????????
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //?????????
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//?????????

        Row titleRow = sheet.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);
        Row titleRow2 = sheet.createRow(1);
        Map<String, Object> draftDataList = reportService.getDraftDataList("5d81bd3194e57500078c2ac1", DateUtils.parseDate("2019-11-15"), DateUtils.parseDate("2019-11-19"));
        System.out.println(JSON.toJSON(draftDataList));
        System.out.println(JSON.toJSONString(draftDataList.get("hyMap")));

        Map hyMap = (Map) draftDataList.get("hyMap");
        List<Map<String, Object>> data = (List<Map<String, Object>>) hyMap.get("data");
        List<Map<String, Object>> title = (List<Map<String, Object>>)hyMap.get("title");
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
//        titleRow.createCell(0).setCellValue("??????");
        Cell cell = titleRow.createCell(0);

        cell.setCellValue("??????");
        cell.setCellStyle(style);
        Map map =new HashMap(16);
        sheet.setColumnWidth(0, 100 * 60);

        for (int j = 0; j < title.size(); j++) {
            map.put(j + 1,title.get(j).get("dataField").toString());
            Cell cellName = titleRow.createCell(j + 1);
            cellName.setCellStyle(style);
            cellName.setCellValue(title.get(j).get("draftName").toString());
            Cell cellUnit = titleRow2.createCell(j + 1);
            cellUnit.setCellStyle(style);
            cellUnit.setCellValue(title.get(j).get("dataUnit").toString());
            //titleRow2.createCell(j ).setCellValue(title.get(j).get("dataUnit").toString());
            sheet.setColumnWidth(j + 1,  100 * 60);
        }

        for (int j = 0; j < data.size(); j++) {
            Row tempRow = sheet.createRow(j + 2);
            Cell cellDate = tempRow.createCell(0);
            cellDate.setCellStyle(style);
            cellDate.setCellValue(data.get(j).get("date").toString());
            List<Map<String, Object>> tempArray = (List<Map<String, Object>>)data.get(j).get("data");
            for (int k = 0; k < map.keySet().size(); k++) {
                String tempKey = map.get(k + 1).toString();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).get("dataField").toString().equals(tempKey)) {
                        if (tempArray.get(i).get("value") != null) {
                            tempRow.createCell(k + 1).setCellValue(tempArray.get(i).get("value").toString());
                        } else {
                            tempRow.createCell(k + 1).setCellValue("");
                        }
                        continue;
                    }
                }
            }
            //titleRow2.createCell(j ).setCellValue(tbDraftData.get(j ).getDraftUnit());
        }
        File file = new File("D:\\????????????121212.xlsx");
        hssfWorkbook.write(new FileOutputStream(file));
    }
    @Autowired
    private ReportServiceImpl reportServiceImpl;
    @Test
    //???????????????????????????????????????
    public void testsheeet()  {
        int flag =0;
        Map<String, Object> draftDataList = reportService.getDraftDataList("5d81bd3194e57500078c2ac1", DateUtils.parseDate("2019-11-01"), DateUtils.parseDate("2019-11-19"));
        System.out.println(JSON.toJSON(draftDataList));
         if(draftDataList!=null && draftDataList.size()>0){
             String fileName = DateUtils.formateDate("yyyyMMddHHmmss") + ".xlsx";
            flag=1;
            XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
            Map yunXingMap = (Map) draftDataList.get("yunXingMap");
            if(yunXingMap!=null && yunXingMap.size()>0){
                try {
                    reportServiceImpl.createSheet(hssfWorkbook,"????????????????????????",yunXingMap,fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Map sheBeiMap = (Map) draftDataList.get("sheBeiMap");
            if(sheBeiMap!=null && sheBeiMap.size()>0){
                try {
                    reportServiceImpl.createSheet(hssfWorkbook,"????????????????????????",sheBeiMap,fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Map hyMap = (Map) draftDataList.get("hyMap");
            if(hyMap!=null && hyMap.size()>0){

                try {
                    reportServiceImpl.createSheet(hssfWorkbook,"????????????????????????",hyMap,fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
          if(flag==1){
                String receive = "729857382@qq.com";
                String subject = "????????????";
                String msg = "????????????";
                String filePaths = filePath+"????????????.xlsx";
                String filename = "????????????.xlsx";
                try {
                    SendMailAcceUtils.sendMail(receive, subject, msg, filePaths,filename);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Autowired
    private  TbRoutingTaskMapper routingTaskMapper;

    @Autowired
    RoutingServiceImpl routingService;
    @Test
    public void testTask(){
        Map map = new HashMap(16);
        String currentMonday = DateUtils.getMonWeekDate();
        String previousSunday = DateUtils.getSunDayOfWeek();
        map.put("factoryNo","5d81bd3194e57500078c2ac1");
        map.put("modelNo","11");
        List<String> dayList = DateUtils.getDayOfWeekWithinDateInterval(DateUtils.formateDate("2019-12-06"), DateUtils.formateDate("2019-12-22"), 1);
        if (!DateUtils.getMonWeekDate().equals(DateUtils.formateDate("2019-12-06"))) {
            dayList.add(0, DateUtils.getMonWeekDate());
        }
        map.put("dayList",dayList);
        map.put("currentMonday",currentMonday);
      /*  map.put("previousSunday",previousSunday);
        TbRoutingTask tbRoutingTask =routingTaskMapper.selectRoutingCheckTaskList(map);
        System.out.println(JSON.toJSON(tbRoutingTask));*/
        List<TbRoutingTask> tbRoutingTasks = routingService.checkRoutingTask(map);
    }
    @Autowired
    SchedulingService schedulingService;
    @Test
    public void deleteTbScheduling(){
        String ss ="05185c115cc24deba5c4278d70f4ef9f,0b703e8256054f6795411d674fc57059";
        schedulingService.deleteTbScheduling(ss);
    }
    @Autowired
    private HomeService homeService;
    @Test
    public void getTbDraftDataList(){
        TbDraftData tbDraftData= new TbDraftData();
        tbDraftData.setFactoryNo("5d81bd3194e57500078c2ac1");
        tbDraftData.setDraftName("??????");
        tbDraftData.setStartTime("2019-11-15");
        tbDraftData.setEndTime("2019-12-06");
        List<TbDraftData> tbDraftDataList = homeService.getTbDraftDataList(tbDraftData);
        System.out.println(JSON.toJSON(tbDraftDataList));
    }

    @Autowired
    SchedulingServiceImpl schedulingServiceImpl;
    @Test
    public void getRule(){
        TbSchedulingRule tbSchedulingRule = new TbSchedulingRule();
        tbSchedulingRule.setGroupType(1);
        tbSchedulingRule.setRuleType(1);
        tbSchedulingRule.setFactoryNo("5d81bd3194e57500078c2ac1");
        JSONObject jsonObject =new JSONObject();

        JSONArray jsonArrayThree= new JSONArray();
        JSONObject jsonObjectThree =new JSONObject();
        jsonObjectThree.put("groupNo","810c1d62800a4da7b47b58c3f355e288");
        jsonObjectThree.put("time","58e38f2d2ee8448c85f4d0efc38938ab");
        JSONObject jsonObjectThree2 =new JSONObject();
        jsonObjectThree2.put("groupNo","eae7c3bf883d4531b0c4b64c83c46776");
        jsonObjectThree2.put("time","");
        JSONObject jsonObjectThree3 =new JSONObject();
        jsonObjectThree3.put("groupNo","5e36e81cd2484136b8bdac8ac5ed08f6");
        jsonObjectThree3.put("time","698712223a2a47aca4cf97c9e6eae356");
        jsonArrayThree.add(jsonObjectThree);
        jsonArrayThree.add(jsonObjectThree2);
        jsonArrayThree.add(jsonObjectThree3);
        jsonObject.put("one",jsonArrayThree);
        System.out.println(jsonObject.toJSONString());
        tbSchedulingRule.setExtendInfo(jsonObject.toJSONString());
        System.out.println(JSON.toJSON(tbSchedulingRule));
  /*      String allJson = "{\n" +
                "\t\"groupType\": 1,\n" +
                "\t\"ruleType\": 1,\n" +
                "\t\"factoryNo\": \"5d81bd3194e57500078c2ac1\",\n" +
                "\t\"extendInfo\": {\n" +
                "\t\t\"one\": [{\n" +
                "\t\t\t\"time\": \"58e38f2d2ee8448c85f4d0efc38938ab\",\n" +
                "\t\t\t\"groupNo\": \"810c1d62800a4da7b47b58c3f355e288\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"time\": \"\",\n" +
                "\t\t\t\"groupNo\": \"eae7c3bf883d4531b0c4b64c83c46776\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"time\": \"698712223a2a47aca4cf97c9e6eae356\",\n" +
                "\t\t\t\"groupNo\": \"5e36e81cd2484136b8bdac8ac5ed08f6\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
        TbSchedulingRule object = JSONObject.parseObject(allJson, TbSchedulingRule.class);
        System.out.println(object.getExtendInfo());*/
       // schedulingServiceImpl.setTbSchedulingRule(tbSchedulingRule);
    }

    @Test
    public void getRuleList(){
        TbSchedulingRule tbSchedulingRule = new TbSchedulingRule();
        tbSchedulingRule.setFactoryNo("5d81bd3194e57500078c2ac1");
        tbSchedulingRule.setGroupType(1);
        tbSchedulingRule.setRuleType(1);
        List<TbSchedulingRule> tbSchedulingRuleList = schedulingService.getTbSchedulingRuleList(tbSchedulingRule);
        System.out.println(JSON.toJSON(tbSchedulingRuleList));
    }

    //0c56f55fe5a74f85a8c9cdd8a72b0065
    //????????????????????????????????????????????????
    @Autowired
    private FaultService faultService;
    @Test
    public void getOrderDetail() throws Exception {
        String taskNo="c91ee78432b3440bad95a6fdb040d45c";
        Map tbWorkTaskDetail = faultService.getTbWorkTaskDetail(taskNo);
        System.out.println(JSON.toJSON(tbWorkTaskDetail));
    }

    @Autowired
    private TbFactoryServiceImpl tbFactoryServiceImpl;

    //???????????????????????????????????????
    @Test
    public void setFactortInfo() throws Exception {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey("5c662ed96201b70001413521");
        String aa="5c662ed96201b70001413521";
        JSONObject jsonObject = tbFactoryServiceImpl.setFactoryInfo(aa);
        System.out.println(JSON.toJSON(jsonObject));
    }
    //?????????????????????????????????
    @Test
    public void setShuiZhiInfo() throws Exception {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey("5c662ed96201b70001413521");
        String aa="5c662ed96201b70001413521";
        JSONObject jsonObject = tbFactoryServiceImpl.setShuiZhi(aa);
        System.out.println(JSON.toJSON(jsonObject));
    }
    //?????????????????????????????????
    @Test
    public void setTuoshuiInfo() throws Exception {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey("5c662ed96201b70001413521");
        String aa="5c662ed96201b70001413521";
        JSONObject jsonObject = tbFactoryServiceImpl.setTuoshui(aa);
        System.out.println(JSON.toJSON(jsonObject));
    }
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IApiSyncService apiSyncService;

    /**
     * ????????????????????????
     * wjl
     */
    @Test
    public void getNewData() throws Exception {
       /* String url = "http://171.84.0.58:8888/report/getReportModelExtendDetailDate?factoryNo=5c662ed96201b70001413521&staticDate=2019-10-19";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);*/
        //Map body = forEntity.getBody();
        //List<Map> list = (List<Map>) body.get("list");
        Date data=DateUtils.parseDate("2019-12-16");
        String factoryNo="559f4420698b4d9187b3a18c589002e4";
        List<Map<String,String>> list =   reportService.getReportModelExtendDetailDate(DateUtils.parseDate("2019-12-16"),factoryNo);
        //String factoryNo="5d4d3330fc3b7f00062a2308";
     /*   List<Map<String,String>> list =new ArrayList<>();
        Map map =new HashMap(16);
        map.put("code","InletWater");
        map.put("value",111);
        list.add(map);
        System.out.println(list);*/
        JSONObject result = new JSONObject();
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        tbFactoryInfo.setFactoryNo(factoryNo);
        List<TbFactoryInfo> factoryList = tbFactoryService.getTbFactoryInfoList(tbFactoryInfo);
        for (TbFactoryInfo factoryInfoEntity : factoryList) {
            //String factoryNo = factoryInfoEntity.getFactoryNo();
            String factoryCode = "PS5001" + "tb";
            System.out.println("--------------------------??????Code???" + factoryCode);
            //Date current = new Date();
            //Date current = SFORMAT.parse("2019-05-04");
            //List<String> weekDayList = DateUtils.getWeekDayList(current);
            List<String> weekDayList = new ArrayList<>();
            weekDayList.add("2019-12-22");

            //8??????????????????????????????
            WeeklyClslEntity weeklyClsl = new WeeklyClslEntity();
            weeklyClsl.setUSERID(factoryCode);
            // 9???????????????????????????
            WeeklyScdlEntity weeklyScdl = new WeeklyScdlEntity();
            weeklyScdl.setUSERID(factoryCode);
            //11???????????????????????????
            WeeklySzzbEntity weeklySzzb = new WeeklySzzbEntity();
            weeklySzzb.setUSERID(factoryCode);
            // 12???????????????60%??????
            WeeklyWn60Entity weeklyWn60 = new WeeklyWn60Entity();
            weeklyWn60.setUSERID(factoryCode);
            // 13???????????????80%??????
            WeeklyWn80Entity weeklyWn80 = new WeeklyWn80Entity();
            weeklyWn80.setUSERID(factoryCode);
            for (int i = 0; i < weekDayList.size(); i++) {
                String key = weekDayList.get(i);
                if (list != null && list.size() > 0) {
                    weeklyClsl = setValue(weeklyClsl, key, list);
                    weeklyScdl = setValue(weeklyScdl, key, list);
                    weeklySzzb = setValue(weeklySzzb, key, list);
                    weeklyWn60 = setValue(weeklyWn60, key, list);
                    weeklyWn80 = setValue(weeklyWn80, key, list);
                }
            }
            boolean updateFlag = false;

            result = apiSyncService.setWeeklyClsl(weeklyClsl,data);
            System.out.println("8?????????????????????????????????" + result.toString());

            result = apiSyncService.setWeeklyScdl(weeklyScdl,data);
            System.out.println("9??????????????????????????????" + result.toString());

            result = apiSyncService.setWeeklySzzb(weeklySzzb,data);
            System.out.println("11??????????????????????????????" + result.toString());

            result = apiSyncService.setWeeklyWn60(weeklyWn60,data);
            System.out.println("12???????????????60%?????????" + result.toString());

            result = apiSyncService.setWeeklyWn80(weeklyWn80,data);
            System.out.println("13???????????????80%?????????" + result.toString());
        }
    }

    /**
     * ???????????????
     * wjl
     */
    public <T> T setValue(T entity, String key, List<Map<String,String>> list) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            String modelType = "";
            if (DateUtils.getDateOfWeek(key) == 1) {
                modelType = "Mon";
                if (field.getName().contains("MonDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("MonWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 2) {
                modelType = "Tues";
                if (field.getName().contains("TuesDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("TuesWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 3) {
                modelType = "Wed";
                if (field.getName().contains("WedDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("WedWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }

            } else if (DateUtils.getDateOfWeek(key) == 4) {
                if (field.getName().contains("ThurDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("ThurWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
                modelType = "Thur";
            } else if (DateUtils.getDateOfWeek(key) == 5) {
                modelType = "Fri";
                if (field.getName().contains("FriDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("FriWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 6) {
                modelType = "Sat";
                if (field.getName().contains("SatDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("SatWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 0) {
                modelType = "Sun";
                if (field.getName().contains("SunDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("SunWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("?????????"));
                }
            }
            if (field.getName().startsWith(modelType)) {
                String keyName = field.getName().substring(modelType.length());
                for (int index = 0; index < list.size(); index++) {
                    if (list.get(index).get("code").equals(keyName)) {
                        field.setAccessible(true);
                        field.set(entity, String.valueOf((list.get(index).get("value"))));
                    }
                }
            }
            if (field.getName().contains("BusinessDate")) {
                field.setAccessible(true);
                field.set(entity, String.valueOf(DateUtils.formateDatePartNo(new Date())));
            }
        }
        return entity;
    }

}

package com.ejobim.opplat.wjl;

import com.ejobim.opplat.OpplatApplicationTests;
import com.ejobim.opplat.controller.SchedulingController;
import com.ejobim.opplat.domain.TbGroupInfo;
import com.ejobim.opplat.domain.TbSchedulingChange;
import com.ejobim.opplat.domain.TbSchedulingPlan;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.mapper.TbGroupDetailMapper;
import com.ejobim.opplat.mapper.TbSchedulingPlanDeatailMapper;
import com.ejobim.opplat.mapper.TbSchedulingPlanMapper;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.SchedulingService;
import com.ejobim.opplat.service.TbSysUseService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestGroup extends OpplatApplicationTests {

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private SchedulingController schedulingController;
    
    @Autowired
    TbSysUseService tbSysUseService;
    
    @Autowired
    private TbGroupDetailMapper tbGroupDetailMapper;
    
    @Autowired
    private TbSchedulingPlanMapper tbSchedulingPlanMapper;

    @Autowired
    private TbSchedulingPlanDeatailMapper tbSchedulingPlanDeatailMapper;
    
    @Autowired
    private EquipService equipService;

    @Test
    public void testGetUserList(){
        TbGroupInfo tbGroupInfo = new TbGroupInfo();
        tbGroupInfo.setUri("/Hollysys_Bewg_modelNew/5c662ed96201b70001413521");
        tbGroupInfo.setGroupType(1);
        tbSysUseService.getTbUserListByFactoryNo(tbGroupInfo);
    }

    //单个测试添加
    @Test
    public void testSaveTbSchedulingPlan(){
        String groupNo="4254a444d9774a69ba810647327a2690"; //c4fb182fd42a42d6b4b5840376365f47 运行班
        String factoryNo="5c662ed96201b70001413521";
        Integer groupType =2;
        TbSchedulingPlan tbSchedulingPlan = new TbSchedulingPlan();
        tbSchedulingPlan.setSchedulingNo(StringTools.getUUID());
        
        tbSchedulingPlan.setFactoryNo(factoryNo);
        tbSchedulingPlan.setGroupNo(groupNo);
        tbSchedulingPlan.setGroupType(groupType);//运行班
        //Date date =new Date();
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.DATE,5);
        Date date = cd.getTime();
        Date day = new Date();
        tbSchedulingPlan.setCreateTime(day);
        tbSchedulingPlan.setSchedulingTime("2019-07-18");
        tbSchedulingPlan.setDayType(0);//'日期类型 0:本日 1次日',
        tbSchedulingPlan.setStartTimePoint(DateUtils.parseDateFullPartMinute("2019-07-18 9:00"));
        tbSchedulingPlan.setEndTimePoint(DateUtils.parseDateFullPartMinute("2019-07-18 18:00"));
        tbSchedulingPlan.setCreateUserCode("155661630951900014");
        tbSchedulingPlan.setCreateUserName("赵戈");
        tbSchedulingPlanMapper.insertSelective(tbSchedulingPlan);

        /*TbGroupDetailExample example = new TbGroupDetailExample();
        TbGroupDetailExample.Criteria criteria = example.createCriteria();
        criteria.andGroupNoEqualTo(groupNo);
        List<TbGroupDetail> tbGroupDetails = tbGroupDetailMapper.selectByExample(example);
        for (TbGroupDetail tbGroupDetail : tbGroupDetails) {
            TbSchedulingPlanDeatail deatail = new TbSchedulingPlanDeatail();
            deatail.setUserCode(tbGroupDetail.getUserCode());
            deatail.setUserName(tbGroupDetail.getUserName());
            deatail.setSchedulingNoDetail(StringTools.getUUID());
            deatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
            deatail.setGroupNo(groupNo);
            deatail.setGroupType(groupType);
            deatail.setGroupName("测试设备班组01");
            deatail.setFactoryNo(factoryNo);
            deatail.setCreateTime(day);
            deatail.setCreateUserCode("155661630951900014");
            deatail.setCreateUserName("赵戈");
            tbSchedulingPlanDeatailMapper.insertSelective(deatail);

        }*/
    }
    
    @Test
    public void testGetTbSchedulingHomeInfo(){
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setFactoryNo("5c662ed96201b70001413521");
        //condition.setType(0);
        condition.setYear(2019);
        condition.setMouth(7);
        condition.setSource(2);
        condition.setUserCode(" 155590456092000014");
        schedulingService.getTbSchedulingHomeInfo(condition);
    }
    @Test
    public void testGetTbSchedulingSetInfo(){
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setFactoryNo("5c662ed96201b70001413521");
        condition.setType(1);
        condition.setYear(2019);
        condition.setMouth(7);
        schedulingService.getTbSchedulingSetInfo(condition);
    }
    //测试添加排班
    @Test
    public void testSaveTbSchedulingPlanAgain(){
        String groupNo01="835aa64e5481468ca340973f521c01a3"; //c4fb182fd42a42d6b4b5840376365f47  运行班01  5a6f3b3b67414649acf2ca6c22a86dcf 运行班02
        String groupName01="测试运行班组0724"; // 闫含 海波 左鹏
       
        String groupNo02="7789cec634834cc1b87dd6480091b738";
        String groupName02="测试运行班组0725"; //  席汴 me 赵戈
        String factoryNo="5c662ed96201b70001413521";
        Integer groupType =1;
        TbSchedulingPlan tbSchedulingPlanDb = new TbSchedulingPlan();

        List<TbSchedulingPlan> tbSchedulingPlanList = new ArrayList<>();
        TbSchedulingPlan tbSchedulingPlan1 = new TbSchedulingPlan();
        tbSchedulingPlan1.setFactoryNo(factoryNo);
        tbSchedulingPlan1.setGroupNo(groupNo01);
        tbSchedulingPlan1.setGroupName(groupName01);
        tbSchedulingPlan1.setGroupType(groupType);//运行班
        //Date date =new Date();
       /* Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.DATE,5);
        Date date = cd.getTime();
        Date day = new Date();*/
        tbSchedulingPlan1.setCreateTime(new Date());
        tbSchedulingPlan1.setSchedulingTime("2019-07-28");
        tbSchedulingPlan1.setDayType(0);//'日期类型 0:本日 1次日',
        tbSchedulingPlan1.setStartTimePointName("2019-07-28 09:00");
        tbSchedulingPlan1.setEndTimePointName("2019-07-28 18:00");
        tbSchedulingPlan1.setCreateUserCode("155661630951900014");
        tbSchedulingPlan1.setCreateUserName("赵戈");
        tbSchedulingPlanList.add(tbSchedulingPlan1);
        //"++++++++++++++++++++++++++"
      /*  TbSchedulingPlan tbSchedulingPlan2 = new TbSchedulingPlan();
        tbSchedulingPlan2.setFactoryNo(factoryNo);
        tbSchedulingPlan2.setGroupNo(groupNo02);
        tbSchedulingPlan2.setGroupName(groupName02);
        tbSchedulingPlan2.setGroupType(groupType);//运行班
        //Date date =new Date();
       *//* Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.DATE,5);
        Date date = cd.getTime();
        Date day = new Date();*//*
        tbSchedulingPlan2.setCreateTime(new Date());
        tbSchedulingPlan2.setSchedulingTime("2019-07-22");
        tbSchedulingPlan2.setDayType(0);//'日期类型 0:本日 1次日',
        tbSchedulingPlan2.setStartTimePointName("2019-07-22 9:00");
        tbSchedulingPlan2.setEndTimePointName("2019-07-22 18:00");
        tbSchedulingPlan2.setCreateUserCode("155661630951900014");
        tbSchedulingPlan2.setCreateUserName("赵戈");
        tbSchedulingPlanList.add(tbSchedulingPlan2);*/
        tbSchedulingPlanDb.setSchedulingPlanList(tbSchedulingPlanList);
   
        System.out.println(tbSchedulingPlanDb);
        //schedulingService.saveTbSchedulingPlan(tbSchedulingPlanDb)  ;
    }
    //c4fb182fd42a42d6b4b5840376365f47

    @Test
    public void testGetgetGroupCalendarData(){
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setFactoryNo("5c662ed96201b70001413521");
        condition.setGroupNo("c4fb182fd42a42d6b4b5840376365f47");
        condition.setYear(2019);
        condition.setMouth(7);
        schedulingService.getGroupCalendarData(condition);
    }

    @Test
    public void testgetTbSchedulingPlan(){
        TbSchedulingPlan condition = new TbSchedulingPlan();
        condition.setFactoryNo("5c662ed96201b70001413521");
        condition.setSchedulingTime("2019-07-20");
        condition.setGroupType(1);
        schedulingService.getTbSchedulingPlan(condition);
    }

    @Test
    public void testapplyTbSchedulingChange(){ //c4fb182fd42a42d6b4b5840376365f47 鲍晓旭 155684844187300023
        //c4fb182fd42a42d6b4b5840376365f47  测试运行班组01 2019-07-18 09:00:00 2018-07-18 09:00:00  3943bc643af04020a399e3ea1b06c88b 
        TbSchedulingChange  tbSchedulingChange = new TbSchedulingChange();
        tbSchedulingChange.setFactoryNo("5c662ed96201b70001413521");
        tbSchedulingChange.setApplyUserName("鲍晓旭");
        tbSchedulingChange.setGroupType(1);
        tbSchedulingChange.setApplyUserCode("155684844187300023");
        tbSchedulingChange.setCreateUserCode("鲍晓旭");
        tbSchedulingChange.setCreateUserName("155684844187300023");
        tbSchedulingChange.setCreateTime(new Date());
        tbSchedulingChange.setApplyGroupTimeName("2019-07-18");
        tbSchedulingChange.setApplyGroupTimePoint("09:00-18:00");
        tbSchedulingChange.setApplyGroupName("测试运行班组01");
        tbSchedulingChange.setApplyGroupNo("c4fb182fd42a42d6b4b5840376365f47");
        tbSchedulingChange.setApplySchedulingNoDetail("3943bc643af04020a399e3ea1b06c88b");
        tbSchedulingChange.setApplyDayType(1);
        //===========
        tbSchedulingChange.setTargetGroupTimeName("2019-07-21");
        tbSchedulingChange.setTargetGroupTimePoint("09:00-18:00");
        tbSchedulingChange.setTargetGroupName("测试运行班组02");
        tbSchedulingChange.setTargetGroupNo("5a6f3b3b67414649acf2ca6c22a86dcf");
        tbSchedulingChange.setTargetSchedulingNoDetail("497b0fd0239c4fb593e68f46b52fa529");
        tbSchedulingChange.setTargetUserCode("155684851576300024");
        tbSchedulingChange.setTargetUserName("李海波");
        //5a6f3b3b67414649acf2ca6c22a86dcf 5a6f3b3b67414649acf2ca6c22a86dcf  测试运行班组02  497b0fd0239c4fb593e68f46b52fa529  李海波   155684851576300024
        schedulingService.applyTbSchedulingChange(tbSchedulingChange);
    }

    @Test
    public void testgetbSchedulingPlanInfoByUserCode(){
        
       // schedulingService.getbSchedulingPlanInfoByUserCode("155590456092000014");
    }
    
    //getTbSchedulingPlanByApplyUser

    @Test
    public void testgetTbSchedulingPlanByApplyUser(){
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setFactoryNo("5c662ed96201b70001413521");
        condition.setUserCode("155590456092000014");
        condition.setCurrentTime(DateUtils.formateDate(new Date()));
        schedulingService.getTbSchedulingPlanByApplyUser(condition);
    }
    //测试获取二维码接口
    //checkTbSchedulingTransferUser
    @Test
    public void testcheckTbSchedulingTransferUser(){
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setFactoryNo("5c662ed96201b70001413521");
        condition.setUserCode("155590456092000014");
        condition.setCurrentTime(DateUtils.formateDate(new Date()));
        //schedulingService.checkTbSchedulingTransferUser(condition);
    }

    @Test
    public void testEquipTree(){

        //equipService.getTbEquipTreeByfactoryNo("5c662ed96201b70001413521");
    }
}

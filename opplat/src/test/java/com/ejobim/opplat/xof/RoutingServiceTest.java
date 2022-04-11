package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.RoutingLocationVo;
import com.ejobim.opplat.mapper.TbEquipInfoMapper;
import com.ejobim.opplat.mapper.TbRoutingLocatioinEquipMapper;
import com.ejobim.opplat.mapper.TbRoutingModelExtendMapper;
import com.ejobim.opplat.mapper.TbRoutingTaskDetailMapper;
import com.ejobim.opplat.mapper.TbRoutingTaskMapper;
import com.ejobim.opplat.service.EquipOrderService;
import com.ejobim.opplat.service.RoutingService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.FileUtils;
import com.ejobim.opplat.util.StringTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.Dict.ROUTING_TASK_STATUS_COMMIT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutingServiceTest {

    @Autowired
    private TbRoutingTaskDetailMapper routingTaskDetailMapper;
    @Autowired
    private TbRoutingTaskMapper routingTaskMapper;
    @Autowired
    private TbRoutingLocatioinEquipMapper routingLocatioinEquipMapper;

    @Autowired
    private RoutingService routingService;
    
    @Autowired
    private TbEquipInfoMapper tbEquipInfoMapper;

    @Autowired
    private EquipOrderService equipOrderService;

    @Autowired
    private TbRoutingModelExtendMapper routingModelExtendMapper;


    @Test
    public void getTaskDetail(){
        routingTaskDetailMapper.getRoutingTaskDetailList("4ad2b55148a6456aaf259697520f6730","842e0a6454f34d199c2ead6568bafde9");
    }

    @Test
    public void locationEquioTest(){
        routingLocatioinEquipMapper.selectByPrimaryKey("1393f0c0deb043528ab5706890e1fd52");
    }

    /**
     * 测试新增巡检轨迹
     */
    @Test
    public void addRoutingTrajectory(){
        TbRoutingTaskDetail routingTaskDetail = new TbRoutingTaskDetail();
        routingTaskDetail.setTaskDetailNo("3cfefa15184a48e2ae0713aafb264758");
        routingTaskDetail.setTaskNo("966fec70b0e644e7a56f43ae892f0891");
        routingService.updateLocationTrajectory(routingTaskDetail);
    }

    @Test
    public void startRoutingTask(){
        TbRoutingTask routingTaskSearch = new TbRoutingTask();
        routingTaskSearch.setFactoryNo("5c662ed96201b70001413521");
        routingTaskSearch.setBeginTime(DateUtils.parseDate("2019-10-12"));
        routingTaskSearch.setEndTime(DateUtils.parseDate("2019-10-20"));
        List<TbRoutingTask> routingTaskList  = routingService.getRoutingTaskList(routingTaskSearch);
        for(TbRoutingTask routingTask:routingTaskList){
            routingTask.setCommitUser("席忭");
            routingService.startRoutingTask(routingTask);
        }
        System.out.println(routingTaskList.size() + "");
    }

    @Test
    public void fillRoutingTask(){
        TbRoutingTask routingTaskSearch = new TbRoutingTask();
        routingTaskSearch.setFactoryNo("5c662ed96201b70001413521");
        routingTaskSearch.setBeginTime(DateUtils.parseDate("2019-10-12"));
        routingTaskSearch.setEndTime(DateUtils.parseDate("2019-10-20"));
        List<TbRoutingTask> routingTaskList  = routingService.getRoutingTaskList(routingTaskSearch);
        for(TbRoutingTask routingTask:routingTaskList){
            List<TbRoutingTaskDetail> getRoutingDetailList = routingService.getRoutingDetailList(routingTask.getTaskNo());
            for(TbRoutingTaskDetail routingTaskDetail:getRoutingDetailList){
                routingTaskDetail.setFillValue(StringTools.formatDouble(10*Math.random(),2));
                routingTaskDetail.setCommitTime(new Date());
                routingTaskDetailMapper.updateByPrimaryKeySelective(routingTaskDetail);
            }
            routingTask.setFinishCount(routingTask.getNeedCount());
            routingTask.setFinishTime(new Date());
            routingTask.setTaskStatus(ROUTING_TASK_STATUS_COMMIT);
            routingTaskMapper.updateByPrimaryKeySelective(routingTask);
        }
        System.out.println(routingTaskList.size() + "");
    }

    @Test
    public void getTree(){
        String factoryNo = "5d81bd3194e57500078c2ac1";
        TbRoutingLocation routingLocation = new TbRoutingLocation();
        routingLocation.setFactoryNo(factoryNo);
        List<TbRoutingLocation> list = routingService.getRoutingLocationList(routingLocation);
        List<String> locationNoList =  list.stream().map(obj -> obj.getLocationNo()).collect(Collectors.toList());
        List<TbRoutingLocatioinEquip> equipList = routingService.getRoutingEquipListByIds(locationNoList);
        TbRoutingLocationElement routingLocationElement = new TbRoutingLocationElement();
        routingLocationElement.setFactoryNo(factoryNo);
        List<TbRoutingLocationElement> elementList = routingService.getRoutingElementList(routingLocationElement,null);
        for(TbRoutingLocation tbRoutingLocation:list){
            for(TbRoutingLocatioinEquip equip:equipList){
                if(tbRoutingLocation.getLocationNo().equals(equip.getRoutingNo())){
                    if(tbRoutingLocation.getEquipList()==null){
                        tbRoutingLocation.setEquipList(new ArrayList<>());
                    }
                    tbRoutingLocation.getEquipList().add(equip);
                }
            }
            for(TbRoutingLocationElement element:elementList){
                if(element.getParentNo()!=null){
                    if(element.getParentNo().equals(tbRoutingLocation.getLocationNo())){
                        tbRoutingLocation.getElementList().add(element);
                    }
                }
            }
        }
        for(TbRoutingLocatioinEquip equip:equipList){
            for(TbRoutingLocationElement element:elementList) {
                if (element.getParentNo().equals(equip.getEquipNo())) {
                    if (equip.getElementList() == null) {
                        equip.setElementList(new ArrayList<>());
                    }
                    equip.getElementList().add(element);
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("巡检点,");
        stringBuffer.append("设备,");
        stringBuffer.append("巡检要素,");
        stringBuffer.append("巡检方法");
        stringBuffer.append("\t\n");
        for(TbRoutingLocation tbRoutingLocation:list){
            stringBuffer.append(tbRoutingLocation.getLocationName());
            stringBuffer.append(",");
            stringBuffer.append(",");
            stringBuffer.append(",");
            stringBuffer.append("");
            stringBuffer.append("\t\n");
            List<TbRoutingLocationElement> elements = tbRoutingLocation.getElementList();
            for(TbRoutingLocationElement element:elements){
                stringBuffer.append(",");
                stringBuffer.append(",");
                stringBuffer.append(element.getElementName() + ",");
                stringBuffer.append(element.getElementMethod());
                stringBuffer.append("\t\n");
            }
            for(TbRoutingLocatioinEquip routingLocatioinEquip:tbRoutingLocation.getEquipList()){
                stringBuffer.append(",");
                String equipNo = routingLocatioinEquip.getEquipNo();
                TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(equipNo);
                if(tbEquipInfo!=null){
                    stringBuffer.append(tbEquipInfo.getEquipName()+",");
                }
                stringBuffer.append(",");
                stringBuffer.append("");
                stringBuffer.append("\t\n");
                if(routingLocatioinEquip.getElementList()!=null){
                    for(TbRoutingLocationElement element:routingLocatioinEquip.getElementList()){
                        stringBuffer.append(",");
                        stringBuffer.append(",");
                        stringBuffer.append(element.getElementName() + ",");
                        stringBuffer.append(element.getElementMethod());
                        stringBuffer.append("\t\n");
                    }
                }


            }
        }
        FileUtils.fileLinesWrite("D:\\tt.csv",stringBuffer.toString(),true);
        System.out.println(JSONObject.toJSONString(list));
    }


    @Test
    public void getEquipFaultDetail(){
        TbEquipFaultInfo equipFaultInfo = equipOrderService.getEquipFaultDetail("1991cb06e55d4051b479476992fef324");
        System.out.println(JSONObject.toJSONString(equipFaultInfo));
    }

    @Test
    public void getRoutingTaskDetailByLocation(){
        routingService.getRoutingTaskDetailByLocation("e7f94ac70b68419fb88214a3a5d8e673","3db2f1df77424419b85c34d376a65889");
    }

    @Test
    public void getTaskRoutingLocationList(){
        TbRoutingTask routingTask = new TbRoutingTask();
        routingTask.setTaskNo("fa0586974d284604845a6102c112bb68");
        List<RoutingLocationVo> list = routingService.getTaskRoutingLocationList(routingTask);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getRotuingLocationDetailInfo(){
        TbUser tbUser = new TbUser();
        tbUser.setCode("P000755");
        Map<String,Object> list  =  routingService.getRoutingLocationDetailInfo(tbUser,"ffc51fd8d81642fcb61681c21971eacc");
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void addRoutingTaskList(){
        Date beginDate  = DateUtils.parseDate("2019-12-11");
        Date endDate  = DateUtils.parseDate("2019-12-12");
        String modelNo = "936d295bb5b14df19fbe801c490de18e";
        TbUser tbUser = new TbUser();
        tbUser.setCode("155590456092000014");
        tbUser.setName("席忭");
        int resultCode = routingService.addRoutingTaskList(beginDate,endDate,modelNo,tbUser);
    }
}

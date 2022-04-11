package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.condition.QueryConditon;
import com.ejobim.opplat.service.BewgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BewgTest {

    @Autowired
    BewgService bewgService;
    @Test
    public void getCurrentInspcetTaskList(){
        String accessToken  = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2RlIjoiODUyOWRiZDc3ZGU2NDU4MzIzYmNhNzk4NzU5N2MyZGVmOWVhMTgxMzYzYjk4MTE4YThhMGU5OTdlNWZlZjI1ZiIsInppZCI6InVhYSIsInRlbmFudE5hbWUiOiJiZXdnIiwidXNlcl9uYW1lIjoieGliaWFuIiwibmlja05hbWUiOiLluK3lv60iLCJpc3MiOiJodHRwOi8vMTkyLjE2OC42Ni4xNTg6MTgwODAvdWFhL29hdXRoL3Rva2VuIiwidGVuYW50SWQiOiJmNmFkMzY4YjRlZTUwYzA4NTM2ZmEzNjJlZjhjZDM2N2JmNTMzYzM0OWRkOGNjOTg5YzE5MmM5NTM4MGZkYzdkOGQ4NWQ0ODE1MzU1NWU0OTRiNzljZmEwZDlhZTNjZjEiLCJleHAiOjE1NjQwODgzNzksImlhdCI6MCwianRpIjoiN2VkZjY0MDMtZTZmYS00ODRlLWFlMDItZTA5NDdhZWZjNjcwIiwiY2xpZW50X2lkIjoiYmV3Zy1wcm8ifQ.gn9kkoN7zN8JfmO-VapTmWDjH_BwXcKKcjlGuzRovDtitQ4ZHO-uvxaSDVoHi9zYymJEPZEBD5T-YVfcvfP6ZSNTWiA9dBfKJpFNfDxgSkseWFSP4J-5ovypiuVybQTLZ5KmH63h_zdIR4SovecIbzlVy7-mVmbRzx3TYGKT1427QWUoDfkypUSKAgB7X1yJw7kBpVgfTJlu6UOZOI_vh40psO-hm5D5-TImo1wPiMjiN36ZIHOXr5jjLqLPIJvrTw9LBHwKFSL6cckMmymmCf4-tlM1izdP7pi_gjQobGijj-awNiqd__vC0j2BqLBUDB015QB2XyiDQ0oNygFkhQ";
        JSONObject jsonObject =  bewgService.getUserInfoByToken(accessToken);
        System.out.println(jsonObject);
    }

    @Test
    public void getOrgInfoTest(){
        QueryConditon queryConditon = new QueryConditon();
        queryConditon.setPageNum(1);
        queryConditon.setPageSize(1000000);
        JSONObject jsonObject = bewgService.getOrgInfo(queryConditon);
        System.out.println(jsonObject);

    }

    @Test
    public void getAlarmTest(){
         bewgService.queryHistoryAlarm("/Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308");
    }

    @Test
    public void getAllAlarmByNodeUri(){
        //限值
        //JSONObject object = bewgService.getAllAlarmByNodeUri("/Hollysys_Bewg_modelNew/5c6e180ffd23240001d72113");
        //离散
        //JSONObject object = bewgService.getAllAlarmByNodeUri("/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c53");
        //变化率
//        JSONObject object = bewgService.getAllAlarmByNodeUri("/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c50");
        //偏差告警
        JSONObject object = bewgService.getAllAlarmByNodeUri("/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c36");
        System.out.println(object.toJSONString());
    }


    @Test
    public void addOrUpdateDeviationAlarms(){
        JSONObject postJson = new JSONObject();
        JSONObject alarmObject = new JSONObject();

        postJson.put("DeviationAlarm",alarmObject);
        alarmObject.put("pointUri","/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c36");

        alarmObject.put("PrimaryDiffZone",5);
        alarmObject.put("HighSeverity",1);
        alarmObject.put("HighMessage","主偏差告警1");

        alarmObject.put("SecondaryDiffZone",3);
        alarmObject.put("LowSeverity",1);
        alarmObject.put("LowMessage","次偏差告警1");

        alarmObject.put("Target",4);
        alarmObject.put("RestoreZone",0);
        alarmObject.put("TimeZone",1000);

        alarmObject.put("Exclusive",false);
        alarmObject.put("EnableState",false);
        System.out.println(postJson.toString());
        JSONObject object = bewgService.addOrUpdateAlarms(postJson,"Hollysys_Bewg_modelNew2");
        System.out.println(object.toJSONString());
    }

    @Test
    public void addOrUpdateRateOfChangeAlarms(){
        JSONObject postJson = new JSONObject();
        JSONObject alarmObject = new JSONObject();

        postJson.put("RateOfChangeAlarm",alarmObject);
        alarmObject.put("pointUri","/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c50");
        JSONArray limitValues = new JSONArray();
        limitValues.add(2.0);
        limitValues.add(1.0);
        alarmObject.put("LimitValues",limitValues);
        JSONArray severities = new JSONArray();
        severities.add(1);
        severities.add(2);
        alarmObject.put("Severities",severities);
        JSONArray messages = new JSONArray();
        messages.add("a");
        messages.add("b");
        alarmObject.put("Messages",messages);
        alarmObject.put("Exclusive",false);
        alarmObject.put("EnableState",false);
        alarmObject.put("ChangeInterval",100);
        alarmObject.put("CaculateInterval",0);
        System.out.println(postJson.toString());
        JSONObject object = bewgService.addOrUpdateAlarms(postJson,"Hollysys_Bewg_modelNew2");
        System.out.println(object.toJSONString());
    }


    @Test
    public void addOrUpdateDiscreteAlarms(){
        JSONObject postJson = new JSONObject();
        JSONObject alarmObject = new JSONObject();

        postJson.put("DiscreteAlarm",alarmObject);
        alarmObject.put("pointUri","/Hollysys_Bewg_modelNew2/5cf2904d5a5d220007874c38");
        JSONArray ActiveType = new JSONArray();
        ActiveType.add(3);
        ActiveType.add(4);
        alarmObject.put("ActiveType",ActiveType);
        JSONArray AlmLevel = new JSONArray();
        AlmLevel.add(2);
        AlmLevel.add(3);
        alarmObject.put("AlmLevel",AlmLevel);
        JSONArray AlmMessage = new JSONArray();
        AlmMessage.add("a");
        AlmMessage.add("b");
        alarmObject.put("AlmMessage",AlmMessage);
        JSONArray DelayTime = new JSONArray();
        DelayTime.add(100);
        DelayTime.add(100);
        alarmObject.put("DelayTime",DelayTime);
        JSONArray AlmType = new JSONArray();
        AlmType.add(0);
        alarmObject.put("AlmType",AlmType);
        alarmObject.put("RestoreZone",0.0);
        alarmObject.put("TimeZone",0);
        alarmObject.put("Exclusive",false);
        alarmObject.put("EnableState",true);
        System.out.println(postJson.toString());
        JSONObject object = bewgService.addOrUpdateAlarms(postJson,"Hollysys_Bewg_modelNew2");
        System.out.println(object.toJSONString());
    }

    @Test
    public void addOrUpdateAlarms(){
        JSONObject postJson = new JSONObject();
        JSONObject alarmObject = new JSONObject();

        postJson.put("LevelAlarm",alarmObject);
        alarmObject.put("pointUri","/Hollysys_Bewg_modelNew/5c6e180ffd23240001d72113");
        JSONArray limitValues = new JSONArray();
        limitValues.add(10.0);
        limitValues.add(9.0);
        limitValues.add(9.0);
        limitValues.add(6.3);
        limitValues.add(6.0);
        limitValues.add(6.0);
        alarmObject.put("LimitValues",limitValues);
        JSONArray severities = new JSONArray();
        severities.add(0);
        severities.add(0);
        severities.add(1);
        severities.add(2);
        severities.add(0);
        severities.add(0);
        alarmObject.put("Severities",severities);
        JSONArray messages = new JSONArray();
        messages.add("a");
        messages.add("b");
        messages.add("c");
        messages.add("d");
        messages.add("e");
        messages.add("f");
        alarmObject.put("Messages",messages);
        alarmObject.put("RestoreZone",0.0);
        alarmObject.put("TimeZone",0);
        alarmObject.put("Exclusive",false);
        alarmObject.put("EnableState",false);
        System.out.println(postJson.toString());
        JSONObject object = bewgService.addOrUpdateAlarms(postJson,"Hollysys_Bewg_modelNew");
        System.out.println(object.toJSONString());
    }
}

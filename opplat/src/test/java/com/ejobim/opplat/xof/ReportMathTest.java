package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbDraftData;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.ReportMath;

import java.util.*;

public class ReportMathTest {

    public static  Map<String, List<TbDraftData>> getDemoValueList(){
        Map<String, List<TbDraftData>> dataMap = new HashMap<>();
        List<TbDraftData> list1 = new ArrayList<>();
        String today = "2019-12-15";
        for(int i=1;i<11;i++){
            TbDraftData tbDraftData1 = new TbDraftData();
            tbDraftData1.setFillNo("fill" + i);
            Date timePoint1 = DateUtils.parseDateFullPartMinute(today + " 09:00" );
            tbDraftData1.setDraftTime(timePoint1);
            tbDraftData1.setDraftValue(i*2.0);
            list1.add(tbDraftData1);
            TbDraftData tbDraftData2= new TbDraftData();
            tbDraftData2.setFillNo("fill" + i);
            Date timePoint2 = DateUtils.parseDateFullPartMinute(today + " 15:00" );
            tbDraftData2.setDraftTime(timePoint2);
            tbDraftData2.setDraftValue(i*2.1);
            list1.add(tbDraftData2);
        }
        dataMap.put(today,list1);

        List<TbDraftData> list2 = new ArrayList<>();
        String yesterday = "2019-12-14";
        for(int i=1;i<11;i++){
            TbDraftData tbDraftData1 = new TbDraftData();
            tbDraftData1.setFillNo("fill" + i);
            Date timePoint1 = DateUtils.parseDateFullPartMinute(yesterday + " 09:00" );
            tbDraftData1.setDraftTime(timePoint1);
            tbDraftData1.setDraftValue(i*1.0);
            list2.add(tbDraftData1);
            TbDraftData tbDraftData2= new TbDraftData();
            tbDraftData2.setFillNo("fill" + i);
            Date timePoint2 = DateUtils.parseDateFullPartMinute(yesterday + " 15:00" );
            tbDraftData2.setDraftTime(timePoint2);
            tbDraftData2.setDraftValue(i*1.1);
            list2.add(tbDraftData2);
        }
        dataMap.put(yesterday,list2);
        return  dataMap;
    }

    public static JSONObject createMathJson(String cmd){
        JSONObject fieldObject = new JSONObject();
        fieldObject.put("type","1");
        fieldObject.put("name",cmd);
        return  fieldObject;
    }

    public static void main(String[] args){
//        Map<String, List<TbDraftData>> valueMap = getDemoValueList();
//        System.out.println(JSONObject.toJSONString(valueMap));
//        JSONArray array = new JSONArray();
//
//        JSONObject aloneObject = new JSONObject();
//        aloneObject.put("type",11);
//        JSONArray detailArray = new JSONArray();
//        JSONObject fieldObject = new JSONObject();
//        fieldObject.put("timePoint","09:00");
//        fieldObject.put("fillNo","fill1");
//        detailArray.add(fieldObject);
//        aloneObject.put("mathDetail",detailArray);
//        array.add(aloneObject);
//
//        array.add(createMathJson("+"));
//
//        JSONObject subObject = new JSONObject();
//        subObject.put("type",12);
//        detailArray = new JSONArray();
//         fieldObject = new JSONObject();
//        fieldObject.put("timePoint","09:00");
//        fieldObject.put("fillNo","fill1");
//        detailArray.add(fieldObject);
//        subObject.put("mathDetail",detailArray);
//        array.add(subObject);
//
//        array.add(createMathJson("+"));
//
//        JSONObject avgObject = new JSONObject();
//        avgObject.put("type",15);
//         detailArray = new JSONArray();
//         fieldObject = new JSONObject();
//        fieldObject.put("timePoint","09:00");
//        fieldObject.put("fillNo","fill1");
//        detailArray.add(fieldObject);
//
//
//
//        fieldObject = new JSONObject();
//        fieldObject.put("timePoint","15:00");
//        fieldObject.put("fillNo","fill1");
//        detailArray.add(fieldObject);
//
//        avgObject.put("mathDetail",detailArray);
//        array.add(avgObject);
//        System.out.println(array);
//
//        ReportMath reportMath = new ReportMath(array,valueMap,"2019-12-15");
//        double calcResult = reportMath.doMath();
//        System.out.println(calcResult);
    }
}

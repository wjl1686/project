package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.synBean.*;
import com.ejobim.opplat.service.IApiSyncService;
import com.ejobim.opplat.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@Service
public class ApiSyncServiceImpl implements IApiSyncService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.sync.url}")
    private String path;

    /**
     * 设置工厂基础信息
     * @param factoryInfo
     * @return
     */
    @Override
    public JSONObject setFactoryInfo(FactoryInfoEntity factoryInfo) {
        String url = path+"/api/SyncDataOracle/SetFactoryInfo";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(factoryInfo).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 进出水水质标准
     * @param shuizhi
     * @return
     */
    @Override
    public JSONObject setShuiZhi(ShuiZhiEntity shuizhi) {
        String url = path+"/api/SyncDataOracle/SetShuiZhi";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(shuizhi).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 脱水系统设计参数
     * @param tuoshui
     * @return
     */
    @Override
    public JSONObject setTuoshui(TuoShuiEntity tuoshui) {
        String url = path+"/api/SyncDataOracle/SetTuoShui";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(tuoshui).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 药剂勾选
     * @param yaoJiGouXuan
     * @return
     */
    @Override
    public JSONObject setYaoJiGouXuan(YaoJiGouXuanNewEntity yaoJiGouXuan) {
        String url = path+"/api/SyncDataOracle/SetYaoJiGouXuan";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(yaoJiGouXuan).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 月报成本填报
     * @param monthlyCb
     * @return
     */
    @Override
    public JSONObject setMonthlyCb (MonthlyCbEntity monthlyCb) {
        String url = path+"/api/SyncDataOracle/SetMonthlyCb";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(monthlyCb).toString());
        System.out.println("月报成本填报Json:" + JSONObject.parseObject(JSONObject.toJSON(monthlyCb).toString()));
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 月报药剂财务
     * @param monthlyYjcw
     * @return
     */
    @Override
    public JSONObject setMonthlyYjcw(MonthlyYjcwNewEntity monthlyYjcw) {
        String url = path+"/api/SyncDataOracle/SetMonthlyYjcw";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(monthlyYjcw).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 月报设备完好率
     * @param monthlySbwh
     * @return
     */
    @Override
    public JSONObject setMonthlySbwh(MonthlySbwhEntity monthlySbwh) {
        String url = path+"/api/SyncDataOracle/SetMonthlySbwh";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(monthlySbwh).toString());
        System.out.println("月报设备完好率Json:" + json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报处理水量填报表
     * @param weeklyClsl
     * @return
     */
    @Override
    public JSONObject setWeeklyClsl(WeeklyClslEntity weeklyClsl, Date date){
        // 设置当前周数标识
        weeklyClsl.setBatchId(DateUtils.getNowWeekMouthNumbers(date));
        String url = path+"/api/SyncDataOracle/SetWeeklyClsl";
        //System.out.println("周报处理水量填报表"+JSON.toJSONString(weeklyClsl));
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklyClsl).toString());
        System.out.println("周报处理水量填报表参数json="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报生产电量填报
     * @param weeklyScdl
     * @return
     */
    @Override
    public JSONObject setWeeklyScdl(WeeklyScdlEntity weeklyScdl, Date date) {
        weeklyScdl.setBatchId(DateUtils.getNowWeekMouthNumbers(date));
        String url = path+"/api/SyncDataOracle/SetWeeklyScdl";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklyScdl).toString());
        System.out.println("周报生产电量填报json参数="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报生产药剂填报
     * @param weeklyScyj
     * @return
     */
    @Override
    public JSONObject setWeeklyScyj(WeeklyScyjEntity weeklyScyj) {
        weeklyScyj.setWeekNumber(DateUtils.getNowWeekMouthNumbers());
        String url = path+"/api/SyncDataOracle/SetWeeklyScyj";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklyScyj).toString());
        System.out.println("周报生产药剂填报json参数="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报水质指标填报
     * @param weeklySzzb
     * @return
     */
    @Override
    public JSONObject setWeeklySzzb(WeeklySzzbEntity weeklySzzb, Date date) {
        weeklySzzb.setBatchId(DateUtils.getNowWeekMouthNumbers(date));
        String url = path+"/api/SyncDataOracle/SetWeeklySzzb";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklySzzb).toString());
        System.out.println("周报水质指标填报json参数="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报污泥60%填报
     * @param weeklyWn60
     * @return
     */
    @Override
    public JSONObject setWeeklyWn60(WeeklyWn60Entity weeklyWn60, Date date) {
        weeklyWn60.setBatchId(DateUtils.getNowWeekMouthNumbers(date));
        String url = path+"/api/SyncDataOracle/SetWeeklyWn60";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklyWn60).toString());
        System.out.println("周报污泥60%填报json参数="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

    /**
     * 周报污泥80%填报
     * @param weeklyWn80
     * @return
     */
    @Override
    public JSONObject setWeeklyWn80(WeeklyWn80Entity weeklyWn80, Date date) {
        weeklyWn80.setBatchId(DateUtils.getNowWeekMouthNumbers(date));
        String url = path+"/api/SyncDataOracle/SetWeeklyWn80";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(weeklyWn80).toString());
        System.out.println("周报污泥80%填报json参数="+json.toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }


    /**
     * 药剂预算
     * @param monthlyYjys
     * @return
     */
    @Override
    public JSONObject setMonthlyYjys(MonthlyYjysNewEntity monthlyYjys) {
        String url = path+"/api/SyncDataOracle/SetMonthlyYjys";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(monthlyYjys).toString());
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        return response;
    }

}

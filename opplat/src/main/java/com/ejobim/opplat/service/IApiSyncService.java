package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.synBean.*;

import java.util.Date;

public interface IApiSyncService {

    /**
     * 设置工厂基础信息
     * @param factoryInfo
     * @return
     */
    JSONObject setFactoryInfo(FactoryInfoEntity factoryInfo);

    /**
     * 进出水水质标准
     * @param shuizhi
     * @return
     */
    JSONObject setShuiZhi(ShuiZhiEntity shuizhi);

    /**
     * 脱水系统设计参数
     * @param tuoshui
     * @return
     */
    JSONObject setTuoshui(TuoShuiEntity tuoshui);

    /**
     * 药剂勾选
     * @param yaoJiGouXuan
     * @return
     */
    JSONObject setYaoJiGouXuan(YaoJiGouXuanNewEntity yaoJiGouXuan);

    /**
     * 月报成本填报
     * @param monthlyCb
     * @return
     */
    JSONObject setMonthlyCb(MonthlyCbEntity monthlyCb);

    /**
     * 月报药剂财务
     * @param monthlyYjcw
     * @return
     */
    JSONObject setMonthlyYjcw(MonthlyYjcwNewEntity monthlyYjcw);

    /**
     * 月报设备完好率
     * @param monthlySbwh
     * @return
     */
    JSONObject setMonthlySbwh(MonthlySbwhEntity monthlySbwh);

    /**
     * 周报处理水量填报表
     * @param weeklyClsl
     * @return
     */
    JSONObject setWeeklyClsl(WeeklyClslEntity weeklyClsl, Date date);

    /**
     * 周报生产电量填报
     * @param weeklyScdl
     * @return
     */
    JSONObject setWeeklyScdl(WeeklyScdlEntity weeklyScdl, Date date);

    /**
     * 周报生产药剂填报
     * @param weeklyScyj
     * @return
     */
    JSONObject setWeeklyScyj(WeeklyScyjEntity weeklyScyj);

    /**
     * 周报水质指标填报
     * @param weeklySzzb
     * @return
     */
    JSONObject setWeeklySzzb(WeeklySzzbEntity weeklySzzb, Date date);

    /**
     * 周报污泥60%填报
     * @param weeklyWn60
     * @return
     */
    JSONObject setWeeklyWn60(WeeklyWn60Entity weeklyWn60, Date date);

    /**
     * 周报污泥80%填报
     * @param weeklyWn80
     * @return
     */
    JSONObject setWeeklyWn80(WeeklyWn80Entity weeklyWn80, Date date);


    /**
     * 药剂预算
     * @param monthlyYjys
     * @return
     */
    JSONObject setMonthlyYjys(MonthlyYjysNewEntity monthlyYjys);
}

/**package com.ejobim.opplat.config;

import com.alibaba.fastjson.JSONArray;
import com.ejobim.opplat.domain.TbFactoryTime;
import com.ejobim.opplat.domain.TbSchedulingPlan;
import com.ejobim.opplat.domain.TbSchedulingRule;
import com.ejobim.opplat.util.DateUtils;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 排班配置信息表
 */
/*public class SchedulingConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 根据现有排班推算后续的排班
     * @param type
     * @param oldScheduleList
     * @return
     */
   /* public  static Integer getNextDaySchedule(Integer type ,Integer[] oldScheduleList ){
        if(type==1){
            return getScheduleOne(oldScheduleList);
        }
        if(type==2){
            return getScheduleTwo(oldScheduleList);
        }
        if(type==3){
            return getScheduleThree(oldScheduleList);
        }
        if(type==4){
            return getScheduleFour(oldScheduleList);
        }
        if(type==5){
            return getScheduleFive(oldScheduleList);
        }
        if(type==6){
            return getScheduleSix(oldScheduleList);
        }

        return null;
    }

    *//**
     * 三班二倒 双排班
     * @return
     *//*
    private  static  Integer  getScheduleOne(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,1,1,1,0,0,2,2,2,2,0,0,1,1,1};
        for(int i=0;i<schedulingConfigs.length-3;i++){
            boolean hasFind = true;
            for(int n=0;n<oldScheduleList.length;n++){
                if(oldScheduleList[n].equals(schedulingConfigs[i+n])){
                    continue;
                }else{
                    hasFind = false;
                    break;
                }

            }
            //如果匹配上
            if(hasFind){
                if(i<schedulingConfigs.length-4){
                    return schedulingConfigs[i+4];
                }else{
                    return schedulingConfigs[0];
                }
            }
        }
        return null;
    }

    private static Integer getCommonConfig(Integer[] schedulingConfigs ,Integer[]  oldScheduleList){
        for(int i=0;i<schedulingConfigs.length-1;i++){
            boolean hasFind = true;
            for(int n=0;n<oldScheduleList.length;n++){
                if(oldScheduleList[n].equals(schedulingConfigs[i+n])){
                    continue;
                }else{
                    hasFind = false;
                    break;
                }

            }
            //如果匹配上
            if(hasFind){
                if(i<schedulingConfigs.length-2){
                    return schedulingConfigs[i+2];
                }else{
                    return schedulingConfigs[1];
                }
            }
        }
        return  null;
    }

    *//**
     * 四班二倒
     * @param oldScheduleList
     * @return
     *//*
    private  static  Integer  getScheduleTwo(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,2,0,0,1};
        return getCommonConfig(schedulingConfigs,oldScheduleList);
    }

    *//**
     * 四班三倒
     * @param oldScheduleList
     * @return
     *//*
    private  static  Integer  getScheduleThree(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,2,3,0,1};
        return getCommonConfig(schedulingConfigs,oldScheduleList);
    }

    *//**
     * 三班两导第二种 单排
     * @param oldScheduleList
     * @return
     *//*
    private  static  Integer  getScheduleFour(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,1,0,2,2,0,1};
        return getCommonConfig(schedulingConfigs,oldScheduleList);
    }

    *//**
     * 四班三倒 第二种 连续上6天班 休息2天
     * @param oldScheduleList
     * @return
     *//*
    private  static  Integer  getScheduleFive(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,1,2,2,3,3,0,0,1};
        return getCommonConfig(schedulingConfigs,oldScheduleList);
    }

    *//**
     * 四班三倒 第三种 连续上6天班 休息2天
     * @param oldScheduleList
     * @return
     *//*
    private  static  Integer  getScheduleSix(Integer[]  oldScheduleList ){
        Integer[] schedulingConfigs = new Integer[]{1,1,1,2,2,2,3,3,3,0,0,0,1,1};
        for(int i=0;i<schedulingConfigs.length-2;i++){
            boolean hasFind = true;
            for(int n=0;n<oldScheduleList.length;n++){
                if(oldScheduleList[n].equals(schedulingConfigs[i+n])){
                    continue;
                }else{
                    hasFind = false;
                    break;
                }

            }
            //如果匹配上
            if(hasFind){
                if(i<schedulingConfigs.length-3){
                    return schedulingConfigs[i+3];
                }else{
                    return schedulingConfigs[2];
                }
            }
        }
        return null;
    }


    *//**
     * 获取初始化排班
     * @param schedulingRuleCurrent
     * @param index
     * @param groupNo
     * @return
     *//*
    private static Integer getInitSchedulePlan(TbSchedulingRule schedulingRuleCurrent,int index,String groupNo){
        JSONArray firstArray = JSONArray.parseArray(schedulingRuleCurrent.getExtendInfo().toString());
        int firstScheduleIndex = -1;
        for(int i=0;i<firstArray.size();i++){
            if(firstArray.getString(i).equals(groupNo)){
                firstScheduleIndex = i;
                break;
            }
        }
        Integer[][] scheduleTable = null;
        if(schedulingRuleCurrent.getRuleType().equals(1)){
           scheduleTable = new Integer[][]{{1,1,1,1},{2,2,0,0},{0,0,2,2}};
        }else if(schedulingRuleCurrent.getRuleType().equals(2)){
            scheduleTable = new Integer[][]{{1,2},{2,0},{0,1},{0,0}};
        }else if(schedulingRuleCurrent.getRuleType().equals(3)){
            scheduleTable = new Integer[][]{{1,2,3,0},{2,3,0,1},{3,0,1,2},{0,1,2,3}};
        }else if(schedulingRuleCurrent.getRuleType().equals(4)){
            scheduleTable = new Integer[][]{{1,1},{2,0},{0,2}};
        }else if(schedulingRuleCurrent.getRuleType().equals(5)){
            scheduleTable = new Integer[][]{{1,1},{2,2},{3,3},{0,0}};
        }else if(schedulingRuleCurrent.getRuleType().equals(6)){
            scheduleTable = new Integer[][]{{1,1,1},{2,2,2},{3,3,3},{0,0,0}};
        }
        return  scheduleTable[firstScheduleIndex][index];
    }


    *//**
     *
     * @param schedulingPlanList
     * @param schedulingRuleCurrent
     * @param factoryTimeList
     * @param date
     * @param groupNo
     * @return
     *//*
    public static Integer getSchedulePlanCollection(List<TbSchedulingPlan> schedulingPlanList, TbSchedulingRule schedulingRuleCurrent, List<TbFactoryTime> factoryTimeList, Date date ,String groupNo ){
        int type = schedulingRuleCurrent.getRuleType();
        int dayCount = 0;
        if(type==1){
            dayCount = 4;
        }
        if(type==2){
            dayCount = 2;
        }
        if(type==3){
            dayCount = 2;
        }
        if(type==4){
            dayCount = 2;
        }
        if(type==5){
            dayCount = 2;
        }
        if(type==6){
            dayCount = 3;
        }
        Date startDate = DateUtils.getNextDate(date,-dayCount);
        Date endInitDate = DateUtils.getNextDate(schedulingRuleCurrent.getEnableTime(),dayCount-1);
        //如果创建日期在初始化日期内
        if(date.getTime()>=schedulingRuleCurrent.getEnableTime().getTime()
            && date.getTime()<=endInitDate.getTime()){
            //进行初始化排班 获取是排班的第几天
            int index = DateUtils.differentDays(schedulingRuleCurrent.getEnableTime(),date);
            return getInitSchedulePlan(schedulingRuleCurrent,index,groupNo);
        }
        Date endDate = DateUtils.getNextDate(date,-1);
        List<String> dayList = DateUtils.getDistDayList(startDate,endDate);
        Integer[] scheduleCollections = getPlanCollection(schedulingPlanList,dayList,factoryTimeList,groupNo);
        if(scheduleCollections==null || scheduleCollections.length!=dayCount){
            return null;
        }else{
            return getNextDaySchedule(type,scheduleCollections);
        }

    }


    *//**
     * 天数
     * @param schedulingPlanList
     * @param factoryTimeList
     * @param dayList
     * @return
     *//*
    private static Integer[] getPlanCollection(List<TbSchedulingPlan> schedulingPlanList,List<String> dayList,List<TbFactoryTime> factoryTimeList,String groupNo ){
        Integer[] list = new Integer[dayList.size()];
        for(int i=0;i<dayList.size();i++){
            String day = dayList.get(i);
            //当天是否有该班组的排班
            boolean groupHasSchedule = false;
            //当天是否有排班
            boolean hasSchedule = false;
            for(TbSchedulingPlan schedulingPlan:schedulingPlanList){
                if(schedulingPlan.getSchedulingTime().equals(day)){
                    hasSchedule = true;
                    if(schedulingPlan.getGroupNo().equals(groupNo)){
                        Integer timeZoneIndex = getTimeZoneIndex(factoryTimeList,schedulingPlan);
                        if(timeZoneIndex==null){
                            return null;
                        }else{
                            list[i] = timeZoneIndex;
                            groupHasSchedule = true;
                            break;
                        }
                    }
                }
            }
            if(groupHasSchedule){
                continue;
            }else if(hasSchedule){
                //班组休假
                list[i] = 0;
            }else{
                //完全找不到排班的情况
                return null;
            }
        }
        return list;

    }

    *//**
     * 找到排班的班次
     * @param factoryTimeList
     * @param schedulingPlan
     * @return
     *//*
    private static Integer getTimeZoneIndex(List<TbFactoryTime> factoryTimeList,TbSchedulingPlan schedulingPlan ){
        for(TbFactoryTime factoryTime:factoryTimeList){
            String startTimeZone = DateUtils.formateDatePart(schedulingPlan.getStartTimePoint()) ;
            String endTimeZone = DateUtils.formateDatePart(schedulingPlan.getEndTimePoint()) ;
            if(factoryTime.getStartTimePoint().equals(startTimeZone) && factoryTime.getEndTimePoint().equals(endTimeZone)){
                return  factoryTime.getTimeSort();
            }
        }
        return null;
    }

    public static void main(String[] args){
        Integer[]  oldScheduleList = new Integer[]{0,1,1};
        System.out.println(getNextDaySchedule(6,oldScheduleList));
    }*/

//}

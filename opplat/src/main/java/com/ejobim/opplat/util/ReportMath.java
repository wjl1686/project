package com.ejobim.opplat.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xibian
 * @apiNote 用户自定义报表的公式计算
 */
public class ReportMath {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //用于计算的基础数据
    private Map<String, Map<String,Double>> dataList;

    //日期列表
    private List<String> dayList;




    /**
     *
     * @param dataList 统计的数据集合
     * @param dayList 统计的日期集合
     */
    public ReportMath(Map<String, Map<String,Double>> dataList,List<String> dayList) {
        this.dayList = dayList;
        this.dataList = dataList;
    }


    /**
     *
     * @param mathType 计算方式
     * @param mathArray 计算公式
     * @param mathDate 列表日期
     * @param staticInfo  统计的开始日期
     * @return
     */
    public Double doMath(int mathType,JSONArray mathArray,String mathDate,String staticInfo) {
        //如果是列表模式 且当日无数据 则直接返回空数据
        if (mathType == 1) {
            if (!dataList.containsKey(mathDate)) {
                return null;
            }
        } else if (mathType == 2) {
            if (dayList.size() < 1) {
                return null;
            }
        }
        //计算公式为空则 无法计算
        if(mathArray==null || mathArray.size() == 0){
            return null;
        }

        //所有的表达式最终都需要转换为一个计算公式
        Binding binding = new Binding();
        //转化计算公式
        StringBuffer calcMathBuffer = new StringBuffer();
        calcMathBuffer.append("v=");

        for (int i = 0; i < mathArray.size(); i++) {
            JSONObject property = mathArray.getJSONObject(i);
            if(!property.containsKey("mathDetail")){
                return null;
            }
            if (property.getIntValue("type") < 10) {
                calcMathBuffer.append(getPropertyCmd(property));
            } else {

                Double value = getPropertyValue(property,mathType,mathDate,staticInfo);
                if (value == null) {
                    return null;
                } else {
                    //绑定数值
                    binding.setVariable("V" + i, value);
                    //修改计算参数
                    calcMathBuffer.append("V" + i);
                }

            }

        }
        binding.setVariable("language", "Groovy");
        String calcMath = calcMathBuffer.toString().replace("^", "**");

        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate(calcMath);
        return Double.valueOf(value.toString());
    }

    /**
     * 获取计算公式内容
     *
     * @param property
     * @return
     */
    private String getPropertyCmd(JSONObject property) {
        if (property.getIntValue("type") == 0) {
            return "";
        } else {
            return property.getString("name");
        }
    }


    private Double getPropertyValue(JSONObject property,int mathType,String mathDate,String staticInfo) {
        switch (property.getIntValue("type")) {
            //独立值
            case 11:
                return getAloneValue(property.getJSONArray("mathDetail").getJSONObject(0),mathType,mathDate,staticInfo);
            //累进值
            case 12:
                return getGraduatedValue(property.getJSONArray("mathDetail").getJSONObject(0),mathType,mathDate,staticInfo);
            //平均值
            case 13:
                return getAvgValue(property.getJSONArray("mathDetail"),mathType,mathDate,staticInfo);
            //最大值
            case 14:
                return getMaxValue(property.getJSONArray("mathDetail"),mathType,mathDate,staticInfo);
            //最小值
            case 15:
                return getMinValue(property.getJSONArray("mathDetail"),mathType,mathDate,staticInfo);
            default:
                return null;
        }
    }

    /**
     * 获取独立值
     *
     * @return
     */
    private Double getAloneValue(JSONObject jsonObject,int mathType,String mathDate,String staticInfo) {
        if (mathType == 1) {
            //列表模式
            return getValueByTimePoint(jsonObject,mathDate);
        } else {
            //统计模式
            double value = 0.0;
            int dayCount = 0;
            List<String> staticDateList = getStaticDateList(staticInfo);
            if(staticDateList==null){
                return  null;
            }
            for (String day : staticDateList) {
                Double dayValue = getValueByTimePoint(jsonObject,day);
                if (dayValue != null) {
                    value += dayValue;
                    dayCount++;
                }
            }

            if (dayCount > 0) {
                return value / dayCount;
            } else {
                return null;
            }
        }

    }


    /**
     * 获取累进值
     *
     * @param jsonObject
     * @return
     */
    private Double getGraduatedValue(JSONObject jsonObject,int mathType,String mathDate,String staticInfo) {
        String startDay = mathDate;
        //默认是前一天
        String endDay = DateUtils.formateDate(DateUtils.getNextDate(mathDate,-1));
        if (mathType == 2) {
            List<String> staticDateList = getStaticDateList(staticInfo);
            if(staticDateList==null){
                return  null;
            }
            //如果是统计方式 默认取最后一天
            startDay = staticDateList.get(staticDateList.size() - 1);
            //统计的开始日期 为统计时间区间第一天的前一天
            endDay = DateUtils.formateDate(DateUtils.getNextDate(staticDateList.get(0), -1));
        }
        Double todayValue = getValueByTimePoint(jsonObject, startDay);
        Double yesterdayValue = getValueByTimePoint(jsonObject, endDay);
        //只有今日值和昨日值 同时存在的时候 才需要返回数据
        if (todayValue != null && yesterdayValue != null) {
            return todayValue - yesterdayValue;
        } else {
            return null;
        }
    }

    /**
     * 获取平均值
     *
     * @param array
     * @return
     */
    private Double getAvgValue(JSONArray array,int mathType,String mathDate,String staticInfo) {
        double avgValue = 0.0;
        //值的计数器
        int valueCount = 0;
        List<String> staticDateList = getDateList(mathType,mathDate,staticInfo);
        if(staticDateList==null){
            return  null;
        }
        for (String day : staticDateList) {
            for (int i = 0; i < array.size(); i++) {
                Double value = getValueByTimePoint(array.getJSONObject(i), day);
                if (value != null) {
                    avgValue += value;
                    valueCount++;
                }
            }
        }

        if (valueCount > 0) {
            return avgValue / valueCount;
        } else {
            return null;
        }
    }


    /**
     * 最大值
     *
     * @param array
     * @return
     */
    private Double getMaxValue(JSONArray array,int mathType,String mathDate,String staticInfo) {
        double maxValue = Double.MIN_VALUE;
        List<String> staticDateList = getDateList(mathType,mathDate,staticInfo);
        if(staticDateList==null){
            return  null;
        }
        for (String day : staticDateList) {
            for (int i = 0; i < array.size(); i++) {
                Double value = getValueByTimePoint(array.getJSONObject(i), day);
                if (value != null) {
                    if (value > maxValue) {
                        maxValue = value;
                    }
                }
            }
        }

        if (maxValue != Double.MIN_VALUE) {
            return maxValue;
        } else {
            return null;
        }
    }

    /**
     * 获取最小值
     *
     * @param array
     * @return
     */
    private Double getMinValue(JSONArray array,int mathType,String mathDate,String staticInfo) {
        double minValue = Double.MAX_VALUE;
        List<String> staticDateList = getDateList(mathType,mathDate,staticInfo);
        if(staticDateList==null){
            return  null;
        }

        for (String day : staticDateList) {
            for (int i = 0; i < array.size(); i++) {
                Double value = getValueByTimePoint(array.getJSONObject(i), day);
                if (value != null) {
                    if (value < minValue) {
                        minValue = value;
                    }
                }
            }
        }

        if (minValue != Double.MAX_VALUE) {
            return minValue;
        } else {
            return null;
        }
    }


    private List<String> getDateList(int mathType,String mathDate,String staticInfo) {
        List<String> staticDateList = null;
        if (mathType == 1) {
            staticDateList = new ArrayList<>();
            staticDateList.add(mathDate);
        } else {
            staticDateList = getStaticDateList(staticInfo);
        }
        return staticDateList;
    }

    private List<String> getStaticDateList(String staticInfo) {
        List<String> staticDateList = this.dayList;
        if (StringUtils.isNotEmpty(staticInfo)) {
            //如果对统计日期另外设置
            JSONObject staticJSON = JSONObject.parseObject(staticInfo);
            Date beginDate = null;
            if (staticJSON.getIntValue("dateType") == 0) {
                beginDate = DateUtils.parseDate(staticJSON.getString("staticStartDate"));
            } else {
                Date searchDate = DateUtils.parseDate(dayList.get(dayList.size()-1));
                beginDate = DateUtils.getFirstDay(searchDate, staticJSON.getIntValue("dateType"));
            }
            if (beginDate != null) {
                Date endDate = DateUtils.parseDate(dayList.get(dayList.size() - 1));
                //如果开始日期大于结束日期
                if(beginDate.getTime()>endDate.getTime()){
                    return null;
                }
                staticDateList = DateUtils.getDistDayList(beginDate, endDate);
            }
        }
        return staticDateList;
    }


    /**
     * 根据时间获取具体的底稿数值
     *
     * @param jsonObject
     * @param date
     * @return
     */
    private Double getValueByTimePoint(JSONObject jsonObject,String date) {
        Date selectTime = DateUtils.parseDateFullPartMinute(date + " " + jsonObject.getString("timePoint"));
        String fillNo = jsonObject.getString("fillNo");
        String key = DateUtils.formateDateFull(selectTime) + "_" + fillNo;

        return this.dataList.get(date).get(key);
    }


}

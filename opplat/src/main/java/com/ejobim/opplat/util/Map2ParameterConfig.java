package com.ejobim.opplat.util;

import com.ejobim.opplat.domain.TbParameterConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Map2ParameterConfig {

    private TbParameterConfig parameterConfig;

    public Map2ParameterConfig(Map<String,Object> map, int parameterType){
        parameterConfig = new TbParameterConfig();

        if(StringUtils.isNotEmpty(map.get("指标类型").toString().trim())){
            parameterType =  getParameterType(map.get("指标类型").toString());
        }
        parameterConfig.setParamType(parameterType);
        parameterConfig.setBrowseName(map.get("填报项").toString());
        parameterConfig.setFillRate(0);
        parameterConfig.setParamCode(map.get("指标编号").toString());
        parameterConfig.setParamFillType(getParamFillType(map.get("录入方式").toString()));
        parameterConfig.setParamFrom(getParamFrom(map.get("是否可通过巡检填报").toString()));
        parameterConfig.setParemMathType(getMathType(map.get("一天填报多次的处理方式").toString()));
        parameterConfig.setParamName(map.get("指标名称").toString());
        parameterConfig.setParamUnit(map.get("单位").toString());
    }


    private int  getParameterType(String str){//1:水量指标;2:电量指标;3:水质指标;4::污泥0指标;5:污泥60指标;6:污泥80指标;7:月设备完好率;8:电费;8:药剂
        switch (str){
            case "水量指标":
                return 1;
            case "电量指标":
                return 2;
            case "水质指标":
                return 3;
            case "污泥公共指标\n" +
                    "（不含药剂指标）":
                return 4;
            case "污泥60%指标\n" +
                    "（不含药剂指标）":
                return 5;
            case "污泥80%指标\n" +
                    "（不含药剂指标）":
                return 6;
            case "月报设备完好率填报":
                return 7;
            case "电费指标":
                return 8;
            case "药剂指标":
                return 9;
             default:
                return 10;
        }
    }

    private int getParamFillType(String str){
        switch (str){
            case "录入指标":
                return 3;
            case "一次性录入":
                return 1;
            default:
                return 2;
        }
    }

    private int getParamFrom(String str){
        switch (str){
            case "是（抄表底）":
                return 1;
            case "否（化验数据）":
                return 2;
            default:
                return 3;
        }
    }

    private int getMathType(String str){
        if(str.startsWith("累进值"))
            return 1;
        else if(str.startsWith("平均值"))
            return 2;
        else if(str.startsWith("最大值"))
            return 3;
        else if(str.startsWith("最小值"))
            return 4;
        else
            return 0;
    }

    public TbParameterConfig getParameterConfig() {
        return parameterConfig;
    }

    public void setParameterConfig(TbParameterConfig parameterConfig) {
        this.parameterConfig = parameterConfig;
    }
}

package com.ejobim.opplat.util;

import java.util.List;
import java.util.Map;

public class ListUtils {

    public static Map<String,Object> getItem(List<Map<String,Object>> list,String value,String key){
        for(Map<String,Object> map:list){
            if(value.equals(map.get(key).toString())){
                return map;
            }
        }
        return null;
    }
}

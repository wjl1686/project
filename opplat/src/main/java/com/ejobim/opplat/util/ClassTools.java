package com.ejobim.opplat.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassTools {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassTools.class);
    public static <T>  void mergeObject(T origin, T destination) {
        if (origin == null || destination == null){
            return;
        }

       /* if (!origin.getClass().equals(destination.getClass()))
            return;*/

        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }


    /**
     * 转换为目标类
     * @param src
     * @param t
     * @return
     */
    public static  <T> T toTarget(Object src, Class<T> t) {
        if (src == null) {
            return null;
        }
        try {
            T target = t.newInstance();
            BeanUtils.copyProperties(target,src);
            return target;
        } catch (Exception e) {

            LOGGER.error("转换出错");
            return null;
        }
    }
    /**
     * 转化为目标类列表
     * @param srcList
     * @param t
     * @return
     */
    public static <T> List<T> toTragetList(List<?> srcList, Class<T> t) {
        List<T> targetList = new ArrayList<>();
        if(srcList != null && !srcList.isEmpty()){
            for(Object src:srcList){
                targetList.add(toTarget(src, t));
            }
        }
        return targetList;
    }
}

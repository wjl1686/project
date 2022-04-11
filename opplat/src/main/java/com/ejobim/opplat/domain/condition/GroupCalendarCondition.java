package com.ejobim.opplat.domain.condition;

/**
 * @author wujianlong
 * @Description: 获取班组日历condition
 * @date 2019/2/19 16:43
 */
public class GroupCalendarCondition {

    private String factoryNo;
    
    private String groupNo;
    
    private String dateName;
    // 0:全部 1:运行班组 2,设备班组
    private Integer type;
}

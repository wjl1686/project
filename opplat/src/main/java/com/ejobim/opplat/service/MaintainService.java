package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 维保工单计划
 */
public interface MaintainService {


    List<TbSparePartsUseLogger>  getSparePartsUserList(String taskNo);



    List<TbEquipTaskFile> getFileList(TbEquipTaskFile overhaulTaskFile);

    int addTaskFile(TbEquipTaskFile overhaulTaskFile);

    int deleteTaskFile(TbEquipTaskFile overhaulTaskFile);


    /**
     * 获取维保计划主体
     * @param planNo
     * @return
     */
    TbEquipMaintainPlan getMaintainPlan(String planNo);

    /**
     * 根据计划执行工单的时间表
     * @param maintainPlan
     * @return
     */
    List<TbFlowMaintainTask> getMaintainTaskTimeList(TbEquipMaintainPlan maintainPlan);




}

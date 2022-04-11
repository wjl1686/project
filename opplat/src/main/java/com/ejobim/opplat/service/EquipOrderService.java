package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbEquipMaintainWorkCondition;
import com.ejobim.opplat.service.impl.EquipOrderServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EquipOrderService {

    /**
     * 获取巡检异常列表
     *
     * @param factoryNo
     * @return
     */
    List<TbEquipFaultInfo> getEquipFaultList(String factoryNo, String equipNam, Integer status, Date beginDate, Date endDate);

    List<TbEquipFaultInfo> getUnFinishEquipFaultList(String factoryNo);

    /**
     * 获取巡检异常详情
     *
     * @param errorNo
     * @return
     */
    TbEquipFaultInfo getEquipFaultDetail(String errorNo);

    /**
     * 更新巡检异常状态
     *
     * @param errorNo
     * @return
     */
    int updateEquipFault(String errorNo);

    /**
     * 根据机构编码和流程编码获取流程信息
     *
     * @param orgNo
     * @param flowCode
     * @return
     */
    TbWorkFlowConfig getWorkFlowConfigByCode(String orgNo, String flowCode);

    /**
     * @param workTaskQueryParam
     * @return
     */
    List<TbWorkTaskInfo> getTaskInfoList(EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam);

    List<TbWorkTaskInfo> getFinishTaskList(String factoryNo,Integer taskType);

    List<TbWorkTaskInfo> getFailTaskList(EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam);

    /**
     * APP获取各人可执行工单
     *
     * @param factoryNo
     * @param user
     * @param plat
     * @param taskType
     * @param date
     * @param equipNo
     * @return
     */
    List<TbWorkTaskInfo> getMyTaskInfoList(String factoryNo, TbUser user, Integer plat, Integer taskType, Date date, String equipNo);

    List<TbWorkTaskInfo> getEquipHistory(String equipNo, Integer taskType);

    int updateTbWorkTaskInfo(TbWorkTaskInfo workTaskInfo);

    /**
     * 获取今天的工单计划
     *
     * @param factoryNo
     * @param taskType
     * @param date
     * @return
     */
    List<TbWorkTaskInfo> getTaskInfoPlanList(String factoryNo, Integer taskType, Date date, TbUser user);

    /**
     * 指派工单
     *
     * @param user
     * @param jsonObject
     * @return
     */
    int setTaskDudyUser(TbUser user, JSONObject jsonObject);

    /**
     * @param factoryNo
     * @param taskType
     * @return
     */
    List<TbWorkTaskInfo> getUnFinishTaskInfoList(String factoryNo, Integer taskType);

    /**
     * 查询维保类型大于计划时间的集合数据
     *
     * @param taskInfo
     * @return
     */
    List<TbWorkTaskInfo> getUnFinishTaskInfoListByPlanTime(TbWorkTaskInfo taskInfo);

    /**
     * 新增保存工作流
     *
     * @param jsonObject
     * @return
     */
    int saveWorkFlowInfo(JSONObject jsonObject, TbUser user);

    int saveWorkFlowInfo(JSONObject jsonObject, TbWorkFlowConfigDetail workFlowConfigDetail, TbUser user);

    int saveValid(JSONObject jsonObject, TbUser user);

    int cancelTask(String taskNo, TbUser user);

    int deleteWorkFlowInfo(String flowNo);

    List<TbEquipTaskFile> getFileList(TbEquipTaskFile equipTaskFile);

    /**
     * 新增附件
     *
     * @param equipTaskFile
     * @return
     */
    int addTaskFile(TbEquipTaskFile equipTaskFile);

    /**
     * 删除附件
     *
     * @param equipTaskFile
     * @return
     */
    int deleteTaskFile(TbEquipTaskFile equipTaskFile);


    /**
     * 获取工作流主体信息
     *
     * @param flowNo
     * @param orgNo
     * @param nodeIndex
     * @param flowCode
     * @param map
     * @return int
     */
    int getWorkFlowDetail(String flowNo, String orgNo, Integer nodeIndex, String flowCode, Map<String, Object> map);

    TbWorkFlowConfigDetail getFirstWorkFlowNode(String factoryNo, String flowCode);

    /**
     * 批量创建维保工单
     *
     * @param list
     * @return
     */
    int createMaintenanceList(String factoryNo, List<TbEquipMaintainFactor> list, TbUser user);

    int createMaintenanceAlone(String factoryNo, TbEquipMaintainFactor maintainFactor, TbUser user);

    /**
     * 创建单个维保计划
     *
     * @param map
     * @return
     */
    int createMaintenanceAloneNew(Map map);

    /**
     * 创建批量维保计划
     *
     * @param condition
     * @param user
     * @return
     */
    int createBatchMaintenancePlan(TbEquipMaintainWorkCondition condition, TbUser user);

    /**
     * 查询维修计划
     *
     * @param workTaskQueryParam
     * @return
     */
    List<TbWorkTaskInfo> getWokTaskPLanList(EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam);

    /**
     * 编辑计划时间
     *
     * @param taskInfo
     * @return
     */
    int editPlan(TbWorkTaskInfo taskInfo);

    /**
     * 查询任务信息
     *
     * @param taskInfo
     * @return
     */
    TbWorkTaskInfo getTbWorkTaskInfo(TbWorkTaskInfo taskInfo);

    List<Map<String, String>> getCheckUserList(String workFlowConfigNo);

    int editMantenPlan(TbWorkTaskInfo taskInfo, TbUser user);

    List<Map<String, Object>> getTaskStaticByGongYi(Date date, String factoryNo, TbUser user);

    /**
     * PC后台获取所有工单和计划列表
     *
     * @param workTaskQueryParam
     * @return
     */
    List<TbWorkTaskInfo> getALLTaskList(EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam);

    /**
     * 工艺查看效果
     *
     * @param taskInfo
     * @return
     */
    Map queryGYEffct(TbWorkTaskInfo taskInfo);
}

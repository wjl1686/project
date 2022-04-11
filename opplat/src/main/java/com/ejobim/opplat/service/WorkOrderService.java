package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.domain.vo.TbFillFormFieldVo;
import com.ejobim.opplat.exception.RestException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WorkOrderService {



    /**
     * 维修工单
     * @param groupNo
     * @return
     */
    List<TbRepairInfo> getTbRepairInfoList(String groupNo,String date);

    /**
     * 获取临时工单
     * @param userNo
     * @return
     */
    List<TbWorkOrderInfo> getTbWorkOrderInfoList(String userNo,String date);


    /**
     * 新增维修工单
     * @param tbTaskInfo
     * @return
     */
    int saveTbRepairInfo(TbTaskInfo tbTaskInfo,TbRepairInfo tbRepairInfo);






    int saveTbWorkOrderInfo(TbWorkOrderInfo tbWorkOrderInfo);



    List<TbTaskInfo> getTbTaskList(String userNo);
    /**
     * @author wujianlong
     * @date 2019-1-18 10:10:08
     * @Description 首页查看任务信息
     * @version 1.0
     * @param condition
     */
    Map<String,Integer> getTaskInfoList(TaskInfoCondition condition);
    /**
     * @author wujianlong
     * @date 2019-1-18 16:10:08
     * @Description 根据当前时间查询任务信息
     * @version 1.0
     * @param currentTime
     */
    List<TbTaskInfo> getCurrentTaskInfo(String currentTime);
    /**
     * @author wujianlong
     * @date 2019-1-18 16:33:08
     * @Description 查询任务信息
     * @version 1.0
     */
    Map<String,Object> getCurrentMouthTaskInfo();
    /**
     * @author wujianlong
     * @date 2019-1-21 15:33:08
     * @Description 查询今日填报数据
     * @version 1.0
     */
    List<TbFillFormTask> findTodayFillTaskInfoList(TbFillFormTask tbFillFormTask,String date,String userCode);


    List<TbFillFormDetail> findFillTaskDetailList(String fillTaskNo,String uri);

    TbFillFormTask getTbFillTaskByKey(String taskNo);
    /**
     * @author wujianlong
     * @date 2019-1-21 16:33:08
     * @Description 查询填报内容配置项
     * @version 1.0
     */
    List<TbFillFormFieldVo> findFillTaskConfigList(String factoryNo, String taskNo , String param);

    List<TbFillFormField> findAllFillTaskConfigList(String factoryNo,String uri);
    /**
     * @author wujianlong
     * @date 2019-1-22 10:53:08
     * @Description 添加配置项内容
     * @version 1.0
     */
    void saveTbFillFormDetail(List<TbFillFormDetail> tbFormDataList) throws RestException;

    List<TbTaskInfo> getPendingTaskList(String currentTime);

    List<TbTaskInfo> getTaskList(TbTaskInfo condition);
    /**
     * @author wujianlong
     * @date 2019-3-13 14:53:08
     * @Description 填报字典数据值（水厂no和上周到当前时间数据）
     * @version 1.0
     */
    List<TbFillFormDetail> selectTbFillFormDetailByFactroyNo(String factroyNo);
    /**
     * @author wujianlong
     * @date 2019-3-1414:53:08
     * @Description 查询填报工单管理列表
     * @version 1.0
     */
    List<TbFillFormTask> findTbFillFormTaskList(TbFillFormTask tbFillFormTask,String beginTime,String endTime,List<String> factoryList);

    int updateTbFillFormTaskStatus(String[] ids,String userCode,String userName);

    int checkTbFillFormTask(String fillTaskNo,TbUser user);

    int rejectTbFillFormTask(String fillTaskNo, TbUser user);

    /**
     * app端查询我的任务
     * @param condition
     * @return
     */
    List<TbWorkTaskInfo> getTaskALlList(TaskInfoCondition condition);


    /**
     * 查询PC端临时工单详情
     * @param ordId
     * @return
     */
    TbWorkOrderTemp getWorkOrderTempDetail(String ordId);
    
    /**
     * APP端临时工单列表
     * @param workOrderTemp,startTime,endTime,finishType
     * @return
     */
    List<TbWorkOrderTemp> getWorkOrderTempList(TbWorkOrderTemp workOrderTemp, Date startTime, Date endTime,int finishType);

    /**
     * pc新增临时工单
     * @param workOrderTemp
     * @return
     */
    int addWorkOrderTemp(TbWorkOrderTemp workOrderTemp);

    /**
     * APP提交临时工单
     * @param workOrderTemp
     * @return
     */
    int updateWorkOrderTemp(TbWorkOrderTemp workOrderTemp);

    List<TaskVo> getTaskAllListNew(TaskInfoCondition condition);
}

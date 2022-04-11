package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.domain.vo.TbSchedulingPlanVo;
import com.ejobim.opplat.exception.BusinessException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SchedulingService {

    /**
     * 新增/修改班组
     * @param  tbGroupInfo
     * @return
     */
    int saveTbGroupInfo(TbGroupInfo tbGroupInfo) throws BusinessException;
    /**
     * 查询班组列表
     * @param  tbGroupInfo
     * @return
     */
    List<TbGroupInfo> getTbGroupInfoList(TbGroupInfo tbGroupInfo);

    /**
     * 查询排班计划页数据
     * @param condition
     * @return
     */
    Map<String, Object>  getTbSchedulingHomeInfo(TbSchedulingPlanCondition condition);


    /**
     * 根据年 月 类型 查询 排班信息
     * @param condition
     * @return
     */
    List<TbSchedulingPlan>  selectSchedulingPlanListByCondition(TbSchedulingPlanCondition condition);

    /**
     * 新增/修改排班计划
     * @param  tbSchedulingPlan
     * @return
     */
    int saveTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan) throws Exception;

    /**
     * 查询排班设置页数据
     * @param condition
     * @return
     */
    Map<String, Object> getTbSchedulingSetInfo(TbSchedulingPlanCondition condition);
    /**
     * 查询排班设置页数据
     * @param condition
     * @return
     */
    Map<String, Object> getGroupCalendarData(TbSchedulingPlanCondition condition);

    /**
     * app换班申请
     * @param  tbSchedulingChange
     * @return
     */
    int applyTbSchedulingChange(TbSchedulingChange tbSchedulingChange);

    /**
     * 根据排班日期和班组类型查询班组排班列表
     * @param  tbSchedulingPlan
     * @return
     */
    List<TbSchedulingPlan>  getTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan);

    /**
     * 查询换班申请列表
     * @param  tbSchedulingChange
     * @return
     */
    List<TbSchedulingChange> getTbSchedulingChangeList(TbSchedulingChange tbSchedulingChange);


    /**
     *  换班申请通过或驳回
     * @param tbSchedulingChange
     * @return
     */
    int goCheckAgreeOrReject(TbSchedulingChange tbSchedulingChange) throws  BusinessException;

    /**
     * 根据用户code和正在运行时间点查询
     * @param userCode
     * @return
     */
    List<TbSchedulingPlan> getbSchedulingPlanInfoByTimePoint(String  userCode);

    /**
     * 根据用户code和正在运行时间查询
     * @param userCode
     * @return
     */
    List<TbSchedulingPlan> getbSchedulingPlanInfoByTime(String  userCode);



    /**
     * 根据类型查看正在运行的班组人员
     * @return
     */
    List<TbSchedulingPlanDeatail> getbSchedulingPlanInfoByGroupType(Integer  type,String factoryNo,String schedulingTime );

    /**
     * app端查询当前申请人的班组的排班信息
     * @return
     */
    TbSchedulingPlanVo getTbSchedulingPlanByApplyUser(TbSchedulingPlanCondition condition);

    /**
     * 校验交班生成二维吗
     * @param  condition
     * @return
     */
    int checkTbSchedulingTransferUser(TbSchedulingPlanCondition condition) throws Exception;

    /**
     * 查询指定时间的排班信息
     * @param  condition
     * @return
     */
    List<TbSchedulingPlan> getbSchedulingPlanInfoByUserCodeByDate(TbSchedulingPlanCondition condition);

    /**
     * app扫码接班
     * @param  plan
     * @return
     */
    int reciveTbSchedulingTransfer(TbSchedulingPlan plan);

    /**
     * 查询交班列表
     * @param  transfer
     * @return
     */
    List<TbSchedulingTransfer>  getTbSchedulingTransferList(TbSchedulingTransfer transfer);


    /**
     *  根据交班no查看详情
     * @param transfer
     * @return
     */
    TbSchedulingTransfer geTbSchedulingTransferInfo(TbSchedulingTransfer transfer);

    /**
     * 点击日历查看排班信息
     * @param condition
     * @return
     */
    Map<String, Object> getTbSchedulingInfoByTime(TbSchedulingPlanCondition condition);
    

    /**
     * 二维码回调
     * @param  condition
     * @return
     */
    int callBack(TbSchedulingPlanCondition condition);

    /**
     * 修改排班计划
     * @param  tbSchedulingPlan
     * @return
     */
    int updateTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan)  throws Exception;

    /**
     * pc 获取计划池
     * @param condition
     * @return
     */
    Map<String, Object> getTbWorkTaskCalendarInfo(TbWorkTaskInfoCondition condition);

    /**
     * 点击日历查看计划信息
     * @param condition
     * @return
     */
    Map<String, Object> getTbWorkTaskInfoByTime(TbWorkTaskInfoCondition condition);

    /**
     * 批量修改计划池日期
     * @param  condition
     * @return
     */
    int updateBatchTbWorkTaskInfo(TbWorkTaskInfoCondition condition);

    /**
     * 获取当前登录的人组code
     * @param  condition
     * @return
     */
    String getUserGroupCode(TbSchedulingPlanCondition condition);
    /**
     * 获取当前班组信息
     * @param  condition
     * @return
     */
   List<TbSchedulingPlanDeatail> getTbSchedulingPlanDeatailBanInfo(TbSchedulingPlanCondition condition);

    /**
     * 删除班组
     * @param  groupNo
     * @return
     */
    int deleteTbGroupInfo(String groupNo);

    /**
     * 删除排班
     * @param  schedulingNos
     * @return
     */
    int deleteTbScheduling(String schedulingNos);

    /**
     * 新增排班规则
     * @param  tbSchedulingRule
     * @return
     */
    int saveTbSchedulingRule(TbSchedulingRule tbSchedulingRule);

    /**
     * 查询排班规则列表
     * @param  tbSchedulingRule
     * @return
     */
    List<TbSchedulingRule> getTbSchedulingRuleList(TbSchedulingRule tbSchedulingRule);

    /**
     * 获取接下来日期的排班
     * @param date
     * @return
     */
    List<TbSchedulingPlan> getNextDateSchedulingPlan(Date date);


    /**
     * 获取
     */
    int  addNextWorkSchedule(String factoryNo);

}

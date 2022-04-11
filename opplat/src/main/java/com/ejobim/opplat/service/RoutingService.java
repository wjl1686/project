package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbRoutingModelCondition;
import com.ejobim.opplat.domain.condition.TbRoutingTaskConditon;
import com.ejobim.opplat.domain.vo.RoutingLocationVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationElementVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationFillElementVo;
import com.ejobim.opplat.exception.BusinessException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 巡检填报点配置
 * @author xibian
 */
public interface RoutingService {

    List<TbRoutingLocation> getRoutingLocationList(TbRoutingLocation routingLocation);

    int insertRoutingLocation(TbRoutingLocation routingLocation);

    int updateRoutingLocation(TbRoutingLocation routingLocation);

    /**
     * 删除巡检点
     * @param routingLocation
     * @return
     */
    int deleteRoutingLocation(TbRoutingLocation routingLocation, String userName);

    /**
     * 删除巡检要素
     * @param routingLocation
     * @return
     */
    int deleteTbRoutingLocationElement(TbRoutingLocationElement routingLocation, String userName);

    /**
     * 根据巡检点编号获取巡检点设备
     * @param routingNo
     * @return
     */
    List<TbRoutingLocatioinEquip> getRoutingEquipList(String routingNo,String equipName);

    /**
     * 根据巡检点编号集合获取巡检点设备
     * @param routingNoList
     * @return
     */
    List<TbRoutingLocatioinEquip> getRoutingEquipListByIds(List<String> routingNoList);

    /**
     * 批量往巡检点添加设备
     * @param locationNo
     * @param equipNoList
     * @param userCode
     * @return
     */
    int addRoutingEquipList(String locationNo,String[] equipNoList, String userCode);

    /**
     * 批量删除
     * @param locationEquipNoList
     * @return
     */
    int deleteRoutingEquipList(String locationNo,String[] locationEquipNoList, String userCode);

    /**
     * 获取巡检要素
     * @param routingLocationElement
     * @return
     */
    List<TbRoutingLocationElement> getRoutingElementList(TbRoutingLocationElement routingLocationElement,List<String> parentIdList);

    int insertTbRoutingLocationElement(TbRoutingLocationElement routingLocationElement);

    int updateTbRoutingLocationElement(TbRoutingLocationElement routingLocationElement);

    /**
     * 获取巡检模板列表
     * @param routingModel
     * @return
     */
    List<TbRoutingModel> getRoutingModelList(TbRoutingModel routingModel);

    /**
     * 新增巡检模式
     * @param routingModel
     * @return
     */
    int addRoutingModel(TbRoutingModel routingModel);

    /**
     * 更新巡检模式
     * @param routingModel
     * @return
     */
    int updateRoutingModel(TbRoutingModel routingModel);

    /**
     * 删除巡检模式
     * @param routingModel
     * @return
     */
    int deleteRoutingModel(TbRoutingModel routingModel);

    /**
     * 新增巡检填报模式详情
     * @param modelNo
     * @param elements
     * @return
     */
    int changeRoutingModelExtends(String modelNo,TbRoutingLocationElement[] elements,String[] delElementNos);

    /**
     * 湖区巡检模式详情
     * @param modelNo
     * @return
     */
    List<TbRoutingModelExtend> getRoutingModelExtends(String modelNo);

    /**
     * 获取巡检填报工单
     * @param routingTask
     * @return
     */
    List<TbRoutingTask> getRoutingTaskList(TbRoutingTask routingTask);

    /**
     * 获取当前用户的巡视工单
     * @param user
     * @return
     */
    Map<String,Object> getMyRoutingTaskList(TbUser user,TbRoutingTask routingTaskQ);


    /**
     * 获取当前用户当前的巡视工单
     * @param user
     * @return
     */
    Map<String,Object> getRoutingLocationDetailInfo(TbUser user, String routingNo);

    /**
     * 根据nfc 查看设备或者工单
     * @param user
     * @return
     */
    Map<String,Object> getRoutingLocationByNfcDetailInfo(TbUser user, String routingNo);


    /**
     * 批量创建巡检任务
     * @param beginDate
     * @param endDate
     * @param modelNo
     * @return
     */
    int addRoutingTaskList(Date beginDate, Date endDate, String modelNo,TbUser user);

    /**
     * 新增巡检任务
     * @param routingTask
     * @return
     */
    int addRoutingTask(TbRoutingTask routingTask);

    /**
     * 修改巡检填报工单
     * @param routingTask
     * @return
     */
    int updateRoutingTask(TbRoutingTask routingTask);

    /**
     * 开始巡检工单
     * @param routingTask
     * @return
     */
    int startRoutingTask(TbRoutingTask routingTask);

    int cancelRoutingTask(String taskNo ,String userCode);

    int finishRoutingTask(TbRoutingTask routingTask);



    /**
     * 插入巡检工单详情
     * @param routingTaskDetailList
     * @return
     */
    int addRoutingTaskDetailList(List<TbRoutingTaskDetail> routingTaskDetailList);

    /**
     * 提交巡检要素详情
     * @param routingTaskDetail
     * @return
     */
    int updateRoutingTaskDetail(TbRoutingTaskDetail routingTaskDetail);



    /**
     * 获取巡视任务的巡视点列表
     * @param routingTask
     * @return
     */
    List<RoutingLocationVo> getTaskRoutingLocationList(TbRoutingTask routingTask);

    /**
     * 根据任务NO和巡检点NO获取任务详情
     * @param taskNo
     * @param locationNo
     * @return
     */
    Map<String,Object> getRoutingTaskDetailByLocation(String taskNo, String locationNo);

    /**
     * 提交巡检详情信息
     * @param routingTaskDetailList
     * @return
     */
    int updateRoutingTaskDetailList(List<TbRoutingTaskDetail> routingTaskDetailList);

    /**
     * 新增巡检异常
     * @param tbEquipFaultInfo
     * @return
     */


    int addRoutingErrorInfo(TbEquipFaultInfo tbEquipFaultInfo );

    TbEquipFaultInfo getRoutingErrorDetail(String errorNo);

    List<TbRoutingLocation> getRoutingTaskDetailList(String taskNo);

    /**
     * 获取巡检工单要素列表
     * @param taskNo
     * @return
     */
    List<TbRoutingTaskDetail> getRoutingDetailList(String taskNo);

    /**
     * 批量导入巡检要素
     * @param list
     * @param factoryNo
     * @return
     */
    int saveImportTbRoutingLocationElement(List<TbRoutingLocationElementVo> list, String factoryNo);

    /**
     * 新增临时巡检
     * @param conditon
     * @return
     */
    int addTempRoutingTask(TbRoutingTaskConditon conditon,TbUser user)throws BusinessException;

    /**
     * 新增临时巡检
     * @param conditon
     * @return
     */
    int modifyTempRoutingTask(TbRoutingTaskConditon conditon,TbUser user)throws BusinessException;

    /**
     * 新增临时巡检模式
     * @param conditon
     * @return
     */
    int addTempTbRoutingModel(TbRoutingModelCondition conditon, TbUser user);

    /**
     * 批量查询巡检点列表
     * @param locationNos
     * @return
     */
    List<TbRoutingLocation> selectRoutingLocationList(String[] locationNos);

    List<TbRoutingTask> getTbRoutingTaskList(TbRoutingTask model);
    /**
     * 更新巡检轨迹
     * @param routingTaskDetail
     * @return
     */
    int updateLocationTrajectory(TbRoutingTaskDetail routingTaskDetail);

    List<TbRoutingTrajectory> getRoutingTrajectorylList(String taskNo);
    /**
     * 根据nfcNo 获取巡检点
     * @param tbRoutingLocation
     * @return
     */
    TbRoutingLocation  getTaskRoutingLocationByNfcNo(TbRoutingLocation tbRoutingLocation);

    /**
     * 批量新增填报项
     * @param list
     * @return
     */
    int saveImportTbRoutingLocationReportElement(List<TbRoutingLocationFillElementVo> list);

    /**
     * 根据nfc_no 传查绑定设备/巡检点类型
     * @param nfcNo
     * @return
     */
    TbNfcInfo getNfcInfo(String nfcNo);

    /**
     * pc新增上报异常
     * @param tbEquipFaultInfo
     * @return
     */
    int savePcError(TbEquipFaultInfo tbEquipFaultInfo);
    /**
     * 上移或者下移巡检点关联设备
     * @param tbRoutingLocatioinEquip
     * @return
     */
    int upOrDownLocationLinkEquip(TbRoutingLocatioinEquip tbRoutingLocatioinEquip);
}

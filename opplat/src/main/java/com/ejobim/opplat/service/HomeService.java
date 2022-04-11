package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbDraftData;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.TaskVo;

import java.util.List;
import java.util.Map;

public interface HomeService {

    Map<String, Object> getHomeInfo(TaskInfoCondition condition);

    Map<String, Object> getHomeEquipInfo(TaskInfoCondition condition);

    Map<String, Object> commonTaskInfo(TaskInfoCondition condition);

    Map<String, Object> getHomeStaticInfo(TbUser user,String factoryNo);

    Map<String, Object> commonTaskInfoDetail(TbUser user,String factoryNo);

    /**
     * 获取水厂或组团工单统计信息
     * @param factoryNo 水厂编号
     * @return
     */
    Map<String, Object> getTaskStaticInfo(String factoryNo);

    List<TaskVo>  getDataNew(TaskInfoCondition condition);

    Map<String,Object> getGroupHomeData(String groupNo);

    List<Map<String,Object>> getGroupErrorInfo(String groupNo);

    List<Map<String,Object>> getGroupTaskInfo(String groupNo);

    Map<String,Object>  getGroupHomeInfo(String factoryNo);

    /**
     * 查询数据底稿信息(截止今天前的数据)
     * @param tbDraftData
     * @return
     */
    List<TbDraftData> getTbDraftDataList(TbDraftData tbDraftData);
}

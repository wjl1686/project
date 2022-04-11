package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingTaskDetail;
import com.ejobim.opplat.domain.TbRoutingTaskDetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbRoutingTaskDetailMapper {
    int countByExample(TbRoutingTaskDetailExample example);

    int deleteByExample(TbRoutingTaskDetailExample example);

    int deleteByPrimaryKey(String taskDetailNo);

    int insert(TbRoutingTaskDetail record);

    /**
     * 批量查询巡检任务详情
     * @param list
     * @return
     */
    int insertBatch(@Param("list") List<TbRoutingTaskDetail> list);

    int insertSelective(TbRoutingTaskDetail record);

    List<TbRoutingTaskDetail> selectByExample(TbRoutingTaskDetailExample example);

    TbRoutingTaskDetail selectByPrimaryKey(String taskDetailNo);

    int updateByExampleSelective(@Param("record") TbRoutingTaskDetail record, @Param("example") TbRoutingTaskDetailExample example);

    int updateByExample(@Param("record") TbRoutingTaskDetail record, @Param("example") TbRoutingTaskDetailExample example);

    int updateByPrimaryKeySelective(TbRoutingTaskDetail record);

    int updateByPrimaryKey(TbRoutingTaskDetail record);

    /**
     * 根据任务NO或巡检点NO获取巡检详情
     * @param taskNo
     * @param locationNo
     * @return
     */
    List<Map<String,Object>> getRoutingTaskDetailList(String taskNo,String locationNo);
}
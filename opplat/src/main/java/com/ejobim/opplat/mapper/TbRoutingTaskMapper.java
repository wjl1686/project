package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingTask;
import com.ejobim.opplat.domain.TbRoutingTaskExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TbRoutingTaskMapper {
    int countByExample(TbRoutingTaskExample example);

    int deleteByExample(TbRoutingTaskExample example);

    int deleteByPrimaryKey(String taskNo);

    int insert(TbRoutingTask record);

    int insertSelective(TbRoutingTask record);

    List<TbRoutingTask> selectByExample(TbRoutingTaskExample example);

    TbRoutingTask selectByPrimaryKey(String taskNo);

    int updateByExampleSelective(@Param("record") TbRoutingTask record, @Param("example") TbRoutingTaskExample example);

    int updateByExample(@Param("record") TbRoutingTask record, @Param("example") TbRoutingTaskExample example);

    int updateByPrimaryKeySelective(TbRoutingTask record);

    int updateByPrimaryKey(TbRoutingTask record);

    int insertBatch(List<TbRoutingTask> list);

    List<TbRoutingTask>  selectRoutingTaskList(TbRoutingTask routingTask);

    TbRoutingTask selectRoutingCheckTaskList(@Param("map") Map map);
}
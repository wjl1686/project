package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFlowMaintainTask;
import com.ejobim.opplat.domain.TbFlowMaintainTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFlowMaintainTaskMapper {
    int countByExample(TbFlowMaintainTaskExample example);

    int deleteByExample(TbFlowMaintainTaskExample example);

    int deleteByPrimaryKey(String taskNo);

    int insert(TbFlowMaintainTask record);

    int insertSelective(TbFlowMaintainTask record);

    List<TbFlowMaintainTask> selectByExample(TbFlowMaintainTaskExample example);

    TbFlowMaintainTask selectByPrimaryKey(String taskNo);

    int updateByExampleSelective(@Param("record") TbFlowMaintainTask record, @Param("example") TbFlowMaintainTaskExample example);

    int updateByExample(@Param("record") TbFlowMaintainTask record, @Param("example") TbFlowMaintainTaskExample example);

    int updateByPrimaryKeySelective(TbFlowMaintainTask record);

    int updateByPrimaryKey(TbFlowMaintainTask record);

    List<TbFlowMaintainTask> selectByFlow(String orgNo, String equipName,String userCode,Integer plat,boolean getFull);
}
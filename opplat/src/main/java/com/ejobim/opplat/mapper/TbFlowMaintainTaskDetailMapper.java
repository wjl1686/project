package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFlowMaintainTaskDetail;
import com.ejobim.opplat.domain.TbFlowMaintainTaskDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFlowMaintainTaskDetailMapper {
    int countByExample(TbFlowMaintainTaskDetailExample example);

    int deleteByExample(TbFlowMaintainTaskDetailExample example);

    int deleteByPrimaryKey(String detailNo);

    int insert(TbFlowMaintainTaskDetail record);

    int insertSelective(TbFlowMaintainTaskDetail record);

    List<TbFlowMaintainTaskDetail> selectByExample(TbFlowMaintainTaskDetailExample example);

    TbFlowMaintainTaskDetail selectByPrimaryKey(String detailNo);

    int updateByExampleSelective(@Param("record") TbFlowMaintainTaskDetail record, @Param("example") TbFlowMaintainTaskDetailExample example);

    int updateByExample(@Param("record") TbFlowMaintainTaskDetail record, @Param("example") TbFlowMaintainTaskDetailExample example);

    int updateByPrimaryKeySelective(TbFlowMaintainTaskDetail record);

    int updateByPrimaryKey(TbFlowMaintainTaskDetail record);
}
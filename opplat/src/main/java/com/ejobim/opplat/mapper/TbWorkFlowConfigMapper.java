package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowConfig;
import com.ejobim.opplat.domain.TbWorkFlowConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowConfigMapper {
    int countByExample(TbWorkFlowConfigExample example);

    int deleteByExample(TbWorkFlowConfigExample example);

    int deleteByPrimaryKey(String flowNo);

    int insert(TbWorkFlowConfig record);

    int insertSelective(TbWorkFlowConfig record);

    List<TbWorkFlowConfig> selectByExample(TbWorkFlowConfigExample example);

    TbWorkFlowConfig selectByPrimaryKey(String flowNo);

    int updateByExampleSelective(@Param("record") TbWorkFlowConfig record, @Param("example") TbWorkFlowConfigExample example);

    int updateByExample(@Param("record") TbWorkFlowConfig record, @Param("example") TbWorkFlowConfigExample example);

    int updateByPrimaryKeySelective(TbWorkFlowConfig record);

    int updateByPrimaryKey(TbWorkFlowConfig record);
}
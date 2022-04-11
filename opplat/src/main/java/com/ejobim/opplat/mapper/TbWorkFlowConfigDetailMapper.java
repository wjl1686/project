package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowConfigDetail;
import com.ejobim.opplat.domain.TbWorkFlowConfigDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowConfigDetailMapper {
    int countByExample(TbWorkFlowConfigDetailExample example);

    int deleteByExample(TbWorkFlowConfigDetailExample example);

    int deleteByPrimaryKey(String nodeNo);

    int insert(TbWorkFlowConfigDetail record);

    int insertSelective(TbWorkFlowConfigDetail record);

    List<TbWorkFlowConfigDetail> selectByExample(TbWorkFlowConfigDetailExample example);

    TbWorkFlowConfigDetail selectByPrimaryKey(String nodeNo);

    int updateByExampleSelective(@Param("record") TbWorkFlowConfigDetail record, @Param("example") TbWorkFlowConfigDetailExample example);

    int updateByExample(@Param("record") TbWorkFlowConfigDetail record, @Param("example") TbWorkFlowConfigDetailExample example);

    int updateByPrimaryKeySelective(TbWorkFlowConfigDetail record);

    int updateByPrimaryKey(TbWorkFlowConfigDetail record);
}
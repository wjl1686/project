package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowConfigDetailExtend;
import com.ejobim.opplat.domain.TbWorkFlowConfigDetailExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowConfigDetailExtendMapper {
    int countByExample(TbWorkFlowConfigDetailExtendExample example);

    int deleteByExample(TbWorkFlowConfigDetailExtendExample example);

    int deleteByPrimaryKey(String nodeExtendNo);

    int insert(TbWorkFlowConfigDetailExtend record);

    int insertSelective(TbWorkFlowConfigDetailExtend record);

    List<TbWorkFlowConfigDetailExtend> selectByExample(TbWorkFlowConfigDetailExtendExample example);

    TbWorkFlowConfigDetailExtend selectByPrimaryKey(String nodeExtendNo);

    int updateByExampleSelective(@Param("record") TbWorkFlowConfigDetailExtend record, @Param("example") TbWorkFlowConfigDetailExtendExample example);

    int updateByExample(@Param("record") TbWorkFlowConfigDetailExtend record, @Param("example") TbWorkFlowConfigDetailExtendExample example);

    int updateByPrimaryKeySelective(TbWorkFlowConfigDetailExtend record);

    int updateByPrimaryKey(TbWorkFlowConfigDetailExtend record);
}
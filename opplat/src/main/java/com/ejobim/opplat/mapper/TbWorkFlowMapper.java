package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlow;
import com.ejobim.opplat.domain.TbWorkFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowMapper {
    int countByExample(TbWorkFlowExample example);

    int deleteByExample(TbWorkFlowExample example);

    int deleteByPrimaryKey(String flowNo);

    int insert(TbWorkFlow record);

    int insertSelective(TbWorkFlow record);

    List<TbWorkFlow> selectByExample(TbWorkFlowExample example);

    TbWorkFlow selectByPrimaryKey(String flowNo);

    int updateByExampleSelective(@Param("record") TbWorkFlow record, @Param("example") TbWorkFlowExample example);

    int updateByExample(@Param("record") TbWorkFlow record, @Param("example") TbWorkFlowExample example);

    int updateByPrimaryKeySelective(TbWorkFlow record);

    int updateByPrimaryKey(TbWorkFlow record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowInfo;
import com.ejobim.opplat.domain.TbWorkFlowInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowInfoMapper {
    int countByExample(TbWorkFlowInfoExample example);

    int deleteByExample(TbWorkFlowInfoExample example);

    int deleteByPrimaryKey(String flowNo);

    int insert(TbWorkFlowInfo record);

    int insertSelective(TbWorkFlowInfo record);

    List<TbWorkFlowInfo> selectByExample(TbWorkFlowInfoExample example);

    TbWorkFlowInfo selectByPrimaryKey(String flowNo);

    int updateByExampleSelective(@Param("record") TbWorkFlowInfo record, @Param("example") TbWorkFlowInfoExample example);

    int updateByExample(@Param("record") TbWorkFlowInfo record, @Param("example") TbWorkFlowInfoExample example);

    int updateByPrimaryKeySelective(TbWorkFlowInfo record);

    int updateByPrimaryKey(TbWorkFlowInfo record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingLocationElement;
import com.ejobim.opplat.domain.TbRoutingLocationElementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRoutingLocationElementMapper {
    int countByExample(TbRoutingLocationElementExample example);

    int deleteByExample(TbRoutingLocationElementExample example);

    int deleteByPrimaryKey(String locationFieldNo);

    int insert(TbRoutingLocationElement record);

    int insertSelective(TbRoutingLocationElement record);

    List<TbRoutingLocationElement> selectByExample(TbRoutingLocationElementExample example);

    TbRoutingLocationElement selectByPrimaryKey(String locationFieldNo);

    int updateByExampleSelective(@Param("record") TbRoutingLocationElement record, @Param("example") TbRoutingLocationElementExample example);

    int updateByExample(@Param("record") TbRoutingLocationElement record, @Param("example") TbRoutingLocationElementExample example);

    int updateByPrimaryKeySelective(TbRoutingLocationElement record);

    int updateByPrimaryKey(TbRoutingLocationElement record);
}
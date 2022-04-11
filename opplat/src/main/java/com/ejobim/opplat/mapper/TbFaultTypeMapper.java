package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFaultType;
import com.ejobim.opplat.domain.TbFaultTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFaultTypeMapper {
    int countByExample(TbFaultTypeExample example);

    int deleteByExample(TbFaultTypeExample example);

    int deleteByPrimaryKey(String faultNo);

    int insert(TbFaultType record);

    int insertSelective(TbFaultType record);

    List<TbFaultType> selectByExample(TbFaultTypeExample example);

    TbFaultType selectByPrimaryKey(String faultNo);

    int updateByExampleSelective(@Param("record") TbFaultType record, @Param("example") TbFaultTypeExample example);

    int updateByExample(@Param("record") TbFaultType record, @Param("example") TbFaultTypeExample example);

    int updateByPrimaryKeySelective(TbFaultType record);

    int updateByPrimaryKey(TbFaultType record);
}
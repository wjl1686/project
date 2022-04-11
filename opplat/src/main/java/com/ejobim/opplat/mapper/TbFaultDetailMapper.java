package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFaultDetail;
import com.ejobim.opplat.domain.TbFaultDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFaultDetailMapper {
    int countByExample(TbFaultDetailExample example);

    int deleteByExample(TbFaultDetailExample example);

    int deleteByPrimaryKey(String faultDetailNo);

    int insert(TbFaultDetail record);

    int insertSelective(TbFaultDetail record);

    List<TbFaultDetail> selectByExample(TbFaultDetailExample example);

    TbFaultDetail selectByPrimaryKey(String faultDetailNo);

    int updateByExampleSelective(@Param("record") TbFaultDetail record, @Param("example") TbFaultDetailExample example);

    int updateByExample(@Param("record") TbFaultDetail record, @Param("example") TbFaultDetailExample example);

    int updateByPrimaryKeySelective(TbFaultDetail record);

    int updateByPrimaryKey(TbFaultDetail record);
}
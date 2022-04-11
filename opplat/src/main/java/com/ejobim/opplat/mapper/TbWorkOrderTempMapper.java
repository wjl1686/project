package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkOrderTemp;
import com.ejobim.opplat.domain.TbWorkOrderTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkOrderTempMapper {
    int countByExample(TbWorkOrderTempExample example);

    int deleteByExample(TbWorkOrderTempExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbWorkOrderTemp record);

    int insertSelective(TbWorkOrderTemp record);

    List<TbWorkOrderTemp> selectByExample(TbWorkOrderTempExample example);

    TbWorkOrderTemp selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbWorkOrderTemp record, @Param("example") TbWorkOrderTempExample example);

    int updateByExample(@Param("record") TbWorkOrderTemp record, @Param("example") TbWorkOrderTempExample example);

    int updateByPrimaryKeySelective(TbWorkOrderTemp record);

    int updateByPrimaryKey(TbWorkOrderTemp record);
}
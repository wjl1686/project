package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkOrderInfo;
import com.ejobim.opplat.domain.TbWorkOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkOrderInfoMapper {
    int countByExample(TbWorkOrderInfoExample example);

    int deleteByExample(TbWorkOrderInfoExample example);

    int deleteByPrimaryKey(String workorderNo);

    int insert(TbWorkOrderInfo record);

    int insertSelective(TbWorkOrderInfo record);

    List<TbWorkOrderInfo> selectByExample(TbWorkOrderInfoExample example);

    TbWorkOrderInfo selectByPrimaryKey(String workorderNo);

    int updateByExampleSelective(@Param("record") TbWorkOrderInfo record, @Param("example") TbWorkOrderInfoExample example);

    int updateByExample(@Param("record") TbWorkOrderInfo record, @Param("example") TbWorkOrderInfoExample example);

    int updateByPrimaryKeySelective(TbWorkOrderInfo record);

    int updateByPrimaryKey(TbWorkOrderInfo record);
}
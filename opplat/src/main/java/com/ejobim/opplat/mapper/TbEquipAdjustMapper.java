package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipAdjust;
import com.ejobim.opplat.domain.TbEquipAdjustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipAdjustMapper {
    int countByExample(TbEquipAdjustExample example);

    int deleteByExample(TbEquipAdjustExample example);

    int deleteByPrimaryKey(String adNo);

    int insert(TbEquipAdjust record);

    int insertSelective(TbEquipAdjust record);

    List<TbEquipAdjust> selectByExample(TbEquipAdjustExample example);

    List<TbEquipAdjust> selectByFlow(String orgNo, String adName,String userCode,Integer plat);

    TbEquipAdjust selectByPrimaryKey(String adNo);

    int updateByExampleSelective(@Param("record") TbEquipAdjust record, @Param("example") TbEquipAdjustExample example);

    int updateByExample(@Param("record") TbEquipAdjust record, @Param("example") TbEquipAdjustExample example);

    int updateByPrimaryKeySelective(TbEquipAdjust record);

    int updateByPrimaryKey(TbEquipAdjust record);
}
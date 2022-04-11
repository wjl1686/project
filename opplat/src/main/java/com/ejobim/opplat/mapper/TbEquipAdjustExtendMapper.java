package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipAdjustExtend;
import com.ejobim.opplat.domain.TbEquipAdjustExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipAdjustExtendMapper {
    int countByExample(TbEquipAdjustExtendExample example);

    int deleteByExample(TbEquipAdjustExtendExample example);

    int deleteByPrimaryKey(String adDetailNo);

    int insert(TbEquipAdjustExtend record);

    int insertSelective(TbEquipAdjustExtend record);

    List<TbEquipAdjustExtend> selectByExample(TbEquipAdjustExtendExample example);

    TbEquipAdjustExtend selectByPrimaryKey(String adDetailNo);

    int updateByExampleSelective(@Param("record") TbEquipAdjustExtend record, @Param("example") TbEquipAdjustExtendExample example);

    int updateByExample(@Param("record") TbEquipAdjustExtend record, @Param("example") TbEquipAdjustExtendExample example);

    int updateByPrimaryKeySelective(TbEquipAdjustExtend record);

    int updateByPrimaryKey(TbEquipAdjustExtend record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAdjustEquip;
import com.ejobim.opplat.domain.TbAdjustEquipExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbAdjustEquipMapper {
    int countByExample(TbAdjustEquipExample example);

    int deleteByExample(TbAdjustEquipExample example);

    int deleteByPrimaryKey(String adNo);

    int insert(TbAdjustEquip record);

    int insertSelective(TbAdjustEquip record);

    List<TbAdjustEquip> selectByExample(TbAdjustEquipExample example);

    List<TbAdjustEquip> selectByKeyName(String factoryNo,String keyName);

    TbAdjustEquip selectByPrimaryKey(String adNo);

    int updateByExampleSelective(@Param("record") TbAdjustEquip record, @Param("example") TbAdjustEquipExample example);

    int updateByExample(@Param("record") TbAdjustEquip record, @Param("example") TbAdjustEquipExample example);

    int updateByPrimaryKeySelective(TbAdjustEquip record);

    int updateByPrimaryKey(TbAdjustEquip record);
}
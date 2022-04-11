package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipOverhaulInfo;
import com.ejobim.opplat.domain.TbEquipOverhaulInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipOverhaulInfoMapper {
    int countByExample(TbEquipOverhaulInfoExample example);

    int deleteByExample(TbEquipOverhaulInfoExample example);

    int deleteByPrimaryKey(String overhaulDetailNo);

    int insert(TbEquipOverhaulInfo record);

    int insertSelective(TbEquipOverhaulInfo record);

    List<TbEquipOverhaulInfo> selectByExample(TbEquipOverhaulInfoExample example);

    TbEquipOverhaulInfo selectByPrimaryKey(String overhaulDetailNo);

    int updateByExampleSelective(@Param("record") TbEquipOverhaulInfo record, @Param("example") TbEquipOverhaulInfoExample example);

    int updateByExample(@Param("record") TbEquipOverhaulInfo record, @Param("example") TbEquipOverhaulInfoExample example);

    int updateByPrimaryKeySelective(TbEquipOverhaulInfo record);

    int updateByPrimaryKey(TbEquipOverhaulInfo record);
}
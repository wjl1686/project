package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipMaintainFactor;
import com.ejobim.opplat.domain.TbEquipMaintainFactorExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbEquipMaintainFactorMapper {
    int countByExample(TbEquipMaintainFactorExample example);

    int deleteByExample(TbEquipMaintainFactorExample example);

    int deleteByPrimaryKey(String mfNo);

    int insert(TbEquipMaintainFactor record);

    int insertSelective(TbEquipMaintainFactor record);

    List<TbEquipMaintainFactor> selectByExample(TbEquipMaintainFactorExample example);

    TbEquipMaintainFactor selectByPrimaryKey(String mfNo);

    int updateByExampleSelective(@Param("record") TbEquipMaintainFactor record, @Param("example") TbEquipMaintainFactorExample example);

    int updateByExample(@Param("record") TbEquipMaintainFactor record, @Param("example") TbEquipMaintainFactorExample example);

    int updateByPrimaryKeySelective(TbEquipMaintainFactor record);

    int updateByPrimaryKey(TbEquipMaintainFactor record);

    List<TbEquipMaintainFactor>  selcetTbEquipMaintainFactorList(TbEquipMaintainFactor tbEquipMaintainFactor);
}
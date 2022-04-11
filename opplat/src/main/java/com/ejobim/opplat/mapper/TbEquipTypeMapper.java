package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipType;
import com.ejobim.opplat.domain.TbEquipTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbEquipTypeMapper {
    int countByExample(TbEquipTypeExample example);

    int deleteByExample(TbEquipTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEquipType record);

    int insertSelective(TbEquipType record);

    List<TbEquipType> selectByExample(TbEquipTypeExample example);

    TbEquipType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEquipType record, @Param("example") TbEquipTypeExample example);

    int updateByExample(@Param("record") TbEquipType record, @Param("example") TbEquipTypeExample example);

    int updateByPrimaryKeySelective(TbEquipType record);

    int updateByPrimaryKey(TbEquipType record);

    TbEquipType  getTbEquipTypeInfo(TbEquipType tbEquipType);

    List<TbEquipType>  selectTbEquipTypetList(TbEquipType tbEquipType);

}
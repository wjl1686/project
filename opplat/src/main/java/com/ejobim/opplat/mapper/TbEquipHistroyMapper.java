package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipHistroy;
import com.ejobim.opplat.domain.TbEquipHistroyExample;
import java.util.List;

import com.ejobim.opplat.domain.TbEquipInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipHistroyMapper {
    int countByExample(TbEquipHistroyExample example);

    int deleteByExample(TbEquipHistroyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEquipHistroy record);

    int insertSelective(TbEquipHistroy record);

    List<TbEquipHistroy> selectByExample(TbEquipHistroyExample example);

    TbEquipHistroy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEquipHistroy record, @Param("example") TbEquipHistroyExample example);

    int updateByExample(@Param("record") TbEquipHistroy record, @Param("example") TbEquipHistroyExample example);

    int updateByPrimaryKeySelective(TbEquipHistroy record);

    int updateByPrimaryKey(TbEquipHistroy record);

    List<TbEquipHistroy>  selectByCoditiom(TbEquipHistroy tbEquipHistroy);
}
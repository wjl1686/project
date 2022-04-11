package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipRepareTaskExtend;
import com.ejobim.opplat.domain.TbEquipRepareTaskExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipRepareTaskExtendMapper {
    int countByExample(TbEquipRepareTaskExtendExample example);

    int deleteByExample(TbEquipRepareTaskExtendExample example);

    int deleteByPrimaryKey(String taskNo);

    int insert(TbEquipRepareTaskExtend record);

    int insertSelective(TbEquipRepareTaskExtend record);

    List<TbEquipRepareTaskExtend> selectByExample(TbEquipRepareTaskExtendExample example);

    TbEquipRepareTaskExtend selectByPrimaryKey(String taskNo);

    int updateByExampleSelective(@Param("record") TbEquipRepareTaskExtend record, @Param("example") TbEquipRepareTaskExtendExample example);

    int updateByExample(@Param("record") TbEquipRepareTaskExtend record, @Param("example") TbEquipRepareTaskExtendExample example);

    int updateByPrimaryKeySelective(TbEquipRepareTaskExtend record);

    int updateByPrimaryKey(TbEquipRepareTaskExtend record);
}
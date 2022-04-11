package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.EquipLog;
import com.ejobim.opplat.domain.EquipLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipLogMapper {
    int countByExample(EquipLogExample example);

    int deleteByExample(EquipLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipLog record);

    int insertSelective(EquipLog record);

    List<EquipLog> selectByExample(EquipLogExample example);

    EquipLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipLog record, @Param("example") EquipLogExample example);

    int updateByExample(@Param("record") EquipLog record, @Param("example") EquipLogExample example);

    int updateByPrimaryKeySelective(EquipLog record);

    int updateByPrimaryKey(EquipLog record);
}
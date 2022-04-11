package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipRepareInfo;
import com.ejobim.opplat.domain.TbEquipRepareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipRepareInfoMapper {
    int countByExample(TbEquipRepareInfoExample example);

    int deleteByExample(TbEquipRepareInfoExample example);

    int deleteByPrimaryKey(String repareDetailNo);

    int insert(TbEquipRepareInfo record);

    int insertSelective(TbEquipRepareInfo record);

    List<TbEquipRepareInfo> selectByExample(TbEquipRepareInfoExample example);

    TbEquipRepareInfo selectByPrimaryKey(String repareDetailNo);

    int updateByExampleSelective(@Param("record") TbEquipRepareInfo record, @Param("example") TbEquipRepareInfoExample example);

    int updateByExample(@Param("record") TbEquipRepareInfo record, @Param("example") TbEquipRepareInfoExample example);

    int updateByPrimaryKeySelective(TbEquipRepareInfo record);

    int updateByPrimaryKey(TbEquipRepareInfo record);
}
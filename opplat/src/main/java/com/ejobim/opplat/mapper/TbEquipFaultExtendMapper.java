package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipFaultExtend;
import com.ejobim.opplat.domain.TbEquipFaultExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipFaultExtendMapper {
    int countByExample(TbEquipFaultExtendExample example);

    int deleteByExample(TbEquipFaultExtendExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEquipFaultExtend record);

    int insertSelective(TbEquipFaultExtend record);

    List<TbEquipFaultExtend> selectByExample(TbEquipFaultExtendExample example);

    TbEquipFaultExtend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEquipFaultExtend record, @Param("example") TbEquipFaultExtendExample example);

    int updateByExample(@Param("record") TbEquipFaultExtend record, @Param("example") TbEquipFaultExtendExample example);

    int updateByPrimaryKeySelective(TbEquipFaultExtend record);

    int updateByPrimaryKey(TbEquipFaultExtend record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipReparePlanExtend;
import com.ejobim.opplat.domain.TbEquipReparePlanExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipReparePlanExtendMapper {
    int countByExample(TbEquipReparePlanExtendExample example);

    int deleteByExample(TbEquipReparePlanExtendExample example);

    int deleteByPrimaryKey(String planExtendNo);

    int insert(TbEquipReparePlanExtend record);

    int insertSelective(TbEquipReparePlanExtend record);

    List<TbEquipReparePlanExtend> selectByExample(TbEquipReparePlanExtendExample example);

    TbEquipReparePlanExtend selectByPrimaryKey(String planExtendNo);

    int updateByExampleSelective(@Param("record") TbEquipReparePlanExtend record, @Param("example") TbEquipReparePlanExtendExample example);

    int updateByExample(@Param("record") TbEquipReparePlanExtend record, @Param("example") TbEquipReparePlanExtendExample example);

    int updateByPrimaryKeySelective(TbEquipReparePlanExtend record);

    int updateByPrimaryKey(TbEquipReparePlanExtend record);
}
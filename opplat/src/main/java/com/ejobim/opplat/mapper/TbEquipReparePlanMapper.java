package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipReparePlan;
import com.ejobim.opplat.domain.TbEquipReparePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipReparePlanMapper {
    int countByExample(TbEquipReparePlanExample example);

    int deleteByExample(TbEquipReparePlanExample example);

    int deleteByPrimaryKey(String rpNo);

    int insert(TbEquipReparePlan record);

    int insertSelective(TbEquipReparePlan record);

    List<TbEquipReparePlan> selectByExample(TbEquipReparePlanExample example);

    TbEquipReparePlan selectByPrimaryKey(String rpNo);

    int updateByExampleSelective(@Param("record") TbEquipReparePlan record, @Param("example") TbEquipReparePlanExample example);

    int updateByExample(@Param("record") TbEquipReparePlan record, @Param("example") TbEquipReparePlanExample example);

    int updateByPrimaryKeySelective(TbEquipReparePlan record);

    int updateByPrimaryKey(TbEquipReparePlan record);
}
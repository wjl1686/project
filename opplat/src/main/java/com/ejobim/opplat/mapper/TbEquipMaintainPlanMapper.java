package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipMaintainPlan;
import com.ejobim.opplat.domain.TbEquipMaintainPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipMaintainPlanMapper {
    int countByExample(TbEquipMaintainPlanExample example);

    int deleteByExample(TbEquipMaintainPlanExample example);

    int deleteByPrimaryKey(String planNo);

    int insert(TbEquipMaintainPlan record);

    int insertSelective(TbEquipMaintainPlan record);

    List<TbEquipMaintainPlan> selectByExample(TbEquipMaintainPlanExample example);

    List<TbEquipMaintainPlan> selectByFlow(String orgNo, String equipName,String userCode,Integer plat);

    TbEquipMaintainPlan selectByPrimaryKey(String planNo);



    int updateByExampleSelective(@Param("record") TbEquipMaintainPlan record, @Param("example") TbEquipMaintainPlanExample example);

    int updateByExample(@Param("record") TbEquipMaintainPlan record, @Param("example") TbEquipMaintainPlanExample example);

    int updateByPrimaryKeySelective(TbEquipMaintainPlan record);

    int updateByPrimaryKey(TbEquipMaintainPlan record);
}
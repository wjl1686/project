package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipMaintainPlanExtend;
import com.ejobim.opplat.domain.TbEquipMaintainPlanExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipMaintainPlanExtendMapper {
    int countByExample(TbEquipMaintainPlanExtendExample example);

    int deleteByExample(TbEquipMaintainPlanExtendExample example);

    int deleteByPrimaryKey(String detailNo);

    int insert(TbEquipMaintainPlanExtend record);

    int insertSelective(TbEquipMaintainPlanExtend record);

    List<TbEquipMaintainPlanExtend> selectByExample(TbEquipMaintainPlanExtendExample example);

    TbEquipMaintainPlanExtend selectByPrimaryKey(String detailNo);

    int updateByExampleSelective(@Param("record") TbEquipMaintainPlanExtend record, @Param("example") TbEquipMaintainPlanExtendExample example);

    int updateByExample(@Param("record") TbEquipMaintainPlanExtend record, @Param("example") TbEquipMaintainPlanExtendExample example);

    int updateByPrimaryKeySelective(TbEquipMaintainPlanExtend record);

    int updateByPrimaryKey(TbEquipMaintainPlanExtend record);
}
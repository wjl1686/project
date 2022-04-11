package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipMaintenanceInfo;
import com.ejobim.opplat.domain.TbEquipMaintenanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipMaintenanceInfoMapper {
    int countByExample(TbEquipMaintenanceInfoExample example);

    int deleteByExample(TbEquipMaintenanceInfoExample example);

    int deleteByPrimaryKey(String maintenanceDetailNo);

    int insert(TbEquipMaintenanceInfo record);

    int insertSelective(TbEquipMaintenanceInfo record);

    List<TbEquipMaintenanceInfo> selectByExample(TbEquipMaintenanceInfoExample example);

    TbEquipMaintenanceInfo selectByPrimaryKey(String maintenanceDetailNo);

    int updateByExampleSelective(@Param("record") TbEquipMaintenanceInfo record, @Param("example") TbEquipMaintenanceInfoExample example);

    int updateByExample(@Param("record") TbEquipMaintenanceInfo record, @Param("example") TbEquipMaintenanceInfoExample example);

    int updateByPrimaryKeySelective(TbEquipMaintenanceInfo record);

    int updateByPrimaryKey(TbEquipMaintenanceInfo record);
}
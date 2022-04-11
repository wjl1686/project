package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipFaultInfo;
import com.ejobim.opplat.domain.TbEquipFaultInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipFaultInfoMapper {
    int countByExample(TbEquipFaultInfoExample example);

    int deleteByExample(TbEquipFaultInfoExample example);

    int deleteByPrimaryKey(String errorNo);

    int insert(TbEquipFaultInfo record);

    int insertSelective(TbEquipFaultInfo record);

    List<TbEquipFaultInfo> selectByExample(TbEquipFaultInfoExample example);

    List<TbEquipFaultInfo> selectUnFinishList(String factoryNo);

    List<Map<String,Object>> selectUnFinishMapList(String factoryNo);

    TbEquipFaultInfo selectByPrimaryKey(String errorNo);

    int updateByExampleSelective(@Param("record") TbEquipFaultInfo record, @Param("example") TbEquipFaultInfoExample example);

    int updateByExample(@Param("record") TbEquipFaultInfo record, @Param("example") TbEquipFaultInfoExample example);

    int updateByPrimaryKeySelective(TbEquipFaultInfo record);

    int updateByPrimaryKey(TbEquipFaultInfo record);
}
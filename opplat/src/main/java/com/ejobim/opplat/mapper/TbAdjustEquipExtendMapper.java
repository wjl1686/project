package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAdjustEquipExtend;
import com.ejobim.opplat.domain.TbAdjustEquipExtendExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbAdjustEquipExtendMapper {
    int countByExample(TbAdjustEquipExtendExample example);

    int deleteByExample(TbAdjustEquipExtendExample example);

    int deleteByPrimaryKey(String adDetailNo);

    int insert(TbAdjustEquipExtend record);

    int insertSelective(TbAdjustEquipExtend record);

    List<TbAdjustEquipExtend> selectByExample(TbAdjustEquipExtendExample example);

    TbAdjustEquipExtend selectByPrimaryKey(String adDetailNo);

    int updateByExampleSelective(@Param("record") TbAdjustEquipExtend record, @Param("example") TbAdjustEquipExtendExample example);

    int updateByExample(@Param("record") TbAdjustEquipExtend record, @Param("example") TbAdjustEquipExtendExample example);

    int updateByPrimaryKeySelective(TbAdjustEquipExtend record);

    int updateByPrimaryKey(TbAdjustEquipExtend record);
}
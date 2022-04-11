package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFacilityParam;
import com.ejobim.opplat.domain.TbFacilityParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFacilityParamMapper {
    int countByExample(TbFacilityParamExample example);

    int deleteByExample(TbFacilityParamExample example);

    int deleteByPrimaryKey(String fatiParamNo);

    int insert(TbFacilityParam record);

    int insertSelective(TbFacilityParam record);

    List<TbFacilityParam> selectByExample(TbFacilityParamExample example);

    TbFacilityParam selectByPrimaryKey(String fatiParamNo);

    int updateByExampleSelective(@Param("record") TbFacilityParam record, @Param("example") TbFacilityParamExample example);

    int updateByExample(@Param("record") TbFacilityParam record, @Param("example") TbFacilityParamExample example);

    int updateByPrimaryKeySelective(TbFacilityParam record);

    int updateByPrimaryKey(TbFacilityParam record);
}
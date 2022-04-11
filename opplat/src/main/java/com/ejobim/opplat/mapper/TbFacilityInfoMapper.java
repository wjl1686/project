package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFacilityInfo;
import com.ejobim.opplat.domain.TbFacilityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFacilityInfoMapper {
    int countByExample(TbFacilityInfoExample example);

    int deleteByExample(TbFacilityInfoExample example);

    int deleteByPrimaryKey(String fatiNo);

    int insert(TbFacilityInfo record);

    int insertSelective(TbFacilityInfo record);

    List<TbFacilityInfo> selectByExample(TbFacilityInfoExample example);

    TbFacilityInfo selectByPrimaryKey(String fatiNo);

    int updateByExampleSelective(@Param("record") TbFacilityInfo record, @Param("example") TbFacilityInfoExample example);

    int updateByExample(@Param("record") TbFacilityInfo record, @Param("example") TbFacilityInfoExample example);

    int updateByPrimaryKeySelective(TbFacilityInfo record);

    int updateByPrimaryKey(TbFacilityInfo record);

    TbFacilityInfo  selectByTbFacilityInfo(TbFacilityInfo facilityInfo);
}
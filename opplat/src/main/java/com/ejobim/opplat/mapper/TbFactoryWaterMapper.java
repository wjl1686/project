package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryWater;
import com.ejobim.opplat.domain.TbFactoryWaterExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbFactoryWaterMapper {
    int countByExample(TbFactoryWaterExample example);

    int deleteByExample(TbFactoryWaterExample example);

    int insert(TbFactoryWater record);

    int insertSelective(TbFactoryWater record);

    List<TbFactoryWater> selectByExample(TbFactoryWaterExample example);

    TbFactoryWater selectByPrimaryKey(String factoryNo);

    int updateByExampleSelective(@Param("record") TbFactoryWater record, @Param("example") TbFactoryWaterExample example);

    int updateByExample(@Param("record") TbFactoryWater record, @Param("example") TbFactoryWaterExample example);

    int updateByFactoryNo(@Param("record")TbFactoryWater record);

    List<TbFactoryWater> selectWaterInfoByConds(TbFactoryWater tbFactoryWater);
}
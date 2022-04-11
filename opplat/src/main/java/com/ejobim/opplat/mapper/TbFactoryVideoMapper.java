package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryVideo;
import com.ejobim.opplat.domain.TbFactoryVideoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbFactoryVideoMapper {
    int countByExample(TbFactoryVideoExample example);

    int deleteByExample(TbFactoryVideoExample example);

    int deleteByPrimaryKey(String factoryNo);

    int insert(TbFactoryVideo record);

    int insertSelective(TbFactoryVideo record);

    List<TbFactoryVideo> selectByExample(TbFactoryVideoExample example);

    TbFactoryVideo selectByPrimaryKey(String factoryNo);

    int updateByExampleSelective(@Param("record") TbFactoryVideo record, @Param("example") TbFactoryVideoExample example);

    int updateByExample(@Param("record") TbFactoryVideo record, @Param("example") TbFactoryVideoExample example);

    int updateByPrimaryKeySelective(TbFactoryVideo record);

    int updateByPrimaryKey(TbFactoryVideo record);
}
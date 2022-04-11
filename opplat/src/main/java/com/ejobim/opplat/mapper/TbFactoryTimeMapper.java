package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryTime;
import com.ejobim.opplat.domain.TbFactoryTimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbFactoryTimeMapper {
    int countByExample(TbFactoryTimeExample example);

    int deleteByExample(TbFactoryTimeExample example);

    int deleteByPrimaryKey(String timeNo);

    int insert(TbFactoryTime record);

    int insertSelective(TbFactoryTime record);

    List<TbFactoryTime> selectByExample(TbFactoryTimeExample example);

    TbFactoryTime selectByPrimaryKey(String timeNo);

    int updateByExampleSelective(@Param("record") TbFactoryTime record, @Param("example") TbFactoryTimeExample example);

    int updateByExample(@Param("record") TbFactoryTime record, @Param("example") TbFactoryTimeExample example);

    int updateByPrimaryKeySelective(TbFactoryTime record);

    int updateByPrimaryKey(TbFactoryTime record);

    List<TbFactoryTime>  selectTbFactroyTimeList(TbFactoryTime tbFactoryTime);

    List<TbFactoryTime>  getTbFactroyTimeByCondition(TbFactoryTime tbFactoryTime);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryMeasureCaliber;
import com.ejobim.opplat.domain.TbFactoryMeasureCaliberExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbFactoryMeasureCaliberMapper {
    int countByExample(TbFactoryMeasureCaliberExample example);

    int deleteByExample(TbFactoryMeasureCaliberExample example);

    int deleteByPrimaryKey(String factoryNo);

    int insert(TbFactoryMeasureCaliber record);

    int insertSelective(TbFactoryMeasureCaliber record);

    List<TbFactoryMeasureCaliber> selectByExample(TbFactoryMeasureCaliberExample example);

    TbFactoryMeasureCaliber selectByPrimaryKey(String factoryNo);

    int updateByExampleSelective(@Param("record") TbFactoryMeasureCaliber record, @Param("example") TbFactoryMeasureCaliberExample example);

    int updateByExample(@Param("record") TbFactoryMeasureCaliber record, @Param("example") TbFactoryMeasureCaliberExample example);

    int updateByPrimaryKeySelective(TbFactoryMeasureCaliber record);

    int updateByPrimaryKey(TbFactoryMeasureCaliber record);
}
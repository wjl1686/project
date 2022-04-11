package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSparePartsUseLogger;
import com.ejobim.opplat.domain.TbSparePartsUseLoggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbSparePartsUseLoggerMapper {
    int countByExample(TbSparePartsUseLoggerExample example);

    int deleteByExample(TbSparePartsUseLoggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSparePartsUseLogger record);

    int insertSelective(TbSparePartsUseLogger record);

    List<TbSparePartsUseLogger> selectByExample(TbSparePartsUseLoggerExample example);

    TbSparePartsUseLogger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSparePartsUseLogger record, @Param("example") TbSparePartsUseLoggerExample example);

    int updateByExample(@Param("record") TbSparePartsUseLogger record, @Param("example") TbSparePartsUseLoggerExample example);

    int updateByPrimaryKeySelective(TbSparePartsUseLogger record);

    int updateByPrimaryKey(TbSparePartsUseLogger record);

    TbSparePartsUseLogger  selectBySparePartsNo(String sparePartsNo);

    int updateBySparePartsNo(TbSparePartsUseLogger tbSparePartsUseLogger);

    List<TbSparePartsUseLogger>  selectByWrokOrderNo(String wrokOrderNo);
}
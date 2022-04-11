package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbReportDate;
import com.ejobim.opplat.domain.TbReportDateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
public interface TbReportDateMapper {
    int countByExample(TbReportDateExample example);

    int deleteByExample(TbReportDateExample example);

    int deleteByPrimaryKey(String drNo);

    int insert(TbReportDate record);

    int insertBatch(List<TbReportDate> list);

    int insertSelective(TbReportDate record);

    List<TbReportDate> selectByExample(TbReportDateExample example);

    TbReportDate selectByPrimaryKey(String drNo);

    int updateByExampleSelective(@Param("record") TbReportDate record, @Param("example") TbReportDateExample example);

    int updateByExample(@Param("record") TbReportDate record, @Param("example") TbReportDateExample example);

    int updateByPrimaryKeySelective(TbReportDate record);

    int updateByPrimaryKey(TbReportDate record);

    TbReportDate getLastReportDate(String factoryNo);
}
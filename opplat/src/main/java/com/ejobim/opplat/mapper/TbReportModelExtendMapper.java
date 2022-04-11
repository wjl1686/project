package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbReportModelExtend;
import com.ejobim.opplat.domain.TbReportModelExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbReportModelExtendMapper {
    int countByExample(TbReportModelExtendExample example);

    int deleteByExample(TbReportModelExtendExample example);

    int deleteByPrimaryKey(String extendNo);

    int insert(TbReportModelExtend record);

    int insertSelective(TbReportModelExtend record);

    List<TbReportModelExtend> selectByExample(TbReportModelExtendExample example);

    TbReportModelExtend selectByPrimaryKey(String extendNo);

    int updateByExampleSelective(@Param("record") TbReportModelExtend record, @Param("example") TbReportModelExtendExample example);

    int updateByExample(@Param("record") TbReportModelExtend record, @Param("example") TbReportModelExtendExample example);

    int updateByPrimaryKeySelective(@Param("record") TbReportModelExtend record);

    int updateByPrimaryKey(@Param("record") TbReportModelExtend record);

    int selectCount(@Param("record") TbReportModelExtend record);

    int updateByEnyity(TbReportModelExtend tbReportModelExtend);
}
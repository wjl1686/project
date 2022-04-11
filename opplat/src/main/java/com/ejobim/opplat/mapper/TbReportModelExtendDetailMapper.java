package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbReportModelExtendDetail;
import com.ejobim.opplat.domain.TbReportModelExtendDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbReportModelExtendDetailMapper {
    int countByExample(TbReportModelExtendDetailExample example);

    int deleteByExample(TbReportModelExtendDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbReportModelExtendDetail record);

    int insertSelective(TbReportModelExtendDetail record);

    List<TbReportModelExtendDetail> selectByExample(TbReportModelExtendDetailExample example);

    TbReportModelExtendDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbReportModelExtendDetail record, @Param("example") TbReportModelExtendDetailExample example);

    int updateByExample(@Param("record") TbReportModelExtendDetail record, @Param("example") TbReportModelExtendDetailExample example);

    int updateByPrimaryKeySelective(TbReportModelExtendDetail record);

    int updateByPrimaryKey(TbReportModelExtendDetail record);
}
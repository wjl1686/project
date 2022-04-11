package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbReportModel;
import com.ejobim.opplat.domain.TbReportModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbReportModelMapper {
    int countByExample(TbReportModelExample example);

    int deleteByExample(TbReportModelExample example);

    int deleteByPrimaryKey(String rmNo);

    int insert(TbReportModel record);

    int insertSelective(TbReportModel record);

    List<TbReportModel> selectByExample(TbReportModelExample example);

    TbReportModel selectByPrimaryKey(String rmNo);

    int updateByExampleSelective(@Param("record") TbReportModel record, @Param("example") TbReportModelExample example);

    int updateByExample(@Param("record") TbReportModel record, @Param("example") TbReportModelExample example);

    int updateByPrimaryKeySelective(TbReportModel record);

    int updateByPrimaryKey(TbReportModel record);
}
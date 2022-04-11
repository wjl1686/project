package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbAnalysisFillTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public interface TbAnalysisFillTaskMapper {
    int countByExample(TbAnalysisFillTaskExample example);

    int deleteByExample(TbAnalysisFillTaskExample example);

    int deleteByPrimaryKey(String fillTaskNo);

    int insert(TbAnalysisFillTask record);

    int insertSelective(TbAnalysisFillTask record);

    List<TbAnalysisFillTask> selectByExample(TbAnalysisFillTaskExample example);

    TbAnalysisFillTask selectByPrimaryKey(String fillTaskNo);

    int updateByExampleSelective(@Param("record") TbAnalysisFillTask record, @Param("example") TbAnalysisFillTaskExample example);

    int updateByExample(@Param("record") TbAnalysisFillTask record, @Param("example") TbAnalysisFillTaskExample example);

    int updateByPrimaryKeySelective(TbAnalysisFillTask record);

    int updateByPrimaryKey(TbAnalysisFillTask record);
}
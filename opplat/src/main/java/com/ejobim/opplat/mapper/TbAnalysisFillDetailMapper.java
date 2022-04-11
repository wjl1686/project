package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAnalysisFillDetail;
import com.ejobim.opplat.domain.TbAnalysisFillDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public interface TbAnalysisFillDetailMapper {
    int countByExample(TbAnalysisFillDetailExample example);

    int deleteByExample(TbAnalysisFillDetailExample example);

    int deleteByPrimaryKey(String fillDetailNo);

    int insert(TbAnalysisFillDetail record);

    int insertBatch(List<TbAnalysisFillDetail> list);

    int insertSelective(TbAnalysisFillDetail record);

    List<TbAnalysisFillDetail> selectByExample(TbAnalysisFillDetailExample example);

    TbAnalysisFillDetail selectByPrimaryKey(String fillDetailNo);

    int updateByExampleSelective(@Param("record") TbAnalysisFillDetail record, @Param("example") TbAnalysisFillDetailExample example);

    int updateByExample(@Param("record") TbAnalysisFillDetail record, @Param("example") TbAnalysisFillDetailExample example);

    int updateByPrimaryKeySelective(TbAnalysisFillDetail record);

    int updateByPrimaryKey(TbAnalysisFillDetail record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbDraftData;
import com.ejobim.opplat.domain.TbDraftDataExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbDraftDataMapper {
    int countByExample(TbDraftDataExample example);

    int deleteByExample(TbDraftDataExample example);

    int deleteByPrimaryKey(String draftNo);

    int insert(TbDraftData record);

    int insertSelective(TbDraftData record);

    int insertBatch(List<TbDraftData> list);

    List<TbDraftData> selectByExample(TbDraftDataExample example);

    TbDraftData selectByPrimaryKey(String draftNo);

    int updateByExampleSelective(@Param("record") TbDraftData record, @Param("example") TbDraftDataExample example);

    int updateByExample(@Param("record") TbDraftData record, @Param("example") TbDraftDataExample example);

    int updateByPrimaryKeySelective(TbDraftData record);

    int updateByPrimaryKey(TbDraftData record);


    List<TbDraftData> selectReportDayWeekDate(@Param("monDay") String monDay,@Param("sunDay")  String sunDay,@Param("factoryNo")  String factoryNo);

    List<TbDraftData> getTbDraftDataList(TbDraftData tbDraftData);
}
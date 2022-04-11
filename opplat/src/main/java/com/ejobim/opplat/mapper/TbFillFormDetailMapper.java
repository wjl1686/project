package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFillFormDetail;
import com.ejobim.opplat.domain.TbFillFormDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
@Component
public interface TbFillFormDetailMapper {
    int countByExample(TbFillFormDetailExample example);

    int deleteByExample(TbFillFormDetailExample example);

    int insert(TbFillFormDetail record);

    int insertSelective(TbFillFormDetail record);

    List<TbFillFormDetail> selectByExample(TbFillFormDetailExample example);

    TbFillFormDetail selectByPrimaryKey(@Param("detailNo") String detailNo);

    int updateByExampleSelective(@Param("record") TbFillFormDetail record, @Param("example") TbFillFormDetailExample example);

    int updateByExample(@Param("record") TbFillFormDetail record, @Param("example") TbFillFormDetailExample example);

    int updateByPrimaryKeySelective(TbFillFormDetail record);

    int updateByPrimaryKey(TbFillFormDetail record);

    int insertBatch(List<TbFillFormDetail> list);

    List<TbFillFormDetail> selectTbFillFormDetailByFactroyNo(String factoryNo);

    List<TbFillFormDetail> selectListByDate(String factoryNo,String startDate,String endDate);
}
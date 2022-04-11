package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbGroupDetail;
import com.ejobim.opplat.domain.TbGroupDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbGroupDetailMapper {
    int countByExample(TbGroupDetailExample example);

    int deleteByExample(TbGroupDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGroupDetail record);

    int insertSelective(TbGroupDetail record);

    List<TbGroupDetail> selectByExample(TbGroupDetailExample example);

    TbGroupDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbGroupDetail record, @Param("example") TbGroupDetailExample example);

    int updateByExample(@Param("record") TbGroupDetail record, @Param("example") TbGroupDetailExample example);

    int updateByPrimaryKeySelective(TbGroupDetail record);

    int updateByPrimaryKey(TbGroupDetail record);
}
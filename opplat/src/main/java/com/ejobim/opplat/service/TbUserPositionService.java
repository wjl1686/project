package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbUserPosition;
import com.ejobim.opplat.domain.TbUserPositionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TbUserPositionService {
    int countByExample(TbUserPositionExample example);

    int deleteByExample(TbUserPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserPosition record);

    int insertSelective(TbUserPosition record);

    List<TbUserPosition> selectByExample(TbUserPositionExample example);

    TbUserPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserPosition record, @Param("example") TbUserPositionExample example);

    int updateByExample(@Param("record") TbUserPosition record, @Param("example") TbUserPositionExample example);

    int updateByPrimaryKeySelective(TbUserPosition record);

    int updateByPrimaryKey(TbUserPosition record);


}

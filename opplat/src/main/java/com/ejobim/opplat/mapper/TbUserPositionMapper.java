package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbUserPosition;
import com.ejobim.opplat.domain.TbUserPositionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbUserPositionMapper {
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
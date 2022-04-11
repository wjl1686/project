package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbLog;
import com.ejobim.opplat.domain.TbLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLogMapper {
    int countByExample(TbLogExample example);

    int deleteByExample(TbLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbLog record);

    int insertSelective(TbLog record);

    List<TbLog> selectByExample(TbLogExample example);

    TbLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbLog record, @Param("example") TbLogExample example);

    int updateByExample(@Param("record") TbLog record, @Param("example") TbLogExample example);

    int updateByPrimaryKeySelective(TbLog record);

    int updateByPrimaryKey(TbLog record);
}
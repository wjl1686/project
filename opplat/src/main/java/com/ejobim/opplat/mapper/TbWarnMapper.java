package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWarn;
import com.ejobim.opplat.domain.TbWarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWarnMapper {
    int countByExample(TbWarnExample example);

    int deleteByExample(TbWarnExample example);

    int deleteByPrimaryKey(String warnNo);

    int insert(TbWarn record);

    int insertSelective(TbWarn record);

    List<TbWarn> selectByExampleWithBLOBs(TbWarnExample example);

    List<TbWarn> selectByExample(TbWarnExample example);

    TbWarn selectByPrimaryKey(String warnNo);

    int updateByExampleSelective(@Param("record") TbWarn record, @Param("example") TbWarnExample example);

    int updateByExampleWithBLOBs(@Param("record") TbWarn record, @Param("example") TbWarnExample example);

    int updateByExample(@Param("record") TbWarn record, @Param("example") TbWarnExample example);

    int updateByPrimaryKeySelective(TbWarn record);

    int updateByPrimaryKeyWithBLOBs(TbWarn record);

    int updateByPrimaryKey(TbWarn record);

    List<TbWarn> findWarnList(String currentTime);
}
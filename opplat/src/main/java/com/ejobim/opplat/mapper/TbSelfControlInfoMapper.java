package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSelfControlInfo;
import com.ejobim.opplat.domain.TbSelfControlInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSelfControlInfoMapper {
    int countByExample(TbSelfControlInfoExample example);

    int deleteByExample(TbSelfControlInfoExample example);

    int deleteByPrimaryKey(String selControlNo);

    int insert(TbSelfControlInfo record);

    int insertSelective(TbSelfControlInfo record);

    List<TbSelfControlInfo> selectByExample(TbSelfControlInfoExample example);

    TbSelfControlInfo selectByPrimaryKey(String selControlNo);

    int updateByExampleSelective(@Param("record") TbSelfControlInfo record, @Param("example") TbSelfControlInfoExample example);

    int updateByExample(@Param("record") TbSelfControlInfo record, @Param("example") TbSelfControlInfoExample example);

    int updateByPrimaryKeySelective(TbSelfControlInfo record);

    int updateByPrimaryKey(TbSelfControlInfo record);
}
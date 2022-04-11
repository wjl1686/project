package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbGroupInfo;
import com.ejobim.opplat.domain.TbGroupInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbGroupInfoMapper {
    int countByExample(TbGroupInfoExample example);

    int deleteByExample(TbGroupInfoExample example);

    int deleteByPrimaryKey(String groupNo);

    int insert(TbGroupInfo record);

    int insertSelective(TbGroupInfo record);

    List<TbGroupInfo> selectByExample(TbGroupInfoExample example);

    TbGroupInfo selectByPrimaryKey(String groupNo);

    int updateByExampleSelective(@Param("record") TbGroupInfo record, @Param("example") TbGroupInfoExample example);

    int updateByExample(@Param("record") TbGroupInfo record, @Param("example") TbGroupInfoExample example);

    int updateByPrimaryKeySelective(TbGroupInfo record);

    int updateByPrimaryKey(TbGroupInfo record);

    List<TbGroupInfo>  getTbGroupInfoList(TbGroupInfo tbGroupInfo);
}
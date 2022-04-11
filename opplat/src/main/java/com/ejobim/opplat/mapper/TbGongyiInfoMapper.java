package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbGongyiInfo;
import com.ejobim.opplat.domain.TbGongyiInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbGongyiInfoMapper {
    int countByExample(TbGongyiInfoExample example);

    int deleteByExample(TbGongyiInfoExample example);

    int deleteByPrimaryKey(String gongyiNo);

    int insert(TbGongyiInfo record);

    int insertSelective(TbGongyiInfo record);

    List<TbGongyiInfo> selectByExample(TbGongyiInfoExample example);

    TbGongyiInfo selectByPrimaryKey(String gongyiNo);

    int updateByExampleSelective(@Param("record") TbGongyiInfo record, @Param("example") TbGongyiInfoExample example);

    int updateByExample(@Param("record") TbGongyiInfo record, @Param("example") TbGongyiInfoExample example);

    int updateByPrimaryKeySelective(TbGongyiInfo record);

    int updateByPrimaryKey(TbGongyiInfo record);

    List<TbGongyiInfo> getCheckGongyiList(TbGongyiInfo gongyiInfo);
}
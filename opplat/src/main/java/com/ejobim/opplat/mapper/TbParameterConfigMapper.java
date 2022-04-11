package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbParameterConfig;
import com.ejobim.opplat.domain.TbParameterConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbParameterConfigMapper {
    int countByExample(TbParameterConfigExample example);

    int deleteByExample(TbParameterConfigExample example);

    int deleteByPrimaryKey(String paramNo);

    int insert(TbParameterConfig record);

    int insertSelective(TbParameterConfig record);

    List<TbParameterConfig> selectByExample(TbParameterConfigExample example);

    TbParameterConfig selectByPrimaryKey(String paramNo);

    int updateByExampleSelective(@Param("record") TbParameterConfig record, @Param("example") TbParameterConfigExample example);

    int updateByExample(@Param("record") TbParameterConfig record, @Param("example") TbParameterConfigExample example);

    int updateByPrimaryKeySelective(TbParameterConfig record);

    int updateByPrimaryKey(TbParameterConfig record);
}
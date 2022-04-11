package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbParameterConfigExtend;
import com.ejobim.opplat.domain.TbParameterConfigExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbParameterConfigExtendMapper {
    int countByExample(TbParameterConfigExtendExample example);

    int deleteByExample(TbParameterConfigExtendExample example);

    int deleteByPrimaryKey(String extendNo);

    int insert(TbParameterConfigExtend record);

    int insertSelective(TbParameterConfigExtend record);

    List<TbParameterConfigExtend> selectByExample(TbParameterConfigExtendExample example);

    TbParameterConfigExtend selectByPrimaryKey(String extendNo);

    int updateByExampleSelective(@Param("record") TbParameterConfigExtend record, @Param("example") TbParameterConfigExtendExample example);

    int updateByExample(@Param("record") TbParameterConfigExtend record, @Param("example") TbParameterConfigExtendExample example);

    int updateByPrimaryKeySelective(TbParameterConfigExtend record);

    int updateByPrimaryKey(TbParameterConfigExtend record);
}
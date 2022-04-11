package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TDict;
import com.ejobim.opplat.domain.TDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TDictMapper {
    int countByExample(TDictExample example);

    int deleteByExample(TDictExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(TDict record);

    int insertSelective(TDict record);

    List<TDict> selectByExample(TDictExample example);

    TDict selectByPrimaryKey(Long dictId);

    int updateByExampleSelective(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByExample(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByPrimaryKeySelective(TDict record);

    int updateByPrimaryKey(TDict record);
}
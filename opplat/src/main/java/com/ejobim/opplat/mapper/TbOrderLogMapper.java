package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbOrderLog;
import com.ejobim.opplat.domain.TbOrderLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbOrderLogMapper {
    int countByExample(TbOrderLogExample example);

    int deleteByExample(TbOrderLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOrderLog record);

    int insertSelective(TbOrderLog record);

    List<TbOrderLog> selectByExample(TbOrderLogExample example);

    TbOrderLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOrderLog record, @Param("example") TbOrderLogExample example);

    int updateByExample(@Param("record") TbOrderLog record, @Param("example") TbOrderLogExample example);

    int updateByPrimaryKeySelective(TbOrderLog record);

    int updateByPrimaryKey(TbOrderLog record);
}
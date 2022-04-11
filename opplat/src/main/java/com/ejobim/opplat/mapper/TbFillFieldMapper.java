package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFillField;
import com.ejobim.opplat.domain.TbFillFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFillFieldMapper {
    int countByExample(TbFillFieldExample example);

    int deleteByExample(TbFillFieldExample example);

    int deleteByPrimaryKey(String fieldNo);

    int insert(TbFillField record);

    int insertSelective(TbFillField record);

    List<TbFillField> selectByExample(TbFillFieldExample example);

    TbFillField selectByPrimaryKey(String fieldNo);

    int updateByExampleSelective(@Param("record") TbFillField record, @Param("example") TbFillFieldExample example);

    int updateByExample(@Param("record") TbFillField record, @Param("example") TbFillFieldExample example);

    int updateByPrimaryKeySelective(TbFillField record);

    int updateByPrimaryKey(TbFillField record);
}
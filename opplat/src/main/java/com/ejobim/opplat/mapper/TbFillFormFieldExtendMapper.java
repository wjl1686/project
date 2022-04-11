package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFillFormFieldExtend;
import com.ejobim.opplat.domain.TbFillFormFieldExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFillFormFieldExtendMapper {
    int countByExample(TbFillFormFieldExtendExample example);

    int deleteByExample(TbFillFormFieldExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFillFormFieldExtend record);

    int insertSelective(TbFillFormFieldExtend record);

    List<TbFillFormFieldExtend> selectByExample(TbFillFormFieldExtendExample example);

    TbFillFormFieldExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFillFormFieldExtend record, @Param("example") TbFillFormFieldExtendExample example);

    int updateByExample(@Param("record") TbFillFormFieldExtend record, @Param("example") TbFillFormFieldExtendExample example);

    int updateByPrimaryKeySelective(TbFillFormFieldExtend record);

    int updateByPrimaryKey(TbFillFormFieldExtend record);

    int deleteTbFillFormFieldExtendByConfigNo(String configNo);
}
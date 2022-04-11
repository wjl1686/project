package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFillFormField;
import com.ejobim.opplat.domain.TbFillFormFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFillFormFieldMapper {
    int countByExample(TbFillFormFieldExample example);

    int deleteByExample(TbFillFormFieldExample example);

    int deleteByPrimaryKey(String configNo);

    int insert(TbFillFormField record);

    int insertBatch(@Param("list") List<TbFillFormField> list);

    int insertSelective(TbFillFormField record);

    List<TbFillFormField> selectByExample(TbFillFormFieldExample example);

    TbFillFormField selectByPrimaryKey(String configNo);

    int updateByExampleSelective(@Param("record") TbFillFormField record, @Param("example") TbFillFormFieldExample example);

    int updateByExample(@Param("record") TbFillFormField record, @Param("example") TbFillFormFieldExample example);

    int updateByPrimaryKeySelective(TbFillFormField record);

    int updateByPrimaryKey(TbFillFormField record);

    List<TbFillFormField> getFieldLists(@Param("uri") String uri,@Param("fieldType") Integer fieldType,@Param("fieldCode") String fieldCode,@Param("fieldName") String fieldName);

    List<TbFillFormField> selectTbFillFormFieldList(TbFillFormField tbFillFormField);

    List<TbFillFormField> getFieldListExtend(TbFillFormField tbFillFormField);

    List<TbFillFormField> getFieldListByFactoryNo(String factoryNo);
}
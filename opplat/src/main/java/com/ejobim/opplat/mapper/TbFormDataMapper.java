package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFormData;
import com.ejobim.opplat.domain.TbFormDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFormDataMapper {
    int countByExample(TbFormDataExample example);

    int deleteByExample(TbFormDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFormData record);

    int insertSelective(TbFormData record);

    List<TbFormData> selectByExample(TbFormDataExample example);

    TbFormData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFormData record, @Param("example") TbFormDataExample example);

    int updateByExample(@Param("record") TbFormData record, @Param("example") TbFormDataExample example);

    int updateByPrimaryKeySelective(TbFormData record);

    int updateByPrimaryKey(TbFormData record);
}
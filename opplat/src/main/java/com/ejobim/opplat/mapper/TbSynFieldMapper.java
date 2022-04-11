package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSynField;
import com.ejobim.opplat.domain.TbSynFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbSynFieldMapper {
    int countByExample(TbSynFieldExample example);

    int deleteByExample(TbSynFieldExample example);

    int deleteByPrimaryKey(String uri);

    int insert(TbSynField record);

    int insertSelective(TbSynField record);

    List<TbSynField> selectByExample(TbSynFieldExample example);

    TbSynField selectByPrimaryKey(String uri);

    int updateByExampleSelective(@Param("record") TbSynField record, @Param("example") TbSynFieldExample example);

    int updateByExample(@Param("record") TbSynField record, @Param("example") TbSynFieldExample example);

    int updateByPrimaryKeySelective(TbSynField record);

    int updateByPrimaryKey(TbSynField record);


}
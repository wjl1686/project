package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbParam;
import com.ejobim.opplat.domain.TbParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbParamMapper {
    int countByExample(TbParamExample example);

    int deleteByExample(TbParamExample example);

    int insert(TbParam record);

    int insertSelective(TbParam record);

    List<TbParam> selectByExample(TbParamExample example);

    int updateByExampleSelective(@Param("record") TbParam record, @Param("example") TbParamExample example);

    int updateByExample(@Param("record") TbParam record, @Param("example") TbParamExample example);

    List<TbParam> selectParamList(TbParam param);
}
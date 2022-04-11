package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbGongyiAdjustExtend;
import com.ejobim.opplat.domain.TbGongyiAdjustExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbGongyiAdjustExtendMapper {
    int countByExample(TbGongyiAdjustExtendExample example);

    int deleteByExample(TbGongyiAdjustExtendExample example);

    int deleteByPrimaryKey(String adExtendNo);

    int insert(TbGongyiAdjustExtend record);

    int insertSelective(TbGongyiAdjustExtend record);

    List<TbGongyiAdjustExtend> selectByExample(TbGongyiAdjustExtendExample example);

    TbGongyiAdjustExtend selectByPrimaryKey(String adExtendNo);

    int updateByExampleSelective(@Param("record") TbGongyiAdjustExtend record, @Param("example") TbGongyiAdjustExtendExample example);

    int updateByExample(@Param("record") TbGongyiAdjustExtend record, @Param("example") TbGongyiAdjustExtendExample example);

    int updateByPrimaryKeySelective(TbGongyiAdjustExtend record);

    int updateByPrimaryKey(TbGongyiAdjustExtend record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbGongyiAdjust;
import com.ejobim.opplat.domain.TbGongyiAdjustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbGongyiAdjustMapper {
    int countByExample(TbGongyiAdjustExample example);

    int deleteByExample(TbGongyiAdjustExample example);

    int deleteByPrimaryKey(String adjustNo);

    int insert(TbGongyiAdjust record);

    int insertSelective(TbGongyiAdjust record);

    List<TbGongyiAdjust> selectByExample(TbGongyiAdjustExample example);

    List<TbGongyiAdjust> selectByFlow(String orgNo, String adjustName,String userCode,Integer plat,boolean getFull);

    TbGongyiAdjust selectByPrimaryKey(String adjustNo);

    int updateByExampleSelective(@Param("record") TbGongyiAdjust record, @Param("example") TbGongyiAdjustExample example);

    int updateByExample(@Param("record") TbGongyiAdjust record, @Param("example") TbGongyiAdjustExample example);

    int updateByPrimaryKeySelective(TbGongyiAdjust record);

    int updateByPrimaryKey(TbGongyiAdjust record);
}
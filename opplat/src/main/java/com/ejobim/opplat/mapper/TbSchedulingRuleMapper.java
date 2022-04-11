package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSchedulingRule;
import com.ejobim.opplat.domain.TbSchedulingRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSchedulingRuleMapper {
    int countByExample(TbSchedulingRuleExample example);

    int deleteByExample(TbSchedulingRuleExample example);

    int deleteByPrimaryKey(String schedulingRuleNo);

    int insert(TbSchedulingRule record);

    int insertSelective(TbSchedulingRule record);

    List<TbSchedulingRule> selectByExample(TbSchedulingRuleExample example);

    TbSchedulingRule selectByPrimaryKey(String schedulingRuleNo);

    int updateByExampleSelective(@Param("record") TbSchedulingRule record, @Param("example") TbSchedulingRuleExample example);

    int updateByExample(@Param("record") TbSchedulingRule record, @Param("example") TbSchedulingRuleExample example);

    int updateByPrimaryKeySelective(TbSchedulingRule record);

    int updateByPrimaryKey(TbSchedulingRule record);
}
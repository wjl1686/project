package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSchedulingPlan;
import com.ejobim.opplat.domain.TbSchedulingPlanDeatail;
import com.ejobim.opplat.domain.TbSchedulingPlanDeatailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbSchedulingPlanDeatailMapper {
    int countByExample(TbSchedulingPlanDeatailExample example);

    int deleteByExample(TbSchedulingPlanDeatailExample example);

    int deleteByPrimaryKey(String schedulingNoDetail);

    int insert(TbSchedulingPlanDeatail record);

    int insertBatch(List<TbSchedulingPlanDeatail> list);

    int insertSelective(TbSchedulingPlanDeatail record);

    List<TbSchedulingPlanDeatail> selectByExample(TbSchedulingPlanDeatailExample example);

    TbSchedulingPlanDeatail selectByPrimaryKey(String schedulingNoDetail);

    int updateByExampleSelective(@Param("record") TbSchedulingPlanDeatail record, @Param("example") TbSchedulingPlanDeatailExample example);

    int updateByExample(@Param("record") TbSchedulingPlanDeatail record, @Param("example") TbSchedulingPlanDeatailExample example);

    int updateByPrimaryKeySelective(TbSchedulingPlanDeatail record);

    int updateByPrimaryKey(TbSchedulingPlanDeatail record);

    List<TbSchedulingPlanDeatail>  selectTbSchedulingPlanDeatailList(TbSchedulingPlanDeatail tbSchedulingPlanDeatail);

    List<TbSchedulingPlanDeatail>   selectTbSchedulingPlanDeatailListByCondition(TbSchedulingPlan tbSchedulingPlan);
    
}
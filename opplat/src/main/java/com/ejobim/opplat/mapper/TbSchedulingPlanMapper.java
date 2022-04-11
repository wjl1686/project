package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSchedulingPlan;
import com.ejobim.opplat.domain.TbSchedulingPlanExample;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.domain.vo.TbSchedulingPlanVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbSchedulingPlanMapper {
    int countByExample(TbSchedulingPlanExample example);

    int deleteByExample(TbSchedulingPlanExample example);

    int deleteByPrimaryKey(String schedulingNo);

    int insert(TbSchedulingPlan record);

    int insertBatch(List<TbSchedulingPlan> list);

    int insertSelective(TbSchedulingPlan record);

    List<TbSchedulingPlan> selectByExample(TbSchedulingPlanExample example);

    TbSchedulingPlan selectByPrimaryKey(String schedulingNo);

    int updateByExampleSelective(@Param("record") TbSchedulingPlan record, @Param("example") TbSchedulingPlanExample example);

    int updateByExample(@Param("record") TbSchedulingPlan record, @Param("example") TbSchedulingPlanExample example);

    int updateByPrimaryKeySelective(TbSchedulingPlan record);

    int updateByPrimaryKey(TbSchedulingPlan record);

    List<TbSchedulingPlan>  selectSchedulingPlanListByConditionApp(TbSchedulingPlanCondition condition);
    
    List<TbSchedulingPlan>  selectSchedulingPlanListByCondition(TbSchedulingPlanCondition condition);

    List<TbSchedulingPlan>  getbSchedulingPlanInfoByTimePoint(TbSchedulingPlanCondition tbSchedulingPlanCondition);

    List<TbSchedulingPlan>   getbSchedulingPlanInfoByTime(TbSchedulingPlanCondition tbSchedulingPlanCondition);


    List<TbSchedulingPlan>  getbSchedulingPlanInfoByUserCodeByDate(TbSchedulingPlanCondition tbSchedulingPlanCondition);

    List<TbSchedulingPlanVo>  getTbSchedulingPlanByApplyUser(TbSchedulingPlanCondition condition);

    List<TbSchedulingPlan>  getTbSchedulingPlanByReviceUser(TbSchedulingPlan plan);

    List<TbSchedulingPlan>  selectSchedulingPlanByTime(TbSchedulingPlan schedulingPlan);

    TbSchedulingPlan  getUserGroupCode(TbSchedulingPlanCondition condition);

    List<TbSchedulingPlan> getbSchedulingPlanInfoByGroupType(TbSchedulingPlanCondition tbSchedulingPlanCondition);

    int  selectSchedulingByCondition(TbSchedulingPlan schedulingPlan);

    /**
     * 目标班组排班和人员信息
     */
    List<TbSchedulingPlan> selectTbSchedulingPlanListByConditionTime(TbSchedulingPlan tbSchedulingPlan);
}
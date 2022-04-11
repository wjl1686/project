package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowInfoExtend;
import com.ejobim.opplat.domain.TbWorkFlowInfoExtendExample;
import java.util.List;

import com.ejobim.opplat.domain.condition.ChooseUserConditon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowInfoExtendMapper {
    int countByExample(TbWorkFlowInfoExtendExample example);

    int deleteByExample(TbWorkFlowInfoExtendExample example);

    int deleteByPrimaryKey(String extendNo);

    int insert(TbWorkFlowInfoExtend record);

    int insertSelective(TbWorkFlowInfoExtend record);

    List<TbWorkFlowInfoExtend> selectByExample(TbWorkFlowInfoExtendExample example);

    TbWorkFlowInfoExtend selectByPrimaryKey(String extendNo);

    int updateByExampleSelective(@Param("record") TbWorkFlowInfoExtend record, @Param("example") TbWorkFlowInfoExtendExample example);

    int updateByExample(@Param("record") TbWorkFlowInfoExtend record, @Param("example") TbWorkFlowInfoExtendExample example);

    int updateByPrimaryKeySelective(TbWorkFlowInfoExtend record);

    int updateByPrimaryKey(TbWorkFlowInfoExtend record);

    String  selectByCondition(ChooseUserConditon conditon);

    TbWorkFlowInfoExtend  selectByConditions (ChooseUserConditon conditon);
}
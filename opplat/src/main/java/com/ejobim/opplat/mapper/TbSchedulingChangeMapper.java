package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSchedulingChange;
import com.ejobim.opplat.domain.TbSchedulingChangeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSchedulingChangeMapper {
    int countByExample(TbSchedulingChangeExample example);

    int deleteByExample(TbSchedulingChangeExample example);

    int deleteByPrimaryKey(String changeNo);

    int insert(TbSchedulingChange record);

    int insertSelective(TbSchedulingChange record);

    List<TbSchedulingChange> selectByExample(TbSchedulingChangeExample example);

    TbSchedulingChange selectByPrimaryKey(String changeNo);

    int updateByExampleSelective(@Param("record") TbSchedulingChange record, @Param("example") TbSchedulingChangeExample example);

    int updateByExample(@Param("record") TbSchedulingChange record, @Param("example") TbSchedulingChangeExample example);

    int updateByPrimaryKeySelective(TbSchedulingChange record);

    int updateByPrimaryKey(TbSchedulingChange record);

    List<TbSchedulingChange>  getTbSchedulingChangeList(TbSchedulingChange tbSchedulingChange);

    TbSchedulingChange  selectByConditin(TbSchedulingChange change);
}
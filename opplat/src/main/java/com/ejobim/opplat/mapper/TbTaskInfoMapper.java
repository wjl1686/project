package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbTaskInfo;
import com.ejobim.opplat.domain.TbTaskInfoExample;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.TbTaskInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbTaskInfoMapper {
    int countByExample(TbTaskInfoExample example);

    int deleteByExample(TbTaskInfoExample example);

    int deleteByPrimaryKey(String taskNo);

    int insert(TbTaskInfo record);

    int insertSelective(TbTaskInfo record);

    List<TbTaskInfo> selectByExample(TbTaskInfoExample example);

    TbTaskInfo selectByPrimaryKey(String taskNo);

    int updateByExampleSelective(@Param("record") TbTaskInfo record, @Param("example") TbTaskInfoExample example);

    int updateByExample(@Param("record") TbTaskInfo record, @Param("example") TbTaskInfoExample example);

    int updateByPrimaryKeySelective(TbTaskInfo record);

    int updateByPrimaryKey(TbTaskInfo record);

    List<TbTaskInfoVo> selectTaskInfoList(TaskInfoCondition condition);

    List<TbTaskInfo> getCurrentMouthTaskInfo();

    List<TbTaskInfo> selectTaskList(TbTaskInfo condition);
    
}

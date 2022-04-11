package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkTaskInfo;
import com.ejobim.opplat.domain.TbWorkTaskInfoExample;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.domain.vo.TbWorkTaskInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TbWorkTaskInfoMapper {
    int countByExample(TbWorkTaskInfoExample example);

    int deleteByExample(TbWorkTaskInfoExample example);

    int deleteByPrimaryKey(String taskNo);

    int insert(TbWorkTaskInfo record);

    int insertSelective(TbWorkTaskInfo record);

    List<TbWorkTaskInfo> selectByExample(TbWorkTaskInfoExample example);

    TbWorkTaskInfo selectByPrimaryKey(String taskNo);

    int updateByExampleSelective(@Param("record") TbWorkTaskInfo record, @Param("example") TbWorkTaskInfoExample example);

    int updateByExample(@Param("record") TbWorkTaskInfo record, @Param("example") TbWorkTaskInfoExample example);

    int updateByPrimaryKeySelective(TbWorkTaskInfo record);

    int updateByPrimaryKey(TbWorkTaskInfo record);

    List<TbWorkTaskInfo>  selectTbWorkTaskInfoListByCondition(TbWorkTaskInfoCondition condition);
    
    List<TbWorkTaskInfo>  selectTbWorkTaskInfoByTime(TbWorkTaskInfoCondition condition);

    List<TbWorkTaskInfoVo>  getTbWorkTaskInfoVoListByUser(TaskInfoCondition condition);

    List<TbWorkTaskInfo>  selectTbWorkTaskInfoByJson(TaskInfoCondition condition);

    List<Map<String,Object>> selectUnFinishTaskList(String factoryNo);
    
    List<TaskVo>  selectTbWorkTaskInfoByJsonNew(TaskInfoCondition condition);

}
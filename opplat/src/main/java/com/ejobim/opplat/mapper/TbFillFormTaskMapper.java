package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFillFormTask;
import com.ejobim.opplat.domain.TbFillFormTaskExample;
import java.util.List;

import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.TbFillFormTaskVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFillFormTaskMapper {
    int countByExample(TbFillFormTaskExample example);

    int deleteByExample(TbFillFormTaskExample example);

    int insert(TbFillFormTask record);

    int insertSelective(TbFillFormTask record);

    List<TbFillFormTask> selectByExample(TbFillFormTaskExample example);

    TbFillFormTask getTbFillFormTaskByKey( @Param("taskNo") String taskNo);

    int updateByExampleSelective(@Param("record") TbFillFormTask record, @Param("example") TbFillFormTaskExample example);

    int updateByExample(@Param("record") TbFillFormTask record, @Param("example") TbFillFormTaskExample example);

    int updateByPrimaryKeySelective(TbFillFormTask record);

    int updateByPrimaryKey(TbFillFormTask record);

    List<TbFillFormTask> selectTbFillFormTaskList(@Param("task") TbFillFormTask tbFillFormTask,@Param("beginTime") String beginTime,
                                                  @Param("endTime") String endTime,@Param("factoryList") List<String> factoryList);


    List<TbFillFormTaskVo>  getTbFillFormTaskListByUser(TaskInfoCondition condition);
}
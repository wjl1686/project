package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.WorkFlowApi;
import com.ejobim.opplat.domain.WorkFlowApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
public interface WorkFlowApiMapper {
    int countByExample(WorkFlowApiExample example);

    int deleteByExample(WorkFlowApiExample example);

    int deleteByPrimaryKey(String apiNo);

    int insert(WorkFlowApi record);

    int insertSelective(WorkFlowApi record);

    List<WorkFlowApi> selectByExample(WorkFlowApiExample example);

    WorkFlowApi selectByPrimaryKey(String apiNo);

    int updateByExampleSelective(@Param("record") WorkFlowApi record, @Param("example") WorkFlowApiExample example);

    int updateByExample(@Param("record") WorkFlowApi record, @Param("example") WorkFlowApiExample example);

    int updateByPrimaryKeySelective(WorkFlowApi record);

    int updateByPrimaryKey(WorkFlowApi record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingTrajectory;
import com.ejobim.opplat.domain.TbRoutingTrajectoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbRoutingTrajectoryMapper {
    int countByExample(TbRoutingTrajectoryExample example);

    int deleteByExample(TbRoutingTrajectoryExample example);

    int deleteByPrimaryKey(String trajeNo);

    int insert(TbRoutingTrajectory record);

    int insertSelective(TbRoutingTrajectory record);

    List<TbRoutingTrajectory> selectByExample(TbRoutingTrajectoryExample example);

    TbRoutingTrajectory selectByPrimaryKey(String trajeNo);

    int updateByExampleSelective(@Param("record") TbRoutingTrajectory record, @Param("example") TbRoutingTrajectoryExample example);

    int updateByExample(@Param("record") TbRoutingTrajectory record, @Param("example") TbRoutingTrajectoryExample example);

    int updateByPrimaryKeySelective(TbRoutingTrajectory record);

    int updateByPrimaryKey(TbRoutingTrajectory record);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbNfcInfo;
import com.ejobim.opplat.domain.TbRoutingLocation;
import com.ejobim.opplat.domain.TbRoutingLocationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TbRoutingLocationMapper {
    int countByExample(TbRoutingLocationExample example);

    int deleteByExample(TbRoutingLocationExample example);

    int deleteByPrimaryKey(String locationNo);

    int insert(TbRoutingLocation record);

    int insertSelective(TbRoutingLocation record);

    List<TbRoutingLocation> selectByExample(TbRoutingLocationExample example);

    TbRoutingLocation selectByPrimaryKey(String locationNo);

    int updateByExampleSelective(@Param("record") TbRoutingLocation record, @Param("example") TbRoutingLocationExample example);

    int updateByExample(@Param("record") TbRoutingLocation record, @Param("example") TbRoutingLocationExample example);

    int updateByPrimaryKeySelective(TbRoutingLocation record);

    int updateByPrimaryKey(TbRoutingLocation record);

    List<TbRoutingLocation>  selectRoutingLocationList(@Param("list") String[] list);

    TbRoutingLocation getTaskRoutingLocationByNfcNo(TbRoutingLocation tbRoutingLocation);

    List<Map<String, String>>  getNfcRoutingLocationList(TbNfcInfo tbNfcInfo);

    List<TbRoutingLocation> selectCheckRoutingLocationList(TbRoutingLocation routingLocation);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingModelExtend;
import com.ejobim.opplat.domain.TbRoutingModelExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbRoutingModelExtendMapper {
    int countByExample(TbRoutingModelExtendExample example);

    int deleteByExample(TbRoutingModelExtendExample example);

    int deleteByPrimaryKey(String routingModelExtendNo);

    int insert(TbRoutingModelExtend record);

    int insertBatch(List<TbRoutingModelExtend> list);

    int insertSelective(TbRoutingModelExtend record);

    List<TbRoutingModelExtend> selectByExample(TbRoutingModelExtendExample example);

    TbRoutingModelExtend selectByPrimaryKey(String routingModelExtendNo);

    int updateByExampleSelective(@Param("record") TbRoutingModelExtend record, @Param("example") TbRoutingModelExtendExample example);

    int updateByExample(@Param("record") TbRoutingModelExtend record, @Param("example") TbRoutingModelExtendExample example);

    int updateByPrimaryKeySelective(TbRoutingModelExtend record);

    int updateByPrimaryKey(TbRoutingModelExtend record);

    /**
     * 根据巡检模式NO 获取
     * @param modelNo
     * @return
     */
    List<String> getLocationList(String modelNo);

    List<String> getRoutingModelList(String locationNo);
}
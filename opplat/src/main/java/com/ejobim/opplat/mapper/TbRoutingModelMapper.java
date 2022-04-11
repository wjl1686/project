package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingModel;
import com.ejobim.opplat.domain.TbRoutingModelExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbRoutingModelMapper {
    int countByExample(TbRoutingModelExample example);

    int deleteByExample(TbRoutingModelExample example);

    int deleteByPrimaryKey(String routingModelNo);

    int insert(TbRoutingModel record);

    int insertSelective(TbRoutingModel record);

    List<TbRoutingModel> selectByExample(TbRoutingModelExample example);

    TbRoutingModel selectByPrimaryKey(String routingModelNo);

    int updateByExampleSelective(@Param("record") TbRoutingModel record, @Param("example") TbRoutingModelExample example);

    int updateByExample(@Param("record") TbRoutingModel record, @Param("example") TbRoutingModelExample example);

    int updateByPrimaryKeySelective(TbRoutingModel record);

    int updateByPrimaryKey(TbRoutingModel record);
}
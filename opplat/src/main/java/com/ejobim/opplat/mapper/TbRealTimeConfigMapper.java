package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRealTimeConfig;
import com.ejobim.opplat.domain.TbRealTimeConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbRealTimeConfigMapper {
    int countByExample(TbRealTimeConfigExample example);

    int deleteByExample(TbRealTimeConfigExample example);

    int insert(TbRealTimeConfig record);

    int insertSelective(TbRealTimeConfig record);

    List<TbRealTimeConfig> selectByExample(TbRealTimeConfigExample example);

    int updateByExampleSelective(@Param("record") TbRealTimeConfig record, @Param("example") TbRealTimeConfigExample example);

    int updateByExample(@Param("record") TbRealTimeConfig record, @Param("example") TbRealTimeConfigExample example);
}
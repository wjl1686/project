package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryDehydrationSystem;
import com.ejobim.opplat.domain.TbFactoryDehydrationSystemExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbFactoryDehydrationSystemMapper {
    int countByExample(TbFactoryDehydrationSystemExample example);

    int deleteByExample(TbFactoryDehydrationSystemExample example);

    int insert(TbFactoryDehydrationSystem record);

    int insertSelective(TbFactoryDehydrationSystem record);

    TbFactoryDehydrationSystem selectByPrimaryKey(String factoryNo);

    List<TbFactoryDehydrationSystem> selectByExample(TbFactoryDehydrationSystemExample example);

    int updateByExampleSelective(@Param("record") TbFactoryDehydrationSystem record, @Param("example") TbFactoryDehydrationSystemExample example);

    int updateByExample(@Param("record") TbFactoryDehydrationSystem record, @Param("example") TbFactoryDehydrationSystemExample example);

    int updateByFactoryNo(@Param("record")TbFactoryDehydrationSystem record);

    List<TbFactoryDehydrationSystem> selectDehyInfoByConds(TbFactoryDehydrationSystem tbFactoryDehydrationSystem);
}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryInfoExtend;
import com.ejobim.opplat.domain.TbFactoryInfoExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbFactoryInfoExtendMapper {
    int countByExample(TbFactoryInfoExtendExample example);

    int deleteByExample(TbFactoryInfoExtendExample example);

    int deleteByPrimaryKey(String factoryNo);

    int insert(TbFactoryInfoExtend record);

    int insertSelective(TbFactoryInfoExtend record);

    List<TbFactoryInfoExtend> selectByExample(TbFactoryInfoExtendExample example);

    TbFactoryInfoExtend selectByPrimaryKey(String factoryNo);

    int updateByExampleSelective(@Param("record") TbFactoryInfoExtend record, @Param("example") TbFactoryInfoExtendExample example);

    int updateByExample(@Param("record") TbFactoryInfoExtend record, @Param("example") TbFactoryInfoExtendExample example);

    int updateByPrimaryKeySelective(TbFactoryInfoExtend record);

    int updateByPrimaryKey(TbFactoryInfoExtend record);
}
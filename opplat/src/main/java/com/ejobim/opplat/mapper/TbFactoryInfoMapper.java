package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbFactoryInfo;
import com.ejobim.opplat.domain.TbFactoryInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbFactoryInfoMapper {
    int countByExample(TbFactoryInfoExample example);

    int deleteByExample(TbFactoryInfoExample example);

    int deleteByPrimaryKey(String factoryNo);

    int insert(TbFactoryInfo record);

    int insertSelective(TbFactoryInfo record);

    List<TbFactoryInfo> selectByExample(TbFactoryInfoExample example);
    /**
     * 根据水厂no获取水厂信息
     * @param factoryNo
     * @return
     */
    TbFactoryInfo selectByPrimaryKey(String factoryNo);
    /**
     * 根据水厂no获取水厂信息list
     * @param factoryNo
     * @return
     */
    List<TbFactoryInfo> selectByPrimaryKeyNew(String factoryNo);

    int updateByExampleSelective(@Param("record") TbFactoryInfo record, @Param("example") TbFactoryInfoExample example);

    int updateByExample(@Param("record") TbFactoryInfo record, @Param("example") TbFactoryInfoExample example);

    int updateByPrimaryKeySelective(TbFactoryInfo record);

    int updateByPrimaryKey(TbFactoryInfo record);

    TbFactoryInfo  selectTbFactoryInfoByName(@Param("factoryName")String factoryName);
}
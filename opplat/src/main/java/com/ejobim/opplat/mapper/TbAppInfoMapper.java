package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAppInfo;
import com.ejobim.opplat.domain.TbAppInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbAppInfoMapper {
    int countByExample(TbAppInfoExample example);

    int deleteByExample(TbAppInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAppInfo record);

    int insertSelective(TbAppInfo record);

    List<TbAppInfo> selectByExample(TbAppInfoExample example);

    TbAppInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAppInfo record, @Param("example") TbAppInfoExample example);

    int updateByExample(@Param("record") TbAppInfo record, @Param("example") TbAppInfoExample example);

    int updateByPrimaryKeySelective(TbAppInfo record);

    int updateByPrimaryKey(TbAppInfo record);
}
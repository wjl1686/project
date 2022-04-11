package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSysUser;
import com.ejobim.opplat.domain.TbSysUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TbSysUserMapper {
    int countByExample(TbSysUserExample example);

    int deleteByExample(TbSysUserExample example);

    int deleteByPrimaryKey(String userNo);

    int insert(TbSysUser record);

    int insertSelective(TbSysUser record);

    List<TbSysUser> selectByExample(TbSysUserExample example);

    TbSysUser selectByPrimaryKey(String userNo);

    int updateByExampleSelective(@Param("record") TbSysUser record, @Param("example") TbSysUserExample example);

    int updateByExample(@Param("record") TbSysUser record, @Param("example") TbSysUserExample example);

    int updateByPrimaryKeySelective(TbSysUser record);

    int updateByPrimaryKey(TbSysUser record);

    List<TbSysUser> getUserLists(TbSysUser tbSysUser);

    List<Map<String, Object>> getUserFactoryList(@Param("orgCodeList") List<String> orgCodeList,@Param("type") Integer type);


}
package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSysRole;
import com.ejobim.opplat.domain.TbSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRoleMapper {
    int countByExample(TbSysRoleExample example);

    int deleteByExample(TbSysRoleExample example);

    int deleteByPrimaryKey(String roleNo);

    int insert(TbSysRole record);

    int insertSelective(TbSysRole record);

    List<TbSysRole> selectByExample(TbSysRoleExample example);

    TbSysRole selectByPrimaryKey(String roleNo);

    int updateByExampleSelective(@Param("record") TbSysRole record, @Param("example") TbSysRoleExample example);

    int updateByExample(@Param("record") TbSysRole record, @Param("example") TbSysRoleExample example);

    int updateByPrimaryKeySelective(TbSysRole record);

    int updateByPrimaryKey(TbSysRole record);

    List<TbSysRole> findUserRole(@Param("userNo") String userNo);
}
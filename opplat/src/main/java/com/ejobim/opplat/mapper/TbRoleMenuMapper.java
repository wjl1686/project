package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoleMenu;
import com.ejobim.opplat.domain.TbRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoleMenuMapper {
    int countByExample(TbRoleMenuExample example);

    int deleteByExample(TbRoleMenuExample example);

    int insert(TbRoleMenu record);

    int insertSelective(TbRoleMenu record);

    List<TbRoleMenu> selectByExample(TbRoleMenuExample example);

    int updateByExampleSelective(@Param("record") TbRoleMenu record, @Param("example") TbRoleMenuExample example);

    int updateByExample(@Param("record") TbRoleMenu record, @Param("example") TbRoleMenuExample example);
}
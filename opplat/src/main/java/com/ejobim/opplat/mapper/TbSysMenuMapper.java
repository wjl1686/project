package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSysMenu;
import com.ejobim.opplat.domain.TbSysMenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xibian
 */
@Component
public interface TbSysMenuMapper {
    int countByExample(TbSysMenuExample example);

    int deleteByExample(TbSysMenuExample example);

    int deleteByPrimaryKey(String menuNo);

    int insert(TbSysMenu record);

    int insertSelective(TbSysMenu record);

    List<TbSysMenu> selectByExample(TbSysMenuExample example);

    TbSysMenu selectByPrimaryKey(String menuNo);

    int updateByExampleSelective(@Param("record") TbSysMenu record, @Param("example") TbSysMenuExample example);

    int updateByExample(@Param("record") TbSysMenu record, @Param("example") TbSysMenuExample example);

    int updateByPrimaryKeySelective(TbSysMenu record);

    int updateByPrimaryKey(TbSysMenu record);

    List<TbSysMenu> selectSysMenuTreeByRoleNo(String roleNo);

    List<TbSysMenu>  selectMenuAllList();

    List<TbSysMenu> selectMenuListByRoleNoList(List<String> list);

    List<TbSysMenu> selectMenuListByRoleNo(@Param("role") String role);
}
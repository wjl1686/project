package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbSysRole;

import java.util.List;

public interface TbSysRoleService {
    int insert(TbSysRole record);

    /**
     * @author wujianlong
     * @date 2019-1-15 13:44:08
     * @Description 添加角色
     * @version 1.0
     * @param sysRole,menuIds
     */
    void addRole(TbSysRole sysRole, String[] menuIds);

    /**
     * @author wujianlong
     * @date 2019-1-15 14:44:08
     * @Description 修改角色
     * @version 1.0
     * @param sysRole,menuIds
     */
    void updateRole(TbSysRole sysRole, String[] menuIds);

    /**
     * @author wujianlong
     * @date 2019-1-15 17:44:08
     * @Description 删除角色
     * @version 1.0
     * @param roles
     */
    void deleteRole(String[] roles);
    /**
     * @author wujianlong
     * @date 2019-1-15 17:55:08
     * @Description 查询角色列表
     * @version 1.0
     * @param tbSysRole
     */
    List<TbSysRole> findRoleList(TbSysRole tbSysRole);
    /**
     * @author wujianlong
     * @date 2019-1-17 17:55:08
     * @Description 根据当前用户userNO 查用户角色信息
     * @version 1.0
     * @param userNo
     */
    List<TbSysRole> findUserRole(String userNo);

    void addRoles(TbSysRole sysRole);

    void updateRoles(TbSysRole sysRole);

    int addRoleLinkMenu(TbSysRole tbSysRole);
}

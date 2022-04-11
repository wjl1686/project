package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbSysMenu;
import com.ejobim.opplat.util.Tree;

import java.util.List;

/**
 * @author wujianlong
 * @Description: 菜单管理
 * @date 2019/1/16 9:34
 */
public interface TbSysMenuService {
    /**
     * @author wujianlong
     * @date 2019-1-14 17:44:08
     * @Description 添加菜单或者按钮
     * @version 1.0
     * @param menu
     */
    void addMenu(TbSysMenu menu);
    /**
     * @author wujianlong
     * @date 2019-1-15 09:44:08
     * @Description 修改菜单或者按钮
     * @version 1.0
     * @param menu
     */
    void updateMenu(TbSysMenu menu);

    /**
     * @author wujianlong
     * @date 2019-1-15 09:55:08
     * @Description 删除菜单或者按钮
     * @version 1.0
     * @param menuIds
     */
    int deleteMeuns(String[] menuIds);

    /**
     * @author wujianlong
     * @date 2019-1-15 10:55:08
     * @Description 查询菜单列表
     * @version 1.0
     * @param menu
     */
    List<TbSysMenu> findMenuList(TbSysMenu menu);

    Tree<TbSysMenu> getSysMenuTree(String roleNo);

    List<TbSysMenu> findNewMenuList(TbSysMenu menu);
}

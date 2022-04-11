package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbSysMenu;
import com.ejobim.opplat.service.TbSysMenuService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 菜单管理
 * @date 2019/1/16 9:32
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/menu")
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbSysMenuService tbSysMenuService;


    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/addMenu")
    @ApiOperation(value = "新增菜单")
    public AjaxObject addMenu(TbSysMenu menu) {
        if(StringUtils.isBlank(menu.getMenuNo())) {
            logger.info("新增菜单参数menu={}", menu);
            String name = "";
            if (TbSysMenu.TYPE_MENU == (menu.getType())) {
                name = "菜单";
            } else {
                name = "按钮";
            }
            try {
                tbSysMenuService.addMenu(menu);
                return AjaxObject.ok("添加成功");
            } catch (Exception e) {
                logger.error("新增{}失败", name, e);
                return AjaxObject.error("新增" + name + "失败，请联系网站管理员！");
            }
        }else{
            logger.info("修改菜单参数menu={}", JSON.toJSONString(menu));
            String name ="";
            if (TbSysMenu.TYPE_MENU==(menu.getType())) {
                name = "菜单";
            } else {
                name = "按钮";
            }
            try {
                this.tbSysMenuService.updateMenu(menu);
                return AjaxObject.ok("修改" + name + "成功！");
            } catch (Exception e) {
                logger.error("修改{}失败", name, e);
                return AjaxObject.error("修改" + name + "失败，请联系网站管理员！");
            }
        }
    }
    /**
     * 删除菜单
     * @param menuIds
     * @return
     */
    @PostMapping("/deleteMenus")
    @ApiOperation(value = "删除菜单")
    public AjaxObject deleteMenus(String[] menuIds) {
        logger.info("删除菜单参数id={}", JSON.toJSONString(menuIds));
        try {
            int i = this.tbSysMenuService.deleteMeuns(menuIds);
            if(i>0){
                return AjaxObject.ok("删除成功！");
            }else{
                return AjaxObject.error("删除失败！");
            }
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            return AjaxObject.error("删除失败，请联系网站管理员！");
        }
    }

    /**
     * 查询菜单列表
     * @param req
     * @param menu 类型 0菜单 1按钮
     * @return
     */
    @GetMapping("/getMenuList")
    @ApiOperation(value = "获取菜单列表")
    public  List<TbSysMenu>  getMenuList(HttpServletRequest req, TbSysMenu menu){
        logger.info("查询菜单列表参数menu={}", JSON.toJSONString(menu));
        List<String> roleList = new ArrayList<>();
        roleList.add("admin");
        menu.setRoleList(roleList);
        logger.info("查询菜单列表参数menu={}", JSON.toJSONString(menu));
        List<TbSysMenu> sysMenus = tbSysMenuService.findMenuList(menu);
        return TreeUtils.getMenuList(sysMenus);
    }

    /**
     * 获取菜单tree
     * @param req 
     * @param roleNo
     * @return
     */
    @RequestMapping(value = "/getSysMenuTree", method = RequestMethod.GET)
    @ApiOperation(value = "获取菜单列表")
    public AjaxObject getSysMenuTree(HttpServletRequest req,String roleNo) {
        Tree<TbSysMenu> tree = tbSysMenuService.getSysMenuTree(roleNo);
        Map map = new HashMap(16);
        map.put("tree", tree);
        return AjaxObject.ok(map);
    }


}

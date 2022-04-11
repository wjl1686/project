package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbSysRole;
import com.ejobim.opplat.service.TbSysRoleService;
import com.ejobim.opplat.util.AjaxObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author wujianlong
 * @Description: 角色管理
 * @date 2019/1/16 9:32
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbSysRoleService tbSysRoleService;
    
    /**
     * 添加角色
     * @param sysRole
     * @param menuIds
     * @return
     */
    @PostMapping("/addRole")
    public AjaxObject addRole(TbSysRole sysRole, String[] menuIds){
        logger.info("新增角色参数role={},关联菜单menuIds={}", JSON.toJSONString(sysRole),menuIds);
        try {
            tbSysRoleService.addRole(sysRole,menuIds);
            return AjaxObject.ok("新增角色成功");
        } catch (Exception e) {
            logger.error("新增角色失败e={}", e);
            return AjaxObject.error("新增角色失败，请联系网站管理员！");
        }
    }

    /**
     * 添加角色/编辑角色
     * @param sysRole
     * @return
     */
    @PostMapping("/addRoles")
    public AjaxObject addRoles(TbSysRole sysRole){
        logger.info("新增角色参数role={}", JSON.toJSONString(sysRole));
            if(StringUtils.isBlank(sysRole.getRoleNo())) {
                //添加
                try {
                    tbSysRoleService.addRoles(sysRole);
                    return AjaxObject.ok("添加成功");
                } catch (Exception e) {
                    logger.error("新增{}失败",  e);
                    return AjaxObject.error("新增失败，请联系网站管理员！");
                }
            }else{
                //编辑
                try {
                    tbSysRoleService.updateRoles(sysRole);
                    return AjaxObject.ok("编辑成功");
                } catch (Exception e) {
                    logger.error("编辑失败",  e);
                    return AjaxObject.error("编辑失败，请联系网站管理员！");
                }
            }
    }

    /**
     * 修改角色
     * @param sysRole
     * @param menuIds
     * @return
     */
    @PostMapping("/updateRole")
    public AjaxObject updateRole(TbSysRole sysRole,String[] menuIds) {
        logger.info("修改角色参数role={},关联菜单menuIds={}", JSON.toJSONString(sysRole),menuIds);
        try {
            tbSysRoleService.updateRole(sysRole, menuIds);
            return AjaxObject.ok("修改角色成功！");
        } catch (Exception e) {
            logger.error("修改角色失败", e);
            return AjaxObject.error("修改角色失败，请联系网站管理员！");
        }
    }

    /**
     * 删除角色
     * @param roles
     * @return
     */
    @PostMapping("/deleteRole")
    public AjaxObject deleteRole(String[] roles) {
        logger.info("删除角色id参数roles={}", roles);
        try {
            tbSysRoleService.deleteRole(roles);
            return AjaxObject.ok("删除角色成功！");
        } catch (Exception e) {
            logger.error("删除角色失败", e);
            return AjaxObject.error("删除角色失败，请联系网站管理员！");
        }
    }

    /**
     * 删除角色
     * @param roles
     * @return
     */
    @PostMapping("/deleteRoles")
    public AjaxObject deleteRoles(String[] roles) {
        logger.info("删除角色id参数roles={}", roles);
        try {
            return AjaxObject.ok("删除角色成功！");
        } catch (Exception e) {
            logger.error("删除角色失败", e);
            return AjaxObject.error("删除角色失败，请联系网站管理员！");
        }
    }

    /**
     * 查询角色列表
     * @param req
     * @param tbSysRole
     * @return
     */
    @GetMapping("/getRoleList")
    @ApiOperation(value = "获取角色列表")
    public AjaxObject getRoleList(HttpServletRequest req, TbSysRole tbSysRole){
        logger.info("查询角色列表参数menu={}", JSON.toJSONString(tbSysRole));
        int pageNum = 1;
        int pageSize = 1000;
        if(StringUtils.isNotBlank( req.getParameter("page"))){
            pageNum =Integer.valueOf(req.getParameter("page"));
            pageSize =Integer.valueOf(req.getParameter("rows"));
        }
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<TbSysRole> sysMenus = tbSysRoleService.findRoleList(tbSysRole);
        PageInfo pageInfo = new PageInfo(sysMenus);
        Map<String,Object> map = new HashMap<>(16);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return AjaxObject.ok(map);
    }

    /**
     * 添加角色关联菜单
     * @param tbSysRole
     * @return
     */
    @PostMapping("/addRoleLinkMenu")
    @ApiOperation(value = "获取数据底稿")
    public AjaxObject addRoleLinkMenu(TbSysRole tbSysRole) {
        logger.info("添加角色关联菜单menu={}", tbSysRole);
        int count = tbSysRoleService.addRoleLinkMenu(tbSysRole);
        return AjaxObject.ok("添加成功");
    }
}

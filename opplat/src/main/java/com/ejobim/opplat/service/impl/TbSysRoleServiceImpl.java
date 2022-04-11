package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbRoleMenu;
import com.ejobim.opplat.domain.TbRoleMenuExample;
import com.ejobim.opplat.domain.TbSysRole;
import com.ejobim.opplat.domain.TbSysRoleExample;
import com.ejobim.opplat.mapper.TbRoleMenuMapper;
import com.ejobim.opplat.mapper.TbSysRoleMapper;
import com.ejobim.opplat.service.TbSysRoleService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * @author wujianlong
 * @Description: 角色管理
 * @date 2019/1/16 9:32
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class TbSysRoleServiceImpl implements TbSysRoleService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbRoleMenuMapper tbRoleMenuMapper;

    @Autowired
    private TbSysRoleMapper tbSysRoleMapper;


    @Override
    public int insert(TbSysRole record) {
        return tbSysRoleMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public void addRole(TbSysRole sysRole, String[] menuIds) {
        logger.info("添加角色表参数,sysRole:{},关联菜单menuIds:{}", JSON.toJSONString(sysRole),menuIds);
        sysRole.setRoleNo(StringTools.getUUID());
        sysRole.setCreateTime(new Date());
        //添加角色表
        tbSysRoleMapper.insertSelective(sysRole);
        //添加角色菜单管理表
        setRoleMenus(sysRole,menuIds);
    }
    private void setRoleMenus(TbSysRole sysRole, String[] menuIds) {
        logger.info("添加角色菜单关联表参数,roleId:{},关联菜单menuIds:{}",sysRole.getRoleNo(),menuIds);
        Arrays.stream(menuIds).forEach(menuId -> {
            TbRoleMenu rm = new TbRoleMenu();
            rm.setMenuNo(menuId);
            rm.setRoleNo(sysRole.getRoleNo());
            tbRoleMenuMapper.insert(rm);
        });
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public void updateRole(TbSysRole sysRole, String[] menuIds) {
        sysRole.setModifyTime(new Date());
        tbSysRoleMapper.updateByPrimaryKeySelective(sysRole);
        //先删除角色菜单关联表信息
        TbRoleMenuExample example = new TbRoleMenuExample();
        example.createCriteria().andMenuNoEqualTo(sysRole.getRoleNo());
        this.tbRoleMenuMapper.deleteByExample(example);
        setRoleMenus(sysRole, menuIds);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public void deleteRole(String[] roles) {
        logger.info("删除角色id参数,ids:{}",roles);
        for (String id:roles) {
            //删除角色表
            tbSysRoleMapper.deleteByPrimaryKey(id);
            //删除角色管理菜单表
            TbRoleMenuExample tbRoleMenuExample = new TbRoleMenuExample();
            tbRoleMenuExample.createCriteria().andRoleNoEqualTo(id);
            tbRoleMenuMapper.deleteByExample(tbRoleMenuExample);
            //删除用户关联角色
          /*  TbUserRoleExample tbUserRoleExample = new TbUserRoleExample();
            tbRoleMenuExample.createCriteria().andRoleNoEqualTo(id);
            tbUserRoleMapper.deleteByExample(tbUserRoleExample);*/

        }
    }

    @Override
    public List<TbSysRole> findRoleList(TbSysRole tbSysRole) {
        logger.info("查询角色列表参数,TbSysRole:{}",JSON.toJSONString(tbSysRole));
        List<TbSysRole> tbSysMenus = new ArrayList<>();
        try {
            TbSysRoleExample example = new TbSysRoleExample();
            if (StringUtils.isNotBlank(tbSysRole.getRoleName())) {
                TbSysRoleExample.Criteria  criteria = example.createCriteria();
                criteria.andRoleNameEqualTo(tbSysRole.getRoleName());
            }
            example.setOrderByClause("create_time");
            tbSysMenus = tbSysRoleMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取角色列表失败", e);
        }
        return tbSysMenus;
    }

    @Override
    public List<TbSysRole> findUserRole(String userNo) {
        return tbSysRoleMapper.findUserRole(userNo);
    }

    @Override
    public void addRoles(TbSysRole sysRole) {
        logger.info("添加角色表参数,sysRole:{}", JSON.toJSONString(sysRole));
        sysRole.setRoleNo(StringTools.getUUID());
        sysRole.setCreateTime(new Date());
        //添加角色表
        tbSysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public void updateRoles(TbSysRole sysRole) {
        sysRole.setModifyTime(new Date());
        tbSysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public int addRoleLinkMenu(TbSysRole tbSysRole) {
        //删除逻辑
        TbRoleMenuExample tbRoleMenuExample = new TbRoleMenuExample();
        TbRoleMenuExample.Criteria criteria = tbRoleMenuExample.createCriteria();
        criteria.andRoleNoEqualTo(tbSysRole.getRoleNo());
        tbRoleMenuMapper.deleteByExample(tbRoleMenuExample);
        int flag= 0;
        String menuIds = tbSysRole.getMenuIds();
        String[] split = menuIds.split(",");
        for (String menuNo : split) {
            TbRoleMenu tbRoleMenu = new TbRoleMenu();
            tbRoleMenu.setMenuNo(menuNo);
            tbRoleMenu.setRoleNo(tbSysRole.getRoleNo());
            flag = tbRoleMenuMapper.insertSelective(tbRoleMenu);
        }
        return flag;
    }
}

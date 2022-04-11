package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbRoleMenu;
import com.ejobim.opplat.domain.TbRoleMenuExample;
import com.ejobim.opplat.domain.TbSysMenu;
import com.ejobim.opplat.domain.TbSysMenuExample;
import com.ejobim.opplat.mapper.TbRoleMenuMapper;
import com.ejobim.opplat.mapper.TbSysMenuMapper;
import com.ejobim.opplat.service.TbSysMenuService;
import com.ejobim.opplat.util.StringTools;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wujianlong
 * @Description: 菜单管理
 * @date 2019/1/16 9:32
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TbSysMenuServiceImpl implements TbSysMenuService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbSysMenuMapper tbSysMenuMapper;

    @Autowired
    private TbRoleMenuMapper tbRoleMenuMapper;

    @Override
    public void addMenu(TbSysMenu menu) {
        logger.info("添加菜单参数,TbSysMenu:{}", JSON.toJSONString(menu));
        menu.setMenuNo(StringTools.getUUID());
        menu.setCreateTime(new Date());
        menu.setModifyTime(new Date());
        if (menu.getParentId() == null || "".equals(menu.getParentId())){
            menu.setParentId("0");
        }
        if (TbSysMenu.TYPE_BUTTON==(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        tbSysMenuMapper.insertSelective(menu);
    }

    @Override
    public void updateMenu(TbSysMenu menu) {
        logger.info("修改菜单参数,TbSysMenu:{}",JSON.toJSONString(menu));
        menu.setModifyTime(new Date());
        if (menu.getParentId() == null) {
            menu.setParentId("0");
        }
        if (TbSysMenu.TYPE_BUTTON==(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        tbSysMenuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int deleteMeuns(String[] menuIds) {
        int i =0;
        logger.info("删除菜单id参数,ids:{}",JSON.toJSONString(menuIds));
        for (String id:menuIds) {
            //通过id查询一下
            TbRoleMenuExample tbRoleMenuExample = new TbRoleMenuExample();
            TbRoleMenuExample.Criteria  criteria = tbRoleMenuExample.createCriteria();
            criteria.andMenuNoEqualTo(id);
//            List<TbRoleMenu> tbRoleMenus = tbRoleMenuMapper.selectByExample(tbRoleMenuExample);
//            for(int i=0;i<tbRoleMenus.size();i++)
//                tbSysMenuMapper.deleteByPrimaryKey(tbRoleMenus.get(i));
//            }
            tbSysMenuMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public List<TbSysMenu> findMenuList(TbSysMenu menu) {
        logger.info("查询菜单列表参数,TbSysMenu:{}",JSON.toJSONString(menu));
        List<TbSysMenu> tbSysMenus = new ArrayList<>();

        try {
            TbSysMenuExample example = new TbSysMenuExample();
            if (StringUtils.isNotBlank(menu.getMenuName())) {
                TbSysMenuExample.Criteria  criteria = example.createCriteria();
                criteria.andMenuNameEqualTo(menu.getMenuName());
            }
            if (StringUtils.isNotBlank(menu.getParentId())) {
                TbSysMenuExample.Criteria  criteria = example.createCriteria();
                criteria.andParentIdEqualTo(menu.getParentId());
            }
            if(menu.getType()!=null){
                TbSysMenuExample.Criteria  criteria = example.createCriteria();
                criteria.andTypeEqualTo(menu.getType());
            }
            example.setOrderByClause("sort");
            tbSysMenus = tbSysMenuMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取菜单信息失败", e);
        }
        return tbSysMenus;
    }

    @Override
    public Tree<TbSysMenu> getSysMenuTree(String roleNo) {
        TbSysMenuExample example = new TbSysMenuExample();
        TbSysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0);
        List<TbSysMenu> tbSysMenuAllList = tbSysMenuMapper.selectByExample(example);
        List<TbSysMenu> tbSysMenusPartList = tbSysMenuMapper.selectSysMenuTreeByRoleNo(roleNo);
        if(tbSysMenusPartList!=null && tbSysMenusPartList.size()>0){
        StringBuffer strBu = new StringBuffer();
        for (int i = 0; i < tbSysMenusPartList.size(); i ++) {
            strBu.append(tbSysMenusPartList.get(i).getMenuNo() + ",");
        }

        for (int i = 0; i < tbSysMenuAllList.size(); i ++) {
            if (strBu.toString().contains(tbSysMenuAllList.get(i).getMenuNo())) {
                if("0".equals(tbSysMenuAllList.get(i).getParentId())){
                    tbSysMenuAllList.get(i).setChecked(false);
                }else{
                    boolean flag = true;
                    for (TbSysMenu tbSysMenu : tbSysMenuAllList) {
                        if(tbSysMenuAllList.get(i).getMenuNo().equals(tbSysMenu.getParentId())){
                            tbSysMenuAllList.get(i).setChecked(false);
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        tbSysMenuAllList.get(i).setChecked(true);
                    }
                }
            } else {
                tbSysMenuAllList.get(i).setChecked(false);
            }
        }
        }
        List<Tree<TbSysMenu>> trees = new ArrayList<>();
        buildTrees(trees,tbSysMenuAllList);
        return TreeUtils.build(trees);
    }
    private void buildTrees(List<Tree<TbSysMenu>> trees, List<TbSysMenu> tbSynObjects) {
        tbSynObjects.forEach(menu -> {
            Tree<TbSysMenu> tree = new Tree<>();
            tree.setId(menu.getMenuNo()==null?null:menu.getMenuNo().toString());
            tree.setParentId(menu.getParentId()==null?null:menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            tree.setChecked(menu.isChecked());
            trees.add(tree);
        });
    }

    @Override
    public List<TbSysMenu> findNewMenuList(TbSysMenu menu) {
        List<TbSysMenu> tbSysMenus = new ArrayList<>();
        List<String> roleList = menu.getRoleList();
        tbSysMenus =tbSysMenuMapper.selectMenuListByRoleNoList(roleList);
        return tbSysMenus;
    }
}

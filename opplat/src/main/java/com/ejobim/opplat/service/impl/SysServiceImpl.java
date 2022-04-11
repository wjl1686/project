package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbOrgMapper;
import com.ejobim.opplat.mapper.TbRoleMapper;
import com.ejobim.opplat.mapper.TbUserMapper;
import com.ejobim.opplat.mapper.TbUserOrgRoleMapper;
import com.ejobim.opplat.service.SysService;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysServiceImpl  implements SysService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbOrgMapper tbOrgMapper;

    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private TbUserOrgRoleMapper userOrgRoleMapper;



    @Override
    public Tree<TbOrg> getTbOrgAllTree() {
        TbOrgExample example = new TbOrgExample();
        TbOrgExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(1);
        List<TbOrg> tbOrgs = tbOrgMapper.selectByExample(example);
        List<Tree<TbOrg>> trees = new ArrayList<>();
        buildTrees(trees,tbOrgs);
        return TreeUtils.build(trees);
    }

    private void buildTrees(List<Tree<TbOrg>> trees, List<TbOrg> tbSynObjects) {
        tbSynObjects.forEach(menu -> {
            Tree<TbOrg> tree = new Tree<>();
            tree.setId(menu.getCode());
            tree.setParentId(menu.getParentCode());
            tree.setText(menu.getName());
            tree.setUrl(menu.getUri());
            Map<String,Object> attribute = new HashMap<>();
            attribute.put("noType",menu.getType());
            tree.setAttributes(attribute);
            trees.add(tree);
        });
    }
    
    @Override
    public List<TbUser> getTbUserListS(List<String> codeList,String name) {
        List<TbUser> userListQ = new ArrayList<>();
        Map map = new HashMap(16);
        map.put("name",name);
        map.put("codeList",codeList);
        List<TbUser> userList = tbUserMapper.getTbUserListQ(map);
    /*    Map<String, Object> userMap = new HashMap<>();
        for (TbUser tbUser : userList) {
            if (userMap.get(tbUser.getCode()) != null) {
                TbUser tempUser = new TbUser();
                tempUser = (TbUser) userMap.get(tbUser.getCode());
                tempUser.setRoleName(tempUser.getRoleName() + "," + tbUser.getRoleName());
                userMap.put(tbUser.getCode(), tempUser);
            } else {
                userMap.put(tbUser.getCode(), tbUser);
            }
        }
        for (String key : userMap.keySet()) {
            userListQ.add((TbUser) userMap.get(key));
        }*/
        return userList;
    }

    @Override
    public List<TbRole> getRoleList(TbRole tbRole) {
        return tbRoleMapper.selectRoleList(tbRole);
    }

    @Override
    public List<TbUser> getALLUserList(String type) {
        return tbUserMapper.getALLUserList();
    }

    @Override
    public List<TbUserOrgRole> getUserCodeList(String orgCode) {
        TbUserOrgRoleExample example = new TbUserOrgRoleExample();
        TbUserOrgRoleExample.Criteria criteria = example.createCriteria();
        criteria.andOrgCodeEqualTo(orgCode);
        return userOrgRoleMapper.selectByExample(example);
    }

    @Override
    public List<TbRole> selectRoleNameByUserCode(String code) {
        return userOrgRoleMapper.selectRoleNameByUserCode(code);
    }
}

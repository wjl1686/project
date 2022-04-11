package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbOrg;
import com.ejobim.opplat.domain.TbRole;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.TbUserOrgRole;
import com.ejobim.opplat.util.Tree;

import java.util.List;

public interface SysService {
    /**
     * @param
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 获取组织机构tree
     * @version 1.0
     */
    Tree<TbOrg> getTbOrgAllTree();
    
    /**
     * @param
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 根据组织机构tree查询用户列表
     * @version 1.0
     */
     List<TbUser> getTbUserListS(List<String> codeList,String name);

    /**
     * @param
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 查询角色列表
     * @version 1.0
     */
    List<TbRole> getRoleList(TbRole tbRole);

    List<TbUser> getALLUserList(String type);

    List<TbUserOrgRole> getUserCodeList(String orgCode);

    /**
     * @param
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 根据用户code查询角色列表
     * @version 1.0
     */
    List<TbRole> selectRoleNameByUserCode(String code);
}

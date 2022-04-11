package com.ejobim.opplat.service;


import com.alibaba.fastjson.JSONArray;
import com.ejobim.opplat.domain.TDict;
import com.ejobim.opplat.domain.TbGroupInfo;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.condition.ChooseUserConditon;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;

import java.util.List;
import java.util.Map;

public interface TbSysUseService {

    int addDict(TDict tDict);
    
    /**
     * 根据组织机构ID获取水厂列表
     * @param orgCodeList ,type
     * @return
     */
    List<Map<String,Object>> getUserFactoryList(List<String> orgCodeList,Integer type);
    
    TbUser getUserByCode(String userCode);

    JSONArray getUserArray(List<String> userCodeList);

    List<TbUser>  getTbUserLists(TbUser tbUser);

    List<TbUser> getTbUserList(ChooseUserConditon conditon);

    List<TbUser> getTbUserListByRoleCode(String orgCode,List<String> roleCodes);

    List<TbUser> getTbUserListByRoleCode(String orgCode,String role);

    List<TbUser> getFactoryUserListByRoleCode(String factoryNo,List<String> roleCodes);

    List<TbUser> getTbUserListByFactoryNo(TbGroupInfo tbGroupInfo);

    /**
     * 根据组织机构ID和设备经理code 查询设备经理用户/或者水厂经理
     * @param condition
     * @return
     */
    List<TbUser>  getTbEquipMangerUserListByFactoryUri(TbWorkTaskInfoCondition condition);

    /**
     * 根据组织机构ID和班组角色
     * @param condition
     * @return
     */
    List<TbUser> getTbEquipBanUserListByFactoryUri(TbWorkTaskInfoCondition condition);
}

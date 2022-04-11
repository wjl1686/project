package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.ChooseUserConditon;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.TbSysUseService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wujianlong
 * @Description: 用户管理
 * @date 2019/1/16 9:40
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,  rollbackFor = Exception.class)
public class TbSysUseServiceImpl  implements TbSysUseService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Autowired
    private TDictMapper tDictMapper;

    @Autowired
    private TbUserMapper tbUserMapper;


    @Autowired
    private TbUserOrgRoleMapper tbUserOrgRoleMapper;

    @Autowired
    private TbWorkFlowInfoExtendMapper tbWorkFlowInfoExtendMapper;

    @Autowired
    private TbFactoryInfoMapper factoryInfoMapper;

    @Autowired
    private TbOrgMapper tbOrgMapper;
    @Override
    public int addDict(TDict tDict) {
        return tDictMapper.insertSelective(tDict);
    }


    @Override
    public List<Map<String, Object>> getUserFactoryList(List<String> orgCodeList,Integer type) {
        return tbSysUserMapper.getUserFactoryList(orgCodeList,type);
    }
    

    @Override
    public TbUser getUserByCode(String userCode) {
        return tbUserMapper.selectByPrimaryKey(userCode);
    }

    /**
     * 根据CODE列表获取用户列表
     * @param userCodeList
     * @return
     */
    @Override
    public JSONArray getUserArray(List<String> userCodeList) {
        JSONArray array = new JSONArray();
        if(userCodeList!=null){
            for(String userCode:userCodeList){
                TbUser user = tbUserMapper.selectByPrimaryKey(userCode);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userCode",user.getCode());
                jsonObject.put("userName",user.getName());
                array.add(jsonObject);
            }
        }
        return array;
    }

    @Override
    public List<TbUser> getTbUserLists(TbUser tbUser) {
        return tbUserMapper.selectTbUserLists(tbUser);
    }

    @Override
    public List<TbUser> getTbUserList(ChooseUserConditon conditon) {
        //查询水厂/或者机构
        List<TbUser> userList = new ArrayList<>();
        TbWorkFlowInfoExtend tbWorkFlowInfoExtend = tbWorkFlowInfoExtendMapper.selectByConditions(conditon);
        if(tbWorkFlowInfoExtend!=null) {
            tbWorkFlowInfoExtend.getRoleList();
            tbWorkFlowInfoExtend.getExtendOrgNo();
            conditon.setOrgCode(tbWorkFlowInfoExtend.getExtendOrgNo());
            conditon.setRoleCode(tbWorkFlowInfoExtend.getRoleList());
            userList = tbUserMapper.selectByCondition(conditon);
        }
        return userList;
    }

    @Override
    public List<TbUser> getTbUserListByRoleCode(String orgCode, List<String> roleCodes) {
        TbUserOrgRoleExample userOrgRoleExample = new TbUserOrgRoleExample();
        TbUserOrgRoleExample.Criteria criteria = userOrgRoleExample.createCriteria();
        if(roleCodes.size()>0){
            criteria.andRoleCodeIn(roleCodes);
        }
        criteria.andOrgCodeEqualTo(orgCode);
        List<TbUserOrgRole> tbUserOrgRoles = tbUserOrgRoleMapper.selectByExample(userOrgRoleExample);
        if(tbUserOrgRoles.size()>0){
            List<String> userCodeList =tbUserOrgRoles.stream().map(TbUserOrgRole::getUserCode).collect(Collectors.toList());
            TbUserExample userExample = new TbUserExample();
            TbUserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andCodeIn(userCodeList);
            return tbUserMapper.selectByExample(userExample);
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public List<TbUser> getTbUserListByRoleCode(String orgCode, String role) {

        TbUserOrgRoleExample userOrgRoleExample = new TbUserOrgRoleExample();
        TbUserOrgRoleExample.Criteria criteria = userOrgRoleExample.createCriteria();
        criteria.andOrgCodeEqualTo(orgCode);
        if(StringUtils.isNotEmpty(role)){
            criteria.andRoleCodeEqualTo(role);
        }

        List<TbUserOrgRole> tbUserOrgRoles = tbUserOrgRoleMapper.selectByExample(userOrgRoleExample);
        if(tbUserOrgRoles.size()>0){
            List<String> userCodeList =tbUserOrgRoles.stream().map(TbUserOrgRole::getUserCode).collect(Collectors.toList());
            TbUserExample userExample = new TbUserExample();
            TbUserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andCodeIn(userCodeList);
            return tbUserMapper.selectByExample(userExample);
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public List<TbUser> getFactoryUserListByRoleCode(String factoryNo, List<String> roleCodes) {
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        if(factoryInfo==null){
            return new ArrayList<>();
        }else{
            TbOrg factoryOrg = tbOrgMapper.selectByUri(factoryInfo.getUri());
            return getTbUserListByRoleCode(factoryOrg.getCode(),roleCodes);
        }
    }


    @Override
    public List<TbUser> getTbUserListByFactoryNo(TbGroupInfo tbGroupInfo) {
        TbOrg tbOrg = tbOrgMapper.selectByUri(tbGroupInfo.getUri());
        if(tbOrg!=null){
            tbGroupInfo.setCode(tbOrg.getCode());
        }
        return tbUserMapper.getTbUserListByFactoryNo(tbGroupInfo);
    }

    @Override
    public List<TbUser> getTbEquipMangerUserListByFactoryUri(TbWorkTaskInfoCondition condition) {
        TbOrg tbOrg = tbOrgMapper.selectByUri(condition.getFactoryUri());
        if(tbOrg!=null){
            condition.setOrgCode(tbOrg.getCode());
        }
        return tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);
    }

    @Override
    public List<TbUser> getTbEquipBanUserListByFactoryUri(TbWorkTaskInfoCondition condition) {
        TbOrg tbOrg = tbOrgMapper.selectByUri(condition.getFactoryUri());
        if(tbOrg!=null){
            condition.setOrgCode(tbOrg.getCode());
        }
        //水厂-运行班长 水厂-设备班长
        //SCYXBZ SCSBBZ
        return tbUserMapper.getTbEquipBanUserListByFactoryUri(condition);
    }
    
}

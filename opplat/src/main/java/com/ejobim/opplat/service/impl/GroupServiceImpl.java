package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.exception.RestException;
import com.ejobim.opplat.mapper.OrgGroupInfoMapper;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.service.GroupService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import java.beans.Transient;
import java.util.List;

/**
 * @author xibian
 */
@Service
public class GroupServiceImpl implements GroupService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String factoryList = "factoryList";

    @Autowired
    OrgGroupInfoMapper orgGroupInfoMapper;

    @Autowired
    private TbFactoryInfoMapper factoryInfoMapper;

    @Override
    public List<OrgGroupInfo> getGroupList(OrgGroupInfo groupInfo) {
        OrgGroupInfoExample example = createExampleFromBean(groupInfo);
        return orgGroupInfoMapper.selectByExample(example);
    }

    /**
     * 组团信息添加或修改
     *
     * @param groupInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = RestException.class)
    public int updateGroup(OrgGroupInfo groupInfo) {

        if (groupInfo.getId() != null) {
            orgGroupInfoMapper.updateByPrimaryKeySelective(groupInfo);

        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("description", groupInfo.getGroupName());
            jsonObject.put("factoryList", new JSONArray());
            groupInfo.setGroupDetailInfo(jsonObject.toString());
            //groupInfo.setGroupNo(StringTools.getUUID());
            orgGroupInfoMapper.insertSelective(groupInfo);
        }
        return Dict.AjaxStatus.YES.getStatusCode();


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateGroupDetail(Integer id, String factoryNo, int updateType) {
        //新增

        if(updateType==1){
           return  addNewFactory(id,factoryNo);
        }else  if(updateType==2){
            return  removeFactory(id,factoryNo);
        }else  if(updateType==3){
            return  setCenterFactory(id,factoryNo);
        }
        return 0;
    }

    /**
     * 新增水厂
     * @param id
     * @param factoryNo
     * @return
     */
    private  int addNewFactory(Integer id, String factoryNo){
        OrgGroupInfo orgGroupInfo = orgGroupInfoMapper.selectByPrimaryKey(id);
        JSONObject detailInfo = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        JSONObject newFactory = new JSONObject();
        newFactory.put("uri",factoryInfo.getUri());
        newFactory.put("factoryNo", factoryInfo.getFactoryNo());
        newFactory.put("factoryName", factoryInfo.getFactoryName());
        String groupNo = orgGroupInfo.getGroupNo();
        if(detailInfo.getJSONArray(factoryList).size()==0){
            groupNo = factoryInfo.getFactoryNo();
            newFactory.put("isMain",1);
            orgGroupInfo.setGroupNo(groupNo);
        }else{
            newFactory.put("isMain",0);
        }
        factoryInfo.setOrgGroupNo(groupNo);

        factoryInfoMapper.updateByPrimaryKeySelective(factoryInfo);
        detailInfo.getJSONArray(factoryList).add(newFactory);
        orgGroupInfo.setGroupDetailInfo(detailInfo.toString());
        orgGroupInfoMapper.updateByPrimaryKeySelective(orgGroupInfo);
        return Dict.AjaxStatus.YES.getStatusCode();
    }

    /**
     * 从组团移除水厂
     * @param id
     * @param factoryNo
     * @return
     */
    private  int removeFactory(Integer id, String factoryNo){
        OrgGroupInfo orgGroupInfo = orgGroupInfoMapper.selectByPrimaryKey(id);
        JSONObject detailInfo = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        JSONArray factoryArray = detailInfo.getJSONArray(factoryList);

        for(int i=0;i<factoryArray.size();i++){
            if(factoryNo.equals(factoryArray.getJSONObject(i).getString("factoryNo"))){
                factoryArray.remove(i);
                break;
            }
        }
        factoryInfo.setOrgGroupNo("");
        factoryInfoMapper.updateByPrimaryKeySelective(factoryInfo);

        orgGroupInfo.setGroupDetailInfo(detailInfo.toString());
        orgGroupInfoMapper.updateByPrimaryKeySelective(orgGroupInfo);

        return Dict.AjaxStatus.YES.getStatusCode();
    }


    /**
     * 设置中心水厂
     * @param id
     * @param factoryNo
     * @return
     */
    private  int setCenterFactory(Integer id, String factoryNo){
        OrgGroupInfo orgGroupInfo = orgGroupInfoMapper.selectByPrimaryKey(id);
        JSONObject detailInfo = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());

        JSONArray factoryArray = detailInfo.getJSONArray(factoryList);

        for(int i=0;i<factoryArray.size();i++){
            if(factoryNo.equals(factoryArray.getJSONObject(i).getString("factoryNo"))){
                factoryArray.getJSONObject(i).put("isMain",1);
            }else{
                factoryArray.getJSONObject(i).put("isMain",0);
            }
            TbFactoryInfo factoryInfo = new TbFactoryInfo();
            factoryInfo.setFactoryNo(factoryArray.getJSONObject(i).getString("factoryNo"));
            factoryInfo.setOrgGroupNo(factoryNo);
            factoryInfoMapper.updateByPrimaryKeySelective(factoryInfo);
        }
        orgGroupInfo.setGroupDetailInfo(detailInfo.toString());
        orgGroupInfoMapper.updateByPrimaryKeySelective(orgGroupInfo);

        return Dict.AjaxStatus.YES.getStatusCode();
    }

    /**
     * 检查组成水厂信息
     *
     * @param newGroupInfo
     */
    private String freshFactoryInfo(OrgGroupInfo newGroupInfo) {
        OrgGroupInfo oldGroupInfo = orgGroupInfoMapper.selectByPrimaryKey(newGroupInfo.getId());
        JSONObject oldDetailInfo = JSONObject.parseObject(oldGroupInfo.getGroupDetailInfo().toString());
        JSONObject newDetailInfo = JSONObject.parseObject(newGroupInfo.getGroupDetailInfo().toString());
        JSONArray oldArray = oldDetailInfo.getJSONArray("factoryList");
        JSONArray newArray = newDetailInfo.getJSONArray("factoryList");
        String groupNo = null;


        /**
         * 双重循环  获取新加入的水厂 为新加入水厂的加入组团编号
         */
        if(oldArray.size()==0){
            groupNo = newArray.getJSONObject(0).getString("factoryNo");
            newArray.getJSONObject(0).put("isMain",1);
            newGroupInfo.setGroupDetailInfo(newDetailInfo.toString());
            setFactoryGroupInfo(groupNo, groupNo);
        }else{
            for (int i = 0; i < newArray.size(); i++) {
                JSONObject factoryInfo = newArray.getJSONObject(i);
                //获取中心水厂 返回中心水厂的水厂编号
                if (factoryInfo.containsKey("isMain") && factoryInfo.getIntValue("isMain") == 1) {
                    groupNo = factoryInfo.getString("factoryNo");
                }
            }

            for (int i = 0; i < newArray.size(); i++) {
                JSONObject factoryInfo = newArray.getJSONObject(i);

                boolean noContain = true;
                for (int j = 0; j < oldArray.size(); j++) {
                    if (oldArray.getJSONObject(j).getString("factoryNo").equals(factoryInfo.getString("factoryNo"))) {
                        noContain = false;
                        break;
                    }
                }
                if (noContain) {
                    setFactoryGroupInfo(factoryInfo.getString("factoryNo"), groupNo);
                }
            }

            /**
             * 双重循环  获取被删除掉的水厂编号 移除删除掉水厂的组团属性
             */
            for (int i = 0; i < oldArray.size(); i++) {
                JSONObject factoryInfo = oldArray.getJSONObject(i);
                boolean noContain = true;
                for (int j = 0; j < newArray.size(); j++) {
                    if (oldArray.getJSONObject(j).getString("factoryNo").equals(factoryInfo.getString("factoryNo"))) {
                        noContain = false;
                        break;
                    }
                }
                if (noContain) {
                    setFactoryGroupInfo(factoryInfo.getString("factoryNo"), "");
                }
            }
        }

        return groupNo;
    }


    /**
     * 设置水厂的组团信息
     */
    private void setFactoryGroupInfo(String factoryNo, String groupNo) {
        TbFactoryInfo factoryInfo = new TbFactoryInfo();
        factoryInfo.setOrgGroupNo(groupNo);
        factoryInfo.setFactoryNo(factoryNo);
        factoryInfoMapper.updateByPrimaryKeySelective(factoryInfo);
    }


    private OrgGroupInfoExample createExampleFromBean(OrgGroupInfo groupInfo) {
        OrgGroupInfoExample groupInfoExample = new OrgGroupInfoExample();
        groupInfoExample.setOrderByClause("id");
        OrgGroupInfoExample.Criteria criteria = groupInfoExample.createCriteria();
        if (StringUtils.isNotEmpty(groupInfo.getGroupNo())) {
            criteria.andGroupNoEqualTo(groupInfo.getGroupNo());
        }
        if (StringUtils.isNotEmpty(groupInfo.getGroupName())) {
            criteria.andGroupNameEqualTo(groupInfo.getGroupName());
        }
        return groupInfoExample;
    }




}

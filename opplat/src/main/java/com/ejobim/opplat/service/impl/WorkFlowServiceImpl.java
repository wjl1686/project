package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.service.MaintainService;
import com.ejobim.opplat.service.WorkFlowService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.ejobim.opplat.common.Dict.DELETE_NO;
import static com.ejobim.opplat.common.Dict.DELETE_YES;

/**
 * @author  xibian
 */
@Service
public class WorkFlowServiceImpl implements WorkFlowService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    TbWorkFlowInfoMapper workFlowInfoMapper;
    TbWorkFlowConfigMapper workFlowConfigMapper;
    TbWorkFlowConfigDetailMapper workFlowConfigDetailMapper;
    TbWorkFlowConfigDetailExtendMapper workFlowConfigDetailExtendMapper;
    TbWorkFlowMapper workFlowMapper;
    TbWorkFlowExtendMapper workFlowExtendMapper;
    TbUserMapper userMapper;
    WorkFlowApiMapper workFlowApiMapper;

    @Autowired
    MaintainService baseMaintainService;


    @Autowired
    public WorkFlowServiceImpl(TbWorkFlowInfoMapper workFlowInfoMapper,TbWorkFlowConfigMapper workFlowConfigMapper
            ,TbWorkFlowConfigDetailMapper workFlowConfigDetailMapper,TbWorkFlowConfigDetailExtendMapper workFlowConfigDetailExtendMapper
            ,TbWorkFlowMapper workFlowMapper,TbWorkFlowExtendMapper workFlowExtendMapper ,TbUserMapper userMapper,WorkFlowApiMapper workFlowApiMapper)
    {
        this.workFlowInfoMapper = workFlowInfoMapper;
        this.workFlowConfigMapper = workFlowConfigMapper;
        this.workFlowConfigDetailMapper = workFlowConfigDetailMapper;
        this.workFlowConfigDetailExtendMapper = workFlowConfigDetailExtendMapper;
        this.workFlowMapper = workFlowMapper;
        this.workFlowExtendMapper = workFlowExtendMapper;
        this.userMapper = userMapper;
        this.workFlowApiMapper = workFlowApiMapper;
    }

    /**
     * 获取工作流列表
     * @param workFlowInfo
     * @return
     */
    @Override
    public List<TbWorkFlowInfo> getWorkFlowList(TbWorkFlowInfo workFlowInfo) {
        TbWorkFlowInfoExample example = new TbWorkFlowInfoExample();
        TbWorkFlowInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(workFlowInfo.getOrgNo())){
            criteria.andOrgNoEqualTo(workFlowInfo.getOrgNo());
        }
        if(StringUtils.isNotEmpty(workFlowInfo.getFlowName())){
            criteria.andFlowNameLike("%" + workFlowInfo.getFlowName() + "%");
        }


        return workFlowInfoMapper.selectByExample(example);
    }

    /**
     * 获取工作流流程表
     * @param workFlowConfig
     * @return
     */
    @Override
    public List<TbWorkFlowConfig> getWorkFlowConfigList(TbWorkFlowConfig workFlowConfig) {
        TbWorkFlowConfigExample example = new TbWorkFlowConfigExample();
        TbWorkFlowConfigExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(workFlowConfig.getOrgNo())){
            criteria.andOrgNoEqualTo(workFlowConfig.getOrgNo());
        }

        if(StringUtils.isNotEmpty(workFlowConfig.getFlowName())){
            criteria.andFlowNameLike("%" + workFlowConfig.getFlowName() + "%");
        }
        if(StringUtils.isNotEmpty(workFlowConfig.getFlowCode())){
            criteria.andFlowCodeEqualTo(workFlowConfig.getFlowCode());
        }
        return workFlowConfigMapper.selectByExample(example);
    }

    /**
     * 工作流流程表单
     * @param workFlowConfigDetail
     * @return
     */
    @Override
    public List<TbWorkFlowConfigDetail> getWorkFlowDetailList(TbWorkFlowConfigDetail workFlowConfigDetail) {
        TbWorkFlowConfigDetailExample example = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteria = example.createCriteria();
        criteria.andConfigNoEqualTo(workFlowConfigDetail.getConfigNo());
        if(StringUtils.isNotEmpty(workFlowConfigDetail.getNodeCode())){
            criteria.andNodeCodeEqualTo(workFlowConfigDetail.getNodeCode());
        }
        if(workFlowConfigDetail.getNodeSort()!=null){
            criteria.andNodeSortEqualTo(workFlowConfigDetail.getNodeSort());
        }
        example.setOrderByClause(" node_sort ");
        return workFlowConfigDetailMapper.selectByExample(example);
    }

    /**
     * 共用方法获取步骤详情
     * @param workFlowService
     * @param workFlow
     * @param flowNo
     * @param extendNoList
     * @return
     */
    private List getDetailInfo(IWorkFlowDetailService workFlowService, TbWorkFlow workFlow, String flowNo, List<String> extendNoList){

        Object detailInfo = workFlowService.getDetailInfoByFlowNo(flowNo);
        workFlow.setDetailInfo(detailInfo);
        List list = workFlowService.getExtendListByExtendNo(extendNoList);
        return list;
    }

    @Override
    public TbWorkFlowConfig getWorkFlowConfigByCode(String orgNo, String flowCode) {
        TbWorkFlowConfigExample example = new TbWorkFlowConfigExample();
        TbWorkFlowConfigExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(orgNo);
        if(StringUtils.isNotEmpty(flowCode)){
            criteria.andFlowCodeEqualTo(flowCode);
        }
        List<TbWorkFlowConfig> list = workFlowConfigMapper.selectByExample(example);
        return list.size()==1?list.get(0):null;
    }




    @Override
    public List<TbWorkFlowConfigDetailExtend> getWorkFlowDetailExtendList(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend,Integer type) {
        TbWorkFlowConfigDetailExtendExample extendExample = new TbWorkFlowConfigDetailExtendExample();
        TbWorkFlowConfigDetailExtendExample.Criteria criteria = extendExample.createCriteria();
        if (StringUtils.isNotEmpty(workFlowConfigDetailExtend.getNodeNo())) {
            criteria.andNodeNoEqualTo(workFlowConfigDetailExtend.getNodeNo());
        }
        if (StringUtils.isNotEmpty(workFlowConfigDetailExtend.getFlowNo())) {
            criteria.andFlowNoEqualTo(workFlowConfigDetailExtend.getFlowNo());
        }
        if (type != null) {
        if (type == 1) {
            criteria.andFieldTypeGreaterThanOrEqualTo(100);
        } else if (type == 2) {
            criteria.andFieldTypeLessThan(100);
        }
    }

        extendExample.setOrderByClause(" field_index ");
        return workFlowConfigDetailExtendMapper.selectByExample(extendExample);
    }

    @Override
    public int saveWorkFlowConfig(TbWorkFlowConfig workFlowConfig, TbUser user) {
        if(StringUtils.isNotEmpty(workFlowConfig.getFlowNo())){
            workFlowConfig.setUpdateUser(user.getCode());
            workFlowConfig.setUpdateUserName(user.getName());
            workFlowConfig.setUpdateTime(new Date());
            return workFlowConfigMapper.updateByPrimaryKeySelective(workFlowConfig);
        }else{
            workFlowConfig.setFlowNo(StringTools.getUUID());
            workFlowConfig.setCreateTime(new Date());
            workFlowConfig.setCreateUser(user.getCode());
            workFlowConfig.setCreateUserName(user.getName());
            return workFlowConfigMapper.insertSelective(workFlowConfig);
        }
    }

    @Override
    public int saveWorkFlowDetailList(List<TbWorkFlowConfigDetail> workFlowConfigDetails) {
        TbWorkFlowConfigDetail workFlowConfigDetailSearch = new TbWorkFlowConfigDetail();
        workFlowConfigDetailSearch.setConfigNo(workFlowConfigDetails.get(0).getConfigNo());
        List<TbWorkFlowConfigDetail> oldList = getWorkFlowDetailList(workFlowConfigDetailSearch);
        for(int i=0;i<oldList.size();i++){
            TbWorkFlowConfigDetail workFlowConfigDetail = oldList.get(i);
            boolean has = false;
            for(int j=0;j<workFlowConfigDetails.size();j++){
                if(workFlowConfigDetail.getNodeNo().equals(workFlowConfigDetails.get(j).getNodeNo())){
                    has = true;
                    break;
                }
            }
            if(!has){
                workFlowConfigDetailMapper.deleteByPrimaryKey(workFlowConfigDetail.getNodeNo());
            }

        }
        for(int i=0;i<workFlowConfigDetails.size();i++){
            TbWorkFlowConfigDetail workFlowConfigDetail = workFlowConfigDetails.get(i);
            if(StringUtils.isNotEmpty(workFlowConfigDetail.getNodeNo())){
                workFlowConfigDetailMapper.updateByPrimaryKeySelective(workFlowConfigDetail);
            }else{
                workFlowConfigDetail.setNodeNo(StringTools.getUUID());
                workFlowConfigDetailMapper.insertSelective(workFlowConfigDetail);
            }
        }
        return 1;
    }

    @Override
    public int saveWorkFlowDetail(TbWorkFlowConfigDetail workFlowConfigDetail) {
        if(StringUtils.isNotEmpty(workFlowConfigDetail.getNodeUserCode())){
            workFlowConfigDetail.setNodeUserIndex(null);
        }
        return workFlowConfigDetailMapper.updateByPrimaryKeySelective(workFlowConfigDetail);
    }

    @Override
    public int saveWorkFlowDetailUser(TbWorkFlowConfigDetail workFlowConfigDetail,int nodeUserType) {
        TbWorkFlowConfigDetail workFlowConfigDetailOld = workFlowConfigDetailMapper.selectByPrimaryKey(workFlowConfigDetail.getNodeNo());
        if(nodeUserType==1){
            workFlowConfigDetailOld.setNodeUserIndex(null);
            workFlowConfigDetailOld.setNodeUserCode(null);
            workFlowConfigDetailOld.setNodeRole(workFlowConfigDetail.getNodeRole());
            workFlowConfigDetailOld.setNodeRoleOrg(workFlowConfigDetail.getNodeRoleOrg());
        }else{
            if(StringUtils.isNotEmpty(workFlowConfigDetail.getNodeUserCode())){
                workFlowConfigDetailOld.setNodeUserIndex(null);
                workFlowConfigDetailOld.setNodeUserCode(workFlowConfigDetail.getNodeUserCode());
            }else{
                workFlowConfigDetailOld.setNodeUserIndex(workFlowConfigDetail.getNodeUserIndex());
                workFlowConfigDetailOld.setNodeUserCode(null);
            }
            workFlowConfigDetailOld.setNodeRole(null);
            workFlowConfigDetailOld.setNodeRoleOrg(null);
        }

        return workFlowConfigDetailMapper.updateByPrimaryKey(workFlowConfigDetailOld);
    }

    @Override
    public int saveWorkFlowDetailExtend(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend) {
        TbWorkFlowConfigDetail workFlowConfigDetail = workFlowConfigDetailMapper.selectByPrimaryKey(workFlowConfigDetailExtend.getNodeNo());
        workFlowConfigDetailExtend.setFlowNo(workFlowConfigDetail.getConfigNo());
        if(StringUtils.isNotEmpty(workFlowConfigDetailExtend.getNodeExtendNo())){
            return  workFlowConfigDetailExtendMapper.updateByPrimaryKeySelective(workFlowConfigDetailExtend);
        }else{
            workFlowConfigDetailExtend.setNodeExtendNo(StringTools.getUUID());
            return workFlowConfigDetailExtendMapper.insertSelective(workFlowConfigDetailExtend);
        }

    }

    @Override
    public int changeNodeIndex(String firstNodeExtendNo,Integer firstFieldIndex, String secondNodeExtendNo,Integer secondFieldIndex){
        TbWorkFlowConfigDetailExtend firstWorkFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        firstWorkFlowConfigDetailExtend.setNodeExtendNo(firstNodeExtendNo);
        firstWorkFlowConfigDetailExtend.setFieldIndex(firstFieldIndex);
        workFlowConfigDetailExtendMapper.updateByPrimaryKeySelective(firstWorkFlowConfigDetailExtend);
        TbWorkFlowConfigDetailExtend secondWorkFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        secondWorkFlowConfigDetailExtend.setNodeExtendNo(secondNodeExtendNo);
        secondWorkFlowConfigDetailExtend.setFieldIndex(secondFieldIndex);
        workFlowConfigDetailExtendMapper.updateByPrimaryKeySelective(secondWorkFlowConfigDetailExtend);
        return 1;
    }

    /**
     * 修改控制规则
     * @param nodeExtendNo
     * @param showCondition  显示规则
     * @param validateRules  校验规则，主要是和其他字段的比较
     * @return
     */
    @Override
    public int  changeControlRule( String nodeExtendNo,String showCondition,String validateRules){
        TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        workFlowConfigDetailExtend.setNodeExtendNo(nodeExtendNo);
        if(showCondition!=null){
            workFlowConfigDetailExtend.setShowCondition(showCondition);
        }
        if(validateRules!=null){
            workFlowConfigDetailExtend.setValidateRules(validateRules);
        }
        workFlowConfigDetailExtendMapper.updateByPrimaryKeySelective(workFlowConfigDetailExtend);
        return 1;
    }

    @Override
    public int deleteWorkFlowDetailExtend(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend) {
        return workFlowConfigDetailExtendMapper.deleteByPrimaryKey(workFlowConfigDetailExtend.getNodeExtendNo());
    }

    @Override
    public int saveWorkFlowInfo(TbWorkFlowInfo workFlowInfo) {
        if(workFlowInfo.getFlowNo()!=null){
            return workFlowInfoMapper.updateByPrimaryKeySelective(workFlowInfo);
        }else{
            workFlowInfo.setCreateTime(new Date());
            workFlowInfo.setFlowNo(StringTools.getUUID());
            return workFlowInfoMapper.insertSelective(workFlowInfo);
        }

    }

    @Override
    public int deleteWorkFlowInfo(String flowNo) {
        return workFlowConfigMapper.deleteByPrimaryKey(flowNo);
    }

    @Override
    public List<WorkFlowApi> getWorkFlowApiList(WorkFlowApi workFlowApi) {
        WorkFlowApiExample workFlowApiExample = new WorkFlowApiExample();
        workFlowApiExample.createCriteria().andDeleteFlagEqualTo(DELETE_NO);
        workFlowApiExample.setOrderByClause( "update_time desc ");
        return workFlowApiMapper.selectByExample(workFlowApiExample);
    }

    @Override
    public int saveWorkFlowApi(WorkFlowApi workFlowApi) {
        if(StringUtils.isNotEmpty(workFlowApi.getApiNo())){
            return workFlowApiMapper.updateByPrimaryKeySelective(workFlowApi);
        }else{
            workFlowApi.setDeleteFlag(0);
            workFlowApi.setApiNo(StringTools.getUUID());
            workFlowApi.setUpdateTime(new Date());
            return workFlowApiMapper.insertSelective(workFlowApi);
        }
    }

    @Override
    public int deleteWorkFlowApi(WorkFlowApi workFlowApi) {
        workFlowApi.setDeleteFlag(DELETE_YES);
        return workFlowApiMapper.updateByPrimaryKeySelective(workFlowApi);
    }





    @Override
    @Transactional(rollbackFor = Exception.class)
    public int workFlowCopyAlone(String sourceFlowNo, String targetFlowNo) {
        TbWorkFlowConfig sourceConfig =  workFlowConfigMapper.selectByPrimaryKey(sourceFlowNo);
        TbWorkFlowConfig targetConfig =  workFlowConfigMapper.selectByPrimaryKey(targetFlowNo);
        TbWorkFlowConfigDetail workFlowConfigDetailSearch = new TbWorkFlowConfigDetail();
        workFlowConfigDetailSearch.setConfigNo(sourceConfig.getFlowNo());
        List<TbWorkFlowConfigDetail> workFlowConfigDetailOneList = getWorkFlowDetailList(workFlowConfigDetailSearch);
        clearOldWorkFlow(targetFlowNo);
        copyWorkFlowDetail(targetConfig.getOrgNo(), workFlowConfigDetailOneList, targetConfig.getFlowNo(),sourceConfig.getOrgNo());
        return Dict.AjaxStatus.YES.getStatusCode();
    }

    private void clearOldWorkFlow(String targetFlowNo){
        TbWorkFlowConfigDetail workFlowConfigDetailSearch = new TbWorkFlowConfigDetail();
        workFlowConfigDetailSearch.setConfigNo(targetFlowNo);
        List<TbWorkFlowConfigDetail> workFlowConfigDetailList = getWorkFlowDetailList(workFlowConfigDetailSearch);
        for(TbWorkFlowConfigDetail workFlowConfigDetail:workFlowConfigDetailList){
            TbWorkFlowConfigDetailExtendExample extendExample = new TbWorkFlowConfigDetailExtendExample();
            extendExample.createCriteria().andNodeNoEqualTo(workFlowConfigDetail.getNodeNo());
            workFlowConfigDetailExtendMapper.deleteByExample(extendExample);
            workFlowConfigDetailMapper.deleteByPrimaryKey(workFlowConfigDetail.getNodeNo());
        }
    }



    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;
    @Autowired
    private TbOrgMapper tbOrgMapper;

    private void copyWorkFlowDetail(String targetOrgNo, List<TbWorkFlowConfigDetail> workFlowConfigDetailOneList, String flowNo, String sourceOrgNo) {

        TbFactoryInfo sourceFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(sourceOrgNo);
        TbFactoryInfo targetFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(targetOrgNo);
        TbOrg sourceOrg = tbOrgMapper.selectByUri(sourceFactoryInfo.getUri());
        TbOrg targetOrg = tbOrgMapper.selectByUri(targetFactoryInfo.getUri());

        for (int j = 0; j < workFlowConfigDetailOneList.size(); j++) {
            TbWorkFlowConfigDetail workFlowConfigDetailOne = workFlowConfigDetailOneList.get(j);
            TbWorkFlowConfigDetailExtend workFlowConfigDetailExtendSearch = new TbWorkFlowConfigDetailExtend();
            workFlowConfigDetailExtendSearch.setNodeNo(workFlowConfigDetailOne.getNodeNo());
            List<TbWorkFlowConfigDetailExtend> workFlowConfigDetailExtendOneList = getWorkFlowDetailExtendList(workFlowConfigDetailExtendSearch,null);
            String nodeNo = StringTools.getUUID();
            workFlowConfigDetailOne.setConfigNo(flowNo);
            workFlowConfigDetailOne.setNodeNo(nodeNo);
            workFlowConfigDetailOne.setOrgNo(targetOrgNo);
            //替换不周的操作人员
            if(StringUtils.isNotEmpty(workFlowConfigDetailOne.getNodeRoleOrg())){
                StringBuffer orgBuffer = new StringBuffer();
                StringBuffer roleBuffer = new StringBuffer();
                String[] sourceOrgCodeList = workFlowConfigDetailOne.getNodeRoleOrg().split(",");
                String[] sourceRoleCodeList = workFlowConfigDetailOne.getNodeRole().split(",");
                for(int i=0;i<sourceRoleCodeList.length;i++){
                    //替换水厂本身的角色
                    if(sourceOrgCodeList[i].equals(sourceOrg.getCode())){
                        orgBuffer.append(targetOrg.getCode()).append(",");
                        roleBuffer.append(sourceRoleCodeList[i]).append(",");
                    }
                }
                if(orgBuffer.length()>0){
                    workFlowConfigDetailOne.setNodeRoleOrg(orgBuffer.substring(0,orgBuffer.length()-1));
                    workFlowConfigDetailOne.setNodeRole(roleBuffer.substring(0,roleBuffer.length()-1));
                }
            }
            workFlowConfigDetailMapper.insertSelective(workFlowConfigDetailOne);

            for (int n = 0; n < workFlowConfigDetailExtendOneList.size(); n++) {
                TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = workFlowConfigDetailExtendOneList.get(n);
                workFlowConfigDetailExtend.setNodeNo(nodeNo);
                workFlowConfigDetailExtend.setNodeExtendNo(StringTools.getUUID());
                workFlowConfigDetailExtend.setFlowNo(flowNo);
                workFlowConfigDetailExtendMapper.insertSelective(workFlowConfigDetailExtend);

            }
        }
    }

}

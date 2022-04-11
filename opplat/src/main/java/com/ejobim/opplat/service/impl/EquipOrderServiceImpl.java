package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.common.WorkFlowCommon;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.BewgPointCondition;
import com.ejobim.opplat.domain.condition.TbEquipMaintainWorkCondition;
import com.ejobim.opplat.domain.interf.WorkFlowExtendI;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.EquipOrderService;
import com.ejobim.opplat.service.TbEquipMaintainFactorService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.Dict.*;
import static com.ejobim.opplat.common.WorkFlowCommon.*;


/**
 * 设备工单业务处理类
 *
 * @author xibian
 */
@Service
public class EquipOrderServiceImpl implements EquipOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbWorkFlowMapper workFlowMapper;
    @Autowired
    TbWorkFlowConfigMapper workFlowConfigMapper;
    @Autowired
    TbWorkFlowConfigDetailMapper workFlowConfigDetailMapper;
    @Autowired
    TbWorkFlowConfigDetailExtendMapper workFlowConfigDetailExtendMapper;
    @Autowired
    TbEquipRepareInfoMapper equipRepareInfoMapper;
    @Autowired
    TbEquipOverhaulInfoMapper equipOverhaulInfoMapper;
    @Autowired
    TbEquipMaintenanceInfoMapper equipMaintenanceInfoMapper;
    @Autowired
    TbGongyiAdjustMapper gongyiAdjustMapper;
    @Autowired
    TbEquipAdjustMapper equipAdjustMapper;
    @Autowired
    TbEquipMaintainFactorMapper equipMaintainFactorMapper;
    @Autowired
    TbWorkTaskInfoMapper workTaskInfoMapper;
    @Autowired
    TbWorkTaskInfoExtendMapper workTaskInfoExtendMapper;
    @Autowired
    TbOrgMapper orgMapper;
    @Autowired
    TbRoleMapper roleMapper;
    @Autowired
    TbUserMapper userMapper;
    @Autowired
    TbUserOrgRoleMapper userOrgRoleMapper;
    @Autowired
    TbEquipFaultInfoMapper equipFaultInfoMapper;
    @Autowired
    TbFactoryInfoMapper factoryInfoMapper;
    @Autowired
    TbEquipInfoMapper equipInfoMapper;
    @Autowired
    private TbEquipTaskFileMapper fileMapper;
    @Autowired
    private TbEquipMaintainFactorMapper tbEquipMaintainFactorMapper;

    @Autowired
    private TbDictMapper dictMapper;

    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;

    @Autowired
    private TbRoutingTaskDetailMapper routingTaskDetailMapper;
    @Autowired
    private TbRoutingLocationMapper routingLocationMapper;

    @Override
    public List<TbEquipFaultInfo> getEquipFaultList(String factoryNo, String equipName, Integer status, Date beginDate, Date endDate) {
        TbEquipFaultInfoExample equipFaultInfoExample = new TbEquipFaultInfoExample();
        TbEquipFaultInfoExample.Criteria criteria = equipFaultInfoExample.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        if (StringUtils.isNotEmpty(equipName)) {
            criteria.andEquipNameLike("%" + equipName + "%");
        }
        if (status != null) {
            //未处理
            criteria.andErrorStatusEqualTo(status);
        }
        if (beginDate != null) {
            criteria.andUpdateTimeGreaterThanOrEqualTo(beginDate);
        }
        if (endDate != null) {
            criteria.andUpdateTimeLessThan(DateUtils.getNextDate(endDate, 1));
        }
        equipFaultInfoExample.setOrderByClause("update_time desc");
        List<TbEquipFaultInfo> tbEquipFaultInfos = equipFaultInfoMapper.selectByExample(equipFaultInfoExample);
        for (TbEquipFaultInfo tbEquipFaultInfo : tbEquipFaultInfos) {
            if(tbEquipFaultInfo.getErrorLocation()!=null){
                TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(tbEquipFaultInfo.getErrorLocation());
                if(routingLocation!=null){
                    tbEquipFaultInfo.setLocationName(routingLocation.getLocationName());
                }
            }
        }
        return tbEquipFaultInfos;
    }

    @Override
    public List<TbEquipFaultInfo> getUnFinishEquipFaultList(String factoryNo) {
        return equipFaultInfoMapper.selectUnFinishList(factoryNo);
    }


    @Override
    public TbEquipFaultInfo getEquipFaultDetail(String errorNo) {
        TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
        TbRoutingTaskDetail routingTaskDetail = routingTaskDetailMapper.selectByPrimaryKey(equipFaultInfo.getDetailTaskNo());
        if (routingTaskDetail != null) {
            equipFaultInfo.setRoutingInfo(routingTaskDetail.getElementName());
            TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(routingTaskDetail.getLocationNo());
            if (routingLocation != null) {
                equipFaultInfo.setLocationName(routingLocation.getLocationName());
            }
        }
        return equipFaultInfo;
    }

    @Override
    public int updateEquipFault(String errorNo) {
        TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
        if ("none".equals(equipFaultInfo.getFactoryNo())) {
            return Dict.AjaxStatus.RECOMMITE.getStatusCode();
        } else {
            equipFaultInfo.setErrorStatus(ERROR_STATUS_NONE);
            if (equipFaultInfoMapper.updateByPrimaryKeySelective(equipFaultInfo) > 0) {
                return Dict.AjaxStatus.YES.getStatusCode();
            } else {
                return Dict.AjaxStatus.FAIL.getStatusCode();
            }
        }
    }

    @Override
    public TbWorkFlowConfig getWorkFlowConfigByCode(String orgNo, String flowCode) {
        TbWorkFlowConfigExample example = new TbWorkFlowConfigExample();
        TbWorkFlowConfigExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(orgNo);
        if (StringUtils.isNotEmpty(flowCode)) {
            criteria.andFlowCodeEqualTo(flowCode);
        }
        List<TbWorkFlowConfig> list = workFlowConfigMapper.selectByExample(example);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<TbWorkTaskInfo> getTaskInfoList(WorkTaskQueryParam workTaskQueryParam) {
        if (StringUtils.isEmpty(workTaskQueryParam.getTaskNo())) {
            TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
            TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
            //未结束
            //水厂条件
            if (StringUtils.isNotEmpty(workTaskQueryParam.getFactoryNo())) {
                criteria.andOrgNoEqualTo(workTaskQueryParam.getFactoryNo());
            }
            if (StringUtils.isNotEmpty(workTaskQueryParam.getTaskNo())) {
                criteria.andTaskNoEqualTo(workTaskQueryParam.getTaskNo());
            }
            if (workTaskQueryParam.getBeginDate() != null) {
                criteria.andPlanStartTimeGreaterThanOrEqualTo(workTaskQueryParam.getBeginDate());
            }
            if (workTaskQueryParam.getEndDate() != null) {
                criteria.andPlanStartTimeLessThan(DateUtils.getNextDate(workTaskQueryParam.getEndDate(), 1));
            }

            //工单类型参数
            if (workTaskQueryParam.getTaskType() != null) {
                criteria.andTaskTypeEqualTo(workTaskQueryParam.getTaskType());
            }
            //设备参数
            if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipNo())) {
                criteria.andEquipNoEqualTo(workTaskQueryParam.getEquipNo());
            }

            if(workTaskQueryParam.getEquipNoList()!=null){
                criteria.andEquipNoIn(workTaskQueryParam.getEquipNoList());
            }


            if (workTaskQueryParam.getUrgencyDegree() != null) {
                criteria.andUrgencyDegreeEqualTo(workTaskQueryParam.getUrgencyDegree());
            }
            //工单内容参数
            if (StringUtils.isNotEmpty(workTaskQueryParam.getTaskContent())) {
                criteria.andTaskContentLike("%" + workTaskQueryParam.getTaskContent() + "%");
            }
            //criteria.andTaskStatusNotEqualTo(0);
            List<Integer> integerList = new ArrayList<>();
            integerList.add(-1);
            integerList.add(0);
            criteria.andTaskStatusNotIn(integerList);
            example.setOrderByClause(" plan_start_time desc,create_time desc");
            return workTaskInfoMapper.selectByExample(example);
        } else {
            TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
            TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
            criteria.andTaskNoEqualTo(workTaskQueryParam.getTaskNo());
            return workTaskInfoMapper.selectByExample(example);
        }

    }

    @Override
    public List<TbWorkTaskInfo> getFinishTaskList(String factoryNo, Integer taskType) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(factoryNo);
        //工单类型参数
        criteria.andTaskTypeEqualTo(taskType);
        criteria.andTaskStatusEqualTo(WORK_TASK_STATUS_FINISH);
        example.setOrderByClause(" plan_start_time desc,create_time desc");
        return workTaskInfoMapper.selectByExample(example);
    }


    @Override
    public List<TbWorkTaskInfo> getFailTaskList(WorkTaskQueryParam workTaskQueryParam) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        //水厂条件
        if (StringUtils.isNotEmpty(workTaskQueryParam.getFactoryNo())) {
            criteria.andOrgNoEqualTo(workTaskQueryParam.getFactoryNo());
        }
        //设备名称

        if (workTaskQueryParam.getBeginDate() != null) {
            criteria.andPlanStartTimeGreaterThanOrEqualTo(workTaskQueryParam.getBeginDate());
        }
        if (workTaskQueryParam.getEndDate() != null) {
            criteria.andPlanStartTimeLessThan(DateUtils.getNextDate(workTaskQueryParam.getEndDate(), 1));
        }
        //工单类型参数
        if (workTaskQueryParam.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(workTaskQueryParam.getTaskType());
        }
        //设备参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipNo())) {
            criteria.andEquipNoEqualTo(workTaskQueryParam.getEquipNo());
        }
        if (workTaskQueryParam.getUrgencyDegree() != null) {
            criteria.andUrgencyDegreeEqualTo(workTaskQueryParam.getUrgencyDegree());
        }
        //工单内容参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getTaskContent())) {
            criteria.andTaskContentLike("%" + workTaskQueryParam.getTaskContent() + "%");
        }
        if(workTaskQueryParam.getEquipNoList()!=null && workTaskQueryParam.getEquipNoList().size()>0){
            criteria.andEquipNoIn(workTaskQueryParam.getEquipNoList());
        }
        criteria.andTaskStatusBetween(WORK_TASK_STATUS_FAIL, WORK_TASK_STATUS_FAIL_HANDLE);
        example.setOrderByClause(" plan_start_time desc,create_time desc");
        return workTaskInfoMapper.selectByExample(example);
    }

    private List<String> getEquipNoListByEquipName(String factoryNo, String equipName) {
        TbEquipInfoExample example = new TbEquipInfoExample();
        TbEquipInfoExample.Criteria criteria = example.createCriteria();
        criteria.andEquipNameLike("%" + equipName + "%");
        criteria.andFactoryNoEqualTo(factoryNo);
        List<TbEquipInfo> equipInfoList = equipInfoMapper.selectByExample(example);
        if (equipInfoList.size() > 0) {
            return equipInfoList.stream().map(TbEquipInfo::getEquipNo).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * 获取所有已下发未完成工单
     *
     * @param factoryNo
     * @param user
     * @param plat
     * @param taskType
     * @param date
     * @param equipNo
     * @return
     */
    @Override
    public List<TbWorkTaskInfo> getMyTaskInfoList(String factoryNo, TbUser user, Integer plat, Integer taskType, Date date, String equipNo) {

        if (StringUtils.isEmpty(factoryNo) && StringUtils.isEmpty(equipNo)) {
            return new ArrayList<>();
        } else if (StringUtils.isEmpty(factoryNo)) {
            TbEquipInfo equipInfo = equipInfoMapper.selectByPrimaryKey(equipNo);
            factoryNo = equipInfo.getFactoryNo();
        }

        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(factoryNo)) {
            criteria.andOrgNoEqualTo(factoryNo);
        }
        //已经开始的
        criteria.andPlanStartTimeLessThan(date);

        //获取执行中的工单
        criteria.andTaskStatusEqualTo(WORK_TASK_STATUS_ORDER);

        if (taskType != null) {
            criteria.andTaskTypeEqualTo(taskType);
        }
        if (StringUtils.isNotEmpty(equipNo)) {
            criteria.andEquipNoEqualTo(equipNo);
        }
        //三个排序条件优先级，是否驳回重修，工单计划时间 分别逆序
        example.setOrderByClause(" urgency_degree DESC, is_repeat desc,plan_start_time desc ");
        List<TbWorkTaskInfo> list = workTaskInfoMapper.selectByExample(example);
        List<TbWorkTaskInfo> resultList = new ArrayList<>();
        JSONArray orgRoleList = user.getOrgRoleList();
        logger.info("登录用户的name={},orgRoleList={}", user.getName(), JSON.toJSON(orgRoleList));
        List<TbOrg> orgList = getOrgList();
        String longinUserRole = "";
        for (int i = 0; i < orgRoleList.size(); i++) {
            JSONObject orgRole = orgRoleList.getJSONObject(i);
            for (TbOrg org : orgList) {
                if (orgRole.getString("orgEnCode").equals(org.getOrgencode())) {
                    orgRole.put("orgCode", org.getCode());
                    longinUserRole = orgRole.getString("roleList").toString();
                }
            }

        }

        for (int i = 0; i < list.size(); i++) {
            TbWorkTaskInfo workTaskInfo = list.get(i);
            //首先判断工单是否直接是指派给自己的
            if (user.getCode().equals(workTaskInfo.getNextUser())) {
                workTaskInfo.setEnableCommit(true);
                resultList.add(workTaskInfo);
                continue;
            }
            //其次当前登录用户的角色和制定nextrole 一样
            if (StringUtils.isNotEmpty(workTaskInfo.getNextRole()) && workTaskInfo.getTaskStatus() == 1) {
                JSONArray nextRoleArray = JSONArray.parseArray(workTaskInfo.getNextRole());
                for (int n = 0; n < nextRoleArray.size(); n++) {
                    JSONObject jsonObject = nextRoleArray.getJSONObject(n);
                    logger.info("下一步用户角色roles={}", jsonObject);
                    if (longinUserRole.contains(jsonObject.get("role").toString())) {
                        resultList.add(workTaskInfo);
                        workTaskInfo.setEnableCommit(true);
                        break;
                    }
                }
                continue;
            }
            //其次判断角色
            if (StringUtils.isNotEmpty(workTaskInfo.getNextRole())) {
                JSONArray nextRoleArray = JSONArray.parseArray(workTaskInfo.getNextRole());
                for (int n = 0; n < nextRoleArray.size(); n++) {
                    if (hasRole(orgRoleList, nextRoleArray.getJSONObject(n))) {
                        resultList.add(workTaskInfo);
                        workTaskInfo.setEnableCommit(true);
                        continue;
                    }
                }

            }

         /*   //其次判断角色
            if (StringUtils.isNotEmpty(workTaskInfo.getCheckUser())) {
                JSONArray userArray = JSONArray.parseArray(workTaskInfo.getCheckUser());
                if(userArray.contains(user.getCode())){
                    workTaskInfo.setEnableCommit(false);
                    resultList.add(workTaskInfo);
                    continue;
                }
            }*/

            //判断是否是参与者
//            if(StringUtils.isNotEmpty(workTaskInfo.getRelatedUser())){
//                JSONArray userArray  = JSONArray.parseArray(workTaskInfo.getRelatedUser());
//                if(userArray.contains(user.getCode())){
//                    workTaskInfo.setEnableCommit(false);
//                    resultList.add(workTaskInfo);
//                    workTaskInfo.setNextStatusCodeName("查看详情");
//                    continue;
//                }
//            }

            //判断是否有协助人
            if (StringUtils.isNotEmpty(workTaskInfo.getAssistUser())) {
                JSONArray userArray = JSONArray.parseArray(workTaskInfo.getAssistUser());
                for (int n = 0; n < userArray.size(); n++) {
                    JSONObject userJson = userArray.getJSONObject(n);
                    if (userJson.getString("userCode").equals(user.getCode())) {
                        workTaskInfo.setEnableCommit(false);
                        resultList.add(workTaskInfo);
                        workTaskInfo.setNextStatusCodeName("查看详情");
                        continue;
                    }
                }
            }

            //判断如果是创建者
            if(workTaskInfo.getCreateUser().equals(user.getCode())){
                workTaskInfo.setEnableCommit(false);
                workTaskInfo.setNextStatusCodeName("查看详情");
                resultList.add(workTaskInfo);

            }

        }


        return resultList;
    }

    private boolean hasRole(JSONArray orgRoleList, JSONObject orgRole) {
        for (int i = 0; i < orgRoleList.size(); i++) {
            JSONObject orgRoleCurrent = orgRoleList.getJSONObject(i);
            if (orgRoleCurrent.getString("orgCode").equals(orgRole.getString("org"))
                    && orgRoleCurrent.getJSONArray("roleList").contains(orgRole.getString("role"))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TbWorkTaskInfo> getEquipHistory(String equipNo, Integer taskType) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andEquipNoEqualTo(equipNo);
        criteria.andTaskStatusEqualTo(WORK_TASK_STATUS_FINISH);
        if(taskType!=null){
            criteria.andTaskTypeEqualTo(taskType);
        }

        example.setOrderByClause(" real_start_time desc");
        return workTaskInfoMapper.selectByExample(example);
    }

    @Override
    public int updateTbWorkTaskInfo(TbWorkTaskInfo workTaskInfo) {
        if (workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo) > 0) {
            return Dict.AjaxStatus.YES.getStatusCode();
        } else {
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }
    }

    @Override
    public List<TbWorkTaskInfo> getTaskInfoPlanList(String factoryNo, Integer taskType, Date date, TbUser user) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(factoryNo);
        //自修的工单才需要下发工单
        //criteria.andIsEntrustEqualTo(ENTRUST_NO);
        if (taskType != null) {
            criteria.andTaskTypeEqualTo(taskType);
        }
        //如果没有日期参数 则是查询所有的工单计划
        if (date != null) {
            //日期为第二天的0点0分 任务预计开始时间小于该时间
            criteria.andPlanStartTimeLessThan(date);
        }
        //计划状态的工单
        criteria.andTaskStatusEqualTo(WORK_TASK_STATUS_PLAN);
        example.setOrderByClause(" urgency_degree DESC, is_repeat desc,plan_start_time desc ");
        List<TbWorkTaskInfo> list = workTaskInfoMapper.selectByExample(example);
        List<TbWorkTaskInfo> resultList = new ArrayList<>();
        JSONArray orgRoleList = user.getOrgRoleList();
        List<TbOrg> orgList = getOrgList();
        for (int i = 0; i < orgRoleList.size(); i++) {
            JSONObject orgRole = orgRoleList.getJSONObject(i);
            for (TbOrg org : orgList) {
                if (orgRole.getString("orgEnCode").equals(org.getOrgencode())) {
                    orgRole.put("orgCode", org.getCode());
                }
            }

        }

        for (int i = 0; i < list.size(); i++) {
            TbWorkTaskInfo workTaskInfo = list.get(i);
            //首先判断工单是否直接是指派给自己的
            if (user.getCode().equals(workTaskInfo.getNextUser())) {
                workTaskInfo.setEnableCommit(true);
                resultList.add(workTaskInfo);
                continue;
            }
            //其次判断角色
            boolean hsaFind = false;
            if (StringUtils.isNotEmpty(workTaskInfo.getNextRole())) {
                JSONArray nextRoleArray = JSONArray.parseArray(workTaskInfo.getNextRole());
                for (int n = 0; n < nextRoleArray.size(); n++) {
                    if (hasRole(orgRoleList, nextRoleArray.getJSONObject(n))) {
                        workTaskInfo.setEnableCommit(true);
                        resultList.add(workTaskInfo);
                        hsaFind = true;
                        continue;
                    }
                }
            }

            //如果已经是操作人员 就不继续查找
            if(!hsaFind){
                //判断如果是创建者
                if(workTaskInfo.getCreateUser().equals(user.getCode())){
                    workTaskInfo.setEnableCommit(false);
                    workTaskInfo.setNextStatusCodeName("查看详情");
                    resultList.add(workTaskInfo);
                }
            }

        }
        return resultList;
    }

    /**
     * 下发
     *
     * @param user
     * @param jsonObject
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int setTaskDudyUser(TbUser user, JSONObject jsonObject) {
        String taskNo = jsonObject.getString("taskNo");
        //做一次转换 防止转成类是出错
        jsonObject.put("dutyUser", jsonObject.getJSONObject("dutyUser").toString());
        jsonObject.put("assistUser", jsonObject.getJSONArray("assistUser").toString());
        TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
        if(!workTaskInfo.getTaskStatus().equals(WORK_TASK_STATUS_PLAN)){
            return AjaxStatus.TASK_STATUS_CHANGED.getStatusCode();
        }
        TbWorkFlowConfigDetail workFlowConfigDetail = getNextWorkFlowDetail(workTaskInfo.getWorkFlowConfigNo(), workTaskInfo.getNextStatusIndex());
        if (workFlowConfigDetail.getNodeName().equals("下发")) {
            TbWorkFlowConfigDetailExtend workFlowConfigDetailExtendSearch = new TbWorkFlowConfigDetailExtend();
            workFlowConfigDetailExtendSearch.setNodeNo(workFlowConfigDetail.getNodeNo());
            List<TbWorkFlowConfigDetailExtend> workFlowConfigDetailExtends = getWorkFlowDetailExtendList(workFlowConfigDetailExtendSearch, 1);
            workFlowConfigDetail.setFieldList(workFlowConfigDetailExtends);
            TbWorkFlowConfigDetail nextWorkFlowConfigDetail = getNextWorkFlowConfigDetail(workFlowConfigDetail, jsonObject, taskNo);
            return saveWorkTaskInfo(taskNo, user, workFlowConfigDetail, nextWorkFlowConfigDetail, jsonObject, null, null);
        } else {
            return AjaxStatus.RECOMMITE.getStatusCode();
        }


    }

    @Override
    public List<TbWorkTaskInfo> getUnFinishTaskInfoList(String factoryNo, Integer taskType) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTaskTypeEqualTo(taskType);
        criteria.andOrgNoEqualTo(factoryNo);
        criteria.andNextStatusIndexGreaterThan(-1);
        return workTaskInfoMapper.selectByExample(example);
    }


    @Override
    public List<TbWorkTaskInfo> getUnFinishTaskInfoListByPlanTime(TbWorkTaskInfo taskInfo) {
        List<TbWorkTaskInfo> tbWorkTaskInfos = new ArrayList<>();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        if (taskInfo != null) {
            if (taskInfo.getOrgNo() != null) {
                criteria.andOrgNoEqualTo(taskInfo.getOrgNo());
            }
            if (taskInfo.getTaskType() != null) {
                criteria.andTaskTypeEqualTo(taskInfo.getTaskType());
            }
            if (taskInfo.getSource() != null) {
                if (taskInfo.getSource() == 0) {
                    //查询大于计划开始时间
                    if (taskInfo.getPlanStartTime() != null) {
                        criteria.andPlanStartTimeGreaterThan(taskInfo.getPlanStartTime());
                    }
                } else if (taskInfo.getSource() == 1) {
                    //查询等于计划开始时间
                    if (taskInfo.getPlanStartTime() != null) {
                        criteria.andPlanStartTimeEqualTo(taskInfo.getPlanStartTime());
                    }
                }
            }
            if (taskInfo.getTaskFrom() != null) {
                criteria.andTaskFromEqualTo(taskInfo.getTaskFrom());
            }
            if(taskInfo.getTaskStatus()!=null){
                criteria.andTaskStatusNotEqualTo(WORK_TASK_STATUS_CANCEL);
            }
            example.setOrderByClause("plan_start_time");
            tbWorkTaskInfos = workTaskInfoMapper.selectByExample(example);
        }

        return tbWorkTaskInfos;
    }

    private List<TbUser> getUserListByCodes(List<String> userCodeList) {
        TbUserExample userExample = new TbUserExample();
        TbUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCodeIn(userCodeList);
        return userMapper.selectByExample(userExample);
    }


    /**
     * 查询所有的组织机构
     *
     * @return
     */
    private List<TbOrg> getOrgList() {
        TbOrgExample orgExample = new TbOrgExample();
        TbOrgExample.Criteria criteria = orgExample.createCriteria();
        criteria.andStateEqualTo(1);
        List<TbOrg> list = orgMapper.selectByExample(orgExample);
        return list;
    }

    private List<TbRole> getRoleList() {
        TbRoleExample roleExample = new TbRoleExample();
        List<TbRole> list = roleMapper.selectByExample(roleExample);
        return list;
    }


    /**
     * 获取工作流步骤信息
     *
     * @param workFlowConfigDetail
     * @return
     */
    private List<TbWorkFlowConfigDetail> getWorkFlowDetailList(TbWorkFlowConfigDetail workFlowConfigDetail) {
        TbWorkFlowConfigDetailExample example = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteria = example.createCriteria();
        criteria.andConfigNoEqualTo(workFlowConfigDetail.getConfigNo());
        if (StringUtils.isNotEmpty(workFlowConfigDetail.getNodeCode())) {
            criteria.andNodeCodeEqualTo(workFlowConfigDetail.getNodeCode());
        }
        if (workFlowConfigDetail.getNodeSort() != null) {
            criteria.andNodeSortEqualTo(workFlowConfigDetail.getNodeSort());
        }
        if (workFlowConfigDetail.getNodeIndex() != null) {
            criteria.andNodeIndexEqualTo(workFlowConfigDetail.getNodeIndex());
        }
        example.setOrderByClause(" node_sort ");
        return workFlowConfigDetailMapper.selectByExample(example);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int saveWorkFlowInfo(JSONObject jsonObject, TbUser user) {
        String flowNo = jsonObject.getString("flowNo");
        Integer validStatus = jsonObject.containsKey("validStatus") ? jsonObject.getIntValue("validStatus") : null;
        TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
        JSONObject detailInfo = jsonObject.getJSONObject("detailInfo");
        TbWorkFlowConfigDetail nextWorkFlowConfigDetail = getNextWorkFlowConfigDetail(workFlowConfigDetail, detailInfo, flowNo);
        return saveWorkTaskInfo(flowNo, user, workFlowConfigDetail, nextWorkFlowConfigDetail, detailInfo, validStatus, jsonObject);
    }

    private boolean checkForceFiled(TbWorkFlowConfigDetail workFlowConfigDetail, JSONObject detailInfo) {
        for (int i = 0; i < workFlowConfigDetail.getFieldList().size(); i++) {
            TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = workFlowConfigDetail.getFieldList().get(i);
            if (!detailInfo.containsKey(workFlowConfigDetailExtend.getFieldCode())) {
                return false;
            } else if (detailInfo.get(workFlowConfigDetailExtend.getFieldCode()) == null || StringUtils.isEmpty(detailInfo.get(workFlowConfigDetailExtend.getFieldCode()).toString())) {
                return false;
            }
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int saveWorkFlowInfo(JSONObject detailInfo, TbWorkFlowConfigDetail workFlowConfigDetail, TbUser user) {
        TbWorkFlowConfigDetail nextWorkFlowConfigDetail = getNextWorkFlowConfigDetail(workFlowConfigDetail, detailInfo, null);
        return saveWorkTaskInfo(null, user, workFlowConfigDetail, nextWorkFlowConfigDetail, detailInfo, null, null);
    }

    /**
     * 重修或委外
     *
     * @param jsonObject
     * @param user
     * @return
     */
    @Override
    public int saveValid(JSONObject jsonObject, TbUser user) {
        try {
            String taskNo = jsonObject.getString("flowNo");
            int type = jsonObject.getIntValue("type");
            TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);

            //重修
            if (type == 1) {
                TbWorkFlowConfigDetail configDetail = new TbWorkFlowConfigDetail();
                configDetail.setConfigNo(workTaskInfo.getWorkFlowConfigNo());
                List<TbWorkFlowConfigDetail> workFlowConfigDetailList = getWorkFlowDetailList(configDetail);
                List<TbWorkTaskInfoExtend> workFlowExtendList = getWorkTaskInfoExtendList(taskNo, true);

                TbWorkFlowConfigDetail returnNode = null;
                //查找当前步骤
                for (int i = 0; i < workFlowConfigDetailList.size(); i++) {
                    if (workFlowConfigDetailList.get(i).getNodeIndex().equals(workTaskInfo.getNextStatusIndex())) {
                        returnNode = workFlowConfigDetailList.get(i);
                        break;
                    }
                }
                if (returnNode.getNodeReturn() == null) {
                    return Dict.AjaxStatus.NOFIND.getStatusCode();
                }
                TbWorkFlowConfigDetail currentNodeConfig = null;

                //查找回滚的哪个步骤
                for (int i = 0; i < workFlowConfigDetailList.size(); i++) {
                    if (workFlowConfigDetailList.get(i).getNodeIndex().toString().equals(returnNode.getNodeReturn())) {
                        currentNodeConfig = workFlowConfigDetailList.get(i);
                        break;
                    }
                }
                if (currentNodeConfig == null) {
                    return Dict.AjaxStatus.NOFIND.getStatusCode();
                }

                TbWorkTaskInfoExtend lastNode = null;
                TbWorkTaskInfoExtend currentNode = null;

                for(int i=workFlowExtendList.size()-1;i>=0;i--){
                    if (workFlowExtendList.get(i).getStatusIndex().equals(currentNodeConfig.getNodeIndex())) {
                        currentNode = workFlowExtendList.get(i);
                        currentNode.setValidStatus(2);
                        workTaskInfoExtendMapper.updateByPrimaryKeySelective(currentNode);
                        if (i > 0) {
                            lastNode = workFlowExtendList.get(i - 1);
                        }
                    }else{
                        workFlowExtendList.get(i).setValidStatus(2);
                        workTaskInfoExtendMapper.updateByPrimaryKeySelective(workFlowExtendList.get(i));
                    }
                }

                workTaskInfo.setStatusCode(lastNode.getStatusCode());
                workTaskInfo.setStatusCodeName(lastNode.getStatusCodeName());
                workTaskInfo.setStatusIndex(lastNode.getStatusIndex());
                workTaskInfo.setNextStatusCode(currentNodeConfig.getNodeCode());
                workTaskInfo.setNextStatusCodeName(currentNodeConfig.getNodeName());
                workTaskInfo.setNextStatusIndex(currentNodeConfig.getNodeIndex());
                workTaskInfo.setNextUser(currentNode.getCommitUserCode());
                workTaskInfo.setNextRole("");
                workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo);



            } else {
                //设置为无法自修
                workTaskInfo.setTaskStatus(WORK_TASK_STATUS_FAIL);
                workTaskInfo.setStatusCode(workTaskInfo.getNextStatusCode());
                workTaskInfo.setStatusCodeName(workTaskInfo.getNextStatusCodeName());
                workTaskInfo.setStatusIndex(workTaskInfo.getNextStatusIndex());
                JSONObject userJson = new JSONObject();
                userJson.put("userCode", user.getCode());
                userJson.put("userName", user.getName());
                JSONObject infoJson = new JSONObject();
                infoJson.put("checkUser", userJson);
                infoJson.put("repareVideo", jsonObject.getJSONObject("detailInfo").getString("repareVideo"));
                workTaskInfo.setExtendInfo(infoJson.toJSONString());
                workTaskInfo.setNextStatusCode("");
                workTaskInfo.setNextStatusCodeName("");
                workTaskInfo.setNextStatusIndex(0);
                workTaskInfo.setNextUser(null);
                workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo);

//                TbWorkTaskInfoExtend workFlowExtend = createNewExtend(workTaskInfo.getTaskNo(), flowConfigDetail, user.getName(), user.getCode());
//                workFlowExtend.setValidStatus(1);
//                workTaskInfoExtendMapper.insertSelective(workFlowExtend);
            }
            return Dict.AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Dict.AjaxStatus.SERVICE_RROR.getStatusCode();

    }

    @Override
    public int cancelTask(String taskNo, TbUser user) {
        TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
        if(workTaskInfo.getTaskStatus().equals(WORK_TASK_STATUS_PLAN)){
            workTaskInfo.setTaskStatus(WORK_TASK_STATUS_CANCEL);
            workTaskInfo.setNextStatusCode("CANCEL");
            workTaskInfo.setNextStatusCodeName("已取消");
            setRelatedUser(user, workTaskInfo);
            if (workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo) > 0) {
                return Dict.AjaxStatus.YES.getStatusCode();
            } else {
                return Dict.AjaxStatus.FAIL.getStatusCode();
            }
        }else{
            return Dict.AjaxStatus.TASK_STATUS_CHANGED.getStatusCode();
        }

    }


    /**
     * 保存工单进度
     *
     * @param taskNo
     * @param user
     * @param flowConfigDetail
     * @param nextFlowConfigDetail
     * @param detailInfo
     * @param validStatus
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int saveWorkTaskInfo(String taskNo, TbUser user, TbWorkFlowConfigDetail flowConfigDetail, TbWorkFlowConfigDetail nextFlowConfigDetail
            , JSONObject detailInfo, Integer validStatus, JSONObject jsonObject) {
        try {
            TbWorkFlowConfig workFlowConfig = workFlowConfigMapper.selectByPrimaryKey(flowConfigDetail.getConfigNo());
            if (StringUtils.isNotEmpty(taskNo)) {
                //编辑或者走流程
                TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
                //检查是否重复提交和越权
                int checkResult = checkWorkFlow(workTaskInfo, flowConfigDetail.getNodeIndex(), user);
                if (checkResult != 0) {
                    return checkResult;
                }
                //审批不通过
                if (validStatus != null && validStatus.intValue() == 1) {
                    if (StringUtils.isEmpty(flowConfigDetail.getNodeReturn())) {
                        return Dict.AjaxStatus.NO_SET_CALLBACK.getStatusCode();
                    }
                    List<TbWorkTaskInfoExtend> workFlowExtendList = getWorkTaskInfoExtendList(workTaskInfo.getTaskNo(), true);
                    TbWorkFlowConfigDetail configDetail = new TbWorkFlowConfigDetail();
                    configDetail.setConfigNo(workTaskInfo.getWorkFlowConfigNo());
                    List<TbWorkFlowConfigDetail> workFlowConfigDetailList = getWorkFlowDetailList(configDetail);
                    TbWorkFlowConfigDetail workFlowConfigDetail = getLastNode(workFlowConfigDetailList, Integer.valueOf(flowConfigDetail.getNodeReturn()));
                    TbWorkFlowConfigDetail nextWorkFlowConfigDetail = getCurrentNode(workFlowConfigDetailList, Integer.valueOf(flowConfigDetail.getNodeReturn()));

                    TbWorkTaskInfoExtend returnFlowExtend = callbackWorkFlowDetail(workFlowConfigDetailList, workFlowExtendList, flowConfigDetail.getNodeIndex(), Integer.valueOf(flowConfigDetail.getNodeReturn()));

                    callbackWorkFlow(workTaskInfo,  workFlowConfigDetail, nextWorkFlowConfigDetail, returnFlowExtend);


                    TbWorkTaskInfoExtend workFlowExtend = createNewExtend(workTaskInfo.getTaskNo(), flowConfigDetail, user.getName(), user.getCode());
                    workFlowExtend.setValidStatus(1);
                    workTaskInfoExtendMapper.insertSelective(workFlowExtend);
                    saveDetailInfo(detailInfo, workFlowExtend.getExtendNo(), workFlowConfig.getFlowCode(), flowConfigDetail.getStepCode(), null);
                    //审批不通过直接结束
                }else if (validStatus != null && validStatus.intValue() == 2) {
                    workTaskInfo.setStatusCode("");
                    workTaskInfo.setStatusCodeName("已终止");
                    workTaskInfo.setNextStatusIndex(-1);
                    workTaskInfo.setRealFinishTime(new Date());
                    workTaskInfo.setNextStatusCodeName("");
                    workTaskInfo.setNextStatusCode("");
                    workTaskInfo.setNextUser("");
                    workTaskInfo.setRealStartTime(new Date());
                    workTaskInfo.setTaskStatus(WORK_TASK_STATUS_CHECK_FAIL);
                    workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo);
                    TbWorkTaskInfoExtend workFlowExtend = createNewExtend(workTaskInfo.getTaskNo(), flowConfigDetail, user.getName(), user.getCode());
                    workFlowExtend.setValidStatus(1);
                    workTaskInfoExtendMapper.insertSelective(workFlowExtend);
                    saveDetailInfo(detailInfo, workFlowExtend.getExtendNo(), workFlowConfig.getFlowCode(), flowConfigDetail.getStepCode(), null);
                } else {
                    if (checkFinalExamine(flowConfigDetail, workTaskInfo)) {
                        nextFlowConfigDetail = null;
                    }
                    setWorkTaskInfo(flowConfigDetail, nextFlowConfigDetail, workTaskInfo, detailInfo, user);
                    setRelatedUser(user, workTaskInfo);
                    workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo);
                    TbWorkTaskInfoExtend workFlowExtend = createNewExtend(workTaskInfo.getTaskNo(), flowConfigDetail, user.getName(), user.getCode());
                    workTaskInfoExtendMapper.insertSelective(workFlowExtend);

                    String nextStep = workTaskInfo.getTaskStatus().equals(2) ? null : nextFlowConfigDetail.getStepCode();
                    saveDetailInfo(detailInfo, workFlowExtend.getExtendNo(), workFlowConfig.getFlowCode(), flowConfigDetail.getStepCode(), nextStep);
                    //最后的步骤
                    if (workTaskInfo.getTaskStatus().equals(-1)) {
                        if (workFlowConfig.getNextFlowCode() != null) {
                            addNextWorkTaskInfo(workFlowConfig, user, detailInfo, workTaskInfo, flowConfigDetail);
                        }
                     //如果是维保任务 则自动创建下一次工单
                        if (SBWB.equals(workFlowConfig.getFlowCode())) {
                            createNewMaintanance(workTaskInfo, user);
                        }
                    }
                }

            } else {
                //新增数据
                TbWorkTaskInfo workTaskInfo = JSON.toJavaObject(detailInfo, TbWorkTaskInfo.class);
                setNewWorkTaskInfo(workTaskInfo, user, flowConfigDetail, nextFlowConfigDetail);
                if (detailInfo.containsKey("errorNo")) {
                    String errorNo = detailInfo.getString("errorNo");
                    TbWorkTaskInfo taskInfo = new TbWorkTaskInfo();
                    taskInfo.setTaskFrom(errorNo);
                    TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
                    equipFaultInfo.setFlowNo(workTaskInfo.getTaskNo());
                    List<TbWorkTaskInfo> tbWorkTaskInfoList = getUnFinishTaskInfoListByPlanTime(taskInfo);
                    if (tbWorkTaskInfoList != null && tbWorkTaskInfoList.size() > 0) {
                        //改成4
                        equipFaultInfo.setErrorStatus(ERROR_STATUS_TASK_AND_GYTZ);
                        logger.info("异常转工艺或者维修参数equipFaultInfo={}", JSON.toJSONString(equipFaultInfo));
                    } else {
                        //判断根据
                        if (workTaskInfo.getTaskType() == WX_TYPE) {
                            //转维修 1
                            equipFaultInfo.setErrorStatus(ERROR_STATUS_TASK);
                            logger.info("异常转维修参数equipFaultInfo={}", JSON.toJSONString(equipFaultInfo));
                        } else if (workTaskInfo.getTaskType() == GYTZ_TYPE) {
                            //转工艺调整 3
                            equipFaultInfo.setErrorStatus(ERROR_STATUS_GYTZ);
                            logger.info("异常转工艺参数equipFaultInfo={}", JSON.toJSONString(equipFaultInfo));
                        }
                    }
                    equipFaultInfoMapper.updateByPrimaryKeySelective(equipFaultInfo);
                    workTaskInfo.setTaskFrom(errorNo);
                    workTaskInfo.setEquipNo(equipFaultInfo.getEquipNo());
                }
                workTaskInfoMapper.insertSelective(workTaskInfo);
                if (jsonObject != null) {
                    jsonObject.put("flowNo", workTaskInfo.getTaskNo());
                    if (jsonObject.containsKey("oldTaskNo")) {
                        TbWorkTaskInfo oldTaskInfo = workTaskInfoMapper.selectByPrimaryKey(jsonObject.getString("oldTaskNo"));
                        JSONObject equipList = JSONObject.parseObject(oldTaskInfo.getExtendInfo());
                        equipList.put("nextTaskNo", workTaskInfo.getTaskNo());
                        oldTaskInfo.setExtendInfo(equipList.toString());
                        oldTaskInfo.setTaskStatus(WORK_TASK_STATUS_FAIL_HANDLE);
                        workTaskInfoMapper.updateByPrimaryKeySelective(oldTaskInfo);
                    }
                }

                TbWorkTaskInfoExtend workFlowExtend = createNewExtend(workTaskInfo.getTaskNo(), flowConfigDetail, user.getName(), user.getCode());
                workTaskInfoExtendMapper.insertSelective(workFlowExtend);
                saveDetailInfo(detailInfo, workFlowExtend.getExtendNo(), workFlowConfig.getFlowCode(), flowConfigDetail.getStepCode(), nextFlowConfigDetail.getStepCode());

            }
            return Dict.AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            if (TransactionAspectSupport.currentTransactionStatus().isNewTransaction()) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } else {
                try {
                    throw ex;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return Dict.AjaxStatus.SERVICE_RROR.getStatusCode();
    }


    private void setRelatedUser(TbUser user, TbWorkTaskInfo workTaskInfo) {
        JSONArray relatedUserArray = new JSONArray();
        if (StringUtils.isNotEmpty(workTaskInfo.getRelatedUser())) {
            relatedUserArray = JSONArray.parseArray(workTaskInfo.getRelatedUser());
        }
        if (!relatedUserArray.contains(user.getCode())) {
            relatedUserArray.add(user.getCode());
        }
        workTaskInfo.setRelatedUser(relatedUserArray.toJSONString());
    }

    /**
     * 添加工作流任务主体信息
     *
     * @param taskJson
     * @param extendNo
     * @param flowCode
     */
    private void saveDetailInfo(JSONObject taskJson, String extendNo, String flowCode, String step, String nextStep) {
        //设备调整
        if (SBDX.equals(flowCode)) {
            saveEquipOverhaul(taskJson, extendNo, step, nextStep);
        } else if (SBWB.equals(flowCode)) {
            saveMaintenanceInfo(taskJson, extendNo, step, nextStep);
        } else if (SBWXN.equals(flowCode)) {
            saveEquipRepare(taskJson, extendNo, step, nextStep);
        } else if (SBFF.equals(flowCode)) {
            saveMaintenanceInfo(taskJson, extendNo, step, nextStep);
        } else if (GYTZ.equals(flowCode)) {
            saveGongyiAdjustInfo(taskJson, extendNo, step, nextStep);
        } else if (SBTZ.equals(flowCode)) {
            saveEquipAdjustInfo(taskJson, extendNo, step, nextStep);
        }
    }

    private void saveEquipRepare(JSONObject taskJson, String extendNo, String step, String nextStep) {
        if (taskJson != null) {
            TbEquipRepareInfo repareInfo = JSON.toJavaObject(taskJson, TbEquipRepareInfo.class);
            repareInfo.setRepareDetailNo(StringTools.getUUID());
            repareInfo.setExtendNo(extendNo);
            equipRepareInfoMapper.insertSelective(repareInfo);
        }

    }

    private void saveEquipOverhaul(JSONObject taskJson, String extendNo, String step, String nextStep) {
        if (taskJson != null) {
            TbEquipOverhaulInfo overhaulInfo = JSON.toJavaObject(taskJson, TbEquipOverhaulInfo.class);
            overhaulInfo.setOverhaulDetailNo(StringTools.getUUID());
            overhaulInfo.setExtendNo(extendNo);
            equipOverhaulInfoMapper.insertSelective(overhaulInfo);
        }

    }

    private void saveMaintenanceInfo(JSONObject taskJson, String extendNo, String step, String nextStep) {
        if (taskJson != null) {
            TbEquipMaintenanceInfo maintenanceInfo = JSON.toJavaObject(taskJson, TbEquipMaintenanceInfo.class);
            maintenanceInfo.setMaintenanceDetailNo(StringTools.getUUID());
            maintenanceInfo.setExtendNo(extendNo);
            equipMaintenanceInfoMapper.insertSelective(maintenanceInfo);

        }
    }

    private void saveGongyiAdjustInfo(JSONObject taskJson, String extendNo, String step, String nextStep) {
        if (taskJson != null) {
            TbGongyiAdjust gongyiAdjust = JSON.toJavaObject(taskJson, TbGongyiAdjust.class);
            gongyiAdjust.setAdjustNo(StringTools.getUUID());
            gongyiAdjust.setFlowNo(extendNo);
            gongyiAdjustMapper.insertSelective(gongyiAdjust);

        }
    }

    private void saveEquipAdjustInfo(JSONObject taskJson, String extendNo, String step, String nextStep) {
        if (taskJson != null) {
            TbEquipAdjust tbEquipAdjust = JSON.toJavaObject(taskJson, TbEquipAdjust.class);
            tbEquipAdjust.setAdNo(StringTools.getUUID());
            tbEquipAdjust.setFlowNo(extendNo);
            equipAdjustMapper.insertSelective(tbEquipAdjust);
        }
    }


    /**
     * 设置工作流详情
     *
     * @param flowConfigDetail
     * @param nextFlowConfigDetail
     * @param workTaskInfo
     */
    private void setWorkTaskInfo(TbWorkFlowConfigDetail flowConfigDetail, TbWorkFlowConfigDetail nextFlowConfigDetail, TbWorkTaskInfo workTaskInfo, JSONObject detailJson, TbUser user) {

        if (nextFlowConfigDetail != null) {
            workTaskInfo.setStatusIndex(flowConfigDetail.getNodeIndex());
            workTaskInfo.setStatusCodeName(flowConfigDetail.getNodeName());
            workTaskInfo.setStatusCode(flowConfigDetail.getNodeCode());
            String nextUser = getNextUser(flowConfigDetail, detailJson);
            workTaskInfo.setNextUser("");
            workTaskInfo.setNextRole("");
            if (nextUser == null) {
                //如果有制定用户直接制定未当前用户
                if (StringUtils.isNotEmpty(nextFlowConfigDetail.getNodeUserCode())) {
                    workTaskInfo.setNextUser(nextFlowConfigDetail.getNodeUserCode());
                } else if (nextFlowConfigDetail.getNodeUserIndex() != null && nextFlowConfigDetail.getNodeUserIndex() > 0) {
                    TbWorkTaskInfoExtend workTaskInfoExtend = getWorkFlowInfoExtend(workTaskInfo.getTaskNo(), nextFlowConfigDetail.getNodeUserIndex());
                    if (workTaskInfoExtend != null) {
                        workTaskInfo.setNextUser(workTaskInfoExtend.getCommitUserCode());
                    }
                } else if (StringUtils.isNotEmpty(nextFlowConfigDetail.getNodeRole())) {
                    String[] roleList = nextFlowConfigDetail.getNodeRole().split(",");
                    String[] orgList = nextFlowConfigDetail.getNodeRoleOrg().split(",");
                    JSONArray array = new JSONArray();
                    for (int i = 0; i < roleList.length; i++) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("org", orgList[i]);
                        jsonObject.put("role", roleList[i]);
                        array.add(jsonObject);
                    }
                    workTaskInfo.setNextRole(array.toString());
                }
            } else {
                workTaskInfo.setNextRole("");
                workTaskInfo.setNextUser(nextUser);
            }
            if (detailJson != null) {
                TbWorkTaskInfo newWorkTaskInfo = JSON.toJavaObject(detailJson, TbWorkTaskInfo.class);
                setTaskDetalInfo(workTaskInfo, newWorkTaskInfo);
            }

            workTaskInfo.setNextStatusIndex(nextFlowConfigDetail.getNodeIndex());
            workTaskInfo.setNextStatusCode(nextFlowConfigDetail.getNodeCode());
            workTaskInfo.setNextStatusCodeName(nextFlowConfigDetail.getNodeName());
            workTaskInfo.setNextPlat(nextFlowConfigDetail.getNodePlat());
            if (flowConfigDetail.getNodeOptName().equals("下发") || flowConfigDetail.getNodeName().equals("下发")) {
                workTaskInfo.setTaskStatus(1);
            }

        } else {
            workTaskInfo.setStatusCode("");
            workTaskInfo.setStatusCodeName("已完成");
            workTaskInfo.setNextStatusIndex(-1);
            workTaskInfo.setRealFinishTime(new Date());
            workTaskInfo.setNextStatusCodeName("");
            workTaskInfo.setNextStatusCode("");
            workTaskInfo.setNextUser("");
            workTaskInfo.setRealStartTime(new Date());
            workTaskInfo.setTaskStatus(WORK_TASK_STATUS_FINISH);
        }
    }

    private boolean checkFinalExamine(TbWorkFlowConfigDetail flowConfigDetail, TbWorkTaskInfo taskInfo) {
        if (flowConfigDetail.getNodeCode().startsWith("EXAMINE")) {
            //判断验收人
            if (StringUtils.isNotEmpty(taskInfo.getCheckUser())) {
                JSONObject obj = JSONObject.parseObject(taskInfo.getCheckUser());
                if (obj.getString("value").equals(flowConfigDetail.getNodeNo())) {
                    return true;
                } else {
                    return false;
                }
//                List<String> roleList = Arrays.asList(flowConfigDetail.getNodeRole().split(","));
//                if (roleList.contains(obj.getString("value"))) {
//                    return true;
//                } else {
//                    return false;
//                }
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * 获取直接指定的用户
     *
     * @param flowConfigDetail
     * @param detailJson
     * @return
     */
    private String getNextUser(TbWorkFlowConfigDetail flowConfigDetail, JSONObject detailJson) {
        if (flowConfigDetail.getFieldList() != null) {
            for (int i = 0; i < flowConfigDetail.getFieldList().size(); i++) {
                TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = flowConfigDetail.getFieldList().get(i);
                if (workFlowConfigDetailExtend.getIsNextUser().equals(1)) {
                    if (detailJson.containsKey(workFlowConfigDetailExtend.getFieldCode())) {
                        return detailJson.getJSONObject(workFlowConfigDetailExtend.getFieldCode()).getString("userCode");
                    }
                }
            }
        }

        return null;
    }

    private void setTaskDetalInfo(TbWorkTaskInfo workTaskInfo, TbWorkTaskInfo newWorkTaskInfo) {
        Field[] targetFields = workTaskInfo.getClass().getDeclaredFields();
        Field[] sourceFields = newWorkTaskInfo.getClass().getDeclaredFields();
        for (int i = 0; i < sourceFields.length; i++) {
            Field sourceField = sourceFields[i];
            if (Modifier.isStatic(sourceField.getModifiers())) {
                continue;
            }
            Field targetField = targetFields[i];
            if (Modifier.isStatic(targetField.getModifiers())) {
                continue;
            }
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                if (!(sourceField.get(newWorkTaskInfo) == null)) {
                    targetField.set(workTaskInfo, sourceField.get(newWorkTaskInfo));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            sourceField.setAccessible(false);
            targetField.setAccessible(false);
        }
    }


    /**
     * 创建工作流程主表
     *
     * @param user
     * @param flowConfigDetail
     * @param nextFlowConfigDetail
     * @return
     */
    private TbWorkTaskInfo setNewWorkTaskInfo(TbWorkTaskInfo workTaskInfo, TbUser user, TbWorkFlowConfigDetail flowConfigDetail, TbWorkFlowConfigDetail nextFlowConfigDetail) {

        workTaskInfo.setNextPlat(nextFlowConfigDetail.getNodePlat());
        workTaskInfo.setCreateUser(user.getCode());
        workTaskInfo.setCreateUserName(user.getName());
        workTaskInfo.setNextStatusIndex(nextFlowConfigDetail.getNodeIndex());
        JSONArray relatedUserArray = new JSONArray();
        relatedUserArray.add(user.getCode());
        workTaskInfo.setRelatedUser(relatedUserArray.toJSONString());
        //设置下一步的执行人员 优先指定人员 其次跟前置某步骤一样
        if (StringUtils.isNotEmpty(nextFlowConfigDetail.getNodeUserCode())) {
            workTaskInfo.setNextUser(nextFlowConfigDetail.getNodeUserCode());
        } else if (nextFlowConfigDetail.getNodeUserIndex() != null && nextFlowConfigDetail.getNodeUserIndex() > 0) {
            if (StringUtils.isNotEmpty(workTaskInfo.getTaskNo())) {
                TbWorkTaskInfoExtend workTaskInfoExtend = getWorkFlowInfoExtend(workTaskInfo.getTaskNo(), nextFlowConfigDetail.getNodeUserIndex());
                if (workTaskInfoExtend != null) {
                    workTaskInfo.setNextUser(workTaskInfoExtend.getCommitUserCode());
                } else {
                    workTaskInfo.setNextUser(user.getCode());
                }
            } else {
                workTaskInfo.setNextUser(user.getCode());
            }

        } else if (StringUtils.isNotEmpty(nextFlowConfigDetail.getNodeRole())) {
            String[] roleList = nextFlowConfigDetail.getNodeRole().split(",");
            String[] orgList = nextFlowConfigDetail.getNodeRoleOrg().split(",");
            JSONArray array = new JSONArray();
            for (int i = 0; i < roleList.length; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("org", orgList[i]);
                jsonObject.put("role", roleList[i]);
                array.add(jsonObject);
            }
            workTaskInfo.setNextRole(array.toString());
        }

        workTaskInfo.setDeleteFlag(Dict.DELETE_NO);
        workTaskInfo.setTaskNo(StringTools.getUUID());

        workTaskInfo.setNextStatusCode(nextFlowConfigDetail.getNodeCode());
        workTaskInfo.setNextStatusCodeName(nextFlowConfigDetail.getNodeName());
        workTaskInfo.setStatusIndex(flowConfigDetail.getNodeIndex());
        workTaskInfo.setStatusCode(flowConfigDetail.getNodeCode());
        workTaskInfo.setStatusCodeName(flowConfigDetail.getNodeName());
        workTaskInfo.setWorkFlowConfigNo(flowConfigDetail.getConfigNo());
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(workTaskInfo.getOrgNo());
        int taskCount = getTaskCount(workTaskInfo.getPlanStartTime()) + 1;
        String taskCode = taskCount + "";
        if (taskCount <= 10) {
            taskCode = "00" + taskCount;
        } else if (taskCount <= 100) {
            taskCode = "0" + taskCount;
        }
        if (workTaskInfo.getTaskType().intValue() == WX_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "WX" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "WX" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        } else if (workTaskInfo.getTaskType().intValue() == DX_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "DX" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "DX" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        } else if (workTaskInfo.getTaskType().intValue() == WB_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "WB" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "WB" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        } else if (workTaskInfo.getTaskType().intValue() == FF_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "FF" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "FF" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        } else if (workTaskInfo.getTaskType().intValue() == GYTZ_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "GYTZ" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "GYTZ" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        } else if (workTaskInfo.getTaskType().intValue() == SBTZ_TYPE) {
            workTaskInfo.setTaskCode(factoryInfo.getBrowsename() + "SBTZ" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
            workTaskInfo.setPlanCode(factoryInfo.getBrowsename() + "SBTZ" + DateUtils.formateMyDate(workTaskInfo.getPlanStartTime(), "yyyyMMdd") + taskCode);
        }

        return workTaskInfo;
    }

    private int getTaskCount(Date startTime) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        example.createCriteria().andPlanStartTimeGreaterThanOrEqualTo(startTime).andPlanStartTimeLessThan(DateUtils.getNextDate(startTime, 1));
        return workTaskInfoMapper.countByExample(example);
    }


    /**
     * 创建工作流程具体步骤表
     *
     * @param taskNo
     * @param flowConfigDetail
     * @param user
     * @return
     */
    private TbWorkTaskInfoExtend createNewExtend(String taskNo, TbWorkFlowConfigDetail flowConfigDetail, String user, String userCode) {
        TbWorkTaskInfoExtend workFlowExtend = new TbWorkTaskInfoExtend();
        workFlowExtend.setExtendNo(StringTools.getUUID());
        workFlowExtend.setTaskNo(taskNo);
        workFlowExtend.setCommitUser(user);
        workFlowExtend.setCommitUserCode(userCode);
        workFlowExtend.setCommitTime(new Date());
        workFlowExtend.setValidStatus(0);
        workFlowExtend.setStatusIndex(flowConfigDetail.getNodeIndex());
        workFlowExtend.setStatusCodeName(flowConfigDetail.getNodeOptName());
        //将步骤的配置信息保存起来
        workFlowExtend.setNodeConfigDetail(JSON.toJSONString(flowConfigDetail));
        return workFlowExtend;
    }

    /**
     * 根据工作流编号查询个步骤信息
     *
     * @param taskNo
     * @return
     */
    private List<TbWorkTaskInfoExtend> getWorkTaskInfoExtendList(String taskNo, boolean valid) {
        TbWorkTaskInfoExtendExample workFlowExtendExample = new TbWorkTaskInfoExtendExample();
        TbWorkTaskInfoExtendExample.Criteria criteria = workFlowExtendExample.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        if (valid) {
            criteria.andValidStatusEqualTo(WorkFlowCommon.FLOW_NORM);
        }
        workFlowExtendExample.setOrderByClause(" commit_time ");
        return workTaskInfoExtendMapper.selectByExample(workFlowExtendExample);
    }


    /**
     * 校验是否重复提交和是否权限正常
     *
     * @return
     */
    private int checkWorkFlow(TbWorkTaskInfo workTaskInfo, Integer statusIndex, TbUser user) {
        //如果已经提交的步骤不是应该执行的步骤
        if (!statusIndex.equals(workTaskInfo.getNextStatusIndex())) {
            return Dict.AjaxStatus.RECOMMITE.getStatusCode();
        }
        if (user.getCode().equals(workTaskInfo.getNextUser())) {

        }


        return Dict.AjaxStatus.YES.getStatusCode();
    }


    /**
     * 获取当前步骤的下一步骤
     *
     * @param workFlowConfigDetail
     * @param detailInfo
     * @return
     */
    private TbWorkFlowConfigDetail getNextWorkFlowConfigDetail(TbWorkFlowConfigDetail workFlowConfigDetail, JSONObject detailInfo, String flowNo) {
        TbWorkFlowConfigDetail nextWorkFlowConfigDetail = null;
        if (StringUtils.isNotEmpty(workFlowConfigDetail.getLinkedNodes())) {
            JSONArray linkedArray = JSONArray.parseArray(workFlowConfigDetail.getLinkedNodes());
            //获取下一步骤
            if (linkedArray.size() == 1) {
                Integer linkedNode = linkedArray.getJSONObject(0).getIntValue("routeIndex");
                nextWorkFlowConfigDetail = getNextWorkFlowDetail(workFlowConfigDetail.getConfigNo(), linkedNode);
            } else if (linkedArray.size() > 1) {
                //如果有多个连接
                int nodeIndex = linkedArray.getJSONObject(0).getIntValue("nodeIndex");
                String routeKey = linkedArray.getJSONObject(0).getString("routeKey");
                String value = "";
                //使用判定值就在当前步骤
                if (nodeIndex == workFlowConfigDetail.getNodeIndex().intValue()) {
                    value = detailInfo.get(routeKey).toString();
                } else {
                    value = getRouteValue(flowNo, nodeIndex, routeKey, workFlowConfigDetail.getConfigNo());
                }


                for (int i = 0; i < linkedArray.size(); i++) {
                    //如果路由能匹配
                    if (value.equals(linkedArray.getJSONObject(i).getString("routeValue"))) {
                        Integer linkedNode = linkedArray.getJSONObject(i).getIntValue("routeIndex");
                        nextWorkFlowConfigDetail = getNextWorkFlowDetail(workFlowConfigDetail.getConfigNo(), linkedNode);
                    }
                }
            }
        }
        return nextWorkFlowConfigDetail;
    }

    private TbWorkFlowConfigDetail getNextWorkFlowDetail(String flowNo, Integer nodeIndex) {
        TbWorkFlowConfigDetailExample example = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteria = example.createCriteria();
        criteria.andConfigNoEqualTo(flowNo);
        criteria.andNodeIndexEqualTo(nodeIndex);
        List<TbWorkFlowConfigDetail> list = workFlowConfigDetailMapper.selectByExample(example);
        return list.size() == 1 ? list.get(0) : null;
    }

    /**
     * 获取路由值
     *
     * @param taskNo       工作流NO
     * @param nodeIndex    步骤节点 NULL则是任务主属性
     * @param routeKey     路由配置的字段
     * @param flowConfigNo 工作流配置NO
     * @return
     */
    private String getRouteValue(String taskNo, Integer nodeIndex, String routeKey, String flowConfigNo) {
        TbWorkFlowConfig workFlowConfig = workFlowConfigMapper.selectByPrimaryKey(flowConfigNo);
        String flowCode = workFlowConfig.getFlowCode();
        List<String> extendNoList = new ArrayList<>();
        if (nodeIndex != null) {
            TbWorkTaskInfoExtend workFlowInfoExtend = getWorkFlowInfoExtend(taskNo, nodeIndex);
            extendNoList.add(workFlowInfoExtend.getExtendNo());
        }

        JSONObject taskJSON = null;
        JSONObject extendJSON = null;
        //维修工单

        TbWorkTaskInfo taskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
        taskJSON = JSON.parseObject(JSON.toJSONString(taskInfo));
        if (extendNoList.size() > 0) {

        }

        if (extendJSON != null) {
            if (extendJSON.containsKey(routeKey)) {
                return extendJSON.get(routeKey).toString();
            } else if (taskJSON != null) {
                if (taskJSON.containsKey(routeKey)) {
                    return taskJSON.get(routeKey).toString();
                }
            }
            return null;

        } else {
            return taskJSON.get(routeKey).toString();
        }
    }

    /**
     * 根据工作流NO和步骤编号查找步骤详情
     *
     * @param taskNo
     * @param nodeIndex
     * @return
     */
    private TbWorkTaskInfoExtend getWorkFlowInfoExtend(String taskNo, Integer nodeIndex) {
        TbWorkTaskInfoExtendExample extendExample = new TbWorkTaskInfoExtendExample();
        TbWorkTaskInfoExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        if (nodeIndex != null) {
            criteria.andStatusIndexEqualTo(nodeIndex);
        }
        criteria.andValidStatusEqualTo(WorkFlowCommon.FLOW_NORM.intValue());
        List<TbWorkTaskInfoExtend> list = workTaskInfoExtendMapper.selectByExample(extendExample);
        return list.size() == 1 ? list.get(0) : null;
    }

    /**
     * 获取上一步骤
     *
     * @param workFlowConfigDetailList
     * @param index
     * @return
     */
    private TbWorkFlowConfigDetail getLastNode(List<TbWorkFlowConfigDetail> workFlowConfigDetailList, int index) {
        for (TbWorkFlowConfigDetail workFlowConfigDetail : workFlowConfigDetailList) {
            JSONArray array = JSONArray.parseArray(workFlowConfigDetail.getLinkedNodes());
            for (int i = 0; i < array.size(); i++) {
                if (array.getJSONObject(i).getIntValue("routeIndex") == index) {
                    return workFlowConfigDetail;
                }
            }
        }
        return null;
    }

    /**
     * 获取上一步骤
     *
     * @param workFlowConfigDetailList
     * @param index
     * @return
     */
    private TbWorkFlowConfigDetail getCurrentNode(List<TbWorkFlowConfigDetail> workFlowConfigDetailList, int index) {
        for (TbWorkFlowConfigDetail workFlowConfigDetail : workFlowConfigDetailList) {
            if (workFlowConfigDetail.getNodeIndex() == index) {
                return workFlowConfigDetail;
            }
        }
        return null;
    }

    /**
     * 驳回操作
     */
    private TbWorkTaskInfoExtend callbackWorkFlowDetail(List<TbWorkFlowConfigDetail> workFlowConfigDetailList, List<TbWorkTaskInfoExtend> extendList, int index, int returnNode) {
        TbWorkTaskInfoExtend currentNode = null;

        for(int i=extendList.size()-1;i>=0;i--){
            TbWorkTaskInfoExtend workTaskInfoExtend =  extendList.get(i);
            if (workTaskInfoExtend.getStatusIndex().equals(returnNode)) {
                currentNode = workTaskInfoExtend;
                workTaskInfoExtend.setValidStatus(2);
                workTaskInfoExtendMapper.updateByPrimaryKeySelective(workTaskInfoExtend);
                break;

            }else{
                workTaskInfoExtend.setValidStatus(2);
                workTaskInfoExtendMapper.updateByPrimaryKeySelective(workTaskInfoExtend);
            }
        }
        return  currentNode;


    }

    /**
     * 设置退回
     *
     * @param extendList
     * @param flowIndex
     */
    private TbWorkTaskInfoExtend updateWorkTaskInfoExtend(List<TbWorkTaskInfoExtend> extendList, Integer flowIndex) {
        for (TbWorkTaskInfoExtend workTaskInfoExtend : extendList) {
            if (workTaskInfoExtend.getValidStatus().intValue() == 0) {
                if (flowIndex.equals(workTaskInfoExtend.getStatusIndex())) {
                    workTaskInfoExtend.setValidStatus(2);
                    workTaskInfoExtendMapper.updateByPrimaryKeySelective(workTaskInfoExtend);
                    return workTaskInfoExtend;
                }
            }
        }
        return null;
    }

    /**
     * 任务回退
     *
     * @param workTaskInfo
     * @param workFlowConfigDetail
     * @param workTaskInfoExtend
     */
    private void callbackWorkFlow(TbWorkTaskInfo workTaskInfo,  TbWorkFlowConfigDetail workFlowConfigDetail, TbWorkFlowConfigDetail nextWorkFlowConfigDetail, TbWorkTaskInfoExtend workTaskInfoExtend) {
        workTaskInfo.setNextStatusCodeName(nextWorkFlowConfigDetail.getNodeName());
        workTaskInfo.setNextStatusCode(nextWorkFlowConfigDetail.getNodeCode());
        workTaskInfo.setNextStatusIndex(nextWorkFlowConfigDetail.getNodeIndex());
        workTaskInfo.setNextUser(workTaskInfoExtend.getCommitUserCode());
        workTaskInfo.setNextRole("");

        workTaskInfo.setStatusCode(workFlowConfigDetail.getNodeCode());
        workTaskInfo.setStatusIndex(workFlowConfigDetail.getNodeIndex());
        workTaskInfo.setStatusCodeName(workFlowConfigDetail.getNodeName());
        workTaskInfo.setNextPlat(2);
        workTaskInfoMapper.updateByPrimaryKeySelective(workTaskInfo);
    }

    /**
     * 添加下一步的工作流程
     *
     * @param lastWorkFlowConfig
     * @param user
     */
    private void addNextWorkTaskInfo(TbWorkFlowConfig lastWorkFlowConfig, TbUser user, JSONObject lostPostJson, TbWorkTaskInfo workTaskInfo, TbWorkFlowConfigDetail lastWorkFlowConfigDetail) throws Exception {
        TbWorkFlowConfig workFlowConfig = getWorkFlowConfigByCode(lastWorkFlowConfig.getOrgNo(), lastWorkFlowConfig.getNextFlowCode());
        TbWorkFlowConfigDetail configDetail = new TbWorkFlowConfigDetail();
        configDetail.setConfigNo(workFlowConfig.getFlowNo());
        //获取细节步骤
        List<TbWorkFlowConfigDetail> detailList = getWorkFlowDetailList(configDetail);
        //获取当前步骤
        TbWorkFlowConfigDetail workFlowConfigDetail = detailList.get(0);

        String flowCode = workFlowConfig.getFlowCode();
        switch (flowCode) {
            case WBGD:


                break;
            default:
                break;
        }

    }

    @Override
    public int deleteWorkFlowInfo(String flowNo) {
        return 0;
    }

    @Override
    public List<TbEquipTaskFile> getFileList(TbEquipTaskFile equipTaskFile) {
        TbEquipTaskFileExample equipTaskFileExample = new TbEquipTaskFileExample();
        TbEquipTaskFileExample.Criteria criteria = equipTaskFileExample.createCriteria();
        criteria.andOfTaskNoEqualTo(equipTaskFile.getOfTaskNo());
        return fileMapper.selectByExample(equipTaskFileExample);
    }

    @Override
    public int addTaskFile(TbEquipTaskFile equipTaskFile) {
        equipTaskFile.setOfTaskStatus(0);
        equipTaskFile.setOfUploadTime(new Date());
        equipTaskFile.setOfFileStatus(0);
        equipTaskFile.setOfNo(StringTools.getUUID());
        return fileMapper.insertSelective(equipTaskFile);
    }

    @Override
    public int deleteTaskFile(TbEquipTaskFile equipTaskFile) {
        return fileMapper.deleteByPrimaryKey(equipTaskFile.getOfNo());
    }

    @Override
    public int getWorkFlowDetail(String taskNo, String orgNo, Integer nodeIndex, String flowCode, Map<String, Object> map) {
        TbWorkFlowConfig workFlowConfig = getWorkFlowConfigByCode(orgNo, flowCode);
        if (workFlowConfig == null) {
            return Dict.AjaxStatus.NOFIND.getStatusCode();
        }
        TbWorkFlowConfigDetail configDetail = new TbWorkFlowConfigDetail();
        configDetail.setConfigNo(workFlowConfig.getFlowNo());
        //获取细节步骤
        List<TbWorkFlowConfigDetail> detailList = getWorkFlowDetailList(configDetail);
        //获取流程的表单
        getField(workFlowConfig.getFlowNo(), detailList);
        if (nodeIndex != null) {
            TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            List<TbWorkTaskInfoExtend> workTaskInfoExtendList = getWorkTaskInfoExtendList(taskNo, false);
            List<String> extendNoList = workTaskInfoExtendList.stream().map(TbWorkTaskInfoExtend::getExtendNo).collect(Collectors.toList());
            //设备调整
            List detailInfoList = null;
            String lastFlowNo = null;
            if (SBDX.equals(flowCode)) {
                detailInfoList = getOverhaulInfoList(extendNoList);
            } else if (SBWB.equals(flowCode)) {
                detailInfoList = getMaintenanceInfoList(extendNoList);
            } else if (SBWXN.equals(flowCode)) {
                detailInfoList = getRepareInfoList(extendNoList);
            } else if (SBFF.equals(flowCode)) {
                detailInfoList = getMaintenanceInfoList(extendNoList);
            } else if (GYTZ.equals(flowCode)) {
                detailInfoList = getGongyiAdjustList(extendNoList);
            } else if (SBTZ.equals(flowCode)) {
                detailInfoList = getEquipAdjustList(extendNoList);
            }
            getExtendDetail(workTaskInfoExtendList, detailInfoList);

            for (TbWorkFlowConfigDetail workFlowConfigDetail : detailList) {
                if (workFlowConfigDetail.getNodeIndex().equals(nodeIndex)) {
                    map.put("currentNode", workFlowConfigDetail);
                }
            }

            map.put("taskInfo", workTaskInfo);
            //设置返回的已经完成的步骤
            map.put("flowNodeList", workTaskInfoExtendList);
            List<Map<String, Object>> fieldDetailList = new ArrayList<>();
            getDetailMapList(workTaskInfo, workTaskInfoExtendList, fieldDetailList);
            map.put("detailList", fieldDetailList);
            //如果有上一层的流程则获取上一流程的详细信息
            if (StringUtils.isNotEmpty(workFlowConfig.getLastFlowCode())) {
                Map<String, Object> lastMap = new HashMap<>();
                getWorkFlowDetail(lastFlowNo, workFlowConfig.getOrgNo(), WorkFlowCommon.FLOW_CODE_FULL, workFlowConfig.getLastFlowCode(), lastMap);
                map.put("lastFlowInfo", lastMap);
            }
        } else {
            map.put("currentNode", detailList.get(0));
        }
        return Dict.AjaxStatus.YES.getStatusCode();
    }

    @Override
    public TbWorkFlowConfigDetail getFirstWorkFlowNode(String factoryNo, String flowCode) {
        TbWorkFlowConfig workFlowConfig = getWorkFlowConfigByCode(factoryNo, flowCode);
        TbWorkFlowConfigDetail configDetail = new TbWorkFlowConfigDetail();
        configDetail.setConfigNo(workFlowConfig.getFlowNo());
        //获取细节步骤
        List<TbWorkFlowConfigDetail> detailList = getWorkFlowDetailList(configDetail);
        return detailList.size() > 0 ? detailList.get(0) : null;
    }

    private void createNewMaintanance(TbWorkTaskInfo workTaskInfo, TbUser user) {
        TbEquipMaintainFactor equipMaintainFactor = equipMaintainFactorMapper.selectByPrimaryKey(workTaskInfo.getTaskFrom());
        Date nextDate = DateUtils.getNextDate(new Date(), equipMaintainFactor.getCycle());
        logger.info("维保完成data={},cycle={}", DateUtils.formateDateFull(nextDate), equipMaintainFactor.getCycle());
        equipMaintainFactor.setMfTime(nextDate);
        //更新维保要素下一步维保时间
        equipMaintainFactorMapper.updateByPrimaryKey(equipMaintainFactor);
    /*    TbWorkFlowConfigDetail workFlowConfigDetail = getFirstWorkFlowNode(workTaskInfo.getOrgNo(), SBWB);
        JSONObject detailJson = new JSONObject();
        detailJson.put("factoryNo", equipMaintainFactor.getFactoryNo());
        detailJson.put("taskType", WB_TYPE);
        detailJson.put("equipNo", equipMaintainFactor.getEquipNo());
        detailJson.put("taskContent", equipMaintainFactor.getMfContent());
        detailJson.put("maintenanceElementNo", equipMaintainFactor.getMfNo());
        detailJson.put("planStartTime", equipMaintainFactor.getMfTime());
        //设置维保要素编号
        detailJson.put("taskFrom", equipMaintainFactor.getMfNo());
        //设置维保周期
        detailJson.put("planUseTime", equipMaintainFactor.getCycle());
        saveWorkFlowInfo(detailJson, workFlowConfigDetail, user);*/
    }

    @Override
    public int createMaintenanceList(String factoryNo, List<TbEquipMaintainFactor> list, TbUser user) {
        TbWorkFlowConfigDetail workFlowConfigDetail = getFirstWorkFlowNode(factoryNo, SBWB);
        try {
            for (int i = 0; i < list.size(); i++) {
                TbEquipMaintainFactor equipMaintainFactor = list.get(i);
                JSONObject detailJson = new JSONObject();
                detailJson.put("factoryNo", factoryNo);
                detailJson.put("orgNo", factoryNo);
                detailJson.put("taskType", WB_TYPE);
                detailJson.put("equipNo", equipMaintainFactor.getEquipNo());
                detailJson.put("taskContent", equipMaintainFactor.getMfContent());
                detailJson.put("maintenanceElementNo", equipMaintainFactor.getMfNo());
                detailJson.put("planStartTime", equipMaintainFactor.getMfTime());
                //设置维保要素编号
                detailJson.put("taskFrom", equipMaintainFactor.getMfNo());
                //设置维保周期
                detailJson.put("planUseTime", equipMaintainFactor.getCycle());
                detailJson.put("isEntrust", ENTRUST_NO);
                saveWorkFlowInfo(detailJson, workFlowConfigDetail, user);
            }
            return Dict.AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            return Dict.AjaxStatus.SERVICE_RROR.getStatusCode();
        }
    }

    @Override
    public int createMaintenanceAlone(String factoryNo, TbEquipMaintainFactor equipMaintainFactor, TbUser user) {
        TbWorkFlowConfigDetail workFlowConfigDetail = getFirstWorkFlowNode(factoryNo, SBWB);
        TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        workFlowConfigDetailExtend.setNodeNo(workFlowConfigDetail.getNodeNo());
        List<TbWorkFlowConfigDetailExtend> fieldList = getWorkFlowDetailExtendList(workFlowConfigDetailExtend, 1);
        workFlowConfigDetail.setFieldList(fieldList);
        try {
            JSONObject detailJson = new JSONObject();
            detailJson.put("factoryNo", factoryNo);
            detailJson.put("orgNo", factoryNo);
            detailJson.put("taskType", WB_TYPE);
            detailJson.put("equipNo", equipMaintainFactor.getEquipNo());
            detailJson.put("taskContent", equipMaintainFactor.getMfContent());
            detailJson.put("maintenanceElementNo", equipMaintainFactor.getMfNo());
            detailJson.put("planStartTime", equipMaintainFactor.getMfTime());
            //设置维保要素编号
            detailJson.put("taskFrom", equipMaintainFactor.getMfNo());
            //设置维保周期
            detailJson.put("planUseTime", equipMaintainFactor.getCycle());
            detailJson.put("isEntrust", ENTRUST_NO);
            saveWorkFlowInfo(detailJson, workFlowConfigDetail, user);
            return Dict.AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            return Dict.AjaxStatus.SERVICE_RROR.getStatusCode();
        }
    }

    @Autowired
    private TbEquipMaintainFactorService tbEquipMaintainFactorService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createMaintenanceAloneNew(Map map) {
        int flag = 0;
        TbEquipMaintainFactor equipMaintainFactor = (TbEquipMaintainFactor) map.get("tbEquipMaintainFactor");
        Integer whether = (Integer) map.get("whether");
        TbUser user = (TbUser) map.get("user");
        Date taskDate = (Date) map.get("taskDate");
        TbWorkTaskInfo tbWorkTaskInfo = getTbWorkTaskInfo(equipMaintainFactor, taskDate);
        if (equipMaintainFactor != null) {
            equipMaintainFactor.setMfTime(taskDate);
            if (whether == 0) {
                //需要修改
                if (checkSave(tbWorkTaskInfo)) {
                    //存在不管
                } else {
                    flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user,map.get("checkUser").toString());
                }
                tbWorkTaskInfo.setSource(0);
                Date endDate;
                List<TbWorkTaskInfo> unFinishTaskInfoListByPlanTimeList = getUnFinishTaskInfoListByPlanTime(tbWorkTaskInfo);
                if (unFinishTaskInfoListByPlanTimeList != null && unFinishTaskInfoListByPlanTimeList.size() > 0) {
                    for (int i = 0; i < unFinishTaskInfoListByPlanTimeList.size(); i++) {
                        Date nextDate = DateUtils.getNextDate(DateUtils.formateDate(taskDate), (i + 1) * equipMaintainFactor.getCycle());
                        unFinishTaskInfoListByPlanTimeList.get(i).setPlanStartTime(nextDate);
                        flag = updateTbWorkTaskInfo(unFinishTaskInfoListByPlanTimeList.get(i));
                        if (i == unFinishTaskInfoListByPlanTimeList.size() - 1) {
                            endDate = nextDate;
                            //equipMaintainFactor.setMfTime(endDate);
                            //tbEquipMaintainFactorService.updateEquipMaintainFactor(equipMaintainFactor);
                        }
                    }
                } else {
                    //tbEquipMaintainFactorService.updateEquipMaintainFactor(equipMaintainFactor);
                    //flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user);
                }
            } else {
                if (checkSave(tbWorkTaskInfo)) {
                    flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                } else {
                    flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user,map.get("checkUser").toString());
                }
            }
        }
        return flag;
    }

    public Boolean checkSave(TbWorkTaskInfo tbWorkTaskInfo) {
        boolean flag = false;
        tbWorkTaskInfo.setSource(1);
        List<TbWorkTaskInfo> tbWorkTaskInfoList = getUnFinishTaskInfoListByPlanTime(tbWorkTaskInfo);
        if (tbWorkTaskInfoList != null && tbWorkTaskInfoList.size() > 0) {
            flag = true;
        }
        return flag;
    }

    /*
     * 获取里开始时间最近的一条计划
     * */
    public List<TbWorkTaskInfo> getLastTask(TbWorkTaskInfo tbWorkTaskInfo) {
        List<TbWorkTaskInfo> tbWorkTaskInfos = new ArrayList<>();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(tbWorkTaskInfo.getOrgNo());
        //不是取消的
        criteria.andTaskStatusNotEqualTo(-1);
        criteria.andTaskFromEqualTo(tbWorkTaskInfo.getTaskFrom());
        criteria.andPlanStartTimeLessThanOrEqualTo(tbWorkTaskInfo.getPlanStartTime());
        example.setOrderByClause("plan_start_time desc");
        tbWorkTaskInfos = workTaskInfoMapper.selectByExample(example);
        return tbWorkTaskInfos;
    }

    /*
     * 查询大于开始时间的所有计划数据
     * */
    public List<TbWorkTaskInfo> getTaskByStartTime(TbWorkTaskInfo tbWorkTaskInfo) {
        TbWorkTaskInfo tbWorkTaskInfoQ = new TbWorkTaskInfo();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(tbWorkTaskInfo.getOrgNo());
        criteria.andTaskFromEqualTo(tbWorkTaskInfo.getTaskFrom());
        criteria.andPlanStartTimeGreaterThanOrEqualTo(tbWorkTaskInfo.getPlanStartTime());
        return workTaskInfoMapper.selectByExample(example);

    }

 /*   public int deleteTaskByStartAndEnd(TbWorkTaskInfo tbWorkTaskInfo) {
        TbWorkTaskInfo tbWorkTaskInfoQ = new TbWorkTaskInfo();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(tbWorkTaskInfo.getOrgNo());
        criteria.andTaskNoEqualTo(tbWorkTaskInfo.getTaskNo());
       *//* criteria.andTaskFromEqualTo(tbWorkTaskInfo.getTaskFrom());
        criteria.andPlanStartTimeBetween(tbWorkTaskInfo.getPlanStartTime(), tbWorkTaskInfo.getPlanFinishTime());*//*
        return workTaskInfoMapper.deleteByExample(example);
    }*/

    public int deleteTbWorkTaskInfoExtend(String taskNo) {
        TbWorkTaskInfoExtendExample extendExample = new TbWorkTaskInfoExtendExample();
        TbWorkTaskInfoExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        return workTaskInfoExtendMapper.deleteByExample(extendExample);
    }

    public int deleteTbEquipMaintenanceInfo(String extendNo) {
        TbEquipMaintenanceInfoExample extendExample = new TbEquipMaintenanceInfoExample();
        TbEquipMaintenanceInfoExample.Criteria criteria = extendExample.createCriteria();
        criteria.andExtendNoEqualTo(extendNo);
        return equipMaintenanceInfoMapper.deleteByExample(extendExample);
    }

    public TbWorkTaskInfo getTbWorkTaskInfo(TbEquipMaintainFactor equipMaintainFactor, Date taskDate) {
        TbWorkTaskInfo taskInfo = new TbWorkTaskInfo();
        taskInfo.setOrgNo(equipMaintainFactor.getFactoryNo());
        taskInfo.setTaskFrom(equipMaintainFactor.getMfNo());
        taskInfo.setPlanStartTime(taskDate);
        taskInfo.setTaskType(WB_TYPE);
        taskInfo.setTaskStatus(WORK_TASK_STATUS_CANCEL);
        return taskInfo;
    }

    /**
     * 公共维保计划保存
     */
    public int tbEquipMaintainWorkPlanSave(TbEquipMaintainFactor equipMaintainFactor, TbUser user,String checkUser) {
        int flag = 0;
        TbWorkFlowConfigDetail workFlowConfigDetail = getFirstWorkFlowNode(equipMaintainFactor.getFactoryNo(), SBWB);
        TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        workFlowConfigDetailExtend.setNodeNo(workFlowConfigDetail.getNodeNo());
        List<TbWorkFlowConfigDetailExtend> fieldList = getWorkFlowDetailExtendList(workFlowConfigDetailExtend, 1);
        workFlowConfigDetail.setFieldList(fieldList);
        try {
            JSONObject detailJson = new JSONObject();
            detailJson.put("factoryNo", equipMaintainFactor.getFactoryNo());
            detailJson.put("orgNo", equipMaintainFactor.getFactoryNo());
            detailJson.put("taskType", WB_TYPE);
            detailJson.put("equipNo", equipMaintainFactor.getEquipNo());
            detailJson.put("taskContent", equipMaintainFactor.getMfContent());
            detailJson.put("maintenanceElementNo", equipMaintainFactor.getMfNo());
            detailJson.put("planStartTime", equipMaintainFactor.getMfTime());
            detailJson.put("checkUser", checkUser);
            //设置维保要素编号
            detailJson.put("taskFrom", equipMaintainFactor.getMfNo());
            //设置维保周期
            detailJson.put("planUseTime", equipMaintainFactor.getCycle());
            detailJson.put("isEntrust", ENTRUST_NO);
            flag = saveWorkFlowInfo(detailJson, workFlowConfigDetail, user);
        } catch (Exception ex) {
            flag = Dict.AjaxStatus.SERVICE_RROR.getStatusCode();
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createBatchMaintenancePlan(TbEquipMaintainWorkCondition condition, TbUser user) {
        int flag = 0;
        String equipNo = "";
        List<String> mfNoLkist = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        if (condition != null) {
            dayList = DateUtils.getDistDayList(condition.getBeginTime(), condition.getEndTime());
            equipNo = condition.getEquipNo();
            mfNoLkist = condition.getMfNoLkist();
            //需要覆盖
            if ("0".equals(equipNo) && mfNoLkist.size() == 1 && "0".equals(mfNoLkist.get(0))) {
                //选的都是全部
                TbEquipMaintainFactor tbEquipMaintainFactor = new TbEquipMaintainFactor();
                tbEquipMaintainFactor.setFactoryNo(condition.getFactoryNo());
                List<TbEquipMaintainFactor> tbEquipMaintainFactorList = tbEquipMaintainFactorMapper.selcetTbEquipMaintainFactorList(tbEquipMaintainFactor);
                if (tbEquipMaintainFactorList != null && tbEquipMaintainFactorList.size() > 0) {
                    flag = allTbEquipMaintain(dayList, tbEquipMaintainFactorList, condition, user);
                }
            } else {
                if (mfNoLkist.size() == 1 && mfNoLkist.get(0).equals("0")) {
                    mfNoLkist.get(0).equals("0");
                    //根据设备查询所有维保项
                    TbEquipMaintainFactor tbEquipMaintainFactor = new TbEquipMaintainFactor();
                    tbEquipMaintainFactor.setEquipNo(condition.getEquipNo());
                    tbEquipMaintainFactor.setFactoryNo(condition.getFactoryNo());
                    List<TbEquipMaintainFactor> tbEquipMaintainFactorList = tbEquipMaintainFactorMapper.selcetTbEquipMaintainFactorList(tbEquipMaintainFactor);
                    if (tbEquipMaintainFactorList != null && tbEquipMaintainFactorList.size() > 0) {
                        flag = allTbEquipMaintain(dayList, tbEquipMaintainFactorList, condition, user);
                    }
                } else {
                    if (mfNoLkist.contains("0")) {
                        TbEquipMaintainFactor tbEquipMaintainFactor = new TbEquipMaintainFactor();
                        tbEquipMaintainFactor.setEquipNo(condition.getEquipNo());
                        tbEquipMaintainFactor.setFactoryNo(condition.getFactoryNo());
                        List<TbEquipMaintainFactor> tbEquipMaintainFactorList = tbEquipMaintainFactorMapper.selcetTbEquipMaintainFactorList(tbEquipMaintainFactor);
                        if (tbEquipMaintainFactorList != null && tbEquipMaintainFactorList.size() > 0) {
                            flag = allTbEquipMaintain(dayList, tbEquipMaintainFactorList, condition, user);
                        }
                    } else {
                        List<TbEquipMaintainFactor> tbEquipMaintainFactorList = new ArrayList<>();
                        for (String mfNo : mfNoLkist) {
                            TbEquipMaintainFactor equipMaintainFactor = tbEquipMaintainFactorMapper.selectByPrimaryKey(mfNo);
                            tbEquipMaintainFactorList.add(equipMaintainFactor);
                        }
                        if (tbEquipMaintainFactorList != null && tbEquipMaintainFactorList.size() > 0) {
                            flag = allTbEquipMaintain(dayList, tbEquipMaintainFactorList, condition, user);
                        }
                    }
                }

            }

        }
        return flag;
    }

    public int allTbEquipMaintain(List<String> dayList, List<TbEquipMaintainFactor> tbEquipMaintainFactorList, TbEquipMaintainWorkCondition condition, TbUser user) {
        int flag = 0;
        for (TbEquipMaintainFactor equipMaintainFactor : tbEquipMaintainFactorList) {
            flag = data(equipMaintainFactor, condition, dayList, user);
        }
        return flag;
    }

    public int data(TbEquipMaintainFactor equipMaintainFactor, TbEquipMaintainWorkCondition condition, List<String> dayList, TbUser user) {
        int flag = 0;
        //查询大于开始时间的数据
        TbWorkTaskInfo tbWorkTaskInfoTime = new TbWorkTaskInfo();
        tbWorkTaskInfoTime.setTaskType(WB_TYPE);
        tbWorkTaskInfoTime.setPlanStartTime(DateUtils.parseDate(dayList.get(0)));
        tbWorkTaskInfoTime.setTaskFrom(equipMaintainFactor.getMfNo());
        tbWorkTaskInfoTime.setOrgNo(equipMaintainFactor.getFactoryNo());
        List<TbWorkTaskInfo> taskByStartTimeList = getTaskByStartTime(tbWorkTaskInfoTime);

        TbWorkTaskInfo tbWorkTaskInfoQ = new TbWorkTaskInfo();
        tbWorkTaskInfoQ.setOrgNo(equipMaintainFactor.getFactoryNo());
        tbWorkTaskInfoQ.setTaskFrom(equipMaintainFactor.getMfNo());
        tbWorkTaskInfoQ.setPlanStartTime((DateUtils.parseDate(dayList.get(0))));
        //查询离当前时间最近的一次时间
        List<TbWorkTaskInfo> lastTask = getLastTask(tbWorkTaskInfoQ);
        if (taskByStartTimeList != null && taskByStartTimeList.size() > 0) {
            for (TbWorkTaskInfo taskInfo : taskByStartTimeList) {
                logger.info("需要删除的数据长度TaskByStartTimeList={}", taskByStartTimeList.size());
                workTaskInfoMapper.deleteByPrimaryKey(taskInfo.getTaskNo());
            }
            Calendar ca = Calendar.getInstance();
            if(lastTask!=null && lastTask.size()>0){
                ca.setTime(lastTask.get(0).getPlanStartTime());
            }else {
                ca.setTime(DateUtils.parseDate(dayList.get(0)));
            }
            while (true) {
                if(lastTask!=null && lastTask.size()>0){
                    if (lastTask.get(0).getPlanStartTime() != null) {
                        ca.add(Calendar.DATE, equipMaintainFactor.getCycle());
                        Long startMills = DateUtils.parseDate(dayList.get(0)).getTime();
                        Long endMills = DateUtils.parseDate(dayList.get(dayList.size() - 1)).getTime();
                        if (ca.getTimeInMillis() >= startMills) {
                            if (ca.getTimeInMillis() <= endMills) {
                                //设置插入
                                equipMaintainFactor.setMfTime(ca.getTime());
                                TbWorkTaskInfo tbWorkTaskInfo = new TbWorkTaskInfo();
                                tbWorkTaskInfo.setTaskType(WB_TYPE);
                                tbWorkTaskInfo.setCheckUser(condition.getCheckUser());
                                tbWorkTaskInfo.setPlanStartTime(equipMaintainFactor.getMfTime());
                                tbWorkTaskInfo.setTaskFrom(equipMaintainFactor.getMfNo());
                                flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user,condition.getCheckUser());
                                logger.info("计划时间,mfno={},mfConte={},周期={},时间={}", equipMaintainFactor.getMfNo(), equipMaintainFactor.getMfContent(), equipMaintainFactor.getCycle(), DateUtils.formateDate(equipMaintainFactor.getMfTime()));
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }else {
                    if (dayList.get(0) != null) {
                        ca.add(Calendar.DATE, equipMaintainFactor.getCycle());
                        Long startMills = DateUtils.parseDate(dayList.get(0)).getTime();
                        Long endMills = DateUtils.parseDate(dayList.get(dayList.size() - 1)).getTime();
                        if (ca.getTimeInMillis() >= startMills) {
                            if (ca.getTimeInMillis() <= endMills) {
                                //设置插入
                                equipMaintainFactor.setMfTime(ca.getTime());
                                TbWorkTaskInfo tbWorkTaskInfo = new TbWorkTaskInfo();
                                tbWorkTaskInfo.setTaskType(WB_TYPE);
                                tbWorkTaskInfo.setPlanStartTime(equipMaintainFactor.getMfTime());
                                tbWorkTaskInfo.setTaskFrom(equipMaintainFactor.getMfNo());
                                flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user,condition.getCheckUser());
                                logger.info("计划时间,mfno={},mfConte={},周期={},时间={}", equipMaintainFactor.getMfNo(), equipMaintainFactor.getMfContent(), equipMaintainFactor.getCycle(), DateUtils.formateDate(equipMaintainFactor.getMfTime()));
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }

            }
        } else {
            Calendar ca = Calendar.getInstance();
            ca.setTime(DateUtils.parseDate(dayList.get(0)));
            while (true) {
                if (dayList.get(0) != null) {
                    ca.add(Calendar.DATE, equipMaintainFactor.getCycle());
                    Long startMills = DateUtils.parseDate(dayList.get(0)).getTime();
                    Long endMills = DateUtils.parseDate(dayList.get(dayList.size() - 1)).getTime();
                    if (ca.getTimeInMillis() >= startMills) {
                        if (ca.getTimeInMillis() <= endMills) {
                            //设置插入
                            equipMaintainFactor.setMfTime(ca.getTime());
                            TbWorkTaskInfo tbWorkTaskInfo = new TbWorkTaskInfo();
                            tbWorkTaskInfo.setTaskType(WB_TYPE);
                            tbWorkTaskInfo.setPlanStartTime(equipMaintainFactor.getMfTime());
                            tbWorkTaskInfo.setTaskFrom(equipMaintainFactor.getMfNo());
                            flag = tbEquipMaintainWorkPlanSave(equipMaintainFactor, user, condition.getCheckUser());
                            logger.info("计划时间,mfno={},mfConte={},周期={},时间={}", equipMaintainFactor.getMfNo(), equipMaintainFactor.getMfContent(), equipMaintainFactor.getCycle(), DateUtils.formateDate(equipMaintainFactor.getMfTime()));
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return flag;
    }

    private void getDetailMapList(TbWorkTaskInfo workTaskInfo, List<TbWorkTaskInfoExtend> list, List<Map<String, Object>> detailList) {
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            TbWorkTaskInfoExtend workTaskInfoExtend = list.get(i);
            map.put("commitTime", DateUtils.formateDateFull(workTaskInfoExtend.getCommitTime()));
            map.put("commitUser", workTaskInfoExtend.getCommitUser());
            map.put("validStatus", workTaskInfoExtend.getValidStatus());
            map.put("statusCodeName", workTaskInfoExtend.getStatusCodeName());
            JSONObject json = JSON.parseObject(workTaskInfoExtend.getNodeConfigDetail());
            map.put("nodeNeedCheck", json.getIntValue("nodeNeedCheck"));
            JSONArray fieldList = json.getJSONArray("fieldList");
            JSONObject taskJson = JSON.parseObject(JSON.toJSONString(workTaskInfo));
            List<Map<String, Object>> detailMapList = new ArrayList<>();
            if (workTaskInfoExtend.getDetailInfo() == null) {
                continue;
            }
            JSONObject detailJson = JSON.parseObject(JSON.toJSONString(workTaskInfoExtend.getDetailInfo()));
            for (int n = 0; n < fieldList.size(); n++) {
                JSONObject field = fieldList.getJSONObject(n);
                if (field.getIntValue("isShow") == 1) {
                    Map<String, Object> detailMap = new HashMap<>();
                    detailMap.put("fieldType", field.getIntValue("fieldType"));
                    detailMap.put("fieldCode", field.getString("fieldCode"));
                    detailMap.put("fieldName", field.getString("fieldName"));
                    detailMap.put("isShow", field.getIntValue("isShow"));
                    detailMap.put("isForce", field.getIntValue("isForce"));
                    if (detailJson.containsKey(field.getString("fieldCode"))) {
                        detailMap.put("fieldValue", detailJson.get(field.getString("fieldCode")) == null ? "" : detailJson.get(field.getString("fieldCode")));
                        detailMap.put("oldValue", detailJson.get(field.getString("fieldCode")) == null ? "" : detailJson.get(field.getString("fieldCode")));
                    } else {
                        detailMap.put("fieldValue", taskJson.get(field.getString("fieldCode")) == null ? "" : taskJson.get(field.getString("fieldCode")));
                        detailMap.put("oldValue", taskJson.get(field.getString("fieldCode")) == null ? "" : taskJson.get(field.getString("fieldCode")));
                    }
                    int fieldType = field.getIntValue("fieldType");
                    if (fieldType == 203 || fieldType == 204) {
                        getMultiListValue(detailMap, field);
                    }
                    if (fieldType == 202 || fieldType == 207) {
                        getMultiSelectListValue(detailMap, field);
                    }
                    if (fieldType == 205 || fieldType == 206) {
                        getUserSelectValue(detailMap, field);
                    }
                    if (fieldType == 201) {
                        getSingleListValue(detailMap, field);
                    }
                    if (fieldType == 105) {
                        if (detailMap.get("fieldValue") != null) {
                            if (detailMap.get("fieldValue") != null && StringUtils.isNotEmpty(detailMap.get("fieldValue").toString())) {
                                Date dateValue = new Date((long) detailMap.get("fieldValue"));
                                detailMap.put("fieldValue", DateUtils.formateDate(dateValue));
                                detailMap.put("oldValue", DateUtils.formateDate(dateValue));
                            }
                        }
                    }
                    if (fieldType == 106) {
                        if (detailMap.get("fieldValue") != null) {
                            if (detailMap.get("fieldValue") != null && StringUtils.isNotEmpty(detailMap.get("fieldValue").toString())) {
                                Date dateValue = new Date((long) detailMap.get("fieldValue"));
                                detailMap.put("fieldValue", DateUtils.formateDateFull(dateValue));
                                detailMap.put("oldValue", DateUtils.formateDate(dateValue));
                            }
                        }
                    }
                    if (detailMap.get("fieldValue") == null || "null".equals(detailMap.get("fieldValue").toString())) {
                        detailMap.put("fieldValue", "");
                    }
                    detailMapList.add(detailMap);
                }
            }
            map.put("fieldValueList", detailMapList);
            detailList.add(map);

        }
    }

    private void getSingleListValue(Map<String, Object> detailMap, JSONObject field) {
        if (detailMap.get("fieldValue") == null) {
            detailMap.put("fieldValue", "");
            return;
        }
        System.out.println(field.getString("fieldSelectUrl"));
        if (StringUtils.isNotEmpty(field.getString("fieldSelectUrl"))) {
            JSONObject jsonObject = JSONObject.parseObject(detailMap.get("fieldValue").toString());
            if(jsonObject!=null){
                detailMap.put("fieldValue", jsonObject.getString("text"));
            }

        } else {
            if (detailMap.containsKey("fieldValue") && StringUtils.isNotEmpty(detailMap.get("fieldValue").toString())) {
                int valueKey = Integer.valueOf(detailMap.get("fieldValue").toString());
                JSONArray fieldArray = field.getJSONArray("filedSelect");
                if(fieldArray!=null){
                    for (int i = 0; i < fieldArray.size(); i++) {
                        JSONObject jsonObject = fieldArray.getJSONObject(i);
                        if (jsonObject.getIntValue("key") == valueKey) {
                            detailMap.put("fieldValue", jsonObject.getString("value"));
                        }
                    }
                }
            }
        }


    }

    private void getMultiSelectListValue(Map<String, Object> detailMap, JSONObject field) {
        JSONArray array = JSONArray.parseArray(detailMap.get("fieldValue").toString());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.size(); i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(array.getJSONObject(i).getString("text"));
        }
        detailMap.put("fieldValue", stringBuffer.toString());
    }

    private void getMultiListValue(Map<String, Object> detailMap, JSONObject field) {
        JSONArray array = new JSONArray();
        if (detailMap.get("fieldValue") != null && StringUtils.isNotEmpty(detailMap.get("fieldValue").toString())) {
            array = JSONArray.parseArray(detailMap.get("fieldValue").toString());
        } else {
            detailMap.put("fieldValue", new String[0]);
            return;
        }
        String[] infos = new String[array.size()];
        JSONObject fieldJson = field.getJSONObject("commitFields");
        if (field.getIntValue("fieldType") == 204) {
            for (int i = 0; i < array.size(); i++) {
                if (StringUtils.isNotEmpty(array.getJSONObject(i).getString(fieldJson.getString("nameField")))) {
                    if (StringUtils.isNotEmpty(array.getJSONObject(i).getString(fieldJson.getString("nameField")).split(",")[1])) {
                        infos[i] = array.getJSONObject(i).getString(fieldJson.getString("nameField")).split(",")[1];
                    } else {
                        infos[i] = "";
                    }

                } else {
                    infos[i] = "";
                }
            }
        }

        if (field.getIntValue("fieldType") == 203) {
            for (int i = 0; i < array.size(); i++) {
                if (array.getJSONObject(i).containsKey(fieldJson.getString("nameField"))) {
                    //如果两个值中间的一个为空 则不加载

                    StringBuffer sb = new StringBuffer();
                    if (StringUtils.isNotEmpty(array.getJSONObject(i).getString(fieldJson.getString("nameField")))) {
                        String[] strs = array.getJSONObject(i).getString(fieldJson.getString("nameField")).split(",");
                        String name = strs.length > 1 ? strs[1] : strs[0];

                        sb.append("【");
                        sb.append(name);
                        sb.append("】");

                    }
                    if (StringUtils.isNotEmpty(array.getJSONObject(i).getString(fieldJson.getString("valueField")))) {
                        int value = array.getJSONObject(i).getIntValue(fieldJson.getString("valueField"));
                        String title = fieldJson.getString("label");
                        sb.append(title);
                        sb.append("【");
                        sb.append(value);
                        sb.append("】");
                    }


                    infos[i] = sb.toString();
                }

            }
        }
        detailMap.put("fieldValue", infos);
    }

    private void getUserSelectValue(Map<String, Object> detailMap, JSONObject field) {

        if (field.getIntValue("fieldType") == 205) {
            JSONObject json = JSONObject.parseObject(detailMap.get("fieldValue").toString());
            detailMap.put("fieldValue", json.getString("userName"));
        }
        if (field.getIntValue("fieldType") == 206) {
            JSONArray array = JSONArray.parseArray(detailMap.get("fieldValue").toString());
            if (array != null && array.size() > 0) {
                StringBuffer userNames = new StringBuffer();
                for (int i = 0; i < array.size(); i++) {
                    if (i > 0) {
                        userNames.append(",");
                    }
                    userNames.append(array.getJSONObject(i).getString("userName"));

                }
                detailMap.put("fieldValue", userNames.toString());
            } else {
                detailMap.put("fieldValue", "");
            }

        }

    }

    /**
     * 获取工作流步骤的详细信息
     *
     * @param extendList
     * @param detailList
     */
    private void getExtendDetail(List<TbWorkTaskInfoExtend> extendList, List detailList) {
        for (TbWorkTaskInfoExtend workTaskInfoExtend : extendList) {
            for (int i = 0; i < detailList.size(); i++) {
                WorkFlowExtendI workFlowExtendI = (WorkFlowExtendI) detailList.get(i);
                if (workTaskInfoExtend.getExtendNo().equals(workFlowExtendI.getExtendNo())) {
                    workTaskInfoExtend.setDetailInfo(workFlowExtendI);
                }
            }
        }
    }


    private List<TbEquipRepareInfo> getRepareInfoList(List<String> extendList) {
        TbEquipRepareInfoExample example = new TbEquipRepareInfoExample();
        TbEquipRepareInfoExample.Criteria criteria = example.createCriteria();
        criteria.andExtendNoIn(extendList);
        return equipRepareInfoMapper.selectByExample(example);
    }

    private List<TbEquipOverhaulInfo> getOverhaulInfoList(List<String> extendList) {
        TbEquipOverhaulInfoExample example = new TbEquipOverhaulInfoExample();
        TbEquipOverhaulInfoExample.Criteria criteria = example.createCriteria();
        criteria.andExtendNoIn(extendList);
        return equipOverhaulInfoMapper.selectByExample(example);
    }

    private List<TbEquipMaintenanceInfo> getMaintenanceInfoList(List<String> extendList) {
        TbEquipMaintenanceInfoExample example = new TbEquipMaintenanceInfoExample();
        TbEquipMaintenanceInfoExample.Criteria criteria = example.createCriteria();
        criteria.andExtendNoIn(extendList);
        return equipMaintenanceInfoMapper.selectByExample(example);
    }

    private List<TbGongyiAdjust> getGongyiAdjustList(List<String> extendList) {
        TbGongyiAdjustExample example = new TbGongyiAdjustExample();
        example.createCriteria().andFlowNoIn(extendList);
        return gongyiAdjustMapper.selectByExample(example);
    }

    private List<TbEquipAdjust> getEquipAdjustList(List<String> extendList) {
        TbEquipAdjustExample example = new TbEquipAdjustExample();
        example.createCriteria().andFlowNoIn(extendList);
        return equipAdjustMapper.selectByExample(example);
    }

    /**
     * 获取各个步骤的表单字段
     *
     * @param configNo
     * @param finishDetailList
     */
    private void getField(String configNo, List<TbWorkFlowConfigDetail> finishDetailList) {
        TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend = new TbWorkFlowConfigDetailExtend();
        workFlowConfigDetailExtend.setFlowNo(configNo);
        List<TbWorkFlowConfigDetailExtend> list = getWorkFlowDetailExtendList(workFlowConfigDetailExtend, 1);
        Map<String, List<TbWorkFlowConfigDetailExtend>> extendListMap = new HashMap<>(16);

        for (TbWorkFlowConfigDetailExtend detailExtend : list) {
            if (extendListMap.containsKey(detailExtend.getNodeNo())) {
                extendListMap.get(detailExtend.getNodeNo()).add(detailExtend);
            } else {
                List<TbWorkFlowConfigDetailExtend> childList = new ArrayList<>();
                childList.add(detailExtend);
                extendListMap.put(detailExtend.getNodeNo(), childList);
            }
        }
        for (TbWorkFlowConfigDetail workFlowConfigDetailL : finishDetailList) {
            workFlowConfigDetailL.setFieldList(extendListMap.get(workFlowConfigDetailL.getNodeNo()));
        }
        List<TbWorkFlowConfigDetailExtend> buttonList = getWorkFlowDetailExtendList(workFlowConfigDetailExtend, 2);
        Map<String, List<TbWorkFlowConfigDetailExtend>> buttonListMap = new HashMap<>(16);
        if (buttonList.size() > 0) {
            for (TbWorkFlowConfigDetailExtend detailExtend : buttonList) {
                if (buttonListMap.containsKey(detailExtend.getNodeNo())) {
                    buttonListMap.get(detailExtend.getNodeNo()).add(detailExtend);
                } else {
                    List<TbWorkFlowConfigDetailExtend> childList = new ArrayList<>();
                    childList.add(detailExtend);
                    buttonListMap.put(detailExtend.getNodeNo(), childList);
                }
            }
        }
        for (TbWorkFlowConfigDetail workFlowConfigDetailL : finishDetailList) {
            workFlowConfigDetailL.setButtonList(buttonListMap.get(workFlowConfigDetailL.getNodeNo()));
        }

    }

    public List<TbWorkFlowConfigDetailExtend> getWorkFlowDetailExtendList(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend, Integer type) {
        TbWorkFlowConfigDetailExtendExample extendExample = new TbWorkFlowConfigDetailExtendExample();
        TbWorkFlowConfigDetailExtendExample.Criteria criteria = extendExample.createCriteria();
        if (StringUtils.isNotEmpty(workFlowConfigDetailExtend.getNodeNo())) {
            criteria.andNodeNoEqualTo(workFlowConfigDetailExtend.getNodeNo());
        }
        if (StringUtils.isNotEmpty(workFlowConfigDetailExtend.getFlowNo())) {
            criteria.andFlowNoEqualTo(workFlowConfigDetailExtend.getFlowNo());
        }
        if (type == 1) {
            criteria.andFieldTypeGreaterThan(100);
        } else {
            criteria.andFieldTypeLessThan(100);
        }

        extendExample.setOrderByClause(" field_index ");
        return workFlowConfigDetailExtendMapper.selectByExample(extendExample);
    }

    /**
     * 工作流程查询参数
     */
    public static class WorkTaskQueryParam {
        private String factoryNo;
        private String equipNo;
        private List<String> equipNoList;
        private Date beginDate;
        private Date endDate;
        private String equipName;
        private String taskContent;
        private Integer taskType;
        private Integer urgencyDegree;
        private String taskNo;

        public Date getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getEquipName() {
            return equipName;
        }

        public void setEquipName(String equipName) {
            this.equipName = equipName;
        }

        public String getTaskContent() {
            return taskContent;
        }

        public void setTaskContent(String taskContent) {
            this.taskContent = taskContent;
        }

        public String getFactoryNo() {
            return factoryNo;
        }

        public void setFactoryNo(String factoryNo) {
            this.factoryNo = factoryNo;
        }

        public String getEquipNo() {
            return equipNo;
        }

        public void setEquipNo(String equipNo) {
            this.equipNo = equipNo;
        }

        public Integer getTaskType() {
            return taskType;
        }

        public void setTaskType(Integer taskType) {
            this.taskType = taskType;
        }

        public Integer getUrgencyDegree() {
            return urgencyDegree;
        }

        public void setUrgencyDegree(Integer urgencyDegree) {
            this.urgencyDegree = urgencyDegree;
        }

        public String getTaskNo() {
            return taskNo;
        }

        public void setTaskNo(String taskNo) {
            this.taskNo = taskNo;
        }

        public List<String> getEquipNoList() {
            return equipNoList;
        }

        public void setEquipNoList(List<String> equipNoList) {
            this.equipNoList = equipNoList;
        }
    }

    @Override
    public List<TbWorkTaskInfo> getWokTaskPLanList(WorkTaskQueryParam workTaskQueryParam) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        //未结束
        //水厂条件
        if (StringUtils.isNotEmpty(workTaskQueryParam.getFactoryNo())) {
            criteria.andOrgNoEqualTo(workTaskQueryParam.getFactoryNo());
        }
        /// criteria.andPlanStartTimeGreaterThanOrEqualTo(DateUtils.parseDate(DateUtils.formateDate(new Date())));
        if (workTaskQueryParam.getBeginDate() != null) {
            criteria.andPlanStartTimeGreaterThanOrEqualTo(workTaskQueryParam.getBeginDate());
        }
        if (workTaskQueryParam.getEndDate() != null) {
            criteria.andPlanStartTimeLessThan(DateUtils.getNextDate(workTaskQueryParam.getEndDate(), 1));
        }
        //工单类型参数
        if (workTaskQueryParam.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(workTaskQueryParam.getTaskType());
        }
        //设备参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipNo())) {
            criteria.andEquipNoEqualTo(workTaskQueryParam.getEquipNo());
        }
        if(workTaskQueryParam.getEquipNoList()!=null){
            criteria.andEquipNoIn(workTaskQueryParam.getEquipNoList());
        }

        if (workTaskQueryParam.getUrgencyDegree() != null) {
            criteria.andUrgencyDegreeEqualTo(workTaskQueryParam.getUrgencyDegree());
        }
        //工单内容参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getTaskContent())) {
            criteria.andTaskContentLike("%" + workTaskQueryParam.getTaskContent() + "%");
        }
        criteria.andTaskStatusBetween(WORK_TASK_STATUS_CANCEL, WORK_TASK_STATUS_PLAN);
        example.setOrderByClause(" plan_start_time desc,update_time desc");
        return workTaskInfoMapper.selectByExample(example);
    }

    @Override
    public int editPlan(TbWorkTaskInfo taskInfo) {
        taskInfo.setUpdateTime(new Date());
        if (workTaskInfoMapper.updateByPrimaryKeySelective(taskInfo) > 0) {
            return Dict.AjaxStatus.YES.getStatusCode();
        } else {
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }
    }

    @Override
    public TbWorkTaskInfo getTbWorkTaskInfo(TbWorkTaskInfo workTaskQueryParam) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        //水厂条件
        if (StringUtils.isNotEmpty(workTaskQueryParam.getOrgNo())) {
            criteria.andOrgNoEqualTo(workTaskQueryParam.getOrgNo());
        }
        if (workTaskQueryParam.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(workTaskQueryParam.getTaskType());
        }
        if (workTaskQueryParam.getTaskFrom() != null) {
            criteria.andTaskFromEqualTo(workTaskQueryParam.getTaskFrom());
        }
        example.setOrderByClause(" plan_start_time desc,update_time desc");
        return workTaskInfoMapper.selectByExample(example).size() > 0 ? workTaskInfoMapper.selectByExample(example).get(0) : null;
    }

    @Override
    public List<Map<String, String>> getCheckUserList(String workFlowConfigNo) {
        TbWorkFlowConfigDetail workFlowConfigDetailCurrent = workFlowConfigDetailMapper.selectByPrimaryKey(workFlowConfigNo);
        TbWorkFlowConfigDetail workFlowConfigDetailSearch = new TbWorkFlowConfigDetail();
        workFlowConfigDetailSearch.setConfigNo(workFlowConfigDetailCurrent.getConfigNo());
        List<TbWorkFlowConfigDetail> detailList = getWorkFlowDetailList(workFlowConfigDetailSearch);
        List<Map<String, String>> checkRoleList = new ArrayList<>();
        //List<TbRole> tbRoleList = getRoleList();
        List<String> roleList = new ArrayList<>();
        for (TbWorkFlowConfigDetail workFlowConfigDetail : detailList) {
            if (workFlowConfigDetail.getNodeCode().startsWith("EXAMINE")) {
//                String[] roles = workFlowConfigDetail.getNodeRole().split(",");
//                for (int i = 0; i < roles.length; i++) {
//                    for (TbRole tbRole : tbRoleList) {
//                        if (roles[i].equals(tbRole.getCode())) {
//                            if (!roleList.contains(tbRole.getCode())) {
//                                Map<String, String> map = new HashMap<>();
//                                map.put("value", tbRole.getCode());
//                                map.put("text", tbRole.getName());
//                                checkRoleList.add(map);
//                                roleList.add(tbRole.getCode());
//                            }
//                        }
//                    }
//                }

                Map<String, String> map = new HashMap<>();
                map.put("value", workFlowConfigDetail.getNodeNo());
                map.put("text", workFlowConfigDetail.getNodeName());
                checkRoleList.add(map);
            }
        }
        return checkRoleList;
    }

    @Override
    public int editMantenPlan(TbWorkTaskInfo taskInfo, TbUser user) {
        int flag = 0;
        TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskInfo.getTaskNo());
        TbWorkTaskInfo tbWorkTaskInfoQ = new TbWorkTaskInfo();
        tbWorkTaskInfoQ.setOrgNo(taskInfoQ.getOrgNo());
        tbWorkTaskInfoQ.setTaskFrom(taskInfoQ.getTaskFrom());
        tbWorkTaskInfoQ.setPlanStartTime((taskInfo.getPlanStartTime()));
        //List<TbWorkTaskInfo> tbWorkTaskInfoList = checkTbWorkTaskInfo(tbWorkTaskInfoQ);
        TbEquipMaintainFactor equipMaintainFactor = tbEquipMaintainFactorMapper.selectByPrimaryKey(taskInfoQ.getTaskFrom());
        if (taskInfo.getWhether() == 0) {
            //是否影响后续计划 0是 1否
            //查询大于等于页面传的时间的数据
            List<TbWorkTaskInfo> planStartTimeList = getWorkTaskInfoByPlanStartTime(tbWorkTaskInfoQ);
            if (planStartTimeList != null && planStartTimeList.size() > 0) {
                if (taskInfoQ != null) {
                    if (taskInfo.getTaskNo().equals(taskInfoQ.getTaskNo())) {
                        flag = workTaskInfoMapper.updateByPrimaryKeySelective(taskInfo);
                    } else {
                        flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                    }
                } else {
                    flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                }
                //修改后续的时
                for (int i = 0; i < planStartTimeList.size(); i++) {

                    logger.info("shi间={}", DateUtils.getNextDate((DateUtils.formateDate(taskInfo.getPlanStartTime())), (i + 1) * equipMaintainFactor.getCycle()));
                    planStartTimeList.get(i).setPlanStartTime(DateUtils.getNextDate((DateUtils.formateDate(taskInfo.getPlanStartTime())), (i + 1) * equipMaintainFactor.getCycle()));

                    logger.info("计划时间mfno={},mfConte={},周期={},时间={}", equipMaintainFactor.getMfNo(), equipMaintainFactor.getMfContent(), equipMaintainFactor.getCycle(), DateUtils.formateDate(planStartTimeList.get(i).getPlanStartTime()));
                    flag = workTaskInfoMapper.updateByPrimaryKeySelective(planStartTimeList.get(i));
                }
            } else {
                if (taskInfoQ != null) {
                    if (taskInfo.getTaskNo().equals(taskInfoQ.getTaskNo())) {
                        flag = workTaskInfoMapper.updateByPrimaryKeySelective(taskInfo);
                    } else {
                        flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                    }
                } else {
                    flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                }
            }
        } else {
            if (taskInfoQ != null) {
                if (taskInfo.getTaskNo().equals(taskInfoQ.getTaskNo())) {
                    flag = workTaskInfoMapper.updateByPrimaryKeySelective(taskInfo);
                } else {
                    flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
                }
            } else {
                flag = workTaskInfoMapper.updateByPrimaryKeySelective(taskInfo);
            }
        }

        return flag;
    }

    @Override
    public List<Map<String, Object>> getTaskStaticByGongYi(Date date, String factoryNo, TbUser user) {
        TbDictExample dictExample = new TbDictExample();
        dictExample.createCriteria().andParentIdEqualTo(9);
        List<TbDict> dictList = dictMapper.selectByExample(dictExample);
        //获取工单计划
        List<TbWorkTaskInfo> planList = getTaskInfoPlanList(factoryNo, null, date, user);
        //获取工单
        List<TbWorkTaskInfo> taskList = getMyTaskInfoList(factoryNo, user, 1, null, date, null);
        List<String> equipNoList = new ArrayList<>();
        for (TbWorkTaskInfo workTaskInfo : planList) {
            if (!equipNoList.contains(workTaskInfo.getEquipNo())) {
                equipNoList.add(workTaskInfo.getEquipNo());
            }
        }
        for (TbWorkTaskInfo workTaskInfo : taskList) {
            if (!equipNoList.contains(workTaskInfo.getEquipNo())) {
                equipNoList.add(workTaskInfo.getEquipNo());
            }
        }
        if (equipNoList.size() == 0) {
            return new ArrayList<>();
        }
        ;

        TbEquipInfoExample equipInfoExample = new TbEquipInfoExample();
        equipInfoExample.createCriteria().andEquipNoIn(equipNoList);
        List<TbEquipInfo> equipInfoList = equipInfoMapper.selectByExample(equipInfoExample);
        if (equipInfoList.size() == 0) {
            return new ArrayList<>();
        }
        Map<String, Map<Integer, Map<String, Object>>> detailStaticMap = new LinkedHashMap<>();
        for (TbWorkTaskInfo workTaskInfo : planList) {
            getStaticInfo(equipInfoList, detailStaticMap, workTaskInfo);
        }
        for (TbWorkTaskInfo workTaskInfo : taskList) {
            getStaticInfo(equipInfoList, detailStaticMap, workTaskInfo);
        }

        List<Map<String, Object>> list = new ArrayList<>();

        for (Map.Entry<String, Map<Integer, Map<String, Object>>> entry : detailStaticMap.entrySet()) {
            String gongyi = entry.getKey();
            String gongyiName = getGongYiName(dictList, gongyi);
            Map<String, Object> staticMap = new HashedMap();
            staticMap.put("gongyi", gongyi);
            staticMap.put("gongyiName", gongyiName);
            List<Map<String, Object>> taskStaticList = new ArrayList<>();
            for (Map.Entry<Integer, Map<String, Object>> taskEntry : entry.getValue().entrySet()) {
                Map<String, Object> taskMap = new HashedMap();
                taskMap.put("count", taskEntry.getValue().get("count"));
                taskMap.put("taskType", taskEntry.getKey());
                taskMap.put("hasErgency", taskEntry.getValue().get("hasErgency"));
                taskStaticList.add(taskMap);
            }
            staticMap.put("taskList", taskStaticList);
            list.add(staticMap);
        }

        return list;
    }

    private String getGongYiName(List<TbDict> dictList, String gongyi) {
        for (TbDict dict : dictList) {
            if (dict.getKeyName().equals(gongyi)) {
                return dict.getValueName();
            }
        }
        return null;
    }

    /**
     * 分工艺段和类型统计工单数量
     *
     * @param equipInfoList
     * @param detailStaticMap
     * @param workTaskInfo
     */
    private void getStaticInfo(List<TbEquipInfo> equipInfoList, Map<String, Map<Integer, Map<String, Object>>> detailStaticMap, TbWorkTaskInfo workTaskInfo) {
        String gongyi = getEquipGongYi(equipInfoList, workTaskInfo.getEquipNo());
        Integer taskType = workTaskInfo.getTaskType();
        if (gongyi == null) {
            return;
        }
        if (detailStaticMap.containsKey(gongyi)) {
            Map<String, Object> detailMap = null;
            if (detailStaticMap.get(gongyi).containsKey(taskType)) {
                detailMap = detailStaticMap.get(gongyi).get(taskType);
            } else {
                detailMap = new HashedMap();
                detailMap.put("count", 0);
                detailMap.put("taskType", taskType);
                detailMap.put("hasErgency", 0);
                detailStaticMap.get(gongyi).put(taskType, detailMap);
            }
            if (workTaskInfo.getUrgencyDegree().equals(1)) {
                detailMap.put("hasErgency", 1);
            }
            detailMap.put("count", Integer.valueOf(detailMap.get("count").toString()) + 1);
        } else {
            Map<String, Object> detailMap = new HashedMap();
            detailMap.put("count", 1);
            detailMap.put("taskType", taskType);
            detailMap.put("hasErgency", 0);
            if (workTaskInfo.getUrgencyDegree().equals(1)) {
                detailMap.put("hasErgency", 1);
            }
            Map<Integer, Map<String, Object>> typeMap = new LinkedHashMap<>();
            typeMap.put(taskType, detailMap);
            detailStaticMap.put(gongyi, typeMap);
        }
    }

    private String getEquipGongYi(List<TbEquipInfo> equipInfoList, String equipNo) {
        for (TbEquipInfo equipInfo : equipInfoList) {
            if (equipInfo.getEquipNo().equals(equipNo)) {
                return equipInfo.getInstallationSite();
            }
        }
        return null;
    }

    public List<TbWorkTaskInfo> checkTbWorkTaskInfo(TbWorkTaskInfo tbWorkTaskInfo) {
        List<TbWorkTaskInfo> tbWorkTaskInfos = new ArrayList<>();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(tbWorkTaskInfo.getOrgNo());
        //不是取消的
        criteria.andTaskStatusNotEqualTo(-1);
        criteria.andTaskFromEqualTo(tbWorkTaskInfo.getTaskFrom());
        criteria.andPlanStartTimeEqualTo(tbWorkTaskInfo.getPlanStartTime());
        example.setOrderByClause("plan_start_time desc,update_time desc");
        tbWorkTaskInfos = workTaskInfoMapper.selectByExample(example);
        return tbWorkTaskInfos;
    }

    public List<TbWorkTaskInfo> getWorkTaskInfoByPlanStartTime(TbWorkTaskInfo tbWorkTaskInfo) {
        List<TbWorkTaskInfo> tbWorkTaskInfos = new ArrayList<>();
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrgNoEqualTo(tbWorkTaskInfo.getOrgNo());
        //不是取消的
        criteria.andTaskStatusNotEqualTo(-1);
        criteria.andTaskFromEqualTo(tbWorkTaskInfo.getTaskFrom());
        criteria.andPlanStartTimeGreaterThan(tbWorkTaskInfo.getPlanStartTime());
        example.setOrderByClause("plan_start_time");
        tbWorkTaskInfos = workTaskInfoMapper.selectByExample(example);
        return tbWorkTaskInfos;

    }

    @Override
    public List<TbWorkTaskInfo> getALLTaskList(WorkTaskQueryParam workTaskQueryParam) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        TbWorkTaskInfoExample.Criteria criteria = example.createCriteria();
        //未结束
        //水厂条件
        if (StringUtils.isNotEmpty(workTaskQueryParam.getFactoryNo())) {
            criteria.andOrgNoEqualTo(workTaskQueryParam.getFactoryNo());
        }
        if (workTaskQueryParam.getBeginDate() != null) {
            criteria.andPlanStartTimeGreaterThanOrEqualTo(workTaskQueryParam.getBeginDate());
        }
        if (workTaskQueryParam.getEndDate() != null) {
            criteria.andPlanStartTimeLessThan(DateUtils.getNextDate(workTaskQueryParam.getEndDate(), 1));
        }

        //工单类型参数
        if (workTaskQueryParam.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(workTaskQueryParam.getTaskType());
        }
        //设备参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipNo())) {
            criteria.andEquipNoEqualTo(workTaskQueryParam.getEquipNo());
        }
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipName())) {
            List<String> equipNoList = getEquipNoListByEquipName(workTaskQueryParam.getFactoryNo(), workTaskQueryParam.getEquipName());
            if (equipNoList != null) {
                criteria.andEquipNoIn(equipNoList);
            }
        }
        if (workTaskQueryParam.getUrgencyDegree() != null) {
            criteria.andUrgencyDegreeEqualTo(workTaskQueryParam.getUrgencyDegree());
        }
        //工单内容参数
        if (StringUtils.isNotEmpty(workTaskQueryParam.getTaskContent())) {
            criteria.andTaskContentLike("%" + workTaskQueryParam.getTaskContent() + "%");
        }
        example.setOrderByClause(" plan_start_time desc,update_time desc");
        return workTaskInfoMapper.selectByExample(example);
    }

    @Autowired
    private BewgService bewgService;

    @Override
    public Map queryGYEffct(TbWorkTaskInfo taskInfo) {
        Map map = new HashMap(16);
        TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskInfo.getTaskNo());
        BewgPointCondition condition = new BewgPointCondition();
        if (taskInfoQ.getRealFinishTime() == null) {
            long firstL = 1800000;
            condition.setStartTime(DateUtils.dateFormatFullXG(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(new Date()), -1)));
            ////调整时间的后5个小时
            condition.setEndTime(DateUtils.dateFormatFullXG(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(new Date()), 5)));

        } else {
            //调整时间的前一个小时
            condition.setStartTime(DateUtils.dateFormatFullXG(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(taskInfoQ.getRealFinishTime()), -1)));

            if(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(taskInfoQ.getRealFinishTime()), 5).getTime()>System.currentTimeMillis()){
                condition.setEndTime(DateUtils.dateFormatFullXG(new Date()));
            }else {
                //调整时间的后5个小时
                condition.setEndTime(DateUtils.dateFormatFullXG(DateUtils.getNextHourFullXG(DateUtils.dateFormatFullXG(taskInfoQ.getRealFinishTime()), 5)));

            }


        }
        String equipList = taskInfoQ.getEquipList();
        if (equipList != null) {
            JSONArray jsonArray = JSONArray.parseArray(equipList);
            List<String> pathList = new ArrayList<>();
            List<String> uriList = new ArrayList<>();
            List<String> nameList = new ArrayList<>();
            for (int t = 0; t < jsonArray.size(); t++) {
                JSONObject jsonObject = jsonArray.getJSONObject(t);
                uriList.add(jsonObject.get("value").toString());
                nameList.add(jsonObject.get("text").toString());
            }
            //查询测点名称
            List<TbSynObject> tbSynObjects = tbSynObjectMapper.selectBatchUris(uriList);
            pathList = tbSynObjects.stream().map(e -> e.getBrowsepath()).collect(Collectors.toList());
            //指标数据tbSynObjects=[{"accesslevel":"m3","browsename":"FT_ACC","browsepath":"/Hollysys_Bewg_modelNew/5c662ed96201b70001413521/IWM/IW_FTA_1/FT_ACC","createTime":1562083205000,"displayname":"实测累积流量","factoryNo":"5c662ed96201b70001413521","factoryUri":"/Hollysys_Bewg_modelNew/5c662ed96201b70001413521","fieldType":2,"fieldUri":"/system/2004","hasvalue":1,"level":4,"name":"实测累积流量","parentUri":"/Hollysys_Bewg_modelNew/5c76a276f0313e000133ed96","tbChildSynObjectList":[],"type":4,"uri":"/Hollysys_Bewg_modelNew/5c76a276f0313e000133eda5"},{"accesslevel":"m3/h","browsename":"FT","browsepath":"/Hollysys_Bewg_modelNew/5c662ed96201b70001413521/IWM/IW_FTA_1/FT","createTime":1562083205000,"displayname":"实测瞬时流量","factoryNo":"5c662ed96201b70001413521","factoryUri":"/Hollysys_Bewg_modelNew/5c662ed96201b70001413521","fieldType":2,"fieldUri":"/system/2004","hasvalue":1,"level":4,"name":"实测瞬时流量","parentUri":"/Hollysys_Bewg_modelNew/5c76a276f0313e000133ed96","tbChildSynObjectList":[],"type":4,"uri":"/Hollysys_Bewg_modelNew/5c76a276f0313e000133eda6"}]
            condition.setPathList(pathList);
            logger.info("指标数据tbSynObjects={}", JSON.toJSONString(nameList));
            logger.info("请求和利时指标数据condition={}", JSON.toJSONString(condition));
            JSONObject jsonObject = bewgService.queryHistory(condition);
            //data={"msg":"","result":[{"historyData":[{"s":0,"t":1569034679000,"v":681889.0}]},{"historyData":[{"s":0,"t":1569034679000,"v":511.326019}]}],"code":"0x00000000"}
            List<Map> values = new ArrayList<>();
            List timeList = new ArrayList();
            if (jsonObject != null) {
                JSONArray objectJSONArray = jsonObject.getJSONArray("result");
                if (objectJSONArray != null && objectJSONArray.size() > 0) {
                    //[{"historyData":[{"s":0,"t":1569034679000,"v":681889.0}]},{"historyData":[{"s":0,"t":1569034679000,"v":511.326019}]}]
                    JSONArray historyData1 = objectJSONArray.getJSONObject(0).getJSONArray("historyData");
                    for (int i = 0; i < historyData1.size(); i++) {
                        timeList.add(DateUtils.dateFormatFullXG(new Date((Long) historyData1.getJSONObject(i).get("t"))));


                    }
                    for (int t = 0; t < objectJSONArray.size(); t++) {
                        List list = new ArrayList();
                        JSONArray historyData = objectJSONArray.getJSONObject(t).getJSONArray("historyData");
                        for (int i = 0; i < historyData.size(); i++) {
                            List obj = new ArrayList();
                            obj.add(DateUtils.dateFormatFullXG(new Date((Long) historyData.getJSONObject(i).get("t"))));
                            obj.add(historyData.getJSONObject(i).get("v"));
                            list.add(obj);
                            // list.add(historyData.getJSONObject(i).get("v"));
                        }
                        Map obj = new HashMap();
                        obj.put("name", nameList.get(t));
                        obj.put("type", "line");
                        obj.put("data", list);
                        values.add(obj);
                    }
                }
            }
            //[["2019",'1'],[2]]
            //Map<String, List<Map>> name = values.stream().collect(Collectors.groupingBy(e -> e.get("name").toString()));
            map.put("nameValue", values);
            map.put("titleName", nameList);
            map.put("timeName", timeList);
            map.put("adjustTime", DateUtils.dateFormatFullXG(taskInfoQ.getRealFinishTime() == null ? new Date() : taskInfoQ.getRealFinishTime()));
        }

        logger.info("返回数据map={}", JSON.toJSONString(map));
        return map;
    }
}

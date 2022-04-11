package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbRoutingModelCondition;
import com.ejobim.opplat.domain.condition.TbRoutingTaskConditon;
import com.ejobim.opplat.domain.vo.RoutingLocationVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationElementVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationFillElementVo;
import com.ejobim.opplat.domain.vo.TbRoutingTaskVo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.service.RoutingService;
import com.ejobim.opplat.service.SchedulingService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.Dict.*;
import static com.ejobim.opplat.common.WorkFlowCommon.TEMP_NO;
import static com.ejobim.opplat.common.WorkFlowCommon.TEMP_YES;

/**
 * 巡检填报相关配置
 *
 * @author xibian
 */
@Service
public class RoutingServiceImpl implements RoutingService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int flag = 0;

    /**
     * 巡检点Mapper
     */
    @Autowired
    TbRoutingLocationMapper routingLocationMapper;

    /**
     * 巡检点设备Mapper
     */
    @Autowired
    TbRoutingLocatioinEquipMapper routingLocationEquipMapper;

    /**
     * 巡检要素Mapper
     */
    @Autowired
    TbRoutingLocationElementMapper routingLocationElementMapper;

    /**
     * 巡检模式Mapper
     */
    @Autowired
    TbRoutingModelMapper routingModelMapper;

    /**
     * 巡检模式详情
     */
    @Autowired
    TbRoutingModelExtendMapper routingModelExtendMapper;

    @Autowired
    TbRoutingTaskMapper routingTaskMapper;

    @Autowired
    TbRoutingTaskDetailMapper routingTaskDetailMapper;

    @Autowired
    TbFactoryInfoMapper tbFactoryInfoMapper;

    @Autowired
    BewgService bewgService;

    @Autowired
    TbEquipInfoMapper equipInfoMapper;

    @Autowired
    TbEquipFaultInfoMapper equipFaultInfoMapper;

    @Autowired
    SchedulingService schedulingService;

    @Autowired
    TbSchedulingPlanMapper tbSchedulingPlanMapper;

    @Autowired
    TbRoutingTrajectoryMapper routingTrajectoryMapper;

    @Autowired
    TbParameterConfigMapper tbParameterConfigMapper;

    @Autowired
    private TbNfcInfoMapper tbNfcInfoMapper;

    @Autowired
    private TbRoutingLocatioinEquipMapper tbRoutingLocatioinEquipMapper;

    @Autowired
    private TbOrgMapper orgMapper;

    @Autowired
    private ReportService reportService;

    @Override
    public List<TbRoutingLocation> getRoutingLocationList(TbRoutingLocation routingLocation) {
        TbRoutingLocationExample example = new TbRoutingLocationExample();
        TbRoutingLocationExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(routingLocation.getFactoryNo());
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        if (routingLocation.getSource() != null) {
            if (routingLocation.getSource() == 0) {
                if (StringUtils.isNotEmpty(routingLocation.getLocationName())) {
                    criteria.andLocationNameLike("%" + routingLocation.getLocationName() + "%");
                }
            } else {
                if (StringUtils.isNotEmpty(routingLocation.getLocationName())) {
                    criteria.andLocationNameEqualTo(routingLocation.getLocationName());
                }
            }
        }
        example.setOrderByClause("location_sort");
        return routingLocationMapper.selectByExample(example);
    }

    @Override
    public int insertRoutingLocation(TbRoutingLocation routingLocation) {
        flag = 0;
        //根据水厂和巡检点名称,顺序
        List<TbRoutingLocation> routingLocationList = routingLocationMapper.selectCheckRoutingLocationList(routingLocation);
        //List<TbRoutingLocation> routingLocationList = getCommonRoutingLocationList(routingLocation);
        if (routingLocationList != null && routingLocationList.size() > 0) {
            flag = Dict.AjaxStatus.LOCATTION_NAME_REPEAT.getStatusCode();
        } else {
            routingLocation.setLocationNo(StringTools.getUUID());
            flag = routingLocationMapper.insertSelective(routingLocation);
        }
        return flag;
    }

    public List<TbRoutingLocation> getCommonRoutingLocationList(TbRoutingLocation routingLocation) {
        TbRoutingLocation routingLocationQ = new TbRoutingLocation();
        routingLocationQ.setFactoryNo(routingLocation.getFactoryNo());
        routingLocationQ.setLocationName(routingLocation.getLocationName());
        routingLocationQ.setSource(1);
        List<TbRoutingLocation> routingLocationList = getRoutingLocationList(routingLocationQ);
        return routingLocationList;
    }

    @Override
    public int updateRoutingLocation(TbRoutingLocation routingLocation) {
        flag = 0;
        //List<TbRoutingLocation> routingLocationList = getCommonRoutingLocationList(routingLocation);
        List<TbRoutingLocation> routingLocationList = routingLocationMapper.selectCheckRoutingLocationList(routingLocation);
        if (routingLocationList != null && routingLocationList.size() > 0) {
            for (TbRoutingLocation tbRoutingLocation : routingLocationList) {
                if (!routingLocation.getLocationNo().equals(tbRoutingLocation.getLocationNo())) {
                    flag = Dict.AjaxStatus.LOCATTION_NAME_REPEAT.getStatusCode();
                    break;
                } else {
                    flag = routingLocationMapper.updateByPrimaryKeySelective(routingLocation);
                }
            }
        } else {
            //修改
            flag = routingLocationMapper.updateByPrimaryKeySelective(routingLocation);
        }
        return flag;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRoutingLocation(TbRoutingLocation routingLocation, String userName) {
        //删除巡检点关联的设备
        int flag = 0;
        TbRoutingLocatioinEquipExample example = new TbRoutingLocatioinEquipExample();
        TbRoutingLocatioinEquipExample.Criteria criteria = example.createCriteria();
        criteria.andRoutingNoEqualTo(routingLocation.getLocationNo());
        flag = tbRoutingLocatioinEquipMapper.deleteByExample(example);
        routingLocation.setDeleteFlag(DELETE_YES);
        routingLocation.setUpdateUser(userName);
        flag = routingLocationMapper.updateByPrimaryKeySelective(routingLocation);
        if (flag == 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flag;
    }

    @Override
    public int deleteTbRoutingLocationElement(TbRoutingLocationElement routingLocation, String userName) {
        routingLocation.setDeleteFlag(DELETE_YES);
        return routingLocationElementMapper.updateByPrimaryKeySelective(routingLocation);
    }

    @Override
    public List<TbRoutingLocatioinEquip> getRoutingEquipList(String routingNo, String equipName) {
        TbRoutingLocatioinEquipExample example = new TbRoutingLocatioinEquipExample();
        TbRoutingLocatioinEquipExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(routingNo)) {
            criteria.andRoutingNoEqualTo(routingNo);
        }
        if (StringUtils.isNotEmpty(equipName)) {
            TbEquipInfoExample equipInfoExample = new TbEquipInfoExample();
            equipInfoExample.createCriteria().andEquipNameLike('%' + equipName + "%");
            List<TbEquipInfo> equipInfoList = equipInfoMapper.selectByExample(equipInfoExample);
            List<String> equipNoList = equipInfoList.stream().map(TbEquipInfo::getEquipNo).collect(Collectors.toList());
            criteria.andEquipNoIn(equipNoList);
        }
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        example.setOrderByClause("equip_sort");
        return routingLocationEquipMapper.selectByExample(example);
    }

    @Override
    public List<TbRoutingLocatioinEquip> getRoutingEquipListByIds(List<String> routingNoList) {
        TbRoutingLocatioinEquipExample example = new TbRoutingLocatioinEquipExample();
        TbRoutingLocatioinEquipExample.Criteria criteria = example.createCriteria();
        if (routingNoList != null && routingNoList.size() > 0) {
            criteria.andRoutingNoIn(routingNoList);
        }
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        example.setOrderByClause("equip_sort");
        return routingLocationEquipMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addRoutingEquipList(String locationNo, String[] equipNoList, String userCode) {
        try {
            int maxSort = routingLocationEquipMapper.getLocationEquipMaxSort(locationNo);
            TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(locationNo);
            for (int i = 0; i < equipNoList.length; i++) {
                TbRoutingLocatioinEquip oldLoctionEquip = routingLocationEquipMapper.selectByEquipNo(locationNo, equipNoList[i]);
                if (oldLoctionEquip != null) {
                    oldLoctionEquip.setDeleteFlag(0);
                    oldLoctionEquip.setCreateUser(userCode);
                    routingLocationEquipMapper.updateByPrimaryKeySelective(oldLoctionEquip);
                } else {
                    TbRoutingLocatioinEquip routingLocatioinEquip = new TbRoutingLocatioinEquip();
                    routingLocatioinEquip.setCreateUser(userCode);
                    routingLocatioinEquip.setDeleteFlag(0);
                    routingLocatioinEquip.setEquipNo(equipNoList[i]);
                    routingLocatioinEquip.setEquipSort(maxSort);
                    routingLocatioinEquip.setRoutingNo(locationNo);
                    routingLocatioinEquip.setLocationEquipNo(StringTools.getUUID());
                    routingLocationEquipMapper.insertSelective(routingLocatioinEquip);
                    maxSort++;
                }
            }
            routingLocation.setEquipCount(routingLocation.getEquipCount() + equipNoList.length);
            routingLocationMapper.updateByPrimaryKeySelective(routingLocation);
            return 1;
        } catch (Exception ex) {
            logger.error(ex.toString());
            return 0;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRoutingEquipList(String locationNo, String[] locationEquipNoList, String userCode) {
        try {
            TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(locationNo);
            for (String locationEquipNo : locationEquipNoList) {
                TbRoutingLocatioinEquip tbRoutingLocatioinEquip = routingLocationEquipMapper.selectByPrimaryKey(locationEquipNo);
                tbRoutingLocatioinEquip.setDeleteFlag(1);
                tbRoutingLocatioinEquip.setCreateUser(userCode);
                routingLocationEquipMapper.updateByPrimaryKeySelective(tbRoutingLocatioinEquip);
            }
            int equipCount = routingLocation.getEquipCount() > locationEquipNoList.length ? routingLocation.getEquipCount() - locationEquipNoList.length : 0;
            routingLocation.setEquipCount(equipCount);
            routingLocationMapper.updateByPrimaryKeySelective(routingLocation);
            return 1;
        } catch (Exception ex) {
            logger.error(ex.toString());
            return 0;
        }
    }

    @Override
    public List<TbRoutingLocationElement> getRoutingElementList(TbRoutingLocationElement routingLocationElement, List<String> parentIdList) {
        TbRoutingLocationElementExample routingLocationElementExample = new TbRoutingLocationElementExample();
        TbRoutingLocationElementExample.Criteria criteria = routingLocationElementExample.createCriteria();
        criteria.andFactoryNoEqualTo(routingLocationElement.getFactoryNo());
        if (routingLocationElement.getElementType() != null) {
            criteria.andElementTypeEqualTo(routingLocationElement.getElementType());
        }
        if (routingLocationElement.getElementName() != null) {
            criteria.andElementNameLike("%" + routingLocationElement.getElementName() + "%");
        }
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        if (parentIdList != null) {
            criteria.andParentNoIn(parentIdList);
        } else {
            if (StringUtils.isNotEmpty(routingLocationElement.getParentNo())) {
                criteria.andParentNoEqualTo(routingLocationElement.getParentNo());
            }
        }

        routingLocationElementExample.setOrderByClause(" element_sort, update_time desc ");
        return routingLocationElementMapper.selectByExample(routingLocationElementExample);
    }

    @Override
    public int insertTbRoutingLocationElement(TbRoutingLocationElement routingLocationElement) {
        flag = 0;
        List<TbRoutingLocationElement> checkRoutingElementList = getCheckRoutingElementList(routingLocationElement);
        if (checkRoutingElementList != null && checkRoutingElementList.size() > 0) {
            flag = Dict.AjaxStatus.SORT_EXIST.getStatusCode();
        } else {
            flag = routingLocationElementMapper.insertSelective(routingLocationElement);
        }
        return flag;
    }

    public List<TbRoutingLocationElement> getCheckRoutingElementList(TbRoutingLocationElement routingLocationElement) {
        TbRoutingLocationElementExample routingLocationElementExample = new TbRoutingLocationElementExample();
        TbRoutingLocationElementExample.Criteria criteria = routingLocationElementExample.createCriteria();
        criteria.andFactoryNoEqualTo(routingLocationElement.getFactoryNo());
        if (routingLocationElement.getElementType() != null) {
            criteria.andElementTypeEqualTo(routingLocationElement.getElementType());
        }
        if (routingLocationElement.getElementSort() != null) {
            criteria.andElementSortEqualTo(routingLocationElement.getElementSort());
        }
        if (routingLocationElement.getParentType() != null) {
            criteria.andParentTypeEqualTo(routingLocationElement.getParentType());
        }
        if (routingLocationElement.getParentNo() != null) {
            criteria.andParentNoEqualTo(routingLocationElement.getParentNo());
        }
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        return routingLocationElementMapper.selectByExample(routingLocationElementExample);
    }

    @Override
    public int updateTbRoutingLocationElement(TbRoutingLocationElement routingLocationElement) {
        flag = 0;
        TbRoutingLocationElement locationElement = routingLocationElementMapper.selectByPrimaryKey(routingLocationElement.getLocationFieldNo());
        if (locationElement != null) {
            routingLocationElement.setFactoryNo(locationElement.getFactoryNo());
            routingLocationElement.setElementType(locationElement.getElementType());
            routingLocationElement.setParentType(locationElement.getParentType());
            routingLocationElement.setParentNo(locationElement.getParentNo());
            List<TbRoutingLocationElement> checkRoutingElementList = getCheckRoutingElementList(routingLocationElement);
            if (checkRoutingElementList != null && checkRoutingElementList.size() > 0) {
                if (checkRoutingElementList.get(0).getLocationFieldNo().equals(routingLocationElement.getLocationFieldNo())) {
                    flag = routingLocationElementMapper.updateByPrimaryKeySelective(routingLocationElement);
                } else {
                    flag = Dict.AjaxStatus.SORT_EXIST.getStatusCode();
                }
            } else {
                flag = routingLocationElementMapper.updateByPrimaryKeySelective(routingLocationElement);
            }
        } else {
            flag = 2;
        }
        return flag;
    }

    @Override
    public List<TbRoutingModel> getRoutingModelList(TbRoutingModel routingModel) {
        TbRoutingModelExample routingModelExample = new TbRoutingModelExample();
        TbRoutingModelExample.Criteria criteria = routingModelExample.createCriteria();
        criteria.andFactoryNoEqualTo(routingModel.getFactoryNo());
        criteria.andDeleteFlagEqualTo(DELETE_NO);
        if (routingModel.getSource() == null) {
            criteria.andAllCountGreaterThan(0);
        } else {
            if (routingModel.getSource() == 0) {
                if (StringUtils.isNotEmpty(routingModel.getRoutingModelName())) {
                    criteria.andRoutingModelNameLike("%" + routingModel.getRoutingModelName() + "%");
                }
            } else {
                if (StringUtils.isNotEmpty(routingModel.getRoutingModelName())) {
                    criteria.andRoutingModelNameEqualTo(routingModel.getRoutingModelName());
                }
            }
        }
        if (routingModel.getRoutingModelLevel() != null) {
            criteria.andRoutingModelLevelEqualTo(routingModel.getRoutingModelLevel());
        }
        routingModelExample.setOrderByClause(" update_time desc ");
        return routingModelMapper.selectByExample(routingModelExample);
    }

    @Override
    public int addRoutingModel(TbRoutingModel routingModel) {
        //根据模式名称去重
        flag = 0;
        List<TbRoutingModel> routingModelList = getCommonRoutingModelList(routingModel);
        if (routingModelList != null && routingModelList.size() > 0) {
            flag = Dict.AjaxStatus.MODEL_NAME_REPEAT.getStatusCode();
        } else {
            routingModel.setCreateTime(new Date());
            routingModel.setDeleteFlag(0);
            routingModel.setRoutingModelNo(StringTools.getUUID());
            routingModel.setRoutingModelStatus(0);
            flag = routingModelMapper.insert(routingModel);
        }
        return flag;
    }

    public List<TbRoutingModel> getCommonRoutingModelList(TbRoutingModel routingModel) {
        TbRoutingModel routingModelQ = new TbRoutingModel();
        routingModelQ.setFactoryNo(routingModel.getFactoryNo());
        routingModelQ.setRoutingModelName(routingModel.getRoutingModelName());
        routingModelQ.setSource(1);
        List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
        return routingModelList;
    }

    @Override
    public int updateRoutingModel(TbRoutingModel routingModel) {
        flag = 0;
        List<TbRoutingModel> routingModelList = getCommonRoutingModelList(routingModel);
        if (routingModelList != null && routingModelList.size() > 0) {
            for (TbRoutingModel model : routingModelList) {
                if (!routingModel.getRoutingModelNo().equals(model.getRoutingModelNo())) {
                    flag = Dict.AjaxStatus.MODEL_NAME_REPEAT.getStatusCode();
                    break;
                } else {
                    flag = routingModelMapper.updateByPrimaryKeySelective(routingModel);
                }
            }

        } else {
            flag = routingModelMapper.updateByPrimaryKeySelective(routingModel);
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRoutingModel(TbRoutingModel routingModel) {
        TbRoutingModel tbRoutingModel = routingModelMapper.selectByPrimaryKey(routingModel.getRoutingModelNo());
        tbRoutingModel.setDeleteFlag(DELETE_YES);
        return routingModelMapper.updateByPrimaryKeySelective(tbRoutingModel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int changeRoutingModelExtends(String modelNo, TbRoutingLocationElement[] elements, String[] delElementNos) {
        List<TbRoutingModelExtend> extendList = new ArrayList<>();

        try {
            TbRoutingModel routingModel = routingModelMapper.selectByPrimaryKey(modelNo);
            int allCount = routingModel.getAllCount() == null ? 0 : routingModel.getAllCount();
            allCount = allCount - delElementNos.length;
            if (delElementNos.length > 0) {
                deleteRoutingModelExtends(Arrays.asList(delElementNos));
            }
            for (int i = 0; i < elements.length; i++) {
                TbRoutingModelExtend modelExtend = new TbRoutingModelExtend();
                modelExtend.setRoutingModelNo(modelNo);
                modelExtend.setRoutingElementNo(elements[i].getLocationFieldNo());

                modelExtend.setCreateTime(new Date());
                modelExtend.setRoutingElementType(elements[i].getElementType());
                modelExtend.setRoutingLocationNo(elements[i].getLocationNo());
                modelExtend.setRoutingEquipNo(elements[i].getEquipNo());
                modelExtend.setRoutingModelExtendNo(StringTools.getUUID());
                extendList.add(modelExtend);
            }
            allCount = allCount + elements.length;
            routingModel.setAllCount(allCount);
            routingModelMapper.updateByPrimaryKeySelective(routingModel);
            if (extendList.size() > 0) {
                routingModelExtendMapper.insertBatch(extendList);
            }
            return AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            return AjaxStatus.FAIL.getStatusCode();
        }
    }

    @Override
    public List<TbRoutingModelExtend> getRoutingModelExtends(String modelNo) {
        return getRoutingModelList(modelNo);
    }

    @Override
    public List<TbRoutingTask> getRoutingTaskList(TbRoutingTask routingTask) {
        TbRoutingTaskExample routingTaskExample = new TbRoutingTaskExample();
        TbRoutingTaskExample.Criteria criteria = routingTaskExample.createCriteria();
        criteria.andFactoryNoEqualTo(routingTask.getFactoryNo());
        if (routingTask.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(routingTask.getTaskType());
        }
        if (routingTask.getTaskStatus() != null) {
            criteria.andTaskStatusEqualTo(routingTask.getTaskStatus());
        }
        if (routingTask.getBeginTime() != null) {
            criteria.andBeginTimeGreaterThanOrEqualTo(routingTask.getBeginTime());
        }
        if (routingTask.getEndTime() != null) {
            criteria.andBeginTimeLessThan(DateUtils.getNextDate(routingTask.getEndTime(), 1));
        }
        routingTaskExample.setOrderByClause(" begin_time desc");


        List<TbRoutingTask> taskList = routingTaskMapper.selectByExample(routingTaskExample);
        TbRoutingModel routingModelQ = new TbRoutingModel();
        routingModelQ.setFactoryNo(routingTask.getFactoryNo());
        List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
        for (TbRoutingTask tbRoutingTask : taskList) {
            for (TbRoutingModel routingModel : routingModelList) {
                if (routingModel.getRoutingModelNo().equals(tbRoutingTask.getModelNo())) {
                    tbRoutingTask.setModelName(routingModel.getRoutingModelName());
                    break;
                }
            }
            if (StringUtils.isEmpty(tbRoutingTask.getModelName())) {
                tbRoutingTask.setModelName("临时巡检");
            }

        }
        return taskList;
    }

    public List<TbRoutingTask> getRoutingTaskListNew(TbRoutingTask routingTask) {
        TbRoutingTaskExample routingTaskExample = new TbRoutingTaskExample();
        TbRoutingTaskExample.Criteria criteria = routingTaskExample.createCriteria();
        criteria.andFactoryNoEqualTo(routingTask.getFactoryNo());
        if (routingTask.getTaskType() != null) {
            criteria.andTaskTypeEqualTo(routingTask.getTaskType());
        }
        if (routingTask.getTaskStatus() != null) {
            criteria.andTaskStatusEqualTo(routingTask.getTaskStatus());
        } else {
            criteria.andTaskStatusNotEqualTo(4);
        }
        if (routingTask.getBeginTime() != null) {
            criteria.andBeginTimeGreaterThanOrEqualTo(routingTask.getBeginTime());
        }
        if (routingTask.getEndTime() != null) {
            criteria.andBeginTimeLessThan(routingTask.getEndTime());
        }
        routingTaskExample.setOrderByClause("begin_time");
        List<TbRoutingTask> taskList = routingTaskMapper.selectByExample(routingTaskExample);
        TbRoutingModel routingModelQ = new TbRoutingModel();
        routingModelQ.setFactoryNo(routingTask.getFactoryNo());
        List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
        for (TbRoutingTask tbRoutingTask : taskList) {
            for (TbRoutingModel routingModel : routingModelList) {
                if (routingModel.getRoutingModelNo().equals(tbRoutingTask.getModelNo())) {
                    tbRoutingTask.setModelName(routingModel.getRoutingModelName());
                    break;
                }
            }
            if (StringUtils.isEmpty(tbRoutingTask.getModelName())) {
                tbRoutingTask.setModelName("临时巡检");
            }

        }
        return taskList;
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

    @Override
    public Map<String, Object> getMyRoutingTaskList(TbUser user, TbRoutingTask routingTask) {
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        JSONArray orgRoleList = user.getOrgRoleList();
        List<TbOrg> orgList = getOrgList();
        //默认普遍用户,否则运行经理角色
        Boolean checkUseRrole = false;
        for (int t = 0; t < orgRoleList.size(); t++) {
            //运行经理角色155410622795000005  水厂总经理155410604662000002
            JSONObject orgRole = orgRoleList.getJSONObject(t);
            JSONArray roleList = orgRole.getJSONArray("roleList");
            for (TbOrg org : orgList) {
                if (orgRole.getString("orgEnCode").equals(org.getOrgencode()) && roleList.contains("155410622795000005")) {
                    checkUseRrole = true;
                }
            }
        }
        if (checkUseRrole) {
            TbRoutingTask routingTaskQ = new TbRoutingTask();
            routingTaskQ.setFactoryNo(routingTask.getFactoryNo());
            routingTaskQ.setTaskType(3);
            routingTaskQ.setBeginTimeS(DateUtils.getMonWeekDate());
            List<TbRoutingTask> taskList = routingTaskMapper.selectRoutingTaskList(routingTaskQ);
            List<TbRoutingTask> finishList = taskList.stream().filter(tbRoutingTask -> tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_COMMIT).collect(Collectors.toList());
            for (TbRoutingTask tbRoutingTask : finishList) {
                tbRoutingTask.setModelName(routingModelMapper.selectByPrimaryKey(tbRoutingTask.getModelNo())==null?"":(routingModelMapper.selectByPrimaryKey(tbRoutingTask.getModelNo())).getRoutingModelName());
            }
            List<TbRoutingTask> noFinishList = taskList.stream().filter(tbRoutingTask -> tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_PLAN || tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_STAET).collect(Collectors.toList());
            for (TbRoutingTask tbRoutingTask : noFinishList) {
                tbRoutingTask.setModelName(routingModelMapper.selectByPrimaryKey(tbRoutingTask.getModelNo())==null?"":(routingModelMapper.selectByPrimaryKey(tbRoutingTask.getModelNo())).getRoutingModelName());
            }
            TbRoutingTaskVo routingTaskNoFinish = new TbRoutingTaskVo();
            TbRoutingTaskVo routingTaskFinish = new TbRoutingTaskVo();

            routingTaskFinish.setFinishList(finishList);
            //未完成的数据
            routingTaskNoFinish.setCurrentList(noFinishList);
            map.put("finish", routingTaskFinish);
            map.put("noFinish", routingTaskNoFinish);
        } else {
            //根据userCode 和水厂no 查询班组类型
            //获取个人排班信息
            //有限获取运行班信息
            List<TbSchedulingPlan> schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTimePoint(user.getCode());
            //如果找不到设备班巡检
            if (schedulingPlanList == null || schedulingPlanList.size() == 0) {
                schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTime(user.getCode());
            }
            if (schedulingPlanList != null && schedulingPlanList.size() > 0) {
                TbSchedulingPlan schedulingPlan = schedulingPlanList.get(0);
                //查询本班次内的任务
                TbRoutingTask routingTaskQ = new TbRoutingTask();
                routingTaskQ.setFactoryNo(routingTask.getFactoryNo());
                routingTaskQ.setTaskType(schedulingPlan.getGroupType());
                List<TbRoutingTask> taskList = new ArrayList<>();
                //工单的时间需要在班次上班时间内
                if (schedulingPlan.getGroupType() == 1) {
                    routingTaskQ.setBeginTime(schedulingPlan.getStartTimePoint());
                    //暂定方案加一个小时o.
                    //DateUtils.getNextDate(1)
                    routingTaskQ.setEndTime(DateUtils.getNextHourFull(DateUtils.formateDateFull(schedulingPlan.getEndTimePoint()), 1));
                    taskList = getRoutingTaskListNew(routingTaskQ);
                } else {
                    routingTaskQ.setBeginTimeS(DateUtils.formateDate(new Date()));
                    taskList = routingTaskMapper.selectRoutingTaskList(routingTaskQ);
                }
                //区分是运行班还是设备班
                //查询所有水厂下所有不同类型的任务
                for (int i = taskList.size() - 1; i >= 0; i--) {
                    if (taskList.get(i).getTaskStatus().intValue() == ROUTING_TASK_STATUS_CANCEL) {
                        taskList.remove(i);
                    }
                }
                TbRoutingModel routingModelQ = new TbRoutingModel();
                routingModelQ.setFactoryNo(schedulingPlan.getFactoryNo());
                List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
                if (taskList != null && taskList.size() > 0) {
                    freshTaskSort(taskList, routingModelList, map);
                }
            }
        }

        return map;
    }

    @Override
    public Map<String, Object> getRoutingLocationDetailInfo(TbUser user, String routingNo) {
        //获取个人排班信息
        Map<String, Object> curentMap = new HashMap<>(3);

        JSONArray orgRoleList = user.getOrgRoleList();
        List<TbOrg> orgList = getOrgList();
        //默认普遍用户,否则运行经理角色
        Boolean checkUseRrole = false;
        for (int t = 0; t < orgRoleList.size(); t++) {
            //运行经理角色155410622795000005  水厂总经理155410604662000002
            JSONObject orgRole = orgRoleList.getJSONObject(t);
            JSONArray roleList = orgRole.getJSONArray("roleList");
            for (TbOrg org : orgList) {
                if (orgRole.getString("orgEnCode").equals(org.getOrgencode()) && roleList.contains("155410604662000002")) {
                    checkUseRrole = true;
                }
            }
        }
        if (checkUseRrole) {
            List<TbRoutingTask> finishList = new ArrayList<>(20);
            List<TbRoutingTask> noFinishList = new ArrayList<>(20);
            TbRoutingLocation tbRoutingLocation = routingLocationMapper.selectByPrimaryKey(routingNo);
            List<String> modellist = routingModelExtendMapper.getRoutingModelList(routingNo);
            TbRoutingTask routingTaskQ = new TbRoutingTask();
            routingTaskQ.setFactoryNo(tbRoutingLocation.getFactoryNo());
            routingTaskQ.setTaskType(3);
            routingTaskQ.setBeginTimeS(DateUtils.getMonWeekDate());
            List<TbRoutingTask> taskList = routingTaskMapper.selectRoutingTaskList(routingTaskQ);
            if (taskList != null && taskList.size() > 0) {
                finishList = taskList.stream().filter(tbRoutingTask -> tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_COMMIT).collect(Collectors.toList());
                List<String> taskNoList = finishList.stream().map(TbRoutingTask::getTaskNo).collect(Collectors.toList());
                for (int i = finishList.size() - 1; i >= 0; i--) {
                    TbRoutingTask routingTask = taskList.get(i);
                    //如果是非临时巡检工单  不包含在巡检模式里
                    if (!modellist.contains(routingTask.getModelNo())) {
                        finishList.remove(i);
                    }
                }
                noFinishList = taskList.stream().filter(tbRoutingTask -> tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_PLAN || tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_STAET).collect(Collectors.toList());
                for (int i = noFinishList.size() - 1; i >= 0; i--) {
                    TbRoutingTask routingTask = taskList.get(i);
                    //如果是非临时巡检工单  不包含在巡检模式里
                    if (!modellist.contains(routingTask.getModelNo())) {
                        noFinishList.remove(i);
                    }
                }
            }
            curentMap.put("finish", finishList);
            curentMap.put("noFinish", noFinishList);
        } else {
            //获取巡检工单
            List<TbSchedulingPlan> schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTimePoint(user.getCode());
            if (schedulingPlanList != null && schedulingPlanList.size() > 0) {
                TbSchedulingPlan schedulingPlan = schedulingPlanList.get(0);
                //查询本班次内的任务
                TbRoutingTask routingTaskQ = new TbRoutingTask();
                routingTaskQ.setFactoryNo(schedulingPlan.getFactoryNo());
                //工单的时间需要在班次上班时间内
                routingTaskQ.setBeginTime(schedulingPlan.getStartTimePoint());
                routingTaskQ.setEndTime(getRoutingTaskByScheduleTime(schedulingPlan));
                //区分是运行班还是设备班
                routingTaskQ.setTaskType(schedulingPlan.getGroupType());
                List<TbRoutingTask> taskList = getRoutingTaskListNew(routingTaskQ);
                if (taskList.size() > 0) {
                    //获取含有该巡检的巡检模式列表
                    List<String> modellist = routingModelExtendMapper.getRoutingModelList(routingNo);
                    List<String> taskNoList = taskList.stream().map(TbRoutingTask::getTaskNo).collect(Collectors.toList());
                    List<TbRoutingTaskDetail> taskDetailList = getRoutingTaskDetailListByTaskNo(taskNoList, routingNo);

                    List<String> myTaskNoList = taskDetailList.stream().map(TbRoutingTaskDetail::getTaskNo).collect(Collectors.toList());
                    for (int i = taskList.size() - 1; i >= 0; i--) {
                        TbRoutingTask routingTask = taskList.get(i);
                        //如果是临时巡检工单  不包含在工单里面
                        if (routingTask.getTempStatus().equals(1)) {
                            if (!myTaskNoList.contains(routingTask.getTaskNo())) {
                                taskList.remove(i);
                            }
                        } else {
                            //如果是非临时巡检工单  不包含在巡检模式里
                            if (!modellist.contains(routingTask.getModelNo())) {
                                taskList.remove(i);
                            }
                        }
                    }
                    TbRoutingModel routingModelQ = new TbRoutingModel();
                    routingModelQ.setFactoryNo(schedulingPlan.getFactoryNo());
                    List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
                    freshTaskSort(taskList, routingModelList, curentMap);
                }

            }
        }


        //获取巡检点信息
        TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(routingNo);
        curentMap.put("routingLocationInfo", routingLocation);
        List<TbRoutingLocatioinEquip> equipList = getRoutingEquipList(routingNo, null);
        curentMap.put("equipList", equipList);
        return curentMap;
    }

    private Date getRoutingTaskByScheduleTime(TbSchedulingPlan schedulingPlan) {
        return schedulingPlan.getEndTimePoint();
    }

    private List<TbRoutingTaskDetail> getRoutingTaskDetailListByTaskNo(List<String> taskNoList, String locationNo) {

        TbRoutingTaskDetailExample example = new TbRoutingTaskDetailExample();
        example.createCriteria().andTaskNoIn(taskNoList).andLocationNoEqualTo(locationNo);
        return routingTaskDetailMapper.selectByExample(example);
    }

    @Override
    public Map<String, Object> getRoutingLocationByNfcDetailInfo(TbUser user, String routingNo) {
        Map<String, Object> currentMap = new HashMap<>(3);
        //获取个人排班信息
        List<TbSchedulingPlan> schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTimePoint(user.getCode());
        TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(routingNo);
        List<TbRoutingLocatioinEquip> equipList = getRoutingEquipList(routingNo, null);
        if (schedulingPlanList != null && schedulingPlanList.size() > 0) {
            TbSchedulingPlan schedulingPlan = schedulingPlanList.get(0);
            //查询本班次内的任务
            TbRoutingTask routingTaskQ = new TbRoutingTask();
            routingTaskQ.setFactoryNo(schedulingPlan.getFactoryNo());
            //工单的时间需要在班次上班时间内
            routingTaskQ.setBeginTime(schedulingPlan.getStartTimePoint());
            routingTaskQ.setEndTime(schedulingPlan.getEndTimePoint());
            //区分是运行班还是设备班
            routingTaskQ.setTaskType(schedulingPlan.getGroupType());
            List<TbRoutingTask> taskList = getRoutingTaskListNew(routingTaskQ);
            TbRoutingModel routingModelQ = new TbRoutingModel();
            routingModelQ.setFactoryNo(schedulingPlan.getFactoryNo());
            List<TbRoutingModel> routingModelList = getRoutingModelList(routingModelQ);
            freshTaskSort(taskList, routingModelList, currentMap);
            //获取巡检点信息
        }
        currentMap.put("routingLocationInfo", routingLocation);
        currentMap.put("equipList", equipList);
        return currentMap;
    }


    /**
     * 对工单列表，将当前时段的工单移动第一的位置
     *
     * @param taskList
     */
    private void freshTaskSort(List<TbRoutingTask> taskList, List<TbRoutingModel> routingModelList, Map<String, Object> currentMap) {
        TbRoutingTaskVo routingTaskFinish = new TbRoutingTaskVo();
        TbRoutingTaskVo routingTaskNoFinish = new TbRoutingTaskVo();
        //组合数据
        for (TbRoutingTask tbRoutingTask : taskList) {
            if (routingModelList != null && routingModelList.size() > 0) {
                for (TbRoutingModel routingModel : routingModelList) {
                    if ((routingModel.getRoutingModelNo()).equals(tbRoutingTask.getModelNo())) {
                        tbRoutingTask.setModelName(routingModel.getRoutingModelName());
                    }
                }
            }


            if (StringUtils.isEmpty(tbRoutingTask.getModelName())) {
                tbRoutingTask.setModelName("临时巡检");
            }

        }
        //完成的
        List<TbRoutingTask> finishList = new ArrayList<>(20);
        //合并后的数据
        List<TbRoutingTask> currentList = new ArrayList<>(20);
        //正在正常进行的
        List<TbRoutingTask> currentNormalList = new ArrayList<>(20);
        //正在进行临时的
        List<TbRoutingTask> currentTempList = new ArrayList<>(20);
        //接下来的
        List<TbRoutingTask> nextList = new ArrayList<>(20);
        //去出完成的 状态等于2
        finishList = taskList.stream().filter(tbRoutingTask -> tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_COMMIT).collect(Collectors.toList());
        //未完成的 状态等于0 或者1 且开始时间小于当前时间 包括正在的
        currentNormalList = taskList.stream().filter(tbRoutingTask -> (tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_PLAN || tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_STAET) && tbRoutingTask.getBeginTime().getTime() < System.currentTimeMillis() && tbRoutingTask.getTempStatus() == 0).collect(Collectors.toList());
        for (int i = 0; i < currentNormalList.size(); i++) {
            if (i == 0) {
                currentNormalList.get(i).setCurrentTask(true);
            }
        }
        //取出临时
        currentTempList = taskList.stream().filter(tbRoutingTask -> (tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_PLAN || tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_STAET) && tbRoutingTask.getBeginTime().getTime() < System.currentTimeMillis() && tbRoutingTask.getTempStatus() == 1).collect(Collectors.toList());
        for (int i = 0; i < currentTempList.size(); i++) {
            TbRoutingTask task = new TbRoutingTask();
            if (i == 0) {
                currentTempList.get(i).setCurrentTask(true);
            }
            BeanUtils.copyProperties(currentTempList.get(i), task);
            currentList.add(task);
        }
        //接下来的
        nextList = taskList.stream().filter(tbRoutingTask -> (tbRoutingTask.getTaskStatus() == ROUTING_TASK_STATUS_PLAN) && tbRoutingTask.getBeginTime().getTime() > System.currentTimeMillis()).collect(Collectors.toList());
        for (TbRoutingTask routingTask : currentNormalList) {
            TbRoutingTask normal = new TbRoutingTask();
            BeanUtils.copyProperties(routingTask, normal);
            currentList.add(normal);
        }
        //完成的数据
        routingTaskFinish.setFinishList(finishList);
        //未完成的数据
        routingTaskNoFinish.setCurrentList(currentList);
        routingTaskNoFinish.setNextList(nextList);
        currentMap.put("finish", routingTaskFinish);
        currentMap.put("noFinish", routingTaskNoFinish);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addRoutingTaskList(Date beginDate, Date endDate, String modelNo, TbUser user) {
        TbRoutingModel tbRoutingModel = routingModelMapper.selectByPrimaryKey(modelNo);
        if (tbRoutingModel != null) {
            if (null == tbRoutingModel.getAllCount()) {
                return AjaxStatus.MODEL_IS_NULL.getStatusCode();
            }
        }
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(tbRoutingModel.getFactoryNo());
        List<String> dayList = new ArrayList<>();

        List<TbRoutingTask> list = new ArrayList<>();
        //如果是三级巡检
        if (tbRoutingModel.getRoutingModelLevel() == 3) {
            dayList = DateUtils.getDayOfWeekWithinDateInterval(DateUtils.formateDate(beginDate), DateUtils.formateDate(endDate), 1);
            //校验当前模式是否在本周存在 ,根据当前时间获取周一
            if (!DateUtils.getMonWeekDate().equals(DateUtils.formateDate(beginDate))) {
                dayList.add(0, DateUtils.getMonWeekDate());
            }
            Map map = new HashMap(16);
            map.put("factoryNo", tbRoutingModel.getFactoryNo());
            map.put("modelNo", modelNo);
            map.put("dayList", dayList);
            List<TbRoutingTask> tbRoutingTasks = checkRoutingTask(map);
            if (tbRoutingTasks != null && tbRoutingTasks.size() > 0) {
                for (int i = dayList.size() - 1; i >= 0; i--) {
                    //TbRoutingTask routingTask = taskList.get(i);
                    for (int t = 0; t < tbRoutingTasks.size(); t++) {
                        if (dayList.size() > 0) {
                            if (dayList.get(i).equals(DateUtils.formateDate(tbRoutingTasks.get(t).getBeginTime()))) {
                                dayList.remove(i);
                                break;
                            }
                        }
                    }
                }
                for (String day : dayList) {
                    Date currentTaskTime = DateUtils.parseDateFull(day + " " + "00:00:00");
                    String taskCode = tbFactoryInfo.getBrowsename() + "XJ" + DateUtils.formateMyDate(currentTaskTime, "yyyyMMddHHmm" + tbRoutingModel.getRoutingModelLevel());
                    TbRoutingTask routingTask = createTbRoutingTask(tbRoutingModel, taskCode, currentTaskTime, user);
                    list.add(routingTask);
                }
            } else {

                for (String day : dayList) {
                    Date currentTaskTime = DateUtils.parseDateFull(day + " " + "00:00:00");
                    String taskCode = tbFactoryInfo.getBrowsename() + "XJ" + DateUtils.formateMyDate(currentTaskTime, "yyyyMMddHHmm" + tbRoutingModel.getRoutingModelLevel());
                    TbRoutingTask routingTask = createTbRoutingTask(tbRoutingModel, taskCode, currentTaskTime, user);
                    list.add(routingTask);
                }
            }
            if (list.size() > 0) {
                routingTaskMapper.insertBatch(list);
                return Dict.AjaxStatus.YES.getStatusCode();
            } else {
                return Dict.AjaxStatus.RECREATE.getStatusCode();
            }
        } else {
            dayList = DateUtils.getDistDayList(beginDate, endDate);
            boolean plan = true;
            if (tbRoutingModel.getRoutingModelLevel() == 2) {
                //校验设备班是否排班
                TbSchedulingPlanExample schedulingPlanExample = new TbSchedulingPlanExample();
                schedulingPlanExample.createCriteria().andGroupTypeEqualTo(2).andFactoryNoEqualTo(tbRoutingModel.getFactoryNo())
                        .andSchedulingTimeBetween(DateUtils.formateDate(beginDate),DateUtils.formateDate(endDate));
                List<TbSchedulingPlan> tbSchedulingPlanList = tbSchedulingPlanMapper.selectByExample(schedulingPlanExample);
                if(tbSchedulingPlanList.size()>0){
                    freshEquipSchedule(dayList,tbSchedulingPlanList);
                }else{
                    dayList.clear();
                }

            }
            if (dayList.size()>0) {
                //获取现有工单
                List<TbRoutingTask> oldTaskList = searchRoutingTask(tbRoutingModel.getFactoryNo(), beginDate, DateUtils.getNextDate(endDate, 1), tbRoutingModel.getRoutingModelLevel());
                // 按天循环
                for (String day : dayList) {
                    //如果选择的巡检模式和当天已有同级别的巡检模式 不一致 则不创建
                    if (!checkTaskRepeatModel(tbRoutingModel, oldTaskList, day)) {
                        continue;
                    }
                    String[] timeZones = tbRoutingModel.getTimeZones().split(",");
                    //判断是否有旧任务
                    for (String timeZone : timeZones) {
                        Date currentTaskTime = DateUtils.parseDateFull(day + " " + timeZone + ":00");
                        if (currentTaskTime.getTime() < System.currentTimeMillis()) {
                            //如果超过时间 则不荀彧创建
                            continue;
                        }
                        //验证同一时间点是否有重复的工单
                        if (!checkTaskTimeZone(tbRoutingModel, oldTaskList, currentTaskTime)) {
                            continue;
                        }
                        String taskCode = tbFactoryInfo.getBrowsename() + "XJ" + DateUtils.formateMyDate(currentTaskTime, "yyyyMMddHHmm" + tbRoutingModel.getRoutingModelLevel());
                        TbRoutingTask routingTask = createTbRoutingTask(tbRoutingModel, taskCode, currentTaskTime, user);
                        list.add(routingTask);
                    }
                }
                if (list.size() > 0) {
                    routingTaskMapper.insertBatch(list);
                    return Dict.AjaxStatus.YES.getStatusCode();
                } else {
                    return Dict.AjaxStatus.RECREATE.getStatusCode();
                }
            } else {
                return Dict.AjaxStatus.EQUIP_GROUP_NO_PlAN.getStatusCode();
            }
        }
    }

    //校验是否存在3级巡检
    public List<TbRoutingTask> checkRoutingTask(Map map) {
        TbRoutingTaskExample example = new TbRoutingTaskExample();
        TbRoutingTaskExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(map.get("factoryNo").toString());
        criteria.andModelNoEqualTo(map.get("modelNo").toString());
        List<Date> dayList = (List<Date>) map.get("dayList");
        criteria.andBeginTimeIn(dayList);
        criteria.andTaskStatusNotEqualTo(4);
        return routingTaskMapper.selectByExample(example);
    }

    private void freshEquipSchedule(List<String> dayList,List<TbSchedulingPlan> schedulingPlanList){
        for(int i=dayList.size()-1;i>=0;i--){
            boolean hasFind = false;
           for(TbSchedulingPlan schedulingPlan:schedulingPlanList){
               if(dayList.get(i).equals(schedulingPlan.getSchedulingTime())){
                   hasFind = true;

               }
           }
           if(!hasFind){
               dayList.remove(i);
           }
        }
    }

    /**
     * 严重当前的巡检模式和当天已经创建的工单的巡检模式是否一致
     *
     * @param routingModel
     * @param taskList
     * @param date
     * @return
     */
    private boolean checkTaskRepeatModel(TbRoutingModel routingModel, List<TbRoutingTask> taskList, String date) {
        for (TbRoutingTask routingTask : taskList) {
            //时间相等 且巡检级别一致
            if (DateUtils.formateDate(routingTask.getBeginTime()).equals(date) && routingTask.getTaskType().equals(routingModel.getRoutingModelLevel())) {
                if (!routingModel.getRoutingModelNo().equals(routingTask.getModelNo())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断是否是重复时间点
     *
     * @param routingModel
     * @param taskList
     * @param date
     * @return
     */
    private boolean checkTaskTimeZone(TbRoutingModel routingModel, List<TbRoutingTask> taskList, Date date) {
        for (TbRoutingTask routingTask : taskList) {
            //时间相等 且巡检模式一致
            if (routingTask.getBeginTime().equals(date) && routingTask.getModelNo().equals(routingModel.getRoutingModelNo())) {
                return false;
            }
        }
        return true;
    }

    private TbRoutingTask createTbRoutingTask(TbRoutingModel tbRoutingModel, String taskCode, Date beginTime, TbUser user) {
        TbRoutingTask routingTask = new TbRoutingTask();
        if (tbRoutingModel != null) {
            routingTask.setTaskType(tbRoutingModel.getRoutingModelLevel());
            routingTask.setFactoryNo(tbRoutingModel.getFactoryNo());
            routingTask.setModelNo(tbRoutingModel.getRoutingModelNo());
            routingTask.setNeedCount(tbRoutingModel.getAllCount());
        }
        routingTask.setBeginTime(beginTime);
        routingTask.setCraeteTime(new Date());
        routingTask.setCreateUserCode(user.getCode());
        routingTask.setCreateUserName(user.getName());
        routingTask.setFinishCount(0);
        routingTask.setErrorCount(0);
        routingTask.setTaskCode(taskCode);
        routingTask.setTaskStatus(ROUTING_TASK_STATUS_PLAN);
        routingTask.setTaskNo(StringTools.getUUID());
        routingTask.setTempStatus(TEMP_NO);
        routingTask.setDraftStatus(0);
        return routingTask;
    }

    ////'1:级巡检(运行巡检)；2级巡检(设备巡检)',
    private int getTaskIndex(String factoryNo, String date, Integer type) {
        Date startDate = DateUtils.parseDate(date);
        Date endDate = DateUtils.parseDateFull(date + " 23:59:59");
        TbRoutingTaskExample example = new TbRoutingTaskExample();
        TbRoutingTaskExample.Criteria criteria = example.createCriteria();
        criteria.andBeginTimeBetween(startDate, endDate);
        //'0:正常工单1:临时工单'
        criteria.andTaskStatusEqualTo(0);
        criteria.andFactoryNoEqualTo(factoryNo);
        //1：运行班工单 2：设备班工单'
        criteria.andTaskTypeEqualTo(type);
        return routingTaskMapper.countByExample(example);
    }

    private List<TbRoutingTask> searchRoutingTask(String factoryNo, Date beginDate, Date endDate, Integer taskType) {
        TbRoutingTaskExample example = new TbRoutingTaskExample();
        example.createCriteria().andBeginTimeGreaterThanOrEqualTo(beginDate).andBeginTimeLessThan(endDate).andTaskTypeEqualTo(taskType).andFactoryNoEqualTo(factoryNo).andTaskStatusNotEqualTo(4);
        example.setOrderByClause(" begin_time  ");
        return routingTaskMapper.selectByExample(example);
    }


    @Override
    public int addRoutingTask(TbRoutingTask routingTask) {
        return routingTaskMapper.insertSelective(routingTask);
    }

    @Override
    public int updateRoutingTask(TbRoutingTask routingTask) {
        return routingTaskMapper.updateByPrimaryKeySelective(routingTask);
    }

    /**
     * 开始巡检任务
     *
     * @param routingTask
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int startRoutingTask(TbRoutingTask routingTask) {
        //获取巡检模式
        TbRoutingTask oldRoutingTask = routingTaskMapper.selectByPrimaryKey(routingTask.getTaskNo());
        //获取模式编号
        if (oldRoutingTask.getTaskStatus().intValue() >= ROUTING_TASK_STATUS_STAET) {
            return AjaxStatus.RECREATE.getStatusCode();
            //如果不是当前巡检任务
        } else if (oldRoutingTask.getBeginTime().getTime() > System.currentTimeMillis()) {
            return AjaxStatus.NOSTART.getStatusCode();
        } else {
            oldRoutingTask.setTaskStatus(ROUTING_TASK_STATUS_STAET);
            oldRoutingTask.setStartTime(new Date());
            if (oldRoutingTask.getTempStatus().equals(TEMP_NO)) {
                List<TbRoutingModelExtend> routingModelExtendList = getRoutingModelExtends(oldRoutingTask.getModelNo());
                List<TbRoutingTaskDetail> list = new ArrayList<>();
                for (int i = 0; i < routingModelExtendList.size(); i++) {
                    TbRoutingModelExtend tbRoutingModelExtend = routingModelExtendList.get(i);
                    TbRoutingLocationElement routingLocationElement = routingLocationElementMapper.selectByPrimaryKey(tbRoutingModelExtend.getRoutingElementNo());
                    list.add(createRoutingTaskDetail(routingTask.getTaskNo(), routingLocationElement, tbRoutingModelExtend));
                }
                oldRoutingTask.setNeedCount(list.size());
                routingTaskDetailMapper.insertBatch(list);
            }
            oldRoutingTask.setCommitUser(routingTask.getCommitUser());
            routingTaskMapper.updateByPrimaryKeySelective(oldRoutingTask);
            return AjaxStatus.YES.getStatusCode();
        }
    }

    @Override
    public int cancelRoutingTask(String taskNo, String userCode) {
        TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey(taskNo);
        //如果项目已经开始则不能取消
        if (routingTask.getTaskStatus().equals(ROUTING_TASK_STATUS_STAET)) {
            return AjaxStatus.ROUTING_START_EXIST.getStatusCode();
        }

        routingTask.setTaskStatus(ROUTING_TASK_STATUS_CANCEL);
        routingTask.setCommitUser(userCode);
        if (routingTaskMapper.updateByPrimaryKeySelective(routingTask) > 0) {
            return AjaxStatus.YES.getStatusCode();
        } else {
            return AjaxStatus.FAIL.getStatusCode();
        }

    }

    @Override
    public int finishRoutingTask(TbRoutingTask routingTask) {
        TbRoutingTask oldRoutingTask = routingTaskMapper.selectByPrimaryKey(routingTask.getTaskNo());
        //已提交过的巡检工单部能再次提交
        if (oldRoutingTask.getTaskStatus().intValue() == ROUTING_TASK_STATUS_COMMIT) {
            return AjaxStatus.RECOMMITE.getStatusCode();
        }
        //未开始的工单 不能直接提交
        if (oldRoutingTask.getTaskStatus().intValue() == ROUTING_TASK_STATUS_PLAN) {
            return AjaxStatus.FAIL.getStatusCode();
        }
        oldRoutingTask.setFinishTime(new Date());
        oldRoutingTask.setTaskStatus(ROUTING_TASK_STATUS_COMMIT);
        routingTaskMapper.updateByPrimaryKeySelective(oldRoutingTask);
        reportService.insertRoutingDraftData(oldRoutingTask);
        return AjaxStatus.YES.getStatusCode();
    }

    private TbRoutingTaskDetail createRoutingTaskDetail(String taskNo, TbRoutingLocationElement routingLocationElement, TbRoutingModelExtend tbRoutingModelExtend) {
        TbRoutingTaskDetail routingTaskDetail = new TbRoutingTaskDetail();
        routingTaskDetail.setElementName(routingLocationElement.getElementName());
        routingTaskDetail.setElementType(routingLocationElement.getElementType());
        routingTaskDetail.setRoutingStatus(0);
        routingTaskDetail.setElementNo(routingLocationElement.getLocationFieldNo());
        routingTaskDetail.setTaskDetailNo(StringTools.getUUID());
        routingTaskDetail.setTaskNo(taskNo);
        routingTaskDetail.setLocationNo(tbRoutingModelExtend.getRoutingLocationNo());
        routingTaskDetail.setEquipNo(tbRoutingModelExtend.getRoutingEquipNo());
        //填报
        if (routingLocationElement.getElementType() == 2) {
            routingTaskDetail.setAutoBrowsePath(routingLocationElement.getAutoFieldBrowsePath());
            routingTaskDetail.setFieldNo(routingLocationElement.getFieldNo());
            routingTaskDetail.setFieldUnit(routingLocationElement.getFieldUnit());
        }
        return routingTaskDetail;
    }


    @Override
    public int addRoutingTaskDetailList(List<TbRoutingTaskDetail> routingTaskDetailList) {
        return routingTaskDetailMapper.insertBatch(routingTaskDetailList);
    }

    @Override
    public int updateRoutingTaskDetail(TbRoutingTaskDetail routingTaskDetail) {
        return routingTaskDetailMapper.updateByPrimaryKeySelective(routingTaskDetail);
    }

    /**
     * 批量提交任务详情
     *
     * @param routingTaskDetailList
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateRoutingTaskDetailList(List<TbRoutingTaskDetail> routingTaskDetailList) {
        try {
            int finishCount = 0;
            String taskNo = null;
            for (int i = 0; i < routingTaskDetailList.size(); i++) {
                //获取原有的列表
                TbRoutingTaskDetail routingTaskDetail = routingTaskDetailMapper.selectByPrimaryKey(routingTaskDetailList.get(i).getTaskDetailNo());
                if (routingTaskDetail != null) {
                    if (i == 0) {
                        taskNo = routingTaskDetail.getTaskNo();
                    }
                    //如果是异常不能重复提交
                    if (routingTaskDetail.getRoutingStatus().intValue() == 0 && routingTaskDetailList.get(i).getRoutingStatus().intValue() != 0) {
                        routingTaskDetailMapper.updateByPrimaryKeySelective(routingTaskDetailList.get(i));
                        finishCount++;
                    } else {
                        if (routingTaskDetail.getRoutingStatus().intValue() != 2) {
                            routingTaskDetailMapper.updateByPrimaryKeySelective(routingTaskDetailList.get(i));
                        }
                    }
                }
            }
            TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey(taskNo);
            routingTask.setFinishCount(routingTask.getFinishCount().intValue() + finishCount);
            routingTaskMapper.updateByPrimaryKeySelective(routingTask);
            return AjaxStatus.YES.getStatusCode();
        } catch (Exception ex) {
            logger.error(ex.toString());
            return AjaxStatus.SERVICE_RROR.getStatusCode();
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addRoutingErrorInfo(TbEquipFaultInfo tbEquipFaultInfo) {
        TbRoutingTaskDetail routingTaskDetail = routingTaskDetailMapper.selectByPrimaryKey(tbEquipFaultInfo.getDetailTaskNo());
        try {
            if (routingTaskDetail.getRoutingStatus().intValue() == 2) {
                return AjaxStatus.RECOMMITE.getStatusCode();
            } else {
                TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey(routingTaskDetail.getTaskNo());
                if (routingTaskDetail.getRoutingStatus().intValue() == 0) {
                    routingTask.setFinishCount(routingTask.getFinishCount() + 1);
                    routingTask.setErrorCount(routingTask.getErrorCount() + 1);
                    routingTaskMapper.updateByPrimaryKeySelective(routingTask);
                }
                routingTaskDetail.setRoutingStatus(2);
                routingTaskDetail.setCommitTime(new Date());

                routingTaskDetailMapper.updateByPrimaryKeySelective(routingTaskDetail);
                tbEquipFaultInfo.setFactoryNo(routingTask.getFactoryNo());

                if (StringUtils.isNotEmpty(routingTaskDetail.getEquipNo())) {
                    TbEquipInfo equipInfo = equipInfoMapper.selectByPrimaryKey(routingTaskDetail.getEquipNo());
                    tbEquipFaultInfo.setEquipName(equipInfo.getEquipName());
                    tbEquipFaultInfo.setEquipNo(equipInfo.getEquipNo());
                }

                equipFaultInfoMapper.insertSelective(tbEquipFaultInfo);
                return AjaxStatus.YES.getStatusCode();
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return AjaxStatus.SERVICE_RROR.getStatusCode();


    }

    @Override
    public TbEquipFaultInfo getRoutingErrorDetail(String errorNo) {
        TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
        if (equipFaultInfo != null && StringUtils.isNotEmpty(equipFaultInfo.getDetailTaskNo())) {
            TbRoutingTaskDetail routingTaskDetail = routingTaskDetailMapper.selectByPrimaryKey(equipFaultInfo.getDetailTaskNo());
            if (routingTaskDetail != null) {
                equipFaultInfo.setRoutingInfo(routingTaskDetail.getElementName());
                TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(routingTaskDetail.getLocationNo());
                if (routingLocation != null) {
                    equipFaultInfo.setLocationName(routingLocation.getLocationName());
                }
            }

        }
        return equipFaultInfo;
    }

    @Override
    public List<TbRoutingLocation> getRoutingTaskDetailList(String taskNo) {
        TbRoutingTaskDetailExample example = new TbRoutingTaskDetailExample();
        TbRoutingTaskDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        example.setOrderByClause(" element_type desc");
        List<TbRoutingTaskDetail> list = routingTaskDetailMapper.selectByExample(example);
        getRoutingErrorInfo(list);
        List<String> locationIds = list.stream().map(TbRoutingTaskDetail::getLocationNo).collect(Collectors.toList());
        List<String> equipIds = list.stream().map(TbRoutingTaskDetail::getEquipNo).collect(Collectors.toList());
        TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey(taskNo);
        //现获取巡检点列表
        TbRoutingLocation tbRoutingLocationSearch = new TbRoutingLocation();
        tbRoutingLocationSearch.setFactoryNo(routingTask.getFactoryNo());
        List<TbRoutingLocation> routingLocationList = getRoutingLocationList(tbRoutingLocationSearch);
        List<TbRoutingLocatioinEquip> locationEquipList = getRoutingEquipListByIds(locationIds);
        for (int i = locationEquipList.size() - 1; i >= 0; i--) {
            if (!equipIds.contains(locationEquipList.get(i).getEquipNo())) {
                locationEquipList.remove(i);
                continue;
            }
            for (TbRoutingTaskDetail routingTaskDetail : list) {
                if (StringUtils.isNotEmpty(routingTaskDetail.getEquipNo())) {
                    if (routingTaskDetail.getEquipNo().equals(locationEquipList.get(i).getEquipNo())) {
                        locationEquipList.get(i).getTaskDetailList().add(routingTaskDetail);
                    }
                }
            }
        }
        for (int i = routingLocationList.size() - 1; i >= 0; i--) {
            TbRoutingLocation routingLocation = routingLocationList.get(i);
            if (!locationIds.contains(routingLocation.getLocationNo())) {
                routingLocationList.remove(routingLocation);
                continue;
            }
            for (int n = locationEquipList.size() - 1; n >= 0; n--) {
                if (locationEquipList.get(n).getRoutingNo().equals(routingLocation.getLocationNo())) {
                    routingLocation.getEquipList().add(locationEquipList.get(n));
                }
            }
            for (TbRoutingTaskDetail routingTaskDetail : list) {
                if (!StringUtils.isNotEmpty(routingTaskDetail.getEquipNo())) {
                    if (routingTaskDetail.getLocationNo().equals(routingLocation.getLocationNo())) {
                        routingLocation.getTaskDetailList().add(routingTaskDetail);
                    }
                }
            }
        }

        return routingLocationList;
    }

    private void getRoutingErrorInfo(List<TbRoutingTaskDetail> list) {
        List<String> taskNoList = new ArrayList<>();
        for (TbRoutingTaskDetail routingTaskDetail : list) {
            if (routingTaskDetail.getRoutingStatus().equals(2)) {
                taskNoList.add(routingTaskDetail.getTaskDetailNo());
            }
        }
        if (taskNoList.size() > 0) {
            TbEquipFaultInfoExample example = new TbEquipFaultInfoExample();
            example.createCriteria().andDetailTaskNoIn(taskNoList);
            List<TbEquipFaultInfo> equipFaultInfoList = equipFaultInfoMapper.selectByExample(example);
            for (TbEquipFaultInfo equipFaultInfo : equipFaultInfoList) {
                for (TbRoutingTaskDetail routingTaskDetail : list) {
                    {
                        if (routingTaskDetail.getTaskDetailNo().equals(equipFaultInfo.getDetailTaskNo())) {
                            routingTaskDetail.setEquipFaultInfo(equipFaultInfo);
                        }
                    }
                }
            }
        }

    }

    @Override
    public List<TbRoutingTaskDetail> getRoutingDetailList(String taskNo) {
        TbRoutingTaskDetailExample example = new TbRoutingTaskDetailExample();
        TbRoutingTaskDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        return routingTaskDetailMapper.selectByExample(example);
    }

    @Override
    public List<RoutingLocationVo> getTaskRoutingLocationList(TbRoutingTask routingTask) {
        List<RoutingLocationVo> routingLocationVoList = new ArrayList<>();
        TbRoutingTask oldRoutingTask = routingTaskMapper.selectByPrimaryKey(routingTask.getTaskNo());
        if (oldRoutingTask == null) {
            return new ArrayList<>();
        }
        String modelNo = oldRoutingTask.getModelNo();
        List<Map<String, Object>> list = routingTaskDetailMapper.getRoutingTaskDetailList(routingTask.getTaskNo(), null);
        TbRoutingModel routingModel = routingModelMapper.selectByPrimaryKey(modelNo);
        Map<String, RoutingLocationVo> locationMap = new HashMap<>();
        for (Map<String, Object> map : list) {
            String locationName = map.get("location_name").toString();
            String locationNo = map.get("location_no").toString();
            String equipName = map.get("equip_name") == null ? null : map.get("equip_name").toString();
            RoutingLocationVo locationVo;
            if (locationMap.containsKey(locationNo)) {
                locationVo = locationMap.get(locationNo);
            } else {
                locationVo = new RoutingLocationVo();
                locationVo.setLocationNo(locationNo);
                locationVo.setLocationName(locationName);
                locationVo.setNeedCount(0);
                locationVo.setFinishCount(0);
                if (routingModel != null) {
                    locationVo.setModelName(routingModel.getRoutingModelName());
                }
                locationMap.put(locationNo, locationVo);
            }
            //记录异常数量
            if (equipName != null && !"null".equals(equipName)) {
                if (locationVo.getEquipBuffer().indexOf(equipName) < 0) {
                    locationVo.setEquipBuffer(locationVo.getEquipBuffer().append(equipName).append(","));
                }
            }
            if ("2".equals(map.get("routing_status").toString())) {
                locationVo.setErrorCount(locationVo.getErrorCount() + 1);
            }
            locationVo.setNeedCount(locationVo.getNeedCount() + 1);
            if (!"0".equals(map.get("routing_status").toString())) {
                locationVo.setFinishCount(locationVo.getFinishCount() + 1);
            }

        }
        //  return  new ArrayList<>(locationMap.values());
        for (String s : locationMap.keySet()) {
            routingLocationVoList.add(locationMap.get(s));
        }

        return routingLocationVoList;
    }

    @Override
    public Map<String, Object> getRoutingTaskDetailByLocation(String taskNo, String locationNo) {
        List<Map<String, Object>> list = routingTaskDetailMapper.getRoutingTaskDetailList(taskNo, locationNo);
        List<Map<String, Object>> locationElementList = new ArrayList<>();
        Map<String, Map<String, Object>> equipMap = new HashMap<>();
        List<String> browsePathList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Map<String, Object> elementMap = new HashMap<>();
            String taskDetailNo = map.get("task_detail_no").toString();
            int elementType = Integer.parseInt(map.get("element_type").toString());
            String elementName = map.get("element_name").toString();
            int status = Integer.parseInt(map.get("routing_status").toString());
            elementMap.put("taskDetailNo", taskDetailNo);
            elementMap.put("elementType", elementType);
            elementMap.put("status", status);
            elementMap.put("elementName", elementName);
            //如果是填报要素
            if (elementType == 2) {
                if (map.get("fill_value") != null) {
                    double fillValue = Double.parseDouble(map.get("fill_value").toString());
                    elementMap.put("fillValue", fillValue);
                }
                if (map.get("field_unit") != null) {
                    String fieldUnit = map.get("field_unit").toString();
                    elementMap.put("fieldUnit", fieldUnit);
                }
                if (map.get("auto_browse_path") != null && StringUtils.isNotEmpty(map.get("auto_browse_path").toString())) {
                    String browsePath = map.get("auto_browse_path").toString();
                    elementMap.put("browsePath", browsePath);
                    if (status == 0) {
                        browsePathList.add(browsePath);
                    }
                }
            }
            //如果没有设备 则是在巡检点下的巡检要素
            if (map.get("equip_name") == null) {
                locationElementList.add(elementMap);
            } else {
                String equipNo = map.get("equip_no").toString();
                String equipName = map.get("equip_name").toString();
                Map<String, Object> equipObjectMap = null;
                if (!equipMap.containsKey(equipNo)) {
                    equipObjectMap = new HashMap<>();
                    List<Object> elementList = new ArrayList<>();
                    equipObjectMap.put("elementList", elementList);
                    equipObjectMap.put("equipNo", equipNo);
                    equipObjectMap.put("equipName", equipName);
                    equipMap.put(equipNo, equipObjectMap);
                } else {
                    equipObjectMap = equipMap.get(equipNo);
                }
                List<Map<String, Object>> elementList = (List<Map<String, Object>>) equipObjectMap.get("elementList");
                elementList.add(elementMap);
            }
        }
        Map<String, Object> detailMap = new HashMap<>();
        List<Map<String, Object>> equipList = new ArrayList<>(equipMap.values());
        detailMap.put("equipList", equipList);
        detailMap.put("elementList", locationElementList);
        logger.info("browsePathList:" + browsePathList.size());
        getAutoFieldValue(equipList, locationElementList, browsePathList);
        return detailMap;
    }

    private void getAutoFieldValue(List<Map<String, Object>> equipList, List<Map<String, Object>> elementList, List<String> browsePathList) {
        String[] uriCollection = new String[browsePathList.size()];
        browsePathList.toArray(uriCollection);
        JSONObject jsonObject = bewgService.getDataInfoNew(uriCollection);
        logger.info(jsonObject.toString());
        if ("0x00000000".equals(jsonObject.getString("code"))) {
            JSONArray resultArray = jsonObject.getJSONArray("result");
            for (int i = 0; i < resultArray.size(); i++) {
                JSONObject valueJson = resultArray.getJSONObject(i);
                if (valueJson != null) {
                    double value = StringTools.formatDouble(valueJson.getDouble("v"), 2);
                    String browsePath = browsePathList.get(i);
                    for (Map<String, Object> equipObject : equipList) {
                        if (equipObject.containsKey("elementList")) {
                            List<Map<String, Object>> equipElementList = (List<Map<String, Object>>) equipObject.get("elementList");
                            for (Map<String, Object> elementMap : equipElementList) {
                                if (elementMap.containsKey("browsePath") && browsePath.equals(elementMap.get("browsePath").toString())) {
                                    elementMap.put("autoValue", value);
                                }
                            }
                        }
                    }
                    for (Map<String, Object> elementMap : elementList) {
                        if (elementMap.containsKey("browsePath") && browsePath.equals(elementMap.get("browsePath").toString())) {
                            elementMap.put("autoValue", value);
                        }
                    }
                }

            }
        }

    }


    /**
     * 通过巡检模式编号 查询详情
     *
     * @param modelNo
     * @return
     */
    private List<TbRoutingModelExtend> getRoutingModelList(String modelNo) {
        TbRoutingModelExtendExample extendExample = new TbRoutingModelExtendExample();
        TbRoutingModelExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andRoutingModelNoEqualTo(modelNo);
        return routingModelExtendMapper.selectByExample(extendExample);
    }

    /**
     * 根据主键 批量删除
     *
     * @param extendNoList
     * @return
     */
    private void deleteRoutingModelExtends(List<String> extendNoList) throws Exception {
        TbRoutingModelExtendExample extendExample = new TbRoutingModelExtendExample();
        TbRoutingModelExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andRoutingModelExtendNoIn(extendNoList);
        routingModelExtendMapper.deleteByExample(extendExample);
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int saveImportTbRoutingLocationElement(List<TbRoutingLocationElementVo> list, String factoryNo) {

        String parentNo = "";
        String locationNo = "";
        if (list != null && list.size() > 0) {
            for (TbRoutingLocationElementVo tbVo : list) {
                flag = 0;
                //设备为主
                TbRoutingLocationElement locationElement = new TbRoutingLocationElement();
                String equipName = tbVo.getEquipName();
                String locationName = tbVo.getLocationName();
                if (equipName != null || (equipName != null && locationName != null)) {
                    if (equipName.split(",").length == 2) {
                        parentNo = equipName.split(",")[1];
                        tbVo.setParentType(1);
                    }
                } else {
                    if (locationName.split(",").length == 2) {
                        parentNo = locationName.split(",")[1];
                        tbVo.setParentType(2);
                    }
                }
                BeanUtils.copyProperties(tbVo, locationElement);
                locationElement.setLocationFieldNo(StringTools.getUUID());
                locationElement.setParentNo(parentNo);
                locationElement.setElementType(1);
                locationElement.setDeleteFlag(0);
                flag = routingLocationElementMapper.insertSelective(locationElement);
            }
            if (flag == 0) {
                throw new BusinessException(500, "导入失败");
            }
        }

        return flag;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int addTempRoutingTask(TbRoutingTaskConditon conditon, TbUser user) throws BusinessException {
        flag = 0;
        if (conditon != null) {
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(conditon.getFactoryNo());
            conditon.setBeginTime(DateUtils.parseDateFull(conditon.getBeginTimeName()));

            //生成code校验
            TbRoutingTask model = new TbRoutingTask();
            model.setFactoryNo(conditon.getFactoryNo());
            model.setTempStatus(1);
            model.setBeginTime(conditon.getBeginTime());
            List<TbRoutingTask> tbRoutingTaskList = getTbRoutingTaskList(model);
            String taskCode = "";
            String code = DateUtils.formateMyDate(conditon.getBeginTime(), "yyyyMMddHHmm");
            if (tbRoutingTaskList != null && tbRoutingTaskList.size() > 0) {
                taskCode = tbFactoryInfo.getBrowsename() + "LSXJ" + (Long.parseLong(code) + tbRoutingTaskList.size());

            } else {
                taskCode = tbFactoryInfo.getBrowsename() + "LSXJ" + code;
            }
            TbRoutingTask routingTask = createTbRoutingTask(null, taskCode, conditon.getBeginTime(), user);
            //创建临时巡检工单
            routingTask.setFactoryNo(conditon.getFactoryNo());
            routingTask.setTaskType(conditon.getTaskType());
            routingTask.setTempStatus(TEMP_YES);
            if (conditon.getTbRoutingTaskConditonList() != null && conditon.getTbRoutingTaskConditonList().size() > 0) {
                routingTask.setNeedCount(conditon.getTbRoutingTaskConditonList().size());
            }
            //System.out.println(routingTask);
            flag = routingTaskMapper.insertSelective(routingTask);
            if (flag == 1) {
                flag = saveTbRoutingTaskDetail(routingTask, conditon.getTbRoutingTaskConditonList());
            }
            getResult(flag);
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int modifyTempRoutingTask(TbRoutingTaskConditon conditon, TbUser user) throws BusinessException {
        TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey(conditon.getTaskNo());
        routingTask.setTaskType(conditon.getTaskType());
        if (conditon.getTbRoutingTaskConditonList() != null && conditon.getTbRoutingTaskConditonList().size() > 0) {
            routingTask.setNeedCount(conditon.getTbRoutingTaskConditonList().size());
        }
        //设置时间
        routingTask.setBeginTime(DateUtils.parseDateFull(conditon.getBeginTimeName()));
        routingTaskMapper.updateByPrimaryKeySelective(routingTask);
        //先删除详情
        TbRoutingTaskDetailExample routingTaskDetailExample = new TbRoutingTaskDetailExample();
        TbRoutingTaskDetailExample.Criteria criteria = routingTaskDetailExample.createCriteria();
        criteria.andTaskNoEqualTo(conditon.getTaskNo());
        routingTaskDetailMapper.deleteByExample(routingTaskDetailExample);
        //重新添加详情
        saveTbRoutingTaskDetail(routingTask, conditon.getTbRoutingTaskConditonList());
        return AjaxStatus.YES.getStatusCode();
    }


    public void getResult(int result) throws BusinessException {
        if (result == 0) {
            throw new BusinessException(500, "保存失败");
        }
    }

    public int saveTbRoutingTaskDetail(TbRoutingTask routingTask, List<TbRoutingTaskConditon> list) {
        flag = 0;
        List<TbRoutingTaskDetail> tbRoutingTaskDetailList = new ArrayList<>();
        for (TbRoutingTaskConditon tbRoutingTaskConditon : list) {
            TbRoutingTaskDetail detail = new TbRoutingTaskDetail();
            detail.setTaskDetailNo(StringTools.getUUID());
            detail.setTaskNo(routingTask.getTaskNo());
            detail.setElementType(tbRoutingTaskConditon.getElementType());
            detail.setLocationNo(tbRoutingTaskConditon.getLocationNo());
            //查询要素名称
            TbRoutingLocationElement locationElement = routingLocationElementMapper.selectByPrimaryKey(tbRoutingTaskConditon.getLocationFieldNo());
            if (locationElement != null) {
                detail.setElementName(locationElement.getElementName());
                detail.setFieldUnit(locationElement.getFieldUnit());
                detail.setFieldNo(locationElement.getFieldNo());
                detail.setAutoBrowsePath(locationElement.getAutoFieldBrowsePath());
            }
            detail.setElementNo(tbRoutingTaskConditon.getLocationFieldNo());
            detail.setEquipNo(tbRoutingTaskConditon.getEquipNo());
            detail.setRoutingStatus(0);
            tbRoutingTaskDetailList.add(detail);
        }
        System.out.println(tbRoutingTaskDetailList);
        flag = routingTaskDetailMapper.insertBatch(tbRoutingTaskDetailList);
        return flag;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int addTempTbRoutingModel(TbRoutingModelCondition conditon, TbUser user) {
        flag = 0;
        if (conditon != null) {
            //根据水厂和名字 校验
            TbRoutingModel model = new TbRoutingModel();
            model.setRoutingModelNo(StringTools.getUUID());
            model.setCreateTime(new Date());
            model.setFactoryNo(conditon.getFactoryNo());
            model.setRoutingModelName(conditon.getRoutingModelName());
            model.setRoutingModelLevel(conditon.getRoutingModelLevel());
            model.setRoutingModelStatus(0);
            model.setRouteType(1);
            List<TbRoutingModel> routingModelListByName = getRoutingModelListByName(model);
            if (routingModelListByName != null && routingModelListByName.size() > 0) {
                flag = Dict.AjaxStatus.MODEL_NAME_REPEAT.getStatusCode();
            } else {
                if (conditon.getTbRoutingModelConditionList() != null && conditon.getTbRoutingModelConditionList().size() > 0) {
                    model.setAllCount(conditon.getTbRoutingModelConditionList().size());
                } else {
                    model.setAllCount(0);
                }
                if (user != null) {
                    model.setCreateUser(user.getCode());
                }
                model.setDeleteFlag(0);
                flag = routingModelMapper.insert(model);
                if (flag == 1) {
                    flag = saveRoutingModelExtend(model, conditon.getTbRoutingModelConditionList());
                    if (flag >= 1) {
                        flag = 1;
                    }
                }
                getResult(flag);
            }
        }
        return flag;
    }

    public int saveRoutingModelExtend(TbRoutingModel model, List<TbRoutingModelCondition> list) {
        flag = 0;
        List<TbRoutingModelExtend> tbRoutingModelExtendList = new ArrayList<>();
        for (TbRoutingModelCondition condition : list) {
            TbRoutingModelExtend detail = new TbRoutingModelExtend();
            detail.setRoutingModelExtendNo(StringTools.getUUID());
            detail.setRoutingModelNo(model.getRoutingModelNo());
            detail.setRoutingElementNo(condition.getLocationFieldNo());
            detail.setRoutingElementType(condition.getElementType());
            detail.setRoutingEquipNo(condition.getEquipNo());
            detail.setRoutingLocationNo(condition.getLocationNo());
            detail.setCreateTime(new Date());
            tbRoutingModelExtendList.add(detail);
        }
        System.out.println(tbRoutingModelExtendList);
        flag = routingModelExtendMapper.insertBatch(tbRoutingModelExtendList);
        return flag;
    }

    public List<TbRoutingModel> getRoutingModelListByName(TbRoutingModel model) {
        TbRoutingModelExample extendExample = new TbRoutingModelExample();
        TbRoutingModelExample.Criteria criteria = extendExample.createCriteria();
        criteria.andFactoryNoEqualTo(model.getFactoryNo());
        criteria.andRoutingModelNameEqualTo(model.getRoutingModelName());
        return routingModelMapper.selectByExample(extendExample);
    }

    @Override
    public List<TbRoutingTask> getTbRoutingTaskList(TbRoutingTask model) {
        TbRoutingTaskExample example = new TbRoutingTaskExample();
        TbRoutingTaskExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(model.getFactoryNo());
        if (model.getTempStatus() != null) {
            criteria.andTempStatusEqualTo(model.getTempStatus());
        }
        if (model.getBeginTime() != null) {
            criteria.andBeginTimeEqualTo(model.getBeginTime());
        }
        if (model.getTaskStatus() != null) {
            criteria.andTaskStatusEqualTo(model.getTaskStatus());
        }
        if (model.getCommitUserCode() != null) {
            criteria.andCommitUserCodeEqualTo(model.getCommitUserCode());
        }
        return routingTaskMapper.selectByExample(example);
    }

    @Override
    public List<TbRoutingLocation> selectRoutingLocationList(String[] locationNos) {
        return routingLocationMapper.selectRoutingLocationList(locationNos);
    }

    @Override
    public int updateLocationTrajectory(TbRoutingTaskDetail routingTaskDetail) {

        TbRoutingTaskDetail oldRoutingTaskDetail = routingTaskDetailMapper.selectByPrimaryKey(routingTaskDetail.getTaskDetailNo());

        TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(oldRoutingTaskDetail.getLocationNo());
        if (routingLocation == null) {
            return AjaxStatus.NOFIND.getStatusCode();
        }
        TbRoutingTrajectory routingTrajectory = getOldRoutingTrajectory(oldRoutingTaskDetail.getTaskNo(), routingLocation.getLocationNo());
        if (routingTrajectory == null) {
            routingTrajectory = new TbRoutingTrajectory();
            routingTrajectory.setLocationNo(routingLocation.getLocationNo());
            routingTrajectory.setTrajeNo(StringTools.getUUID());
            routingTrajectory.setRoutingTaskNo(oldRoutingTaskDetail.getTaskNo());
            routingTrajectory.setTrajeX(routingLocation.getLocationX());
            routingTrajectory.setTrajeY(routingLocation.getLocationY());
            routingTrajectory.setTrajeTime(new Date());
            routingTrajectoryMapper.insertSelective(routingTrajectory);
        } else {
            routingTrajectory.setTrajeTime(new Date());
            routingTrajectoryMapper.updateByPrimaryKeySelective(routingTrajectory);
        }

        return AjaxStatus.YES.getStatusCode();
    }

    private TbRoutingTrajectory getOldRoutingTrajectory(String taskNo, String locationNo) {
        TbRoutingTrajectoryExample example = new TbRoutingTrajectoryExample();
        example.createCriteria().andLocationNoEqualTo(locationNo).andRoutingTaskNoEqualTo(taskNo);
        List<TbRoutingTrajectory> list = routingTrajectoryMapper.selectByExample(example);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<TbRoutingTrajectory> getRoutingTrajectorylList(String taskNo) {
        TbRoutingTrajectoryExample example = new TbRoutingTrajectoryExample();
        example.createCriteria().andRoutingTaskNoEqualTo(taskNo);
        example.setOrderByClause(" traje_time  ");
        return routingTrajectoryMapper.selectByExample(example);
    }


    @Override
    public TbRoutingLocation getTaskRoutingLocationByNfcNo(TbRoutingLocation tbRoutingLocation) {
        return routingLocationMapper.getTaskRoutingLocationByNfcNo(tbRoutingLocation);
    }

    @Override
    public int saveImportTbRoutingLocationReportElement(List<TbRoutingLocationFillElementVo> list) {
        String parentNo = "";
        if (list != null && list.size() > 0) {
            for (TbRoutingLocationFillElementVo tbVo : list) {
                flag = 0;
                TbRoutingLocationElement locationElement = new TbRoutingLocationElement();
                String filedName = tbVo.getFieldNoName();
                String equipName = tbVo.getEquipName();
                String locationName = tbVo.getLocationName();
                if (equipName != null || (equipName != null && locationName != null)) {
                    if (equipName.split(",").length == 2) {
                        parentNo = equipName.split(",")[1];
                        tbVo.setParentType(1);
                    }
                } else {
                    if (locationName.split(",").length == 2) {
                        parentNo = locationName.split(",")[1];
                        tbVo.setParentType(2);
                    }
                }
                List<TbParameterConfig> tbParameterConfigList = getTbParameterConfigList(filedName);
                BeanUtils.copyProperties(tbVo, locationElement);
                if (tbParameterConfigList != null && tbParameterConfigList.size() > 0) {
                    locationElement.setFieldNo(tbParameterConfigList.get(0).getParamNo());
                }
                locationElement.setLocationFieldNo(StringTools.getUUID());
                locationElement.setElementType(2);
                locationElement.setDeleteFlag(0);
                locationElement.setParentNo(parentNo);
                flag = routingLocationElementMapper.insertSelective(locationElement);
            }
            if (flag == 0) {
                throw new BusinessException(500, "导入失败");
            }
        }
        return flag;
    }

    public List<TbParameterConfig> getTbParameterConfigList(String name) {
        TbParameterConfigExample example = new TbParameterConfigExample();
        TbParameterConfigExample.Criteria criteria = example.createCriteria();
        criteria.andParamNameEqualTo(name);
        criteria.andParamFromNotEqualTo(1);
        return tbParameterConfigMapper.selectByExample(example);

    }

    @Override
    public TbNfcInfo getNfcInfo(String nfcNo) {
        return tbNfcInfoMapper.selectByPrimaryKey(nfcNo);
    }

    @Override
    public int savePcError(TbEquipFaultInfo tbEquipFaultInfo) {
        flag = 0;
        flag = equipFaultInfoMapper.insertSelective(tbEquipFaultInfo);
        return flag;
    }

    @Override
    public int upOrDownLocationLinkEquip(TbRoutingLocatioinEquip tbRoutingLocatioinEquip) {
        flag = 0;
        if (tbRoutingLocatioinEquip != null) {
            TbRoutingLocatioinEquip current = tbRoutingLocatioinEquipMapper.selectByPrimaryKey(tbRoutingLocatioinEquip.getLocationEquipNo());
            Integer currentSort = current.getEquipSort();
            TbRoutingLocatioinEquip upOrDowm = tbRoutingLocatioinEquipMapper.selectByPrimaryKey(tbRoutingLocatioinEquip.getLocationEquipNoUpOrDown());
            Integer upOrDowmSort = upOrDowm.getEquipSort();
            if (current != null && upOrDowm != null) {
                current.setEquipSort(upOrDowmSort);
                flag = tbRoutingLocatioinEquipMapper.updateByPrimaryKey(current);
                if (flag == 1) {
                    upOrDowm.setEquipSort(currentSort);
                    flag = tbRoutingLocatioinEquipMapper.updateByPrimaryKey(upOrDowm);
                }
            }
        }
        return flag;
    }

    public List<TbRoutingLocatioinEquip> getTbRoutingLocationEquipList(TbRoutingLocatioinEquip tbRoutingLocatioinEquip) {
        TbRoutingLocatioinEquipExample example = new TbRoutingLocatioinEquipExample();
        TbRoutingLocatioinEquipExample.Criteria criteria = example.createCriteria();
        if (tbRoutingLocatioinEquip != null) {
            if (tbRoutingLocatioinEquip.getEquipNo() != null) {
                criteria.andEquipNoEqualTo(tbRoutingLocatioinEquip.getEquipNo());
            }
            if (tbRoutingLocatioinEquip.getRoutingNo() != null) {
                criteria.andRoutingNoEqualTo(tbRoutingLocatioinEquip.getRoutingNo());
            }
            if (tbRoutingLocatioinEquip.getEquipSort() != null) {
                criteria.andEquipSortEqualTo(tbRoutingLocatioinEquip.getEquipSort());
            }
        }
        return tbRoutingLocatioinEquipMapper.selectByExample(example);

    }
}

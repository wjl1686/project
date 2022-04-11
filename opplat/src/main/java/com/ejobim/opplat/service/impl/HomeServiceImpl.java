package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.HomeService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.WorkFlowCommon.*;

@Service
public class HomeServiceImpl implements HomeService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbFillFormTaskMapper tbFillFormTaskMapper;


    @Autowired
    private TbObjectDataMapper tbObjectDataMapper;

    @Autowired
    private OrgGroupInfoMapper orgGroupInfoMapper;

    @Autowired
    private TbSynObjectMapper synObjectMapper;

    @Autowired
    private TbFactoryInfoMapper factoryInfoMapper;

    @Autowired
    private BewgService bewgService;

    @Autowired
    private TbEquipFaultInfoMapper equipFaultInfoMapper;

    @Autowired
    private TbWorkTaskInfoMapper workTaskInfoMapper;

    @Autowired
    private TbOrgMapper orgMapper;

    @Autowired
    private TbDraftDataMapper tbDraftDataMapper;


    @Override
    public Map<String, Object> getHomeInfo(TaskInfoCondition condition) {


        Map<String, Object> objectMap = new HashMap<>(16);
        Map<String, Object> noMap = new HashMap<>(16);
        Map<String, Object> planMap = new HashMap<>(16);
        List<TaskVo> taskVoList = new ArrayList<>(16);
        FinishVo finishVo = new FinishVo();
        NoFinishVo noFinishVo = new NoFinishVo();


        objectMap.put("noFinish", noMap);
        objectMap.put("planFinish", planMap);
        objectMap.put("nowData", taskVoList);
        objectMap.put("mouthFinishVo", finishVo);
        objectMap.put("mouthNoFinishVo", noFinishVo);
        return objectMap;
    }

    private <T> Map<String, Integer> commonMap(Map<Date, List<T>> listMap) {
        Map<String, Integer> map = new HashMap<>(30);
        for (Date date : listMap.keySet()) {
            if (map.containsKey(DateUtils.formateDate(date))) {
                map.put(DateUtils.formateDate(date), map.get(DateUtils.formateDate(date)) + 1);
            } else {
                map.put(DateUtils.formateDate(date), listMap.get(date).size());
            }

        }
        return map;
    }


    /**
     * 填报
     *
     * @param condition
     * @return
     */
    private Map<String, Object> tbFillFormTaskVoMap(TaskInfoCondition condition) {
        Map<String, Object> objectMap = new HashMap<>(100);
        //未完成的
        List<TbFillFormTaskVo> tbNofinish = new ArrayList<>();
        //待完成的
        List<TbFillFormTaskVo> tbPlanFinish = new ArrayList<>();

        List<TbFillFormTaskVo> finish = new ArrayList<>();
        List<TbFillFormTaskVo> nowData = new ArrayList<>();
        List<TbFillFormTaskVo> nowDayNoFinish = new ArrayList<>();
        List<TbFillFormTaskVo> nowDayFinish = new ArrayList<>();
        List<TbFillFormTaskVo> tbFillFormAllList = tbFillFormTaskMapper.getTbFillFormTaskListByUser(condition);
        Map<String, Integer> noFinishMap = new HashMap<>();
        Map<String, Integer> planFinishMap = new HashMap<>();
        //按条件过滤
        tbNofinish = tbFillFormAllList.stream().filter(tbFillFormTask -> tbFillFormTask.getCommitTime() == null && tbFillFormTask.getEndTime().getTime() <= System.currentTimeMillis()).collect(Collectors.toList());
        finish = tbFillFormAllList.stream().filter(tbFillFormTask -> tbFillFormTask.getCommitTime() != null).collect(Collectors.toList());
        Map<Date, List<TbFillFormTaskVo>> collect = tbNofinish.stream().collect(Collectors.groupingBy(TbFillFormTaskVo::getEndTime));
        noFinishMap = commonMap(collect);
        objectMap.put("noFinish", noFinishMap);
        objectMap.put("finishFill", finish.size());

        tbPlanFinish = tbFillFormAllList.stream().filter(tbFillFormTask -> tbFillFormTask.getCommitTime() == null && tbFillFormTask.getFillTaskTime().getTime() > System.currentTimeMillis()).collect(Collectors.toList());
        Map<Date, List<TbFillFormTaskVo>> collect1 = tbPlanFinish.stream().collect(Collectors.groupingBy(TbFillFormTaskVo::getFillTaskTime));
        planFinishMap = commonMap(collect1);
        objectMap.put("planFinish", planFinishMap);
        //大于00.00 小于第二天的00.00分
        nowData = tbFillFormAllList.stream().filter(tbFillFormTask -> tbFillFormTask.getFillTaskTime().getTime() >= DateUtils.getZeroDay() && tbFillFormTask.getFillTaskTime().getTime() <= DateUtils.get23Day()).collect(Collectors.toList());
        nowDayNoFinish = nowData.stream().filter(tbFillFormTask -> tbFillFormTask.getCommitTime() == null).collect(Collectors.toList());
        nowDayFinish = nowData.stream().filter(tbFillFormTask -> tbFillFormTask.getCommitTime() != null).collect(Collectors.toList());

        objectMap.put("nowData", nowData);
        objectMap.put("nowDayNoFillFinish", nowDayNoFinish.size());
        objectMap.put("nowDayFillFinish", nowDayFinish.size());
        return objectMap;
    }


    /**
     * 巡检
     *
     * @param condition
     * @return
     */
    private Map<String, Object> tbInspcetTaskVoMap(TaskInfoCondition condition) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Integer> noFinishTbInspcetTaskVoMap = new HashMap<>();
        Map<String, Integer> planFinishTbInspcetTaskVoMap = new HashMap<>();
        //未完成的
        List<TbInspcetTaskVo> tbNofinish = new ArrayList<>();
        //待完成的
        List<TbInspcetTaskVo> tbPlanFinish = new ArrayList<>();
        List<TbInspcetTaskVo> finish = new ArrayList<>();
        List<TbInspcetTaskVo> nowData = new ArrayList<>();
        List<TbInspcetTaskVo> nowDayNoFinish = new ArrayList<>();
        List<TbInspcetTaskVo> nowDayFinish = new ArrayList<>();

        Map<Date, List<TbInspcetTaskVo>> collect = tbNofinish.stream().collect(Collectors.groupingBy(TbInspcetTaskVo::getInspEndTime));
        noFinishTbInspcetTaskVoMap = commonMap(collect);
        map.put("noFinish", noFinishTbInspcetTaskVoMap);
        map.put("finishInspcet", finish.size());


        map.put("planFinish", planFinishTbInspcetTaskVoMap);

        map.put("nowData", nowData);
        map.put("nowDayNoInspcetFinish", nowDayNoFinish.size());
        map.put("nowDayInspcetFinish", nowDayFinish.size());
        return map;
    }


    public List<Object> commonMethod(Map<String, Object> objectMap) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> noMap = new HashMap<>();
        Map<String, Object> planMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        List<Object> object = new ArrayList<>();
        Map<String, Integer> noFinishWrok = (Map<String, Integer>) objectMap.get("noFinish");
        for (String s : noFinishWrok.keySet()) {
            if (noMap.containsKey(s)) {
                noMap.put(s, (Integer) noMap.get(s) + noFinishWrok.get(s));
            } else {
                noMap.put(s, noFinishWrok.get(s));
            }
        }
        Map<String, Integer> planFinishWrok = (Map<String, Integer>) objectMap.get("planFinish");
        //取待完成
        for (String s : planFinishWrok.keySet()) {
            if (planMap.containsKey(s)) {
                planMap.put(s, (Integer) planMap.get(s) + planFinishWrok.get(s));
            } else {
                planMap.put(s, planFinishWrok.get(s));
            }
        }
        map.put("noFinish", noMap);
        map.put("planFinish", planMap);
        object.add(map);
        return object;
    }

    @Override
    public Map<String, Object> getHomeEquipInfo(TaskInfoCondition condition) {
        Map<String, Object> objectMap = new HashMap<>(10);
        Map<String, Integer> equipMap = new HashMap<>(10);


        //取当前的

        List<String> rootList = tbObjectDataMapper.selectRootObjectUriList(condition);
        //取出所有当前有任务的设备 根据设备分组


        objectMap.put("equipMap", equipMap);
        return objectMap;
    }


    @Autowired
    private TbWorkTaskInfoMapper tbWorkTaskInfoMapper;

    @Override
    public Map<String, Object> commonTaskInfo(TaskInfoCondition condition) {
        Map<String, Object> map = new HashMap<>();
        //未完成的
        List<TbWorkTaskInfoVo> tbNofinish = new ArrayList<>();
        //待完成的
        List<TbWorkTaskInfoVo> tbPlanFinish = new ArrayList<>();
        List<TbWorkTaskInfoVo> finish = new ArrayList<>();
        List<TbWorkTaskInfoVo> nowData = new ArrayList<>();
        List<TbWorkTaskInfoVo> nowDayNoFinish = new ArrayList<>();
        List<TbWorkTaskInfoVo> nowDayFinish = new ArrayList<>();
        //查当月所有的数据
        //List<TbTaskInfoVo> allList = tbEquipOverhaulTaskMapper.getTbEquipOverhaulTaskVoListByUser(condition);
        List<TbWorkTaskInfoVo> allList = tbWorkTaskInfoMapper.getTbWorkTaskInfoVoListByUser(condition);
        //未完成的
        tbNofinish = allList.stream().filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getPlanFinishTime() != null).filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getTaskStatus() == 1 && tbWorkTaskInfoVo.getPlanFinishTime().getTime() <= System.currentTimeMillis()).collect(Collectors.toList());
        //完成的
        //finish = allList.stream().filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getTaskStatus() == 2).collect(Collectors.toList());
        Map<Date, List<TbWorkTaskInfoVo>> collect = tbNofinish.stream().collect(Collectors.groupingBy(TbWorkTaskInfoVo::getPlanStartTime));
        map.put("noFinish", commonMap(collect));
        //map.put("finishOverhaul", finish.size());
        //待完成的
        tbPlanFinish = allList.stream().filter(tbWorkTaskInfoVo -> ((tbWorkTaskInfoVo.getPlanFinishTime() == null || tbWorkTaskInfoVo.getPlanFinishTime().getTime() > System.currentTimeMillis()) && tbWorkTaskInfoVo.getTaskStatus() == 1)).collect(Collectors.toList());

        Map<Date, List<TbWorkTaskInfoVo>> collect1 = tbPlanFinish.stream().collect(Collectors.groupingBy(TbWorkTaskInfoVo::getPlanStartTime));
        map.put("planFinish", commonMap(collect1));

        nowData = allList.stream().filter(tbWorkTaskInfoVo -> (DateUtils.parseDate(DateUtils.formateDate(tbWorkTaskInfoVo.getPlanStartTime())).getTime() == DateUtils.parseDate(DateUtils.formateDateFull(new Date())).getTime())).collect(Collectors.toList());
       /* nowDayNoFinish = nowData.stream().filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getTaskStatus() == 1).collect(Collectors.toList());
        nowDayFinish = nowData.stream().filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getTaskStatus()==2).collect(Collectors.toList());*/
        map.put("nowData", nowData);
        /*map.put("nowDayNoOverhaulFinish", nowDayNoFinish.size());
        map.put("nowDayOverhaulFinish", nowDayFinish.size());*/
        return map;
    }

    @Override
    public Map<String, Object> getHomeStaticInfo(TbUser user, String factoryNo) {

        Date beginDate = DateUtils.parseDate(DateUtils.getMonthFirstDay());
        Date endDate = DateUtils.parseDate(DateUtils.getMonthLastDay());
        List<String> dayList = DateUtils.getDistDayList(beginDate, endDate);
        Map<String, Object> resultMap = initStaticMap(dayList);
        int userType = getUserType(user, factoryNo);

        switch (userType) {
            case 0:
                break;
            case 1:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode(),userType);
                break;
            case 2:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode(),userType);
                getRoutingTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode());
                //getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode());
                break;
            case 3:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode(),userType);
                getRoutingTaskInfo(resultMap, beginDate, endDate, factoryNo, user.getCode());
                break;
            case 4:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, null,userType);
                break;
            case 5:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, null,userType);
                getRoutingTaskInfo(resultMap, beginDate, endDate, factoryNo, null);
                break;
            case 6:
                getEquipTaskInfo(resultMap, beginDate, endDate, factoryNo, null,userType);
                getRoutingTaskInfo(resultMap, beginDate, endDate, factoryNo, null);
                break;
            default:
                return resultMap;

        }
        return resultMap;
    }

    /**
     * 获取设备类工单
     *
     * @param resultMap
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @param factoryNo 水厂编号
     * @param userCode  如果为空则是获取所有
     */
    private void getEquipTaskInfo(Map<String, Object> resultMap, Date beginDate, Date endDate, String factoryNo, String userCode,int userType) {
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        example.createCriteria().andPlanStartTimeBetween(beginDate, endDate).andOrgNoEqualTo(factoryNo);
        example.setOrderByClause(" plan_start_time ");
        List<TbWorkTaskInfo> list = workTaskInfoMapper.selectByExample(example);
        for (TbWorkTaskInfo workTaskInfo : list) {
            if (userCode != null) {
                if (workTaskInfo.getDutyUser() != null) {
                    JSONObject dutyUser = JSONObject.parseObject(workTaskInfo.getDutyUser());
                    if (!userCode.equals(dutyUser.getString("userCode"))) {
                        continue;
                    }
                } else {
                    continue;
                }

            }

            if(userType==5){
                //如果是运行经理类角色,只能看工艺调整
                if(GYTZ_TYPE!=workTaskInfo.getTaskType()){
                    continue;
                }
            }else  if(userType==4){
                //如果是设备经理类角色,不能看工艺调整
                if(GYTZ_TYPE!=workTaskInfo.getTaskType()){
                    continue;
                }
            }
            String date = DateUtils.formateDate(workTaskInfo.getPlanStartTime());
            List<TaskVo> taskList = null;
            if (resultMap.containsKey(date)) {
                taskList = (List<TaskVo>) resultMap.get(date);
            } else {
                taskList = new ArrayList<>();
            }
            taskList.add(TaskVo.parseWorkTaskInfo(workTaskInfo));
        }
    }

    /**
     * 获取巡检异常工单
     *
     * @param resultMap
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @param factoryNo 水厂编号
     * @param userCode  如果为空则是获取所有
     */
    private void getRoutingTaskInfo(Map<String, Object> resultMap, Date beginDate, Date endDate, String factoryNo, String userCode) {
        TbEquipFaultInfoExample example = new TbEquipFaultInfoExample();
        example.createCriteria().andUpdateTimeBetween(beginDate, endDate).andFactoryNoEqualTo(factoryNo);
        example.setOrderByClause(" update_time ");
        List<TbEquipFaultInfo> list = equipFaultInfoMapper.selectByExample(example);
        for (TbEquipFaultInfo equipFaultInfo : list) {
            //判断该工单是否归属于该用户
            if (userCode != null) {
                if (!userCode.equals(equipFaultInfo.getReportUserCode())) {
                    continue;
                }
            }
            String date = DateUtils.formateDate(equipFaultInfo.getUpdateTime());
            List<TaskVo> taskList = null;
            if (resultMap.containsKey(date)) {
                taskList = (List<TaskVo>) resultMap.get(date);
            } else {
                taskList = new ArrayList<>();
            }
            taskList.add(TaskVo.parseRoutingErrorInfo(equipFaultInfo));
        }
    }

    /**
     * 初始化该月每天的数据
     *
     * @param dayList
     * @return
     */
    private Map<String, Object> initStaticMap(List<String> dayList) {
        Map<String, Object> map = new LinkedHashMap<>(dayList.size());
        for (String day : dayList) {
            map.put(day, new ArrayList<>(10));
        }
        return map;
    }


    /**
     * 获取用户类型
     *
     * @param user
     * @param factoryNo
     * @return 0：错误的类型 1:维修类执行 2:运行类执行  3:设备工单和运行工单都可以执行  4：维修类查看 5：运行类查看 6：设备及运行都可以查看
     */
    private int getUserType(TbUser user, String factoryNo) {
        JSONArray orgRoleList = user.getOrgRoleList();
        String factoryCode = getFactoryCode(factoryNo);
        if (factoryCode == null) {
            return 0;
        }
        JSONArray roleList = null;
        for (int i = 0; i < orgRoleList.size(); i++) {
            if (factoryCode.equals(orgRoleList.getJSONObject(i).getString("value"))) {
                roleList = orgRoleList.getJSONObject(i).getJSONArray("roleList");
                break;
            }
        }
        if (roleList != null) {
            int userType = 0;
            //是维修工或者维修班长
            if (roleList.contains("155410630797900013") || roleList.contains("155410629689600012")) {
                userType = 1;
            }
            //如果是运行班组员或运行班长
            if (roleList.contains("155410626944500009") || roleList.contains("155410625672600008")) {
                //如果及是设备班又是运行班 则类型为3
                if (userType == 1) {
                    userType = 3;
                } else {
                    userType = 2;
                }
            }
            //水厂运行主管及组团运行经理或组团运行主管
            if (roleList.contains("155410624743100007") || roleList.contains("155684892482300027")) {
                userType = 4;
            }
            if (roleList.contains("155410624743100007") || roleList.contains("155661572763300009")) {
                if (userType == 4) {
                    userType = 6;
                } else {
                    userType = 5;
                }
            }

            if (roleList.contains("155410604662000002") || roleList.contains("155410620561800003") || roleList.contains("155661568957600008")) {
                userType = 6;
            }

            return userType;
        } else {
            return 0;
        }
    }


    /**
     * 根据水厂编号获取水厂机构编号
     *
     * @param factoryNo
     * @return
     */
    private String getFactoryCode(String factoryNo) {
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        TbOrgExample orgExample = new TbOrgExample();
        orgExample.createCriteria().andUriEqualTo(factoryInfo.getUri());
        List<TbOrg> orgList = orgMapper.selectByExample(orgExample);
        return orgList.size() == 1 ? orgList.get(0).getCode() : null;
    }

    @Override
    public Map<String, Object> commonTaskInfoDetail(TbUser user, String factoryNo) {
        int userType = getUserType(user, factoryNo);
        Date beginDate = DateUtils.parseDate(DateUtils.getMonthFirstDay());
        Date endDate = DateUtils.getNextDate(new Date(), 1);
        Map<String, Object> resultMap = initCommonMap();

        //查询当月的工单详情
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        example.createCriteria().andPlanStartTimeBetween(beginDate, endDate).andOrgNoEqualTo(factoryNo);
        example.setOrderByClause(" plan_start_time ");
        List<TbWorkTaskInfo> list = workTaskInfoMapper.selectByExample(example);

        //根据具体情况进行统计
        for (TbWorkTaskInfo workTaskInfo : list) {
            String taskTypeKey = getTaskTypeName(workTaskInfo.getTaskType());
            String taskStatusKey = getTaskStatusName(workTaskInfo.getTaskStatus());
            if (taskTypeKey == null || taskStatusKey == null) {
                continue;
            }
            Map<String, Integer> countMap = (Map<String, Integer>) resultMap.get(taskTypeKey);
            String detailKey = taskTypeKey + taskStatusKey;
            if (userType == 1 || userType == 3 || userType == 2) {
                if (workTaskInfo.getDutyUser() != null) {
                    JSONObject dutyUser = JSONObject.parseObject(workTaskInfo.getDutyUser());
                    if (!user.getCode().equals(dutyUser.getString("userCode"))) {
                        continue;
                    }
                } else {
                    continue;
                }
            }else if(userType == 5){
                if(GYTZ_TYPE!=workTaskInfo.getTaskType()){
                    continue;
                }
            }else if(userType == 4){
                if(GYTZ_TYPE==workTaskInfo.getTaskType()){
                    continue;
                }
            }
            countMap.put(detailKey, countMap.get(detailKey) + 1);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getTaskStaticInfo(String factoryNo) {
        List<String> factoryNoList = new ArrayList<>();
        List<TbFactoryInfo> factoryInfoList =  new ArrayList<>();
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        //如果是组团水厂
        if(StringUtils.isNotEmpty(factoryInfo.getOrgGroupNo())){
            factoryInfoList = getGroupFactoryList(factoryInfo.getOrgGroupNo());
            factoryNoList = factoryInfoList.stream().map(TbFactoryInfo::getFactoryNo).collect(Collectors.toList());
        }else{
            factoryNoList.add(factoryNo);
            factoryInfoList.add(factoryInfo);
        }
        TbWorkTaskInfoExample example = new TbWorkTaskInfoExample();
        Date today = DateUtils.parseDate(DateUtils.formateDate(new Date()));
        Date tomorrow = DateUtils.getNextDate(DateUtils.formateDate(new Date()));
        example.createCriteria().andOrgNoIn(factoryNoList).andTaskStatusNotEqualTo(WORK_TASK_STATUS_CANCEL).andPlanStartTimeGreaterThanOrEqualTo(today).andPlanStartTimeLessThan(tomorrow);
        List<TbWorkTaskInfo> taskInfoList = workTaskInfoMapper.selectByExample(example);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("taskCount",taskInfoList.size());
        Map<String,Map<String,Object>> factoryTaskMap = new HashMap<>();
        for(TbWorkTaskInfo workTaskInfo:taskInfoList){
            Map<String,Object> map = null;
            if(factoryTaskMap.containsKey(workTaskInfo.getOrgNo())){
                map = factoryTaskMap.get(workTaskInfo.getOrgNo());
            }else{
                map = new HashMap<>();
                map.put("factoryNo",workTaskInfo.getOrgNo());
                map.put("factoryName",getFactoryName(workTaskInfo.getOrgNo(),factoryInfoList));
                map.put("WX",0);
                map.put("WB",0);
                map.put("DX",0);
                map.put("FF",0);
                map.put("GY",0);
                factoryTaskMap.put(workTaskInfo.getOrgNo(),map);
            }
            setTaskCount(map,workTaskInfo.getTaskType());

        }
        resultMap.put("list",factoryTaskMap.values());
        return resultMap;
    }

    private void setTaskCount(Map<String,Object> map,int taskType){
        String taskTypeStr = "";
        if(taskType==4){
            taskTypeStr = "WX";
        }
        if(taskType==5){
            taskTypeStr = "WB";
        }
        if(taskType==6){
            taskTypeStr = "DX";
        }
        if(taskType==7){
            taskTypeStr = "FF";
        }
        if(taskType==9){
            taskTypeStr = "GY";
        }
        int count =Integer.valueOf(map.get(taskTypeStr).toString());
        count++;
        map.put(taskTypeStr,count);
    }

    private String getFactoryName(String factoryNo,List<TbFactoryInfo> factoryInfoList ){
        for(TbFactoryInfo factoryInfo:factoryInfoList){
            if(factoryInfo.getFactoryNo().equals(factoryNo)){
                return factoryInfo.getFactoryName();
            }
        }
        return "";
    }

    private List<TbFactoryInfo>  getGroupFactoryList(String groupNo){
        TbFactoryInfoExample example = new TbFactoryInfoExample();
        example.createCriteria().andOrgGroupNoEqualTo(groupNo);
        return factoryInfoMapper.selectByExample(example);
    }

    /**
     * 转换工单类型
     *
     * @param type
     * @return
     */
    private String getTaskTypeName(int type) {
        switch (type) {
            case 4:
                return "weixiu";
            case 5:
                return "weibao";
            case 6:
                return "daxiu";
            case 7:
                return "fangfu";
            case 9:
                return "gongyi";
            default:
                return null;
        }
    }


    /**
     * 获取用户状态
     *
     * @param status
     * @return
     */
    private String getTaskStatusName(int status) {
        switch (status) {
            case 0:
                return "UnFinish";
            case 1:
                return "UnFinish";
            case 2:
                return "Finish";
            case 10:
                return "Finish";
            case 11:
                return "Finish";
            default:
                return null;
        }
    }

    /**
     * 初始化结果集合
     *
     * @return
     */
    private Map<String, Object> initCommonMap() {
        Map<String, Object> map = new LinkedHashMap<>(5);
        Map<String, Integer> wxItem = new HashMap<>(2);
        wxItem.put("weixiuFinish", 0);
        wxItem.put("weixiuUnFinish", 0);
        map.put("weixiu", wxItem);

        Map<String, Integer> wbItem = new HashMap<>(2);
        wbItem.put("weibaoFinish", 0);
        wbItem.put("weibaoUnFinish", 0);
        map.put("weibao", wbItem);

        Map<String, Integer> dxItem = new HashMap<>(2);
        dxItem.put("daxiuFinish", 0);
        dxItem.put("daxiuUnFinish", 0);
        map.put("daxiu", dxItem);

        Map<String, Integer> ffItem = new HashMap<>(2);
        ffItem.put("fangfuFinish", 0);
        ffItem.put("fangfuUnFinish", 0);
        map.put("fangfu", ffItem);

        Map<String, Integer> gongyiItem = new HashMap<>(2);
        gongyiItem.put("gongyiFinish", 0);
        gongyiItem.put("gongyiUnFinish", 0);
        map.put("gongyi", gongyiItem);

        return map;
    }

    @Override
    public List<TaskVo> getDataNew(TaskInfoCondition condition) {
        List list = new ArrayList();
        Map map = new HashMap();
        //未完成的
        List<TbWorkTaskInfoVo> tbNofinish = new ArrayList<>();
        //待完成的
        List<TbWorkTaskInfoVo> tbPlanFinish = new ArrayList<>();
        List<TbWorkTaskInfoVo> allList = tbWorkTaskInfoMapper.getTbWorkTaskInfoVoListByUser(condition);
        //  //  // 类型区分 1:未完成 2:待完成
        if (condition.getType() == 1) {
            tbNofinish = allList.stream().filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getPlanFinishTime() != null).filter(tbWorkTaskInfoVo -> tbWorkTaskInfoVo.getTaskStatus() == 1 && tbWorkTaskInfoVo.getPlanFinishTime().getTime() <= System.currentTimeMillis()).collect(Collectors.toList());
            List<TaskVo> taskVoList = new ArrayList<>();
            for (TbWorkTaskInfoVo nofinish : tbNofinish) {
                TaskVo taskVo = new TaskVo();
                if (nofinish.getTaskType() == 4) {
                    taskVo.setTaskName("维修任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 5) {
                    taskVo.setTaskName("维保任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 6) {
                    taskVo.setTaskName("大修任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 7) {
                    taskVo.setTaskName("防腐任务");
                    taskVo.setType((nofinish.getTaskType()));
                }
                taskVo.setCreateUserName(nofinish.getCreateUserName());
                taskVo.setStatus(nofinish.getTaskStatus());
                taskVo.setFinishTime(DateUtils.formateDate(nofinish.getPlanFinishTime()));
                taskVoList.add(taskVo);
                map.put("unFinsh", taskVoList);
            }
            list.add(map);

        } else {
            tbPlanFinish = allList.stream().filter(tbWorkTaskInfoVo -> ((tbWorkTaskInfoVo.getPlanFinishTime() == null || tbWorkTaskInfoVo.getPlanFinishTime().getTime() > System.currentTimeMillis()) && tbWorkTaskInfoVo.getTaskStatus() == 1)).collect(Collectors.toList());
            List<TaskVo> taskVoList = new ArrayList<>();
            for (TbWorkTaskInfoVo nofinish : tbPlanFinish) {
                TaskVo taskVo = new TaskVo();
                if (nofinish.getTaskType() == 4) {
                    taskVo.setTaskName("维修任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 5) {
                    taskVo.setTaskName("维保任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 6) {
                    taskVo.setTaskName("大修任务");
                    taskVo.setType((nofinish.getTaskType()));
                } else if (nofinish.getTaskType() == 7) {
                    taskVo.setTaskName("防腐任务");
                    taskVo.setType((nofinish.getTaskType()));
                }
                taskVo.setCreateUserName(nofinish.getCreateUserName());
                taskVo.setStatus(nofinish.getTaskStatus());
                taskVo.setFinishTime(DateUtils.formateDate(nofinish.getPlanFinishTime()));
                taskVoList.add(taskVo);
                map.put("planFinsh", taskVoList);
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public Map<String, Object> getGroupHomeData(String groupNo) {
        // 瞬时进水IW_FT, IW_COD  IW_NH3-N,IW_SS,IW_TP,IW_TN,IW_PH  累计流量 OW_FTACCML,
        //瞬时出水OW_FT, ,OW_COD OW_NH3-N OW_SS,OW_TP,OW_TN,OW_PH
        OrgGroupInfo orgGroupInfo = getGroupInfoByNo(groupNo);
        if (orgGroupInfo == null || orgGroupInfo.getGroupDetailInfo() == null) {
            return new HashMap<>();
        } else {
            String[] fields = new String[]{"IW_FTACCML", "IW_FTACC", "IW_FT", "IW_COD", "IW_NH3-N", "IW_SS", "IW_TP", "IW_TN", "IW_PH", "OW_FTACCML", "OW_FTACC", "OW_FT", "OW_COD", "OW_NH3-N", "OW_SS", "OW_TP", "OW_TN", "OW_PH"};
            JSONObject jsonObject = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
            if (jsonObject.containsKey("factoryList")) {
                JSONArray factoryList = jsonObject.getJSONArray("factoryList");
                Map<String, Object> resultMap = new HashMap<>(4);
                List<Map<String, Object>> factoryMapList = new ArrayList<>(factoryList.size());
                resultMap.put("dataList", factoryMapList);
                for (int i = 0; i < factoryList.size(); i++) {
                    List<String> fieldList = new ArrayList<>(fields.length);
                    JSONObject factoryInfo = factoryList.getJSONObject(i);
                    Map<String, Object> factoryDataMap = new HashMap<>(fields.length);
                    factoryDataMap.put("factoryName", factoryInfo.getString("factoryName"));
                    factoryDataMap.put("star", i + 1);
                    Map<String, String> inputInfo = newComposeMap();
                    Map<String, String> outputInfo = newComposeMap();
                    Map<String, String> hyInfo = newComposeMap();

                    factoryDataMap.put("inputInfo", inputInfo);
                    factoryDataMap.put("outputInfo", outputInfo);
                    factoryDataMap.put("hyInfo", hyInfo);
                    setFactoryRuntimeHyWaterData(hyInfo);

                    TbSynObjectExample synObjectExample = new TbSynObjectExample();
                    synObjectExample.createCriteria().andFactoryNoEqualTo(factoryInfo.getString("factoryNo")).andBrowsenameIn(Arrays.asList(fields)).andHasvalueEqualTo(1).andFieldUriEqualTo("/system/2004");
                    List<TbSynObject> synObjectList = synObjectMapper.selectByExample(synObjectExample);

                    for (int n = 0; n < synObjectList.size(); n++) {
                        TbSynObject synObject = synObjectList.get(n);
                        fieldList.add(synObject.getBrowsepath());
                    }
                    if (fieldList.size() > 0) {
                        String[] searchFields = new String[fieldList.size()];
                        fieldList.toArray(searchFields);
                        JSONObject resultJson = bewgService.getDataInfoNew(searchFields);
                        setFactoryRuntimeInWaterData(inputInfo, resultJson, synObjectList);
                        setFactoryRuntimeOutWaterData(outputInfo, resultJson, synObjectList);
                    }
                    List<Map<String, Object>> errorInfoList = equipFaultInfoMapper.selectUnFinishMapList(factoryInfo.getString("factoryNo"));
                    factoryDataMap.put("errorInfoList", errorInfoList);
                    factoryMapList.add(factoryDataMap);
                }
                return resultMap;
            }
            return new HashMap<>();
        }
    }

    @Override
    public List<Map<String, Object>> getGroupErrorInfo(String groupNo) {
        OrgGroupInfo orgGroupInfo = getGroupInfoByNo(groupNo);
        if (orgGroupInfo == null || orgGroupInfo.getGroupDetailInfo() == null) {
            return new ArrayList<>();
        } else {
            JSONObject jsonObject = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
            if (jsonObject.containsKey("factoryList")) {
                JSONArray factoryList = jsonObject.getJSONArray("factoryList");
                List<String> facotryNoList = new ArrayList<>();
                List<Map<String, Object>> factoryMapList = new ArrayList<>(factoryList.size());
                for (int i = 0; i < factoryList.size(); i++) {
                    JSONObject factoryInfo = factoryList.getJSONObject(i);
                    facotryNoList.add(factoryInfo.getString("factoryNo"));
                    Map<String, Object> factoryDataMap = new HashMap<>(2);
                    factoryDataMap.put("factoryNo", factoryInfo.getString("factoryNo"));
                    List<Map<String, Object>> errorInfoList = equipFaultInfoMapper.selectUnFinishMapList(factoryInfo.getString("factoryNo"));
                    factoryDataMap.put("errorInfoList", errorInfoList);
                    factoryMapList.add(factoryDataMap);
                }
                return factoryMapList;
            }
            return new ArrayList<>();
        }
    }

    @Override
    public List<Map<String, Object>> getGroupTaskInfo(String groupNo) {
        OrgGroupInfo orgGroupInfo = getGroupInfoByNo(groupNo);
        if (orgGroupInfo == null || orgGroupInfo.getGroupDetailInfo() == null) {
            return new ArrayList<>();
        } else {
            JSONObject jsonObject = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
            if (jsonObject.containsKey("factoryList")) {
                JSONArray factoryList = jsonObject.getJSONArray("factoryList");
                List<String> facotryNoList = new ArrayList<>();
                List<Map<String, Object>> factoryMapList = new ArrayList<>(factoryList.size());
                for (int i = 0; i < factoryList.size(); i++) {
                    JSONObject factoryInfo = factoryList.getJSONObject(i);
                    facotryNoList.add(factoryInfo.getString("factoryNo"));
                    Map<String, Object> factoryDataMap = new HashMap<>(2);
                    factoryDataMap.put("factoryNo", factoryInfo.getString("factoryNo"));
                    List<Map<String, Object>> errorInfoList = workTaskInfoMapper.selectUnFinishTaskList(factoryInfo.getString("factoryNo"));
                    factoryDataMap.put("taskInfoList", errorInfoList);
                    factoryMapList.add(factoryDataMap);
                }
                return factoryMapList;
            }
            return new ArrayList<>();
        }
    }

    @Override
    public Map<String, Object> getGroupHomeInfo(String factoryNo) {
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        String[] fields = new String[]{"IW_FTACCML", "IW_FTACC", "IW_FT", "IW_COD", "IW_NH3-N", "IW_SS", "IW_TP", "IW_TN", "IW_PH", "OW_FTACCML", "OW_FTACC", "OW_FT", "OW_COD", "OW_NH3-N", "OW_SS", "OW_TP", "OW_TN", "OW_PH"};
        if (StringUtils.isNotEmpty(factoryInfo.getOrgGroupNo())) {
            OrgGroupInfo orgGroupInfo = getGroupInfoByNo(factoryInfo.getOrgGroupNo());
            if (orgGroupInfo == null) {
                logger.info("未找到组团信息");
                return new HashMap<>();
            }
            JSONObject jsonObject = JSONObject.parseObject(orgGroupInfo.getGroupDetailInfo().toString());
            Map<String, Object> groupMap = new HashMap<>(2);
            groupMap.put("groupId", orgGroupInfo.getId());
            groupMap.put("groupNo", orgGroupInfo.getGroupNo());
            groupMap.put("groupName", orgGroupInfo.getGroupName());
            JSONArray factoryList = jsonObject.getJSONArray("factoryList");
            List<Map<String, Object>> factoryInfoList = new ArrayList<>(factoryList.size());
            List<String> factoryNoList = new ArrayList<>();
            for (int i = 0; i < factoryList.size(); i++) {
                Map<String, Object> factoryDataMap = new HashMap<>(5);
                factoryDataMap.put("factoryName", factoryList.getJSONObject(i).getString("factoryName"));
                factoryDataMap.put("factoryNo", factoryList.getJSONObject(i).getString("factoryNo"));
                factoryDataMap.put("uri", factoryList.getJSONObject(i).getString("uri"));
                factoryDataMap.put("star", i + 1);
                factoryInfoList.add(factoryDataMap);
                factoryNoList.add(factoryList.getJSONObject(i).getString("factoryNo"));
            }
            TbSynObjectExample synObjectExample = new TbSynObjectExample();
            synObjectExample.createCriteria().andFactoryNoIn(factoryNoList).andBrowsenameIn(Arrays.asList(fields)).andHasvalueEqualTo(1).andFieldUriEqualTo("/system/2004");
            List<TbSynObject> synObjectList = synObjectMapper.selectByExample(synObjectExample);
            groupMap.put("fieldList", synObjectList);
            groupMap.put("factoryInfoList", factoryInfoList);
            List<String> orgList = new ArrayList<>();
            getFacotryOrgList(orgList, orgGroupInfo.getParentOrg());
            orgList.add(0, orgGroupInfo.getGroupName());
            groupMap.put("orgList", orgList);
            return groupMap;
        } else {
            return new HashMap<>();
        }
    }

    private OrgGroupInfo getGroupInfoByNo(String groupNo) {
        OrgGroupInfoExample example = new OrgGroupInfoExample();
        example.createCriteria().andGroupNoEqualTo(groupNo);
        List<OrgGroupInfo> list = orgGroupInfoMapper.selectByExample(example);
        return list.size() == 1 ? list.get(0) : null;
    }

    private void getFacotryOrgList(List<String> list, String orgCode) {
        TbOrg org = orgMapper.selectByPrimaryKey(orgCode);
        list.add(org.getName());
        if (!org.getParentCode().equals("0")) {
            getFacotryOrgList(list, org.getParentCode());
        }
    }


    private Map<String, String> newComposeMap() {
        Map<String, String> inputInfo = new HashMap<>(10);
        inputInfo.put("water", "-");
        inputInfo.put("runtimeWater", "-");
        inputInfo.put("cod", "-");
        inputInfo.put("nh3", "-");
        inputInfo.put("ss", "-");
        inputInfo.put("tp", "-");
        inputInfo.put("tn", "-");
        inputInfo.put("ph", "-");
        inputInfo.put("bod", "-");
        return inputInfo;
    }

    private void setFactoryRuntimeInWaterData(Map<String, String> inputInfo, JSONObject resultJson, List<TbSynObject> synObjectList) {
        JSONArray resultArray = resultJson.getJSONArray("result");
        for (int i = 0; i < synObjectList.size(); i++) {
            TbSynObject tbSynObject = synObjectList.get(i);
            // "OW_FTACCML","OW_FTACC","OW_FT","OW_COD","OW_NH3-N","OW_SS","OW_TP","OW_TN","OW_PH"
            if ("IW_FTACC".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("water", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_FT".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("runtimeWater", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_COD".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("cod", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_NH3-N".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("nh3", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_SS".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("ss", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_TP".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("tp", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_TN".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("tn", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("IW_PH".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("ph", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            }
        }
    }

    private void setFactoryRuntimeOutWaterData(Map<String, String> inputInfo, JSONObject resultJson, List<TbSynObject> synObjectList) {
        JSONArray resultArray = resultJson.getJSONArray("result");
        for (int i = 0; i < synObjectList.size(); i++) {
            TbSynObject tbSynObject = synObjectList.get(i);
            // "IW_FTACCML","IW_FTACC","IW_FT","IW_COD","IW_NH3-N","IW_SS","IW_TP","IW_TN","IW_PH"
            if ("OW_FTACC".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("water", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_COD".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("cod", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_NH3-N".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("nh3", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_SS".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("ss", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_TP".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("tp", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_TN".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("tn", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            } else if ("OW_PH".equals(tbSynObject.getBrowsename())) {
                inputInfo.put("ph", StringTools.formatDoubleStr(resultArray.getJSONObject(i).getDoubleValue("v"), 2));
            }
        }
    }

    private void setFactoryRuntimeHyWaterData(Map<String, String> hyInfo) {
        hyInfo.put("cod", "-");
        hyInfo.put("nh3", "-");
        hyInfo.put("ss", "-");
        hyInfo.put("tp", "-");
        hyInfo.put("tn", "-");
        hyInfo.put("ph", "-");
        hyInfo.put("bod", "-");
    }

    @Override
    public List<TbDraftData> getTbDraftDataList(TbDraftData tbDraftData) {
        tbDraftData.setDraftTimeByString(DateUtils.formateDate(new Date()));
        List<TbDraftData> tbDraftDataList =tbDraftDataMapper.getTbDraftDataList(tbDraftData);
        //采集类型 1:运行填报2:设备填报:3:化验填报;4:日常填报',
        for (TbDraftData draftData : tbDraftDataList) {
            if(draftData.getDraftType()==1){
                draftData.setDraftTypeName("运行填报");
            }else if(draftData.getDraftType()==2){
                draftData.setDraftTypeName("设备填报");
            }else if(draftData.getDraftType()==3){
                draftData.setDraftTypeName("化验填报");
            }else {
                draftData.setDraftTypeName("日常填报");
            }
            draftData.setDraftUnitValue(draftData.getDraftValue()==null?"":draftData.getDraftValue().toString()+draftData.getDraftUnit());
        }
        return tbDraftDataList;
    }
}
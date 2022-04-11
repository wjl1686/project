package com.ejobim.opplat.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.common.WorkFlowCommon;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.notify.NoticeService;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.service.impl.EquipOrderServiceImpl;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.ExcelHighUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.WorkFlowCommon.GROUP_TYPE_SB;
import static com.ejobim.opplat.common.WorkFlowCommon.USER_TYPE_MANAGER;

/**
 * 设备计划及工单
 *
 * @author xibian
 */
@Api(tags = "设备计划及工单")
@RestController
@RequestMapping("/equipOrder")
public class EquipOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    EquipOrderService equipOrderService;

    @Autowired
    SchedulingService schedulingService;

    @Autowired
    TbSysUseService sysUseService;

    @Autowired
    TbWorkTaskInfoMapper workTaskInfoMapper;

    @Autowired
    NoticeService noticeService;

    @Autowired
    TbWorkFlowConfigMapper tbWorkFlowConfigMapper;

    @Autowired
    TbWorkFlowConfigDetailMapper tbWorkFlowConfigDetailMapper;

    @Autowired
    TbEquipFaultInfoMapper equipFaultInfoMapper;

    @Autowired
    TbSysUseService tbSysUseService;

    @Autowired
    TbFactoryInfoMapper tbFactoryInfoMapper;

    @Autowired
    TbOrgService orgService;

    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    EquipService equipService;

    /**
     * 获取异常列表
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getEquipFaultList")
    @ApiOperation(value = "查询指定日期内的巡检异常")
    public AjaxObject getEquipFaultList(HttpServletRequest request, String factoryNo, Date beginDate, Date endDate) {
        logger.info("获取异常列表参数factoryNo={},beginDate={},endDate={}", factoryNo, beginDate, endDate);
        TbUser user = super.getUser(request, stringRedisTemplate);
        String equipName = request.getParameter("equipName");
        String errorNo = request.getParameter("errorNo");
        Integer status = request.getParameter("status") == null ? null : Integer.valueOf(request.getParameter("status").toString());
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        if (StringUtils.isEmpty(errorNo)) {
            List<TbEquipFaultInfo> equipFaultInfoList = equipOrderService.getEquipFaultList(factoryNo, equipName, status, beginDate, endDate);
            return super.getResultObject(equipFaultInfoList, request.getParameter("page"));
        } else {
            List<TbEquipFaultInfo> equipFaultInfoList = new ArrayList<>();
            TbEquipFaultInfo tbEquipFaultInfo = equipOrderService.getEquipFaultDetail(errorNo);
            equipFaultInfoList.add(tbEquipFaultInfo);
            return super.getResultObject(equipFaultInfoList, request.getParameter("page"));

        }


    }

    /**
     * 获取所有未处理的完成的工单
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getUnFinishEquipFaultList")
    @ApiOperation(value = "查询所有未处理的巡检异常")
    public AjaxObject getUnFinishEquipFaultList(HttpServletRequest request, String factoryNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("App端获取巡检异常列表参数factoryNo={}", factoryNo);
        List<TbEquipFaultInfo> equipFaultInfoList = equipOrderService.getUnFinishEquipFaultList(factoryNo);
        return super.getResultObject(equipFaultInfoList, null);
    }

    /**
     * 修改巡检异常，主要是设置为非异常
     *
     * @param request
     * @param errorNo
     * @return
     */
    @PostMapping("/setEquipFault")
    @ApiOperation(value = "设置巡检异常未非异常")
    public AjaxObject setEquipFault(HttpServletRequest request, String errorNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("设置未非异常 ,异常ID={},用户ID={}", errorNo, user.getCode());
        int returnCode = equipOrderService.updateEquipFault(errorNo);
        if (returnCode == 0) {
            //发送消息
            TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(equipFaultInfo.getFactoryNo());
           /* TbWorkTaskInfoCondition conditionQ = new TbWorkTaskInfoCondition();
            conditionQ.setFactoryUri(tbFactoryInfo.getUri());
            //    private Integer type; 0:全部 1:运行班组 2,设备班组 3 运行经理 SCYXJL 设备经理 SCSBJL
            conditionQ.setType(3);
            List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(conditionQ);*/
            if (equipFaultInfo != null && equipFaultInfo.getReportUserName() != null) {
                noFaultMessager(1, tbFactoryInfo, equipFaultInfo);
            }

        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    /**
     * 确认非异常 发送异常上报者
     */
    public void noFaultMessager(Integer type, TbFactoryInfo tbFactoryInfo, TbEquipFaultInfo equipFaultInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0] = equipFaultInfo.getReportUserCode();
            params.targets = codes;
            params.title = "巡检异常上报工单";
            params.body = "您上报的异常确认为非异常情况，请及时查看！";
            sendNoticeMessage(1, tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info("巡检非异常通知成功用户userList={}", JSON.toJSONString(equipFaultInfo.getReportUserName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取巡检异常详情
     *
     * @param request
     * @param errorNo
     * @return
     */
    @GetMapping("/getEquipFaultDetail")
    @ApiOperation(value = "获取巡检异常详情")
    public AjaxObject getEquipFaultDetail(HttpServletRequest request, String errorNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("获取异常详情参数={}", errorNo);
        TbEquipFaultInfo equipFaultInfo = equipOrderService.getEquipFaultDetail(errorNo);
        return super.getResultObjectAlone(equipFaultInfo);
    }

    /**
     * PC后台获取工单列表
     *
     * @param request
     * @param workTaskQueryParam
     * @return
     */
    @GetMapping("/getTaskList")
    @ApiOperation(value = "获取工单列表")
    public AjaxObject getTaskList(HttpServletRequest request, EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam) {
        logger.info("PC后台获取工单列表参数WorkTaskQueryParam={}", JSON.toJSONString(workTaskQueryParam));
        TbUser user = super.getUser(request, stringRedisTemplate);
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipName())) {
            TbEquipInfo equipInfoSearch = new TbEquipInfo();
            equipInfoSearch.setEquipName(workTaskQueryParam.getEquipName());
            List<TbEquipInfo> equipInfoList = equipService.getEquipList(equipInfoSearch);
            List<String> equipNoList = null;
            if (equipInfoList.size() > 0) {
                equipNoList = equipInfoList.stream().map(TbEquipInfo::getEquipNo).collect(Collectors.toList());
            } else {
                equipNoList = new ArrayList<>(1);
                equipNoList.add("");
            }
            workTaskQueryParam.setEquipNoList(equipNoList);
        }
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbWorkTaskInfo> list = equipOrderService.getTaskInfoList(workTaskQueryParam);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * 获取重修类工单
     *
     * @param request
     * @param workTaskQueryParam
     * @return
     */
    @GetMapping("/getFailTaskList")
    @ApiOperation(value = "获取无法自修的维修工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "taskType", value = "任务类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "equipName", value = "设备名臣", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject getFailTaskList(HttpServletRequest request, EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam) {
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipName())) {
            TbEquipInfo equipInfoSearch = new TbEquipInfo();
            equipInfoSearch.setEquipName(workTaskQueryParam.getEquipName());
            List<TbEquipInfo> equipInfoList = equipService.getEquipList(equipInfoSearch);
            List<String> equipNoList = null;
            if (equipInfoList.size() > 0) {
                equipNoList = equipInfoList.stream().map(TbEquipInfo::getEquipNo).collect(Collectors.toList());
            } else {
                equipNoList = new ArrayList<>(1);
                equipNoList.add("");
            }
            workTaskQueryParam.setEquipNoList(equipNoList);
        }
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbWorkTaskInfo> list = equipOrderService.getFailTaskList(workTaskQueryParam);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * 获取重修类工单
     *
     * @param factoryNo
     * @param taskType
     * @return
     */
    @GetMapping("/getFinishTaskList")
    @ApiOperation(value = "获取已完成工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "taskType", value = "任务类型", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject getFinishTaskList(String factoryNo, Integer taskType) {
        List<TbWorkTaskInfo> list = equipOrderService.getFinishTaskList(factoryNo,taskType);
        return super.getResultObject(list, null);

    }


    /**
     * PC后台获取所有工单和计划列表
     *
     * @param request
     * @param workTaskQueryParam
     * @return
     */
    @GetMapping("/getALLTaskList")
    @ApiOperation(value = "获取所有类型状态的工单")
    public AjaxObject getALLTaskList(HttpServletRequest request, EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam) {
        logger.info("PC后台获取所有工单和计划列表参数WorkTaskQueryParam={}", JSON.toJSONString(workTaskQueryParam));
        TbUser user = super.getUser(request, stringRedisTemplate);
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbWorkTaskInfo> list = equipOrderService.getALLTaskList(workTaskQueryParam);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * PC后台获取不同类型的计划列表
     *
     * @param request
     * @param workTaskQueryParam
     * @return
     */
    @GetMapping("/getWokTaskPLanList")
    @ApiOperation(value = "获取工单计划")
    public AjaxObject getWokTaskPLanList(HttpServletRequest request, EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam) {
        logger.info("PC后台获取工单计划列表参数WorkTaskQueryParam={}", JSON.toJSONString(workTaskQueryParam));
        if (StringUtils.isNotEmpty(workTaskQueryParam.getEquipName())) {
            TbEquipInfo equipInfoSearch = new TbEquipInfo();
            equipInfoSearch.setEquipName(workTaskQueryParam.getEquipName());
            List<TbEquipInfo> equipInfoList = equipService.getEquipList(equipInfoSearch);
            List<String> equipNoList = null;
            if (equipInfoList.size() > 0) {
                equipNoList = equipInfoList.stream().map(TbEquipInfo::getEquipNo).collect(Collectors.toList());
            } else {
                equipNoList = new ArrayList<>(1);
                equipNoList.add("");
            }
            workTaskQueryParam.setEquipNoList(equipNoList);
        }
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbWorkTaskInfo> list = equipOrderService.getWokTaskPLanList(workTaskQueryParam);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * 提供给APP使用
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getMyTaskList")
    @ApiOperation(value = "获取个人可以查看或操作的工单")
    public AjaxObject getMyTaskList(HttpServletRequest request, String factoryNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        int taskType = StringUtils.isNotEmpty(request.getParameter("taskType")) ? Integer.valueOf(request.getParameter("taskType")) : null;
        int plat = StringUtils.isNotEmpty(request.getParameter("plat")) ? Integer.valueOf(request.getParameter("plat")) : 0;
        Date taskDate = DateUtils.getNextDate(new Date(), 1);
        Date planDate = DateUtils.getNextDate(new Date(), 2);
        logger.info("APP使用后台获取工单和计划列表参数factoryNo={},taskTpe={},plat={}", factoryNo, taskType, plat);
        List<TbWorkTaskInfo> planList = equipOrderService.getTaskInfoPlanList(factoryNo, taskType, planDate, user);
        List<TbWorkTaskInfo> taskList = equipOrderService.getMyTaskInfoList(factoryNo, user, plat, taskType, taskDate, null);
        List<TbWorkTaskInfo> list = new ArrayList<>();
        list.addAll(planList);
        list.addAll(taskList);
        if (list.size() > 0) {
            return super.getResultObject(list, null);
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * 获取工单计划
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getTaskPlanList")
    @ApiOperation(value = "获取工单计划列表")
    public AjaxObject getTaskPlanList(HttpServletRequest request, String factoryNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        //获取用户当前是否有排班，以及在班组内部的身份，是班长还是组员
        List<TbSchedulingPlan> schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTimePoint(user.getCode());
        if (schedulingPlanList == null || schedulingPlanList.size() == 0) {
            return super.getResultObject(new ArrayList(), null);
        }
        //如果排班不是设备班
        if (schedulingPlanList.get(0).getGroupType().intValue() != GROUP_TYPE_SB) {
            return super.getResultObject(new ArrayList(), null);
        }
        //如果不是组长 则没有数据返回
        if (schedulingPlanList.get(0).getTbSchedulingPlanDeatailList().get(0).getUserType().intValue() != USER_TYPE_MANAGER) {
            return super.getResultObject(new ArrayList(), null);
        }
        int taskType = StringUtils.isNotEmpty(request.getParameter("taskType")) ? Integer.valueOf(request.getParameter("taskType")) : null;
        Date date = request.getParameter("date") == null ? DateUtils.getNextDate(DateUtils.formateDate(new Date())) : DateUtils.getNextDate(request.getParameter("date"));
        logger.info("A获取工单计划参数factoryNo={},taskTpe={},date={},user={}", factoryNo, taskType, date, JSON.toJSONString(user));
        List list = equipOrderService.getTaskInfoPlanList(factoryNo, taskType, date, user);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * 获取下发用户列表
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getPlanUserList")
    @ApiOperation(value = "获取工单可下发用户列表")
    public AjaxObject getPlanUserList(HttpServletRequest request, String factoryNo, String taskNo, Integer groupType) {
        logger.info("获取下发用户列表factoryNo={},任务taskNo={},groupType={}:", factoryNo, taskNo, groupType);
        Date date = new Date();
        if (StringUtils.isNotEmpty(taskNo)) {
            TbWorkTaskInfo workTaskInfo = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            date = workTaskInfo.getPlanStartTime();
        }
        int type = groupType == null ? 2 : groupType;

        String time = "";
        if (type == 1) {
            time = DateUtils.formateDateFull(new Date());
        } else if (type == 2) {
            time = DateUtils.formateDate(date);
        }
        List<TbSchedulingPlanDeatail> list = schedulingService.getbSchedulingPlanInfoByGroupType(type, factoryNo, time);

        for(TbSchedulingPlanDeatail schedulingPlanDetail:list){
            schedulingPlanDetail.setType(1);
        }
        if(type==2){
            String time2 =  DateUtils.formateDateFull(new Date());
            //获取运行班
            List<TbSchedulingPlanDeatail> list1 = schedulingService.getbSchedulingPlanInfoByGroupType(1, factoryNo, time2);
            for(TbSchedulingPlanDeatail schedulingPlanDetail:list1){
                if(schedulingPlanDetail.getUserType().equals(1)){
                    schedulingPlanDetail.setType(2);
                    list.add(schedulingPlanDetail);
                }
            }

            //获取运行经理和运行主管
            List<String> roleList = new ArrayList<>();
            roleList.add("155410622795000005");
            roleList.add("155410624743100007");
            List<TbUser> userList = tbSysUseService.getFactoryUserListByRoleCode(factoryNo,roleList);
            if(userList!=null && userList.size()>0){
                for(TbUser tbUser:userList){
                    TbSchedulingPlanDeatail schedulingPlanDetail = new TbSchedulingPlanDeatail();
                    schedulingPlanDetail.setUserCode(tbUser.getCode());
                    schedulingPlanDetail.setUserName(tbUser.getName());
                    schedulingPlanDetail.setType(2);
                    list.add(schedulingPlanDetail);
                }
            }

        }
        return super.getResultObject(list, null);
    }

    @GetMapping("/getCheckUserList")
    @ApiOperation(value = "获取工单可验收人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "workFlowConfigNo", value = "工作流编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "flowCode", value = "工单类型编码", dataType = "String", paramType = "query")
    })
    public AjaxObject getCheckUserList(String workFlowConfigNo, String factoryNo, String  flowCode) {
        logger.info("获取设备班人员列表workFlowConfigNo={}", JSON.toJSONString(workFlowConfigNo));
        //查询条件二选一 工作流编号  或 水厂编号+工单类型
        if (StringUtils.isEmpty(workFlowConfigNo) &&  (StringUtils.isEmpty(factoryNo) || StringUtils.isEmpty(flowCode))) {
            return AjaxObject.error("错误的参数");
        }else if(StringUtils.isEmpty(workFlowConfigNo) ){
            TbWorkFlowConfig workFlowConfig = equipOrderService.getWorkFlowConfigByCode(factoryNo,flowCode);
            TbWorkFlowConfigDetailExample workFlowConfigDetailSearch = new TbWorkFlowConfigDetailExample();
            workFlowConfigDetailSearch.createCriteria().andConfigNoEqualTo(workFlowConfig.getFlowNo());
            List<TbWorkFlowConfigDetail> workFlowConfigDetailList = tbWorkFlowConfigDetailMapper.selectByExample(workFlowConfigDetailSearch);
            List<Map<String, String>> checkRoleList = new ArrayList<>();
            for (TbWorkFlowConfigDetail workFlowConfigDetail : workFlowConfigDetailList) {
                if (workFlowConfigDetail.getNodeCode().startsWith("EXAMINE")) {
                    Map<String, String> map = new HashMap<>();
                    map.put("value", workFlowConfigDetail.getNodeNo());
                    map.put("text", workFlowConfigDetail.getNodeName());
                    checkRoleList.add(map);
                }
            }
            return super.getResultObject(checkRoleList, null);
        }else{
            List<Map<String, String>> list = equipOrderService.getCheckUserList(workFlowConfigNo);
            return super.getResultObject(list, null);
        }

    }


    /**
     * 提供给APP使用
     *
     * @param request
     * @param equipNo
     * @return
     */
    @GetMapping("/getEquipTaskList")
    @ApiOperation(value = "根据设备编号获取设备上的当前工单")
    public AjaxObject getEquipTaskList(HttpServletRequest request, String equipNo) {
        logger.info("提供给APP使用equipNo={}:", equipNo);
        TbUser user = super.getUser(request, stringRedisTemplate);
        List<TbSchedulingPlan> schedulingPlanList = schedulingService.getbSchedulingPlanInfoByTimePoint(user.getCode());
        if (schedulingPlanList == null) {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
        int plat = StringUtils.isNotEmpty(request.getParameter("plat")) ? Integer.valueOf(request.getParameter("plat")) : 0;
        Date date = DateUtils.getNextDate(DateUtils.formateDate(new Date()));
        List<TbWorkTaskInfo> list = equipOrderService.getMyTaskInfoList(null, user, plat, null, date, equipNo);
        if (list != null) {
            return super.getResultObject(list, request.getParameter("page"));
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.NOFIND);
        }
    }

    /**
     * APP使用设备历史列表
     *
     * @param request
     * @param equipNo
     * @return
     */
    @GetMapping("/getEquipHistory")
    public AjaxObject getEquipHistory(HttpServletRequest request, String equipNo, Integer taskType) {
        logger.info("APP使用设备历史列表equipNo={},taskType={}", equipNo, taskType);
        TbUser user = super.getUser(request, stringRedisTemplate);
        List list = equipOrderService.getEquipHistory(equipNo, taskType);
        return super.getResultObject(list, request.getParameter("page"));
    }


    /**
     * 获取当前任务的操作步骤信息
     *
     * @param request
     * @param factoryNo 机构编码
     * @param nodeIndex 步骤编号
     * @param flowCode  工单类型流程编码维修:SBWXN 维保:SBWB 大修:SBDX
     * @return
     */
    @GetMapping("/getWorkFlowFiledList")
    @ApiOperation(value = "获取工单工作流的单步的表单信息")
    public AjaxObject getWorkFlowFiledList(HttpServletRequest request, String factoryNo, Integer nodeIndex, String flowCode, String flowNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("取当前任务的操作步骤信息参数水厂factoryNo={},步骤编号nodeIndex={},工单类型流程编码flowCode={}:工单taskNo={}", factoryNo, nodeIndex, flowCode, flowNo);
        Map<String, Object> resultMap = new HashMap<>(16);
        int returnCode = equipOrderService.getWorkFlowDetail(flowNo, factoryNo, nodeIndex, flowCode, resultMap);
        if (returnCode == Dict.AjaxStatus.YES.getStatusCode()) {
            return AjaxObject.ok(resultMap);
        } else {
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
        }
    }

    /**
     * 新建及更新工作流
     *
     * @param request
     * @param jsonObject
     * @return
     */
    @PostMapping("/saveTaskByFlow")
    @ApiOperation(value = "格局工作流更新工单状态")
    public AjaxObject saveTaskByFlow(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("提交信息JSONObject={}", jsonObject);
        TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
        int returnCode = equipOrderService.saveWorkFlowInfo(jsonObject, user);
        JSONObject detailInfo = jsonObject.getJSONObject("detailInfo");
        //异常转维修计划(紧急才通知)
        if (returnCode == 0) {
            // public final static String SBWXN = "SBWXN";
            //  public final static String SBWB = "SBWB";
            //    public final static String SBDX = "SBDX";
            //    public final static String SBFF = "SBFF";
            // public final static String GYTZ = "GYTZ";
            String flowCode = jsonObject.getString("flowCode");
            if (WorkFlowCommon.SBWXN.equals(flowCode)) {
                sendRepairMessage(jsonObject);
            } else if (WorkFlowCommon.SBWB.equals(flowCode)) {
                weibaoMessage(jsonObject);
            } else if (WorkFlowCommon.SBDX.equals(flowCode)) {
                overhaulMessage(jsonObject);
            } else if (WorkFlowCommon.SBFF.equals(flowCode)) {
                fangfuMessage(jsonObject);
            } else if (WorkFlowCommon.GYTZ.equals(flowCode)) {
                gongyiMessage(jsonObject);
            }
        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    /**
     * 获取水厂版主人员
     * @param factoryUri
     * @param type
     * @return
     */
    private List<TbUser> getTbEquipBanUserListByFactoryUri(String factoryUri,Integer type){
        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
        condition.setFactoryUri(factoryUri);
        condition.setType(2);
        // 1运行 2设备
        return  tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
    }

    /**
     * 维修消息
     */
    public void sendRepairMessage(JSONObject jsonObject) {
        try {
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
            JSONObject detailInfo = jsonObject.getJSONObject("detailInfo");
            String factoryNo = workFlowConfigDetail.getOrgNo();
            String taskType = "4";
            String taskNo = jsonObject.getString("flowNo");
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
            if (detailInfo.containsKey("errorNo")) {
                String errorNo = detailInfo.getString("errorNo");
                TbEquipFaultInfo equipFaultInfo = equipFaultInfoMapper.selectByPrimaryKey(errorNo);
                //通过errorNo异常新增
                TbWorkTaskInfo taskInfo = new TbWorkTaskInfo();
                taskInfo.setOrgNo(equipFaultInfo.getFactoryNo());
                taskInfo.setTaskFrom(errorNo);
                taskInfo.setTaskType(Integer.parseInt(taskType));
                TbWorkTaskInfo tbWorkTaskInfo = equipOrderService.getTbWorkTaskInfo(taskInfo);
                if (tbWorkTaskInfo != null) {
                    //异常生成工单紧急 下发 该日当班班长（设备）
                    if ("1".equals(detailInfo.get("urgencyDegree")) && workFlowConfigDetail.getNodeCode().equals("WORKORDER")) {
                        //发送设备班长角色且当班
                        List<TbUser> tbUserList = getTbEquipBanUserListByFactoryUri(tbFactoryInfo.getUri(),2);
                        logger.info("设备班长用户tbUserList={}", JSON.toJSONString(tbUserList));
                        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatails = schedulingService.getbSchedulingPlanInfoByGroupType(1, tbFactoryInfo.getFactoryNo(), DateUtils.formateDate(new Date()));
                        logger.info("设备排班人员用户tbSchedulingPlanDeatails={}", JSON.toJSONString(tbSchedulingPlanDeatails));
                        List<TbUser> tbUsers = new ArrayList<>();
                        for (TbUser tbUser : tbUserList) {
                            for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatails) {
                                if (tbUser.getCode().equals(deatail.getUserCode())) {
                                    TbUser tbUserD = new TbUser();
                                    tbUserD.setCode(tbUser.getCode());
                                    tbUserD.setName(tbUser.getName());
                                    tbUsers.add(tbUserD);
                                }

                            }
                        }
                        if (tbUsers.size() > 0) {
                            logger.info("设备维修新增工单发消息用户tbUsers{}", JSON.toJSONString(tbUsers));
                            TbWorkTaskInfo tbWorkTaskInfoQ = new TbWorkTaskInfo();
                            tbWorkTaskInfoQ.setTaskType(Integer.parseInt(taskType));
                            tbWorkTaskInfoQ.setUrgencyDegree(1);
                            sendBanRoleMessage(tbUserList, tbWorkTaskInfoQ, tbFactoryInfo);
                        }
                    }
                }
            } else {
                if ("1".equals(detailInfo.get("urgencyDegree"))) {
                    // '0一般 1紧急',
                    if (workFlowConfigDetail != null) {
                        //生成工单紧急 下发 该日当班班长（设备）
                        if (workFlowConfigDetail.getNodeCode().equals("WORKORDER")) {
                            //发送设备班长角色且当班

                            List<TbUser> tbUserList = getTbEquipBanUserListByFactoryUri(tbFactoryInfo.getUri(),2);
                            logger.info("设备班长用户tbUserList={}", JSON.toJSONString(tbUserList));
                            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatails = schedulingService.getbSchedulingPlanInfoByGroupType(2, tbFactoryInfo.getFactoryNo(), DateUtils.formateDate(new Date()));
                            logger.info("设备排班人员用户tbSchedulingPlanDeatails={}", JSON.toJSONString(tbSchedulingPlanDeatails));
                            List<TbUser> tbUsers = new ArrayList<>();
                            for (TbUser tbUser : tbUserList) {
                                for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatails) {
                                    if (tbUser.getCode().equals(deatail.getUserCode())) {
                                        TbUser tbUserD = new TbUser();
                                        tbUserD.setCode(tbUser.getCode());
                                        tbUserD.setName(tbUser.getName());
                                        tbUsers.add(tbUserD);
                                    }

                                }
                            }
                            if (tbUsers.size() > 0) {
                                logger.info("设备维修新增工单发消息用户tbUsers{}", JSON.toJSONString(tbUsers));
                                TbWorkTaskInfo tbWorkTaskInfo = new TbWorkTaskInfo();
                                tbWorkTaskInfo.setTaskType(Integer.parseInt(taskType));
                                tbWorkTaskInfo.setUrgencyDegree(1);
                                sendBanRoleMessage(tbUserList, tbWorkTaskInfo, tbFactoryInfo);
                            }
                        }
                    }
                } else {
                    TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskNo);
                    if (workFlowConfigDetail.getNodeCode().equals("DOHANDLER")) {
                        logger.info("消息执行确认维修下发 下一节点验收人DOHANDLER={},workFlowConfigDetail={}", "DOHANDLER", JSON.toJSON(workFlowConfigDetail));
                        //确认维修下发 下一节点验收人
                        sendNextUser(taskInfoQ, tbFactoryInfo);
                    }
                    if (workFlowConfigDetail.getNodeCode().equals("EXAMINE")) {
                        logger.info("消息执行发送设备经理EXAMINE={},workFlowConfigDetail={}", "EXAMINE", JSON.toJSON(workFlowConfigDetail));
                        //验收 发送设备经理

                        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                        condition.setFactoryUri(tbFactoryInfo.getUri());
                        condition.setRoleNo("SCSBJL");
                        List<TbUser> tbEquipMangerUserList = tbSysUseService.getTbEquipMangerUserListByFactoryUri(condition);
                        sendEquipRoleUserMessage(tbEquipMangerUserList, taskInfoQ, tbFactoryInfo);
                    }
                    if (workFlowConfigDetail.getNodeCode().equals("EXAMINE1")) {
                        logger.info("消息执行发送水厂总经理EXAMINE1={},workFlowConfigDetail={}", "EXAMINE1", JSON.toJSON(workFlowConfigDetail));
                        //验收 发送水厂总经理
                        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                        condition.setFactoryUri(tbFactoryInfo.getUri());
                        condition.setRoleNo("SCZJL");
                        List<TbUser> tbEquipMangerUserList = tbSysUseService.getTbEquipMangerUserListByFactoryUri(condition);
                        sendEquipRoleUserMessage(tbEquipMangerUserList, taskInfoQ, tbFactoryInfo);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }



    /**
     * 维保消息
     */
    public void weibaoMessage(JSONObject jsonObject) {
        try {
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
            String taskNo = jsonObject.getString("flowNo");
            TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
            if(workFlowConfigDetail.getNodeCode().equals("DOHANDLER")) {
                logger.info("消息执行确认维修下发 下一节点验收人DOHANDLER={},workFlowConfigDetail={}", "DOHANDLER", JSON.toJSON(workFlowConfigDetail));
                //确认维修下发 下一节点验收人
                sendNextUser(taskInfoQ, tbFactoryInfo);
            }
             //进入验收流程
            if (workFlowConfigDetail.getNodeCode().equals("EXAMINE")) {
                logger.info("消息执行发送设备经理EXAMINE={},workFlowConfigDetail={}", "EXAMINE", JSON.toJSON(workFlowConfigDetail));
                //验收 发送设备经理
                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                condition.setFactoryUri(tbFactoryInfo.getUri());
                condition.setRoleNo("SCSBJL");
                List<TbUser> tbEquipMangerUserList = tbSysUseService.getTbEquipMangerUserListByFactoryUri(condition);
                sendEquipRoleUserMessage(tbEquipMangerUserList, taskInfoQ, tbFactoryInfo);
            }


        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 大修消息
     */
    public void overhaulMessage(JSONObject jsonObject) {
        try {
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
            JSONObject detailInfo = jsonObject.getJSONObject("detailInfo");
            String taskNo = jsonObject.getString("flowNo");
            String taskType = "6";
            TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            if ("1".equals(detailInfo.get("urgencyDegree"))) {
                // '0一般 1紧急',
                if (workFlowConfigDetail != null) {
                    //生成工单紧急 下发 该日当班班长（设备）
                    if (workFlowConfigDetail.getNodeCode().equals("WORKORDER")) {
                        //发送班长设备角色
                        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
                        condition.setType(2);
                        condition.setFactoryNo(workFlowConfigDetail.getOrgNo());
                        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailBanInfo = schedulingService.getTbSchedulingPlanDeatailBanInfo(condition);
                        if (tbSchedulingPlanDeatailBanInfo != null && tbSchedulingPlanDeatailBanInfo.size() > 0) {
                            //设备经理角色
                            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
                            if (tbFactoryInfo != null) {
                                TbWorkTaskInfoCondition conditionQ = new TbWorkTaskInfoCondition();
                                conditionQ.setFactoryUri(tbFactoryInfo.getUri());
                                //    private Integer type; 0:全部 1:运行班组 2,设备班组
                                conditionQ.setType(2);
                                List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(conditionQ);
                                if (tbUserList != null && tbUserList.size() > 0) {
                                    List<String> userCodeList = tbUserList.stream().map(e -> e.getCode()).collect(Collectors.toList());
                                    //按照班长设备角色发
                                    TbWorkTaskInfo tbWorkTaskInfo = new TbWorkTaskInfo();
                                    tbWorkTaskInfo.setTaskType(Integer.parseInt(taskType));
                                    sendBanRoleMessage(tbUserList, tbWorkTaskInfo, tbFactoryInfo);
                                }
                            }
                        }
                    }
                }
            }
            if (workFlowConfigDetail.getNodeCode().equals("DOHANDLER")) {
                logger.info("消息执行确认大修步骤下发 下一节点验收人DOHANDLER={},workFlowConfigDetail={}", "DOHANDLER", JSON.toJSON(workFlowConfigDetail));
                //确认维修下发 下一节点验收人
                if (taskInfoQ != null) {
                    String nextRole = taskInfoQ.getNextRole();
                    if (nextRole != null) {
                        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
                        JSONArray userJson = JSON.parseArray(nextRole);
                        for (int i = 0; i < userJson.size(); i++) {
                            logger.info("大修验证人role={},org={}", userJson.getJSONObject(i).getString("role"), userJson.getJSONObject(i).getString("org"));
                            TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                            condition.setOrgCode(userJson.getJSONObject(i).getString("org"));
                            condition.setRoleCode(userJson.getJSONObject(i).getString("role"));
                            List<TbUser> tbUseList = tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);
                            if (tbUseList != null && tbUseList.size() > 0) {
                                sendEquipRoleUserMessageCheck(tbUseList, taskInfoQ, tbFactoryInfo);
                            }
                        }
                        //[{"role":"155410627896500010","org":"156877508045800026"}]

                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 防腐消息
     */
    public void fangfuMessage(JSONObject jsonObject) {
        try {
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
            String taskNo = jsonObject.getString("flowNo");
            TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
            if(workFlowConfigDetail.getNodeCode().equals("DOHANDLER")) {
                logger.info("消息执行确认维修下发 下一节点验收人DOHANDLER={},workFlowConfigDetail={}", "DOHANDLER", JSON.toJSON(workFlowConfigDetail));
                //确认维修下发 下一节点验收人
                sendNextUser(taskInfoQ, tbFactoryInfo);
            }
            //进入验收流程
            if (workFlowConfigDetail.getNodeCode().equals("EXAMINE")) {
                logger.info("消息执行发送设备经理EXAMINE={},workFlowConfigDetail={}", "EXAMINE", JSON.toJSON(workFlowConfigDetail));
                //验收 发送设备经理
                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                condition.setFactoryUri(tbFactoryInfo.getUri());
                condition.setRoleNo("SCSBJL");
                List<TbUser> tbEquipMangerUserList = tbSysUseService.getTbEquipMangerUserListByFactoryUri(condition);
                sendEquipRoleUserMessage(tbEquipMangerUserList, taskInfoQ, tbFactoryInfo);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

    }

    /**
     * 工艺消息
     */
    public void gongyiMessage(JSONObject jsonObject) {
        try {
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(jsonObject.getJSONObject("flowNode"), TbWorkFlowConfigDetail.class);
            JSONObject detailInfo = jsonObject.getJSONObject("detailInfo");
            String taskNo = jsonObject.getString("flowNo");
            TbWorkTaskInfo taskInfoQ = workTaskInfoMapper.selectByPrimaryKey(taskNo);
            if (detailInfo.containsKey("errorNo")) {
                //通过异常来的
                if (workFlowConfigDetail.getNodeCode().equals("WORKORDER")) {
                    logger.info("消息工艺申请,审核人WORKORDER={},workFlowConfigDetail={}", "WORKORDER", JSON.toJSON(workFlowConfigDetail));
                    //确认维修下发 下一节点验收人
                    if (taskInfoQ != null) {
                        String nextRole = taskInfoQ.getNextRole();
                        if (nextRole != null) {
                            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
                            JSONArray userJson = JSON.parseArray(nextRole);
                            for (int i = 0; i < userJson.size(); i++) {
                                logger.info("工艺审核人role={},org={}", userJson.getJSONObject(i).getString("role"), userJson.getJSONObject(i).getString("org"));
                                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                                condition.setOrgCode(userJson.getJSONObject(i).getString("org"));
                                condition.setRoleCode(userJson.getJSONObject(i).getString("role"));
                                List<TbUser> tbUseList = tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);
                                if (tbUseList != null && tbUseList.size() > 0) {
                                    sendGyCheckMessageCheck(tbUseList, taskInfoQ, tbFactoryInfo);
                                }
                            }
                        }
                    }
                }
            } else {
                if (workFlowConfigDetail.getNodeCode().equals("WORKORDER")) {
                    logger.info("消息工艺申请,审核人WORKORDER={},workFlowConfigDetail={}", "WORKORDER", JSON.toJSON(workFlowConfigDetail));
                    //确认维修下发 下一节点验收人
                    if (taskInfoQ != null) {
                        String nextRole = taskInfoQ.getNextRole();
                        if (nextRole != null) {
                            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
                            JSONArray userJson = JSON.parseArray(nextRole);
                            for (int i = 0; i < userJson.size(); i++) {
                                logger.info("工艺审核人role={},org={}", userJson.getJSONObject(i).getString("role"), userJson.getJSONObject(i).getString("org"));
                                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                                condition.setOrgCode(userJson.getJSONObject(i).getString("org"));
                                condition.setRoleCode(userJson.getJSONObject(i).getString("role"));
                                List<TbUser> tbUseList = tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);
                                if (tbUseList != null && tbUseList.size() > 0) {
                                    sendGyCheckMessageCheck(tbUseList, taskInfoQ, tbFactoryInfo);
                                }
                            }
                        }
                    }
                }
            }
            if (workFlowConfigDetail.getNodeCode().equals("CHECK")) {
                logger.info("消息执行工艺步骤下发 下一节点验收人CHECK={},workFlowConfigDetail={}", "DOHANDLER", JSON.toJSON(workFlowConfigDetail));
                //确认维修下发 下一节点验收人
                if (taskInfoQ != null) {
                    String nextRole = taskInfoQ.getNextRole();
                    if (nextRole != null) {
                        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workFlowConfigDetail.getOrgNo());
                        JSONArray userJson = JSON.parseArray(nextRole);
                        for (int i = 0; i < userJson.size(); i++) {
                            logger.info("工艺验证人role={},org={}", userJson.getJSONObject(i).getString("role"), userJson.getJSONObject(i).getString("org"));
                            TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                            condition.setOrgCode(userJson.getJSONObject(i).getString("org"));
                            condition.setRoleCode(userJson.getJSONObject(i).getString("role"));
                            List<TbUser> tbUseList = tbUserMapper.getTbEquipMangerUserListByFactoryUri(condition);

                            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatails = schedulingService.getbSchedulingPlanInfoByGroupType(1, tbFactoryInfo.getFactoryNo(), DateUtils.formateDateFull(new Date()));
                            logger.info("运行排班人员用户tbSchedulingPlanDeatails={}", JSON.toJSONString(tbSchedulingPlanDeatails));
                            List<TbUser> tbUsers = new ArrayList<>();
                            for (TbUser tbUser : tbUseList) {
                                for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatails) {
                                    if (tbUser.getCode().equals(deatail.getUserCode())) {
                                        TbUser tbUserD = new TbUser();
                                        tbUserD.setCode(tbUser.getCode());
                                        tbUserD.setName(tbUser.getName());
                                        tbUsers.add(tbUserD);
                                    }
                                }
                            }
                            if (tbUsers != null && tbUsers.size() > 0) {
                                sendYunXingBZRoleUserMessage(tbUsers, taskInfoQ, tbFactoryInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 工单完成设备经理验收
     */
    public void sendEquipRoleUserMessageCheck(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {

                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                setMessageUser(userList, params);
                //  工单类型4:维修 5:维保 6:大修 7:防腐',
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    params.title = "维修工单维修完成";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维修工单维修已完成请验收";
                } else if (tbWorkTaskInfo.getTaskType() == 5) {
                    params.title = "维保工单维保完成";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维保工单维保已完成请验收";
                } else if (tbWorkTaskInfo.getTaskType() == 6) {
                    params.title = "大修工单大修完成";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的大修工单大修已完成请验收";
                } else if (tbWorkTaskInfo.getTaskType() == 7) {
                    params.title = "防腐工单防腐完成";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的防腐工单防腐已完成请验收";
                } else if (tbWorkTaskInfo.getTaskType() == 9) {
                    params.title = "工艺调整工单";
                    params.body = "您有一条新的工艺调整工单需要派发或执行，请及时处理！";
                }
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 工艺工单,第二部审批完,运行班长下发
     */
    public void sendYunXingBZRoleUserMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {
                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                setMessageUser(userList, params);
                //  工单类型4:维修 5:维保 6:大修 7:防腐',
                if (tbWorkTaskInfo.getTaskType() == 9) {
                    params.title = "工艺调整工单";
                    params.body = "您有一条新的工艺调整工单需要派发或执行，请及时处理！";
                }
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 工艺计划,第一步审批
     */
    public void sendGyCheckMessageCheck(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {
                setMessageUser(userList, params);
                params.title = "工艺调整计划";
                params.body = "您有一条新的工艺调整计划需要审批，请及时处理！";
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    private void setMessageUser(List<TbUser> userList, NoticeService.PostParams params) {
        List<String> userCodeList = userList.stream().map(e -> e.getCode()).collect(Collectors.toList());
        String[] codes = new String[userCodeList.size()];
        userCodeList.toArray(codes);
        params.targets = codes;
    }

    /**
     * 工单班长完成验收,待设备经理验收
     */
    public void sendCheckEquipRoleMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {

                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                setMessageUser(userList, params);

                //  工单类型4:维修 5:维保 6:大修 7:防腐',
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    params.title = "维修工单待经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维修工单已完成班长验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 5) {
                    params.title = "维保工单待经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维保工单已完成班长验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 6) {
                    params.title = "大修工单待经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的大修工单已完成班长验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 7) {
                    params.title = "防腐工单待经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的防腐工单已完成班长验收,请您验收";
                }
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单设备经理完成验收,待设备经理验收
     */
    public void sendCheckChangZhangRoleMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {

                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                setMessageUser(userList, params);
                //  工单类型4:维修 5:维保 6:大修 7:防腐',
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    params.title = "维修工单待水厂总经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维修工单已完成经理验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 5) {
                    params.title = "维保工单待水厂总经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的维保工单已完成经理验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 6) {
                    params.title = "大修工单待水厂总经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的大修工单已完成经理验收,请您验收";
                } else if (tbWorkTaskInfo.getTaskType() == 7) {
                    params.title = "防腐工单待水厂总经理验收";
                    params.body = "设备" + tbWorkTaskInfo.getEquipName() + "的防腐工单已完成经理验收,请您验收";
                }
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendEquipRoleUserMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            if (userList != null && userList.size() > 0) {

                List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
                setMessageUser(userList, params);
                //  工单类型4:维修 5:维保 6:大修 7:防腐',
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                        params.title = "紧急维修工单验收";
                        params.body = "您有一条新的维修工单需要验收，请及时处理！（紧急）";
                    } else {
                        params.title = "维修工单验收";
                        params.body = "您有一条新的维修工单需要验收，请及时处理！";
                    }
                } else if (tbWorkTaskInfo.getTaskType() == 5) {
                    params.title = "维保工单验收";
                    params.body = "您有一条新的维保工单需要验收,请及时处理！";
                } else if (tbWorkTaskInfo.getTaskType() == 6) {
                    if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                        params.title = "紧急大修工单验收";
                        params.body = "您有一条新的大修工单需要验收，请及时处理！（紧急）";
                    } else {
                        params.title = "大修工单验收";
                        params.body = "您有一条新的大修工单需要验收，请及时处理！";
                    }
                } else if (tbWorkTaskInfo.getTaskType() == 7) {
                    params.title = "防腐工单验收";
                    params.body = "您有一条新的防腐工单需要验收,请及时处理！";
                }
                sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 添加通知异常创建者
     */
    public void sendErrorCreateUserMessage(TbEquipFaultInfo equipFaultInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0] = equipFaultInfo.getReportUserCode();
            params.targets = codes;
            params.title = "异常处理-转维修（紧急状态)";
            params.body = "您上报的" + "[" + equipFaultInfo.getEquipName() + "]" + "异常已转至维修工单并创建下发";

            sendNoticeMessage(1, tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info("巡检异常通知成功用户userName={}", equipFaultInfo.getReportUserName());
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 工单创建,发送设备班长角色
     */
    public void sendBanRoleMessage(List<TbUser> tbUserList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userNameList = tbUserList.stream().map(e -> e.getName()).collect(Collectors.toList());

            setMessageUser(tbUserList, params);
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskFrom() == null) {
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    if (tbWorkTaskInfo.getUrgencyDegree() == 1) {
                        params.title = "紧急维修工单派发";
                        params.body = "您有一条新的维修工单需要派发或执行，请及时处理！（紧急）";
                    } else {
                        params.title = "维修工单派发";
                        params.body = "您有一条新的维修工单需要派发或执行，请及时处理！";
                    }
                } else if (tbWorkTaskInfo.getTaskType() == 5) {
                    params.title = "紧急维保下发";
                    params.body = "有一条新的紧急维保工单需要派发执行";
                } else if (tbWorkTaskInfo.getTaskType() == 6) {
                    params.title = "紧急大修下发";
                    params.body = "有一条新的紧急大修重置工单需要派发执行";
                } else if (tbWorkTaskInfo.getTaskType() == 7) {
                    params.title = "紧急防腐下发";
                    params.body = "有一条新的紧急防腐工单需要派发执行";
                }
            } else {
                if (tbWorkTaskInfo.getTaskType() == 4) {
                    params.title = "异常处理-转维修（紧急状态)";
                    params.body = "有一条新的紧急维修工单需要派发执行";
                } else if (tbWorkTaskInfo.getTaskType() == 9) {
                    params.title = "异常处理-转工艺调整";
                    params.body = "有一条新的工艺调整工单需要派发执行";
                }
            }

            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    /**
     * 确认维修下发 下一节点验收人
     */
    public void sendNextUser(TbWorkTaskInfo taskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            if (taskInfo.getNextUser() != null && !"".equals(taskInfo.getNextUser())) {
                codes[0] = taskInfo.getNextUser();
                params.targets = codes;
                if (taskInfo.getTaskType() == 4) {
                    if (taskInfo.getUrgencyDegree() == 1) {
                        params.title = "紧急维修工单验收";
                        params.body = "您有一条新的维修工单需要验收，请及时处理！（紧急）";
                    } else {
                        params.title = "维修工单验收";
                        params.body = "您有一条新的维修工单需要验收，请及时处理！";
                    }
                } else if (taskInfo.getTaskType() == 5) {
                    params.title = "维保工单验收";
                    params.body = "您有一条新的维保工单需要验收，请及时处理！";
                } else if (taskInfo.getTaskType() == 6) {
                    if (taskInfo.getUrgencyDegree() == 1) {
                        params.title = "紧急大修工单验收";
                        params.body = "您有一条新的大修工单需要验收，请及时处理！（紧急）";
                    } else {
                        params.title = "大修工单验收";
                        params.body = "您有一条新的大修工单需要验收，请及时处理！";
                    }
                } else if (taskInfo.getTaskType() == 7) {
                    params.title = "防腐工单验收";
                    params.body = "您有一条新的防腐工单需要验收，请及时处理";
                }

                sendNoticeMessage(taskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
                logger.info(params.title + "成功通知用户userName={}", tbUserMapper.selectByPrimaryKey(taskInfo.getNextUser()).getName());
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单派发
     *
     * @param request
     * @param jsonObject
     * @return
     */
    @PostMapping("/setDutyUser")
    @ApiOperation(value = "工单下发")
    public AjaxObject setDutyUser(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        logger.info("指派工单提交信息JSONObject={}", jsonObject);
        TbUser user = super.getUser(request, stringRedisTemplate);
        int returnCode = equipOrderService.setTaskDudyUser(user, jsonObject);
        //下发通知消息
        if (returnCode == 0) {
            TbWorkTaskInfo taskInfo = workTaskInfoMapper.selectByPrimaryKey(jsonObject.getString("taskNo"));
            //if (taskInfo.getIsEntrust() == 0) 0:不委外 1:委外'
            String dutyUser = taskInfo.getDutyUser();
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(taskInfo.getOrgNo());
            if (dutyUser != null) {
                JSONObject userJson = JSON.parseObject(dutyUser);
                logger.info("执行人code={},name={}", userJson.getString("userCode"), userJson.getString("userName"));
                sendXFDutyMessage(userJson.getString("userCode"), userJson.getString("userName"), taskInfo, tbFactoryInfo);
            }
            String assistUser = taskInfo.getAssistUser();
            if (assistUser != null) {
                JSONArray jsonArray = JSON.parseArray(assistUser);
                String[] codes = new String[jsonArray.size()];
                String name = "";
                for (int i = 0; i < jsonArray.size(); i++) {
                    codes[i] = jsonArray.getJSONObject(i).getString("userCode");
                    name += jsonArray.getJSONObject(i).getString("userName") + " ";
                }
                logger.info("协助人codes={},names={}", JSON.toJSONString(codes), name);
                sendXFAssistUserMessage(codes, name, taskInfo, tbFactoryInfo);
            }

        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    /**
     * 工单派发给执行人
     */
    public void sendXFDutyMessage(String code, String name, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0] = code;
            params.targets = codes;
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                    params.title = "紧急维修工单执行";
                    params.body = "您有一条新的维修工单需要执行，请及时处理！（紧急）";

                } else {
                    params.title = "维修工单执行";
                    params.body = "您有一条新的维修工单需要执行，请及时处理！";
                }
            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单执行";
                params.body = "有一条维保工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                    params.title = "紧急大修工单执行";
                    params.body = "您有一条新的大修工单需要执行，请及时处理！（紧急）";
                } else {
                    params.title = "大修工单执行";
                    params.body = "您有一条新的大修工单需要执行，请及时处理！";
                }
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单执行";
                params.body = "有一条防腐工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 9) {
                params.title = "工艺调整工单执行";
                params.body = "您有一条新的工艺调整工单需要执行，请及时处理！";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", name);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单派发给协助人
     */
    public void sendXFAssistUserMessage(String[] codes, String name, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            params.targets = codes;
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                    params.title = "紧急维修工单派发";
                    params.body = "您有一条新的维修工单需要协助执行，请及时处理！（紧急）";
                } else {
                    params.title = "维修工单协助执行";
                    params.body = "您有一条新的维修工单需要协助执行，请及时处理！";
                }

            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单派发";
                params.body = "有一条维保工单下发给您，请协助执行人进行工单执行工作";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                if (tbWorkTaskInfo.getUrgencyDegree().equals(1)) {
                    params.title = "紧急大修工单派发";
                    params.body = "您有一条新的大修工单需要协助执行，请及时处理！（紧急）";
                } else {
                    params.title = "大修工单协助执行";
                    params.body = "您有一条新的大修工单需要执行执行，请及时处理！";
                }
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单派发";
                params.body = "有一条防腐工单下发给您，请协助执行人进行工单执行工作";
            } else if (tbWorkTaskInfo.getTaskType() == 9) {
                params.title = "工艺调整工单派发";
                params.body = "有一条工艺调整工单下发给您，请协助执行人进行工单执行工作";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendNoticeMessage(Integer taskType, String factoryNo,String factoryName, NoticeService.PostParams params) throws Exception {
        Map<String, Object> extParameters = new HashMap<>(6);
        extParameters.put("taskType", taskType);
        params.extParameters = extParameters;
        extParameters.put("factoryNo", factoryNo);
        extParameters.put("factoryName", factoryName);
        params.appPush = false;
        logger.info(params.title + "Params={}", JSON.toJSONString(params));
        noticeService.post(params);
    }


    /**
     * 提交重修或提交委外 提交委外 type = 1
     *
     * @param request
     * @param jsonObject
     * @return
     */
    @PostMapping("/saveValid")
    @ApiOperation(value = "设置维修工单无法自修")
    public AjaxObject saveValid(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        logger.info("提交重修或提交委外taskNo={}", jsonObject);
        TbUser user = super.getUser(request, stringRedisTemplate);
        int returnCode = equipOrderService.saveValid(jsonObject, user);
        int type = jsonObject.getIntValue("type");
        if (returnCode == 0) {
            TbWorkTaskInfo taskInfo = workTaskInfoMapper.selectByPrimaryKey(jsonObject.getString("flowNo"));
            if (taskInfo != null) {
                TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(taskInfo.getOrgNo());
                if (tbFactoryInfo != null) {
                    if (type == 1) {
                        //委外通知
                        sendRepetUserMessage(taskInfo, tbFactoryInfo);
                    } else {
                        //走重修 通知
//                        List<TbUser> tbEquipMangerUserList = getTbEquipMangerUserList(tbFactoryInfo.getUri());
//                        sendEquipManagerWWUserMessage(tbEquipMangerUserList,taskInfo,tbFactoryInfo);
                    }
                }
            }

        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    /**
     * 工单重修
     */
    public void sendRepetUserMessage(TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            String dutyUser = tbWorkTaskInfo.getDutyUser();
            JSONObject jsonObject = JSON.parseObject(dutyUser);
            if (jsonObject != null) {
                codes[0] = jsonObject.getString("userCode");
            }
            params.targets = codes;
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                params.title = "维修工单验收-重修";
                params.body = "有一条维修工单没有通过验收，请及时进行操作";
            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单验收-重修";
                params.body = "有一条维保工单没有通过验收，请及时进行操作";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                params.title = "大修工单验收-重修";
                params.body = "有一条大修工单没有通过验收，请及时进行操作";
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单验收-重修";
                params.body = "有一条防腐工单没有通过验收，请及时进行操作";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", tbUserMapper.selectByPrimaryKey(jsonObject.getString("userCode")).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单发给设备经理(委外)
     */
    public void sendEquipManagerWWUserMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            setMessageUser(userList, params);
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                params.title = "维修工单验收";
                params.body = "有一条委外维修工单完成，需要您进行验收";
            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单验收";
                params.body = "有一条委外维保工单完成，需要您进行验收";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                params.title = "大修工单验收";
                params.body = "有一条委外大修工单完成，需要您进行验收";
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单验收";
                params.body = "有一条委外防腐工单完成，需要您进行验收";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单发给设备经理无法自修
     */
    public void sendEquipManagerNoUserMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            setMessageUser(userList, params);
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                params.title = "维修工单派发";
                params.body = "有一条维修工单下发给您，请协助执行人进行工单执行工作";
            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单派发";
                params.body = "有一条维保工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                params.title = "大修工单派发";
                params.body = "有一条大修工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单派发";
                params.body = "有一条防腐工单下发给您，请尽快查看并执行";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 工单发给设备经理维修完成
     */
    public void sendEquipManageUserMessage(List<TbUser> userList, TbWorkTaskInfo tbWorkTaskInfo, TbFactoryInfo tbFactoryInfo) {
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();

            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            setMessageUser(userList, params);
            //  工单类型4:维修 5:维保 6:大修 7:防腐',
            if (tbWorkTaskInfo.getTaskType() == 4) {
                params.title = "维修工单派发";
                params.body = "有一条维修工单下发给您，请协助执行人进行工单执行工作";
            } else if (tbWorkTaskInfo.getTaskType() == 5) {
                params.title = "维保工单派发";
                params.body = "有一条维保工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 6) {
                params.title = "大修工单派发";
                params.body = "有一条大修工单下发给您，请尽快查看并执行";
            } else if (tbWorkTaskInfo.getTaskType() == 7) {
                params.title = "防腐工单派发";
                params.body = "有一条防腐工单下发给您，请尽快查看并执行";
            }
            sendNoticeMessage(tbWorkTaskInfo.getTaskType(), tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送设备/运行班组角色
    public void sendEquipManageYesrUserMessage(List<TbUser> userList, TbRoutingTask oldRoutingTask, TbFactoryInfo tbFactoryInfo) {
        try {
            //'0:正常工单1:临时工单',
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            setMessageUser(userList, params);
            if (oldRoutingTask.getTempStatus() == 0) {
                params.title = "正常巡检";
                params.body = "正常巡检工单发现异常上报项，请尽快处理";
            } else {
                params.title = "临时巡检";
                params.body = "临时巡检工单发现异常上报项，请尽快处理";
            }
            sendNoticeMessage(1, tbFactoryInfo.getFactoryNo(),tbFactoryInfo.getFactoryName(), params);
            logger.info(params.title + "通知成功用户userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消任务
     *
     * @param request
     * @param taskNo
     * @return
     */
    @PostMapping("/cancelTask")
    @ApiOperation(value = "取消工单计划")
    public AjaxObject cancelTask(HttpServletRequest request, String taskNo) {
        logger.info("取消任务taskNo={}", taskNo);
        TbUser user = super.getUser(request, stringRedisTemplate);
        int returnCode = equipOrderService.cancelTask(taskNo, user);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    @RequestMapping("/getFileList")
    @ApiOperation(value = "获取工单相关的资料信息")
    @ResponseBody
    public AjaxObject getFileList(HttpServletRequest request, TbEquipTaskFile overhaulTaskFile) {
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbEquipTaskFile> list = equipOrderService.getFileList(overhaulTaskFile);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/uploadAttachFile")
    @ApiOperation(value = "上传工单的相关资料")
    @ResponseBody
    public AjaxObject uploadAttachFile(TbEquipTaskFile overhaulTaskFile) {
        if (equipOrderService.addTaskFile(overhaulTaskFile) > 0) {
            return AjaxObject.ok("上传文件成功");
        } else {
            return AjaxObject.error("上传文件失败");
        }
    }

    @PostMapping("/deleteAttachFile")
    @ApiOperation(value = "删除工单资料")
    @ResponseBody
    public AjaxObject deleteAttachFile(TbEquipTaskFile overhaulTaskFile) {
        if (equipOrderService.deleteTaskFile(overhaulTaskFile) > 0) {
            return AjaxObject.ok("文件删除成功");
        } else {
            return AjaxObject.error("文件删除失败");
        }
    }

    /**
     * 编辑计划时间
     *
     * @param request
     * @param taskInfo
     * @return
     */
    @PostMapping("/editPlan")
    @ApiOperation(value = "修改工单计划时间")
    public AjaxObject editPlan(HttpServletRequest request, TbWorkTaskInfo taskInfo) {
        logger.info("编辑计划时间TbWorkTaskInfo={}", JSON.toJSONString(taskInfo));
        String planFinishTime = request.getParameter("planFinishTime");
        if(planFinishTime.length()>11){
            taskInfo.setPlanFinishTime(DateUtils.parseDateFull(planFinishTime));
        }

        TbUser user = super.getUser(request, stringRedisTemplate);
        int returnCode = equipOrderService.editPlan(taskInfo);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
    }

    /**
     * 维保编辑特殊
     *
     * @param request
     * @param taskInfo
     * @return
     */
    @PostMapping("/editMantenPlan")
    @ApiOperation(value = "修改维保工单")
    public AjaxObject editMantenPlan(HttpServletRequest request, TbWorkTaskInfo taskInfo) {
        AjaxObject ajaxObject = new AjaxObject();
        logger.info("维保编辑计划时间TbWorkTaskInfo={}", taskInfo);
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            int flag = equipOrderService.editMantenPlan(taskInfo, user);
            if (flag == 1) {
                ajaxObject = AjaxObject.ok("编辑成功");
            } else {
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("维保编辑计划时间失败e={}", e);
            return AjaxObject.error("维保编辑计划时间，请联系管理员！");
        }
        return ajaxObject;
    }

    /**
     * 按工艺段统计工单数量
     *
     * @param factoryNo
     * @return
     */
    @GetMapping("/getTaskStaticByGongYi")
    @ApiOperation(value = "统计各工艺段当前的工单数量")
    public AjaxObject getTaskStaticByGongYi(HttpServletRequest request, String factoryNo) {
        logger.info("按工艺段统计工单数量factoryNo={}", factoryNo);
        TbUser user = super.getUser(request, stringRedisTemplate);
        Date date = DateUtils.getNextDate(new Date(), 1);
        List<Map<String, Object>> list = equipOrderService.getTaskStaticByGongYi(date, factoryNo, user);
        return super.getResultObject(list, null);
    }

    /**
     * 工艺查看效果
     *
     * @param request
     * @param taskInfo
     * @return
     */
    @GetMapping("/queryGYEffct")
    @ApiOperation(value = "获取工艺调整工单的关联指标数据")
    public AjaxObject queryGYEffct(HttpServletRequest request, TbWorkTaskInfo taskInfo) {
        logger.info("工艺查看效果TbWorkTaskInfo={}", JSON.toJSONString(taskInfo));
        TbUser user = super.getUser(request, stringRedisTemplate);
        Map map = equipOrderService.queryGYEffct(taskInfo);
        return AjaxObject.ok(map);
    }

    /**
     * 导出工艺调整工单
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/exportGongYiOrder",method = RequestMethod.GET)
    @GetMapping("/app/getTargetTbSchedulingPlan")
    @ApiOperation(value = "导出工艺调整工单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "taskType", value = "类型传9", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "beginDate", value = "调整开始时间", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "调整结束时间", required = false, dataType = "string", paramType = "query")
    })
    public void exportGongYiOrder(HttpServletRequest request,  HttpServletResponse response, EquipOrderServiceImpl.WorkTaskQueryParam workTaskQueryParam) {
        logger.info("PC后台获取工艺工单列表参数WorkTaskQueryParam={}", JSON.toJSONString(workTaskQueryParam));
        // PC后台获取工单列表参数WorkTaskQueryParam={"beginDate":1575129600000,"endDate":1575302400000,"factoryNo":"5c6f5f581c5fda0001211081","taskType":9}
        //取当前任务的操作步骤信息参数水厂factoryNo=5d81bd3194e57500078c2ac1,步骤编号nodeIndex=-1,工单类型流程编码=GYTZ:工单taskNo=2d060597fdfd4cfe9a68fb934c779167
        String fileName = "工艺调整工单.xls";
        Map<String, Object> resultMap = new HashMap<>(16);
        List list = new ArrayList();
        List<TbWorkTaskInfo> tbWorkTaskInfoList = equipOrderService.getTaskInfoList(workTaskQueryParam);
        if (tbWorkTaskInfoList != null && tbWorkTaskInfoList.size() > 0) {
            for (TbWorkTaskInfo tbWorkTaskInfo : tbWorkTaskInfoList) {
                Map<String, Object> resultMapNew = new HashMap<>(16);
                int returnCode = equipOrderService.getWorkFlowDetail(tbWorkTaskInfo.getTaskNo(), tbWorkTaskInfo.getOrgNo(), -1, "GYTZ", resultMapNew);
                list.add(resultMapNew);
            }
            logger.info("工艺调整工单列表gyList={}", JSON.toJSON(list));
            List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
            ExcelExportEntity deliColGroup = new ExcelExportEntity("工艺调整工单", "order");
            List<ExcelExportEntity> deliColList = new ArrayList<ExcelExportEntity>();
            deliColList.add(new ExcelExportEntity("调整名称", "taskName"));
            deliColList.add(new ExcelExportEntity("执行信息", "orderMessage"));
            deliColList.add(new ExcelExportEntity("调整类型", "adjustType"));
            deliColList.add(new ExcelExportEntity("计划开始时间", "startTime"));
            deliColList.add(new ExcelExportEntity("调整时间", "adjustTime"));
            deliColList.add(new ExcelExportEntity("调整内容", "taskContent"));
            deliColList.add(new ExcelExportEntity("影响指标", "zhibiao"));
            deliColGroup.setList(deliColList);
            colList.add(deliColGroup);
            ExcelExportEntity jdColGroup = new ExcelExportEntity("审批", "check");
            List<ExcelExportEntity> jdColList = new ArrayList<ExcelExportEntity>();
            jdColList.add(new ExcelExportEntity("执行信息", "zhixingCheck"));
            jdColList.add(new ExcelExportEntity("审批意见", "shenpiCheck"));
            jdColList.add(new ExcelExportEntity("备注", "noteCheck"));
            jdColGroup.setList(jdColList);
            colList.add(jdColGroup);
            ExcelExportEntity jdColGroupXf = new ExcelExportEntity("下发", "xiafa");
            List<ExcelExportEntity> jdColListXf = new ArrayList<ExcelExportEntity>();
            jdColListXf.add(new ExcelExportEntity("执行信息", "zhixingXf"));
            jdColListXf.add(new ExcelExportEntity("执行人", "zhixingXfUser"));
            jdColListXf.add(new ExcelExportEntity("协助人", "xiezhuXfUser"));
            jdColGroupXf.setList(jdColListXf);
            colList.add(jdColGroupXf);
            ExcelExportEntity jdColGroupFk = new ExcelExportEntity("反馈", "fankui");
            List<ExcelExportEntity> jdColListFk = new ArrayList<ExcelExportEntity>();
            jdColListFk.add(new ExcelExportEntity("执行信息", "zhixingFk"));
            jdColListFk.add(new ExcelExportEntity("执行内容", "zhixingFkContent"));
            jdColListFk.add(new ExcelExportEntity("备注", "noteFk"));
            jdColGroupFk.setList(jdColListFk);
            colList.add(jdColGroupFk);
            List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> valMap = new HashMap<String, Object>();
                String orderMessage = "";
                String taskName = "";
                String adjustType = "";
                String adjustTime = "";
                String startTime = "";
                String taskContent = "";
                String zhibiao = "";
                //审批字段
                String tijiaoUser = "提交人:";
                String zhixingCheck = "";
                String shenpiCheck = "";
                String noteCheck = "";
                //下发字段
                String zhixingXf = "";
                String zhixingXfUser = "";
                String xiezhuXfUser = "";
                //反馈字段
                String zhixingFk = "";
                String zhixingFkContent = "";
                String noteFk = "";
                Map map = (Map) list.get(i);
                List orderList = (List) map.get("detailList");
                if (orderList != null && orderList.size() > 0) {
                    Map mapOrder = (Map) orderList.get(0);
                    System.out.println(mapOrder.toString());
                    List<Map<String, Object>> fieldValueList = (List<Map<String, Object>>) mapOrder.get("fieldValueList");
                    orderMessage = tijiaoUser + mapOrder.get("commitUser").toString() + "  " + mapOrder.get("commitTime").toString();
                    taskName = fieldValueList.get(0).get("fieldValue").toString();
                    adjustType = fieldValueList.get(1).get("fieldValue").toString();
                    startTime = fieldValueList.get(2).get("fieldValue").toString();
                    adjustTime = fieldValueList.get(3).get("fieldValue").toString();
                    taskContent = fieldValueList.get(4).get("fieldValue").toString();
                    zhibiao = fieldValueList.get(5).get("fieldValue").toString();
                    if (orderList.size() >= 2 && orderList.size() < 5) {
                        //审批
                        Map mapCheck = (Map) orderList.get(1);
                        zhixingCheck = tijiaoUser + mapCheck.get("commitUser").toString() + "  " + mapCheck.get("commitTime").toString();
                        List<Map<String, Object>> fieldValueCheckList = (List<Map<String, Object>>) mapCheck.get("fieldValueList");
                        shenpiCheck = fieldValueCheckList.get(0).get("fieldValue").toString();
                        noteCheck = fieldValueCheckList.get(1).get("fieldValue").toString();

                        if (orderList.size() >= 3) {
                            //下发
                            Map mapXf = (Map) orderList.get(2);
                            zhixingXf = tijiaoUser + mapXf.get("commitUser").toString() + "  " + mapXf.get("commitTime").toString();
                            List<Map<String, Object>> fieldValueXfList = (List<Map<String, Object>>) mapXf.get("fieldValueList");
                            zhixingXfUser = fieldValueXfList.get(0).get("fieldValue").toString();
                            xiezhuXfUser = fieldValueXfList.get(1).get("fieldValue").toString();
                        }
                        if (orderList.size() == 4) {
                            //反馈
                            Map mapFk = (Map) orderList.get(3);
                            zhixingFk = tijiaoUser + mapFk.get("commitUser").toString() + "  " + mapFk.get("commitTime").toString();
                            List<Map<String, Object>> fieldValueFkList = (List<Map<String, Object>>) mapFk.get("fieldValueList");
                            zhixingFkContent = fieldValueFkList.get(0).get("fieldValue").toString();
                            noteFk = fieldValueFkList.get(1).get("fieldValue").toString();
                        }
                    }
                    List<Map<String, Object>> orderDetailList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> deliValMap = new HashMap<String, Object>();
                    deliValMap.put("taskName", taskName);
                    deliValMap.put("adjustType", adjustType);
                    deliValMap.put("adjustTime", adjustTime);
                    deliValMap.put("startTime", startTime);
                    deliValMap.put("taskContent", taskContent);
                    deliValMap.put("zhibiao", zhibiao);
                    deliValMap.put("orderMessage", orderMessage);
                    orderDetailList.add(deliValMap);
                    valMap.put("order", orderDetailList);
                    //审批
                    List<Map<String, Object>> checkDetailList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> checkValMap = new HashMap<String, Object>();
                    checkValMap.put("zhixingCheck", zhixingCheck);
                    checkValMap.put("shenpiCheck", shenpiCheck);
                    checkValMap.put("noteCheck", noteCheck);
                    checkDetailList.add(checkValMap);
                    valMap.put("check", checkDetailList);
                    //下发
                    List<Map<String, Object>> xFDetailList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> xFValMap = new HashMap<String, Object>();
                    xFValMap.put("zhixingXf", zhixingXf);
                    xFValMap.put("zhixingXfUser", zhixingXfUser);
                    xFValMap.put("xiezhuXfUser", xiezhuXfUser);
                    xFDetailList.add(xFValMap);
                    valMap.put("xiafa", xFDetailList);
                    //反馈

                    List<Map<String, Object>> fKDetailList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> fKValMap = new HashMap<String, Object>();
                    fKValMap.put("zhixingFk", zhixingFk);
                    fKValMap.put("zhixingFkContent", zhixingFkContent);
                    fKValMap.put("noteFk", noteFk);
                    fKDetailList.add(fKValMap);
                    valMap.put("fankui", fKDetailList);
                    listMap.add(valMap);
                }
            }
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("工艺调整", "工艺调整数据"), colList,
                    listMap);
            ExcelHighUtils.buildExcelDocument(fileName, workbook, response);
            /*FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("D:/工艺调整数据.xls");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }else {
            try {
                errorInfo(response,"查询数据为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *
     * 下载模板出错
     */
    public void  errorInfo( HttpServletResponse response,String info) throws Exception{
        response.reset();
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        os.write(info.getBytes("UTF-8"));
        os.close();
    }
}

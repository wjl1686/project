package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.BewgQueryRelationofnodes;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.enums.ErrorMsg;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.domain.vo.TbFillFormFieldVo;
import com.ejobim.opplat.exception.RestException;
import com.ejobim.opplat.mapper.TbDraftDataMapper;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
/**
 * @author wujianlong
 * @Description: 任务
 * @date 2019/1/15 18:16
 */
@Api(tags = "任务管理")
@RestController
@RequestMapping("/task")
public class TaskController extends  BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WorkOrderService workOrderService;

    @Value("${email.excel}")
    private String filePath;

    @Autowired
    private Environment env;

    @Autowired
    private TbFactoryService factoryService;

    @Autowired
    private TbSynObjectService tbSynObjectService;

    @Autowired
    private BewgService bewgService;

    @Autowired
    private ParameterConfigService parameterConfigService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HomeService homeService;

    @Autowired
    private RoutingService routingService;




    /**
     * app端查询我的任务
     *
     * @param request,condition
     * @return
     */
    @GetMapping("/getTaskAllList")
    public AjaxObject getTaskAllList(HttpServletRequest request, TaskInfoCondition condition) {
        logger.info("app端查询我的任务参数TaskInfoCondition={}", JSON.toJSONString(condition));
        TbUser user = super.getUser(request, stringRedisTemplate);
        condition.setDutyUser(user.getCode());
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));

        List<TaskVo> taskInfoList = workOrderService.getTaskAllListNew(condition);
        for (TaskVo taskInfo : taskInfoList) {
            if (taskInfo.getType() == 4) {
                taskInfo.setTaskName("维修任务");
            } else if (taskInfo.getType() == 5) {
                taskInfo.setTaskName("维保任务");
            } else if (taskInfo.getType() == 6) {
                taskInfo.setTaskName("大修任务");
            } else if (taskInfo.getType() == 7) {
                taskInfo.setTaskName("防腐任务");
            } else if (taskInfo.getType() == 9) {
                taskInfo.setTaskName("工艺调整");
            } else if (taskInfo.getType() == 0) {
                taskInfo.setTaskName("巡检任务");
            }
        }
        return super.getResultViewObject(taskInfoList, request.getParameter("page"), taskInfoList, request.getParameter("rows"));
    }

    /**
     * 查询当天任务(填报/巡检)
     *
     * @param currentTime
     * @return
     */
    @GetMapping("/getCurrentTaskInfo")
    public AjaxObject getTaskInfoList(String currentTime) {
        List<TbTaskInfo> tbTaskInfoVos = workOrderService.getCurrentTaskInfo(currentTime);
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("tbTaskInfoVos", tbTaskInfoVos);
        objectMap.put("task/xunjian", tbTaskInfoVos.size());
        return AjaxObject.ok(objectMap);
    }

    /**
     * 查询当天任务(待处理)
     *
     * @param currentTime
     * @return
     */
    @GetMapping("/getPendingTaskList")
    public AjaxObject getPendingTaskList(String currentTime) {
        List<TbTaskInfo> tbTaskInfoVos = workOrderService.getPendingTaskList(currentTime);
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("tbTaskInfoVos", tbTaskInfoVos);
        return AjaxObject.ok(objectMap);
    }


    /**
     * 查询当月任务
     *
     * @return
     */
    @GetMapping("/getCurrentMouthTaskInfo")
    public AjaxObject getCurrentMouthTaskInfo() {
        Map<String, Object> objectMap = workOrderService.getCurrentMouthTaskInfo();
        return AjaxObject.ok(objectMap);
    }

    /**
     * 查询今日填报数据已下发的
     *
     * @param tbFillFormTask
     * @returngetFillTaskDetail
     */
    @GetMapping("/getFillTaskInfoList")
    public AjaxObject getFillTaskInfoList(HttpServletRequest request, TbFillFormTask tbFillFormTask, String date) {
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        TbUser user = super.getUser(request, stringRedisTemplate);
        List<TbFillFormTask> tbRoutingInspectionInfos = workOrderService.findTodayFillTaskInfoList(tbFillFormTask, date, user.getCode());
        return super.getResultObject(tbRoutingInspectionInfos, request.getParameter("page"));

    }


    @GetMapping("/getFillTaskDetailList")
    public AjaxObject getFillTaskDetailList(HttpServletRequest request, String fillTaskNo, String uri) {
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbFillFormDetail> tbRoutingInspectionInfos = workOrderService.findFillTaskDetailList(fillTaskNo, uri);
        return super.getResultObject(tbRoutingInspectionInfos, request.getParameter("page"));
    }

    /**
     * 针对APP的接口，对自动填报和手动填报进行了分组
     *
     * @param request
     * @param fillTaskNo
     * @return
     */
    @GetMapping("/getFillTaskDetail")
    public AjaxObject getFillTaskDetail(HttpServletRequest request, String fillTaskNo, String uri) {
        List<TbFillFormDetail> tbRoutingInspectionInfos = workOrderService.findFillTaskDetailList(fillTaskNo, uri);
        TbFillFormTask fillFormTask = workOrderService.getTbFillTaskByKey(fillTaskNo);
        Map<Integer, List<TbFillFormDetail>> map = new HashMap(16);
        List<String> uriList = new ArrayList<>();
        //查询数据接口
        for (TbFillFormDetail tbFill : tbRoutingInspectionInfos) {
            if (tbFill.getType().intValue() == 2) {
                if (!map.containsKey(2)) {
                    map.put(2, new ArrayList<TbFillFormDetail>());
                }
                map.get(2).add(tbFill);
            } else {
                if (!map.containsKey(1)) {
                    map.put(1, new ArrayList<TbFillFormDetail>());
                }
                map.get(1).add(tbFill);
            }
            if (tbFill.getType() == 2) {
                uriList.add(tbFill.getBrowsePath());
            }
        }
        if (fillFormTask == null) {
            return AjaxObject.error("未找到的填报任务");
        } else {
            if (fillFormTask.getStatus() == 1
                    || fillFormTask.getStatus() == 2
                    || fillFormTask.getStatus() == 11
                    || fillFormTask.getStatus() == 12) {
                //未完成的任务需要查询实时数据
                String[] uriCollection = new String[uriList.size()];
                uriList.toArray(uriCollection);
                JSONObject jsonObject = this.bewgService.getDataInfoNew(uriCollection);
                System.out.print(jsonObject.toString());
                if ("0x00000000".equals(jsonObject.getString("code"))) {
                    for (int i = 0; i < map.get(2).size(); i++) {
                        TbFillFormDetail fillFormDetail = map.get(2).get(i);
                        JSONObject valueJson = jsonObject.getJSONArray("result").getJSONObject(i);
                        if (valueJson != null) {
                            if (fillFormDetail.getAutoValue() == null) {
                                fillFormDetail.setAutoValue(valueJson.getDouble("v"));
                            }
                            if (fillFormDetail.getFieldValue() == null) {
                                fillFormDetail.setFieldValue(valueJson.getDouble("v"));
                            }
                        }

                    }
                }
            }
            Map resultMap = new HashMap(16);
            resultMap.put("list", map);
            return AjaxObject.ok(resultMap);
        }

    }

    /**
     * 查询填报内容配置项
     *
     * @param factoryNo,taskNo,param
     * @return
     */
    @GetMapping("/getFillTaskCofigList")
    public AjaxObject getFillTaskCofigList(String factoryNo, String taskNo, String param) {
        logger.info("查询参数factoryNo={},taskNo={}", factoryNo, taskNo);
        Map<String, Object> objectMap = new HashMap<>(16);
        try {
            if (StringUtils.isBlank(factoryNo) || StringUtils.isBlank(taskNo)) {
                throw new RestException(ErrorMsg.PARAMETER_ISNULL);
            }
            List<TbFillFormFieldVo> tbTaskInfoVos = workOrderService.findFillTaskConfigList(factoryNo, taskNo, param);
            objectMap.put("tbTaskInfoVos", tbTaskInfoVos);
        } catch (RestException e) {
            return AjaxObject.error(e.getMsg());
        } catch (Exception e) {

        }
        return AjaxObject.ok(objectMap);
    }

    /**
     * 生成填报任务
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/saveTbFillTask", method = RequestMethod.POST)
    public AjaxObject saveTbFillTask(HttpServletRequest req) {
        String factoryNo = req.getParameter("factoryNo");
        Date startTime = DateUtils.parseDate(req.getParameter("beginTime"));
        Date endTime = DateUtils.parseDate(req.getParameter("endTime"));
        TbUser user = super.getUser(req, stringRedisTemplate);
        try {
            this.factoryService.createFillTask(factoryNo, startTime, endTime, user);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return AjaxObject.error();
        }
        return AjaxObject.ok();

    }

    /**
     * 添加填报数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/saveTbFillFormDetail", method = RequestMethod.POST)
    public AjaxObject saveTbFillFormDetail(HttpServletRequest request, @RequestBody JSONObject jsonData) {
        logger.info("请求参数{}", jsonData.toString());
        JSONArray manulFillList = jsonData.getJSONArray("manulFillList");
        JSONArray autoFillList = jsonData.getJSONArray("autoFillList");
        List<TbFillFormDetail> list = new ArrayList<>();
        for (int i = 0; i < manulFillList.size(); i++) {
            JSONObject fillObject = manulFillList.getJSONObject(i);
            String fillFormDetailNo = fillObject.getString("no");
            TbFillFormDetail tbFillFormDetail = new TbFillFormDetail();
            if (fillObject.getString("value") != null) {
                double fillValue = Double.valueOf(fillObject.getString("value"));
                tbFillFormDetail.setFieldValue(fillValue);
            }
            tbFillFormDetail.setFillFormDetailNo(fillFormDetailNo);
            list.add(tbFillFormDetail);
        }
        for (int i = 0; i < autoFillList.size(); i++) {
            JSONObject fillObject = autoFillList.getJSONObject(i);
            String fillFormDetailNo = fillObject.getString("no");
            TbFillFormDetail tbFillFormDetail = new TbFillFormDetail();
            if (fillObject.getString("value") != null) {
                double fillValue = Double.valueOf(fillObject.getString("value"));
                tbFillFormDetail.setFieldValue(fillValue);
            }
            if (fillObject.getString("autoValue") != null) {
                double autoValue = Double.valueOf(fillObject.getString("autoValue"));
                tbFillFormDetail.setAutoValue(autoValue);
            }
            tbFillFormDetail.setFillFormDetailNo(fillFormDetailNo);
            list.add(tbFillFormDetail);
        }
        factoryService.saveFillFormDetail(list);
        return AjaxObject.ok();
    }

    @RequestMapping(value = "/saveTbHyFormDetail", method = RequestMethod.POST)
    public AjaxObject saveTbHyFormDetail(HttpServletRequest request) {

        String[] nodes = request.getParameterValues("node");
        String[] values = request.getParameterValues("value");
        List<TbFillFormDetail> list = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            if (StringUtils.isNotEmpty(nodes[i]) && StringUtils.isNotEmpty(values[i])) {

                double fillValue = Double.valueOf(values[i]);
                String fillFormDetailNo = nodes[i];
                TbFillFormDetail tbFillFormDetail = new TbFillFormDetail();
                tbFillFormDetail.setFieldValue(fillValue);
                tbFillFormDetail.setFillFormDetailNo(fillFormDetailNo);
                list.add(tbFillFormDetail);
            }
        }


        factoryService.saveFillFormDetail(list);
        return AjaxObject.ok();
    }

    /**
     * 确认提交
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/commitFillTask", method = RequestMethod.POST)
    public AjaxObject commitFillTask(HttpServletRequest request, TbFillFormTask tbFillFormTask) {
        factoryService.updateFillFormTask(tbFillFormTask);
        return AjaxObject.ok();
    }

    /**
     * 填报形成tree
     *
     * @param req ,factoryNo
     * @return
     */
    @RequestMapping(value = "/getSynchronizeData", method = RequestMethod.GET)
    public AjaxObject getSynchronizeData(HttpServletRequest req) {
        //查询本地水厂
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        List<TbFactoryInfo> tbFactoryInfoList = factoryService.getTbFactoryInfoList(tbFactoryInfo);
        //取出水厂uri
        List<String> dbUriList = tbFactoryInfoList.stream().map(TbFactoryInfo::getUri).collect(Collectors.toList());
        //查询远端水厂
        BewgQueryRelationofnodes model = new BewgQueryRelationofnodes();
        model.setForward("false");
        model.setMaxSize(100);
        List<String> real = new ArrayList<>();
        real.add("/0/40");
        model.setRelations(real);
        List<String> uri = new ArrayList<>();
        uri.add("/system/1015");
        model.setUris(uri);
        JSONObject jsonObject = bewgService.queryAllFactory(model);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        JSONObject json = jsonArray.getJSONObject(0);
        JSONArray nodes = json.getJSONArray("nodes");
        List<String> serviceUriList = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            JSONObject jsonObject1 = nodes.getJSONObject(i);
            serviceUriList.add(jsonObject1.getJSONObject("nodeValues").getString("uri"));
        }
        System.out.println(serviceUriList.size());
        Map<String, Object> map = new HashMap<>(16);
        return AjaxObject.ok(map);
    }


    /**
     * 数据底稿（查询任务状态完成5 和超时 7）
     *
     * @param request
     * @return
     */
    @GetMapping("/data/draftList")
    public AjaxObject getTbFillFormFieldList(HttpServletRequest request) {
        //tb_fill_form_field
        //填报配置字段（水厂no）
        String factoryNo = request.getParameter("factoryNo");
        TbFillFormField tbFillFormField = new TbFillFormField();
        tbFillFormField.setFactoryNo(factoryNo);
        List<TbFillFormField> topList = this.factoryService.getTbFillFormFieldList(tbFillFormField);
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setFactoryNo(factoryNo);
        List<TbSynObject> tbSynObjects = tbSynObjectService.getTbSynObjectList(tbSynObject, false);
        //获取填报数据的表头
        List<Tree<TbSynObject>> fillTreeList = new ArrayList<>();
        TreeUtils.buildTrees(fillTreeList, tbSynObjects);
        Tree<TbSynObject> fillTree = TreeUtils.build(fillTreeList);
        //获取化验数据的表头
        List<Tree<TbSynObject>> hyTreeList = new ArrayList<>();
        TreeUtils.buildTrees(hyTreeList, tbSynObjects);
        Tree<TbSynObject> hyTree = TreeUtils.build(hyTreeList);

        List<String> idFillList = new ArrayList<>();
        List<TbFillFormField> fillFieldList = new ArrayList<>();
        List<String> idHyList = new ArrayList<>();
        List<TbFillFormField> fillHyList = new ArrayList<>();
        for (TbFillFormField fillFormField : topList) {
            if (fillFormField.getFillType() != null) {
                if (fillFormField.getFillType() == 3) {
                    if (!idHyList.contains(fillFormField.getEquipNo())) {
                        idHyList.add(fillFormField.getEquipNo());
                    }
                    fillHyList.add(fillFormField);
                } else {
                    if (!idFillList.contains(fillFormField.getEquipNo())) {
                        idFillList.add(fillFormField.getEquipNo());
                    }
                    fillFieldList.add(fillFormField);
                }
            }
        }
        TreeUtils.freshSynDataParent(fillTree.getChildren(), idFillList);
        TreeUtils.freshSynDataParent(hyTree.getChildren(), idHyList);
        List<TbFillFormDetail> tbFillFormDetails = workOrderService.selectTbFillFormDetailByFactroyNo(factoryNo);
        List<List<TbFillFormDetail>> fillDetailMap = new ArrayList<>();
        List<String> fillKeyList = new ArrayList<>();
        List<List<TbFillFormDetail>> hyDetailMap = new ArrayList<>();
        List<String> hyKeyList = new ArrayList<>();
        for (TbFillFormDetail tbFillFormDetail : tbFillFormDetails) {
            if (tbFillFormDetail.getType() == 3) {
                getKeyList(hyDetailMap, hyKeyList, tbFillFormDetail);
            } else {
                getKeyList(fillDetailMap, fillKeyList, tbFillFormDetail);
            }
        }
        Map<String, Object> fillMap = new HashMap<>(16);
        fillMap.put("title", fillTree);
        fillMap.put("data", fillDetailMap);
        fillMap.put("fieldList", fillFieldList);
        Map<String, Object> hyMap = new HashMap<>(16);
        hyMap.put("title", hyTree);
        hyMap.put("data", hyDetailMap);
        hyMap.put("fieldList", fillHyList);

        Map<String, Object> map = new HashMap(16);
        map.put("fillMap", fillMap);
        map.put("hyMap", hyMap);
        return AjaxObject.ok(map);
    }

    private void getKeyList(List<List<TbFillFormDetail>> fillDetailMap, List<String> keyList, TbFillFormDetail tbFillFormDetail) {
        String key = tbFillFormDetail.getFillTakeTime();
        if (tbFillFormDetail.getType().intValue() == 3) {
            key = tbFillFormDetail.getFillTakeTime().substring(0, 10) + " " + tbFillFormDetail.getTimePoint();
        }
        int index = keyList.indexOf(key);
        if (index < 0) {
            List<TbFillFormDetail> list = new ArrayList<>();
            fillDetailMap.add(list);
            keyList.add(key);
            list.add(tbFillFormDetail);
        } else {
            fillDetailMap.get(index).add(tbFillFormDetail);
        }
    }

    /**
     * 获取填报树
     *
     * @param request
     * @return
     */
    @GetMapping("/getFieldList")
    public AjaxObject getFieldList(HttpServletRequest request, TbFillFormField tbFillFormField, TbSynObject tbSynObject) {
        List<TbSynObject> tbSynObjects = tbSynObjectService.getTbSynObjectList(tbSynObject, false);
        List<TbFillFormField> topList = this.factoryService.getTbFillFormFieldList(tbFillFormField);
        List<Tree<TbSynObject>> fillTreeList = new ArrayList<>();
        TreeUtils.buildTrees(fillTreeList, tbSynObjects);
        Tree<TbSynObject> fillTree = TreeUtils.build(fillTreeList);
        System.out.println(System.currentTimeMillis());
        TreeUtils.addTreeNode(fillTree.getChildren(), topList);
        TreeUtils.clearSpaceNode(fillTree.getChildren());
        System.out.println(System.currentTimeMillis());
        Map resultMap = new HashMap(16);
        resultMap.put("fillTree", fillTree);
        return AjaxObject.ok(resultMap);
    }

    /**
     * 获取日报数据
     *
     * @param request
     * @return
     */
    @GetMapping("/data/getTbFillFormDateList")
    public AjaxObject getTbFillFormDateList(HttpServletRequest request) {
        //tb_fill_form_field
        //填报配置字段（水厂no）
        String factoryNo = request.getParameter("factoryNo");
        TbFillFormField tbFillFormField = new TbFillFormField();
        tbFillFormField.setFactoryNo(factoryNo);
        List<TbFillFormField> topList = this.factoryService.getTbFillFormFieldList(tbFillFormField);
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setFactoryNo(factoryNo);
        List<TbSynObject> tbSynObjects = tbSynObjectService.getTbSynObjectList(tbSynObject, false);
        List<TbFillFormDetail> tbFillFormDetails = workOrderService.selectTbFillFormDetailByFactroyNo(factoryNo);
        TbParameterConfigExtend parameterConfigExtendExample = new TbParameterConfigExtend();
        parameterConfigExtendExample.setFactoryNo(factoryNo);
        List<TbParameterConfigExtend> parameterConfigExtendList = parameterConfigService.getParameterConfigExtendList(parameterConfigExtendExample);
        Map<String, Object> map = new HashMap(16);
        return AjaxObject.ok(map);
    }


    /**
     * 查询填报工单列表
     *
     * @param req
     * @return
     */
    @GetMapping(value = "/findTbFillFormTaskList")
    public AjaxObject findTbFillFormTaskList(HttpServletRequest req, TbFillFormTask tbFillFormTask) {
        logger.info("查询参数tbFillFormTask={}", JSON.toJSON(tbFillFormTask));
        int pageNum = 1;
        int pageSize = 10;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            pageNum = Integer.valueOf(req.getParameter("page"));
            pageSize = Integer.valueOf(req.getParameter("rows"));
        }
        PageHelper.startPage(pageNum, pageSize);
        String beginTime = req.getParameter("beginTime");
        String endTime = req.getParameter("endTime");
        Map map = new HashMap(16);
        try {
            List<TbFillFormTask> tbRoutingInspectionInfos = new ArrayList<>();
            if (tbFillFormTask.getFactoryNo() != null) {
                String[] strs = tbFillFormTask.getFactoryNo().split(",");
                if (strs.length > 1) {
                    tbFillFormTask.setFactoryNo(null);
                    tbRoutingInspectionInfos = workOrderService.findTbFillFormTaskList(tbFillFormTask, beginTime, endTime, Arrays.asList(strs));
                } else {
                    tbRoutingInspectionInfos = workOrderService.findTbFillFormTaskList(tbFillFormTask, beginTime, endTime, null);
                }
            } else {
                tbRoutingInspectionInfos = workOrderService.findTbFillFormTaskList(tbFillFormTask, beginTime, endTime, null);
            }
            PageInfo pageInfo = new PageInfo(tbRoutingInspectionInfos);
            map.put("rows", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
        } catch (Exception e) {
            return AjaxObject.error(e.getMessage());
        }
        return AjaxObject.ok(map);
    }

    @GetMapping(value = "/findHyFillFormTaskList")
    public AjaxObject findHyFillFormTaskList(HttpServletRequest req, TbFillFormTask tbFillFormTask) {
        logger.info("查询参数tbFillFormTask={}", JSON.toJSON(tbFillFormTask));
        TbUser user = super.getUser(req, stringRedisTemplate);
        String beginTime = req.getParameter("beginTime");
        String endTime = req.getParameter("endTime");
        super.setPageInfo(req.getParameter("pageNum"), req.getParameter("pageSize"));
        List<String> factoryNoList = null;
        String[] strs = tbFillFormTask.getFactoryNo().split(",");
        if (strs.length > 1) {
            factoryNoList = Arrays.asList(strs);
            tbFillFormTask.setFactoryNo(null);
        }
        if ("2".equals(tbFillFormTask.getFlag()) || "3".equals(tbFillFormTask.getFlag())) {
            tbFillFormTask.setFillTaskUserNo(user.getCode());
        }
        List<TbFillFormTask> list = workOrderService.findTbFillFormTaskList(tbFillFormTask, beginTime, endTime, factoryNoList);
        return super.getResultObject(list, req.getParameter("pageNum"));

    }

//    /**
//     * 查询填报工单列表0
//     * @param req
//     * @return
//     */
//    @GetMapping(value = "/findSendTbFillFormTaskList")
//    @ResponseBody
//    public AjaxObject findSendTbFillFormTaskList(HttpServletRequest req,TbFillFormTask tbFillFormTask){
//        logger.info("查询参数tbFillFormTask={}",JSON.toJSON(tbFillFormTask));
//        Map map = new HashMap();
//        try {
//            List<TbFillFormTask> tbRoutingInspectionInfos = new ArrayList<>();
//            if(tbFillFormTask.getFillTaskNo()!=null){
//                String[] strs = tbFillFormTask.getFillTaskNo().split(",");
//                if(strs.length>1)
//                    tbRoutingInspectionInfos = workOrderService.findTbFillFormTaskList(tbFillFormTask,beginTime,endTime,Arrays.asList(strs));
//                else{
//                    tbRoutingInspectionInfos= workOrderService.findTbFillFormTaskList(tbFillFormTask,beginTime,endTime,null);
//                }
//            }
//
//            PageInfo pageInfo = new PageInfo(tbRoutingInspectionInfos);
//            map.put("rows",pageInfo.getList());
//            map.put("total",pageInfo.getTotal());
//        } catch (Exception e) {
//            return AjaxObject.error(e.getMessage());
//        }
//        return AjaxObject.ok(map);
//    }

//    /**
//     * 查询待审核填报工单列表4,6
//     * @param req
//     * @return
//     */
//    @GetMapping(value = "/findCheckTbFillFormTaskList")
//    @ResponseBody
//    public AjaxObject findCheckTbFillFormTaskList(HttpServletRequest req,TbFillFormTask tbFillFormTask){
//        logger.info("查询参数tbFillFormTask={}",JSON.toJSON(tbFillFormTask));
//        Map map = new HashMap();
//        try {
//
//            List<TbFillFormTask> tbRoutingInspectionInfos = workOrderService.findTbFillFormTaskList(tbFillFormTask,null,null);
//            PageInfo pageInfo = new PageInfo(tbRoutingInspectionInfos);
//            map.put("rows",pageInfo.getList());
//            map.put("total",pageInfo.getTotal());
//        } catch (Exception e) {
//            return AjaxObject.error(e.getMessage());
//        }
//        return AjaxObject.ok(map);
//    }

    /**
     * 修改状态为 1
     *
     * @param ids 0-1
     * @return
     */
    @PostMapping("/updateTbFillFormTask")
    public AjaxObject updateTbFillFormTaskStatus(String[] ids, String userName, String userCode) {
        logger.info("修改填报工单号参数ids{}", ids);
        try {
            workOrderService.updateTbFillFormTaskStatus(ids, userCode, userName);
            return AjaxObject.ok("修改成功！");
        } catch (Exception e) {
            logger.error("修改失败", e);
            return AjaxObject.error("修改失败，请联系网站管理员！");
        }
    }

    /**
     * 审核通过
     *
     * @param fillTaskNo
     * @return
     */
    @PostMapping("/checkTbFillFormTask")
    public AjaxObject checkTbFillFormTask(HttpServletRequest request, String fillTaskNo) {
        logger.info("审核填报参数fillTaskNo{}", fillTaskNo);

        try {
            int i = workOrderService.checkTbFillFormTask(fillTaskNo, super.getUser(request, this.stringRedisTemplate));
            if (i > 0) {
                return AjaxObject.ok("审核成功！");
            } else {
                return AjaxObject.error("审核失败！");
            }

        } catch (Exception e) {
            logger.error("审核失败", e);
            return AjaxObject.error("审核失败，请联系网站管理员！");
        }
    }

    /**
     * 驳回通过
     *
     * @param fillTaskNo
     * @return
     */
    @PostMapping("/rejectTbFillFormTask")
    public AjaxObject rejectTbFillFormTask(HttpServletRequest request, String fillTaskNo) {
        logger.info("驳回填报参数fillTaskNo{}", fillTaskNo);
        try {
            int i = workOrderService.rejectTbFillFormTask(fillTaskNo, super.getUser(request, this.stringRedisTemplate));
            if (i > 0) {
                return AjaxObject.ok("驳回成功！");
            } else {
                return AjaxObject.error("驳回成功失败！");
            }
        } catch (Exception e) {
            logger.error("驳回失败", e);
            return AjaxObject.error("删除失败，请联系网站管理员！");
        }
    }

    /**
     * PC端临时工单
     *
     * @param req
     * @param tbWorkOrderTemp
     * @return
     */
    @GetMapping(value = "/getTempOrderList")
    @ApiOperation(value = "查询临时工单列表")
    public AjaxObject getTempOrderList(HttpServletRequest req, TbWorkOrderTemp tbWorkOrderTemp) {
        logger.info("查询PC端临时工单={}", JSON.toJSON(tbWorkOrderTemp));
        TbUser user = super.getUser(req, stringRedisTemplate);
        Date beginTime = req.getParameter("beginTime") == null ? null : DateUtils.parseDateFull(req.getParameter("beginTime"));
        Date endTime = req.getParameter("endTime") == null ? null : DateUtils.parseDateFull(req.getParameter("endTime"));
        int finishType = req.getParameter("finishType") == null ? 0 : Integer.valueOf(req.getParameter("finishType"));
        tbWorkOrderTemp.setCreateUser(user.getCode());
        super.setPageInfo(req.getParameter("page"), req.getParameter("rows"));
        List<TbWorkOrderTemp> list = workOrderService.getWorkOrderTempList(tbWorkOrderTemp, beginTime, endTime, finishType);
        return super.getResultObject(list, req.getParameter("page"));
    }

    /**
     * 查询PC端临时工单详情
     *
     * @param req
     * @param orderId
     * @return
     */
    @GetMapping(value = "/getTempOrderDetail")
    @ApiOperation(value = "查询临时工单详情")
    public AjaxObject getTempOrderList(HttpServletRequest req, String orderId) {
        logger.info("查询PC端临时工单详情={}", orderId);
        TbUser user = super.getUser(req, stringRedisTemplate);
        TbWorkOrderTemp orderTempDetail = workOrderService.getWorkOrderTempDetail(orderId);
        return super.getResultObjectAlone(orderTempDetail);
    }

    /**
     * APP端临时工单列表
     *
     * @param req
     * @param tbWorkOrderTemp
     * @return
     */
    @GetMapping(value = "/getAppTempWorkOrderList")
    @ApiOperation(value = "获取我的临时工单")
    public AjaxObject getAppTempWorkOrderList(HttpServletRequest req, TbWorkOrderTemp tbWorkOrderTemp) {
        logger.info(" APP端临时工单列表TbWorkOrderTemp={}", JSON.toJSON(tbWorkOrderTemp));
        TbUser user = super.getUser(req, stringRedisTemplate);
        tbWorkOrderTemp.setOrderDuty(user.getCode());
        List<TbWorkOrderTemp> list = workOrderService.getWorkOrderTempList(tbWorkOrderTemp, null, null, 1);
        return super.getResultObject(list, null);
    }

    /**
     * pc新增临时工单
     *
     * @param req
     * @param tbWorkOrderTemp
     * @return
     */
    @PostMapping(value = "/addTempWorkOrder")
    @ApiOperation(value = "新建临时工单")
    public AjaxObject addTempWorkOrder(HttpServletRequest req, TbWorkOrderTemp tbWorkOrderTemp) {
        logger.info("pc新增临时工单TbWorkOrderTemp={}", JSON.toJSON(tbWorkOrderTemp));
        String orderEndTime = req.getParameter("orderEndTime");
        TbUser user = super.getUser(req, stringRedisTemplate);
        tbWorkOrderTemp.setCreateUser(user.getCode());
        tbWorkOrderTemp.setCreateUserName(user.getName());
        tbWorkOrderTemp.setOrderId(StringTools.getUUID());
        tbWorkOrderTemp.setOrderEndTime(DateUtils.parseDateFull(orderEndTime));
        tbWorkOrderTemp.setOrderCode(DateUtils.formateDate("yyyyMMddHHmmss"));
        if (workOrderService.addWorkOrderTemp(tbWorkOrderTemp) > 0) {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.YES);
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.UNKONWN);
        }
    }

    /**
     * APP提交临时工单
     *
     * @param req
     * @param tbWorkOrderTemp
     * @return
     */
    @PostMapping(value = "/updateTempWorkOrder")
    @ApiOperation(value = "修改临时工单状态")
    public AjaxObject updateTempWorkOrder(HttpServletRequest req, TbWorkOrderTemp tbWorkOrderTemp) {
        logger.info("APP提交临时工单TbWorkOrderTemp={}", JSON.toJSON(tbWorkOrderTemp));
        TbUser user = super.getUser(req, stringRedisTemplate);
        tbWorkOrderTemp.setOrderFinishTime(new Date());
        //设置完成时间
        if (workOrderService.updateWorkOrderTemp(tbWorkOrderTemp) > 0) {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.YES);
        } else {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.UNKONWN);
        }
    }

    
}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.bean.CodeModel;
import com.ejobim.opplat.domain.condition.TbRoutingModelCondition;
import com.ejobim.opplat.domain.condition.TbRoutingTaskConditon;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.domain.vo.RoutingLocationVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationElementVo;
import com.ejobim.opplat.domain.vo.TbRoutingLocationFillElementVo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.notify.NoticeService;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ??????????????????
 * @author  xibian
 */
@Api(tags = "????????????????????????")
@RestController
@RequestMapping("/routing")
public class RoutingController  extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoutingService routingService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private TbSynObjectService tbSynObjectService;
    @Autowired
    private TbParameterConfigMapper parameterConfigMapper;

    @Autowired
    private TbSchedulingPlanDeatailMapper tbSchedulingPlanDeatailMapper;

    @Autowired
    private NoticeService noticeService;
    
    @Autowired
    private TbRoutingTaskMapper routingTaskMapper;

    @Autowired
    private TbRoutingTaskDetailMapper tbRoutingTaskDetailMapper;

    @Autowired
    private TbRoutingLocationMapper routingLocationMapper;

    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;
    
    @Autowired
    private TbSysUseService tbSysUseService;
    
    @Autowired
    private ParameterConfigService parameterConfigService;

    @Autowired
    private EquipService equipService;

    @Autowired
    private SchedulingService schedulingService;

    /**
     * ???????????????????????????
     * @param request
     * @param routingLocation
     * @return
     */
    @GetMapping("/getRoutingLocationList")
    @ApiOperation(value = "?????????????????????")
    public AjaxObject getRoutingLocationList(HttpServletRequest request, TbRoutingLocation routingLocation) {
        logger.info("?????????????????????={}", JSON.toJSONString(routingLocation));
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbRoutingLocation> list = routingService.getRoutingLocationList(routingLocation);
        return super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * ??????????????????????????????
     * @param request
     * @param routingLocation
     * @return
     */
    @PostMapping("/addRoutingLocation")
    @ApiOperation(value = "???????????????")
    public AjaxObject saveRoutingLocation(HttpServletRequest request,TbRoutingLocation routingLocation){
        AjaxObject ajaxObject = new AjaxObject();
        logger.info("??????????????????????????????TbRoutingLocation={}", JSON.toJSONString(routingLocation));
        int returnCode = 0;
           TbUser user = super.getUser(request,stringRedisTemplate);
           String msg = "";
           if(StringUtils.isNotEmpty(routingLocation.getLocationNo())){
               routingLocation.setUpdateUser(user.getName());
               returnCode = routingService.updateRoutingLocation(routingLocation);
           }else{
               routingLocation.setCreateUser(user.getName());
               returnCode = routingService.insertRoutingLocation(routingLocation);
           }
            if(returnCode==1) {
                ajaxObject =AjaxObject.ok("??????");
            }else{
                ajaxObject =  AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));
            }
        return  ajaxObject;

    }

    /**
     * ???????????????
     * @param request
     * @param routingLocation
     * @return
     */
    @PostMapping("/deleteRoutingLocation")
    @ApiOperation(value = "???????????????")
    public AjaxObject deleteRoutingLocation(HttpServletRequest request,TbRoutingLocation routingLocation){
        logger.info("???????????????TbRoutingLocation={}", JSON.toJSONString(routingLocation));
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(routingService.deleteRoutingLocation(routingLocation, user.getName())>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }
    }
    /**
     * ??????????????????
     * @param request
     * @param routingLocation
     * @return
     */
    @PostMapping("/deleteRoutingElementLocation")
    @ApiOperation(value = "??????????????????")
    public AjaxObject deleteRoutingElementLocation(HttpServletRequest request,TbRoutingLocationElement routingLocation){
        logger.info("??????????????????TbRoutingLocation={}", JSON.toJSONString(routingLocation));
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(routingService.deleteTbRoutingLocationElement(routingLocation, user.getName())>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }

    }

    /**
     * ???????????????????????????
     * @param request
     * @param routingNo,equipName
     * @return
     */
    @GetMapping("/getRoutingLocationEquipList")
    @ApiOperation(value = "?????????????????????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "routingNo", value = "?????????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "equipName", value = "????????????", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject getRoutingLocationEquipList( HttpServletRequest request ,String routingNo, String equipName) {
        logger.info("???????????????????????????routingNo={}", routingNo);
        List<TbRoutingLocatioinEquip> list = routingService.getRoutingEquipList(routingNo,equipName);
        return super.getResultObject(list,null);
    }

    /**
     * ????????????
     * @param request
     * @param equipNos
     * @param locationNo
     * @return
     */
    @PostMapping("/addRoutingEquipList")
    @ApiOperation(value = "???????????????????????????")
    public AjaxObject addRoutingEquipList(HttpServletRequest request,String equipNos,String locationNo){
        logger.info("????????????equipNos={},equipNos={}", equipNos,locationNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        int returnCode =  routingService.addRoutingEquipList(locationNo,equipNos.split(","),user.getCode());
        if(returnCode>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }
    }

    /**
     * ?????????????????????
     * @param request
     * @param locationEquipNos
     * @param locationNo
     * @return
     */
    @PostMapping("/deleteRoutingLocationEquip")
    @ApiOperation(value = "???????????????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "locationEquipNos", value = "???????????????????????????", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "locationNo", value = "???????????????",  dataType = "string", paramType = "query")
    })
    public AjaxObject deleteRoutingLocationEquip(HttpServletRequest request,String locationEquipNos,String locationNo){
        logger.info("?????????????????????locationEquipNos={},equipNos={}", locationEquipNos,locationNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(routingService.deleteRoutingEquipList(locationNo,locationEquipNos.split(","),user.getCode())>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }

    }

    /**
     * ???????????????
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getRoutingInfoTree")
    @ApiOperation(value = "????????????????????????????????????")
    public AjaxObject getRoutingInfoTree(HttpServletRequest request, String factoryNo) {
        logger.info("?????????????????????factoryNo={}", factoryNo);
        TbRoutingLocation routingLocation = new TbRoutingLocation();
        routingLocation.setFactoryNo(factoryNo);
        routingLocation.setSource(0);
        List<TbRoutingLocation> list = routingService.getRoutingLocationList(routingLocation);
        if(list.size()>0){
            List<String> locationNoList =  list.stream().map(obj -> obj.getLocationNo()).collect(Collectors.toList());
            List<TbRoutingLocatioinEquip> equipList = routingService.getRoutingEquipListByIds(locationNoList);
            for(TbRoutingLocatioinEquip equip:equipList){
                for(TbRoutingLocation tbRoutingLocation:list){
                    if(tbRoutingLocation.getLocationNo().equals(equip.getRoutingNo())){
                        tbRoutingLocation.getEquipList().add(equip);
                    }
                }
            }
        }

        return super.getResultObject(list,null);
    }

    /**
     * ??????????????????
     * @param request
     * @param routingLocationElement
     * @return
     */
    @GetMapping("/getRoutingElementList")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject getRoutingElementList(HttpServletRequest request, TbRoutingLocationElement routingLocationElement) {
        logger.info("??????????????????RoutingLocationElement={},url={},controller={}", JSON.toJSONString(routingLocationElement),"/getRoutingElementList","RoutingController");
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        String parentType = request.getParameter("parentType");
        List<TbRoutingLocationElement> list = routingService.getRoutingElementList(routingLocationElement,null);
        return super.getResultObject(list,request.getParameter("page"));

    }
    
    /**
     * ????????????????????????
     * @param request
     * @param routingLocationElement
     * @return
     */
    @PostMapping("/addRoutingElement")
    @ApiOperation(value = "?????????????????????")
    public AjaxObject addRoutingElement(HttpServletRequest request,TbRoutingLocationElement routingLocationElement){
        logger.info("????????????????????????RoutingLocationElement={}", JSON.toJSONString(routingLocationElement));
        TbUser user = super.getUser(request,stringRedisTemplate);
        routingLocationElement.setCreateTime(new Date());
        routingLocationElement.setCreateUser(user.getName());
        routingLocationElement.setDeleteFlag(0);
        routingLocationElement.setLocationFieldNo(StringTools.getUUID());
        if(StringUtils.isNotEmpty(routingLocationElement.getFieldNo())){
            TbParameterConfig parameterConfig = parameterConfigMapper.selectByPrimaryKey(routingLocationElement.getFieldNo());
            routingLocationElement.setFieldUnit(parameterConfig.getParamUnit());
        }
        int flag = routingService.insertTbRoutingLocationElement(routingLocationElement);
        if(flag==1){
            return AjaxObject.ok();
        }else{
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
        }
    }

    /**
     * ??????????????????
     * @param request
     * @param routingLocationElement
     * @return
     */
    @PostMapping("/updateRoutingElement")
    @ApiOperation(value = "??????????????????")
    public AjaxObject updateRoutingElement(HttpServletRequest request,TbRoutingLocationElement routingLocationElement){
        logger.info("??????????????????RoutingLocationElement={}", JSON.toJSONString(routingLocationElement));
        TbParameterConfig parameterConfig = parameterConfigMapper.selectByPrimaryKey(routingLocationElement.getFieldNo());
        if(parameterConfig!=null){
            routingLocationElement.setFieldUnit(parameterConfig.getParamUnit());
        }
        int flag =routingService.updateTbRoutingLocationElement(routingLocationElement);
        if(flag==1){
            return AjaxObject.ok();
        }else{
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
        }

    }

    /**
     * ???????????????????????????
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getFactoryAutoFields")
    @ApiOperation(value = "?????????????????????????????????")
    public AjaxObject getFactoryAutoFields(HttpServletRequest request,String factoryNo){
        logger.info("???????????????????????????factoryNo={}",factoryNo);
        Tree<TbSynObject> tree=  tbSynObjectService.findTreeLists(factoryNo,0,2,1);
        Map<String,Object> resultMap = new HashMap<>(2);
        resultMap.put("tree",tree);
        return AjaxObject.ok(resultMap);
    }

    /**
     * ????????????????????????
     * @param request
     * @param routingModel
     * @return
     */
    @GetMapping("/getRoutingModelList")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject getRoutingModelList(HttpServletRequest request, TbRoutingModel routingModel) {
        logger.info("????????????????????????={}", JSON.toJSONString(routingModel));
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        routingModel.setSource(0);
        List<TbRoutingModel> list = routingService.getRoutingModelList(routingModel);
        return super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * ??????????????????
     * @param request
     * @param routingModel
     * @return
     */
    @PostMapping("/addRoutingModel")
    @ApiOperation(value = "??????????????????")
    public AjaxObject addRoutingModel(HttpServletRequest request, TbRoutingModel routingModel) {
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        routingModel.setCreateUser(user.getName());
        routingModel.setUpdateUser(user.getName());
        try {
            logger.info("??????????????????={}", JSON.toJSONString(routingModel));
            int flag  = routingService.addRoutingModel(routingModel);
            if(flag==1){
                ajaxObject =AjaxObject.ok("????????????");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("???????????????????????????e={}", e.getMessage());
            AjaxObject.error(e.getMessage());
        }
        return ajaxObject;

    }

    /**
     * ??????????????????
     * @param request
     * @param routingModel
     * @return
     */
    @PostMapping("/updateRoutingModel")
    @ApiOperation(value = "??????????????????")
    public AjaxObject updateRoutingModel(HttpServletRequest request, TbRoutingModel routingModel) {
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        routingModel.setUpdateUser(user.getName());
        try {
            logger.info("??????????????????TbRoutingModel={}", JSON.toJSONString(routingModel));
            int flag  = routingService.updateRoutingModel(routingModel);
            if(flag==1){
                ajaxObject =AjaxObject.ok("????????????");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("??????/????????????????????????e={}", e.getMessage());
            AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }

    /**
     * ??????????????????
     * @param request
     * @param routingModel
     * @return
     */
    @PostMapping("/deleteRoutingModel")
    @ApiOperation(value = "??????????????????")
    public AjaxObject deleteRoutingModel(HttpServletRequest request, TbRoutingModel routingModel) {
        logger.info("??????????????????TbRoutingModel={}", JSON.toJSONString(routingModel));
        TbUser user = super.getUser(request,stringRedisTemplate);
        int resultCode  = routingService.deleteRoutingModel(routingModel);
        if(resultCode>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }
    }
    /**
     * ???????????????
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getRoutingTree")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject getRoutingTree(HttpServletRequest request,String factoryNo){
        logger.info("???????????????factoryNo={}", JSON.toJSONString(factoryNo));
        TbRoutingLocation routingLocation = new TbRoutingLocation();
        routingLocation.setFactoryNo(factoryNo);
        List<TbRoutingLocation> list = routingService.getRoutingLocationList(routingLocation);
        List<String> locationNoList =  list.stream().map(obj -> obj.getLocationNo()).collect(Collectors.toList());
        List<TbRoutingLocatioinEquip> equipList = routingService.getRoutingEquipListByIds(locationNoList);
        TbRoutingLocationElement routingLocationElement = new TbRoutingLocationElement();
        routingLocationElement.setFactoryNo(factoryNo);
        List<TbRoutingLocationElement> elementList = routingService.getRoutingElementList(routingLocationElement,null);
        for(TbRoutingLocation tbRoutingLocation:list){
            for(TbRoutingLocatioinEquip equip:equipList){
                if(tbRoutingLocation.getLocationNo().equals(equip.getRoutingNo())){
                    if(tbRoutingLocation.getEquipList()==null){
                        tbRoutingLocation.setEquipList(new ArrayList<>());
                    }
                    tbRoutingLocation.getEquipList().add(equip);
                }
            }
            for(TbRoutingLocationElement element:elementList){
                if(element.getParentNo()!=null){
                    if(element.getParentNo().equals(tbRoutingLocation.getLocationNo())){
                        tbRoutingLocation.getElementList().add(element);
                    }
                }
            }
        }
        for(TbRoutingLocatioinEquip equip:equipList){
            for(TbRoutingLocationElement element:elementList) {
                if (element.getParentNo().equals(equip.getEquipNo())) {
                    if (equip.getElementList() == null) {
                        equip.setElementList(new ArrayList<>());
                    }
                    equip.getElementList().add(element);
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("tree",list);
        return AjaxObject.ok(map);
    }

    /**
     * ????????????????????????
     * @param request
     * @param modelNo
     * @return
     */
    @GetMapping("/getRoutingModelExtends")
    @ApiOperation(value = "???????????????????????????")
    public AjaxObject getRoutingModelExtends(HttpServletRequest request,String modelNo){
        logger.info("????????????????????????ModelNo={}", JSON.toJSONString(modelNo));
        List<TbRoutingModelExtend> modelExtends = routingService.getRoutingModelExtends(modelNo);
        return  super.getResultObject(modelExtends,null);
    }
    /**
     * ??????????????????
     * @param request
     * @param postJSON
     * @return
     */
    @PostMapping("/changeRoutingModelExtends")
    @ApiOperation(value = "???????????????????????????")
    public AjaxObject changeRoutingModelExtends(HttpServletRequest request, @RequestBody JSONObject postJSON){
        JSONArray addElements = postJSON.getJSONArray("elements");
        JSONArray delElements = postJSON.getJSONArray("delElements");
        String  modelNo  =postJSON.getString("modelNo");
        TbRoutingLocationElement[] elements = new TbRoutingLocationElement[addElements.size()];
        for(int i=0;i<addElements.size();i++){
            JSONObject jsonObject =addElements.getJSONObject(i);
            TbRoutingLocationElement routingLocationElement = new TbRoutingLocationElement();
            routingLocationElement.setElementType(jsonObject.getIntValue("elementType"));
            routingLocationElement.setLocationFieldNo(jsonObject.getString("elementNo"));
            routingLocationElement.setLocationNo(jsonObject.getString("locationNo"));
            routingLocationElement.setEquipNo(jsonObject.getString("equipNo"));
            elements[i] = routingLocationElement;
        }
        String[] delElementNos = new String[delElements.size()];
        for(int i=0;i<delElements.size();i++){
            delElementNos[i] = delElements.get(i).toString();
        }
        int returnCode = routingService.changeRoutingModelExtends(modelNo,elements,delElementNos);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(returnCode));

    }

    /**
     * pc????????????????????????
     * @param request
     * @param routingTaskQ
     * @return
     */
    @GetMapping("/getRoutingTaskList")
    @ApiOperation(value = "???????????????????????????")
    public AjaxObject getRoutingTaskList(HttpServletRequest request,TbRoutingTask routingTaskQ){
        logger.info("pc????????????????????????={}", JSON.toJSONString(routingTaskQ));
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        if(routingTaskQ.getEndTime()==null){
            routingTaskQ.setEndTime(DateUtils.getNextDate(DateUtils.formateDate(new Date())));
        }
        List<TbRoutingTask> list = routingService.getRoutingTaskList(routingTaskQ);
        return super.getResultObject(list,request.getParameter("page"));
    }
    

    /**
     * pc????????????????????????
     * @param request
     * @param beginDate
     * @param endDate
     * @param modelNo
     * @return
     */
    @PostMapping("/addRoutingTask")
    @ApiOperation(value = "??????????????????")
    public AjaxObject addRoutingTask(HttpServletRequest request,Date beginDate,Date endDate,String modelNo){
        logger.info("pc????????????????????????/??????beginDate={},endDate={},modelNo={}",beginDate ,endDate,modelNo);
        TbUser tbUser = super.getUser(request,stringRedisTemplate);
        int resultCode = routingService.addRoutingTaskList(beginDate,endDate,modelNo,tbUser);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }
    
    ///////////////////////////////////////////
    //APP????????????
    /**
     * ???????????????????????????????????????
     * @param request
     * @param routingTaskQ
     * @return
     */
    @GetMapping("/getMyRoutingTaskList")
    @ApiOperation(value = "???????????????????????????")
    public AjaxObject getMyRoutingTaskList(HttpServletRequest request,TbRoutingTask routingTaskQ){
        logger.info("app??????????????????????????????????????????TbRoutingTask={}", JSON.toJSONString(routingTaskQ));
        TbUser user = super.getUser(request,stringRedisTemplate);
        Map<String,Object> map = routingService.getMyRoutingTaskList(user,routingTaskQ);
        return AjaxObject.ok(map);
    }

    /**
     * ??????????????????
     * @param request
     * @param routingTask
     * @return
     */
    @PostMapping("/startRoutingTask")
    @ApiOperation(value = "????????????")
    public AjaxObject startRoutingTask(HttpServletRequest request,TbRoutingTask routingTask){
        logger.info("??????????????????TbRoutingTask={}", JSON.toJSONString(routingTask));
        TbUser tbUser = super.getUser(request,stringRedisTemplate);
        routingTask.setCommitUser(tbUser.getName());
        int resultCode = routingService.startRoutingTask(routingTask);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    /**
     * ????????????
     * @param request
     * @param taskNo
     * @return
     */
    @PostMapping("/cancelRoutingTask")
    @ApiOperation(value = "??????????????????")
    public AjaxObject cancelRoutingTask(HttpServletRequest request,String taskNo){
        logger.info("????????????????????????TbRoutingTask={}", taskNo);
        TbUser tbUser = super.getUser(request,stringRedisTemplate);
        int resultCode = routingService.cancelRoutingTask(taskNo,tbUser.getName());
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    /**
     * ????????????????????????
     * @param request
     * @param routingTask
     * @return
     */
    @PostMapping("/finishRoutingTask")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject finishRoutingTask(HttpServletRequest request,TbRoutingTask routingTask){
        logger.info("????????????????????????TbRoutingTask={}", JSON.toJSONString(routingTask));
        TbUser tbUser = super.getUser(request,stringRedisTemplate);
        routingTask.setCommitUser(tbUser.getName());
        routingTask.setCommitUserCode(tbUser.getCode());
        int resultCode = routingService.finishRoutingTask(routingTask);
        if(resultCode==0){
            TbRoutingTask oldRoutingTask = routingTaskMapper.selectByPrimaryKey(routingTask.getTaskNo());
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(oldRoutingTask.getFactoryNo());
            sendCreateUser(oldRoutingTask,tbFactoryInfo);
        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }
    //??????????????????????????????
    public void sendCreateUser(TbRoutingTask oldRoutingTask,TbFactoryInfo tbFactoryInfo){
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0]=oldRoutingTask.getCreateUserCode();
            params.targets =codes;
            params.title="??????????????????";
            params.body="?????????????????????????????????????????????????????????????????????";
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",1);
            extParameters.put("factoryNo",tbFactoryInfo.getFactoryNo());
            extParameters.put("factoryName",tbFactoryInfo.getFactoryName());
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("????????????????????????Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("????????????????????????????????????userName={}", oldRoutingTask.getCreateUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ???????????????????????????????????????
     * @param request
     * @param routingTask
     * @return
     */
    @GetMapping("/getTaskRoutingLocationList")
    @ApiOperation(value = "??????????????????????????????????????????")
    public AjaxObject getTaskRoutingLocationList(HttpServletRequest request,TbRoutingTask routingTask){
        logger.info("app???????????????????????????????????????TbRoutingTask={}",JSON.toJSONString(routingTask));
        List<RoutingLocationVo> list = routingService.getTaskRoutingLocationList(routingTask);
        return super.getResultObject(list,null);
    }


    /**
     * ????????????????????????NO??????????????????
     * @param request
     * @param taskNo
     * @param locationNo
     * @return
     */
    @GetMapping("/getRoutingTaskDetailByLocation")
    @ApiOperation(value = "?????????????????????????????????")
    public AjaxObject getRoutingTaskDetailByLocation(HttpServletRequest request,String taskNo,String locationNo){
        logger.info("????????????????????????NO??????????????????taskNo={},locationNo={}",taskNo,locationNo);
        Map<String,Object>  detailMap = routingService.getRoutingTaskDetailByLocation(taskNo,locationNo);
        return AjaxObject.ok(detailMap);
    }

    /**
     * ??????????????????
     * @param request
     * @param postJSON
     * @return
     */
    @PostMapping("/saveRoutingTaskDetail")
    @ApiOperation(value = "??????????????????????????????")
    public AjaxObject saveRoutingTaskDetail(HttpServletRequest request, @RequestBody JSONObject postJSON){
        logger.info("??????????????????JSONObject={}",postJSON);
        JSONArray elementList = postJSON.getJSONArray("elementList");
        JSONArray fillList = postJSON.getJSONArray("fillList");
        List<TbRoutingTaskDetail> taskDetailList = new ArrayList<>();
        for(int i=0;i<elementList.size();i++){
            JSONObject json = elementList.getJSONObject(i);
            TbRoutingTaskDetail routingTaskDetail = new TbRoutingTaskDetail();
            routingTaskDetail.setTaskDetailNo(json.getString("taskNo"));
            routingTaskDetail.setRoutingStatus(Integer.valueOf(json.getIntValue("status")));
            routingTaskDetail.setCommitTime(new Date());
            taskDetailList.add(routingTaskDetail);
        }
        for(int i=0;i<fillList.size();i++){
            JSONObject json = fillList.getJSONObject(i);
            if(!json.containsKey("fillValue")||"".equals(json.get("fillValue").toString())){
                continue;
            }
            TbRoutingTaskDetail routingTaskDetail = new TbRoutingTaskDetail();
            routingTaskDetail.setTaskDetailNo(json.getString("taskNo"));
            routingTaskDetail.setRoutingStatus(1);
            routingTaskDetail.setCommitTime(new Date());
            routingTaskDetail.setFillValue(json.getDoubleValue("fillValue"));
            if(json.containsKey("autoValue")){
                routingTaskDetail.setAutoValue(StringTools.formatDouble(json.getDoubleValue("autoValue"),2));
            }
            taskDetailList.add(routingTaskDetail);
        }
        int resultCode = routingService.updateRoutingTaskDetailList(taskDetailList);
        if(resultCode!=0){
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        }else{
            resultCode = routingService.updateLocationTrajectory(taskDetailList.get(0));
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        }
    }

    /**
     * ?????????????????????????????????
     * @param taskNo
     * @return
     */
    @GetMapping("/getRoutingTrajectoryList")
    @ApiOperation(value = "?????????????????????????????????")
    public AjaxObject getRoutingTrajectoryList(String taskNo){
        List<TbRoutingTrajectory> list =  routingService.getRoutingTrajectorylList(taskNo);
        return super.getResultObject(list,null);
    }

    /**
     * ??????????????????
     * @param req
     * @return
     */
    @RequestMapping(value = "/saveRoutingError",method = RequestMethod.POST)
    @ApiOperation(value = "??????????????????")
    public AjaxObject saveRoutingError(HttpServletRequest req ){
        TbUser user = super.getUser(req,stringRedisTemplate);
        String taskNo = req.getParameter("taskNo");
        String routingErrTextInfo = req.getParameter("routingErrTextInfo");
        String pictures = req.getParameter("pictures");
        String videos = req.getParameter("videos");
        String audios = req.getParameter("audios");
        TbRoutingTaskDetail detail = tbRoutingTaskDetailMapper.selectByPrimaryKey(taskNo);
        TbEquipFaultInfo tbEquipFaultInfo = new TbEquipFaultInfo();
        tbEquipFaultInfo.setErrorNo(StringTools.getUUID());
        tbEquipFaultInfo.setErrorAudio(audios);
        tbEquipFaultInfo.setErrorFrom(1);
        tbEquipFaultInfo.setErrorContent(routingErrTextInfo);
        tbEquipFaultInfo.setErrorPictures(pictures);
        tbEquipFaultInfo.setErrorVideo(videos);
        tbEquipFaultInfo.setErrorLocation(detail.getLocationNo());
        tbEquipFaultInfo.setReportUserCode(user.getCode());
        tbEquipFaultInfo.setReportUserName(user.getName());
        tbEquipFaultInfo.setDetailTaskNo(taskNo);
        logger.info("app?????????????????????tbEquipFaultInfo={}",JSON.toJSONString(tbEquipFaultInfo));
        int resultCode = routingService.addRoutingErrorInfo(tbEquipFaultInfo);
        if(resultCode==0){

            TbRoutingTask oldRoutingTask = routingTaskMapper.selectByPrimaryKey(detail.getTaskNo());
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(oldRoutingTask.getFactoryNo());
            //????????????
            if(tbFactoryInfo!=null){
                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                condition.setFactoryUri(tbFactoryInfo.getUri());
                //    private Integer type; 0:?????? 1:???????????? 2,???????????? 3 ???????????? SCYXJL ???????????? SCSBJL
                condition.setType(3);
                List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
                List<String> userCodeList = tbUserList.stream().map(e -> e.getCode()).collect(Collectors.toList());
                if(tbUserList!=null && tbUserList.size()>0){
                    if(userCodeList.contains(oldRoutingTask.getCreateUserCode())){
                        sendCreateRoutingTask(oldRoutingTask,tbFactoryInfo);
                    }else {
                        sendCreateRoutingTask(oldRoutingTask,tbFactoryInfo);
                       // sendBanRoutingTask(tbUserList,tbFactoryInfo,oldRoutingTask);
                    }
                }else {
                    //????????????
                    sendCreateRoutingTask(oldRoutingTask,tbFactoryInfo);
                }
            }
            
        }
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    //??????????????????????????????
    public void sendCreateRoutingTask(TbRoutingTask oldRoutingTask,TbFactoryInfo tbFactoryInfo){
        try {
            //'0:????????????1:????????????',
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0]=oldRoutingTask.getCreateUserCode();
            params.targets =codes;
            if(oldRoutingTask.getTempStatus()==0){
                params.title="????????????";
                params.body="?????????????????????????????????????????????????????????????????????";
            }else {
                params.title="????????????";
                params.body="?????????????????????????????????????????????????????????????????????";
            } 
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",2);
            extParameters.put("factoryNo",tbFactoryInfo.getFactoryNo());
            extParameters.put("factoryName",tbFactoryInfo.getFactoryName());
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("????????????????????????Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("????????????????????????????????????userName={}", oldRoutingTask.getCreateUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //????????????????????????/??????????????????
    public void sendBanRoutingTask(List<TbUser> userList,TbFactoryInfo tbFactoryInfo,TbRoutingTask oldRoutingTask){
        try {
            //'0:????????????1:????????????',
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userCodeList = userList.stream().map(e -> e.getCode()).collect(Collectors.toList());
            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            String[] codes = new String[userCodeList.size()];
            userCodeList.toArray(codes);
            params.targets =codes;
            if(oldRoutingTask.getTempStatus()==0){
                params.title="????????????";
                params.body="?????????????????????????????????????????????????????????????????????";
            }else {
                params.title="????????????";
                params.body="?????????????????????????????????????????????????????????????????????";
            }
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",1);
            if(tbFactoryInfo!=null){
                extParameters.put("factoryNo",tbFactoryInfo.getFactoryNo());
                extParameters.put("factoryName",tbFactoryInfo.getFactoryName());
            }
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("????????????????????????Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info(params.title+"??????????????????userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * ????????????NO??????????????????
     * @param req
     * @return
     */
    @RequestMapping(value = "/getRoutingErrorDetail",method = RequestMethod.GET)
    @ApiOperation(value = "????????????????????????????????????????????????")
    public AjaxObject getRoutingErrorDetail(HttpServletRequest req ){
        String errorNo = req.getParameter("errorNo");
        logger.info("????????????NO??????????????????={}",errorNo);
        TbEquipFaultInfo equipFaultInfo = routingService.getRoutingErrorDetail(errorNo);
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("errorInfo",equipFaultInfo);
        return AjaxObject.ok(errorMap);
    }

    @RequestMapping(value="/getRoutingTaskDetail",method = RequestMethod.GET)
    @ApiOperation(value = "????????????????????????????????????????????????")
    public AjaxObject getRoutingTaskDetail(String taskNo){
        logger.info("pc????????????????????????taskNo={}",taskNo);
        List<TbRoutingLocation> routingTaskDetailList = routingService.getRoutingTaskDetailList(taskNo);
        return super.getResultObject(routingTaskDetailList,null);
    }

    /**
     * ??????????????????
     * @param taskNo
     * @return
     */
    @RequestMapping(value="/getRoutingTaskDetailInfo",method = RequestMethod.GET)
    @ApiOperation(value = "?????????????????????????????????")
    public AjaxObject getRoutingTaskDetailInfo(String taskNo){
        List<TbRoutingTaskDetail> routingTaskDetailList = routingService.getRoutingDetailList(taskNo);
        return super.getResultObject(routingTaskDetailList,null);
    }

    /**
     * ?????????????????????????????????
     * @param routingNo
     * @return
     */
    @GetMapping("/getRotuingLocationDetailInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "routingNo", value = "?????????no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getRotuingLocationDetailInfo(HttpServletRequest request, String routingNo){
        logger.info("?????????????????????????????????routingNo={}", routingNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        Map<String,Object> map = routingService.getRoutingLocationDetailInfo(user,routingNo);
        return AjaxObject.ok(map);
    }


    /**
     * ??????nfcNo????????????????????????????????????id
     * @param nfcNo
     * @return
     */
    @GetMapping("/getRotuingLocationByNfcDetailInfo")
    @ApiOperation(value = "??????NFC???????????????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "??????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nfcNo", value = "nfcNo", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getRoutingLocationByNfcDetailInfo(HttpServletRequest request, String nfcNo,String factoryNo){
        Map<String,Object> map = new HashMap<>(16);
        logger.info("??????nfcNo????????????????????????????????????id??????nfcNo={},factoryNo={}",nfcNo,factoryNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        //??????nfcNo???????????????no
        if(nfcNo!=null){
            TbNfcInfo tbNfcInfo = routingService.getNfcInfo(nfcNo);
            if(tbNfcInfo!=null){
                //??????
                if(tbNfcInfo.getNodeType()==1){
                    TbEquipInfo equipInfo = equipService.getEquipInfo(tbNfcInfo.getNodeId());
                    if(equipInfo==null){
                        return AjaxObject.error("????????????????????????????????????");
                    }
                    if(!equipInfo.getFactoryNo().equals(factoryNo)){
                        return AjaxObject.error("??????????????????????????????????????????");
                    }
                }else  if(tbNfcInfo.getNodeType()==2){
                    TbRoutingLocation routingLocation = routingLocationMapper.selectByPrimaryKey(tbNfcInfo.getNodeId());
                    if(routingLocation==null){
                        return AjaxObject.error("???????????????????????????????????????");
                    }
                    if(!routingLocation.getFactoryNo().equals(factoryNo)){
                        return AjaxObject.error("??????????????????????????????????????????");
                    }
                }
                map.put("nodeType",tbNfcInfo.getNodeType());
                map.put("nodeId",tbNfcInfo.getNodeId());
                return AjaxObject.ok(map);
            }else {
                return AjaxObject.error("?????????????????????");
            }
        }else {
            return AjaxObject.error("???????????????ID");
        }
    }
    /**
     * ????????????????????????????????????
     * @param request,response,equipNos
     * @return
     */
    @GetMapping("/getRoutingLocationViewQR")
    @ApiOperation(value = "???????????????????????????")
    public void getRoutingLocationViewQR(HttpServletRequest request, HttpServletResponse response,String[] locationNos){
        logger.info("??????????????????????????????????????????locationNos={}", JSON.toJSONString(locationNos));
        List<TbRoutingLocation> list =routingService.selectRoutingLocationList(locationNos);
       // List<TbRoutingLocation> list = routingService.getRoutingLocationList(routingLocation);
        try {
            response.reset();
            String fileName = DateUtils.formateDate("yyyyMMddHHmmss") + ".jpg";
            response.setHeader("content-disposition","attachment;filename=" + fileName );
            createEquipQR(response.getOutputStream(),list,"??????????????????");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  void createEquipQR(OutputStream outputStream, List<TbRoutingLocation> tbEquipInfoList, String className)
            throws IOException {
        try {
            int rowCount = tbEquipInfoList.size()%3==0?tbEquipInfoList.size()/3:(tbEquipInfoList.size()/4 + 1);
            //????????????
            int width = 1700;
            int height = rowCount*520 + 80;
            BufferedImage image = new BufferedImage(width,height ,BufferedImage.TYPE_INT_RGB);
            //??????xy??????????????????????????????
            Graphics2D g2d = image.createGraphics();
            g2d.setBackground(Color.WHITE);
            g2d.clearRect(0, 0, width, height);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SimHei", Font.PLAIN, 30));
            int x  = 850 - className.length() * 15;
            g2d.drawString(className, x, 50);
            for(int i=0;i<tbEquipInfoList.size();i++) {
                TbRoutingLocation student =tbEquipInfoList.get(i);
                int top = (i / 4 * 510) + 80;
                int left = (i % 4 * 410) + 20;
                g2d.drawRect(left , top, 400, 500);
                g2d.setFont(new Font("SimHei", Font.PLAIN, 20));
                String name =  student.getLocationName();
                g2d.drawString(name,left + (200 - name.length() * 10), top + 40);
                CodeModel info = new CodeModel();
                info.setHeight(100);
                info.setWidth(100);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("nodeId",student.getLocationNo());
                jsonObject.put("nodeType",2);
                info.setContents(jsonObject.toJSONString());
                logger.info("???????????????equip={},name={}",JSON.toJSONString(jsonObject),name);
                QR_Code code = new QR_Code();
                BufferedImage bufferedImage = code.dealLogoAndPic(info);
                g2d.drawImage((Image)bufferedImage, left + 2  , top + 50, 390, 390,null);
            }
            //???????????????
            ImageIO.write(image, "jpg", outputStream);
            g2d.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            outputStream.close();
        }
    }
    /**
     * ???????????? ????????????????????????
     * @param request,response
     * @return
     */
  
    @RequestMapping(value = "/downloadModel",method = RequestMethod.GET)
    @ApiOperation(value = "??????????????????????????????")
    public void downloadModel(HttpServletRequest request,  HttpServletResponse response,String factoryNo) throws Exception{
        String fileName ="??????????????????.xlsx";
        List<TbEquipInfo> tbEquipInfoList = new ArrayList<>();
        List<TbRoutingLocation> tbRoutingLocationList = new ArrayList<>();
        if(factoryNo==null){
            String info="??????no??????";
            errorInfo(response,info);
        }else {
            TbEquipInfo tbEquipInfo = new TbEquipInfo();
            tbEquipInfo.setFactoryNo(factoryNo);
            tbEquipInfoList =equipService.getEquipList(tbEquipInfo);
            TbRoutingLocation location= new TbRoutingLocation();
            location.setFactoryNo(factoryNo);
            tbRoutingLocationList = routingService.getRoutingLocationList(location);
        }
        //????????????3  ????????????4  ??????5 ????????????6
        int type =3;
        logger.info("????????????????????????");
        List<String> equipNameList = new ArrayList<>();
        for (TbEquipInfo tbEquipInfo : tbEquipInfoList) {
            equipNameList.add(tbEquipInfo.getEquipName()+","+tbEquipInfo.getEquipNo());
        }
        List<String> locationNameList = new ArrayList<>();
        for (TbRoutingLocation routingLocation : tbRoutingLocationList) {
            locationNameList.add(routingLocation.getLocationName()+","+routingLocation.getLocationNo());
        }
        if(equipNameList.size()==0 ||locationNameList.size()==0){
            String info="??????/??????????????????";
            errorInfo(response,info);
        }else {
            Map map = new HashMap();
            map.put("fileName",fileName);
            map.put("type",type);
            map.put("equipNameList",equipNameList);
            map.put("locationNameList",locationNameList);
            ExcelHighUtils.writeExcelX(response,null, TbRoutingLocationElementVo.class,map);
        }
                
    }
    /**
     * 
     * ??????????????????
     */
    public void  errorInfo( HttpServletResponse response,String info) throws Exception{
            response.reset();
            ServletOutputStream os = response.getOutputStream();
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            os.write(info.getBytes("UTF-8"));
            os.close();
        }

    public void createSheet(XSSFWorkbook hssfWorkbook , String sheetTitle, Map hyMap, String fileName,HttpServletResponse response) throws IOException{
        XSSFSheet sheet = hssfWorkbook.createSheet(sheetTitle);
        XSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //??????????????????????????????????????????;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //??????????????????????????????????????????;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //???????????????
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //????????????
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //?????????
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//?????????
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//?????????

        Row titleRow = sheet.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);
        Row titleRow2 = sheet.createRow(1);
        List<Map<String, Object>> data = (List<Map<String, Object>>) hyMap.get("data");
        List<Map<String, Object>> title = (List<Map<String, Object>>)hyMap.get("title");
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
//        titleRow.createCell(0).setCellValue("??????");
        Cell cell = titleRow.createCell(0);

        cell.setCellValue("??????");
        cell.setCellStyle(style);
        Map map =new HashMap(16);
        sheet.setColumnWidth(0, 100 * 60);

        for (int j = 0; j < title.size(); j++) {
            map.put(j + 1,title.get(j).get("dataField").toString());
            Cell cellName = titleRow.createCell(j + 1);
            cellName.setCellStyle(style);
            cellName.setCellValue(title.get(j).get("draftName").toString());
            Cell cellUnit = titleRow2.createCell(j + 1);
            cellUnit.setCellStyle(style);
            cellUnit.setCellValue(title.get(j).get("dataUnit")!=null?title.get(j).get("dataUnit").toString():"");
            //titleRow2.createCell(j ).setCellValue(title.get(j).get("dataUnit").toString());
            sheet.setColumnWidth(j + 1,  100 * 60);
        }
        for (int j = 0; j < data.size(); j++) {
            Row tempRow = sheet.createRow(j + 2);
            Cell cellDate = tempRow.createCell(0);
            cellDate.setCellStyle(style);
            cellDate.setCellValue(data.get(j).get("date").toString());
            List<Map<String, Object>> tempArray = (List<Map<String, Object>>)data.get(j).get("data");
            for (int k = 0; k < map.keySet().size(); k++) {
                String tempKey = map.get(k + 1).toString();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).get("dataField").toString().equals(tempKey)) {
                        if (tempArray.get(i).get("value") != null) {
                            tempRow.createCell(k + 1).setCellValue(tempArray.get(i).get("value").toString());
                        } else {
                            tempRow.createCell(k + 1).setCellValue("");
                        }
                        continue;
                    }
                }
            }
        }
     /*   File file = new File( filePath+fileName);
        hssfWorkbook.write(new FileOutputStream(file));*/
        buildExcelDocument(fileName,hssfWorkbook,response);
    }

    public static  void  buildExcelDocument(String fileName, Workbook wb, HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.flush();
            wb.write(bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ????????????????????????
     * @param request,file
     * @return
     */
    @RequestMapping(value = "/importEquip",method = RequestMethod.POST)
    @ApiOperation(value = "??????????????????")
    public AjaxObject importEquip(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo){
        AjaxObject ajaxObject = new AjaxObject();
        List<TbRoutingLocationElementVo> list = ExcelUtils.readExcel("", TbRoutingLocationElementVo.class, file);
        logger.info("????????????????????????????????????list={}", JSON.toJSONString(list));
        TbUser user = super.getUser(request,stringRedisTemplate);
        list.forEach(o->{
            o.setCreateUser(user.getName());
            o.setCreateTime(new Date());
            o.setFactoryNo(factoryNo);
        });
        try {
            int i = routingService.saveImportTbRoutingLocationElement(list,factoryNo);
            if(i==1){
                ajaxObject = AjaxObject.ok("????????????");
            }else {
                ajaxObject =  AjaxObject.error("????????????");
            }
        } catch (Exception e) {
            ajaxObject =AjaxObject.error(e.getMessage());
            e.printStackTrace();
        }
        return  ajaxObject;
    }

    /**
     * ??????????????????
     * @param request
     * @param conditon
     * @return
     */
    @RequestMapping(value ="/addTempRoutingTask",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject addTempRoutingTask(HttpServletRequest request,@RequestBody TbRoutingTaskConditon conditon){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            logger.info("????????????????????????TbRoutingTaskConditon={},????????????user={}", JSON.toJSONString(conditon), JSON.toJSON(user));
            int flag = routingService.addTempRoutingTask(conditon, user);
            if (flag >= 1) {
                ajaxObject = AjaxObject.ok("????????????");
                //????????????
                TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(conditon.getFactoryNo());
                // `task_type` int(11) DEFAULT '1' COMMENT '1?????????????????? 2??????????????????',
                if(tbFactoryInfo!=null){
                    if(conditon.getTaskType()==1){
                        //?????????
                        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                        condition.setFactoryUri(tbFactoryInfo.getUri());
                        condition.setType(1);
                        // 1?????? 2??????
                        List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
                        logger.info("????????????????????????????????????tbUserList={}", JSON.toJSONString(tbUserList));
                        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatails = schedulingService.getbSchedulingPlanInfoByGroupType(1, tbFactoryInfo.getFactoryNo(), DateUtils.formateDateFull(new Date()));
                        logger.info("????????????????????????tbSchedulingPlanDeatails={}", JSON.toJSONString(tbSchedulingPlanDeatails));
                        List<TbUser> tbUsers = new ArrayList<>();
                        for (TbUser tbUser : tbUserList) {
                            for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatails) {
                                if(tbUser.getCode().equals(deatail.getUserCode())){
                                    TbUser tbUserD = new TbUser();
                                    tbUserD.setCode(tbUser.getCode());
                                    tbUserD.setName(tbUser.getName());
                                    tbUsers.add(tbUserD);
                                }
                            }
                        }
                        if(tbUsers.size()>0){
                            logger.info("???????????????????????????????????????tbUsers{}", JSON.toJSONString(tbUsers));
                            sendTempRoutingTask(tbUsers,tbFactoryInfo,condition.getType());
                        }
                    }else if(conditon.getTaskType()==2){
                        //??????
                        TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                        condition.setFactoryUri(tbFactoryInfo.getUri());
                        condition.setType(2);
                        // 1?????? 2??????
                        List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
                        logger.info("????????????????????????????????????tbUserList={}", JSON.toJSONString(tbUserList));
                        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatails = schedulingService.getbSchedulingPlanInfoByGroupType(2, tbFactoryInfo.getFactoryNo(), DateUtils.formateDate(new Date()));
                        logger.info("????????????????????????tbSchedulingPlanDeatails={}", JSON.toJSONString(tbSchedulingPlanDeatails));
                        List<TbUser> tbUsers = new ArrayList<>();
                        for (TbUser tbUser : tbUserList) {
                            for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatails) {
                                if(tbUser.getCode().equals(deatail.getUserCode())){
                                    TbUser tbUserD = new TbUser();
                                    tbUserD.setCode(tbUser.getCode());
                                    tbUserD.setName(tbUser.getName());
                                    tbUsers.add(tbUserD);
                                }

                            }
                        }
                        if(tbUsers.size()>0){
                            logger.info("???????????????????????????????????????tbUsers{}", JSON.toJSONString(tbUsers));
                            sendTempRoutingTask(tbUsers,tbFactoryInfo,condition.getType());
                        }
                    }
                }
            } else {
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("????????????????????????e={}", e.getMessage());
            ajaxObject = AjaxObject.error(e.getMessage());
        }

        return ajaxObject;
    }
    

    //????????????????????????/??????????????????
    public void sendTempRoutingTask(List<TbUser> userList,TbFactoryInfo tbFactoryInfo,Integer type){
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            List<String> userCodeList = userList.stream().map(e -> e.getCode()).collect(Collectors.toList());
            List<String> userNameList = userList.stream().map(e -> e.getName()).collect(Collectors.toList());
            String[] codes = new String[userCodeList.size()];
            userCodeList.toArray(codes);
            params.targets =codes;
            if(type==1){
                params.title="????????????????????????";
                params.body="??????????????????????????????????????????????????????????????????????????????";
            }else if (type ==2) {
                params.title="????????????????????????";
                params.body="??????????????????????????????????????????????????????????????????????????????";
            }
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",1);
            if(tbFactoryInfo!=null){
                extParameters.put("factoryNo",tbFactoryInfo.getFactoryNo());
                extParameters.put("factoryName",tbFactoryInfo.getFactoryName());
            }
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("????????????????????????Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("????????????????????????????????????userName={}", JSON.toJSONString(userNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ???????????????????????????
     * @param request
     * @param conditon
     * @return
     */
    @RequestMapping(value ="/modifyTempRoutingTask",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "??????????????????????????????")
    public AjaxObject modifyTempRoutingTask(HttpServletRequest request,@RequestBody TbRoutingTaskConditon conditon){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            logger.info("????????????????????????TbRoutingTaskConditon={},????????????user={}", JSON.toJSONString(conditon), JSON.toJSON(user));
            int flag = routingService.modifyTempRoutingTask(conditon, user);
            if (flag >= 1) {
                ajaxObject = AjaxObject.ok("????????????");
            } else {
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("????????????????????????e={}", e.getMessage());
            ajaxObject = AjaxObject.error(e.getMessage());
        }

        return ajaxObject;
    }

    /**
     * ????????????????????????
     * @param request
     * @param conditon
     * @return
     */
    @RequestMapping(value ="/addTempTbRoutingModel",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "????????????????????????")
    public AjaxObject addTempTbRoutingModel(HttpServletRequest request,@RequestBody TbRoutingModelCondition conditon){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            logger.info("??????????????????????????????TbRoutingModelCondition={},????????????user={}", JSON.toJSONString(conditon),JSON.toJSON(user));
            int flag =routingService.addTempTbRoutingModel(conditon,user);
            if(flag==1){
                ajaxObject =AjaxObject.ok("????????????");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("??????????????????????????????e={}", e.getMessage());
            AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }

    /**
     * ???????????? ??????????????????
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/downloadModelParam",method = RequestMethod.GET)
    @ApiOperation(value = "????????????????????????")
    public void downloadModelParam(HttpServletRequest request,  HttpServletResponse response,String factoryNo) throws Exception{
        String fileName ="??????????????????.xlsx";
        List<TbEquipInfo> tbEquipInfoList = new ArrayList<>();
        List<TbRoutingLocation> tbRoutingLocationList = new ArrayList<>();
        if(factoryNo==null){
            String info="??????no??????";
            errorInfo(response,info);
        }else {
            TbEquipInfo tbEquipInfoQ = new TbEquipInfo();
            tbEquipInfoQ.setFactoryNo(factoryNo);
            tbEquipInfoList = equipService.getEquipList(tbEquipInfoQ);
            TbRoutingLocation location = new TbRoutingLocation();
            location.setFactoryNo(factoryNo);
            tbRoutingLocationList = routingService.getRoutingLocationList(location);
            List<String> equipNameList = new ArrayList<>();
            for (TbEquipInfo tbEquipInfo : tbEquipInfoList) {
                equipNameList.add(tbEquipInfo.getEquipName() + "," + tbEquipInfo.getEquipNo());
            }

            List<String> locationNameList = new ArrayList<>();
            for (TbRoutingLocation routingLocation : tbRoutingLocationList) {
                locationNameList.add(routingLocation.getLocationName() + "," + routingLocation.getLocationNo());
            }
            //????????????3  ????????????4  ??????5  ????????????6
            int type = 6;
            TbParameterConfig tbParameterConfig = new TbParameterConfig();
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            integerList.add(2);
            tbParameterConfig.setParamFromList(integerList);
            List<TbParameterConfig> list =new ArrayList<>();
            list = parameterConfigService.selectParameterConfigList(tbParameterConfig);
            if(equipNameList.size()==0 ||locationNameList.size()==0 || list.size()==0){
                String info="??????/?????????/?????????????????????";
               errorInfo(response,info);
            }else {
                List<String> paramNameList = list.stream().map(e -> e.getParamName()).collect(Collectors.toList());
                Map map = new HashMap();
                map.put("fileName", fileName);
                map.put("type", type);
                map.put("paramNameList", paramNameList);
                map.put("tbEquipInfoList", equipNameList);
                map.put("locationNameList", locationNameList);
                ExcelHighUtils.writeExcelX(response, null, TbRoutingLocationFillElementVo.class, map);
                logger.info("??????????????????ok");
            }
        }
    }

    /**
     * ????????????????????????
     * @param request,file
     * @return
     */
    @RequestMapping(value = "/importParam",method = RequestMethod.POST)
    @ApiOperation(value = "??????????????????")
    public AjaxObject importParam(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo){
        AjaxObject ajaxObject = new AjaxObject();
        List<TbRoutingLocationFillElementVo> list = ExcelUtils.readExcel("", TbRoutingLocationFillElementVo.class, file);
        logger.info("????????????????????????list={}", JSON.toJSONString(list));
        TbUser user = super.getUser(request,stringRedisTemplate);
        list.forEach(o->{
            o.setCreateUser(user.getName());
            o.setCreateTime(new Date());
            o.setFactoryNo(factoryNo);
        });
        try {
            int i = routingService.saveImportTbRoutingLocationReportElement(list);
            if(i==1){
                ajaxObject = AjaxObject.ok("????????????");
            }else {
                ajaxObject =  AjaxObject.error("????????????");
            }
        } catch (Exception e) {
            ajaxObject =AjaxObject.error(e.getMessage());
            e.printStackTrace();
        }
        return  ajaxObject;
    }

    /**
     * pc??????????????????
     * @param req ,tbEquipFaultInfo
     * @return
     */
    @RequestMapping(value = "/savePcError",method = RequestMethod.POST)
    @ApiOperation(value = "PC?????????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "??????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "errorContent ", value = "????????????", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "errorPicture ", value = "??????", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "errorVideo ", value = "??????", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "equipNo", value = "??????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "equipName", value = "????????????", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "errorFrom", value = "??????(1:app 2:pc)", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject savePcError(HttpServletRequest req,TbEquipFaultInfo tbEquipFaultInfo ){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(req,stringRedisTemplate);
        logger.info("pc??????????????????tbEquipFaultInfo={}",JSON.toJSONString(tbEquipFaultInfo));
        tbEquipFaultInfo.setReportUserCode(user.getCode());
        tbEquipFaultInfo.setReportUserName(user.getName());
        tbEquipFaultInfo.setErrorNo(StringTools.getUUID());
        int resultCode = routingService.savePcError(tbEquipFaultInfo);
        if(resultCode==1){
            ajaxObject= AjaxObject.ok();
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(tbEquipFaultInfo.getFactoryNo());
            //????????????
            if(tbFactoryInfo!=null){
                TbWorkTaskInfoCondition condition = new TbWorkTaskInfoCondition();
                //    private Integer type; 0:?????? 1:???????????? 2,???????????? 3 ???????????? SCYXJL ???????????? SCSBJL
                condition.setFactoryUri(tbFactoryInfo.getUri());
                condition.setType(3);
                List<TbUser> tbUserList = tbSysUseService.getTbEquipBanUserListByFactoryUri(condition);
                //List<String> userCodeList = tbUserList.stream().map(e -> e.getCode()).collect(Collectors.toList());
                if(tbUserList!=null && tbUserList.size()>0){
                    sendPcErroeMessage(tbFactoryInfo,tbUserList);
                }
            }
        }else {
            ajaxObject =AjaxObject.error();
        }
        return ajaxObject;
    }

    /**
     * pc??????????????????????????????
     */
    public void sendPcErroeMessage(TbFactoryInfo tbFactoryInfo,List<TbUser> tbUserList){
        List<String> userCodeList = tbUserList.stream().map(e -> e.getCode()).collect(Collectors.toList());
        try {
            //'0:????????????1:????????????',
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[userCodeList.size()];
            userCodeList.toArray(codes);
            params.targets =codes;
            params.title="pc???????????????";
            params.body="pc???????????????????????????????????????";
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",1);
            extParameters.put("factoryNo",tbFactoryInfo.getFactoryNo());
            extParameters.put("factoryName",tbFactoryInfo.getFactoryName());
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("pc??????????????????Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("pc????????????????????????userName={}",JSON.toJSONString(tbUserList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ???????????????????????????????????????
     * @param request
     * @param tbRoutingLocatioinEquip
     * @return
     */
    @ApiOperation(value = "????????????????????????????????????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "????????????token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "locationEquipNo", value = "????????????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "locationEquipNoUpOrDown", value = "??????/???????????????no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "??????(0:?????? 1:??????)", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value ="/upOrDownLocationLinkEquip")
    public AjaxObject upOrDownLocationLinkEquip(HttpServletRequest request,TbRoutingLocatioinEquip tbRoutingLocatioinEquip){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            logger.info("?????????????????????????????????????????????TbRoutingLocatioinEquip={}", JSON.toJSONString(tbRoutingLocatioinEquip));
            int flag = routingService.upOrDownLocationLinkEquip(tbRoutingLocatioinEquip);
            if (flag >= 1) {
                ajaxObject = AjaxObject.ok("??????");
            } else {
                ajaxObject = AjaxObject.error("????????????");
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            logger.error("?????????????????????????????????????????????e={}", e.getMessage());
            ajaxObject = AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }
}

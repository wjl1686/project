package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 流程
 * @date 2019/1/15 18:16
 */
@Api(tags = "流程管理")
@RestController
@RequestMapping("/flow")
public class WorkFlowController extends  BaseController {

    WorkFlowService workFlowService;
    StringRedisTemplate stringRedisTemplate;
    TbSysUseService useService;
    TbFactoryService factoryService;


    public WorkFlowController(WorkFlowService workFlowService, StringRedisTemplate stringRedisTemplate,
                              TbSysUseService useService, TbFactoryService factoryService){
        this.workFlowService = workFlowService;
        this.stringRedisTemplate = stringRedisTemplate;
        this.useService = useService;
        this.factoryService = factoryService;

    }

    @GetMapping("/flowList")
    @ApiOperation(value = "查询工作流列表")
    public AjaxObject getWorkFlowList(HttpServletRequest request,TbWorkFlowInfo tbWorkFlowInfo){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbWorkFlowInfo> list = workFlowService.getWorkFlowList(tbWorkFlowInfo);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @PostMapping("/addWorkFlow")
    @ApiOperation(value = "新增工作流")
    public AjaxObject addWorkFlow(HttpServletRequest request,TbWorkFlowInfo tbWorkFlowInfo){
        if(StringUtils.isEmpty(tbWorkFlowInfo.getFlowNo())){
            TbUser user = super.getUser(request,stringRedisTemplate);
            tbWorkFlowInfo.setCreateUser(user.getCode());
            tbWorkFlowInfo.setCreateUserName(user.getName());
        }
        if(workFlowService.saveWorkFlowInfo(tbWorkFlowInfo)>0){
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    @PostMapping("/deleteWorkFlow")
    @ApiOperation(value = "删除工作流")
    public AjaxObject deleteWorkFlow(TbWorkFlowInfo tbWorkFlowInfo){
        if(workFlowService.deleteWorkFlowInfo(tbWorkFlowInfo.getFlowNo())>0){
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    /**
     * 克隆工艺流程
     * @param sourceFlowNo
     * @param targetFlowNo
     * @return
     */
    @PostMapping(value = "/cloneWorkFlow")
    @ApiOperation(value = "从目标水厂复制工作流")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "sourceFlowNo", value = "原流程编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "targetFlowNo", value = "目标流程编号", dataType = "string", paramType = "query")

    })
    public AjaxObject cloneWorkFlow(String sourceFlowNo,String targetFlowNo){
        int resultCode = workFlowService.workFlowCopyAlone(sourceFlowNo,targetFlowNo);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    /**
     * 获取水厂的工作流配置
     * @param request
     * @return
     */
    @GetMapping( "/getWorkFlowConfigList")
    @ApiOperation(value = "查询水厂的工作流列表")
    public AjaxObject getWorkFlowConfig(HttpServletRequest request,TbWorkFlowConfig workFlowConfig){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbWorkFlowConfig> list = workFlowService.getWorkFlowConfigList(workFlowConfig);
        List<TbFactoryInfo> factoryInfoList = factoryService.getFactoryInfoList(null);
        for(TbWorkFlowConfig workFlowConfig1:list){
            for(TbFactoryInfo factoryInfo:factoryInfoList){
                if(workFlowConfig1.getOrgNo().equals(factoryInfo.getFactoryNo())){
                    workFlowConfig1.setOrgName(factoryInfo.getFactoryName());
                }
            }
        }
        return super.getResultObject(list,request.getParameter("page"));
    }

    @GetMapping( "/getWorkFlowDetailList")
    public AjaxObject getWorkFlowDetailList(HttpServletRequest request,TbWorkFlowConfig workFlowConfig, TbWorkFlowConfigDetail workFlowConfigDetail){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        if(StringUtils.isEmpty(workFlowConfigDetail.getConfigNo())){
            //如果没有传递子项的ID
            List<TbWorkFlowConfig> list = workFlowService.getWorkFlowConfigList(workFlowConfig);
            workFlowConfigDetail.setConfigNo(list.get(0).getFlowNo());
        }
        List<TbWorkFlowConfigDetail> list = workFlowService.getWorkFlowDetailList(workFlowConfigDetail);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @GetMapping( "/getWorkFlowDetailExtendList")
    @ApiOperation(value = "查询工作流的流程详情")
    public AjaxObject getWorkFlowDetailExtendList(HttpServletRequest request, TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        Integer type = request.getParameter("type")==null?1:Integer.valueOf(request.getParameter("type"));
        List<TbWorkFlowConfigDetailExtend> list = workFlowService.getWorkFlowDetailExtendList(workFlowConfigDetailExtend,type);
        return super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * 保存工作流配置
     * @param request
     * @param workFlowConfig
     * @return
     */
    @PostMapping( "/saveWorkFlowConfig")
    @ApiOperation(value = "修改工作流信息")
    public AjaxObject saveWorkFlowConfig(HttpServletRequest request,TbWorkFlowConfig workFlowConfig){
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(workFlowService.saveWorkFlowConfig(workFlowConfig,user)>0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("操作失败");
        }
    }

    /**
     * 保存工作中流详情
     * @param request
     * @param detailArray
     * @return
     */
    @ApiOperation(value = "批量保存工作流的配置详情")
    @PostMapping( "/saveWorkFlowDetails")
    public AjaxObject saveWorkFlowDetails(HttpServletRequest request,@RequestBody JSONArray detailArray){
        TbUser user = super.getUser(request,stringRedisTemplate);
        List<TbWorkFlowConfigDetail> configDetailList = new ArrayList<>();
        for(int i=0;i<detailArray.size();i++){
            TbWorkFlowConfigDetail workFlowConfigDetail = JSON.toJavaObject(detailArray.getJSONObject(i),TbWorkFlowConfigDetail.class);
            configDetailList.add(workFlowConfigDetail);
        }
        if(workFlowService.saveWorkFlowDetailList(configDetailList)>0) {
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    @ApiOperation(value = "当个保存工作流详情")
    @PostMapping( "/saveWorkFlowDetail")
    public AjaxObject saveWorkFlowDetail(HttpServletRequest request,TbWorkFlowConfigDetail workFlowConfigDetail ){

        if(workFlowService.saveWorkFlowDetail(workFlowConfigDetail)>0) {
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }


    @ApiOperation(value = "配置工作流步骤的操作角色及用户")
    @PostMapping( "/saveWorkFlowOrg")
    public AjaxObject saveWorkFlowOrg(HttpServletRequest request,TbWorkFlowConfigDetail tbWorkFlowConfigDetail,int  nodeUserType){

        if(workFlowService.saveWorkFlowDetailUser(tbWorkFlowConfigDetail,nodeUserType)>0) {
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    @ApiOperation(value = "修改工作流表单字段的顺序")
    @PostMapping( "/changeNodeIndex")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "firstNodeExtendNo", value = "前一个表单NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "firstFieldIndex", value = "前一个表单序号", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "secondNodeExtendNo", value = "后一个表单NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secondFieldIndex", value = "后一个表单序号", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject changeNodeIndex( String firstNodeExtendNo,Integer firstFieldIndex, String secondNodeExtendNo,Integer secondFieldIndex){
        if(workFlowService.changeNodeIndex( firstNodeExtendNo, firstFieldIndex,  secondNodeExtendNo, secondFieldIndex)>0) {
            return AjaxObject.ok("修改顺序成功");
        }else {
            return AjaxObject.error("修改顺序失败");
        }
    }

    @ApiOperation(value = "修改工作流表单的校验规则")
    @PostMapping( "/changeControlRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "nodeExtendNo", value = "表单字段NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "showCondition", value = "控制规则", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "valiDateRules", value = "比较规则", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject changeControlRule( String nodeExtendNo,String showCondition,String validateRules){
        if(workFlowService.changeControlRule( nodeExtendNo, showCondition,  validateRules)>0) {
            return AjaxObject.ok("修改规则成功");
        }else {
            return AjaxObject.error("修改规则失败");
        }
    }



    @ApiOperation(value = "修改工作流步骤信息")
    @PostMapping( "/saveWorkFlowDetailExtend")
    public AjaxObject saveWorkFlowDetailExtend(HttpServletRequest request,TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend){

        if(workFlowService.saveWorkFlowDetailExtend(workFlowConfigDetailExtend)>0) {
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    @ApiOperation(value = "删除工作流步骤")
    @PostMapping( "/deleteWorkFlowDetailExtend")
    public AjaxObject deleteWorkFlowDetailExtend(HttpServletRequest request,TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend){

        if(workFlowService.deleteWorkFlowDetailExtend(workFlowConfigDetailExtend)>0) {
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }


    @ApiOperation(value = "查询工作流接口列表")
    @GetMapping("/getWorkFlowApoList")
    public AjaxObject getWorkFlowApoList(HttpServletRequest request,WorkFlowApi workFlowApi){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<WorkFlowApi> list = workFlowService.getWorkFlowApiList(workFlowApi);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @ApiOperation(value = "新增工作流接口")
    @PostMapping("/addWorkFlowApi")
    public AjaxObject addWorkFlowApi(HttpServletRequest request,WorkFlowApi workFlowApi){

        if(workFlowService.saveWorkFlowApi(workFlowApi)>0){
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

    @ApiOperation(value = "删除工作流接口")
    @PostMapping("/deleteWorkFlowApi")
    public AjaxObject deleteWorkFlowApi(WorkFlowApi workFlowApi){
        if(workFlowService.deleteWorkFlowApi(workFlowApi)>0){
            return AjaxObject.ok("保存成功");
        }else {
            return AjaxObject.error("保存失败");
        }
    }

}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbAnalysisFillDetail;
import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbFillField;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.FillTaskService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author  xibian
 * 填报类管理
 */
@Api(tags = "填报类管理")
@Controller
@RequestMapping("/filltask")
public class FillTaskController  extends  BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FillTaskService fillTaskService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @ApiOperation(value = "获取化验填报指标列表")
    @RequestMapping("getFillFieldList")
    @ResponseBody
    public AjaxObject getFillFieldList(HttpServletRequest request, TbFillField fillField){
        logger.info("查询化验填报列表参数TbFillField={}", JSON.toJSONString(fillField));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbFillField> list =fillTaskService.getFillFieldList(fillField);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @ApiOperation(value = "新增化验填报指标")
    @PostMapping("addFillField")
    @ResponseBody
    public AjaxObject addFillField(HttpServletRequest request, TbFillField fillField){
        logger.info("新增化验填报参数TbFillField={}", JSON.toJSONString(fillField));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =  fillTaskService.addFillField(fillField,user);
            if(flag==1){
                ajaxObject = AjaxObject.ok("新增成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增失败e={}", e);
            ajaxObject = AjaxObject.error("新增失败，请联系管理员！");
        }
        return ajaxObject;
    }

    @ApiOperation(value = "修改化验填报指标")
    @PostMapping("updateFillField")
    @ResponseBody
    public AjaxObject updateFillField(HttpServletRequest request, TbFillField fillField){
        logger.info("修改化验填报参数TbFillField={}", JSON.toJSONString(fillField));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =  fillTaskService.updateFillField(fillField,user);
            if(flag==1){
                ajaxObject = AjaxObject.ok("修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改失败e={}", e);
            ajaxObject = AjaxObject.error("修改失败，请联系管理员！");
        }
        return ajaxObject;
    }

    @ApiOperation(value = "修改化验指标状态")
    @PostMapping("changeFillFieldStatus")
    @ResponseBody
    public AjaxObject changeFillFieldStatus(HttpServletRequest request, TbFillField fillField){
        logger.info("修改化验填报参数TbFillField={}", JSON.toJSONString(fillField));
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =  fillTaskService.changeFillFieldStatus(fillField,user);
            if(flag==1){
                return AjaxObject.ok("修改成功");
            }else{
                return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改失败e={}", e);
            return AjaxObject.error("修改失败，请联系管理员！");
        }
    }

    @ApiOperation(value = "获取化验工单列表")
    @RequestMapping("getAnalysisTaskList")
    @ResponseBody
    public AjaxObject getAnalysisTaskList(HttpServletRequest request, TbAnalysisFillTask analysisFillTask, Date beginDate, Date endDate,String getFill){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbAnalysisFillTask> list =fillTaskService.getAnalysisTaskList(analysisFillTask,beginDate,endDate,getFill);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @ApiOperation(value = "新增化验填报工单")
    @PostMapping("addTbAnalysisFillTask")
    @ResponseBody
    public AjaxObject addTbAnalysisFillTask(HttpServletRequest request, String factoryNo,Date taskDate){
        TbUser user = super.getUser(request,stringRedisTemplate);
        int resultCode =  fillTaskService.addTbAnalysisFillTask(factoryNo,taskDate,user);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    @ApiOperation(value = "更新化验工单状态")
    @PostMapping("updateTbAnalysisFillTask")
    @ResponseBody
    public AjaxObject updateTbAnalysisFillTask(HttpServletRequest request, TbAnalysisFillTask analysisFillTask){
        TbUser user = super.getUser(request,stringRedisTemplate);
        int resultCode =  fillTaskService.updateTbAnalysisFillTask(analysisFillTask);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    @ApiOperation(value = "获取化验工单详情")
    @PostMapping("commitAnalysisFillTask")
    @ResponseBody
    public AjaxObject commitAnalysisFillTask(HttpServletRequest request, TbAnalysisFillTask analysisFillTask){
        TbUser user = super.getUser(request,stringRedisTemplate);
        analysisFillTask.setFillUserCode(user.getCode());
        analysisFillTask.setFillUserName(user.getName());
        analysisFillTask.setStatus(2);
        int resultCode =  fillTaskService.updateTbAnalysisFillTask(analysisFillTask);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }


    @RequestMapping("getAnalysisTaskDetailList")
    @ResponseBody
    @ApiOperation(value = "获取化验工单详情")
    public AjaxObject getAnalysisTaskDetailList(HttpServletRequest request, String fillTaskNo){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbAnalysisFillDetail> list =fillTaskService.getAnalysisTaskDetailList(fillTaskNo);
        return super.getResultObject(list,request.getParameter("page"));
    }

    @RequestMapping("saveAnalysisTaskDetail")
    @ResponseBody
    @ApiOperation(value = "化验工单填报")
    public AjaxObject saveAnalysisTaskDetail(HttpServletRequest request){

        String[] nodes = request.getParameterValues("node");
        String[] values = request.getParameterValues("value");
        List<TbAnalysisFillDetail> list = new ArrayList<>();

        for(int i=0;i<nodes.length;i++){

            String fillDetailNo = nodes[i];
            TbAnalysisFillDetail analysisFillDetail = new TbAnalysisFillDetail();

            analysisFillDetail.setFillDetailNo(fillDetailNo);
            analysisFillDetail.setFillTime(new Date());
            if(StringUtils.isNotEmpty(nodes[i])&&StringUtils.isNotEmpty(values[i])){
                double fillValue = Double.valueOf(values[i]);
                analysisFillDetail.setFieldValue(fillValue);
            }
            list.add(analysisFillDetail);
        }
        if(list.size()>0){
            int resultCode =  fillTaskService.saveAnalysisTaskDetailList(list);
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        }else{
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(0));
        }

    }



}

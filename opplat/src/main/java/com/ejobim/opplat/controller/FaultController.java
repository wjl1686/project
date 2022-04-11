package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbFaultDetail;
import com.ejobim.opplat.domain.TbFaultType;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.FaultService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 故障相关
 * @date 2019/12/10 15:47
 */
@Api(tags = "故障相关")
@RestController
@RequestMapping("/fault")
public class FaultController  extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FaultService faultService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 查询故障类型列表
     * @param req,tbFaultType
     * @return
     */
    @GetMapping("/getTbFaultTypeList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
    })
    public AjaxObject getTbFaultTypeList(HttpServletRequest req, TbFaultType tbFaultType){
        logger.info("查询故障类型列表参数TbFaultType={}", JSON.toJSONString(tbFaultType));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbFaultType> tbFaultTypeList = faultService.getTbFaultTypeList(tbFaultType);
        return super.getResultObject(tbFaultTypeList,req.getParameter("page"));
    }

    /**
     * 新增/修改故障类型
     * @param request,tbFaultType
     * @return
     */
    @PostMapping("/saveTbFaultType")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultName", value = "故障名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "equipTypeNo", value = "设备类型no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject saveTbFaultType(HttpServletRequest request, TbFaultType tbFaultType){
        logger.info("新增/修改故障类型参数TbFaultType={}", JSON.toJSONString(tbFaultType));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =faultService.saveTbFaultType(tbFaultType,user);
            if(flag==1){
                ajaxObject = AjaxObject.ok("新增/修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增/修改失败e={}", e);
            ajaxObject = AjaxObject.error("新增/修改失败，请联系管理员！");
        }
        return  ajaxObject;
    }

    /**
     * 删除故障类型
     * @param request,faultNo
     * @return
     */
    @PostMapping("/deleteTbFaultType")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "faultNo", value = "故障类型no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject deleteTbFaultType(HttpServletRequest request, String faultNo){
        logger.info("删除故障类型参数FaultNo={}", JSON.toJSONString(faultNo));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =faultService.deleteTbFaultType(faultNo);
            if(flag==1){
                ajaxObject = AjaxObject.ok("删除成功");
            }else{
                ajaxObject = AjaxObject.error("删除失败，系统异常！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除失败e={}", e);
            ajaxObject = AjaxObject.error("删除失败，系统异常！");
        }
        return  ajaxObject;
    }
    /**
     * 查询故障详情列表
     * @param req,tbFaultDetail
     * @return
     */
    @GetMapping("/getTbFaultDetailList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "equipName", value = "设备名称", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultNo", value = "故障类型no", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "beginTime", value = "故障开始时间", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "故障结束时间", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject getTbFaultDetailList(HttpServletRequest req, TbFaultDetail tbFaultDetail){
        logger.info("查询故障详情列表参数TbFaultType={}", JSON.toJSONString(tbFaultDetail));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbFaultDetail> tbFaultDetailList = faultService.getTbFaultDetailList(tbFaultDetail);
        return super.getResultObject(tbFaultDetailList,req.getParameter("page"));
    }

    /**
     * 查询工单详情及异常信息
     * @param taskNo
     * @return
     */
    @GetMapping("/getTbWorkTaskDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "taskNo", value = "工单no", required = true, dataType = "string", paramType = "query"),
    })
    public AjaxObject getTbWorkTaskDetail(HttpServletRequest req, String taskNo){
        logger.info("故障相关查询工单详情及异常信息参数TaskNo={}", JSON.toJSONString(taskNo));
        Map map = new HashMap(16);
        try {
            map = faultService.getTbWorkTaskDetail(taskNo);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxObject.error("计算小时出错");
        }
        return AjaxObject.ok(map);
    }
    /**
     * 新增/修改故障类型
     * @param request,tbFaultType
     * @return
     */
    @PostMapping("/saveTbFaultDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultNo", value = "故障类型no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "taskNo", value = "工单no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultDescription", value = "故障描述", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultAnalysis", value = "故障分析", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "dealPloy", value = "故障策略", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "faultDetailNo", value = "故障详情no(修改时传)", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject saveTbFaultDetail(HttpServletRequest request, TbFaultDetail tbFaultDetail){
        logger.info("新增/修改故障详情参数TbFaultDetail={}", JSON.toJSONString(tbFaultDetail));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =faultService.saveTbFaultDetail(tbFaultDetail,user);
            if(flag==1){
                ajaxObject = AjaxObject.ok("新增/修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增/修改失败e={}", e);
            ajaxObject = AjaxObject.error("新增/修改失败，请联系管理员！");
        }
        return  ajaxObject;
    }

    /**
     * 查询故障详情
     * @param faultDetailNo
     * @return
     */
    @GetMapping("/getTbFaultDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "faultDetailNo", value = "故障详情no", required = true, dataType = "string", paramType = "query"),
    })
    public AjaxObject getTbFaultDetail(HttpServletRequest req, String faultDetailNo){
        logger.info("故障相关查询故障详情参数TaskNo={}", JSON.toJSONString(faultDetailNo));
        Map map = new HashMap(16);
        try {
            map = faultService.getTbFaultDetail(faultDetailNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxObject.ok(map);
    }
}

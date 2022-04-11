package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbFacilityInfo;
import com.ejobim.opplat.domain.TbGongyiInfo;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.FacilityService;
import com.ejobim.opplat.util.AjaxObject;
import io.jsonwebtoken.lang.Assert;
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
import java.util.List;
/**
 * @author wujianlong
 * @Description: 设施
 * @date 2019/1/15 18:16
 */
@Api(tags = "设施管理")
@RestController
@RequestMapping("/facility")
public class FacilityController extends  BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private FacilityService facilityService;
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public FacilityController(FacilityService facilityService,StringRedisTemplate stringRedisTemplate){
        Assert.notNull(facilityService, "facilityService must not be null!");
        Assert.notNull(stringRedisTemplate, "stringRedisTemplate must not be null!");
        this.facilityService = facilityService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/getGongyiList")
    public AjaxObject getGongyiList(HttpServletRequest request, TbGongyiInfo gongyiInfo){
        logger.info("获取工艺段列表{}",gongyiInfo);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbGongyiInfo> list =  facilityService.getGongyiList(gongyiInfo);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/saveGongyiInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "gongyiFactoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "gongyiName", value = "名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "gongyiIndex", value = "序号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "gongyiNo", value = "gongyiNo主键", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject saveGongyiInfo(HttpServletRequest request, TbGongyiInfo gongyiInfo){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =facilityService.saveGongyiInfo(gongyiInfo,user);
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

    @PostMapping("/deleteGongyiInfo")
    public AjaxObject deleteGongyiInfo(TbGongyiInfo gongyiInfo){
        if(facilityService.deleteGongyiInfo(gongyiInfo)>0){
            return AjaxObject.ok("删除成功");
        }else{
            return AjaxObject.error("删除失败");
        }
    }

    @GetMapping("/getFacilityList")
    public AjaxObject getFacilityList(HttpServletRequest request, TbFacilityInfo facilityInfo){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("获取设施列表TbFacilityInfo={}",facilityInfo);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbFacilityInfo> list =  facilityService.getFacilityList(facilityInfo);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/saveFacilityInfo")
    public AjaxObject saveFacilityInfo(HttpServletRequest request,TbFacilityInfo facilityInfo){
        logger.info("新增/修改设施参数TbFacilityInfo={}", JSON.toJSONString(facilityInfo));
        TbUser user = super.getUser(request,stringRedisTemplate);
        int resultCode =  facilityService.saveTbFacilityInfo(facilityInfo,user);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));

    }



    @PostMapping("/deleteFacilityInfo")
    public AjaxObject deleteFacilityInfo(TbFacilityInfo facilityInfo){
        if(facilityService.deleteTbFacilityInfo(facilityInfo)>0){
            return AjaxObject.ok("删除成功");
        }else{
            return AjaxObject.error("删除失败");
        }
    }

}

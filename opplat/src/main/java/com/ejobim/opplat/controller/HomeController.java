package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.service.HomeService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: app首页相关
 * @date 2019/4/19 13:58
 */
@Api(tags = "app首页相关")
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HomeService homeService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 查询首页展示的数据
     * @param request
     * @return
     */
    @GetMapping("/getHomeInfo")
    public AjaxObject getHomeInfo(HttpServletRequest request, TaskInfoCondition condition){
        condition.setStartTime(DateUtils.getMonthFirstDay());
        condition.setEndTime(DateUtils.getMonthLastDay());
        logger.info("查询首页展示的数据参数TaskInfoCondition={}", JSON.toJSONString(condition));
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        condition.setDutyUser(getUser(request,stringRedisTemplate).getCode());
        Map<String,Object>  map  = homeService.getHomeInfo(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }

    /**
     * 查询首页展示设备的数据
     * @param request
     * @return
     */
    @GetMapping("/getHomeEquipInfo")
    public AjaxObject getHomeEquipInfo(HttpServletRequest request, TaskInfoCondition condition){
        condition.setStartTime(DateUtils.getMonthFirstDay());
        condition.setEndTime(DateUtils.getMonthLastDay());
        logger.info("查询首页展示设备的数据参数TaskInfoCondition={}", JSON.toJSONString(condition));
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        condition.setDutyUser(getUser(request,stringRedisTemplate).getCode());
        Map<String,Object>  map  = homeService.getHomeEquipInfo(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }


    /**
     * 查询首页展示的数据
     * @param request
     * @return
     */
    @GetMapping("/getHomeInfoNew")
    @ApiOperation(value = "APP端首页工单统计信息")
    public AjaxObject getHomeInfoNew(HttpServletRequest request, TaskInfoCondition condition){
        condition.setStartTime(DateUtils.getMonthFirstDay());
        condition.setEndTime(DateUtils.getMonthLastDay());
        logger.info("查询首页展示的数据参数TaskInfoCondition={}", JSON.toJSONString(condition));
        TbUser user = super.getUser(request,stringRedisTemplate);
        condition.setDutyUser(getUser(request,stringRedisTemplate).getCode());
        Map<String,Object>  map  = homeService.commonTaskInfo(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }

    /**
     * 首页日历数据及详情
     * @param request
     * @param factoryNo 水厂编号
     * @return
     */
    @GetMapping("/getHomeStaticInfo")
    @ApiOperation(value = "APP端首页按日统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getHomeStaticInfo(HttpServletRequest request,String factoryNo){
        TbUser user = super.getUser(request,stringRedisTemplate);
        Map<String,Object> map = homeService.getHomeStaticInfo(user,factoryNo);
        return AjaxObject.ok(map);
    }
    /**
     * 查询首页展示的当月柱状图数据
     * @param request
     * @return
     */
    @GetMapping("/getHomeInfoDetail")
    @ApiOperation(value = "APP端首页柱状图统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getHomeInfoDetail(HttpServletRequest request, String factoryNo ){
        logger.info("查询首页展示的数据参数TaskInfoCondition={}", factoryNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        Map<String,Object>  map  = homeService.commonTaskInfoDetail(user,factoryNo);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }


    @RequestMapping(value = "/getTaskStaticInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getTaskStaticInfo( String factoryNo ){
        Map<String,Object>  map  = homeService.getTaskStaticInfo(factoryNo);
        return AjaxObject.ok(map);
    }

    /**
     * 查询首页点击蓝色和红色展示设备的数据
     * @param request
     * @return
     */
    @GetMapping("/getDataNew")
    public AjaxObject getDataNew(HttpServletRequest request, TaskInfoCondition condition){
        logger.info("查询首页点击蓝色和红色展示设备的数据参数TaskInfoCondition={}", JSON.toJSONString(condition));
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        condition.setDutyUser(getUser(request,stringRedisTemplate).getCode());
        List<TaskVo>  taskVoList = homeService.getDataNew(condition);
        Map map = new HashMap(16);
        map.put("data",taskVoList);
        return AjaxObject.ok(map);
    }


    @GetMapping("/getGroupErrorInfo")
    public AjaxObject getGroupErrorInfo(HttpServletRequest request, String groupNo){
        logger.info("查询组团的异常信息={}", groupNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        List<Map<String,Object>> list = homeService.getGroupErrorInfo(groupNo);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return AjaxObject.ok(map);
    }

    @GetMapping("/getGroupTaskInfo")
    public AjaxObject getGroupTaskInfo(HttpServletRequest request, String groupNo){
        logger.info("查询组团的公当年信息={}", groupNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        List<Map<String,Object>> list = homeService.getGroupTaskInfo(groupNo);
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return AjaxObject.ok(map);
    }

    /**
     * 获取组团列表
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/getGroupHomeInfo")
    public AjaxObject getGroupHomeDataInfo(HttpServletRequest request, String factoryNo){
        logger.info("查询组团首页信息={}", factoryNo);
        Map<String,Object> resultMap  = homeService.getGroupHomeInfo(factoryNo);
        return AjaxObject.ok(resultMap);
    }
}

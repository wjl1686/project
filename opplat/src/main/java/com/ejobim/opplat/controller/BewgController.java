package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.condition.BewgQueryCumulation;
import com.ejobim.opplat.domain.condition.BewgQueryRelationofnodes;
import com.ejobim.opplat.domain.condition.BewgQueryTreeCondition;
import com.ejobim.opplat.domain.condition.QueryConditon;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 和利时相关接口
 * @date 2019/2/18 12:40
 */
@Api(tags = "和利时相关接口")
@RestController
@RequestMapping("/bewg")
public class BewgController  extends  BaseController{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    
    @Autowired
    private BewgService bewgService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 查询实时数据
     * @return
     */
    @PostMapping("/getDataInfo")
    public AjaxObject getDataInfo(HttpServletRequest request){
       JSONObject param = super.getJsonParam(request);
        return getRunTimeData(param);
    }

    @PostMapping("/getDataInfoApp")
    public AjaxObject getDataInfoNew(HttpServletRequest request,@RequestBody JSONObject jsonData){
        return getRunTimeData(jsonData);
    }

    private AjaxObject getRunTimeData(JSONObject jsonObject){

        String[] idCollection = null;
        if("java.lang.String".equalsIgnoreCase(jsonObject.get("ids").getClass().getTypeName()) ){
            idCollection = jsonObject.getString("ids").split(",");
        }else{
            JSONArray ids = jsonObject.getJSONArray("ids");
            idCollection = new String[ids.size()];
            for(int i=0;i<ids.size();i++){
                idCollection[i] = ids.getString(i);
            }
        }
        JSONObject dataInfo = bewgService.getDataInfoNew(idCollection);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.put("data",dataInfo);
        return AjaxObject.ok(objectMap);
    }


    /**
     * 时序服务需要提供台时统计接口
     * @return
     */
    @PostMapping("/queryCumulation")
    public AjaxObject queryCumulation(@RequestBody List<BewgQueryCumulation> list){
        Long startTime =System.currentTimeMillis();
        JSONObject dataInfo = bewgService.queryCumulation(list);
        Long endTime =System.currentTimeMillis();
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.put("data",dataInfo);
        return AjaxObject.ok(objectMap);

    }
    /**
     * 获取所有工厂
     * @return
     */
    @PostMapping("/queryAllFactory")
    public AjaxObject queryAllFactory(@RequestBody BewgQueryRelationofnodes condition){
        Long startTime =System.currentTimeMillis();
        JSONObject dataInfo = bewgService.queryAllFactory(condition);
        Long endTime =System.currentTimeMillis();
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.put("data",dataInfo);
        return AjaxObject.ok(objectMap);

    }
    /**
     * 查看完整的树
     * @return
     */
    @PostMapping("/queryTreeNode")
    public AjaxObject queryTreeNode(@RequestBody BewgQueryTreeCondition condition){
        Long startTime =System.currentTimeMillis();
        JSONObject dataInfo = bewgService.queryTreeNode(condition);
        Long endTime =System.currentTimeMillis();
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.put("data",dataInfo);
        return AjaxObject.ok(objectMap);

    }

    /**
     * 查看完整的树
     * @return
     */
    @GetMapping("/getOrgInfo")
    public AjaxObject getOrgInfo(HttpServletRequest request){

        String tenantId = request.getParameter("tenantId");
        String updateTime = request.getParameter("updateTime");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        QueryConditon queryConditon = new QueryConditon();
        queryConditon.setTenantId(tenantId);
        JSONObject dataInfo = bewgService.getOrgInfo(queryConditon);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.put("data",dataInfo);
        return AjaxObject.ok(objectMap);

    }

    /**
     * 创建socket,同时创建监控项
     * @param  request queryConditon
     * @return
     */
    @RequestMapping(value ="/createSocket",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header")
    })
    public AjaxObject createSocket(HttpServletRequest request,@RequestBody QueryConditon queryConditon){
//        logger.info("创建socket,同时创建监控项入参QueryConditon={}", JSON.toJSONString(queryConditon));
        AjaxObject ajaxObject = new AjaxObject();
        Map map = bewgService.createSocket(queryConditon);
        if(map.get("websocketUrl")!=null){
            ajaxObject = AjaxObject.ok(map);
        }else{
            ajaxObject =AjaxObject.error();
        }
//        logger.info("创建socket,同时创建监控项结果AjaxObject={}", JSON.toJSONString(ajaxObject));
        return ajaxObject;
    }

    /**
     * 同步用户,角色,机构信息
     * @param  request queryConditon
     * @return
     */
    @GetMapping("/syncUserOrgRoleData")
    public AjaxObject syncUserOrgRoleData(HttpServletRequest request){
        long startTime = System.currentTimeMillis();
        logger.info("开始同步用户,角色,机构信息startTime={}",startTime);
        TbUser user = super.getUser(request,stringRedisTemplate);
        QueryConditon queryConditon = new QueryConditon();
        queryConditon.setPageNum(1);
        queryConditon.setPageSize(1000000);
        bewgService.getOrgInfo(queryConditon);
        bewgService.getRoleInfo(queryConditon);
        bewgService.getUserInfo(queryConditon);
        logger.info("结束同步用户,角色,机构信息endTime={},时间差值cha={}",System.currentTimeMillis(),System.currentTimeMillis()-startTime);
        return AjaxObject.ok();
    }

    /**
     * 获取历史告警
     * @param  request condition 
     * @return
     */
    @RequestMapping(value ="/queryHistoryAlarm",method = RequestMethod.GET)
    public List queryHistoryAlarm(HttpServletRequest request, String factoryUri){
//        logger.info("获取历史告警入参QueryHistoryAlarmConditon={}", JSON.toJSONString(factoryUri));
        List list  = bewgService.queryHistoryAlarm(factoryUri);
        return list;
    }
    /**
     * 通过uri获取告警
     * @param  request condition
     * @return
     */
    @RequestMapping(value ="/queryAlarmByUri",method = RequestMethod.GET)
    public List queryAlarmByUri(HttpServletRequest request, String uri){
        logger.info("通过uri获取告警uri={}", JSON.toJSONString(uri));
        List<Map<String,Object>> list  = bewgService.queryAlarmByUri(uri);
        return list;
    }


    @RequestMapping(value ="/getAllAlarmByNodeUri",method = RequestMethod.GET)
    @ApiOperation(value = "获取测点的告警配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "nodeUri", value = "测点uri", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getAllAlarmByNodeUri(String nodeUri){
        JSONObject jsonObject = bewgService.getAllAlarmByNodeUri(nodeUri);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",jsonObject.getJSONArray("list"));
        return AjaxObject.ok(resultMap);
    }

    @RequestMapping(value ="/setAlarmByNodeUri",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "更新测点的告警配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "nodeUri", value = "测点uri", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "param", value = "提交的信息", required = true, dataType = "JSONObject", paramType = "body")
    })
    public AjaxObject setAlarmByNodeUri(String nodeUri,  @RequestBody JSONObject param){
        if(StringUtils.isEmpty(nodeUri)) {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.PARAM_IS_NULL);
        }
        logger.info(param.toJSONString());
        String nameSpace = nodeUri.split("/")[1];
        JSONObject jsonObject = bewgService.addOrUpdateAlarms(param,nameSpace);
        if(jsonObject!=null){
            if("0x00000000".equals(jsonObject.getString("code"))){
                return AjaxObject.getAjaxStatus(Dict.AjaxStatus.YES);
            }else{
                return AjaxObject.error(jsonObject.getString("msg"));
            }
        }else{
            return AjaxObject.error("远程服务器错误");
        }


    }

}

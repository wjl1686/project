package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/18 12:41
 */
@Service
public class BewgServiceImpl implements BewgService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${dataUrl}")
    private String dataUrl;

    @Value("${dataAlarmUrl}")
    private String dataAlarmUrl;

    @Value("${loginUrl}")
    private String loginUrl;

    @Value("${hollysys-model-url}")
    private String hollysysUrl;
    
    @Value("${hollysys-agg-url}")
    private String hollysysAggUrl;

    @Value("${hollysys-alarm-url}")
    private String hollysysAlarmUrl;

    @Value("${tenantId}")
    private String tenantId;

    @Value("${socketUrl}")
    private String socketUrl;




    @Autowired
    private TbOrgMapper tbOrgMapper;

    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbUserOrgMapper tbUserOrgMapper;

    @Autowired
    private TbUserOrgRoleMapper tbUserOrgRoleMapper;

    private  JSONObject jsonObject1 = new JSONObject();
    @Override
    public JSONObject getDataInfo(String[] list) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(Arrays.asList(list));
        JSONObject result = HttpClientUtils.httpPost(hollysysAggUrl + "/aggquery/query/queryCurrent", jsonArray.toString());
        return result;
    }

    /**
     * 获取侧点实时数据
     * @param list
     * @return
     */
    @Override
    public JSONObject getDataInfoNew(String[] list) {
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<list.length;i++){
            jsonArray.add(parse(list[i]));
        }
        //logger.info(" 获取实时数据,时序数据接口入参url={},jsonArray={}",hollysysAggUrl + "/aggquery/query/queryPointLatestDataByBrowsePath",JSON.toJSON(jsonArray));
        JSONObject result = HttpClientUtils.httpPost(hollysysAggUrl + "/aggquery/query/queryPointLatestDataByBrowsePath", jsonArray.toString());
//        logger.info(" 获取实时数据,时序数据接口结果result={}",JSON.toJSON(result));
        return result;
    }

    /**
     * 获取侧点实时数据
     * @param array
     * @return
     */
    @Override
    public JSONObject getDataInfoNew(JSONArray array) {
        JSONObject result = HttpClientUtils.httpPost(hollysysAggUrl + "/aggquery/query/queryPointLatestDataByBrowsePath", array.toString());
        // System.out.println(result);
        return result;
    }

    private  JSONObject parse(String browsePath) {
        JSONObject json = new JSONObject();
        String[] strs = browsePath.split("/");
        StringBuffer sb = new StringBuffer();
        for(int i=3;i<strs.length;i++) {
            if(i>3){
                sb.append(",");
            }
            sb.append(strs[i]);
        }
        json.put("path", sb.toString());
        json.put("uri", "/" + strs[1]+"/" + strs[2]);
        return json;
    }

    @Override
    public JSONObject queryCumulation(List<BewgQueryCumulation> list) {
        JSONObject result = new JSONObject();
        for (BewgQueryCumulation bewg:list) {
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("endTime",bewg.getEndTime());
            jsonObject1.put("startTime", bewg.getStartTime());
            jsonObject1.put("uri",bewg.getUri());
            jsonObject1.put("value",bewg.getValue());
            jsonArray.add(jsonObject1);
            result = HttpClientUtils.httpPost(hollysysAggUrl + "/aggquery/query/queryCumulation", jsonArray.toString());
        }
        return result;
    }

    @Override
    public JSONObject queryAllFactory(BewgQueryRelationofnodes condition) {
        jsonObject1.put("forward",condition.getForward());
        jsonObject1.put("maxSize",condition.getMaxSize());
        List<String> relationsList = condition.getRelations();
        jsonObject1.put("relations",returnJSONArray(relationsList));
        List<String> urisList = condition.getUris();
        jsonObject1.put("uris",returnJSONArray(urisList));
        JSONObject result = HttpClientUtils.httpPost(hollysysUrl + "/model/v2/model/relationofnodes", jsonObject1.toString());
        return result;
    }

    @Override
    public JSONObject getOrgTreeByUserId(String token) {
        String url = loginUrl + "/uaa/org/getOrgTreeByUserId";
        String info =  HttpClientUtils.StringGet(url,"","utf-8", token);
        return JSONObject.parseObject(info);
    }

    @Override
    public JSONObject queryTreeNode(BewgQueryTreeCondition condition) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("forward",condition.getForward());
        jsonObject1.put("depth",condition.getDepth());
        List<String> relationsList = condition.getRelations();
        jsonObject1.put("relations", returnJSONArray(relationsList));
        jsonObject1.put("id",condition.getId());
        StringBuffer str = new StringBuffer();
        str.append(condition.getNamespace()).append("?").append("queryTypeDefinition="+condition.getQueryTypeDefinition());
        JSONObject result = HttpClientUtils.httpPost(this.hollysysUrl + "/model/opcua/queryTreeNode/depth/"+str, jsonObject1.toString());
        return result;
    }

    /**
     * 抽取公共代码
     * @param list
     * @return
     */
    private JSONArray returnJSONArray(List<String> list){
        JSONArray relations = new JSONArray();
        for (String real:list) {
            relations.add(real);
        }
        return relations;
    }

    @Override
    public String getToken() {
        jsonObject1.put("clientId",clientId);
        jsonObject1.put("clientSecret",clientSecret);
        logger.info("获取token接口入参url={},jsonObject1={}",dataUrl + "/uaa/sys/fetchToken4Client",JSON.toJSON(jsonObject1));
        JSONObject jsonObject = HttpClientUtils.httpPost(dataUrl + "/uaa/sys/fetchToken4Client", jsonObject1);
        JSONObject obj = new JSONObject();
        String token=null;
        if(jsonObject!=null){
             obj = jsonObject.getJSONObject("obj");
             if(obj.getString("access_token")!=null){
                 token = obj.getString("access_token");
             }
        }
        logger.info("获取token接口返回结果token={}",token);
        return  token;
    }

    @Override
    public JSONObject getOrgInfo(QueryConditon queryConditon) {
        String url = dataUrl + "/uaa/org/queryOrgByUpdateTime";
        String token = getToken();
        String queryUrl = getQueryUrl(queryConditon, url);
        logger.info("同步和利时机构接口入参url={},token={}",queryUrl,"bearer "+token);
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+token);
        JSONObject jsonObject = JSONObject.parseObject(strResult);
        JSONObject obj = getResultJsonObject(jsonObject, "obj");
        JSONArray result = obj.getJSONArray("result");
        saveOrg(result);
        return jsonObject;
    }

    public JSONObject getResultJsonObject( JSONObject jsonObject,String key){
        JSONObject obj = jsonObject.getJSONObject(key);
        return obj;
    }

    public void saveOrg(JSONArray jsonArray){
        //同步数据 先删除
        tbOrgMapper.delete();
        List<TbOrg> orgList = JSONObject.parseArray(jsonArray.toJSONString(), TbOrg.class);
        orgList.forEach(org->{
            if(org.getState()==1){
                tbOrgMapper.insertSelective(org);
            }
        });

    }

    @Override
    public JSONObject getRoleInfo(QueryConditon queryConditon) {
        String url = dataUrl + "/uaa/role/queryRoleByUpdateTime";
        String queryUrl = getQueryUrl(queryConditon, url);
        String token = getToken();
        logger.info("同步和利时角色接口入参url={},token={}",queryUrl,"bearer "+token);
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+token);
        JSONObject jsonObject = JSONObject.parseObject(strResult);
        JSONArray obj = jsonObject.getJSONArray("obj");
        saveRole(obj);
        logger.info("同步角色成功");
        return jsonObject;
    }

    public String getQueryUrl(QueryConditon queryConditon,String url){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(url);
        stringBuffer.append("?tenantId=");
        stringBuffer.append(tenantId);
        if(queryConditon.getUpdateTime()!=null){
            stringBuffer.append("&updateTime=");
            stringBuffer.append(queryConditon.getUpdateTime());
        }
        if(queryConditon.getPageNum()!=null){
            stringBuffer.append("&pageNum=");
            stringBuffer.append(queryConditon.getPageNum());
        }
        if(queryConditon.getPageSize()!=null){
            stringBuffer.append("&pageSize=");
            stringBuffer.append(queryConditon.getPageSize());
        }
        return stringBuffer.toString();
    }

    public void saveRole(JSONArray jsonArray){
        //同步数据 先删除
        tbRoleMapper.delete();
        List<TbRole> tbRoles = JSONObject.parseArray(jsonArray.toJSONString(), TbRole.class);
        tbRoles.forEach(role->{
            if(role.getState()==1){
                tbRoleMapper.insertSelective(role);
            }
        });
    }

    @Override
    public JSONObject getUserInfo(QueryConditon queryConditon) {
        JSONObject jsonObject = new JSONObject();
        String url = dataUrl + "/uaa/user/queryUserByUpdateTime";
        String queryUrl = getQueryUrl(queryConditon, url);
        String token = getToken();
        if(token==null){
            return jsonObject;
        }
        logger.info("同步和利时用户接口入参url={},token={}",queryUrl,"bearer "+token);
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+token);
        logger.info("同步和利时用户接口结果UserObj={}",strResult);
        jsonObject = JSONObject.parseObject(strResult);
        System.out.println(jsonObject);
        JSONObject obj = jsonObject.getJSONObject("obj");
        JSONArray userList = obj.getJSONArray("userList");

        saveUser(userList);
        List<TbUserOrg> userOrgList = new ArrayList<>();
        List<TbUserRole> userRoleList = new ArrayList<>();
        List<TbUserOrgRole> tbUserOrgRoleList = new ArrayList<>();
        //取出所有用户
       for(int i = 0; i<userList.size();i++){
           JSONObject jsonObject2 = userList.getJSONObject(i);
           String userCode = jsonObject2.getString("code");
           JSONArray orgList = jsonObject2.getJSONArray("orgList");
           for(int t = 0; t<orgList.size();t++){
               TbUserOrg tbUserOrg = new TbUserOrg();
               JSONObject jsonObject3 = orgList.getJSONObject(t);
               tbUserOrg.setUserCode(userCode);
               String orgCode = jsonObject3.getString("code");
               tbUserOrg.setOrgCode(orgCode);
               userOrgList.add(tbUserOrg);
               JSONArray roleList = jsonObject3.getJSONArray("roleList");
               for(int h = 0; h<roleList.size();h++){
                   JSONObject jsonObject4 = roleList.getJSONObject(h);
                   TbUserOrgRole tbUserOrgRole = new TbUserOrgRole();
                   tbUserOrgRole.setUserCode(userCode);
                   tbUserOrgRole.setOrgCode(orgCode);
                   tbUserOrgRole.setRoleCode(jsonObject4.getString("code"));
                   tbUserOrgRoleList.add(tbUserOrgRole);
                   TbUserRole tbUserRole = new TbUserRole();
                   tbUserRole.setUserCode(userCode);
                   tbUserRole.setRoleCode(jsonObject4.getString("code"));
                   userRoleList.add(tbUserRole);
               }
           }
       }
       saveUserOrgRole(tbUserOrgRoleList);
        logger.info("同步用户成功");
        return jsonObject;
    }

    @Override
    public JSONObject loginHollySys(String userName, String password) {
        String url = loginUrl + "/gpaas/goLogin";
        JSONObject postJson = new JSONObject();
        postJson.put("username",userName);
        postJson.put("password",password);
        logger.info("同步和利时登录接口入参url={},postJson={}",url,JSON.toJSON(postJson));
        JSONObject jsonObject = HttpClientUtils.httpPost(url, postJson);
        logger.info("同步和利时登录接口{}结果JSONObject={}",url,JSON.toJSON(jsonObject));
        return jsonObject;
    }

    /**
     * 批量更新静态属性
     * @param uriList
     * @return
     */
    @Override
    public JSONObject updteNodes(List<Map<String,Object>> uriList) {
        String url = this.hollysysUrl  + "/model/v2/model/nodes/nodes";
        JSONArray postArray = new JSONArray();
        for(Map<String,Object> map:uriList){
            JSONObject postJson = new JSONObject();
            postJson.put("uri",map.get("uri").toString());
            JSONArray array = new JSONArray();
            JSONObject updateJson = new JSONObject();
            updateJson.put("op","replace");
            updateJson.put("path","Value");
            updateJson.put("value",map.get("value"));
            array.add(updateJson);
            postJson.put("patchJson",array);
            postArray.add(postJson);
        }
        logger.info("同步和利时 批量更新静态属性入参url={},postArray={}",url,JSON.toJSON(postArray));
        JSONObject jsonObject = HttpClientUtils.httpPost(url, postArray.toString());
        return jsonObject;
    }

    @Override
    public JSONObject logOut(String token) {
        String queryUrl = loginUrl + "/uaa/sys/logOut";
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+ token);
        return JSONObject.parseObject(strResult);
    }

    @Override
    public JSONObject getUserInfoByToken(String token) {
       // String queryUrl = loginUrl + "/cloud/user/queryUser";
        String queryUrl = loginUrl + "/uaa/user/queryUser";
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+ token);
        return JSONObject.parseObject(strResult);
    }

    @Override
    public JSONObject getUserOrgByToken(String token) {
        String queryUrl = loginUrl + "/uaa/org/getOrgTreeByUserId";
        String strResult = HttpClientUtils.StringGet(queryUrl, "", "UTF-8", "bearer "+ token);
        return JSONObject.parseObject(strResult);
    }

    public void saveUser(JSONArray jsonArray){
        tbUserMapper.delete();
        List<TbUser> tbUserList = JSONObject.parseArray(jsonArray.toJSONString(), TbUser.class);
        tbUserList.forEach(role->{
            tbUserMapper.insertSelective(role);
        });
       //tbUserMapper.insertUserBatchlist(tbUserList);
    }
    public void saveUserOrg(List<TbUserOrg> userOrgList){
        tbUserOrgMapper.delete();
        userOrgList.forEach(role->{
            tbUserOrgMapper.insertSelective(role);
        });
    }
    public void saveUserOrgRole( List<TbUserOrgRole> tbUserOrgRoleList){
        tbUserOrgRoleMapper.delete();
        tbUserOrgRoleList.forEach(role->{
            tbUserOrgRoleMapper.insertSelective(role);
        });
       //tbUserOrgRoleMapper.insertUserOrgRoleBatchlist(tbUserOrgRoleList);
    }
    @Autowired
    private TbWorkFlowInfoMapper tbWorkFlowInfoMapper;

    @Autowired
    private TbWorkFlowInfoExtendMapper tbWorkFlowInfoExtendMapper;


    /**
     * 根据测点获取告警信息
     * @param queryConditon
     * @return
     */
    @Override
    public JSONObject getAlarmList(QueryConditon queryConditon) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = returnJSONArray(queryConditon.getUriList());
        JSONObject postJson = new JSONObject();
        postJson.put("uriList",jsonArray);
        logger.info("接口入参数据url={},postJson={}",dataAlarmUrl+"/model/alarm/queryAlarmByPointuri",JSON.toJSONString(jsonArray));
        jsonObject = HttpClientUtils.httpPost(dataAlarmUrl+"/model/alarm/queryAlarmByPointuri", jsonArray.toJSONString());
        logger.info("接口返回数据jsonObject={}",JSON.toJSONString(jsonObject));
        return  jsonObject;
    }

    @Override
    public JSONObject createSubscription(QueryConditon queryConditon) {
        JSONObject jsonObject = new JSONObject();
        jsonObject = HttpClientUtils.httpPost(socketUrl+"/subscription/create", jsonObject);
        logger.info("订阅结果={}",jsonObject);
        return  jsonObject;
    }

    @Override
    public JSONObject createByUri(MonitorCondition condition) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = returnMonitorConditionJSONArray(condition.getMonitoredItems());
        logger.info("创建监控项参数uri={},JSONArray={}",socketUrl+"/monitoreditem/createByUri?subscriptionId="+condition.getSubscriptionId(),jsonArray);
        jsonObject = HttpClientUtils.httpPost(socketUrl+"/monitoreditem/createByUri?subscriptionId="+condition.getSubscriptionId(), jsonArray.toJSONString());
        logger.info("创建监控项结果={}",jsonObject);
        return  jsonObject;
    }
    private JSONArray returnMonitorConditionJSONArray(List<MonitorCondition> list){
        JSONArray relations = new JSONArray();
        for (MonitorCondition real:list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("monitoredItemType",real.getMonitoredItemType());
            jsonObject.put("nodeUri",real.getNodeUri());
            relations.add(jsonObject);
        }
        return relations;
    }

    @Override
    public Map createSocket(QueryConditon queryConditon) {
        Map map = new HashMap(16);
        JSONObject jsonObject = createSubscription(queryConditon);
        String subscriptionId ="";
        String websocketUrl =null;
        //        //{"msg":"create subscription succeed.","result":{"maxNotificationsPerPublish":0,"requestedLifetimeCount":2400,"websocketUrl":"/monitor?sessionId=0252fdf3-2a50-4ff9-9dcc-ff6b90d19d13&subId=8e1296ed021746a7a0c39fbe0c60b4df","publishingEnabled":false,"requestedMaxKeepAliveCount":10,"sessionId":"0252fdf3-2a50-4ff9-9dcc-ff6b90d19d13","subscriptionId":"8e1296ed021746a7a0c39fbe0c60b4df","priority":0,"requestedPublishingInterval":500},"code":"0x00000000","success":true}
        if(jsonObject.getString("code").equals("0x00000000")){
            JSONObject result = jsonObject.getJSONObject("result");
            subscriptionId = result.getString("subscriptionId");
            websocketUrl = result.getString("websocketUrl");
        }
        map.put("websocketUrl",websocketUrl);

        MonitorCondition monitorConditionAdd = new MonitorCondition();
        List<MonitorCondition> monitorConditionList = new ArrayList<>();
        List<String> uriList = queryConditon.getUriList();
        for (String s : uriList) {
            MonitorCondition monitorCondition = new MonitorCondition();
            monitorCondition.setNodeUri(s);
            monitorConditionList.add(monitorCondition);
        }
        monitorConditionAdd.setSubscriptionId(subscriptionId);
        monitorConditionAdd.setMonitoredItems(monitorConditionList);
        JSONObject byUri = createByUri(monitorConditionAdd);
        //{"msg":"this subscription does not exists, please check the subscriptionId again.","code":"0x80000000","success":false}
        //2019-10-12 17:55:44.737  INFO 22872 --- [nio-8888-exec-1] c.e.opplat.service.impl.BewgServiceImpl  : 创建监控项结果={"msg":"创建监控项成功","result":[{"queueSize":1,"monitoringMode":"Reporting","monitoredItemType":"EVENT_BY_URI","nodeUri":"/Hollysys_Bewg_modelNew/5c662bba6201b7000141351a","samplingInterval":2000,"monitoredItemId":"92f39a95b6794c60bd638058fe50eb0b","attribute":"Value","subscriptionId":"df29bb6f3c3c478a9dfcf5f7f7cab566","discardOldest":true,"onlyChangeData":false}],"code":"0x00000000","success":true}
        if(byUri.getString("code").equals("0x80000000")){
            //接口失败
            map.put("websocketUrl",null);
        }
        return map;
    }

    @Override
    public JSONObject queryHistory( BewgPointCondition condition) {
        JSONObject jsonObject = new JSONObject();
        List<String> pathList = condition.getPathList();
        Map objmMap = new HashMap();
        ArrayList<Object> list = new ArrayList<>();
        for (String s : pathList) {
            Map map = new HashMap();
            map.put("continuePoint","");
            map.put("uri",s);
            list.add(map);
        }
        objmMap.put("vars",list);
        Map detailMap = new HashMap();
        detailMap.put("startTime",condition.getStartTime());
        detailMap.put("endTime",condition.getEndTime());
        double v = DateUtils.judgmentDate(condition.getStartTime(), condition.getEndTime());
        //setInterval(v,condition);
        detailMap.put("interval",600);
        detailMap.put("aggregateType","interpolation");
        detailMap.put("maxSizePerNode",100);
        objmMap.put("detail",detailMap);
        logger.info("获取测点历史插值查询入参数JSONArray={}",JSON.toJSONString(objmMap));
        jsonObject = HttpClientUtils.httpPost(hollysysAggUrl+"/aggquery/query/queryHistory", JSON.toJSONString(objmMap));
        logger.info("返回获取测点历史插值查询data={}",JSON.toJSONString(jsonObject));
        return jsonObject;
    }

    //根据时间差值判断
    public void setInterval(double time,BewgPointCondition condition){
        if(time<0.5d){
            condition.setInterval(60L);
        }else if(time<=24d){
            condition.setInterval(3600L);
        }else {
            condition.setInterval(86400L);
        }
    }

   /* public static void main(String[] args) {
        Map objmMap = new HashMap();
        List<String> pathList = new ArrayList<>();
        pathList.add("11");
        pathList.add("22");
        ArrayList<Object> list = new ArrayList<>();
        for (String s : pathList) {
            Map map = new HashMap();
            map.put("continuePoint","");
            map.put("uri",s);
            list.add(map);
        }
        objmMap.put("vars",list);
        Map detailMap = new HashMap();
        detailMap.put("startTime",10);
        detailMap.put("endTime",11);
        detailMap.put("interval",100);
        detailMap.put("aggregateType","interpolation");
        detailMap.put("maxSizePerNode",100);
        objmMap.put("detail",detailMap);
        *//*Map map = new HashMap();
        map.put("uri",pathList);
        Map re= new HashMap();
        re.put("vars",map);*//*
        System.out.println(JSON.toJSONString(objmMap));
    }*/
    
    //public List getAlarmListDurWeek(AlarmCondition alarmCondition) {
      /*  Calendar currCalendar = Calendar.getInstance();
        if(StringUtils.isEmpty(alarmCondition.getEndTime())){
            alarmCondition.setEndTime(DateUtils.formateDateFull(currCalendar.getTime()));
        }
        if(StringUtils.isEmpty(alarmCondition.getStartTime())){
            currCalendar.add(Calendar.DATE,-7);
            alarmCondition.setStartTime(DateUtils.formateDateFull(currCalendar.getTime()));
        }
        Map filterMap = new HashMap();
        filterMap.put("field","DeviceId");
        filterMap.put("operator","Equal");
        filterMap.put("value", Lists.newArrayList(alarmCondition.getFactoryUri()));
        alarmCondition.setFactoryUri(null);
        List filterList = new ArrayList();
        filterList.add(filterMap);
        Map subscrptionMap = new HashMap(16);
        subscrptionMap.put("filter",filterList);
        alarmCondition.setSubscrption(subscrptionMap);
        logger.info("报警历史查询参数Object={}",JSON.toJSONString(alarmCondition));
        JSONObject jsonObject = HttpClientUtils.httpPost(alarmReport+"/v1/event/subscription/alarm", JSON.toJSONString(alarmCondition));
        logger.info("报警历史查询结果jsonObject={}",jsonObject);

        List alarmList = new ArrayList();
        if(jsonObject!=null){
            JSONArray result = jsonObject.getJSONArray("result");
            for (int i = 0; i < result.size(); i++) {
                String obj = String .valueOf(result.get(i));
                alarmList.add(JSON.parse(obj));
            }

        }
        List<SewageSite> sewageSites = sewageSiteMapper.selectByConds(new SewageSite());
        dealData(alarmList,sewageSites.stream().filter(obj->obj.getBrowsePath()!=null).map(SewageSite::getBrowsePath).collect(Collectors.toList()),sewageSites);
        return alarmList;*/
   // }
    
    public List queryHistoryAlarmLast(String factoryUri) {
        List alarmList = new ArrayList();
        String url ="/v1/event/history/alarm/access";
            if(factoryUri!=null){
                QueryHistoryAlarmConditon condition = new QueryHistoryAlarmConditon();
                String[] split = factoryUri.split(",");
                //condition.setNodes( Arrays.asList(split));
                Date date = new Date();
                Calendar currCalendar = Calendar.getInstance();
                //condition.setStartTime(DateUtils.dateFormatFullXG(DateUtils.getNextDate(date,Integer.parseInt(dayValue))));
                condition.setEndTime(DateUtils.dateFormatFullXG(currCalendar.getTime()));
                
                currCalendar.add(Calendar.DATE,-15);
                condition.setStartTime(DateUtils.dateFormatFullXG(currCalendar.getTime()));
                Map filterMap = new HashMap();
                filterMap.put("field","DeviceId");
                filterMap.put("operator","Equal");
                filterMap.put("value",Arrays.asList(split));
                List filterList = new ArrayList();
                filterList.add(filterMap);
                //Map subscrptionMap = new HashMap(16)
                condition.setFilter(filterList);
                JSONObject jsonObject = HttpClientUtils.httpPost(dataAlarmUrl+url, JSON.toJSONString(condition));

                
                if(jsonObject!=null){
                    JSONArray result = jsonObject.getJSONArray("result");
                    for (int i = 0; i < result.size(); i++) {
                        String obj = String .valueOf(result.get(i));
                        alarmList.add(JSON.parse(obj));
                    }

                }
            }
        System.out.println(JSON.toJSONString(alarmList));
        return alarmList;
    }

    @Override
    public List queryHistoryAlarm(String factoryUri) {
        List alarmList = new ArrayList();
        String url ="/v1/event/subscription/alarm";
        if(factoryUri!=null){
            QueryHistoryAlarmConditon condition = new QueryHistoryAlarmConditon();
            String[] split = factoryUri.split(",");
            //condition.setNodes( Arrays.asList(split));
            Date date = new Date();
            Calendar currCalendar = Calendar.getInstance();
            Map filterMap = new HashMap();
            filterMap.put("field","DeviceId");
            filterMap.put("operator","Equal");
            filterMap.put("value",Arrays.asList(split));
            List filterList = new ArrayList();
            filterList.add(filterMap);
            //Map subscrptionMap = new HashMap(16)
            //condition.setFilter(filterList);
            Map subscrptionMap = new HashMap(16);
            subscrptionMap.put("filter",filterList);
            condition.setSubscrption(subscrptionMap);
            JSONObject jsonObject = HttpClientUtils.httpPost(dataAlarmUrl+url, JSON.toJSONString(condition));
            if(jsonObject!=null){
                JSONArray result = jsonObject.getJSONArray("result");
                for (int i = 0; i < result.size(); i++) {
                    String obj = String .valueOf(result.get(i));
                    alarmList.add(JSON.parse(obj));
                }

            }
        }
        System.out.println(JSON.toJSONString(alarmList));
        return alarmList;
    }

    @Override
    public JSONObject getAllAlarmByNodeUri(String nodeUri) {
        String url = hollysysAlarmUrl + "/model/opcua/getAllAlarmByNodeUri?nodeUri="+nodeUri;
        String strResult = HttpClientUtils.StringGet(url, "", "UTF-8", null);
        JSONObject jsonObject = JSONObject.parseObject(strResult);
        if("0x00000000".equals(jsonObject.getString("code"))){
            JSONObject resultJSONObject = new JSONObject();
            resultJSONObject.put("list",jsonObject.getJSONArray("result"));
            return   resultJSONObject;
        }else{
            return null;
        }
    }

    @Override
    public JSONObject addOrUpdateAlarms( JSONObject  jsonObject, String nameSpace ){
        String url = hollysysAlarmUrl + "/model/alarm/addOrUpdateAlarms?namespace=" + nameSpace;
        JSONObject resultJSONObject = HttpClientUtils.httpPost(url, jsonObject.toString());
        return resultJSONObject;
    }

    @Override
    public List<Map<String, Object>> queryAlarmByUri(String uri) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object>  mapBig =new LinkedHashMap<>();
        Map<String, Object>  map =new HashMap<>();
        map.put("limitValue",1);
        map.put("alarmLevel",1);
        map.put("alarmInfo","告警信息lcHigh");
        mapBig.put("lcHighLimit",map);
        Map<String, Object>  ggMap =new HashMap<>();
        ggMap.put("limitValue",1);
        ggMap.put("alarmLevel",1);
        ggMap.put("alarmInfo","告警信息gg");
        mapBig.put("ggLimit",ggMap);
        Map<String, Object>  gMap =new HashMap<>();
        gMap.put("limitValue",1);
        gMap.put("alarmLevel",1);
        gMap.put("alarmInfo","告警信息g");
        mapBig.put("gLimit",gMap);
        Map<String, Object>  dMap =new HashMap<>();
        dMap.put("limitValue",1);
        dMap.put("alarmLevel",1);
        dMap.put("alarmInfo","告警信息d");
        mapBig.put("dLimit",dMap);
        Map<String, Object>  ddMap =new HashMap<>();
        ddMap.put("limitValue",1);
        ddMap.put("alarmLevel",1);
        ddMap.put("alarmInfo","告警信息dd");
        mapBig.put("ddLimit",ddMap);
        Map<String, Object>  lcLowMap =new HashMap<>();
        lcLowMap.put("limitValue",1);
        lcLowMap.put("alarmLevel",1);
        lcLowMap.put("alarmInfo","告警信息lcLow");
        mapBig.put("lcLowLimit",lcLowMap);
        System.out.println(mapBig);
        list.add(mapBig);
        return list;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(DateUtils.getNextDate(new Date(),-7));
        System.out.println(Integer.parseInt("-7"));
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object>  mapBig =new LinkedHashMap<>();
        Map<String, Object>  map =new HashMap<>();
        map.put("limitValue",1);
        map.put("alarmLevel",1);
        map.put("alarmInfo","告警信息lcHigh");
        mapBig.put("lcHighLimit",map);
        Map<String, Object>  ggMap =new HashMap<>();
        ggMap.put("limitValue",1);
        ggMap.put("alarmLevel",1);
        ggMap.put("alarmInfo","告警信息gg");
        mapBig.put("ggLimit",ggMap);
        Map<String, Object>  gMap =new HashMap<>();
        gMap.put("limitValue",1);
        gMap.put("alarmLevel",1);
        gMap.put("alarmInfo","告警信息g");
        mapBig.put("gLimit",gMap);
        Map<String, Object>  dMap =new HashMap<>();
        dMap.put("limitValue",1);
        dMap.put("alarmLevel",1);
        dMap.put("alarmInfo","告警信息d");
        mapBig.put("dLimit",dMap);
        Map<String, Object>  ddMap =new HashMap<>();
        ddMap.put("limitValue",1);
        ddMap.put("alarmLevel",1);
        ddMap.put("alarmInfo","告警信息dd");
        mapBig.put("ddLimit",ddMap);
        Map<String, Object>  lcLowMap =new HashMap<>();
        lcLowMap.put("limitValue",1);
        lcLowMap.put("alarmLevel",1);
        lcLowMap.put("alarmInfo","告警信息lcLow");
        mapBig.put("lcLowLimit",lcLowMap);
        System.out.println(mapBig);
        list.add(mapBig);
        System.out.println(JSON.toJSON(list));

    }
}

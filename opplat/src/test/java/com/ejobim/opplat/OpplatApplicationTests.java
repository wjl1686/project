package com.ejobim.opplat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpplatApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /*@Autowired
    private TbTaskInfoMapper tbTaskInfoMapper;

    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private TbFillFormTaskMapper tbFillFormTaskMapper;

    @Test
    public void contextLoads() {
        TaskInfoCondition taskInfoCondition = new TaskInfoCondition();
        taskInfoCondition.setStartTime("2019-01-17");
        taskInfoCondition.setEndTime("2019-01-20");
        Map<String, Integer> taskInfoList = workOrderService.getTaskInfoList(taskInfoCondition);
        //List<TbTaskInfoVo> tbTaskInfoVos = tbTaskInfoMapper.selectTaskInfoList(taskInfoCondition);
        //taskInfoList.keySet()

        Iterator<Map.Entry<String, Integer>> entries = taskInfoList.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println(entry.getKey() +entry.getValue());
        }
    }

    @Test
    public void getCurrentTaskInfo() {
        System.out.println(workOrderService.getCurrentTaskInfo("2019-01-17").size());
    }

    @Test
    public void getCurrentMouthTaskInfo() {
        System.out.println(workOrderService.getCurrentMouthTaskInfo().size());
    }

    @Test
    public void getFillMouthTaskInfo() {
        //System.out.println(workOrderService.findFillTaskInfoList("","",null).size());
    }


    @Test
    public void getConfig() {
        //System.out.println(workOrderService.findFillTaskCofigList("2fee29b539954fc1a9bd505fce3e120c","2fee29b539954fc1a9bd505fce3e12u1").size());
    }
    @Autowired
    //private TbFillFormConfigMapper tbFillFormConfigMapper;
    @Test
    public void update() {
        //System.out.println(//workOrderService.findFillTaskCofigList("2fee29b539954fc1a9bd505fce3e120c",null,null,null));
    }
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedis() {
        String  userInfo = stringRedisTemplate.opsForValue().get("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ6aWQiOiJ1YWEiLCJ1c2VyX25hbWUiOiIxMzU4MTU1MTUwNiIsInNjb3BlIjpbIm9wZW5pZCIsImNvcmUiLCJ1YWEubm9uZSIsImFjcy5wb2xpY2llcy5yZWFkIiwiYWNzLnBvbGljaWVzLndyaXRlIiwiYWNzLmF0dHJpYnV0ZXMucmVhZCIsInByZWRpeC1hY3Muem9uZXMuZGVtby51c2VyIiwiYWNzLmF0dHJpYnV0ZXMud3JpdGUiLCJhY3Muem9uZXMuYWRtaW4iLCJwcmVkaXgtYWNzLnpvbmVzLmRlbW8uYWRtaW4iXSwiaXNzIjoiaHR0cDovLzE5Mi4xNjguNjYuMTU4OjE4MDgwL3VhYS9vYXV0aC90b2tlbiIsImV4cCI6MTU1Nzc2MTk4MCwiaWF0IjowLCJqdGkiOiIxNWVlMDgyNy1lODgzLTQ2ZWItYThkYi0zNzM4MGVkY2RjMmIiLCJjbGllbnRfaWQiOiJpbyJ9.jRIfE_Ghp935q-62x_U_eLwzK6tu6pMNfHuohGtq3yBPYILNpbcyTxlcJNBt2eOpeInyjmFg458ICkK2qrmERamWt0x8xFD8EXffOmSCbRHfTFRT-ms9rDBlg8paukH-6oXXop0_NhaPJMxFKkPn2uWA684_yELwEvBZq4-p-8XFAVAznshC14_WYs01jNoX8bcV3lVlJQj7KZw1yw0Kgqk1egNFiCwZW57nK5Znxb8DH2_tv0CO-BnqsEqU51lPMNcTPv-kQ77DxKFWCIGdKywEV1m0GVZ5irUdXcThR8nkjpQDyr-D0d8S-NaowUUlwAMYVsJGLMi0waHhTE4Mgw");

        System.out.println(userInfo);
        //System.out.println(tbFillFormTaskMapper.updateByTaskNo("2fee29b539954fc1a9bd505fce3e12u1",1));
    }


    @Autowired
    TbSynObjectMapper tbSynObjectMapper;
    @Test
    public void testTree() {
        TbSynObjectExample tbSynObjectExample = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = tbSynObjectExample.createCriteria();
        criteria.andFactoryNoEqualTo("4399dbe038cf43efa57dfd15290e2e13");
        List<TbSynObject> tbSynObjects = tbSynObjectMapper.selectByExample(tbSynObjectExample);
        List<Tree<TbSynObject>> trees = new ArrayList<>();
        tbSynObjects.forEach(menu -> {
            Tree<TbSynObject> tree = new Tree<>();
            tree.setId(menu.getUri());
            tree.setParentId(menu.getParentUri());
            tree.setText(menu.getDisplayname());
//            tree.setLevel(menu.getLevel().toString());
            //tree.setIcon(menu.getIcon());
            //tree.setUrl(menu.getUrl());
            trees.add(tree);
        });
        TreeUtils.build(trees);
        System.out.println(tbSynObjects.size());


    }
//    @Autowired
//    private TbSynFieldMapper tbSynFieldMapper;
//    @Test
//    public  void testParams(){
//        List<TbSynField> paramLists = tbSynFieldMapper.getParamLists("","/Hollysys_bewg_model/5c39a890a08e4500015e80ad");
//        System.out.println(paramLists.size());
//    }
    @Autowired
    private FactoryController factoryController;
    @Test
    public  void testFactoryList(){
        AjaxObject ajaxObject =factoryController.getFactoryList(null,null);
        System.out.println(ajaxObject.get("factoryInfo"));
    }

    @Test
    public  void testBewgTree() {
       *//* JSONArray jsonArray = new JSONArray();
        jsonArray.add(param);*//*
    *//*    JSONObject jsonObject = new JSONObject();
        jsonObject.put("namespace","Hollysys_bewg_model");
        jsonObject.put("queryTypeDefinition","true");*//*
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("depth",10);
        jsonObject1.put("forward","true");
        jsonObject1.put("id","5c39a185a08e4500015e7fe5");
        *//*String[] str = new String[3];
        str[0]="/0/35";
        str[1]="/0/46";
        str[2]="/0/47";*//*
        JSONArray str = new JSONArray();
        str.add("/0/35");
        str.add("/0/46");
        str.add("/0/47");
        jsonObject1.put("relations",str);
        //jsonObject.put("depthAndRelationQueryParam",jsonObject1);
        StringBuffer str1 = new StringBuffer();
        str1.append("Hollysys_bewg_model").append("?").append("queryTypeDefinition=true");
        JSONObject result = HttpClientUtils.httpPost("http://model-bewg-bewg.huawei.bewg.hiacloud.net.cn:80/model/opcua/queryTreeNode/depth/"+str1, jsonObject1.toString());
        System.out.println(result);
    }

    @Test
    public void testqueryCumulation() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("endTime","2018/07/02-23:59:59");
        jsonObject1.put("startTime", "2018/07/01-00:00:00");
        jsonObject1.put("uri","/Hollysys_bewg_model/5c39a995a08e4500015e81af");
        jsonObject1.put("value",1);
        jsonArray.add(jsonObject1);
        JSONObject result = HttpClientUtils.httpPost("http://model-bewg-bewg.huawei.bewg.hiacloud.net.cn:80/aggquery/query/queryCumulation", jsonArray.toString());
        System.out.println(result);
    }
    @Autowired
    BewgService bewgService;
    @Test
    public void testqueryCumulation11() {
        BewgQueryCumulation queryCumulation = new BewgQueryCumulation();
        queryCumulation.setEndTime("2018/07/02-23:59:59");
        queryCumulation.setStartTime("2018/07/01-00:00:00");
        queryCumulation.setUri("/Hollysys_bewg_model/5c39a995a08e4500015e81af");
        queryCumulation.setValue("1");
        List<BewgQueryCumulation> list = new ArrayList<>();
        list.add(queryCumulation);
        JSONObject result =bewgService.queryCumulation(list);
        System.out.println(result);
    }

    @Test
    public void testQueryAllFactroy() {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("forward",false);
        jsonObject1.put("maxSize",100);

        JSONArray relations = new JSONArray();
        relations.add("/0/40");
        jsonObject1.put("relations",relations);

        JSONArray uris = new JSONArray();
        uris.add("/system/1015");
        jsonObject1.put("uris",uris);

        JSONObject result = HttpClientUtils.httpPost("http://model-bewg-bewg.huawei.bewg.hiacloud.net.cn:80/model/v2/model/relationofnodes", jsonObject1.toString());
        System.out.println(result);
    }

    @Test
    public void testQueryAllFactroy11() {
        BewgQueryRelationofnodes model = new BewgQueryRelationofnodes();
        model.setForward("false");
        model.setMaxSize(100);
        List<String> real = new ArrayList<>();
        real.add("/0/40");
        model.setRelations(real);
        List<String> uri = new ArrayList<>();
        uri.add("/system/1015");
        model.setUris(uri);
        JSONObject result = bewgService.queryAllFactory(model);
        System.out.println(result);
    }

    @Autowired
    private TbParamMapper tbParamMapper;

    @Test
    public void testSaveTbParam() {
        BewgQueryTreeCondition condition = new BewgQueryTreeCondition();
        //{"forward":"true","depth":10,"relations":["/0/45"],"id":"5c528443147b260001341a70","namespace":"Hollysys_Bewg_modelNew","queryTypeDefinition":"true"}
        condition.setForward("true");
        condition.setDepth("9");
        List<String> real = new ArrayList<>();
        real.add("/0/45");
        condition.setRelations(real);
        condition.setId("5c51bb665c074c00011b47ee");//5c51bb665c074c00011b47ee   5c528443147b260001341a70
        condition.setNamespace("Hollysys_Bewg_modelNew");
        condition.setQueryTypeDefinition("true");
        JSONObject jsonObject = bewgService.queryTreeNode(condition);
        System.out.println(jsonObject.toString());
//        List<TbParam> list = new ArrayList<>();
//        JSONArray jsonArray = jsonObject.getJSONArray("result");
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//            JSONArray jsonArray1 = jsonObject1.getJSONArray("children");
//            for (int j = 0; j < jsonArray1.size(); j++) {
//                JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
//                json(jsonObject2, list, null);
//
//            }
//
//        }
//        System.out.println(list.size());
     *//* for (TbParam tbParam:list) {
            tbParamMapper.insertSelective(tbParam);
        JSONObject json = jsonArray.getJSONObject(0);
        List<String> serviceUriList = new ArrayList<>();
        String uri = json.getString("uri");
        JSONArray children = json.getJSONArray("children");
        digui(children, serviceUriList);
        /*for(int i=0;i<children.size();i++) {
            JSONObject child = children.getJSONObject(i);
            uri = child.getString("uri");
            serviceUriList.add(uri);
            JSONArray children1 = child.getJSONArray("children");
            for(int j=0;j<children1.size();j++) {
                JSONObject child1 = children1.getJSONObject(j);
                if(child1==null){
                    System.out.println("child1"+j);
                    return;
                }
                uri = child1.getString("uri");
                serviceUriList.add(uri);
                if(child1.getJSONArray("children")!=null){
                    JSONArray  children2 = child1.getJSONArray("children");
                    if(children2==null){
                        System.out.println("children2"+j);
                        return;
                    }
                    for(int t=0;t<children2.size();t++) {
                        JSONObject child2 = children2.getJSONObject(t);
                        if(child2==null){
                            System.out.println("child2"+t);
                            return;
                        }
                        uri = child2.getString("uri");
                        serviceUriList.add(uri);
                    }
                }
            }
        }*//*



    }


    @Test
    public void test222() {
        //定时任务使用
        //查询本地水厂
       *//* TbSynObjectExample tbSynObjectExample = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = tbSynObjectExample.createCriteria();
        criteria.andFactoryNoEqualTo("5c748f4f1c5fda00013b904d");
        List<TbSynObject> tbSynObjects = tbSynObjectMapper.selectByExample(tbSynObjectExample);
        //取出水厂uri
        List<String> dbUriList = tbSynObjects.stream().map(TbSynObject::getUri).collect(Collectors.toList());*//*
        //查询远端水厂
        BewgQueryTreeCondition condition = new BewgQueryTreeCondition();// 6276    //2912
        condition.setId("5c662ed96201b70001413521");//安娜二五 5c662ed96201b70001413521  5c748f4f1c5fda00013b904d
        condition.setForward(Constant.FORWARD);
        condition.setDepth(Constant.DEPTH);
        List<String> real = new ArrayList<>();
        //"/0/35","/0/46","/0/47"
        real.add(Constant.RELATION1);
        real.add(Constant.RELATION2);
        real.add(Constant.RELATION3);
        condition.setRelations(real);
        condition.setNamespace(Constant.NAMESPACE);
        condition.setQueryTypeDefinition(Constant.QUERYTYPEDEFINITION);
        JSONObject jsonObject = bewgService.queryTreeNode(condition);
        if (jsonObject == null) {
            System.out.println("接口失败");
            return;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("result");

        JSONObject json = jsonArray.getJSONObject(0);
        List<String> serviceUriList = new ArrayList<>();
        String uri = json.getString("uri");
        JSONArray children = json.getJSONArray("children");
        digui(children, serviceUriList);
        *//*for(int i=0;i<children.size();i++) {
            JSONObject child = children.getJSONObject(i);
            uri = child.getString("uri");
            serviceUriList.add(uri);
            JSONArray children1 = child.getJSONArray("children");
            for(int j=0;j<children1.size();j++) {
                JSONObject child1 = children1.getJSONObject(j);
                if(child1==null){
                    System.out.println("child1"+j);
                    return;
                }
                uri = child1.getString("uri");
                serviceUriList.add(uri);
                if(child1.getJSONArray("children")!=null){
                    JSONArray  children2 = child1.getJSONArray("children");
                    if(children2==null){
                        System.out.println("children2"+j);
                        return;
                    }
                    for(int t=0;t<children2.size();t++) {
                        JSONObject child2 = children2.getJSONObject(t);
                        if(child2==null){
                            System.out.println("child2"+t);
                            return;
                        }
                        uri = child2.getString("uri");
                        serviceUriList.add(uri);
                    }
                }
            }
        }*//*
        System.out.println(serviceUriList.size());
    }
    public void json(JSONObject jsonObject, List<TbParam> list, String parentUri) {
        TbParam tbParam = new TbParam();
        String name = jsonObject.getString("name");
        String uri = jsonObject.getString("uri");
        tbParam.setName(name);
        tbParam.setUri(uri);
        tbParam.setType(2);
        tbParam.setParentUri(parentUri);
        list.add(tbParam);
        if (jsonObject.containsKey("children") && null!=jsonObject.get("children")) {
            JSONArray jsonArray1 = jsonObject.getJSONArray("children");
            if (jsonArray1 != null) {
                for (int j = 0; j < jsonArray1.size(); j++) {
                    json(jsonArray1.getJSONObject(j), list, uri);
                }
            }

        }

    }


    public void digui(JSONArray array, List<String> str) {

        for (int i = 0; i < array.size(); i++) {
            JSONObject childJSON = array.getJSONObject(i);
            String uri = childJSON.getString("uri");

            if (childJSON.containsKey("typeDefinitionUri") &&
                    ("/system/2006".equals(childJSON.getString("typeDefinitionUri"))
                            || "/system/2005".equals(childJSON.getString("typeDefinitionUri")))) {
                continue;
            }
            System.out.println(childJSON.getString("name"));
            //
            str.add(uri);

            if (childJSON.getJSONArray("children") != null) {
                JSONArray children1 = childJSON.getJSONArray("children");
                digui(children1, str);
            }
        }
    }*/

    @Test
    public void getAA(){
        stringRedisTemplate.opsForValue().set("ttt", "888", 2, TimeUnit.DAYS);

        System.out.println(stringRedisTemplate.opsForValue().get("ttt"));
        stringRedisTemplate.opsForValue().set("ttt222", "redis4bf77f71a1e749edb3c88ab051c57aca", 2, TimeUnit.DAYS);
        System.out.println(stringRedisTemplate.opsForValue().get("ttt222"));

    }

}

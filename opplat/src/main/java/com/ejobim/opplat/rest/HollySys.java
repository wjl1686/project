package com.ejobim.opplat.rest;

import org.springframework.stereotype.Component;

@Component
public class HollySys {
  /*  @Value("${hollysys-model-url}")
    private String hollysysUrl;

    @Value("${hollysys-analysis-url}")
    private String analysisUrl;
    @Autowired
    private TbFactoryService factoryService;
    @Autowired
    private TbSynObjectService tbSynObjectService;
    @Autowired
    private FactoryModel factoryModel;
    @Autowired
    private TbObjectDataMapper tbObjectDataMapper;
    @Autowired
    private TbSynBaseDetailMapper tbSynBaseDetailMapper;
    @Autowired
    private TbFactoryVideoMapper factoryVideoMapper;

    @Autowired
    TbSynObjectMapper tbSynObjectMapper;

    public List<TbFactoryInfo> getFactoryList(){
        JSONObject result = HttpClientUtils.httpPost(hollysysUrl + "/model/v2/model/relationofnodes", createFactoryInfoPostInfo());
        JSONArray factoryArray = result.getJSONArray("result").getJSONObject(0).getJSONArray("nodes");
        System.out.println(result);
        List<TbFactoryInfo> myFactoryList  = factoryService.getTbFactoryInfoList(new TbFactoryInfo());

        List<TbFactoryInfo> list = new ArrayList<>();
        for(int i=0;i<factoryArray.size();i++){
            JSONObject factoryJSon = factoryArray.getJSONObject(i).getJSONObject("nodeValues");
            String uri = factoryJSon.getString("uri");
            String factoryNo = uri.split("/")[2];
            String factoryName = factoryJSon.getString("DisplayName");
            //剔除模型数据中的测试数据
            if(factoryName.indexOf("测试")>=0){
                continue;
            }
            TbFactoryInfo factoryInfo = new TbFactoryInfo();
            factoryInfo.setUri(factoryJSon.getString("uri"));
            factoryInfo.setFactoryName(factoryJSon.getString("DisplayName"));
            factoryInfo.setFactoryNo(factoryNo);
            factoryInfo.setBrowsename(factoryJSon.getString("BrowseName"));
            factoryInfo.setBrowsepath(factoryJSon.getString("BrowsePath"));
            factoryInfo.setCreateTime(new Date());
            list.add(factoryInfo);
        }
        List<TbFactoryVideo> factoryVideoList = factoryVideoMapper.selectByExample(new TbFactoryVideoExample());
        List<String> videoNoList = factoryVideoList.stream().map(TbFactoryVideo::getFactoryNo).collect(Collectors.toList());
        //重复判断
        for(TbFactoryInfo factoryInfo:list){
            boolean had = false;
            for(TbFactoryInfo tbFactoryInfo:myFactoryList){
                if(factoryInfo.getUri().equals(tbFactoryInfo.getUri())){
                    had = true;
                    break;
                }
            }
            if(!videoNoList.contains(factoryInfo.getFactoryNo())){
                TbFactoryVideo factoryVideo = new TbFactoryVideo();
                factoryVideo.setFactoryNo(factoryInfo.getFactoryNo());
                factoryVideo.setHasvideo(0);
                factoryVideoMapper.insertSelective(factoryVideo);
            }
            if(!had){
                factoryService.addFactory(factoryInfo);
                //标记为新加水厂
                factoryInfo.setValue("true");
            }else{
                factoryService.updateFactory(factoryInfo);
            }
        }



        return list;
    }

    public List<TbFactoryInfo> getFactoryListOwn(){
        List<TbFactoryInfo> myFactoryList  = factoryService.getTbFactoryInfoList(new TbFactoryInfo());

        return myFactoryList;
    }

    private String createFactoryInfoPostInfo(){
        JSONObject json = new JSONObject();
        json.put("forward",false);
        //json.put("maxSize",1000);

        JSONArray relations = new JSONArray();
        relations.add("/0/40");
        json.put("relations",relations);

        JSONArray uris = new JSONArray();
        uris.add("/system/1015");
        json.put("uris",uris);

        return json.toString();
    }


    public JSONObject getFactoryModelWeb(String factoryUri){
        try{
            StringBuffer stringBuffer = new StringBuffer();
            String[] strs = factoryUri.split("/");
            String workSpace = strs[1];
            String factoryNo = strs[2];
            stringBuffer.append(workSpace).append("?").append("queryTypeDefinition=true");
            String url = hollysysUrl + "/model/opcua/queryTreeNode/depth/" + stringBuffer.toString();
            String postInfo = createFactoryTreePostInfo(factoryNo);
            JSONObject result = HttpClientUtils.httpPost(url, postInfo);
            if(result!=null){
                System.out.println(result.toString());
            }
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void saveFactoryModelToFile(String factoryNo,String factoryUri){
        JSONObject result = getFactoryModelWebNew(factoryUri);
        if(result!=null){
            //FileUtils.fileLinesWrite("/home/server/syndata/data/"+factoryNo+".json",result.toString(),false);
            FileUtils.fileLinesWrite("D:/data/"+factoryNo+"_1.json",result.toString(),false);
        }
    }

    *//**
     * 同步数据
     * @param factoryUri
     * @param factoryNo
     * @param type 1：从Web获取数据，2：从本地文件同步数据
     * @return
     *//*
    public List<TbSynObject> getFactoryTree(String factoryUri,String factoryNo,int type){

        JSONObject resultOld ;
        JSONObject result ;
        result = getFactoryModelWebNew(factoryUri);
        if(result.getIntValue("totalCount")>0){
            int pointsDataLimit = 3000;
            factoryModel.parseModel(result,factoryUri,factoryNo);

            List<TbSynObject> tbSynObjects = factoryModel.tbSynObjectList;
            if(tbSynObjects.size()<10){
                return null;
            }
            tbSynObjectService.deleteByFactoryNo(factoryNo);

            System.out.println(tbSynObjects.size());

            //tbSynObjectService.insertBatch(tbSynObjects);
            List<TbSynObject> tbSynList  = new ArrayList<>();
            for(int i=0;i<tbSynObjects.size();i++){
                tbSynList.add(tbSynObjects.get(i));
                if(pointsDataLimit == tbSynList.size()||i == tbSynObjects.size()-1){
                    tbSynObjectService.insertBatch(tbSynList);
                    tbSynList.clear();
                }
            }

            List<TbObjectData> tbObjectDataList = factoryModel.tbObjectDataList;
            deleteTbObjectDataList(factoryNo);

            List<TbObjectData> newList = new ArrayList<TbObjectData>();
            //分批次处理
            for(int i=0;i<tbObjectDataList.size();i++){
                newList.add(tbObjectDataList.get(i));
                if(pointsDataLimit == newList.size()||i == tbObjectDataList.size()-1){
                    tbObjectDataMapper.insertBatch(newList);
                    newList.clear();
                }
            }
            System.out.println(tbSynObjects.size());


            deleteSynBaseDetailList(factoryNo);
            List<TbSynBaseDetail> tbSynBaseDetailList = factoryModel.tbSynBaseDetailList;

            List<TbSynBaseDetail> newList2 = new ArrayList<TbSynBaseDetail>();
            for(int i=0;i<tbSynBaseDetailList.size();i++){//分批次处理
                newList2.add(tbSynBaseDetailList.get(i));
                if(pointsDataLimit == newList2.size()||i == tbSynBaseDetailList.size()-1){
                    tbSynBaseDetailMapper.insertBatch(newList2);
                    newList2.clear();


                }
            }
        }

        return null;

    }

    private JSONObject getFactoryModelWebNew(String factoryUri) {

        try{
            String url = analysisUrl+"/analysis/app/queryFileByUri?uri=" + factoryUri ;
            String str = null;
            JSONObject result = HttpClientUtils.httpPost(url,str);
            if(result!=null){
                System.out.println(result.toString());
            }
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    private void deleteSynBaseDetailList(String factoryNo){
        TbSynBaseDetailExample example =new TbSynBaseDetailExample();
        TbSynBaseDetailExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        tbSynBaseDetailMapper.deleteByExample(example);
    }

    private void deleteTbObjectDataList(String factoryNo){
        TbObjectDataExample example =new TbObjectDataExample();
        TbObjectDataExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        criteria.andDataFromEqualTo(0);
        tbObjectDataMapper.deleteByExample(example);
    }

    private String createFactoryTreePostInfo(String factoryUri){
        JSONObject json = new JSONObject();
        json.put("depth",9);
        json.put("forward","true");
        json.put("id",factoryUri);

        JSONArray str = new JSONArray();
        str.add("/0/35");
        str.add("/0/46");
        str.add("/0/47");
        json.put("relations",str);
        System.out.println(json.toString());
        return json.toString();
    }

    public static void main(String[] args){
        List<String> infos = FileUtils.readFileContent("D:/fa3.json");
        JSONObject result = JSONObject.parseObject(infos.get(0));
        FactoryModel factoryModel = new FactoryModel();
        factoryModel.parseModel(result,"/Hollysys_Bewg_modelNew/5c748f4f1c5fda00013b904d","5c748f4f1c5fda00013b904d");
        List<TbSynBaseDetail> tbSynBaseDetailList = factoryModel.tbSynBaseDetailList;
        for(int i=0;i<100;i++){
            System.out.println(i + ":" +tbSynBaseDetailList.get(i).toString());
        }

    }*/

}

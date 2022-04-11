package com.ejobim.opplat.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbObjectData;
import com.ejobim.opplat.domain.TbSynBaseDetail;
import com.ejobim.opplat.domain.TbSynObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FactoryModel {
    private static Integer zero = 0;
    private static Integer one = 1;
    //水厂类型
    private static Integer factoryType = 1;
    //工艺段类型
    private static Integer gongyiType = 2;
    //设备类型
    private static Integer equipType = 3;
    //测点类型
    private static Integer varType = 4;
    //水厂静态类型
    private final static String factoryBaseDefineType = "/Hollysys_Bewg_modelNew/5c62602f147b260001343173";
    //水厂类型
    private final static String factoryDefineType = "/system/1015";
    //手动填报类型
    private final static String manualDefineType = "/system/2003";
    //数据库手动填报类型
    private final static int manualMyDefineType = 1;
    //自动填报类型
    private final static String autoDefineType = "/system/2004";
    //数据库自动填报类型
    private final static int autoMyDefineType = 2;
    //设备静态属性
    private final static String staticType = "/system/2006";
    //设备参数
    private final static String paramType = "/system/2005";


    public List<TbSynObject> tbSynObjectList ;
    public  List<TbObjectData> tbObjectDataList;
    //存储静态属性类字段
    public List<TbSynBaseDetail> tbSynBaseDetailList;



    public  void
    parseModel(JSONObject jsonObject,String factoryUri,String factoryNo){
        tbSynObjectList = new ArrayList<>();
        tbObjectDataList  = new ArrayList<>();
        tbSynBaseDetailList  = new ArrayList<>();
        JSONObject json = jsonObject.getJSONArray("result").getJSONObject(0);
        //处理水厂本身
        TbSynObject tbSynObject = parseTbSynObjectFactory(json,null,factoryUri, factoryNo);
        tbSynObject.setFieldType(0);
        tbSynObject.setCreateTime(new Date());
        tbSynObject.setType(factoryType);

        JSONArray children = json.getJSONArray("children");
        if(children!=null){
            tbSynObjectList.add(tbSynObject);
            List<TbSynObject> list = new ArrayList<>();

            for (int i = 0; i < children.size(); i++) {
                JSONObject child = children.getJSONObject(i);
                TbSynObject synObject = parseTbSynObject(child,factoryUri, factoryUri, factoryNo, 2, factoryUri);
                if(synObject!=null){
                    list.add(synObject);
                }
            }
            getAllSynObject(list);
        }

    }

    /**
     * 解析水厂模型
     * @param jsonObject
     * @param parentUri
     * @param factoryUri
     * @param factoryNo
     * @return
     */
    private  TbSynObject parseTbSynObjectFactory(JSONObject jsonObject,String parentUri,String factoryUri,String factoryNo){
        //排除水厂类型
        String typeDefinitionUri = jsonObject.getString("typeDefinitionUri");
        int fieldType = 0;
        Integer type = 1;
        String  uri =  jsonObject.getString("uri");
        String  order =  jsonObject.getString("order");
        String DisplayName = jsonObject.getJSONObject("properties").getString("DisplayName");
        String browseName = jsonObject.getJSONObject("properties").getString("BrowseName");
        String browsePath = jsonObject.getJSONObject("properties").getString("BrowsePath");
        //保存tbSynObjectMapper 表
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setUri(jsonObject.getString("uri"));
        tbSynObject.setName(DisplayName);
        tbSynObject.setBrowsename(browseName);
        tbSynObject.setDisplayname(DisplayName);
        if("/Hollysys_Bewg_modelNew/5c75ed93f0313e0001152fe6".equals(jsonObject.getString("uri"))){
            System.out.println("11111");
        }
        if(order!=null){
            tbSynObject.setSortOrder(Long.valueOf(order));
        }
        if (jsonObject.getJSONObject("properties").containsKey("BrowsePath")) {
            tbSynObject.setBrowsepath(jsonObject.getJSONObject("properties").getString("BrowsePath"));
        }
        if (jsonObject.getJSONObject("properties").containsKey("AccessLevel")) {
            tbSynObject.setAccesslevel(jsonObject.getJSONObject("properties").getString("AccessLevel"));
        }
        tbSynObject.setParentUri(null);
        //判断该测点是否有值
         tbSynObject.setHasvalue(zero);
        //1:水厂，2：工艺；3：设备；4：测点',
        tbSynObject.setType(type);
        tbSynObject.setFieldType(fieldType);
        tbSynObject.setLevel(1);
        tbSynObject.setFactoryNo(factoryNo);
        tbSynObject.setFactoryUri(factoryUri);
        tbSynObject.setCreateTime(new Date());
        return tbSynObject;
    }

    private  TbSynObject parseTbSynObject(JSONObject jsonObject,String parentUri,String factoryUri,String factoryNo,int level,String parentBrowsePath){
        //获取类型定义
        String typeDefinitionUri = jsonObject.getString("typeDefinitionUri");
        int fieldType = 0;
        Integer type = 1;
        if(factoryBaseDefineType.equals(typeDefinitionUri)||staticType.equals(typeDefinitionUri)||paramType.equals(typeDefinitionUri)){
            if(factoryBaseDefineType.equals(typeDefinitionUri)){
                getStaticInfo(jsonObject,parentUri,factoryNo,1);
            } else {
                getStaticInfo(jsonObject,parentUri,factoryNo,0);
            }
            return null;
            //水厂
        } else if(factoryDefineType.equals(jsonObject.getString("typeDefinitionUri"))){
            type = factoryType;
            //手动填报
        }else  if (manualDefineType.equals(jsonObject.getString("typeDefinitionUri"))) {
            fieldType = 1;
            type = varType;
            //自动填报
        } else if (autoDefineType.equals(jsonObject.getString("typeDefinitionUri"))) {
            fieldType = 2;
            type = varType;
        }else{
            type = gongyiType;
        }

        String  uri =  jsonObject.getString("uri");
        String  order =  jsonObject.getString("order");
        String DisplayName = jsonObject.getJSONObject("properties").getString("DisplayName");

        String browseName = jsonObject.getJSONObject("properties").getString("BrowseName");

        //保存tbSynObjectMapper 表
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setUri(jsonObject.getString("uri"));
        tbSynObject.setName(DisplayName);
        tbSynObject.setBrowsename(browseName);
        //将类型存储
        tbSynObject.setFieldUri(typeDefinitionUri);
        tbSynObject.setDisplayname(DisplayName);
        if(order!=null){
            tbSynObject.setSortOrder(Long.valueOf(order));
        }
        String browsePath =  parentBrowsePath + "/" +browseName;

        tbSynObject.setBrowsepath(browsePath);

        if (jsonObject.getJSONObject("properties").containsKey("AccessLevel")) {
            tbSynObject.setAccesslevel(jsonObject.getJSONObject("properties").getString("AccessLevel"));
        }
        if(parentUri!=null){
            tbSynObject.setParentUri(parentUri);
        }
        //判断该测点是否有值
        if (jsonObject.getJSONObject("properties").containsKey("Value")) {
            if ("".equals(jsonObject.getJSONObject("properties").getString("Value"))) {
                tbSynObject.setHasvalue(zero);
            } else{
                tbSynObject.setHasvalue(one);
                if(fieldType==2){
                    System.out.println(browsePath);
                }
            }

        } else {
            tbSynObject.setHasvalue(zero);
        }
        //1:水厂，2：工艺；3：设备；4：测点',
        tbSynObject.setType(type);
        tbSynObject.setFieldType(fieldType);
        tbSynObject.setLevel(level);
        tbSynObject.setFactoryNo(factoryNo);
        tbSynObject.setFactoryUri(factoryUri);
        tbSynObject.setCreateTime(new Date());

        if (jsonObject.containsKey("children")
                && jsonObject.get("children") != null
                && !"null".equals(jsonObject.get("children").toString())) {
            JSONArray array = jsonObject.getJSONArray("children");
            List<TbSynObject> tbList = new ArrayList<TbSynObject>();
            for (int i = 0; i < array.size(); i++) {
                JSONObject childJSON = array.getJSONObject(i);
                TbSynObject childSynObject  = parseTbSynObject(childJSON,tbSynObject.getUri(), factoryUri, factoryNo, level + 1,browsePath);
                if(childSynObject!=null){
                    tbList.add(childSynObject);
                }
            }
            tbSynObject.setTbSynObjectList(tbList);
        }

        return tbSynObject;
    }

    private  void getAllSynObject(List<TbSynObject> list) {
        for (TbSynObject synObject : list) {
            synObject.setCreateTime(new Date());
            tbSynObjectList.add(synObject);
            getChildSynObject(synObject);
        }
    }

    private   void  getChildSynObject(TbSynObject tbSynObject) {
        if (tbSynObject.getTbSynObjectList() != null && tbSynObject.getTbSynObjectList().size() > 0) {
            for (TbSynObject childSynObject : tbSynObject.getTbSynObjectList()) {
                childSynObject.setCreateTime(new Date());

                tbSynObjectList.add(childSynObject);
                if (childSynObject.getType() != varType) {
                    getChildSynObject(childSynObject);
                    tbSynObject.getTbChildSynObjectList().addAll(childSynObject.getTbChildSynObjectList());
                } else {
                    tbSynObject.getTbChildSynObjectList().add(childSynObject);
                }
            }
        }
        //tb_object_data
        if (tbSynObject.getTbChildSynObjectList() != null && tbSynObject.getTbChildSynObjectList().size() > 0) {
            for (TbSynObject synObject : tbSynObject.getTbChildSynObjectList()) {
                TbObjectData objectData = new TbObjectData();
                objectData.setDataUri(synObject.getUri());
                objectData.setCreateTime(new Date());
                objectData.setDataFrom(0);
                objectData.setFactoryNo(synObject.getFactoryNo());
                objectData.setObjectUri(tbSynObject.getUri());
                tbObjectDataList.add(objectData);
            }
        }
    }

    /**
     *
     * @param jsonObject
     * @param parentUri
     * @param factoryNo
     * @param cycle 循环获取基础属性
     * @return
     */
    private  void getStaticInfo(JSONObject jsonObject,String parentUri,String factoryNo,int cycle){
        TbSynBaseDetail tbSynBaseDetail = new TbSynBaseDetail();
        String typeDefinitionUri = jsonObject.getString("typeDefinitionUri"); //排除水厂类型
        String name = jsonObject.getString("name"); //排除水厂类型
        String  uri =  jsonObject.getString("uri");
        String displayName = jsonObject.getJSONObject("properties").getString("DisplayName");
        String browseName = jsonObject.getJSONObject("properties").getString("BrowseName");
        String browsePath = jsonObject.getJSONObject("properties").getString("BrowsePath");
        String description = jsonObject.getJSONObject("properties").getString("Description");
        String value = jsonObject.getJSONObject("properties").getString("Value");

        tbSynBaseDetail.setUri(uri);
        tbSynBaseDetail.setDisplayname(displayName);
        tbSynBaseDetail.setBrowsename(browseName);
        tbSynBaseDetail.setBrowsepath(browsePath);
        tbSynBaseDetail.setDescription(description);
        tbSynBaseDetail.setParentUri(parentUri);
        tbSynBaseDetail.setFactoryNo(factoryNo);
        tbSynBaseDetail.setTypedefinitionuri(typeDefinitionUri);
        tbSynBaseDetail.setName(name);
        tbSynBaseDetail.setCreateTime(new Date());
        tbSynBaseDetail.setValue(value);
        if(cycle==0){
            tbSynBaseDetailList.add(tbSynBaseDetail);
        } else{
            if (jsonObject.containsKey("children")
                    && jsonObject.get("children") != null
                    && !"null".equals(jsonObject.get("children").toString())) {
                JSONArray array = jsonObject.getJSONArray("children");
                for(int i=0;i<array.size();i++){
                    getStaticInfo(array.getJSONObject(i),parentUri,factoryNo,0);
                }
            }

        }

    }


}

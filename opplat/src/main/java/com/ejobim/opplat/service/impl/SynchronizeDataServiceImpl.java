package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Constant;
import com.ejobim.opplat.domain.TbFactoryInfo;
import com.ejobim.opplat.domain.TbObjectData;
import com.ejobim.opplat.domain.TbSynObject;
import com.ejobim.opplat.domain.condition.BewgQueryTreeCondition;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.mapper.TbObjectDataMapper;
import com.ejobim.opplat.mapper.TbSynObjectMapper;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.SynchronizeDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SynchronizeDataServiceImpl implements SynchronizeDataService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BewgService bewgService;
    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;
    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;
    @Autowired
    private TbObjectDataMapper tbObjectDataMapper;

    List<TbSynObject> tbSynObjectList = new ArrayList<>();
    private Integer zroe = 0;
    private Integer one = 1;
    private Integer two = 2;

    @Override
    public void insertData(String factroy) {
        BewgQueryTreeCondition condition = new BewgQueryTreeCondition();
        condition.setId(factroy);
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
        saveData(jsonObject.getJSONArray("result"), condition.getNamespace());
    }

    @Transactional
    void saveData(JSONArray jsonArray, String namespace) {
        JSONObject json = jsonArray.getJSONObject(0);
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        String uri = json.getString("uri");
        String factoryNo = json.getString("uri").replace("/" + namespace + "/", "");
        String factoryName = json.getJSONObject("properties").getString("DisplayName");
        String browseName = json.getJSONObject("properties").getString("BrowseName");
        String browsePath = json.getJSONObject("properties").getString("BrowsePath");
        tbFactoryInfo.setFactoryNo(factoryNo);
        tbFactoryInfo.setUri(uri);
        tbFactoryInfo.setFactoryName(factoryName);
        tbFactoryInfo.setBrowsename(browseName);
        tbFactoryInfo.setBrowsepath(browsePath);
        //保存工厂表
        tbFactoryInfoMapper.insert(tbFactoryInfo);
        //保存tbSynObjectMapper 表
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setFactoryUri(uri);
        tbSynObject.setFactoryNo(factoryNo);
        tbSynObject.setUri(json.getString("uri"));
        tbSynObject.setName(factoryName);
        tbSynObject.setBrowsename(browseName);
        tbSynObject.setDisplayname(factoryName);
        //Integer value =1;
        tbSynObject.setHasvalue(one);
        //1:水厂，2：工艺；3：设备；4：测点',
        tbSynObject.setType(one);
        tbSynObject.setLevel(1);
        tbSynObjectMapper.insertSelective(tbSynObject);
        //
        JSONArray children = json.getJSONArray("children");
        for (int i = 0; i < children.size(); i++) {
            JSONObject child = children.getJSONObject(i);
            tbSynObjectList.add(getTbSynObject(child, uri, factoryNo, 2));
        }
        displayInfo(tbSynObjectList);
    }


    private TbSynObject getTbSynObject(JSONObject child, String uri, String factoryNo, int level) {

        if ("/Hollysys_Bewg_modelNew/5c6fba511c5fda00012833bc".contentEquals(child.getString("uri"))) {
            System.out.println("1111");
        }
        TbSynObject tbSynObject = new TbSynObject();
        tbSynObject.setFactoryUri(uri);
        tbSynObject.setFactoryNo(factoryNo);
        tbSynObject.setUri(child.getString("uri"));
        tbSynObject.setName(child.getString("name"));
        tbSynObject.setBrowsename(child.getJSONObject("properties").getString("BrowseName"));
        tbSynObject.setDisplayname(child.getJSONObject("properties").getString("DisplayName"));
        if (child.containsKey("typeDefinitionUri")) {

        }
        if (child.getJSONObject("properties").containsKey("BrowsePath")) {
            tbSynObject.setBrowsepath(child.getJSONObject("properties").getString("BrowsePath"));
        }
        if (uri != null)
            tbSynObject.setParentUri(uri);


        if ("Variable".equals(child.getJSONObject("properties").getString("NodeClass"))) {
            //1:水厂，2：工艺；3：设备；4：测点',
            Integer value = 4;
            tbSynObject.setType(value);
            if (child.getJSONObject("properties").containsKey("AccessLevel"))
                tbSynObject.setAccesslevel(child.getJSONObject("properties").getString("AccessLevel"));
            if (child.getJSONObject("properties").containsKey("Value")) {
                if ("".equals(child.getJSONObject("properties").getString("Value"))) { //
                    tbSynObject.setHasvalue(zroe);
                } else
                    tbSynObject.setHasvalue(one);
            } else {
                tbSynObject.setHasvalue(zroe);
            }
            if (child.containsKey("typeDefinitionUri")) {
                if ("/system/2003".equals(child.getString("typeDefinitionUri"))) {
                    tbSynObject.setFieldType(1);
                } else if ("/system/2004".equals(child.getString("typeDefinitionUri"))) {
                    tbSynObject.setFieldType(2);
                }
            }
        } else {
            //1:水厂，2：工艺；3：设备；4：测点',
            tbSynObject.setType(two);
            List<TbSynObject> tbSynObjectList = new ArrayList<TbSynObject>();
            //List<TbSynObject> fieldList = new ArrayList<TbSynObject>();
            if (child.containsKey("children")
                    && child.get("children") != null
                    && !"null".equals(child.get("children").toString())) {
                JSONArray array = child.getJSONArray("children");
                for (int i = 0; i < array.size(); i++) {
                    JSONObject childJSON = array.getJSONObject(i);
                    if (childJSON.containsKey("typeDefinitionUri") &&
                            ("/system/2006".equals(childJSON.getString("typeDefinitionUri"))
                                    || "/system/2005".equals(childJSON.getString("typeDefinitionUri")))) {
                        continue;
                    }
                    //
                    tbSynObjectList.add(getTbSynObject(childJSON, uri, factoryNo, level + 1));


                }
            }
            tbSynObject.setTbSynObjectList(tbSynObjectList);
        }
        return tbSynObject;

    }

    public void displayInfo(List<TbSynObject> tbSynObjectList) {
        //System.out.println(tbSynObjectList.size());
        List<TbSynObject> list = new ArrayList<>();
        for (TbSynObject tbSynObject : tbSynObjectList) {
            tbSynObject.setCreateTime(new Date());
            list.add(tbSynObject);
            showTbSynObject(tbSynObject, list);
        }
        tbSynObjectMapper.insertBatch(list);
        System.out.println(list.size());
    }

    private void showTbSynObject(TbSynObject tbSynObject, List<TbSynObject> list) {
//		System.out.println(tbSynObject.getLevel() + ":" + tbSynObject.toString());
        if (tbSynObject.getTbSynObjectList().size() > 0 && tbSynObject.getTbSynObjectList() != null) {
            for (TbSynObject tbSynObjectChild : tbSynObject.getTbSynObjectList()) {
                list.add(tbSynObjectChild);
                //1:水厂，2：工艺；3：设备；4：测点',
                if (tbSynObjectChild.getType() != 4) {
                    showTbSynObject(tbSynObjectChild, list);
                    tbSynObject.getTbChildSynObjectList().addAll(tbSynObjectChild.getTbChildSynObjectList());
                } else {
                    tbSynObject.getTbChildSynObjectList().add(tbSynObjectChild);
                }
            }
        }
        //tb_object_data
        List<TbObjectData> fieldlist = new ArrayList<TbObjectData>();
        if (tbSynObject.getTbChildSynObjectList() != null && tbSynObject.getTbChildSynObjectList().size() > 0) {
            for (TbSynObject field : tbSynObject.getTbChildSynObjectList()) {
                TbObjectData objectData = new TbObjectData();
                objectData.setDataUri(field.getUri());
                objectData.setCreateTime(new Date());
                objectData.setObjectUri(tbSynObject.getUri());
                fieldlist.add(objectData);
            }
            if (fieldlist.size() > 0) {
                //添加
                tbObjectDataMapper.insertBatch(fieldlist);
            }
        }
    }
}

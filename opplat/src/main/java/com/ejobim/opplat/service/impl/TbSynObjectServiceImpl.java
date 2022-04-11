package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbFillFormFieldMapper;
import com.ejobim.opplat.mapper.TbObjectDataMapper;
import com.ejobim.opplat.mapper.TbSynObjectMapper;
import com.ejobim.opplat.service.TbSynObjectService;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/1/29 14:18
 */
@Service
public class TbSynObjectServiceImpl implements TbSynObjectService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;

    @Autowired
    private TbObjectDataMapper tbObjectDataMapper;

    @Autowired
    private TbFillFormFieldMapper tbFillFormFieldMapper;


    /**
     *
     * @param factoryNo
     * @param getType 取数据方式1：排除填报字段，2：包含填报字段（但不包含水厂）
     * @return
     */
    @Override
    public Tree<TbSynObject> findTreeLists(String factoryNo, int getType, Integer fieldType,Integer hasValue) {
        TbSynObjectExample tbSynObjectExample = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = tbSynObjectExample.createCriteria();

        if(StringUtils.isNotBlank(factoryNo)){
            String[] ids = factoryNo.split(",");
            if(ids.length>1){
                List<String> list = Arrays.asList(ids);
                criteria.andFactoryNoIn(list);
            }else{
                criteria.andFactoryNoEqualTo(factoryNo);
            }

        }
        tbSynObjectExample.setOrderByClause("sort_order");
        if(getType==1){
            Integer type = 4;
            criteria.andTypeNotEqualTo(type);
        }

        System.out.println(System.currentTimeMillis());
        List<TbSynObject> tbSynObjects = tbSynObjectMapper.selectByExample(tbSynObjectExample);
        System.out.println(System.currentTimeMillis());
        List<TbSynObject> list = new ArrayList<>();
        for(TbSynObject tbSynObject:tbSynObjects){

            if(tbSynObject.getType()!=4){
                list.add(tbSynObject);
            }else {
                if(fieldType!=null && hasValue!=null){
                    if( tbSynObject.getFieldType().intValue()==fieldType && tbSynObject.getHasvalue()==hasValue.shortValue()){
                        list.add(tbSynObject);
                    }
                }else if(fieldType!=null ){
                    if( tbSynObject.getFieldType().intValue()==fieldType ){
                        list.add(tbSynObject);
                    }
                }else if(hasValue!=null ){
                    if( tbSynObject.getHasvalue()==hasValue.shortValue() ){
                        list.add(tbSynObject);
                    }
                }else{
                    list.add(tbSynObject);
                }
            }
        }
        List<Tree<TbSynObject>> trees = new ArrayList<>();
        if(list!=null && list.size()>0){
            TreeUtils.buildTrees(trees,list);
        }
        return TreeUtils.build(trees);
    }




    @Override
    public List<TbSynObject> getParamLists(String factoryNo,String uri,Integer type,String browseName,String displayName,Integer hasValue) {
        List<TbSynObject> tbSynFields =tbSynObjectMapper.getParamLists(factoryNo,uri,type,browseName,displayName,hasValue);
        List<String> uriList = new ArrayList<>();
        for(TbSynObject tbSynObject:tbSynFields){
            if(!uriList.contains(tbSynObject.getUri())){
                uriList.add(tbSynObject.getParentUri());
            }
        }

        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        if(uriList.size()>0){
            criteria.andUriIn(uriList);
        }
        List<TbSynObject> parentSynObjectList = tbSynObjectMapper.selectByExample(example);
        for(TbSynObject tbSynObject:tbSynFields){
            for(TbSynObject parentSynObject:parentSynObjectList){
                if(tbSynObject.getParentUri().equals(parentSynObject.getUri())){
                    tbSynObject.setParentName(parentSynObject.getDisplayname());
                }
            }
        }
        return tbSynFields;
    }

    @Override
    public List<TbSynObject> getChildUriList(String uri,Integer type) {
        TbSynObjectExample example = new TbSynObjectExample();
        example.createCriteria().andParentUriEqualTo(uri).andTypeEqualTo(type).andFieldTypeEqualTo(2).andHasvalueEqualTo(1);
        return tbSynObjectMapper.selectByExample(example);
    }

    @Override
    public List<TbFillFormField> getSelectFieldList(String uri, Integer fieldType ,String fieldCode,String fieldName) {
        return tbFillFormFieldMapper.getFieldLists(uri,fieldType,fieldCode,fieldName);
    }

    @Override
    public List<TbFillFormField> getFieldListExtend(TbFillFormField tbFillFormField) {
        return tbFillFormFieldMapper.getFieldListExtend(tbFillFormField);
    }

    @Override
    public List<TbSynObject> getTbSynObjectList(TbSynObject tbSynObject,boolean getNode) {
        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbSynObject.getFactoryNo())){
            criteria.andFactoryNoEqualTo(tbSynObject.getFactoryNo());
        }
        if(!getNode){
            Integer type = 4;
            criteria.andTypeNotEqualTo(type);
        }
        return this.tbSynObjectMapper.selectByExample(example);
    }

    @Override
    public List<TbSynObject> getTbSynObjectList(List<String> uris) {
        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        criteria.andUriIn(uris);
        return tbSynObjectMapper.selectByExample(example);
    }

    @Override
    public int getTbSynObjectCount(String factoryNo, Integer fieldType) {
        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        if(factoryNo!=null){
            criteria.andFactoryNoEqualTo(factoryNo);
        }
        if(fieldType!=null){
            criteria.andFieldTypeEqualTo(fieldType);
        }
        return tbSynObjectMapper.countByExample(example);
    }

    @Override
    public int deleteByFactoryNo(String factoryNo) {
        TbSynObjectExample example  = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        return  tbSynObjectMapper.deleteByExample(example);
    }

    @Override
    public int insertBatch(List<TbSynObject> list) {
        return tbSynObjectMapper.insertBatch(list);
    }

    @Override
    public int insertTbObjectDataList(List<TbObjectData> list) {
         tbObjectDataMapper.insertBatch(list);
         return 0;
    }

    @Override
    public List<TbSynObject>
    selectSynObjectList(TbSynObject tbSynObject) {
        if(StringUtils.isNotBlank(tbSynObject.getParentUri())){
            tbSynObject.setType(4);
            tbSynObject.setFieldType(2);
            tbSynObject.setHasvalue(1);
            return tbSynObjectMapper.selectSynObjectByConds(tbSynObject);
        }
        return null;
    }

    @Override
    public List<TbSynObject> selectSynObjectListByConds(TbSynObject tbSynObject) {
        return tbSynObjectMapper.selectSynObjectByConds(tbSynObject);
    }

    @Override
    public Tree<TbSynObject> findAppEquipTree(TbEquipInfo equipInfo) {
        Tree<TbSynObject> tbSynObjectTree = new Tree<>();
        List<TbSynObject> tbSynObjects = new ArrayList<>();
        //查询所有设备
        if(equipInfo.getFactoryNo()!=null){
            TbSynObject tbSynObject = new TbSynObject();
            tbSynObject.setFactoryNo(equipInfo.getFactoryNo());
            tbSynObjects = tbSynObjectMapper.selectSynObjectByFactoryNo(tbSynObject);
            List<Tree<TbSynObject>> trees = new ArrayList<>();
            TreeUtils.buildTrees(trees,tbSynObjects);
            tbSynObjectTree = TreeUtils.build(trees);
        }
        return tbSynObjectTree;
    }
}


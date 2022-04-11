package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbFillFormField;
import com.ejobim.opplat.domain.TbObjectData;
import com.ejobim.opplat.domain.TbSynObject;
import com.ejobim.opplat.util.Tree;

import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/1/29 14:17
 */
public interface TbSynObjectService {

    Tree<TbSynObject> findTreeLists(String factoryNo,int  getType,Integer fieldType,Integer hasValue);

    List<TbSynObject> getParamLists(String factoryNo,String uri,Integer type,String browseName,String displayName,Integer hasValue);

    List<TbSynObject> getChildUriList(String uri,Integer type);

    List<TbFillFormField> getSelectFieldList(String uri,Integer fieldType,String fieldCode,String fieldName);

    List<TbFillFormField> getFieldListExtend(TbFillFormField tbFillFormField);//String uri, int fillType

    List<TbSynObject> getTbSynObjectList(TbSynObject tbSynObject,boolean getNode);

    List<TbSynObject> getTbSynObjectList(List<String> uris);

    int  getTbSynObjectCount(String factoryNo,Integer fieldType);

    int deleteByFactoryNo(String factoryNo);

    int insertBatch(List<TbSynObject> list);

    int insertTbObjectDataList(List<TbObjectData> list);


    List<TbSynObject> selectSynObjectList(TbSynObject tbSynObject);

    List<TbSynObject> selectSynObjectListByConds(TbSynObject tbSynObject);
    /**
     * app端 根据水厂获取设备tree列表
     * @param equipInfo
     * @return
     */
    Tree<TbSynObject> findAppEquipTree(TbEquipInfo equipInfo);
}

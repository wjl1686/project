package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.TbEquipInfoVo;
import com.ejobim.opplat.util.Tree;

import java.util.List;
import java.util.Map;

public interface EquipService {
    /**
     * 获取设备列表
     * @param tbEquipInfo
     * @return
     */
    List<TbEquipInfo> getEquipList(TbEquipInfo tbEquipInfo);

    /**
     * 根据设备编号获取设备
     * @param equipNo
     * @return
     */
    TbEquipInfo getEquipInfo(String equipNo);

    /**
     * 设备调整
     * @param tbAdjustEquip
     * @return
     */
    List<TbAdjustEquip> getAdjuastEquipList(TbAdjustEquip tbAdjustEquip);

    /**
     * 获取设备调整列表
     * @param factoryNo
     * @param keyName
     * @return
     */
    List<TbAdjustEquip> getAdjuastEquipList(String factoryNo,String keyName);

    /**
     * 新增更新设备信息
     * @param tbEquipInfo
     * @return
     */
    int saveEquipInfo(TbEquipInfo tbEquipInfo);

    /**
     * 启用停用设备
     * @param equipNo
     * @param status
     * @param user
     * @return
     */
    int changeEquipStatus(String equipNo,Integer status,TbUser user);

    /**
     * 获取设备调整详细信息
     * @param status
     * @param adNo
     * @return
     */
    TbAdjustEquip getAdjuastEquipExtendList(Integer status, String adNo);

    /**
     * 新增设备调整
     * @param tbAdjustEquip
     * @return
     */
    int addTbAdjustEquip(TbAdjustEquip tbAdjustEquip);

    /**
     * 新增设备调整详情
     * @param tbAdjustEquipExtend
     * @param status
     * @param commit
     * @return
     */
    int saveTbAdjustEquipExtend(TbAdjustEquipExtend tbAdjustEquipExtend, Integer status,boolean commit);

    /**
     * 获取设备附件
     * @param equipNo
     * @param fileName
     * @return
     */
    List<TbEquipAttachment> getAttachmentList(String equipNo, String fileName);

    /**
     * 保存设备附件
     * @param tbEquipAttachment
     * @return
     */
    int saveTbEquipAttachment(TbEquipAttachment tbEquipAttachment);

    /**
     * 删除设备附件
     * @param tbEquipAttachment
     * @return
     */
    int delTbEquipAttachment(TbEquipAttachment tbEquipAttachment);

    /**
     * 获取配件列表
     *
     * @param tbSpareParts
     * @return
     */
    List<TbSpareParts> getSparePartsList(TbSpareParts tbSpareParts);


    String getEquipRunTime(String equipNo);


    List<TbEquipInfo> selectEquipBaseInfoByKey(TbEquipInfo tbEquipInfo);

    List<TbSpareParts> selectSparePartsByEqNo(TbEquipInfo tbEquipInfo);

    /**
     * 修改备件库数量
     * @param list
     * @return
     */
    int commonTbSparePartsUseLogger(List<TbSparePartsUseLogger> list);


     /**
     * 公共方法转单
     * @param tbOrderLog
     * @return
     */
    public  int commonAppTransferOrder(TbOrderLog tbOrderLog);
    /**
     * 维修转委外传附件
     * @param overhaulTaskFile
     * @return
     */
    int addTaskFile(TbEquipTaskFile overhaulTaskFile);

    List<TbEquipTaskFile> getFileList(TbEquipTaskFile tbEquipTaskFile);

    List<Map<String,String>> getRunningParamsBySynInfo(List<TbSynObject> list);


    TbEquipInfo getEquipDetailInfo(TbEquipInfo tbEquipInfo);
    /**
     *  根据设备编号批量查询设备信息
     * @param equipNos
     * @return
     */
    List<TbEquipInfo>  selectEquipBatchlist(String[] equipNos);

    /**
     *  新增设备历史记录
     * @param tbEquipHistroy
     * @return
     */
    int saveTbEquipHistroy(TbEquipHistroy tbEquipHistroy);
    /**
     *  新增/修改设备类型管理
     * @param tbEquipType
     * @return
     */
    int saveTbEquipType(TbEquipType tbEquipType);
    /**
     *  查询设备类型
     * @param tbEquipType
     * @return
     */
    List<TbEquipType> selectTbEquipTypetList(TbEquipType tbEquipType);

    Tree<TbEquipType> findTbEquipTypeAllTree();

    TbEquipType getInfoById(Integer parentId);
    /**
     *  导入设备类型
     * @param list,factoryNo,tbDicts,tbEquipTypeList
     * @return
     */
    int saveImportEquipInfo(List<TbEquipInfoVo> list, String factoryNo, List<TbDict> tbDicts, List<TbEquipType> tbEquipTypeList);

    /**
     *  new 查询设备类型
     * @param tbEquipType
     * @return
     */
    List<TbEquipType> selectTbEquipTypetLists(TbEquipType tbEquipType);

    /**
     * 设备类型启用或者停用
     * @param id
     * @return
     */
    int stopTbEquipType(Integer id);

    /**
     * 查询绑定nfc设备/巡检点列表
     * @param tbNfcInfo
     * @return
     */
    List<TbNfcInfo> getEquipNFCList(TbNfcInfo tbNfcInfo);

    /**
     * 新增绑定nfc设备/巡检点
     * @param tbNfcInfo
     * @return
     */
    int saveEquipNFC(TbNfcInfo tbNfcInfo);

    /**
     * 根据类型查询设备或者巡检点
     * @param tbNfcInfo
     * @return
     */
    List<Map<String, String>> getSheOrXunList(TbNfcInfo tbNfcInfo);

    int stopEquipNFC(TbNfcInfo tbNfcInfo);
    /**
     * 修改绑定nfc设备/巡检点
     * @param tbNfcInfo
     * @return
     */
    int updateEquipNFC(TbNfcInfo tbNfcInfo);
}


package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.TbFactoryInfoVo;
import com.ejobim.opplat.util.Tree;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TbFactoryService {
    int addFactory(TbFactoryInfo tbFactoryInfo);

    int updateFactory(TbFactoryInfo tbFactoryInfo);


    int updateFactoryInOutWater(TbFactoryWater tbFactoryWater);

    int updatefactoryDry(TbFactoryDehydrationSystem tbFactoryDehydrationSystem);


    List<TbFactoryInfo> getTbFactoryInfoList(TbFactoryInfo tbFactoryInfo);

    List<TbFactoryInfo> getTbFactoryInfoNewList(TbFactoryInfo tbFactoryInfo);


    List<TbFactoryInfo> getFactoryInfoList(List<String> factoryNoList);

    /**
     * 新增填报字段
     * @param
     * @return
     */
    int saveTbFillFormField(List<TbFillFormField> tbFillFormFieldList);

    int addTbFillFormField(TbFillFormField tbFillFormField);

    int deleteTbFillFormField(String key);

    int  getTbFillFormFieldCount(String factoryNo,Integer fieldType);

    int updateTbFillFormField(TbFillFormField tbFillFormField);

    int saveFillFormDetail(List<TbFillFormDetail> list);

    int updateFillFormTask(TbFillFormTask tbFillFormTask);

    /**
     * 根据水厂no获取水厂信息
     * @param factoryNo
     * @return
     */
    TbFactoryInfo getFactoryInfoByNo(String factoryNo);

    List<TbFactoryInfo> getChildrenFactory(String factoryNo);

    List<TbFillFormField> getTbFillFormFieldList();


    int addTbFormDataList(List<TbFormData> tbFormDataList);


    List<TbFormData> getTbFormDataList(TbFormData tbFormData);



    int saveRealTimeConfig(List<TbRealTimeConfig> list,String factoryNo);

    Tree<TbRealTimeConfig> findTreeLists(String factoryNo) ;

    List<TbRealTimeConfig> fineTbRealTimeConfigList(String factoryNo);

    /**
     * 生成填报任务
     * @param factoryNo
     * @return
     */
    int createFillTask(String factoryNo, Date startDate, Date endDate,TbUser user);


    List<TbParam> getParamList(TbParam param);

    void saveTbFillFormFieldExtend(TbFillFormFieldExtend tbFillFormFieldExtend,String[] monthDate);

    /**
     * @author wujianlong
     * @date 2019-3-04 14:53:08
     * @Description 人工配置项列表
     * @version 1.0
     */
    List<TbFillFormField> getTbFillFormFieldList(TbFillFormField tbFillFormField);

    /**
     * @author wujianlong
     * @date 2019-12-16 11:53:08
     * @Description 新增水厂信息
     * @version 1.0
     */
    int saveFactoryAllInfo(JSONObject json,String factoryNo,TbUser user) throws Exception;

    TbFactoryVideo getFactoryVideo(String factoryNo);
    /**
     * @author wujianlong
     * @date 2019-3-04 14:53:08
     * @Description 导入水厂相关信息
     * @version 1.0
     */
    int saveFactoryInfo(List<TbFactoryInfoVo> list, String factoryNo, List<TbDict> tbDicts,List<TbOrg> tbOrgList) throws Exception;

    /**
     * 查询水厂班次列表
     * @param  tbFactoryTime
     * @return
     */
    List<TbFactoryTime> getTbFactroyTimeList(TbFactoryTime tbFactoryTime);

    /**
     * 新增/修改水厂班次
     * @param  factoryNo
     * @param  timeType
     * @param  timePoints
     * @return
     */
    int saveTbFactoryTime( String factoryNo, Integer timeType, String timePoints, TbUser user ) throws Exception;

    Map<String,Object>   getFactoryTimeDetail(String factoryNo, Integer timeType );

    /**
     * 删除班次
     * @param timeNo
     * @return
     */
    int deleteTbFactoryTime(String timeNo);

    /**
     * 新增子水厂
     * @param tbFactoryInfo
     * @return
     */
    int saveTbFactoryChildren(TbFactoryInfo tbFactoryInfo);

    /**
     * 查询水厂信息
     * @param factoryNo
     * @return
     */
    List<TbFactoryInfo> getFactoryInfoByNoNew(String factoryNo);

    List<String> getFactoryOrg(String factoryCode);
    /**
     * 查询水厂no信息
     * @param factoryNo
     * @return
     */
    List<TbFactoryInfo> getTbFactoryInfoDataByFactroyNo(String factoryNo);
    /**
     * 查询子水厂
     * @param factoryNo
     * @return
     */
    List<TbFactoryInfo> getChildFactroy(String factoryNo);
    /**
     * 删除子水厂
     * @param factoryNo
     * @return
     */
    int delChildFactroy(String factoryNo);

    int setFactoryVideo(String factoryNo, String videoId);

}

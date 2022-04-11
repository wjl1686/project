package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.condition.*;

import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/18 12:41
 */
public interface BewgService {
    /**
     * 旧版本 废弃
     * @param list
     * @return
     */
    JSONObject getDataInfo(String[] list);

    /**
     * 获取实时数据 时序数据
     * @param list
     * @return
     */
    JSONObject getDataInfoNew(String[] list);

    JSONObject getDataInfoNew(JSONArray array);

    /**
     * 获取统计数据
     * @param list
     * @return
     */
    JSONObject queryCumulation(List<BewgQueryCumulation> list);

    /**
     * 获取水厂信息
     * @param condition
     * @return
     */
    JSONObject queryAllFactory(BewgQueryRelationofnodes condition);


    JSONObject queryTreeNode(BewgQueryTreeCondition condition);

    JSONObject getOrgTreeByUserId(String token);
    /**
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 获取token
     * @version 1.0
     * @param
     */
    String getToken();
    /**
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 获取组织机构同步数据
     * @version 1.0
     * @param
     */
    JSONObject getOrgInfo( QueryConditon queryConditon);

    /**
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 获取角色同步数据
     * @version 1.0
     * @param
     */
    JSONObject getRoleInfo( QueryConditon queryConditon);

    /**
     * @author wujianlong
     * @date 2019-3-35 14:10:08
     * @Description 获取用户同步数据
     * @version 1.0
     * @param
     */
    JSONObject getUserInfo( QueryConditon queryConditon);

    JSONObject loginHollySys(String userName,String password);

    JSONObject updteNodes(List<Map<String,Object>> uriList);

    JSONObject logOut(String token);

    JSONObject getUserInfoByToken(String token);

    JSONObject getUserOrgByToken(String token);

    /**
     * @author wujianlong
     * @date 2019-5-30 11:10:08
     * @Description 根据测点uri查询关联告警
     * @version 1.0
     * @param
     */
    JSONObject getAlarmList( QueryConditon queryConditon);

    /**
     * @author wujianlong
     * @date 2019-5-30 11:10:08
     * @Description 根据测点uri查询告警详情
     * @version 1.0
     * @param
     */
    //JSONObject getAlarmInfo( QueryConditon queryConditon);

    /**
     * @author wujianlong
     * @date 2019-5-30 11:10:08
     * @Description 创建订阅接口
     * @version 1.0
     * @param
     */
    JSONObject createSubscription(QueryConditon queryConditon);
    /**
     * @author wujianlong
     * @date 2019-5-30 11:10:08
     * @Description 使用uri创建事件监控项
     * @version 1.0
     * @param
     */
    JSONObject createByUri(MonitorCondition condition);

    /**
     * 创建socket,同时创建监控项
     * @param   queryConditon
     * @return
     */
    Map createSocket(QueryConditon queryConditon);

    /**
     * 获取测点历史插值查询
     * @param condition
     * @return
     */
    JSONObject queryHistory(BewgPointCondition condition);
    
    /**
     * 获取告警历史值查询
     * @param factoryUri
     * @return
     */
    List queryHistoryAlarm(String factoryUri);

    /**
     * 通过uri获取告警
     * @param   uri
     * @return
     */
    List<Map<String, Object>> queryAlarmByUri(String uri);

    /**
     * 查询测点的告警配置
     * @param nodeUri
     * @return
     */
    JSONObject getAllAlarmByNodeUri( String  nodeUri);

    /**
     * 修改告警配置
     * @param jsonObject
     * @return
     */
    JSONObject addOrUpdateAlarms( JSONObject  jsonObject,String nameSpace);
}

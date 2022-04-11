package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author  xibian
 */
public interface WorkFlowService {

    /**
     * 获取工作流程列表
     * @param workFlowInfo
     * @return
     */
    List<TbWorkFlowInfo> getWorkFlowList(TbWorkFlowInfo workFlowInfo);

    List<TbWorkFlowConfig> getWorkFlowConfigList(TbWorkFlowConfig workFlowConfig);

    List<TbWorkFlowConfigDetail> getWorkFlowDetailList(TbWorkFlowConfigDetail  workFlowConfigDetail);


    /**
     * 根据机构编码和流程编码获取流程信息
     * @param orgNo
     * @param flowCode
     * @return
     */
    TbWorkFlowConfig getWorkFlowConfigByCode(String orgNo,String flowCode);



    List<TbWorkFlowConfigDetailExtend> getWorkFlowDetailExtendList(TbWorkFlowConfigDetailExtend  workFlowConfigDetailExtend,Integer type);



    int  saveWorkFlowConfig(TbWorkFlowConfig workFlowConfig, TbUser user);

    int saveWorkFlowDetailList(List<TbWorkFlowConfigDetail> workFlowConfigDetails);

    int saveWorkFlowDetail(TbWorkFlowConfigDetail workFlowConfigDetail);

    int saveWorkFlowDetailUser(TbWorkFlowConfigDetail workFlowConfigDetail,int nodeUserType);

    int saveWorkFlowDetailExtend(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend);

    int changeNodeIndex(String firstNodeExtendNo,Integer firstFieldIndex, String secondNodeExtendNo,Integer secondFieldIndex);

    int  changeControlRule( String nodeExtendNo,String showCondition,String validateRules);

    int deleteWorkFlowDetailExtend(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend);

    /**
     * 新增保存工作流
     * @param workFlowInfo
     * @return
     */
    int saveWorkFlowInfo(TbWorkFlowInfo workFlowInfo);

    int deleteWorkFlowInfo(String flowNo);

    List<WorkFlowApi> getWorkFlowApiList(WorkFlowApi workFlowApi);

    int saveWorkFlowApi(WorkFlowApi workFlowApi);

    int deleteWorkFlowApi(WorkFlowApi workFlowApi);






    int workFlowCopyAlone(String sourceFlowNo,String targetFlowNo);
}

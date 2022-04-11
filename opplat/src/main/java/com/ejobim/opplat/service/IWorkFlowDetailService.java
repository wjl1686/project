package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作流详情接口
 * @author  xibian
 * @date  2019-06-14
 */
public interface IWorkFlowDetailService {

    /**
     * 保存任务详细信息
     * @param taskInfo
     * @param flowNo
     * @return
     */
    int saveDetailInfo(JSONObject taskInfo,JSONObject extendInfo, String flowNo, String extendNo,String step, String nextStep);

//    /**
//     * 保存任务的详细信息
//     * @param taskInfo
//     * @param extendNo
//     * @return
//     */
//    int saveDetailInfoExtend(JSONObject taskInfo, String extendNo,String step, String nextStep);

    /**
     * 获取工作流各个步骤的详情
     * @param extendNoList
     * @return
     */
    List getExtendListByExtendNo(List<String> extendNoList);

    /**
     * 获取工作流任务的主任务详情
     * @param flowNo
     * @return
     */
    Object getDetailInfoByFlowNo(String flowNo);

    /**
     * 获取任务扩展信息
     * @param factoryNo
     * @param request
     * @param userCode
     * @param plat
     * @return
     */
    List  getDetailList(String factoryNo, HttpServletRequest request, String userCode, Integer plat);


}

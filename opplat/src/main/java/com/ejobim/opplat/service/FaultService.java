package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbFaultDetail;
import com.ejobim.opplat.domain.TbFaultType;
import com.ejobim.opplat.domain.TbUser;

import java.util.List;
import java.util.Map;

public interface FaultService {

    /**
     * 查询故障类型列表
     * @param tbFaultType
     * @return
     */
    List<TbFaultType> getTbFaultTypeList(TbFaultType tbFaultType);

    /**
     * 新增故障类型
     * @param tbFaultType
     * @return
     */
    int saveTbFaultType(TbFaultType tbFaultType, TbUser user);

    /**
     * 查询故障详情列表
     * @param tbFaultDetail
     * @return
     */
    List<TbFaultDetail> getTbFaultDetailList(TbFaultDetail tbFaultDetail);

    /**
     * 查询工单详情及异常信息
     * @param taskNo
     * @return
     */
    Map getTbWorkTaskDetail(String taskNo) throws Exception;

    /**
     * 删除故障类型
     * @param faultNo
     * @return
     */
    int deleteTbFaultType(String faultNo);

    /**
     * 新增/修改故障类型
     * @param tbFaultDetail,user
     * @return
     */
    int saveTbFaultDetail(TbFaultDetail tbFaultDetail, TbUser user);

    /**
     * 查询故障详情
     * @param faultDetailNo
     * @return
     */
    Map getTbFaultDetail(String faultDetailNo) throws Exception;
}

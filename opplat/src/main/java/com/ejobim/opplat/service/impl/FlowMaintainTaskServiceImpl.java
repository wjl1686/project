package com.ejobim.opplat.service.impl;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbFlowMaintainTaskDetailMapper;
import com.ejobim.opplat.mapper.TbFlowMaintainTaskMapper;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设备维保工单
 * @author xibian
 * @date 2019-06-14
 */
@Service("flowMaintainTaskService")
public class FlowMaintainTaskServiceImpl implements IWorkFlowDetailService {
    public final  static String  SPAREPAETS_USE  = "sparePartsList";
    @Autowired
    TbFlowMaintainTaskMapper taskMapper;
    @Autowired
    TbFlowMaintainTaskDetailMapper taskDetailMapper;
    @Autowired
    EquipService equipService;

    @Override
    public int saveDetailInfo(JSONObject taskInfo, JSONObject extendInfo,String flowNo,String extendNo,String step,String nextStep) {
        if(taskInfo!=null){
            TbFlowMaintainTask maintainTask = JSON.toJavaObject(taskInfo,TbFlowMaintainTask.class);
            maintainTask.setFlowNo(flowNo);
            maintainTask.setTaskNo(StringTools.getUUID());
            maintainTask.setPlanNo(flowNo);
            taskMapper.insertSelective(maintainTask);
        }
        TbFlowMaintainTaskDetail maintainTaskDetail = JSON.toJavaObject(extendInfo,TbFlowMaintainTaskDetail.class);
        maintainTaskDetail.setExtendNo(extendNo);
        maintainTaskDetail.setDetailNo(StringTools.getUUID());
        //如果有使用备品备件
        if(extendInfo.containsKey(SPAREPAETS_USE)){
            List<TbSparePartsUseLogger> useLoggers = new ArrayList<>();
            JSONArray sparePartsList = extendInfo.getJSONArray(SPAREPAETS_USE);
            for(int i=0;i<sparePartsList.size();i++){
                TbSparePartsUseLogger sparePartsUseLogger = new TbSparePartsUseLogger();
                sparePartsUseLogger.setUseCount(sparePartsList.getJSONObject(i).getIntValue("useCount"));
                sparePartsUseLogger.setUseTime(new Date());
                sparePartsUseLogger.setWorkOrderNo(extendNo);
                sparePartsUseLogger.setWorkOrderType(2);
                sparePartsUseLogger.setSparePartsNo(sparePartsList.getJSONObject(i).getString("sparePartsNo"));
                useLoggers.add(sparePartsUseLogger);
            }
            equipService.commonTbSparePartsUseLogger(useLoggers);
        }
        return taskDetailMapper.insertSelective(maintainTaskDetail);

    }

    @Override
    public List getExtendListByExtendNo(List<String> extendNoList) {
        TbFlowMaintainTaskDetailExample example = new TbFlowMaintainTaskDetailExample();
        TbFlowMaintainTaskDetailExample.Criteria criteria = example.createCriteria();
        criteria.andExtendNoIn(extendNoList);
        return taskDetailMapper.selectByExample(example);
    }

    @Override
    public Object getDetailInfoByFlowNo(String flowNo) {
        TbFlowMaintainTaskExample  example = new TbFlowMaintainTaskExample();
        TbFlowMaintainTaskExample.Criteria criteria = example.createCriteria();
        criteria.andFlowNoEqualTo(flowNo);
        List<TbFlowMaintainTask> list = taskMapper.selectByExample(example);
        return list.size()==1?list.get(0):null;
    }

    @Override
    public List getDetailList(String factoryNo, HttpServletRequest request, String userCode, Integer plat) {
        return taskMapper.selectByFlow(factoryNo,request.getParameter("equipName"),userCode,plat,userCode==null);
    }
}

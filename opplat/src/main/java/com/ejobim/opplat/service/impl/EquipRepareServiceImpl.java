package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ejobim.opplat.common.WorkFlowCommon.*;
import static com.ejobim.opplat.service.impl.FlowMaintainTaskServiceImpl.SPAREPAETS_USE;

/**
 * 设备维修服务类
 */
@Service("equipRepareServiceImpl")
public class EquipRepareServiceImpl implements IWorkFlowDetailService {
    @Autowired
    TbEquipFaultInfoMapper equipFaultInfoMapper;
    @Autowired
    TbEquipFaultExtendMapper equipFaultExtendMapper;
    @Autowired
    TbEquipReparePlanMapper equipReparePlanMapper;
    @Autowired
    TbEquipReparePlanExtendMapper equipReparePlanExtendMapper;
    @Autowired
    TbEquipRepareTaskExtendMapper equipRepareTaskExtendMapper;
    @Autowired
    private EquipService equipService;

    @Override
    public int saveDetailInfo(JSONObject taskInfo,JSONObject extendInfo, String flowNo, String extendNo,String step, String nextStep) {

        if(SBWX_YCSB.equals(step)){
            if(taskInfo!=null){
                TbEquipFaultInfo equipFaultInfo = JSON.toJavaObject(taskInfo,TbEquipFaultInfo.class);
                equipFaultInfo.setErrorNo(StringTools.getUUID());
                equipFaultInfo.setFlowNo(flowNo);
                equipFaultInfoMapper.insertSelective(equipFaultInfo);
            }
            if(extendInfo!=null){
                TbEquipFaultExtend equipFaultExtend = JSON.toJavaObject(extendInfo,TbEquipFaultExtend.class);
                equipFaultExtend.setId(StringTools.getUUID());
                equipFaultExtend.setExtendNo(extendNo);
                return equipFaultExtendMapper.insertSelective(equipFaultExtend);
            }

        }else  if(SBWX_WXJH.equals(step)){
            if(extendInfo.containsKey(SPAREPAETS_USE)){
                List<TbSparePartsUseLogger> useLoggers = new ArrayList<>();
                JSONArray sparePartsList = taskInfo.getJSONArray(SPAREPAETS_USE);
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
            //转维修计划
            if(taskInfo!=null) {
                TbEquipReparePlan equipReparePlan = JSON.toJavaObject(taskInfo, TbEquipReparePlan.class);
                equipReparePlan.setRpNo(StringTools.getUUID());
                equipReparePlan.setFlowNo(flowNo);
            }
            if(extendInfo!=null){
                TbEquipReparePlanExtend equipReparePlanExtend = JSON.toJavaObject(extendInfo,TbEquipReparePlanExtend.class);
                equipReparePlanExtend.setPlanExtendNo(StringTools.getUUID());
                equipReparePlanExtend.setExtendNo(extendNo);
                return equipReparePlanExtendMapper.insertSelective(equipReparePlanExtend);
            }

        }else if(SBWX_WXGD.equals(step)){
            if(extendInfo!=null){
                TbEquipRepareTaskExtend equipRepareTaskExtend = JSON.toJavaObject(extendInfo,TbEquipRepareTaskExtend.class);
                equipRepareTaskExtend.setTaskNo(StringTools.getUUID());
                equipRepareTaskExtend.setExtendNo(extendNo);
                return equipRepareTaskExtendMapper.insertSelective(equipRepareTaskExtend);
            }
        }
        return 0;
    }



    @Override
    public List getExtendListByExtendNo(List<String> extendNoList) {
        List list = new ArrayList();
        TbEquipFaultExtendExample example = new TbEquipFaultExtendExample();
        TbEquipFaultExtendExample.Criteria criteria = example.createCriteria();
        criteria.andExtendNoIn(extendNoList);
        List errorList =  equipFaultExtendMapper.selectByExample(example);
        list.addAll(errorList);
        TbEquipReparePlanExtendExample reparePlanExtendExample = new TbEquipReparePlanExtendExample();
        TbEquipReparePlanExtendExample.Criteria criteria1 = reparePlanExtendExample.createCriteria();
        criteria1.andExtendNoIn(extendNoList);
        List planList =  equipReparePlanExtendMapper.selectByExample(reparePlanExtendExample);
        list.addAll(planList);
        TbEquipRepareTaskExtendExample equipRepareTaskExtendExample = new TbEquipRepareTaskExtendExample();
        TbEquipRepareTaskExtendExample.Criteria criteria2 = equipRepareTaskExtendExample.createCriteria();
        criteria2.andExtendNoIn(extendNoList);
        List taskList =  equipRepareTaskExtendMapper.selectByExample(equipRepareTaskExtendExample);
        list.addAll(taskList);
        return list;
    }

    @Override
    public Object getDetailInfoByFlowNo(String flowNo) {
        TbEquipFaultInfoExample  example = new TbEquipFaultInfoExample();
        TbEquipFaultInfoExample.Criteria criteria = example.createCriteria();
        criteria.andFlowNoEqualTo(flowNo);
        List<TbEquipFaultInfo> list = equipFaultInfoMapper.selectByExample(example);
        return list.size()==1?list.get(0):null;
    }

    @Override
    public List getDetailList(String factoryNo, HttpServletRequest request, String userCode, Integer plat) {
        int step = request.getParameter("step")==null?1:Integer.valueOf(request.getParameter("step"));

        return null;
    }
}

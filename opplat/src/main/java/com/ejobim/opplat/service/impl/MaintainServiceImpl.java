package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.common.WorkFlowCommon;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.service.MaintainService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author  xibian
 * @date 2019-05-10
 */
@Service("maintainService")
public class MaintainServiceImpl implements MaintainService, IWorkFlowDetailService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbFactoryInfoMapper tbFactoryMapper;
    @Autowired
    private TbEquipTaskFileMapper fileMapper;
    @Autowired
    private TbEquipInfoMapper equipInfoMapper;
    @Autowired
    private TbOrderLogMapper orderLogMapper;
    @Autowired
    private TbSparePartsUseLoggerMapper tbSparePartsUseLoggerMapper;
    @Autowired
    private TbEquipMaintainPlanMapper maintainPlanMapper;
    @Autowired
    private TbEquipMaintainPlanExtendMapper maintainPlanExtendMapper;





    @Override
    public List<TbSparePartsUseLogger>  getSparePartsUserList(String taskNo){
        TbSparePartsUseLoggerExample useLoggerExample = new TbSparePartsUseLoggerExample();
        TbSparePartsUseLoggerExample.Criteria criteria = useLoggerExample.createCriteria();
        criteria.andWorkOrderTypeEqualTo(2);
        criteria.andWorkOrderNoEqualTo(taskNo);
        return tbSparePartsUseLoggerMapper.selectByExample(useLoggerExample);
    }



    @Override
    public List<TbEquipTaskFile> getFileList(TbEquipTaskFile overhaulTaskFile) {
        TbEquipTaskFileExample example = new TbEquipTaskFileExample();
        TbEquipTaskFileExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskExtendNo())){
            criteria.andOfTaskExtendNoEqualTo(overhaulTaskFile.getOfTaskExtendNo());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskStatusCode())){
            criteria.andOfTaskStatusCodeEqualTo(overhaulTaskFile.getOfTaskStatusCode());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskNo())){
            criteria.andOfTaskNoEqualTo(overhaulTaskFile.getOfTaskNo());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfFactoryNo())){
            criteria.andOfFactoryNoEqualTo(overhaulTaskFile.getOfFactoryNo());
        }
        criteria.andOfTypeEqualTo(overhaulTaskFile.getOfType());
        return fileMapper.selectByExample(example) ;
    }

    @Override
    public int addTaskFile(TbEquipTaskFile overhaulTaskFile) {
        return 0;
    }

    @Override
    public int deleteTaskFile(TbEquipTaskFile overhaulTaskFile) {
        return fileMapper.deleteByPrimaryKey(overhaulTaskFile.getOfNo());
    }

    @Override
    public List<TbEquipMaintainPlan> getDetailList(String orgNo, HttpServletRequest request, String userCode, Integer plat) {
        return maintainPlanMapper.selectByFlow(orgNo,request.getParameter("equipName"),userCode,plat);
    }


    @Override
    public TbEquipMaintainPlan getMaintainPlan(String planNo) {
        return maintainPlanMapper.selectByPrimaryKey(planNo);
    }



    @Override
    public int saveDetailInfo(JSONObject taskInfo,JSONObject extendInfo, String flowNo,String extendNo,String step,String nextStep) {
        if(taskInfo!=null){
            TbEquipMaintainPlan tbEquipMaintainPlan = JSON.toJavaObject(taskInfo,TbEquipMaintainPlan.class);
            tbEquipMaintainPlan.setPlanNo(StringTools.getUUID());
            tbEquipMaintainPlan.setFlowNo(flowNo);
            maintainPlanMapper.insert(tbEquipMaintainPlan);
        }
        if(extendInfo!=null){
            TbEquipMaintainPlanExtend tbEquipMaintainPlanExtend = JSON.toJavaObject(extendInfo,TbEquipMaintainPlanExtend.class);
            tbEquipMaintainPlanExtend.setDetailNo(StringTools.getUUID());
            tbEquipMaintainPlanExtend.setExtendNo(extendNo);
            return maintainPlanExtendMapper.insert(tbEquipMaintainPlanExtend);
        }
        return 0;
    }


    @Override
    public List getExtendListByExtendNo(List<String> extendNoList) {
        TbEquipMaintainPlanExtendExample extendExample = new TbEquipMaintainPlanExtendExample();
        TbEquipMaintainPlanExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andExtendNoIn(extendNoList);
        return maintainPlanExtendMapper.selectByExample(extendExample);
    }

    @Override
    public Object getDetailInfoByFlowNo(String flowNo) {
        TbEquipMaintainPlanExample  maintainPlanExample = new TbEquipMaintainPlanExample();
        TbEquipMaintainPlanExample.Criteria criteria = maintainPlanExample.createCriteria();
        criteria.andFlowNoEqualTo(flowNo);
        List<TbEquipMaintainPlan> list = maintainPlanMapper.selectByExample(maintainPlanExample);
        return list.size()==1?list.get(0):null;
    }

    @Override
    public List<TbFlowMaintainTask> getMaintainTaskTimeList(TbEquipMaintainPlan maintainPlan) {
        Date baseStartTime = DateUtils.parseDate(maintainPlan.getPlanYear() + "-01-01");
        int count = 12;
        int addMonth = 1;
        switch (maintainPlan.getPlanCircle().intValue()){
            case 1:
                addMonth = 1;
                count = 12;
                break;
            case 2:
                addMonth = 3;
                count = 4;
                break;
            case 3:
                addMonth = 6;
                count = 2;
                break;
            case 4:
                addMonth = 12;
                count =1;
                break;
        }
        List<TbFlowMaintainTask> list = new ArrayList<>(12);
        for(int i=0;i<count;i++){
            Map<String,Date> map = new HashMap<>(2);
            Date startDate = DateUtils.addMonth(baseStartTime,i * addMonth);
            Date endDate = DateUtils.addMonth(baseStartTime,(i + 1) * addMonth);
            TbFlowMaintainTask maintainTask = new TbFlowMaintainTask();
            maintainTask.setPlanNo(maintainPlan.getFlowNo());
            maintainTask.setEndTime(endDate);
            maintainTask.setTaskCode("WB" + DateUtils.formateDate("yyyyMMdHHmmss") );
            maintainTask.setIsEntrust(maintainPlan.getIsEntrust());
            maintainTask.setEquipName(maintainPlan.getEquipName());
            maintainTask.setEquipTypeName(maintainPlan.getEquipTypeName());
            maintainTask.setEquipNo(maintainPlan.getEquipNo());
            maintainTask.setEquipLocationName(maintainPlan.getEquipLocationName());
            maintainTask.setStartTime(startDate);
            maintainTask.setPlanCost(maintainPlan.getPlanCost()/count);
            list.add(maintainTask);
        }
        return list;
    }

}

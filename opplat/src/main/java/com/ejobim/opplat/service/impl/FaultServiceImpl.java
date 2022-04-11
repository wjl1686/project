package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.FaultService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FaultServiceImpl implements FaultService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbFaultTypeMapper tbFaultTypeMapper;

    @Autowired
    private TbEquipTypeMapper tbEquipTypeMapper;

    @Autowired
    private TbFaultDetailMapper tbFaultDetailMapper;

    @Autowired
    private TbWorkTaskInfoMapper tbWorkTaskInfoMapper;

    @Autowired
    private TbEquipFaultInfoMapper tbEquipFaultInfoMapper;

    @Autowired
    private TbEquipInfoMapper tbEquipInfoMapper;

    @Override
    public List<TbFaultType> getTbFaultTypeList(TbFaultType tbFaultType) {
        TbFaultTypeExample example = new TbFaultTypeExample();
        TbFaultTypeExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbFaultType.getFactoryNo())){
            criteria.andFactoryNoEqualTo(tbFaultType.getFactoryNo());
        }
        if(StringUtils.isNotEmpty(tbFaultType.getFaultName())){
            criteria.andFaultNameLike("%"+tbFaultType.getFaultName()+"%");
        }
        //校验子还是父
        if(tbFaultType.getEquipTypeNo()!=null && !"".equals(tbFaultType.getEquipTypeNo())) {
            TbEquipType tbEquipType = tbEquipTypeMapper.selectByPrimaryKey(Integer.parseInt(tbFaultType.getEquipTypeNo()));
            if (tbEquipType.getParentId() == 0) {
                //父
                TbEquipTypeExample exampleT = new TbEquipTypeExample();
                TbEquipTypeExample.Criteria criteriaT = exampleT.createCriteria();
                criteriaT.andParentIdEqualTo(tbEquipType.getId());
                List<TbEquipType> tbEquipTypes = tbEquipTypeMapper.selectByExample(exampleT);
                List<String> idList = tbEquipTypes.stream().map(e -> e.getId().toString()).collect(Collectors.toList());
                criteria.andEquipTypeNoIn(idList);
            } else {
                //子
                if (StringUtils.isNotEmpty(tbFaultType.getEquipTypeNo())) {
                    criteria.andEquipTypeNoEqualTo(tbFaultType.getEquipTypeNo());
                }
            }
        }
        example.setOrderByClause("create_time desc");
        return tbFaultTypeMapper.selectByExample(example);
    }

    @Override
    public int saveTbFaultType(TbFaultType tbFaultType, TbUser user) {
        int flag=0;
        List<TbFaultType> checkTbFaultTypeList = getCheckTbFaultTypeList(tbFaultType);
        if(tbFaultType.getFaultNo()!=null){
            //修改
            logger.info("故障修改接口执行了");
            for (int i = checkTbFaultTypeList.size() - 1; i >= 0; i --) {
                if(checkTbFaultTypeList.get(i).getFaultNo().equals(tbFaultType.getFaultNo())){
                    checkTbFaultTypeList.remove(i);
                }
            }
            if(checkTbFaultTypeList!=null && checkTbFaultTypeList.size()>0){

                List<String> stringNameList = checkTbFaultTypeList.stream().map(e -> e.getFaultName()).collect(Collectors.toList());
                if(stringNameList.contains(tbFaultType.getFaultName())){
                    flag = Dict.AjaxStatus.FAULT_NAME_EXIST.getStatusCode();
                }else {
                    tbFaultType.setUpdateTime(new Date());
                    tbFaultType.setUpdateUserName(user.getName());
                    tbFaultType.setUpdateUserCode(user.getCode());
                    flag = tbFaultTypeMapper.updateByPrimaryKeySelective(tbFaultType);
                }

            }else {
                tbFaultType.setUpdateTime(new Date());
                tbFaultType.setUpdateUserName(user.getName());
                tbFaultType.setUpdateUserCode(user.getCode());
                flag = tbFaultTypeMapper.updateByPrimaryKeySelective(tbFaultType);
            }
        }else {
            logger.info("故障新增接口执行了");
            //新增
            if(checkTbFaultTypeList!=null && checkTbFaultTypeList.size()>0){
                flag = Dict.AjaxStatus.FAULT_NAME_EXIST.getStatusCode();
            }else {
                tbFaultType.setFaultNo(StringTools.getUUID());
                tbFaultType.setCreateTime(new Date());
                tbFaultType.setCreateUserName(user.getName());
                tbFaultType.setCreateUserCode(user.getCode());
                if (StringUtils.isNotEmpty(tbFaultType.getEquipTypeNo())) {
                    TbEquipType tbEquipType = tbEquipTypeMapper.selectByPrimaryKey(Integer.parseInt(tbFaultType.getEquipTypeNo()));
                    if (tbEquipType != null) {
                        tbFaultType.setEquipTypeName(tbEquipType.getTypeName());
                    }
                }
                flag = tbFaultTypeMapper.insertSelective(tbFaultType);
            }
        }
        return flag;
    }
    public List<TbFaultType> getCheckTbFaultTypeList(TbFaultType tbFaultType) {
        TbFaultTypeExample example = new TbFaultTypeExample();
        TbFaultTypeExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbFaultType.getFactoryNo())){
            criteria.andFactoryNoEqualTo(tbFaultType.getFactoryNo());
        }
        if(StringUtils.isNotEmpty(tbFaultType.getFaultName())){
            criteria.andFaultNameEqualTo(tbFaultType.getFaultName());
        }
        if(StringUtils.isNotEmpty(tbFaultType.getEquipTypeNo())){
            criteria.andEquipTypeNoEqualTo(tbFaultType.getEquipTypeNo());
        }
        return tbFaultTypeMapper.selectByExample(example);
    }

    @Override
    public List<TbFaultDetail> getTbFaultDetailList(TbFaultDetail tbFaultDetail) {
        TbFaultDetailExample example = new TbFaultDetailExample();
        TbFaultDetailExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbFaultDetail.getFactoryNo())){
            criteria.andFactoryNoEqualTo(tbFaultDetail.getFactoryNo());
        }
        if(StringUtils.isNotEmpty(tbFaultDetail.getEquipName())){
            criteria.andEquipNameLike("%"+tbFaultDetail.getEquipName()+"%");
        }
        if(StringUtils.isNotEmpty(tbFaultDetail.getFaultNo())){
            criteria.andFaultNoEqualTo(tbFaultDetail.getFaultNo());
        }
        if (tbFaultDetail.getBeginTime() != null) {
            criteria.andFaultTimeGreaterThanOrEqualTo(DateUtils.parseDateFull(tbFaultDetail.getBeginTime()+" 00:00:00"));
        }
        if (tbFaultDetail.getEndTime() != null) {
            criteria.andFaultTimeLessThan(DateUtils.getNextDateFull(tbFaultDetail.getEndTime()+" 00:00:00", 1));
        }
        example.setOrderByClause("create_time desc");
        List<TbFaultDetail> tbFaultDetailList = tbFaultDetailMapper.selectByExample(example);
        for (TbFaultDetail faultDetail : tbFaultDetailList) {
            TbFaultType tbFaultType = tbFaultTypeMapper.selectByPrimaryKey(faultDetail.getFaultNo());
            if(tbFaultType!=null){
                faultDetail.setFaultName(tbFaultType.getFaultName());
            }
            TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(faultDetail.getEquipNo());
            if(tbEquipInfo!=null){
                faultDetail.setEquipCode(tbEquipInfo.getEquipCode());
            }
            TbWorkTaskInfo tbWorkTaskInfo = tbWorkTaskInfoMapper.selectByPrimaryKey(faultDetail.getTaskNo());
            if(tbWorkTaskInfo!=null){
                TbEquipFaultInfo tbEquipFaultInfo = tbEquipFaultInfoMapper.selectByPrimaryKey(tbWorkTaskInfo.getTaskFrom());
                if(tbEquipFaultInfo!=null){
                    faultDetail.setReportUserName(tbEquipFaultInfo.getReportUserName());
                }else {
                    faultDetail.setReportUserName(tbWorkTaskInfo.getCreateUserName());
                }
            }
        }
        return tbFaultDetailList;
    }

    @Override
    public int deleteTbFaultType(String faultNo) {
        int flag=0;
        logger.info("故障类型删除接口执行了");
        flag= tbFaultTypeMapper.deleteByPrimaryKey(faultNo);
        return flag;
    }

    @Override
    public Map getTbWorkTaskDetail(String taskNo) throws Exception {
        Map map = new HashMap(16);
        TbWorkTaskInfo tbWorkTaskInfo = tbWorkTaskInfoMapper.selectByPrimaryKey(taskNo);
        if(tbWorkTaskInfo!=null){
            map.put("taskNo",tbWorkTaskInfo.getTaskNo());
            map.put("taskCode",tbWorkTaskInfo.getTaskCode());
            map.put("repairTime",DateUtils.formateDateFull(tbWorkTaskInfo.getRealFinishTime()));
            if (StringUtils.isNotEmpty(tbWorkTaskInfo.getEquipNo())){
                TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(tbWorkTaskInfo.getEquipNo());
                map.put("equipName",tbEquipInfo.getEquipName());
                map.put("equipCode",tbEquipInfo.getEquipCode());
                map.put("equipLocation",getEquipLocation(tbEquipInfo.getInstallationSite()));
                if(tbEquipInfo!=null){
                    if(tbEquipInfo.getEquipNewType()!=null && !"".equals(tbEquipInfo.getEquipNewType())){
                        TbFaultType tbFaultType = new TbFaultType();
                        tbFaultType.setFactoryNo(tbEquipInfo.getFactoryNo());
                        tbFaultType.setEquipTypeNo(tbEquipInfo.getEquipNewType().toString());
                        List<TbFaultType> checkTbFaultTypeList = getCheckTbFaultTypeList(tbFaultType);
                        map.put("faultTypeList",checkTbFaultTypeList);
                        TbEquipType tbEquipType = tbEquipTypeMapper.selectByPrimaryKey(tbEquipInfo.getEquipNewType());
                        if(tbEquipType!=null){
                            TbEquipType tbEquipTypeParent = tbEquipTypeMapper.selectByPrimaryKey(tbEquipType.getParentId());
                            String equipTypeName=tbEquipType.getTypeName();
                            if(tbEquipTypeParent!=null){
                                map.put("equipTypeName","父:"+tbEquipTypeParent.getTypeName()+"-子:"+equipTypeName);
                            }
                        }
                    }
                }
            }
            if (StringUtils.isNotEmpty(tbWorkTaskInfo.getTaskFrom())){
                TbEquipFaultInfo tbEquipFaultInfo = tbEquipFaultInfoMapper.selectByPrimaryKey(tbWorkTaskInfo.getTaskFrom());
                if(tbEquipFaultInfo!=null){
                    map.put("errorPic",tbEquipFaultInfo.getErrorPictures()==null?"":tbEquipFaultInfo.getErrorPictures());
                    map.put("faultTime",DateUtils.formateDateFull(tbEquipFaultInfo.getUpdateTime()));
                    map.put("reportUserName",tbEquipFaultInfo.getReportUserName());
                }
            }else {
                map.put("faultTime",DateUtils.formateDateFull(tbWorkTaskInfo.getCreateTime()));
                map.put("reportUserName",tbWorkTaskInfo.getCreateUserName());
                map.put("errorPic","");
            }
            map.put("faultHour",DateUtils.dateDiff(map.get("faultTime").toString(),DateUtils.formateDateFull(tbWorkTaskInfo.getRealFinishTime())));

        }
        return map;
    }
    public String getEquipLocation(String equipLocation ) {
        if("01".equals(equipLocation)) {
            return "进水段";
        }
        if("02".equals(equipLocation)){
            return "提升段";
        }
        if("03".equals(equipLocation)){
            return "初沉段";
        }
        if("04".equals(equipLocation)){
            return "生化处理段";
        }
        if("05".equals(equipLocation)){
            return "二沉段";
        }
        if("06".equals(equipLocation)){
            return "脱水段";
        }
        if("07".equals(equipLocation)){
            return "深水处理段";
        }
        if("08".equals(equipLocation)){
            return "电力高压段";
        }
        if("09".equals(equipLocation)){
            return "电力低压段";
        }
        if("99".equals(equipLocation)) {
            return "其他段";
        }
        return equipLocation;
    }

    @Override
    public int saveTbFaultDetail(TbFaultDetail tbFaultDetail, TbUser user) {
        int flag=0;
        if(tbFaultDetail.getFaultDetailNo()!=null){
            //修改
            logger.info("故障详情修改接口执行了");
            tbFaultDetail.setUpdateTime(new Date());
            tbFaultDetail.setUpdateUserCode(user.getCode());
            tbFaultDetail.setUpdateUserName(user.getName());
            flag=tbFaultDetailMapper.updateByPrimaryKeySelective(tbFaultDetail);
        }else {
            logger.info("故障详情新增接口执行了");
            //新增
            TbWorkTaskInfo tbWorkTaskInfo = tbWorkTaskInfoMapper.selectByPrimaryKey(tbFaultDetail.getTaskNo());
            if(tbWorkTaskInfo!=null){
                tbFaultDetail.setTaskCode(tbWorkTaskInfo.getTaskCode());
                tbFaultDetail.setEquipNo(tbWorkTaskInfo.getEquipNo());
                tbFaultDetail.setEquipName(tbWorkTaskInfo.getEquipName());
                if (StringUtils.isNotEmpty(tbWorkTaskInfo.getTaskFrom())){
                    TbEquipFaultInfo tbEquipFaultInfo = tbEquipFaultInfoMapper.selectByPrimaryKey(tbWorkTaskInfo.getTaskFrom());
                    if(tbEquipFaultInfo!=null){
                        tbFaultDetail.setFaultPic(tbEquipFaultInfo.getErrorPictures());
                        tbFaultDetail.setFaultTime(tbEquipFaultInfo.getUpdateTime());
                    }
                }else {
                    tbFaultDetail.setFaultTime(tbWorkTaskInfo.getCreateTime());
                }
                tbFaultDetail.setRepairTime(tbWorkTaskInfo.getRealFinishTime());
            }
            tbFaultDetail.setFaultDetailNo(StringTools.getUUID());
            tbFaultDetail.setCreateTime(new Date());
            tbFaultDetail.setCreateUserCode(user.getCode());
            tbFaultDetail.setCreateUserName(user.getName());
            flag=tbFaultDetailMapper.insertSelective(tbFaultDetail);
        }
        return flag;
    }

    @Override
    public Map getTbFaultDetail(String faultDetailNo) throws Exception {
        TbFaultDetail tbFaultDetail = tbFaultDetailMapper.selectByPrimaryKey(faultDetailNo);
        Map  map =getTbWorkTaskDetail(tbFaultDetail.getTaskNo());
        if(tbFaultDetail!=null) {
            map.put("faultDescription", tbFaultDetail.getFaultDescription());
            map.put("faultAnalysis", tbFaultDetail.getFaultAnalysis());
            map.put("dealPloy", tbFaultDetail.getDealPloy());
            map.put("faultNo", tbFaultDetail.getFaultNo());
            TbFaultType tbFaultType = tbFaultTypeMapper.selectByPrimaryKey(tbFaultDetail.getFaultNo());
            if(tbFaultType!=null){
                map.put("faultName", tbFaultType.getFaultName());
            }
        }
        return map;
    }
}

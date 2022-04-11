package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbEquipAdjustExtendMapper;
import com.ejobim.opplat.mapper.TbEquipAdjustMapper;
import com.ejobim.opplat.mapper.TbUserMapper;
import com.ejobim.opplat.service.EquipAdjustService;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("equipAdjustService")
public class EquipAdjustServiceImpl implements EquipAdjustService, IWorkFlowDetailService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TbEquipAdjustMapper equipAdjustMapper;
    private TbEquipAdjustExtendMapper equipAdjustExtendMapper;
    private TbUserMapper userMapper;

    @Autowired
    public EquipAdjustServiceImpl(TbEquipAdjustMapper equipAdjustMapper,TbEquipAdjustExtendMapper equipAdjustExtendMapper,TbUserMapper userMapper){
        this.equipAdjustMapper = equipAdjustMapper;
        this.equipAdjustExtendMapper = equipAdjustExtendMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<TbEquipAdjust> getDetailList(String orgNo, HttpServletRequest request, String userCode, Integer plat) {
        return equipAdjustMapper.selectByFlow(orgNo,request.getParameter("adName"),userCode,plat);
    }




    @Override
    public List<TbEquipAdjustExtend> getEquipAdjustExtendList(String adNo) {
        TbEquipAdjustExtendExample extendExample = new TbEquipAdjustExtendExample();
        TbEquipAdjustExtendExample.Criteria criteria = extendExample.createCriteria();
        //criteria.andAdNoEqualTo(adNo);
        return equipAdjustExtendMapper.selectByExample(extendExample);
    }

    @Override
    public TbEquipAdjust getEquipAdjustInfo(String adNo) {
        return equipAdjustMapper.selectByPrimaryKey(adNo);
    }


    @Override
    public int saveDetailInfo(JSONObject taskInfo,JSONObject extendInfo, String flowNo,String extendNo, String step,String nextStep) {
        if(taskInfo!=null){
            TbEquipAdjust tbEquipAdjust = JSON.toJavaObject(taskInfo,TbEquipAdjust.class);
            tbEquipAdjust.setAdNo(StringTools.getUUID());
            tbEquipAdjust.setFlowNo(flowNo);
            equipAdjustMapper.insertSelective(tbEquipAdjust);
        }
        TbEquipAdjustExtend tbEquipAdjustExtend = new TbEquipAdjustExtend();
        if(extendInfo!=null){
            tbEquipAdjustExtend = JSON.toJavaObject(extendInfo,TbEquipAdjustExtend.class);
        }

        tbEquipAdjustExtend.setAdDetailNo(StringTools.getUUID());
        tbEquipAdjustExtend.setExtendNo(extendNo);
        return equipAdjustExtendMapper.insertSelective(tbEquipAdjustExtend);
    }

    @Override
    public List getExtendListByExtendNo(List<String> extendNoList) {
        TbEquipAdjustExtendExample extendExample = new TbEquipAdjustExtendExample();
        TbEquipAdjustExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andExtendNoIn(extendNoList);
        return equipAdjustExtendMapper.selectByExample(extendExample);
    }

    @Override
    public Object getDetailInfoByFlowNo(String flowNo) {
        TbEquipAdjustExample example = new TbEquipAdjustExample();
        TbEquipAdjustExample.Criteria criteria = example.createCriteria();
        criteria.andFlowNoEqualTo(flowNo);
        List<TbEquipAdjust>  list = equipAdjustMapper.selectByExample(example);
        return list.size()==1?list.get(0):null;
    }
}

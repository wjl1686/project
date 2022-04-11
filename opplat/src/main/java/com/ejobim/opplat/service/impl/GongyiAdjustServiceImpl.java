package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbGongyiAdjust;
import com.ejobim.opplat.domain.TbGongyiAdjustExample;
import com.ejobim.opplat.domain.TbGongyiAdjustExtend;
import com.ejobim.opplat.domain.TbGongyiAdjustExtendExample;
import com.ejobim.opplat.mapper.TbGongyiAdjustExtendMapper;
import com.ejobim.opplat.mapper.TbGongyiAdjustMapper;
import com.ejobim.opplat.service.IWorkFlowDetailService;
import com.ejobim.opplat.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工艺调整
 * @author  xibian
 */
@Service("gongyiAdjustService")
public class GongyiAdjustServiceImpl implements IWorkFlowDetailService {
    @Autowired
    TbGongyiAdjustMapper gongyiAdjustMapper;
    @Autowired
    TbGongyiAdjustExtendMapper gongyiAdjustExtendMapper;

    @Override
    public int saveDetailInfo(JSONObject taskInfo, JSONObject extendInfo, String flowNo, String extendNo, String step, String nextStep) {
        if(taskInfo!=null){
            TbGongyiAdjust gongyiAdjust = JSON.toJavaObject(taskInfo,TbGongyiAdjust.class);
            gongyiAdjust.setFlowNo(flowNo);
            gongyiAdjust.setAdjustNo(StringTools.getUUID());
            gongyiAdjustMapper.insertSelective(gongyiAdjust);
        }
        if(extendInfo!=null){
            TbGongyiAdjustExtend gongyiAdjustExtend = JSON.toJavaObject(extendInfo,TbGongyiAdjustExtend.class);
            gongyiAdjustExtend.setExtendNo(extendNo);
            gongyiAdjustExtend.setAdExtendNo(StringTools.getUUID());
            gongyiAdjustExtendMapper.insert(gongyiAdjustExtend);
        }
        return 0;
    }

    @Override
    public List getExtendListByExtendNo(List<String> extendNoList) {
        TbGongyiAdjustExtendExample adjustExtendExample = new TbGongyiAdjustExtendExample();
        TbGongyiAdjustExtendExample.Criteria criteria = adjustExtendExample.createCriteria();
        criteria.andExtendNoIn(extendNoList);
        return gongyiAdjustExtendMapper.selectByExample(adjustExtendExample);
    }

    @Override
    public Object getDetailInfoByFlowNo(String flowNo) {
        TbGongyiAdjustExample gongyiAdjustExample = new TbGongyiAdjustExample();
        TbGongyiAdjustExample.Criteria criteria= gongyiAdjustExample.createCriteria();
        criteria.andFlowNoEqualTo(flowNo);
        List list = gongyiAdjustMapper.selectByExample(gongyiAdjustExample);
        return list.size()==1?list.get(0):null;
    }

    @Override
    public List getDetailList(String factoryNo, HttpServletRequest request, String userCode, Integer plat) {
        return gongyiAdjustMapper.selectByFlow(factoryNo,request.getParameter("adjustName"),userCode,plat,userCode==null);
    }
}

package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbWorkFlowConfigDetailExtendMapper;
import com.ejobim.opplat.mapper.TbWorkFlowConfigDetailMapper;
import com.ejobim.opplat.service.EquipOrderService;
import com.ejobim.opplat.service.WorkFlowService;
import com.ejobim.opplat.util.StringTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipOrderServiceTest {

    @Autowired
    TbWorkFlowConfigDetailMapper workFlowConfigDetailMapper;
    @Autowired
    TbWorkFlowConfigDetailExtendMapper workFlowConfigDetailExtendMapper;

    @Autowired
    WorkFlowService workFlowService;

    @Autowired
    EquipOrderService equipOrderService;

    @Test
    public void copyConfigDetail(){
        TbWorkFlowConfigDetailExample example = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteria = example.createCriteria();
        criteria.andConfigNoEqualTo("078d13be92984613ab9797c92b31973f");
        List<TbWorkFlowConfigDetail> detailList = workFlowConfigDetailMapper.selectByExample(example);
        for(TbWorkFlowConfigDetail workFlowConfigDetail:detailList){
            TbWorkFlowConfigDetailExtendExample extendExample = new TbWorkFlowConfigDetailExtendExample();
            TbWorkFlowConfigDetailExtendExample.Criteria criteria1 = extendExample.createCriteria();
            criteria1.andNodeNoEqualTo(workFlowConfigDetail.getNodeNo());
            List<TbWorkFlowConfigDetailExtend> extendList = workFlowConfigDetailExtendMapper.selectByExample(extendExample);
            String newNodeNo = StringTools.getUUID();
            for(TbWorkFlowConfigDetailExtend detailExtend:extendList){
                detailExtend.setNodeExtendNo(StringTools.getUUID());
                detailExtend.setNodeNo(newNodeNo);
                detailExtend.setFlowNo("4a2e9c20537e408cbcdcbe434d6ac3d1");
                workFlowConfigDetailExtendMapper.insertSelective(detailExtend);
            }
            workFlowConfigDetail.setConfigNo("4a2e9c20537e408cbcdcbe434d6ac3d1");

            workFlowConfigDetail.setNodeNo(newNodeNo);
            workFlowConfigDetailMapper.insertSelective(workFlowConfigDetail);

        }
    }

    @Test
    public void workFlowCopy(){
        workFlowService.workFlowCopyAlone("57547845a88e4d1ca53690cd7479e0e3","5c598ba8548e4af59db99e49490151ee");
    }

    @Test
    public void  getUnFinishEquipFaultList(){
        List<TbEquipFaultInfo> list = equipOrderService.getUnFinishEquipFaultList("5d4d3330fc3b7f00062a2308");
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getFinishTaskList(){
        List<TbWorkTaskInfo> list = equipOrderService.getFinishTaskList("5d81bd3194e57500078c2ac1",9);
        System.out.println(JSONObject.toJSONString(list));
    }

}

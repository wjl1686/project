package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.TbFactoryInfoVo;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.service.TbSynObjectService;
import com.ejobim.opplat.service.TbSysUseService;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import io.swagger.annotations.ApiImplicitParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.ToolBarUI;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryServiceTest {

    @Autowired
    TbFactoryService tbFactoryService;

    @Autowired
    TbSynObjectService tbSynObjectService;

    @Test
    public  void export(){
        String factoryNo = "5c6f5f581c5fda0001211081";
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        tbFactoryInfo.setFactoryNo(factoryNo);

        List<TbFactoryInfo> tbFactoryInfoList = tbFactoryService.getTbFactoryInfoNewList(tbFactoryInfo);
        List<TbFactoryInfoVo> tbFactoryInfoVoList = new ArrayList<>();
        for (TbFactoryInfo equipInfo : tbFactoryInfoList) {
            TbFactoryInfoVo tbEquipInfoVo = new TbFactoryInfoVo();
            BeanUtils.copyProperties(equipInfo, tbEquipInfoVo);
            tbFactoryInfoVoList.add(tbEquipInfoVo);
        }
        System.out.println(JSONObject.toJSONString(tbFactoryInfoVoList));
    }

    @Test
    public void getTree(){
        String factoryNo = "5d81bd3194e57500078c2ac1";
        Tree<TbSynObject> tbSynObjects = tbSynObjectService.findTreeLists(factoryNo, 0, 2, null);
        List<TbRealTimeConfig> tbRealTimeConfigList = tbFactoryService.fineTbRealTimeConfigList(factoryNo);
        List<String> idList = new ArrayList<>();
        for (TbRealTimeConfig tbRealTimeConfig : tbRealTimeConfigList) {
            idList.add(tbRealTimeConfig.getUri());
        }
        if (tbSynObjects != null) {
            TreeUtils.freshSynData(tbSynObjects.getChildren(), idList);
            TreeUtils.changeTreeLevel(tbSynObjects.getChildren().get(0).getChildren());
            Tree<TbSynObject> firstNode = null;
            if (tbSynObjects.getChildren() != null && tbSynObjects.getChildren().size() > 0) {
                for (Tree<TbSynObject> treeNode : tbSynObjects.getChildren().get(0).getChildren()) {
                    if (treeNode.getText().indexOf("运行指标") >= 0) {
                        firstNode = treeNode;
                    }
                }
                if (firstNode != null) {
                    tbSynObjects.getChildren().get(0).getChildren().remove(firstNode);
                    tbSynObjects.getChildren().get(0).getChildren().add(0, firstNode);

                }
            }
            System.out.println(JSONObject.toJSONString(tbSynObjects));
        }
    }

    @Test
    public void getFactoryTimeDetail(){
        TbUser user = new TbUser();
        user.setCode("system");
        user.setName("系统");
        try {
            tbFactoryService.saveTbFactoryTime("5dc4dc1b0ac067000750bc66",1,"00:00,08:00,16:00",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSONObject.toJSONString(tbFactoryService.getFactoryTimeDetail("5dc4dc1b0ac067000750bc66",1)));
    }
}

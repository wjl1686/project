package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbReportModel;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.HomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeServiceTest {

    @Autowired
    HomeService homeService;



    @Test
    public void getGroupHome(){

        Map<String,Object> map =  homeService.getGroupHomeData("111");
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void getHomeStaticInfo(){
        TbUser user1 = new TbUser();
        user1.setCode("156872876324200017");
        TbUser user2 = new TbUser();
        user2.setCode("156871570338900007");
        Map<String,Object> map = homeService.getHomeStaticInfo(user1,"5d4d3330fc3b7f00062a2308");

        //Map<String,Object> map = homeService.commonTaskInfoDetail(user1,"5d4d3330fc3b7f00062a2308");
        System.out.println(JSONObject.toJSONString(map));
//        map = homeService.getHomeStaticInfo(user2,2,"5d4d3330fc3b7f00062a2308");
//        System.out.println(JSONObject.toJSONString(map));
//        map = homeService.getHomeStaticInfo(null,3,"5d4d3330fc3b7f00062a2308");
//        System.out.println(JSONObject.toJSONString(map));
//        map = homeService.getHomeStaticInfo(null,4,"5d4d3330fc3b7f00062a2308");
//        System.out.println(JSONObject.toJSONString(map));
//        map = homeService.getHomeStaticInfo(null,5,"5d4d3330fc3b7f00062a2308");
//        System.out.println(JSONObject.toJSONString(map));
//        map = homeService.getHomeStaticInfo(null,6,"5d4d3330fc3b7f00062a2308");
//        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void getTaskStaticInfo(){
        Map<String,Object> map = homeService.getTaskStaticInfo("5d81bd3194e57500078c2ac1");
        System.out.println(JSONObject.toJSONString(map));
    }


}

package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbSchedulingPlanDeatail;
import com.ejobim.opplat.service.SchedulingService;
import com.ejobim.opplat.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulingServiceTest {

    @Autowired
    SchedulingService schedulingService;

    @Test
    public void getPlanUserList(){
        String factoryNo = "5d81bd3194e57500078c2ac1";
        int type = 1;
        String  time = DateUtils.formateDateFull(new Date());
        //String  time = DateUtils.formateDate(new Date());
        List<TbSchedulingPlanDeatail> list = schedulingService.getbSchedulingPlanInfoByGroupType(type, factoryNo, time);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void addNextWorkSchedule(){
        schedulingService.addNextWorkSchedule("5d81bd3194e57500078c2ac1");
    }
}

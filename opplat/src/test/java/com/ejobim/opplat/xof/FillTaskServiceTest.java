package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbAnalysisFillDetail;
import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.FillTaskService;
import com.ejobim.opplat.util.DateUtils;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FillTaskServiceTest {

    @Autowired
    FillTaskService fillTaskService;

    @Test
    public void getAnalysisTaskList(){
        TbAnalysisFillTask tbAnalysisFillTask = new TbAnalysisFillTask();
        tbAnalysisFillTask.setFactoryNo("5d81bd3194e57500078c2ac1");
        tbAnalysisFillTask.setFillTaskTime(DateUtils.parseDate("2019-12-02"));
        List<TbAnalysisFillTask> list =   fillTaskService.getAnalysisTaskList(tbAnalysisFillTask,null,null,null);
        System.out.println(JSONObject.toJSONString(list));
    }

    /**
     * 创建化验测试数据
     */
    @Test
    public void createFillTaskData(){
        Date beginDate = DateUtils.parseDate("2019-02-29");
        Date endDate = DateUtils.parseDate("2019-12-20");
        int count = DateUtils.differentDays(beginDate,endDate);
        String factoryNo = "5d81bd3194e57500078c2ac1";
        TbAnalysisFillTask tbAnalysisFillTaskSearch = new TbAnalysisFillTask();
        tbAnalysisFillTaskSearch.setFactoryNo(factoryNo);
        TbUser user = new TbUser();
        user.setCode("SYSTEM");
        user.setName("系统创建");
        for(int i=0;i<count;i++){
            Date taskDate = DateUtils.getNextDate(beginDate,i);
            tbAnalysisFillTaskSearch.setFillTaskTime(taskDate);
            int code =  fillTaskService.addTbAnalysisFillTask(factoryNo,taskDate,user);
            if(code==0){
                List<TbAnalysisFillTask> list =   fillTaskService.getAnalysisTaskList(tbAnalysisFillTaskSearch,null,null,null);

                if(list.size()==1){
                    TbAnalysisFillTask analysisFillTask = list.get(0);
                    List<TbAnalysisFillDetail> detailList = fillTaskService.getAnalysisTaskDetailList(list.get(0).getFillTaskNo());
                    for(TbAnalysisFillDetail analysisFillDetail:detailList){
                        analysisFillDetail.setFieldValue(Math.random()*10);
                    }
                    fillTaskService.saveAnalysisTaskDetailList(detailList);
                    analysisFillTask.setCommitTime(new Date());
                    analysisFillTask.setFillCount(analysisFillTask.getFillCountAll());
                    analysisFillTask.setFillUserCode(user.getCode());
                    analysisFillTask.setFillUserName(user.getName());
                    analysisFillTask.setStatus(2);
                    fillTaskService.updateTbAnalysisFillTask(analysisFillTask);
                }
            }

        }
    }
}

package com.ejobim.opplat.controller;

import com.ejobim.opplat.domain.TbAnalysisFillDetail;
import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbCalc;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.FillTaskService;
import com.ejobim.opplat.service.SynService;
import com.ejobim.opplat.service.TbCalcService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.DateUtils;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author wujianlong
 * @Description: 工具
 * @date 2019/1/15 18:16
 */
@Api( tags= "工具管理")
@RestController
@RequestMapping("/calc")
public class ToolController {

    @Autowired
    TbCalcService tbCalcService;
    @Autowired
    SynService synService;

    @Autowired
    BewgService bewgService;

    @Autowired
    FillTaskService fillTaskService;

    @RequestMapping(value = "/getCalcList",method = RequestMethod.GET)
    @ApiOperation(value = "获取计算器列表")
    public AjaxObject getCalcList(){
        List<TbCalc> tbCalcList = tbCalcService.getTbCalcList();
        List<Map<String,Object>> list = new ArrayList<>();

        for(TbCalc tbCalc:tbCalcList){
            Map<String,Object> calcMap = new HashMap<>(16);
            calcMap.put("name",tbCalc.getCalcName());
            System.out.println(tbCalc.getCalcContent());
            JSONObject calcInfo = JSONObject.fromObject(tbCalc.getCalcContent());
            JSONArray calcList = calcInfo.getJSONArray("calcList");
            //清理计算公式
            for(int i=0;i<calcList.size();i++){
                JSONArray resultList = calcList.getJSONObject(i).getJSONArray("resultList");
                for(int n=0;n<resultList.size();n++){
                    resultList.getJSONObject(n).put("calc","");
                }
            }
            JSONArray basePropertys = calcInfo.getJSONArray("baseProperty");
            for(int i=0;i<basePropertys.size();i++){
                if(basePropertys.getJSONObject(i).containsKey("calc")){
                    basePropertys.getJSONObject(i).put("calc","");
                }
            }
            calcMap.put("info", calcInfo);
            list.add(calcMap);
        }
        Map<String,Object> map = new HashMap<>(16);
        map.put("calcLis",list);
        return AjaxObject.ok(map);
    }

    @ApiOperation(value = "调取计算器计算过程获取结果")
    @RequestMapping(value = "/doCalc",method = RequestMethod.GET)
    public AjaxObject doCalc(HttpServletRequest request){
        String calcName = request.getParameter("calcName");
        TbCalc tbCalc = tbCalcService.getTbCalc(calcName);
        String calcContent = tbCalc.getCalcContent();
        JSONObject calcJson = JSONObject.fromObject(calcContent);
        JSONArray mainResultList = calcJson.getJSONArray("calcList");
        JSONArray basePropertys=  calcJson.getJSONArray("baseProperty");

        JSONObject inputJson = new JSONObject();
        for(int i=0;i<basePropertys.size();i++){
            JSONObject property = basePropertys.getJSONObject(i);
            if(property.getInt("type")==1){
                String str = request.getParameter(property.getString("code"));
                if(StringUtils.isNotEmpty(str)) {
                    return AjaxObject.error("缺少参数：" + property.getString("propertyName"));
                }else{
                    //赋值
                    inputJson.put(property.getString("code"),Double.valueOf(str));
                }
            }else if(property.getInt("type")==3){
                String str = request.getParameter(property.getString("code"));
                if(str!=null) {
                    //赋值
                    inputJson.put(property.getString("code"), Double.valueOf(str));
                }
            }
        }

        for(int i=0;i<basePropertys.size();i++){
            JSONObject property = basePropertys.getJSONObject(i);
            if(property.getInt("type")==2){
                String str = request.getParameter(property.getString("code"));
                if(StringUtils.isNotEmpty(str)) {
                    inputJson.put(property.getString("code"),doCalc(property,inputJson));
                }else{
                    inputJson.put(property.getString("code"),Double.valueOf(str));
                    //赋值
                }
            }
        }
        JSONObject mathJSON = mainResultList.getJSONObject(0);
        if(mainResultList.size()>1){
            String switchName = request.getParameter("switchName");
            for(int i = 0;i<mainResultList.size();i++){
                if(mainResultList.getJSONObject(i).getString("propertyName").equals(switchName)){
                    mathJSON = mainResultList.getJSONObject(i);
                    break;
                }
            }
        }
        Map<String,Object> resultJson = new JSONObject();
        System.out.println(mathJSON.getString("propertyName"));
        for(int n =0;n<mathJSON.getJSONArray("resultList").size();n++){
            JSONObject property = mathJSON.getJSONArray("resultList").getJSONObject(n);
            inputJson.put(property.getString("code"),doCalc(property,inputJson));
            resultJson.put(property.getString("propertyName"),doCalc(property,inputJson));
        }
        return AjaxObject.ok(resultJson);
    }
    private double  doCalc(JSONObject calcJSON,JSONObject inputJson) {
        JSONArray propertyList = calcJSON.getJSONArray("propertyList");
        Binding binding = new Binding();
        for (int i = 0; i < propertyList.size(); i++) {
            binding.setVariable(propertyList.getString(i), inputJson.getDouble(propertyList.getString(i)));
        }
        binding.setVariable("language", "Groovy");
        String calcMath = calcJSON.getString("calc");
        calcMath = calcMath.replace("^", "**");
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate(calcMath);
        System.out.println(calcJSON.getString("propertyName") + ":" + value.toString());
        return Double.valueOf(value.toString());
    }

    @RequestMapping(value = "/synData",method = RequestMethod.GET)
    public AjaxObject synData(HttpServletRequest request){
        synService.FacoryModelSynchronization();
        return AjaxObject.ok();
    }

    @RequestMapping(value = "/createSubscription",method = RequestMethod.GET)
    public String createSubscription(HttpServletRequest request){
        com.alibaba.fastjson.JSONObject jsonObject = bewgService.createSubscription(null);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getTabInfo",method = RequestMethod.POST)
    public AjaxObject getTabInfo(@RequestBody com.alibaba.fastjson.JSONObject jsonData){
        String searchInfo = jsonData.getString("searchInfo");
        if(searchInfo.toLowerCase().startsWith("select")){
            List<Map<String,Object>> list = tbCalcService.getTableDetailInfo(searchInfo);
            Map<String,Object> resultMap = new HashMap<>(2);
            resultMap.put("list",list);
            return AjaxObject.ok(resultMap);
        }else {
            return AjaxObject.error("");
        }

    }

    @RequestMapping(value = "/createDemoData",method = RequestMethod.POST)
    public AjaxObject createDemoData(String beginDate, String endDate){
        Date begin = DateUtils.parseDate(beginDate);
        Date end = DateUtils.parseDate(endDate);
        int count = DateUtils.differentDays(begin,end);
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
        return AjaxObject.ok("");
    }
}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.enums.ProjectTypeEnum;
import com.ejobim.opplat.domain.vo.TbEquipOverhaulVo;
import com.ejobim.opplat.mapper.TbWorkFlowConfigDetailExtendMapper;
import com.ejobim.opplat.mapper.TbWorkFlowConfigDetailMapper;
import com.ejobim.opplat.mapper.TbWorkFlowConfigMapper;
import com.ejobim.opplat.service.EquipOrderService;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.OverhaulService;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.util.*;
import io.jsonwebtoken.lang.Assert;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author wujianlong
 * @Description: 大修重置
 * @date 2019/1/15 18:16
 */
@Api(tags = "大修重置管理")
@RestController
@RequestMapping("/overhaul")
public class OverhaulController extends  BaseController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private OverhaulService overhaulService;
    private TbFactoryService tbFactoryService;
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Environment env;

    @Autowired
    public OverhaulController(OverhaulService overhaulService,TbFactoryService tbFactoryService,StringRedisTemplate stringRedisTemplate){
        Assert.notNull(overhaulService, "anticorrosiveService must not be null!");
        Assert.notNull(tbFactoryService, "tbFactoryService must not be null!");
        Assert.notNull(stringRedisTemplate, "stringRedisTemplate must not be null!");
        this.overhaulService = overhaulService;
        this.tbFactoryService = tbFactoryService;
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @RequestMapping("/getFileList")
    public AjaxObject getFileList(HttpServletRequest request,TbEquipTaskFile overhaulTaskFile){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipTaskFile> list =  overhaulService.getFileList(overhaulTaskFile);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/uploadAttachFile")
    public AjaxObject uploadAttachFile(TbEquipTaskFile overhaulTaskFile){
        if(overhaulService.addTaskFile(overhaulTaskFile)>0) {
            return AjaxObject.ok("上传文件成功");
        }else{
            return AjaxObject.error("上传文件失败");
        }
    }



    /**
     * 下载 模板大修重置下载模板
     * @param request,response
     * @return
     */
    @Autowired
    private EquipService equipService;

    @RequestMapping(value = "/downloadModel",method = RequestMethod.GET)
    public void downloadModel(HttpServletRequest request, HttpServletResponse response, String factoryNo){
        String fileName ="大修重置模板.xlsx";
        List<TbEquipInfo> tbEquipInfoList = new ArrayList<>();
        if(factoryNo==null){
            return;
        }{
            TbEquipInfo tbEquipInfo = new TbEquipInfo();
            tbEquipInfo.setFactoryNo(factoryNo);
            tbEquipInfoList =equipService.getEquipList(tbEquipInfo);
        }
        //巡检要素3  维保要素4  大修5 填报指标6
        int type =5;
        logger.info("下载大修重置模板开始");
        List<String> equipNameList = new ArrayList<>();
        for (TbEquipInfo tbEquipInfo : tbEquipInfoList) {
            equipNameList.add(tbEquipInfo.getEquipName()+","+tbEquipInfo.getEquipNo());
        }
        List<String> projectTypeList =new ArrayList<>();
        projectTypeList.add("大修");
        projectTypeList.add("改造");
        projectTypeList.add("重置");
        projectTypeList.add("新增");
        List<String> isEntrustList =new ArrayList<>();
        isEntrustList.add("是");
        isEntrustList.add("否");
        Map map = new HashMap();
        map.put("fileName",fileName);
        map.put("type",type);
        map.put("projectTypeList",projectTypeList);
        map.put("isEntrustList",isEntrustList);
        map.put("equipNameList",equipNameList);
        ExcelHighUtils.writeExcelX(response,null, TbEquipOverhaulVo.class,map);
        logger.info("下载大修重置模板成功");
    }
    /**
     * 批量导入大修
     * @param request,file
     * @return
     */
    @Autowired
    EquipOrderService equipOrderService;
    
    @Autowired
    TbWorkFlowConfigDetailMapper tbWorkFlowConfigDetailMapper; 
    
    @Autowired
    TbWorkFlowConfigMapper tbWorkFlowConfigMapper;
    
    @Autowired
    TbWorkFlowConfigDetailExtendMapper workFlowConfigDetailExtendMapper;
    
    String folwCode ="SBDX";
    
    @RequestMapping(value = "/importTbEquipOverhaul",method = RequestMethod.POST)
    public AjaxObject importEquip(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo){
        AjaxObject ajaxObject = new AjaxObject();
        List<TbEquipOverhaulVo> list = ExcelUtils.readExcel("", TbEquipOverhaulVo.class, file);
        String equipNo="";
        logger.info("批量批量导入大修信息list={}", JSON.toJSONString(list));
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(list!=null && list.size()>0){
            for (TbEquipOverhaulVo tbVo : list) {
                if(factoryNo==null || "".equals(factoryNo)){
                    ajaxObject = AjaxObject.error("水厂no不能为空");
                    break;
                }
                tbVo.setOrgNo(factoryNo);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("flowCode",folwCode);
                String equipName = tbVo.getEquipName();
                if(equipName.split(",").length==2){
                    equipNo  = equipName.split(",")[1];
                    tbVo.setEquipName(equipName.split(",")[0]);
                }else {
                    ajaxObject = AjaxObject.error("设备名称,不能为空");
                    break;
                }
                String planTime = tbVo.getPlanTime();
                if(planTime==null || "".equals(planTime)){
                    ajaxObject = AjaxObject.error("计划实施时间,不能为空");
                    break;
                }
                if(tbVo.getPlanCost()==null || "".equals(tbVo.getPlanCost())){
                    ajaxObject = AjaxObject.error("预算（含税金额）万元,不能为空");
                    break;
                }
                if(tbVo.getRealCost()==null || "".equals(tbVo.getRealCost())){
                    ajaxObject = AjaxObject.error("预算（不含税）万元,不能为空");
                    break;
                }
                if(tbVo.getTaxRate()==null || "".equals(tbVo.getTaxRate())){
                    ajaxObject = AjaxObject.error("参照税率(X.00%),不能为空");
                    break;
                }
                if(tbVo.getOverhaulContent()==null || "".equals(tbVo.getOverhaulContent())){
                    ajaxObject = AjaxObject.error("预算计算明细,不能为空");
                    break;
                }
                if(tbVo.getOverhaulSanitationOkType()==null || "".equals(tbVo.getOverhaulSanitationOkType())){
                    ajaxObject = AjaxObject.error("项目类型,不能为空");
                    break;
                }
                if(tbVo.getIsEntrustType()==null || "".equals(tbVo.getIsEntrustType())){
                    ajaxObject = AjaxObject.error("是否委外,不能为空");
                    break;
                }else {
                    // 0不委外 1委外
                    if(tbVo.getIsEntrustType().equals("是")){
                        tbVo.setIsEntrust(1);
                    }else {
                        tbVo.setIsEntrust(0);
                    }
                }
                if(tbVo.getOverhaulVideo()==null || "".equals(tbVo.getOverhaulVideo())){
                    ajaxObject = AjaxObject.error("实时原因,不能为空");
                    break;
                }
                if(tbVo.getTaskContent()==null || "".equals(tbVo.getTaskContent())){
                    ajaxObject = AjaxObject.error("大修目标,不能为空");
                    break;
                }
                String[] split = planTime.split("-");
                Date monthFirstDay;
                if(split.length==2){
                    monthFirstDay = DateUtils.getMonthFirstDay(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }else {
                    ajaxObject = AjaxObject.error("计划实施时间格式不正确,导入失败");
                    break;
                }
                tbVo.setPlanStartTime(monthFirstDay);
                tbVo.setEquipNo(equipNo);
                tbVo.setUrgencyDegree(0);
                tbVo.setTaskType(6);
                tbVo.setOverhaulSanitationOk(ProjectTypeEnum.getCode(tbVo.getOverhaulSanitationOkType()));
                //通过水厂no  和维修类型
                TbWorkFlowConfigExample example = new TbWorkFlowConfigExample();
                TbWorkFlowConfigExample.Criteria criteria = example.createCriteria();
                criteria.andOrgNoEqualTo(factoryNo);
                criteria.andFlowCodeEqualTo(folwCode);
                List<TbWorkFlowConfig> tbWorkFlowConfigs = tbWorkFlowConfigMapper.selectByExample(example);
                String flowNo="";
                if(tbWorkFlowConfigs!=null && tbWorkFlowConfigs.size()>0){
                    flowNo=tbWorkFlowConfigs.get(0).getFlowNo();
                }else {
                    ajaxObject = AjaxObject.error("工作流大修流程没有配置,导入失败");
                    break;
                }
                TbWorkFlowConfigDetail tbWorkFlowConfigDetail = getTbWorkFlowConfigDetail(flowNo);
                if(tbWorkFlowConfigDetail==null){
                    ajaxObject = AjaxObject.error("工作流大修流程没有配置,导入失败");
                    break;
                }
                TbWorkFlowConfigDetailExtend workFlowConfigDetailExtendSearch = new TbWorkFlowConfigDetailExtend();
                workFlowConfigDetailExtendSearch.setNodeNo(tbWorkFlowConfigDetail.getNodeNo());
                List<TbWorkFlowConfigDetailExtend> workFlowDetailExtendList = getWorkFlowDetailExtendList(workFlowConfigDetailExtendSearch);
                if(workFlowDetailExtendList!=null && workFlowDetailExtendList.size()>0){
                    tbWorkFlowConfigDetail.setFieldList(workFlowDetailExtendList);
                    jsonObject.put("flowNode",tbWorkFlowConfigDetail);
                }else {
                    ajaxObject = AjaxObject.error("工作流大修流程没有配置,导入失败");
                    break;
                }
                jsonObject.put("detailInfo",tbVo);
                System.out.println(jsonObject);
                int flag= equipOrderService.saveWorkFlowInfo(jsonObject, user);
                    if(flag==0) {
                        ajaxObject =AjaxObject.ok("导入成功");
                    }else{
                        ajaxObject = AjaxObject.error("导入失败");
                    }
                }            
        }else {
            ajaxObject =  AjaxObject.error("数据为空,导入失败");
        }
        return  ajaxObject;
    }
    
    public TbWorkFlowConfigDetail getTbWorkFlowConfigDetail(String flowNo ){
        TbWorkFlowConfigDetail detail = new TbWorkFlowConfigDetail();
        TbWorkFlowConfigDetailExample detailExample = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteriaDetail = detailExample.createCriteria();
        criteriaDetail.andConfigNoEqualTo(flowNo);
        detailExample.setOrderByClause("node_sort");
        detail =tbWorkFlowConfigDetailMapper.selectByExample(detailExample).get(0);
        return detail;
    }

    public List<TbWorkFlowConfigDetailExtend> getWorkFlowDetailExtendList(TbWorkFlowConfigDetailExtend workFlowConfigDetailExtend) {
        TbWorkFlowConfigDetailExtendExample extendExample = new TbWorkFlowConfigDetailExtendExample();
        TbWorkFlowConfigDetailExtendExample.Criteria criteria = extendExample.createCriteria();
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(workFlowConfigDetailExtend.getNodeNo())){
            criteria.andNodeNoEqualTo(workFlowConfigDetailExtend.getNodeNo());
        }
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(workFlowConfigDetailExtend.getFlowNo())){
            criteria.andFlowNoEqualTo(workFlowConfigDetailExtend.getFlowNo());
        }

        extendExample.setOrderByClause(" field_index ");
        return workFlowConfigDetailExtendMapper.selectByExample(extendExample);
    }
}

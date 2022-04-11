package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbEquipMaintainFactor;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.TbWorkTaskInfo;
import com.ejobim.opplat.domain.condition.TbEquipMaintainWorkCondition;
import com.ejobim.opplat.domain.vo.TbEquipMaintainFactorVo;
import com.ejobim.opplat.service.EquipOrderService;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.TbEquipMaintainFactorService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.ExcelHighUtils;
import com.ejobim.opplat.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.WorkFlowCommon.WB_TYPE;

/**
 * @author wujianlong
 * @Description: 维保要素相关
 * @date 2019/7/11 14:18
 */
@Api(tags = "维保要素相关")
@RestController
@RequestMapping("maintainFactor")
public class EquipMaintainFactorController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbEquipMaintainFactorService tbEquipMaintainFactorService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EquipOrderService equipOrderService;



    /**
     * 查询维保要素列表
     * @param  request
     * @param  tbEquipMaintainFactor
     * @return
     */
    @ApiOperation(value = "查询水厂的维保要素")
    @GetMapping("/getTbEquipMaintainFactorList")
    public AjaxObject getTbEquipMaintainFactorList(HttpServletRequest request, TbEquipMaintainFactor tbEquipMaintainFactor){
        logger.info("维保要素查询条件TbEquipMaintainFactor={}", JSON.toJSONString(tbEquipMaintainFactor));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipMaintainFactor> list =  tbEquipMaintainFactorService.getTbEquipMaintainFactorList(tbEquipMaintainFactor,null);
        return super.getResultObject(list, request.getParameter("page"));
    }

    /**
     * 查询维保要素列表
     * @param  request
     * @param  tbEquipMaintainFactor
     * @return
     */
    @GetMapping("/getTbEquipMaintainFactorAllList")
    public AjaxObject getTbEquipMaintainFactorAllList(HttpServletRequest request, TbEquipMaintainFactor tbEquipMaintainFactor){
        logger.info("维保要素查询条件TbEquipMaintainFactor={}", JSON.toJSONString(tbEquipMaintainFactor));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipMaintainFactor> list =  tbEquipMaintainFactorService.getTbEquipMaintainFactorList(tbEquipMaintainFactor,null);
        if(list.size()>0){
            TbEquipMaintainFactor tbEquipInfoQ = new TbEquipMaintainFactor();
            tbEquipInfoQ.setMfNo("0");
            tbEquipInfoQ.setMfContent("全部");
            list.add(0,tbEquipInfoQ);
        }
        return super.getResultObject(list, request.getParameter("page"));
    }
    /**
     * 根据水厂查询设备列表
     * @param  request
     * @param  tbEquipInfo
     * @return
     */
    @GetMapping("/getTbEquipListByfactoryNo")
    @ApiOperation(value = "查询水厂设备列表")
    public List<TbEquipInfo> getTbEquipListByfactoryNo(HttpServletRequest request,TbEquipInfo tbEquipInfo){
        logger.info("根据水厂查询设备列表条件TbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        List<TbEquipInfo> list =  tbEquipMaintainFactorService.getTbEquipListByfactoryNo(tbEquipInfo);
        return list;
    }
    /**
     * 新增/修改设备维保要素
     * @param  request
     * @param  tbEquipMaintainFactor
     * @return
     */
    @PostMapping("/saveTbEquipMaintainFactor")
    @ApiOperation(value = "新增修改维保要素")
    public AjaxObject saveTbEquipMaintainFactor(HttpServletRequest request, TbEquipMaintainFactor tbEquipMaintainFactor){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        if(tbEquipMaintainFactor.getMfNo()!=null){
            logger.info("修改设备维保要素参数TbEquipMaintainFactor={}", JSON.toJSONString(tbEquipMaintainFactor));
            tbEquipMaintainFactor.setUpdateUserCode(user.getCode());
            tbEquipMaintainFactor.setUpdateUserName(user.getName());
            tbEquipMaintainFactor.setUpdateTime(new Date());
        }else {
            logger.info("新增设备维保要素参数TbEquipMaintainFactor={}", JSON.toJSONString(tbEquipMaintainFactor));
            tbEquipMaintainFactor.setCreateUserCode(user.getCode());
            tbEquipMaintainFactor.setCreateUserName(user.getName());
            tbEquipMaintainFactor.setCreateTime(new Date());
        }
        if(tbEquipMaintainFactorService.saveTbEquipMaintainFactor(tbEquipMaintainFactor)>0) {
                ajaxObject =AjaxObject.ok("成功");
        }else{
                ajaxObject = AjaxObject.ok("失败");
        }
        return ajaxObject;
    }

    /**
     * 删除设备维保要素
     * @param  request
     * @param  tbEquipMaintainFactor
     * @return
     */
    @ApiOperation(value = "更新或删除维保要素")
    @PostMapping("/updateEquipMaintainFactor")
    public AjaxObject updateEquipMaintainFactor(HttpServletRequest request, TbEquipMaintainFactor tbEquipMaintainFactor){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("删除设备维保要素参数TbEquipMaintainFactor={}", JSON.toJSONString(tbEquipMaintainFactor));
        if(tbEquipMaintainFactorService.updateEquipMaintainFactor(tbEquipMaintainFactor)>0) {
            ajaxObject =AjaxObject.ok("成功");
        }else{
            ajaxObject = AjaxObject.ok("失败");
        }
        return ajaxObject;
    }

    /**
     * 批量创建维保计划
     * @param request
     * @param factoryNo
     * @return
     */
    @PostMapping("/createMaintenancePlan")
    @ApiOperation(value = "批量创建维保计划")
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public AjaxObject createMaintenancePlan(HttpServletRequest request, String factoryNo){
        logger.info("创建水厂维保计划factoryNo={}", factoryNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        List<TbWorkTaskInfo> workTaskInfoList = equipOrderService.getUnFinishTaskInfoList(factoryNo,WB_TYPE);
        List<String> elementNoList = workTaskInfoList.stream().map(TbWorkTaskInfo::getTaskFrom).collect(Collectors.toList());
        List<TbEquipMaintainFactor> equipMaintainFactorList = tbEquipMaintainFactorService.getTbEquipMaintainFactorList(factoryNo);
        List<TbEquipMaintainFactor> unUseList = new ArrayList<>();
        for(int i=0;i<equipMaintainFactorList.size();i++){
            if(!elementNoList.contains(equipMaintainFactorList.get(i).getMfNo())){
                unUseList.add(equipMaintainFactorList.get(i));
            }
        }
        int resultCode = equipOrderService.createMaintenanceList(factoryNo,unUseList,user);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    /**
     * 创建临时维保计划
     * @param request
     * @param mfNo,taskDate
     * @return
     */
    @PostMapping("/createTempMaintenance")
    @ApiOperation(value = "创建历史维保")
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public AjaxObject createTempMaintenance(HttpServletRequest request, String mfNo,Date taskDate){
        logger.info("创建单个维保计划mfNo={},taskDate={}", mfNo,taskDate);
        TbUser user = super.getUser(request,stringRedisTemplate);
        TbEquipMaintainFactor tbEquipMaintainFactor = tbEquipMaintainFactorService.getTbEquipMaintainFactorByKey(mfNo);
        List<TbWorkTaskInfo> workTaskInfoList = equipOrderService.getUnFinishTaskInfoList(tbEquipMaintainFactor.getFactoryNo(),WB_TYPE);
        TbWorkTaskInfo currentTask = null;
        for(TbWorkTaskInfo workTaskInfo:workTaskInfoList){
            if(workTaskInfo.getTaskFrom().equals(mfNo)){
                currentTask = workTaskInfo;
                break;
            }
        }
        if(currentTask!=null){
            currentTask.setPlanStartTime(taskDate);
            tbEquipMaintainFactor.setMfTime(taskDate);
            tbEquipMaintainFactorService.updateEquipMaintainFactor(tbEquipMaintainFactor);
            int resultCode = equipOrderService.updateTbWorkTaskInfo(currentTask);
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        }else{
            int resultCode = equipOrderService.createMaintenanceAlone(tbEquipMaintainFactor.getFactoryNo(),tbEquipMaintainFactor,user);
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        }

    }

    /**
     * 创建单个维保计划
     * @param request
     * @param mfNo,taskDate,whether
     * @return
     */
    @ApiOperation(value = "创建单个维保")
    @PostMapping("/createSinMaintenance")
    public AjaxObject createSinMaintenance(HttpServletRequest request, String mfNo,Date taskDate,Integer whether,String checkUser){
        AjaxObject ajaxObject = new AjaxObject();
        logger.info("创建单个维保计划mfNo={},taskDate={}", mfNo,taskDate);
        TbUser user = super.getUser(request,stringRedisTemplate);
        TbEquipMaintainFactor tbEquipMaintainFactor = tbEquipMaintainFactorService.getTbEquipMaintainFactorByKey(mfNo);
        Map map = new HashMap();
        map.put("user",user);
        map.put("taskDate",taskDate);
        map.put("whether",whether);
        map.put("checkUser",checkUser);
        map.put("tbEquipMaintainFactor",tbEquipMaintainFactor);
        try {
            int flag = equipOrderService.createMaintenanceAloneNew(map);
            if(flag==1){
                ajaxObject = AjaxObject.ok("创建成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增失败e={}", e);
            ajaxObject = AjaxObject.error("创建失败，请联系管理员!");
        }
        return ajaxObject;
    }


    /**
     * 批量创建维保计划
     * @param  request
     * @param  condition
     * @return
     */
    @ApiOperation(value = "创建维保计划")
    @RequestMapping(value ="/createBatchMaintenancePlan",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public AjaxObject createBatchMaintenancePlan(HttpServletRequest request, @RequestBody TbEquipMaintainWorkCondition condition){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("批量创建维保计划参数TbEquipMaintainWorkCondition={}", JSON.toJSONString(condition));
        try {
            if(condition==null){
                ajaxObject = AjaxObject.error("创建失败,参数为空");
            }
            int flag = equipOrderService.createBatchMaintenancePlan(condition,user);
            if(flag==1){
                ajaxObject = AjaxObject.ok("创建成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增失败e={}", e);
            ajaxObject = AjaxObject.error("创建失败，请联系管理员!");
        }
        return ajaxObject;
    }
    /**
     * 下载 模板维保要素模板
     * @param request,response
     * @return
     */
    @Autowired
    private EquipService equipService;

    @ApiOperation(value = "下载维保要素导入模板")
    @RequestMapping(value = "/downloadModel",method = RequestMethod.GET)
    public void downloadModel(HttpServletRequest request, HttpServletResponse response, String factoryNo){
        List<TbEquipInfo> tbEquipInfoList = new ArrayList<>();
        if(factoryNo==null){
            return;
        }{
            TbEquipInfo tbEquipInfo = new TbEquipInfo();
            tbEquipInfo.setFactoryNo(factoryNo);
            tbEquipInfoList =equipService.getEquipList(tbEquipInfo);
        }
        //巡检要素3  维保要素4  大修5 填报指标6
        List<String> equipNameList = new ArrayList<>();
        for (TbEquipInfo tbEquipInfo : tbEquipInfoList) {
            equipNameList.add(tbEquipInfo.getEquipName()+","+tbEquipInfo.getEquipNo());
        }
        Map map = new HashMap();
        map.put("fileName","维保要素模板.xlsx");
        map.put("type",4);
        map.put("equipNameList",equipNameList);
        ExcelHighUtils.writeExcelX(response,null, TbEquipMaintainFactorVo.class,map);
        logger.info("下载维保要素模板Ok");
    }

    /**
     * 批量导入维保要素
     * @param request,file
     * @return
     */
    @ApiOperation(value = "批量导入维保要素")
    @RequestMapping(value = "/importEquipMaintainFactor",method = RequestMethod.POST)
    public AjaxObject importEquip(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo){
        AjaxObject ajaxObject = new AjaxObject();
        List<TbEquipMaintainFactorVo> list = ExcelUtils.readExcel("", TbEquipMaintainFactorVo.class, file);
        logger.info("批量导入维保要素信息list={}", JSON.toJSONString(list));
        TbUser user = super.getUser(request,stringRedisTemplate);
        list.forEach(o->{
            o.setCreateUserCode(user.getCode());
            o.setCreateUserName(user.getName());
            o.setCreateTime(new Date());
            o.setFactoryNo(factoryNo);
        });
        try {
            int i =tbEquipMaintainFactorService.saveImportEquipMaintainFactor(list);
            if(i==1){
                ajaxObject = AjaxObject.ok("导入成功");
            }else {
                ajaxObject =  AjaxObject.error("导入失败");
            }
        } catch (Exception e) {
            ajaxObject =AjaxObject.error(e.getMessage());
            e.printStackTrace();
            ajaxObject =  AjaxObject.error("导入失败");
        }
        return  ajaxObject;
    }

}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.bean.CodeModel;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.domain.vo.TbSchedulingPlanVo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.service.SchedulingService;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.service.TbSysUseService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.ExcelUtils;
import com.ejobim.opplat.util.QR_Code;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.*;

/**
 * @author wujianlong
 * @Description: 班组排班相关
 * @date 2019/7/11 14:18
 */
@Api(tags = "班组排班相关")
@RestController
@RequestMapping("scheduling")
public class SchedulingController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SchedulingService schedulingService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TbSysUseService tbSysUseService;
    
    @Autowired
    private TbFactoryService tbFactoryService; 



    /**
     * 查询班组列表
     * @param  request
     * @param  tbGroupInfo
     * @return
     */
    @GetMapping("/getTbGroupInfoList")
    @ApiOperation(value = "查询班组列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupName", value = "班组名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "班组类型", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject getTbEquipMaintainFactorList(HttpServletRequest request,  TbGroupInfo tbGroupInfo){
        logger.info("查询班组列表条件TbGroupInfo={}", JSON.toJSONString(tbGroupInfo));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbGroupInfo> list =  schedulingService.getTbGroupInfoList(tbGroupInfo);
        return super.getResultObject(list, request.getParameter("page"));
    }


    /**
     * 根据班组添加人,水厂查询用户
     * @param  request
     * @param  tbGroupInfo
     * @return
     */
    @GetMapping("/getTbUserListByfactoryNo")
    @ApiOperation(value = "获取班组")
    public List<TbUser> getTbUserListByfactoryNo(HttpServletRequest request,TbGroupInfo tbGroupInfo){
        logger.info("根据水厂查询用户列表条件TbGroupInfo={}", JSON.toJSONString(tbGroupInfo));
        List<TbUser> list = tbSysUseService.getTbUserListByFactoryNo(tbGroupInfo);
        return list;
    }
    /**
     * 新增/修改班组
     * @param  request
     * @param  tbGroupInfo
     * @return
     */
    @RequestMapping(value ="/saveTbGroupInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "新增修改班组")
    public AjaxObject saveTbGroupInfo(HttpServletRequest request, @RequestBody TbGroupInfo tbGroupInfo){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        if(tbGroupInfo.getGroupNo()!=null){
            logger.info("修改班组参数TbGroupInfo={}", JSON.toJSONString(tbGroupInfo));
            tbGroupInfo.setUpdateUserCode(user.getCode());
            tbGroupInfo.setUpdateUserName(user.getName());
            tbGroupInfo.setUpdateTime(new Date());
        }else {
            logger.info("新增班组要素参数TbGroupInfo={}", JSON.toJSONString(tbGroupInfo));
            tbGroupInfo.setCreateUserCode(user.getCode());
            tbGroupInfo.setCreateUserName(user.getName());
            tbGroupInfo.setCreateTime(new Date());
        }
        try {
            int flag =schedulingService.saveTbGroupInfo(tbGroupInfo);
            if(flag==1){
                    ajaxObject = AjaxObject.ok("新增/修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增/修改班组失败e={}", e);
            ajaxObject = AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }
    /**
     * 班组获取排班日历
     * @param request
     * @param condition
     * @return
     */
    @GetMapping("/getGroupCalendarData")
    @ApiOperation(value = "获取班组的排班信息")
    @ResponseBody
    public AjaxObject getGroupCalendarData(HttpServletRequest request, TbSchedulingPlanCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("查询班组获取排班日历参数TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        Map<String,Object>  map  = schedulingService.getGroupCalendarData(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }
    /**
     * 查询排班计划页数据(app共用我的排班)
     * @param request
     * @param condition
     * @return
     */
    @GetMapping("/getTbSchedulingPlanHomeInfo")
    @ApiOperation(value = "查询排班计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "年份", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "mouth", value = "月份", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "source", value = "来源(1:后台 2:App)", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public AjaxObject getTbSchedulingHomeInfo(HttpServletRequest request, TbSchedulingPlanCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        Map<String,Object>  map = new HashMap<>(16);
        Map<String,Object> objectMap = new HashMap<>(16);
        logger.info("查询排班计划页数据参数TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        if(condition.getSource()!=null){
            if(condition.getSource()==2){
                //来源app
                condition.setUserCode(user.getCode());
            }
        }
        if(condition.getFactoryNo()!=null){
         map = schedulingService.getTbSchedulingHomeInfo(condition);
        }
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap); 
    }
    /**
     * 点击日历查看排班信息
     * @param request
     * @param condition
     * @return
     */
    @GetMapping("/getTbSchedulingInfoByTime")
    @ApiOperation(value = "查询当日的排班信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "schedulingTime", value = "排班日期", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "source", value = "来源(1:后台 2:App)", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public AjaxObject getTbSchedulingInfoByTime(HttpServletRequest request, TbSchedulingPlanCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("点击日历查看排班信息TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        if(condition.getSource()!=null){
            if(condition.getSource()==2){
                //来源app
                condition.setUserCode(user.getCode());
            }else{
                if(condition.getSchedulingTime()!=null) {
                    condition.setSchedulingTime(DateUtils.formateDate(DateUtils.parseDate(condition.getSchedulingTime())));
                }
            }
        }
        Map<String,Object>  map  = schedulingService.getTbSchedulingInfoByTime(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }
    

    /**
     * 新增排班计划
     * @param  request
     * @param  tbSchedulingPlan
     * @return
     */
    @RequestMapping(value ="/saveTbSchedulingPlan",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "新增排班计划")
    public AjaxObject saveTbSchedulingPlan(HttpServletRequest request, @RequestBody TbSchedulingPlan tbSchedulingPlan){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
            logger.info("新增排班计划参数TbSchedulingPlan={}", JSON.toJSONString(tbSchedulingPlan));
            List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlan.getSchedulingPlanList();
            for (TbSchedulingPlan schedulingPlan : schedulingPlanList) {
                schedulingPlan.setCreateUserCode(user.getCode());
                schedulingPlan.setCreateUserName(user.getName());
                schedulingPlan.setCreateTime(new Date());
            }
        try {
            int flag =schedulingService.saveTbSchedulingPlan(tbSchedulingPlan);
            if(flag>0) {
                ajaxObject =AjaxObject.ok("成功");
            }else{
                ajaxObject = AjaxObject.error("失败");
            }
        } catch (Exception e) {
                ajaxObject = AjaxObject.error(e.getMessage());
            e.printStackTrace();
        }
        return ajaxObject;
    }

    /**
     * 修改排班计划
     * @param  request
     * @param  tbSchedulingPlan
     * @return
     */
    @ApiOperation(value = "修改排班计划")
    @RequestMapping(value ="/updateTbSchedulingPlan",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public AjaxObject updateTbSchedulingPlan(HttpServletRequest request, @RequestBody TbSchedulingPlan tbSchedulingPlan){
         AjaxObject ajaxObject = new AjaxObject();
         TbUser user = super.getUser(request, stringRedisTemplate);
            logger.info("修改排班计划参数TbSchedulingPlan={}", JSON.toJSONString(tbSchedulingPlan));
            List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlan.getSchedulingPlanList();
            for (TbSchedulingPlan schedulingPlan : schedulingPlanList) {
                schedulingPlan.setCreateUserCode(user.getCode());
                schedulingPlan.setCreateUserName(user.getName());
                schedulingPlan.setCreateTime(new Date());
            }
        try {
            int flag =schedulingService.updateTbSchedulingPlan(tbSchedulingPlan);
            if(flag>0) {
                ajaxObject =AjaxObject.ok("成功");
            }else{
                ajaxObject = AjaxObject.error("失败");
            }
        } catch (Exception e) {
            ajaxObject = AjaxObject.error(e.getMessage());
            e.printStackTrace();
        }

        return ajaxObject;
    }
    /**
     * 查询排班设置页数据
     * @param request
     * @param condition
     * @return
     */
    @GetMapping("/getTbSchedulingSetInfo")
    @ResponseBody
    public AjaxObject getTbSchedulingSetInfo(HttpServletRequest request, TbSchedulingPlanCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("查询排班设置页数据参数TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        Map<String,Object>  map  = schedulingService.getTbSchedulingSetInfo(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }

    /**
     * app换班申请
     * @param  request
     * @param  tbSchedulingChange
     * @return
     */
    @ApiOperation(value = "申请换班")
    @RequestMapping(value ="/applyTbSchedulingChange",method = RequestMethod.POST)
    public AjaxObject saveTbGroupInfo(HttpServletRequest request,  TbSchedulingChange  tbSchedulingChange){
        //AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        if(tbSchedulingChange.getChangeNo()!=null){
            logger.info("修改班组参数TbSchedulingChange={}", JSON.toJSONString(tbSchedulingChange));
            tbSchedulingChange.setApplyUserName(user.getName());
            tbSchedulingChange.setApplyUserCode(user.getCode());
            tbSchedulingChange.setUpdateUserCode(user.getCode());
            tbSchedulingChange.setUpdateUserName(user.getName());
            tbSchedulingChange.setUpdateTime(new Date());
        }else {
            logger.info("新增app换班申请参数TbSchedulingChange={}", JSON.toJSONString(tbSchedulingChange));
            tbSchedulingChange.setApplyUserName(user.getName());
            tbSchedulingChange.setApplyUserCode(user.getCode());
            tbSchedulingChange.setCreateUserCode(user.getCode());
            tbSchedulingChange.setCreateUserName(user.getName());
            tbSchedulingChange.setCreateTime(new Date());
        }
        try {
            int flag =schedulingService.applyTbSchedulingChange(tbSchedulingChange);
            if(flag==1){
                if(tbSchedulingChange.getChangeNo()!=null){
                    return AjaxObject.ok("修改成功");
                }else{
                    return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
                }
            }else{
                return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("app换班申请失败e={}", e);
            return AjaxObject.error("app换班申请失败，请联系管理员！");
        }
    }

    /**
     * 根据排班日期和班组类型查询班组排班列表(目标班组)
     * @param  request
     * @param  tbSchedulingPlan
     * @return
     */
    @ApiOperation(value = "根据排班日期和班组类型查询班组排班列表")
    @GetMapping("/app/getTargetTbSchedulingPlan")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "schedulingTime", value = "排班日期", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupNo", value = "班组no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "班组类型", required = true, dataType = "string", paramType = "query")
    })
    public List<TbSchedulingPlan> getTargetTbSchedulingPlan(HttpServletRequest request,TbSchedulingPlan tbSchedulingPlan){
        TbUser user = super.getUser(request, stringRedisTemplate);
        tbSchedulingPlan.setUserCode(user.getCode());
        logger.info("根据排班日期和班组类型查询班组排班列表条件(目标班组)TbSchedulingPlan={}", JSON.toJSONString(tbSchedulingPlan));
        List<TbSchedulingPlan> list = schedulingService.getTbSchedulingPlan(tbSchedulingPlan);
        return list;
    }

    /**
     * 查询换班申请列表
     * @param  request
     * @param  tbSchedulingChange
     * @return
     */
    @ApiOperation(value = "查询换班记录")
    @GetMapping("/getTbSchedulingChangeList")
    public AjaxObject getTbSchedulingChangeList(HttpServletRequest request, TbSchedulingChange tbSchedulingChange){
        logger.info("查询换班申请列表条件TbSchedulingPlan={}", JSON.toJSONString(tbSchedulingChange));
        TbUser user = super.getUser(request, stringRedisTemplate);
        if(tbSchedulingChange.getSource()==2){
            tbSchedulingChange.setApplyUserCode(user.getCode());
            tbSchedulingChange.setTargetUserCode(user.getCode());
        }
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbSchedulingChange> list =  schedulingService.getTbSchedulingChangeList(tbSchedulingChange);
        return super.getResultObject(list, request.getParameter("page"));
    }

    /**
     *  换班申请通过或驳回
     * @param request
     * @param tbSchedulingChange
     * @return
     */
    @ApiOperation(value = "换班申请审核")
    @PostMapping("/goCheckAgreeOrReject")
    @ResponseBody
    public AjaxObject goCheckAgreeOrReject(HttpServletRequest request, TbSchedulingChange tbSchedulingChange){
        logger.info("换班申请通过或驳回参数TbEquipPlan={}", tbSchedulingChange);
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        tbSchedulingChange.setUpdateUserCode(user.getCode());
        tbSchedulingChange.setUpdateUserName(user.getName());
        tbSchedulingChange.setUpdateTime(new Date());
        try {
            int flag =  schedulingService.goCheckAgreeOrReject(tbSchedulingChange);
            if(flag==1) {
                ajaxObject =AjaxObject.ok("成功");
            }else{
                ajaxObject = AjaxObject.error("失败");
            }
        } catch (BusinessException e) {
            e.printStackTrace();
                ajaxObject = AjaxObject.error(e.getCode(),e.getMsg());
        }
        return ajaxObject;
    }

    /**
     * app端查询当前申请人的班组的排班信息
     * @param  request
     * @return
     */
    @ApiOperation(value = "查询个人的排班计划")
    @GetMapping("/app/getTbSchedulingPlanByApplyUser")
    public TbSchedulingPlanVo getTbSchedulingPlanByApplyUser(HttpServletRequest request, TbSchedulingPlanCondition condition){
        TbUser user = super.getUser(request, stringRedisTemplate);
        condition.setUserCode(user.getCode());
        logger.info("app端查询当前申请人的班组的排班信息参数TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        TbSchedulingPlanVo tbSchedulingPlan = schedulingService.getTbSchedulingPlanByApplyUser(condition);
        return tbSchedulingPlan;
    }

    /**
     * 校验交班生成二维吗
     * @param  request
     * @param  condition
     * @return
     */
    @ApiOperation(value = "校验交班信息")
    @GetMapping("/app/checkTbSchedulingTransferUser")
    public AjaxObject checkTbSchedulingTransferUser(HttpServletRequest request, TbSchedulingPlanCondition condition){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        condition.setUserCode(user.getCode());
        //成功 1 其他都不可以
        logger.info("校验交班生成二维吗条件TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        int flag = 0;
        try {
            flag = schedulingService.checkTbSchedulingTransferUser(condition);
            if(flag==1) {
                ajaxObject =AjaxObject.ok("成功");
            }else{
                ajaxObject =  AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
                ajaxObject = AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }
    /**
     * 获取二维码
     * @param request,response,equipNos
     * @return
     */
    @ApiOperation(value = "交班二维码")
    @GetMapping("/app/getTbSchedulingTransferViewQR")
    public void getTbSchedulingTransferViewQR(HttpServletRequest request, HttpServletResponse response){
        TbUser user = super.getUser(request, stringRedisTemplate);
        TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
        condition.setUserCode(user.getCode());
        logger.info("获取二维码参数TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        List<TbSchedulingPlan> tbSchedulingPlanList = schedulingService.getbSchedulingPlanInfoByUserCodeByDate(condition);
        tbSchedulingPlanList.forEach(tbSchedulingPlan -> {
            tbSchedulingPlan.setUserCode(user.getCode());
            tbSchedulingPlan.setUserName(user.getName());
            tbSchedulingPlan.setEndTimePointName(DateUtils.formateDateFull(tbSchedulingPlan.getEndTimePoint()));
        });
        try {
            response.reset();
            String fileName = DateUtils.formateDate("yyyyMMddHHmmss") + ".jpg";
            response.setHeader("content-disposition","attachment;filename=" + fileName );
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Cache-Control","no-cache");
            createEquipQR(response.getOutputStream(),tbSchedulingPlanList,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 交班二维码生成
     */
    public  void createEquipQR(OutputStream outputStream, List<TbSchedulingPlan> tbSchedulingPlanList, String className)
            throws IOException {
        try {
            //获取图片
            int width = 400;
            int height = 400;
            BufferedImage image = new BufferedImage(width,height ,BufferedImage.TYPE_INT_RGB);
            //根据xy点坐标绘制闭合多边形
            Graphics2D g2d = image.createGraphics();
            g2d.setBackground(Color.WHITE);
            g2d.clearRect(0, 0, width, height);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SimHei", Font.PLAIN, 30));
            int x  = 850 - className.length() * 15;
            g2d.drawString(className, x, 50);
            for(int i=0;i<tbSchedulingPlanList.size();i++) {
                TbSchedulingPlan student =tbSchedulingPlanList.get(i);
                student.setTransferCode(student.getGroupNo()+DateUtils.formateDatePartNo(new Date()));
                g2d.drawRect(0 , 0, 400, 400);
                g2d.setFont(new Font("SimHei", Font.PLAIN, 24));
                CodeModel info = new CodeModel();
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("groupNo",student.getGroupNo());
                jsonObject.put("groupName",student.getGroupName());
                jsonObject.put("endTimePointName",student.getEndTimePointName());
                jsonObject.put("schedulingTime",student.getSchedulingTime());
                jsonObject.put("dayType",student.getDayType());
                jsonObject.put("groupType",student.getGroupType());
                jsonObject.put("userCode",student.getUserCode());
                jsonObject.put("userName",student.getUserName());
                jsonObject.put("transferCode",student.getTransferCode());
                info.setContents(jsonObject.toJSONString());
                QR_Code code = new QR_Code();
                BufferedImage bufferedImage = code.dealLogoAndPic(info);
                g2d.drawImage((Image)bufferedImage, 0  , 0, 400, 400,null);
            }
            //设置透明度
            ImageIO.write(image, "jpg", outputStream);
            g2d.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            outputStream.close();
        }
    }

    /**
     * app扫码接班
     * @param  request
     * @param  plan
     * @return
     */
    @ApiOperation(value = "扫码交接班")
    @PostMapping("/app/reciveTbSchedulingTransfer")
    public AjaxObject reciveTbSchedulingTransfer(HttpServletRequest request, TbSchedulingPlan plan){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        plan.setCreateUserCode(user.getCode());
        plan.setCreateUserName(user.getName());
        plan.setCreateTime(new Date());
        //成功 1 其他都不可以
        logger.info("app扫码接班参数TbSchedulingPlan={}", JSON.toJSONString(plan));
        int flag =  schedulingService.reciveTbSchedulingTransfer(plan);
        if(flag==1) {
            ajaxObject =AjaxObject.ok("成功");
        }else{
            ajaxObject =  AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
        }
        return ajaxObject;
    }
    /**
     * 查询交班列表
     * @param  request
     * @param  transfer
     * @return
     */
    @ApiOperation(value = "查询交班记录")
    @GetMapping("/getTbSchedulingTransferList")
    public AjaxObject getTbSchedulingTransferList(HttpServletRequest request, TbSchedulingTransfer transfer){
        logger.info("查询换班列表条件TbSchedulingTransfer={}", JSON.toJSONString(transfer));
        TbUser user = super.getUser(request, stringRedisTemplate);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbSchedulingTransfer> list =  schedulingService.getTbSchedulingTransferList(transfer);
        return super.getResultObject(list, request.getParameter("page"));
    }
    
    /**
     *  根据交班no查看详情
     * @param request,equipInfo
     * @return
     */
    @ApiOperation(value = "查询交班详情")
    @GetMapping("/geTbSchedulingTransferInfo")
    @ResponseBody
    public AjaxObject geTbSchedulingTransferInfo(HttpServletRequest request,TbSchedulingTransfer transfer){
        logger.info("根据交班no查看详情条件TbSchedulingTransfer={}", JSON.toJSONString(transfer));
        TbUser user = super.getUser(request,stringRedisTemplate);
        TbSchedulingTransfer transferInfo =  schedulingService.geTbSchedulingTransferInfo(transfer);
        Map<String,Object> map = new HashMap<>(16);
        map.put("transferInfo",transferInfo);
        return AjaxObject.ok(map);
    }

    /**
     * 打印排班
     * @param request,response
     * @return
     */
    @ApiOperation(value = "导出排班信息到Excel")
    @RequestMapping(value = "/exportTbSchedulingPlan",method = RequestMethod.GET)
    public void downloadModel(HttpServletRequest request,  HttpServletResponse response,TbSchedulingPlanCondition condition){
        String fileName =condition.getYear()+"年"+condition.getMouth()+"月"+"排班.xls";
        int type =3;
        List<TbSchedulingPlan> tbSchedulingPlanList = schedulingService.selectSchedulingPlanListByCondition(condition);
        List<TbSchedulingPlanVo> tbSchedulingPlanVoList = new ArrayList<>();
        String ban="";
        String cheng="";
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            TbSchedulingPlanVo tbSchedulingPlanVo = new TbSchedulingPlanVo();
            BeanUtils.copyProperties(tbSchedulingPlan,tbSchedulingPlanVo);
            tbSchedulingPlanVo.setFactoryName(tbFactoryService.getFactoryInfoByNo(tbSchedulingPlan.getFactoryNo())!=null ?tbFactoryService.getFactoryInfoByNo(tbSchedulingPlan.getFactoryNo()).getFactoryName() :null);
            if(tbSchedulingPlan.getGroupType()==1){
                tbSchedulingPlanVo.setGroupTypeName("运行班");
            }else {
                tbSchedulingPlanVo.setGroupTypeName("设备班");
            }
            if(tbSchedulingPlan.getDayType()==0){
                tbSchedulingPlanVo.setDayTypeName("本日");
            }else {
                tbSchedulingPlanVo.setDayTypeName("次日");
            }
            //取出成员
            cheng="";
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlan.getTbSchedulingPlanDeatailList();
            for (TbSchedulingPlanDeatail deatail : tbSchedulingPlanDeatailList) {
                if(deatail.getUserType()==1){
                    ban =deatail.getUserName();
                }else {
                    cheng+=deatail.getUserName()+",";
                }
            }
            tbSchedulingPlanVo.setBanUser(ban);
            tbSchedulingPlanVo.setChengUser(cheng.substring(0, cheng.length()-1));
            tbSchedulingPlanVoList.add(tbSchedulingPlanVo);
        }
        for (TbSchedulingPlanVo tbSchedulingPlanVo : tbSchedulingPlanVoList) {
            tbSchedulingPlanVo.setStartTimePointName(DateUtils.formateDateFull(tbSchedulingPlanVo.getStartTimePoint()));
            tbSchedulingPlanVo.setEndTimePointName(DateUtils.formateDateFull(tbSchedulingPlanVo.getEndTimePoint()));
            tbSchedulingPlanVo.setCreateTimeName(DateUtils.formateDateFull(tbSchedulingPlanVo.getCreateTime()));
        }
        logger.info("导出打印排班数据tbSchedulingPlanList={}", JSON.toJSONString(tbSchedulingPlanList));
        ExcelUtils.writeExcel(response,tbSchedulingPlanVoList, TbSchedulingPlanVo.class,null,null,fileName,type,null);
    }
    
    /**
     * 二维码回调
     * @param  request
     * @param  condition
     * @return
     */
    @GetMapping("/app/callBack")
    public AjaxObject callBack(HttpServletRequest request, TbSchedulingPlanCondition condition){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        condition.setCurrentTime(user.getCode());
        logger.info("二维码回调条件TbSchedulingPlanCondition={}", JSON.toJSONString(condition));
        int flag =  schedulingService.callBack(condition);
        if(flag==1) {
            ajaxObject =AjaxObject.ok("交接班成功");
        }else{
            ajaxObject =  AjaxObject.error(499,"暂无交接");
        }
        return ajaxObject;
    }
    /**
     * pc获取计划池
     * @param request
     * @param condition
     * @return
     */
    @GetMapping("/getTbWorkTaskCalendarInfo")
    @ResponseBody
    public AjaxObject getTbWorkTaskCalendarInfo(HttpServletRequest request, TbWorkTaskInfoCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info(" 获取计划池参数TbWorkTaskInfoCondition={}", JSON.toJSONString(condition));
        Map<String,Object>  map  = schedulingService.getTbWorkTaskCalendarInfo(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }
    /**
     * 点击日历查看计划信息
     * @param request
     * @param condition
     * @return
     */
    @ApiOperation(value = "点击日历查看计划信息")
    @GetMapping("/getTbWorkTaskInfoByTime")
    public AjaxObject getTbWorkTaskInfoByTime(HttpServletRequest request, TbWorkTaskInfoCondition condition){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info(" 获取计划池参数TbWorkTaskInfoCondition={}", JSON.toJSONString(condition));
        condition.setCurrentTime(DateUtils.formateDate(DateUtils.parseDate(condition.getCurrentTime())));
        Map<String,Object>  map  = schedulingService.getTbWorkTaskInfoByTime(condition);
        Map<String,Object> objectMap = new HashMap<>(16);
        objectMap.putAll(map);
        return AjaxObject.ok(objectMap);
    }

    /**
     * 批量修改计划池日期
     * @param  request
     * @param  condition
     * @return
     */
    @ApiOperation(value = "批量修改计划池日期")
    @RequestMapping(value ="/updateBatchTbWorkTaskInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public AjaxObject updateTbSchedulingPlan(HttpServletRequest request, @RequestBody TbWorkTaskInfoCondition condition){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        //logger.info("批量修改计划池参数TbWorkTaskInfoCondition={}", JSON.toJSONString(condition.getTbWorkTaskInfoList()));
        try {
            int flag =schedulingService.updateBatchTbWorkTaskInfo(condition);
            if(flag>0) {
                ajaxObject =AjaxObject.ok("成功");
            }else{
                ajaxObject = AjaxObject.error("失败");
            }
        } catch (Exception e) {
                ajaxObject = AjaxObject.error(e.getMessage());
                e.printStackTrace();
        }
        return ajaxObject;
    }

    /**
     * 获取当前登录的人组code
     * @param  request
     * @param  condition
     * @return
     */
    @GetMapping("/app/getUserGroupCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getUserGroupCode(HttpServletRequest request, TbSchedulingPlanCondition condition){
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        condition.setUserCode(user.getCode());
        try {
            String code= schedulingService.getUserGroupCode(condition);
            if(!"".equals(code)) {
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("transferCode",code);
                ajaxObject =AjaxObject.ok(jsonObject);
            }else{
                ajaxObject =  AjaxObject.error(501,"该用户没有设置班组");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxObject = AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }
    
    /**
     * 删除班组
     * @param  request
     * @param  groupNo
     * @return
     */
    @ApiOperation(value = "删除班组")
    @RequestMapping(value ="/deleteTbGroupInfo",method = RequestMethod.POST)
    public AjaxObject deleteTbGroupInfo(HttpServletRequest request, String groupNo){
        logger.info("删除班组参数groupNo={}", groupNo);
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            int flag =schedulingService.deleteTbGroupInfo(groupNo);
            if(flag>=1){
                ajaxObject = AjaxObject.ok("删除班组成功");
            }else{
                ajaxObject = AjaxObject.error("删除班组失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除班组失败e={}", e);
            ajaxObject = AjaxObject.error("删除班组失败，请联系管理员！");
        }
        return ajaxObject;
    }
    /**
     * 删除排班
     * @param  request
     * @param  schedulingNos
     * @return
     */
    @ApiOperation(value = "删除排班计划")
    @RequestMapping(value ="/deleteTbScheduling",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "schedulingNos", value = "排班的主键no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject deleteTbScheduling(HttpServletRequest request, String schedulingNos){
        logger.info("删除排班参数schedulingNos={}", schedulingNos);
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            int flag =schedulingService.deleteTbScheduling(schedulingNos);
            if(flag>=1){
                ajaxObject = AjaxObject.ok("删除排班成功");
            }else{
                ajaxObject = AjaxObject.error("删除排班失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除排班失败e={}", e);
            ajaxObject = AjaxObject.error("删除排班失败，请联系管理员！");
        }
        return ajaxObject;
    }

    /**
     * 新增排班规则参数TbSchedulingRule
     * @param  request
     * @param  tbSchedulingRule
     * @return
     */
    @ApiOperation(value = "保存排班规则")
    @PostMapping("/saveTbSchedulingRule")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "班组类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "ruleType", value = "规则类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "extendInfo", value = "详情", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject saveTbSchedulingRule(HttpServletRequest request, @RequestBody TbSchedulingRule tbSchedulingRule){
        logger.info("新增排班规则参数TbSchedulingRule={}",JSON.toJSON(tbSchedulingRule));

        if(tbSchedulingRule.getEnableTime().getTime()<System.currentTimeMillis()){
            return  AjaxObject.error("起效时间必须晚于当天");
        }
        TbUser user = super.getUser(request, stringRedisTemplate);
        if(StringUtils.isEmpty(tbSchedulingRule.getSchedulingRuleNo())){
            tbSchedulingRule.setCreateUserName(user.getName());
            tbSchedulingRule.setCreateUserCode(user.getCode());
            tbSchedulingRule.setCreateTime(new Date());
        }else{
            tbSchedulingRule.setUpdateUserName(user.getName());
            tbSchedulingRule.setUpdateUserCode(user.getCode());
            tbSchedulingRule.setUpdateTime(new Date());
        }
        try {
            int resultCode =schedulingService.saveTbSchedulingRule(tbSchedulingRule);
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxObject.error(e.getMessage());
        }
    }
    /**
     * 查询排班规则列表
     * @param  request
     * @param  tbSchedulingRule
     * @return
     */
    @GetMapping("/getTbSchedulingRuleList")
    @ApiOperation(value = "查询排班规则列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupName", value = "班组名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "班组类型", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject getTbSchedulingRuleList(HttpServletRequest request, TbSchedulingRule tbSchedulingRule){
        logger.info("查询排班规则列表TbSchedulingRule={}", JSON.toJSONString(tbSchedulingRule));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbSchedulingRule> list =  schedulingService.getTbSchedulingRuleList(tbSchedulingRule);
        List<Integer> typeList = new ArrayList<>();
        for(TbSchedulingRule schedulingRule:list){
            if(!typeList.contains(schedulingRule.getGroupType())){
                schedulingRule.setCanEdit(1);
                typeList.add(schedulingRule.getGroupType());
                continue;
            }else{
                schedulingRule.setCanEdit(0);
            }
        }
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/addAutoSchedule")
    @ApiOperation(value = "新增自动排班")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject addAutoSchedule(HttpServletRequest request, String factoryNo){
        logger.info("查询排班规则列表TbSchedulingRule={}", factoryNo);
        int resultCode  =  schedulingService.addNextWorkSchedule(factoryNo);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }
}

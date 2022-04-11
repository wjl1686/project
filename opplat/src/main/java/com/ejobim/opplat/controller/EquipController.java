package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.bean.CodeModel;
import com.ejobim.opplat.domain.vo.TbEquipInfoVo;
import com.ejobim.opplat.mapper.TbEquipTypeMapper;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
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
 * @Description: 设备管理
 * @date 2019/1/19 10:47
 */
@Api(tags = "设备相关接口")
@RestController
@RequestMapping("/equip")
public class EquipController extends  BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EquipService equipService;

    @Autowired
    private TbSynObjectService tbSynObjectService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TbDictService tbDictService;

    @Autowired
    private EquipOrderService equipOrderService;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private TbEquipTypeMapper tbEquipTypeMapper;

    /**
     * 查询设备列表
     * @param req,tbEquipInfo
     * @return
     */
    @GetMapping("/getEquipList")
    @ApiOperation(value = "查询设备列表")
    public AjaxObject getEquipList(HttpServletRequest req, TbEquipInfo tbEquipInfo){
        logger.info("查询设备列表参数TbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbEquipInfo> tbEquipInfos = equipService.getEquipList(tbEquipInfo);
        for (TbEquipInfo equipInfo : tbEquipInfos) {
            equipInfo.setEquipNameS(equipInfo.getEquipName()+"("+getEquipLocation(equipInfo.getInstallationSite())+""+"["+getQiHao(equipInfo.getIssueNo())+"]"+")");
        }
        return super.getResultObject(tbEquipInfos,req.getParameter("page"));
    }
    
    public String getQiHao(String issueNo ) { 
        if("1".equals(issueNo)) {
            return "一期";
        }
        if("2".equals(issueNo)){
            return "二期";
        }
        if("3".equals(issueNo)){
            return "三期";
        }
        if("4".equals(issueNo)){
            return "四期";
        }
        return "一期";
    }

    public String getEquipLocation(String equipLocation ) {
        if("01".equals(equipLocation)) {
            return "进水段";
        }
        if("02".equals(equipLocation)){
            return "提升段";
        }
        if("03".equals(equipLocation)){
            return "初沉段";
        }
        if("04".equals(equipLocation)){
            return "生化处理段";
        }
        if("05".equals(equipLocation)){
            return "二沉段";
        }
        if("06".equals(equipLocation)){
            return "脱水段";
        }
        if("07".equals(equipLocation)){
            return "深水处理段";
        }
        if("08".equals(equipLocation)){
            return "电力高压段";
        }
        if("09".equals(equipLocation)){
            return "电力低压段";
        }
        if("99".equals(equipLocation)) {
            return "其他段";
        }
        return equipLocation;
    }
    /**
     * 获取设备列表  工作流专用
     * @param req
     * @param tbEquipInfo
     * @return
     */
    @GetMapping("/getEquipListFlow")

    public AjaxObject getEquipListFlow(HttpServletRequest req, TbEquipInfo tbEquipInfo){
        logger.info("查询设备列表工作流专用参数TbTbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        List<TbEquipInfo> tbEquipInfos = equipService.getEquipList(tbEquipInfo);
        List<Map<String,String>> list = new ArrayList<>();
        for(TbEquipInfo equipInfo:tbEquipInfos){
            Map<String,String> map = new HashMap<>();
            map.put("value",equipInfo.getEquipNo());
            map.put("text",equipInfo.getEquipName());
            list.add(map);
        }
        return super.getResultObject(list,null);
    }

    /**
     * 查询设备列表
     * @param req,tbEquipInfo
     * @return
     */
    @GetMapping("/getALlEquipList")
    public AjaxObject getALlEquipList(HttpServletRequest req, TbEquipInfo tbEquipInfo){
        logger.info("查询所有设备列表参数TbTbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        TbEquipInfo tbEquipInfoQ = new TbEquipInfo();
        tbEquipInfoQ.setEquipNo("0");
        tbEquipInfoQ.setEquipName("全部");
        List<TbEquipInfo> tbEquipInfos = equipService.getEquipList(tbEquipInfo);
        if(tbEquipInfos!=null && tbEquipInfos.size()>0){
            tbEquipInfos.add(0,tbEquipInfoQ);
        }
        return super.getResultObject(tbEquipInfos,req.getParameter("page"));
    }

    @PostMapping("/saveEquipInfo")
    @ApiOperation(value = "修改设备台账信息")
    public AjaxObject saveEquipInfo(HttpServletRequest request,  TbEquipInfo tbEquipInfo){
        TbUser user = super.getUser(request,stringRedisTemplate);
        String code =  "";
        if(tbEquipInfo.getEquipSort()<10){
            code =  tbEquipInfo.getIssueNo()+"0" + tbEquipInfo.getEquipSort();
        }else if(tbEquipInfo.getEquipSort()<100){
            code = tbEquipInfo.getIssueNo() + tbEquipInfo.getEquipSort();
        }else {
            code=tbEquipInfo.getEquipSort()+"";
        }        
        if(tbEquipInfo.getFactoryCode()!=null){
            String equipCode =  tbEquipInfo.getFactoryCode() +  tbEquipInfo.getInstallationSite() + tbEquipInfo.getEquipTypeCode() + code + tbEquipInfo.getEquipMainType();
            tbEquipInfo.setEquipCode(equipCode);
        }
        tbEquipInfo.setUpdateUser(user.getName());
        tbEquipInfo.setUpdateTime(new Date());
        logger.info("保存设备参数TbTbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        if(equipService.saveEquipInfo(tbEquipInfo)>=1){
            return AjaxObject.ok("添加成功");
        }else{
            return AjaxObject.error("添加失败");
        }
    }
    /**
     * 修改设备列表
     * @param request
     * @param tbEquipInfo
     * @return
     */
    @PostMapping("/updateEquipInfo")
    @ApiOperation(value = "SED设备和数采平台设备URI关联")
    public AjaxObject updateEquipInfo(HttpServletRequest request,  TbEquipInfo tbEquipInfo){
        logger.info("修改设备列表参数TbTbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(equipService.saveEquipInfo(tbEquipInfo)>=1){
            return AjaxObject.ok("关联成功");
        }else{
            return AjaxObject.error("成功失败");
        }
    }

    @PostMapping("/changeEquipStatus")
    @ApiOperation(value = "设备停用启用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "equipNo", value = "设备编号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "设备状态（1：停用；0：启用）", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject changeEquipStatus(HttpServletRequest request,  String equipNo, Integer status){

        logger.info("起/停用设备 =编号：{} 状态：{}", equipNo,status);
        TbUser user = super.getUser(request,stringRedisTemplate);
        int resultCode = equipService.changeEquipStatus(equipNo,status,user);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }




    /**
     * 查询设施列表
     * @param req
     * @return
     */
    @ApiOperation(value = "查询设施列表")
    @GetMapping("/getAttachmentList")
    public AjaxObject getAttachmentList(HttpServletRequest req){
        String equipNo = req.getParameter("equipNo");
        String fileName = req.getParameter("fileName");
        logger.info("查询设施列表参数equipNo={}", equipNo);
        logger.info("查询设施列表参数fileName={}", fileName);
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbEquipAttachment> list = equipService.getAttachmentList(equipNo,fileName);
        return  super.getResultObject(list,req.getParameter("page"));
    }
    /**
     * 保存设施
     * @param request,tbEquipAttachment
     * @return
     */
    @ApiOperation(value = "保存设施信息")
    @PostMapping("/saveEquipAttachment")
    public AjaxObject saveEquipAttachment(HttpServletRequest request, TbEquipAttachment tbEquipAttachment ){
        logger.info("保存设施参数TbEquipAttachment={}", JSON.toJSONString(tbEquipAttachment));
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        tbEquipAttachment.setAttachmentUpload(user.getName());
        if(equipService.saveTbEquipAttachment(tbEquipAttachment)>=1){
            return AjaxObject.ok("添加成功");
        }else{
            return AjaxObject.error("添加失败");
        }

    }
    /**
     * 删除设施
     * @param request,tbEquipAttachment
     * @return
     */
    @ApiOperation(value = "删除设施")
    @PostMapping("/delEquipAttachment")
    public AjaxObject delEquipAttachment(HttpServletRequest request, TbEquipAttachment tbEquipAttachment ){
        logger.info("删除设施参数TbEquipAttachment={}", JSON.toJSONString(tbEquipAttachment));
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        if(equipService.delTbEquipAttachment(tbEquipAttachment)>=1){
            return AjaxObject.ok("删除成功");
        }else{
            return AjaxObject.error("删除失败");
        }
    }

    /**
     * 查询设备调整列表
     * @param request,tbAdjustEquip
     * @return
     */
    @GetMapping("/getAdjustEquipList")
    public AjaxObject getAdjustEquipList(HttpServletRequest request, String keyName,String factoryNo){
        logger.info("查询设备调整列表参数TbAdjustEquip={}{}", keyName,factoryNo);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbAdjustEquip> list = equipService.getAdjuastEquipList(factoryNo,keyName);
        return  super.getResultObject(list,request.getParameter("page"));
    }




    /**
     * 根据设备编号查询设备信息
     * @param request,equipNo
     * @return
     */
    @ApiOperation(value = "查询设备详情")
    @GetMapping("/getTbEquipInfo")
    public AjaxObject getTbEquipInfo(HttpServletRequest request,String equipNo){
        logger.info("根据设备编号查询设备信息EquipNo={}", equipNo);
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
        TbEquipInfo tbEquipInfo = equipService.getEquipInfo(equipNo);
        Map<String,Object> map = new HashMap<>(16);
        map.put("tbEquipInfo",tbEquipInfo);
        return  AjaxObject.ok(map);
    }


    public void getUserInfo(HttpServletRequest request){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("当前登录用户User={}", JSON.toJSONString(user));
    }

    /**
     * 根据tbequipInfo 查询完整的信息
     * @param request,tbEquipInfo
     * @return
     */
    @GetMapping("/getEquipInfo")
    public AjaxObject getEquipInfo(HttpServletRequest request,TbEquipInfo tbEquipInfo){
        logger.info("查看设备详情之基本信息参数TbEquipInfo={}", JSON.toJSONString(tbEquipInfo));
        getUserInfo(request);
        List list = equipService.selectEquipBaseInfoByKey(tbEquipInfo);
        return super.getResultObject(list, null);
    }


    /**
     * 根据 equipNo 查询运行参数信息
     * @param request,tbSynObject
     * @return
     */
    @GetMapping("/getRunningParams")
    @ApiOperation(value = "查询设备的实时运行状态")
    public AjaxObject getRunningParams(HttpServletRequest request,TbSynObject tbSynObject){
        logger.info("查看设备详情之运行参数信息参数TbSynObject={}", JSON.toJSONString(tbSynObject));
        getUserInfo(request);
        List<TbSynObject> list = tbSynObjectService.selectSynObjectList(tbSynObject);
        List<Map<String,String>> resultList = equipService.getRunningParamsBySynInfo(list);
        for(int i = resultList.size()-1;i>=0;i--){
            if(resultList.get(i)!=null){
                resultList.remove(i);
            }
        }
        return super.getResultObject(resultList, null);
    }

    /**
     * 维修上传的附件
     * @param tbEquipTaskFile
     * @return
     */
    @PostMapping("/uploadAttachFile")
    @ApiOperation(value = "上传设备附属文件资料")
    public AjaxObject uploadAttachFile(HttpServletRequest request,TbEquipTaskFile tbEquipTaskFile){
        logger.info("pc查询维修上传的附件列表参数TbEquipTaskFile={}", JSON.toJSONString(tbEquipTaskFile));
        getUserInfo(request);
        if(equipService.addTaskFile(tbEquipTaskFile)>0) {
            return AjaxObject.ok("上传文件成功");
        }else{
            return AjaxObject.error("上传文件失败");
        }
    }
    /**
     * 查询维修上传的附件列表
     * @param tbEquipTaskFile
     * @return
     */
    @RequestMapping("/getFileList")
    @ApiOperation(value = "获取设备附属文件资料")
    public AjaxObject getFileList(HttpServletRequest request,TbEquipTaskFile tbEquipTaskFile){
        logger.info("pc查询维修上传的附件列表参数TbEquipTaskFile={}", JSON.toJSONString(tbEquipTaskFile));
        getUserInfo(request);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipTaskFile> list =  equipService.getFileList(tbEquipTaskFile);
        return super.getResultObject(list, request.getParameter("page"));
    }


    /**
     * app端 获取设备详情
     * @param request,equipInfo
     * @return
     */
    @GetMapping("/getEquipDetailInfo")
    @ApiOperation(value = "获取设备台账、当前工单、台时")
    public AjaxObject getEquipDetailInfo(HttpServletRequest request,TbEquipInfo equipInfo,Integer plat){
        logger.info("app端获取设备详情TbEquipInfo={}", JSON.toJSONString(equipInfo));
        getUserInfo(request);
        TbUser user = super.getUser(request,stringRedisTemplate);
        TbEquipInfo tbEquipInfo =  equipService.getEquipDetailInfo(equipInfo);
        Map<String,Object> map = new HashMap<>(16);
        Date taskDate = DateUtils.getNextDate(new Date(),1);
        if(plat==null || plat.equals(2)){
            List<TbWorkTaskInfo> taskInfoList = equipOrderService.getMyTaskInfoList(tbEquipInfo.getFactoryNo(),user,1,null,taskDate,equipInfo.getEquipNo());
            map.put("taskInfoList",taskInfoList);
        }
        String equipRunTime = equipService.getEquipRunTime(equipInfo.getEquipNo());
        map.put("equipRunTime",equipRunTime);
        map.put("equipInfo",tbEquipInfo);
        return AjaxObject.ok(map);
    }
    /**
     * app端 根据水厂获取设备tree列表
     * @param request,equipInfo
     * @return
     */
    @GetMapping("/getAppEquipTree")
    public AjaxObject getAppEquipTree(HttpServletRequest request,TbEquipInfo equipInfo){
        logger.info("app端 获取设备tree列表参数TbEquipInfo={}", JSON.toJSONString(equipInfo));
        getUserInfo(request);
        Tree<TbSynObject> tree=  tbSynObjectService.findAppEquipTree(equipInfo);
        Map map = new HashMap(16);
        map.put("tree",tree);
        return AjaxObject.ok(map);
    }

    /**
     * 根据设备编号获取二维码
     * @param request,response,equipNos
     * @return
     */
    @GetMapping("/getEquipviewQR")
    @ApiOperation(value = "生成设备二维码")
    public void getEquipviewQR(HttpServletRequest request, HttpServletResponse response,String[] equipNos){
        logger.info("根据设备编号获取二维码参数equipNos={}", JSON.toJSONString(equipNos));
        List<TbEquipInfo> tbEquipInfoList =equipService.selectEquipBatchlist(equipNos);
        try {
            response.reset();
            String fileName = DateUtils.formateDate("yyyyMMddHHmmss") + ".jpg";
            response.setHeader("content-disposition","attachment;filename=" + fileName );
            createEquipQR(response.getOutputStream(),tbEquipInfoList,"设备二维码");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public  void createEquipQR(OutputStream outputStream, List<TbEquipInfo> tbEquipInfoList, String className)
            throws IOException {
        try {
            int rowCount = tbEquipInfoList.size()%3==0?tbEquipInfoList.size()/3:(tbEquipInfoList.size()/4 + 1);
            //获取图片
            int width = 1700;
            int height = rowCount*520 + 80;
            BufferedImage image = new BufferedImage(width,height ,BufferedImage.TYPE_INT_RGB);
            //根据xy点坐标绘制闭合多边形
            Graphics2D g2d = image.createGraphics();
            g2d.setBackground(Color.WHITE);
            g2d.clearRect(0, 0, width, height);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SimHei", Font.PLAIN, 30));
            int x  = 850 - className.length() * 15;
            g2d.drawString(className, x, 50);
            for(int i=0;i<tbEquipInfoList.size();i++) {
                TbEquipInfo student =tbEquipInfoList.get(i);
                int top = (i / 4 * 510) + 80;
                int left = (i % 4 * 410) + 2;
                g2d.drawRect(left , top, 400, 500);
                g2d.setFont(new Font("SimHei", Font.PLAIN, 20));
                String name = student.getEquipName();
                g2d.drawString(name,left + (200 - name.length() * 10), top + 40);
                CodeModel info = new CodeModel();
                info.setHeight(150);
                info.setWidth(150);
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("nodeId",student.getEquipNo());
                jsonObject.put("nodeType",1);
                info.setContents(jsonObject.toJSONString());
                logger.info("设备信息equip={},name={}",JSON.toJSONString(jsonObject),name);
                QR_Code code = new QR_Code();
                BufferedImage bufferedImage = code.dealLogoAndPic(info);
                g2d.drawImage((Image)bufferedImage, left + 2  , top + 50, 390, 390,null);
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
     * 新增/修改设备类型管理
     * @param request
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "新增/修改设备类型")
    public AjaxObject saveTbEquipType(HttpServletRequest request, TbEquipType tbEquipType){
        logger.info("新增/修改设备类型管理参数TbEquipType={}", JSON.toJSONString(tbEquipType));
        try {
            TbUser user = super.getUser(request,stringRedisTemplate);
            if(user!=null){
                tbEquipType.setCreateUser(user.getCode());
                tbEquipType.setCreateUserName(user.getName());
            }

            int flag= equipService.saveTbEquipType(tbEquipType);
            if(flag==1){
                if(tbEquipType.getId()!=null){
                    return AjaxObject.ok("修改设备类型管理成功");
                }else{
                    return AjaxObject.ok("新增设备类型管理成功");
                }
            }else{
                return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            logger.error("新增/修改设备类型管理管理失败e={}", e);
            return AjaxObject.error("新增/修改设备类型管理失败，请联系网站分类要素管理员！");
        }
    }
    /**
     * 查询设备类型管理列表
     * @param req,tbEquipType
     * @return
     */
    @GetMapping("/getTbEquipTypeList")
    @ApiOperation(value = "获取设备类型列表")
    public  List<TbEquipType> getTbEquipTypeList(HttpServletRequest req,TbEquipType tbEquipType){
        logger.info("查询设备类型管理列表参数TbEquipType={}", tbEquipType);
        TbUser user = super.getUser(req,stringRedisTemplate);
        List<TbEquipType> allTbEquipTypeList = new ArrayList<>();
        allTbEquipTypeList = getALlTbInspectionSortDict(tbEquipType);
        boolean flag= true;
        List<String> typeNoList = new ArrayList<>();
        if(tbEquipType.getTypeName()!=null || tbEquipType.getEquipTypeCode()!=null || tbEquipType.getStatus()!=null){
            flag =false;
            List<TbEquipType> tbEquipTypeList = equipService.selectTbEquipTypetList(tbEquipType);
            for (TbEquipType dict:tbEquipTypeList){
                typeNoList.add(dict.getId().toString());
            }
        }
        if(!flag){
            freshSortTree(allTbEquipTypeList,typeNoList);
        }
        return allTbEquipTypeList;
    }

    /**
     * 查询设备类型管理列表
     * @param request,tbEquipType
     * @return
     */
    @GetMapping("/getTbEquipTypeLists")
    public   AjaxObject getTbEquipTypeLists(HttpServletRequest request,TbEquipType tbEquipType){
        TbUser user = super.getUser(request,stringRedisTemplate);
        logger.info("查询设备类型管理列表TbEquipType={}", JSON.toJSONString(tbEquipType));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipType> tbDicts = equipService.selectTbEquipTypetLists(tbEquipType);
        return super.getResultObject(tbDicts, request.getParameter("page"));
    }
    /**
     * 设备类型启用或者停用
     * @param request,tbEquipType
     * @return
     */
    @PostMapping("/stopTbEquipType")
    @ApiOperation(value = "设备类型启用或者停用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "班组名称", required = true, dataType = "string", paramType = "query"),
    })
    public AjaxObject stopTbEquipType(HttpServletRequest request,Integer id){
        logger.info("设备类型启用或者停用id={}", id);
        TbUser user = super.getUser(request,stringRedisTemplate);
        if(equipService.stopTbEquipType(id)>0){
            return AjaxObject.ok("删除成功");
        }else{
            return AjaxObject.error("删除失败");
        }
    }
    public  List<TbEquipType> getALlTbInspectionSortDict(TbEquipType tbEquipType){
        TbEquipType tbQ = new TbEquipType();
        tbQ.setFactoryNo(tbEquipType.getFactoryNo());
        List<TbEquipType> tbTbEquipTypetList = equipService.selectTbEquipTypetList(tbQ);
        for (TbEquipType equipType : tbTbEquipTypetList) {
            if(equipType.getParentId()!=null){
                TbEquipType tb = equipService.getInfoById(equipType.getParentId());
                if(tb!=null){
                    equipType.setParentName(tb.getTypeName());
                }
            }
        }
        List<TbEquipType> topTbInspectionSortDictList = new ArrayList<>();
        Map<Integer,List<TbEquipType>> chileMap = new HashMap<>(16);
        for (TbEquipType dict : tbTbEquipTypetList) {
            if(dict.getParentId() == null || dict.getParentId() == 0){
                // 插入父菜单
                topTbInspectionSortDictList.add(dict);
            }else {
                // 如果当前没有对应的父菜单被插入
                if(!chileMap.containsKey(dict.getParentId())){
                    List<TbEquipType> list =new ArrayList<>();
                    chileMap.put(dict.getParentId(),list);
                }
                chileMap.get(dict.getParentId()).add(dict);
            }
        }
        for (TbEquipType dict:tbTbEquipTypetList){
            dict.setChildren(chileMap.get(dict.getId()));
        }

        return topTbInspectionSortDictList;
    }
    private void freshSortTree( List<TbEquipType>  list, List<String> typeNoList){
        for (int i = list.size() - 1; i >= 0; i --) {
            TbEquipType tbEquipType = list.get(i);
            if (tbEquipType.getChildren() != null && tbEquipType.getChildren().size() > 0){
                freshSortTree(tbEquipType.getChildren(),typeNoList);
                boolean flag = tbEquipType.getChildren() == null || tbEquipType.getChildren().size() == 0;
                if (flag && !typeNoList.contains(tbEquipType.getId().toString())){
                    list.remove(tbEquipType);
                }
            } else {
                if (!typeNoList.contains(tbEquipType.getId().toString())) {
                    list.remove(tbEquipType);
                }
            }
        }
    }

    @GetMapping("/equipTypelist")
    public AjaxObject getEquipTypeList(TbEquipType tbEquipType){
        super.setPageInfo(null,null);
        List<TbEquipType> list =  equipService.selectTbEquipTypetList(tbEquipType);
        return super.getResultObject(list, null);
    }

    // 获取巡检要素**************************************************************************
    /**
     * 获取巡检要素树结构
     * @param req
     * @return
     */
    @RequestMapping(value = "/getTbParamAllTree",method = RequestMethod.GET)
    public AjaxObject getTbParamAllTree(HttpServletRequest req){
        logger.info("获取巡检要素树结构",req);
        Tree<TbEquipType> tree=  equipService.findTbEquipTypeAllTree();
        Map map =new HashMap(16);
        map.put("tree",tree);
        return AjaxObject.ok(map);
    }


    /**
     * 下载模板 设备导入模块
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/downloadModel",method = RequestMethod.GET)
    @ApiOperation(value = "下载设备导入模板")
    public void downloadModel(HttpServletRequest request,  HttpServletResponse response) throws  Exception{
        List<TbDict> tbDicts =getDictList();
        //获取设备类型
        List<TbEquipType> equipTypeList = getTbEquipTypeList();
        Map map = new HashMap(16);
        map.put("tbDicts",tbDicts);
        map.put("equipTypeList",equipTypeList);
        map.put("type",2);
        map.put("fileName","设备模板.xlsx");
        logger.info("下载模板 设备导入模块equipTypeList={}", JSON.toJSONString(equipTypeList));
        if((tbDicts==null && tbDicts.size()==0)|| (equipTypeList==null && equipTypeList.size()==0)){
            String info="字典/设备类型数据为空";
            errorInfo(response,info);
        }else {
            ExcelHighUtils.writeExcelX(response,null, TbEquipInfoVo.class,map);
        }
        logger.info("下载模板 设备导入模块ok");
    }
   
    /**
     * 获取设备安装地点 导入相关下拉框数据
     * @return
     */
    public List<TbDict> getDictList(){
        List<Integer> parentList = new ArrayList<>();
        //9,141
        parentList.add(9);
        parentList.add(141);
        parentList.add(148);
        List<TbDict> tbDicts = tbDictService.getDictByParent(parentList);
        return  tbDicts;
    }

    /**
     * 获取设备类型 导入相关下拉框数据
     * @return
     */
    public List<TbEquipType> getTbEquipTypeList(){
        TbEquipTypeExample example = new TbEquipTypeExample();
        TbEquipTypeExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdNotEqualTo(0);
        example.setOrderByClause("id");
        return  tbEquipTypeMapper.selectByExample(example);
    }

    /**
     * 批量导入设备信息
     * @param request,file
     * @return
     */
    @RequestMapping(value = "/importEquip",method = RequestMethod.POST)
    @ApiOperation(value = "通过Excel导入设备台账")
    public AjaxObject importEquip(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo){
        AjaxObject ajaxObject = new AjaxObject();
        List<TbEquipInfoVo> list = ExcelUtils.readExcel("", TbEquipInfoVo.class, file);
        if(list!=null && list.size()>0) {
            logger.info("批量导入设备信息list={}", JSON.toJSONString(list));
            TbUser user = super.getUser(request, stringRedisTemplate);
            List<TbDict> tbDicts = getDictList();
            List<TbEquipType> tbEquipTypeList = getTbEquipTypeList();
            list.forEach(o -> {
                o.setUpdateTime(new Date());
                o.setUpdateUser(user.getName());
            });
            try {
                int i = equipService.saveImportEquipInfo(list, factoryNo, tbDicts, tbEquipTypeList);
                if (i >= 1) {
                    ajaxObject = AjaxObject.ok("导入成功");
                } else {
                    ajaxObject =  AjaxObject.getAjaxStatus(Dict.getAjaxStatus(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
                ajaxObject = AjaxObject.error("导入失败");
            }
        }else {
            ajaxObject = AjaxObject.error("数据空,导入失败");
        }
        return  ajaxObject;
    }

    /**
     *  导出设备
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    @ApiOperation(value = "导出设备台账Excel")
    public void export(HttpServletRequest request,  HttpServletResponse response,String factoryNo,String equipMainType,String equipName){
        TbEquipInfo tbEquipInfo = new TbEquipInfo();
        tbEquipInfo.setFactoryNo(factoryNo);
        if(!"".equals(equipMainType)){
            tbEquipInfo.setEquipMainType(equipMainType);
        }
        if(!"".equals(equipName)){
            tbEquipInfo.setEquipName(equipName);
        }
        List<TbDict> tbDicts =getDictList();
        //获取设备类型
        List<TbEquipType> equipTypeList = getTbEquipTypeList();
        tbEquipInfo.setTbDicts(tbDicts);
        tbEquipInfo.setEquipTypeList(equipTypeList);
        List<TbEquipInfo> tbEquipInfos = equipService.getEquipList(tbEquipInfo);
        List<TbEquipInfoVo> tbEquipInfoVoList = new ArrayList<>();
        for (TbEquipInfo equipInfo : tbEquipInfos) {
            TbEquipInfoVo tbEquipInfoVo = new TbEquipInfoVo();
            equipInfo.setEquipNameS(equipInfo.getEquipName()+","+equipInfo.getEquipNo());
            BeanUtils.copyProperties(equipInfo,tbEquipInfoVo);
            tbEquipInfoVoList.add(tbEquipInfoVo);

        }
        Map map = new HashMap(16);
        map.put("type",0);
        map.put("fileName","导出设备数据.xlsx");
        ExcelHighUtils.writeExcelX(response,tbEquipInfoVoList, TbEquipInfoVo.class,map);
    }

    /**
     * 获取设备和设施列表
     * @param factoryNo
     * @return
     */
    @GetMapping("/getAntiEquipList")
    public AjaxObject getAntiEquipList(String factoryNo){
        List<Map<String,String>> list = new ArrayList<>();
        TbEquipInfo equipInfoSearch = new TbEquipInfo();
        equipInfoSearch.setFactoryNo(factoryNo);
        List<TbEquipInfo> equipInfoList = equipService.getEquipList(equipInfoSearch);
        for(TbEquipInfo equipInfo:equipInfoList){
            Map<String,String> map = new HashMap<>();
            map.put("text", equipInfo.getEquipName());
            map.put("value", equipInfo.getEquipNo());
            list.add(map);
        }
        TbFacilityInfo facilityInfoSearch = new TbFacilityInfo();
        facilityInfoSearch.setFatiFactoryNo(factoryNo);
        List<TbFacilityInfo> factoryInfoList = facilityService.getFacilityList(facilityInfoSearch);
        for(TbFacilityInfo facilityInfo:factoryInfoList){
            Map<String,String> map = new HashMap<>();
            map.put("text", facilityInfo.getFatiName());
            map.put("value", facilityInfo.getFatiNo());
            list.add(map);
        }
        return super.getResultObject(list,null);
    }
    /**
     *
     * 下载模板出错
     */
    public void  errorInfo( HttpServletResponse response,String info) throws Exception{
        response.reset();
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        os.write(info.getBytes("UTF-8"));
        os.close();
    }

    /**
     * 查询绑定nfc设备/巡检点列表
     * @param req,tbEquipInfo
     * @return
     */
    @GetMapping("/getEquipNFCList")
    @ApiOperation(value = "获取绑定的NFC卡列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeName", value = "设备/巡检点名称",  dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeNo", value = "nfc卡号", dataType = "string", paramType = "query")
    })
    public AjaxObject getEquipNFCList(HttpServletRequest req, TbNfcInfo tbNfcInfo){
        logger.info("查询绑定nfc设备/巡检点列表参数TbTbNfcInfo={}", JSON.toJSONString(tbNfcInfo));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbNfcInfo> tbEquipInfos = equipService.getEquipNFCList(tbNfcInfo);
        return super.getResultObject(tbEquipInfos,req.getParameter("page"));
    }
    /**
     * 新增/修改绑定nfc设备/巡检点
     * @param request,tbNfcInfo
     * @return
     */
    @PostMapping("/saveEquipNFC")
    @ApiOperation(value = "绑定NFC卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeName", value = "设备/巡检点名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeNo", value = "nfc卡号",required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeType", value = "类型(1:设备 2:巡检点)", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject saveEquipNFC(HttpServletRequest request, TbNfcInfo tbNfcInfo){
        logger.info("新增/修改绑定nfc设备/巡检点参数TbTbNfcInfo={}", JSON.toJSONString(tbNfcInfo));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =equipService.saveEquipNFC(tbNfcInfo);
            if(flag==1){
                ajaxObject = AjaxObject.ok("新增/修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增/修改失败e={}", e);
            ajaxObject = AjaxObject.error("新增/修改失败，请联系管理员！");
        }
        return  ajaxObject;
    }


    /**
     * 根据类型查询设备或者巡检点
     * @param req,tbNfcInfo
     * @return
     */
    @GetMapping("/getSheOrXunList")
    @ApiOperation(value = "查询NFC绑定的设备或巡检点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeType", value = "类型(1:设备 2:巡检)",  required = true,dataType = "string", paramType = "query")
    })
    public AjaxObject getSheOrXunList(HttpServletRequest req,TbNfcInfo tbNfcInfo){
        logger.info("根据类型查询设备或者巡检点参数TbTbNfcInfo={}", JSON.toJSONString(tbNfcInfo));
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<Map<String,String>> tbEquipInfos = equipService.getSheOrXunList(tbNfcInfo);
        return super.getResultObject(tbEquipInfos,req.getParameter("page"));
    }

    /**
     * 解绑绑定nfc设备/巡检点
     * @param request,tbNfcInfo
     * @return
     */
    @PostMapping("/stopEquipNFC")
    @ApiOperation(value = "解绑NFC卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nfcNo", value = "nfcNo", required = true, dataType = "string", paramType = "query"),
    })
    public AjaxObject stopEquipNFC(HttpServletRequest request, TbNfcInfo tbNfcInfo){
        logger.info("解绑绑定nfc设备/巡检点参数TbTbNfcInfo={}", JSON.toJSONString(tbNfcInfo));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =equipService.stopEquipNFC(tbNfcInfo);
            if(flag==1){
                ajaxObject = AjaxObject.ok("解绑成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("解绑失败e={}", e);
            ajaxObject = AjaxObject.error("解绑失败，请联系管理员！");
        }
        return  ajaxObject;
    }

    /**
     * 修改绑定nfc设备/巡检点
     * @param request,tbNfcInfo
     * @return
     */
    @PostMapping("/updateEquipNFC")
    @ApiOperation(value = "更新NFC绑定信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeName", value = "设备/巡检点名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeNo", value = "nfc卡号",required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "nodeType", value = "类型(1:设备 2:巡检点)", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject updateEquipNFC(HttpServletRequest request, TbNfcInfo tbNfcInfo){
        logger.info("新增/修改绑定nfc设备/巡检点参数TbTbNfcInfo={}", JSON.toJSONString(tbNfcInfo));
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request,stringRedisTemplate);
        try {
            int flag =equipService.updateEquipNFC(tbNfcInfo);
            if(flag==1){
                ajaxObject = AjaxObject.ok("修改成功");
            }else{
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改失败e={}", e);
            ajaxObject = AjaxObject.error("修改失败，请联系管理员！");
        }
        return  ajaxObject;
    }


}

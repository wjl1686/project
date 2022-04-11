package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.TbFactoryInfoVo;
import com.ejobim.opplat.mapper.TbFactoryVideoMapper;
import com.ejobim.opplat.rest.HollySys;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wujianlong
 * @Description: 水厂
 * @date 2019/1/15 18:16
 */
@Api(tags = "水厂管理")
@RestController
@RequestMapping("/factory")
public class FactoryController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbFactoryService tbFactoryService;
    @Autowired
    TbEquipInfoService tbEquipInfoService;
    @Autowired
    private Environment env;
    @Autowired
    private TbSynObjectService tbSynObjectService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private TbOrgService tbOrgService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private TbDictService tbDictService;
    @Autowired
    HollySys hollySys;
    
    @Autowired
    private TbFactoryVideoMapper tbFactoryVideoMapper;

    /**
     * 查询所有水厂
     *
     * @return
     */
    @GetMapping("/getFactoryList")
    @ApiOperation(value = "获取水厂列表")
    public AjaxObject getFactoryList(HttpServletRequest req, TbFactoryInfo tbFactoryInfo) {
        logger.info("查询所有水厂入参TbFactoryInfo={}", JSON.toJSONString(tbFactoryInfo));
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            super.setPageInfo(req.getParameter("page"), req.getParameter("rows"));
            List<TbFactoryInfo> factoryInfos = tbFactoryService.getTbFactoryInfoList(tbFactoryInfo);
            return super.getResultObject(factoryInfos, req.getParameter("page"));
        } else {
            List<TbFactoryInfo> factoryInfos = tbFactoryService.getTbFactoryInfoList(tbFactoryInfo);
            Map<String, Object> objectMap = new HashMap<>(16);
            objectMap.put("factoryInfo", factoryInfos);
            return AjaxObject.ok(objectMap);
        }
    }

    /**
     * 获取水厂基本信息
     *
     * @return
     */
    @GetMapping("/getFactoryInfo")
    @ApiOperation(value = "获取水厂详细信息")
    public AjaxObject getFactoryInfo(HttpServletRequest request) {
        String factoryNo = request.getParameter("factoryNo");
        TbFactoryInfo tbFactoryInfo = tbFactoryService.getFactoryInfoByNo(factoryNo);
        Map<String, Object> objectMap = new HashMap<>(16);

        List<TbFactoryInfo> children = tbFactoryService.getChildrenFactory(factoryNo);
        if(children!=null && children.size()>0){
            objectMap.put("children", children);
        }


        TbFactoryVideo tbFactoryVideo = tbFactoryVideoMapper.selectByPrimaryKey(factoryNo);
        TbUser tbUser = this.getUser(request, stringRedisTemplate);
        objectMap.put("factoryInfo", tbFactoryInfo);
        if(tbFactoryVideo!=null){
            objectMap.put("unitId", tbFactoryVideo.getVideoId());
        }
        objectMap.put("tbUser", tbUser);
        return AjaxObject.ok(objectMap);

    }


    /**
     * 获取水厂unitId
     * @return
     */
    @GetMapping("/getFactoryUnitId")
    @ApiOperation(value = "获取配置的水厂在视频监控平台的unitId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getFactoryUnitId(HttpServletRequest request,String factoryNo) {
        logger.info("获取水厂unitId入参水厂no={}", factoryNo);
        TbFactoryVideo tbFactoryVideo = tbFactoryVideoMapper.selectByPrimaryKey(factoryNo);
        logger.info("获取水厂unitId结果tbFactoryVideo={}", JSON.toJSONString(tbFactoryVideo));
        TbUser tbUser = this.getUser(request, stringRedisTemplate);
        Map<String, Object> objectMap = new HashMap<>(16);
        if(tbFactoryVideo!=null){
            objectMap.put("unitId", tbFactoryVideo.getVideoId());
        }else {
            objectMap.put("unitId", null);
        }
        return AjaxObject.ok(objectMap);
    }
    /**
     * 获取水厂基本信息
     *
     * @return
     */
    @GetMapping("/getFactoryInfoNew")
    @ApiOperation(value = "获取水厂详细信息")
    public AjaxObject getFactoryInfoNew(HttpServletRequest request) {
        String factoryNo = request.getParameter("factoryNo");
        List<TbFactoryInfo> tbFactoryInfoListRe = new ArrayList<>();
        List<TbFactoryInfo> tbFactoryInfoList = tbFactoryService.getFactoryInfoByNoNew(factoryNo);
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        if(tbFactoryInfoList!=null && tbFactoryInfoList.size()==1){
            tbFactoryInfoListRe=tbFactoryInfoList;
        }else if(tbFactoryInfoList!=null && tbFactoryInfoList.size()==2){
            tbFactoryInfoListRe.add(tbFactoryInfoList.get(1));
        }else {
            tbFactoryInfoListRe = tbFactoryInfoList.stream().filter(tbFactoryInfo1 -> tbFactoryInfo1.getIssueNo()!=0).collect(Collectors.toList());
        }
        TbUser tbUser = this.getUser(request, stringRedisTemplate);
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("factoryInfo", tbFactoryInfoListRe);
        objectMap.put("tbUser", tbUser);
        return AjaxObject.ok(objectMap);

    }


    /**
     * 新增水厂
     *
     * @param tbFactoryInfo
     * @return
     */
    @RequestMapping(value = "/addFactory", method = RequestMethod.GET)
    public String addFactory(TbFactoryInfo tbFactoryInfo) {
        tbFactoryInfo.setFactoryNo(StringTools.getUUID());
        return tbFactoryService.addFactory(tbFactoryInfo) + "";
    }


    /**
     * 修改水厂基本信息
     *
     * @param tbFactoryInfo
     * @return
     */
    @ApiOperation(value = "更新水厂信息")
    @PostMapping("/updateFactory")
    public AjaxObject updateFactory(TbFactoryInfo tbFactoryInfo, TbFactoryWater tbFactoryWater, TbFactoryDehydrationSystem tbFactoryDehydrationSystem) {
        if (tbFactoryService.updateFactory(tbFactoryInfo) >= 0
                && tbFactoryService.updateFactoryInOutWater(tbFactoryWater) >= 0
                && tbFactoryService.updatefactoryDry(tbFactoryDehydrationSystem) >= 0) {
            return AjaxObject.ok("更新水厂信息成功");
        } else {
            return AjaxObject.error("更新失败");

        }
    }


    /**
     * 修改水厂基本信息
     *
     * @param tbFactoryInfo
     * @return
     */
    @PostMapping("/updateFactoryOwn")
    public AjaxObject updateFactoryOwn(TbFactoryInfo tbFactoryInfo) {
        if (tbFactoryService.updateFactory(tbFactoryInfo) >= 0) {
            return AjaxObject.ok("更新水厂信息成功");
        } else {
            return AjaxObject.error("更新失败");

        }
    }

    /**
     * 更新水厂列表
     *
     * @param request
     * @return
     */
    @PostMapping("/syncFactoryList")
    @ApiOperation(value = "从水厂平台同步水厂列表")
    public AjaxObject syncFactoryList(HttpServletRequest request) {
        hollySys.getFactoryList();
        return AjaxObject.ok("");
    }

    @PostMapping("/syncFactoryModel")
    public AjaxObject syncFactoryModel(HttpServletRequest request,String uri) {
//        List<TbFactoryInfo> factoryInfoList = tbFactoryService.getTbFactoryInfoList(new TbFactoryInfo());
//        for (int i = 0; i < factoryInfoList.size(); i++) {
//            TbFactoryInfo factoryInfo = factoryInfoList.get(i);
//            if(StringUtils.isEmpty(factoryInfo.getParentFactoryNo())){
//                hollySys.getFactoryTree(factoryInfo.getUri(), factoryInfo.getFactoryNo(), 1);
//                logger.info("更新水厂模型{},{}", factoryInfo.getFactoryNo(), factoryInfo.getFactoryName());
//            }
//
//        }
//        hollySys.getFactoryList();
        if(StringUtils.isNotEmpty(uri)){
            String factoryNo = uri.split("/")[2];
            hollySys.getFactoryTree(uri, factoryNo, 1);
        }

        return AjaxObject.ok("");
    }


    @RequestMapping(value = "/updateFactoryMap", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "上传水厂平面图")
    public AjaxObject updateFactoryMap(HttpServletRequest req, @RequestBody TbFactoryInfo tbFactoryInfo) {
        logger.info("添加上传水厂平面图成功参数TbFactoryInfo={}", JSON.toJSONString(tbFactoryInfo));
        if (tbFactoryService.updateFactory(tbFactoryInfo) >= 0) {
            return AjaxObject.ok("上传水厂平面图成功");
        } else {
            return AjaxObject.error("更新失败");
        }
    }

    /**
     * 修改水厂进出水水质信息
     *
     * @param tbFactoryWater
     * @return
     */
    @PostMapping("/updateFactoryInOutWater")
    public AjaxObject updateFactoryInOutWater(TbFactoryWater tbFactoryWater) {
        if (tbFactoryService.updateFactoryInOutWater(tbFactoryWater) >= 0) {
            return AjaxObject.ok("更新水厂信息成功");
        } else {
            return AjaxObject.error("更新失败");

        }
    }

    /**
     * 修改水厂脱水信息
     *
     * @param tbFactoryDehydrationSystem
     * @return
     */
    @PostMapping("/updatefactoryDry")
    public AjaxObject updatefactoryDry(TbFactoryDehydrationSystem tbFactoryDehydrationSystem) {
        if (tbFactoryService.updatefactoryDry(tbFactoryDehydrationSystem) >= 0) {
            return AjaxObject.ok("更新水厂信息成功");
        } else {
            return AjaxObject.error("更新失败");

        }
    }

    /**
     * 通过tree和获取相应的字段
     *
     * @param uri
     * @return
     */
    @RequestMapping(value = "/getFieldList", method = RequestMethod.GET)
    @ApiOperation(value = "获取水厂在数采平台的模型信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "uri", value = "测点URI", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂NO", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getFieldList(String uri, String factoryNo) {
        Map map = new HashMap(16);
        if (StringUtils.isNotBlank(uri)) {
            List<TbSynObject> tbObjectDataList = tbSynObjectService.getChildUriList(uri, 4);

            map.put("rows", tbObjectDataList);
            map.put("total", tbObjectDataList.size());
            return AjaxObject.ok(map);

        } else {
            map.put("rows", new ArrayList<String>());
            map.put("total", 0);
            return AjaxObject.ok(map);
        }

    }

    /**
     * 填报形成tree
     *
     * @param req ,factoryNo
     * @return
     */
    @RequestMapping(value = "/getTree", method = RequestMethod.GET)
    public AjaxObject findTreeLists(HttpServletRequest req, String factoryNo, String fillTaskNo) {

        logger.info("添加参数factoryNo={}", factoryNo);

        int type = req.getParameter("type") == null ? 1 : Integer.valueOf(req.getParameter("type"));
        Integer fieldType = req.getParameter("fieldType") == null ? null : Integer.valueOf(req.getParameter("fieldType"));
        Integer hasValue = req.getParameter("hasValue") == null ? null : Integer.valueOf(req.getParameter("hasValue"));
        Tree<TbSynObject> tree = tbSynObjectService.findTreeLists(factoryNo, 1, fieldType, null);

        List<TbFillFormDetail> tbFillFormDetailList = workOrderService.findFillTaskDetailList(fillTaskNo, null);
        List<String> idList = new ArrayList<>();
        for (TbFillFormDetail tbFillFormDetail : tbFillFormDetailList) {
            idList.add(tbFillFormDetail.getEquipNo());
        }
        TreeUtils.freshSynDataParent(tree.getChildren(), idList);
        Map map = new HashMap(16);
        map.put("tree", tree);
        return AjaxObject.ok(map);
    }

    /**
     * 获取填报类树结构
     *
     * @param req ,factoryNo
     * @return
     */
    @RequestMapping(value = "/getFillFormAllTree", method = RequestMethod.GET)
    public AjaxObject getFillFormAllTree(HttpServletRequest req, String factoryNo) {
        logger.info("添加参数factoryNo={}", factoryNo);
        Integer fieldType = req.getParameter("fieldType") == null ? null : Integer.valueOf(req.getParameter("fieldType"));
        //哪个方法需要返回
        String methodName = req.getParameter("methodName");
        Tree<TbSynObject> tree = tbSynObjectService.findTreeLists(factoryNo, 1, fieldType, null);
        Map map = new HashMap(16);
        map.put("tree", tree);
        return AjaxObject.ok(map);
    }

    /**
     * 获取实时填报树
     *
     * @param req
     * @param factoryNo
     * @return
     */
    @RequestMapping(value = "/getFactoryRunTimeTree", method = RequestMethod.GET)
    public AjaxObject getFactoryRunTimeTree(HttpServletRequest req, String factoryNo) {
        logger.info("添加参数factoryNo={}", factoryNo);
        Integer hasValue = req.getParameter("hasValue") == null ? null : Integer.valueOf(req.getParameter("hasValue"));
        Tree<TbSynObject> tree = tbSynObjectService.findTreeLists(factoryNo, 0, 2, hasValue);
        Map<String, Object> map = new HashMap(16);
        map.put("tree", tree);
        List<TbRealTimeConfig> tbRealTimeConfigList = this.tbFactoryService.fineTbRealTimeConfigList(factoryNo);
        map.put("tbRealTimeConfigList", tbRealTimeConfigList);
        return AjaxObject.ok(map);
    }

    /**
     * 查询药剂字典
     *
     * @param req,param
     * @return
     */
    @GetMapping("/getParamList")
    public AjaxObject getParamList(HttpServletRequest req, TbParam param) {
        logger.info("查询字典param列表参数TbParam={}", param);
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            int pageNum = Integer.valueOf(req.getParameter("page"));
            int pageSize = Integer.valueOf(req.getParameter("rows"));
            PageHelper.startPage(pageNum, pageSize);
            List<TbParam> tbMedicineList = tbFactoryService.getParamList(param);
            PageInfo pageInfo = new PageInfo(tbMedicineList);
            map.put("rows", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
        } else {
            List<TbParam> tbMedicineList = tbFactoryService.getParamList(param);
            PageInfo pageInfo = new PageInfo(tbMedicineList);
            map.put("rows", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
        }
        return AjaxObject.ok(map);
    }

    /**
     * 通过tree和获取相应的字段
     *
     * @param req ,param
     * @return
     */
    @RequestMapping(value = "/getSelectFieldList", method = RequestMethod.GET)
    public AjaxObject getSelectParamLists(HttpServletRequest req, TbFillFormField tbFillFormField) {
        Map map = new HashMap(16);
        List<TbFillFormField> tbFillFormTasks = new ArrayList<>();
        String uri = req.getParameter("uri");
        if (StringUtils.isNotBlank(uri)) {
            String factoryNo = req.getParameter("factoryNo");
            String fieldCode = StringUtils.isEmpty(req.getParameter("fieldCode")) ? null : req.getParameter("fieldCode");
            String fieldName = StringUtils.isEmpty(req.getParameter("fieldName")) ? null : req.getParameter("fieldName");

            Integer fieldType = req.getParameter("fieldType") == null ? null : Integer.parseInt(req.getParameter("fieldType"));
            if (StringUtils.isNotBlank(req.getParameter("page"))) {
                int pageNum = Integer.valueOf(req.getParameter("page"));
                int pageSize = Integer.valueOf(req.getParameter("rows"));
                PageHelper.startPage(pageNum, pageSize);
                logger.info("添加参数param={}", uri);
                tbFillFormTasks = tbSynObjectService.getSelectFieldList(uri, fieldType, fieldCode, fieldName);
                PageInfo pageInfo = new PageInfo(tbFillFormTasks);
                map.put("rows", pageInfo.getList());
                map.put("total", pageInfo.getTotal());
                return AjaxObject.ok(map);
            } else {
                tbFillFormTasks = tbSynObjectService.getSelectFieldList(uri, fieldType, fieldCode, fieldName);
                map.put("rows", tbFillFormTasks);
                map.put("total", tbFillFormTasks.size());
                return AjaxObject.ok(map);
            }
        } else {
            map.put("rows", new ArrayList<String>());
            map.put("total", 0);
            return AjaxObject.ok(map);
        }
    }


    @RequestMapping(value = "/getEquipList", method = RequestMethod.POST)
    public AjaxObject getEquipList(TbEquipInfo tbEquipInfo) {
        List<TbEquipInfo> list = tbEquipInfoService.getTbEquipInfoList(tbEquipInfo);
        Map<String, Object> map = new HashMap<>(16);
        map.put("equipList", list);
        return AjaxObject.ok(map);
    }

    /**
     * 新建填报字段
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveTbFillFormField", method = RequestMethod.POST)
    public AjaxObject saveTbFillFormField(HttpServletRequest request) {
        String uris = request.getParameter("uris");
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            List<String> uriList = Arrays.asList(uris.split(","));
            List<TbSynObject> tbSynObjectList = tbSynObjectService.getTbSynObjectList(uriList);
            List<TbFillFormField> tbFillFormFields = new ArrayList<>();
            for (TbSynObject tbSynObject : tbSynObjectList) {
                TbFillFormField tbFillFormField = new TbFillFormField();
                tbFillFormField.setCreatePerson(user.getCode());
                tbFillFormField.setConfigStatus(0);
                tbFillFormField.setCreateTime(new Date());
                tbFillFormField.setBrowsePath(tbSynObject.getBrowsepath());
                tbFillFormField.setConfigNo(tbSynObject.getUri());
                tbFillFormField.setConfigInfo("");
                tbFillFormField.setFactoryNo(tbSynObject.getFactoryNo());
                tbFillFormField.setFieldCode(tbSynObject.getBrowsename());
                tbFillFormField.setFieldName(tbSynObject.getDisplayname());
                tbFillFormField.setFieldType(tbSynObject.getFieldType());
                tbFillFormField.setFillType(tbSynObject.getFieldType());
                tbFillFormField.setFieldUnit(tbSynObject.getAccesslevel());
                tbFillFormField.setSedName(tbSynObject.getDisplayname());
                tbFillFormField.setEquipNo(tbSynObject.getParentUri());
                tbFillFormFields.add(tbFillFormField);
            }
            tbFactoryService.saveTbFillFormField(tbFillFormFields);
            return AjaxObject.ok();
        } catch (Exception ex) {
            return AjaxObject.getAjaxStatus(Dict.AjaxStatus.RECOMMITE);
        }
    }

    @RequestMapping(value = "/updateTbFillFormField", method = RequestMethod.POST)
    public AjaxObject updateTbFillFormField(TbFillFormField tbFillFormField) {
        try {
            tbFactoryService.updateTbFillFormField(tbFillFormField);
            return AjaxObject.ok();
        } catch (Exception ex) {
        }
        return AjaxObject.error("删除失败");
    }

    @RequestMapping(value = "/deleteTbFillFormField", method = RequestMethod.POST)
    public AjaxObject deleteTbFillFormField(HttpServletRequest request) {
        try {
            String uris = request.getParameter("uris");
            List<String> uriList = Arrays.asList(uris.split(","));
            for (String key : uriList) {
                //删除配置表和配置周期表
                tbFactoryService.deleteTbFillFormField(key);
            }
            return AjaxObject.ok();
        } catch (Exception ex) {
        }
        return AjaxObject.error("删除失败");
    }

    @RequestMapping(value = "/getFieldStaticInfo", method = RequestMethod.GET)
    public AjaxObject getFieldStaticInfo(String factoryNo) {
        int selectCount = tbFactoryService.getTbFillFormFieldCount(factoryNo, null);
        int allCount = tbSynObjectService.getTbSynObjectCount(factoryNo, null);
        Map<String, Object> map = new HashMap<>(16);
        map.put("allCount", allCount);
        map.put("selectCount", selectCount);
        return AjaxObject.ok(map);
    }

    /**
     * 增加字段
     *
     * @param tbFillFormField
     * @return
     */
    @RequestMapping(value = "/saveSEDTbFillFormField", method = RequestMethod.POST)
    public AjaxObject saveSEDTbFillFormField(TbFillFormField tbFillFormField) {
        if (StringUtils.isEmpty(tbFillFormField.getConfigNo())) {
            tbFillFormField.setCreateTime(new Date());
            tbFillFormField.setConfigNo(StringTools.getUUID());
            tbFillFormField.setConfigStatus(1);
            tbFillFormField.setFieldType(tbFillFormField.getFillType());
            String[] strs = tbFillFormField.getEquipNo().split(",");
            tbFillFormField.setEquipNo(strs[strs.length - 1]);
            List<TbObjectData> list = new ArrayList<>();
            for (int i = 1; i < strs.length; i++) {
                TbObjectData tbObjectData = new TbObjectData();
                tbObjectData.setFactoryNo(tbFillFormField.getFactoryNo());
                tbObjectData.setCreateTime(new Date());
                tbObjectData.setDataUri(tbFillFormField.getConfigNo());
                tbObjectData.setObjectUri(strs[i]);
                tbObjectData.setObjectType(4);
                tbObjectData.setDataFrom(1);
                list.add(tbObjectData);
            }
            tbSynObjectService.insertTbObjectDataList(list);
            tbFactoryService.addTbFillFormField(tbFillFormField);
            return AjaxObject.ok("添加字段成功");
        } else {
            tbFillFormField.setFieldType(tbFillFormField.getFillType());
            tbFactoryService.updateTbFillFormField(tbFillFormField);
            return AjaxObject.ok("编辑字段成功");
        }
    }

    /**
     * 配置项添加配置周期
     *
     * @param req ,tbFillFormFieldExtend
     * @return
     */
    @RequestMapping(value = "/saveTbFillFormFieldExtend", method = RequestMethod.POST)
    public AjaxObject saveTbFillFormFieldExtend(HttpServletRequest req, TbFillFormFieldExtend tbFillFormFieldExtend, String[] monthDate, String[] vaildTime, String[] tbVaildTime) {
        logger.info("添加参数tbFillFormFieldExtend={}", JSON.toJSON(tbFillFormFieldExtend));
        try {
            String[] inputValue = tbVaildTime;
            if (tbFillFormFieldExtend.getType() == 3) {
                inputValue = monthDate;
            } else if (tbFillFormFieldExtend.getType() == 4) {
                inputValue = vaildTime;
            }
            this.tbFactoryService.saveTbFillFormFieldExtend(tbFillFormFieldExtend, inputValue);
        } catch (Exception e) {
            return AjaxObject.error(e.getMessage());
        }
        return AjaxObject.ok();
    }


    /**
     * 人工配置项列表
     *
     * @param tbFillFormField
     * @return
     */
    @GetMapping("/getTbFillFormFieldList")
    public AjaxObject getTbFillFormFieldList(HttpServletRequest request, TbFillFormField tbFillFormField) {
        //tb_fill_form_field
        logger.info("查询字典param列表参数TbFillFormField={}", tbFillFormField);
        Map map = new HashMap(16);
        if (StringUtils.isNotEmpty(tbFillFormField.getConfigNo())) {
            if (StringUtils.isNotBlank(request.getParameter("page"))) {
                int pageNum = Integer.valueOf(request.getParameter("page"));
                int pageSize = Integer.valueOf(request.getParameter("rows"));
                PageHelper.startPage(pageNum, pageSize);
                List<TbFillFormField> tbFillFormTasks = tbSynObjectService.getFieldListExtend(tbFillFormField);
                PageInfo pageInfo = new PageInfo(tbFillFormTasks);
                map.put("rows", pageInfo.getList());
                map.put("total", pageInfo.getTotal());
                return AjaxObject.ok(map);
            } else {
                List<TbFillFormField> tbObjectDataList = tbSynObjectService.getFieldListExtend(tbFillFormField);
                map.put("rows", tbObjectDataList);
                map.put("total", tbObjectDataList.size());
                return AjaxObject.ok(map);
            }
        } else {
            map.put("rows", new ArrayList<String>());
            map.put("total", 0);
            return AjaxObject.ok(map);
        }

    }


    @PostMapping("/saveRealTimeConfig")
    public AjaxObject saveRealTimeConfig(HttpServletRequest request) {
        String factoryNo = request.getParameter("no");
        String ids = request.getParameter("ids");
        String parents = request.getParameter("parentList");
        String[] isList = ids.split(",");
        String[] parentList = parents.split(",");
        List<TbRealTimeConfig> tbRealTimeConfigList = new ArrayList<>();
        for (int i = 0; i < isList.length; i++) {
            if(StringUtils.isNotEmpty(isList[i])){
                TbRealTimeConfig tbRealTimeConfig = new TbRealTimeConfig();
                tbRealTimeConfig.setAccesslevel("");
                tbRealTimeConfig.setFactoryNo(factoryNo);
                tbRealTimeConfig.setBrowsepath("");
                tbRealTimeConfig.setDisplayname("");
                tbRealTimeConfig.setParenturi(parentList[i]);
                tbRealTimeConfig.setUri(isList[i]);
                tbRealTimeConfigList.add(tbRealTimeConfig);
            }

        }
        tbFactoryService.saveRealTimeConfig(tbRealTimeConfigList,factoryNo);
        return AjaxObject.ok("修改实时数据配置成功");
    }

    /**
     * 获取实时填报字段
     *
     * @param request
     * @return
     */
    @GetMapping("/getRealTimeConfig")
    @ApiOperation(value = "获取实时数据显示配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject getRealTimeConfig(HttpServletRequest request) {
        String factoryNo = request.getParameter("factoryNo");
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
        }

        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("list", tbSynObjects);
        return AjaxObject.ok(resultMap);
    }

    @GetMapping("/getWorkFlowRealTimeConfig")
    public AjaxObject getWorkFlowRealTimeConfig(HttpServletRequest request) {
        String factoryNo = request.getParameter("factoryNo");

        Tree<TbSynObject> tbSynObjects = tbSynObjectService.findTreeLists(factoryNo, 0, 2, null);
        List<TbRealTimeConfig> tbRealTimeConfigList = tbFactoryService.fineTbRealTimeConfigList(factoryNo);
        List<String> idList = new ArrayList<>();
        for (TbRealTimeConfig tbRealTimeConfig : tbRealTimeConfigList) {
            idList.add(tbRealTimeConfig.getUri());
        }
        if (tbSynObjects != null) {
            TreeUtils.freshSynData(tbSynObjects.getChildren(), idList);
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
        }
        Map<String, Object> map = new HashMap<>(6);
        Map<String, Object> resultMap = getTreeMap(tbSynObjects.getChildren().get(0));
        List<Map<String, Object>> treeList = new ArrayList<>(2);
        treeList.add(resultMap);
        map.put("tree", treeList);
        return AjaxObject.ok(map);
    }


    private Map<String, Object> getTreeMap(Tree<TbSynObject> treeNode) {
        Map<String, Object> resultMap = new HashMap<>(5);
        resultMap.put("id", treeNode.getId());
        resultMap.put("text", treeNode.getText());
        resultMap.put("type", treeNode.getAttributes().get("type"));
        if ("4".equals(treeNode.getAttributes().get("type").toString())) {
            resultMap.put("isValue", true);
        } else {
            resultMap.put("isValue", false);
        }
        resultMap.put("accessLevel", treeNode.getAttributes().get("accessLevel"));

        if (treeNode.getChildren().size() > 0) {
            List<Map<String, Object>> children = new ArrayList<>(treeNode.getChildren().size());
            for (int i = 0; i < treeNode.getChildren().size(); i++) {
                children.add(getTreeMap(treeNode.getChildren().get(i)));
            }
            resultMap.put("children", children);
        }
        return resultMap;

    }


    @PostMapping("/saveFactoryAllInfo")
    public AjaxObject saveFactoryAllInfo(HttpServletRequest request, @RequestBody JSONObject json) throws Exception {
        AjaxObject ajaxObject = new AjaxObject();
        JSONObject data = json.getJSONObject("data");
        String factoryNo = data.getString("factoryNo");
        try {
            int i = tbFactoryService.saveFactoryAllInfo(data, factoryNo, super.getUser(request, stringRedisTemplate));
            if (i == 1) {
                ajaxObject = AjaxObject.ok("保存成功,同步报表数据成功");
            } else {
                if(i==0){
                    i=500;
                }
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxObject =AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }

    @GetMapping("/getServiceRegion")
    public List getServiceRegion(TbOrg tbOrg) {
        tbOrg.setState(1);
        List<TbOrg> list = tbOrgService.selectOrgInfoByObject(tbOrg);
        List data = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = new HashMap<>(16);
            map.put("code", list.get(i).getCode());
            map.put("name", list.get(i).getName());
            data.add(map);
        }
        return data;
    }

    @RequestMapping(value = "/getFactoryVideo", method = RequestMethod.GET)
    public AjaxObject getFactoryVideo(String factoryNo) {
        TbFactoryVideo factoryVideo = tbFactoryService.getFactoryVideo(factoryNo);
        Map<String, Object> map = new HashMap<>(16);
        map.put("videoInfo", factoryVideo);
        return AjaxObject.ok(map);
    }

    /**
     * 批量导入水厂信息
     *
     * @param request,file
     * @return
     */
    @RequestMapping(value = "/importFactory", method = RequestMethod.POST)
    @ApiOperation(value = "通过Excel模板导入水厂信息")
    public AjaxObject importFactory(HttpServletRequest request, @RequestParam("file") MultipartFile file, String factoryNo) {
        AjaxObject ajaxObject = new AjaxObject();
        List<TbFactoryInfoVo> list = ExcelUtils.readExcel("", TbFactoryInfoVo.class, file);
        if(list!=null || list.size()==0){
            ajaxObject = AjaxObject.error("模板数据空,导入失败");
        }
        List<TbDict> tbDictList = getDictList();
        if(tbDictList!=null || tbDictList.size()==0){
            ajaxObject = AjaxObject.error("字典维护的相关数据空,导入失败");
        }
        List<TbOrg> tbOrgList = getTbOrgList();
        if(tbOrgList!=null || tbOrgList.size()==0){
            ajaxObject = AjaxObject.error("组织机构数据空,导入失败");
        }
        try {
            int i = tbFactoryService.saveFactoryInfo(list, factoryNo, tbDictList, tbOrgList);
            if (i == 1) {
                ajaxObject = AjaxObject.ok("导入成功,同步报表数据成功");
            } else {
                if(i==0){
                    i=500;
                }
                ajaxObject = AjaxObject.getAjaxStatus(Dict.getAjaxStatus(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxObject =AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
    }

    /**
     * 下载模板
     *
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/downloadModel", method = RequestMethod.GET)
    @ApiOperation(value = "下载水厂信息导入Excel模板")
    public void downloadModel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<TbDict> tbDicts = getDictList();
        List<TbOrg> tbOrgList = getTbOrgList();
        Map map = new HashMap(16);
        if((tbDicts==null && tbDicts.size()==0)|| (tbOrgList==null && tbOrgList.size()==0)){
            String info="字典/机构信息数据为空";
            errorInfo(response,info);
        }else {
            map.put("tbDicts", tbDicts);
            map.put("tbOrgList", tbOrgList);
            map.put("type", 1);
            map.put("fileName", "水厂模板.xlsx");
            ExcelHighUtils.writeExcelX(response, null, TbFactoryInfoVo.class, map);
        }
        
    }

    /**
     * 下载模板High
     * @param request,response
     * @return
     *//*
    @RequestMapping(value = "/downloadModelHigh",method = RequestMethod.GET)
    public void downloadModelHigh(HttpServletRequest request,  HttpServletResponse response){
        List<TbDict> tbDicts =getDictList();
        List<TbOrg> tbOrgList = getTbOrgList();
        String fileName ="水厂模板High.xlsx";
        int type=1;
        ExcelHighUtils.writeExcelX(response,null, TbFactoryInfoVo.class,tbDicts,tbOrgList,fileName,type,null);
    }*/

    /**
     * 获取水厂导入相关下拉框数据
     *
     * @return
     */
    public List<TbDict> getDictList() {
        List<Integer> parentList = new ArrayList<>();
        //'55','56','57','58','65','81','88','94','99','102'
        parentList.add(55);
        parentList.add(56);
        parentList.add(57);
        parentList.add(58);
        parentList.add(65);
        parentList.add(81);
        parentList.add(88);
        parentList.add(94);
        parentList.add(99);
        parentList.add(102);
        parentList.add(117);
        List<TbDict> tbDicts = tbDictService.getDictByParent(parentList);
        return tbDicts;
    }

    /**
     * 获取parentCode=1 区域
     *
     * @return
     */
    public List<TbOrg> getTbOrgList() {
        TbOrg tbOrg = new TbOrg();
        tbOrg.setState(1);
        tbOrg.setParentCode("1");
        List<TbOrg> tbOrgList = tbOrgService.selectOrgInfoByObject(tbOrg);
        return tbOrgList;
    }

    /**
     * 导出水厂
     *
     * @param request,response
     * @return
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    @ApiOperation(value = "导出水厂信息到Excel表")
    public void export(HttpServletRequest request, HttpServletResponse response, String factoryNo, String factoryName) {
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        tbFactoryInfo.setFactoryNo(factoryNo);
        if (!"".equals(factoryName)) {
            tbFactoryInfo.setFactoryName(factoryName);
        }
        List<TbDict> tbDicts = getDictList();
        tbFactoryInfo.setTbDicts(tbDicts);
        List<TbOrg> tbOrgList = getTbOrgList();
        tbFactoryInfo.setTbOrgList(tbOrgList);
        logger.info("查询所有水厂入参TbFactoryInfo={}", JSON.toJSONString(tbFactoryInfo));
        List<TbFactoryInfo> tbFactoryInfoList = tbFactoryService.getTbFactoryInfoNewList(tbFactoryInfo);
        List<TbFactoryInfoVo> tbFactoryInfoVoList = new ArrayList<>();
        for (TbFactoryInfo equipInfo : tbFactoryInfoList) {
            TbFactoryInfoVo tbEquipInfoVo = new TbFactoryInfoVo();
            BeanUtils.copyProperties(equipInfo, tbEquipInfoVo);
            tbFactoryInfoVoList.add(tbEquipInfoVo);
        }
        List<TbFactoryInfoVo> tbFactoryInfoListRe = new ArrayList<>();

        if(tbFactoryInfoVoList!=null && tbFactoryInfoVoList.size()>=1){
            for (int i = tbFactoryInfoVoList.size() - 1; i >= 0; i --) {

                TbFactoryInfo factorySearch = new TbFactoryInfo();
                factorySearch.setParentFactoryNo(tbFactoryInfoVoList.get(i).getFactoryNo());
                factorySearch.setTbDicts(tbDicts);
                factorySearch.setTbOrgList(tbOrgList);
                List<TbFactoryInfo> tbFactoryInfoDataByFactoryNo = tbFactoryService.getTbFactoryInfoNewList(factorySearch);
                if(tbFactoryInfoDataByFactoryNo!=null && tbFactoryInfoDataByFactoryNo.size()>0){
                    for (TbFactoryInfo factoryInfo : tbFactoryInfoDataByFactoryNo) {
                        TbFactoryInfoVo tbEquipInfoVo = new TbFactoryInfoVo();
                        BeanUtils.copyProperties(factoryInfo, tbEquipInfoVo);
                        tbFactoryInfoVoList.add(tbEquipInfoVo);
                    }
                    tbFactoryInfoVoList.remove(i);
                }
                        
            }
            tbFactoryInfoListRe= tbFactoryInfoVoList;
        }
        //获取设备类型
        Map map = new HashMap(16);
        map.put("type", 0);
        map.put("fileName", "导出水厂数据.xlsx");
        logger.info("导出水厂数据list={}",JSON.toJSONString(tbFactoryInfoListRe));
        ExcelHighUtils.writeExcelX(response, tbFactoryInfoListRe, TbFactoryInfoVo.class, map);
        logger.info("导出水厂数据ok");
    }
    //班次维护

    /**
     * 查询水厂班次列表
     *
     * @param request
     * @param tbFactoryTime
     * @return
     */
    @GetMapping("/getTbFactroyTimeList")
    @ApiOperation(value = "获取水厂排班班次列表")
    public AjaxObject getTbEquipMaintainFactorList(HttpServletRequest request, TbFactoryTime tbFactoryTime) {
        logger.info("查询水厂班次列表条件TbGroupInfo={}", JSON.toJSONString(tbFactoryTime));
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbFactoryTime> list = tbFactoryService.getTbFactroyTimeList(tbFactoryTime);
        return super.getResultObject(list, request.getParameter("page"));
    }

    /**
     * 新增/修改水厂班次
     *
     * @param request
     * @param factoryNo
     * @return
     */
    @RequestMapping(value = "/saveTbFactoryTime", method = RequestMethod.POST)
    @ApiOperation(value = "修改水厂排班班次信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "timeType", value = "排班类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "timePoints", value = "时间点序列", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject saveTbGroupInfo(HttpServletRequest request, String factoryNo, Integer timeType, String timePoints) {
        //AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            int flag = tbFactoryService.saveTbFactoryTime(factoryNo,timeType,timePoints,user);
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增/修改水厂班次失败e={}", e);
            return AjaxObject.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/getFactoryTimeDetail", method = RequestMethod.POST)
    @ApiOperation(value = "获取排班班次的具体信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂NO", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "timeType", value = "排班类型", required = true, dataType = "int", paramType = "query")
    })
    public AjaxObject getFactoryTimeDetail(String factoryNo, Integer timeType) {
        Map<String,Object> map = tbFactoryService.getFactoryTimeDetail(factoryNo,timeType);
        return AjaxObject.ok(map);

    }

    /**
     * 删除班次
     *
     * @param timeNo
     * @return
     */
    @PostMapping("/deleteTbFactoryTime")
    @ApiOperation(value = "删除排班班次")
    public AjaxObject deleteMenus(String timeNo) {
        logger.info("删除班次参数tinmeNo={}", JSON.toJSONString(timeNo));
        try {
            int i = this.tbFactoryService.deleteTbFactoryTime(timeNo);
            if (i > 0) {
                return AjaxObject.ok("删除成功！");
            } else {
                return AjaxObject.error("删除失败！");
            }
        } catch (Exception e) {
            logger.error("删除班次失败", e.getMessage());
            return AjaxObject.error(e.getMessage());
        }
    }

    /**
     * 新增子水厂
     * @param request
     * @param tbFactoryInfo
     * @return
     */
    @ApiOperation(value = "对于多期独立运营的水厂，按期添加子水厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "issueNo", value = "期号no", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/saveTbFactoryChildren", method = RequestMethod.POST)
    public AjaxObject saveTbFactoryChildren(HttpServletRequest request, TbFactoryInfo tbFactoryInfo) {
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        try {
            int flag = tbFactoryService.saveTbFactoryChildren(tbFactoryInfo);
            if (flag == 1) {
                ajaxObject = AjaxObject.ok("新增成功");
            } else {
                ajaxObject =  AjaxObject.getAjaxStatus(Dict.getAjaxStatus(flag));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增子水厂失败e={}", e);
            ajaxObject = AjaxObject.error(e.getMessage());
        }
        return ajaxObject;
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
     * 新增子水厂
     * @param request
     * @param factoryCode
     * @return
     */
    @ApiOperation(value = "对于多期独立运营的水厂，按期添加子水厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryCode", value = "factoryCode", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "factoryNo", value = "factoryNo", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/getFactoryOrg", method = RequestMethod.GET)
    public AjaxObject saveTbFactoryChildren(HttpServletRequest request, String factoryCode) {
        List<String> orgList = tbFactoryService.getFactoryOrg(factoryCode);
        Map<String,Object> map = new HashMap<>();
        map.put("orgList",orgList);
        return AjaxObject.ok(map);
    }
    /**
     * 查询子水厂
     * @param request,factoryNo
     * @return
     */
    @GetMapping("/getChildFactroy")
    @ApiOperation(value = "获取多期水厂列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "factoryNo", required = true, dataType = "string", paramType = "query")
    })
    public List<TbFactoryInfo> getChildFactroy(HttpServletRequest request, String factoryNo) {
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("查询子水厂参数factoryNo={}", JSON.toJSONString(factoryNo));
        List<TbFactoryInfo> tbFactoryInfoList= tbFactoryService.getChildFactroy(factoryNo);
        return tbFactoryInfoList;
    }

    /**
     * 删除子水厂
     * @param request,factoryNo
     * @return
     */
    @PostMapping("/delChildFactroy")
    @ApiOperation(value = "删除子水厂")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "factoryNo", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject delChildFactroy(HttpServletRequest request, String factoryNo) {
        AjaxObject ajaxObject = new AjaxObject();
        TbUser user = super.getUser(request, stringRedisTemplate);
        logger.info("删除子水厂参数factoryNo={}", JSON.toJSONString(factoryNo));
        int flag= tbFactoryService.delChildFactroy(factoryNo);
        if (flag == 1) {
            ajaxObject = AjaxObject.ok("删除成功");
        } else {
            ajaxObject =  AjaxObject.error("删除失败");
        }
        return ajaxObject;
    }


    /**
     * 配置监控视频
     * @param
     * @return
     */
    @PostMapping("/setFactoryVideo")
    @ApiOperation(value = "设置水厂监控视频配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂编号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "videoId", value = "视频编号", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject setFactoryVideo( String factoryNo,String videoId) {
        int flag= tbFactoryService.setFactoryVideo(factoryNo,videoId);
        if (flag == 1) {
            return AjaxObject.ok("配置成功");
        } else {
            return AjaxObject.error("配置失败");
        }
    }


}

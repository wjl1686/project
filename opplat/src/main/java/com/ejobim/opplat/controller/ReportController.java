package com.ejobim.opplat.controller;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.service.FillFieldService;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 填报
 * @date 2019/1/15 18:16
 */
@Api(tags = "填报")
@RestController
@RequestMapping("/report")
public class ReportController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ReportService reportService;
    private FillFieldService fillFieldService;
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    public ReportController(ReportService reportService, FillFieldService fillFieldService, StringRedisTemplate stringRedisTemplate) {
        this.reportService = reportService;
        this.fillFieldService = fillFieldService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/dateReport")
    @ApiOperation(value = "获取日结数据")
    public AjaxObject getDateReport(String page, String rows, String factoryNo, String startDate, String endDate) {
        super.setPageInfo(page, rows);
        startDate = StringUtils.isNotEmpty(startDate) ? startDate : DateUtils.formateDate(new Date());
        endDate = StringUtils.isNotEmpty(endDate) ? endDate : DateUtils.formateDate(new Date());
        List<TbReportDate> list = reportService.getTbReportDateList(factoryNo, DateUtils.parseDate(startDate), DateUtils.parseDate(endDate));
        return getResultObject(list, page);
    }

    /**
     * 获取日填报数据
     *
     * @param factoryNo
     * @param startDate
     * @param endDate
     * @param extendRmNo
     * @return
     */
    @GetMapping("/getDateReport")
    @ApiOperation(value = "获取日结数据")
    public AjaxObject getDateReport(String factoryNo, String startDate, String endDate, String extendRmNo) throws IllegalAccessException, IntrospectionException, InvocationTargetException {

        startDate = StringUtils.isNotEmpty(startDate) ? startDate : DateUtils.formateDate(new Date());
        endDate = StringUtils.isNotEmpty(endDate) ? endDate : DateUtils.formateDate(new Date());
        Map<String, List<TbReportDate>> map = reportService.getReportDateListByModel(factoryNo, DateUtils.parseDate(startDate), DateUtils.parseDate(endDate), extendRmNo);
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("info", map);
        return AjaxObject.ok(resultMap);
    }

    @GetMapping("/getReportModelList")
    @ApiOperation(value = "获取自定义报表模板列表")
    public AjaxObject getReportModelList(String page, String rows, TbReportModel reportModel) {
        super.setPageInfo(page, rows);
        List<TbReportModel> list = reportService.getReportModelList(reportModel);
        return getResultObject(list, page);
    }

    @GetMapping("/getFillFieldList")
    @ApiOperation(value = "获取填报指标列表")
    public AjaxObject getFillFieldList() {
        List<TbParameterConfig> list = reportService.getFieldList();
        return getResultObject(list, null);
    }


    @PostMapping("/addReportModel")
    @ApiOperation(value = "新增自定义白标模板")
    public AjaxObject addReportModel(HttpServletRequest request, TbReportModel reportModel) {

        if (reportService.addReportModel(reportModel, super.getUser(request, stringRedisTemplate)) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("保存错误");
        }
    }

    @PostMapping("/remove")
    @ApiOperation(value = "删除自定义报表模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "rmNo", value = "模板NO", required = true, dataType = "string", paramType = "header")
    })
    public AjaxObject remove(HttpServletRequest request, String rmNo) {
        int resultCode = reportService.deleteReportModel(rmNo);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));

    }

    /**
     * 获取其他自定义报表
     *
     * @param tbReportModelExtend
     * @param beginDate
     * @param endDate
     * @param type
     * @return
     */
    @GetMapping("/getReportModelExtendList")
    @ApiOperation(value = "获取普通类型报表模板详情或报表数据")
    public AjaxObject getReportModelExtendList(TbReportModelExtend tbReportModelExtend, Date beginDate, Date endDate, Integer type) {
        List<TbReportModelExtend> list = reportService.getReportModelExtendList(tbReportModelExtend, type, beginDate, endDate);
        Map<String, Object> resultMap = createResultMap(list);
        return AjaxObject.ok(resultMap);
    }

    /**
     * 获取报表系统自定义报表
     *
     * @param tbReportModelExtend
     * @param beginDate
     * @param endDate
     * @param type
     * @param factoryNo
     * @param parentFactoryNo
     * @return
     */
    @GetMapping("/getReportModelExtendDetailList")
    @ApiOperation(value = "获取报表系统报表模板详情或报表数据")
    public AjaxObject getReportModelExtendDetailList(TbReportModelExtend tbReportModelExtend, Date beginDate, Date endDate, Integer type, String factoryNo, String parentFactoryNo) {
        List<TbReportModelExtend> list = reportService.getReportModelExtendDetailList(tbReportModelExtend, type, beginDate, endDate, factoryNo, parentFactoryNo);
        Map<String, Object> resultMap = createResultMap(list);
        return AjaxObject.ok(resultMap);
    }

    /**
     * 将结果集合包装成所需的结构
     *
     * @param list
     * @return
     */
    private Map<String, Object> createResultMap(List<TbReportModelExtend> list) {
        Map<String, Object> resultMap = new HashMap<>();
        int columnCount = 0;
        int rowCount = 0;
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendColumnIndex() > columnCount) {
                columnCount = reportModelExtend.getExtendColumnIndex();
            }
            if (reportModelExtend.getExtendColumnIndex() > rowCount) {
                rowCount = reportModelExtend.getExtendRowIndex();
            }
        }
        resultMap.put("columnCount", columnCount);
        resultMap.put("rowCount", rowCount);
        resultMap.put("list", list);
        return resultMap;
    }


    @GetMapping("/getReportModelExtendDetailDate")
    public AjaxObject getReportModelExtendDetailDate(String staticDate, String factoryNo) {
        List<Map<String, String>> list = reportService.getReportModelExtendDetailDate(DateUtils.parseDate(staticDate), factoryNo);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", list);
        return AjaxObject.ok(resultMap);
    }


    /**
     * 新增和更新报表详情列
     *
     * @return
     */
    @PostMapping("/addReportModelExtend")
    @ApiOperation(value = "新增自定义报表模板单元格信息")
    public AjaxObject addReportModelExtend(HttpServletRequest request, TbReportModelExtend tbReportModelExtend) {
        if (reportService.addReportModelExtend(tbReportModelExtend, super.getUser(request, stringRedisTemplate)) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("保存错误");
        }
    }

    @PostMapping("/changeModelExtendType")
    public AjaxObject changeModelExtendType(HttpServletRequest request, TbReportModelExtend tbReportModelExtend) {
        if (reportService.addReportModelExtendDetail(tbReportModelExtend, super.getUser(request, stringRedisTemplate)) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("保存错误");
        }
    }

    @PostMapping("/addReportModelExtendDetail")
    @ApiOperation(value = "新增系统报表报表模板单元格信息")
    public AjaxObject addReportModelExtendDetail(HttpServletRequest request, TbReportModelExtend tbReportModelExtend) {
        if (reportService.addReportModelExtendDetail(tbReportModelExtend, super.getUser(request, stringRedisTemplate)) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("保存错误");
        }
    }

    @PostMapping("/deleteReportModelExtend")
    @ApiOperation(value = "删除自定义报表模板单元格信息")
    public AjaxObject deleteReportModelExtend(HttpServletRequest request, TbReportModelExtend tbReportModelExtend) {
        if (reportService.deleteReportModelExtend(tbReportModelExtend) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("保存错误");
        }
    }

    /**
     * baocun
     *
     * @param request
     * @param tbReportModelExtend
     * @return
     */
    @PostMapping("/saveModelMathCmd")
    @ApiOperation(value = "更新自定义报表模板单元格统计公式")
    public AjaxObject saveModelMathCmd(HttpServletRequest request, TbReportModelExtend tbReportModelExtend) {
        if (reportService.updateModelMathCmd(tbReportModelExtend) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("错误的参数");
        }
    }

    /**
     * 报表模板宝保存
     *
     * @param request
     * @param reportModelExtendDetail
     * @return
     */
    @PostMapping("/saveReportModelMathCmd")
    @ApiOperation(value = "更新自定义报表模板单元格统计公式")
    public AjaxObject saveReportModelMathCmd(HttpServletRequest request, TbReportModelExtendDetail reportModelExtendDetail) {
        if (reportService.updateReportModelMathCmd(reportModelExtendDetail) > 0) {
            return AjaxObject.ok("保存成功");
        } else {
            return AjaxObject.error("错误的参数");
        }
    }

    @GetMapping("/draftList")
    @ApiOperation(value = "获取数据底稿")
    public AjaxObject getDraftList(String factoryNo, Date startDate, Date endDate) {
        Map<String, Object> resultMap = reportService.getDraftDataList(factoryNo, startDate, endDate);
        return AjaxObject.ok(resultMap);
    }

    @GetMapping("/getDraftFieldList")
    public AjaxObject getDraftFieldList(String factoryNo) {
        Map<String, Object> resultMap = reportService.getDraftFieldList(factoryNo);
        return AjaxObject.ok(resultMap);
    }

    @GetMapping("/getFieldList")
    public AjaxObject getFieldList(String factoryNo) {
        List<Map<String, String>> list = reportService.getFieldList(factoryNo);
        return super.getResultObject(list, null);
    }

    @PostMapping("/addDateReport")
    public AjaxObject addDateReport(String factoryNo) {
        this.reportService.insertReportDate(factoryNo);
        return AjaxObject.ok("");
    }

    /**
     * 同步数据到报表系统
     * @param request
     * @param factoryNo
     * @return
     */
    @GetMapping("/saveSynReportDate")
    @ApiOperation(value = "同步数据至报表系统")
    public AjaxObject saveSynReportDate(HttpServletRequest request,String factoryNo,Date date) {
        AjaxObject ajaxObject = new AjaxObject();
        logger.info("同步数据到报表系统参数factoryNo={}", factoryNo);
        try {
            int i= reportService.saveSynReportDate(factoryNo,date);
            if(i==1){
                ajaxObject = AjaxObject.ok("同步成功");
            }else {
                ajaxObject = AjaxObject.error("同步失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxObject;
    }

}

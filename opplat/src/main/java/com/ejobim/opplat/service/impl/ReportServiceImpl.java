package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.synBean.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.IApiSyncService;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.util.CalculatorUtil;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.ReportMath;
import com.ejobim.opplat.util.StringTools;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author xibian
 * @date 2019-05-10
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int CELL_EXPAND_VERTICAL = 2;
    private static final int CELL_EXPAND_HORIZONTAL = 3;
    private static final int CELL_TIME_EXPAND_VERTICAL = 4;
    private static final int CELL_TIME_EXPAND_HORIZONTAL = 5;

    @Autowired
    private TbReportDateMapper reportDateMapper;
    @Autowired
    private TbReportModelMapper reportModelMapper;
    @Autowired
    private TbReportModelExtendMapper reportModelExtendMapper;

    @Autowired
    private TbFactoryWaterMapper tbFactoryWaterMapper;

    @Autowired
    private TbFactoryDehydrationSystemMapper tbFactoryDehydrationSystemMapper;

    @Autowired
    private TbFactoryMeasureCaliberMapper tbFactoryMeasureCaliberMapper;

    @Autowired
    private TbFactoryInfoExtendMapper tbFactoryInfoExtendMapper;

    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;

    @Autowired
    private TbReportDateMapper tbReportDateMapper;

    @Autowired
    private TbDraftDataMapper draftDataMapper;

    @Autowired
    private TbAnalysisFillTaskMapper analysisFillTaskMapper;

    @Autowired
    private TbAnalysisFillDetailMapper tbAnalysisFillDetailMapper;

    @Autowired
    private TbRoutingTaskMapper routingTaskMapper;

    @Autowired
    private TbRoutingTaskDetailMapper routingTaskDetailMapper;

    @Autowired
    private TbParameterConfigMapper parameterConfigMapper;

    @Autowired
    private TbFillFieldMapper fillFieldMapper;

    @Autowired
    private TbRoutingLocationElementMapper routingLocationElementMapper;

    @Autowired
    private TbReportModelExtendDetailMapper reportModelExtendDetailMapper;

    @Autowired
    private TbFillFormDetailMapper fillFormDetailMapper;

    @Value("${email.excel}")
    private String filePath;

    @Autowired
    private TbFactoryService tbFactoryService;

    @Autowired
    private IApiSyncService apiSyncService;


    @Autowired
    public ReportServiceImpl(TbReportDateMapper reportDateMapper, TbReportModelMapper reportModelMapper,
                             TbReportModelExtendMapper reportModelExtendMapper, TbFillFormDetailMapper fillFormDetailMapper) {
        this.reportDateMapper = reportDateMapper;
        this.reportModelMapper = reportModelMapper;
        this.reportModelExtendMapper = reportModelExtendMapper;
        this.fillFormDetailMapper = fillFormDetailMapper;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int addDateReport(TbReportDate reportDate) {
        reportDate.setDrNo(StringTools.getUUID());
        return reportDateMapper.insert(reportDate);
    }

    @Override
    public List<TbReportDate> getTbReportDateList(String factoryNo, Date startDate, Date endDate) {
        TbReportDateExample example = new TbReportDateExample();
        TbReportDateExample.Criteria criteria = example.createCriteria();
        criteria.andDrFactoryNoEqualTo(factoryNo);
        criteria.andDrDateBetween(startDate, endDate);
        example.setOrderByClause(" dr_browse_name ");
        return reportDateMapper.selectByExample(example);
    }

    @Override
    public Map<String, List<TbReportDate>> getReportDateListByModel(String factoryNo, Date startDate, Date endDate, String extendRmNo) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        TbReportModelExtendExample extendExample = new TbReportModelExtendExample();
        TbReportModelExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andExtendRmNoEqualTo(extendRmNo);
        //获取配置信息
        List<TbReportModelExtend> extendList = reportModelExtendMapper.selectByExample(extendExample);
        List<String> dayList = DateUtils.getDistDayList(startDate, endDate);
        Map<String, List<TbReportDate>> map = new HashMap<>();
        for (String day : dayList) {
            List<TbReportDate> reportDateList = getDateReportList(factoryNo, day, extendList);
            if (reportDateList != null) {
                map.put(day, reportDateList);
            }
        }
        return map;
    }

    private List<TbReportDate> getDateReportList(String factoryNo, String date, List<TbReportModelExtend> extendList) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String nextDate = DateUtils.formateDate(DateUtils.getNextDate(date));
        String nextNextDate = DateUtils.formateDate(DateUtils.getNextDate(nextDate));
        List<TbFillFormDetail> lastList = fillFormDetailMapper.selectListByDate(factoryNo, date, nextDate);
        if (lastList == null || lastList.size() == 0) {
            return null;
        }
        List<TbFillFormDetail> currentList = fillFormDetailMapper.selectListByDate(factoryNo, nextDate, nextNextDate);
        if (currentList == null || currentList.size() == 0) {
            return null;
        }
        Map<String, Map<String, Object>> tempMap = new HashMap<>();
        Map<String, Map<String, Object>> nextDayTempMap = new HashMap<>();
        clearData(tempMap, extendList, lastList);
        clearData(nextDayTempMap, extendList, currentList);
        //存储数据用于计算达标率
        Map waterMap = null;
        TbFactoryMeasureCaliber tbFactoryMeasureCaliber = null;
        TbFactoryInfoExtend tbFactoryInfoExtend = null;
        List<TbReportDate> reportDateList = new ArrayList<>();
        Map dehyInfoMap = null;
        Map<String, Double> fillMap = new HashMap<>();
        for (TbReportModelExtend extend : extendList) {
            if (extend.getExtendMathType().intValue() != 5 && extend.getExtendMathType().intValue() != 0) {
                List<TbFillFormDetail> valueList1 = (List<TbFillFormDetail>) tempMap.get(extend.getExtendNo()).get("valueList");
                List<TbFillFormDetail> valueList2 = (List<TbFillFormDetail>) nextDayTempMap.get(extend.getExtendNo()).get("valueList");
                double value = getValue(extend, valueList1, valueList2);
                fillMap.put(extend.getUri(), value);
                reportDateList.add(newReportDate(valueList1.get(0), extend, extend.getExtendBrowseName(), extend.getExtendMathType(), value, DateUtils.parseDate(date)));
            }
        }
        for (TbReportModelExtend extend : extendList) {
            if (extend.getExtendMathType().intValue() == 5) {
                double value = calculateNew(factoryNo, extend, fillMap, waterMap, tbFactoryMeasureCaliber, tbFactoryInfoExtend, dehyInfoMap);
                reportDateList.add(newReportDate(null, extend, extend.getExtendBrowseName(), extend.getExtendMathType(), value, DateUtils.parseDate(date)));
            }
        }
        return reportDateList;


    }


    private Double calculateNew(String factoryNo, TbReportModelExtend modelExtend, Map<String, Double> fillMap, Map waterMap, TbFactoryMeasureCaliber tbFactoryMeasureCaliber,
                                TbFactoryInfoExtend tbFactoryInfoExtend, Map dehyInfoMap) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Double value = 0.0;
        if (StringUtils.isNotEmpty(modelExtend.getExtendMathCmd())) {

            JSONArray jsonArray = JSONArray.parseArray(modelExtend.getExtendMathCmd());
            StringBuffer mathCmdSb = new StringBuffer();
            for (int i = 0; i < jsonArray.size(); i++) {
                if (jsonArray.getJSONObject(i).getIntValue("type") > 0) {
                    if (jsonArray.getJSONObject(i).getIntValue("type") == 1) {
                        mathCmdSb.append("[" + jsonArray.getJSONObject(i).getString("name") + "]");
                    } else {
                        mathCmdSb.append(jsonArray.getJSONObject(i).getString("name"));
                    }

                }
            }
            String mathCmd = mathCmdSb.toString();

            for (Map.Entry<String, Double> entry : fillMap.entrySet()) {
                String replayStr = "[" + entry.getKey() + "]";
                mathCmd = mathCmd.replace(replayStr, String.valueOf(entry.getValue()));
            }
            value = CalculatorUtil.getResult(mathCmd);


        }
        return value;
    }


    private TbReportDate newReportDate(TbFillFormDetail detail, TbReportModelExtend extend, String browseName, int type, Double value, Date date) {
        TbReportDate reportDate = new TbReportDate();
        reportDate.setDrBrowseName(browseName);
        reportDate.setDrNo(StringTools.getUUID());
        reportDate.setDrCreateTime(new Date());
        if (detail != null) {
            reportDate.setDrDate(date);
            reportDate.setDrDisplayName(extend.getExtendColumnName());
            reportDate.setDrEquipNo(detail.getEquipNo());
            reportDate.setDrFactoryNo(detail.getFactoryNo());
            reportDate.setDrEquipName(extend.getExtendNo());
            reportDate.setDrUnit(detail.getFieldUnit());
        } else {
            reportDate.setDrDate(date);
            reportDate.setDrDisplayName(extend.getExtendColumnName());
            reportDate.setDrEquipName(extend.getExtendNo());
            reportDate.setDrFactoryNo(extend.getExtendFactoryNo());
        }
        reportDate.setDrValue(value.floatValue());
        reportDate.setDrDataType(type);

        return reportDate;
    }

    private double getValue(TbReportModelExtend modelExtend, List<TbFillFormDetail> valueList1, List<TbFillFormDetail> valueList2) {

        if (modelExtend.getExtendMathType().intValue() == 3) {
            double value = Double.MIN_VALUE;
            for (TbFillFormDetail formDetail : valueList1) {
                value = value < formDetail.getFieldValue() ? formDetail.getFieldValue() : value;
            }
            return value;
        }
        if (modelExtend.getExtendMathType().intValue() == 3) {
            double value = Double.MAX_VALUE;
            for (TbFillFormDetail formDetail : valueList1) {
                value = value > formDetail.getFieldValue() ? formDetail.getFieldValue() : value;
            }
            return value;
        }
        if (modelExtend.getExtendMathType().intValue() == 1) {
            if (valueList1.size() > modelExtend.getSubIndex() && valueList2.size() > modelExtend.getSubIndex()) {
                return valueList2.get(modelExtend.getSubIndex()).getFieldValue() - valueList1.get(modelExtend.getSubIndex()).getFieldValue();
            }
        }
        if (modelExtend.getExtendMathType().intValue() == 2) {
            double sum = 0.0;
            for (TbFillFormDetail formDetail : valueList1) {
                if (formDetail == null || formDetail.getFieldValue() == null) {
                    System.out.println();
                }
                sum += formDetail.getFieldValue();
            }
            return sum / valueList1.size();
        }

        return -1;

    }

    /**
     * 根据配置信息获取数据
     *
     * @param tempMap
     * @param extendList
     * @param detailList
     */
    private void clearData(Map<String, Map<String, Object>> tempMap, List<TbReportModelExtend> extendList, List<TbFillFormDetail> detailList) {
        for (TbReportModelExtend modelExtend : extendList) {
            if (modelExtend.getExtendMathType().intValue() != 0) {
                Map<String, Object> map = tempMap.get(modelExtend.getExtendNo());
                List<TbFillFormDetail> valueList = null;
                if (map != null) {
                    valueList = (List<TbFillFormDetail>) map.get("valueList");
                } else {
                    map = new HashMap<>();
                    valueList = new ArrayList<>();
                    map.put("valueList", valueList);
                    map.put("config", modelExtend);
                    tempMap.put(modelExtend.getExtendNo(), map);
                }

                //如果是计算类型
                if (modelExtend.getExtendMathType().intValue() == 5) {
                    valueList.add(null);
                } else {
                    for (TbFillFormDetail tbFillFormDetail : detailList) {
                        if (tbFillFormDetail.getConfigNo().equals(modelExtend.getUri())) {
                            valueList.add(tbFillFormDetail);
                        }
                    }
                }
            }

        }
    }


    @Override
    public List<TbReportModel> getReportModelList(TbReportModel reportModel) {
        List<TbFactoryInfo> childFactoryList = getChildFactoryList(reportModel.getRmFactoryNo());
        List<TbReportModel> list = new ArrayList<>(20);
        TbReportModelExample reportModelExample = new TbReportModelExample();
        reportModelExample.createCriteria().andRmFactoryNoEqualTo("system");
        List<TbReportModel> sysList = reportModelMapper.selectByExample(reportModelExample);
        TbReportModel sysReportModel = sysList.get(0);
        if (childFactoryList.size() > 1) {
            for (TbFactoryInfo factoryInfo : childFactoryList) {
                TbReportModel factoryReportModel = sysReportModel.clone();
                factoryReportModel.setRmFactoryNo(factoryInfo.getFactoryNo());
                factoryReportModel.setRmName(factoryReportModel.getRmName() + "(" + factoryInfo.getFactoryName() + ")");
                list.add(factoryReportModel);
            }
        } else {
            TbReportModel factoryReportModel = sysReportModel.clone();
            factoryReportModel.setRmFactoryNo(reportModel.getRmFactoryNo());

            list.add(factoryReportModel);
        }

        TbReportModelExample example = new TbReportModelExample();
        TbReportModelExample.Criteria criteria = example.createCriteria();
        criteria.andRmFactoryNoEqualTo(reportModel.getRmFactoryNo());
        if (StringUtils.isNotEmpty(reportModel.getRmName())) {
            criteria.andRmNameLike("%" + reportModel.getRmName() + "%");
        }
        List<TbReportModel> myList = reportModelMapper.selectByExample(example);
        list.addAll(myList);
        return list;
    }


    /**
     * 通过水厂编号查询子水厂列表
     *
     * @param factoryNo
     * @return
     */
    private List<TbFactoryInfo> getChildFactoryList(String factoryNo) {
        TbFactoryInfoExample factoryInfoExample = new TbFactoryInfoExample();
        factoryInfoExample.createCriteria().andParentFactoryNoEqualTo(factoryNo);
        return tbFactoryInfoMapper.selectByExample(factoryInfoExample);
    }

    @Override
    public int addReportModel(TbReportModel reportModel, TbUser tbUser) {
        reportModel.setRmNo(StringTools.getUUID());
        reportModel.setRmCreateTime(new Date());
        reportModel.setRmCreateUser(tbUser.getCode());
        reportModel.setRmCreateUseName(tbUser.getName());
        return reportModelMapper.insertSelective(reportModel);
    }

    @Override
    @Transactional()
    public int deleteReportModel(String rmNo) {
        TbReportModel reportModel = reportModelMapper.selectByPrimaryKey(rmNo);
        //报表系统模板
        if (reportModel.getRmCycle().equals(2)) {
            return Dict.AjaxStatus.SYSTEM_REPORT.getStatusCode();
        } else {
            TbReportModelExtendExample reportModelExtendExample = new TbReportModelExtendExample();
            reportModelExtendExample.createCriteria().andExtendRmNoEqualTo(rmNo);
            reportModelExtendMapper.deleteByExample(reportModelExtendExample);
            reportModelMapper.deleteByPrimaryKey(rmNo);
            return Dict.AjaxStatus.YES.getStatusCode();
        }


    }

    @Override
    public List<TbReportModelExtend> getReportModelExtendList(TbReportModelExtend reportModelExtendSearch, Integer type, Date beginDate, Date endDate) {

        //获取模板信息
        TbReportModel reportModel = reportModelMapper.selectByPrimaryKey(reportModelExtendSearch.getExtendRmNo());
        //取得报表模板样式
        TbReportModelExtendExample extendExample = new TbReportModelExtendExample();
        extendExample.createCriteria().andExtendRmNoEqualTo(reportModelExtendSearch.getExtendRmNo());
        extendExample.setOrderByClause(" extend_column_index ");
        List<TbReportModelExtend> list = reportModelExtendMapper.selectByExample(extendExample);
        if (type == 1) {
            return list;
        } else {
            //获取报表中所有需要统计的数据项

            List<String> dayList = DateUtils.getDistDayList(beginDate, endDate);
            Date searchBeginDate = DateUtils.getNextDate(beginDate,-1);
            Date baseSearchDate = getExcelBaseInfo(list, dayList.size());
            if(baseSearchDate!=null ){
                baseSearchDate = DateUtils.getNextDate(baseSearchDate,-1);
            }

            if(baseSearchDate==null || baseSearchDate.getTime()>searchBeginDate.getTime()){
                baseSearchDate = beginDate;
            }
            System.out.println(DateUtils.formateDateFull(new Date()));
            Map<String, Map<String,Double>> reportDateMap = getStaticDataMap(baseSearchDate, endDate, reportModel.getRmFactoryNo());

            //统计模式
            List<TbReportModelExtend> resultList = getReportFieldTitle(list);

            //找到设置的日期列
            List<TbReportModelExtend> dateCellList = getDateColumn(list);
            System.out.println(DateUtils.formateDateFull(new Date()));
            //创建日期列
            if (dateCellList.size() > 0) {
                for (TbReportModelExtend dateCell : dateCellList) {
                    if (dateCell.getExtendMathType().equals(CELL_TIME_EXPAND_VERTICAL)) {
                        for (int i = 0; i < dayList.size(); i++) {
                            String day = dayList.get(i);
                            TbReportModelExtend dateModelExtend = newReportCell(0, dateCell.getExtendRowIndex() + i, dateCell.getExtendColumnIndex(), day, null, 1, 1);

                            resultList.add(dateModelExtend);
                        }
                    } else if (dateCell.getExtendMathType().equals(CELL_TIME_EXPAND_HORIZONTAL)) {
                        for (int i = 0; i < dayList.size(); i++) {
                            String day = dayList.get(i);
                            TbReportModelExtend dateModelExtend = newReportCell(0, dateCell.getExtendRowIndex(), dateCell.getExtendColumnIndex() + i, day, null, 1, 1);


                            resultList.add(dateModelExtend);
                        }
                    }
                }
            }

            //先计算统计单元格
            ReportMath reportMath = new ReportMath(reportDateMap, dayList);
            System.out.println(DateUtils.formateDateFull(new Date()));
            for (TbReportModelExtend reportModelExtend : list) {
                //单个单元格
                if (reportModelExtend.getExtendMathType().equals(1)) {
                    if(StringUtils.isNotEmpty(reportModelExtend.getExtendMathCmd())){
                        JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getExtendMathCmd());
                        Double value = reportMath.doMath(2,cmdArray,dayList.get(dayList.size()-1),reportModelExtend.getExtendStaticInfo());
                        if (value != null) {
                            TbReportModelExtend newReportModelCell = newReportCell(1, reportModelExtend.getExtendRowIndex(), reportModelExtend.getExtendColumnIndex(), null, value, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                            resultList.add(newReportModelCell);
                        } else {
                            TbReportModelExtend newReportModelCell = newReportCell(1, reportModelExtend.getExtendRowIndex(), reportModelExtend.getExtendColumnIndex(), "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                            resultList.add(newReportModelCell);
                        }
                    }else{
                        TbReportModelExtend newReportModelCell = newReportCell(1, reportModelExtend.getExtendRowIndex(), reportModelExtend.getExtendColumnIndex(), "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                        resultList.add(newReportModelCell);
                    }

                } else if (reportModelExtend.getExtendMathType().equals(2) || reportModelExtend.getExtendMathType().equals(3)) {
                    //扩展的横向列或者纵向列
                    for (int i = 0; i < dayList.size(); i++) {
                        int rowAdd = 0;
                        int columnAdd = 0;
                        if (reportModelExtend.getExtendMathType().equals(2)) {
                            rowAdd = i;
                        }
                        if (reportModelExtend.getExtendMathType().equals(3)) {
                            columnAdd = i;
                        }
                        String title = "-";
                        Double value = null;
                        String day = dayList.get(i);
                        if (reportDateMap.containsKey(day)) {
                            if(StringUtils.isNotEmpty(reportModelExtend.getExtendMathCmd())){
                                JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getExtendMathCmd());
                                value = reportMath.doMath(1,cmdArray,day,reportModelExtend.getExtendStaticInfo());
                                if (value != null) {
                                    title = null;
                                }
                            }

                        }

                        TbReportModelExtend newReportModelCell = newReportCell(1, reportModelExtend.getExtendRowIndex() + rowAdd, reportModelExtend.getExtendColumnIndex() + columnAdd, title, value, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                        resultList.add(newReportModelCell);
                    }
                }
            }
            System.out.println(DateUtils.formateDateFull(new Date()));
            return resultList;
        }
    }

    /**
     * 获取整个页面的基础布局
     *
     * @param list
     * @param staticCount
     * @return
     */
    private Date getExcelBaseInfo(List<TbReportModelExtend> list, int staticCount) {

        Date date = null;
        int maxRow = 0;
        int maxColumn = 0;
        for (TbReportModelExtend reportModelExtend : list) {
            //获取最小的时间范围
            date = getStaticDate(date, reportModelExtend);
            //获取最高的宽高
            if (reportModelExtend.getExtendRowIndex() > maxRow) {
                maxRow = reportModelExtend.getExtendRowIndex();
            }
            if (reportModelExtend.getExtendColumnIndex() > maxColumn) {
                maxColumn = reportModelExtend.getExtendColumnIndex();
            }
        }
        int maxSize = maxRow > maxColumn ? maxRow : maxColumn;
        int rowAdd = 0;
        int columnAdd = 0;
        Map<String, Integer> startMap = new HashMap<>();
        startMap.put("rowAddStart", 0);
        startMap.put("columnAddStart", 0);
        int[] verticalExpands = new int[maxSize + 1];
        int[] horizontalExpands = new int[maxSize + 1];
        for (int i = 0; i <= maxSize; i++) {
            verticalExpands[i] = 0;
            horizontalExpands[i] = 0;
        }

        for (int size = 0; size <= maxSize; size++) {
            //是否找到 纵向扩展
            Map<String, Object> verticalMap = new HashMap<>();
            verticalMap.put("hasVerticalExpand", false);
            verticalMap.put("rowAddCount", 0);

            //是否找到 横向扩展
            Map<String, Object> horizontalMap = new HashMap<>();
            horizontalMap.put("hasHorizontalExpand", false);
            horizontalMap.put("columnAddCount", 0);

            for (int i = 0; i < size; i++) {
                for (TbReportModelExtend reportModelExtend : list) {
                    if(reportModelExtend.getSubIndex()!=null && reportModelExtend.getSubIndex()==10){
                        continue;
                    }
                    //修改行坐标
                    if (reportModelExtend.getExtendRowIndex() == i && reportModelExtend.getExtendColumnIndex() == size) {
                        getVerticalMap(reportModelExtend, staticCount, startMap, verticalExpands, verticalMap);
                        reportModelExtend.setExtendColumnIndex(reportModelExtend.getExtendColumnIndex() + columnAdd);
                        reportModelExtend.setSubIndex(10);

                    }
                }
            }
            for (int i = 0; i < size; i++) {
                for (TbReportModelExtend reportModelExtend : list) {
                    if(reportModelExtend.getSubIndex()!=null && reportModelExtend.getSubIndex()==10){
                        continue;
                    }
                    //修改列坐标
                    if (reportModelExtend.getExtendColumnIndex() == i && reportModelExtend.getExtendRowIndex() == size) {
                        getHorizontalMap(reportModelExtend, staticCount, startMap, horizontalExpands, horizontalMap);
                        reportModelExtend.setExtendRowIndex(reportModelExtend.getExtendRowIndex() + rowAdd);
                        reportModelExtend.setSubIndex(10);

                    }
                }
            }
            for (TbReportModelExtend reportModelExtend : list) {
                if(reportModelExtend.getSubIndex()!=null && reportModelExtend.getSubIndex()==10){
                    continue;
                }
                if (reportModelExtend.getExtendColumnIndex() == size && reportModelExtend.getExtendRowIndex() == size) {
                    getVerticalMap(reportModelExtend, staticCount, startMap, verticalExpands, verticalMap);
                    getHorizontalMap(reportModelExtend, staticCount, startMap, horizontalExpands, horizontalMap);
                    reportModelExtend.setExtendColumnIndex(reportModelExtend.getExtendColumnIndex() + columnAdd);
                    reportModelExtend.setExtendRowIndex(reportModelExtend.getExtendRowIndex() + rowAdd);
                    reportModelExtend.setSubIndex(10);

                }

            }

            boolean hasVerticalExpand = (boolean) verticalMap.get("hasVerticalExpand");
            if (hasVerticalExpand) {
                int rowAddCount = (int) verticalMap.get("rowAddCount");
                rowAdd = rowAdd + rowAddCount;
            }
            boolean hasHorizontalExpand = (boolean) horizontalMap.get("hasHorizontalExpand");
            if (hasHorizontalExpand) {
                int columnAddCount = (int) horizontalMap.get("columnAddCount");
                columnAdd = columnAdd + columnAddCount;
            }
        }
        //用户获取 统计的时间范围
        return date;
    }

    private void getVerticalMap(TbReportModelExtend reportModelExtend, int staticCount, Map<String, Integer> startMap, int[] verticalExpands, Map<String, Object> resultMap) {
        if (reportModelExtend.getExtendMathType().equals(CELL_EXPAND_VERTICAL) || reportModelExtend.getExtendMathType().equals(CELL_TIME_EXPAND_VERTICAL)) {
            resultMap.put("hasVerticalExpand", true);
            //如果同列 已经有了个扩展单元格
            if (verticalExpands[reportModelExtend.getExtendColumnIndex()] == 1) {
                resultMap.put("rowAddCount", staticCount - 1);
            } else {
                //第一次找到该列的扩展
                if (startMap.get("rowAddStart") == 0) {
                    resultMap.put("rowAddCount", staticCount - 1);
                    startMap.put("rowAddStart", reportModelExtend.getExtendRowIndex());
                } else if (startMap.get("rowAddStart") < reportModelExtend.getExtendRowIndex()) {
                    startMap.put("rowAddStart", reportModelExtend.getExtendRowIndex());
                    resultMap.put("rowAddCount", 1);
                }
                //如果本列第一次找到 其他列已经存在 则+1
                verticalExpands[reportModelExtend.getExtendColumnIndex()] = 1;
            }

        }
    }

    private void getHorizontalMap(TbReportModelExtend reportModelExtend, int staticCount, Map<String, Integer> startMap, int[] horizontalExpands, Map<String, Object> resultMap) {
        if (reportModelExtend.getExtendMathType().equals(CELL_EXPAND_HORIZONTAL) || reportModelExtend.getExtendMathType().equals(CELL_TIME_EXPAND_HORIZONTAL)) {
            resultMap.put("hasHorizontalExpand", true);
            if (horizontalExpands[reportModelExtend.getExtendRowIndex()] == 1) {
                resultMap.put("columnAddCount", staticCount - 1);
            } else {
                //第一次找到该行的扩展
                if (startMap.get("columnAddStart") == 0) {
                    resultMap.put("columnAddCount", staticCount - 1);
                    startMap.put("columnAddStart", reportModelExtend.getExtendColumnIndex());
                } else if (startMap.get("columnAddStart") < reportModelExtend.getExtendColumnIndex()) {
                    startMap.put("columnAddStart", reportModelExtend.getExtendColumnIndex());
                    resultMap.put("columnAddCount", 1);
                }
                horizontalExpands[reportModelExtend.getExtendRowIndex()] = 1;
            }
        }
    }


    private Date getStaticDate(Date date, TbReportModelExtend reportModelExtend) {
        if (StringUtils.isNotEmpty(reportModelExtend.getExtendStaticInfo())) {
            JSONObject jsonObject = JSONObject.parseObject(reportModelExtend.getExtendStaticInfo());

            Date staticStartDate = null;
            //固定日期
            if (jsonObject.getIntValue("dateType") == 0) {
                if(!jsonObject.containsKey("staticStartDate")){
                    return null;
                }
                staticStartDate = DateUtils.parseDate(jsonObject.getString("staticStartDate"));

            } else {
                staticStartDate = DateUtils.getFirstDay(new Date(), jsonObject.getIntValue("dateType"));
            }

            if (date == null) {
                date = staticStartDate;
            } else {
                if (date.getTime() > staticStartDate.getTime()) {
                    date = staticStartDate;
                }
            }

        }
        return date;
    }



    private Map<String, Map<String,Double>> getStaticDataMap(Date beginDate, Date endDate, String factoryNo) {
        beginDate = DateUtils.getNextDate(beginDate,-1);
        List<String> dayList = DateUtils.getDistDayList(beginDate, endDate);
        Map<String, Map<String,Double>> resultMap = new HashMap<>();
        for(String date:dayList){
            resultMap.put(date,new HashMap<>());
        }
        TbDraftDataExample draftDataExample = new TbDraftDataExample();
        draftDataExample.createCriteria().andDraftTimeBetween(beginDate, endDate).andFactoryNoEqualTo(factoryNo);
        draftDataExample.setOrderByClause(" draft_time ");
        List<TbDraftData> list = draftDataMapper.selectByExample(draftDataExample);

        for (TbDraftData draftData : list) {
            String key = DateUtils.formateDateFull(draftData.getDraftTime()) + "_" + draftData.getFillNo();
            resultMap.get(draftData.getDraftDate()).put(key,draftData.getDraftValue());
        }
        return resultMap;
    }


    /**
     * 获取水厂报表模板及数据
     *
     * @param reportModelExtendSearch
     * @param type
     * @param beginDate
     * @param endDate
     * @param factoryNo
     * @return
     */
    @Override
    public List<TbReportModelExtend> getReportModelExtendDetailList(TbReportModelExtend reportModelExtendSearch, Integer type, Date beginDate, Date endDate, String factoryNo, String parentFactoryNo) {

        //获取模板信息
        TbReportModel reportModel = reportModelMapper.selectByPrimaryKey(reportModelExtendSearch.getExtendRmNo());
        //取得报表模板样式
        TbReportModelExtendExample extendExample = new TbReportModelExtendExample();
        extendExample.createCriteria().andExtendRmNoEqualTo(reportModelExtendSearch.getExtendRmNo());
        extendExample.setOrderByClause(" extend_column_index ");
        List<TbReportModelExtend> list = reportModelExtendMapper.selectByExample(extendExample);
        TbReportModelExtendDetailExample reportModelExtendDetailExample = new TbReportModelExtendDetailExample();
        reportModelExtendDetailExample.createCriteria().andFactoryNoEqualTo(factoryNo);
        List<TbReportModelExtendDetail> reportModelExtendDetailList = reportModelExtendDetailMapper.selectByExample(reportModelExtendDetailExample);
        if (reportModelExtendDetailList.size() > 0) {
            for (TbReportModelExtendDetail reportModelExtendDetail : reportModelExtendDetailList) {
                for (TbReportModelExtend reportModelExtend : list) {
                    if (reportModelExtend.getExtendNo().equals(reportModelExtendDetail.getLinkExtendNo())) {
                        reportModelExtend.setReportModelExtendDetail(reportModelExtendDetail);
                    }
                }
            }

        }
        if (type == 1) {
            return list;
        } else if (type == 2) {
            //获取报表中所有需要统计的数据项
            List<String> dayList = DateUtils.getDistDayList(beginDate, endDate);
            List<TbReportModelExtend> resultList = getReportFieldDetailTitle(list);
            int startRow = 3;
            for (String day : dayList) {
                TbReportModelExtend dateModelExtend = newReportCell(0, startRow, 0, day, null, 1, 1);
                dateModelExtend.setExtendMathType(1);
                dateModelExtend.setValue(day);
                resultList.add(dateModelExtend);
                startRow++;
            }
            //获取所有的统计数据
            Map<String, Map<String,Double>> reportDateMap = null;
            if (parentFactoryNo == null) {
                reportDateMap = getStaticDataMap(beginDate, endDate, factoryNo);
            } else {
                reportDateMap = getStaticDataMap(beginDate, endDate, parentFactoryNo);
            }

            startRow = 3;
            //先计算统计单元格
            ReportMath reportMath = new ReportMath(reportDateMap, dayList);
            for (int i = 0; i < dayList.size(); i++) {
                String day = dayList.get(i);
                if (reportDateMap.containsKey(day)) {
                    for (TbReportModelExtend reportModelExtend : list) {
                        if (reportModelExtend.getExtendMathType() != 0) {
                            if (reportModelExtend.getReportModelExtendDetail() != null && StringUtils.isNotEmpty(reportModelExtend.getReportModelExtendDetail().getMathCmd())) {
                                if(StringUtils.isNotEmpty(reportModelExtend.getReportModelExtendDetail().getMathCmd())) {
                                    JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getReportModelExtendDetail().getMathCmd());
                                    Double value = reportMath.doMath(1,cmdArray,day,null);
                                    if (value != null) {
                                        TbReportModelExtend newReportModelCell = newReportCell(1, startRow, reportModelExtend.getExtendColumnIndex() + 1, null, value, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                                        resultList.add(newReportModelCell);
                                    } else {
                                        TbReportModelExtend newReportModelCell = newReportCell(1, startRow, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                                        resultList.add(newReportModelCell);
                                    }
                                }else{
                                    TbReportModelExtend newReportModelCell = newReportCell(1, startRow, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                                    resultList.add(newReportModelCell);
                                }

                            } else {
                                TbReportModelExtend newReportModelCell = newReportCell(1, startRow, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                                resultList.add(newReportModelCell);
                            }
                        }


                    }
                } else {

                    for (TbReportModelExtend reportModelExtend : list) {
                        if (reportModelExtend.getExtendMathType() != 0) {
                            TbReportModelExtend newReportModelCell = newReportCell(1, startRow, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                            resultList.add(newReportModelCell);
                        }
                    }
                }
                startRow++;
            }
            return resultList;

        }
        return list;
    }


    @Override
    public List<Map<String, String>> getReportModelExtendDetailDate(Date staticDate, String factoryNo) {
        String rmNo = "fb2f755a8d5644e982e182cda42cad42";
        Date endDate = staticDate;
        Date beginDate = DateUtils.getNextDate(DateUtils.formateDate(staticDate), -1);

        //取得报表模板样式
        TbReportModelExtendExample extendExample = new TbReportModelExtendExample();
        extendExample.createCriteria().andExtendRmNoEqualTo(rmNo);
        extendExample.setOrderByClause(" extend_column_index ");
        List<TbReportModelExtend> list = reportModelExtendMapper.selectByExample(extendExample);
        TbReportModelExtendDetailExample reportModelExtendDetailExample = new TbReportModelExtendDetailExample();
        reportModelExtendDetailExample.createCriteria().andFactoryNoEqualTo(factoryNo);
        List<TbReportModelExtendDetail> reportModelExtendDetailList = reportModelExtendDetailMapper.selectByExample(reportModelExtendDetailExample);
        if (reportModelExtendDetailList.size() > 0) {
            for (TbReportModelExtendDetail reportModelExtendDetail : reportModelExtendDetailList) {
                for (TbReportModelExtend reportModelExtend : list) {
                    if (reportModelExtend.getExtendNo().equals(reportModelExtendDetail.getLinkExtendNo())) {
                        reportModelExtend.setReportModelExtendDetail(reportModelExtendDetail);
                    }
                }
            }

        }
        TbFactoryInfo factoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);

        //获取报表中所有需要统计的数据项
        List<Map<String, String>> resultList = new ArrayList<>(100);

        Map<String, Map<String,Double>> reportDateMap = null;
        if (StringUtils.isEmpty(factoryInfo.getParentFactoryNo())) {
            reportDateMap = getStaticDataMap(beginDate, endDate, factoryNo);
        } else {
            reportDateMap = getStaticDataMap(beginDate, endDate, factoryInfo.getParentFactoryNo());
        }
        List<String> dayList = new ArrayList<>();
        dayList.add(DateUtils.formateDate(staticDate));
        ReportMath reportMath = new ReportMath(reportDateMap, dayList);
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType() != 0) {
                if (reportModelExtend.getReportModelExtendDetail() != null && StringUtils.isNotEmpty(reportModelExtend.getReportModelExtendDetail().getMathCmd())) {
                    if(StringUtils.isNotEmpty(reportModelExtend.getExtendMathCmd())) {
                        JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getReportModelExtendDetail().getMathCmd());
                        //列表模式
                        Double value = reportMath.doMath(1,cmdArray, DateUtils.formateDate(staticDate),null);
                        if (value != null) {
                            Map<String, String> map = new HashMap<>(3);
                            map.put("code", reportModelExtend.getExtendCode());
                            map.put("value", value + "");
                            resultList.add(map);
                        }
                    }
                }
            }

        }

        return resultList;
    }

    /**
     * 获取报表中有哪些需要统计的数据字段
     *
     * @param list
     * @return
     */
    private Map<String, Double> getReportFieldMap(List<TbReportModelExtend> list) {
        Map<String, Double> fieldMap = new HashedMap();
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType() == 1) {
                if (!fieldMap.containsKey(reportModelExtend.getUri())) {
                    fieldMap.put(reportModelExtend.getUri(), 0.0);
                }
            } else if (reportModelExtend.getExtendMathType() == 2 && StringUtils.isNotEmpty(reportModelExtend.getExtendMathCmd())) {
                JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getExtendMathCmd());
                for (int i = 0; i < cmdArray.size(); i++) {
                    JSONObject jsonObject = cmdArray.getJSONObject(i);
                    if (jsonObject.getIntValue("type") == 1) {
                        String param = jsonObject.getString("name");
                        if (!fieldMap.containsKey(param)) {
                            fieldMap.put(param, 0.0);
                        }
                    }
                }
            }
        }
        return fieldMap;

    }

    private Map<String, Double> getReportDetailFieldMap(List<TbReportModelExtend> list) {
        Map<String, Double> fieldMap = new HashedMap();
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType() == 1) {
                if (reportModelExtend.getReportModelExtendDetail() != null) {
                    if (!fieldMap.containsKey(reportModelExtend.getReportModelExtendDetail().getDtUri())) {
                        fieldMap.put(reportModelExtend.getUri(), 0.0);
                    }
                }

            } else if (reportModelExtend.getExtendMathType() == 2
                    && reportModelExtend.getReportModelExtendDetail() != null
                    && StringUtils.isNotEmpty(reportModelExtend.getReportModelExtendDetail().getMathCmd())) {
                JSONArray cmdArray = JSONArray.parseArray(reportModelExtend.getReportModelExtendDetail().getMathCmd());
                for (int i = 0; i < cmdArray.size(); i++) {
                    JSONObject jsonObject = cmdArray.getJSONObject(i);
                    if (jsonObject.getIntValue("type") == 1) {
                        String param = jsonObject.getString("name");
                        if (!fieldMap.containsKey(param)) {
                            fieldMap.put(param, 0.0);
                        }
                    }
                }
            }
        }
        return fieldMap;

    }


    private List<TbReportModelExtend> getReportFieldTitle(List<TbReportModelExtend> list) {
        List<TbReportModelExtend> extendList = new ArrayList<>(list.size() * 20);
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType() == 0) {
                extendList.add(reportModelExtend);
            }
        }
        return extendList;
    }

    private List<TbReportModelExtend> getDateColumn(List<TbReportModelExtend> list) {
        List<TbReportModelExtend> resultList = new ArrayList<>();
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType().equals(CELL_TIME_EXPAND_VERTICAL) || reportModelExtend.getExtendMathType().equals(CELL_TIME_EXPAND_HORIZONTAL)  ) {
                resultList.add(reportModelExtend);
            }
        }
        return resultList;
    }

    private List<TbReportModelExtend> getReportFieldDetailTitle(List<TbReportModelExtend> list) {
        List<TbReportModelExtend> extendList = new ArrayList<>(list.size() * 20);
        TbReportModelExtend modelExtendO_0 = newReportCell(0, 0, 0, "日期", null, 1, 3);
        extendList.add(modelExtendO_0);
        List<String> fieldNoList = new ArrayList<>();
        for (TbReportModelExtend reportModelExtend : list) {
            if (reportModelExtend.getExtendMathType() == 1 || reportModelExtend.getExtendMathType() == 2) {
                TbReportModelExtend modelExtend0 = newReportCell(0, 1, reportModelExtend.getExtendColumnIndex() + 1, reportModelExtend.getExtendColumnName(), null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                extendList.add(modelExtend0);
                if (reportModelExtend.getReportModelExtendDetail() != null) {
                    if (!fieldNoList.contains(reportModelExtend.getReportModelExtendDetail().getFieldNo())) {
                        fieldNoList.add(reportModelExtend.getReportModelExtendDetail().getFieldNo());
                    }
                }
            } else {
                reportModelExtend.setExtendColumnIndex(reportModelExtend.getExtendColumnIndex() + 1);
                extendList.add(reportModelExtend);
            }
        }
        if (fieldNoList.size() > 0) {
            TbParameterConfigExample parameterConfigExample = new TbParameterConfigExample();
            parameterConfigExample.createCriteria().andParamNoIn(fieldNoList);
            List<TbParameterConfig> parameterConfigList = parameterConfigMapper.selectByExample(parameterConfigExample);
            for (TbReportModelExtend reportModelExtend : list) {
                if (reportModelExtend.getExtendMathType() == 1 || reportModelExtend.getExtendMathType() == 2) {
                    if (reportModelExtend.getReportModelExtendDetail() != null) {
                        boolean hasFind = false;
                        for (TbParameterConfig parameterConfig : parameterConfigList) {
                            if (parameterConfig.getParamNo().equals(reportModelExtend.getReportModelExtendDetail().getFieldNo())) {
                                TbReportModelExtend modelExtend1 = newReportCell(0, 2, reportModelExtend.getExtendColumnIndex() + 1, parameterConfig.getParamUnit(), null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                                extendList.add(modelExtend1);
                                hasFind = true;
                                break;
                            }
                        }
                        if (!hasFind) {
                            TbReportModelExtend modelExtend1 = newReportCell(0, 2, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                            extendList.add(modelExtend1);
                        }
                    } else {
                        TbReportModelExtend modelExtend1 = newReportCell(0, 2, reportModelExtend.getExtendColumnIndex() + 1, "-", null, reportModelExtend.getExtendCellWidth(), reportModelExtend.getExtendCellHeight());
                        extendList.add(modelExtend1);
                    }
                }
            }
        }

        return extendList;

    }


    private TbReportModelExtend newReportCell(int type, int row, int column, String title, Double value, int cellWidth, int cellHeight) {
        TbReportModelExtend modelExtend0 = new TbReportModelExtend();
        modelExtend0.setExtendColumnName(title);
        if (type == 1) {
            if (value != null) {
                modelExtend0.setValue(value + "");
            } else {
                modelExtend0.setValue("-");
            }
        }

        modelExtend0.setExtendColumnIndex(column);
        modelExtend0.setExtendRowIndex(row);
        modelExtend0.setExtendCellWidth(cellWidth);
        modelExtend0.setExtendCellHeight(cellHeight);
        modelExtend0.setExtendMathType(type);
        return modelExtend0;
    }

    /**
     * 根据计算公式计算值
     *
     * @param valueMap
     * @param mathCmd
     */
    private String doMathByCmd(Map<String, Double> valueMap, List<TbReportDate> reportDateList, String mathCmd) {
        try {
            JSONArray cmdArray = JSONArray.parseArray(mathCmd);
            Binding binding = new Binding();
            StringBuffer calcMath = new StringBuffer();
            calcMath.append("v=");
            int index = 0;
            for (int i = 0; i < cmdArray.size(); i++) {
                JSONObject jsonObject = cmdArray.getJSONObject(i);
                if (jsonObject.getIntValue("type") == 0) {
                    calcMath.append("");
                } else if (jsonObject.getIntValue("type") == 2) {
                    calcMath.append(jsonObject.getString("name"));
                } else if (jsonObject.getIntValue("type") == 1) {
                    String param = jsonObject.getString("name");
                    calcMath.append("V" + index);
                    if (valueMap != null) {
                        binding.setVariable("V" + index, valueMap.get(param));
                    } else if (reportDateList != null) {
                        for (TbReportDate reportDate : reportDateList) {
                            if (reportDate.getDrFillNo().equals(param)) {
                                binding.setVariable("V" + index, reportDate.getDrValue());
                            }
                        }
                    }

                    index++;
                }
            }
            binding.setVariable("language", "Groovy");
            GroovyShell shell = new GroovyShell(binding);
            Object value = shell.evaluate(calcMath.toString());
            return StringTools.formatDoubleStr(Double.valueOf(value.toString()), 2);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "";
        }

    }

    /**
     * 统计到报表
     *
     * @param reportDateList
     * @param reportModelExtend
     */
    private void getStaticDataMap(List<TbReportDate> reportDateList, TbReportModelExtend reportModelExtend) {
        int staticType = reportDateList.get(0).getDrDataType();
        //求和
        if (staticType == 0 || staticType == 1) {
            double value = 0;
            for (TbReportDate reportDate : reportDateList) {
                value += reportDate.getDrValue();
            }
            reportModelExtend.setValue(StringTools.formatDoubleStr(value, 2));
        } else if (staticType == 2) {
            //累进制
            double value = 0;
            for (TbReportDate reportDate : reportDateList) {
                value += reportDate.getDrValue();
            }
            reportModelExtend.setValue(StringTools.formatDoubleStr(value / reportDateList.size(), 2));
        } else if (staticType == 3) {
            //最大值
            double value = Double.MIN_VALUE;
            for (TbReportDate reportDate : reportDateList) {
                if (value < reportDate.getDrValue()) {
                    value = reportDate.getDrValue();
                }
            }
            reportModelExtend.setValue(StringTools.formatDoubleStr(value, 2));
        } else if (staticType == 4) {
            //最小值
            double value = Double.MAX_VALUE;
            for (TbReportDate reportDate : reportDateList) {
                if (value > reportDate.getDrValue()) {
                    value = reportDate.getDrValue();
                }
            }
            reportModelExtend.setValue(StringTools.formatDoubleStr(value, 2));
        }

    }


    @Override
    public int addReportModelExtend(TbReportModelExtend reportModelExtend, TbUser tbUser) {
        if (StringUtils.isNotEmpty(reportModelExtend.getExtendNo())) {
            return reportModelExtendMapper.updateByPrimaryKeySelective(reportModelExtend);
        } else {
            //校验指定单元格是否已经存在值，防止重复查询数据
            TbReportModelExtend tmp = new TbReportModelExtend();
            tmp.setExtendRowIndex(reportModelExtend.getExtendRowIndex());
            tmp.setExtendColumnIndex(reportModelExtend.getExtendColumnIndex());
            tmp.setExtendFactoryNo(reportModelExtend.getExtendFactoryNo());
            tmp.setExtendRmNo(reportModelExtend.getExtendRmNo());
            if (reportModelExtendMapper.selectCount(tmp) > 0) {
                return 0;
            }
            //插入数据
            reportModelExtend.setExtendNo(StringTools.getUUID());
            return reportModelExtendMapper.insert(reportModelExtend);
        }

    }

    /**
     * 新增修改系统报表详情
     *
     * @param reportModelExtend
     * @param tbUser
     * @return
     */
    @Override
    public int addReportModelExtendDetail(TbReportModelExtend reportModelExtend, TbUser tbUser) {
        TbReportModelExtendDetailExample reportModelExtendDetailExample = new TbReportModelExtendDetailExample();
        TbReportModelExtend oldReportModelExtend = reportModelExtendMapper.selectByPrimaryKey(reportModelExtend.getExtendNo());
        reportModelExtendDetailExample.createCriteria().andFactoryNoEqualTo(reportModelExtend.getExtendFactoryNo()).andLinkExtendNoEqualTo(reportModelExtend.getExtendNo());
        List<TbReportModelExtendDetail> reportModelExtendDetails = reportModelExtendDetailMapper.selectByExample(reportModelExtendDetailExample);
        if (reportModelExtendDetails.size() == 0) {
            TbReportModelExtendDetail reportModelExtendDetail = new TbReportModelExtendDetail();
            reportModelExtendDetail.setDtUri(reportModelExtend.getUri());
            reportModelExtendDetail.setFieldNo(reportModelExtend.getExtendFieldName());
            reportModelExtendDetail.setMathCmd(reportModelExtend.getExtendMathCmd());
            reportModelExtendDetail.setFactoryNo(reportModelExtend.getExtendFactoryNo());
            if (oldReportModelExtend.getExtendMathType() != null) {
                reportModelExtendDetail.setMathType(oldReportModelExtend.getExtendMathType());
            }

            reportModelExtendDetail.setLinkExtendNo(reportModelExtend.getExtendNo());
            return reportModelExtendDetailMapper.insertSelective(reportModelExtendDetail);
        } else {
            TbReportModelExtendDetail reportModelExtendDetail = reportModelExtendDetails.get(0);
            if (StringUtils.isNotEmpty(reportModelExtend.getUri())) {
                reportModelExtendDetail.setDtUri(reportModelExtend.getUri());
            }
            if (StringUtils.isNotEmpty(reportModelExtend.getExtendFieldName())) {
                reportModelExtendDetail.setFieldNo(reportModelExtend.getExtendFieldName());
            }
            if (StringUtils.isNotEmpty(reportModelExtend.getExtendMathCmd())) {
                reportModelExtendDetail.setMathCmd(reportModelExtend.getExtendMathCmd());
            }
            if (reportModelExtend.getExtendMathType() != null) {
                reportModelExtendDetail.setMathType(reportModelExtend.getExtendMathType());
            }

            return reportModelExtendDetailMapper.updateByPrimaryKeySelective(reportModelExtendDetail);
        }
    }

    @Override
    public int deleteReportModelExtend(TbReportModelExtend tbReportModelExtend) {
        return reportModelExtendMapper.deleteByPrimaryKey(tbReportModelExtend.getExtendNo());
    }

    @Override
    public int updateModelMathCmd(TbReportModelExtend tbReportModelExtend) {
        //跟新一条记录防止错误更新多条记录
        if (tbReportModelExtend.getExtendRmNo() != null
                && tbReportModelExtend.getExtendFactoryNo() != null
                && tbReportModelExtend.getUri() != null
                && tbReportModelExtend.getExtendMathCmd() != null) {
            return reportModelExtendMapper.updateByPrimaryKeySelective(tbReportModelExtend);

        } else {
            return 0;
        }
    }

    @Override
    public int updateReportModelMathCmd(TbReportModelExtendDetail reportModelExtendDetail) {
        //跟新一条记录防止错误更新多条记录
        if (reportModelExtendDetail.getId() != null) {
            return reportModelExtendDetailMapper.updateByPrimaryKeySelective(reportModelExtendDetail);
        } else {
            return reportModelExtendDetailMapper.insertSelective(reportModelExtendDetail);
        }
    }


    @Override
    public int saveReportDateRecord(String factoryNo, String startDate, String endDate, String extendRmNo) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        startDate = StringUtils.isNotEmpty(startDate) ? startDate : DateUtils.formateDate(new Date());
        endDate = StringUtils.isNotEmpty(endDate) ? endDate : DateUtils.formateDate(new Date());
        TbReportModelExtendExample extendExample = new TbReportModelExtendExample();
        TbReportModelExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andExtendRmNoEqualTo(extendRmNo);
        //获取配置信息
        List<TbReportModelExtend> extendList = reportModelExtendMapper.selectByExample(extendExample);
        List<String> dayList = DateUtils.getDistDayList(DateUtils.parseDate(startDate), DateUtils.parseDate(endDate));
        for (String day : dayList) {
            List<TbReportDate> dateReportList = getDateReportList(factoryNo, day, extendList);

            System.out.println(dateReportList.size());
        }
        return 1;
    }

    /**
     * 获取数据底稿
     *
     * @param factoryNo
     * @return
     */
    @Override
    public Map<String, Object> getDraftDataList(String factoryNo, Date startDate, Date endDate) {
        Map<String, Object> mainMap = new HashMap<>();

        TbDraftDataExample draftDataExample = new TbDraftDataExample();
        if (startDate != null && endDate != null) {
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeBetween(startDate, endDate);
        } else if (startDate != null) {
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeGreaterThanOrEqualTo(startDate);
        } else if (endDate != null) {
            startDate = DateUtils.getNextDate(endDate, -7);
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeBetween(startDate, endDate);
        } else {
            startDate = DateUtils.getNextDate(new Date(), -7);
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeGreaterThanOrEqualTo(startDate);
        }

        draftDataExample.setOrderByClause(" draft_time ");
        List<TbDraftData> draftDataList = draftDataMapper.selectByExample(draftDataExample);

        List<Map<String, Object>> yunXingList = new ArrayList<>(16);
        List<Map<String, Object>> sheBeiList = new ArrayList<>(16);
        List<Map<String, Object>> hyList = new ArrayList<>(16);

        List<Map<String, String>> yunXingTitleList = new ArrayList<>();
        List<String> yunXingTitleSList = new ArrayList<>();

        List<Map<String, String>> sheBeiTitleList = new ArrayList<>();
        List<String> sheBeiTitleSList = new ArrayList<>();

        List<Map<String, String>> hyTitleList = new ArrayList<>();
        List<String> hyTitleSList = new ArrayList<>();

        Map<String, Object> yunXingMap = new HashMap<>();
        Map<String, Object> sheBeiMap = new HashMap<>();
        Map<String, Object> hyMap = new HashMap<>();
        yunXingMap.put("title", yunXingTitleList);
        yunXingMap.put("data", yunXingList);
        sheBeiMap.put("title", sheBeiTitleList);
        sheBeiMap.put("data", sheBeiList);
        hyMap.put("title", hyTitleList);
        hyMap.put("data", hyList);
        mainMap.put("yunXingMap", yunXingMap);
        mainMap.put("sheBeiMap", sheBeiMap);
        mainMap.put("hyMap", hyMap);

        Map<String, List<TbDraftData>> dataMap = new LinkedHashMap<>();
        for (TbDraftData draftData : draftDataList) {
            String dateStr = DateUtils.formateDateFull(draftData.getDraftTime());
            if (dataMap.containsKey(dateStr)) {
                dataMap.get(dateStr).add(draftData);
            } else {
                List<TbDraftData> list = new ArrayList<>();
                dataMap.put(dateStr, list);
                list.add(draftData);
            }
        }

        for (Map.Entry<String, List<TbDraftData>> entry : dataMap.entrySet()) {

            Map<String, Object> yunXingMapDate = new HashMap<>();
            Map<String, Object> sheBeiMapDate = new HashMap<>();
            Map<String, Object> hyMapDate = new HashMap<>();
            yunXingMapDate.put("date", entry.getKey());
            sheBeiMapDate.put("date", entry.getKey());
            hyMapDate.put("date", entry.getKey());

            List<Map<String, Object>> yunXingDataList = new ArrayList<>();
            List<Map<String, Object>> sheBeiDataList = new ArrayList<>();
            List<Map<String, Object>> hyDataList = new ArrayList<>();
            yunXingMapDate.put("data", yunXingDataList);
            sheBeiMapDate.put("data", sheBeiDataList);
            hyMapDate.put("data", hyDataList);

            List<TbDraftData> list = entry.getValue();
            for (TbDraftData draftData : list) {
                Map<String, String> titleMap = new HashMap<>();
                titleMap.put("draftName", draftData.getDraftName());
                titleMap.put("dataField", draftData.getFillNo());
                titleMap.put("dataUnit", draftData.getDraftUnit());
                Map<String, Object> dtMap = new HashMap<>();
                dtMap.put("dataField", draftData.getFillNo());
                dtMap.put("value", draftData.getDraftValue());

                if (draftData.getDraftType().equals(1)) {
                    if (!yunXingTitleSList.contains(draftData.getFillNo())) {
                        yunXingTitleList.add(titleMap);
                        yunXingTitleSList.add(draftData.getFillNo());
                    }
                    yunXingDataList.add(dtMap);
                } else if (draftData.getDraftType().equals(2)) {
                    if (!sheBeiTitleSList.contains(draftData.getFillNo())) {
                        sheBeiTitleList.add(titleMap);
                        sheBeiTitleSList.add(draftData.getFillNo());
                    }
                    sheBeiDataList.add(dtMap);
                } else if (draftData.getDraftType().equals(3)) {
                    if (!hyTitleSList.contains(draftData.getFillNo())) {
                        hyTitleList.add(titleMap);
                        hyTitleSList.add(draftData.getFillNo());
                    }
                    hyDataList.add(dtMap);
                }

            }
            if (yunXingDataList.size() > 0) {
                yunXingList.add(yunXingMapDate);
            }
            if (sheBeiDataList.size() > 0) {
                sheBeiList.add(sheBeiMapDate);
            }
            if (hyDataList.size() > 0) {
                hyList.add(hyMapDate);
            }

        }
        return mainMap;
    }

    /**
     * 获取所有的填报字段 包含化验、巡检填报等
     *
     * @param factoryNo
     * @return
     */
    @Override
    public List<Map<String, String>> getFieldList(String factoryNo) {
        List<Map<String, String>> list = new ArrayList<>();
        TbFillFieldExample fillFieldExample = new TbFillFieldExample();
        fillFieldExample.createCriteria().andFactoryNoEqualTo(factoryNo);
        List<TbFillField> fillFields = fillFieldMapper.selectByExample(fillFieldExample);
        for (TbFillField fillField : fillFields) {
            Map<String, String> map = new HashMap<>();
            map.put("fieldName", fillField.getFieldName());
            map.put("fieldNo", fillField.getFieldNo());
            map.put("baseFieldNo", fillField.getBaseFieldNo());
            list.add(map);
        }
        TbRoutingLocationElementExample routingLocationElementExample = new TbRoutingLocationElementExample();
        routingLocationElementExample.createCriteria().andFactoryNoEqualTo(factoryNo).andElementTypeEqualTo(2);
        List<TbRoutingLocationElement> routingLocationElements = routingLocationElementMapper.selectByExample(routingLocationElementExample);
        for (TbRoutingLocationElement routingLocationElement : routingLocationElements) {
            Map<String, String> map = new HashMap<>();
            map.put("fieldName", routingLocationElement.getElementName());
            map.put("fieldNo", routingLocationElement.getLocationFieldNo());
            map.put("baseFieldNo", routingLocationElement.getFieldNo());
            list.add(map);
        }
        return list;
    }

    @Override
    public Map<String, Object> getDraftFieldList(String factoryNo) {
        Map<String, Object> mainMap = new HashMap<>();

        TbDraftDataExample draftDataExample = new TbDraftDataExample();
        Date startDate = DateUtils.getNextDate(new Date(), -30);
        draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeGreaterThanOrEqualTo(startDate);
        draftDataExample.setOrderByClause(" draft_time ");
        List<TbDraftData> draftDataList = draftDataMapper.selectByExample(draftDataExample);

        List<Map<String, Object>> runTimeMap = getFieldList(draftDataList, 1);
        List<Map<String, Object>> equipMap = getFieldList(draftDataList, 2);
        List<Map<String, Object>> analysisMap = getFieldList(draftDataList, 3);
        mainMap.put("runTimeInfo", runTimeMap);
        mainMap.put("equipInfo", equipMap);
        mainMap.put("analysisInfo", analysisMap);
        return mainMap;
    }

    /**
     * 统计某一类指标
     *
     * @param draftDataList
     * @param fieldType
     * @return
     */
    private List<Map<String, Object>> getFieldList(List<TbDraftData> draftDataList, int fieldType) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, String>> fieldList = new ArrayList<>();
        List<String> titleSList = new ArrayList<>();
        List<String> timePointList = new ArrayList<>();
        for (TbDraftData draftData : draftDataList) {
            if (!draftData.getDraftType().equals(fieldType)) {
                continue;
            }
            String draftTime = DateUtils.formateDateFull(draftData.getDraftTime());
            String timePoint = draftTime.substring(11, 16);
            if (!timePointList.contains(timePoint)) {
                timePointList.add(timePoint);
            }
            if (!titleSList.contains(draftData.getFillNo())) {
                titleSList.add(draftData.getFillNo());
                Map<String, String> fieldNode = new HashMap<>();
                fieldNode.put("fillNo", draftData.getFillNo());
                fieldNode.put("fillName", draftData.getDraftName());
                fieldList.add(fieldNode);
            }
        }
        for (int i = 0; i < fieldList.size(); i++) {
            if (i == 0) {
                Map<String, Object> dataMap = new HashMap<>(5);
                dataMap.put("value", "时间");
                dataMap.put("type", 0);
                dataMap.put("row", 0);
                dataMap.put("column", 0);
                list.add(dataMap);
            }
            Map<String, Object> titleMap = new HashMap<>(5);
            titleMap.put("value", fieldList.get(i).get("fillName"));
            titleMap.put("type", 0);
            titleMap.put("row", 0);
            titleMap.put("column", i + 1);
            list.add(titleMap);
        }
        Collections.sort(timePointList);
        for (int r = 0; r < timePointList.size(); r++) {
            Map<String, Object> timePointMap = new HashMap<>(5);
            timePointMap.put("value", timePointList.get(r));
            timePointMap.put("type", 0);
            timePointMap.put("row", r + 1);
            timePointMap.put("column", 0);
            list.add(timePointMap);
            for (int c = 0; c < fieldList.size(); c++) {
                Map<String, Object> fieldMap = new HashMap<>(8);
                String fillNo = fieldList.get(c).get("fillNo").toString();
                String timePoint = timePointList.get(r).toString();
                boolean hasValue = fieldHasValue(draftDataList, fillNo, timePoint, fieldType);
                fieldMap.put("fillName", fieldList.get(c).get("fillName"));
                fieldMap.put("value", hasValue ? "可选" : "-");
                fieldMap.put("hasValue", hasValue);
                fieldMap.put("type", 1);
                fieldMap.put("row", r + 1);
                fieldMap.put("column", c + 1);
                fieldMap.put("fillNo", fieldList.get(c).get("fillNo"));
                fieldMap.put("timePoint", timePointList.get(r));
                list.add(fieldMap);
            }
        }
        return list;
    }

    private boolean fieldHasValue(List<TbDraftData> draftDataList, String fillNo, String timePoint, int fieldType) {
        for (TbDraftData draftData : draftDataList) {
            if (!draftData.getDraftType().equals(fieldType)) {
                continue;
            }
            String draftTime = DateUtils.formateDateFull(draftData.getDraftTime());
            String currentTimePoint = draftTime.substring(11, 16);
            if (currentTimePoint.equals(timePoint) && draftData.getFillNo().equals(fillNo)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param routingTask
     * @return
     */
    @Override
    public int insertRoutingDraftData(TbRoutingTask routingTask) {
        try {
            List<TbParameterConfig> fieldList = parameterConfigMapper.selectByExample(new TbParameterConfigExample());
            TbRoutingTaskDetailExample routingTaskDetailExample = new TbRoutingTaskDetailExample();
            routingTaskDetailExample.createCriteria().andTaskNoEqualTo(routingTask.getTaskNo()).andElementTypeEqualTo(2);
            List<TbRoutingTaskDetail> routingTaskDetailList = routingTaskDetailMapper.selectByExample(routingTaskDetailExample);
            List<TbDraftData> draftDataList = new ArrayList<>(routingTaskDetailList.size());
            for (TbRoutingTaskDetail routingTaskDetail : routingTaskDetailList) {
                TbDraftData draftData = new TbDraftData();
                draftData.setDataFrom(routingTaskDetail.getTaskDetailNo());
                draftData.setDraftDate(DateUtils.formateDate(routingTask.getBeginTime()));
                draftData.setDraftName(routingTaskDetail.getElementName());
                draftData.setDraftNo(StringTools.getUUID());
                draftData.setDraftType(routingTask.getTaskType());
                draftData.setDraftTime(routingTask.getBeginTime());
                draftData.setDraftUnit(routingTaskDetail.getFieldUnit());
                draftData.setDraftValue(routingTaskDetail.getFillValue());
                draftData.setFillNo(routingTaskDetail.getElementNo());
                draftData.setFillTaskNo(routingTask.getTaskNo());
                TbParameterConfig parameterConfig = getField(fieldList, routingTaskDetail.getFieldNo());
                if (parameterConfig != null) {
                    draftData.setStaticType(parameterConfig.getParemMathType());
                    draftData.setFieldNo(parameterConfig.getParamNo());
                }
                draftData.setFactoryNo(routingTask.getFactoryNo());
                draftDataList.add(draftData);
            }
            if (draftDataList.size() > 0) {
                draftDataMapper.insertBatch(draftDataList);
            }
            //修改工单状态 设置为已经加入底稿
            routingTask.setDraftStatus(1);
            routingTaskMapper.updateByPrimaryKeySelective(routingTask);
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return 0;
    }

    @Override
    public int insertAnalysisDraftData(TbAnalysisFillTask analysisFillTask) {
        try {
            List<TbParameterConfig> fieldList = parameterConfigMapper.selectByExample(new TbParameterConfigExample());
            TbAnalysisFillDetailExample analysisFillDetailExample = new TbAnalysisFillDetailExample();
            analysisFillDetailExample.createCriteria().andTaskNoEqualTo(analysisFillTask.getFillTaskNo());
            List<TbAnalysisFillDetail> analysisFillDetailList = tbAnalysisFillDetailMapper.selectByExample(analysisFillDetailExample);
            List<TbDraftData> draftDataList = new ArrayList<>(analysisFillDetailList.size());
            for (TbAnalysisFillDetail analysisFillDetail : analysisFillDetailList) {
                TbDraftData draftData = new TbDraftData();
                draftData.setDataFrom(analysisFillDetail.getFillDetailNo());
                draftData.setDraftDate(DateUtils.formateDate(analysisFillTask.getFillTaskTime()));
                draftData.setDraftName(analysisFillDetail.getFieldName());
                draftData.setDraftNo(StringTools.getUUID());
                draftData.setDraftType(3);
                draftData.setDraftTime(analysisFillTask.getFillTaskTime());
                draftData.setDraftUnit(analysisFillDetail.getFieldUnit());
                draftData.setDraftValue(analysisFillDetail.getFieldValue());
                draftData.setFillNo(analysisFillDetail.getFieldNo());
                draftData.setFillTaskNo(analysisFillTask.getFillTaskNo());
                TbParameterConfig parameterConfig = getField(fieldList, analysisFillDetail.getBaseFieldNo());
                if (parameterConfig != null) {
                    draftData.setStaticType(parameterConfig.getParemMathType());
                    draftData.setFieldNo(parameterConfig.getParamNo());
                }
                draftData.setFactoryNo(analysisFillTask.getFactoryNo());
                draftDataList.add(draftData);
            }
            draftDataMapper.insertBatch(draftDataList);
            //修改工单状态 设置为已经加入底稿
            analysisFillTask.setDraftStatus(1);
            analysisFillTaskMapper.updateByPrimaryKeySelective(analysisFillTask);
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return 0;
    }

    /**
     * 插入化验数据
     *
     * @param factoryNo
     * @param fieldList
     */
    private void addAnalysisData(String factoryNo, List<TbParameterConfig> fieldList) {
        TbAnalysisFillTaskExample analysisFillTaskExample = new TbAnalysisFillTaskExample();
        analysisFillTaskExample.createCriteria().andStatusEqualTo(2).andDraftStatusEqualTo(0).andFactoryNoEqualTo(factoryNo);

        List<TbAnalysisFillTask> analysisFillTaskList = analysisFillTaskMapper.selectByExample(analysisFillTaskExample);
        for (TbAnalysisFillTask analysisFillTask : analysisFillTaskList) {
            //先清除现有数据  防止有些数据已经被修改过
            TbDraftDataExample draftDataExample = new TbDraftDataExample();
            draftDataExample.createCriteria().andFillTaskNoEqualTo(analysisFillTask.getFillTaskNo());
            draftDataMapper.deleteByExample(draftDataExample);

            TbAnalysisFillDetailExample analysisFillDetailExample = new TbAnalysisFillDetailExample();
            analysisFillDetailExample.createCriteria().andTaskNoEqualTo(analysisFillTask.getFillTaskNo());
            List<TbAnalysisFillDetail> analysisFillDetailList = tbAnalysisFillDetailMapper.selectByExample(analysisFillDetailExample);
            List<TbDraftData> draftDataList = new ArrayList<>(analysisFillDetailList.size());
            for (TbAnalysisFillDetail analysisFillDetail : analysisFillDetailList) {
                TbDraftData draftData = new TbDraftData();
                draftData.setDataFrom(analysisFillDetail.getFillDetailNo());
                draftData.setDraftDate(DateUtils.formateDate(analysisFillTask.getFillTaskTime()));
                draftData.setDraftName(analysisFillDetail.getFieldName());
                draftData.setDraftNo(StringTools.getUUID());
                draftData.setDraftType(3);
                draftData.setDraftTime(analysisFillTask.getFillTaskTime());
                draftData.setDraftUnit(analysisFillDetail.getFieldUnit());
                draftData.setDraftValue(analysisFillDetail.getFieldValue());
                draftData.setFillNo(analysisFillDetail.getFieldNo());
                draftData.setFillTaskNo(analysisFillTask.getFillTaskNo());
                TbParameterConfig parameterConfig = getField(fieldList, analysisFillDetail.getBaseFieldNo());
                if (parameterConfig != null) {
                    draftData.setStaticType(parameterConfig.getParemMathType());
                    draftData.setFieldNo(parameterConfig.getParamNo());
                }
                draftData.setFactoryNo(analysisFillTask.getFactoryNo());
                draftDataList.add(draftData);
            }
            draftDataMapper.insertBatch(draftDataList);
            //修改工单状态 设置为已经加入底稿
            analysisFillTask.setDraftStatus(1);
            analysisFillTaskMapper.updateByPrimaryKeySelective(analysisFillTask);
        }
    }

    /**
     * 插入巡检填报数据
     *
     * @param factoryNo
     * @param fieldList
     */
    private void addRoutingFillData(String factoryNo, List<TbParameterConfig> fieldList) {

        TbRoutingTaskExample routingTaskExample = new TbRoutingTaskExample();
        routingTaskExample.createCriteria().andTaskStatusEqualTo(2).andDraftStatusEqualTo(0).andFactoryNoEqualTo(factoryNo);
        List<TbRoutingTask> routingTaskList = routingTaskMapper.selectByExample(routingTaskExample);

        for (TbRoutingTask routingTask : routingTaskList) {
            //先清除现有数据  防止有些数据已经被修改过
            TbDraftDataExample draftDataExample = new TbDraftDataExample();
            draftDataExample.createCriteria().andFillTaskNoEqualTo(routingTask.getTaskNo());
            draftDataMapper.deleteByExample(draftDataExample);

            TbRoutingTaskDetailExample routingTaskDetailExample = new TbRoutingTaskDetailExample();
            routingTaskDetailExample.createCriteria().andTaskNoEqualTo(routingTask.getTaskNo()).andElementTypeEqualTo(2);
            List<TbRoutingTaskDetail> routingTaskDetailList = routingTaskDetailMapper.selectByExample(routingTaskDetailExample);
            List<TbDraftData> draftDataList = new ArrayList<>(routingTaskDetailList.size());
            for (TbRoutingTaskDetail routingTaskDetail : routingTaskDetailList) {
                TbDraftData draftData = new TbDraftData();
                draftData.setDataFrom(routingTaskDetail.getTaskDetailNo());
                draftData.setDraftDate(DateUtils.formateDate(routingTask.getBeginTime()));
                draftData.setDraftName(routingTaskDetail.getElementName());
                draftData.setDraftNo(StringTools.getUUID());
                draftData.setDraftType(routingTask.getTaskType());

                draftData.setDraftTime(routingTask.getBeginTime());
                draftData.setDraftUnit(routingTaskDetail.getFieldUnit());
                draftData.setDraftValue(routingTaskDetail.getFillValue());
                draftData.setFillNo(routingTaskDetail.getElementNo());
                draftData.setFillTaskNo(routingTask.getTaskNo());
                TbParameterConfig parameterConfig = getField(fieldList, routingTaskDetail.getFieldNo());
                if (parameterConfig != null) {
                    draftData.setStaticType(parameterConfig.getParemMathType());
                    draftData.setFieldNo(parameterConfig.getParamNo());
                }
                draftData.setFactoryNo(routingTask.getFactoryNo());
                draftDataList.add(draftData);
            }
            if (draftDataList.size() > 0) {
                draftDataMapper.insertBatch(draftDataList);
            }
            //修改工单状态 设置为已经加入底稿
            routingTask.setDraftStatus(1);
            routingTaskMapper.updateByPrimaryKeySelective(routingTask);
        }
    }

    private TbParameterConfig getField(List<TbParameterConfig> fieldList, String fieldNo) {
        for (TbParameterConfig field : fieldList) {
            if (field.getParamNo().equals(fieldNo)) {
                return field;
            }
        }
        return null;
    }

    /**
     * 插入日报报表数据
     *
     * @param factoryNo
     * @return
     */
    @Override
    public int insertReportDate(String factoryNo) {
        //获取最后的日结日期
        TbReportDate reportDate = reportDateMapper.getLastReportDate(factoryNo);
        TbDraftDataExample draftDataExample = new TbDraftDataExample();
        List<String> dateList = new ArrayList<>();
        if (reportDate == null) {
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo);
        } else {
            Date startDate = reportDate.getDrDate();
            Date endDate = DateUtils.getNextDate(new Date(), 0);
            dateList = DateUtils.getDistDayList(DateUtils.getNextDate(startDate, 1), DateUtils.getNextDate(new Date(), -1));
            draftDataExample.createCriteria().andFactoryNoEqualTo(factoryNo).andDraftTimeGreaterThanOrEqualTo(startDate).andDraftTimeLessThan(endDate);
        }

        draftDataExample.setOrderByClause(" draft_time ");
        List<TbDraftData> draftDataList = draftDataMapper.selectByExample(draftDataExample);
        Map<String, Map<String, List<TbDraftData>>> dataMap = new HashMap<>();

        for (TbDraftData draftData : draftDataList) {
            String date = draftData.getDraftDate();
            if (dataMap.containsKey(draftData.getFillNo())) {
                Map<String, List<TbDraftData>> dateMap = dataMap.get(draftData.getFillNo());
                if (!dateMap.containsKey(date)) {
                    List<TbDraftData> list = new ArrayList<>();
                    dateMap.put(date, list);
                    list.add(draftData);
                } else {
                    dateMap.get(date).add(draftData);
                }

            } else {
                Map<String, List<TbDraftData>> dateMap = new HashMap<>();
                List<TbDraftData> list = new ArrayList<>();
                list.add(draftData);
                dateMap.put(date, list);
                dataMap.put(draftData.getFillNo(), dateMap);
            }
            if (reportDate == null) {
                if (!dateList.contains(date)) {
                    dateList.add(date);
                }
            }
        }
        for (String date : dateList) {
//            if(dataMap.containsKey(date)){
            getReportDate(date, dataMap);
//            }

        }
        return 0;
    }

    private void getReportDate(String date, Map<String, Map<String, List<TbDraftData>>> dataMap) {
        String lastDate = DateUtils.formateDate(DateUtils.getNextDate(date, -1));
        List<TbReportDate> reportDateList = new ArrayList<>();
        for (Map.Entry<String, Map<String, List<TbDraftData>>> entry : dataMap.entrySet()) {
            TbReportDate reportDate = new TbReportDate();
            reportDate.setDrDate(DateUtils.parseDate(date));
            reportDate.setDrNo(StringTools.getUUID());
            Map<String, List<TbDraftData>> map = entry.getValue();
            List<TbDraftData> list = map.get(date);

            if (list == null || list.size() == 0) {
                continue;
            }
            reportDate.setDrDisplayName(list.get(0).getDraftName());
            reportDate.setDrBrowseName(list.get(0).getDraftName());
            reportDate.setDrUnit(list.get(0).getDraftUnit());
            reportDate.setDrCreateTime(new Date());
            reportDate.setDrDataType(list.get(0).getDraftType());
            reportDate.setDrFactoryNo(list.get(0).getFactoryNo());
            reportDate.setDrFillNo(list.get(0).getFillNo());
            List<TbDraftData> lastList = map.get(lastDate);
            int staticType = list.get(0).getStaticType() == null ? 1 : list.get(0).getStaticType();
            Double value = getReportData(list, lastList, staticType);
            reportDate.setDrValue(value.floatValue());
            reportDateList.add(reportDate);
        }
        if (reportDateList.size() > 0) {
            reportDateMapper.insertBatch(reportDateList);
        }

    }

    /**
     * 单个填报要素按日统计
     *
     * @param list
     * @param lastList
     * @param staticType
     * @return
     */
    private double getReportData(List<TbDraftData> list, List<TbDraftData> lastList, int staticType) {
        //求和
        if (staticType == 0) {
            double value = 0;
            for (TbDraftData draftData : list) {
                if (draftData == null || draftData.getDraftValue() == null) {
                    continue;
                }
                value += draftData.getDraftValue();
            }
            return value;
        } else if (staticType == 1) {
            //累进制
            if (lastList != null) {
                return list.get(0).getDraftValue() - lastList.get(0).getDraftValue();
            } else {
                return 0;
            }
        } else if (staticType == 2) {
            //平均值
            double value = 0;
            for (TbDraftData draftData : list) {
                if (draftData == null || draftData.getDraftValue() == null) {
                    continue;
                }
                value += draftData.getDraftValue();
            }
            return value / list.size();
        } else if (staticType == 3) {
            //合计
            double value = Double.MIN_VALUE;
            for (TbDraftData draftData : list) {
                if (draftData == null || draftData.getDraftValue() == null) {
                    continue;
                }
                if (value < draftData.getDraftValue()) {
                    value = draftData.getDraftValue();
                }
            }
            return value;
        } else if (staticType == 4) {
            //累进制
            double value = Double.MAX_VALUE;
            for (TbDraftData draftData : list) {
                if (draftData == null || draftData.getDraftValue() == null) {
                    continue;
                }
                if (value > draftData.getDraftValue()) {
                    value = draftData.getDraftValue();
                }
            }
            return value;
        }
        return 0;
    }

    @Override
    public List<TbParameterConfig> getFieldList() {
        return parameterConfigMapper.selectByExample(new TbParameterConfigExample());
    }


    @Override
    public int selectReportDayWeekDate(String factoryNo) {
        int flag = 0;
        //上周日
        String sunDay = DateUtils.formateDate(DateUtils.getNextDate(new Date(), -1));
        //上周一
        String monDay = DateUtils.formateDate(DateUtils.getNextDate(new Date(), -7));
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate(monDay,sunDay,factoryNo);
        Map<String, Object> draftDataList = getDraftDataList(factoryNo, DateUtils.parseDate(monDay), DateUtils.parseDate(sunDay));
        if (draftDataList != null && draftDataList.size() > 0) {
            String fileName = DateUtils.formateDate("yyyyMMddHHmmss") + ".xlsx";
            flag = 1;
            XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
            Map yunXingMap = (Map) draftDataList.get("yunXingMap");
            if (yunXingMap != null && yunXingMap.size() > 0) {
                try {
                    createSheet(hssfWorkbook, "运行填报数据底稿", yunXingMap, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Map sheBeiMap = (Map) draftDataList.get("sheBeiMap");
            if (sheBeiMap != null && sheBeiMap.size() > 0) {
                try {
                    createSheet(hssfWorkbook, "设备填报数据底稿", sheBeiMap, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Map hyMap = (Map) draftDataList.get("hyMap");
            if (hyMap != null && hyMap.size() > 0) {

                try {
                    createSheet(hssfWorkbook, "化验填报数据底稿", hyMap, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    /*public void testBaseWrite(Map<String, Object> draftDataList) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("sheetName");
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        Row titleRow = sheet.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);
        Row titleRow2 = sheet.createRow(1);
        //Map<String, Object> draftDataList = reportService.getDraftDataList("5d81bd3194e57500078c2ac1", DateUtils.parseDate("2019-11-15"), DateUtils.parseDate("2019-11-19"));
        *//*System.out.println(JSON.toJSON(draftDataList));
        System.out.println(JSON.toJSONString(draftDataList.get("hyMap")));*//*

        //Map hyMap = (Map) draftDataList.get("hyMap");
        Map yunXingMap = (Map) draftDataList.get("yunXingMap");

        Map sheBeiMap = (Map) draftDataList.get("sheBeiMap");

        Map hyMap = (Map) draftDataList.get("hyMap");
        List<Map<String, Object>> data = (List<Map<String, Object>>) hyMap.get("data");
        List<Map<String, Object>> title = (List<Map<String, Object>>)hyMap.get("title");
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
//        titleRow.createCell(0).setCellValue("时间");
        Cell cell = titleRow.createCell(0);

        cell.setCellValue("时间");
        cell.setCellStyle(style);
        Map map =new HashMap(16);
        sheet.setColumnWidth(0, 100 * 60);

        for (int j = 0; j < title.size(); j++) {
            map.put(j + 1,title.get(j).get("dataField").toString());
            Cell cellName = titleRow.createCell(j + 1);
            cellName.setCellStyle(style);
            cellName.setCellValue(title.get(j).get("draftName").toString());
            Cell cellUnit = titleRow2.createCell(j + 1);
            cellUnit.setCellStyle(style);
            cellUnit.setCellValue(title.get(j).get("dataUnit").toString());
            //titleRow2.createCell(j ).setCellValue(title.get(j).get("dataUnit").toString());
            sheet.setColumnWidth(j + 1,  100 * 60);
        }

        for (int j = 0; j < data.size(); j++) {
            Row tempRow = sheet.createRow(j + 2);
            Cell cellDate = tempRow.createCell(0);
            cellDate.setCellStyle(style);
            cellDate.setCellValue(data.get(j).get("date").toString());
            List<Map<String, Object>> tempArray = (List<Map<String, Object>>)data.get(j).get("data");
            for (int k = 0; k < map.keySet().size(); k++) {
                String tempKey = map.get(k + 1).toString();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).get("dataField").toString().equals(tempKey)) {
                        if (tempArray.get(i).get("value") != null) {
                            tempRow.createCell(k + 1).setCellValue(tempArray.get(i).get("value").toString());
                        } else {
                            tempRow.createCell(k + 1).setCellValue("");
                        }
                        continue;
                    }
                }
            }
            //titleRow2.createCell(j ).setCellValue(tbDraftData.get(j ).getDraftUnit());
        }
        File file = new File("D:\\test11111.xls");
        hssfWorkbook.write(new FileOutputStream(file));
    }*/
    public void createSheet(XSSFWorkbook hssfWorkbook, String sheetTitle, Map hyMap, String fileName) throws IOException {
        XSSFSheet sheet = hssfWorkbook.createSheet(sheetTitle);
        XSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        //设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        Row titleRow = sheet.createRow(0);
        CellRangeAddress region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);
        Row titleRow2 = sheet.createRow(1);
        List<Map<String, Object>> data = (List<Map<String, Object>>) hyMap.get("data");
        List<Map<String, Object>> title = (List<Map<String, Object>>) hyMap.get("title");
        //List<TbDraftData> tbDraftData = draftDataMapper.selectReportDayWeekDate("2019-11-15","2019-11-19","5d81bd3194e57500078c2ac1");
//        titleRow.createCell(0).setCellValue("时间");
        Cell cell = titleRow.createCell(0);

        cell.setCellValue("时间");
        cell.setCellStyle(style);
        Map map = new HashMap(16);
        sheet.setColumnWidth(0, 100 * 60);

        for (int j = 0; j < title.size(); j++) {
            map.put(j + 1, title.get(j).get("dataField").toString());
            Cell cellName = titleRow.createCell(j + 1);
            cellName.setCellStyle(style);
            cellName.setCellValue(title.get(j).get("draftName").toString());
            Cell cellUnit = titleRow2.createCell(j + 1);
            cellUnit.setCellStyle(style);
            cellUnit.setCellValue(title.get(j).get("dataUnit") != null ? title.get(j).get("dataUnit").toString() : "");
            //titleRow2.createCell(j ).setCellValue(title.get(j).get("dataUnit").toString());
            sheet.setColumnWidth(j + 1, 100 * 60);
        }
        for (int j = 0; j < data.size(); j++) {
            Row tempRow = sheet.createRow(j + 2);
            Cell cellDate = tempRow.createCell(0);
            cellDate.setCellStyle(style);
            cellDate.setCellValue(data.get(j).get("date").toString());
            List<Map<String, Object>> tempArray = (List<Map<String, Object>>) data.get(j).get("data");
            for (int k = 0; k < map.keySet().size(); k++) {
                String tempKey = map.get(k + 1).toString();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).get("dataField").toString().equals(tempKey)) {
                        if (tempArray.get(i).get("value") != null) {
                            tempRow.createCell(k + 1).setCellValue(tempArray.get(i).get("value").toString());
                        } else {
                            tempRow.createCell(k + 1).setCellValue("");
                        }
                        continue;
                    }
                }
            }
        }
        File file = new File(filePath + fileName);
        hssfWorkbook.write(new FileOutputStream(file));
    }

    @Override
    public int saveSynReportDate(String factoryNo, Date date) throws Exception {
        int flag = 0;
        //获取当前时间的前一天
        List<Map<String, String>> list = getReportModelExtendDetailDate(date, factoryNo);
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        tbFactoryInfo.setFactoryNo(factoryNo);
        List<TbFactoryInfo> factoryList = tbFactoryService.getTbFactoryInfoList(tbFactoryInfo);
        if (list != null && list.size() > 0) {
            for (TbFactoryInfo factoryInfoEntity : factoryList) {
                //String factoryNo = factoryInfoEntity.getFactoryNo();
                String factoryCode = factoryInfoEntity.getFactoryCode() + "tb";
                List<String> weekDayList = new ArrayList<>();
                weekDayList.add(DateUtils.formateDate(date));
                //8、周报处理水量填报表
                WeeklyClslEntity weeklyClsl = new WeeklyClslEntity();
                weeklyClsl.setUSERID(factoryCode);
                // 9、周报生产电量填报
                WeeklyScdlEntity weeklyScdl = new WeeklyScdlEntity();
                weeklyScdl.setUSERID(factoryCode);
                //11、周报水质指标填报
                WeeklySzzbEntity weeklySzzb = new WeeklySzzbEntity();
                weeklySzzb.setUSERID(factoryCode);
                // 12、周报污泥60%填报
                WeeklyWn60Entity weeklyWn60 = new WeeklyWn60Entity();
                weeklyWn60.setUSERID(factoryCode);
                // 13、周报污泥80%填报
                WeeklyWn80Entity weeklyWn80 = new WeeklyWn80Entity();
                weeklyWn80.setUSERID(factoryCode);
                for (int i = 0; i < weekDayList.size(); i++) {
                    String key = weekDayList.get(i);
                    if (list != null && list.size() > 0) {
                        weeklyClsl = setValue(weeklyClsl, key, list);
                        weeklyScdl = setValue(weeklyScdl, key, list);
                        weeklySzzb = setValue(weeklySzzb, key, list);
                        weeklyWn60 = setValue(weeklyWn60, key, list);
                        weeklyWn80 = setValue(weeklyWn80, key, list);
                    }
                }
                flag = 1;
                JSONObject resultSl = apiSyncService.setWeeklyClsl(weeklyClsl,date);
                logger.info("8、周报处理水量填报表：resultSl={}" + resultSl.toString());

                JSONObject resultDl = apiSyncService.setWeeklyScdl(weeklyScdl,date);
                logger.info("9、周报生产电量填报：resultDl={}" + resultDl.toString());

                JSONObject resultSz = apiSyncService.setWeeklySzzb(weeklySzzb,date);
                logger.info("11、周报水质指标填报：resultSz={}" + resultSz.toString());

                JSONObject resultWn60 = apiSyncService.setWeeklyWn60(weeklyWn60,date);
                logger.info("12、周报污泥60%填报：resultWn60={}" + resultWn60.toString());

                JSONObject resultWn80 = apiSyncService.setWeeklyWn80(weeklyWn80,date);
                logger.info("13、周报污泥80%填报：resultWn80+{}" + resultWn80.toString());
            }
        }
        return flag;
    }

    /**
     * 实体设置值
     * wjl
     */
    public <T> T setValue(T entity, String key, List<Map<String, String>> list) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            String modelType = "";
            if (DateUtils.getDateOfWeek(key) == 1) {
                modelType = "Mon";
                if (field.getName().contains("MonDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("MonWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期一"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 2) {
                modelType = "Tues";
                if (field.getName().contains("TuesDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("TuesWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期二"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 3) {
                modelType = "Wed";
                if (field.getName().contains("WedDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("WedWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期三"));
                }

            } else if (DateUtils.getDateOfWeek(key) == 4) {
                if (field.getName().contains("ThurDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("ThurWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期四"));
                }
                modelType = "Thur";
            } else if (DateUtils.getDateOfWeek(key) == 5) {
                modelType = "Fri";
                if (field.getName().contains("FriDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("FriWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期五"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 6) {
                modelType = "Sat";
                if (field.getName().contains("SatDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("SatWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期六"));
                }
            } else if (DateUtils.getDateOfWeek(key) == 0) {
                modelType = "Sun";
                if (field.getName().contains("SunDate")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf(key));
                }
                if (field.getName().contains("SunWeekDay")) {
                    field.setAccessible(true);
                    field.set(entity, String.valueOf("星期日"));
                }
            }
            if (field.getName().startsWith(modelType)) {
                String keyName = field.getName().substring(modelType.length());
                for (int index = 0; index < list.size(); index++) {
                    if (list.get(index).get("code").equals(keyName)) {
                        field.setAccessible(true);
                        field.set(entity, String.valueOf((list.get(index).get("value"))));
                    }
                }
            }
            if (field.getName().contains("BusinessDate")) {
                field.setAccessible(true);
                field.set(entity, String.valueOf(DateUtils.formateDatePartNo(new Date())));
            }
        }
        return entity;
    }


}

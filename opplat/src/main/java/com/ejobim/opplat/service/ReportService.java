package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 报表类
 */
public interface ReportService {
    int addDateReport(TbReportDate reportDate);

    List<TbReportDate> getTbReportDateList(String factoryNo, Date startDate, Date endDate);

    Map<String,List<TbReportDate>> getReportDateListByModel(String factoryNo, Date startDate, Date endDate, String extendRmNo) throws IllegalAccessException, IntrospectionException, InvocationTargetException;

    List<TbReportModel> getReportModelList(TbReportModel reportModel);

    int addReportModel(TbReportModel reportModel, TbUser tbUser);

    int deleteReportModel(String  rmNo);

    List<TbReportModelExtend> getReportModelExtendList(TbReportModelExtend reportModel,Integer type,Date beginDate,Date endDate);

    List<TbReportModelExtend> getReportModelExtendDetailList(TbReportModelExtend reportModel,Integer type,Date beginDate,Date endDate,String factoryNo,String parentFactoryNo);

    List<Map<String,String>> getReportModelExtendDetailDate(Date staticDate,String factoryNo);

    int addReportModelExtend(TbReportModelExtend reportModelExtend, TbUser tbUser);

    int addReportModelExtendDetail(TbReportModelExtend reportModelExtend, TbUser tbUser);

    int deleteReportModelExtend(TbReportModelExtend tbReportModelExtend);

    int updateModelMathCmd(TbReportModelExtend tbReportModelExtend);

    int updateReportModelMathCmd(TbReportModelExtendDetail reportModelExtendDetail);

    int saveReportDateRecord(String factoryNo,String startDate,String endDate,String extendRmNo) throws IllegalAccessException, IntrospectionException, InvocationTargetException;

    Map<String,Object> getDraftDataList(String factoryNo,Date startDate,Date endDate);

    List<Map<String,String>> getFieldList(String factoryNo);

    Map<String,Object> getDraftFieldList(String factoryNo);

    int insertRoutingDraftData(TbRoutingTask routingTask);

    int insertAnalysisDraftData(TbAnalysisFillTask analysisFillTask);

    int insertReportDate(String factoryNo);

    List<TbParameterConfig> getFieldList();

    /**
     * 一周填报数据的定时任务
     */
    int selectReportDayWeekDate(String factoryNo);

    /**
     * 同步数据到报表系统
     * @param factoryNo
     * @return
     */
    int saveSynReportDate(String factoryNo,Date date) throws Exception;
}

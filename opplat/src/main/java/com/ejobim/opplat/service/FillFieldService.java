package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbFillFormDetail;
import com.ejobim.opplat.domain.TbFillFormField;
import com.ejobim.opplat.domain.TbReportDate;
import com.ejobim.opplat.domain.TbSynObject;

import java.util.List;

public interface FillFieldService {
    /**
     * 根据厂区的配置创建填报字段模型
     * @param factoryNo
     */
    void createFieldFromConfig(String factoryNo);

    List<TbSynObject> getTbSynObject(TbSynObject synObject);

    List<TbFillFormField> getFillFieldList(TbFillFormField tbFillFormField);

    /**
     *
     * @param factoryNo startDate endDate
     * @return
     */
    List<TbFillFormDetail> getFillDetailList(String factoryNo,String startDate,String endDate);

    /**
     * 获取水厂的日报表
     * @param date
     * @param factoryNo
     * @return
     */
    List<TbReportDate> getReportDate(String date,String factoryNo);

    int addReportDateList(List<TbReportDate> list);

    List<TbFillFormField> selectFillFieldList(TbFillFormField tbFillFormField);
}

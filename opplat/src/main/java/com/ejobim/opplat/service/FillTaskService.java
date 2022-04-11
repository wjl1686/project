package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbAnalysisFillDetail;
import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbFillField;
import com.ejobim.opplat.domain.TbUser;

import javax.swing.plaf.ToolBarUI;
import java.util.Date;
import java.util.List;

public interface FillTaskService {

    /**
     * 查询填报字段列表
     * @param fillField
     * @return
     */
    List<TbFillField> getFillFieldList(TbFillField fillField);

    /**
     * 新增填报字段
     * @param fillField
     * @param user
     * @return
     */
    int addFillField(TbFillField fillField, TbUser user);

    /**
     * 更新填报字段
     * @param fillField
     * @param user
     * @return
     */
    int updateFillField(TbFillField fillField, TbUser user);

    int changeFillFieldStatus(TbFillField fillField, TbUser user);

    /**
     * 获取化验工单
     * @param tbAnalysisFillTask
     * @return
     */
    List<TbAnalysisFillTask> getAnalysisTaskList(TbAnalysisFillTask tbAnalysisFillTask, Date beginDate, Date endDate,String getFill);

    /**
     * 新增化验工单
     * @param factoryNo
     * @return
     */
    int addTbAnalysisFillTask(String factoryNo,Date taskDate,TbUser user);

    /**
     * 更新化验工单
     * @param tbAnalysisFillTask
     * @return
     */
    int updateTbAnalysisFillTask(TbAnalysisFillTask tbAnalysisFillTask);


    List<TbAnalysisFillDetail> getAnalysisTaskDetailList(String fillTaskNo);

    int saveAnalysisTaskDetailList(List<TbAnalysisFillDetail> list);

}

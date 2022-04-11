package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.FillTaskService;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 填报字段及工单管理类
 *
 * @author xibian
 */
@Service
public class FillTaskServiceImpl implements FillTaskService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TbFillFieldMapper fillFieldMapper;
    @Autowired
    TbAnalysisFillTaskMapper analysisFillTaskMapper;
    @Autowired
    TbAnalysisFillDetailMapper analysisFillDetailMapper;
    @Autowired
    TbParameterConfigMapper parameterConfigMapper;
    @Autowired
    TbFactoryInfoMapper factoryInfoMapper;

    @Autowired
    ReportService reportService;

    @Override
    public List<TbFillField> getFillFieldList(TbFillField fillField) {
        TbFillFieldExample example = new TbFillFieldExample();
        TbFillFieldExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(fillField.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(fillField.getFactoryNo());
        }
        if (fillField.getFieldType() != null) {
            criteria.andFieldTypeEqualTo(fillField.getFieldType());
        }
        if (StringUtils.isNotEmpty(fillField.getFieldName())) {
            criteria.andFieldNameLike('%' + fillField.getFieldName() + "%");
        }
        //状态查询条件
        if (fillField.getFieldStatus() != null) {
            criteria.andFieldStatusEqualTo(fillField.getFieldStatus());
        }
        List<TbFillField> list = fillFieldMapper.selectByExample(example);
        if (list.size() > 0) {
            List<String> noList = list.stream().map(TbFillField::getBaseFieldNo).collect(Collectors.toList());
            getFieldBaseInfo(list, noList);
        }
        return list;
    }

    /**
     * 通过关联的指标id获取填报项的指标
     *
     * @param list
     * @param noList
     */
    private void getFieldBaseInfo(List<TbFillField> list, List<String> noList) {
        TbParameterConfigExample example = new TbParameterConfigExample();
        TbParameterConfigExample.Criteria criteria = example.createCriteria();
        criteria.andParamNoIn(noList);
        List<TbParameterConfig> baseList = parameterConfigMapper.selectByExample(example);
        for (TbFillField fillField : list) {
            for (TbParameterConfig parameterConfig : baseList) {
                if (fillField.getBaseFieldNo().equals(parameterConfig.getParamNo())) {
                    fillField.setParameterConfig(parameterConfig);
                }
            }
        }
    }


    @Override
    public int addFillField(TbFillField fillField, TbUser user) {
        int flag = 0;
        try {
            List<TbFillField> checkFillFieldList = getCheckFillFieldList(fillField);
            if (checkFillFieldList != null && checkFillFieldList.size() > 0) {
                flag = Dict.AjaxStatus.NAME_EXIST.getStatusCode();
            } else {
                fillField.setCreateUserCode(user.getCode());
                fillField.setCreateUserName(user.getName());
                fillField.setFieldNo(StringTools.getUUID());
                fillField.setFieldStatus(Dict.dataStatus.YES.getCode());
                flag = fillFieldMapper.insertSelective(fillField);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
            flag = Dict.AjaxStatus.FAIL.getStatusCode();
        }
        return flag;
    }

    public List<TbFillField> getCheckFillFieldList(TbFillField fillField) {
        TbFillFieldExample example = new TbFillFieldExample();
        TbFillFieldExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(fillField.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(fillField.getFactoryNo());
        }
        if (StringUtils.isNotEmpty(fillField.getFieldName())) {
            criteria.andFieldNameEqualTo(fillField.getFieldName());
        }
        List<TbFillField> list = fillFieldMapper.selectByExample(example);
        return list;
    }

    @Override
    public int updateFillField(TbFillField fillField, TbUser user) {
        int flag = 0;
        List<TbFillField> checkFillFieldList = getCheckFillFieldList(fillField);
        for (int i = checkFillFieldList.size() - 1; i >= 0; i--) {
            if (checkFillFieldList.get(i).getFieldNo().equals(fillField.getFieldNo())) {
                checkFillFieldList.remove(i);
            }
        }
        if (checkFillFieldList != null && checkFillFieldList.size() > 0) {
            flag = Dict.AjaxStatus.NAME_EXIST.getStatusCode();
            // }
        } else {
            //修改记录没有存在过
            fillField.setUpdateUserCode(user.getCode());
            fillField.setUpdateUserName(user.getName());
            flag = fillFieldMapper.updateByPrimaryKeySelective(fillField);
        }
        return flag;
    }


    @Override
    public int changeFillFieldStatus(TbFillField fillField, TbUser user) {

        int flag = fillFieldMapper.updateByPrimaryKeySelective(fillField);

        return flag;
    }

    @Override
    public List<TbAnalysisFillTask> getAnalysisTaskList(TbAnalysisFillTask tbAnalysisFillTask, Date beginDate, Date endDate, String getFill) {
        TbAnalysisFillTaskExample example = new TbAnalysisFillTaskExample();
        TbAnalysisFillTaskExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tbAnalysisFillTask.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(tbAnalysisFillTask.getFactoryNo());
        }
        if(tbAnalysisFillTask.getFillTaskTime()==null){
            if (beginDate != null && endDate != null) {
                criteria.andFillTaskTimeBetween(beginDate, endDate);
            } else if (beginDate != null) {
                criteria.andFillTaskTimeGreaterThanOrEqualTo(beginDate);
            } else if (endDate != null) {
                criteria.andFillTaskTimeLessThanOrEqualTo(endDate);
            }
        }else{
            criteria.andFillTaskTimeEqualTo(tbAnalysisFillTask.getFillTaskTime());
        }
        if (tbAnalysisFillTask.getStatus() != null) {
            criteria.andStatusEqualTo(tbAnalysisFillTask.getStatus());
        }
        if (StringUtils.isNotEmpty(getFill)) {
            criteria.andStatusLessThan(2);
        }
        example.setOrderByClause(" fill_task_time desc");
        return analysisFillTaskMapper.selectByExample(example);
    }

    public List<TbAnalysisFillTask>  getOldAnalysisTask(String factoryNo, Date taskDate) {
        TbAnalysisFillTaskExample example = new TbAnalysisFillTaskExample();
        example.createCriteria().andFactoryNoEqualTo(factoryNo).andFillTaskTimeEqualTo(taskDate);
        return analysisFillTaskMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addTbAnalysisFillTask(String factoryNo, Date taskDate, TbUser user) {
        List<TbAnalysisFillTask> oldList  = getOldAnalysisTask(factoryNo,taskDate);
        if(oldList.size()>0){
            return Dict.AjaxStatus.RE_CREATE.getStatusCode();
        }
        try {
            TbFillField fillFieldSearch = new TbFillField();
            fillFieldSearch.setFactoryNo(factoryNo);
            fillFieldSearch.setFieldStatus(Dict.dataStatus.YES.getCode());
            List<TbFillField> tbFillFieldList = getFillFieldList(fillFieldSearch);
            TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
            TbAnalysisFillTask analysisFillTask = new TbAnalysisFillTask();
            analysisFillTask.setCreateUserCode(user.getCode());
            analysisFillTask.setCreateUserName(user.getName());
            analysisFillTask.setFactoryNo(factoryNo);
            analysisFillTask.setFillCount(0);
            analysisFillTask.setFillTaskCode("HY_" + factoryInfo.getFactoryCode() + DateUtils.formateMyDate(taskDate, "yyyyMMdd"));
            analysisFillTask.setFillCountAll(tbFillFieldList.size());
            String taskNo = StringTools.getUUID();
            analysisFillTask.setFillTaskNo(taskNo);
            analysisFillTask.setCreateTime(new Date());
            analysisFillTask.setFillTaskTime(taskDate);
            analysisFillTask.setStatus(0);
            analysisFillTaskMapper.insertSelective(analysisFillTask);
            List<TbAnalysisFillDetail> analysisFillDetailList = new ArrayList<>();
            for (int i = 0; i < tbFillFieldList.size(); i++) {
                analysisFillDetailList.add(newTaskDetail(tbFillFieldList.get(i), taskNo, user));
            }
            analysisFillDetailMapper.insertBatch(analysisFillDetailList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }

        return Dict.AjaxStatus.YES.getStatusCode();
    }

    private TbAnalysisFillDetail newTaskDetail(TbFillField fillField, String taskNo, TbUser user) {
        TbAnalysisFillDetail analysisFillDetail = new TbAnalysisFillDetail();
        analysisFillDetail.setBaseFieldNo(fillField.getBaseFieldNo());
        analysisFillDetail.setCreateUserCode(user.getCode());
        analysisFillDetail.setCreateUserName(user.getName());
        analysisFillDetail.setFactoryNo(fillField.getFactoryNo());
        analysisFillDetail.setFieldName(fillField.getFieldName());
        analysisFillDetail.setFieldNo(fillField.getFieldNo());
        analysisFillDetail.setFieldUnit(fillField.getParameterConfig().getParamUnit());
        analysisFillDetail.setFillDetailNo(StringTools.getUUID());
        analysisFillDetail.setTaskNo(taskNo);
        analysisFillDetail.setCreateTime(new Date());
        return analysisFillDetail;
    }

    @Override
    public int updateTbAnalysisFillTask(TbAnalysisFillTask tbAnalysisFillTask) {

        if (analysisFillTaskMapper.updateByPrimaryKeySelective(tbAnalysisFillTask) > 0) {
            reportService.insertAnalysisDraftData(analysisFillTaskMapper.selectByPrimaryKey(tbAnalysisFillTask.getFillTaskNo()));
            return Dict.AjaxStatus.YES.getStatusCode();
        } else {
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }
    }

    @Override
    public List<TbAnalysisFillDetail> getAnalysisTaskDetailList(String fillTaskNo) {
        TbAnalysisFillDetailExample example = new TbAnalysisFillDetailExample();
        TbAnalysisFillDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTaskNoEqualTo(fillTaskNo);
        return analysisFillDetailMapper.selectByExample(example);
    }

    @Override
    public int saveAnalysisTaskDetailList(List<TbAnalysisFillDetail> list) {
        try {
            int fillCount = 0;
            String taskNo = "";
            for (TbAnalysisFillDetail analysisFillDetail : list) {
                TbAnalysisFillDetail tbAnalysisFillDetail = analysisFillDetailMapper.selectByPrimaryKey(analysisFillDetail.getFillDetailNo());
                taskNo = tbAnalysisFillDetail.getTaskNo();
                if (analysisFillDetail.getFieldValue() != null) {
                    fillCount++;
                }
                //只有数据发生变更的时候才需要更新数据
                if (analysisFillDetail.getFieldValue() == null && tbAnalysisFillDetail.getFieldValue() == null) {
                    continue;
                } else if (analysisFillDetail.getFieldValue() != null && tbAnalysisFillDetail.getFieldValue() != null) {
                    if (analysisFillDetail.getFieldValue().equals(tbAnalysisFillDetail.getFieldValue())) {
                        continue;
                    }
                }
                tbAnalysisFillDetail.setFieldValue(analysisFillDetail.getFieldValue());
                tbAnalysisFillDetail.setFillTime(new Date());
                analysisFillDetailMapper.updateByPrimaryKey(tbAnalysisFillDetail);
            }
            TbAnalysisFillTask analysisFillTask = analysisFillTaskMapper.selectByPrimaryKey(taskNo);
            if (fillCount != analysisFillTask.getFillCount()) {
                analysisFillTask.setFillCount(fillCount);
                analysisFillTaskMapper.updateByPrimaryKeySelective(analysisFillTask);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }

        return Dict.AjaxStatus.YES.getStatusCode();
    }
}

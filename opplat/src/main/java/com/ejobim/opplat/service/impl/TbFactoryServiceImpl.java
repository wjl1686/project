package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.synBean.FactoryInfoEntity;
import com.ejobim.opplat.domain.synBean.ShuiZhiEntity;
import com.ejobim.opplat.domain.synBean.TuoShuiEntity;
import com.ejobim.opplat.domain.vo.TbFactoryInfoVo;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.TbDictService;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.Dict.DELETE_NO;

/**
 * @author xibian
 * @date 2019-05-10
 */
@Service
public class TbFactoryServiceImpl implements TbFactoryService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.sync.url}")
    private String path;

    @Autowired
    TbFactoryInfoMapper tbFactoryInfoMapper;

    @Autowired
    TbFillFormFieldMapper tbFillFormFieldMapper;

    @Autowired
    TbFormDataMapper tbFormDataMapper;

    @Autowired
    TbRealTimeConfigMapper tbRealTimeConfigMapper;

    @Autowired
    TbFactoryWaterMapper tbFactoryWaterMapper;

    @Autowired
    TbFactoryDehydrationSystemMapper tbFactoryDehydrationSystemMapper;

    @Autowired
    TbFillFormTaskMapper tbFillFormTaskMapper;

    @Autowired
    TbFillFormDetailMapper tbFillFormDetailMapper;

    @Autowired
    private TbParamMapper tbParamMapper;

    @Autowired
    private TbFillFormFieldExtendMapper tbFillFormFieldExtendMapper;

    @Autowired
    private TbWorkFlowConfigDetailMapper tbWorkFlowConfigDetailMapper;

    @Autowired
    private TbFactoryInfoExtendMapper tbFactoryInfoExtendMapper;

    @Autowired
    private TbFactoryMeasureCaliberMapper tbFactoryMeasureCaliberMapper;

    @Autowired
    private TbFactoryVideoMapper factoryVideoMapper;

    @Autowired
    private TbDictMapper tbDictMapper;

    @Autowired
    private TbFactoryTimeMapper tbFactoryTimeMapper;

    @Autowired
    private TbDictService tbDictService;

    @Autowired
    private TbOrgMapper orgMapper;

    @Autowired
    private OrgGroupInfoMapper orgGroupInfoMapper;

    @Override
    public int addFactory(TbFactoryInfo tbFactoryInfo) {
        return tbFactoryInfoMapper.insert(tbFactoryInfo);
    }

    /**
     * 根据主键更新水厂属性
     * @param tbFactoryInfo
     * @return
     */
    @Override
    public int updateFactory(TbFactoryInfo tbFactoryInfo) {
        return tbFactoryInfoMapper.updateByPrimaryKeySelective(tbFactoryInfo);
    }

    @Override
    public int updateFactoryInOutWater(TbFactoryWater tbFactoryWater) {
        TbFactoryWaterExample example = new TbFactoryWaterExample();
        TbFactoryWaterExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(tbFactoryWater.getFactoryNo());
        return tbFactoryWaterMapper.updateByExampleSelective(tbFactoryWater, example);
    }

    @Override
    public int updatefactoryDry(TbFactoryDehydrationSystem tbFactoryDehydrationSystem) {
        TbFactoryDehydrationSystemExample example = new TbFactoryDehydrationSystemExample();
        TbFactoryDehydrationSystemExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(tbFactoryDehydrationSystem.getFactoryNo());
        return tbFactoryDehydrationSystemMapper.updateByExampleSelective(tbFactoryDehydrationSystem, example);
    }

    @Override
    public List<TbFactoryInfo> getTbFactoryInfoList(TbFactoryInfo tbFactoryInfo) {
        return getTbFactoryInfoData(tbFactoryInfo);
    }

    public List<TbFactoryInfo> getTbFactoryInfoData(TbFactoryInfo tbFactoryInfo) {
        List<TbFactoryInfo> tbFactoryInfoList = new ArrayList<>();
        TbFactoryInfoExample tbFactoryInfoExample = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = tbFactoryInfoExample.createCriteria();
        if (!StringUtils.isEmpty(tbFactoryInfo.getFactoryName())) {
            criteria.andFactoryNameLike("%" + tbFactoryInfo.getFactoryName() + "%");
        }
        if (!StringUtils.isEmpty(tbFactoryInfo.getFactoryNo())) {
            String[] ids = tbFactoryInfo.getFactoryNo().split(",");
            if (ids.length > 1) {
                List<String> list = Arrays.asList(ids);
                criteria.andFactoryNoIn(list);
            } else {
                criteria.andFactoryNoEqualTo(tbFactoryInfo.getFactoryNo());
            }

        }
        if(!StringUtils.isEmpty(tbFactoryInfo.getParentFactoryNo())){
            criteria.andParentFactoryNoEqualTo(tbFactoryInfo.getParentFactoryNo());
        }
        tbFactoryInfoExample.setOrderByClause(" sortindex ");
        tbFactoryInfoList = tbFactoryInfoMapper.selectByExample(tbFactoryInfoExample);
        return tbFactoryInfoList;
    }

    @Override
    public List<TbFactoryInfo> getFactoryInfoList(List<String> factoryNoList) {
        TbFactoryInfoExample tbFactoryInfoExample = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = tbFactoryInfoExample.createCriteria();
        if (factoryNoList != null) {
            criteria.andFactoryNoIn(factoryNoList);
        }
        tbFactoryInfoExample.setOrderByClause(" sortIndex ");

        return tbFactoryInfoMapper.selectByExample(tbFactoryInfoExample);
    }

    @Override
    public List<TbFactoryInfo> getTbFactoryInfoDataByFactroyNo(String factoryNo) {
        List<TbFactoryInfo> tbFactoryInfoList = new ArrayList<>();
        TbFactoryInfoExample tbFactoryInfoExample = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = tbFactoryInfoExample.createCriteria();
        criteria.andParentFactoryNoEqualTo(factoryNo);
        tbFactoryInfoExample.setOrderByClause(" issue_no ");
        tbFactoryInfoList = tbFactoryInfoMapper.selectByExample(tbFactoryInfoExample);
        return tbFactoryInfoList;
    }

    @Override
    public int saveTbFillFormField(List<TbFillFormField> tbFillFormFieldList) {
        return tbFillFormFieldMapper.insertBatch(tbFillFormFieldList);
    }

    @Override
    public int addTbFillFormField(TbFillFormField tbFillFormField) {
        return tbFillFormFieldMapper.insertSelective(tbFillFormField);
    }

    @Override
    public int deleteTbFillFormField(String key) {
        //删除配置周期表
        TbFillFormFieldExtendExample tbFillFormFieldExtendExample = new TbFillFormFieldExtendExample();
        TbFillFormFieldExtendExample.Criteria criteria = tbFillFormFieldExtendExample.createCriteria();
        criteria.andConfigNoEqualTo(key);
        List<TbFillFormFieldExtend> tbFillFormFieldExtends = tbFillFormFieldExtendMapper.selectByExample(tbFillFormFieldExtendExample);
        if (tbFillFormFieldExtends != null && tbFillFormFieldExtends.size() > 0) {
            tbFillFormFieldExtendMapper.deleteTbFillFormFieldExtendByConfigNo(key);
        }
        return tbFillFormFieldMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int getTbFillFormFieldCount(String factoryNo, Integer fieldType) {
        TbFillFormFieldExample example = new TbFillFormFieldExample();
        TbFillFormFieldExample.Criteria criteria = example.createCriteria();
        if (factoryNo != null) {
            criteria.andFactoryNoEqualTo(factoryNo);
        }
        if (fieldType != null) {
            criteria.andFieldTypeEqualTo(fieldType);
        }
        return tbFillFormFieldMapper.countByExample(example);
    }

    @Override
    public int updateTbFillFormField(TbFillFormField tbFillFormField) {
        return tbFillFormFieldMapper.updateByPrimaryKeySelective(tbFillFormField);
    }

    @Override
    public int saveFillFormDetail(List<TbFillFormDetail> list) {

        int addCount = 0;
        String taskNo = "";
        for (TbFillFormDetail tbFillFormDetail : list) {
            if (tbFillFormDetail.getFieldValue() == null) {
                continue;
            }

            TbFillFormDetail fillFormDetail = tbFillFormDetailMapper.selectByPrimaryKey(tbFillFormDetail.getFillFormDetailNo());
            taskNo = fillFormDetail.getTaskNo();
            if (fillFormDetail.getFillTime() == null) {
                addCount++;
                tbFillFormDetail.setFillTime(new Date());

            }
            this.tbFillFormDetailMapper.updateByPrimaryKeySelective(tbFillFormDetail);
        }
        TbFillFormTaskExample tbFillFormTaskExample = new TbFillFormTaskExample();
        TbFillFormTaskExample.Criteria criteria1 = tbFillFormTaskExample.createCriteria();
        criteria1.andFillTaskNoEqualTo(taskNo);
        TbFillFormTask tbFillFormTask = tbFillFormTaskMapper.getTbFillFormTaskByKey(taskNo);
        tbFillFormTask.setStatus(2);
        tbFillFormTask.setFillCount(tbFillFormTask.getFillCount() + addCount);
        tbFillFormTaskMapper.updateByExampleSelective(tbFillFormTask, tbFillFormTaskExample);
        return 0;
    }

    @Override
    public int updateFillFormTask(TbFillFormTask tbFillFormTask) {
        //获取原有的任务
        TbFillFormTask oldTask = tbFillFormTaskMapper.getTbFillFormTaskByKey(tbFillFormTask.getFillTaskNo());
        oldTask.setCommitTime(new Date());
        if (oldTask.getStatus().intValue() == 2 || oldTask.getStatus().intValue() == 11) {
            if (oldTask.getEndTime().getTime() < System.currentTimeMillis()) {
                //超时提交
                oldTask.setStatus(6);
            } else {
                //正常提交
                oldTask.setStatus(4);
            }
        } else if (oldTask.getStatus().intValue() == 12) {
            //超时提交
            oldTask.setStatus(6);
        }
        return this.tbFillFormTaskMapper.updateByPrimaryKeySelective(oldTask);
    }

    @Override
    public TbFactoryInfo getFactoryInfoByNo(String factoryNo) {
        return tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
    }


    @Override
    public List<TbFactoryInfo> getChildrenFactory(String factoryNo) {
        TbFactoryInfoExample example = new TbFactoryInfoExample();
        example.createCriteria().andParentFactoryNoEqualTo(factoryNo);
        return tbFactoryInfoMapper.selectByExample(example);
    }

    @Override
    public List<TbFillFormField> getTbFillFormFieldList() {
        return this.tbFillFormFieldMapper.selectByExample(new TbFillFormFieldExample());
    }


    @Override
    public int addTbFormDataList(List<TbFormData> tbFormDataList) {
        for (TbFormData tbFormData : tbFormDataList) {
            this.tbFormDataMapper.insert(tbFormData);
        }
        return 1;
    }

    @Override
    public List<TbFormData> getTbFormDataList(TbFormData tbFormData) {
        TbFormDataExample tbFormDataExample = new TbFormDataExample();
        TbFormDataExample.Criteria criteria = tbFormDataExample.createCriteria();
        if (tbFormData.getFormDate() != null) {
            criteria.andFormDateEqualTo(tbFormData.getFormDate());
        }
        if (!StringUtils.isEmpty(tbFormData.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(tbFormData.getFactoryNo());
        }
        return tbFormDataMapper.selectByExample(tbFormDataExample);
    }


    @Override
    public int saveRealTimeConfig(List<TbRealTimeConfig> list, String factoryNo) {
        List<TbRealTimeConfig> tbRealTimeConfigList = getTbRealTimeConfigList(factoryNo);
        checkTbRealTimeConfig(list, tbRealTimeConfigList, 1);
        checkTbRealTimeConfig(tbRealTimeConfigList, list, 2);
        return 0;
    }

    private void checkTbRealTimeConfig(List<TbRealTimeConfig> list1, List<TbRealTimeConfig> list2, int type) {
        for (TbRealTimeConfig tbRealTimeConfig : list1) {
            boolean contain = false;
            for (TbRealTimeConfig realTimeConfig : list2) {
                if (realTimeConfig.getUri().equals(tbRealTimeConfig.getUri())) {
                    contain = true;
                    break;
                }
            }
            if (contain) {
                continue;
            }

            if (type == 1) {
                tbRealTimeConfigMapper.insertSelective(tbRealTimeConfig);
            } else {
                deleteTbRealTimeConfig(tbRealTimeConfig);
            }

        }
    }

    private void deleteTbRealTimeConfig(TbRealTimeConfig realTimeConfig) {
        TbRealTimeConfigExample example = new TbRealTimeConfigExample();
        TbRealTimeConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(realTimeConfig.getFactoryNo());
        criteria.andUriEqualTo(realTimeConfig.getUri());
        tbRealTimeConfigMapper.deleteByExample(example);

    }

    private List<TbRealTimeConfig> getTbRealTimeConfigList(String factoryNo) {
        TbRealTimeConfigExample example = new TbRealTimeConfigExample();
        TbRealTimeConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        return tbRealTimeConfigMapper.selectByExample(example);
    }

    @Override
    public Tree<TbRealTimeConfig> findTreeLists(String factoryNo) {
        List<TbRealTimeConfig> tbRealTimeConfigList = fineTbRealTimeConfigList(factoryNo);
        List<Tree<TbRealTimeConfig>> trees = new ArrayList<>();
        buildTrees(trees, tbRealTimeConfigList);
        return TreeUtils.build(trees);
    }

    @Override
    public List<TbRealTimeConfig> fineTbRealTimeConfigList(String factoryNo) {
        TbRealTimeConfigExample example = new TbRealTimeConfigExample();
        TbRealTimeConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        List<TbRealTimeConfig> tbRealTimeConfigList = tbRealTimeConfigMapper.selectByExample(example);
        return tbRealTimeConfigList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int createFillTask(String factoryNo, Date startDate, Date endDate, TbUser user) {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        String code = tbFactoryInfo.getBrowsename();
        List<TbFillFormField> fillFormFields = tbFillFormFieldMapper.getFieldListByFactoryNo(factoryNo);
        Map<String, List<TbFillFormField>> fillMap = new HashMap<>();

        for (TbFillFormField tbFillFormField : fillFormFields) {

            String key = "";
            if (tbFillFormField.getFillType() == null) {
                continue;
            }

            if (tbFillFormField.getFillType() == 3) {
                key = "hyTb";
            } else if (tbFillFormField.getFillType() == 1 || tbFillFormField.getFillType() == 2) {
                if (tbFillFormField.getFieldExtend() == null || tbFillFormField.getFieldExtend().getId() == null) {
                    continue;
                }
                if (tbFillFormField.getFieldExtend().getType() == 1) {
                    //排除未正常配置的字段
                    if (StringUtils.isEmpty(tbFillFormField.getFieldExtend().getVaildTime())) {
                        continue;
                    }
                    key = "hourTask";
                } else if (tbFillFormField.getFieldExtend().getType() == 2) {
                    //排除未正常配置的字段
                    if (StringUtils.isEmpty(tbFillFormField.getFieldExtend().getWeek())) {
                        continue;
                    }
                    key = "deyTask";
                } else if (tbFillFormField.getFieldExtend().getType() == 3) {
                    //排除未正常配置的字段
                    if (StringUtils.isEmpty(tbFillFormField.getFieldExtend().getVaildTime())) {
                        continue;
                    }
                    key = "deyTask";
                } else if (tbFillFormField.getFieldExtend().getType() == 4) {
                    //排除未正常配置的字段
                    if (StringUtils.isEmpty(tbFillFormField.getFieldExtend().getVaildTime())) {
                        continue;
                    }
                    key = "deyTask";
                }

            } else {
                continue;
            }
            if (!fillMap.containsKey(key)) {
                List<TbFillFormField> list = new ArrayList<>();
                fillMap.put(key, list);
            }
            fillMap.get(key).add(tbFillFormField);

        }
        System.out.println(fillMap.size());
        for (String key : fillMap.keySet()) {
            try {
                List<TbFillFormField> list = fillMap.get(key);
                //如果是化验填报类的
                if ("hyTb".equals(key)) {
                    createHyFillTask(list, startDate, endDate, code, user.getName());
                } else if ("deyTask".equalsIgnoreCase(key)) {
                    createDayOnceFillTask(list, startDate, endDate, code, user.getName());
                } else {
                    //一日多次的任务
                    if (list.get(0).getFieldExtend().getType() == 1) {
                        createDayMultiFillTask(list, startDate, endDate, code, user.getName(), factoryNo);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }


        }
        return 0;
    }

    @Override
    public List<TbParam> getParamList(TbParam param) {
        TbParamExample example = new TbParamExample();
        TbParamExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getName())) {
            criteria.andNameLike("%" + param.getName() + "%");
        }
        if (param.getType() != null) {
            criteria.andTypeEqualTo(param.getType());
        }
        return tbParamMapper.selectParamList(param);
    }

    @Override
    public void saveTbFillFormFieldExtend(TbFillFormFieldExtend tbFillFormFieldExtend, String[] monthDate) {
        tbFillFormFieldExtend.setCreateTime(new Date());
        Integer type = tbFillFormFieldExtend.getType();
        StringBuffer stringBuffer = new StringBuffer();
        if (monthDate != null) {
            for (int i = 0; i < monthDate.length; i++) {
                if (i > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(monthDate[i]);
            }
            tbFillFormFieldExtend.setVaildTime(stringBuffer.toString());
        }
        if (tbFillFormFieldExtend.getId() != null) {
            tbFillFormFieldExtendMapper.updateByPrimaryKeySelective(tbFillFormFieldExtend);
        } else {
            tbFillFormFieldExtendMapper.insertSelective(tbFillFormFieldExtend);
        }

    }

    @Override
    public List<TbFillFormField> getTbFillFormFieldList(TbFillFormField tbFillFormField) {
        return tbFillFormFieldMapper.selectTbFillFormFieldList(tbFillFormField);
    }


    private List<TbWorkFlowConfigDetail> getTbWorkFlowConfigDetailList(String configNo) {
        TbWorkFlowConfigDetailExample detailExample = new TbWorkFlowConfigDetailExample();
        TbWorkFlowConfigDetailExample.Criteria criteria = detailExample.createCriteria();
        criteria.andConfigNoEqualTo(configNo);
        return tbWorkFlowConfigDetailMapper.selectByExample(detailExample);
    }

    @Override
    public int saveFactoryAllInfo(JSONObject json, String factoryNo, TbUser user) throws Exception {
        //1.更新tb_factory_info表中的数据
        String factoryInfoFormJson = json.getString("factoryInfoForm");
        TbFactoryInfo info = JSONObject.parseObject(factoryInfoFormJson, TbFactoryInfo.class);
        info.setCreateTime(new Date());
        info.setFactoryNo(factoryNo);
        int count = tbFactoryInfoMapper.updateByPrimaryKeySelective(info);
        //2.插入/更新tb_factory_info_extend表中的数据
        if (count > 0) {
            String userInfoFormJson = json.getString("userInfoForm");
            TbFactoryInfoExtend infoExtend = JSONObject.parseObject(factoryInfoFormJson, TbFactoryInfoExtend.class);
            TbFactoryInfoExtend userInfo = JSONObject.parseObject(userInfoFormJson, TbFactoryInfoExtend.class);
            infoExtend.setFilledAccount(userInfo.getFilledAccount());
            infoExtend.setLastUpdateTime(userInfo.getLastUpdateTime());
            infoExtend.setFactoryNo(factoryNo);
            count = tbFactoryInfoExtendMapper.updateByPrimaryKeySelective(infoExtend);
            if (count == 0) {
                count = tbFactoryInfoExtendMapper.insertSelective(infoExtend);
            }
        }
        //3.插入/更新tb_factory_water
        if (count > 0) {
            String inOutWaterForm = json.getString("inOutWaterForm");
            TbFactoryWater tbFactoryWater = JSONObject.parseObject(inOutWaterForm, TbFactoryWater.class);
            tbFactoryWater.setFactoryNo(factoryNo);
            tbFactoryWater.setCreatTime(new Date());
            count = tbFactoryWaterMapper.updateByFactoryNo(tbFactoryWater);
            if (count == 0) {
                count = tbFactoryWaterMapper.insertSelective(tbFactoryWater);
            }
        }
        //4.插入/更新tb_factory_measure_caliber计量口径表
        if (count > 0) {
            String measuringCaliberForm = json.getString("measuringCaliberForm");
            TbFactoryMeasureCaliber tbFactoryMeasureCaliber = JSONObject.parseObject(measuringCaliberForm, TbFactoryMeasureCaliber.class);
            tbFactoryMeasureCaliber.setFactoryNo(factoryNo);
            count = tbFactoryMeasureCaliberMapper.updateByPrimaryKeySelective(tbFactoryMeasureCaliber);
            if (count == 0) {
                count = tbFactoryMeasureCaliberMapper.insertSelective(tbFactoryMeasureCaliber);
            }
        }
        //5.插入/更新tb_factory_dehydration_system系统数据
        if (count > 0) {
            String factoryDryForm = json.getString("factoryDryForm");
            TbFactoryDehydrationSystem tbFactoryDehydrationSystem = JSONObject.parseObject(factoryDryForm, TbFactoryDehydrationSystem.class);
            tbFactoryDehydrationSystem.setFactoryNo(factoryNo);
            count = tbFactoryDehydrationSystemMapper.updateByFactoryNo(tbFactoryDehydrationSystem);
            if (count == 0) {
                count = tbFactoryDehydrationSystemMapper.insertSelective(tbFactoryDehydrationSystem);
            }
        }
        if (count == 0) {
            throw new Exception();
        }
        JSONObject jF = setFactoryInfo(factoryNo);
        logger.info("");
        if(!jF.getString("DataResult").equals("succ")){
            count= Dict.AjaxStatus.IMPORT_FACTORY_FAI.getStatusCode();
        }
        JSONObject jsZ =setShuiZhi(factoryNo);
        if(!jsZ.getString("DataResult").equals("succ")){
            count= Dict.AjaxStatus.IMPORT_SHUI_FAI.getStatusCode();
        }
        JSONObject jtS=setTuoshui(factoryNo);
        if(!jtS.getString("DataResult").equals("succ")){
            count= Dict.AjaxStatus.IMPORT_TUO_FAI.getStatusCode();
        }
        return count;
    }

    @Override
    public TbFactoryVideo getFactoryVideo(String factoryNo) {
        return factoryVideoMapper.selectByPrimaryKey(factoryNo);
    }


    /**
     * 判断任务是否已经存在
     *
     * @param taskDate
     * @return
     */
    private TbFillFormTask hasFillTask(Date taskDate, int taskType, String factoryNo) {
        TbFillFormTaskExample example = new TbFillFormTaskExample();
        TbFillFormTaskExample.Criteria criteria = example.createCriteria();
        criteria.andFillTaskTimeEqualTo(taskDate);

        criteria.andTaskTypeEqualTo(taskType);
        criteria.andFactoryNoEqualTo(factoryNo);
        List<TbFillFormTask> list = this.tbFillFormTaskMapper.selectByExample(example);
        if (list.size() >= 1) {
            return list.get(0);
        } else {
            return null;
        }

    }

    private int getTaskCodeIndex(String factoryNo, String date, int type) {
        Date startDate = DateUtils.parseDate(date);
        Date endDate = DateUtils.parseDateFull(date + " 23:59:59");
        TbFillFormTaskExample example = new TbFillFormTaskExample();
        TbFillFormTaskExample.Criteria criteria = example.createCriteria();
        criteria.andFillTaskTimeBetween(startDate, endDate);
        criteria.andFactoryNoEqualTo(factoryNo);
        if (type < 3) {
            criteria.andTaskTypeNotEqualTo(3);
        } else {
            criteria.andTaskTypeEqualTo(type);
        }

        example.setOrderByClause(" fill_task_time");
        return tbFillFormTaskMapper.selectByExample(example).size();
    }

    /**
     * 创建化验填报任务
     *
     * @param tbFillFormFieldList
     * @param startDate
     * @param endDate
     * @param code
     */
    private void createHyFillTask(List<TbFillFormField> tbFillFormFieldList, Date startDate, Date endDate, String code, String userName) {
        List<String> dayList = DateUtils.getDistDayList(startDate, endDate);
        TbFillFormField tbFillFormField = tbFillFormFieldList.get(0);
        int taskCount = 0;
        for (TbFillFormField fillFormField : tbFillFormFieldList) {
            if (fillFormField.getFieldExtend().getId() != null) {
                if (!StringUtils.isEmpty(fillFormField.getFieldExtend().getVaildTime())) {
                    taskCount += fillFormField.getFieldExtend().getVaildTime().split(",").length;
                }
            } else {
                taskCount++;
            }

        }
        // 按天循环
        for (String day : dayList) {
            int taskType = 5;
            int taskIndex = getTaskCodeIndex(tbFillFormField.getFactoryNo(), day, taskType);
            Date taskDate = DateUtils.parseDate(day);
            //如果没有该时间点的同类型的
            if (hasFillTask(taskDate, taskType, tbFillFormField.getFactoryNo()) == null) {
                String index = getTaskIndex(taskIndex);
                String taskCode = code + "HY" + day.replace("-", "") + index;
                Date endTime = DateUtils.parseDateFull(day + " 23:59:59");
                TbFillFormTask tbFillFormTask = createBaseFillTask(taskType, taskCount, tbFillFormField.getFactoryNo(), taskCode, taskDate, endTime, userName);
                //创建任务
                this.tbFillFormTaskMapper.insertSelective(tbFillFormTask);
                List<TbFillFormDetail> list = new ArrayList<>();
                for (TbFillFormField tbFillField : tbFillFormFieldList) {
                    if (tbFillField.getFieldExtend().getId() == null || StringUtils.isEmpty(tbFillField.getFieldExtend().getVaildTime())) {
                        TbFillFormDetail fillFormDetail = createBaseFillTaskDetail(tbFillFormTask, tbFillField, null, userName);
                        list.add(fillFormDetail);
                    } else {
                        if (!StringUtils.isEmpty(tbFillField.getFieldExtend().getVaildTime())) {
                            String[] times = tbFillField.getFieldExtend().getVaildTime().split(",");
                            for (String time : times) {
                                TbFillFormDetail fillFormDetail = createBaseFillTaskDetail(tbFillFormTask, tbFillField, time, userName);
                                list.add(fillFormDetail);
                            }
                        }

                    }

                }
                this.tbFillFormDetailMapper.insertBatch(list);

            }
        }

    }

    private String getTaskIndex(int taskIndex) {
        String index = taskIndex + "";
        if (taskIndex < 10) {
            index = "00" + taskIndex;
        } else if (taskIndex < 100) {
            index = "0" + taskIndex;
        }
        return index;
    }


    /**
     * 创建天多次任务
     */
    private void createDayMultiFillTask(List<TbFillFormField> tbFillFormFieldList, Date startDate, Date endDate, String code, String userName, String factoryNo) {
        List<String> dayList = DateUtils.getDistDayList(startDate, endDate);
        Map<String, List<TbFillFormField>> taskFieldMap = new HashMap<>();
        for (TbFillFormField tbFillFormField : tbFillFormFieldList) {
            String[] times = tbFillFormField.getFieldExtend().getVaildTime().split(",");
            for (String timeZone : times) {
                if (!taskFieldMap.containsKey(timeZone)) {
                    List<TbFillFormField> list = new ArrayList<>();
                    taskFieldMap.put(timeZone, list);
                }
                taskFieldMap.get(timeZone).add(tbFillFormField);
            }
        }
        try {
            // 按天循环
            for (String day : dayList) {
                //获取当天的任务编号
                int taskIndex = getTaskCodeIndex(factoryNo, day, 1);
                for (String timeZone : taskFieldMap.keySet()) {
                    String dayStartTime = day + " " + timeZone + ":00";
                    Date startTime = DateUtils.parseDateFull(dayStartTime);
                    Date endTime = DateUtils.getFullNextHour(dayStartTime, 2);
                    //如果没有该时间点的同类型的
                    if (hasFillTask(startTime, 1, factoryNo) == null) {
                        String index = getTaskIndex(taskIndex);
                        List<TbFillFormField> currentList = taskFieldMap.get(timeZone);
                        String taskCode = code + "TB" + day.replace("-", "") + index;
                        TbFillFormTask tbFillFormTask = createBaseFillTask(1, currentList.size(), factoryNo, taskCode, startTime, endTime, userName);
                        //创建任务
                        this.tbFillFormTaskMapper.insertSelective(tbFillFormTask);
                        List<TbFillFormDetail> list = new ArrayList<>();
                        for (TbFillFormField tbFillField : currentList) {
                            TbFillFormDetail tbFillFormDetail = createBaseFillTaskDetail(tbFillFormTask, tbFillField, timeZone, userName);
                            list.add(tbFillFormDetail);
                        }
                        this.tbFillFormDetailMapper.insertBatch(list);
                    }
                    taskIndex++;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }


    /**
     * 创建周任务
     */
    private void createDayOnceFillTask(List<TbFillFormField> tbFillFormFieldList, Date startDate, Date endDate, String code, String userName) {
        Map<String, List<TbFillFormField>> dateTaskMap = new HashMap<>();
        List<String> dayList = DateUtils.getDistDayList(startDate, endDate);
        for (String day : dayList) {
            for (TbFillFormField tbFillFormField : tbFillFormFieldList) {
                //周填报
                if (tbFillFormField.getFieldExtend().getType().intValue() == 2) {
                    int weekDate = DateUtils.getDateOfWeek(day);
                    if (tbFillFormField.getFieldExtend().getWeek().indexOf(weekDate + "") >= 0) {
                        addToMap(dateTaskMap, tbFillFormField, day);
                    }
                    //月填报
                } else if (tbFillFormField.getFieldExtend().getType().intValue() == 3) {
                    int monthDate = DateUtils.getDateOfMonth(day);
                    List<String> monthDateList = Arrays.asList(tbFillFormField.getFieldExtend().getVaildTime().split(","));
                    if (monthDateList.contains(monthDate + "")) {
                        addToMap(dateTaskMap, tbFillFormField, day);
                    }
                } else if (tbFillFormField.getFieldExtend().getType().intValue() == 4) {
                    if (tbFillFormField.getFieldExtend().getVaildTime().indexOf(day) >= 0) {
                        addToMap(dateTaskMap, tbFillFormField, day);
                    }
                }
            }

        }

        for (String day : dateTaskMap.keySet()) {
            Date taskDate = DateUtils.parseDate(day);
            Date endTime = DateUtils.getNextDate(day);
            //按天计算的任务 编号直接为000
            String taskCode = code + "TB" + day.replace("-", "") + "000";

            List<TbFillFormField> list = dateTaskMap.get(day);
            if (list.size() > 0) {
                String factoryNo = list.get(0).getFactoryNo();
                TbFillFormTask dayTask = hasFillTask(taskDate, 2, factoryNo);
                int oldCount = 0;
                if (dayTask == null) {
                    dayTask = createBaseFillTask(1, list.size(), factoryNo, taskCode, taskDate, endTime, userName);
                    //创建天任务
                    this.tbFillFormTaskMapper.insertSelective(dayTask);
                } else {
                    oldCount = dayTask.getFillCountAll();
                }
                List<TbFillFormDetail> newlist = new ArrayList<>();
                for (TbFillFormField tbFillField : list) {
                    if (hasOldTaskDetail(dayTask.getFillTaskNo(), tbFillField.getConfigNo())) {
                        TbFillFormDetail tbFillFormDetail = createBaseFillTaskDetail(dayTask, tbFillField, "00:00", userName);
                        newlist.add(tbFillFormDetail);
                        if (oldCount > 0) {
                            oldCount++;
                        }
                    }
                }
                if (newlist.size() > 0) {
                    this.tbFillFormDetailMapper.insertBatch(newlist);
                }

                if (oldCount > 0) {
                    dayTask.setFillCountAll(oldCount);
                    this.tbFillFormTaskMapper.updateByPrimaryKeySelective(dayTask);
                }
            }

        }


    }

    private void addToMap(Map<String, List<TbFillFormField>> map, TbFillFormField fillFormDetail, String day) {
        if (map.containsKey(day)) {
            map.get(day).add(fillFormDetail);
        } else {
            List<TbFillFormField> list = new ArrayList<>();
            list.add(fillFormDetail);
            map.put(day, list);
        }
    }


    /**
     * 创建任务对象
     *
     * @param taskType
     * @param fieldCount
     * @param factoryNo
     * @return
     */
    private TbFillFormTask createBaseFillTask(int taskType, int fieldCount, String factoryNo, String taskCode, Date taskTime, Date endTime, String userName) {
        TbFillFormTask tbFillFormTask = new TbFillFormTask();
        tbFillFormTask.setFillTaskNo(StringTools.getUUID());
        tbFillFormTask.setTaskType(taskType);
        //设置填报字段总数量
        tbFillFormTask.setFillCountAll(fieldCount);
        tbFillFormTask.setFillCount(0);
        tbFillFormTask.setFactoryNo(factoryNo);
        tbFillFormTask.setCreateTime(new Date());
        tbFillFormTask.setCreateUser(userName);
        tbFillFormTask.setStatus(0);
        tbFillFormTask.setFillTaskCode(taskCode);
        tbFillFormTask.setFillTaskTime(taskTime);
        tbFillFormTask.setEndTime(endTime);
        return tbFillFormTask;
    }


    /**
     * 创建任务详情
     *
     * @param tbFillFormTask
     * @param tbFillFormField
     * @param timePoint
     * @return
     */
    private TbFillFormDetail createBaseFillTaskDetail(TbFillFormTask tbFillFormTask, TbFillFormField tbFillFormField, String timePoint, String userName) {
        TbFillFormDetail tbFillFormDetail = new TbFillFormDetail();
        tbFillFormDetail.setFillFormDetailNo(StringTools.getUUID());
        tbFillFormDetail.setConfigNo(tbFillFormField.getConfigNo());
        tbFillFormDetail.setTaskNo(tbFillFormTask.getFillTaskNo());
        tbFillFormDetail.setFieldCode(tbFillFormField.getFieldCode());
        String fieldName = StringTools.clearNumber(tbFillFormField.getParentObj().getDisplayname()) + "_" + tbFillFormField.getFieldName();
        tbFillFormDetail.setFieldName(fieldName);
        tbFillFormDetail.setFieldUnit(tbFillFormField.getFieldUnit());
        tbFillFormDetail.setFactoryNo(tbFillFormField.getFactoryNo());
        tbFillFormDetail.setEquipNo(tbFillFormField.getEquipNo());
        tbFillFormDetail.setFormDate(tbFillFormTask.getFillTaskTime());
        tbFillFormDetail.setTimePoint(timePoint);
        tbFillFormDetail.setBrowsePath(tbFillFormField.getBrowsePath());
        tbFillFormDetail.setCreatePerson(userName);
        tbFillFormDetail.setCreateTime(new Date());
        tbFillFormDetail.setType(tbFillFormField.getFieldType());
        return tbFillFormDetail;
    }

    private boolean hasOldTaskDetail(String taskNo, String configNo) {
        TbFillFormDetailExample example = new TbFillFormDetailExample();
        TbFillFormDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTaskNoEqualTo(taskNo);
        criteria.andConfigNoEqualTo(configNo);
        List<TbFillFormDetail> list = this.tbFillFormDetailMapper.selectByExample(example);
        if (list.size() >= 0) {
            return true;
        } else {
            return false;
        }

    }


    private void buildTrees(List<Tree<TbRealTimeConfig>> trees, List<TbRealTimeConfig> tbRealTimeConfigList) {
        tbRealTimeConfigList.forEach(menu -> {
            Tree<TbRealTimeConfig> tree = new Tree<>();
            tree.setId(menu.getUri());
            tree.setParentId(menu.getParenturi());
            Map<String, Object> attribute = new HashMap<>();
            attribute.put("accessLevel", menu.getAccesslevel());
            attribute.put("browsePath", menu.getBrowsepath());
            tree.setAttributes(attribute);
            tree.setText(menu.getDisplayname());
            trees.add(tree);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveFactoryInfo(List<TbFactoryInfoVo> list, String factoryNo, List<TbDict> tbDicts, List<TbOrg> tbOrgList) throws Exception {
        int flag = 0;
        //业务大区
        for (TbFactoryInfoVo con : list) {
            if (con.getProjectExitTimeName() != null) {
                con.setProjectExitTime(DateUtils.parseDateNo(con.getProjectExitTimeName()));
            }
            //businessStartTime
            if (con.getBusinessStartTimeName() != null) {
                con.setBusinessStartTime(DateUtils.parseDateNo(con.getBusinessStartTimeName()));
            }
            for (TbOrg tbOrg : tbOrgList) {
                if (con.getRegionName() != null) {
                    if (tbOrg.getName().equals(con.getRegionName())) {
                        con.setRegion(tbOrg.getCode());
                    }
                }
            }
        }
        //projectExitTime
        //水厂分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂  --父id 55
        commonData(list, tbDicts, 55);

        //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目  --父id 57
        commonData(list, tbDicts, 57);

        //是否集团运营 1运营 是  0：不运营 否 父id 117
        commonData(list, tbDicts, 117);

        //核心工艺 //todo
        // commonData( list,  tbDicts, 55);
        // 1:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级A 2:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级B 3: 城镇污水处理厂污染物排放标准/GB18918-  2002/二级
        // 4: 污水综合排放标准/GB8978 - 1996/一级 5: 污水综合排放标准/GB8978 - 1996/二级 6: 污水综合排放标准/GB8978 - 1996/三级
        // 7;地表水环境质量标准/GB3838 - 2002/I类 8:地表水环境质量标准/GB3838 - 2002/II类 9: 地表水环境质量标准/GB3838 - 2002/III类 10:地表水环境质量标准/GB3838 - 2002/IV类 11;地表水环境质量标准/GB3838 - 2002/V类
        // 12:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/A标准 13:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/B标准
        // 14:广东省地方标准水污染物排放限值/DB4426 - 2001/一级 15:广东省地方标准水污染物排放限值/DB4426 - 2001/二级
        // 16:四川省岷江、沱江流域水污染物排放标准/DB51/2311-2016 17:化学工业主要水染污物排放标准/DB32/939 - 2006/一级 18:化学工业主要水污染物排放标准/DB32/939 - 2006/二级
        // 19: 河水净化厂水质标准：浊度≤2.0色度≤10 透明度≥15  父id 56
        commonData(list, tbDicts, 56);

        // 计量口径类型 1:进水 2:出水 3:其他    -- (父id 65)
        commonData(list, tbDicts, 65);

        // 污泥浓缩方式 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
        commonData(list, tbDicts, 58);

        //污泥脱水方式(含水量约80%) //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
        commonData(list, tbDicts, 81);

        //污泥预脱水方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
        commonData(list, tbDicts, 88);

        // 污泥深度脱水方式(含水率约60%)  //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
        commonData(list, tbDicts, 94);

        // 污泥运输方式 1: 政府运输 2:自行运输       --父id  99
        commonData(list, tbDicts, 99);

        // 污泥处理方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
        commonData(list, tbDicts, 102);

        for (TbFactoryInfoVo tbFactoryInfoVo : list) {
            tbFactoryInfoVo.setFactoryNo(factoryNo);
            TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
            tbFactoryInfo.setSortindex(tbFactoryInfoVo.getSortindex() != null ? tbFactoryInfoVo.getSortindex() : null);
            BeanUtils.copyProperties(tbFactoryInfoVo, tbFactoryInfo);
//            if (tbFactoryInfoVo.getBusinessStartTimeName() != null) {
//                tbFactoryInfo.setBusinessStartTime(DateUtils.parseDate(tbFactoryInfoVo.getBusinessStartTimeName()));
//            }
            //判断一次
            TbFactoryInfo tbFactoryInfoDb = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
            if (tbFactoryInfoDb != null) {
                //修改
                flag = tbFactoryInfoMapper.updateByPrimaryKeySelective(tbFactoryInfo);
            } else {
                flag = tbFactoryInfoMapper.insertSelective(tbFactoryInfo);
            }
            if (flag == 0) {
                throw new Exception();
            } else {
                //水厂 水厂拓展表
                flag = saveTbFactoryInfoExtend(tbFactoryInfoVo, factoryNo, flag);
                //水厂 水厂进出水表
                flag = saveTbFactoryWater(tbFactoryInfoVo, factoryNo, flag);
                //水厂 计量口径-水厂拓展表
                flag = saveTbFactoryMeasureCaliber(tbFactoryInfoVo, factoryNo, flag);
                //水厂 脱水系统设计参数
                flag = saveTbFactoryDehydrationSystem(tbFactoryInfoVo, factoryNo, flag);
                //设置水厂信息
                JSONObject jF = setFactoryInfo(factoryNo);
                logger.info("");
                if(!jF.getString("DataResult").equals("succ")){
                    flag= Dict.AjaxStatus.IMPORT_FACTORY_FAI.getStatusCode();
                }
                JSONObject jsZ =setShuiZhi(factoryNo);
                if(!jsZ.getString("DataResult").equals("succ")){
                    flag= Dict.AjaxStatus.IMPORT_SHUI_FAI.getStatusCode();
                }
                JSONObject jtS=setTuoshui(factoryNo);
                if(!jtS.getString("DataResult").equals("succ")){
                    flag= Dict.AjaxStatus.IMPORT_TUO_FAI.getStatusCode();
                }
            }
        }
        return flag;
    }

    public void commonData(List<TbFactoryInfoVo> list, List<TbDict> tbDicts, int parentId) {
        List<TbDict> collect = tbDicts.stream().filter(x -> x.getParentId() == parentId).collect(Collectors.toList());
        for (TbFactoryInfoVo con : list) {
            con.getProjectTypeName();
            con.getOperateTypeName();
            con.getWaterQualityNormOutName();
            con.getLevelName();
            con.getMeasureCaliberTypeName();
            con.getSludgeTypeName();
            con.getDehydrationTypeName();
            con.getDehydrationPreTypeName();
            con.getMudDepthDehydrationTypeName();
            con.getMudTransportTypeName();
            con.getMudHandleTypeName();
            for (TbDict tbDict : collect) {
                if (con.getProjectTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getProjectTypeName()) && parentId == 57) {
                        con.setProjectType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getOperateTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getOperateTypeName()) && parentId == 117) {
                        con.setOperateType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getWaterQualityNormOutName() != null && parentId == 56) {
                    if (tbDict.getValueName().equals(con.getWaterQualityNormOutName())) {
                        con.setWaterQualityNormOut(tbDict.getKeyName());
                    }
                }
                if (con.getLevelName() != null && parentId == 55) {
                    if (tbDict.getValueName().equals(con.getLevelName())) {
                        con.setLevel(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getMeasureCaliberTypeName() != null && parentId == 65) {
                    if (tbDict.getValueName().equals(con.getMeasureCaliberTypeName())) {
                        con.setMeasureCaliberType(tbDict.getKeyName());
                    }
                }
                if (con.getSludgeTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getSludgeTypeName()) && parentId == 58) {
                        con.setSludgeType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getDehydrationTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getDehydrationTypeName()) && parentId == 81) {
                        con.setDehydrationType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getDehydrationPreTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getDehydrationPreTypeName()) && parentId == 88) {
                        con.setDehydrationPreType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getMudDepthDehydrationTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getMudDepthDehydrationTypeName()) && parentId == 94) {
                        con.setMudDepthDehydrationType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getMudTransportTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getMudTransportTypeName()) && parentId == 99) {
                        con.setMudTransportType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
                if (con.getMudHandleTypeName() != null) {
                    if (tbDict.getValueName().equals(con.getMudHandleTypeName()) && parentId == 102) {
                        con.setMudHandleType(Integer.parseInt(tbDict.getKeyName()));
                    }
                }
            }
        }
    }

    public int saveTbFactoryInfoExtend(TbFactoryInfoVo tbFactoryInfoVo, String factoryNo, int flag) throws Exception {
        int result = 0;
        TbFactoryInfoExtend tbFactoryInfoExtend = new TbFactoryInfoExtend();
        tbFactoryInfoExtend.setLastUpdateTime(new Date());
        BeanUtils.copyProperties(tbFactoryInfoVo, tbFactoryInfoExtend);
        TbFactoryInfoExtend tbFactoryInfoExtendDb = tbFactoryInfoExtendMapper.selectByPrimaryKey(factoryNo);
        if (tbFactoryInfoExtendDb != null) {
            result = tbFactoryInfoExtendMapper.updateByPrimaryKeySelective(tbFactoryInfoExtend);
        } else {
            result = tbFactoryInfoExtendMapper.insertSelective(tbFactoryInfoExtend);
        }
        getResult(result);
        return result;
    }

    public int saveTbFactoryWater(TbFactoryInfoVo tbFactoryInfoVo, String factoryNo, int flag) throws Exception {
        int result = 0;
        TbFactoryWater tbFactoryWater = new TbFactoryWater();
        tbFactoryWater.setCreatTime(new Date());
        BeanUtils.copyProperties(tbFactoryInfoVo, tbFactoryWater);
        TbFactoryWater tbFactoryWaterDb = tbFactoryWaterMapper.selectByPrimaryKey(factoryNo);
        if (tbFactoryWaterDb != null) {
            result = tbFactoryWaterMapper.updateByFactoryNo(tbFactoryWater);
        } else {
            result = tbFactoryWaterMapper.insertSelective(tbFactoryWater);
        }
        getResult(result);
        return result;
    }

    public int saveTbFactoryMeasureCaliber(TbFactoryInfoVo tbFactoryInfoVo, String factoryNo, int flag) throws Exception {
        int result = 0;
        TbFactoryMeasureCaliber tbFactoryMeasureCaliber = new TbFactoryMeasureCaliber();
        tbFactoryMeasureCaliber.setLastUpdateTime(new Date());
        BeanUtils.copyProperties(tbFactoryInfoVo, tbFactoryMeasureCaliber);
        TbFactoryMeasureCaliber tbFactoryMeasureCaliberDb = tbFactoryMeasureCaliberMapper.selectByPrimaryKey(factoryNo);
        if (tbFactoryMeasureCaliberDb != null) {
            result = tbFactoryMeasureCaliberMapper.updateByPrimaryKeySelective(tbFactoryMeasureCaliber);
        } else {
            result = tbFactoryMeasureCaliberMapper.insertSelective(tbFactoryMeasureCaliber);
        }
        getResult(result);
        return result;
    }

    public int saveTbFactoryDehydrationSystem(TbFactoryInfoVo tbFactoryInfoVo, String factoryNo, int flag) throws Exception {
        int result = 0;
        TbFactoryDehydrationSystem tbFactoryDehydrationSystem = new TbFactoryDehydrationSystem();
        tbFactoryDehydrationSystem.setCreateTime(new Date());
        BeanUtils.copyProperties(tbFactoryInfoVo, tbFactoryDehydrationSystem);
        TbFactoryDehydrationSystem tbFactoryDehydrationSystemDb = tbFactoryDehydrationSystemMapper.selectByPrimaryKey(factoryNo);
        if (tbFactoryDehydrationSystemDb != null) {
            result = tbFactoryDehydrationSystemMapper.updateByFactoryNo(tbFactoryDehydrationSystem);
        } else {
            result = tbFactoryDehydrationSystemMapper.insertSelective(tbFactoryDehydrationSystem);
        }
        getResult(result);
        return result;
    }

    public void getResult(int result) throws Exception {
        if (result == 0) {
            throw new Exception();
        }
    }

    /**
     * 设置工厂基础信息
     * @param factoryNo
     * @return
     */
    public JSONObject setFactoryInfo(String factoryNo) {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        FactoryInfoEntity factoryInfo = new FactoryInfoEntity();
        TbFactoryInfoExtend tbFactoryInfoExtend = tbFactoryInfoExtendMapper.selectByPrimaryKey(tbFactoryInfo.getFactoryNo());
        factoryInfo.setUSERID_(tbFactoryInfo.getFactoryCode()+"tb");
        factoryInfo.setNO(tbFactoryInfo.getSortindex()!=null?tbFactoryInfo.getSortindex().toString():null);
        //查询大区名称
        TbOrg tbOrg = orgMapper.selectByPrimaryKey(tbFactoryInfo.getRegion());
        if(tbOrg!=null){
            factoryInfo.setAreaName(tbOrg.getName());
        }
        factoryInfo.setFullName(tbFactoryInfo.getFactoryName());
        String levelName="";
        if(tbFactoryInfo.getLevel()==1){
            levelName="直辖市及省会所在城市";
        }else if(tbFactoryInfo.getLevel()==2){
            levelName="地市级水厂";
        }else {
            levelName="县级水厂";
        }
        factoryInfo.setWaterworksLevel(levelName);
        factoryInfo.setCompanyName(tbFactoryInfo.getOperateCompanyName());
        String projectName="";
        if(tbFactoryInfo.getProjectType()==1){
            projectName="市政污水处理厂";
        }else if(tbFactoryInfo.getProjectType()==2){
            projectName="村镇污水处理项目";
        }else if(tbFactoryInfo.getProjectType()==3){
            projectName="工业园区污水厂";
        }else if(tbFactoryInfo.getProjectType()==4){
            projectName="再生水生产厂";
        }else {
            projectName="再生水项目";
        }
        factoryInfo.setProjectType(projectName);
        factoryInfo.setAddress(tbFactoryInfo.getProjectAddress());
        factoryInfo.setLng(tbFactoryInfo.getLongitude()+"");
        factoryInfo.setLat(tbFactoryInfo.getLatitude()+"");
        String operateTypeName="是";
        if(tbFactoryInfo.getOperateType()==2){
            operateTypeName="否";
        }
        factoryInfo.setIsGroupOperation(operateTypeName);
        if(tbFactoryInfoExtend!=null){
            factoryInfo.setFranchiseModel(tbFactoryInfoExtend.getPlanningScale());
            factoryInfo.setProPlanScale(tbFactoryInfoExtend.getContractScale());
            factoryInfo.setProBuildRate(tbFactoryInfoExtend.getPowerRate());
            factoryInfo.setProBuildRate(tbFactoryInfoExtend.getPowerScale());
            factoryInfo.setProConsStage(tbFactoryInfoExtend.getBuileScale());
            factoryInfo.setProScaleOperation(tbFactoryInfoExtend.getHoldScale());
            //ProScaleMaintain  运营维护管网长度（km）
            factoryInfo.setProScaleMaintain(tbFactoryInfoExtend.getHoldMaintain());
            factoryInfo.setPlanServicePopulation(tbFactoryInfoExtend.getServicePopulation());
            factoryInfo.setPlanServiceArea(tbFactoryInfoExtend.getServiceArea());
            factoryInfo.setPlanIndustrialWasteWater(tbFactoryInfoExtend.getIndustrialWasteRate());
            factoryInfo.setPlanCoreTechnology(tbFactoryInfoExtend.getCoreProcess());
            //出生水质标准
            List<TbDict> dictList = getDictList();
            for (TbDict tbDict : dictList) {
                if (tbFactoryInfoExtend.getWaterQualityNormOut() != null && tbDict.getParentId() == 56 && tbFactoryInfoExtend.getWaterQualityNormOut().equals(tbDict.getKeyName())) {
                    factoryInfo.setPlanEffluentQualityStandard(tbDict.getValueName());
                }
            }
            factoryInfo.setContractPeriod(tbFactoryInfoExtend.getContractPeriod()+"");
            factoryInfo.setBaseWater(tbFactoryInfoExtend.getKeepWaterVolume());
            factoryInfo.setUnitContractPrice(tbFactoryInfoExtend.getContractUnitPrice());
        }
        if(!StringUtils.isEmpty(tbFactoryInfo.getBusinessStartTime())){
            factoryInfo.setRunStartDate(DateUtils.formateDate(tbFactoryInfo.getBusinessStartTime()));
        }
        factoryInfo.setRemark(tbFactoryInfo.getDescripion());
       // factoryInfo.setProjectName("");
        if(!StringUtils.isEmpty(tbFactoryInfo.getProjectExitTime())){
            factoryInfo.setExitTime(DateUtils.formateDate(tbFactoryInfo.getProjectExitTime()));
        }
        String url = path+"/api/SyncDataOracle/SetFactoryInfo";
        logger.info("水厂信息factoryInfo={}", JSON.toJSON(factoryInfo));
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(factoryInfo).toString());
        logger.info("水厂信息请求url={},数据json={}", url,json);
        JSONObject response =  restTemplate.postForObject(url, json, JSONObject.class);
        logger.info("水厂信息结果son={}", response);
        return response;
    }

    /**
     * 进出水水质标准
     * @param factoryNo
     * @return
     */
    public JSONObject setShuiZhi(String factoryNo) {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        JSONObject response =new JSONObject();
        if(tbFactoryInfo!=null){
            ShuiZhiEntity shuizhi = new ShuiZhiEntity();
            TbFactoryWater water = tbFactoryWaterMapper.selectByPrimaryKey(tbFactoryInfo.getFactoryNo());
            if(water!=null){
                shuizhi.setUSERID_(tbFactoryInfo.getFactoryCode()+"tb");
                shuizhi.setB3(water.getTotalInwaterCod());
                shuizhi.setC3(water.getTotalInwaterBod());
                shuizhi.setD3(water.getTotalInwaterSs());
                shuizhi.setE3(water.getTotalInwaterNh3N());
                shuizhi.setF3(water.getTotalInwaterTn());
                shuizhi.setG3(water.getTotalInwaterTp());
                shuizhi.setH3(water.getTotalInwaterPhDown());
                shuizhi.setI3(water.getTotalInwaterPhUp());
                if(!StringUtils.isEmpty(water.getTotalInwaterChroma())){
                    shuizhi.setJ3(Double.parseDouble(water.getTotalInwaterChroma()+""));
                }
                shuizhi.setK3(water.getTotalOutwaterCod());
                shuizhi.setK3(water.getTotalOutwaterBod());
                //总出水BOD标准值（mg/l //todo 暂无维护
                //shuizhi.setL3();
                shuizhi.setM3(water.getTotalOutwaterSs());
                shuizhi.setN3(water.getTotalOutwaterNh3N1());
                shuizhi.setP3(water.getTotalOutwaterTn());
                shuizhi.setQ3(water.getTotalOutwaterTp());
                shuizhi.setR3(water.getTotalOutwaterPhDown());
                shuizhi.setS3(water.getTotalOutwaterPhUp());
                if(!StringUtils.isEmpty(water.getTotalOutwaterChroma())){
                    shuizhi.setT3(Double.parseDouble(water.getTotalOutwaterChroma()+""));
                }
                if(!StringUtils.isEmpty(water.getTotalOutwaterColiform())){
                    shuizhi.setU3(Double.parseDouble(water.getTotalOutwaterColiform()+""));
                }
                if(!StringUtils.isEmpty(water.getTotalOutwaterTurbidity())){
                    shuizhi.setV3(Double.parseDouble(water.getTotalOutwaterTurbidity()+""));
                }
                shuizhi.setW3(water.getTotalOutwaterDissolution());
                shuizhi.setX3(water.getTotalOutwaterHardness());
                shuizhi.setY3(water.getTotalOutwaterAnion());
                if(water.getCreatTime()!=null){
                    shuizhi.setZ3(DateUtils.formateDate(water.getCreatTime()));
                }else {
                    shuizhi.setZ3(DateUtils.formateDate(new Date()));
                }
            }
            String url = path+"/api/SyncDataOracle/SetShuiZhi";
            JSONObject json = JSONObject.parseObject(JSONObject.toJSON(shuizhi).toString());
            logger.info("水质信息请求url={},数据json={}", url,json);
            response = restTemplate.postForObject(url, json, JSONObject.class);
            logger.info("水质信息结果json={}", response);
        }

        return response;
    }
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
     * 脱水系统设计参数
     * @param factoryNo
     * @return
     */
    public JSONObject setTuoshui(String factoryNo) {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        TuoShuiEntity tuoshui = new TuoShuiEntity();
        if(tbFactoryInfo!=null){
            TbFactoryDehydrationSystem system = tbFactoryDehydrationSystemMapper.selectByPrimaryKey(tbFactoryInfo.getFactoryNo());
            if(system!=null){
                List<TbDict> dictList = getDictList();
                tuoshui.setUSERID(tbFactoryInfo.getFactoryCode()+"tb");
                //出生水质标准
                for (TbDict tbDict : dictList) {
                    // 污泥浓缩方式 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
                    if (system.getSludgeType() != null && tbDict.getParentId() == 58 && system.getSludgeType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudConcentrateType(tbDict.getValueName());
                    }
                    ////污泥脱水方式(含水量约80%) //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
                    if (system.getDehydrationType() != null && tbDict.getParentId() == 81 && system.getDehydrationType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudDeepDehydrationType(tbDict.getValueName());
                    }
                    //污泥预脱水方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
                    if (system.getDehydrationPreType() != null && tbDict.getParentId() == 88 && system.getDehydrationPreType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudPreDehydrationType(tbDict.getValueName());
                    }
                    // 污泥深度脱水方式(含水率约60%)  //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
                    if (system.getMudDepthDehydrationType() != null && tbDict.getParentId() == 94 && system.getMudDepthDehydrationType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudDeepDehydrationType(tbDict.getValueName());
                    }
                    // 污泥运输方式 1: 政府运输 2:自行运输       --父id  99
                    if (system.getMudTransportType() != null && tbDict.getParentId() == 99 && system.getMudTransportType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudTransport(tbDict.getValueName());
                    }
                    // 污泥处理方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
                    if (system.getMudHandleType() != null && tbDict.getParentId() == 102 && system.getMudHandleType().equals(tbDict.getKeyName())) {
                        tuoshui.setMudHandle(tbDict.getValueName());
                    }
                }
                //MudDesignDehydrationRate 脱水设计出泥含水率脱水设计出泥含水率  //todo  没有维护
                //tuoshui.setMudDeepDesignDehydrationRate();
                tuoshui.setMudPreDesignDehydrationRate(system.getPreDehydrationMudWaterRate());
                tuoshui.setMudDeepDesignDehydrationRate(system.getDepthDehydrationMudWaterRate());
            }
        }
        String url = path+"/api/SyncDataOracle/SetTuoShui";
        JSONObject json = JSONObject.parseObject(JSONObject.toJSON(tuoshui).toString());
        logger.info("脱水信息请求url={},数据json={}", url,json);
        JSONObject response = restTemplate.postForObject(url, json, JSONObject.class);
        logger.info("脱水信息结果json={}", response);
        return response;
    }



    @Override
    public List<TbFactoryInfo> getTbFactoryInfoNewList(TbFactoryInfo tbFactoryInfo) {
        List<TbDict> tbDicts = tbFactoryInfo.getTbDicts();
        List<TbOrg> tbOrgList = tbFactoryInfo.getTbOrgList();
        List<TbFactoryInfo> tbFactoryInfoList = new ArrayList<>();
        tbFactoryInfoList = getTbFactoryInfoData(tbFactoryInfo);
        for (TbFactoryInfo factoryInfo : tbFactoryInfoList) {
            String factoryNo = factoryInfo.getFactoryNo();
            TbFactoryInfoExtend tbFactoryInfoExtend = tbFactoryInfoExtendMapper.selectByPrimaryKey(factoryNo);
            if (tbFactoryInfoExtend != null) {
                BeanUtils.copyProperties(tbFactoryInfoExtend, factoryInfo);

            }
            TbFactoryWater tbFactoryWater = tbFactoryWaterMapper.selectByPrimaryKey(factoryNo);
            if (tbFactoryWater != null) {
                BeanUtils.copyProperties(tbFactoryWater, factoryInfo);
            }
            TbFactoryMeasureCaliber tbFactoryMeasureCaliber = tbFactoryMeasureCaliberMapper.selectByPrimaryKey(factoryNo);
            if (tbFactoryMeasureCaliber != null) {
                BeanUtils.copyProperties(tbFactoryMeasureCaliber, factoryInfo);
            }
            TbFactoryDehydrationSystem tbFactoryDehydrationSystem = tbFactoryDehydrationSystemMapper.selectByPrimaryKey(factoryNo);
            if (tbFactoryDehydrationSystem != null) {
                BeanUtils.copyProperties(tbFactoryDehydrationSystem, factoryInfo);
            }
            //业务大区
            if (tbOrgList != null && tbOrgList.size() > 0) {
                for (TbOrg tbOrg : tbOrgList) {
                    if (factoryInfo.getRegion() != null) {
                        if (factoryInfo.getRegion().equals(tbOrg.getCode())) {
                            factoryInfo.setRegionName(tbOrg.getName());
                        }
                    }
                }
            }
            //水厂等级
            if (tbDicts != null && tbDicts.size() > 0) {
                for (TbDict tbDict : tbDicts) {
                    //水厂 父id 55
                    if (factoryInfo.getLevel() != null) {
                        if (factoryInfo.getLevel().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 55) {
                            factoryInfo.setLevelName(tbDict.getValueName());
                        }
                    }
                    //projectType 父id  57
                    if (factoryInfo.getProjectType() != null) {
                        if (factoryInfo.getProjectType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 57) {
                            factoryInfo.setProjectTypeName(tbDict.getValueName());
                        }
                    }
                    //是否集团运营 1运营 是  0：不运营 否 父id 117
                    if (factoryInfo.getOperateType() != null) {
                        if (factoryInfo.getOperateType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 117) {
                            factoryInfo.setOperateTypeName(tbDict.getValueName());
                        }
                    }
                    //父id 56
                    if (factoryInfo.getWaterQualityNormOut() != null) {
                        if (factoryInfo.getWaterQualityNormOut().equals(tbDict.getKeyName()) && tbDict.getParentId() == 56) {
                            factoryInfo.setWaterQualityNormOutName(tbDict.getValueName());
                        }
                    }
                    //运营起始时间
                    if (factoryInfo.getBusinessStartTime() != null) {
                        factoryInfo.setBusinessStartTimeName(DateUtils.formateDatePartNo(factoryInfo.getBusinessStartTime()));
                    }
                    //项目退出时间
                    if (factoryInfo.getProjectExitTime() != null) {
                        factoryInfo.setProjectExitTimeName(DateUtils.formateDatePartNo(factoryInfo.getProjectExitTime()));
                    }
                    //计量口径 // 1:进水 2:出水 3:其他    -- (父id 65)
                    if (factoryInfo.getMeasureCaliberType() != null) {
                        if (factoryInfo.getMeasureCaliberType().equals(tbDict.getKeyName()) && tbDict.getParentId() == 65) {
                            factoryInfo.setMeasureCaliberTypeName(tbDict.getValueName());
                        }
                    }
                    // 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
                    if (factoryInfo.getSludgeType() != null) {
                        if (factoryInfo.getSludgeType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 58) {
                            factoryInfo.setSludgeTypeName(tbDict.getValueName());
                        }
                    }
                    ////1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
                    if (factoryInfo.getDehydrationType() != null) {
                        if (factoryInfo.getDehydrationType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 81) {
                            factoryInfo.setDehydrationTypeName(tbDict.getValueName());
                        }
                    }
                    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
                    if (factoryInfo.getDehydrationPreType() != null) {
                        if (factoryInfo.getDehydrationPreType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 88) {
                            factoryInfo.setDehydrationPreTypeName(tbDict.getValueName());
                        }
                    }
                    //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
                    if (factoryInfo.getMudDepthDehydrationType() != null) {
                        if (factoryInfo.getMudDepthDehydrationType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 94) {
                            factoryInfo.setMudDepthDehydrationTypeName(tbDict.getValueName());
                        }
                    }
                    // 1: 政府运输 2:自行运输       --父id  99
                    if (factoryInfo.getMudTransportType() != null) {
                        if (factoryInfo.getMudTransportType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 99) {
                            factoryInfo.setMudTransportTypeName(tbDict.getValueName());
                        }
                    }
                    //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
                    if (factoryInfo.getMudHandleType() != null) {
                        if (factoryInfo.getMudHandleType().toString().equals(tbDict.getKeyName()) && tbDict.getParentId() == 102) {
                            factoryInfo.setMudHandleTypeName(tbDict.getValueName());
                        }
                    }
                }

            }
        }
        return tbFactoryInfoList;
    }

    @Override
    public List<TbFactoryTime> getTbFactroyTimeList(TbFactoryTime tbFactoryTime) {
        TbFactoryTimeExample example = new TbFactoryTimeExample();
        TbFactoryTimeExample.Criteria criteria =  example.createCriteria();
        criteria.andFactoryNoEqualTo(tbFactoryTime.getFactoryNo()).andFlagEqualTo(0);
        if(tbFactoryTime.getTimeType()!=null){
            criteria.andTimeTypeEqualTo(tbFactoryTime.getTimeType());
        }
        example.setOrderByClause(" time_type, time_sort");

        List<TbFactoryTime> tbFactoryTimeList = tbFactoryTimeMapper.selectTbFactroyTimeList(tbFactoryTime);
        for (TbFactoryTime factoryTime : tbFactoryTimeList) {
            if (getInteger(factoryTime.getStartTimePoint()) > getInteger(factoryTime.getEndTimePoint())) {
                factoryTime.setDayTimeType("次日");
            } else {
                factoryTime.setDayTimeType("本日");
            }
        }
        return tbFactoryTimeList;
    }

    @Override
    public int saveTbFactoryTime( String factoryNo, Integer timeType, String timePoints, TbUser user ) throws Exception {
        TbFactoryTimeExample example = new TbFactoryTimeExample();
        example.createCriteria().andFactoryNoEqualTo(factoryNo).andFlagEqualTo(0).andTimeTypeEqualTo(timeType);
        //设备排班
        String[] timePointList = timePoints.split(",");
        if(timeType.equals(2) || timeType.equals(3)){
            if(timePointList.length!=2){
                return Dict.AjaxStatus.FACTORY_TIME_COUNT_ERROR.getStatusCode();
            }
            tbFactoryTimeMapper.deleteByExample(example);
            TbFactoryTime factoryTime = new TbFactoryTime();
            factoryTime.setTimeNo(StringTools.getUUID());
            factoryTime.setStartTimePoint(timePointList[0]);
            factoryTime.setEndTimePoint(timePointList[1]);
            factoryTime.setCreateTime(new Date());
            factoryTime.setFactoryNo(factoryNo);
            factoryTime.setCreateUserCode(user.getCode());
            factoryTime.setCreateUserName(user.getName());
            factoryTime.setTimeType(timeType);
            factoryTime.setTimeSort(1);
            factoryTime.setFlag(DELETE_NO);
            tbFactoryTimeMapper.insertSelective(factoryTime);
            return Dict.AjaxStatus.YES.getStatusCode();

        }else if(timeType.equals(1)){
            if(timePointList.length==1||timePointList.length>3){
                return Dict.AjaxStatus.FACTORY_TIME_EQUIP_HAS.getStatusCode();
            }
            tbFactoryTimeMapper.deleteByExample(example);
            for(int i=0;i<timePointList.length;i++){
                TbFactoryTime factoryTime = addNewFactoryTime(factoryNo, timeType, user, timePointList, i);
                tbFactoryTimeMapper.insertSelective(factoryTime);
            }
            return Dict.AjaxStatus.YES.getStatusCode();
        }
        return Dict.AjaxStatus.YES.getStatusCode();

    }

    private TbFactoryTime addNewFactoryTime(String factoryNo,Integer timeType, TbUser user, String[] timePointList, int i) {
        TbFactoryTime factoryTime = new TbFactoryTime();
        factoryTime.setTimeNo(StringTools.getUUID());
        factoryTime.setStartTimePoint(timePointList[i]);
        if(i==timePointList.length-1){
            factoryTime.setEndTimePoint(timePointList[0]);
        }else{
            factoryTime.setEndTimePoint(timePointList[i+1]);
        }
        factoryTime.setCreateTime(new Date());
        factoryTime.setFactoryNo(factoryNo);
        factoryTime.setCreateUserCode(user.getCode());
        factoryTime.setCreateUserName(user.getName());
        factoryTime.setTimeType(timeType);
        factoryTime.setTimeSort(1+i);
        factoryTime.setFlag(DELETE_NO);
        return factoryTime;
    }

    @Override
    public  Map<String,Object>   getFactoryTimeDetail(String factoryNo, Integer timeType ){
        List<TbFactoryTime> oldFactoryTimeList = getFactoryTimeList(factoryNo,timeType);
        Map<String,Object> map = new HashMap<>();
        if(oldFactoryTimeList.size()>0){
            if(oldFactoryTimeList.size()>0
                    && (oldFactoryTimeList.get(0).getTimeType().equals(2)||oldFactoryTimeList.get(0).getTimeType().equals(3))){
                String[] timePoints = new String[2];
                timePoints[0] = oldFactoryTimeList.get(0).getStartTimePoint();
                timePoints[1] = oldFactoryTimeList.get(0).getEndTimePoint();
                map.put("timePoints",timePoints);
            }else if(oldFactoryTimeList.size()>1 && oldFactoryTimeList.get(0).getTimeType().equals(1)){
                List<String> list = new ArrayList<>();
                if(oldFactoryTimeList.size()<4){
                    for(int i=0;i<oldFactoryTimeList.size();i++){
                        list.add(oldFactoryTimeList.get(i).getStartTimePoint());
                    }
                }else{
                    for(int i=0;i<3;i++){
                        list.add(oldFactoryTimeList.get(i).getStartTimePoint());
                    }
                }
                map.put("timePoints",list);
            }
        }
        return map;
    }
    private List<TbFactoryTime> getFactoryTimeList(String factoryNo,Integer type){
        TbFactoryTimeExample factoryTimeExample = new TbFactoryTimeExample();
        factoryTimeExample.createCriteria().andFactoryNoEqualTo(factoryNo).andTimeTypeEqualTo(type).andFlagEqualTo(DELETE_NO);
        factoryTimeExample.setOrderByClause(" time_sort ");
        return tbFactoryTimeMapper.selectByExample(factoryTimeExample);
    }

    public Integer getInteger(String str) {
        String string = str.split(":")[0];
        String string2 = str.split(":")[1];
        return Integer.valueOf(string + string2);
    }


    @Override
    public int deleteTbFactoryTime(String timeNo) {
        int flag = 0;
        flag = tbFactoryTimeMapper.deleteByPrimaryKey(timeNo);
        return flag;
    }

    @Override
    public int saveTbFactoryChildren(TbFactoryInfo tbFactoryInfo) {
        List<Integer> parentList = new ArrayList<>();
        parentList.add(148);
        List<TbDict> tbDicts = tbDictService.getDictByParent(parentList);
        String name = "";
        for (TbDict tbDict : tbDicts) {
            if (tbFactoryInfo.getIssueNo() != null) {
                if (tbDict.getKeyName().equals(tbFactoryInfo.getIssueNo().toString())) {
                    name = tbDict.getValueName();
                }
            }
        }
        int flag = 0;
        List<TbFactoryInfo> tbFactoryInfoList = checkTbFactoryInfo(tbFactoryInfo);
        if (tbFactoryInfoList != null && tbFactoryInfoList.size() > 0) {
            flag = Dict.AjaxStatus.RE_CREATE.getStatusCode();
        } else {
            if (tbFactoryInfo.getFactoryNo() != null) {
                TbFactoryInfo tbFactoryInfoDb = tbFactoryInfoMapper.selectByPrimaryKey(tbFactoryInfo.getFactoryNo());
                if (tbFactoryInfoDb != null) {
                    tbFactoryInfo.setParentFactoryNo(tbFactoryInfoDb.getFactoryNo());
                    String uuid = StringTools.getUUID();
                    tbFactoryInfo.setFactoryNo(uuid);
                    tbFactoryInfo.setFactoryName(tbFactoryInfoDb.getFactoryName() + name);
                    String uri = tbFactoryInfoDb.getUri();
                    if (uri != null) {
                        String[] split = uri.split("/");
                        tbFactoryInfo.setUri("/" + split[1] + "/" + uuid);
                    }
                    tbFactoryInfo.setBrowsepath(tbFactoryInfoDb.getBrowsepath());
                    tbFactoryInfo.setBrowsename(tbFactoryInfoDb.getBrowsename() + "_" + tbFactoryInfo.getIssueNo());
                    tbFactoryInfo.setCreateTime(new Date());
                    tbFactoryInfo.setLevel(tbFactoryInfoDb.getLevel());
                    flag = tbFactoryInfoMapper.insertSelective(tbFactoryInfo);
                }
            }
        }
        return flag;
    }

    public List<TbFactoryInfo> checkTbFactoryInfo(TbFactoryInfo tbFactoryInfo) {
        TbFactoryInfoExample example = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = example.createCriteria();
        if (tbFactoryInfo.getIssueNo() != null) {
            criteria.andIssueNoEqualTo(tbFactoryInfo.getIssueNo());
        }
        if (tbFactoryInfo.getFactoryNo() != null) {
            criteria.andParentFactoryNoEqualTo(tbFactoryInfo.getFactoryNo());
        }
        return tbFactoryInfoMapper.selectByExample(example);
    }

    @Override
    public List<TbFactoryInfo> getFactoryInfoByNoNew(String factoryNo) {
        return tbFactoryInfoMapper.selectByPrimaryKeyNew(factoryNo);
    }

    @Override
    public List<String> getFactoryOrg(String factoryCode) {
        List<String> orgList = new ArrayList<>();
        TbOrg factoryOrg = orgMapper.selectByPrimaryKey(factoryCode);
        getFacotryOrgList(orgList, factoryOrg.getParentCode());
        String factoryNo = factoryOrg.getUri().split("/")[2];
        TbFactoryInfo factoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        if (!StringUtils.isEmpty(factoryInfo.getOrgGroupNo())) {
            OrgGroupInfo orgGroupInfo = getGroupInfoByNo(factoryInfo.getOrgGroupNo());
            orgList.add(0, orgGroupInfo.getGroupName());
        }

        return orgList;
    }

    private OrgGroupInfo getGroupInfoByNo(String groupNo) {
        OrgGroupInfoExample example = new OrgGroupInfoExample();
        example.createCriteria().andGroupNoEqualTo(groupNo);
        List<OrgGroupInfo> list = orgGroupInfoMapper.selectByExample(example);
        return list.size() == 1 ? list.get(0) : null;
    }


    private void getFacotryOrgList(List<String> list, String orgCode) {
        TbOrg org = orgMapper.selectByPrimaryKey(orgCode);
        list.add(org.getName());
        if (!org.getParentCode().equals("0")) {
            getFacotryOrgList(list, org.getParentCode());
        }
    }

    @Override
    public List<TbFactoryInfo> getChildFactroy(String factoryNo) {
        TbFactoryInfo tbFactoryInfo = new TbFactoryInfo();
        tbFactoryInfo.setFactoryNo(factoryNo);
        return checkTbFactoryInfo(tbFactoryInfo);
    }

    @Override
    public int delChildFactroy(String factoryNo) {
        int flag = 0;
        flag = tbFactoryInfoMapper.deleteByPrimaryKey(factoryNo);
        if (flag == 1) {
            //水厂 水厂拓展表
            //flag = saveTbFactoryInfoExtend(tbFactoryInfoVo, factoryNo, flag);
            tbFactoryInfoExtendMapper.deleteByPrimaryKey(factoryNo);
            //水厂 水厂进出水表
            // flag = saveTbFactoryWater(tbFactoryInfoVo, factoryNo, flag);
            TbFactoryWaterExample example = new TbFactoryWaterExample();
            TbFactoryWaterExample.Criteria criteria = example.createCriteria();
            criteria.andFactoryNoEqualTo(factoryNo);
            tbFactoryWaterMapper.deleteByExample(example);
            //水厂 计量口径-水厂拓展表
            //flag = saveTbFactoryMeasureCaliber(tbFactoryInfoVo, factoryNo, flag);
            tbFactoryMeasureCaliberMapper.deleteByPrimaryKey(factoryNo);
            //水厂 脱水系统设计参数
            //flag = saveTbFactoryDehydrationSystem(tbFactoryInfoVo, factoryNo, flag);
            TbFactoryDehydrationSystemExample exampleSys = new TbFactoryDehydrationSystemExample();
            TbFactoryDehydrationSystemExample.Criteria criteriaSys = exampleSys.createCriteria();
            criteriaSys.andFactoryNoEqualTo(factoryNo);
            tbFactoryDehydrationSystemMapper.deleteByExample(exampleSys);
        }
        return flag;
    }

    @Override
    public int setFactoryVideo(String factoryNo, String videoId) {
        TbFactoryVideo factoryVideo = factoryVideoMapper.selectByPrimaryKey(factoryNo);
        if(factoryVideo==null){
            factoryVideo = new TbFactoryVideo();
            factoryVideo.setFactoryNo(factoryNo);
            factoryVideo.setVideoId(videoId);
            factoryVideo.setHasvideo(1);
            return factoryVideoMapper.insertSelective(factoryVideo);
        }else{
            factoryVideo.setVideoId(videoId);
            return factoryVideoMapper.updateByPrimaryKey(factoryVideo);
        }
    }


}

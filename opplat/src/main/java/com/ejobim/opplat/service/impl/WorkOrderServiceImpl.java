package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import com.ejobim.opplat.domain.enums.ErrorMsg;
import com.ejobim.opplat.domain.vo.TaskVo;
import com.ejobim.opplat.domain.vo.TbFillFormFieldVo;
import com.ejobim.opplat.domain.vo.TbTaskInfoVo;
import com.ejobim.opplat.exception.RestException;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.notify.NoticeService;
import com.ejobim.opplat.service.WorkOrderService;
import com.ejobim.opplat.util.ClassTools;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.HttpClientUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author  xibian
 * @date 2019-05-10
 */
@Service
@Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
public class WorkOrderServiceImpl implements WorkOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private TbRepairInfoMapper tbRepairInfoMapper;

    @Autowired
    private TbWorkOrderInfoMapper tbWorkOrderInfoMapper;

    @Autowired
    private TbTaskInfoMapper tbTaskInfoMapper;

    @Autowired
    private TbFillFormTaskMapper tbFillFormTaskMapper;

    @Autowired
    private TbFillFormFieldMapper tbFillFormFieldMapper;

    @Autowired
    private TbFillFormDetailMapper  tbFillFormDetailMapper;
    
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbWorkOrderTempMapper workOrderTempMapper;
    
    @Autowired
    private TbWorkTaskInfoMapper tbWorkTaskInfoMapper;

    @Autowired
    private TDictMapper tDictMapper;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;

    @Value("${nofity.appPush}")
    private boolean appPath;

    @Override
    public List<TbRepairInfo> getTbRepairInfoList(String groupNo, String date) {
        TbRepairInfoExample tbRepairInfoExample = new TbRepairInfoExample();
        TbRepairInfoExample.Criteria criteria = tbRepairInfoExample.createCriteria();
        Date beginDate = DateUtils.parseDate(date);
        Date endDate = DateUtils.getNextDate(date);
        criteria.andRepairTimeBetween(beginDate,endDate);
        return tbRepairInfoMapper.selectByExample(tbRepairInfoExample);
    }
    @Override
    public List<TbWorkOrderInfo> getTbWorkOrderInfoList(String userNo, String date) {
        TbWorkOrderInfoExample tbWorkOrderInfoExample = new TbWorkOrderInfoExample();
        TbWorkOrderInfoExample.Criteria criteria = tbWorkOrderInfoExample.createCriteria();
        criteria.andUserNoEqualTo(userNo);
        Date beginDate = DateUtils.parseDate(date);
        Date endDate = DateUtils.getNextDate(date);
        criteria.andCreateTimeBetween(beginDate,endDate);
        return tbWorkOrderInfoMapper.selectByExample(tbWorkOrderInfoExample);
    }
    @Override
    public int saveTbRepairInfo(TbTaskInfo tbTaskInfo,TbRepairInfo tbRepairInfo) {
        if(tbTaskInfo.getTaskNo()==null){
            tbTaskInfo.setTaskNo(StringTools.getUUID());
            return tbTaskInfoMapper.insert(tbTaskInfo);
        }else{
            return tbTaskInfoMapper.updateByPrimaryKeySelective(tbTaskInfo);
        }

    }

    @Override
    public int saveTbWorkOrderInfo(TbWorkOrderInfo tbWorkOrderInfo) {
        return tbWorkOrderInfoMapper.insert(tbWorkOrderInfo);
    }

    @Override
    public List<TbTaskInfo> getTbTaskList(String userNo) {
        TbTaskInfoExample tbTaskInfoExample = new TbTaskInfoExample();
        TbTaskInfoExample.Criteria criteria  = tbTaskInfoExample.createCriteria();
        criteria.andCreateUserNoEqualTo(userNo);
        tbTaskInfoExample.setOrderByClause(" finish_time desc ");
        return tbTaskInfoMapper.selectByExample(tbTaskInfoExample);
    }
    @Override
    public Map<String,Integer> getTaskInfoList(TaskInfoCondition condition) {
        List<TbTaskInfoVo> tbTaskInfoVos = tbTaskInfoMapper.selectTaskInfoList(condition);
        //未完成
        Map<String,Integer> map = new HashMap();
        for (TbTaskInfoVo tbTaskInfoVo:tbTaskInfoVos){
            if(tbTaskInfoVo.getTaskStatus()==0){
                //任务进行中待完成
                String key=DateUtils.formateDate(tbTaskInfoVo.getEndTime());
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }
        }
        return map;
    }
    @Override
    public List<TbTaskInfo> getCurrentTaskInfo(String currentTime) {
        List<TbTaskInfo> tbTaskInfos = new ArrayList<>();
        TbTaskInfoExample tbTaskInfoExample = new TbTaskInfoExample();
        TbTaskInfoExample.Criteria criteria  = tbTaskInfoExample.createCriteria();
        criteria.andEndTimeEqualTo(DateUtils.parseDate(currentTime));
        tbTaskInfoExample.setOrderByClause(" end_time desc ");
        tbTaskInfos =tbTaskInfoMapper.selectByExample(tbTaskInfoExample);
        TDictExample tDictExample = new TDictExample();
        TDictExample.Criteria criteria1 = tDictExample.createCriteria();
        criteria1.andTableNameEqualTo("tb_task_info");
        criteria1.andFieldNameEqualTo("taskType");
        criteria1.andKeyyBetween(1L,2L);
        List<TDict> tDicts = tDictMapper.selectByExample(tDictExample);
        tbTaskInfos.forEach(tbTaskInfo -> {
            for(TDict tDict: tDicts){
                if(tbTaskInfo.getTaskType().toString().equals(tDict.getKeyy().toString())){
                    tbTaskInfo.setTaskTypeName(tDict.getValuee());
                }
            }
        });
        return tbTaskInfos;
    }
    @Override
    public Map<String,Object> getCurrentMouthTaskInfo() {
        Map<String,Object> objectMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        List<TbTaskInfo> list = tbTaskInfoMapper.getCurrentMouthTaskInfo();
        for (TbTaskInfo tbTaskInfo: list){
            if(tbTaskInfo.getTaskStatus()==0){
                String key ="noFinsh";
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }else if (tbTaskInfo.getTaskStatus()==1){
                String key ="finsh";
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }
        }
        objectMap.putAll(map);
        return objectMap;
    }
    /**
     * 获取今日的任务列表
     * @param date
     * @return
     */
    @Override
    public List<TbFillFormTask> findTodayFillTaskInfoList( TbFillFormTask tbFillFormTask,String date,String userCode ) {
        TbFillFormTaskExample example = new TbFillFormTaskExample();
        TbFillFormTaskExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(date)){
            Date startDate = DateUtils.parseDate(date);
            Date endDate = DateUtils.parseDateFull(date + " 23:59:59" );
            criteria.andFillTaskTimeBetween(startDate,endDate);
        }
        if(StringUtils.isNotEmpty(tbFillFormTask.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(tbFillFormTask.getFactoryNo());
        }
        if(tbFillFormTask.getTaskType()==null){
            criteria.andTaskTypeEqualTo(1);
        }else{
            criteria.andTaskTypeEqualTo(tbFillFormTask.getTaskType());
        }

        if(tbFillFormTask.getFillTaskNo()!=null){
            criteria.andFillTaskNoEqualTo(tbFillFormTask.getFillTaskNo());
        }
        criteria.andFillTaskUserNoEqualTo(userCode);
        criteria.andStatusGreaterThan(Dict.TASK_STATUS_UNDEPLOY);
        example.setOrderByClause(" fill_task_time");
        return tbFillFormTaskMapper.selectByExample(example);
    }
    @Override
    public List<TbFillFormDetail> findFillTaskDetailList(String fillTaskNo,String uri) {
        TbFillFormDetailExample example = new TbFillFormDetailExample();
        TbFillFormDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTaskNoEqualTo(fillTaskNo);
        if(StringUtils.isNotEmpty(uri)){
            criteria.andEquipNoEqualTo(uri);
        }
        example.setOrderByClause("type,field_code ");
        List<TbFillFormDetail> list  = tbFillFormDetailMapper.selectByExample(example);

        return list;
    }
    @Override
    public TbFillFormTask getTbFillTaskByKey(String taskNo) {
        return tbFillFormTaskMapper.getTbFillFormTaskByKey(taskNo);
    }
    public String getRate ( BigDecimal a ,BigDecimal b) {
        String percent = b == null ? "-" :b.compareTo(new BigDecimal(0)) == 0 ? "-":
                                a == null ? "0.00%" :a.multiply(new BigDecimal(100)).divide(b,2,BigDecimal.ROUND_HALF_UP) + "%";
            return percent;
    }
    @Override
    public List<TbFillFormFieldVo> findFillTaskConfigList(String factoryNo, String taskNo, String param) {
        //任务明细表查
        List<TbFillFormFieldVo> tbFillFormFieldVoList = new ArrayList<>();
        //任务配置表
        List<TbFillFormField> tbFillFormFields = new ArrayList<>();
        //添加逻辑校验
        JSONArray jsonArray = new JSONArray();
        for (TbFillFormField tbFillFormConfig: tbFillFormFields) {
            jsonArray.add(tbFillFormConfig.getBrowsePath());
        }
        //调用实时请求接口
        JSONObject result = HttpClientUtils.httpPost("http://model-bewg-bewg.huawei.bewg.hiacloud.net.cn:80/aggquery/query/queryCurrent", jsonArray.toString());
        JSONArray resultArray = result.getJSONArray("result");
        for(int i=0;i<tbFillFormFields.size();i++){
            TbFillFormField tbFillFormField = tbFillFormFields.get(i);
            JSONObject jsonObject = resultArray.getJSONObject(i);
            TbFillFormFieldVo tbFillFormFieldVo = new TbFillFormFieldVo();
            ClassTools.mergeObject(tbFillFormField, tbFillFormFieldVo);
            String value = jsonObject.getString("v");
            String time = jsonObject.getString("t");
            if (value != null) {
                tbFillFormFieldVo.setFiledValue(value);
            }
            if (time != null) {
                tbFillFormFieldVo.setTime(DateUtils.stampToDate(time));
            }
            tbFillFormFieldVoList.add(tbFillFormFieldVo);

        }
        return tbFillFormFieldVoList;
    }

    @Override
    public List<TbFillFormField> findAllFillTaskConfigList(String factoryNo,String uri) {
        TbFillFormFieldExample example = new TbFillFormFieldExample();
        TbFillFormFieldExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        criteria.andConfigNoEqualTo(uri);
        //List<TbFillFormField> tbFillFormConfigList = tbFillFormFieldMapper.findAllFillTaskConfigList(factoryNo,uri);
        return null;
    }

    @Override
    @Transactional(rollbackFor = RestException.class)
    public void saveTbFillFormDetail(List<TbFillFormDetail> tbFormDataList) throws RestException {
        String taskNo="";
        //校验是否在最大和最小值之间
        for(TbFillFormDetail tbFormData:tbFormDataList){
                String factoryNo = tbFormData.getFactoryNo();
            String fieldCode1 = tbFormData.getFieldCode();
            Double fieldValue = tbFormData.getFieldValue();
            if(fieldValue<0){
                throw new RestException(ErrorMsg.PARAMETER_NUM);
            }
                taskNo =tbFormData.getTaskNo();
                tbFormData.setFillFormDetailNo(StringTools.getUUID());
                tbFormData.setCreateTime(new Date());
                tbFormData.setFormDate(new Date());
                tbFillFormDetailMapper.insertSelective(tbFormData);
                //通过任务taskNo修改
        }
//        int i = tbFillFormTaskMapper.updateByTaskNo(taskNo,tbFormDataList.size());
//        if(i<=0){
//            throw new RestException(ErrorMsg.PARAMETER_NOEXIST);
//        }
    }

    //获取配置项信息
    public  List<TbFillFormField> getTbFillFormConfig(String factoryNo){
        List<TbFillFormField> tbFillFormFields = new ArrayList<>();
        TbFillFormFieldExample example = new TbFillFormFieldExample();
        TbFillFormFieldExample.Criteria criteria  = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        criteria.andConfigStatusEqualTo(0);//0:生效 1;失效
        example.setOrderByClause(" create_time desc ");
        tbFillFormFields = tbFillFormFieldMapper.selectByExample(example);
        return tbFillFormFields;
    }

    @Override
    public List<TbTaskInfo> getPendingTaskList(String currentTime) {
        List<TbTaskInfo> tbTaskInfos = new ArrayList<>();
        TbTaskInfoExample tbTaskInfoExample = new TbTaskInfoExample();
        TbTaskInfoExample.Criteria criteria  = tbTaskInfoExample.createCriteria();
        if(StringUtils.isEmpty(currentTime)){
            criteria.andEndTimeEqualTo(new Date());
        }else{
            criteria.andEndTimeEqualTo(DateUtils.parseDate(currentTime));
        }/**/
        tbTaskInfoExample.setOrderByClause(" end_time desc ");
        tbTaskInfos =tbTaskInfoMapper.selectByExample(tbTaskInfoExample);
        return tbTaskInfos;

    }

    @Override
    public List<TbTaskInfo> getTaskList(TbTaskInfo condition) {
        return tbTaskInfoMapper.selectTaskList(condition);
    }


    @Override
    public List<TbFillFormDetail> selectTbFillFormDetailByFactroyNo(String factroyNo) {
        return tbFillFormDetailMapper.selectTbFillFormDetailByFactroyNo(factroyNo);
    }

    @Override
    public List<TbFillFormTask> findTbFillFormTaskList(TbFillFormTask tbFillFormTask,String beginTime,String endTime,List<String> factoryList) {
        List<TbFillFormTask> tbFillFormTasks = tbFillFormTaskMapper.selectTbFillFormTaskList(tbFillFormTask,beginTime,endTime,factoryList);
        return tbFillFormTasks;
    }
    @Override
    public int updateTbFillFormTaskStatus(String[] ids,String userCode, String userName) {
        int i=0;
        for (String id : ids) {
            TbFillFormTask tbFillFormTask = new TbFillFormTask();
            tbFillFormTask.setFillTaskNo(id);
            tbFillFormTask.setStatus(1);
            tbFillFormTask.setFillUserName(userName);
            tbFillFormTask.setFillUser(userName);
            tbFillFormTask.setFillTaskUserNo(userCode);
             i = tbFillFormTaskMapper.updateByPrimaryKeySelective(tbFillFormTask);
        }
        return i;
    }

    @Override
    public int checkTbFillFormTask(String fillTaskNo,TbUser user) {
        int flag=0;
        //查询
        TbFillFormTask tbFillFormTask = tbFillFormTaskMapper.getTbFillFormTaskByKey(fillTaskNo);
        TbFillFormTask fillFormTask = new TbFillFormTask();
        if(tbFillFormTask.getStatus()==4){
            //正常完成
            fillFormTask.setStatus(5);
        }else{
            //超时完成
            fillFormTask.setStatus(7);
        }
        fillFormTask.setFillTaskNo(fillTaskNo);
        fillFormTask.setCheckUser(user.getCode());
        fillFormTask.setCheckUserName(user.getName());
        flag = tbFillFormTaskMapper.updateByPrimaryKeySelective(fillFormTask);
        return flag;
    }

    @Override
    public int rejectTbFillFormTask(String fillTaskNo, TbUser user) {
        int flag=0;
        //查询
        TbFillFormTask tbFillFormTask = tbFillFormTaskMapper.getTbFillFormTaskByKey(fillTaskNo);
        TbFillFormTask fillFormTask = new TbFillFormTask();
        if(tbFillFormTask.getStatus()==4){
            //正常完成驳回
            fillFormTask.setStatus(11);
        }else{
            //超时完成驳回
            fillFormTask.setStatus(12);
        }
        fillFormTask.setFillTaskNo(fillTaskNo);
        fillFormTask.setCheckUser(user.getCode());
        fillFormTask.setCheckUserName(user.getName());
        flag = tbFillFormTaskMapper.updateByPrimaryKeySelective(fillFormTask);
        return flag;
    }

    public String getUserName(String code){
        String name =null;
        if(tbUserMapper.selectByPrimaryKey(code)!=null){
            name= tbUserMapper.selectByPrimaryKey(code).getName();
        }
        return  name;
    }
    @Override
    public List<TbWorkTaskInfo> getTaskALlList(TaskInfoCondition condition) {
        List<TbWorkTaskInfo> tbWorkTaskInfos = new ArrayList<>();
        tbWorkTaskInfos =tbWorkTaskInfoMapper.selectTbWorkTaskInfoByJson(condition);
        return tbWorkTaskInfos;
    }
    
    @Override
    public List<TbWorkOrderTemp> getWorkOrderTempList(TbWorkOrderTemp workOrderTemp, Date startTime, Date endTime,int finishType) {
        TbWorkOrderTempExample example = new TbWorkOrderTempExample();
        TbWorkOrderTempExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(workOrderTemp.getOrderFactoryNo())){
            criteria.andOrderFactoryNoEqualTo(workOrderTemp.getOrderFactoryNo());
        }
        if(StringUtils.isNotEmpty(workOrderTemp.getCreateUser())){
            criteria.andCreateUserEqualTo(workOrderTemp.getCreateUser());
        }
        if(StringUtils.isNotEmpty(workOrderTemp.getOrderDuty())){
            criteria.andOrderDutyEqualTo(workOrderTemp.getOrderDuty());
        }
        if(StringUtils.isNotEmpty(workOrderTemp.getOrderName())){
            criteria.andOrderNameLike("%"+workOrderTemp.getOrderName()+"%" );
        }
        if(startTime!=null && endTime!=null){
            criteria.andCreateTimeBetween(startTime,endTime);
        }else if(startTime!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(startTime);
        }else if(endTime!=null){
            criteria.andCreateTimeLessThanOrEqualTo(endTime);
        }
        if(finishType==1){ //未完成
            criteria.andOrderFinishTimeIsNull();
        }else if(finishType==2){ //已完成
            criteria.andOrderFinishTimeIsNotNull();
        }
        example.setOrderByClause(" order_finish_time desc");

        return workOrderTempMapper.selectByExample(example);
    }

    @Override
    public int addWorkOrderTemp(TbWorkOrderTemp workOrderTemp) {
        int flag = 0;
        flag =workOrderTempMapper.insertSelective(workOrderTemp);
        if(flag==1){
            sendMessage(workOrderTemp);
        }
        return flag;
    }

    public void sendMessage(TbWorkOrderTemp workOrderTemp){
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0]=workOrderTemp.getOrderDuty();
            params.targets =codes;
            params.title="临时工单";
            params.body="有一条新的临时工单下发给您，请及时查看并执行";
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",8);
            extParameters.put("factoryNo",workOrderTemp.getOrderFactoryNo());
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workOrderTemp.getOrderFactoryNo());
            if(tbFactoryInfo!=null){
                extParameters.put("factoryName", tbFactoryInfo.getFactoryName());
            }
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("临时工单通知Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("临时工单通知成功用户userName={}", workOrderTemp.getOrderDutyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int updateWorkOrderTemp(TbWorkOrderTemp workOrderTemp) {
        int flag=0;
        TbWorkOrderTemp workOrderTempQ = workOrderTempMapper.selectByPrimaryKey(workOrderTemp.getOrderId());
        flag =workOrderTempMapper.updateByPrimaryKeySelective(workOrderTemp);
        if(flag==1){
            sendCreateUserMessage(workOrderTempQ);
        }
        return flag;
    }
    public void sendCreateUserMessage(TbWorkOrderTemp workOrderTemp){
        try {
            NoticeService.PostParams params = new NoticeService.PostParams();
            String[] codes = new String[1];
            codes[0]=workOrderTemp.getCreateUser();
            params.targets =codes;
            params.title="临时工单执行提交";
            params.body="您创建的临时工单"+"["+workOrderTemp.getOrderName()+"]"+"已完成执行";
            Map<String, Object> extParameters = new HashMap<>(16);
            extParameters.put("taskType",8);
            extParameters.put("factoryNo",workOrderTemp.getOrderFactoryNo());
            TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(workOrderTemp.getOrderFactoryNo());
            if(tbFactoryInfo!=null){
                extParameters.put("factoryName", tbFactoryInfo.getFactoryName());
            }
            params.extParameters=extParameters;
            params.appPush=false;
            logger.info("临时工单执行提交Params={}", JSON.toJSONString(params));
            noticeService.post(params);
            logger.info("临时工单执行提交通知成功用户userName={}", workOrderTemp.getCreateUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public TbWorkOrderTemp getWorkOrderTempDetail(String ordId) {
        TbWorkOrderTemp workOrderTemp = workOrderTempMapper.selectByPrimaryKey(ordId);
        return workOrderTemp;
    }

    @Override
    public List<TaskVo> getTaskAllListNew(TaskInfoCondition condition) {
        return tbWorkTaskInfoMapper.selectTbWorkTaskInfoByJsonNew(condition);
    }
}

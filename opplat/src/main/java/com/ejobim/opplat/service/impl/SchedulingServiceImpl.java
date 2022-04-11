package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.config.SchedulingConfig;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.TbSchedulingPlanCondition;
import com.ejobim.opplat.domain.condition.TbWorkTaskInfoCondition;
import com.ejobim.opplat.domain.vo.Amount;
import com.ejobim.opplat.domain.vo.TbDataVo;
import com.ejobim.opplat.domain.vo.TbSchedulingPlanVo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.SchedulingService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.Dict.DELETE_NO;

@Service
public class SchedulingServiceImpl  implements SchedulingService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int flag=0;

    //提前30天排班
    private static int SCHEDULE_DATE_COUNT = 30;

    @Autowired
    private TbGroupInfoMapper tbGroupInfoMapper;

    @Value("${minute}")
    private Long minute;

    @Autowired
    private TbGroupDetailMapper tbGroupDetailMapper;

    @Autowired
    private TbSchedulingPlanMapper tbSchedulingPlanMapper;

    @Autowired
    private TbSchedulingPlanDeatailMapper tbSchedulingPlanDeatailMapper;

    @Autowired
    private TbSchedulingChangeMapper tbSchedulingChangeMapper;

    @Autowired
    private TbSchedulingTransferMapper tbSchedulingTransferMapper;

    @Autowired
    private TbDictMapper tbDictMapper;

    @Autowired
    private TbWorkTaskInfoMapper tbWorkTaskInfoMapper;

    @Autowired
    private TbFactoryTimeMapper tbFactoryTimeMapper;

    @Autowired
    private TbSchedulingRuleMapper tbSchedulingRuleMapper;


    @Override
    public List<TbGroupInfo> getTbGroupInfoList(TbGroupInfo tbGroupInfo) {
        List<TbGroupInfo> tbGroupInfoList = tbGroupInfoMapper.getTbGroupInfoList(tbGroupInfo);
        for (TbGroupInfo groupInfo : tbGroupInfoList) {
            TbGroupDetail tbGroupDetail = new TbGroupDetail();
            tbGroupDetail.setGroupNo(groupInfo.getGroupNo());
            List<TbGroupDetail> tbGroupDetailList = getTbGroupDetailList(tbGroupDetail);
            groupInfo.setTbGroupDetailList(tbGroupDetailList);
        }
        return tbGroupInfoList;
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int saveTbGroupInfo(TbGroupInfo tbGroupInfo) throws BusinessException {
        flag=0;
        logger.info("班组参数TbGroupInfo={}", JSON.toJSONString(tbGroupInfo));
        //根据组名和水厂查询
        List<TbGroupInfo> tbGroupInfoList = getTbGroupInfoList(tbGroupInfo);
        if(tbGroupInfo.getGroupNo()!=null){
            //修改
            //删除细表
            if(tbGroupInfoList!=null && tbGroupInfoList.size()>0){
                // //修改本条记录
            if(!tbGroupInfo.getGroupNo().equals(tbGroupInfoList.get(0).getGroupNo())){
                flag = Dict.AjaxStatus.GROUPNAME_EXIST.getStatusCode();
            }else{
                flag = saveOrUpdateTbGroupInfoAndDetail(tbGroupInfo);
            }
        }else{
            //修改记录没有存在过
            flag = saveOrUpdateTbGroupInfoAndDetail(tbGroupInfo);
        }
    }else{
            //新增
            if(tbGroupInfoList!=null && tbGroupInfoList.size()>0){
                //重复提交
                return Dict.AjaxStatus.GROUPNAME_EXIST.getStatusCode();
            }
            String groupNo = StringTools.getUUID();
            tbGroupInfo.setGroupNo(groupNo);
            //获取人数
            TbGroupDetail tbGroupDetail = new TbGroupDetail();
            tbGroupDetail.setGroupNo(groupNo);
            List<TbGroupDetail>  tbGroupDetails = getTbGroupDetailList(tbGroupDetail);
            int count=0;
            if(tbGroupDetails!=null && tbGroupDetails.size()>0){
                count=tbGroupDetails.size();
            }
            List<TbGroupInfo> memberList = tbGroupInfo.getMemberList();
            if(memberList!=null && memberList.size()>0){
                tbGroupInfo.setMemberCount(count+memberList.size());
            }
            tbGroupInfo.setFlag(0);
            int flag = tbGroupInfoMapper.insertSelective(tbGroupInfo);
            if(flag==1){
                flag = saveTbGroupDetail(tbGroupInfo,memberList);
            }
        }

        getResult(flag);
        return flag;
    }
    public void getResult( int result) throws BusinessException {
        if(result==0){
            throw new BusinessException(500,"数据重复");
        }else if(result==100){
            throw new BusinessException(400,"排班日期重复");
        }
    }
    public int saveOrUpdateTbGroupInfoAndDetail( TbGroupInfo tbGroupInfo){
        flag=0;
        List<TbGroupInfo> memberList = tbGroupInfo.getMemberList();
        TbGroupDetailExample example = new TbGroupDetailExample();
        TbGroupDetailExample.Criteria criteria = example.createCriteria();
        criteria.andGroupNoEqualTo(tbGroupInfo.getGroupNo());
        flag = tbGroupDetailMapper.deleteByExample(example);
        if(flag>=1){
            if(memberList!=null && memberList.size()>0){
                tbGroupInfo.setMemberCount(memberList.size());
            }
            flag = tbGroupInfoMapper.updateByPrimaryKeySelective(tbGroupInfo);
            if(flag==1){
                flag = saveTbGroupDetail(tbGroupInfo,memberList);

            }
        }
        return flag;
    }
    public List<TbGroupDetail> getTbGroupDetailList(TbGroupDetail tbGroupDetail){
        TbGroupDetailExample example = new TbGroupDetailExample();
        TbGroupDetailExample.Criteria criteria = example.createCriteria();
        if(tbGroupDetail!=null){
            if(tbGroupDetail.getGroupNo()!=null){
                criteria.andGroupNoEqualTo(tbGroupDetail.getGroupNo());
            }
        }
        List<TbGroupDetail> tbGroupDetails = tbGroupDetailMapper.selectByExample(example);
        return tbGroupDetails;
    }
    public int saveTbGroupDetail( TbGroupInfo tbGroupInfo ,List<TbGroupInfo> memberList ){
        flag=0;
        for (TbGroupInfo groupInfo : memberList) {
            TbGroupDetail saveTbGroupDetail =new TbGroupDetail();
            saveTbGroupDetail.setGroupNo(tbGroupInfo.getGroupNo());
            saveTbGroupDetail.setCreateTime(new Date());
            saveTbGroupDetail.setFlag(0);
            if(tbGroupInfo.getUpdateUserCode()==null){
                saveTbGroupDetail.setCreateUserCode(tbGroupInfo.getCreateUserCode());
                saveTbGroupDetail.setCreateUserName(tbGroupInfo.getCreateUserName());
            }else {
                saveTbGroupDetail.setCreateUserCode(tbGroupInfo.getUpdateUserCode());
                saveTbGroupDetail.setCreateUserName(tbGroupInfo.getUpdateUserName());
            }
            saveTbGroupDetail.setUserCode(groupInfo.getUserCode());
            saveTbGroupDetail.setUserName(groupInfo.getName());
            saveTbGroupDetail.setUserType(groupInfo.getLeader());
            flag = tbGroupDetailMapper.insertSelective(saveTbGroupDetail);
        }
        return flag;
    }

    @Override
    public Map<String, Object> getTbSchedulingHomeInfo(TbSchedulingPlanCondition condition) {
        Map<String, Object> map =new HashMap<>(16);
        //查询本月信息
        List<TbSchedulingPlan> tbSchedulingPlanList =selectSchedulingPlanListByCondition(condition);
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            tbSchedulingPlan.setStartTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getStartTimePoint()));
            tbSchedulingPlan.setEndTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getEndTimePoint()));
        }
        //根据排班计划日期进行分组
        Map<Date, List<TbSchedulingPlan>> collect = tbSchedulingPlanList.stream().collect(Collectors.groupingBy(TbSchedulingPlan::getStartTimePoint));
        List<TbSchedulingPlan> nowData = tbSchedulingPlanList.stream().filter(tbSchedulingPlan -> tbSchedulingPlan.getSchedulingTime().equals(DateUtils.formateDate(new Date()))).collect(Collectors.toList());
        for (TbSchedulingPlan tbSchedulingPlan : nowData) {
            if(tbSchedulingPlan.getGroupNo()!=null){
                TbGroupInfo tbGroupInfo = tbGroupInfoMapper.selectByPrimaryKey(tbSchedulingPlan.getGroupNo());
                if(tbGroupInfo!=null){
                    tbSchedulingPlan.setGroupName(tbGroupInfo.getGroupName());
                    TbSchedulingPlanDeatail tbSchedulingPlanDeatail =new TbSchedulingPlanDeatail();
                    tbSchedulingPlanDeatail.setGroupNo(tbSchedulingPlan.getGroupNo());
                    tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                    List<TbSchedulingPlanDeatail> tbSchedulingPlanDetailList = getTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
                    List<String> userList = tbSchedulingPlanDetailList.stream().map(e -> e.getUserName()).collect(Collectors.toList());
                    tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDetailList);
                }
            }
        }
        Map<String, Integer> mapCount = commonMap(collect);
        map.put("calendarList",mapCount);
        map.put("nowData",nowData);
        System.out.println(map.toString());
        return map;
    }
    //公共查询接口
    @Override
    public  List<TbSchedulingPlan>  selectSchedulingPlanListByCondition(TbSchedulingPlanCondition condition){
        List<TbSchedulingPlan> tbSchedulingPlanList =new ArrayList<>();
        if(condition!=null) {
            if (condition.getYear() != null && condition.getMouth() != null) {
                //设置月初第一天
                Date monthFirstDay = DateUtils.getMonthFirstDay(condition.getYear(), condition.getMouth());
                condition.setStartTime(DateUtils.formateDate(monthFirstDay));
                // 设置页末最后一天
                Date monthlastDay = DateUtils.getMonthLastDay(condition.getYear(), condition.getMouth());
                condition.setEndTime(DateUtils.formateDate(monthlastDay));
                if(condition.getSource()!=null){
                    if(condition.getSource()==2){
                        tbSchedulingPlanList=tbSchedulingPlanMapper.selectSchedulingPlanListByConditionApp(condition);
                    }else {
                        tbSchedulingPlanList = tbSchedulingPlanMapper.selectSchedulingPlanListByCondition(condition);

                    }
                }
            }
        }
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
            tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
        return tbSchedulingPlanList;
    }
    private <T> Map<String, Integer> commonMap(Map<Date, List<T>> listMap) {
        Map<String, Integer> map = new HashMap<>(30);
        for (Date date : listMap.keySet()) {
            if(map.containsKey(DateUtils.formateDate(date))){
                map.put(DateUtils.formateDate(date),map.get(DateUtils.formateDate(date))+1);
            }else{
                map.put(DateUtils.formateDate(date), listMap.get(date).size());
            }
        }
        return map;
    }


    public List<TbSchedulingPlanDeatail> getTbSchedulingPlanDeatailList( TbSchedulingPlanDeatail tbSchedulingPlanDeatail){
        List<TbSchedulingPlanDeatail> list = new ArrayList<>();
        TbSchedulingPlanDeatailExample example = new TbSchedulingPlanDeatailExample();
        TbSchedulingPlanDeatailExample.Criteria criteria = example.createCriteria();
        if(tbSchedulingPlanDeatail!=null){
            if(tbSchedulingPlanDeatail.getGroupNo()!=null){
                criteria.andGroupNoEqualTo(tbSchedulingPlanDeatail.getGroupNo());
            }
            if(tbSchedulingPlanDeatail.getSchedulingNo()!=null){
                criteria.andSchedulingNoEqualTo(tbSchedulingPlanDeatail.getSchedulingNo());
            }
            if(tbSchedulingPlanDeatail.getUserCode()!=null){
                criteria.andUserCodeEqualTo(tbSchedulingPlanDeatail.getUserCode());
            }
            if(tbSchedulingPlanDeatail.getFactoryNo()!=null){
                criteria.andFactoryNoEqualTo(tbSchedulingPlanDeatail.getFactoryNo());
            }
            example.setOrderByClause("user_type desc");
            list=tbSchedulingPlanDeatailMapper.selectByExample(example);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan) throws Exception {
        flag=0;
        List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlan.getSchedulingPlanList();
        flag = saveTbSchedulingPlan(schedulingPlanList);
        return flag;
    }
    @Transactional(rollbackFor = Exception.class)
    public int saveTbSchedulingPlan(List<TbSchedulingPlan> schedulingPlanList)  throws Exception{
        flag=0;
        //校验同一时间,同一班组类型 同一水厂
        // 不能重复创建
        for (TbSchedulingPlan schedulingPlan : schedulingPlanList) {
            //校验设备班
            schedulingPlan.setGroupName(tbGroupInfoMapper.selectByPrimaryKey(schedulingPlan.getGroupNo()).getGroupName());
            //根据timeNo
            TbFactoryTime tbFactoryTime = tbFactoryTimeMapper.selectByPrimaryKey(schedulingPlan.getTimeNo());
            String start =tbFactoryTime.getStartTimePoint();
            String end =tbFactoryTime.getEndTimePoint();
            schedulingPlan.setStartTimePoint(getDate(schedulingPlan.getSchedulingTime()+" "+start));
            if(getInteger(start)<getInteger(end)){
                //本日
                schedulingPlan.setEndTimePoint(getDate(schedulingPlan.getSchedulingTime()+" "+end));
                schedulingPlan.setDayType(0);
            }else {
                //次日
                Calendar cal = Calendar.getInstance();
                //设置起时间
                cal.setTime(getDate(schedulingPlan.getSchedulingTime()+" "+end));
                cal.add(Calendar.DATE, 1);
                schedulingPlan.setEndTimePoint(cal.getTime());
                schedulingPlan.setDayType(1);
            }
            if(schedulingPlan.getGroupType()==2){
                if(schedulingPlan.getDayType()==1){
                    throw new Exception("设备班只能排白班");
                }
            }
            schedulingPlan.setSchedulingTime(DateUtils.formateDate(DateUtils.parseDate(schedulingPlan.getSchedulingTime())));
            boolean b = checkTbSchedulingPlanExist(schedulingPlan);
            if(b){
                //重复创建
                getResult(100);
                break;
            }
            schedulingPlan.setSchedulingNo(StringTools.getUUID());
            flag = tbSchedulingPlanMapper.insertSelective(schedulingPlan);
            if(flag ==1){
                flag = saveTbSchedulingPlanDeatail(schedulingPlan);
            }
        }
        getResult(flag);
        return flag;
    }
    public  Integer getInteger(String str){
        String string =str.split(":")[0];
        String string2   =str.split(":")[1];
        return  Integer.valueOf(string+string2);
    }
    public int saveTbSchedulingPlanDeatail(TbSchedulingPlan tbSchedulingPlan){
        flag=0;
        TbGroupDetail tbGroupDetail = new TbGroupDetail();
        tbGroupDetail.setGroupNo(tbSchedulingPlan.getGroupNo());
        List<TbGroupDetail> tbGroupDetailList = getTbGroupDetailList(tbGroupDetail);
        if(tbGroupDetailList!=null && tbGroupDetailList.size()>0){
            for (TbGroupDetail groupDetail : tbGroupDetailList) {
                TbSchedulingPlanDeatail deatail = new TbSchedulingPlanDeatail();
                deatail.setFactoryNo(tbSchedulingPlan.getFactoryNo());
                deatail.setUserCode(groupDetail.getUserCode());
                deatail.setUserName(groupDetail.getUserName());
                deatail.setSchedulingNoDetail(StringTools.getUUID());
                deatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                deatail.setGroupNo(tbSchedulingPlan.getGroupNo());
                deatail.setGroupType(tbSchedulingPlan.getGroupType());
                deatail.setUserType(groupDetail.getUserType());
                String grouName="";
                if(tbSchedulingPlan!=null){
                    if(tbSchedulingPlan.getGroupNo()!=null){
                        TbGroupInfo tbGroupInfo = tbGroupInfoMapper.selectByPrimaryKey(tbSchedulingPlan.getGroupNo());
                        if(tbGroupInfo!=null){
                            grouName=tbGroupInfo.getGroupName();
                        }
                    }
                }
                deatail.setGroupName(grouName);
                deatail.setFactoryNo(tbSchedulingPlan.getFactoryNo());
                deatail.setCreateTime(tbSchedulingPlan.getCreateTime());
                deatail.setCreateUserCode(tbSchedulingPlan.getCreateUserCode());
                deatail.setCreateUserName(tbSchedulingPlan.getCreateUserName());
                flag =tbSchedulingPlanDeatailMapper.insertSelective(deatail);
            }
        }
        return flag;
    }

    public String getString(String string){
        return DateUtils.formateDate(DateUtils.parseDate(string)) ;
    }
    @Override
    public Map<String, Object> getTbSchedulingSetInfo(TbSchedulingPlanCondition condition) {
        Map<String, Object> map = new HashMap();
        //查询本月信息
        List<TbSchedulingPlan> tbSchedulingPlanList =selectSchedulingPlanListByCondition(condition);
        //根据排班计划日期进行分组
        Map<Date, List<TbSchedulingPlan>> collect = tbSchedulingPlanList.stream().collect(Collectors.groupingBy(TbSchedulingPlan::getStartTimePoint));
        Map<String, Integer> mapCount = commonMap(collect);
        //根据类型获取相应的班组
        List<TbGroupInfo> groupInfoList = new ArrayList<>();
        TbGroupInfo tbGroupInfo = new TbGroupInfo();
        if(condition!=null){
            if(condition.getFactoryNo()!=null && condition.getType()!=null){
                tbGroupInfo.setFactoryNo(condition.getFactoryNo());
                tbGroupInfo.setGroupType(condition.getType());
                groupInfoList = getTbGroupInfoList(tbGroupInfo);
            }
        }
        for (TbGroupInfo groupInfo : groupInfoList) {
            TbGroupDetail tbGroupDetail = new TbGroupDetail();
            tbGroupDetail.setGroupNo(groupInfo.getGroupNo());
            List<TbGroupDetail> tbGroupDetailList = getTbGroupDetailList(tbGroupDetail);
            for (TbGroupDetail groupDetail : tbGroupDetailList) {
                if(groupDetail.getUserType()!=null && groupDetail.getUserType()==1){
                    groupDetail.setUserTypeName("组长");
                }else {
                    groupDetail.setUserTypeName("组员");
                }
            }
            groupInfo.setTbGroupDetailList(tbGroupDetailList);
        }
        map.put("calendarList",mapCount);
        map.put("groupList",groupInfoList);
        return map;
    }

    public boolean checkTbSchedulingPlanExist(TbSchedulingPlan schedulingPlan ){
        boolean  exist =false;
        int count = tbSchedulingPlanMapper.selectSchedulingByCondition(schedulingPlan);
        if(count>0){
            exist=true;
        }
        return exist;

    }

    @Override
    public Map<String, Object> getGroupCalendarData(TbSchedulingPlanCondition condition) {
        Map<String, Object> map = new HashMap<>(16);
        List<TbSchedulingPlan>  tbSchedulingPlanList = selectSchedulingPlanListByCondition(condition);
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            tbSchedulingPlan.setStartTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getStartTimePoint()));
            tbSchedulingPlan.setEndTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getEndTimePoint()));
            TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
            tbSchedulingPlanDeatail.setGroupNo( tbSchedulingPlan.getGroupNo());
            tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
        List<TbSchedulingPlan> nowData = tbSchedulingPlanList.stream().filter(tbSchedulingPlan -> tbSchedulingPlan.getSchedulingTime().equals(DateUtils.formateDate(new Date()))).collect(Collectors.toList());
        //根据排班计划日期进行分组
        Map<String, List<TbSchedulingPlan>> collect = tbSchedulingPlanList.stream().collect(Collectors.groupingBy(TbSchedulingPlan::getSchedulingTime));
        map.put("data",collect);
        map.put("nowData",nowData);
        return map;
    }

    public static Date  getDate(String str) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm");
        return sdf.parse(str);
    }


    @Override
    public int applyTbSchedulingChange(TbSchedulingChange tbSchedulingChange) {
        flag=0;
        if(tbSchedulingChange!=null){
            TbSchedulingPlanCondition condition = new TbSchedulingPlanCondition();
            condition.setUserCode(tbSchedulingChange.getCreateUserCode());
            condition.setSchedulingTime(tbSchedulingChange.getApplyGroupTimeName());
            TbSchedulingPlanVo tbSchedulingPlan = getTbSchedulingPlanByApplyUser(condition);
            //TbSchedulingPlanDeatail tbSchedulingPlanDeatailApply = tbSchedulingPlanDeatailMapper.selectByPrimaryKey(tbSchedulingChange.getApplySchedulingNoDetail());
            tbSchedulingChange.setApplyGroupNo(tbSchedulingPlan.getGroupNo());
            tbSchedulingChange.setApplyGroupName(tbSchedulingPlan.getGroupName());
            tbSchedulingChange.setApplyGroupTime(DateUtils.parseDate(tbSchedulingChange.getApplyGroupTimeName()));
            tbSchedulingChange.setApplySchedulingNoDetail(tbSchedulingPlan.getSchedulingNoDetail());
            tbSchedulingChange.setApplyDayType(tbSchedulingPlan.getDayType());
            tbSchedulingChange.setGroupType(tbSchedulingPlan.getGroupType());
            TbSchedulingPlanDeatail tbSchedulingPlanDeatailTarget = tbSchedulingPlanDeatailMapper.selectByPrimaryKey(tbSchedulingChange.getTargetSchedulingNoDetail());
            tbSchedulingChange.setTargetGroupTime(DateUtils.parseDate(tbSchedulingChange.getTargetGroupTimeName()));
            tbSchedulingChange.setTargetGroupNo(tbSchedulingPlanDeatailTarget.getGroupNo());
            tbSchedulingChange.setTargetGroupName(tbSchedulingPlanDeatailTarget.getGroupName());
            tbSchedulingChange.setApplyDayType(tbSchedulingChange.getTargetDayType());
            tbSchedulingChange.setChangeNo(StringTools.getUUID());
            tbSchedulingChange.setStatus(0);
            tbSchedulingChange.setFlag(0);
            flag =tbSchedulingChangeMapper.insertSelective(tbSchedulingChange);
        }
        return flag;
    }

    @Override
    public List<TbSchedulingPlan> getTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan) {
        List<TbSchedulingPlan> tbSchedulingPlanList =tbSchedulingPlanMapper.selectTbSchedulingPlanListByConditionTime(tbSchedulingPlan);
        for (TbSchedulingPlan schedulingPlan : tbSchedulingPlanList) {
            schedulingPlan.setStartTimePointName(DateUtils.formateDatePart(schedulingPlan.getStartTimePoint()));
            schedulingPlan.setEndTimePointName(DateUtils.formateDatePart(schedulingPlan.getEndTimePoint()));
            TbSchedulingPlanDeatail deatail = new TbSchedulingPlanDeatail();
            deatail.setSchedulingNo(schedulingPlan.getSchedulingNo());
            deatail.setFactoryNo(schedulingPlan.getFactoryNo());
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = getTbSchedulingPlanDeatailList(deatail);
            schedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
        return tbSchedulingPlanList;
    }
    public List<TbSchedulingPlan> getCommomTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan) {
        TbSchedulingPlanExample example = new TbSchedulingPlanExample();
        TbSchedulingPlanExample.Criteria criteria = example.createCriteria();
        if (tbSchedulingPlan != null) {
            if (tbSchedulingPlan.getFactoryNo() != null) {
                criteria.andFactoryNoEqualTo(tbSchedulingPlan.getFactoryNo());
            }
            if (tbSchedulingPlan.getGroupType() != null) {
                criteria.andGroupTypeEqualTo(tbSchedulingPlan.getGroupType());
            }
            if (tbSchedulingPlan.getSchedulingTime() != null) {
                criteria.andSchedulingTimeEqualTo(tbSchedulingPlan.getSchedulingTime());
            }
            if (tbSchedulingPlan.getGroupNo() != null) {
                criteria.andGroupNoNotEqualTo(tbSchedulingPlan.getGroupNo());
            }
        }
        return tbSchedulingPlanMapper.selectByExample(example);
    }

    @Override
    public List<TbSchedulingChange> getTbSchedulingChangeList(TbSchedulingChange tbSchedulingChange) {
        return tbSchedulingChangeMapper.getTbSchedulingChangeList(tbSchedulingChange);
    }

    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public int goCheckAgreeOrReject(TbSchedulingChange tbSchedulingChange) throws BusinessException {
        flag=0;
        if(tbSchedulingChange!=null){
            if(tbSchedulingChange.getType()!=null && tbSchedulingChange.getChangeNo()!=null){
                if(tbSchedulingChange.getType()==1){
                    //通过
                    tbSchedulingChange.setStatus(1);
                   flag = tbSchedulingChangeMapper.updateByPrimaryKeySelective(tbSchedulingChange);
                   if(flag==1){
                       TbSchedulingChange tbSchedulingChangeDb = tbSchedulingChangeMapper.selectByPrimaryKey(tbSchedulingChange.getChangeNo());
                       if(tbSchedulingChangeDb!=null){
                           TbSchedulingPlanDeatail detail = new TbSchedulingPlanDeatail();
                           Date date = new Date();
                           detail.setUpdateTime(date);
                           detail.setUpdateUserName(tbSchedulingChange.getUpdateUserName());
                           detail.setUpdateUserCode(tbSchedulingChange.getUpdateUserCode());
                           detail.setSchedulingNoDetail(tbSchedulingChangeDb.getApplySchedulingNoDetail());
                           detail.setUserName(tbSchedulingChangeDb.getTargetUserName());
                           detail.setUserCode(tbSchedulingChangeDb.getTargetUserCode());
                           flag = updateTbSchedulingPlanDeatail(detail);
                           if(flag==1){
                               TbSchedulingPlanDeatail detailTarget = new TbSchedulingPlanDeatail();
                               detailTarget.setUpdateTime(date);
                               detailTarget.setUpdateUserName(tbSchedulingChange.getUpdateUserName());
                               detailTarget.setUpdateUserCode(tbSchedulingChange.getUpdateUserCode());
                               detailTarget.setSchedulingNoDetail(tbSchedulingChangeDb.getTargetSchedulingNoDetail());
                               detailTarget.setUserName(tbSchedulingChangeDb.getApplyUserName());
                               detailTarget.setUserCode(tbSchedulingChangeDb.getApplyUserCode());
                               flag = updateTbSchedulingPlanDeatail(detailTarget);
                           }
                       }
                   }
                }else{
                    //驳回
                    tbSchedulingChange.setStatus(2);
                    flag =tbSchedulingChangeMapper.updateByPrimaryKeySelective(tbSchedulingChange);
                }
            }else{
                flag =  Dict.AjaxStatus.PARAM_IS_NULL.getStatusCode();
            }
        }else {
            flag =  Dict.AjaxStatus.PARAM_IS_NULL.getStatusCode();
        }
        getResult(flag);
        return flag;
    }
    public int updateTbSchedulingPlanDeatail(TbSchedulingPlanDeatail detail){
        return tbSchedulingPlanDeatailMapper.updateByPrimaryKeySelective(detail);
    }

    @Override
    public List<TbSchedulingPlan> getbSchedulingPlanInfoByTimePoint(String userCode) {
        List<TbSchedulingPlan> tbSchedulingPlanList = new ArrayList<>();
        TbSchedulingPlanCondition tbSchedulingPlanCondition = new TbSchedulingPlanCondition();
        tbSchedulingPlanCondition.setUserCode(userCode);
        Date date = new Date();
        String newDate= DateUtils.formateDateFull(date);
        tbSchedulingPlanCondition.setCurrentTime(newDate);
        logger.info("根据用户code和时间点查询所在班组的排班信息参数TbSchedulingPlanCondition={}", JSON.toJSONString(tbSchedulingPlanCondition));
        tbSchedulingPlanList =tbSchedulingPlanMapper.getbSchedulingPlanInfoByTimePoint(tbSchedulingPlanCondition);
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
            tbSchedulingPlanDeatail.setGroupNo( tbSchedulingPlan.getGroupNo());
            tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                tbSchedulingPlanDeatail.setUserCode(userCode);
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
        return tbSchedulingPlanList;
    }

    @Override
    public List<TbSchedulingPlan> getbSchedulingPlanInfoByTime(String userCode) {
        List<TbSchedulingPlan> tbSchedulingPlanList = new ArrayList<>();
        TbSchedulingPlanCondition tbSchedulingPlanCondition = new TbSchedulingPlanCondition();
        tbSchedulingPlanCondition.setUserCode(userCode);
        tbSchedulingPlanCondition.setType(2);
        tbSchedulingPlanCondition.setSchedulingTime(DateUtils.formateDate(new Date()));
        logger.info("根据用户code和时间查询所在班组的排班信息参数TbSchedulingPlanCondition={}", tbSchedulingPlanCondition);
        tbSchedulingPlanList =tbSchedulingPlanMapper.getbSchedulingPlanInfoByTime(tbSchedulingPlanCondition);
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
            tbSchedulingPlanDeatail.setGroupNo( tbSchedulingPlan.getGroupNo());
            tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                tbSchedulingPlanDeatail.setUserCode(userCode);
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
        return tbSchedulingPlanList;
    }


    @Override
    public List<TbSchedulingPlanDeatail> getbSchedulingPlanInfoByGroupType(Integer type,String factoryNo,String schedulingTime) {
        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = new ArrayList<>();
        TbSchedulingPlanCondition tbSchedulingPlanCondition = new TbSchedulingPlanCondition();
        tbSchedulingPlanCondition.setType(type);
        tbSchedulingPlanCondition.setFactoryNo(factoryNo);
        if(schedulingTime!=null){
            if(type==1){
                tbSchedulingPlanCondition.setCurrentTime(schedulingTime);
            }else {
                tbSchedulingPlanCondition.setSchedulingTime(schedulingTime);
            }
        }else {
            if(type==1){
                Date date = new Date();
                String newDate= DateUtils.formateDateFull(date);
                tbSchedulingPlanCondition.setCurrentTime(newDate);
            }else {
                tbSchedulingPlanCondition.setSchedulingTime(DateUtils.formateDate(new Date()));
            }
        }

        logger.info("根据班组类型查询正在运行班组的排班信息参数TbSchedulingPlanCondition={}", tbSchedulingPlanCondition);
        List<TbSchedulingPlan>  tbSchedulingPlanList  = tbSchedulingPlanMapper.getbSchedulingPlanInfoByGroupType(tbSchedulingPlanCondition);
        if (tbSchedulingPlanList!=null && tbSchedulingPlanList.size()>0) {
            for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
                TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
                tbSchedulingPlanDeatail.setGroupNo( tbSchedulingPlan.getGroupNo());
                tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            }
        }
        return tbSchedulingPlanDeatailList;
    }

    @Override
    public TbSchedulingPlanVo getTbSchedulingPlanByApplyUser(TbSchedulingPlanCondition condition) {
        TbSchedulingPlanVo tbSchedulingPlan = new TbSchedulingPlanVo();
        List<TbSchedulingPlanVo> tbSchedulingPlanList =tbSchedulingPlanMapper.getTbSchedulingPlanByApplyUser(condition);
        if(tbSchedulingPlanList!=null && tbSchedulingPlanList.size()>0){
            tbSchedulingPlan=tbSchedulingPlanList.get(0);
            tbSchedulingPlan.setStartTimePointName(DateUtils.formateDatePart(tbSchedulingPlanList.get(0).getStartTimePoint()));
            tbSchedulingPlan.setEndTimePointName(DateUtils.formateDatePart(tbSchedulingPlanList.get(0).getEndTimePoint()));
        }
        return tbSchedulingPlan;
    }

    @Override
    public int checkTbSchedulingTransferUser(TbSchedulingPlanCondition condition) throws Exception {
       flag=0;
        String factroyNo=condition.getFactoryNo();
        //查询当前用所在的组 正在进行的班
        if(condition.getUserCode()!=null){
            List<TbSchedulingPlan>  tbSchedulingPlanList =getbSchedulingPlanInfoByUserCodeByDate(condition);
            if(tbSchedulingPlanList!=null && tbSchedulingPlanList.size()>0){
                long endTime =  System.currentTimeMillis() - minute;
                long startTime =  System.currentTimeMillis() + minute;
                Date endTimeDate = new Date(endTime);
                Date startTimeDte = new Date(startTime);
                condition.setStartTime(DateUtils.formateDateFull(startTimeDte));
                condition.setEndTime(DateUtils.formateDateFull(endTimeDate));
                List<TbSchedulingPlan>  tbSchedulingPlanListAgain = getbSchedulingPlanInfoByUserCodeByDate(condition);
                if(tbSchedulingPlanListAgain!=null && tbSchedulingPlanListAgain.size()>0){
                    flag=1;
                }else {
                    flag=Dict.AjaxStatus.NO_TIME_LIMIT.getStatusCode();
                }
            }else {
                flag=Dict.AjaxStatus.USER_NO_CHEDULING_INFO.getStatusCode();
            }
        }
        return flag;
    }
    @Override
    public List<TbSchedulingPlan>  getbSchedulingPlanInfoByUserCodeByDate(TbSchedulingPlanCondition condition){
        List<TbSchedulingPlan> tbSchedulingPlanList =new ArrayList<>();
        condition.setCurrentTime(DateUtils.formateDate(new Date()));
        tbSchedulingPlanList = tbSchedulingPlanMapper.getbSchedulingPlanInfoByUserCodeByDate(condition);
        return tbSchedulingPlanList;
    }

    public  List<TbSchedulingTransfer> checkTbSchedulingTransferList(TbSchedulingTransfer transfer){
        List<TbSchedulingTransfer> tbSchedulingTransferList = new ArrayList<>();
        TbSchedulingTransferExample example = new TbSchedulingTransferExample();
        TbSchedulingTransferExample.Criteria criteria = example.createCriteria();
        if(transfer.getFactoryNo()!=null){
            criteria.andFactoryNoEqualTo(transfer.getFactoryNo());
        }
        if(transfer.getTransferCode()!=null){
            criteria.andTransferCodeEqualTo(transfer.getTransferCode());
        }
        tbSchedulingTransferList =tbSchedulingTransferMapper.selectByExample(example);
        return tbSchedulingTransferList;
    }

    @Override
    public int reciveTbSchedulingTransfer(TbSchedulingPlan plan) {
            flag=0;
            //查不属于自己的排班信息
            List<TbSchedulingPlan> tbSchedulingPlanList =tbSchedulingPlanMapper.getTbSchedulingPlanByReviceUser(plan);
            if(tbSchedulingPlanList!=null && tbSchedulingPlanList.size()>0){
                TbSchedulingTransfer transfer  = new TbSchedulingTransfer();
                transfer.setTransferNo(StringTools.getUUID());
                transfer.setFactoryNo(plan.getFactoryNo());
                transfer.setApplyGroupNo(plan.getGroupNo());
                transfer.setApplyGroupName(plan.getGroupName());
                transfer.setGroupType(plan.getGroupType());
                transfer.setApplyGroupTime(plan.getSchedulingTime());
                transfer.setApplyDayType(plan.getDayType());
                transfer.setApplyUserCode(plan.getUserCode());
                transfer.setApplyUserName(plan.getUserName());
                transfer.setTargetGroupName(tbSchedulingPlanList.get(0).getGroupName());
                transfer.setTargetDayType(tbSchedulingPlanList.get(0).getDayType());
                transfer.setTargetGroupTime(tbSchedulingPlanList.get(0).getSchedulingTime());
                transfer.setTargetGroupNo(tbSchedulingPlanList.get(0).getGroupNo());
                transfer.setTargetUserCode(plan.getCreateUserCode());
                transfer.setTargetUserName(plan.getCreateUserName());
                transfer.setCreateTime(new Date());
                transfer.setTransferCode(plan.getTransferCode());
                transfer.setCreateUserCode(plan.getCreateUserCode());
                transfer.setCreateUserName(plan.getCreateUserName());
                List<TbSchedulingTransfer> tbSchedulingTransferList = checkTbSchedulingTransferList(transfer);
                if(tbSchedulingTransferList!=null && tbSchedulingTransferList.size()>0){
                    flag = Dict.AjaxStatus.FINSH_SCHEDULING.getStatusCode();
                }else{
                    transfer.setFlag(0);
                    flag =tbSchedulingTransferMapper.insertSelective(transfer);
                }
            }else {
                flag = Dict.AjaxStatus.USER_NO_GOING_SCHEDULING_PLAN.getStatusCode();
            }

        return flag;
    }

    @Override
    public List<TbSchedulingTransfer> getTbSchedulingTransferList(TbSchedulingTransfer transfer) {
        List<TbSchedulingTransfer> tbSchedulingTransferList = tbSchedulingTransferMapper.getTbSchedulingTransferList(transfer);
        return tbSchedulingTransferList;
    }

    @Override
    public TbSchedulingTransfer geTbSchedulingTransferInfo(TbSchedulingTransfer transfer) {
        TbSchedulingTransfer tbSchedulingTransfer = new TbSchedulingTransfer();
        tbSchedulingTransfer = tbSchedulingTransferMapper.selectByPrimaryKey(transfer.getTransferNo());
        return tbSchedulingTransfer;
    }

    @Override
    public Map<String, Object> getTbSchedulingInfoByTime(TbSchedulingPlanCondition condition) {
        Map<String, Object> map = new HashMap<>(16);
        List<TbSchedulingPlan>  tbSchedulingPlanList =  new ArrayList<>();
        if(condition.getSource()==2){
            tbSchedulingPlanList =tbSchedulingPlanMapper.selectSchedulingPlanListByConditionApp(condition);
        }else  {
            tbSchedulingPlanList = tbSchedulingPlanMapper.selectSchedulingPlanListByCondition(condition);
        }
            for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
                TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
                tbSchedulingPlanDeatail.setGroupNo(tbSchedulingPlan.getGroupNo());
                tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
                tbSchedulingPlan.setStartTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getStartTimePoint()));
                tbSchedulingPlan.setEndTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getEndTimePoint()));
                List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
                //List<String> userList = tbSchedulingPlanDeatailList.stream().map(e -> e.getUserName()).collect(Collectors.toList());
                tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
            }
            map.put("tbSchedulingPlanList", tbSchedulingPlanList);
        return map;
    }

    //删除排班表
    public int deleteTbSchedulingPlan(TbSchedulingPlan  tbSchedulingPlan) throws BusinessException {
        flag=0;
        if(tbSchedulingPlan!=null){
            TbSchedulingPlanExample example = new TbSchedulingPlanExample();
            TbSchedulingPlanExample.Criteria criteria = example.createCriteria();
            criteria.andFactoryNoEqualTo(tbSchedulingPlan.getFactoryNo());
            criteria.andGroupNoEqualTo(tbSchedulingPlan.getGroupNo());
            criteria.andSchedulingTimeEqualTo(tbSchedulingPlan.getSchedulingTime());
            flag =tbSchedulingPlanMapper.deleteByExample(example);
        }
        return flag;
    }
    //删除排班计划表
    public int deleteTbSchedulingPlanDetail(String schedulingNo) throws BusinessException {
        flag=0;
        if(schedulingNo!=null){
        TbSchedulingPlanDeatailExample deatail = new TbSchedulingPlanDeatailExample();
        TbSchedulingPlanDeatailExample.Criteria criteria = deatail.createCriteria();
        criteria.andSchedulingNoEqualTo(schedulingNo);
        flag =tbSchedulingPlanDeatailMapper.deleteByExample(deatail);
        }
        return flag;
    }

    @Override
    public int callBack(TbSchedulingPlanCondition condition) {
        flag=0;
        TbSchedulingTransfer transfer = new TbSchedulingTransfer();
        transfer.setFactoryNo(condition.getFactoryNo());
        transfer.setTransferCode(condition.getTransferCode());
        List<TbSchedulingTransfer> tbSchedulingTransferList = checkTbSchedulingTransferList(transfer);
        if(tbSchedulingTransferList!=null && tbSchedulingTransferList.size()>0){
            flag=1;
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTbSchedulingPlan(TbSchedulingPlan tbSchedulingPlan) throws Exception {
        flag=0;
        List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlan.getSchedulingPlanList();
        //校验同一时间,同一班组类型 同一水厂
        // 不能重复创建
        for (TbSchedulingPlan schedulingPlan : schedulingPlanList) {
            //根据groupNo和日期和水厂
            List<TbSchedulingPlan> tbSchedulingPlanDb = tbSchedulingPlanMapper.selectSchedulingPlanByTime(schedulingPlan);
            if(tbSchedulingPlanDb !=null && tbSchedulingPlanDb.size()>0){
                for (TbSchedulingPlan plan : tbSchedulingPlanDb) {
                    //删除主表 和明细表
                    flag=tbSchedulingPlanMapper.deleteByPrimaryKey(plan.getSchedulingNo());
                    if(flag==1){
                        flag = deleteTbSchedulingPlanDetail(plan.getSchedulingNo());
                    }
                }

            }
        }
        if(flag>=1){
            flag = saveTbSchedulingPlan(schedulingPlanList);
        }
        return flag;
    }

    @Override
    public Map<String, Object> getTbWorkTaskCalendarInfo(TbWorkTaskInfoCondition condition) {
        Map<String, Object> map = new HashMap<>(16);
       //统计当月所有数据
        List<TbWorkTaskInfo> tbWorkTaskInfos = selectTbWorkTaskInfoListByCondition(condition);
        for (TbWorkTaskInfo tbWorkTaskInfo : tbWorkTaskInfos) {
            if(tbWorkTaskInfo.getTaskStatus()>=1){
                String orgNo = tbWorkTaskInfo.getOrgNo();
                Date planStartTime = tbWorkTaskInfo.getPlanStartTime();
                String dutyUser = tbWorkTaskInfo.getDutyUser();
                JSONObject jsonObject = JSON.parseObject(dutyUser);
                if(jsonObject!=null){
                    String userCode = jsonObject.getString("userCode");
                    TbSchedulingPlanCondition conditionNew = new TbSchedulingPlanCondition();
                    conditionNew.setFactoryNo(tbWorkTaskInfo.getOrgNo());
                    conditionNew.setSchedulingTime(DateUtils.formateDate(tbWorkTaskInfo.getPlanStartTime()));
                    conditionNew.setUserCode(userCode);
                    TbSchedulingPlan userGroupCode = tbSchedulingPlanMapper.getUserGroupCode(conditionNew);
                    if(userGroupCode!=null){
                        tbWorkTaskInfo.setGroupName(userGroupCode.getGroupName());
                    }
                }
            }
        }
        //根据排班计划日期进行分组
        Map<Date, List<TbWorkTaskInfo>> collect = tbWorkTaskInfos.stream().collect(Collectors.groupingBy(TbWorkTaskInfo::getPlanStartTime));
        TbDataVo tbDataVo = new TbDataVo();
        //查询单日的班组信息
        TbSchedulingPlanCondition conditionPlan = new TbSchedulingPlanCondition();
        conditionPlan.setFactoryNo(condition.getFactoryNo());
        conditionPlan.setSchedulingTime(DateUtils.formateDate(new Date()));
        List<TbSchedulingPlan> tbSchedulingPlanList = tbSchedulingPlanMapper.selectSchedulingPlanListByCondition(conditionPlan);
        getTbSchedulingPlanDeataiUser(tbSchedulingPlanList);
        groupCommonData(tbDataVo,tbSchedulingPlanList);
        List<TbWorkTaskInfo> allList = tbWorkTaskInfos.stream().filter(tbWorkTaskInfo -> (DateUtils.formateDate(tbWorkTaskInfo.getPlanStartTime()).equals(DateUtils.formateDate(new Date())))).collect(Collectors.toList());
        taskCommonData(tbDataVo,allList);
        Map<String, Amount> mapCount = commonMapPoll(collect);
        map.put("nowData",tbDataVo);
        map.put("calendarList",mapCount);
        return map;
    }
    public void groupCommonData(TbDataVo tbDataVo,  List<TbSchedulingPlan> tbSchedulingPlanList){
        List<TbSchedulingPlan> runList = tbSchedulingPlanList.stream().filter(tbSchedulingPlan -> (tbSchedulingPlan.getGroupType()==1)).collect(Collectors.toList());
        tbDataVo.setRunList(runList);
        List<TbSchedulingPlan> equipList = tbSchedulingPlanList.stream().filter(tbSchedulingPlan -> (tbSchedulingPlan.getGroupType()==2)).collect(Collectors.toList());
        tbDataVo.setEquipList(equipList);
    }
    public void taskCommonData(TbDataVo tbDataVo, List<TbWorkTaskInfo> allList){
        List<TbWorkTaskInfo> weixiuList = allList.stream().filter(tbWorkTaskInfo -> (tbWorkTaskInfo.getTaskType()==4)).collect(Collectors.toList());
        List<TbWorkTaskInfo> weibaoList = allList.stream().filter(tbWorkTaskInfo -> (tbWorkTaskInfo.getTaskType()==5)).collect(Collectors.toList());
        List<TbWorkTaskInfo> fangfuList = allList.stream().filter(tbWorkTaskInfo -> (tbWorkTaskInfo.getTaskType()==7)).collect(Collectors.toList());
        List<TbWorkTaskInfo> daxiuList = allList.stream().filter(tbWorkTaskInfo -> (tbWorkTaskInfo.getTaskType()==6)).collect(Collectors.toList());
        List<TbWorkTaskInfo> gongyiList = allList.stream().filter(tbWorkTaskInfo -> (tbWorkTaskInfo.getTaskType()==9)).collect(Collectors.toList());
        tbDataVo.setWeixiuList(weixiuList);
        tbDataVo.setWeibaoList(weibaoList);
        tbDataVo.setFangfuList(fangfuList);
        tbDataVo.setDaxiuList(daxiuList);
        tbDataVo.setGongyiList(gongyiList);
    }
    /*
    * 获取班组人员信息
    * */
    public void getTbSchedulingPlanDeataiUser(List<TbSchedulingPlan> tbSchedulingPlanList){
        for (TbSchedulingPlan tbSchedulingPlan : tbSchedulingPlanList) {
            TbSchedulingPlanDeatail tbSchedulingPlanDeatail = new TbSchedulingPlanDeatail();
            tbSchedulingPlanDeatail.setSchedulingNo(tbSchedulingPlan.getSchedulingNo());
            tbSchedulingPlan.setStartTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getStartTimePoint()));
            tbSchedulingPlan.setEndTimePointName(DateUtils.formateDatePart(tbSchedulingPlan.getEndTimePoint()));
            List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(tbSchedulingPlanDeatail);
            tbSchedulingPlan.setTbSchedulingPlanDeatailList(tbSchedulingPlanDeatailList);
        }
    }
    private <T> Map<String, Amount> commonMapPoll(Map<Date, List<TbWorkTaskInfo>> listMap) {
        Map<String, Amount> map = new HashMap<>(30);
        long currentTimeMillis = System.currentTimeMillis();
        for (Date date : listMap.keySet()) {
            Amount amount =new Amount();
            if(map.containsKey(DateUtils.formateDate(date))){
                amount.setTotal(map.get(DateUtils.formateDate(date)).getTotal()+1);
                map.put(DateUtils.formateDate(date),amount);
            }else{
                amount.setTotal(listMap.get(date).size());
                map.put(DateUtils.formateDate(date),amount);
            }
            List<TbWorkTaskInfo> list = listMap.get(date);
            for (TbWorkTaskInfo  taskInfo : list){
                if(taskInfo.getPlanStartTime().getTime()<=currentTimeMillis && taskInfo.getTaskStatus()==2){
                  if(map.containsKey(DateUtils.formateDate(taskInfo.getPlanStartTime()))){
                      amount.setFinish(map.get(DateUtils.formateDate(taskInfo.getPlanStartTime())).getFinish()+1);
                      map.put(DateUtils.formateDate(taskInfo.getPlanStartTime()),amount);
                    }else{
                      amount.setFinish(listMap.get(taskInfo.getPlanStartTime()).size());
                      map.put(DateUtils.formateDate(taskInfo.getPlanStartTime()),amount);
                    }
                }
            }
        }
        return map;
    }

    //公共查询接口

    public  List<TbWorkTaskInfo>  selectTbWorkTaskInfoListByCondition(TbWorkTaskInfoCondition condition){
        List<TbWorkTaskInfo> tbSchedulingPlanList =new ArrayList<>();
        if(condition!=null) {
            if (condition.getYear() != null && condition.getMouth() != null) {
                //设置月初第一天
                Date monthFirstDay = DateUtils.getMonthFirstDay(condition.getYear(), condition.getMouth());
                condition.setStartTime(DateUtils.formateDate(monthFirstDay));
                // 设置页末最后一天
                Date monthlastDay = DateUtils.getMonthLastDay(condition.getYear(), condition.getMouth());
                condition.setEndTime(DateUtils.formateDate(monthlastDay));
                tbSchedulingPlanList = tbWorkTaskInfoMapper.selectTbWorkTaskInfoListByCondition(condition);
            }
        }
        return tbSchedulingPlanList;
    }

    @Override
    public Map<String, Object> getTbWorkTaskInfoByTime(TbWorkTaskInfoCondition condition) {
        Map<String, Object> map = new HashMap<>(16);
        List<TbWorkTaskInfo>  tbWorkTaskInfoList =  new ArrayList<>();
        TbDataVo tbDataVo = new TbDataVo();
        //获取传来日期班组信息
        TbSchedulingPlan tbSchedulingPlan = new TbSchedulingPlan();
        tbSchedulingPlan.setFactoryNo(condition.getFactoryNo());
        tbSchedulingPlan.setSchedulingTime(condition.getCurrentTime());
        List<TbSchedulingPlan> tbSchedulingPlanList = getCommomTbSchedulingPlan(tbSchedulingPlan);
        getTbSchedulingPlanDeataiUser(tbSchedulingPlanList);
        groupCommonData(tbDataVo,tbSchedulingPlanList);
        tbWorkTaskInfoList = tbWorkTaskInfoMapper.selectTbWorkTaskInfoByTime(condition);
        for (TbWorkTaskInfo tbWorkTaskInfo : tbWorkTaskInfoList) {
            if(tbWorkTaskInfo.getTaskStatus()>=1){
                String orgNo = tbWorkTaskInfo.getOrgNo();
                Date planStartTime = tbWorkTaskInfo.getPlanStartTime();
                String dutyUser = tbWorkTaskInfo.getDutyUser();
                JSONObject jsonObject = JSON.parseObject(dutyUser);
                if(jsonObject!=null){
                    String userCode = jsonObject.getString("userCode");
                    TbSchedulingPlanCondition conditionNew = new TbSchedulingPlanCondition();
                    conditionNew.setFactoryNo(tbWorkTaskInfo.getOrgNo());
                    conditionNew.setSchedulingTime(DateUtils.formateDate(tbWorkTaskInfo.getPlanStartTime()));
                    conditionNew.setUserCode(userCode);
                    TbSchedulingPlan userGroupCode = tbSchedulingPlanMapper.getUserGroupCode(conditionNew);
                    if(userGroupCode!=null){
                        tbWorkTaskInfo.setGroupName(userGroupCode.getGroupName());
                    }
                }
            }
        }
        taskCommonData(tbDataVo,tbWorkTaskInfoList);
        map.put("nowData", tbDataVo);
        return map;
    }
    @Override
    public int updateBatchTbWorkTaskInfo(TbWorkTaskInfoCondition condition) {
        flag=0;
        List<TbWorkTaskInfo> tbWorkTaskInfoList = condition.getTbWorkTaskInfoList();
        if(tbWorkTaskInfoList!=null && tbWorkTaskInfoList.size()>0){
            for (TbWorkTaskInfo tbWorkTaskInfo : tbWorkTaskInfoList) {
                TbWorkTaskInfo taskInfo = new TbWorkTaskInfo();
                taskInfo.setTaskNo(tbWorkTaskInfo.getTaskNo());
                taskInfo.setPlanStartTime(tbWorkTaskInfo.getPlanStartTime());
                flag = tbWorkTaskInfoMapper.updateByPrimaryKeySelective(taskInfo);
            }
        }
        return flag;
    }

    @Override
    public String getUserGroupCode(TbSchedulingPlanCondition condition) {
        String code ="";
        condition.setSchedulingTime(DateUtils.formateDate(new Date()));
        TbSchedulingPlan  tbSchedulingPlan = tbSchedulingPlanMapper.getUserGroupCode(condition);
        if(tbSchedulingPlan!=null){
             code=tbSchedulingPlan.getGroupNo()+DateUtils.formateDatePartNo(new Date());
        }
        return code;
    }

    @Override
    public  List<TbSchedulingPlanDeatail> getTbSchedulingPlanDeatailBanInfo(TbSchedulingPlanCondition condition){
        TbSchedulingPlanDeatail deatail = new TbSchedulingPlanDeatail();
        if(condition.getType()==1){
            //运行班
            Date date = new Date();
            String newDate= DateUtils.formateDateFull(date);
            condition.setCurrentTime(newDate);
        }else {
            //设备班
            condition.setSchedulingTime(DateUtils.formateDate(new Date()));
        }
        List<TbSchedulingPlanDeatail> tbSchedulingPlanDeatailList = new ArrayList<>();
        List<TbSchedulingPlan>  tbSchedulingPlanList  = tbSchedulingPlanMapper.getbSchedulingPlanInfoByGroupType(condition);
        if (tbSchedulingPlanList!=null && tbSchedulingPlanList.size()>0) {
            deatail.setSchedulingNo(tbSchedulingPlanList.get(0).getSchedulingNo());
            tbSchedulingPlanDeatailList = tbSchedulingPlanDeatailMapper.selectTbSchedulingPlanDeatailList(deatail);
        }
        return tbSchedulingPlanDeatailList;
    }

    @Override
    public int deleteTbGroupInfo(String groupNo) {
        flag=0;
        int flag = tbGroupInfoMapper.deleteByPrimaryKey(groupNo);
        if(flag==1){
            TbGroupDetailExample example = new TbGroupDetailExample();
            TbGroupDetailExample.Criteria criteria = example.createCriteria();
            criteria.andGroupNoEqualTo(groupNo);
            flag= tbGroupDetailMapper.deleteByExample(example);
        }
        return flag;
    }

    @Override
    public int deleteTbScheduling(String schedulingNos) {
        flag=0;
        String[] split = schedulingNos.split(",");
        for (String s : split) {
            flag = tbSchedulingPlanMapper.deleteByPrimaryKey(s);
        }
        return flag;
    }

    @Override
    public int saveTbSchedulingRule(TbSchedulingRule tbSchedulingRule){
        TbSchedulingRule searchObject = new TbSchedulingRule();
        searchObject.setFactoryNo(tbSchedulingRule.getFactoryNo());
        searchObject.setGroupType(tbSchedulingRule.getGroupType());
        List<TbSchedulingRule>  oldList = getTbSchedulingRuleList(searchObject);
        if(StringUtils.isEmpty(tbSchedulingRule.getSchedulingRuleNo())){
            if(oldList.size()>0 && DateUtils.differentDays(oldList.get(0).getEnableTime(),tbSchedulingRule.getEnableTime())<10){
                return Dict.AjaxStatus.SCHEDULE_RULE_TIME.getStatusCode();
            }
            tbSchedulingRule.setSchedulingRuleNo(StringTools.getUUID());
            tbSchedulingRule.setCreateTime(new Date());
            tbSchedulingRuleMapper.insertSelective(tbSchedulingRule);
            return Dict.AjaxStatus.YES.getStatusCode();
        }else{
            if(oldList.size()>1 && DateUtils.differentDays(oldList.get(1).getEnableTime(),tbSchedulingRule.getEnableTime())<10){
                return Dict.AjaxStatus.SCHEDULE_RULE_TIME.getStatusCode();
            }
            tbSchedulingRule.setUpdateTime(new Date());
            tbSchedulingRuleMapper.updateByPrimaryKeySelective(tbSchedulingRule);
            return Dict.AjaxStatus.YES.getStatusCode();
        }

    }


    @Override
    public List<TbSchedulingRule> getTbSchedulingRuleList(TbSchedulingRule tbSchedulingRule) {
        List<TbSchedulingRule> tbSchedulingRules = new ArrayList<>();
        TbSchedulingRuleExample example = new TbSchedulingRuleExample();
        TbSchedulingRuleExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(tbSchedulingRule.getFactoryNo());
        if(tbSchedulingRule.getRuleType()!=null){
            criteria.andRuleTypeEqualTo(tbSchedulingRule.getRuleType());
        }
        if(tbSchedulingRule.getGroupType()!=null){
            criteria.andGroupTypeEqualTo(tbSchedulingRule.getGroupType());
        }
        tbSchedulingRules = tbSchedulingRuleMapper.selectByExample(example);
        example.setOrderByClause(" enable_time  desc");
        return tbSchedulingRules;
    }

    @Override
    public List<TbSchedulingPlan> getNextDateSchedulingPlan(Date date) {
        return null;
    }

    /**
     * 创建接下来的巡检工单
     * @param factoryNo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addNextWorkSchedule(String factoryNo) {
        List<TbSchedulingPlan> schedulingPlanList = new ArrayList<>();
        List<TbSchedulingPlanDeatail> schedulingPlanDetailList = new ArrayList<>();

        //获取是设备排班计划
        List<TbSchedulingPlan> equipSchedulingPlanList =getEquipSchedulePlan(factoryNo);
        if(equipSchedulingPlanList!=null){
            for(TbSchedulingPlan schedulingPlan : equipSchedulingPlanList){
                schedulingPlanList.add(schedulingPlan);
                if(schedulingPlan.getTbSchedulingPlanDeatailList()!=null && schedulingPlan.getTbSchedulingPlanDeatailList().size()>0){
                    schedulingPlanDetailList.addAll(schedulingPlan.getTbSchedulingPlanDeatailList());
                }
            }
        }

        //获取运行排班计划
        List<TbSchedulingPlan> runSchedulingPlanList =getRunSchedulePlan(factoryNo);
        if(runSchedulingPlanList!=null){
            for(TbSchedulingPlan schedulingPlan : runSchedulingPlanList){
                schedulingPlanList.add(schedulingPlan);
                if(schedulingPlan.getTbSchedulingPlanDeatailList()!=null && schedulingPlan.getTbSchedulingPlanDeatailList().size()>0){
                    schedulingPlanDetailList.addAll(schedulingPlan.getTbSchedulingPlanDeatailList());
                }
            }
        }
        if(schedulingPlanList.size()>0){
            tbSchedulingPlanMapper.insertBatch(schedulingPlanList);
            tbSchedulingPlanDeatailMapper.insertBatch(schedulingPlanDetailList);
            return Dict.AjaxStatus.YES.getStatusCode();
        }else{
            return Dict.AjaxStatus.SCHEDULE_HAS_FINISH.getStatusCode();
        }

    }


    /**
     * 运行班排班
     * @param factoryNo
     * @return
     */
    private List<TbSchedulingPlan> getRunSchedulePlan(String factoryNo){
        List<TbFactoryTime> factoryTimeList = getFactoryTimeList(factoryNo,1);
        List<TbGroupInfo> groupInfoList = getGroupInfoList(factoryNo,1);
        List<TbSchedulingRule> schedulingRuleList = getSchedulingRuleList(factoryNo,1);

        //如何没有任何排班规则 不能排班
        if(schedulingRuleList.size()==0){
            return null;
        }

        //获取最新的排班信息
        String startDate = DateUtils.formateDate(new Date());
        String endDate = DateUtils.formateDate(DateUtils.getNextDate(new Date(),SCHEDULE_DATE_COUNT-1));
        TbSchedulingPlanExample schedulingPlanExample = new TbSchedulingPlanExample();
        schedulingPlanExample.createCriteria().andFactoryNoEqualTo(factoryNo).andGroupTypeEqualTo(1).andSchedulingTimeBetween(startDate,endDate);
        schedulingPlanExample.setOrderByClause(" scheduling_time desc");
        List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlanMapper.selectByExample(schedulingPlanExample);

        //开始创建

        Date startScheduleDate = null;

        Date endScheduleDate = DateUtils.getNextDate(new Date(),SCHEDULE_DATE_COUNT);

        Map<String,Object> scheduleMap = getStartDate(schedulingPlanList,schedulingRuleList);
        TbSchedulingRule  currentRule = null;
        List<TbSchedulingPlan> newSchedulingPlanList = new ArrayList<>();
        List<TbSchedulingPlan> oldSchedulingPlanList = new ArrayList<>();
        logger.info(JSONObject.toJSONString(scheduleMap));
        if(scheduleMap.containsKey("startDate") && scheduleMap.containsKey("currentRule")){
            //如果能找到最近的排班规则 但无法找到相对应的排班 则从改规则的起效时间开始排班
            startScheduleDate =(Date)scheduleMap.get("startDate");
            currentRule =(TbSchedulingRule)scheduleMap.get("currentRule");
            if(startScheduleDate.getTime()>=endScheduleDate.getTime()){
                return  null;
            }
            if(DateUtils.differentDays(currentRule.getEnableTime(),startScheduleDate)<5){
                oldSchedulingPlanList = getMySchedulingPlanList(schedulingPlanList,DateUtils.getNextDate(startScheduleDate,- 5));
            }else{
                oldSchedulingPlanList = getMySchedulingPlanList(schedulingPlanList,currentRule.getEnableTime());
            }

        }else if(!scheduleMap.containsKey("startDate") && scheduleMap.containsKey("currentRule")){
            //如果能找到最近的排班规则 但无法找到相对应的排班 则从改规则的起效时间开始排班
            currentRule =(TbSchedulingRule)scheduleMap.get("currentRule");
            startScheduleDate = currentRule.getEnableTime();
            clearOldSchedulePlanList(schedulingPlanList,startScheduleDate);

        }else{
            currentRule = schedulingRuleList.get(0);
            startScheduleDate = currentRule.getEnableTime();
        }

        List<String> dayList = DateUtils.getDistDayList(startScheduleDate,endScheduleDate);
        for(int i=0;i<dayList.size();i++){
            String day = dayList.get(i);
            Date date = DateUtils.parseDate(day);
            for(int n=0;n<groupInfoList.size();n++){
                TbGroupInfo groupInfo = groupInfoList.get(n);
                logger.info(JSONObject.toJSONString(currentRule));
                Integer index = SchedulingConfig.getSchedulePlanCollection(oldSchedulingPlanList,currentRule,factoryTimeList,date,groupInfo.getGroupNo());
                if(index==null){
                    logger.error("错误的排班设置");
                    return null;
                }
                //休班
                if(index==0){
                    continue;
                }
                TbFactoryTime factoryTime = getFactoryTimeZone(factoryTimeList,index);
                boolean crossDay = false;
                //只有早晚班的 晚班才有跨天的
                if(factoryTimeList.size()==2&&index==2){
                    crossDay = true;
                }
                if(factoryTimeList.size()==3&&index==3){
                    crossDay = true;
                }
                TbSchedulingPlan schedulingPlan = createSchedulingPlan(groupInfo,factoryTime,day,factoryNo,crossDay);
                schedulingPlan.setScheduleRule(currentRule.getSchedulingRuleNo());
                newSchedulingPlanList.add(schedulingPlan);
                oldSchedulingPlanList.add(schedulingPlan);
            }


        }
        return newSchedulingPlanList;
    }

    /**
     * 获取当前排班适用的 排班规则 和开始日期
     * @param schedulingPlanList
     * @param schedulingRuleList
     * @return
     */
    private Map<String,Object> getStartDate(List<TbSchedulingPlan> schedulingPlanList,List<TbSchedulingRule> schedulingRuleList){
        Map<String,Object> resultMap = new HashMap<>();
        for(int i=0;i<schedulingPlanList.size();i++){
            TbSchedulingPlan schedulingPlan = schedulingPlanList.get(i);
            Date scheduleDate = DateUtils.parseDate(schedulingPlan.getSchedulingTime());
            for(TbSchedulingRule schedulingRule:schedulingRuleList){
                //如果排班时间超过 排班规则的启用时间
                if(scheduleDate.getTime()>=schedulingRule.getEnableTime().getTime() ){
                    //如果找到排班规则
                    if(schedulingRule.getSchedulingRuleNo().equals(schedulingPlan.getScheduleRule())){
                        resultMap.put("startDate",DateUtils.getNextDate(schedulingPlan.getSchedulingTime(),1));
                    }
                    resultMap.put("currentRule",schedulingRule);
                    return resultMap;
                }
            }
        }
        return resultMap;

    }

    /**
     * 删除 旧模式下创建的 排班
     * @param schedulingPlanList
     * @param startDate
     * @return
     */
    private void  clearOldSchedulePlanList(List<TbSchedulingPlan> schedulingPlanList,Date startDate){
        List<String> list = new ArrayList<>();
        for(TbSchedulingPlan schedulingPlan:schedulingPlanList){
            Date date = DateUtils.parseDate(schedulingPlan.getSchedulingTime());
            if(date.getTime()>=startDate.getTime()){
                list.add(schedulingPlan.getSchedulingNo());
            }
        }
        if(list.size()>0){
            TbSchedulingPlanExample schedulingPlanExample = new TbSchedulingPlanExample();
            schedulingPlanExample.createCriteria().andSchedulingNoIn(list);
            tbSchedulingPlanMapper.deleteByExample(schedulingPlanExample);
        }

    }

    private List<TbSchedulingPlan> getMySchedulingPlanList(List<TbSchedulingPlan> schedulingPlanList,Date startDate){
        List<TbSchedulingPlan> list = new ArrayList<>();
        for(int i=0;i<schedulingPlanList.size()-1;i++){
            TbSchedulingPlan schedulingPlan = schedulingPlanList.get(i);
            if(DateUtils.parseDate(schedulingPlan.getSchedulingTime()).getTime()>=startDate.getTime()){
                list.add(schedulingPlan);
            }
        }
        return list;
    }




    /**
     * 设备班排班
     * @return
     */
    private List<TbSchedulingPlan> getEquipSchedulePlan(String factoryNo){
        List<TbFactoryTime> factoryTimeList = getFactoryTimeList(factoryNo,2);
        List<TbGroupInfo> groupInfoList = getGroupInfoList(factoryNo,2);
        List<TbSchedulingRule> schedulingRuleList = getSchedulingRuleList(factoryNo,2);

        //如何没有任何排班规则 不能排班
        if(schedulingRuleList.size()==0 || factoryTimeList.size()==0 || groupInfoList.size()==0){
            return null;
        }
        //获取最新的排班信息
        String startDate = DateUtils.formateDate(new Date());
        String endDate = DateUtils.formateDate(DateUtils.getNextDate(new Date(),SCHEDULE_DATE_COUNT-1));
        TbSchedulingPlanExample schedulingPlanExample = new TbSchedulingPlanExample();
        schedulingPlanExample.createCriteria().andFactoryNoEqualTo(factoryNo).andGroupTypeEqualTo(2).andSchedulingTimeBetween(startDate,endDate);
        schedulingPlanExample.setOrderByClause(" scheduling_time desc");
        List<TbSchedulingPlan> schedulingPlanList = tbSchedulingPlanMapper.selectByExample(schedulingPlanExample);

        Date startScheduleDate = null;
        Date endScheduleDate = DateUtils.getNextDate(new Date(),SCHEDULE_DATE_COUNT);

        Map<String,Object> scheduleMap = getStartDate(schedulingPlanList,schedulingRuleList);
        TbSchedulingRule  currentRule = null;
        List<TbSchedulingPlan> newSchedulingPlanList = new ArrayList<>();
        if(scheduleMap.containsKey("startDate") && scheduleMap.containsKey("currentRule")){
            //如果能找到最近的排班规则 但无法找到相对应的排班 则从改规则的起效时间开始排班
            startScheduleDate =(Date)scheduleMap.get("startDate");
            currentRule =(TbSchedulingRule)scheduleMap.get("currentRule");

            if(startScheduleDate.getTime()>=endScheduleDate.getTime()){
                return  null;
            }

        }else if(!scheduleMap.containsKey("startDate") && scheduleMap.containsKey("currentRule")){
            //如果能找到最近的排班规则 但无法找到相对应的排班 则从改规则的起效时间开始排班
            currentRule =(TbSchedulingRule)scheduleMap.get("currentRule");
            startScheduleDate = currentRule.getEnableTime();
            clearOldSchedulePlanList(schedulingPlanList,startScheduleDate);
        }else{
            currentRule = schedulingRuleList.get(0);
            startScheduleDate = currentRule.getEnableTime();
        }
        List<String> dayList = DateUtils.getDistDayList(startScheduleDate,endScheduleDate);

        for(int i=0;i<dayList.size();i++){
            String day = dayList.get(i);
            Date date = DateUtils.parseDate(day);
            //如果周末不需要上班 并且日期是周末的
            if(currentRule.getWeekendWork().equals(0) && DateUtils.isWeekEnd(date)){
                continue;
            }

            TbSchedulingPlan schedulingPlan = createSchedulingPlan(groupInfoList.get(0),factoryTimeList.get(0),day,factoryNo,false);
            schedulingPlan.setScheduleRule(currentRule.getSchedulingRuleNo());
            newSchedulingPlanList.add(schedulingPlan);


        }
        return newSchedulingPlanList;

    }

    /**
     *
     * @param groupInfo
     * @param factoryTime
     * @param date
     * @param factoryNo
     * @param crossDay 是否跨天
     * @return
     */
    private TbSchedulingPlan createSchedulingPlan(TbGroupInfo groupInfo, TbFactoryTime factoryTime,String date,String factoryNo,boolean crossDay ){
        TbSchedulingPlan schedulingPlan = new TbSchedulingPlan();
        schedulingPlan.setFactoryNo(factoryNo);
        schedulingPlan.setSchedulingTime(date);
        schedulingPlan.setGroupType(groupInfo.getGroupType());
        schedulingPlan.setSchedulingNo(StringTools.getUUID());
        schedulingPlan.setGroupName(groupInfo.getGroupName());
        schedulingPlan.setTimeNo(factoryTime.getTimeNo());
        schedulingPlan.setCreateTime(new Date());
        schedulingPlan.setGroupNo(groupInfo.getGroupNo());
        schedulingPlan.setFlag(DELETE_NO);
        schedulingPlan.setCreateUserCode("SYSTEM");
        schedulingPlan.setCreateUserName("自动生成");
        if(!crossDay){
            Date startTime = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getStartTimePoint());
            Date endTime = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getEndTimePoint());
            schedulingPlan.setStartTimePoint(startTime);
            schedulingPlan.setEndTimePoint(endTime);
            schedulingPlan.setDayType(0);
        }else{
            //如果开始时间大于结束时间 则表示需要跨天
            if(factoryTime.getStartTimePoint().compareTo(factoryTime.getEndTimePoint())>0){
                Date startTime = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getStartTimePoint());
                Date tempDate = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getEndTimePoint());
                Date endTime = DateUtils.getNextDateTime(tempDate,1);
                schedulingPlan.setStartTimePoint(startTime);
                schedulingPlan.setDayType(1);
                schedulingPlan.setEndTimePoint(endTime);
            }else{
                Date tempDate = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getStartTimePoint());
                Date startTime = DateUtils.getNextDateTime(tempDate,1);
                tempDate = DateUtils.parseDateFullPartMinute(date + " " + factoryTime.getEndTimePoint());
                Date endTime = DateUtils.getNextDateTime(tempDate,1);
                schedulingPlan.setStartTimePoint(startTime);
                schedulingPlan.setEndTimePoint(endTime);
                schedulingPlan.setDayType(1);
            }
        }
        List<TbGroupDetail> groupDetailList = getGroupDetailList(groupInfo.getGroupNo());
        List<TbSchedulingPlanDeatail> schedulingPlanDetailList = new ArrayList<>();
        for(TbGroupDetail groupDetail:groupDetailList){
            TbSchedulingPlanDeatail schedulingPlanDetail = new TbSchedulingPlanDeatail();
            schedulingPlanDetail.setSchedulingNoDetail(StringTools.getUUID());
            schedulingPlanDetail.setSchedulingNo(schedulingPlan.getSchedulingNo());
            schedulingPlanDetail.setGroupType(schedulingPlan.getGroupType());
            schedulingPlanDetail.setUserCode(groupDetail.getUserCode());
            schedulingPlanDetail.setUserName(groupDetail.getUserName());
            schedulingPlanDetail.setGroupNo(groupDetail.getGroupNo());
            schedulingPlanDetail.setGroupName(groupInfo.getGroupName());
            schedulingPlanDetail.setUserType(groupDetail.getUserType());
            schedulingPlanDetail.setFactoryNo(factoryNo);
            schedulingPlanDetail.setFlag(DELETE_NO);
            schedulingPlanDetail.setCreateUserCode("SYSTEM");
            schedulingPlanDetail.setCreateUserName("自动创建");
            schedulingPlanDetail.setCreateTime(new Date());
            schedulingPlanDetailList.add(schedulingPlanDetail);
        }
        schedulingPlan.setTbSchedulingPlanDeatailList(schedulingPlanDetailList);
        return schedulingPlan;

    }

    /**
     * 获取排班时间段
     * @param factoryTimeList
     * @param index
     * @return
     */
    private TbFactoryTime getFactoryTimeZone(List<TbFactoryTime> factoryTimeList, int index){
        for(TbFactoryTime factoryTime:factoryTimeList){
            if(factoryTime.getTimeSort().equals(index)){
                return factoryTime;
            }
        }
        return null;
    }

    /**
     * 获取水厂班次列表
     * @param factoryNo
     * @param type
     * @return
     */
    private List<TbFactoryTime> getFactoryTimeList(String factoryNo,Integer type){
        TbFactoryTimeExample factoryTimeExample = new TbFactoryTimeExample();
        factoryTimeExample.createCriteria().andFactoryNoEqualTo(factoryNo).andFlagEqualTo(DELETE_NO).andTimeTypeEqualTo(type);
        return tbFactoryTimeMapper.selectByExample(factoryTimeExample);
    }

    /**
     * 获取水厂班组信息
     * @param factoryNo
     * @param type
     * @return
     */
    private List<TbGroupInfo> getGroupInfoList(String factoryNo,Integer type) {
        TbGroupInfoExample groupInfoExample = new TbGroupInfoExample();
        groupInfoExample.createCriteria().andFactoryNoEqualTo(factoryNo).andFlagEqualTo(DELETE_NO).andGroupTypeEqualTo(type);
        return tbGroupInfoMapper.selectByExample(groupInfoExample);
    }

    /**
     * 获取水厂排班规则
     * @param factoryNo
     * @param type
     * @return
     */
    public List<TbSchedulingRule> getSchedulingRuleList(String factoryNo,Integer type){
        TbSchedulingRuleExample schedulingRuleExample = new TbSchedulingRuleExample();
        schedulingRuleExample.createCriteria().andFactoryNoEqualTo(factoryNo).andGroupTypeEqualTo(type);
        schedulingRuleExample.setOrderByClause(" enable_time desc ");
        return tbSchedulingRuleMapper.selectByExample(schedulingRuleExample);
    }

    /**
     * 获取班组详情
     * @param groupNo
     * @return
     */
    private List<TbGroupDetail> getGroupDetailList(String groupNo){
        TbGroupDetailExample groupDetailExample = new TbGroupDetailExample();
        groupDetailExample.createCriteria().andGroupNoEqualTo(groupNo).andFlagEqualTo(DELETE_NO);
        return tbGroupDetailMapper.selectByExample(groupDetailExample);
    }



    private  List<TbSchedulingRule>  getCurrentSchedulingRule(Date date, List<TbSchedulingRule> schedulingRuleList ){
        List<TbSchedulingRule> list = new ArrayList<>(2);

        for(int n=schedulingRuleList.size()-1;n>=0;n--){
            if(n>0){
                if(schedulingRuleList.get(schedulingRuleList.size()-1-n ).getEnableTime().getTime()<=date.getTime()
                        && schedulingRuleList.get(schedulingRuleList.size()-n ).getEnableTime().getTime()>date.getTime()){
                    list.add(schedulingRuleList.get(schedulingRuleList.size()-1-n));
                    list.add(schedulingRuleList.get(schedulingRuleList.size()-n));
                    break;
                }
            }else{
                if(schedulingRuleList.get(schedulingRuleList.size()-1).getEnableTime().getTime()<=date.getTime()){
                    list.add(schedulingRuleList.get(schedulingRuleList.size()-1));
                }else{
                    return null;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String startDate = DateUtils.formateDate(new Date());
        System.out.println(startDate);
        String endDate = DateUtils.formateDate(DateUtils.getNextDate(new Date(),SCHEDULE_DATE_COUNT-1));
        System.out.println(endDate);
    }




}

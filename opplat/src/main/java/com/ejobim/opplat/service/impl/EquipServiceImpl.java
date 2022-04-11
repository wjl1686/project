package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.vo.FinishVo;
import com.ejobim.opplat.domain.vo.TbEquipInfoVo;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.TbDictService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import com.ejobim.opplat.util.Tree;
import com.ejobim.opplat.util.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.ejobim.opplat.common.WorkFlowCommon.*;

@Service
public class EquipServiceImpl implements EquipService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbEquipInfoMapper tbEquipInfoMapper;

    @Autowired
    private TbAdjustEquipMapper tbAdjustEquipMapper;

    @Autowired
    private TbAdjustEquipExtendMapper tbAdjustEquipExtendMapper;


    @Autowired
    private TbEquipAttachmentMapper tbEquipAttachmentMapper;

    @Autowired
    private TbSparePartsMapper tbSparePartsMapper;

    @Autowired
    private Environment env;

    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;


    @Autowired
    private TbOrderLogMapper tbOrderLogMapper;

    @Autowired
    private TbSparePartsUseLoggerMapper tbSparePartsUseLoggerMapper;

    @Autowired
    private EquipService equipService;

    @Autowired
    private BewgService bewgService;

    @Autowired
    private TbEquipTaskFileMapper tbEquipTaskFileMapper;

    @Autowired
    TbUserMapper tbUserMapper;

    @Autowired
    private TbDictService tbDictService;

    @Autowired
    private TbEquipHistroyMapper tbEquipHistroyMapper;

    @Autowired
    private TbEquipTypeMapper tbEquipTypeMapper;
    
    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;
    
    @Autowired
    private TbNfcInfoMapper tbNfcInfoMapper;
    
    @Autowired
    private TbRoutingLocationMapper tbRoutingLocationMapper;

    private int flag = 0;

    @Autowired
    private EquipLogMapper equipLogMapper;

    @Autowired
    private TbWorkTaskInfoMapper workTaskInfoMapper;

    @Override
    public List<TbEquipInfo> getEquipList(TbEquipInfo tbEquipInfo) {
        List<TbEquipInfo> tbEquipInfos =new ArrayList<>();
        TbEquipInfoExample example = new TbEquipInfoExample();
        TbEquipInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tbEquipInfo.getFactoryNo())) {
            criteria.andFactoryNoEqualTo(tbEquipInfo.getFactoryNo());
        }
        if (StringUtils.isNotEmpty(tbEquipInfo.getEquipMainType())) {
            criteria.andEquipMainTypeEqualTo(tbEquipInfo.getEquipMainType());
        }
        if (StringUtils.isNotEmpty(tbEquipInfo.getEquipType())) {
            criteria.andEquipTypeEqualTo(tbEquipInfo.getEquipType());
        }
        if (tbEquipInfo.getEquipNewType() != null) {
            criteria.andEquipNewTypeEqualTo(tbEquipInfo.getEquipNewType());
        }
        if (StringUtils.isNotEmpty(tbEquipInfo.getEquipName())) {
            criteria.andEquipNameLike("%" + tbEquipInfo.getEquipName() + "%");
        }
        example.setOrderByClause(" update_time desc ");
        tbEquipInfos= tbEquipInfoMapper.selectByExample(example);
        //取出字典
        List<TbDict> tbDicts = tbEquipInfo.getTbDicts();
        //取出 设备类型
        List<TbEquipType> equipTypeList = tbEquipInfo.getEquipTypeList();
        for (TbEquipInfo equipInfo : tbEquipInfos) {
            //设备类型
            if(equipTypeList!=null && equipTypeList.size()>0) {
                for (TbEquipType tbEquipType : equipTypeList) {
                    if (equipInfo.getEquipNewType() != null) {
                        if (equipInfo.getEquipNewType().equals(tbEquipType.getId())) {
                            equipInfo.setEquipNewTypeName(tbEquipType.getTypeName());
                        }
                    }

                }
            }

            //购置时间
            if(equipInfo.getPurchaseDate()!=null) {
                equipInfo.setPurchaseDateName(DateUtils.formateDatePartNo(equipInfo.getPurchaseDate()));
            }
            if(tbDicts!=null && tbDicts.size()>0) {
                for (TbDict tbDict : tbDicts) {
                    //安装位置
                    if (equipInfo.getInstallationSite() != null) {
                        if (equipInfo.getInstallationSite().equals(tbDict.getKeyName())) {
                            equipInfo.setInstallationSiteName(tbDict.getValueName());
                        }
                    }
                    //管理状态
                    if (equipInfo.getEquipStatus() != null) {
                        if (equipInfo.getEquipStatus().toString().equals(tbDict.getKeyName())) {
                            equipInfo.setEquipStatusName(tbDict.getValueName());
                        }
                    }
                }
            }
            //立卡时间
            if(equipInfo.getStartDate()!=null) {
                equipInfo.setStartDateName(DateUtils.formateDatePartNo(equipInfo.getStartDate()));
            }
            //启用时间
            //立卡时间
            if(equipInfo.getInvocationDate()!=null) {
                equipInfo.setInvocationDateName(DateUtils.formateDatePartNo(equipInfo.getInvocationDate()));
            }


        }
        return tbEquipInfos;
    }

    @Override
    public List<TbAdjustEquip> getAdjuastEquipList(TbAdjustEquip tbAdjustEquip) {

        TbAdjustEquipExample example = new TbAdjustEquipExample();

        TbAdjustEquipExample.Criteria criteria = example.createCriteria();
        if (tbAdjustEquip.getStatus() != null) {
            if (tbAdjustEquip.getStatus() == 1) {
                criteria.andStatusLessThanOrEqualTo(1);
            } else {
                criteria.andStatusEqualTo(tbAdjustEquip.getStatus());
            }

        }
        criteria.andFactoryNoEqualTo(tbAdjustEquip.getFactoryNo());
        if (StringUtils.isNotEmpty(tbAdjustEquip.getAdName())) {
            criteria.andAdNameLike("%" + tbAdjustEquip.getAdName() + "%");
        }
        example.setOrderByClause("apply_time desc");
        List<TbAdjustEquip> list = tbAdjustEquipMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<TbAdjustEquip> getAdjuastEquipList(String factoryNo,String keyName) {
        return tbAdjustEquipMapper.selectByKeyName(factoryNo,keyName);
    }

    @Override
    public int saveEquipInfo(TbEquipInfo tbEquipInfo) {
        if (StringUtils.isNotEmpty(tbEquipInfo.getEquipNo())) {
            return tbEquipInfoMapper.updateByPrimaryKeySelective(tbEquipInfo);
        } else {
            tbEquipInfo.setEquipNo(StringTools.getUUID());
            return tbEquipInfoMapper.insertSelective(tbEquipInfo);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int changeEquipStatus(String equipNo,Integer status,TbUser user){

        TbEquipInfo equipInfo = tbEquipInfoMapper.selectByPrimaryKey(equipNo);
        if(equipInfo.getEquipStatus().equals(status)){
            return Dict.AjaxStatus.EQUIP_STATUS_NO_CHANGE.getStatusCode();
        }else{
            equipInfo.setEquipStatus(status);
            tbEquipInfoMapper.updateByPrimaryKeySelective(equipInfo);
            EquipLog equipLog = new EquipLog();
            equipLog.setEquipNo(equipNo);
            equipLog.setStatus(status);
            equipLog.setUpdateTime(new Date());
            equipLog.setUpdateUser(user.getCode());
            equipLogMapper.insertSelective(equipLog);
            return Dict.AjaxStatus.YES.getStatusCode();
        }


    }

    @Override
    public TbAdjustEquip getAdjuastEquipExtendList(Integer status, String adNo) {
        TbAdjustEquip tbAdjustEquip = tbAdjustEquipMapper.selectByPrimaryKey(adNo);
        TbAdjustEquipExtendExample example = new TbAdjustEquipExtendExample();
        TbAdjustEquipExtendExample.Criteria criteria = example.createCriteria();
        criteria.andAdNoEqualTo(adNo);
        if (status != null) {
            criteria.andStepIndexLessThanOrEqualTo(status);
        }
        tbAdjustEquip.setExtendList(tbAdjustEquipExtendMapper.selectByExample(example));
        return tbAdjustEquip;
    }

    @Override
    public int addTbAdjustEquip(TbAdjustEquip tbAdjustEquip) {
        tbAdjustEquip.setApplyTime(new Date());
        String adNo = StringTools.getUUID();
        tbAdjustEquip.setAdNo(adNo);
        tbAdjustEquip.setStatus(0);
        this.tbAdjustEquipMapper.insert(tbAdjustEquip);
        TbAdjustEquipExtend firstExtend = createAdjustEquipExtend(adNo, 0, tbAdjustEquip.getApplyUser(), new Date());
        this.tbAdjustEquipExtendMapper.insert(firstExtend);
        TbAdjustEquipExtend secondExtend = createAdjustEquipExtend(adNo, 1, tbAdjustEquip.getApplyUser(), null);
        this.tbAdjustEquipExtendMapper.insert(secondExtend);
        return 1;
    }

    private TbAdjustEquipExtend createAdjustEquipExtend(String adNo, int status, String stepUser, Date date) {
        TbAdjustEquipExtend tbAdjustEquipExtend = new TbAdjustEquipExtend();
        tbAdjustEquipExtend.setAdDetailNo(StringTools.getUUID());
        tbAdjustEquipExtend.setAdNo(adNo);
        tbAdjustEquipExtend.setStepIdea("");
        tbAdjustEquipExtend.setStepIndex(status);
        tbAdjustEquipExtend.setStepTime(date);
        tbAdjustEquipExtend.setVaildStatus(1);
        tbAdjustEquipExtend.setStepUser(stepUser);
        return tbAdjustEquipExtend;
    }

    @Override
    public int saveTbAdjustEquipExtend(TbAdjustEquipExtend tbAdjustEquipExtend, Integer status, boolean commit) {
        TbAdjustEquip tbAdjustEquip = this.tbAdjustEquipMapper.selectByPrimaryKey(tbAdjustEquipExtend.getAdNo());
        if (commit) {
            tbAdjustEquip.setStatus(tbAdjustEquipExtend.getStepIndex());
        } else {
            tbAdjustEquip.setStatus(2);
        }

        tbAdjustEquipMapper.updateByPrimaryKeySelective(tbAdjustEquip);
        if (tbAdjustEquipExtend.getStepIndex() == 1) {
            TbAdjustEquipExtend equipExtend = getTbAdjustEquipExtendByStepIndex(tbAdjustEquipExtend.getAdNo(), tbAdjustEquipExtend.getStepIndex());
            if (equipExtend != null) {
                equipExtend.setStepTime(new Date());
                tbAdjustEquipExtendMapper.updateByPrimaryKeySelective(equipExtend);
            }
        } else {
            tbAdjustEquipExtend.setAdDetailNo(StringTools.getUUID());
            tbAdjustEquipExtend.setStepTime(new Date());
            tbAdjustEquipExtend.setVaildStatus(1);
            tbAdjustEquipExtendMapper.insert(tbAdjustEquipExtend);
        }
        return 1;
    }

    private TbAdjustEquipExtend getTbAdjustEquipExtendByStepIndex(String adNo, Integer setpIndex) {
        TbAdjustEquipExtendExample example = new TbAdjustEquipExtendExample();
        TbAdjustEquipExtendExample.Criteria criteria = example.createCriteria();
        criteria.andStepIndexEqualTo(setpIndex);
        criteria.andAdNoEqualTo(adNo);
        criteria.andStepIndexEqualTo(1);
        List<TbAdjustEquipExtend> list = tbAdjustEquipExtendMapper.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }

    }

    private void getEquipLocationName(TbEquipInfo tbEquipInfo) {
        List<Integer> parentList = new ArrayList<>();
        parentList.add(9);
        List<TbDict> dictByParent = tbDictService.getDictByParent(parentList);
        for (TbDict tbDict : dictByParent) {
            if(tbDict.getKeyName().equals(tbEquipInfo.getInstallationSite())){
                tbEquipInfo.setInstallationSiteName(tbDict.getValueName());
            }
        }
    }


    private String getYear() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String year = dateFormat.format(new Date());
        return year;
    }



    @Override
    public List<TbEquipAttachment> getAttachmentList(String equipNo, String fileName) {
        TbEquipAttachmentExample example = new TbEquipAttachmentExample();
        TbEquipAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andEquipNoEqualTo(equipNo);
        if (StringUtils.isNotEmpty(fileName)) {
            criteria.andAttachmentFilenameLike("%" + fileName + "%");
        }
        return tbEquipAttachmentMapper.selectByExample(example);
    }

    @Override
    public int saveTbEquipAttachment(TbEquipAttachment tbEquipAttachment) {
        tbEquipAttachment.setAttachmentUploadTime(new Date());
        tbEquipAttachment.setAttachmentNo(StringTools.getUUID());
        return tbEquipAttachmentMapper.insert(tbEquipAttachment);
    }

    @Override
    public int delTbEquipAttachment(TbEquipAttachment tbEquipAttachment) {
        return tbEquipAttachmentMapper.deleteByPrimaryKey(tbEquipAttachment.getId());
    }

    @Override
    public List<TbSpareParts> getSparePartsList(TbSpareParts tbSpareParts) {
        TbSparePartsExample example = new TbSparePartsExample();
        TbSparePartsExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tbSpareParts.getEquipType())) {
            criteria.andEquipTypeEqualTo(tbSpareParts.getEquipType());
        }
        if (StringUtils.isNotEmpty(tbSpareParts.getSparePartsName())) {
            criteria.andSparePartsNameEqualTo(tbSpareParts.getSparePartsName());
        }
        return tbSparePartsMapper.selectByExample(example);
    }

    /**
     * 获取设备运行台式
     * @param equipNo
     * @return
     */
    public String getEquipRunTime(String equipNo){
        TbEquipInfo equipInfo = tbEquipInfoMapper.selectByPrimaryKey(equipNo);
        //获取启用时间
        Date startTime = equipInfo.getInvocationDate();
        if(startTime==null){
            return "";
        }
        EquipLogExample example = new EquipLogExample();
        example.createCriteria().andEquipNoEqualTo(equipNo);
        example.setOrderByClause(" update_time ");
        List<EquipLog> equipLogList = equipLogMapper.selectByExample(example);
        long runTime = System.currentTimeMillis() - startTime.getTime();
        long stopTimeSum = 0;
        Date stopTime = null;
        for(int i=0;i<equipLogList.size();i++){
            if(equipLogList.get(i).getStatus().equals(1)){
                stopTime = equipLogList.get(i).getUpdateTime();
            }else if(equipLogList.get(i).getStatus().equals(0)){
                if(stopTime!=null){
                    long currentStopTime = equipLogList.get(i).getUpdateTime().getTime() - stopTime.getTime();
                    stopTimeSum = stopTimeSum + currentStopTime;
                }
                stopTime = null;
            }
        }
        //如果设备停用后还一直未恢复
        if(stopTime!=null){
            stopTimeSum = stopTimeSum +  System.currentTimeMillis() - stopTime.getTime();
        }
        runTime = runTime - stopTimeSum;

        TbWorkTaskInfoExample workTaskInfoExample = new TbWorkTaskInfoExample();
        //设备编号相等 且完成的
        List<Integer> finishStatus = new ArrayList<>();
        finishStatus.add(WORK_TASK_STATUS_FINISH);
        finishStatus.add(WORK_TASK_STATUS_FAIL);
        finishStatus.add(WORK_TASK_STATUS_FAIL_HANDLE);
        workTaskInfoExample.createCriteria().andEquipNoEqualTo(equipNo).andTaskStatusIn(finishStatus);
        workTaskInfoExample.setOrderByClause(" real_finish_time ");
        List<TbWorkTaskInfo> workTaskInfoList = workTaskInfoMapper.selectByExample(workTaskInfoExample);
        long repairTimeSum = 0;
        for(TbWorkTaskInfo  workTaskInfo:workTaskInfoList){
            if(workTaskInfo.getRealStartTime()!=null && workTaskInfo.getRealFinishTime()!=null){
                repairTimeSum = repairTimeSum + workTaskInfo.getRealFinishTime().getTime() - workTaskInfo.getPlanStartTime().getTime();
            }
        }

        TbWorkTaskInfoExample workTaskInfoExample1 = new TbWorkTaskInfoExample();
        //设备编号相等 且完成的
        List<Integer> unFinishStatus = new ArrayList<>();
        unFinishStatus.add(WORK_TASK_STATUS_PLAN);
        unFinishStatus.add(WORK_TASK_STATUS_ORDER);
        workTaskInfoExample1.createCriteria().andEquipNoEqualTo(equipNo).andTaskStatusIn(unFinishStatus);
        workTaskInfoExample1.setOrderByClause(" plan_start_time  desc ");
        List<TbWorkTaskInfo> workTaskInfoList1 = workTaskInfoMapper.selectByExample(workTaskInfoExample1);
        if(workTaskInfoList1.size()>0){
            if(workTaskInfoList1.get(0).getPlanStartTime()!=null) {
                repairTimeSum = repairTimeSum + System.currentTimeMillis() - workTaskInfoList1.get(0).getPlanStartTime().getTime();
            }
        }
        runTime = runTime - repairTimeSum;

        return DateUtils.getTimeString(runTime);
    }

    @Override
    public TbEquipInfo getEquipInfo(String equipNo) {
        TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(equipNo);

        if (tbEquipInfo!=null){
            tbEquipInfo.setEquipTypeName(getTbEquipTypeName(tbEquipInfo.getEquipNewType()));
            getEquipLocationName(tbEquipInfo);
        }

        return tbEquipInfo;
    }


    private String getTbEquipTypeName(Integer tbEquipType) {
        String name = "";
        if (tbEquipType == null) {
            name = "--";
        } else {
            TbEquipType equipType = tbEquipTypeMapper.selectByPrimaryKey(tbEquipType);
            if (equipType == null) {
                name = "--";
            } else {
                name = equipType.getTypeName();
            }

        }
        return name;
    }


    @Override
    public int commonTbSparePartsUseLogger(List<TbSparePartsUseLogger> list) {
        int count = 0;
        for (TbSparePartsUseLogger tbSparePartsUseLogger : list) {
            //TbSparePartsUseLogger sparePartsUseLoggerDb = tbSparePartsUseLoggerMapper.selectBySparePartsNo(tbSparePartsUseLogger.getSparePartsNo());
            TbSpareParts tbSpareParts = new TbSpareParts();
            tbSpareParts.setSparePartsNo(tbSparePartsUseLogger.getSparePartsNo());
            tbSparePartsUseLogger.setUseTime(new Date());
            //查询基础备件总数量
            TbSpareParts tbSparePartsAll = tbSparePartsMapper.selectByPrimaryKey(tbSparePartsUseLogger.getSparePartsNo());
            if (tbSparePartsAll != null) {
                if (tbSparePartsUseLogger.getUseCount() > tbSparePartsAll.getSparePartsCount()) {
                    return count;
                }
                tbSparePartsUseLoggerMapper.insertSelective(tbSparePartsUseLogger);
                //修改 查询当前备品总数量,    减去备品数量
                tbSpareParts.setSparePartsCount(tbSparePartsAll.getSparePartsCount() - tbSparePartsUseLogger.getUseCount());
                count = tbSparePartsMapper.updateByPrimaryKeySelective(tbSpareParts);
            }

        }
        return count;
    }



    @Override
    public int saveTbEquipHistroy(TbEquipHistroy tbEquipHistroy) {
        tbEquipHistroy.setCreateTime(new Date());
        return tbEquipHistroyMapper.insertSelective(tbEquipHistroy);

    }




    @Override
    public List<TbEquipInfo> selectEquipBaseInfoByKey(TbEquipInfo tbEquipInfo) {
        if (StringUtils.isNotBlank(tbEquipInfo.getEquipNo())) {
            return tbEquipInfoMapper.selectEquipBaseInfoByKey(tbEquipInfo);
        }
        return null;
    }

    @Override
    public List<TbSpareParts> selectSparePartsByEqNo(TbEquipInfo tbEquipInfo) {
        List<TbEquipInfo> tbEquipInfoList = this.selectEquipBaseInfoByKey(tbEquipInfo);
        if (tbEquipInfoList.size() > 0) {
            TbSpareParts tbSpareParts = new TbSpareParts();
            tbSpareParts.setEquipType(tbEquipInfoList.get(0).getEquipType());
            List<TbSpareParts> list = tbSparePartsMapper.selectSparePartsByCond(tbSpareParts);
            //临时代码 start
            if (list.size() == 0) {
                list = tbSparePartsMapper.selectSparePartsByCond(new TbSpareParts());
            }
            //临时代码 end
            return list;
        }
        return null;
    }


    @Override
    public int commonAppTransferOrder(TbOrderLog tbOrderLog) {
        return tbOrderLogMapper.insertSelective(tbOrderLog);
    }



    @Override
    public int addTaskFile(TbEquipTaskFile overhaulTaskFile) {

        overhaulTaskFile.setOfUploadTime(new Date());
        overhaulTaskFile.setOfFileStatus(0);
        overhaulTaskFile.setOfNo(StringTools.getUUID());
        return tbEquipTaskFileMapper.insertSelective(overhaulTaskFile);
    }

    @Override
    public List<TbEquipTaskFile> getFileList(TbEquipTaskFile tbEquipTaskFile) {
        TbEquipTaskFileExample example = new TbEquipTaskFileExample();
        TbEquipTaskFileExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tbEquipTaskFile.getOfTaskExtendNo())) {
            criteria.andOfTaskExtendNoEqualTo(tbEquipTaskFile.getOfTaskExtendNo());
        }
        if (StringUtils.isNotEmpty(tbEquipTaskFile.getOfTaskNo())) {
            criteria.andOfTaskNoEqualTo(tbEquipTaskFile.getOfTaskNo());
        }
        if (StringUtils.isNotEmpty(tbEquipTaskFile.getOfFactoryNo())) {
            criteria.andOfFactoryNoEqualTo(tbEquipTaskFile.getOfFactoryNo());
        }
        criteria.andOfTypeEqualTo(1);
        return tbEquipTaskFileMapper.selectByExample(example);
    }

    @Override
    public List<Map<String, String>> getRunningParamsBySynInfo(List<TbSynObject> list) {
        //筛选符合条件的记录
        String[] browerPaths = list.stream()
                .map(obj -> obj.getBrowsepath())
                .toArray(String[]::new);
        if (browerPaths.length > 0) {
            JSONObject dataInfoNew = bewgService.getDataInfoNew(browerPaths);
            List<Map<String, String>> resultList = dataInfoNew.getObject("result", List.class);
            for (int i = 0; i < resultList.size(); i++) {
                Map<String, String> map = resultList.get(i);
                if (map != null) {
                    map.put("browseName", list.get(i).getBrowsename());
                    map.put("displayName", list.get(i).getDisplayname());
                    map.put("currValue", map.get("v"));
                    map.put("catchTime", map.get("t"));
                }
            }
            return resultList;
        } else {
            return new ArrayList<>();
        }

    }




    @Override
    public TbEquipInfo getEquipDetailInfo(TbEquipInfo tbEquipInfo) {


        if (tbEquipInfo.getEquipNo() != null ) {

            TbEquipInfo tbEquipInfoQ = tbEquipInfoMapper.selectByPrimaryKey(tbEquipInfo.getEquipNo());
            //获取设备图片
            List<Integer> pid = new ArrayList<>();
            pid.add(9);
            List<TbDict> dictByParent = tbDictService.getDictByParent(pid);
            if (tbEquipInfoQ.getInstallationSite() != null) {
                for (TbDict tbDict : dictByParent) {
                    if (tbDict.getKeyName().equals(tbEquipInfoQ.getInstallationSite())) {
                        tbEquipInfoQ.setInstallationSiteName(tbDict.getValueName());

                    }
                }
            }
            return tbEquipInfoQ;
        }else {
            return null;
        }



    }

    @Override
    public List<TbEquipInfo> selectEquipBatchlist(String[] equipNos) {
        return tbEquipInfoMapper.selectEquipBatchlist(equipNos);
    }

    @Override
    public int saveTbEquipType(TbEquipType tbEquipType) {

        //根据sortNo
        TbEquipType tbEquipTypeDb = tbEquipTypeMapper.getTbEquipTypeInfo(tbEquipType);
        if (tbEquipType.getId() != null) {
            if (!tbEquipType.getId().equals(tbEquipTypeDb.getId())) {
                return Dict.AjaxStatus.EQUIP_NUMBER_EXIST.getStatusCode();
            }
            flag = tbEquipTypeMapper.updateByPrimaryKeySelective(tbEquipType);
        } else {
            if (tbEquipTypeDb != null) {
                return Dict.AjaxStatus.EQUIP_NUMBER_EXIST.getStatusCode();
            }
            if (tbEquipType.getParentId() == null || tbEquipType.getParentId() == 0) {
                //tbEquipType.setLevel(1);
            } else {
                TbEquipType parentType = tbEquipTypeMapper.selectByPrimaryKey(tbEquipType.getParentId());
                //tbEquipType.setLevel(parentType.getLevel() + 1);
            }
            tbEquipType.setCreateTime(new Date());
            flag = tbEquipTypeMapper.insertSelective(tbEquipType);
        }
        return flag;
    }

    @Override
    public List<TbEquipType> selectTbEquipTypetList(TbEquipType tbEquipType) {
        return tbEquipTypeMapper.selectTbEquipTypetList(tbEquipType);
    }

    @Override
    public Tree<TbEquipType> findTbEquipTypeAllTree() {
        TbEquipTypeExample equipTypeExample = new TbEquipTypeExample();
        List<TbEquipType> list = tbEquipTypeMapper.selectByExample(equipTypeExample);
        List<Tree<TbEquipType>> trees = new ArrayList<>();
        buildEquipTypeTrees(trees,list);
        return TreeUtils.build(trees);
    }

    private void buildEquipTypeTrees(List<Tree<TbEquipType>> trees, List<TbEquipType> tbEquipTypes) {
        tbEquipTypes.forEach(menu -> {
            Tree<TbEquipType> tbEquipTypeTree = new Tree<>();
            tbEquipTypeTree.setId(menu.getId()==null?null:menu.getId().toString());
            tbEquipTypeTree.setParentId(menu.getParentId()==null?null:menu.getParentId().toString());
            tbEquipTypeTree.setText(menu.getTypeName());
            Map map = new HashMap();
            map.put("equipLevelType",menu.getEquipLevelType());
            map.put("equipTypeCode",menu.getEquipTypeCode());
            tbEquipTypeTree.setAttributes(map);
            trees.add(tbEquipTypeTree);
        });
    }



    @Override
    public TbEquipType getInfoById(Integer parentId) {
        return tbEquipTypeMapper.selectByPrimaryKey(parentId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public int saveImportEquipInfo(List<TbEquipInfoVo> list, String factoryNo, List<TbDict> tbDicts, List<TbEquipType> tbEquipTypeList) {
        TbFactoryInfo tbFactoryInfo = tbFactoryInfoMapper.selectByPrimaryKey(factoryNo);
        int flag = 0;
        //字典相关字段
        List<TbEquipInfo> reptList = new ArrayList<>();
        List<String> reptList2 = new ArrayList<>();
        List<TbEquipInfo> newlist = new ArrayList<>();
        List<TbEquipInfo> batchList = new ArrayList<>();
        if(tbFactoryInfo!=null) {
            for (TbEquipInfoVo con : list) {
                String location ="";
                String equipCode ="";
                //  购买时间
                if (con.getPurchaseDateName() != null) {
                    con.setPurchaseDate(DateUtils.parseDateNo(con.getPurchaseDateName()));
                }
                // 立卡时间
                if (con.getStartDateName() != null) {
                    con.setStartDate(DateUtils.parseDateNo(con.getStartDateName()));
                }
                // 启用时间
                if (con.getInvocationDateName() != null) {
                    con.setInvocationDate(DateUtils.parseDateNo(con.getInvocationDateName()));
                }
                    for (TbDict tbDict : tbDicts) {
                        //循环字典相关数据
                        //安装地点
                        if (con.getInstallationSiteName() != null) {
                            if (tbDict.getValueName().equals(con.getInstallationSiteName())) {
                                location = tbDict.getKeyName();
                                con.setInstallationSite(location);
                            }
                        }
                        /*设备管理状态*/
                        if (con.getEquipStatusName() != null) {
                            if (tbDict.getValueName().equals(con.getEquipStatusName())) {
                                con.setEquipStatus(Integer.parseInt(tbDict.getKeyName()));
                            }
                        }else {
                            con.setEquipStatus(0);
                        }
                        if (con.getIssueNo() != null) {
                            if (tbDict.getValueName().equals(con.getIssueNo())) {
                                con.setIssueNo(tbDict.getKeyName());
                            }
                        }else {
                            con.setIssueNo("1"); 
                        }
                }
                //设备类别
                String code = "";
                if (con.getEquipSort() > 999 || con.getEquipSort() < 0) {
                    return flag;
                } else {
                    if (con.getEquipSort() < 10) {
                        code = con.getIssueNo()==null?"1":con.getIssueNo() + "0" + con.getEquipSort();
                    } else if (con.getEquipSort() < 100) {
                        code = con.getIssueNo()==null?"1":con.getIssueNo() + con.getEquipSort();
                    }else if (con.getEquipSort() >= 100) {
                        code =  con.getEquipSort() +"";
                    }
                }
                for (TbEquipType tbEquipType : tbEquipTypeList) {
                    if (con.getEquipNewTypeName() != null) {
                        if (tbEquipType.getTypeName().equals(con.getEquipNewTypeName())) {
                            TbEquipType tbEquipTypeQ = tbEquipTypeMapper.selectByPrimaryKey(tbEquipType.getId());
                            if(tbEquipTypeQ!=null){
                                String tEquipLevelType= tbEquipType.getEquipLevelType()==null ||"".equals(tbEquipType.getEquipLevelType()) ?"D":tbEquipType.getEquipLevelType();
                                equipCode = tbFactoryInfo.getFactoryCode() + location + tbEquipType.getEquipTypeCode() + code + tEquipLevelType;
                                con.setEquipCode(equipCode);
                                con.setEquipMainType(tEquipLevelType);
                                con.setEquipTypeCode(tbEquipTypeQ.getEquipTypeCode());
                                con.setEquipNewType(tbEquipTypeQ.getId());
                            }else {
                                break;
                            }
                        }                  
                    }
                }
                if(con.getEquipCode()==null){
                    reptList2.add(con.getEquipNewTypeName());
                }
                con.setFactoryNo(factoryNo);
                TbEquipInfo tbEquipInfo = new TbEquipInfo();
                BeanUtils.copyProperties(con, tbEquipInfo);
                String equipNo = con.getEquipNo();
                if (equipNo != null) {
                    TbEquipInfo tbFactoryInfoDb = tbEquipInfoMapper.selectByPrimaryKey(equipNo);
                    if (tbFactoryInfoDb != null) {
                        //修改
                        flag = tbEquipInfoMapper.updateByPrimaryKeySelective(tbEquipInfo);
                    } else {
                        List<TbEquipInfo> tbEquipInfoList = checkTbEquipInfo(tbEquipInfo);
                        if(tbEquipInfoList!=null && tbEquipInfoList.size()>0){
                            flag=  Dict.AjaxStatus.RE_EQUIP_CODE.getStatusCode();
                        }else {
                            String uuid = StringTools.getUUID();
                            tbEquipInfo.setEquipNo(uuid);
                            flag = tbEquipInfoMapper.insertSelective(tbEquipInfo);
                        }
                    }
                } else {
                    List<TbEquipInfo> tbEquipInfoList = checkTbEquipInfo(tbEquipInfo);
                    if(tbEquipInfoList!=null && tbEquipInfoList.size()>0){
                        //flag=  Dict.AjaxStatus.RE_EQUIP_CODE.getStatusCode();
                        newlist.addAll(tbEquipInfoList);
                    }else {
                        tbEquipInfo.setEquipNo(StringTools.getUUID());
                        batchList.add(tbEquipInfo);
                    }
                }
            }
            flag = tbEquipInfoMapper.insertEquipBatchlist(batchList);
        }
        logger.info("导入设备的总数据list={},条Tiao={}",  JSON.toJSONString(list),JSON.toJSONString(list.size()));
        logger.info("导入设备重复code数据newList={}",  JSON.toJSONString(newlist));
        logger.info("code为空的数据reLIst2={}",JSON.toJSONString(reptList2));
        return flag;
    }
    
    public List<TbEquipInfo> checkTbEquipInfo(TbEquipInfo tbEquipInfo){
        TbEquipInfoExample example = new TbEquipInfoExample();
        TbEquipInfoExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(tbEquipInfo.getFactoryNo());
        if(tbEquipInfo.getEquipCode()!=null){
            criteria.andEquipCodeEqualTo(tbEquipInfo.getEquipCode());
        }
        return tbEquipInfoMapper.selectByExample(example);
    }

    @Override
    public List<TbEquipType> selectTbEquipTypetLists(TbEquipType tbEquipType) {
        logger.info("查询设备类型,tbEquipType:{}", JSON.toJSONString(tbEquipType));
        List<TbEquipType> tbTbEquipTypetList = new ArrayList<>();
        try {
            TbEquipTypeExample example = new TbEquipTypeExample();
            TbEquipTypeExample.Criteria criteria = example.createCriteria();
            if (org.apache.commons.lang.StringUtils.isNotBlank(tbEquipType.getTypeName())) {
                criteria.andTypeNameLike("%"+tbEquipType.getTypeName()+"%");
            }
            if(tbEquipType.getParentId()!=null){
                criteria.andParentIdEqualTo(tbEquipType.getParentId());
            }else{
                criteria.andParentIdNotEqualTo(0);
            }
            if(tbEquipType.getStatus()!=null){
                criteria.andStatusEqualTo(tbEquipType.getStatus());
            }
            if(tbEquipType.getEquipTypeCode()!=null){
                criteria.andEquipTypeCodeEqualTo(tbEquipType.getEquipTypeCode());
            }
            tbTbEquipTypetList = tbEquipTypeMapper.selectByExample(example);
            for (TbEquipType equipType : tbTbEquipTypetList) {
                if(equipType.getParentId()!=null){
                    TbEquipType tb = equipService.getInfoById(equipType.getParentId());
                    if(tb!=null){
                        equipType.setParentName(tb.getTypeName());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("获取设备类型信息失败", e);
        }
        return tbTbEquipTypetList;
    }

    @Override
    public int stopTbEquipType(Integer id) {
        flag=0;
        TbEquipType tbEquipType = tbEquipTypeMapper.selectByPrimaryKey(id);
         if(tbEquipType!=null){
             if(tbEquipType.getStatus()==1){
                 tbEquipType.setStatus(2);
             }else {
                 tbEquipType.setStatus(1); 
             }
             flag =tbEquipTypeMapper.updateByPrimaryKeySelective(tbEquipType);
         }
      
        return flag;
    }

    @Override
    public List<TbNfcInfo> getEquipNFCList(TbNfcInfo tbNfcInfo) {
        TbNfcInfoExample example = new TbNfcInfoExample();
        TbNfcInfoExample.Criteria criteria = example.createCriteria();
        if(tbNfcInfo.getFactoryNo()!=null){
            criteria.andFactoryNoEqualTo(tbNfcInfo.getFactoryNo());
        }
        if(tbNfcInfo.getNodeName()!=null){
            criteria.andNodeNameLike("%"+tbNfcInfo.getNodeName()+"%");
        }
        if(tbNfcInfo.getNfcNo()!=null){
            criteria.andNfcNoLike("%"+tbNfcInfo.getNfcNo()+"%");
        }
        if(tbNfcInfo.getNodeType()!=null){
            criteria.andNodeTypeEqualTo(tbNfcInfo.getNodeType());
        }
        example.setOrderByClause("create_time desc");
        return  tbNfcInfoMapper.selectByExample(example);
    }

    @Override
    public int saveEquipNFC(TbNfcInfo tbNfcInfo) {
        //根据组名和水厂查询
        int flag=0;
        List<TbNfcInfo> tbNfcInfoList =tbNfcInfoMapper.getEquipCheckNFCList(tbNfcInfo);
            if(tbNfcInfoList!=null && tbNfcInfoList.size()>0){
             /*   for (int i = tbNfcInfoList.size() - 1; i >= 0; i --) {
                    if(tbNfcInfoList.get(i).getNfcNo().equals(tbNfcInfo.getNfcNo())){
                        tbNfcInfoList.remove(i);
                    }
                }
                if(tbNfcInfoList!=null && tbNfcInfoList.size()>0){
                    List<String> stringNameList = tbNfcInfoList.stream().map(e -> e.getNodeName()).collect(Collectors.toList());
                    List<String> stringIndexList = tbNfcInfoList.stream().map(e -> e.getNfcNo()).collect(Collectors.toList());
                    if(stringNameList.contains(tbNfcInfo.getNodeName())|| stringIndexList.contains(tbNfcInfo.getNfcNo())){
                        flag = Dict.AjaxStatus.NFC_NO_EXIST.getStatusCode();
                    }else{
                        flag =tbNfcInfoMapper.updateByPrimaryKeySelective(tbNfcInfo);
                    }
                    // }
                }else{
                    //修改记录没有存在过
                    flag =tbNfcInfoMapper.updateByPrimaryKeySelective(tbNfcInfo);*/
                flag = Dict.AjaxStatus.NFC_NO_EXIST.getStatusCode();
            }else {
                if(tbNfcInfo.getNodeType()==1){
                    TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(tbNfcInfo.getNodeId());
                    if(tbEquipInfo!=null) {
                        tbNfcInfo.setNodeName(tbEquipInfo.getEquipName());
                    }
                } else {
                    TbRoutingLocation routingLocation = tbRoutingLocationMapper.selectByPrimaryKey(tbNfcInfo.getNodeId());
                    if (routingLocation != null) {
                        tbNfcInfo.setNodeName(routingLocation.getLocationName());
                    }
                }
                tbNfcInfo.setCreateTime(new Date());
                flag =tbNfcInfoMapper.insertSelective(tbNfcInfo);
            }
        return flag;
    }

    
    @Override
    public List<Map<String, String>> getSheOrXunList(TbNfcInfo tbNfcInfo) {
        List<Map<String, String>> list = new ArrayList<>();
        if(tbNfcInfo.getNodeType()==1){
            //设备
            list = tbEquipInfoMapper.getNfcEquipInfoList(tbNfcInfo);
        }else {
           //巡检点 
            list = tbRoutingLocationMapper.getNfcRoutingLocationList(tbNfcInfo);
        }
        return list;
    }

    @Override
    public int stopEquipNFC(TbNfcInfo tbNfcInfo) {
        return tbNfcInfoMapper.deleteByPrimaryKey(tbNfcInfo.getNfcNo());
    }

    @Override
    public int updateEquipNFC(TbNfcInfo tbNfcInfo) {
        int flag=0;
        List<TbNfcInfo> tbNfcInfoList =tbNfcInfoMapper.getEquipCheckNFCList(tbNfcInfo);
     /*   for (int i = tbNfcInfoList.size() - 1; i >= 0; i --) {
            if(tbNfcInfoList.get(i).getNfcNo().equals(tbNfcInfo.getNfcNo())){
                tbNfcInfoList.remove(i);
            }
        }*/
        if (tbNfcInfo.getNodeType() == 1) {
            TbEquipInfo tbEquipInfo = tbEquipInfoMapper.selectByPrimaryKey(tbNfcInfo.getNodeId());
            if (tbEquipInfo != null) {
                tbNfcInfo.setNodeName(tbEquipInfo.getEquipName());
            }
        } else {
            TbRoutingLocation routingLocation = tbRoutingLocationMapper.selectByPrimaryKey(tbNfcInfo.getNodeId());
            if (routingLocation != null) {
                tbNfcInfo.setNodeName(routingLocation.getLocationName());
            }
        }
        if(tbNfcInfoList!=null && tbNfcInfoList.size()>0){
            List<String> stringNameList = tbNfcInfoList.stream().map(e -> e.getNodeId()).collect(Collectors.toList());
            List<String> stringNfcList = tbNfcInfoList.stream().map(e -> e.getNfcNo()).collect(Collectors.toList());
            if(stringNameList.contains(tbNfcInfo.getNodeId()) && stringNfcList.contains(tbNfcInfo.getNfcNo())){
                flag=1;
                //flag = Dict.AjaxStatus.NFC_NO_OR_NAME_EXIST.getStatusCode();
            }else{
                if(stringNameList.contains(tbNfcInfo.getNodeId()) || stringNfcList.contains(tbNfcInfo.getNfcNo())){
                    flag = Dict.AjaxStatus.NFC_NO_OR_NAME_EXIST.getStatusCode();
                }else {
                   
                    flag = tbNfcInfoMapper.updateByPrimaryKeySelective(tbNfcInfo);
                }
            }
            // }
        }else{
            //修改记录没有存在过
            flag =tbNfcInfoMapper.insertSelective(tbNfcInfo);
        }
        return flag;
    }
}

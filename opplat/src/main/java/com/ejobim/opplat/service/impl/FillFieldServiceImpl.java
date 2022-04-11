package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.FillFieldService;
import com.ejobim.opplat.service.ParameterConfigService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FillFieldServiceImpl implements FillFieldService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbParameterConfigExtendMapper configExtendMapper;
    @Autowired
    ParameterConfigService parameterConfigService;
    @Autowired
    TbSynObjectMapper synObjectMapper;
    @Autowired
    TbFillFormFieldMapper fillFormFieldMapper;
    @Autowired
    TbFillFormDetailMapper fillFormDetailMapper;
    @Autowired
    TbFillFormFieldExtendMapper fillFormFieldExtendMapper;
    @Autowired
    private TbReportDateMapper reportDateMapper;

    @Autowired
    private TbObjectDataMapper objectDataMapper;

    @Override
    public void createFieldFromConfig(String factoryNo) {
        TbParameterConfigExtend configExtend = new TbParameterConfigExtend();
        configExtend.setFactoryNo(factoryNo);
        List<String> uriList = new ArrayList<>();
        List<TbParameterConfigExtend> extendList = parameterConfigService.getParameterConfigExtendList(configExtend);
        List<String> slzbList = new ArrayList<>();
        List<String> dlzbUriList = new ArrayList<>();
        List<String> inslszUriList = new ArrayList<>();
        List<String> outslszUriList = new ArrayList<>();
        List<String> wuysUriList = new ArrayList<>();
        List<String> wuysUriList1 = new ArrayList<>();
        List<String> wutsUriList= new ArrayList<>();
        List<String> yjUriList= new ArrayList<>();


        for(int i=0;i<extendList.size();i++){
            TbParameterConfigExtend parameterConfigExtend = extendList.get(i);
            if(browseNameIsError(parameterConfigExtend.getExtendName())){
                continue;
            }
            TbSynObject synObjectExample = new TbSynObject();
            synObjectExample.setFactoryNo(factoryNo);
            synObjectExample.setBrowsename(parameterConfigExtend.getExtendName());
            List<TbSynObject> synObjectList = getTbSynObject(synObjectExample);
            if(synObjectList.size()>0){
                createHollyField(factoryNo, uriList, parameterConfigExtend, synObjectList);
            }else{
                TbParameterConfig tbParameterConfig = parameterConfigExtend.getParameterConfig();
                //进水
                List<String> listInWater = new ArrayList<>();
                initInWaterList(listInWater);
                //浓缩池
                List<String> listNsc = new ArrayList<>();
                listNsc.add("SL_NSC_CNL");

                String ownNo = "/Hollysys_Bewg_modelNew/"+StringTools.getUUID();

                if(uriList.contains(ownNo)){
                    continue;
                }
                uriList.add(ownNo);
                TbFillFormField fillFormField = new TbFillFormField();
                fillFormField.setFactoryNo(factoryNo);

                if (setSedFieldBaseInfo(factoryNo, slzbList, dlzbUriList, inslszUriList, outslszUriList, wuysUriList, wuysUriList1, wutsUriList, yjUriList, tbParameterConfig, listInWater, listNsc, ownNo, fillFormField)){
                    continue;
                }
                createSedField(tbParameterConfig, ownNo, fillFormField);
                fillFormFieldMapper.insertSelective(fillFormField);
                TbFillFormFieldExtend fillFormFieldExtend = new TbFillFormFieldExtend();

                fillFormFieldExtend.setConfigNo(ownNo);
                if(fillFormField.getFillType()==1||fillFormField.getFillType()==2){
                    fillFormFieldExtend.setType(1);
                    fillFormFieldExtend.setCycle(12);
                    fillFormFieldExtend.setVaildTime("09:00");
                }else if(fillFormField.getFillType()==3){
                    fillFormFieldExtend.setType(5);
                    fillFormFieldExtend.setVaildTime("09:00,13:00");
                }
                fillFormFieldExtend.setCreateTime(new Date());
                fillFormFieldExtendMapper.insertSelective(fillFormFieldExtend);
            }

        }

    }

    /**
     * 设置SED字段的基础信息
     * @param factoryNo
     * @param slzbList
     * @param dlzbUriList
     * @param inslszUriList
     * @param outslszUriList
     * @param wuysUriList
     * @param wuysUriList1
     * @param wutsUriList
     * @param yjUriList
     * @param tbParameterConfig
     * @param listInWater
     * @param listNsc
     * @param ownNo
     * @param fillFormField
     * @return
     */
    private boolean setSedFieldBaseInfo(String factoryNo, List<String> slzbList, List<String> dlzbUriList, List<String> inslszUriList, List<String> outslszUriList, List<String> wuysUriList, List<String> wuysUriList1, List<String> wutsUriList, List<String> yjUriList, TbParameterConfig tbParameterConfig, List<String> listInWater, List<String> listNsc, String ownNo, TbFillFormField fillFormField) {
        if(tbParameterConfig.getParamType()==1){
            setObjectDataInfo(factoryNo, slzbList, ownNo, fillFormField, "WPA");
        }else if(tbParameterConfig.getParamType()==2||tbParameterConfig.getParamType()==8){
            setObjectDataInfo(factoryNo, inslszUriList, ownNo, fillFormField, "EEM");
        }else if(tbParameterConfig.getParamType()==3){
            if(listInWater.contains(tbParameterConfig.getBrowseName())){
                setObjectDataInfo(factoryNo, dlzbUriList, ownNo, fillFormField, "IWQ");
            }else{
                setObjectDataInfo(factoryNo, outslszUriList, ownNo, fillFormField, "OWQ");
            }
        }else if(tbParameterConfig.getParamType()==4){
            setObjectDataInfo(factoryNo, outslszUriList, ownNo, fillFormField, "STS");
        }else if(tbParameterConfig.getParamType()==5){
            if(listNsc.contains(tbParameterConfig.getBrowseName())){
                setObjectDataInfo(factoryNo, wuysUriList, ownNo, fillFormField, "DSS");
            }else{
                setObjectDataInfo(factoryNo, wuysUriList1, ownNo, fillFormField, "STK");
            }
        }else if(tbParameterConfig.getParamType()==6){
            setObjectDataInfo(factoryNo, wutsUriList, ownNo, fillFormField, "STK");
        }else if(tbParameterConfig.getParamType()==9){
            setObjectDataInfo(factoryNo, yjUriList, ownNo, fillFormField, "STTA");
            //月报设备完好率
        }else {
            return true;
        }
        return false;
    }

    /**
     * 自建字段的添加
     * @param tbParameterConfig
     * @param ownNo
     * @param fillFormField
     */
    private void createSedField(TbParameterConfig tbParameterConfig, String ownNo, TbFillFormField fillFormField) {
        fillFormField.setConfigNo(ownNo);
        fillFormField.setSedName(tbParameterConfig.getParamName());
        fillFormField.setFieldType(tbParameterConfig.getParamFrom());
        fillFormField.setFillType(tbParameterConfig.getParamFillType());
        fillFormField.setConfigStatus(0);
        fillFormField.setCreateTime(new Date());
        fillFormField.setFieldUnit(tbParameterConfig.getParamUnit());

        fillFormField.setFieldName(tbParameterConfig.getParamName());
        fillFormField.setFieldCode(tbParameterConfig.getBrowseName());
        fillFormField.setCreatePerson("system");
    }

    private void initInWaterList(List<String> listInWater) {
        listInWater.add("SZ_JSZH_DBL");
        listInWater.add("SZ_JS_COD");
        listInWater.add("SZ_JS_BOD5");
        listInWater.add("SZ_JS_SS");
        listInWater.add("SZ_JS_NH3N");
        listInWater.add("SZ_JS_TN");
        listInWater.add("SZ_JS_TP");
    }

    private void setObjectDataInfo(String factoryNo, List<String> slzbList, String ownNo, TbFillFormField fillFormField, String wpa) {
        if (slzbList.size() == 0) {
            String equipNo = getUri(wpa, factoryNo);
            getParentList(equipNo, factoryNo, slzbList);

        }
        fillFormField.setEquipNo(slzbList.get(0));
        addObjectData(slzbList, ownNo, factoryNo);
    }

    /**
     * 模型自有字段的处理
     * @param factoryNo
     * @param uriList
     * @param parameterConfigExtend
     * @param synObjectList
     * @return
     */
    private void createHollyField(String factoryNo, List<String> uriList,TbParameterConfigExtend parameterConfigExtend, List<TbSynObject> synObjectList) {
        for(TbSynObject synObject:synObjectList){
            if(uriList.contains(synObject.getUri())){
                continue;
            }
            uriList.add(synObject.getUri());
            TbFillFormField fillFormField = new TbFillFormField();
            fillFormField.setFactoryNo(factoryNo);
            fillFormField.setEquipNo(synObject.getParentUri());
            fillFormField.setConfigNo(synObject.getUri());
            fillFormField.setSedName(parameterConfigExtend.getParameterConfig().getParamName());

            fillFormField.setFieldType(synObject.getFieldType());
            fillFormField.setFillType(synObject.getFieldType());
            fillFormField.setConfigStatus(0);
            fillFormField.setCreateTime(new Date());
            fillFormField.setFieldUnit(synObject.getAccesslevel());

            fillFormField.setFieldName(synObject.getName());
            fillFormField.setFieldCode(synObject.getBrowsename());
            fillFormField.setBrowsePath(synObject.getBrowsepath());
            fillFormField.setCreatePerson("system");

            fillFormFieldMapper.insertSelective(fillFormField);

            TbFillFormFieldExtend fillFormFieldExtend = new TbFillFormFieldExtend();

            fillFormFieldExtend.setConfigNo(synObject.getUri());

            if(fillFormField.getFillType()==1||fillFormField.getFillType()==2){
                fillFormFieldExtend.setType(1);
                fillFormFieldExtend.setCycle(12);
                fillFormFieldExtend.setStartTime("09:00");
                fillFormFieldExtend.setVaildTime("09:00,20:00");
            }else if(fillFormField.getFillType()==3){
                fillFormFieldExtend.setType(5);
                fillFormFieldExtend.setVaildTime("09:00,13:00");
            }
            fillFormFieldExtend.setCreateTime(new Date());
            fillFormFieldExtendMapper.insertSelective(fillFormFieldExtend);

        }
    }

    private void  addObjectData(List<String> objectList,String uri,String factoryNo){

        for(String objectUri :objectList){
            TbObjectDataExample example = new TbObjectDataExample();
            TbObjectDataExample.Criteria criteria = example.createCriteria();
            criteria.andDataFromEqualTo(1);
            criteria.andDataUriEqualTo(uri);
            criteria.andObjectUriEqualTo(objectUri);
            if(objectDataMapper.selectByExample(example).size()==1){
                continue;
            }
            TbObjectData  objectData= new TbObjectData();
            objectData.setDataFrom(1);
            objectData.setObjectUri(objectUri);
            objectData.setDataUri(uri);
            objectData.setFactoryNo(factoryNo);
            objectData.setCreateTime(new Date());
            objectDataMapper.insert(objectData);
        }
    }

    @Autowired
    TbSynObjectMapper tbSynObjectMapper;
    public String getUri(String name,String factory){

        String uri="";
        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        criteria.andBrowsenameEqualTo(name);
        criteria.andFactoryNoEqualTo(factory);
        List<TbSynObject> tbSynObjects = tbSynObjectMapper.selectByExample(example);
        if(tbSynObjects!=null && tbSynObjects.size()>0 ){
            uri=tbSynObjects.get(0).getUri();
        }
        return uri;
    }

    private void getParentList(String uri,String factoryNo,List<String> list){
        TbSynObject synObject = tbSynObjectMapper.selectByPrimaryKey(uri);
        list.add(synObject.getUri());
        if(synObject.getParentUri().indexOf(factoryNo)<0){
            getParentList(synObject.getParentUri(),factoryNo,list);
        }
    }

    private boolean browseNameIsError(String browseName){
        if(StringUtils.isEmpty(browseName)){
            return true;
        }
        if("无".equalsIgnoreCase(browseName)){
            return true;
        }
        if("待定".equalsIgnoreCase(browseName)){
            return true;
        }

        return false;
    }

    @Override
    public List<TbSynObject> getTbSynObject(TbSynObject synObject) {
        TbSynObjectExample example = new TbSynObjectExample();
        TbSynObjectExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(synObject.getFactoryNo());
        criteria.andBrowsenameEqualTo(synObject.getBrowsename());
        List<TbSynObject> list = synObjectMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<TbFillFormField> getFillFieldList(TbFillFormField tbFillFormField) {
        return fillFormFieldMapper.getFieldListByFactoryNo(tbFillFormField.getFactoryNo());
    }


    @Override
    public List<TbFillFormDetail> getFillDetailList(String factoryNo, String startDate, String endDate) {
        return fillFormDetailMapper.selectListByDate(factoryNo,startDate,endDate);
    }

    @Override
    public List<TbReportDate> getReportDate(String date, String factoryNo) {
        String nextDate =DateUtils.formateDate(DateUtils.getNextDate(date));
        String nextNextDate =DateUtils.formateDate(DateUtils.getNextDate(nextDate));
        TbParameterConfigExtend configExtend = new TbParameterConfigExtend();
        configExtend.setFactoryNo(factoryNo);
        List<TbParameterConfigExtend> extendList = parameterConfigService.getParameterConfigExtendList(configExtend);
        List<TbFillFormDetail> detailList =  getFillDetailList(factoryNo,date,nextDate);
        List<TbFillFormDetail> nextDayDetailList =  getFillDetailList(factoryNo,nextDate,nextNextDate);
        Map<String, Map<String,Object>>  tempMap = new HashMap<>(16);
        Map<String,Map<String,Object>>  nextDayTempMap = new HashMap<>(16);
        clearData(tempMap,extendList,detailList);
        clearData(nextDayTempMap,extendList,nextDayDetailList);
        List<TbReportDate> reportDateList = new ArrayList<>();
        for(String uri:tempMap.keySet()){
            Map<String,Object> map = tempMap.get(uri);
            Map<String,Object> nextMap = nextDayTempMap.get(uri);
            TbParameterConfigExtend parameterConfigExtend = (TbParameterConfigExtend)map.get("config");
            List<TbFillFormDetail> valueList = (List<TbFillFormDetail> )map.get("valueList");
            List<TbFillFormDetail> nextValueList = (List<TbFillFormDetail> )nextMap.get("valueList");

            Double value = getValue(parameterConfigExtend,valueList,nextValueList);
            reportDateList.add(getReportDate(valueList.get(0),parameterConfigExtend.getExtendName(),parameterConfigExtend.getExtendMathType(),value.floatValue()));
        }
        return reportDateList;
    }

    @Override
    public int addReportDateList(List<TbReportDate> list) {
        return reportDateMapper.insertBatch(list);
    }

    @Override
    public List<TbFillFormField> selectFillFieldList(TbFillFormField tbFillFormField) {
        return fillFormFieldMapper.selectTbFillFormFieldList(tbFillFormField);
    }

    private TbReportDate getReportDate(TbFillFormDetail detail,String browseName,int type,float value){
        TbReportDate reportDate = new TbReportDate();
        reportDate.setDrBrowseName(browseName);
        reportDate.setDrNo(StringTools.getUUID());
        reportDate.setDrCreateTime(new Date());
        reportDate.setDrDate(detail.getFormDate());
        reportDate.setDrDisplayName(detail.getFieldName());
        reportDate.setDrEquipNo(detail.getEquipNo());
        reportDate.setDrFactoryNo(detail.getFactoryNo());
        reportDate.setDrUnit(detail.getFieldUnit());
        reportDate.setDrValue(value);
        reportDate.setDrDataType(type);
        return reportDate;
    }

        private void clearData(Map<String,Map<String,Object>>  tempMap,List<TbParameterConfigExtend> extendList,List<TbFillFormDetail> detailList){
        for(int i=0;i<detailList.size();i++){
            TbFillFormDetail fillFormDetail = detailList.get(i);
            TbParameterConfigExtend ownConfig = null;
            for(TbParameterConfigExtend parameterConfigExtend:extendList){
                if(parameterConfigExtend.getExtendName().equalsIgnoreCase(fillFormDetail.getFieldCode())){
                    ownConfig = parameterConfigExtend;
                    break;
                }
            }
            if(ownConfig!=null){
                Map<String,Object> map = tempMap.get(fillFormDetail.getConfigNo());
                if(map == null){
                    map = new HashMap<>(16);
                    List<TbFillFormDetail> valueList = new ArrayList<>();
                    valueList.add(fillFormDetail);
                    map.put("valueList",valueList);
                    map.put("config",ownConfig);
                    tempMap.put(fillFormDetail.getConfigNo(),map);
                }else{
                    List<TbFillFormDetail> valueList = (List<TbFillFormDetail>)map.get("valueList");
                    valueList.add(fillFormDetail);
                }
            }
        }
    }

    private double getValue(TbParameterConfigExtend parameterConfigExtend,List<TbFillFormDetail> valueList1,List<TbFillFormDetail> valueList2){
        if(parameterConfigExtend.getExtendMathType().intValue()==1){
            if(valueList1.size()>parameterConfigExtend.getSubIndex()&&valueList2.size()>parameterConfigExtend.getSubIndex()){
                return valueList2.get(parameterConfigExtend.getSubIndex()).getFieldValue() - valueList1.get(parameterConfigExtend.getSubIndex()).getFieldValue();
            }
        }
        if(parameterConfigExtend.getExtendMathType().intValue()==2){
            double sum = 0.0;
            for(TbFillFormDetail formDetail:valueList1){
                sum +=formDetail.getFieldValue();
            }
            return sum/valueList1.size();
        }
        if(parameterConfigExtend.getExtendMathType().intValue()==3){
            double value = Double.MIN_VALUE;
            for(TbFillFormDetail formDetail:valueList1){
                value = value<formDetail.getFieldValue()?formDetail.getFieldValue():value;
            }
            return value;
        }
        if(parameterConfigExtend.getExtendMathType().intValue()==3){
            double value = Double.MAX_VALUE;
            for(TbFillFormDetail formDetail:valueList1){
                value = value>formDetail.getFieldValue()?formDetail.getFieldValue():value;
            }
            return value;
        }
        return -1;

    }

}

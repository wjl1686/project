package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbFacilityInfoMapper;
import com.ejobim.opplat.mapper.TbFacilityParamMapper;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.mapper.TbGongyiInfoMapper;
import com.ejobim.opplat.service.FacilityService;
import com.ejobim.opplat.util.StringTools;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
public class FacilityServiceImpl implements FacilityService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TbFactoryInfoMapper factoryInfoMapper;

    private TbFacilityInfoMapper facilityInfoMapper;

    private TbFacilityParamMapper facilityParamMapper;

    private TbGongyiInfoMapper gongyiInfoMapper;

    @Autowired
    public FacilityServiceImpl(TbFactoryInfoMapper factoryInfoMapper,TbFacilityInfoMapper facilityInfoMapper,
                               TbFacilityParamMapper facilityParamMapper,TbGongyiInfoMapper gongyiInfoMapper){
        Assert.notNull(factoryInfoMapper, "factoryInfoMapper must not be null!");
        Assert.notNull(facilityInfoMapper, "facilityInfoMapper must not be null!");
        Assert.notNull(facilityParamMapper, "facilityParamMapper must not be null!");
        Assert.notNull(gongyiInfoMapper, "gongyiInfoMapper must not be null!");
        this.factoryInfoMapper = factoryInfoMapper;
        this.facilityInfoMapper = facilityInfoMapper;
        this.facilityParamMapper = facilityParamMapper;
        this.gongyiInfoMapper = gongyiInfoMapper;
    }

    @Override
    public List<TbFacilityInfo> getFacilityList(TbFacilityInfo facilityInfo) {
        TbFacilityInfoExample example = new TbFacilityInfoExample();
        TbFacilityInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(facilityInfo.getFatiFactoryNo())){
            criteria.andFatiFactoryNoEqualTo(facilityInfo.getFatiFactoryNo());
        }
        if(facilityInfo.getFatiManagerStatus()!=null){
            criteria.andFatiManagerStatusEqualTo(facilityInfo.getFatiManagerStatus());
        }
        if(StringUtils.isNotEmpty(facilityInfo.getFatiName())){
            criteria.andFatiNameLike("%" + facilityInfo.getFatiName() + "%");
        }
        if(StringUtils.isNotEmpty(facilityInfo.getFatiGongyi())){
            criteria.andFatiGongyiLike( facilityInfo.getFatiGongyi() );
        }
        if(StringUtils.isNotEmpty(facilityInfo.getFatiCode())){
            criteria.andFatiCodeEqualTo( facilityInfo.getFatiCode() );
        }
        example.setOrderByClause("fati_create_time desc");
        return facilityInfoMapper.selectByExample(example);
    }

    @Override
    public int saveTbFacilityInfo(TbFacilityInfo facilityInfo, TbUser user) {
        //校验falyNo
        try{
            if(StringUtils.isNotEmpty(facilityInfo.getFatiCode())){
                TbFacilityInfo tbFacilityInfoSearch = new TbFacilityInfo();
                tbFacilityInfoSearch.setFatiCode(facilityInfo.getFatiCode());
                List<TbFacilityInfo> facilityInfoList = getFacilityList(tbFacilityInfoSearch);
                TbFacilityInfo oldFacilityInfo = null;
                if(facilityInfoList.size()> 1){
                    return Dict.AjaxStatus.NUMBER_EXIST.getStatusCode();
                }else if(facilityInfoList.size()== 1){
                    oldFacilityInfo = facilityInfoList.get(0);
                }
                if(StringUtils.isNotEmpty(facilityInfo.getFatiNo())){
                    if(oldFacilityInfo!=null&&!oldFacilityInfo.getFatiNo().equals(facilityInfo.getFatiNo())){
                        return Dict.AjaxStatus.NUMBER_EXIST.getStatusCode();
                    }
                    this.facilityInfoMapper.updateByPrimaryKeySelective(facilityInfo);

                }else  {
                    if(oldFacilityInfo!=null){
                        return Dict.AjaxStatus.NUMBER_EXIST.getStatusCode();
                    }
                    facilityInfo.setFatiNo(StringTools.getUUID());
                    facilityInfo.setFatiCreateTime(new Date());
                    facilityInfo.setFatiCreateUserName(user.getName());
                    this.facilityInfoMapper.insertSelective(facilityInfo);
                }
            }else{
                this.facilityInfoMapper.updateByPrimaryKeySelective(facilityInfo);
                return  Dict.AjaxStatus.YES.getStatusCode();
            }

        }catch(Exception ex){
            logger.error(ex.toString());
            return Dict.AjaxStatus.FAIL.getStatusCode();
        }
        return Dict.AjaxStatus.YES.getStatusCode();
    }



    @Override
    public int deleteTbFacilityInfo(TbFacilityInfo facilityInfo) {
        return facilityInfoMapper.deleteByPrimaryKey(facilityInfo.getFatiNo());
    }

    @Override
    public List<TbFacilityParam> getFacilityParamList(TbFacilityParam facilityParam) {
        return null;
    }

    @Override
    public int saveTbFacilityParam(TbFacilityParam tbFacilityParam) {
        return 0;
    }

    @Override
    public int deleteTbFacilityParam(TbFacilityParam tbFacilityParam) {
        return 0;
    }

    @Override
    public List<TbGongyiInfo> getGongyiList(TbGongyiInfo gongyiInfo) {
        TbGongyiInfoExample example  = new TbGongyiInfoExample();
        TbGongyiInfoExample.Criteria criteria = example.createCriteria();
        criteria.andGongyiFactoryNoEqualTo(gongyiInfo.getGongyiFactoryNo());
        if(gongyiInfo.getGongyiName()!=null){
            criteria.andGongyiNameLike("%"+gongyiInfo.getGongyiName()+"%");
        }
        example.setOrderByClause("gongyi_create_time desc ");
        return this.gongyiInfoMapper.selectByExample(example);
    }

    @Override
    public int saveGongyiInfo(TbGongyiInfo gongyiInfo, TbUser user) {
        //根据组名和水厂查询
        int flag=0;
        List<TbGongyiInfo> tbGongyiInfoList = gongyiInfoMapper.getCheckGongyiList(gongyiInfo);
        if(StringUtils.isNotEmpty(gongyiInfo.getGongyiNo())){
            for (int i = tbGongyiInfoList.size() - 1; i >= 0; i --) {
                if(tbGongyiInfoList.get(i).getGongyiNo().equals(gongyiInfo.getGongyiNo())){
                    tbGongyiInfoList.remove(i);
                }
            }
            if(tbGongyiInfoList!=null && tbGongyiInfoList.size()>0){
                    List<String> stringNameList = tbGongyiInfoList.stream().map(e -> e.getGongyiName()).collect(Collectors.toList());
                    List<Integer> stringIndexList = tbGongyiInfoList.stream().map(e -> e.getGongyiIndex()).collect(Collectors.toList());
                if(stringNameList.contains(gongyiInfo.getGongyiName())|| stringIndexList.contains(gongyiInfo.getGongyiIndex())){
                        flag = Dict.AjaxStatus.RE_NAB_IDEAL.getStatusCode();
                    }else{
                        gongyiInfo.setGongyiUpdtateTime(new Date());
                        gongyiInfo.setGongyiUpdateUser(user.getName());
                        flag =gongyiInfoMapper.updateByPrimaryKeySelective(gongyiInfo);
                    }
               // }
            }else{
                //修改记录没有存在过
                gongyiInfo.setGongyiUpdtateTime(new Date());
                gongyiInfo.setGongyiUpdateUser(user.getName());
                flag = gongyiInfoMapper.updateByPrimaryKeySelective(gongyiInfo);
            }
        }else{
            if(tbGongyiInfoList!=null && tbGongyiInfoList.size()>0){
                flag = Dict.AjaxStatus.RE_NAB_IDEAL.getStatusCode();
            }else {
                gongyiInfo.setGongyiNo(StringTools.getUUID());
                gongyiInfo.setGongyiCreateTime(new Date());
                gongyiInfo.setGongyiCreateUser(user.getName());
               flag =gongyiInfoMapper.insertSelective(gongyiInfo);
            }
        }
        return flag;
    }

 /*   public List<TbGongyiInfo> getCheckGongyiList(TbGongyiInfo gongyiInfo) {
        TbGongyiInfoExample example  = new TbGongyiInfoExample();
        TbGongyiInfoExample.Criteria criteria = example.createCriteria();
        criteria.andGongyiFactoryNoEqualTo(gongyiInfo.getGongyiFactoryNo());
        example.setOrderByClause(" gongyi_index ");
        return this.gongyiInfoMapper.selectByExample(example);
    }*/

    @Override
    public int deleteGongyiInfo(TbGongyiInfo gongyiInfo) {
        return  this.gongyiInfoMapper.deleteByPrimaryKey(gongyiInfo.getGongyiNo());
    }
}

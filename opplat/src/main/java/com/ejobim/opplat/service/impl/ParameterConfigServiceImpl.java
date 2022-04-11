package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbParameterConfig;
import com.ejobim.opplat.domain.TbParameterConfigExample;
import com.ejobim.opplat.domain.TbParameterConfigExtend;
import com.ejobim.opplat.domain.TbParameterConfigExtendExample;
import com.ejobim.opplat.mapper.TbParameterConfigExtendMapper;
import com.ejobim.opplat.mapper.TbParameterConfigMapper;
import com.ejobim.opplat.service.ParameterConfigService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterConfigServiceImpl implements ParameterConfigService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbParameterConfigMapper parameterConfigMapper;
    @Autowired
    private TbParameterConfigExtendMapper parameterConfigExtendMapper;

    @Override
    public List<TbParameterConfig> getParameterConfigList(TbParameterConfig parameterConfig) {
        return null;
    }

    @Override
    public int addTbParameterConfig(TbParameterConfig parameterConfig) {
        return 0;
    }

    @Override
    public int deleteTbParameterConfig(TbParameterConfig parameterConfig) {
        return 0;
    }

    @Override
    public List<TbParameterConfigExtend> getParameterConfigExtendList(TbParameterConfigExtend configExtend) {
        TbParameterConfigExtendExample extendExample = new TbParameterConfigExtendExample();
        TbParameterConfigExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andFactoryNoEqualTo(configExtend.getFactoryNo());
        return parameterConfigExtendMapper.selectByExample(extendExample);
    }

    @Override
    public void addParameterConfigExtendList(String factoryNo) {
        List<TbParameterConfig> configList = parameterConfigMapper.selectByExample(new TbParameterConfigExample());
        for(TbParameterConfig parameterConfig:configList){
            TbParameterConfigExtend configExtend = new TbParameterConfigExtend();
            configExtend.setExtendMathType(parameterConfig.getParemMathType());
            configExtend.setExtendName(parameterConfig.getBrowseName());
            configExtend.setExtendNo(StringTools.getUUID());
            configExtend.setExtendParamNo(parameterConfig.getParamNo());
            configExtend.setSubIndex(0);
            configExtend.setFactoryNo(factoryNo);
            parameterConfigExtendMapper.insert(configExtend);
        }
    }

    @Override
    public List<TbParameterConfig> selectParameterConfigList(TbParameterConfig tbParameterConfig) {
        TbParameterConfigExample example = new TbParameterConfigExample();
        TbParameterConfigExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbParameterConfig.getParamName())){
            criteria.andParamNameLike("%" + tbParameterConfig.getParamName() + "%");
        }
        if(StringUtils.isNotEmpty(tbParameterConfig.getBrowseName())){
            criteria.andBrowseNameEqualTo(tbParameterConfig.getBrowseName());
        }
        if(tbParameterConfig.getParamFrom()!=null){
            criteria.andParamFromEqualTo(tbParameterConfig.getParamFrom());
        }
        if(tbParameterConfig.getParamFromList()!=null){
            criteria.andParamFromIn(tbParameterConfig.getParamFromList());
        }
        if(tbParameterConfig.getParamFillType()!=null){
            criteria.andParamFillTypeEqualTo(tbParameterConfig.getParamFillType());
        }
        example.setOrderByClause("create_time desc");
        return parameterConfigMapper.selectByExample(example);
    }

    @Override
    public int saveTbParameterConfig(TbParameterConfig tbParameterConfig) {
        if(StringUtils.isNotEmpty(tbParameterConfig.getParamNo())){

            return parameterConfigMapper.updateByPrimaryKeySelective(tbParameterConfig);
        }else{
            tbParameterConfig.setParamNo(StringTools.getUUID());
            return parameterConfigMapper.insertSelective(tbParameterConfig);
        }
    }

    @Override
    public int deleteTbParameterConfig(String paramNo) {
        return parameterConfigMapper.deleteByPrimaryKey(paramNo);
    }
}

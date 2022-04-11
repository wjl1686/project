package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbParameterConfig;
import com.ejobim.opplat.domain.TbParameterConfigExtend;

import java.util.List;

public interface ParameterConfigService {

    List<TbParameterConfig> getParameterConfigList(TbParameterConfig parameterConfig);

    int addTbParameterConfig(TbParameterConfig parameterConfig);

    int deleteTbParameterConfig(TbParameterConfig parameterConfig);

    List<TbParameterConfigExtend>  getParameterConfigExtendList(TbParameterConfigExtend configExtend);

    void addParameterConfigExtendList(String factoryNo);


    List<TbParameterConfig> selectParameterConfigList(TbParameterConfig tbParameterConfig);

    int saveTbParameterConfig(TbParameterConfig tbParameterConfig);

    int deleteTbParameterConfig(String paramNo);
}

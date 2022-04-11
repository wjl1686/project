package com.ejobim.opplat.service;


import com.ejobim.opplat.domain.TbFactoryInfo;
import com.ejobim.opplat.rest.HollySys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynServiceImpl implements  SynService {
    @Autowired
    HollySys hollySys;

    @Override
    public int FacoryModelSynchronization() {
        List<TbFactoryInfo> factoryInfoList =  hollySys.getFactoryList();
        int index = 0;
        for(int i=0;i<factoryInfoList.size();i++){
            TbFactoryInfo factoryInfo = factoryInfoList.get(i);
            System.out.println("开始同步" + i +"/" + factoryInfoList.size() + "个水厂，名称名称" +  factoryInfo.getFactoryName() );
            hollySys.getFactoryTree(factoryInfo.getUri(),factoryInfo.getFactoryNo(),1);
        }
        return 0;
    }

    @Override
    public int updateData() {
        return 0;
    }
}

package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbFactoryInfo;
import com.ejobim.opplat.domain.TbOrg;
import com.ejobim.opplat.domain.TbOrgExample;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.mapper.TbOrgMapper;
import com.ejobim.opplat.service.TbOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbOrgServiceImpl implements TbOrgService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TbOrgMapper tbOrgMapper;

    @Autowired
    private TbFactoryInfoMapper factoryInfoMapper;

    @Override
    public List<TbOrg> selectOrgInfoByObject(TbOrg tbOrg) {
        return tbOrgMapper.selectOrgInfoByObject(tbOrg);
    }

    @Override
    public TbOrg getFactoryOrg(String factoryNo) {
        TbFactoryInfo factoryInfo = factoryInfoMapper.selectByPrimaryKey(factoryNo);
        TbOrgExample example = new TbOrgExample();
        example.createCriteria().andUriEqualTo(factoryInfo.getUri());
        List<TbOrg> list = tbOrgMapper.selectByExample(example);
        return list.size()==1?list.get(0):null;
    }
}

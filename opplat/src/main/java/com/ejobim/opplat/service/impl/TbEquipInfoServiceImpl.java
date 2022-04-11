package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbEquipInfoExample;
import com.ejobim.opplat.mapper.TbEquipInfoMapper;
import com.ejobim.opplat.service.TbEquipInfoService;
import com.ejobim.opplat.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xibian
 * @date 2019-05-10
 */
@Service
public class TbEquipInfoServiceImpl implements TbEquipInfoService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbEquipInfoMapper tbEquipInfoMapper;

    @Override
    public int saveTbEquipInfo(TbEquipInfo tbEquipInfo) {
        if (tbEquipInfo.getEquipNo() == null) {
            tbEquipInfo.setEquipNo(StringTools.getUUID());
            return tbEquipInfoMapper.insert(tbEquipInfo);
        } else {
            return tbEquipInfoMapper.updateByPrimaryKeySelective(tbEquipInfo);
        }
    }

    @Override
    public List<TbEquipInfo> getTbEquipInfoList(TbEquipInfo tbEquipInfo) {
        TbEquipInfoExample tbEquipInfoExample = new TbEquipInfoExample();
        TbEquipInfoExample.Criteria criteria = tbEquipInfoExample.createCriteria();
        if (tbEquipInfo.getFactoryNo() != null) {
            criteria.andFactoryNoEqualTo(tbEquipInfo.getFactoryNo());
        }

        if (tbEquipInfo.getEquipName() != null) {
            criteria.andEquipNameLike("%" + tbEquipInfo.getEquipName() + "%");
        }

        return tbEquipInfoMapper.selectByExample(tbEquipInfoExample);
    }

}

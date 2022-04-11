package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbSpareParts;
import com.ejobim.opplat.domain.TbSparePartsExample;
import com.ejobim.opplat.mapper.TbSparePartsMapper;
import com.ejobim.opplat.service.SparePartsService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SparePartsServiceImpl implements SparePartsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private TbSparePartsMapper sparePartsMapper;

    @Autowired
    public SparePartsServiceImpl(TbSparePartsMapper sparePartsMapper){
        this.sparePartsMapper = sparePartsMapper;
    }


    @Override
    public List<TbSpareParts> getTbSparePartsList(TbSpareParts spareParts,List<String> idList) {
        TbSparePartsExample example = new TbSparePartsExample();
        TbSparePartsExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(spareParts.getFactoryNo());
        if(spareParts.getSparePartsType()!=null){
            criteria.andSparePartsTypeEqualTo(spareParts.getSparePartsType());
        }
        if(StringUtils.isNotEmpty(spareParts.getSparePartsName())){
            criteria.andSparePartsNameLike("%" +  spareParts.getSparePartsName() + "%");
        }
        if(StringUtils.isNotEmpty(spareParts.getEquipType())){
            criteria.andEquipTypeEqualTo(spareParts.getEquipType());
        }
        if(idList!=null){
            criteria.andEquipTypeNotIn(idList);
        }
        example.setOrderByClause("create_time desc");
        return sparePartsMapper.selectByExample(example);
    }

    @Override
    public int saveTbSpareParts(TbSpareParts spareParts) {
        if(StringUtils.isNotEmpty(spareParts.getSparePartsNo())){
            return this.sparePartsMapper.updateByPrimaryKeySelective(spareParts);
        }else{
            spareParts.setSparePartsNo(StringTools.getUUID());
            spareParts.setCreateTime(new Date());
            return sparePartsMapper.insert(spareParts);
        }
    }

    @Override
    public int deleteTbSpareParts(TbSpareParts tbSpareParts) {
        return sparePartsMapper.deleteByPrimaryKey(tbSpareParts.getSparePartsNo());
    }

    @Override
    public int useSpareParts(TbSpareParts tbSpareParts, int useCount) {
        tbSpareParts.setSparePartsCount(tbSpareParts.getSparePartsCount() - useCount);
        return sparePartsMapper.updateByPrimaryKeySelective(tbSpareParts);
    }

    @Override
    public List selectSparePartsByCond(TbSpareParts spareParts) {
        return sparePartsMapper.selectSparePartsByCond(spareParts);
    }


}

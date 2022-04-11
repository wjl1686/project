package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbCalc;
import com.ejobim.opplat.domain.TbCalcExample;
import com.ejobim.opplat.mapper.TbCalcMapper;
import com.ejobim.opplat.service.TbCalcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author  xibian
 * @date 2019-05-10
 */
@Service
public class TbCalcServiceImpl implements TbCalcService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    TbCalcMapper tbCalcMapper;
    @Override
    public List<TbCalc> getTbCalcList() {
        return tbCalcMapper.selectByExample(null);
    }

    @Override
    public int addTbCalc(TbCalc tbCalc) {
        return tbCalcMapper.insert(tbCalc);
    }

    @Override
    public TbCalc getTbCalc(String name) {
        TbCalcExample example = new TbCalcExample();
        TbCalcExample.Criteria criteria = example.createCriteria();
        criteria.andCalcNameEqualTo(name);
        List<TbCalc> list = tbCalcMapper.selectByExample(example);
        if(list.size()>=0){
            return list.get(0);
        } else{
            return null;
        }

    }

    @Override
    public List<Map<String, Object>> getTableDetailInfo(String sql) {
        return tbCalcMapper.getTableDetailInfo(sql);
    }
}

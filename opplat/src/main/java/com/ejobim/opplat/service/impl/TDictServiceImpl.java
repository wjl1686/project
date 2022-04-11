package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TDict;
import com.ejobim.opplat.domain.TDictExample;
import com.ejobim.opplat.mapper.TDictMapper;
import com.ejobim.opplat.service.TDictService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,  rollbackFor = Exception.class)
public class TDictServiceImpl implements TDictService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TDictMapper tDictMapper;

    @Override
    public List<TDict> findTDictList(TDict tDict) {
        logger.info("查询菜单,TDict:{}", JSON.toJSONString(tDict));
        List<TDict> tDicts = new ArrayList<>();
        try {
            TDictExample example = new TDictExample();
            if (StringUtils.isNotBlank(tDict.getValuee())) {
                TDictExample.Criteria  criteria = example.createCriteria();
                criteria.andValueeEqualTo(tDict.getValuee());
            }
            tDicts = tDictMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取菜单信息失败", e);
        }
        return tDicts;
    }

    @Override
    public int addDict(TDict tDict) {
        logger.info("添加字典,TDict:{}", JSON.toJSONString(tDict));
        return  tDictMapper.insert(tDict);

    }

    @Override
    public int updateDict(TDict tDict) {
        logger.info("修改字典,TDict:{}", JSON.toJSONString(tDict));
        return  tDictMapper.updateByPrimaryKeySelective(tDict);
    }

    @Override
    public int deleteDicts(String[] ids) {
        return 0;
    }
}

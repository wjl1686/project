package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbDict;
import com.ejobim.opplat.domain.TbDictExample;
import com.ejobim.opplat.domain.TbEquipAdjust;
import com.ejobim.opplat.mapper.TbDictMapper;
import com.ejobim.opplat.service.TbDictService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TbDictServiceImpl implements TbDictService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbDictMapper tbDictMapper;

    @Override
    public List<TbDict> findTbDictList(TbDict tbDict) {
        logger.info("查询菜单,TbDict:{}", JSON.toJSONString(tbDict));
        List<TbDict> tbDicts = new ArrayList<>();
        try {
            TbDictExample example = new TbDictExample();
            TbDictExample.Criteria  criteria = example.createCriteria();
            if (StringUtils.isNotBlank(tbDict.getValueName())) {
                criteria.andValueNameEqualTo(tbDict.getValueName());
            }
            if(tbDict.getParentId()!=null){
                criteria.andParentIdEqualTo(tbDict.getParentId());
            }else{
                criteria.andParentIdNotEqualTo(0);
            }
            tbDicts = tbDictMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取菜单信息失败", e);
        }
        return tbDicts;
    }

    @Override
    public List<TbDict> getDictByParent(List<Integer> parentList){
        return tbDictMapper.getDictByParent(parentList);
    }

    @Override
    public int addDict(TbDict tbDict) {
        logger.info("添加字典,TbDict:{}", JSON.toJSONString(tbDict));
        List<TbDict> oldList = getDictByKey(tbDict.getParentId(),tbDict.getKeyName());
        if(oldList.size()>0){
            return Dict.AjaxStatus.RECREATE.getStatusCode();
        }
        tbDict.setCreateTime(new Date());
        tbDictMapper.insert(tbDict);
        return  Dict.AjaxStatus.YES.getStatusCode();

    }

    private List<TbDict> getDictByKey(Integer parentId,String key){
        TbDictExample dictExample = new TbDictExample();
        dictExample.createCriteria().andParentIdEqualTo(parentId).andKeyNameEqualTo(key);
        return tbDictMapper.selectByExample(dictExample);
    }

    @Override
    public int updateDict(TbDict tbDict) {
        logger.info("字典tbDict:{}",JSON.toJSONString(tbDict));
        List<TbDict> oldList = getDictByKey(tbDict.getParentId(),tbDict.getKeyName());
        if(oldList.size()>1){
            return Dict.AjaxStatus.RECREATE.getStatusCode();
        }else if(oldList.size()==1){
            if(!tbDict.getId().equals(oldList.get(0).getId())){
                return Dict.AjaxStatus.RECREATE.getStatusCode();
            }
        }
        tbDict.setCreateTime(new Date());
        if(tbDictMapper.updateByPrimaryKey(tbDict)>0){
            return  Dict.AjaxStatus.YES.getStatusCode();
        }else{
            return  Dict.AjaxStatus.FAIL.getStatusCode();
        }

    }

    @Override
    public int deleteDicts(String[] ids) {
        logger.info("删除字典ids:{}",JSON.toJSONString(ids));
        int flag=0;
        for (String id:ids) {
            flag=tbDictMapper.deleteByPrimaryKey(Integer.valueOf(id));
         }
        return flag;
    }
}

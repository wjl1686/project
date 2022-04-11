package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbEquipInfoExample;
import com.ejobim.opplat.domain.TbEquipMaintainFactor;
import com.ejobim.opplat.domain.TbEquipMaintainFactorExample;
import com.ejobim.opplat.domain.vo.TbEquipMaintainFactorVo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.mapper.TbEquipInfoMapper;
import com.ejobim.opplat.mapper.TbEquipMaintainFactorMapper;
import com.ejobim.opplat.service.TbEquipMaintainFactorService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ejobim.opplat.common.Dict.DELETE_NO;

/**
 * @author wujianlong
 * @Description: 维保要素相关
 * @date 2019/7/11 14:18
 */
@Service
public class TbEquipMaintainFactorServiceImpl implements TbEquipMaintainFactorService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int flag=0;

    @Autowired
    private TbEquipMaintainFactorMapper tbEquipMaintainFactorMapper;
    @Autowired
    private TbEquipInfoMapper tbEquipInfoMapper;
    @Override
    public List<TbEquipMaintainFactor> getTbEquipMaintainFactorList(TbEquipMaintainFactor tbEquipMaintainFactor, List<String> equipTypeList) {
        List<TbEquipMaintainFactor> tbEquipMaintainFactorList= tbEquipMaintainFactorMapper.selcetTbEquipMaintainFactorList(tbEquipMaintainFactor);
        return tbEquipMaintainFactorList;
    }

    @Override
    public List<TbEquipInfo> getTbEquipListByfactoryNo(TbEquipInfo tbEquipInfo) {
        TbEquipInfoExample equipInfoExample = new TbEquipInfoExample();
        TbEquipInfoExample.Criteria criteria = equipInfoExample.createCriteria();
        if(tbEquipInfo.getFactoryNo()!=null){
            criteria.andFactoryNoEqualTo(tbEquipInfo.getFactoryNo());
        }
        if(tbEquipInfo.getEquipName()!=null){
            criteria.andEquipNameLike("%"+tbEquipInfo.getEquipName()+"%");
        }
        List<TbEquipInfo> tbEquipInfoList =tbEquipInfoMapper.selectByExample(equipInfoExample);
        return tbEquipInfoList;
    }

    @Override
    public int saveTbEquipMaintainFactor(TbEquipMaintainFactor tbEquipMaintainFactor) {
        if(tbEquipMaintainFactor.getMfNo()!=null){
            if(tbEquipMaintainFactor.getMfTimeName()!=null){
                tbEquipMaintainFactor.setMfTime(DateUtils.parseDate(tbEquipMaintainFactor.getMfTimeName()));
            }
            flag =tbEquipMaintainFactorMapper.updateByPrimaryKeySelective(tbEquipMaintainFactor);
        }else{
            if(tbEquipMaintainFactor.getMfTimeName()!=null){
             tbEquipMaintainFactor.setMfTime(DateUtils.parseDate(tbEquipMaintainFactor.getMfTimeName()));
            }
            tbEquipMaintainFactor.setMfNo(StringTools.getUUID());
            flag=tbEquipMaintainFactorMapper.insertSelective(tbEquipMaintainFactor);
        }
        return flag;
    }

    @Override
    public int updateEquipMaintainFactor(TbEquipMaintainFactor tbEquipMaintainFactor) {
        TbEquipMaintainFactor equipMaintainFactor = tbEquipMaintainFactorMapper.selectByPrimaryKey(tbEquipMaintainFactor.getMfNo());
        if(equipMaintainFactor.getFlag().intValue()==0){
            equipMaintainFactor.setFlag(1);
        }else{
            equipMaintainFactor.setFlag(0);
        }
        return tbEquipMaintainFactorMapper.updateByPrimaryKeySelective(equipMaintainFactor);
    }

    @Override
    public List<TbEquipMaintainFactor> getTbEquipMaintainFactorList(String factoryNo) {
        TbEquipMaintainFactorExample example = new TbEquipMaintainFactorExample();
        TbEquipMaintainFactorExample.Criteria criteria = example.createCriteria();
        criteria.andFactoryNoEqualTo(factoryNo);
        criteria.andFlagEqualTo(DELETE_NO);
        return tbEquipMaintainFactorMapper.selectByExample(example);
    }

    @Override
    public TbEquipMaintainFactor getTbEquipMaintainFactorByKey(String mfNo) {
        return tbEquipMaintainFactorMapper.selectByPrimaryKey(mfNo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public int saveImportEquipMaintainFactor(List<TbEquipMaintainFactorVo> list) {
        int flag =0;
        String parentNo="";
        String equipName="";
        if(list!=null && list.size()>0){
            for (TbEquipMaintainFactorVo tbVo : list) {
                TbEquipMaintainFactor tbEquipMaintainFactor = new TbEquipMaintainFactor();
                String equipNames = tbVo.getEquipName();
                if(equipNames.split(",").length==2){
                    equipName = equipNames.split(",")[0];
                    parentNo  = equipNames.split(",")[1];
                }
                BeanUtils.copyProperties(tbVo, tbEquipMaintainFactor);
                tbEquipMaintainFactor.setMfNo(StringTools.getUUID());
                tbEquipMaintainFactor.setEquipNo(parentNo);
                tbEquipMaintainFactor.setEquipName(equipName);
                tbEquipMaintainFactor.setFlag(0);
                if(tbVo.getMfTimeName()!=null){
                    tbEquipMaintainFactor.setMfTime(DateUtils.parseDate(tbVo.getMfTimeName()));
                }
                flag=tbEquipMaintainFactorMapper.insertSelective(tbEquipMaintainFactor);
            }
            if(flag==0){
                throw new BusinessException(500,"导入失败");
            }
        }

        return flag;
    }
}

package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbMedicineDictMapper;
import com.ejobim.opplat.mapper.TbMedicineMapper;
import com.ejobim.opplat.mapper.TbSynObjectMapper;
import com.ejobim.opplat.service.TbMedicineService;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/20 16:24
 */
@Service
public class TbMedicineServiceImpl implements TbMedicineService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbMedicineMapper tbMedicineMapper;
    @Autowired
    private TbMedicineDictMapper tbMedicineDictMapper;
    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;

    @Override
    public void addMedicine(List<String> mids,List<String> uris,String factoryNO,String username) {
        //通过mids 查
        List<TbMedicineDict> tbMedicineDicts=tbMedicineDictMapper.selectBatchIds(mids);
        System.out.println(tbMedicineDicts.size());
        //uris
        //List<TbSynObject> tbSynObjects= tbSynObjectMapper.selectBatchUris(uris);
        List<TbMedicine> tbMedicineList = new ArrayList<>();
        for (int i=0; i<tbMedicineDicts.size();i++) {
            TbMedicineDict tbMedicineDict = tbMedicineDicts.get(i);
            TbMedicine tbMedicine = new TbMedicine();
            tbMedicine.setFactoryNo(factoryNO);
            tbMedicine.setCreateTime(new Date());
            tbMedicine.setCreateUser(username);
            tbMedicine.setMedicineNo(StringTools.getUUID());
            tbMedicine.setTargetNo(tbMedicineDict.getTragetNo());
            tbMedicine.setChemicalName(tbMedicineDict.getMedicineName());
            tbMedicine.setChemical(tbMedicineDict.getChemical());
            tbMedicine.setMedicineCategory(tbMedicineDict.getMedicineCategory());
            tbMedicine.setMedicineContent(tbMedicineDict.getMedicineContent());
            tbMedicine.setMedicineVaid(tbMedicineDict.getMedicineVaid());
            tbMedicine.setCategoryType(tbMedicineDict.getCategoryType());
            tbMedicine.setName(uris.get(i));
            tbMedicine.setUri(uris.get(i));
//            for (int t=0; t<tbSynObjects.size();t++) {
//                TbSynObject tbSynObject = tbSynObjects.get(t);
//                if(i==t){
//                    tbMedicine.setUri(tbSynObject.getUri());
//                    tbMedicine.setName(tbSynObject.getName());
//                }
//
//            }
            tbMedicineList.add(tbMedicine);
        }
        System.out.println(tbMedicineList.size());
        for (TbMedicine tbMedicine : tbMedicineList) {
            tbMedicineMapper.insertSelective(tbMedicine);
        }
    }

    @Override
    public List<TbMedicine> findMedicineList(TbMedicine tbMedicine) {
        TbMedicineExample example  = new TbMedicineExample();
        TbMedicineExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbMedicine.getTargetNo())){
            criteria.andTargetNoLike("%" + tbMedicine.getTargetNo() + "%");
        }
        if(StringUtils.isNotEmpty(tbMedicine.getChemicalName())){
            criteria.andChemicalNameLike("%" +  tbMedicine.getChemicalName() + "%");
        }
        if(StringUtils.isNotEmpty(tbMedicine.getMedicineCategory())){
            criteria.andMedicineCategoryLike(tbMedicine.getMedicineCategory());
        }
        if(StringUtils.isNotEmpty(tbMedicine.getMedicineVaid())){
            criteria.andMedicineVaidLike( "%"+ tbMedicine.getMedicineVaid() + "%");
        }
        if(StringUtils.isNotEmpty(tbMedicine.getFactoryNo())){
            String[] strs = tbMedicine.getFactoryNo().split(",");
            if(strs.length>1){
                criteria.andFactoryNoNotIn(Arrays.asList(strs));
            }else{
                criteria.andFactoryNoEqualTo(tbMedicine.getFactoryNo());
            }

        }
        example.setOrderByClause("  create_time desc ");
        return tbMedicineMapper.selectByExample(example);
    }

    @Override
    public void deleteWarn(String[] medicineNos) {
        for (String medicineNo :  medicineNos) {
            tbMedicineMapper.deleteByPrimaryKey(medicineNo);
        }

    }

    @Override
    public List<TbMedicineDict> findMedicineDictList(TbMedicineDict tbMedicine) {
        TbMedicineDictExample tbMedicineDictExample = new TbMedicineDictExample();
        return tbMedicineDictMapper.selectByExample(tbMedicineDictExample);
    }

    @Override
    public List<TbSynObject> findSynObjectList(String factoryNo) {
        return tbSynObjectMapper.findSynObjectList(factoryNo);
    }
}

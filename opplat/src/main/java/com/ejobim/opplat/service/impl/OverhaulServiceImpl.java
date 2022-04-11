package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.common.WorkFlowCommon;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.OverhaulService;
import com.ejobim.opplat.util.StringTools;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author  xibian
 * @date 2019-05-10
 */
@Service
@Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
public class OverhaulServiceImpl implements OverhaulService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TbFactoryInfoMapper factoryInfoMapper;
    private TbEquipTaskFileMapper fileMapper;

    @Autowired
    public OverhaulServiceImpl(TbFactoryInfoMapper factoryInfoMapper,TbEquipTaskFileMapper fileMapper){

        Assert.notNull(factoryInfoMapper, "factoryInfoMapper must not be null!");
        Assert.notNull(fileMapper, "fileMapper must not be null!");
        this.factoryInfoMapper = factoryInfoMapper;
        this.fileMapper = fileMapper;
    }




    @Override
    public List<TbEquipTaskFile> getFileList(TbEquipTaskFile overhaulTaskFile) {
        TbEquipTaskFileExample example = new TbEquipTaskFileExample();
        TbEquipTaskFileExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskExtendNo())){
            criteria.andOfTaskExtendNoEqualTo(overhaulTaskFile.getOfTaskExtendNo());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskNo())){
            criteria.andOfTaskNoEqualTo(overhaulTaskFile.getOfTaskNo());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfFactoryNo())){
            criteria.andOfFactoryNoEqualTo(overhaulTaskFile.getOfFactoryNo());
        }
        if(StringUtils.isNotEmpty(overhaulTaskFile.getOfTaskStatusCode())){
            criteria.andOfTaskStatusCodeEqualTo(overhaulTaskFile.getOfTaskStatusCode());
        }
        criteria.andOfTypeEqualTo(overhaulTaskFile.getOfType());
        return fileMapper.selectByExample(example) ;
    }

    @Override
    public int addTaskFile(TbEquipTaskFile overhaulTaskFile) {

        overhaulTaskFile.setOfUploadTime(new Date());
        overhaulTaskFile.setOfFileStatus(0);
        overhaulTaskFile.setOfNo(StringTools.getUUID());
        return fileMapper.insert(overhaulTaskFile);
    }

    @Override
    public int deleteTaskFile(TbEquipTaskFile overhaulTaskFile) {
        return fileMapper.deleteByPrimaryKey(overhaulTaskFile.getOfNo());
    }


}

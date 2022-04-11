package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbUserPosition;
import com.ejobim.opplat.domain.TbUserPositionExample;
import com.ejobim.opplat.mapper.TbUserPositionMapper;
import com.ejobim.opplat.service.TbUserPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserPositionServiceImpl implements TbUserPositionService {

    @Value("${position_key}")
    private String position_key;

    @Autowired
    private TbUserPositionMapper tbUserPositionMapper;


    @Override
    public int countByExample(TbUserPositionExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TbUserPositionExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TbUserPosition record) {
        return tbUserPositionMapper.insert(record);
    }

    @Override
    public int insertSelective(TbUserPosition record) {
        return 0;
    }

    @Override
    public List<TbUserPosition> selectByExample(TbUserPositionExample example) {
        return null;
    }

    @Override
    public TbUserPosition selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(TbUserPosition record, TbUserPositionExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TbUserPosition record, TbUserPositionExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TbUserPosition record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TbUserPosition record) {
        return 0;
    }
}

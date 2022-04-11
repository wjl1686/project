package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.TbAppInfo;
import com.ejobim.opplat.domain.TbAppInfoExample;
import com.ejobim.opplat.mapper.TbAppInfoMapper;
import com.ejobim.opplat.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xibian
 * @date 2019-05-10
 */
@Service
public class AppServiceImpl implements AppService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private TbAppInfoMapper appInfoMapper;



    @Autowired
    public AppServiceImpl(TbAppInfoMapper appInfoMapper){
        this.appInfoMapper = appInfoMapper;
    }
    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public List<TbAppInfo> getAppInfoList() {
        return null;
    }
    
    private TbAppInfo getAppInfo(String appVersion, Integer appChannel) {
        TbAppInfoExample example = new TbAppInfoExample();
        TbAppInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAppVersionEqualTo(appVersion);
        criteria.andAppChannelEqualTo(appChannel);
        List<TbAppInfo> list = appInfoMapper.selectByExample(example);
        if(list.size() >= 1) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public TbAppInfo getLastedAppInfo(String appVersion,Integer appChannel) {
        TbAppInfo app = this.getAppInfo(appVersion, appChannel);
        TbAppInfoExample example = new TbAppInfoExample();
        TbAppInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAppStatusEqualTo(0);
        if(app != null) {
            criteria.andIdGreaterThan(app.getId());
        }
        criteria.andAppChannelEqualTo(appChannel);
        example.setOrderByClause(" id desc ");
        List<TbAppInfo> list = appInfoMapper.selectByExample(example);
        if(list.size()>=1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void testLock() {
        logger.info("开发抢");
        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        String numStr = stringRedisTemplate.opsForValue().get("num");
        if(StringUtils.isEmpty(numStr)){
            return;
        }
        int num = Integer.parseInt(numStr);
        stringRedisTemplate.opsForValue().set("num",String.valueOf(++num));
        lock.unlock();
        logger.info("结束了");
    }

}

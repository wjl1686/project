package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.domain.User;
import com.ejobim.opplat.domain.UserExample;
import com.ejobim.opplat.mapper.UserMapper;
import com.ejobim.opplat.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xibian
 * @date 2019-05-10
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserMapper userMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedissonClient redissonClient;
    
    public List<User> getTbUserLists() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        List<User> list = userMapper.selectByExample(example);
       return list;
    }

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

    @Override
    public int save() {
        for (int i =20; i<100; i++) {
            User user = new User();
            user.setName(1+"cc");
            user.setAge(i);
            user.setCreateTime(new Date());
            user.setCreator(1111L);
            userMapper.insertSelective(user);
        }
        return 0;
    }
}

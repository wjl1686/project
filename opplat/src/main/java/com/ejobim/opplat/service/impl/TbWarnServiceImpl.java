package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbWarn;
import com.ejobim.opplat.mapper.TbWarnMapper;
import com.ejobim.opplat.service.TbWarnService;
import com.ejobim.opplat.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wujianlong
 * @Description: 告警业务实现类
 * @date 2019/1/19 10:49
 */
@Service
public class TbWarnServiceImpl  implements TbWarnService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbWarnMapper tbWarnMapper;

    @Override
    public void addWarn(TbWarn tbWarn) {
        logger.info("新增告警参数TbWarn={}", JSON.toJSONString(tbWarn));
        tbWarn.setWarnNo(StringTools.getUUID());
        tbWarn.setCreateTime(new Date());
        tbWarnMapper.insertSelective(tbWarn);
    }

    @Override
    public void updateWarn(TbWarn tbWarn) {
        logger.info("修改告警参数TbWarn={}", JSON.toJSONString(tbWarn));
        tbWarnMapper.updateByPrimaryKeySelective(tbWarn);
    }

    @Override
    public List<TbWarn> findWarnList(String currentTime) {
        logger.info("查询告警列表参数currentTime={}", currentTime);
        return tbWarnMapper.findWarnList(currentTime);

    }
}

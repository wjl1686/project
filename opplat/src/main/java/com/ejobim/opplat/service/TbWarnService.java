package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbWarn;

import java.util.List;

/**
 * @author wujianlong
 * @Description: 告警业务
 * @date 2019/1/19 10:48
 */
public interface TbWarnService {
    /**
     * @author wujianlong
     * @date 2019-1-19 11:02:08
     * @Description 添加告警
     * @version 1.0
     * @param tbWarn
     */
    void addWarn(TbWarn tbWarn);
    /**
     * @author wujianlong
     * @date 2019-1-19 11:05:08
     * @Description 修改告警状态
     * @version 1.0
     * @param tbWarn
     */
    void updateWarn(TbWarn tbWarn);
    /**
     * @author wujianlong
     * @date 2019-1-19 11:17:08
     * @Description 查询告警列表
     * @version 1.0
     * @param currentTime
     */
    List<TbWarn> findWarnList(String currentTime);
}

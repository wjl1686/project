package com.ejobim.opplat.service.impl;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbAnnouncement;
import com.ejobim.opplat.domain.TbAnnouncementExample;
import com.ejobim.opplat.mapper.TbAnnouncementMapper;
import com.ejobim.opplat.service.TbAnnouncementService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/1/19 10:53
 */
@Service
public class TbAnnouncementServiceImpl implements TbAnnouncementService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbAnnouncementMapper tbAnnouncementMapper;
    @Override
    public void addAnnouncement(TbAnnouncement tbAnnouncement) {
        logger.info("新增公告参数TbAnnouncement={}", JSON.toJSONString(tbAnnouncement));
        tbAnnouncement.setAnnoucementNo(StringTools.getUUID());
        tbAnnouncement.setCreateTime(new Date());
        tbAnnouncementMapper.insertSelective(tbAnnouncement);
    }

    @Override
    public void updateAnnouncement(TbAnnouncement tbAnnouncement) {
        logger.info("修改公告参数TbAnnouncement={}", JSON.toJSONString(tbAnnouncement));
        tbAnnouncementMapper.updateByPrimaryKeySelective(tbAnnouncement);
    }

    @Override
    public List<TbAnnouncement> findAnnouncementList(String currentTime) {
        logger.info("查询公告列表参数currentTime={}", currentTime);
        List<TbAnnouncement> tbAnnouncements = new ArrayList<>();
        try {
            TbAnnouncementExample example = new TbAnnouncementExample();
            if (StringUtils.isNotBlank(currentTime)) {
                TbAnnouncementExample.Criteria  criteria = example.createCriteria();
                criteria.andCreateTimeEqualTo(DateUtils.parseDate(currentTime));
                criteria.andIfCancelEqualTo(0);
                criteria.andDelFlagEqualTo(0);
            }
            example.setOrderByClause("create_time");
            tbAnnouncements = tbAnnouncementMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("查询公告列表", e);
        }
        return tbAnnouncements;
    }

    @Override
    public TbAnnouncement getAnnouncementInfo(String announcementNo) {
        logger.info("查询公告单个信息参数announcementNo={}", announcementNo);
        TbAnnouncement tbAnnouncement = tbAnnouncementMapper.selectByPrimaryKey(announcementNo);
        return tbAnnouncement;
    }
}

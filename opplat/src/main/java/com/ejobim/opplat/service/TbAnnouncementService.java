package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbAnnouncement;

import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/1/19 10:53
 */
public interface TbAnnouncementService {
    /**
     * @author wujianlong
     * @date 2019-1-19 14:02:08
     * @Description 添加公告
     * @version 1.0
     * @param tbAnnouncement
     */
    
    void addAnnouncement(TbAnnouncement tbAnnouncement);
    
    /**
     * @author wujianlong
     * @date 2019-1-19 14:10:08
     * @Description 修改公告
     * @version 1.0
     * @param tbAnnouncement
     */
    
    void updateAnnouncement(TbAnnouncement tbAnnouncement);
    
    /**
     * @author wujianlong
     * @date 2019-1-19 14:22:08
     * @Description 查询公告列表
     * @version 1.0
     * @param currentTime
     */
    
    List<TbAnnouncement> findAnnouncementList(String currentTime);
    
    /**
     * @author wujianlong
     * @date 2019-1-19 14:30:08
     * @Description 查询单个公告信息
     * @version 1.0
     * @param announcementNo
     */
    
    TbAnnouncement getAnnouncementInfo(String announcementNo);
}

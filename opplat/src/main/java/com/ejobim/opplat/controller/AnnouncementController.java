package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbAnnouncement;
import com.ejobim.opplat.service.TbAnnouncementService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 公告相关
 * @date 2019/1/19 10:46
 */
@Api(description = "公告相关")
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbAnnouncementService tbAnnouncementService;
    
    /**
     * 添加公告
     * @param tbAnnouncement
     * @return
     */
    @PostMapping("/addAnnouncement")
    public AjaxObject addAnnouncement(TbAnnouncement tbAnnouncement){
        logger.info("新增公告参数TbAnnouncement={}", JSON.toJSONString(tbAnnouncement));
        try {
            tbAnnouncementService.addAnnouncement(tbAnnouncement);
            return AjaxObject.ok("新增公告成功");
        } catch (Exception e) {
            logger.error("新增公告失败e={}", e);
            return AjaxObject.error("新增公告失败，请联系网站管理员！");
        }
    }

    /**
     * 修改公告()
     * @param tbAnnouncement
     * @return
     */
    @PostMapping("/updateAnnouncement")
    public AjaxObject updateAnnouncement(TbAnnouncement tbAnnouncement){
        logger.info("修改公告参数TbAnnouncement={}", JSON.toJSONString(tbAnnouncement));
        try {
            tbAnnouncementService.updateAnnouncement(tbAnnouncement);
            return AjaxObject.ok("修改公告成功");
        } catch (Exception e) {
            logger.error("修改公告失败e={}", e);
            return AjaxObject.error("修改公告失败，请联系网站管理员！");
        }
    }

    /**
     * 查询公告列表
     * @param currentTime
     * @return
     */
    @GetMapping("/getAnnouncementList")
    public AjaxObject getAnnouncementList(String currentTime){
        logger.info("查询公告列表参数currentTime={}", currentTime);
        List<TbAnnouncement> tbWarns = tbAnnouncementService.findAnnouncementList(currentTime);
        Map<String,Object> map = new HashMap<>(16);
        map.put("tbWarns",tbWarns);
        return AjaxObject.ok(map);
    }

    /**
     * 查询公告信息
     * @param announcementNo
     * @return
     */
    @GetMapping("/getAnnouncementInfo")
    public AjaxObject getAnnouncementInfo(String announcementNo){
        logger.info("查询公告信息参数announcementNo={}", announcementNo);
        TbAnnouncement tbAnnouncement = tbAnnouncementService.getAnnouncementInfo(announcementNo);
        Map<String,Object> map = new HashMap<>(16);
        map.put("tbAnnouncement",tbAnnouncement);
        return AjaxObject.ok(map);
    }
}

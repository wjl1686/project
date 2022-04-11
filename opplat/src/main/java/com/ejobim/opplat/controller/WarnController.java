package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.annotation.Log;
import com.ejobim.opplat.domain.TbWarn;
import com.ejobim.opplat.service.TbWarnService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 告警信息
 * @date 2019/1/19 10:47
 */
@Api(tags = "告警信息")
@RestController
@RequestMapping("/warn")
public class WarnController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbWarnService tbWarnService;
    /**
     * 添加告警
     * @param tbWarn
     * @return
     */
    @Log("添加告警信息")
    @PostMapping("/addWarn")
    public AjaxObject addWarn(TbWarn tbWarn){
        logger.info("新增告警参数TbWarn={}", JSON.toJSONString(tbWarn));
        try {
            tbWarnService.addWarn(tbWarn);
            return AjaxObject.ok("新增告警成功");
        } catch (Exception e) {
            logger.error("新增告警失败e={}", e);
            return AjaxObject.error("新增告警失败，请联系网站管理员！");
        }
    }

    /**
     * 修改告警状态
     * @param tbWarn
     * @return
     */
    @PostMapping("/updateWarn")
    public AjaxObject updateWarn(TbWarn tbWarn) {
        logger.info("修改告警参数role={},关联菜单menuIds={}", JSON.toJSONString(tbWarn));
        try {
            tbWarnService.updateWarn(tbWarn);
            return AjaxObject.ok("修改告警成功！");
        } catch (Exception e) {
            logger.error("修改告警失败", e);
            return AjaxObject.error("修改告警失败，请联系网站管理员！");
        }
    }

    /**
     * 查询告警列表
     * @param currentTime
     * @return
     */
    @GetMapping("/getWarnList")
    public AjaxObject getWarnList(String currentTime){
        logger.info("查询告警列表参数currentTime={}", currentTime);
        List<TbWarn> tbWarns = tbWarnService.findWarnList(currentTime);
        Map<String,Object> map = new HashMap<>(16);
        map.put("tbWarns",tbWarns);
        return AjaxObject.ok(map);
    }

    @GetMapping("/getAlarmList")
    public AjaxObject getAlarmList(String factoryNo){
        logger.info("查询告警列表参数currentTime={}", factoryNo);
        List<String> alarmList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>(16);
        map.put("list",alarmList);
        return AjaxObject.ok(map);
    }
}

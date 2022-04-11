package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbUserPosition;
import com.ejobim.opplat.service.TbUserPositionService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "位置管理")
@RestController
@RequestMapping("/position")
public class PositionController extends BaseController{

    @Value("${position_key}")
    private String position_key;

    @Autowired
    private TbUserPositionService tbUserPositionService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/saveUserPosition")
    public AjaxObject saveUserPosition(@RequestBody(required = false) TbUserPosition tbUserPosition){
        if(tbUserPosition!=null){
            Date currentTime = new Date();
            tbUserPosition.setCreateTime(currentTime);

            //将位置信息更新到redis中
            Map<String,Object> position = new HashMap<>();
            Map<String,Object> infoMap = new HashMap<>();
            infoMap.put("lng",tbUserPosition.getLng());
            infoMap.put("lat",tbUserPosition.getLat());
            infoMap.put("lasterTime",currentTime);
            position.put(tbUserPosition.getUserCode(), JSON.toJSONString(infoMap));
            stringRedisTemplate.opsForHash().putAll(position_key,position);
            //带工单的位置上报存库
            if(StringUtils.isNotBlank(tbUserPosition.getInspTaskCode())){
                if(tbUserPositionService.insert(tbUserPosition)>0){
                    return AjaxObject.ok();
                }
            }else{
                return AjaxObject.ok();
            }
        }
        return  AjaxObject.error();
    }

}

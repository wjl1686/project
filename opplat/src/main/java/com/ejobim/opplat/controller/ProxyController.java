package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.util.HttpClientUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
/**
 * @author wujianlong
 * @Description: 代理
 * @date 2019/1/15 18:16
 */
@Api(description = "代理")
@RestController
@RequestMapping("/proxy")
public class ProxyController extends BaseController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getCameraList")
    public String getCameraList(HttpServletRequest req){
            logger.info("获取视频接口参数QueryString={}",req.getQueryString());
            TbUser user = super.getUser(req,stringRedisTemplate);
            System.out.println(req.getQueryString());
            //49.4.31.127:8080
             //JSONObject json = HttpClientUtils.httpGet("http://114.116.55.214:8080/VFAIN-platform/securityapp/realtimemonitoring/getNearCameraList.do?" + req.getQueryString());
            /**
             * 获取摄像头列表
             */
           // public static String GET_CARMERALIST = "securityapp/video/getCamareByOrgID.do?";
            JSONObject json = HttpClientUtils.httpGet("http://49.4.31.127:8080/VFAIN-platform/securityapp/realtimemonitoring/getNearCameraList.do?" + req.getQueryString());
            if(json!=null){
                return json.toString();
            }
            return null;
           
    }
}

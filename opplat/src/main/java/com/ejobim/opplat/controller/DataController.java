package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbDraftData;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.HomeService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "数据接口")
@RestController
@RequestMapping("/data")
public class DataController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private HomeService homeService;
    /**
     * 查询数据底稿信息(截止今天前的数据)
     * @param request,tbDraftData
     * @return
     */
    @GetMapping("/getTbDraftData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页号", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "每页数量", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "draftName", value = "填报项名称", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = false, dataType = "string", paramType = "query")
    })
    public AjaxObject getTbDraftDataList(HttpServletRequest request, TbDraftData tbDraftData){
        logger.info("查询数据底稿信息列表参数TbDraftData={}", JSON.toJSONString(tbDraftData));
        TbUser user = super.getUser(request, stringRedisTemplate);
        super.setPageInfo(request.getParameter("page"), request.getParameter("rows"));
        List<TbDraftData> tbDraftDataList = homeService.getTbDraftDataList(tbDraftData);
        return super.getResultObject(tbDraftDataList,request.getParameter("page"));
    }
}

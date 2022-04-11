package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.AjaxObject;
import io.jsonwebtoken.lang.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
/**
 * @author wujianlong
 * @Description: 维保
 * @date 2019/1/15 18:16
 */
@Api(tags = "维保管理")
@RestController
@RequestMapping("/maintain")
public class MaintainController extends BaseController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private WorkOrderService workOrderService;
    private MaintainService maintainService;
    private EquipService equipService;

    private TbFactoryService tbFactoryService;
    private TbSysUseService useService;
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public MaintainController(WorkOrderService workOrderService, TbFactoryService tbFactoryService,
                                MaintainService maintainService,EquipService equipService,
                              StringRedisTemplate stringRedisTemplate,TbSysUseService useService){
        Assert.notNull(workOrderService, "workOrderService must not be null!");
        Assert.notNull(tbFactoryService, "tbFactoryService must not be null!");
        Assert.notNull(maintainService, "maintainService must not be null!");
        Assert.notNull(equipService, "equipService must not be null!");
        Assert.notNull(useService, "useService must not be null!");
        this.workOrderService = workOrderService;
        this.tbFactoryService = tbFactoryService;
        this.maintainService = maintainService;
        this.equipService = equipService;
        this.stringRedisTemplate  =stringRedisTemplate;
        this.useService  =useService;
    }



    @GetMapping("/equipTypelist")
    public AjaxObject getEquipTypeList(TbParam tbParam){
        super.setPageInfo(null,null);
        List<TbParam> list =  tbFactoryService.getParamList(tbParam);
        return super.getResultObject(list, null);

    }


    @RequestMapping("/getSparePartsList")
    @ApiOperation(value = "查询配件信息")
    public AjaxObject getSparePartsList(String  equipNo){
        logger.info("查询条件{}",equipNo);
        TbEquipInfo equipInfoQ = new TbEquipInfo();
        equipInfoQ.setEquipNo(equipNo);
        List<TbSpareParts> tbSparePartsList= equipService.selectSparePartsByEqNo(equipInfoQ);
        return super.getResultObject(tbSparePartsList, null);
    }


    @RequestMapping("/getFileList")
    public AjaxObject getFileList(HttpServletRequest request,TbEquipTaskFile overhaulTaskFile){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbEquipTaskFile> list =  maintainService.getFileList(overhaulTaskFile);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @PostMapping("/uploadAttachFile")
    public AjaxObject uploadAttachFile(TbEquipTaskFile overhaulTaskFile){
        if(maintainService.addTaskFile(overhaulTaskFile)>0) {
            return AjaxObject.ok("上传文件成功");
        }else{
            return AjaxObject.error("上传文件失败");
        }
    }
}

package com.ejobim.opplat.controller;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbSpareParts;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.EquipService;
import com.ejobim.opplat.service.SparePartsService;
import com.ejobim.opplat.util.AjaxObject;
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
 * @Description: 备品备件
 * @date 2019/1/15 18:16
 */
@Api(tags = "备品备件管理")
@RestController
@RequestMapping("/spareparts")
public class SparePartsController extends BaseController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SparePartsService sparePartsService;
    private EquipService equipService;

    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    public SparePartsController(SparePartsService sparePartsService,StringRedisTemplate stringRedisTemplate
                                ,EquipService equipService){
        this.sparePartsService = sparePartsService;
        this.equipService = equipService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @ApiOperation(value = "获取配件列表")
    @GetMapping("/getSparePartsList")
    public AjaxObject getSparePartsList(HttpServletRequest request, TbSpareParts spareParts){
        logger.info("获取工艺段列表{}",spareParts);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        String equipNo = request.getParameter("equipNo");
        if(StringUtils.isNotEmpty(equipNo)){
            TbEquipInfo equipInfo = equipService.getEquipInfo(equipNo);
            spareParts.setEquipType(equipInfo.getEquipNewType().toString());
        }

        List<TbSpareParts> list =  sparePartsService.getTbSparePartsList(spareParts,null);
        return super.getResultObject(list, request.getParameter("page"));
    }

    @ApiOperation(value = "新增修改配件")
    @PostMapping("/saveSpareParts")
    public AjaxObject saveSpareParts(HttpServletRequest request,TbSpareParts spareParts){
        TbUser user = super.getUser(request,stringRedisTemplate);
        spareParts.setCreaetUser(user.getName());
        if(sparePartsService.saveTbSpareParts(spareParts)>0){
            return AjaxObject.ok("修改成功");
        }else {
            return AjaxObject.error("修改失败");
        }
    }

    @ApiOperation(value = "删除配件")
    @PostMapping("/deleteSpareParts")
    public AjaxObject deleteSpareParts(TbSpareParts spareParts){
        if(sparePartsService.deleteTbSpareParts(spareParts)>0){
            return AjaxObject.ok("删除成功");
        }else {
            return AjaxObject.error("删除失败");
        }
    }

    /**
     * 根据 equipNO 查询备件列表信息
     * @param tbSpareParts
     * @return
     */
    @GetMapping("/getSparePartsLists")
    public AjaxObject getSparePartsLists(HttpServletRequest request, TbSpareParts tbSpareParts){
        String equipNo = request.getParameter("equipNo");
        if(StringUtils.isNotEmpty(equipNo)){
            TbEquipInfo equipInfo = equipService.getEquipInfo(equipNo);
            tbSpareParts.setEquipType(equipInfo.getEquipNewType().toString());
            tbSpareParts.setFactoryNo(equipInfo.getFactoryNo());
        }
        List<TbSpareParts> list = sparePartsService.getTbSparePartsList(tbSpareParts,null);
        return super.getResultObject(list, null);
    }

    @ApiOperation(value = "获取配件信息")
    @GetMapping("/getSparePartsListsAlone")
    public AjaxObject getSparePartsListsAlone(HttpServletRequest request, TbSpareParts tbSpareParts){
        String equipNo = request.getParameter("equipNo");
        if(StringUtils.isNotEmpty(equipNo)){
            TbEquipInfo equipInfo = equipService.getEquipInfo(equipNo);
            tbSpareParts.setEquipType(equipInfo.getEquipNewType().toString());
            tbSpareParts.setFactoryNo(equipInfo.getFactoryNo());
        }
        String factoryNo = request.getParameter("factoryNo");
        if(StringUtils.isNotEmpty(factoryNo)){
            tbSpareParts.setFactoryNo(factoryNo);
        }
        List<String> idList = null;
        String sparePartsNoList = request.getParameter("sparePartsNoList");
        if(StringUtils.isNotEmpty(sparePartsNoList)){
            idList = Arrays.asList(sparePartsNoList.split(","));
        }
        List<TbSpareParts> list = sparePartsService.getTbSparePartsList(tbSpareParts,idList);
        List<Map<String,String>> mapList = new ArrayList<>();
        for(TbSpareParts spareParts:list){
            Map<String,String> elementMap = new HashMap<>();
            elementMap.put("text",spareParts.getSparePartsName() + ",余量("+spareParts.getSparePartsCount()+")");
            elementMap.put("value",spareParts.getSparePartsNo() + "," + spareParts.getSparePartsName());
            mapList.add(elementMap);
        }
        return super.getResultObject(mapList, null);
    }


}

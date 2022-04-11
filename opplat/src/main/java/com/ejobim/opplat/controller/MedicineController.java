package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.annotation.Log;
import com.ejobim.opplat.domain.TbMedicine;
import com.ejobim.opplat.domain.TbMedicineDict;
import com.ejobim.opplat.domain.TbSynObject;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.TbMedicineService;
import com.ejobim.opplat.service.TbWarnService;
import com.ejobim.opplat.util.AjaxObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author wujianlong
 * @Description: 药剂信息
 * @date 2019/1/19 10:47
 */
@Api(tags = "药剂信息")
@RestController
@RequestMapping("/medicine")
public class MedicineController extends  BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbWarnService tbWarnService;
    @Autowired
    private TbMedicineService tbMedicineService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Map<String,Object> map = new HashMap<>();

    /**
     * 添加药剂
     * @param request
     * @return
     */
    @Log("添加药剂信息")
    @PostMapping("/addMedicine")
    @ApiOperation(value = "药剂配置")
    public AjaxObject addMedicine(HttpServletRequest request){

        String factoryNo = request.getParameter("factoryNo");
        String[] gongyiduans = request.getParameterValues("gongyiduan");
        //mdechineid
        String[] mdechineids = request.getParameterValues("mdechineid");
        //medchineCheck
        String[] medchineChecks = request.getParameterValues("medchineCheck");
        StringBuffer mid = new StringBuffer();
        StringBuffer uri = new StringBuffer();
        List<TbMedicine> medicineList = new ArrayList<>();
        for (int i = 0;i<medchineChecks.length;i++){
            int index = Integer.valueOf(medchineChecks[i]);
            uri.append(gongyiduans[index]);
            uri.append(",");
            mid.append(mdechineids[index]);
            mid.append(",");

        }
        String[] split = mid.toString().split(",");
        List<String> mIds = Arrays.asList(split);
        String[] split2 = uri.toString().split(",");
        List<String> uris = Arrays.asList(split2);
        TbMedicine tbMedicine = new TbMedicine();
        logger.info("新增药剂参数TbMedicine={}", JSON.toJSONString(tbMedicine));
        try {
            TbUser user = super.getUser(request,stringRedisTemplate);
            tbMedicineService.addMedicine(mIds,uris,factoryNo,user.getCode());
            return AjaxObject.ok("新增药剂成功");
        } catch (Exception e) {
            logger.error("新增药剂失败e={}", e);
            return AjaxObject.error("新增药剂失败，请联系网站管理员！");
        }
    }
    /**
     * 删除药剂
     * @param medicineNos
     * @return
     */
    @PostMapping("/deleteMedicine")
    @ApiOperation(value = "删除配置的药剂")
    public AjaxObject deleteWarn(String[] medicineNos) {
        logger.info("删除药剂参数medicineNo{}", medicineNos);
        try {
            tbMedicineService.deleteWarn(medicineNos);
            return AjaxObject.ok("删除药剂成功！");
        } catch (Exception e) {
            logger.error("删除药剂失败", e);
            return AjaxObject.error("删除药剂失败，请联系网站管理员！");
        }
    }


    /**
     * 查询药剂列表
     * @param req,tbMedicine
     * @return
     */
    @GetMapping("/getMedicineList")
    @ApiOperation(value = "获取药剂配置信息")
    public AjaxObject getMedicineList(HttpServletRequest req,TbMedicine tbMedicine){
        logger.info("查询药剂列表参数TbMedicine={}", tbMedicine);
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbMedicine> tbMedicineList = tbMedicineService.findMedicineList(tbMedicine);
        return super.getResultObject(tbMedicineList,req.getParameter("page"));
    }

    /**
     * 查询药剂字典列表
     * @param tbMedicine
     * @return
             */
    @GetMapping("/getMedicineDictList")
    @ApiOperation(value = "获取药剂类型字典")
    public AjaxObject getMedicineDictList(TbMedicineDict tbMedicine){
        logger.info("查询药剂字典列表参数TbMedicine={}", tbMedicine);
        List<TbMedicineDict> tbMedicineList = tbMedicineService.findMedicineDictList(tbMedicine);
        PageInfo pageInfo = new PageInfo(tbMedicineList);
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return AjaxObject.ok(map);
    }

    /**
     * 查询工艺列表
     * @param
     * @return
     */
    @GetMapping("/getSynObjectList")
    public AjaxObject getSynObjectList( HttpServletRequest request){

        String factoryNo = request.getParameter("factoryNo");
        List<TbSynObject> tbMedicineList = tbMedicineService.findSynObjectList(factoryNo);
        PageInfo pageInfo = new PageInfo(tbMedicineList);
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return AjaxObject.ok(map);
    }
}

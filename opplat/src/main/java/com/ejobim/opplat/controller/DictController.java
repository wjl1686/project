package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.common.annotation.Log;
import com.ejobim.opplat.domain.TbDict;
import com.ejobim.opplat.service.TbDictService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujianlong
 * @Description: 字典表管理
 * @date 2019/3/11 10:16
 */
@Api(tags = "字典表管理")
@RestController
@RequestMapping("/dict")
public class DictController extends  BaseController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbDictService tbDictService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    Map<String,Object> map = new HashMap<>();
    /**
     * 添加字典
     * @param tbDict
     * @return
     */
    @Log("添加字典信息")
    @ApiOperation(value = "新增配置字典项")
    @PostMapping("/addDict")
    public AjaxObject addDict(HttpServletRequest request,TbDict tbDict){
        logger.info("新增字典参数TbDict={}", JSON.toJSONString(tbDict));
        int resultCode = 0;
            if(tbDict.getId()==null) {
                tbDict.setCreateUser(getUser(request,stringRedisTemplate).getCode());
                resultCode = tbDictService.addDict(tbDict);
            }else{
                resultCode = tbDictService.updateDict(tbDict);
            }
            return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));

    }

    /**
     * 查询字典列表
     * @param request,tbDict
     * @return
     */
    @GetMapping("/getDictList")
    @ApiOperation(value = "获取配置字典列表")
    public AjaxObject  getDictList(HttpServletRequest request,TbDict tbDict){
        logger.info("查询字典列表参数tbDict={}", JSON.toJSONString(tbDict));
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbDict> tbDicts = tbDictService.findTbDictList(tbDict);
        return super.getResultObject(tbDicts, request.getParameter("page"));

    }

    @GetMapping("/getDictByParent")
    @ApiOperation(value = "通过配置大类获取子项配置")
    public Map<Integer,List<TbDict>> getDictByParent(String ids){
        List<Integer> idList = new ArrayList<>();
        for(String id:ids.split(",")){
            idList.add(Integer.valueOf(id));
        }
        List<TbDict> tbDicts = tbDictService.getDictByParent(idList);
        Map<Integer,List<TbDict>> resultMap = new HashMap<>(16);
        for(TbDict dict:tbDicts){
            if(resultMap.containsKey(dict.getParentId())){
                resultMap.get(dict.getParentId()).add(dict);
            }else{
                List<TbDict> list = new ArrayList<>();
                list.add(dict);
                resultMap.put(dict.getParentId(),list);
            }
        }
        return resultMap;
    }

    /**
     * 删除字典
     * @param ids
     * @return
     */
    @PostMapping("/deleteDict")
    @ApiOperation(value = "删除字典配置项")
    public AjaxObject deleteMenus(String[] ids) {
        logger.info("删除字典参数id={}", ids.toString());
        try {
            int i = this.tbDictService.deleteDicts(ids);
            if(i>0){
                return AjaxObject.ok("删除成功！");
            }else{
                return AjaxObject.error("删除失败！");
            }
        } catch (Exception e) {
            return AjaxObject.error("删除失败，请联系网站管理员！");
        }
    }
}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.annotation.AutoIdempotent;
import com.ejobim.opplat.domain.Capability;
import com.ejobim.opplat.domain.CapabilityExample;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.User;
import com.ejobim.opplat.mapper.CapabilityMapper;
import com.ejobim.opplat.mapper.TbUserMapper;
import com.ejobim.opplat.service.TokenService;
import com.ejobim.opplat.service.UserService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.ExcelHighNewUtils;
import com.ejobim.opplat.util.StringTools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author wujianlong
 * @Description: 用户相关
 * @date 2019/1/15 18:16
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService tbSysUseService;

    @Autowired
    CapabilityMapper capabilityMapper;

    @Autowired
    private TbUserMapper tbUserMapper;


    @GetMapping("/getUserList")
    public List<User> getTbUserList(HttpServletRequest req) {
        List<User> lists= tbSysUseService.getTbUserLists();
        return lists;
    }
    @GetMapping("/testSave")
    public String getTbUserList() {
         int  i =tbSysUseService.save();
        return "ok";
    }

    /**
     * 查询角色列表
     * @param req
     * @param tbSysRole
     * @return
     */
    @GetMapping("/getRoleList")
    @ApiOperation(value = "获取角色列表")
    public AjaxObject getRoleList(HttpServletRequest req, User tbSysRole){
        logger.info("查询角色列表参数menu={}", JSON.toJSONString(tbSysRole));
        int pageNum = 1;
        int pageSize = 1000;
        if(StringUtils.isNotBlank( req.getParameter("page"))){
            pageNum =Integer.valueOf(req.getParameter("page"));
            pageSize =Integer.valueOf(req.getParameter("rows"));
        }
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = tbSysUseService.getTbUserLists();
        PageInfo pageInfo = new PageInfo(sysMenus);
        Map<String,Object> map = new HashMap<>(16);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return AjaxObject.ok(map);
    }

    @RequestMapping(value = "/downloadModel",method = RequestMethod.GET)
    public void downloadModel(HttpServletRequest request, HttpServletResponse response){
        List<Capability> tbEquipInfoList =getCapabilityLists();
     /*   if(factoryNo==null){
            return;
        }else{
            TbEquipInfoVo tbEquipInfoVo = new TbEquipInfoVo();
            tbEquipInfoList =equipService.getEquipList(tbEquipInfoVo);
        }*/
        //巡检要素 1  维保要素2
        int type =2;
        logger.info("下载能力项模板");
        ExcelHighNewUtils.writeExcelLink(response,tbEquipInfoList);
    }

    public List<Capability> getCapabilityLists() {
        CapabilityExample example = new CapabilityExample();
        CapabilityExample.Criteria criteria = example.createCriteria();
        List<Capability> list = capabilityMapper.selectByExample(example);
        return list;
    }

    @Resource
    private TokenService tokenService;

    /**
     * 幂等性获取token
     * @param
     * @return
     */
    @PostMapping("/get/token")
    public String  getToken(){
        String token = tokenService.createToken();
        if (StringUtils.isNotEmpty(token)) {
            AjaxObject resultVo = new AjaxObject();
            resultVo.data(token);
            return JSON.toJSONString(resultVo);
        }
        return null;
    }

    /**
     * 幂等性校验数据
     * @param
     * @return
     */
    @AutoIdempotent
    @PostMapping("/test/Idempotence")
    public AjaxObject testIdempotence() {
        Map map = new HashMap();
        List<String> lists= new ArrayList<>();
        lists.add("1");
        lists.add("2");
        if (!CollectionUtils.isEmpty(lists)) {
            map.put("data",lists);
            return AjaxObject.ok(map);
        }
       return AjaxObject.ok(map);
    }
    /**
     * redission 测试原子锁
     * @param
     * @return
     */
    @GetMapping("/testRe")
    public String testRe() {
        TbUser record = new TbUser();
        record.setCode(StringTools.getUUID());
        record.setCreateTime(new Date());
        record.setCreator("历史dada");
        record.setName("历史dada");
        tbUserMapper.insertSelective(record);
       //tbSysUseService.testLock();
        return "ok";
    }

}

package com.ejobim.opplat.controller;

import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.Tree;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @author wujianlong
 * @Description: 系统设置
 * @date 2019/1/15 18:16
 */
@Api(tags = "系统设置")
@RestController
@RequestMapping("/sys")
public class SysController  extends  BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbSysUseService tbSysUseService;
    @Autowired
    TbSysRoleService tbSysRoleService;
    @Autowired
    TDictService tDictService;

    @Autowired
    private SysService sysService;

    @Autowired
    private ParameterConfigService parameterConfigService;



    /**
     * 查询菜单列表
     * @param dict 类型 0菜单 1按钮
     * @return
     */
    @ApiOperation(value = "查询菜单列表")
    @GetMapping("/getMenuList")
    public AjaxObject getMenuList(HttpServletRequest req, TDict dict){
        logger.info("查询菜单列表参数menu={}", JSON.toJSONString(dict));
        int pageNum =Integer.valueOf(req.getParameter("page"));
        int pageSize =Integer.valueOf(req.getParameter("rows"));
        PageHelper.startPage(pageNum, pageSize);
        List<TDict> tDictList = tDictService.findTDictList(dict);
        PageInfo pageInfo = new PageInfo(tDictList);
        Map<String,Object> map = new HashMap<>(16);
        map.put("rows", pageInfo.getList());
        //存放每页记录数
        map.put("total", pageInfo.getTotal());
        //存放总记录数 ，必须的
        return AjaxObject.ok(map);
    }

    /**
     * 获取组织机构分类树结构
     * @param req ,uri
     * @return
     */
    @ApiOperation(value = "查询组织机构树")
    @RequestMapping(value = "/getTbOrgAllTree",method = RequestMethod.GET)
    public AjaxObject getFillFormAllTree(HttpServletRequest req,String uri){
        logger.info("查询参数uri={}",uri);
        Tree<TbOrg> tree=  sysService.getTbOrgAllTree();
        Map map = new HashMap(16);
        map.put("tree",tree);
        return AjaxObject.ok(map);
    }



    /**
     * 通过组织tree 获取用户列表
     * @param request
     * @return
     */
    @ApiOperation(value = "查询用户列表")
    @RequestMapping(value = "/getTbUserList",method = RequestMethod.GET)
    public AjaxObject getTbUserList(HttpServletRequest request){
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        String orgcode = request.getParameter("uri");
        String name= request.getParameter("name");
        List<String> orgCodeList = null;
        if(StringUtils.isNotEmpty(orgcode)){
            orgCodeList=new ArrayList<>();
            orgCodeList.add(orgcode);
        }
        logger.info("pc通过组织tree 获取用户列表orgCodeList={},name={}",JSON.toJSONString(orgCodeList),name);
        List<TbUser> tbUserRoleList = sysService.getTbUserListS(orgCodeList,name);
        Map<String, List<TbUser>> collect = tbUserRoleList.stream().collect(Collectors.groupingBy(TbUser::getCode));
    /*    List<TbUser> userList = new ArrayList<>();
        Map<String, Object> userMap = new HashMap<>();
        for (TbUser tbUser : tbUserRoleList) {
            if (userMap.get(tbUser.getCode()) != null) {
                TbUser tempUser = new TbUser();
                tempUser = (TbUser) userMap.get(tbUser.getCode());
                tempUser.setRoleName(tempUser.getRoleName() + "," + tbUser.getRoleName());
                userMap.put(tbUser.getCode(), tempUser);
            } else {
                userMap.put(tbUser.getCode(), tbUser);
            }
        }
        for (String key : userMap.keySet()) {
            userList.add((TbUser) userMap.get(key));
        }*/
        return super.getResultObject(tbUserRoleList, request.getParameter("page"));
    }

    /**
     * 获取角色列表
     * @param req
     * @return
     */
    @ApiOperation(value = "查询角色列表")
    @RequestMapping(value = "/getRoleList",method = RequestMethod.GET)
    public AjaxObject getRoleList(HttpServletRequest req,TbRole tbRole){
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbRole> tbUserList = sysService.getRoleList(tbRole);
        return super.getResultObject(tbUserList,req.getParameter("page"));
    }

    /**
     * 获取通用填报字段
     * @param req
     * @return
     */
    @ApiOperation(value = "查询填报指标列表")
    @RequestMapping(value = "/getfillFieldList",method = RequestMethod.GET)
    public AjaxObject getfillFieldList(HttpServletRequest req,TbParameterConfig parameterConfig){
        super.setPageInfo(req.getParameter("page"),req.getParameter("rows"));
        List<TbParameterConfig> list = parameterConfigService.selectParameterConfigList(parameterConfig);
        return super.getResultObject(list,req.getParameter("page"));
    }

    @ApiOperation(value = "新增修改填报指标")
    @RequestMapping(value = "/savefillField",method = RequestMethod.POST)
    public AjaxObject savefillField(HttpServletRequest req,TbParameterConfig parameterConfig){
        int returnCode=  parameterConfigService.saveTbParameterConfig(parameterConfig);
        if(returnCode>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }

    }

    @ApiOperation(value = "删除填报指标")
    @RequestMapping(value = "/deletefillField",method = RequestMethod.POST)
    public AjaxObject deletefillField(HttpServletRequest req,String paramNo){
        int returnCode=  parameterConfigService.deleteTbParameterConfig(paramNo);
        if(returnCode>0){
            return AjaxObject.ok();
        }else{
            return AjaxObject.error();
        }

    }

}

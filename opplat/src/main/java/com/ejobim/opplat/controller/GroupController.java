package com.ejobim.opplat.controller;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.OrgGroupInfo;
import com.ejobim.opplat.domain.TbGroupInfo;
import com.ejobim.opplat.service.GroupService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author  xibian
 */
@Api(tags = "组团管理接口")
@RestController
@RequestMapping("/group")
public class GroupController extends  BaseController{

    @Autowired
    GroupService groupService;

    /**
     * 获取组团列表
     * @return
     */
    @ApiOperation(value = "获取配置的组团列表")
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public AjaxObject getGroupList( OrgGroupInfo orgGroupInfo){
        super.setPageInfo(null,null);
        List<OrgGroupInfo> list =  groupService.getGroupList(orgGroupInfo);
        return super.getResultObject(list, null);
    }

    /**
     * 修改组团信息
     * @param orgGroupInfo
     * @return
     */
    @ApiOperation(value = "新增编辑组团信息")
    @RequestMapping(value="/saveGroup",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "orgGroupInfo", value = "组团信息", required = true, dataType = "OrgGroupInfo", paramType = "query")
    })
    public AjaxObject saveGroup(OrgGroupInfo orgGroupInfo){
        int  resultCode =  groupService.updateGroup(orgGroupInfo);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }

    /**
     * 修改组团详情
     * @param id
     * @param factoryNo
     * @param updateType
     * @return
     */
    @ApiOperation(value = "修改组团详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "组团id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "factoryNo", value = "水厂no", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "updateType", value = "更新方式1:新增;2:移除;3:设置中心水厂", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value="/saveGroupDetail",method = RequestMethod.POST)
    public AjaxObject saveGroupDetail(Integer id,String factoryNo,Integer updateType){
        int  resultCode =  groupService.updateGroupDetail(id,factoryNo,updateType);
        return AjaxObject.getAjaxStatus(Dict.getAjaxStatus(resultCode));
    }
}

package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.exception.RestException;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.mapper.TbOrgMapper;
import com.ejobim.opplat.mapper.TbRoleMapper;
import com.ejobim.opplat.notify.NoticeService;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.ImageUtil;
import com.ejobim.opplat.util.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author wujianlong
 * @Description: 登录接口
 * @date 2019/1/17 14:06
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${loginUrl}")
    private String loginUrl;
    @Value("${notify.token.expireSeconds}")
    private Integer expireSeconds;
    @Autowired
    private TbSysUseService tbSysUseService;
    @Autowired
    private TbSysRoleService tbSysRoleService;
    @Autowired
    private BewgService bewgService;
    @Autowired
    private TbFactoryService factoryService;
    @Autowired
    TbSysMenuService menuService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    TbFactoryInfoMapper tbFactoryInfoMapper;
    @Autowired
    TbOrgMapper tbOrgMapper;
    @Autowired
    SchedulingService schedulingService;
    
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TbRoleMapper roleMapper;


    private static String URL = "http://console.bewgcloud.net.cn/#/?client=app_yunjianbiao";
    /**
     * app登录
     * @param
     * @return
     */
    @GetMapping("/app")
    public void userLogin(HttpServletResponse response) throws RestException {
        try {
            response.sendRedirect(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws RestException
     */
    @PostMapping("/appLogin")
    @ApiOperation(value = "APP登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username ", value = "用户名/手机号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password ", value = "密码", required = true, dataType = "string", paramType = "query")
    })
    public AjaxObject appLogin(HttpServletRequest request,String username,String password) throws RestException {
        logger.info("app登录接口参数username={},参数password={}", username,password );
        JSONObject loginJson = bewgService.loginHollySys(username,password);
        if(loginJson!=null) {
            if (loginJson.getBoolean("success")) {
                String accessToken = loginJson.getJSONObject("obj").getString("access_token");
                JSONObject userInfo = loginJson.getJSONObject("obj").getJSONObject("current_user");
                JSONArray orgList = userInfo.getJSONArray("orgCode");
                List<Map<String, Object>> factoryList = new ArrayList<>();
                List<String> orgCodeList = new ArrayList<>();
                List<String> factoryCodeList = new ArrayList<>();
                for (int i = 0; i < orgList.size(); i++) {
                    if (orgList.getJSONObject(i).getIntValue("orgType") == 5) {
                        factoryCodeList.add(orgList.getJSONObject(i).getString("value"));
                    } else {
                        orgCodeList.add(orgList.getJSONObject(i).getString("value"));
                    }
                }
                if (orgCodeList.size() > 0) {
                    factoryList.addAll(tbSysUseService.getUserFactoryList(orgCodeList, 2));
                }
                if (factoryCodeList.size() > 0) {
                    factoryList.addAll(tbSysUseService.getUserFactoryList(factoryCodeList, 1));
                }
                JSONObject json = bewgService.getUserInfoByToken(accessToken);
                stringRedisTemplate.opsForValue().set(accessToken, json.getJSONObject("obj").toString(), 2, TimeUnit.DAYS);
                //保存TOKEN用户信息
                JSONObject userOrgTree = bewgService.getUserOrgByToken(accessToken);
                JSONArray obj = userOrgTree.getJSONArray("obj");
                remmvoFactory(obj);
                stringRedisTemplate.opsForValue().set(accessToken + "_tree", userOrgTree.getJSONArray("obj").toString(), 2, TimeUnit.DAYS);
                //保存TOKEN用户信息
                Map<String, Object> map = new HashMap<>(16);
                map.put("userInfo", json.getJSONObject("obj"));
                map.put("factoryList", factoryList);
                map.put("userOrgTree", obj);
                map.put("token", accessToken);
                //调用绑定消息
                try {
                    System.out.println(JSON.toJSON(userInfo));
                    NoticeService.BindParams params = new  NoticeService.BindParams();
                    params.expireSeconds=(expireSeconds);
                    params.token=accessToken;
                    params.target=(String)userInfo.get("code");
                   // logger.info("app绑定通知Params={}",JSON.toJSONString(params) );
                    noticeService.bindToken(params);
                    logger.info("app绑定成功用户userName={}", userInfo.get("realname"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return AjaxObject.ok(map);
            } else {
                return AjaxObject.error(loginJson.getString("msg"));
            }
        }
        return AjaxObject.error("服务出错");
    }
    @GetMapping(value = "/loginCode")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil(120, 40, 5,30);
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
        return null;
    }
    


    @RequestMapping(value = "/setSession",method = RequestMethod.GET)
    public AjaxObject setSession(HttpServletRequest request,HttpServletResponse response){
        request.getSession().setAttribute("userId","12345");
        return AjaxObject.ok();
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public AjaxObject getSession(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request.getSession().getAttribute("userId"));
        return AjaxObject.ok(request.getSession().getAttribute("userId").toString());
    }


    /**
     *  退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    @ApiOperation(value = "注销登录")
    public AjaxObject loginOut(HttpServletRequest request,HttpServletResponse response){
        String token = request.getHeader("token");
        //防止二次注销出错
        if(stringRedisTemplate.opsForValue().get(token)!=null){
            JSONObject json =  bewgService.logOut(request.getHeader("token"));
            logger.info("退出登录结果josn={}",json);
            //退出登录结果josn={"msg":"已退出当前登录","success":true}
            stringRedisTemplate.delete(token);
            NoticeService.UnbindParams params = new  NoticeService.UnbindParams();
            params.token=token;
            try {
                noticeService.unbindToken(params);
                logger.info("解绑用户成功token={}", token);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return AjaxObject.ok();
        }else{
            return AjaxObject.ok();
        }


        
    }

    @RequestMapping(value = "/tokenError",method = RequestMethod.GET)
    public AjaxObject tokenError(HttpServletRequest request,HttpServletResponse response){
        return AjaxObject.error(40,"错误的TOKEN");
    }

    /**
     * 获取用户信息
     * @param req
     * @return
     */
    @GetMapping("/getTbUserInfoUn")
    @ApiOperation(value = "获取用户信息")
    public AjaxObject getTbUserInfoUn(HttpServletRequest req) {
        String token = req.getHeader("token");
        JSONObject userJson =  bewgService.getUserInfoByToken(token);
        if(userJson.containsKey("success")&&userJson.getBoolean("success")){
            //获取成功
            JSONObject userInfo = userJson.getJSONObject("obj");
            stringRedisTemplate.opsForValue().set(token,userInfo.toString(),2, TimeUnit.DAYS);
            System.out.println(userInfo);
            Map<String,Object> map =  new HashMap<>(3);
            JSONObject userOrgTree = bewgService.getUserOrgByToken(token);
            JSONArray obj = userOrgTree.getJSONArray("obj");
            map.put("userInfo",userJson.getJSONObject("obj"));
            map.put("userOrgTree",userOrgTree.getJSONArray("obj"));
            bindNotice(token,userInfo);
            return AjaxObject.ok(map);
        }else{
            return AjaxObject.error(Dict.AjaxStatus.NOLOGIN.getStatusCode(),Dict.AjaxStatus.NOLOGIN.getStatusName());
        }
    }

    @Async
    private void bindNotice(String token,JSONObject userInfo){
        NoticeService.BindParams params = new  NoticeService.BindParams();
        params.expireSeconds=(expireSeconds);
        params.token=token;
        params.target=userInfo.getString("code");
        //logger.info("app绑定通知Params={}",JSON.toJSONString(params) );
        try {
            noticeService.bindToken(params);
            logger.info("app绑定成功用户userName={}", userInfo.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取用户菜单权限
     * @param req
     * @return
     */
    @GetMapping("/getMenuList")
    @ApiOperation(value = "获取用户菜单权限")
    public AjaxObject getMenuList(HttpServletRequest req) {
        String factoryCode = req.getParameter("factoryCode");
        String token = req.getHeader("token");
        String info = stringRedisTemplate.opsForValue().get(token);
        JSONObject userJson = JSONObject.parseObject(info);
        JSONArray orgCodeList = userJson.getJSONArray("orgCodeList");
        List<String> roleList = new ArrayList<>();
        for(int n=0;n<orgCodeList.size();n++){
            if(orgCodeList.getJSONObject(n).getString("orgType").equals(5)){
                if(orgCodeList.getJSONObject(n).getString("value").equals(factoryCode)){
                    JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                    for(int i=0;i<roleArray.size();i++){
                        roleList.add(roleArray.getString(i));
                    }
                }
            }else{
                JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                for(int i=0;i<roleArray.size();i++){
                    roleList.add(roleArray.getString(i));
                }
            }

        }
        TbSysMenu sysMenu  = new TbSysMenu();
        sysMenu.setRoleList(roleList);
        List<TbSysMenu> list = menuService.findNewMenuList(sysMenu);
        List<TbSysMenu> sysMenuList = TreeUtils.getMenuList(list);
        List<TbRole> roles = getRoleList(roleList);
        Map<String,Object> map = new HashMap<>(1);
        boolean isGroup = checkIsGroupRole(roles);
        if(isGroup){
            if(sysMenuList.get(0).getChildren()!=null && sysMenuList.get(0).getChildren().size()>0) {
                TbSysMenu menu = sysMenuList.get(0).getChildren().get(0);
                menu.setMenuName("组团首页");
                menu.setUrl("home/groupHome");
            }else{
                if(sysMenuList.get(0).getChildren()==null){
                    sysMenuList.get(0).setChildren(new ArrayList<>());
                }
                sysMenuList.get(0).getChildren().add(getSysMenu("组团首页","home/groupHome"));
            }
            sysMenuList.get(0).getChildren().add(getSysMenu("质量指标","user/group_quality"));
            sysMenuList.get(0).getChildren().add(getSysMenu("成本指标","user/group_cost"));
            sysMenuList.get(0).getChildren().add(getSysMenu("产量指标","user/group_production"));
            sysMenuList.get(0).getChildren().add(getSysMenu("设备指标","user/group_equip"));
        }else{
            if(sysMenuList.get(0).getChildren()!=null && sysMenuList.get(0).getChildren().size()>0) {
                TbSysMenu menu = sysMenuList.get(0).getChildren().get(0);
                menu.setMenuName("决策中心");
                menu.setUrl("user/data");
            }else{
                if(sysMenuList.get(0).getChildren()==null){
                    sysMenuList.get(0).setChildren(new ArrayList<>());
                }
                sysMenuList.get(0).getChildren().add(getSysMenu("决策中心","user/data"));
            }
        }
        map.put("menuList",sysMenuList);
        return AjaxObject.ok(map);
    }

    @GetMapping("/getTbUserInfo")
    @ApiOperation(value = "获取用户信息")
    public AjaxObject getTbUserList(HttpServletRequest req) {
        String token = req.getHeader("token");
        String factoryCode = req.getParameter("factoryCode");
        JSONObject userJson =  bewgService.getUserInfoByToken(token);
        if(userJson.containsKey("success")&&userJson.getBoolean("success")){
            //获取成功
            JSONObject userInfo = userJson.getJSONObject("obj");
            stringRedisTemplate.opsForValue().set(token,userInfo.toString(),2, TimeUnit.DAYS);
            TbSysMenu sysMenu  = new TbSysMenu();
            List<String> roleList = new ArrayList<>();
            JSONArray orgCodeList = userInfo.getJSONArray("orgCodeList");
            String selectFactoryCode = "";
            if(StringUtils.isNotEmpty(factoryCode)){
                boolean isOwnFactory = false;
                for(int n=0;n<orgCodeList.size();n++){
                    if(orgCodeList.getJSONObject(n).getString("orgType").equals(5)){
                        if(orgCodeList.getJSONObject(n).getString("value").equals(factoryCode)){
                            selectFactoryCode = factoryCode;
                            JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                            for(int i=0;i<roleArray.size();i++){
                                roleList.add(roleArray.getString(i));
                            }
                            isOwnFactory = true;
                        }
                    }else{
                        JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                        for(int i=0;i<roleArray.size();i++){
                            roleList.add(roleArray.getString(i));
                        }
                    }

                }
                if(roleList.size()==0){
                    if(!isOwnFactory){
                        selectFactoryCode = getFirstFactory(roleList, orgCodeList);
                    }
                }


            }else{
                selectFactoryCode = getFirstFactory(roleList, orgCodeList);
                for(int n=0;n<orgCodeList.size();n++) {
                    if (!orgCodeList.getJSONObject(n).getString("orgType").equals(5)) {
                        JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                        for (int i = 0; i < roleArray.size(); i++) {
                            roleList.add(roleArray.getString(i));
                        }
                    }
                }
            }
            Map<String,Object> map =  new HashMap<>(16);
            JSONObject userOrgTree = bewgService.getUserOrgByToken(token);
            JSONArray obj = userOrgTree.getJSONArray("obj");
            map.put("userInfo",userJson.getJSONObject("obj"));
            map.put("userOrgTree",userOrgTree.getJSONArray("obj"));
            if(roleList.size()>0){
                sysMenu.setRoleList(roleList);
                List<TbSysMenu> list = menuService.findNewMenuList(sysMenu);
                List<TbSysMenu> sysMenuList = TreeUtils.getMenuList(list);

                remmvoFactory(obj);
                map.put("selectFactoryCode",selectFactoryCode);


            }else{
                map.put("menuList",new ArrayList<String>());
            }

            return AjaxObject.ok(map);
        }else{
            return AjaxObject.error(Dict.AjaxStatus.NOLOGIN.getStatusCode(),Dict.AjaxStatus.NOLOGIN.getStatusName());
        }
    }

    private TbSysMenu getSysMenu(String title,String url){
        TbSysMenu sysMenu = new TbSysMenu();
        sysMenu.setMenuName(title);
        sysMenu.setParentId("ac42d640be504711b4a4bc8ab0b7a926");
        sysMenu.setUrl(url);
        sysMenu.setSort(1);
        sysMenu.setType(0);
        return sysMenu;
    }

    private boolean checkIsGroupRole(List<TbRole> roles){
        for(TbRole role:roles){
            if(role.getName().startsWith("组团")){
                return true;
            }
        }
        return false;
    }

    private List<TbRole> getRoleList(List<String> codeList){
        TbRoleExample roleExample = new TbRoleExample();
        roleExample.createCriteria().andCodeIn(codeList);
        return roleMapper.selectByExample(roleExample);
    }

    private String getFirstFactory(List<String> roleList, JSONArray orgCodeList) {
        for(int n=0;n<orgCodeList.size();n++){
            if(orgCodeList.getJSONObject(n).getIntValue("orgType") == 5){
                JSONArray roleArray = orgCodeList.getJSONObject(n).getJSONArray("roleList");
                for(int i=0;i<roleArray.size();i++){
                    roleList.add(roleArray.getString(i));
                }
                return orgCodeList.getJSONObject(n).getString("value");
            }
        }
        return null;
    }


    public void remmvoFactory( JSONArray obj){
        List<TbFactoryInfo> factoryInfoList = tbFactoryInfoMapper.selectByExample(new TbFactoryInfoExample());
        List<String> factoryUriList  =  factoryInfoList.stream().map(TbFactoryInfo::getUri).collect(Collectors.toList());
        for(int i=0;i<obj.size();i++){
            for(int n=0;n<obj.getJSONObject(i).getJSONArray("childrenList").size();n++){
                JSONArray childrenList = obj.getJSONObject(i).getJSONArray("childrenList");
                clearNullLeaf(childrenList,factoryUriList);
//                for(int t=0;t<childrenList.size();t++) {
//                    JSONArray childrenList1 = childrenList.getJSONObject(t).getJSONArray("childrenList");
//                    for(int h=0;h<childrenList1.size();h++) {
//                        JSONArray childrenList2 = childrenList1.getJSONObject(h).getJSONArray("childrenList");
//                        for(int m=childrenList2.size()-1;m>=0;m-- ){
//                            JSONObject jsonObject = childrenList2.getJSONObject(m);
//                            String name = jsonObject.getString("name");
//                            TbFactoryInfo tbOrg  = tbFactoryInfoMapper.selectTbFactoryInfoByName(name);
//                            if(tbOrg==null){
//                                childrenList2.remove(m);
//                                logger.info("移除没有实例化的水厂name={}", name );
//                            }
//                        }
//                    }
//                }
            }
        }
    }

    private void clearNullLeaf(JSONArray array,List<String> factoryList){
        for(int i=array.size() - 1; i>=0;i--){
            JSONObject orgObj = array.getJSONObject(i);
            if(orgObj.getIntValue("type")!=5){
                JSONArray children = orgObj.getJSONArray("childrenList");
                clearNullLeaf(children,factoryList);
                if(children.size()==0){
                    array.remove(i);
                }
            }else{
               if(!factoryList.contains(orgObj.getString("uri"))){
                   array.remove(i);
               }
            }
        }
    }

    public void getdatett(JSONArray obj,Map map) {
        JSONArray jsonArray = obj;
        for (int i = 0; i < obj.size(); i++) {
            JSONArray childrenList = obj.getJSONObject(i).getJSONArray("childrenList");
            for (int j = 0; j < childrenList.size(); j++) {
                JSONObject jsonObject = JSON.parseObject(childrenList.get(j).toString());
                if(!(Integer.valueOf(jsonObject.get("type").toString())==5)){
                    getdatett(childrenList,map);
                }else{
                    if(!map.containsKey(jsonObject.get("code"))){
                        childrenList.remove(j);
                    }
                }
            }
        }
    }
    
}

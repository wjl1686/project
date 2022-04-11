package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.UploadFileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author wujianlong
 * @Description: 基础controller
 * @date 2019/1/15 18:16
 */
@Api(description = "基础controller")
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TbUser getUser(HttpServletRequest request, StringRedisTemplate stringRedisTemplate){

        TbUser tbUser = null;
        String token = request.getHeader("token");
        logger.info("获取用户token={}",token);
        if(token!=null){
            tbUser = new TbUser();
            String info = stringRedisTemplate.opsForValue().get(token);
            if(StringUtils.isNotEmpty(info)) {
                JSONObject userJson = JSONObject.parseObject(info);
                tbUser.setCode(userJson.getString("code"));
                tbUser.setName(userJson.getString("name"));
                tbUser.setOrgRoleList(userJson.getJSONArray("orgCodeList"));
            }else {
                return new TbUser();
            }
        }
        logger.info("当前登录用户信息TbUser={}", JSON.toJSONString(tbUser));
        return tbUser;
    }

    public JSONObject getUserInfo(HttpServletRequest request, StringRedisTemplate stringRedisTemplate){
        String token = request.getHeader("token");
        if(token!=null){
            String info = stringRedisTemplate.opsForValue().get(token);
            if(StringUtils.isNotEmpty(info)) {
                JSONObject userJson = JSONObject.parseObject(info);
                return userJson;
            }
            return null;
        }else{
            return null;
        }

    }

    public JSONObject getUserOrgTree(HttpServletRequest request, StringRedisTemplate stringRedisTemplate){
        String token = request.getHeader("token");
        if(token!=null){
            String treeKey = token + "_tree";
            String info = stringRedisTemplate.opsForValue().get(treeKey);
            if(StringUtils.isNotEmpty(info)) {
                JSONObject userTreeJson = JSONObject.parseObject(info);
                return userTreeJson;
            }
            return null;
        }else{
            return null;
        }
    }

    public void  getQueryParams(HttpServletRequest request,String key,Map<String,String> queryParams){
        if(StringUtils.isNotEmpty(request.getParameter(key))){
            queryParams.put(key,request.getParameter(key).toString());
        }
    }


    public JSONObject getJsonParam(HttpServletRequest request){
        String param= null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }

            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPageInfo(String pageNum, String pageSize) {
        if (StringUtils.isNotEmpty(pageNum)) {
            int pageNumValue = Integer.valueOf(pageNum);
            int pageSizeValue = Integer.valueOf(pageSize);
            PageHelper.startPage(pageNumValue, pageSizeValue);
        }
    }

    public AjaxObject getResultObject(List list, String pageNum){
        Map<String,Object> resultMap = new HashMap<>(16);
        if (StringUtils.isNotEmpty(pageNum)) {
            PageInfo pageInfo = new PageInfo(list);
            resultMap.put("rows",pageInfo.getList());
            resultMap.put("total",pageInfo.getTotal());
        }else{
            resultMap.put("rows",list);
            resultMap.put("total",list.size());
        }
        return AjaxObject.ok(resultMap);
    }

    public AjaxObject getResultViewObject(List list, String pageNum,List listView,String pageSizeStr){
        Map<String,Object> resultMap = new HashMap<>(16);
        if (StringUtils.isNotEmpty(pageNum)) {
            int currentPage = Integer.parseInt(pageNum);
            int pageSize = Integer.parseInt(pageSizeStr);
            resultMap.put("currentPage",currentPage);
            PageInfo pageInfo = new PageInfo(list);
            if(pageInfo.getTotal()%pageSize==0){
                int pageCount = (int)pageInfo.getTotal()/pageSize;
                resultMap.put("pageCount",pageCount);
            }else{
                int pageCount = (int)pageInfo.getTotal()/pageSize + 1;
                resultMap.put("pageCount",pageCount);
            }
            resultMap.put("rows",listView);
            resultMap.put("total",pageInfo.getTotal());
        }else{
            resultMap.put("rows",listView);
            resultMap.put("total",list.size());
        }
        return AjaxObject.ok(resultMap);
    }

    /**
     * 返回单格对象的结果
     * @Object object
     * @return
     */
    public AjaxObject getResultObjectAlone(Object object){
        Map<String,Object> resultMap = new HashMap<>(16);
        resultMap.put("info",object);
        return AjaxObject.ok(resultMap);
    }

    public AjaxObject getResultObject(List list, String pageNum,List dictList){
        Map<String,Object> resultMap = new HashMap<>(16);
        if (StringUtils.isNotEmpty(pageNum)) {
            PageInfo pageInfo = new PageInfo(list);
            resultMap.put("rows",pageInfo.getList());
            resultMap.put("total",pageInfo.getTotal());
            resultMap.put("dictList",dictList);
        }else{
            resultMap.put("rows",list);
            resultMap.put("total",list.size());
            resultMap.put("dictList",dictList);
        }
        return AjaxObject.ok(resultMap);
    }

    public StringBuffer uploadMultiFile(MultipartFile[] pictures, String fileLocalPath, String fileUrlPath) {
        StringBuffer pictureStringBuffer = new StringBuffer();
        if(pictures!=null&&pictures.length>0){
            for(int i=0;i<pictures.length;i++){
                String url = UploadFileUtils.uplpadFile(pictures[i],fileLocalPath,fileUrlPath);
                if(i>0){
                    pictureStringBuffer.append(",");
                }

                pictureStringBuffer.append(url);
            }
        }
        return pictureStringBuffer;
    }



    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}

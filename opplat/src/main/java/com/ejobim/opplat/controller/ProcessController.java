package com.ejobim.opplat.controller;


import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.domain.TbProcessApply;
import com.ejobim.opplat.domain.vo.CheckVo;
import com.ejobim.opplat.domain.vo.TbProcessApplyVo;
import com.ejobim.opplat.service.ProcessService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author wujianlong
 * @Description: 工艺调整
 * @date 2019/1/15 18:16
 */
@Api(tags = "工艺调整管理")
@RestController
@RequestMapping("pro")
public   class ProcessController  extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProcessService processService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 保存
     * @param request
     * @return
     */
    @PostMapping("/save")
    public AjaxObject addTbProcessApply(HttpServletRequest request, TbProcessApply tbProcessApply){
            logger.info("新增参数TbProcessApply={}", JSON.toJSONString(tbProcessApply));
            tbProcessApply.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int flag = processService.saveTbProcessApply(tbProcessApply);
            if(flag>0){
                return AjaxObject.ok("新增成功");
            }else {
                return AjaxObject.ok("新增失败");
            }
    }

    /**
     * 提交
     * @param request,checkVo
     * @return
     */
    @PostMapping("/submit")
    public AjaxObject goSubmit(HttpServletRequest request,TbProcessApply tbProcessApply) {
        try {
            tbProcessApply.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.goSubmit(tbProcessApply);
            return AjaxObject.ok("提交成功！");
        } catch (Exception e) {
            logger.error("提交失败", e);
            return AjaxObject.error("提交失败，请联系网站分类要素管理员！");
        }
    }

    /**
     * 调整申请列表展示
     * @param request ,param
     * @return
     */
    @RequestMapping(value = "/getTbProcessApplyList",method = RequestMethod.GET)
    @ResponseBody
    public AjaxObject getTbProcessApplyList(HttpServletRequest request,TbProcessApply tbProcessApply){
        logger.info("查询调整申请列表展示TbProcessApply={}", tbProcessApply);
        List<TbProcessApplyVo> tbProcessApplyList =new ArrayList<>();
        if(tbProcessApply.getStatus()==0){
            tbProcessApply.setApplyUser(getUser(request,stringRedisTemplate).getCode());
        }else {
            tbProcessApply.setChooseUser(getUser(request,stringRedisTemplate).getCode());
        }
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbProcessApplyVo> list = tbProcessApplyList = processService.getTbProcessApplyList(tbProcessApply);
        return  super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * 分析处理通过或者驳回
     * @param request,checkVo
     * @return
     */
    @PostMapping("/passOrReject")
    public AjaxObject passOrReject(HttpServletRequest request,CheckVo checkVo) {
        logger.info("调整分析处理通过或者驳回CheckVo{}", checkVo);
        try {
            checkVo.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.passOrReject(checkVo);
            return AjaxObject.ok("成功！");
        } catch (Exception e) {
            logger.error("失败", e);
            return AjaxObject.error("失败，请联系网站分类要素管理员！");
        }
    }

    /**
     * pc点击详情查看 .app端使用
     * @param request,processNo
     * @return
     */
    @GetMapping("/getTbProcessApplyExtendInfo")
    public AjaxObject getTbProcessApplyInfo(HttpServletRequest request,String processNo) {
        try {
            Map  map= processService.getTbProcessApplyExtendInfo(processNo);
            return AjaxObject.ok(map);
        } catch (Exception e) {
            logger.error("提交失败", e);
            return AjaxObject.error("提交失败，请联系网站分类要素管理员！");
        }
    }

    /**
     * 审核通过和驳回
     * @param request,checkVo
     * @return
     */
    @PostMapping("/check")
    public AjaxObject goCheck(HttpServletRequest request,CheckVo checkVo) {
        logger.info("审核通过和驳回CheckVo{}", checkVo);
        try {
            checkVo.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.goCheck(checkVo);
            return AjaxObject.ok("分析成功！");
        } catch (Exception e) {
            logger.error("分析失败", e);
            return AjaxObject.error("分析失败，请联系网站分类要素管理员！");
        }
    }


    /**
     * 去下发
     * @param request,checkVo
     * @return
     */
    @PostMapping("/delivery")
    public AjaxObject goDelivery(HttpServletRequest request,CheckVo checkVo) {
        try {
            checkVo.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.goDelivery(checkVo);
            return AjaxObject.ok("分析成功！");
        } catch (Exception e) {
            logger.error("分析失败", e);
            return AjaxObject.error("分析失败，请联系网站分类要素管理员！");
        }
    }

    /**
     * APP查询执行列表
     * @param request,condition
     * @return
     */
    @GetMapping("/getDeliveryList")
    public AjaxObject getDeliveryList(HttpServletRequest request, TbProcessApply tbProcessApply) {
        logger.info("查询APP查询执行列表TbProcessApply={}", tbProcessApply);
        tbProcessApply.setChooseUser(getUser(request,stringRedisTemplate).getCode());
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        List<TbProcessApply> list = processService.getDeliveryList(tbProcessApply);
        return  super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * app 执行 确认提交
     * @param request,checkVo
     * @return
     */
    @PostMapping("/appConfirmSubmit")
    public AjaxObject appConfirmSubmit(HttpServletRequest request,CheckVo checkVo) {
        logger.info("app 执行 确认提交CheckVo={}", JSON.toJSONString(checkVo));
        logger.info("app登录用户名称信息", getUser(request,stringRedisTemplate).getName());
        try {
            checkVo.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.appConfirmSubmit(checkVo);
            return AjaxObject.ok("确认提交成功！");
        } catch (Exception e) {
            logger.error("确认提交失败", e);
            return AjaxObject.error("确认提交失败，请联系网站分类要素管理员！");
        }
    }
    /**
     * app效果确认提交或者驳回
     * @param request,checkVo
     * @return
     */
    @PostMapping("/appEffectConfirmSubmit")
    public AjaxObject appEffectConfirmSubmit(HttpServletRequest request,CheckVo checkVo) {
        logger.info("app效果确认提交或者驳回CheckVo={}", JSON.toJSONString(checkVo));
        logger.info("app登录用户名称信息", getUser(request,stringRedisTemplate).getName());
        try {
            checkVo.setApplyUser(getUser(request,stringRedisTemplate).getCode());
            int i = processService.appEffectConfirmSubmit(checkVo);
            return AjaxObject.ok("确认提交成功！");
        } catch (Exception e) {
            logger.error("确认提交失败", e);
            return AjaxObject.error();
        }
    }

    /**
     * pc调整申请所有列表展示
     * @param request ,param
     * @return
     */
    @RequestMapping(value = "/getTbProcessApplyALLList",method = RequestMethod.GET)
    public AjaxObject getTbProcessApplyALLList(HttpServletRequest request,TbProcessApply tbProcessApply){
        logger.info("查询pc调整申请所有列表展示TbProcessApply={}", tbProcessApply);
        super.setPageInfo(request.getParameter("page"),request.getParameter("rows"));
        if(tbProcessApply.getStatus()!=null) {
            //搜索条件查询所有状态
            if (tbProcessApply.getStatus() == -1) {
                tbProcessApply.setStatus(null);
            }
        }
        List<TbProcessApply> list = processService.getTbProcessApplyALLList(tbProcessApply);
        return  super.getResultObject(list,request.getParameter("page"));
    }

    /**
     * 删除
     * @param request,checkVo
     * @return
     */
    @PostMapping("/deleteTbProcessApply")
    public AjaxObject delete(HttpServletRequest request,TbProcessApply tbProcessApply) {
        try {
            int i = processService.deleteTbProcessApply(tbProcessApply);
            return AjaxObject.ok("删除成功！");
        } catch (Exception e) {
            logger.error("删除失败", e);
            return AjaxObject.error("删除失败，请联系网站分类要素管理员！");
        }
    }

}

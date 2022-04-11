package com.ejobim.opplat.controller;

import com.ejobim.opplat.domain.TbAppInfo;
import com.ejobim.opplat.exception.BusinessException;
import com.ejobim.opplat.service.AppService;
import com.ejobim.opplat.util.AjaxObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author wujianlong
 * @Description: app相关
 * @date 2019/1/15 18:16
 */
@Api(tags = {"app相关"})
@RestController
@RequestMapping("app")
public class AppController extends  BaseController {
    @Autowired
    AppService appService;
    
    @ApiOperation(value = "获取app版本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录用户token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/getUpdateInfo")
    public AjaxObject getUpdateInfo(HttpServletRequest request, String version){
        Map<String,Object> map = new HashMap<>(16);
        int appChannel = StringUtils.isEmpty(request.getParameter("appChannel"))?0:Integer.valueOf(request.getParameter("appChannel"));
        TbAppInfo appInfo = null;
        if(appInfo!=null){
            map.put("version",appInfo);
        }else{
           throw new BusinessException(200,"系统异常");
        }
        return AjaxObject.ok(map);
    }

    @GetMapping("/test")
    public AjaxObject getUpdateInfo(HttpServletRequest request){
        appService.testLock();
        return AjaxObject.ok("ok");
    }

    public static void main(String[] args) {
        CompletableFuture.allOf(
                CompletableFuture.completedFuture("hello completedFuture1"),
                CompletableFuture.completedFuture("hello completedFuture2"),
                CompletableFuture.completedFuture("hello completedFuture3"),
                CompletableFuture.completedFuture("hello completedFuture4")
        ).join();

        //runAsync方法不支持返回值。
        //supplyAsync可以支持返回值
        //whenComplete 和 whenCompleteAsync 的区别：
        //whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
        //whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
        //thenApply 方法 当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化。
        CompletableFuture.supplyAsync(() -> {
            System.out.println("runAsync......");
//            int i = 1 / 0;
            return "hello supplyAsync";
        }).thenApply(t -> {
            System.out.println(t);
            return "hello thenApply1";
        }).thenApply(t -> {
            System.out.println(t);
            return "hello thenApply2";
        }).thenAccept(t -> {
            System.out.println(t);
        }).whenComplete((t, u) -> {
            System.out.println("t: " + t);
            System.out.println(u);
        }).handleAsync((t, u) -> {
            System.out.println("t" + t);
            System.out.println(u);
            return "hello handler";
        }).thenCombine(CompletableFuture.completedFuture("hello completedFuture"), (t, u) -> {
            System.out.println(t);
            System.out.println(u);
            return "hello thenCombine";
        });

    }

}

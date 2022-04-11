package com.ejobim.opplat.common.interceptors;


import com.alibaba.fastjson.JSON;
import com.ejobim.opplat.common.annotation.AutoIdempotent;
import com.ejobim.opplat.config.RedisService;
import com.ejobim.opplat.service.TokenService;
import com.ejobim.opplat.util.AjaxObject;
import com.ejobim.opplat.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by wujianlong on 2019/01/25.
 */
//@Component
public class AuthenticatInterceptor extends HandlerInterceptorAdapter {

	private final static Logger logger = LoggerFactory.getLogger(AuthenticatInterceptor.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private RedisService redisService;


	@Autowired
	private JwtUtil jwt;

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
                if(request.getRequestURI().equalsIgnoreCase("/doc.html")) {
                    return true;
                }
		boolean flag = true;
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String token =request.getHeader("token");

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		//被ApiIdempotment标记的扫描
		AutoIdempotent methodAnnotation = method.getAnnotation(AutoIdempotent.class);
		if (methodAnnotation != null) {
			try {
				return tokenService.checkToken(request);// 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
			}catch (Exception ex){
				AjaxObject error = AjaxObject.error(101, ex.getMessage());
				writeReturnJson(response, JSON.toJSONString(error));
				throw ex;
			}
		}
	/*	if("OPTIONS".equals(request.getMethod())){

		}else{
			//logger.info("token:" + token);
			if(StringUtils.isEmpty(token)||"null".equals(token)){
                responseError(response);
                flag= false;
			}else{
                String str = stringRedisTemplate.opsForValue().get(token);
                if(StringUtils.isEmpty(str)){
                    responseError(response);
					flag=false;
                }

            }
		}*/
		return flag;
	}

	private void responseError(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            String error = "token error";
            writer.print(error);
        } catch (IOException e) {
			logger.error("response error",e);
        } finally {
            if (writer != null){
				writer.close();
			}
        }
	}
	/**
	 * 返回的json值
	 * @param response
	 * @param json
	 * @throws Exception
	 */
	private void writeReturnJson(HttpServletResponse response, String json) throws Exception{
		PrintWriter writer = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			writer = response.getWriter();
			writer.print(json);

		} catch (IOException e) {
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}


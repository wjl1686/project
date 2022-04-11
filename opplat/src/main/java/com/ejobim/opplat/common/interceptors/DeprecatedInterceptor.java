package com.ejobim.opplat.common.interceptors;
import com.ejobim.opplat.domain.enums.ErrorMsg;
import com.ejobim.opplat.exception.RestException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wujianlong on 2019/01/25.
 */
public class DeprecatedInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Deprecated deprecated =  ((HandlerMethod) handler).getMethodAnnotation(Deprecated.class);
        if(deprecated!=null){
            throw new RestException(ErrorMsg.TokenIsExpired);
        }

        return super.preHandle(request, response, handler);
    }
}
package com.cooperation.onlineshop.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:授权检测的创建继承HandlerInterceptorAdapter 方法
 * Author: zyg
 * Date: 2020-03-27 13:45
 */
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    BaseAuthority baseAuthority;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //未开启权限检测 跳过
        String url = request.getRequestURI();//这里打端点，页面访问swagger页面看看请求的什么路径
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {

    }


}

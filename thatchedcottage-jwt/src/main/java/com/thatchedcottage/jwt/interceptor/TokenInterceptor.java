package com.thatchedcottage.jwt.interceptor;

import com.thatchedcottage.jwt.utils.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: thatchedcottage
 * @description: 拦截器
 * @author:
 * @create: 2023-10-08 14:28
 **/
/*注解自动运行*/
@Configuration
/*Handler Interceptor  处理程序拦截器*/
public class TokenInterceptor implements HandlerInterceptor {
    // 在请求处理方法被调用之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (!JwtUtil.checkToken(token)){
            /*验证失败*/
            return false;
        }
        return true;
    }
}

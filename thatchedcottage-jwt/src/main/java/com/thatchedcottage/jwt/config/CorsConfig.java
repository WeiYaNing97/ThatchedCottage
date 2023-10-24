package com.thatchedcottage.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: thatchedcottage
 * @description: 跨域问题
 * @author:
 * @create: 2023-10-07 15:47
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer{
        /**
        *addMapping("/**"): 配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
        *allowedorigins"*"): 允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如"http://www.yx.com"，只有该域名可以访问我们的跨域资源
        *allowedHeaders("*"): 允许所有的请求header访问，可以自定义设置任意请求头信息
        *allowedMethods(): 允许所有的请求方法访问该跨域资源服务器，如GET、POST、DELETE、PUT、OPTIONS、HEAD等
        *maxAge(3600): 配置客户端可以缓存pre-flght请求的响应的时间(秒) 。默认设置为1800秒 (30分钟)
        */
        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**")
                    .allowedOrigins(".")
                    .allowedHeaders("*")
                    .allowedMethods("GET","POST","DELETE","PUT","OPTIONS","HEAD")
                    .maxAge(3600);
        }
}
